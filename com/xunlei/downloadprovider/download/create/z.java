package com.xunlei.downloadprovider.download.create;

import android.text.TextUtils;

/* compiled from: CreateUrlTaskActivity */
final class z implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ y b;

    z(y yVar, String str) {
        this.b = yVar;
        this.a = str;
    }

    public final void run() {
        this.b.a.m = true;
        if (TextUtils.isEmpty(this.b.a.e.getText().toString())) {
            this.b.a.e.setText(this.a);
            this.b.a.e.setSelection(this.a.length());
        }
    }
}
