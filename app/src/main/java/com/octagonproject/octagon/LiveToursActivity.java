package com.octagonproject.octagon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LiveToursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_tours);

//        String frameVideo = "https://www.youtube.com/embed/sTf3AlKorio?enablejsapi=1&rel=0&byline=0&portrait=0&modestbranding=0&autohide=1&showinfo=0&controls=0";
        String frameVideo = "<html><body>Video From YouTube<br><iframe width=\\\"420\\\" height=\\\"315\\\" src=\\\"https://www.youtube.com/embed/sTf3AlKorio\\\" frameborder=\\\"0\\\" allowfullscreen></iframe></body></html>";
        WebView displayYoutubeVideo = (WebView) findViewById(R.id.mWebView);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8");
    }
}
