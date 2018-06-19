package com.alibaba.sdk.android.feedback.windvane;

import android.view.View;
import android.view.View.OnClickListener;

class f implements OnClickListener {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void onClick(View view) {
        this.a.a.post(new g(this, this.a.c.getWvUIModel()));
        this.a.a();
    }
}
