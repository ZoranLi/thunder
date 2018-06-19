package com.xunlei.downloadprovider.download.player.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.vod.speedplayback.d;

/* compiled from: VipAccelerateTryController */
final class bp extends BroadcastReceiver {
    final /* synthetic */ bn a;

    bp(bn bnVar) {
        this.a = bnVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (TextUtils.isEmpty(intent.getAction()) == null) {
                if (!(TextUtils.equals("DownloadVodPlayerController.ACTION_PLAY_COMPLETION", intent.getAction()) == null || j.a().a.l() == null || this.a.f() == null)) {
                    this.a.f().a(104, String.valueOf(d.a(this.a.l.c)));
                }
            }
        }
    }
}
