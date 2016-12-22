package com.octagonproject.octagon;

import android.net.http.SslError;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.octagonproject.octagon.utils.Config;

import java.util.HashMap;
import java.util.Map;

public class SocialSitesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_sites);
        findViewById(R.id.img_back).setOnClickListener(this);

        WebView mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler,
                                                  String host, String realm) {
                handler.proceed(Config.USERNAME, Config.PASSWORD);
            }

            public void onReceivedSslError(WebView view, SslErrorHandler handler,
                                           SslError error) {
                handler.proceed();
            }

        });

        String userPassword = Config.USERNAME + ":" + Config.PASSWORD;
        String encoding = new String(Base64.encode(userPassword.getBytes(), Base64.DEFAULT));
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + encoding);

        switch (getIntent().getIntExtra("TYPE", 0)) {
            case 1:
                mWebView.loadUrl("https://www.facebook.com/octagonproject", headers);
                break;
            case 2:
                mWebView.loadUrl("https://twitter.com/octagonproject", headers);
                break;
            case 3:
                mWebView.loadUrl("https://plus.google.com/116040943751036139661", headers);
                break;
            case 4:
                mWebView.loadUrl("https://www.youtube.com/channel/UColwL9pYJFYvlKwhmuJaLcA", headers);
                break;
            case 5:
                mWebView.loadUrl("https://www.instagram.com/theoctagonproject/", headers);
                break;
            case 6:
                mWebView.loadUrl("https://goo.gl/photos/Y46VHXLp4nCKJJ667", headers);
                break;
        }


    }
}
