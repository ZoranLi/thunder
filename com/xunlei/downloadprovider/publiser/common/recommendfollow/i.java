package com.xunlei.downloadprovider.publiser.common.recommendfollow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: FollowRecommendPopWindow */
final class i extends BroadcastReceiver {
    final /* synthetic */ e a;

    i(e eVar) {
        this.a = eVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.k.isFinishing() == null) {
            if (VERSION.SDK_INT < 17 || this.a.k.isDestroyed() == null) {
                context = intent.getAction();
                if (!("new_follow".equals(context) == null && "cancel_follow".equals(context) == null && "new_user_login_success".equals(context) == null && "user_logout".equals(context) == null)) {
                    this.a.b();
                }
            }
        }
    }
}
