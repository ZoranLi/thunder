package com.xunlei.downloadprovider.download.create;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* compiled from: CreateUrlTaskActivity */
final class w implements OnKeyListener {
    final /* synthetic */ CreateUrlTaskActivity a;

    w(CreateUrlTaskActivity createUrlTaskActivity) {
        this.a = createUrlTaskActivity;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66 && keyEvent.getAction() == 1 && this.a.d.isEnabled() != null) {
            CreateUrlTaskActivity.a(this.a);
        }
        return null;
    }
}
