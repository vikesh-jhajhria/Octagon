package com.octagonproject.octagon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.octagonproject.octagon.utils.AppPreferences;
import com.octagonproject.octagon.utils.Config;
import com.octagonproject.octagon.utils.Utils;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startTimer();
        Utils.printKeyHash(this);
    }

    private void startTimer() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AppPreferences preferences = AppPreferences.getAppPreferences(getApplicationContext());
                String userId = preferences.getStringValue(AppPreferences.USER_ID);
                Log.v(TAG, "userId=" + userId);
                if (userId.isEmpty()) {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finishAffinity();
                } else {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finishAffinity();
                }
            }
        }, Config.SPLASH_TIME);
    }
}
