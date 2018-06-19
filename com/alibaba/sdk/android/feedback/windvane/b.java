package com.alibaba.sdk.android.feedback.windvane;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.alibaba.sdk.android.feedback.xblink.f.b.a;

class b implements OnClickListener {
    final /* synthetic */ CustomHybirdActivity a;

    b(CustomHybirdActivity customHybirdActivity) {
        this.a = customHybirdActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("url", this.a.mUrl);
        this.a.setResult(a.e, intent);
        if (this.a.mPageAction.a()) {
            this.a.mPageAction.b();
        } else if (this.a.isCanGoBack()) {
            this.a.webview.goBack();
        } else {
            this.a.finish();
        }
    }
}
