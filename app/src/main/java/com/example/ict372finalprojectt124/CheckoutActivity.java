package com.example.ict372finalprojectt124;




import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class CheckoutActivity extends AppCompatActivity {
    private EditText fullName, address, phone, email;
    private Button changeShippingInfoButton, submitOrderButton;
    private RadioGroup deliveryOptions;
    private TextView orderPrice, deliveryFee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        // Initialize UI components
        fullName = findViewById(R.id.fullName);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        changeShippingInfoButton = findViewById(R.id.changeShippingInfoButton);
        submitOrderButton = findViewById(R.id.submitOrderButton);
        deliveryOptions = findViewById(R.id.deliveryOptions);
        orderPrice = findViewById(R.id.orderPrice);
        deliveryFee = findViewById(R.id.deliveryFee);


        // Set sample order price and delivery fee
        double sampleOrderPrice = 50.00;
        double sampleDeliveryFee = 5.00;
        orderPrice.setText("Order Price: $" + String.format("%.2f", sampleOrderPrice));
        deliveryFee.setText("Delivery Fee: $" + String.format("%.2f", sampleDeliveryFee));


        // Handle change shipping info button click
        changeShippingInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle change shipping info action
                Toast.makeText(CheckoutActivity.this, "Change Shipping Info", Toast.LENGTH_SHORT).show();
            }
        });


        // Handle submit order button click
        submitOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmitOrder(sampleOrderPrice, sampleDeliveryFee);
            }
        });
    }


    private void handleSubmitOrder(double orderPrice, double deliveryFee) {
        // Get user input
        String name = fullName.getText().toString();
        String addr = address.getText().toString();
        String phoneNum = phone.getText().toString();
        String emailAddr = email.getText().toString();


        // Check if all fields are filled
        if (name.isEmpty() || addr.isEmpty() || phoneNum.isEmpty() || emailAddr.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }


        // Get selected delivery option
        int selectedDeliveryId = deliveryOptions.getCheckedRadioButtonId();
        if (selectedDeliveryId == -1) {
            Toast.makeText(this, "Please select a delivery option", Toast.LENGTH_SHORT).show();
            return;
        }


        RadioButton selectedDelivery = findViewById(selectedDeliveryId);





        // Calculate total price
        double totalPrice = orderPrice + deliveryFee;


        // Display order summary
        String summary = "Name: " + name + "\n" +
                "Address: " + addr + "\n" +
                "Phone: " + phoneNum + "\n" +
                "Email: " + emailAddr + "\n" +
                "Payment Method: MasterCard\n" +
                "Delivery Method: " + selectedDelivery.getText() + "\n" +
                "Total Price: $" + String.format("%.2f", totalPrice);


        Toast.makeText(this, summary, Toast.LENGTH_LONG).show();
    }
}
