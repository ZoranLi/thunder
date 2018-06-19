package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DownloadDetailsActivityFragment */
final class aq extends BroadcastReceiver {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    aq(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "ACTION_SHOW_SHARE_DIALOG".equals(intent.getAction()) != null) {
            this.a.c();
        }
    }
}
