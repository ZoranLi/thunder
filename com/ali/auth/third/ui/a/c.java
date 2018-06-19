package com.ali.auth.third.ui.a;

import android.text.TextUtils;

final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    c(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    public final void run() {
        String format;
        if (TextUtils.isEmpty(this.a)) {
            format = String.format("javascript:window.HavanaBridge.onFailure(%s,'');", new Object[]{Integer.valueOf(this.b.b)});
        } else {
            format = String.format("javascript:window.HavanaBridge.onFailure(%s,'%s');", new Object[]{Integer.valueOf(this.b.b), this.a.replace("\\", "\\\\")});
        }
        b.a(this.b, format);
    }
}
