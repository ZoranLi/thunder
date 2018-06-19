package com.xunlei.downloadprovider.download.create;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CreateUrlTaskActivity */
final class v implements OnClickListener {
    final /* synthetic */ CreateUrlTaskActivity a;

    v(CreateUrlTaskActivity createUrlTaskActivity) {
        this.a = createUrlTaskActivity;
    }

    public final void onClick(View view) {
        this.a.e.requestFocus();
        view = this.a.e.getText().toString().length();
        if (view != null && this.a.f) {
            this.a.f = false;
            this.a.e.setSelection(0, view);
        }
    }
}
