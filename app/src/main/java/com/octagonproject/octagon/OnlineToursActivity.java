package com.octagonproject.octagon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OnlineToursActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_tours);
        findViewById(R.id.img_back).setOnClickListener(this);
        findViewById(R.id.free_signup).setOnClickListener(this);

        findViewById(R.id.link_tour_1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.free_signup:
                startActivity(new Intent(getApplicationContext(),SignupActivity.class));
                break;
            case R.id.link_tour_1:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class));
                break;
        }
    }
}
