package com.xunlei.downloadprovider.player.xmp;

import android.os.Handler;
import android.os.Looper;
import com.aplayer.aplayerandroid.APlayerAndroid;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.util.ArrayList;

public final class XmpMediaPlayer {
    public APlayerAndroid a = new APlayerAndroid();
    m b;
    ArrayList<aj> c = new ArrayList();
    String d;
    public boolean e;
    public boolean f;
    boolean g;
    Handler h = new z(this, Looper.getMainLooper());

    public enum BufferingState {
        START,
        BUFFERING,
        END
    }

    XmpMediaPlayer() {
        APlayerAndroid aPlayerAndroid = this.a;
        if ((BrothersApplication.getApplicationInstance().getApplicationInfo().flags & 2) != 0) {
            aPlayerAndroid.openLog(true);
        } else {
            aPlayerAndroid.openLog(false);
        }
        aPlayerAndroid.setOnOpenSuccessListener(new ab(this));
        aPlayerAndroid.setOnPlayCompleteListener(new ac(this));
        aPlayerAndroid.setOnPlayStateChangeListener(new ad(this));
        aPlayerAndroid.setOnSeekCompleteListener(new ae(this));
        aPlayerAndroid.setOnBufferListener(new af(this));
        aPlayerAndroid.setOnShowSubtitleListener(new ag(this));
        aPlayerAndroid.setOnReCreateHwDecoderListener(new ah(this));
        aPlayerAndroid.setOnFirstFrameRenderListener(new ai(this));
        this.b = new m(this);
        this.b.b = new aa(this);
        a(this.b);
    }

    final void a() {
        if (this.h.hasMessages(1)) {
            this.h.removeMessages(1);
        }
    }

    final void b() {
        this.e = false;
        this.f = false;
        this.g = false;
    }

    public final void a(boolean z) {
        this.a.pause();
        if (z) {
            b(true);
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.b.e();
        } else if (this.e) {
            this.b.d();
        }
        this.a.stopRead(z);
    }

    public final int c() {
        int duration = this.a.getDuration();
        return duration < 0 ? 0 : duration;
    }

    public final void a(aj ajVar) {
        if (!(ajVar == null || this.c.contains(ajVar))) {
            this.c.add(ajVar);
        }
    }

    public final void c(boolean z) {
        if (z) {
            this.a.setConfig(420, "1");
        } else {
            this.a.setConfig(420, "0");
        }
    }

    public final void a(int i, String str) {
        this.a.setConfig(i, str);
    }
}
