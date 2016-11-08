package com.octagonproject.octagon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LiveToursActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_tours);
        findViewById(R.id.img_back).setOnClickListener(this);
        /*String url = "https://www.youtube.com/watch?v=sTf3AlKorio&feature=youtu.be";
        ((WebView) findViewById(R.id.mWebView)).getSettings().setJavaScriptEnabled(true);
        //final Activity activity = WalkthroughtFragment.this;
        ((WebView) findViewById(R.id.mWebView)).setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                LiveToursActivity.this.setProgress(progress * 1000);
            }
        });
        ((WebView) findViewById(R.id.mWebView)).setWebViewClient(new MyOwnWebViewClient());
        ((WebView) findViewById(R.id.mWebView)).loadUrl(url);*/


        String frameVideo = "<html><body><iframe width=\"320\" height=\"315\" src=\"https://www.youtube.com/embed/sTf3AlKorio\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

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
        //displayYoutubeVideo.loadUrl("/video.html");
    }

    class MyOwnWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}

