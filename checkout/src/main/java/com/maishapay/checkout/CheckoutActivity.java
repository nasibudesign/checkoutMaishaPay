package com.maishapay.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CheckoutActivity extends AppCompatActivity {


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

        String html = "<html> <body><center><h1>Chargement</h1> </br>" +
                " <form action=\"https://maishapay.shop/marchand/checkout/\" method=\"post\">\n" +
                "\n" +
                "    <input type='hidden' name='apiOptions' value='" + apiOptions + "'>\n</br>" +
                "    <input type='hidden' name='apikey' value='" + apikey + "'>\n</br>" +
                "    <input type='hidden' name='gateway_mode' value='" + gateway_mode + "'>\n</br>" +
                "    <input type='hidden' name='montant' value='" + montant + "'>\n</br>" +
                "    <input type='hidden' name='monnaie' value='" + monnaie + "'>\n</br>" +
                "    <input type='hidden' name='payment_description' value='" + payment_description + "'>\n</br>" +
                "    <input type='hidden' name='logo_url' value='" + logo_url + "'>\n</br>" +
                "    <input type='hidden' name='page_callback_success' value='" + page_callback_success + "'>\n</br>" +
                "    <input type='hidden' name='page_callback_failure' value='" + page_callback_failure + "'>\n</br>" +
                "    <input type='hidden' name='page_callback_cancel' value='" + page_callback_cancel + "'>\n</br></br>" +
                "    <p>Si dans 30 sec rien ne se passe cliquer sur continuer</p></br>" +
                "    <input type='submit' name='submit' value='Continuer'>\n" +
                "</form></body></center>" +
                "<script>\n" +
                "  document.getElementsByName('submit')[0].click();\n" +
                "</script>" +
                "</html>";
        String mime = "text/html";
        String encoding = "utf-8";
        mWebView.loadData(html, mime, encoding);


        Intent intentResult = new Intent();
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains(page_callback_cancel)) {
                    intentResult.putExtra("cancel", MaishaPay.checkoutCancel);
                    setResult(MaishaPay.checkoutCancel, intentResult);
                    finish();
                    return false;
                } else if (url.contains(page_callback_success)) {
                    intentResult.putExtra("sucess", MaishaPay.checkoutSuccess);
                    setResult(MaishaPay.checkoutSuccess, intentResult);
                    finish();
                    return false;
                } else if (url.contains(page_callback_failure)) {
                    intentResult.putExtra("failure", MaishaPay.checkoutSuccess);
                    setResult(MaishaPay.checkoutFailure, intentResult);
                    finish();
                    return false;
                } else {
                    Log.e("MaishaPay PageCallback", "- url : " + url + " is an unrecognized page_callback");
                    return true;
                }
            }
        });

    }
}