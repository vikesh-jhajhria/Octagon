package com.octagonproject.octagon;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.octagonproject.octagon.adapter.DeeperTourAdapter;
import com.octagonproject.octagon.utils.AppPreferences;
import com.octagonproject.octagon.utils.Config;
import com.octagonproject.octagon.utils.HTTPUrlConnection;
import com.octagonproject.octagon.utils.SpacesItemDecoration;
import com.octagonproject.octagon.utils.Utils;
import com.octagonproject.octagon.vo.DeeperTourVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class TourDetailActivity extends BaseActivity {

    private String[] mTourHeading;
    private int[] mHeaderImage;
    private int[] mHeaderTextImage;
    private int[] mTourDescription;
    private String mVideoUrl;
    private int mTourId;
    private ArrayList<DeeperTourVO> deeperTourList;
    private RecyclerView deeperRecyclerView;
    private DeeperTourAdapter deeperTourAdapter;
    private YouTubePlayerView youTubeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTourId = getIntent().getIntExtra("TOUR_ID", 1);

        if (mTourId == 2) {
            setContentView(R.layout.activity_tour_detail_available);
            ImageView shopImg = (ImageView) findViewById(R.id.img_shop);
            shopImg.setImageResource(R.drawable.merged_gospels_page_composite1);
            ViewGroup.LayoutParams lp = shopImg.getLayoutParams();
            lp.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, getResources().getDisplayMetrics());
            ;
            shopImg.setLayoutParams(lp);
            try {
                findViewById(R.id.rl_proto).setOnClickListener(this);
                findViewById(R.id.rl_dome).setOnClickListener(this);
                findViewById(R.id.ll_banner).setOnClickListener(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setContentView(R.layout.activity_tour_detail);
        }
        findViewById(R.id.img_back).setOnClickListener(this);
        findViewById(R.id.jump_to_tour).setOnClickListener(this);


        mTourDescription = new int[]{R.string.online_tour_1, R.string.tour_2_detail,
                R.string.online_tour_3, R.string.online_tour_4, R.string.online_tour_5,
                R.string.online_tour_6, R.string.online_tour_7, R.string.online_tour_8,
                R.string.online_tour_9, R.string.online_tour_10, R.string.online_tour_11,
                R.string.online_tour_12, R.string.online_tour_13, R.string.online_tour_14,
                R.string.online_tour_15, R.string.online_tour_16, R.string.online_tour_17,
                R.string.online_tour_18, R.string.online_tour_19, R.string.online_tour_20,
                R.string.online_tour_21, R.string.online_tour_22, R.string.online_tour_23,
                R.string.online_tour_24, R.string.online_tour_25, R.string.online_tour_26,
                R.string.online_tour_27, R.string.online_tour_28, R.string.online_tour_29,
                R.string.online_tour_30};

        mHeaderTextImage = new int[]{R.drawable.header_image_tour_text_1, R.drawable.header_image_tour_text_2
                , R.drawable.header_image_tour_text_3, R.drawable.header_image_tour_text_4
                , R.drawable.header_image_tour_text_5, R.drawable.header_image_tour_text_6
                , R.drawable.header_image_tour_text_7, R.drawable.header_image_tour_text_8
                , R.drawable.header_image_tour_text_9, R.drawable.header_image_tour_text_10
                , R.drawable.header_image_tour_text_11, R.drawable.header_image_tour_text_12
                , R.drawable.header_image_tour_text_13, R.drawable.header_image_tour_text_14
                , R.drawable.header_image_tour_text_15, R.drawable.header_image_tour_text_16
                , R.drawable.header_image_tour_text_17, R.drawable.header_image_tour_text_18
                , R.drawable.header_image_tour_text_19, R.drawable.header_image_tour_text_20
                , R.drawable.header_image_tour_text_21, R.drawable.header_image_tour_text_22
                , R.drawable.header_image_tour_text_23, R.drawable.header_image_tour_text_24
                , R.drawable.header_image_tour_text_25, R.drawable.header_image_tour_text_26
                , R.drawable.header_image_tour_text_27, R.drawable.header_image_tour_text_28
                , R.drawable.header_image_tour_text_29, R.drawable.header_image_tour_text_30};

        mHeaderImage = new int[]{R.drawable.header_image_tour_1, R.drawable.header_image_tour_2
                , R.drawable.header_image_tour_3, R.drawable.header_image_tour_4
                , R.drawable.header_image_tour_5, R.drawable.header_image_tour_6
                , R.drawable.header_image_tour_7, R.drawable.header_image_tour_8
                , R.drawable.header_image_tour_9, R.drawable.header_image_tour_10
                , R.drawable.header_image_tour_11, R.drawable.header_image_tour_12
                , R.drawable.header_image_tour_13, R.drawable.header_image_tour_14
                , R.drawable.header_image_tour_15, R.drawable.header_image_tour_16
                , R.drawable.header_image_tour_17, R.drawable.header_image_tour_18
                , R.drawable.header_image_tour_19, R.drawable.header_image_tour_20
                , R.drawable.header_image_tour_21, R.drawable.header_image_tour_22
                , R.drawable.header_image_tour_23, R.drawable.header_image_tour_24
                , R.drawable.header_image_tour_25, R.drawable.header_image_tour_26
                , R.drawable.header_image_tour_27, R.drawable.header_image_tour_28
                , R.drawable.header_image_tour_29, R.drawable.header_image_tour_30};

        mTourHeading = new String[]{"1–3", "4-8", "9–16", "17–22", "23–25", "26–29",
                "30–33", "34–52", "53–79", "80–94", "95–97", "98–107", "108–119",
                "120–134", "135–139", "140–145", "146–150", "151–175", "176–198",
                "199–202", "203–213", "214–219", "220–233", "234–242", "243–264",
                "265–270", "271–278", "279–285", "286–295", "296–299"};
        if (mTourId != 2) {
            ((TextView) findViewById(R.id.txt_title)).setText("Based on stories " +
                    mTourHeading[mTourId - 1] + " of The Merged Gospels");
        }
        ((TextView) findViewById(R.id.txt_description)).setText(mTourDescription[mTourId - 1]);


        ((ImageView) findViewById(R.id.img_tour_header)).setImageResource(mHeaderImage[mTourId - 1]);
        ((ImageView) findViewById(R.id.img_tour_header_text)).setImageResource(mHeaderTextImage[mTourId - 1]);
        /*PicassoTrustAll.getInstance(TourDetailActivity.this)
                .load(mHeaderImage[mTourId - 1])
                .into((ImageView) findViewById(R.id.img_tour_header));

        PicassoTrustAll.getInstance(TourDetailActivity.this)
                .load(mHeaderTextImage[mTourId - 1])
                .into((ImageView) findViewById(R.id.img_tour_header_text));*/

        deeperRecyclerView = (RecyclerView) findViewById(R.id.rv_deeper);
        GridLayoutManager layoutManager = new GridLayoutManager(TourDetailActivity.this, 2,
                GridLayoutManager.VERTICAL, false);
        deeperRecyclerView.setLayoutManager(layoutManager);
        deeperRecyclerView.setNestedScrollingEnabled(false);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.rv_spacing);
        deeperRecyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        deeperTourList = new ArrayList<>();
        deeperTourAdapter = new DeeperTourAdapter(this, deeperTourList);
        deeperRecyclerView.setAdapter(deeperTourAdapter);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_KEY, this);


        findViewById(R.id.img_shop).setOnClickListener(this);
        findViewById(R.id.img_book_cover).setOnClickListener(this);


        new GetDeeperTours().execute();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.img_shop:
                startActivity(new Intent(getApplicationContext(), OurStoreActivity.class));
                break;
            case R.id.img_book_cover:
                startActivity(new Intent(getApplicationContext(), WebViewActivity.class)
                        .putExtra("TYPE", "PDF")
                        .putExtra("URL", "https://www.octagonproject.com/Amazing_Discoveries_of_The_Octagon_Project.pdf"));
                break;
            case R.id.rl_proto:
                startActivity(new Intent(getApplicationContext(), WebViewActivity.class)
                        .putExtra("TYPE", "PDF")
                        .putExtra("URL", "https://www.octagonproject.com/Protoevangelium-of-James-Section1.pdf"));
                break;
            case R.id.rl_dome:
                startActivity(new Intent(getApplicationContext(), WebViewActivity.class)
                        .putExtra("TYPE", "PDF")
                        .putExtra("URL", "https://www.octagonproject.com/Dome-of-the-Rock-Inscriptions.pdf"));
                break;
            case R.id.ll_banner:
                AppPreferences preferences = AppPreferences.getAppPreferences(getApplicationContext());
                String userId = preferences.getStringValue(AppPreferences.USER_ID);
                if (userId != null && !userId.isEmpty()) {
                    startActivity(new Intent(getApplicationContext(), WebViewActivity.class)
                            .putExtra("TYPE", "WEB")
                            .putExtra("URL", "https://www.octagonproject.com/vr-videos/free_video.php?vid=2639"));
                } else {
                    startActivity(new Intent(getApplicationContext(), SignupActivity.class));
                }
                break;

            case R.id.jump_to_tour:
                Utils.jumpToAnyTour(this);
                break;
        }
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
            if (mTourId != 2)
                youTubePlayer.cueVideo("sTf3AlKorio");
            else
                youTubePlayer.cueVideo("hI345Z2btDs");
        }
    }

    class GetDeeperTours extends AsyncTask<String, Void, String> {
        HashMap<String, String> postDataParams;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            postDataParams = new HashMap<String, String>();
            postDataParams.put("tour_id", "" + mTourId);

            return HTTPUrlConnection.getInstance().load("https://www.octagonproject.com/wc-api/tour_api.php",
                    postDataParams);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject object = new JSONObject(result);
                if (object.getString("status_id").equals("1")) {
                    JSONObject obj = object.getJSONObject("header_imgs");
                    mVideoUrl = obj.getString("video_url");


                    JSONArray arr = object.getJSONArray("data");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject detail = arr.getJSONObject(i);
                        DeeperTourVO tourVO = new DeeperTourVO();
                        tourVO.setId(detail.getString("id"));
                        tourVO.setTitle(URLDecoder.decode(detail.getString("tour_title"), "UTF-8"));
                        tourVO.setImage(URLDecoder.decode(detail.getString("tour_image_url"), "UTF-8"));
                        tourVO.setDescription(URLDecoder.decode(detail.getString("tour_description"), "UTF-8"));
                        deeperTourList.add(tourVO);
                    }
                    deeperTourAdapter.notifyDataSetChanged();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
