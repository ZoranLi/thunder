package com.xunlei.downloadprovider.contentpublish.website;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: WebsiteDetailFragment */
final class r extends BroadcastReceiver {
    final /* synthetic */ WebsiteDetailFragment a;

    r(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("action_comment_zan_state_changed".contentEquals(intent.getAction()) != null) {
            context = WebsiteDetailFragment.a;
            WebsiteDetailFragment.a(this.a, intent);
        }
    }
}
