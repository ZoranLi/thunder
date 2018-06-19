package com.xunlei.downloadprovider.member.payment.activity;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.payment.b.b;

/* compiled from: IActivityConfigImpl */
final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ g b;

    k(g gVar, String str) {
        this.b = gVar;
        this.a = str;
    }

    public final void run() {
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        Object obj = this.a;
        if (applicationInstance != null) {
            if (!TextUtils.isEmpty(obj)) {
                Glide.with(applicationInstance).load(obj).listener(new b()).preload();
            }
        }
    }
}
