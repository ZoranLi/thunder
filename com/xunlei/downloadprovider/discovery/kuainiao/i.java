package com.xunlei.downloadprovider.discovery.kuainiao;

import android.app.Activity;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;

/* compiled from: KuaiNiaoUtil */
public final class i extends c {
    final /* synthetic */ Activity a;
    final /* synthetic */ PayFrom b;

    public i(Activity activity, PayFrom payFrom) {
        this.a = activity;
        this.b = payFrom;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (i == 0) {
            h.a(this.a, this.b);
        }
    }
}
