package com.xunlei.downloadprovider.player.xmp;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.OrientationEventListener;
import com.umeng.message.proguard.k;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer.ContainerType;

/* compiled from: PlayerFullScreenHelper */
public final class g {
    ThunderXmpPlayer a;
    public boolean b;
    boolean c;
    b d;
    long e;
    OrientationEventListener f;
    boolean g;
    int h = 1;
    boolean i = false;
    boolean j = false;
    boolean k = false;
    public boolean l = true;
    aj m = new i(this);

    public g(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
        thunderXmpPlayer.a(this.m);
    }

    public final void a(boolean z) {
        if (this.a != null) {
            StringBuilder stringBuilder = new StringBuilder("enableOrientationListener(");
            stringBuilder.append(z);
            stringBuilder.append(k.t);
            if (this.f == null && this.a != null) {
                this.f = new h(this, this.a.d);
            }
            if (z) {
                this.f.enable();
            } else {
                this.f.disable();
            }
        }
    }

    final void b(boolean z) {
        if ((!this.b || this.c != z) && this.a != null) {
            BaseActivity baseActivity = this.a.e;
            if (baseActivity != null) {
                if (baseActivity.b) {
                    boolean z2 = true;
                    this.b = true;
                    this.e = SystemClock.elapsedRealtime();
                    int i = 0;
                    if (!this.a.j()) {
                        if (this.i) {
                            z2 = false;
                        }
                    }
                    if (this.a != null) {
                        BaseActivity baseActivity2 = this.a.e;
                        if (baseActivity2 != null) {
                            int systemUiVisibility = baseActivity2.getWindow().getDecorView().getSystemUiVisibility() | 2;
                            if (VERSION.SDK_INT >= 16) {
                                systemUiVisibility |= 4;
                            }
                            if (VERSION.SDK_INT >= 19) {
                                systemUiVisibility |= 4096;
                            }
                            baseActivity2.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
                        }
                    }
                    if (z2) {
                        if (z) {
                            i = 8;
                        }
                        baseActivity.setRequestedOrientation(i);
                        this.c = z;
                    }
                    baseActivity.getWindow().addFlags(1024);
                    PlayerContainer d = d();
                    PlayerContainer e = e();
                    if (d == true && d != e) {
                        this.a.a(ContainerType.FULL_SCREEN, d);
                    }
                    this.a.l.b(this.b);
                    if (this.d) {
                        this.d.a();
                    }
                }
            }
        }
    }

    final void a() {
        if (this.b) {
            if (this.a != null) {
                BaseActivity baseActivity = this.a.e;
                if (baseActivity != null) {
                    this.b = false;
                    this.k = false;
                    this.e = SystemClock.elapsedRealtime();
                    baseActivity.setRequestedOrientation(1);
                    baseActivity.getWindow().clearFlags(1024);
                    if (this.a != null) {
                        baseActivity = this.a.e;
                        if (baseActivity != null) {
                            int systemUiVisibility = baseActivity.getWindow().getDecorView().getSystemUiVisibility() & -3;
                            if (VERSION.SDK_INT >= 16) {
                                systemUiVisibility &= -5;
                            }
                            if (VERSION.SDK_INT >= 19) {
                                systemUiVisibility &= -4097;
                            }
                            baseActivity.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
                        }
                    }
                    PlayerContainer d = d();
                    PlayerContainer e = e();
                    if (!(d == null || d == e)) {
                        this.a.a(ContainerType.NORMAL, e);
                    }
                    this.a.l.b(this.b);
                    if (this.d != null) {
                        this.d.b();
                    }
                }
            }
        }
    }

    public final void b() {
        if (this.a != null) {
            if (this.b) {
                c();
                return;
            }
            if (this.a != null) {
                this.k = this.a.j() ^ true;
                this.j = false;
                this.i = true;
                b(false);
            }
        }
    }

    public final void c() {
        if (this.a != null) {
            a(true);
            this.j = true;
            this.i = false;
            a();
        }
    }

    private PlayerContainer d() {
        return this.a.a(ContainerType.FULL_SCREEN);
    }

    private PlayerContainer e() {
        return this.a.a(ContainerType.NORMAL);
    }
}
