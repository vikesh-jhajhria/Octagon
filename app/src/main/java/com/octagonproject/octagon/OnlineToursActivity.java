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
        findViewById(R.id.link_tour_2).setOnClickListener(this);
        findViewById(R.id.link_tour_3).setOnClickListener(this);
        findViewById(R.id.link_tour_4).setOnClickListener(this);
        findViewById(R.id.link_tour_5).setOnClickListener(this);
        findViewById(R.id.link_tour_6).setOnClickListener(this);
        findViewById(R.id.link_tour_7).setOnClickListener(this);
        findViewById(R.id.link_tour_8).setOnClickListener(this);
        findViewById(R.id.link_tour_9).setOnClickListener(this);
        findViewById(R.id.link_tour_10).setOnClickListener(this);
        findViewById(R.id.link_tour_11).setOnClickListener(this);
        findViewById(R.id.link_tour_12).setOnClickListener(this);
        findViewById(R.id.link_tour_13).setOnClickListener(this);
        findViewById(R.id.link_tour_14).setOnClickListener(this);
        findViewById(R.id.link_tour_15).setOnClickListener(this);
        findViewById(R.id.link_tour_16).setOnClickListener(this);
        findViewById(R.id.link_tour_17).setOnClickListener(this);
        findViewById(R.id.link_tour_18).setOnClickListener(this);
        findViewById(R.id.link_tour_19).setOnClickListener(this);
        findViewById(R.id.link_tour_20).setOnClickListener(this);
        findViewById(R.id.link_tour_21).setOnClickListener(this);
        findViewById(R.id.link_tour_22).setOnClickListener(this);
        findViewById(R.id.link_tour_23).setOnClickListener(this);
        findViewById(R.id.link_tour_24).setOnClickListener(this);
        findViewById(R.id.link_tour_25).setOnClickListener(this);
        findViewById(R.id.link_tour_26).setOnClickListener(this);
        findViewById(R.id.link_tour_27).setOnClickListener(this);
        findViewById(R.id.link_tour_28).setOnClickListener(this);
        findViewById(R.id.link_tour_29).setOnClickListener(this);
        findViewById(R.id.link_tour_30).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.free_signup:
                startActivity(new Intent(getApplicationContext(),SignupActivity.class));
                break;
            case R.id.link_tour_1:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",1));
                break;
            case R.id.link_tour_2:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",2));
                break;
            case R.id.link_tour_3:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",3));
                break;
            case R.id.link_tour_4:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",4));
                break;
            case R.id.link_tour_5:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",5));
                break;
            case R.id.link_tour_6:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",6));
                break;
            case R.id.link_tour_7:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",7));
                break;
            case R.id.link_tour_8:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",8));
                break;
            case R.id.link_tour_9:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",9));
                break;
            case R.id.link_tour_10:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",10));
                break;
            case R.id.link_tour_11:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",11));
                break;
            case R.id.link_tour_12:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",12));
                break;
            case R.id.link_tour_13:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",13));
                break;
            case R.id.link_tour_14:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",14));
                break;
            case R.id.link_tour_15:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",15));
                break;
            case R.id.link_tour_16:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",16));
                break;
            case R.id.link_tour_17:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",17));
                break;
            case R.id.link_tour_18:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",18));
                break;
            case R.id.link_tour_19:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",19));
                break;
            case R.id.link_tour_20:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",20));
                break;
            case R.id.link_tour_21:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",21));
                break;
            case R.id.link_tour_22:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",22));
                break;
            case R.id.link_tour_23:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",23));
                break;
            case R.id.link_tour_24:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",24));
                break;
            case R.id.link_tour_25:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",25));
                break;
            case R.id.link_tour_26:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",26));
                break;
            case R.id.link_tour_27:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",27));
                break;
            case R.id.link_tour_28:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",28));
                break;
            case R.id.link_tour_29:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",29));
                break;
            case R.id.link_tour_30:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",30));
                break;
        }
    }
}
