package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.sdk.WebIconDatabase.a;

class bc implements IconListener {
    final /* synthetic */ a a;
    final /* synthetic */ WebIconDatabase b;

    bc(WebIconDatabase webIconDatabase, a aVar) {
        this.b = webIconDatabase;
        this.a = aVar;
    }

    public void onReceivedIcon(String str, Bitmap bitmap) {
        this.a.a(str, bitmap);
    }
}
