package com.alibaba.sdk.android.feedback.impl;

import android.view.View;
import android.view.View.OnClickListener;

class b implements OnClickListener {
    final /* synthetic */ ErrorPageActivity a;

    b(ErrorPageActivity errorPageActivity) {
        this.a = errorPageActivity;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
