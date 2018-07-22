package com.playground.android;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class activity_webView extends AppCompatActivity {
    WebView myWebView;
    View progressBar;
    String currentUrl = "https://www.google.com";
    SwipeRefreshLayout swipeDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        myWebView = (WebView) findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar3);
        swipeDown = findViewById(R.id.swiperefresh);
        progressBar.setVisibility(View.VISIBLE);
        myWebView.setWebViewClient(new WebViewClient() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                final Uri uri = request.getUrl();
                return handleUri(uri);


            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                final Uri uri = Uri.parse(url);
                return handleUri(uri);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                currentUrl = url;
                progressBar.setVisibility(View.INVISIBLE);
                swipeDown.setRefreshing(false);


            }

            private boolean handleUri(final Uri uri) {

                String viewUrl = myWebView.getUrl();
                Log.d("viewurl", viewUrl);
                if (viewUrl.contains("YouTube")) {
                    Log.d("viewurl", "contains");
                    final Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    return true;
                } else
                    return false;


            }
        });
        myWebView.loadUrl(currentUrl);

        swipeDown.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myWebView.loadUrl("https://www.google.com");
            }
        });



    }

}


