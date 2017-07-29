package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.URI;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    int costPer = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
//        String message = "Total: $";
        int total = calculatePrice(quantity, costPer);
//        displayPrice(createOrderSummary(total));

        String[] addresses = {"wolfyman06@gmail.com"};
        String subject = "new order!";
        String message = createOrderSummary(total);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

//        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void incrementQuantity(View view){
        quantity++;
        displayQuantity(quantity);
    }

    public void decrementQuantity(View view){
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void displayQuantity(int number){
        TextView quantityTextview = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextview.setText(""+number);
    }

    private void displayPrice(String priceMessage){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(priceMessage);
    }

    private int calculatePrice(){
        return quantity * 5;
    }

    private int calculatePrice(int quantity){
        int price = quantity * 5;

        return price;
    }

    private int calculatePrice(int quantity, int pricePerCup){
        int price = quantity * pricePerCup;

        return price;
    }

    public String createOrderSummary(int priceOfOrder){
        String myString = "Name: Kaptain Kunal\n";
        myString += "Quantity: " + quantity + "\n";
        myString += "Total: $" + priceOfOrder + "\n";
        myString += "Thank You!";
        return myString;
    }
}
