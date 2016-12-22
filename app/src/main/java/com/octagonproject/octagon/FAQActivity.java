package com.octagonproject.octagon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.octagonproject.octagon.utils.Config;

public class FAQActivity extends BaseActivity {
    TextView rl1txtview, rl2txtview, rl3txtview, rl4txtview, rl5txtview, rl6txtview,
            rl1txtview_pands, rl2txtview_pands, rl3txtview_pands, rl4txtview_pands,rl1txtview_gen
            ,rl2txtview_gen,rl3txtview_gen,rl4txtview_gen
            ,rl5txtview_gen,rl6txtview_gen,rl7txtview_gen,rl1txtview_current,rl2txtview_current
            ,rl3txtview_current,rl4txtview_current,rl5txtview_current,rl6txtview_current;

    ImageView rl1img, rl2img, rl3img, rl4img, rl5img, rl6img, rl1img_pands, rl2img_pands, rl3img_pands, rl4img_pands
            ,img1_gen,img2_gen,img3_gen,img4_gen,img5_gen,img6_gen,img7_gen
            ,img1_current,img2_current,img3_current,img4_current,img5_current,img6_current;

    private YouTubePlayerView youTubeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_KEY, this);
        findViewById(R.id.img_back).setOnClickListener(this);
        findViewById(R.id.rl1).setOnClickListener(this);
        findViewById(R.id.rl2).setOnClickListener(this);
        findViewById(R.id.rl3).setOnClickListener(this);
        findViewById(R.id.rl4).setOnClickListener(this);
        findViewById(R.id.rl5).setOnClickListener(this);
        findViewById(R.id.rl6).setOnClickListener(this);

        findViewById(R.id.rl1_pands).setOnClickListener(this);
        findViewById(R.id.rl2_pands).setOnClickListener(this);
        findViewById(R.id.rl3_pands).setOnClickListener(this);
        findViewById(R.id.rl4_pands).setOnClickListener(this);

        findViewById(R.id.rl1_general).setOnClickListener(this);
        findViewById(R.id.rl2_general).setOnClickListener(this);
        findViewById(R.id.rl3_general).setOnClickListener(this);
        findViewById(R.id.rl4_general).setOnClickListener(this);
        findViewById(R.id.rl5_general).setOnClickListener(this);
        findViewById(R.id.rl6_general).setOnClickListener(this);
        findViewById(R.id.rl7_general).setOnClickListener(this);

        findViewById(R.id.rl1_current).setOnClickListener(this);
        findViewById(R.id.rl2_current).setOnClickListener(this);
        findViewById(R.id.rl3_current).setOnClickListener(this);
        findViewById(R.id.rl4_current).setOnClickListener(this);
        findViewById(R.id.rl5_current).setOnClickListener(this);
        findViewById(R.id.rl6_current).setOnClickListener(this);

        rl1img = (ImageView) findViewById(R.id.imgview_arrow1);
        rl2img = (ImageView) findViewById(R.id.imgview_arrow2);
        rl3img = (ImageView) findViewById(R.id.imgview_arrow3);
        rl4img = (ImageView) findViewById(R.id.imgview_arrow4);
        rl5img = (ImageView) findViewById(R.id.imgview_arrow5);
        rl6img = (ImageView) findViewById(R.id.imgview_arrow6);

        rl1img_pands = (ImageView) findViewById(R.id.imgview_arrow1__pands);
        rl2img_pands = (ImageView) findViewById(R.id.imgview_arrow2_pands);
        rl3img_pands = (ImageView) findViewById(R.id.imgview_arrow3_pands);
        rl4img_pands = (ImageView) findViewById(R.id.imgview_arrow4_pands);

        rl1txtview = (TextView) findViewById(R.id.txtview_rl1);
        rl2txtview = (TextView) findViewById(R.id.txtview_rl2);
        rl3txtview = (TextView) findViewById(R.id.txtview_rl3);
        rl4txtview = (TextView) findViewById(R.id.txtview_rl4);
        rl5txtview = (TextView) findViewById(R.id.txtview_rl5);
        rl6txtview = (TextView) findViewById(R.id.txtview_rl6);

        rl1txtview_pands = (TextView) findViewById(R.id.txtview_rl1_pands);
        rl2txtview_pands = (TextView) findViewById(R.id.txtview_rl2_pands);
        rl3txtview_pands = (TextView) findViewById(R.id.txtview_rl3_pands);
        rl4txtview_pands = (TextView) findViewById(R.id.txtview_rl4_pands);

        img1_gen = (ImageView) findViewById(R.id.imgview_arrow1__general);
        img2_gen = (ImageView) findViewById(R.id.imgview_arrow2_general);
        img3_gen = (ImageView) findViewById(R.id.imgview_arrow3_general);
        img4_gen = (ImageView) findViewById(R.id.imgview_arrow4_general);
        img5_gen = (ImageView) findViewById(R.id.imgview_arrow5_general);
        img6_gen = (ImageView) findViewById(R.id.imgview_arrow6_general);
        img7_gen = (ImageView) findViewById(R.id.imgview_arrow7_general);

        img1_current = (ImageView) findViewById(R.id.imgview_arrow1__current);
        img2_current = (ImageView) findViewById(R.id.imgview_arrow2_current);
        img3_current = (ImageView) findViewById(R.id.imgview_arrow3_current);
        img4_current = (ImageView) findViewById(R.id.imgview_arrow4_current);
        img5_current = (ImageView) findViewById(R.id.imgview_arrow5_current);
        img6_current = (ImageView) findViewById(R.id.imgview_arrow6_current);

        rl1txtview_gen = (TextView) findViewById(R.id.txtview_rl1_general);
        rl2txtview_gen = (TextView) findViewById(R.id.txtview_rl2_general);
        rl3txtview_gen = (TextView) findViewById(R.id.txtview_rl3_general);
        rl4txtview_gen = (TextView) findViewById(R.id.txtview_rl4_general);
        rl5txtview_gen = (TextView) findViewById(R.id.txtview_rl5_general);
        rl6txtview_gen = (TextView) findViewById(R.id.txtview_rl6_general);
        rl7txtview_gen = (TextView) findViewById(R.id.txtview_rl7_general);

        rl1txtview_current = (TextView) findViewById(R.id.txtview_rl1_current);
        rl2txtview_current = (TextView) findViewById(R.id.txtview_rl2_current);
        rl3txtview_current = (TextView) findViewById(R.id.txtview_rl3_current);
        rl4txtview_current = (TextView) findViewById(R.id.txtview_rl4_current);
        rl5txtview_current = (TextView) findViewById(R.id.txtview_rl5_current);
        rl6txtview_current= (TextView) findViewById(R.id.txtview_rl6_current);
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
                youTubePlayer.cueVideo("hI345Z2btDs");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl1:
                openLayout(findViewById(R.id.rl1));
                break;
            case R.id.rl2:
                openLayout(findViewById(R.id.rl2));
                break;
            case R.id.rl3:
                openLayout(findViewById(R.id.rl3));
                break;
            case R.id.rl4:
                openLayout(findViewById(R.id.rl4));
                break;
            case R.id.rl5:
                openLayout(findViewById(R.id.rl5));
                break;
            case R.id.rl6:
                openLayout(findViewById(R.id.rl6));
                break;

            case R.id.rl1_pands:
                openLayout(findViewById(R.id.rl1_pands));
                break;
            case R.id.rl2_pands:
                openLayout(findViewById(R.id.rl2_pands));
                break;
            case R.id.rl3_pands:
                openLayout(findViewById(R.id.rl3_pands));
                break;
            case R.id.rl4_pands:
                openLayout(findViewById(R.id.rl4_pands));
                break;

            case R.id.rl1_general:
                openLayout(findViewById(R.id.rl1_general));
                break;
            case R.id.rl2_general:
                openLayout(findViewById(R.id.rl2_general));
                break;
            case R.id.rl3_general:
                openLayout(findViewById(R.id.rl3_general));
                break;
            case R.id.rl4_general:
                openLayout(findViewById(R.id.rl4_general));
                break;
            case R.id.rl5_general:
                openLayout(findViewById(R.id.rl5_general));
                break;
            case R.id.rl6_general:
                openLayout(findViewById(R.id.rl6_general));
                break;
            case R.id.rl7_general:
                openLayout(findViewById(R.id.rl7_general));
                break;

            case R.id.rl1_current:
                openLayout(findViewById(R.id.rl1_current));
                break;
            case R.id.rl2_current:
                openLayout(findViewById(R.id.rl2_current));
                break;
            case R.id.rl3_current:
                openLayout(findViewById(R.id.rl3_current));
                break;
            case R.id.rl4_current:
                openLayout(findViewById(R.id.rl4_current));
                break;
            case R.id.rl5_current:
                openLayout(findViewById(R.id.rl5_current));
                break;
            case R.id.rl6_current:
                openLayout(findViewById(R.id.rl6_current));
                break;
        }
    }

    public void openLayout(View view) {

        rl1img.setRotation(0);
        rl1txtview.setVisibility(View.GONE);
        rl2img.setRotation(0);
        rl2txtview.setVisibility(View.GONE);
        rl3img.setRotation(0);
        rl3txtview.setVisibility(View.GONE);
        rl4img.setRotation(0);
        rl4txtview.setVisibility(View.GONE);
        rl5img.setRotation(0);
        rl5txtview.setVisibility(View.GONE);
        rl6img.setRotation(0);
        rl6txtview.setVisibility(View.GONE);

        rl1img_pands.setRotation(0);
        rl1txtview_pands.setVisibility(View.GONE);
        rl2img_pands.setRotation(0);
        rl2txtview_pands.setVisibility(View.GONE);
        rl3img_pands.setRotation(0);
        rl3txtview_pands.setVisibility(View.GONE);
        rl4img_pands.setRotation(0);
        rl4txtview_pands.setVisibility(View.GONE);

        img1_gen.setRotation(0);
        rl1txtview_gen.setVisibility(View.GONE);
        img2_gen.setRotation(0);
        rl2txtview_gen.setVisibility(View.GONE);
        img3_gen.setRotation(0);
        rl3txtview_gen.setVisibility(View.GONE);
        img4_gen.setRotation(0);
        rl4txtview_gen.setVisibility(View.GONE);
        img5_gen.setRotation(0);
        rl5txtview_gen.setVisibility(View.GONE);
        img6_gen.setRotation(0);
        rl6txtview_gen.setVisibility(View.GONE);
        img7_gen.setRotation(0);
        rl7txtview_gen.setVisibility(View.GONE);

        img1_current.setRotation(0);
        rl1txtview_current.setVisibility(View.GONE);
        img2_current.setRotation(0);
        rl2txtview_current.setVisibility(View.GONE);
        img3_current.setRotation(0);
        rl3txtview_current.setVisibility(View.GONE);
        img4_current.setRotation(0);
        rl4txtview_current.setVisibility(View.GONE);
        img5_current.setRotation(0);
        rl5txtview_current.setVisibility(View.GONE);
        img6_current.setRotation(0);
        rl6txtview_current.setVisibility(View.GONE);

        if (view.getId() == R.id.rl1) {
            rl1img.setRotation(90);
            rl1txtview.setVisibility(View.VISIBLE);

        } else if (view.getId() == R.id.rl2) {
            rl2img.setRotation(90);
            rl2txtview.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl3) {
            rl3img.setRotation(90);
            rl3txtview.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl4) {
            rl4img.setRotation(90);
            rl4txtview.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl5) {
            rl5img.setRotation(90);
            rl5txtview.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl6) {
            rl6img.setRotation(90);
            rl6txtview.setVisibility(View.VISIBLE);
        }

        if (view.getId() == R.id.rl1_pands) {
            rl1img_pands.setRotation(90);
            rl1txtview_pands.setVisibility(View.VISIBLE);

        } else if (view.getId() == R.id.rl2_pands) {
            rl2img_pands.setRotation(90);
            rl2txtview_pands.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl3_pands) {
            rl3img_pands.setRotation(90);
            rl3txtview_pands.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl4_pands) {
            rl4img_pands.setRotation(90);
            rl4txtview_pands.setVisibility(View.VISIBLE);
        }

        else if (view.getId() == R.id.rl1_general) {
            img1_gen.setRotation(90);
            rl1txtview_gen.setVisibility(View.VISIBLE);

        } else if (view.getId() == R.id.rl2_general) {
            img2_gen.setRotation(90);
            rl2txtview_gen.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl3_general) {
            img3_gen.setRotation(90);
            rl3txtview_gen.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl4_general) {
            img4_gen.setRotation(90);
            rl4txtview_gen.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl5_general) {
            img5_gen.setRotation(90);
            rl5txtview_gen.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl6_general) {
            img6_gen.setRotation(90);
            rl6txtview_gen.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl7_general) {
            img7_gen.setRotation(90);
            rl7txtview_gen.setVisibility(View.VISIBLE);
        }

        else if (view.getId() == R.id.rl1_current) {
            img1_current.setRotation(90);
            rl1txtview_current.setVisibility(View.VISIBLE);

        } else if (view.getId() == R.id.rl2_current) {
            img2_current.setRotation(90);
            rl2txtview_current.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl3_current) {
            img3_current.setRotation(90);
            rl3txtview_current.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl4_current) {
            img4_current.setRotation(90);
            rl4txtview_current.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl5_current) {
            img5_current.setRotation(90);
            rl5txtview_current.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl6_current) {
            img6_current.setRotation(90);
            rl6txtview_current.setVisibility(View.VISIBLE);
        }
    }
}

