package com.xunlei.downloadprovider.pushmessage.c;

import android.view.View;
import android.widget.TextView;

/* compiled from: NotificationsUtils */
final class d implements c$a {
    d() {
    }

    public final void a(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if ("DUMMY_TITLE".equals(textView.getText().toString())) {
                c.a(textView.getCurrentTextColor());
            }
        }
    }
}
