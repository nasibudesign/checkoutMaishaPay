package com.maishapay.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

class CheckoutActivity extends AppCompatActivity {

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

        String html = "<html> <body> <form action=\"https://maishapay.shop/marchand/checkout/\" method=\"post\">\n" +
                "\n" +
                "    <input type='hidden' name='apiOptions' value='" + apiOptions + "'>\n" +
                "    <input type='hidden' name='apikey' value='" + apikey + "'>\n" +
                "    <input type='hidden' name='gateway_mode' value='" + gateway_mode + "'>\n" +
                "    <input type='hidden' name='montant' value='" + montant + "'>\n" +
                "    <input type='hidden' name='monnaie' value='" + monnaie + "'>\n" +
                "    <input type='hidden' name='payment_description' value='" + payment_description + "'>\n" +
                "    <input type='hidden' name='logo_url' value='" + logo_url + "'>\n" +
                "    <input type='hidden' name='page_callback_success' value='" + page_callback_success + "'>\n" +
                "    <input type='hidden' name='page_callback_failure' value='" + page_callback_failure + "'>\n" +
                "    <input type='hidden' name='page_callback_cancel' value='" + page_callback_cancel + "'>\n" +
                "    <input type='hidden' name='submit' value='Paiment ici'>\n" +
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