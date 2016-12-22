package com.octagonproject.octagon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import uk.co.deanwild.flowtextview.FlowTextView;

public class AboutUsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        findViewById(R.id.img_back).setOnClickListener(this);

        FlowTextView about_us_text = (FlowTextView) findViewById(R.id.txt_about);
        about_us_text.setTextColor(getResources().getColor(android.R.color.white));
        about_us_text.setTextSize(getResources().getDimension(R.dimen.font_14));
        about_us_text.setText(getResources().getText(R.string.about_us_text));
    }
}
