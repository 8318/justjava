package com.example.android.justjava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    /**
     * This app displays an order form to order coffee.
     */

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is  clicked.
     */
    public void increment(View view) {

        if (quantity == 100) {
//            Context context = getApplicationContext();
//            CharSequence text = "Orders exceed maximum i.e 100 !";
//            int duration = Toast.LENGTH_SHORT;
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
            Toast.makeText(this.getApplicationContext(), "Orders exceed maximum i.e 100 !",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is   clicked.
     */
    public void decrement(View view) {
        if (quantity == 0){
            Toast.makeText(this.getApplicationContext(), "You cannot make an order of less than 1 !",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);

    }

    /**
     * This method is called when the order button is  clicked.
     */
    public void submitOrder(View view) {
        displayQuantity(quantity);
        displayPrice(quantity * 5);
//        String priceMessage = "You ordered " + quantity + " cups of coffee that cost $ " +(quantity * 5)+ ".Thank you for the purchase ;) and come again.";
//        displayMessage(priceMessage);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantity_value = findViewById(R.id.quantity_value);
        quantity_value.setText("" + number);
    }

    /**
     * This method displays the given price value on the screen.
     */
    private void displayPrice(int number) {
        TextView price_value = findViewById(R.id.price_value);
        price_value.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.price_value);
        priceTextView.setText(message);
    }

}
