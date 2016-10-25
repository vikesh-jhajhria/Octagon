package com.octagonproject.octagon;

import android.os.Bundle;
import android.view.View;

import com.octagonproject.octagon.BaseActivity;
import com.octagonproject.octagon.R;

public class SignupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViewById(R.id.img_menu).setVisibility(View.GONE);
    }
}
