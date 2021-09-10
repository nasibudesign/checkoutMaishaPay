package com.maishapay.checkout;

import android.app.Activity;
import android.content.Intent;

public class MaishaPay {

    private static final int code = 230021282;
    private static final int codeCheckoutSuccess = 1;
    private static final int codeCheckoutFailure = 0;
    private static final int codeCheckoutCancel = -1;
    public static final int maishaPayCheckoutActivityRequestCode = code;
    public static final int checkoutSuccess = codeCheckoutSuccess;
    public static final int checkoutFailure = codeCheckoutFailure;
    public static final int checkoutCancel = codeCheckoutCancel;
    private static final String page_callback_success = "https://www.maishapay.shop/marchand/pay/suucess.php";
    private static final String page_callback_failure = "https://www.maishapay.shop/marchand/pay/echec.php";
    private static final String page_callback_cancel = "https://maishapay.net";
    public static final String USD = "USD";
    public static final String CDF = "CDF";

    public static void checkout(Activity parentActivity,
                                String apiOptions,
                                String apikey,
                                String gateway_mode,
                                String montant,
                                String monnaie,
                                String payment_description,
                                String logo_url) {
        Intent intent = new Intent(parentActivity, CheckoutActivity.class);
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
        parentActivity.startActivityForResult(intent, maishaPayCheckoutActivityRequestCode);
    }
}