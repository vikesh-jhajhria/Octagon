package com.octagonproject.octagon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReviewsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        findViewById(R.id.go_to_tours).setOnClickListener(this);
        findViewById(R.id.shop).setOnClickListener(this);
        findViewById(R.id.img_back).setOnClickListener(this);
    }
}
