package com.maishapay.checkoutexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.maishapay.checkout.MaishaPay;
import com.maishapay.checkoutexample.databinding.ActivityMainBinding;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String moneySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.apiKey.setText(Const.yourApiKey);
        binding.gatewayMode.setText(Const.yourGateway_mode);
        String defaultDescription = "Description de payement";
        binding.description.setText(defaultDescription);
        binding.radioUsd.setText(MaishaPay.USD);
        binding.radioCdf.setText(MaishaPay.CDF);
        setCDFChecked();

        Glide.with(this).load(Const.yourLogo_url)
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(binding.logoUrl);

        binding.payButton.setOnClickListener(v -> {
            String amount = binding.montant.getText().toString().trim();
            String description = binding.description.getText().toString().trim();
            if (!amount.isEmpty()) {
                Toast.makeText(this, "chargemtent", Toast.LENGTH_SHORT).show();
                MaishaPay.checkout(this,
                        Const.yourApiOptions,
                        Const.yourApiKey,
                        Const.yourGateway_mode,
                        amount,
                        moneySelected,
                        description,
                        Const.yourLogo_url
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
                Toast.makeText(this, "checkoutSuccess " + MaishaPay.checkoutSuccess, Toast.LENGTH_SHORT).show();
                Log.i("succes", MaishaPay.checkoutSuccess + "");
            } else if (resultCode == MaishaPay.checkoutCancel) {
                Toast.makeText(this, "checkoutCancel " + MaishaPay.checkoutCancel, Toast.LENGTH_SHORT).show();
                Log.i("cancel", MaishaPay.checkoutCancel + "");
            } else if (resultCode == MaishaPay.checkoutFailure) {
                Toast.makeText(this, "checkoutFailure " + MaishaPay.checkoutFailure, Toast.LENGTH_SHORT).show();
                Log.i("failure", MaishaPay.checkoutFailure + "");
            } else {
                Log.e("unknown", "unknown result");
            }
        } else {
            Log.e("unknown request code", "unknown or other request code");
        }

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_cdf:
                if (checked)
                    moneySelected = MaishaPay.CDF;
                break;
            case R.id.radio_usd:
                if (checked)
                    moneySelected = MaishaPay.USD;
                break;
        }
    }

    private void setCDFChecked() {
        binding.radioCdf.setChecked(true);
        moneySelected = MaishaPay.CDF;
    }
}