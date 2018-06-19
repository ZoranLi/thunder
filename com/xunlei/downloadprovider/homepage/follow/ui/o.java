package com.xunlei.downloadprovider.homepage.follow.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: FollowTabFragment */
final class o extends BroadcastReceiver {
    final /* synthetic */ FollowTabFragment a;

    o(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.j != null) {
            if (this.a.b != null) {
                context = intent.getAction();
                if ("new_user_login_success".equals(context) != null) {
                    this.a.a(2);
                    this.a.e.c();
                    context = this.a.j;
                    context.j = context.e.b();
                    this.a.c.d();
                    return;
                }
                if ("user_logout".equals(context) != null) {
                    this.a.j.b();
                    this.a.a(1);
                    this.a.d();
                    this.a.e.c();
                }
            }
        }
    }
}
