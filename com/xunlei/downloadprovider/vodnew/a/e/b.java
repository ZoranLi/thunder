package com.xunlei.downloadprovider.vodnew.a.e;

import com.xunlei.downloadprovider.download.downloadvod.i;

/* compiled from: PlayerStateComplete */
final class b extends a {
    private static final String c;

    public final int a() {
        return 7;
    }

    public final String b() {
        return "PLAYER_STATE_COMPLETE";
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.class.getSimpleName());
        stringBuilder.append(" ");
        c = stringBuilder.toString();
    }

    public b(o oVar) {
        super(oVar);
    }

    public final void a(i iVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("setDataSource : ");
        stringBuilder.append(iVar);
    }

    public final void c() throws IllegalStateException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("prepareAsync");
    }

    public final void d() throws IllegalStateException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("start");
        this.b.r = false;
        this.b.s = false;
        this.b.a();
    }

    public final void e() throws IllegalStateException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("pause");
    }

    public final void a(int i) throws IllegalStateException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("seekTo, msec : ");
        stringBuilder.append(i);
    }

    public final void f() throws IllegalStateException {
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
