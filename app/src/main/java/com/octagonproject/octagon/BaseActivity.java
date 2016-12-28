package com.octagonproject.octagon;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import java.util.List;

/**
 * Created by Vikesh on 10/21/2016.
 */

public class BaseActivity extends YouTubeBaseActivity implements View.OnClickListener,
        YouTubePlayer.OnInitializedListener {

    public static final int RECOVERY_REQUEST = 1;
    private boolean isExit;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);
    }


    public String TAG = "OCTAGON";

    public void showProgessDialog() {
        if (dialog != null && !dialog.isShowing() && !this.isFinishing())
            dialog.show();
    }

    public void showProgessDialog(String message) {
        if (dialog != null && !dialog.isShowing() && !this.isFinishing()) {
            dialog.setMessage(message);
            dialog.show();
        }
    }

    public void dismissProgressDialog() {
        if (dialog != null && dialog.isShowing() && !this.isFinishing())
            dialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskList = activityManager.getRunningTasks(10);
        if (taskList.get(0).numActivities == 1 && taskList.get(0).topActivity.getClassName().equals(this.getClass().getName())) {
            if (isExit) {
                finish();
            } else {
                Toast.makeText(this, "Press back again to Exit !", Toast.LENGTH_SHORT).show();
                isExit = true;
            }
        } else {
            super.onBackPressed();
        }
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                isExit = false;
            }
        }, 2000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                onBackPressed();
                break;
            case R.id.shop:
                startActivity(new Intent(getApplicationContext(), OurStoreActivity.class));
                break;
            case R.id.go_to_tours:
                startActivity(new Intent(getApplicationContext(), OnlineToursActivity.class));
                break;
            case R.id.txt_message:
                Intent intent = new Intent(Intent.ACTION_SENDTO)
                        .setData(new Uri.Builder().scheme("mailto").build())
                        .putExtra(Intent.EXTRA_EMAIL, new String[]{" <info@octagonproject.com>"});
                Intent chooser = Intent.createChooser(intent, "Send email with");
                startActivity(chooser);
                break;
            case R.id.txt_more_video:
                startActivity(new Intent(getApplicationContext(), SocialSitesActivity.class)
                        .putExtra("TYPE", 4));
                break;
            case R.id.txt_photo:
                startActivity(new Intent(getApplicationContext(), SocialSitesActivity.class)
                        .putExtra("TYPE", 6));
                break;
            case R.id.txt_permission:
                startActivity(new Intent(getApplicationContext(), FilmingPermissionActivity.class));
                break;
            case R.id.txt_policy:
                startActivity(new Intent(getApplicationContext(), PrivacyPolicyActivity.class));
                break;
            case R.id.txt_bookstore:
                startActivity(new Intent(getApplicationContext(), BookstorePolicyActivity.class));
                break;
            case R.id.txt_about_us:
                startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));
                break;
            case R.id.txt_faq:
                startActivity(new Intent(getApplicationContext(), FAQActivity.class));
                break;
            case R.id.txt_online_tours:
                startActivity(new Intent(getApplicationContext(), OnlineToursActivity.class));
                break;
            case R.id.txt_live_tours:
                startActivity(new Intent(getApplicationContext(), LiveToursActivity.class));
                break;
            case R.id.txt_reviews:
                startActivity(new Intent(getApplicationContext(), ReviewsActivity.class));
                break;
            case R.id.txt_shop:
                startActivity(new Intent(getApplicationContext(), OurStoreActivity.class));
                break;
            case R.id.txt_comments:
                startActivity(new Intent(getApplicationContext(), CommentsActivity.class));
                break;
            case R.id.ll_order_copy:
                startActivity(new Intent(getApplicationContext(), OurStoreActivity.class));
                break;
        }


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format("Error initializing YouTube player", errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
