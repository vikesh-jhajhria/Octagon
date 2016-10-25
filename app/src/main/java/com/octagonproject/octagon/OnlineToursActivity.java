package com.octagonproject.octagon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OnlineToursActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_tours);
        findViewById(R.id.free_signup).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.free_signup:
                startActivity(new Intent(getApplicationContext(),SignupActivity.class));
                break;
        }
    }
}
