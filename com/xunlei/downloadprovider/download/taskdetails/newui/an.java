package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;
import com.xunlei.xllib.android.b;

/* compiled from: DownloadDetailsActivityFragment */
final class an extends BroadcastReceiver {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    an(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction()) != null && b.e(context) != null) {
            DownloadDetailsActivityFragment.q;
            DownloadDetailsActivityFragment.i(this.a);
        }
    }
}
