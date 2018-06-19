package com.xunlei.downloadprovider.vodnew.a.e;

import com.xunlei.downloadprovider.vodnew.a.d.a.c;

/* compiled from: PlayerStateInitialized */
final class f implements c {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void a(boolean z) {
        String str = a.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.c);
        stringBuilder.append("OnOpenComplete回调, success : ");
        stringBuilder.append(z);
        this.a.b.a.b((c) this);
        if (z) {
            this.a.b.f = this.a.b.a.g();
            this.a.b.g = this.a.b.a.i();
            this.a.b.h = this.a.b.a.j();
            z = a.a;
            z = new StringBuilder("VideoDuration : ");
            z.append(this.a.b.f);
            z.append(" VideoWidth : ");
            z.append(this.a.b.g);
            z.append(" VideoHeight : ");
            z.append(this.a.b.h);
            if (this.a.b.d) {
                z = a.a;
                z = new StringBuilder();
                z.append(e.c);
                z.append("打开播放器成功，有历史记录");
                long j = this.a.b.d.h;
                z = a.a;
                z = new StringBuilder();
                z.append(e.c);
                z.append("lastPlayPosition（秒）: ");
                z.append(j / 1000);
                z = a.a;
                z = new StringBuilder();
                z.append(e.c);
                z.append("duration（秒）: ");
                z.append(this.a.b.a.g() / 1000);
                if (j <= 0 || j >= ((long) (this.a.b.a.g() - 1000))) {
                    z = a.a;
                    z = new StringBuilder();
                    z.append(e.c);
                    z.append("从0开始播放");
                } else {
                    this.a.b.a.a((int) j);
                    z = a.a;
                    z = new StringBuilder();
                    z.append(e.c);
                    z.append("前往到位置：");
                    z.append(j);
                }
            } else {
                z = a.a;
                z = new StringBuilder();
                z.append(e.c);
                z.append("打开播放器成功，没有历史记录，从0播放");
            }
            this.a.b.c(5);
            if (this.a.b.i) {
                this.a.b.i.a(this.a.b);
            }
            if (this.a.b.m) {
                this.a.b.m.a(this.a.b, this.a.b.a.i(), this.a.b.a.j(), this.a.b.a.g());
            }
            if (this.a.b.b) {
                this.a.b.b.postDelayed(new g(this), 50);
                return;
            }
        }
        z = a.a;
        z = new StringBuilder();
        z.append(e.c);
        z.append("onOpenComplete返回出错");
        if (this.a.b.b()) {
            z = a.a;
            z = new StringBuilder();
            z.append(e.c);
            z.append("错误原因： ");
            z.append(this.a.b.b().e);
        }
        this.a.b.c(6);
        if (this.a.b.n) {
            this.a.b.n.a(this.a.b, 1, 0);
        }
    }
}
