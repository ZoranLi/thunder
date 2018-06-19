package com.xunlei.downloadprovider.vodnew.a.e;

import com.xunlei.downloadprovider.download.downloadvod.i;

/* compiled from: PlayerStateRelease */
final class m extends a {
    private static final String c;

    public final int a() {
        return 0;
    }

    public final String b() {
        return "PLAYER_STATE_RELEASED";
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m.class.getSimpleName());
        stringBuilder.append(" ");
        c = stringBuilder.toString();
    }

    public m(o oVar) {
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
        stringBuilder.append("pauseWithUI");
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
    }

    public final void g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("reset");
    }

    public final void h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("release");
    }
}
