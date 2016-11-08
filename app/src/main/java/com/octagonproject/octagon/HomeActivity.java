package com.octagonproject.octagon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

public class HomeActivity extends BaseActivity {

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.img_back).setVisibility(View.GONE);
        findViewById(R.id.img_menu).setVisibility(View.VISIBLE);
        findViewById(R.id.img_menu).setOnClickListener(this);
        findViewById(R.id.go_to_tours).setOnClickListener(this);
        findViewById(R.id.free_signup).setOnClickListener(this);
        findViewById(R.id.signup).setOnClickListener(this);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.online_tours).setOnClickListener(this);
        findViewById(R.id.our_store).setOnClickListener(this);
        findViewById(R.id.live_tours).setOnClickListener(this);
        findViewById(R.id.customer_comments).setOnClickListener(this);
        findViewById(R.id.scholarly_reviews).setOnClickListener(this);
        findViewById(R.id.shopping_cart).setOnClickListener(this);
        findViewById(R.id.store_checkout).setOnClickListener(this);
        findViewById(R.id.social_sites).setOnClickListener(this);

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
        switch (view.getId()){
            case R.id.img_menu:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
                break;
            case R.id.free_signup:
                loadActivity(new Intent(getApplicationContext(),SignupActivity.class));
                break;
            case R.id.go_to_tours:
                loadActivity(new Intent(getApplicationContext(),OnlineToursActivity.class));
                break;
            case R.id.signup:
                loadActivity(new Intent(getApplicationContext(),SignupActivity.class));
                break;
            case R.id.login:
                loadActivity(new Intent(getApplicationContext(),LoginActivity.class));
                break;
            case R.id.our_store:
                loadActivity(new Intent(getApplicationContext(),OurStoreActivity.class));
                break;
            case R.id.online_tours:
                loadActivity(new Intent(getApplicationContext(),OnlineToursActivity.class));
                break;
            case R.id.live_tours:
                loadActivity(new Intent(getApplicationContext(),LiveToursActivity.class));
                break;
            case R.id.scholarly_reviews:
                loadActivity(new Intent(getApplicationContext(),ReviewsActivity.class));
                break;
            case R.id.shopping_cart:
                loadActivity(new Intent(getApplicationContext(),ShoppingCartActivity.class));
                break;
            case R.id.store_checkout:
                loadActivity(new Intent(getApplicationContext(),CheckoutActivity.class));
                break;
            case R.id.social_sites:
                loadActivity(new Intent(getApplicationContext(),SocialSitesActivity.class));
                break;
            case R.id.customer_comments:
                loadActivity(new Intent(getApplicationContext(),CommentsActivity.class));
                break;
        }
    }

  private void loadActivity(final Intent intent){
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
