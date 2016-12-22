package com.octagonproject.octagon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PrivacyPolicyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        findViewById(R.id.img_back).setOnClickListener(this);
    }
}
