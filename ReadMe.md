Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency
    check for newer versions on git repo.

	dependencies {
	        implementation 'com.github.nasibudesign:checkoutMaishaPay:0.06'
	}

    

Step 3. call MaishaPay checkout to your 
     
     MaishaPay.checkout(this,
                        yourApiOptions,
                        yourApiKey,
                        yourGateway_mode,
                        _amount,
                        "USD",
                        "test de payement",
                        Const.logo_url,
                        "https://maishapay.net",
                        "https://google.com",
                        "https://yahoo.com"
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