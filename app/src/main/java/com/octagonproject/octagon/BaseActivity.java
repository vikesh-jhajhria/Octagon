package com.octagonproject.octagon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Vikesh on 10/21/2016.
 */

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public String TAG = "OCTAGON";
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.img_back) {
            onBackPressed();
        }
    }
}
