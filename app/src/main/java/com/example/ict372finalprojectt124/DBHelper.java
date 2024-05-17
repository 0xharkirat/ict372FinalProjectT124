package com.example.ict372finalprojectt124;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Objects;

public class DBHelper extends SQLiteOpenHelper {
    public static final String USERS_TABLE = "USERS_TABLE";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";

    public static final int ERROR_NONE = 0;
    public static final int ERROR_EMAIL_EXISTS = 1;
    public static final int ERROR_OTHER = 2;


    public DBHelper(@Nullable Context context) {
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + USERS_TABLE + " (\n" +
                "    " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    " + COLUMN_NAME + " TEXT NOT NULL,\n" +
                "    " + COLUMN_EMAIL + " TEXT UNIQUE NOT NULL,\n" +
                "    " + COLUMN_PASSWORD + " TEXT NOT NULL\n" +
                ");\n";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int addOne(UserModel userModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, userModel.getName());
        cv.put(COLUMN_EMAIL, userModel.getEmail());
        cv.put(COLUMN_PASSWORD, userModel.getPassword());

        try {
            long insert = db.insertOrThrow(USERS_TABLE, null, cv);
            return ERROR_NONE; // Success
        } catch (SQLException e) {
            if (e instanceof SQLiteConstraintException && Objects.requireNonNull(e.getMessage()).contains("UNIQUE constraint failed")) {
                return ERROR_EMAIL_EXISTS; // Email already exists
            } else {
                Log.e("DBHelper", "Error inserting user: " + e.getMessage());
                return ERROR_OTHER; // Other error
            }
        }
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + USERS_TABLE + " WHERE " + COLUMN_EMAIL + "=? AND " + COLUMN_PASSWORD + "=?";

        // Use parameterized query to prevent SQL injection
        Cursor cursor = db.rawQuery(query, new String[]{email, password});

        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }
}
