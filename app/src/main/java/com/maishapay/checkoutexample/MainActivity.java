package com.maishapay.checkoutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText apiKey, gateWayMode, amount, money, logo_url;
    Button payButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiKey = findViewById(R.id.apiKey);
        gateWayMode = findViewById(R.id.gateway_mode);
        amount = findViewById(R.id.montant);
        money = findViewById(R.id.monnaie);
        logo_url = findViewById(R.id.logo_url);
        String _amount = amount.getText().toString();


        payButton = findViewById(R.id.payButton);

        payButton.setOnClickListener(v -> {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
            //checkout with repository
//            Checkout.maishaPay(this,
//                    "",
//                    "",
//                    "1",
//                    _amount,
//                    "USD",
//                    "",
//                    "",
//                    "",
//                    "",
//                    ""
//            );
        });
    }
}