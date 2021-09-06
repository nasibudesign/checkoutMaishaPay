Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency & check for latest versions.

	dependencies {
	        implementation 'com.github.nasibudesign:checkoutMaishaPay:0.06'
	}

   

Step 3. call checkout methode on items to make payement
     
     MaishaPay.checkout(this,
                        "yourApiOptions",
                        "yourApiKey",
                        "yourGateway_mode",
                        "amount",
                        MaishaPay.USD,
                        "Description",
                        "yourLogo_url",
                        "page_callback_success",
                        "page_callback_failure",
                        "page_callback_cancel"
                );

Step 4. on your activity or fragment overide onActivityResult,

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Log.e("requestCode", requestCode + "");
        Log.e("resultCode", resultCode + "");

        if (requestCode == MaishaPay.maishaPayCheckoutActivityRequestCode) {
            if (resultCode == MaishaPay.checkoutSuccess) {
                Log.e("succes", MaishaPay.checkoutSuccess + "");
            } else if (resultCode == MaishaPay.checkoutCancel) {
                Log.e("cancel", MaishaPay.checkoutCancel + "");
            } else if (resultCode == MaishaPay.checkoutFailure) {
                Log.e("failure", MaishaPay.checkoutFailure + "");
            } else {
                Log.e("unknown", "unknown error");
            }
        } else {
            Log.e("unkown request code", "uknown");
        }

    }