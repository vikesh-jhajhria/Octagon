package com.octagonproject.octagon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FilmingPermissionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filing_permission);

        findViewById(R.id.img_back).setOnClickListener(this);
    }
}
