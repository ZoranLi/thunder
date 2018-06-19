package com.xunlei.downloadprovider.vodnew.a.e;

import com.xunlei.downloadprovider.download.downloadvod.i;

/* compiled from: PlayerStateError */
final class c extends a {
    private static final String c;

    public final int a() {
        return 6;
    }

    public final String b() {
        return "PLAYER_STATE_ERROR";
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c.class.getSimpleName());
        stringBuilder.append(" ");
        c = stringBuilder.toString();
    }

    public c(o oVar) {
        super(oVar);
    }

    public final void a(i iVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("setDataSource : ");
        stringBuilder.append(iVar);
    }

    public final void c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("prepareAsync");
    }

    public final void d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("start");
    }

    public final void e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("pause");
    }

    public final void a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("seekTo, msec : ");
        stringBuilder.append(i);
    }

    public final void f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("stop");
        this.b.r = false;
        this.b.s = false;
        this.b.D();
    }

    public final void g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("reset");
        this.b.r = false;
        this.b.s = false;
        this.b.E();
    }

    public final void h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("release");
        this.b.r = false;
        this.b.s = false;
        this.b.F();
    }
}
