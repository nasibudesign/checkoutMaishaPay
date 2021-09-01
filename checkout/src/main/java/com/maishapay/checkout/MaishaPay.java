package com.maishapay.checkout;

import android.content.Context;
import android.content.Intent;

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

        Intent intent = new Intent(context, CheckoutActivity.class);
        intent.putExtra("apiOptions", apiOptions);
        intent.putExtra("apikey", apikey);
        intent.putExtra("gateway_mode", gateway_mode);
        intent.putExtra("montant", montant);
        intent.putExtra("monnaie", monnaie);
        intent.putExtra("payment_description", payment_description);
        intent.putExtra("logo_url", logo_url);
        intent.putExtra("page_callback_success", page_callback_success);
        intent.putExtra("page_callback_failure", page_callback_failure);
        intent.putExtra("page_callback_cancel", page_callback_cancel);
        context.startActivity(intent);
    }
}