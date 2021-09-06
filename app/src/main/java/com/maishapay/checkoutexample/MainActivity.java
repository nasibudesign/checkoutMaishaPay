package com.maishapay.checkoutexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.maishapay.checkout.MaishaPay;

public class MainActivity extends AppCompatActivity {

    EditText apiKey, gateWayMode, montant, money, logo_url;
    Button payButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiKey = findViewById(R.id.apiKey);
        gateWayMode = findViewById(R.id.gateway_mode);
        montant = findViewById(R.id.montant);
        money = findViewById(R.id.monnaie);
        logo_url = findViewById(R.id.logo_url);

        payButton = findViewById(R.id.payButton);

        payButton.setOnClickListener(v -> {
            String amount = montant.getText().toString();
            if (!amount.isEmpty()) {
                Toast.makeText(this, "chargemtent", Toast.LENGTH_SHORT).show();
                MaishaPay.checkout(this,
                        "Const.yourApiOptions",
                        "Const.yourApiKey",
                        "Const.yourGateway_mode",
                        amount,
                        MaishaPay.USD,
                        "Description de payement",
                        "Const.yourLogo_url",
                        "Const.page_callback_success",
                        "Const.page_callback_failure",
                        "Const.page_callback_cancel"
                );
            } else {
                Toast.makeText(this, "paramettre manquant", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("resultCode", resultCode + "");

        if (requestCode == MaishaPay.maishaPayCheckoutActivityRequestCode) {
            if (resultCode == MaishaPay.checkoutSuccess) {
                Log.i("succes", MaishaPay.checkoutSuccess + "");
            } else if (resultCode == MaishaPay.checkoutCancel) {
                Log.i("cancel", MaishaPay.checkoutCancel + "");
            } else if (resultCode == MaishaPay.checkoutFailure) {
                Log.i("failure", MaishaPay.checkoutFailure + "");
            } else {
                Log.e("unknown", "unknown result");
            }
        } else {
            Log.e("unknown request code", "unknown or other request code");
        }

    }
}