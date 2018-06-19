package com.alibaba.sdk.android.feedback.windvane;

import android.view.View;
import android.view.View.OnClickListener;

class j implements OnClickListener {
    final /* synthetic */ WXBaseHybridActivity a;

    j(WXBaseHybridActivity wXBaseHybridActivity) {
        this.a = wXBaseHybridActivity;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
