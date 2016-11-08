package com.octagonproject.octagon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TourDetailActivity extends BaseActivity {

    private String [] mTourHeading;
    private int [] mHeaderImage;
    private int [] mHeaderTextImage;
    private int [] mTourDescription;
    private String [] mVideoUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);

        mTourHeading = new String[]{"1–3","4–8","9–16","17–22","23–25","26–29","30–33","34–52","53–79","80–94","95–97","98–107","108–119","120–134","135–139"
                ,"140–145","146–150","151–175","176–198","199–202","203–213","214–219","220–233"
                ,"234–242","243–264","265–270","271–278","279–285","286–295","296–299"};
    }
}
