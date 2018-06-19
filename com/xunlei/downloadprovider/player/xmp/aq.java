package com.xunlei.downloadprovider.player.xmp;

import com.xunlei.android.shortvideo.ShortVideoInterface;
import com.xunlei.android.shortvideo.ShortVideoInterface.PlayerEvent;
import com.xunlei.android.shortvideo.ShortVideoTask.STATUS;

/* compiled from: XmpPlayerManager */
final class aq implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ STATUS b;
    final /* synthetic */ int c;
    final /* synthetic */ ap d;

    aq(ap apVar, String str, STATUS status, int i) {
        this.d = apVar;
        this.a = str;
        this.b = status;
        this.c = i;
    }

    public final void run() {
        ShortVideoInterface.a().a(PlayerEvent.PLAYER_CALL_START);
        if (this.d.a != null) {
            this.d.a.a(this.a, this.b, this.c);
        }
    }
}
