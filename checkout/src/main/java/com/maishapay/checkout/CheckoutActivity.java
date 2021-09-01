package com.maishapay.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class CheckoutActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();
        String stringData = intent.getExtras().getString("htmlString");
        Log.d("stringData on Activity", stringData);

        WebView mWebView = findViewById(R.id.checoutWebView);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        String mime = "text/html";
        String encoding = "utf-8";
        mWebView.loadData(stringData, mime, encoding);


    }
}