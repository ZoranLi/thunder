package com.xunlei.downloadprovider.player.xmp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;

/* compiled from: ThunderXmpPlayer */
final class t extends BroadcastReceiver {
    final /* synthetic */ ThunderXmpPlayer a;

    t(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("com.xunlei.action.ACTION_VOLUME_UP_KEY_DOWN".equals(intent.getAction()) != null) {
            this.a.d((boolean) null);
            if (this.a.n() != null) {
                ChoicenessReporter.a(this.a.n().d);
            }
        }
    }
}
