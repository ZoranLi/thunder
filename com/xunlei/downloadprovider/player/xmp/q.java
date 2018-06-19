package com.xunlei.downloadprovider.player.xmp;

import android.os.Message;
import com.xunlei.androidvip.XLAndroidVipManager;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.player.xmp.XmpMediaPlayer.BufferingState;
import com.xunlei.downloadprovider.player.xmp.b.a;

/* compiled from: ThunderXmpPlayer */
final class q extends aj {
    final /* synthetic */ XmpMediaPlayer a;
    final /* synthetic */ ThunderXmpPlayer b;

    q(ThunderXmpPlayer thunderXmpPlayer, XmpMediaPlayer xmpMediaPlayer) {
        this.b = thunderXmpPlayer;
        this.a = xmpMediaPlayer;
    }

    public final void a(BufferingState bufferingState, int i) {
        super.a(bufferingState, i);
        if (this.b.i != 0) {
            this.b.i.a(bufferingState);
        }
    }

    public final void c() {
        super.c();
        new StringBuilder("onReCreateHwDecoder--").append(this.b);
        if (this.b.p) {
            this.b.f.c(true);
        }
        if (this.b.K || this.b.E) {
            this.a.a(false);
        }
        if (this.b.l()) {
            a.a();
        }
    }

    public final void a() {
        new StringBuilder("onCompletion--").append(this.b);
        this.b.a("0", "");
    }

    public final void a(String str) {
        super.a(str);
        StringBuilder stringBuilder = new StringBuilder("onError--errorCode=");
        stringBuilder.append(str);
        stringBuilder.append("|");
        stringBuilder.append(this.b);
        this.b.a("2", str);
    }

    public final void b(int i, int i2) {
        super.b(i, i2);
        new StringBuilder("onVideoSizeChanged--").append(this.b);
        this.b.j = i;
        this.b.k = i2;
        ThunderXmpPlayer.a(this.b, this.b.B, this.b.C, i, i2);
        if (this.b.m != null) {
            this.b.m.onVideoSizeChanged(null, i, i2);
        }
    }

    public final void b() {
        super.b();
        new StringBuilder("onOpenSuccess--").append(this.b);
        if (this.b.i != null) {
            y yVar = this.b.i.b;
            if (this.b.y) {
                j n = this.b.M;
                int c = this.b.f.c();
                boolean z = yVar.q;
                String m = this.b.o;
                if (!z) {
                    if (j.e == 0) {
                        n.a(m, n.b);
                    } else if (n.b > 0) {
                        if (j.e % ((long) n.b) == 0) {
                            if (c > XLAndroidVipManager.XL_JNI_ERROR) {
                                c = n.b;
                                Message obtain = Message.obtain();
                                obtain.arg1 = c;
                                obtain.what = 1;
                                obtain.obj = m;
                                n.d.sendMessageDelayed(obtain, 5000);
                            }
                        }
                    }
                    j.e++;
                    f.a(n.a, "short_video_play_count", j.e);
                }
            }
            this.b.c(yVar.g);
            if (yVar.i > 0 && Math.abs(yVar.i - this.b.f.c()) > 1000) {
                this.b.a(yVar.i);
            }
        }
        ThunderXmpPlayer.o(this.b);
    }

    public final void a(int i) {
        super.a(i);
        if (this.b.i != 0 && this.b.i.a == 0) {
            this.b.o();
        }
    }

    public final void a(int i, int i2) {
        super.a(i, i2);
        i2 = new StringBuilder("onPlayStateChange--currentState=");
        i2.append(i);
        i2.append(this.b);
        if (i != 4) {
            this.b.A.setKeepScreenOn(false);
            return;
        }
        i = new StringBuilder("onPlayStateChange--currentTopActivity=");
        i.append(AppStatusChgObserver.b().c());
        i.append("|mActivity=");
        i.append(this.b.e);
        if (AppStatusChgObserver.b().c() != this.b.e) {
            this.a.a(false);
        }
        this.b.A.setKeepScreenOn(1);
    }

    public final void f() {
        super.f();
        new StringBuilder("onPlayClosed---").append(this.b);
        this.b.a("1", "");
        if (this.b.F && this.b.n() != null) {
            this.b.b(this.b.n());
        }
        this.b.F = false;
    }
}
