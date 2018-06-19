package com.xunlei.downloadprovider.homepage.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.b.a;

/* compiled from: DownloadTabFragment */
final class r extends BroadcastReceiver {
    final /* synthetic */ DownloadTabFragment a;

    r(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("ACTION_EXIT_PLAYER".equals(intent.getAction()) != null) {
            a.a(this.a.getContext(), intent.getLongExtra("EXTRA_STAY_TIME", 0));
        }
    }
}
