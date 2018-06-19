package com.tencent.smtt.sdk;

import android.graphics.Picture;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;

class bh implements PictureListener {
    final /* synthetic */ WebView.PictureListener a;
    final /* synthetic */ WebView b;

    bh(WebView webView, WebView.PictureListener pictureListener) {
        this.b = webView;
        this.a = pictureListener;
    }

    public void onNewPicture(WebView webView, Picture picture) {
        this.b.a(webView);
        this.a.onNewPicture(this.b, picture);
    }
}
