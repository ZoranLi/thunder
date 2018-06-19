package com.xunlei.downloadprovider.player.xmp;

import android.os.SystemClock;
import com.xunlei.downloadprovider.player.xmp.XmpMediaPlayer.BufferingState;

/* compiled from: PlayInfo */
public final class e {
    boolean a;
    y b;
    int c;
    long d;
    public int e;
    private long f;
    private BufferingState g;

    e(y yVar) {
        this.b = yVar;
    }

    public final void a() {
        this.e++;
        if (this.b != null) {
            y yVar = this.b;
            yVar.u++;
        }
    }

    public final int b() {
        if (this.b != null) {
            return this.b.u;
        }
        return this.e;
    }

    public final void a(BufferingState bufferingState) {
        new StringBuilder("PlayInfo--onBufferStateChange--").append(bufferingState);
        if (bufferingState == BufferingState.START) {
            this.g = BufferingState.START;
            this.f = SystemClock.elapsedRealtime();
            this.c++;
            return;
        }
        if (bufferingState == BufferingState.END && this.g == BufferingState.START) {
            this.d += SystemClock.elapsedRealtime() - this.f;
            this.g = null;
        }
    }
}
