package com.xunlei.downloadprovider.contentpublish.website;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: WebsiteEditActivity */
final class ao extends BroadcastReceiver {
    final /* synthetic */ WebsiteEditActivity a;

    ao(WebsiteEditActivity websiteEditActivity) {
        this.a = websiteEditActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("action_website_publish_success".equals(intent.getAction()) != null) {
            this.a.finish();
        }
    }
}
