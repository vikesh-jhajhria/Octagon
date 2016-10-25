package com.octagonproject.octagon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.img_menu).setOnClickListener(this);
        findViewById(R.id.go_to_tours).setOnClickListener(this);
        findViewById(R.id.free_signup).setOnClickListener(this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
                startActivity(new Intent(getApplicationContext(),SignupActivity.class));
                break;
            case R.id.go_to_tours:
                startActivity(new Intent(getApplicationContext(),OnlineToursActivity.class));
                break;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.signup:
                startActivity(new Intent(getApplicationContext(),SignupActivity.class));
                break;
            case R.id.login:
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                break;
            case R.id.our_store:

                break;
            case R.id.online_tours:
                startActivity(new Intent(getApplicationContext(),OnlineToursActivity.class));
                break;
            case R.id.live_tours:

                break;
            case R.id.scholarly_reviews:

                break;
            case R.id.shopping_cart:

                break;
            case R.id.store_checkout:

                break;
            case R.id.social_sites:

                break;
            case R.id.customer_comments:

                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
