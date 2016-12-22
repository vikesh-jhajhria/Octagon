package com.octagonproject.octagon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.octagonproject.octagon.utils.Config;

public class OurStoreActivity extends BaseActivity {

    private YouTubePlayerView youTubeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_store);
        findViewById(R.id.img_back).setOnClickListener(this);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_KEY, this);

        findViewById(R.id.txt_more_book).setOnClickListener(this);
        findViewById(R.id.txt_more_audio).setOnClickListener(this);

        findViewById(R.id.txt_click_store_1).setOnClickListener(this);
        findViewById(R.id.txt_click_store_2).setOnClickListener(this);
        findViewById(R.id.txt_click_store_3).setOnClickListener(this);
        findViewById(R.id.txt_click_store_4).setOnClickListener(this);
        findViewById(R.id.txt_click_store_5).setOnClickListener(this);
        findViewById(R.id.txt_click_store_6).setOnClickListener(this);
        findViewById(R.id.txt_click_store_7).setOnClickListener(this);
        findViewById(R.id.txt_click_store_8).setOnClickListener(this);
        findViewById(R.id.txt_click_store_9).setOnClickListener(this);
        findViewById(R.id.txt_click_store_10).setOnClickListener(this);
        findViewById(R.id.txt_click_store_11).setOnClickListener(this);
        findViewById(R.id.txt_click_store_12).setOnClickListener(this);
        findViewById(R.id.txt_click_store_13).setOnClickListener(this);
        findViewById(R.id.txt_click_store_14).setOnClickListener(this);
        findViewById(R.id.txt_click_store_15).setOnClickListener(this);
        findViewById(R.id.txt_click_store_16).setOnClickListener(this);
        findViewById(R.id.txt_click_store_17).setOnClickListener(this);
        findViewById(R.id.txt_click_store_18).setOnClickListener(this);
        findViewById(R.id.txt_click_store_19).setOnClickListener(this);
        findViewById(R.id.txt_click_store_20).setOnClickListener(this);
        findViewById(R.id.txt_click_store_21).setOnClickListener(this);
        findViewById(R.id.txt_click_store_22).setOnClickListener(this);
        findViewById(R.id.txt_click_store_23).setOnClickListener(this);
        findViewById(R.id.txt_click_store_24).setOnClickListener(this);
        findViewById(R.id.txt_click_store_25).setOnClickListener(this);
        findViewById(R.id.txt_click_store_26).setOnClickListener(this);
        findViewById(R.id.txt_click_store_27).setOnClickListener(this);
        findViewById(R.id.txt_click_store_28).setOnClickListener(this);
        findViewById(R.id.txt_click_store_29).setOnClickListener(this);
        findViewById(R.id.txt_click_store_30).setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            youTubeView.initialize(Config.YOUTUBE_KEY, this);
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (!wasRestored) {
            youTubePlayer.cueVideo("X0HRBR8Wu3k");
        }
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.txt_more_book:
                String str = ((TextView)findViewById(R.id.txt_more_book)).getText().toString().trim();
                if(str.equalsIgnoreCase("More...")){
                    findViewById(R.id.txt_book_large).setVisibility(View.VISIBLE);
                    ((TextView)findViewById(R.id.txt_more_book)).setText("Less...");
                }
                else if(str.equalsIgnoreCase("Less...")){
                    findViewById(R.id.txt_book_large).setVisibility(View.GONE);
                    ((TextView)findViewById(R.id.txt_more_book)).setText("More...");
                }
                break;
            case R.id.txt_more_audio:
                String str1 = ((TextView)findViewById(R.id.txt_more_audio)).getText().toString().trim();
                if(str1.equalsIgnoreCase("More...")){
                    findViewById(R.id.txt_audio_large).setVisibility(View.VISIBLE);
                    ((TextView)findViewById(R.id.txt_more_audio)).setText("Less...");
                }
                else if(str1.equalsIgnoreCase("Less...")){
                    findViewById(R.id.txt_audio_large).setVisibility(View.GONE);
                    ((TextView)findViewById(R.id.txt_more_audio)).setText("More...");
                }
                break;
            case R.id.txt_click_store_1:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",1));
                break;
            case R.id.txt_click_store_2:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",2));
                break;
            case R.id.txt_click_store_3:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",3));
                break;
            case R.id.txt_click_store_4:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",4));
                break;
            case R.id.txt_click_store_5:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",5));
                break;
            case R.id.txt_click_store_6:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",6));
                break;
            case R.id.txt_click_store_7:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",7));
                break;
            case R.id.txt_click_store_8:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",8));
                break;
            case R.id.txt_click_store_9:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",9));
                break;
            case R.id.txt_click_store_10:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",10));
                break;
            case R.id.txt_click_store_11:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",11));
                break;
            case R.id.txt_click_store_12:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",12));
                break;
            case R.id.txt_click_store_13:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",13));
                break;
            case R.id.txt_click_store_14:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",14));
                break;
            case R.id.txt_click_store_15:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",15));
                break;
            case R.id.txt_click_store_16:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",16));
                break;
            case R.id.txt_click_store_17:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",17));
                break;
            case R.id.txt_click_store_18:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",18));
                break;
            case R.id.txt_click_store_19:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",19));
                break;
            case R.id.txt_click_store_20:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",20));
                break;
            case R.id.txt_click_store_21:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",21));
                break;
            case R.id.txt_click_store_22:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",22));
                break;
            case R.id.txt_click_store_23:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",23));
                break;
            case R.id.txt_click_store_24:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",24));
                break;
            case R.id.txt_click_store_25:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",25));
                break;
            case R.id.txt_click_store_26:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",26));
                break;
            case R.id.txt_click_store_27:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",27));
                break;
            case R.id.txt_click_store_28:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",28));
                break;
            case R.id.txt_click_store_29:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",29));
                break;
            case R.id.txt_click_store_30:
                startActivity(new Intent(getApplicationContext(),TourDetailActivity.class).putExtra("TOUR_ID",30));
                break;
        }
    }
}
