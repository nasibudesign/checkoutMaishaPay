package com.maishapay.checkout;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MaishaPay {
    public static void checkout(Context context,
                                String apiOptions,
                                String apikey,
                                String gateway_mode,
                                String montant,
                                String monnaie,
                                String payment_description,
                                String logo_url,
                                String page_callback_success,
                                String page_callback_failure,
                                String page_callback_cancel) {
        String postUrl = "https://maishapay.shop/marchand/checkout/";

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                postUrl,
                response -> {
                    Log.i("response : ",response);
                    Intent intent = new Intent(context,CheckoutActivity.class);
                    intent.putExtra("htmlString",response);
                    context.startActivity(intent);
                },
                error -> Log.e("Volley erro:", error + "")
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> postData = new HashMap<>();
                postData.put("apiOptions", apiOptions);
                postData.put("apikey", apikey);
                postData.put("gateway_mode", gateway_mode);
                postData.put("montant", montant);
                postData.put("monnaie", monnaie);
                postData.put("payment_description", payment_description);
                postData.put("logo_url", logo_url);
                postData.put("page_callback_success", page_callback_success);
                postData.put("page_callback_failure", page_callback_failure);
                postData.put("page_callback_cancel", page_callback_cancel);
                return postData;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}