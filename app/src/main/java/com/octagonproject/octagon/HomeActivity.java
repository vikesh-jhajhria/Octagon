package com.octagonproject.octagon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.octagonproject.octagon.utils.Config;

public class HomeActivity extends BaseActivity {

    Handler handler = new Handler();
    private YouTubePlayerView youTubeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);


        findViewById(R.id.img_back).setVisibility(View.GONE);
        findViewById(R.id.img_menu).setVisibility(View.VISIBLE);
        findViewById(R.id.img_menu).setOnClickListener(this);
        findViewById(R.id.img_video).setOnClickListener(this);
        findViewById(R.id.ll_go_on_tours).setOnClickListener(this);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.online_tours).setOnClickListener(this);
        findViewById(R.id.our_store).setOnClickListener(this);
        findViewById(R.id.live_tours).setOnClickListener(this);
        findViewById(R.id.customer_comments).setOnClickListener(this);
        findViewById(R.id.scholarly_reviews).setOnClickListener(this);
        findViewById(R.id.shopping_cart).setOnClickListener(this);
        findViewById(R.id.store_checkout).setOnClickListener(this);
        findViewById(R.id.social_sites).setOnClickListener(this);
        findViewById(R.id.img_facebook).setOnClickListener(this);
        findViewById(R.id.img_twitter).setOnClickListener(this);
        findViewById(R.id.img_google).setOnClickListener(this);
        findViewById(R.id.img_youtube).setOnClickListener(this);
        findViewById(R.id.img_instagram).setOnClickListener(this);
        findViewById(R.id.img_christmas).setOnClickListener(this);

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

            youTubePlayer.loadVideo("j8EnC1TfgBw");
            youTubePlayer.setFullscreen(true);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.img_menu:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
                break;
            case R.id.shop:
                loadActivity(new Intent(getApplicationContext(), OurStoreActivity.class));
                break;
            case R.id.img_video:
                view.setVisibility(View.INVISIBLE);
                youTubeView.initialize(Config.YOUTUBE_KEY, this);
                break;
            case R.id.ll_go_on_tours:
                loadActivity(new Intent(getApplicationContext(), OnlineToursActivity.class));
                break;

            case R.id.login:
                loadActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
            case R.id.our_store:
                loadActivity(new Intent(getApplicationContext(), OurStoreActivity.class));
                break;
            case R.id.online_tours:
                loadActivity(new Intent(getApplicationContext(), OnlineToursActivity.class));
                break;
            case R.id.live_tours:
                loadActivity(new Intent(getApplicationContext(), LiveToursActivity.class));
                break;
            case R.id.scholarly_reviews:
                loadActivity(new Intent(getApplicationContext(), ReviewsActivity.class));
                break;
            case R.id.shopping_cart:
                loadActivity(new Intent(getApplicationContext(), ShoppingCartActivity.class));
                break;
            case R.id.store_checkout:
                loadActivity(new Intent(getApplicationContext(), CheckoutActivity.class));
                break;
            case R.id.customer_comments:
                loadActivity(new Intent(getApplicationContext(), CommentsActivity.class));
                break;
            case R.id.img_facebook:
                startActivity(new Intent(getApplicationContext(), SocialSitesActivity.class)
                        .putExtra("TYPE", 1));
                break;
            case R.id.img_twitter:
                startActivity(new Intent(getApplicationContext(), SocialSitesActivity.class)
                        .putExtra("TYPE", 2));
                break;
            case R.id.img_google:
                startActivity(new Intent(getApplicationContext(), SocialSitesActivity.class)
                        .putExtra("TYPE", 3));
                break;
            case R.id.img_youtube:
                startActivity(new Intent(getApplicationContext(), SocialSitesActivity.class)
                        .putExtra("TYPE", 4));
                break;
            case R.id.img_instagram:
                startActivity(new Intent(getApplicationContext(), SocialSitesActivity.class)
                        .putExtra("TYPE", 5));
                break;
            case R.id.img_christmas:
                startActivity(new Intent(getApplicationContext(), WebViewActivity.class)
                        .putExtra("TYPE", "WEB")
                        .putExtra("URL", "https://www.octagonproject.com/vr-videos/free_video_live.php?vid=10177"));
                break;

        }
    }

    private void loadActivity(final Intent intent) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 100);
    }
}
