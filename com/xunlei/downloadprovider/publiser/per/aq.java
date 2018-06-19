package com.xunlei.downloadprovider.publiser.per;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: HistoryPublishItemFragment */
final class aq extends BroadcastReceiver {
    final /* synthetic */ HistoryPublishItemFragment a;

    aq(HistoryPublishItemFragment historyPublishItemFragment) {
        this.a = historyPublishItemFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("action_website_publish_success".equals(intent.getAction()) != null) {
            this.a.r.a(this.a.c, 0, new ar(this));
        }
    }
}
