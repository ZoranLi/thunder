package com.xunlei.downloadprovider.player.xmp;

import com.xunlei.downloadprovider.player.xmp.b.g.a;

/* compiled from: XmpPlayerManager */
final class an implements a<Integer, ThunderXmpPlayer> {
    final /* synthetic */ ak a;

    an(ak akVar) {
        this.a = akVar;
    }

    public final /* synthetic */ void a(boolean z, Object obj, Object obj2, Object obj3) {
        Integer num = (Integer) obj;
        ThunderXmpPlayer thunderXmpPlayer = (ThunderXmpPlayer) obj2;
        ThunderXmpPlayer thunderXmpPlayer2 = (ThunderXmpPlayer) obj3;
        StringBuilder stringBuilder = new StringBuilder("onEntryRemoved--evicted=");
        stringBuilder.append(z);
        stringBuilder.append("|key=");
        stringBuilder.append(num);
        stringBuilder.append("|oldValue=");
        stringBuilder.append(thunderXmpPlayer);
        stringBuilder.append("|newValue=");
        stringBuilder.append(thunderXmpPlayer2);
        if (z && thunderXmpPlayer != null) {
            thunderXmpPlayer.q();
        }
    }
}
