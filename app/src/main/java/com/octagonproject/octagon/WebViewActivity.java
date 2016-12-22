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

public class WebViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
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
        if (getIntent().getStringExtra("TYPE").equalsIgnoreCase("PDF")) {
            String PDF_URL = getIntent().getStringExtra("URL");
            mWebView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + PDF_URL, headers);
        } else {
            mWebView.loadUrl(getIntent().getStringExtra("URL"));
        }
    }


}
