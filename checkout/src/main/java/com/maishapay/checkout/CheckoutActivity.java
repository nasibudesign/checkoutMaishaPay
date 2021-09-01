package com.maishapay.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class CheckoutActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();
        String apiOptions = intent.getExtras().getString("apiOptions");
        String apikey = intent.getExtras().getString("apikey");
        String gateway_mode = intent.getExtras().getString("gateway_mode");
        String montant = intent.getExtras().getString("montant");
        String monnaie = intent.getExtras().getString("monnaie");
        String payment_description = intent.getExtras().getString("payment_description");
        String logo_url = intent.getExtras().getString("logo_url");
        String page_callback_success = intent.getExtras().getString("page_callback_success");
        String page_callback_failure = intent.getExtras().getString("page_callback_failure");
        String page_callback_cancel = intent.getExtras().getString("page_callback_cancel");

        WebView mWebView = findViewById(R.id.checoutWebView);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);

        String html = "<html> <body><h1>Chargement</h1> </br>" +
                " <form action=\"https://maishapay.shop/marchand/checkout/\" method=\"post\">\n" +
                "\n" +
                "    <input type='text' name='apiOptions' value='" + apiOptions + "'>\n</br>" +
                "    <input type='text' name='apikey' value='" + apikey + "'>\n</br>" +
                "    <input type='text' name='gateway_mode' value='" + gateway_mode + "'>\n</br>" +
                "    <input type='text' name='montant' value='" + montant + "'>\n</br>" +
                "    <input type='text' name='monnaie' value='" + monnaie + "'>\n</br>" +
                "    <input type='text' name='payment_description' value='" + payment_description + "'>\n</br>" +
                "    <input type='text' name='logo_url' value='" + logo_url + "'>\n</br>" +
                "    <input type='text' name='page_callback_success' value='" + page_callback_success + "'>\n</br>" +
                "    <input type='text' name='page_callback_failure' value='" + page_callback_failure + "'>\n</br>" +
                "    <input type='text' name='page_callback_cancel' value='" + page_callback_cancel + "'>\n</br></br>" +
                "    <input type='submit' name='submit' value='Paiment ici'>\n" +
                "</form></body>" +
                "<script>\n" +
                "  document.getElementsByName('submit')[0].click();\n" +
                "</script>" +
                "</html>";
        String mime = "text/html";
        String encoding = "utf-8";
        mWebView.loadData(html, mime, encoding);

    }
}