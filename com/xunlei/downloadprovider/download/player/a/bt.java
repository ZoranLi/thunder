package com.xunlei.downloadprovider.download.player.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: VipAccelerateTryController */
final class bt extends BroadcastReceiver {
    final /* synthetic */ bn a;

    bt(bn bnVar) {
        this.a = bnVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (TextUtils.isEmpty(intent.getAction()) == null) {
                if (TextUtils.equals("ACTION_PLAYERVIEW_PROGRESS_BAR_StopTrackingTouch", intent.getAction()) != null) {
                    this.a.j = true;
                }
            }
        }
    }
}
