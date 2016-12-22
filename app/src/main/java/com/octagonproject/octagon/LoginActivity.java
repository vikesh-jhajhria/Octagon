package com.octagonproject.octagon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.octagonproject.octagon.utils.FBLoginClass;

public class LoginActivity extends BaseActivity {

    private FBLoginClass fbLoginClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fbLoginClass = new FBLoginClass();
        fbLoginClass.sdkInitialize(this);
        setContentView(R.layout.activity_login);
        findViewById(R.id.img_back).setOnClickListener(this);
    }
}
