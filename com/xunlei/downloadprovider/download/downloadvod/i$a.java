package com.xunlei.downloadprovider.download.downloadvod;

import android.text.TextUtils;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.h.e;

/* compiled from: TaskBxbbPlaySource */
class i$a extends a$a {
    final /* synthetic */ i c;

    private i$a(i iVar) {
        this.c = iVar;
    }

    final void c() {
        i.j();
        a.getInstance().a(this.b, false);
    }

    public final void a() {
        this.a = true;
    }

    final void b() {
        if (!this.a) {
            if (i.a(this.c) != null) {
                String str = i.a(this.c).mLocalFileName;
                i.c(this.c);
                if (i.a(this.c).mIsLocalPlay && !TextUtils.isEmpty(i.a(this.c).mPlayUrl)) {
                    i.a(this.c, i.a(this.c).mPlayUrl);
                    this.c.a(i.d(this.c));
                    if (i.e(this.c) <= 1 || e.c(i.a(this.c).mPlayUrl)) {
                        i.j();
                        new StringBuilder("prepareBxbbPlayUrl, isLocalPlay, mPlayUrl : ").append(i.f(this.c));
                        i.a(new j(this));
                    }
                }
                int i = 0;
                i.a(this.c).mIsLocalPlay = false;
                n.a();
                Object c = n.c(str);
                if (TextUtils.isEmpty(c)) {
                    while (i < 15) {
                        i++;
                        if (!this.a) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (!this.a) {
                                if (i.g(this.c) == null) {
                                    i.a(new k(this));
                                    break;
                                }
                                if (!k.e(i.g(this.c))) {
                                    str = i.g(this.c).mLocalFileName;
                                } else if (i.h(this.c) != null) {
                                    str = i.h(this.c).mLocalFileName;
                                }
                                n.a();
                                c = n.c(str);
                                if (!TextUtils.isEmpty(c)) {
                                    i.j();
                                    break;
                                }
                                i.j();
                            } else {
                                break;
                            }
                        }
                        break;
                    }
                    if (TextUtils.isEmpty(c)) {
                        i.j();
                    }
                    i.a(this.c).mPlayUrl = c;
                    i.a(this.c).mLocalFileName = str;
                } else {
                    i.a(this.c).mPlayUrl = c;
                    i.j();
                }
                if (!this.a) {
                    i.b(this.c, i.a(this.c).mPlayUrl);
                    this.c.a(i.i(this.c));
                    i.a(new l(this));
                }
            } else if (i.b(this.c) != null) {
                i.j();
                i.b(this.c).a(this.c, "1");
            }
            c();
        }
    }
}
