package com.webakruti.placify;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebViewClientImpl extends WebViewClient {

    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    public WebViewClientImpl() {

    }

    @TargetApi(Build.VERSION_CODES.N)
    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if (url.indexOf("https://www.myntra.com/") > -1) return false;


            /*Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);*/


        if (url.startsWith("tel:")) {
            Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
            activity.startActivity(intent1);
            return true;
        }
        return false;



            /*if (url.startsWith("tel:")) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                activity.startActivity(intent1);
                //view.reload();
                return true;
            }

            //view.loadUrl(url);
            return true;
        */
    }

    /*@TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        final Uri uri = request.getUrl();

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        activity.startActivity(intent);

         *//*if (uri.toString().startsWith("tel:")) {
            //Handle telephony Urls
            activity.startActivity(new Intent(Intent.ACTION_DIAL, uri));
        } else {
            //Handle Web Urls
            view.loadUrl(uri.toString());
        }*//*
        return true;
    }*/

}