package com.xunlei.downloadprovider.player.xmp;

import android.os.Handler;

/* compiled from: PlayerPositionLooper */
public final class m extends aj {
    XmpMediaPlayer a;
    a b;
    boolean c;
    int d;
    Handler e = new n(this);

    /* compiled from: PlayerPositionLooper */
    public interface a {
        void a(int i);

        void a(int i, boolean z);
    }

    m(XmpMediaPlayer xmpMediaPlayer) {
        this.a = xmpMediaPlayer;
    }

    final void s_() {
        if (this.e.hasMessages(2)) {
            this.e.removeMessages(2);
        }
    }

    final void d() {
        if (!this.c) {
            e();
            this.e.sendEmptyMessageDelayed(3, 500);
        }
    }

    final void e() {
        if (this.e.hasMessages(3)) {
            this.e.removeMessages(3);
        }
    }

    public final void a(String str) {
        super.a(str);
        s_();
        e();
    }

    public final void f() {
        super.f();
        s_();
        e();
    }

    public final void a() {
        super.a();
        s_();
        e();
        if (this.a != null) {
            int c = this.a.c();
            if (this.b != null) {
                this.b.a(c);
            }
        }
    }

    public final void b() {
        super.b();
        this.c = false;
    }

    public final void a(int i, int i2) {
        super.a(i, i2);
        if (i == 0) {
            s_();
            e();
        } else if (i != 4) {
            s_();
        } else {
            s_();
            this.e.sendEmptyMessageDelayed(2, 500);
            d();
        }
    }
}
