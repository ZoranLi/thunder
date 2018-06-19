package com.xunlei.downloadprovider.player.xmp;

import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.broadcast.b;

/* compiled from: ThunderXmpPlayer */
final class u extends b {
    final /* synthetic */ ThunderXmpPlayer a;

    u(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
    }

    public final void c(Context context, Intent intent) {
        super.c(context, intent);
        new StringBuilder("onReceiveScreenOff--").append(this.a);
        this.a.K = true;
        this.a.a(false, false);
    }

    public final void b(Context context, Intent intent) {
        super.b(context, intent);
        new StringBuilder("onReceiveScreenOn--").append(this.a);
        this.a.K = null;
    }
}
