package com.xunlei.downloadprovider.publiser.per;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: PublisherActivity */
final class bx extends BroadcastReceiver {
    final /* synthetic */ PublisherActivity a;

    bx(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        new StringBuilder("onReceive() action=").append(intent.getAction());
        context = intent.getAction();
        if ("new_follow".equals(context) == null && "cancel_follow".equals(context) == null && "new_user_login_success".equals(context) == null && "user_logout".equals(context) == null) {
            if ("following_id_list_loaded".equals(context) == null) {
                "action_start_follow_guide_animation".equals(context);
                return;
            }
        }
        this.a.a(this.a.P.b(this.a.k));
    }
}
