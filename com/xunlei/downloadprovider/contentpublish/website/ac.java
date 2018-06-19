package com.xunlei.downloadprovider.contentpublish.website;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: WebsiteDetailFragment */
final class ac extends BroadcastReceiver {
    final /* synthetic */ WebsiteDetailFragment a;

    ac(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        context = intent.getAction();
        if ("new_follow".equals(context) != null || "cancel_follow".equals(context) != null || "new_user_login_success".equals(context) != null || "user_logout".equals(context) != null) {
            this.a.a();
        }
    }
}
