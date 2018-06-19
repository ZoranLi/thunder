package com.xunlei.downloadprovider.vodnew.a.e;

import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.downloadprovider.vodnew.a.d.a.c;

/* compiled from: PlayerStateInitialized */
final class e extends a {
    private static final String c;
    private c d = new f(this);

    public final int a() {
        return 4;
    }

    public final String b() {
        return "PLAYER_STATE_INITIALIZED";
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.class.getSimpleName());
        stringBuilder.append(" ");
        c = stringBuilder.toString();
    }

    public e(o oVar) {
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
        if (this.b.s) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(c);
            stringBuilder.append("正在close中，等close完毕后再prepare，后面一定要有 close完毕回调重新prepare");
            this.b.a.a(this.b.t);
            return;
        }
        this.b.c.a(new h(this));
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
        this.b.c.h();
        v.a().b = null;
        this.b.a.b(this.d);
        this.b.a.b(this.b.t);
        this.b.C();
    }

    public final void g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("reset");
        f();
        this.b.c(1);
    }

    public final void h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("release");
        f();
        this.b.F();
    }
}
