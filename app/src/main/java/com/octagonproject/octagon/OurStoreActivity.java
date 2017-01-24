package com.octagonproject.octagon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.octagonproject.octagon.utils.Config;
import com.octagonproject.octagon.utils.DatabaseHandler;
import com.octagonproject.octagon.vo.CartItemVO;

public class OurStoreActivity extends BaseActivity {

    private YouTubePlayerView youTubeView;
    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_store);
        findViewById(R.id.img_back).setOnClickListener(this);
        databaseHandler = new DatabaseHandler(this);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_KEY, this);

        findViewById(R.id.txt_more_book).setOnClickListener(this);
        findViewById(R.id.txt_more_audio).setOnClickListener(this);
        findViewById(R.id.txt_atc_printed_book).setOnClickListener(this);
        findViewById(R.id.txt_atc_cd).setOnClickListener(this);
        findViewById(R.id.txt_atc_e_book).setOnClickListener(this);
        findViewById(R.id.txt_atc_mp3).setOnClickListener(this);


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
        CartItemVO item;
        switch (view.getId()) {
            case R.id.txt_more_book:
                String str = ((TextView) findViewById(R.id.txt_more_book)).getText().toString().trim();
                if (str.equalsIgnoreCase("More...")) {
                    findViewById(R.id.txt_book_large).setVisibility(View.VISIBLE);
                    ((TextView) findViewById(R.id.txt_more_book)).setText("Less...");
                } else if (str.equalsIgnoreCase("Less...")) {
                    findViewById(R.id.txt_book_large).setVisibility(View.GONE);
                    ((TextView) findViewById(R.id.txt_more_book)).setText("More...");
                }
                break;
            case R.id.txt_more_audio:
                String str1 = ((TextView) findViewById(R.id.txt_more_audio)).getText().toString().trim();
                if (str1.equalsIgnoreCase("More...")) {
                    findViewById(R.id.txt_audio_large).setVisibility(View.VISIBLE);
                    ((TextView) findViewById(R.id.txt_more_audio)).setText("Less...");
                } else if (str1.equalsIgnoreCase("Less...")) {
                    findViewById(R.id.txt_audio_large).setVisibility(View.GONE);
                    ((TextView) findViewById(R.id.txt_more_audio)).setText("More...");
                }
                break;
            case R.id.txt_atc_cd:
                item = new CartItemVO("The Merged Gospels Audio Book 7 Cd's", 29.95, 1);
                databaseHandler.addCartItem(item);
                startActivity(new Intent(this, ShoppingCartActivity.class).putExtra("ITEM", "CD"));
                break;
            case R.id.txt_atc_e_book:
                item = new CartItemVO("The Merged Gospels E-book", 19.95, 1);
                databaseHandler.addCartItem(item);
                startActivity(new Intent(this, ShoppingCartActivity.class).putExtra("ITEM", "EBOOK"));
                break;
            case R.id.txt_atc_mp3:
                item = new CartItemVO("The Merged Gospels Audio Book 7 Cd's", 29.95, 1);
                databaseHandler.addCartItem(item);
                startActivity(new Intent(this, ShoppingCartActivity.class).putExtra("ITEM", "MP3"));
                break;
            case R.id.txt_atc_printed_book:
                item = new CartItemVO("The Merged Gospels Audio Book 7 Cd's", 29.95, 1);
                databaseHandler.addCartItem(item);
                startActivity(new Intent(this, ShoppingCartActivity.class).putExtra("ITEM", "PRINTED_BOOK"));
                break;
        }
    }
}
