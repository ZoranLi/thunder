package com.tencent.smtt.sdk;

import android.graphics.Picture;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;

class bi implements PictureListener {
    final /* synthetic */ WebView.PictureListener a;
    final /* synthetic */ WebView b;

    bi(WebView webView, WebView.PictureListener pictureListener) {
        this.b = webView;
        this.a = pictureListener;
    }

    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
        this.b.a(iX5WebViewBase);
        this.a.onNewPicture(this.b, picture);
    }

    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
    }
}
