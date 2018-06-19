package com.xunlei.downloadprovider.ad.common.adget;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.xunlei.downloadprovider.ad.common.c.b$a;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.ad.common.report.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WrapListener */
public final class v implements com.xunlei.downloadprovider.ad.common.h.a, com.xunlei.downloadprovider.ad.common.i.a {
    com.xunlei.downloadprovider.ad.common.h.a a;
    boolean b;
    l c;
    String d;
    com.xunlei.downloadprovider.ad.common.adget.j.a e;
    private i f;

    /* compiled from: WrapListener */
    private class a implements RequestListener<String, Bitmap> {
        final /* synthetic */ v a;
        private l b = null;
        private List<l> c = null;
        private b$a d = null;

        public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, boolean z, boolean z2) {
            Bitmap bitmap = (Bitmap) obj;
            this.d.a();
            j.a(this.b, this.d);
            if (this.a.b() != null) {
                return false;
            }
            this.b.t = bitmap;
            this.a.c();
            this.a.a.a(this.c);
            return false;
        }

        public a(v vVar, l lVar, List<l> list) {
            this.a = vVar;
            this.b = lVar;
            this.c = list;
            this.d = new b$a();
            this.d.a = System.currentTimeMillis();
        }

        public final /* synthetic */ boolean onException(Exception exception, Object obj, Target target, boolean z) {
            this.d.a();
            j.a(this.b, this.d, exception == null ? "null" : exception.getMessage());
            if (this.a.b() != null) {
                return false;
            }
            this.a.c();
            this.a.a.a(-7, "load bitmap fail");
            return false;
        }
    }

    public v(int i, com.xunlei.downloadprovider.ad.common.h.a aVar, boolean z) {
        this.a = aVar;
        if (i > 0) {
            this.f = new i(i);
            this.f.a(this);
            this.f.a();
        }
        this.b = z;
    }

    public final void a(List<l> list) {
        if (this.a != null && !b()) {
            if (list != null) {
                if (this.e != null) {
                    for (l lVar : list) {
                        if (!(lVar == null || lVar.i())) {
                            if (!TextUtils.isEmpty(this.e.g)) {
                                lVar.a(this.e.g);
                            }
                            if (!TextUtils.isEmpty(this.e.d)) {
                                lVar.w = k.a(this.e.d);
                            }
                            if (!TextUtils.isEmpty(this.e.f)) {
                                lVar.H = this.e.f;
                            }
                            if (!TextUtils.isEmpty(this.e.c)) {
                                lVar.x = k.a(this.e.c);
                            }
                            if (!TextUtils.isEmpty(this.e.e)) {
                                lVar.z = this.e.e;
                            }
                        }
                    }
                }
                l lVar2 = (l) list.get(0);
                if (lVar2 == null) {
                    c();
                    this.a.a(-5, "model is null");
                    return;
                } else if (!this.b) {
                    c();
                    this.a.a(list);
                    return;
                } else if (TextUtils.isEmpty(lVar2.l())) {
                    c();
                    this.a.a(-7, "imageUrl is empty");
                    return;
                } else {
                    Glide.with(com.xunlei.downloadprovider.ad.a.a()).load(lVar2.l()).asBitmap().listener(new a(this, lVar2, list)).into(Integer.MIN_VALUE, Integer.MIN_VALUE);
                    return;
                }
            }
            c();
            this.a.a(-5, "result is null");
        }
    }

    final boolean b() {
        return this.f != null && this.f.c;
    }

    final void c() {
        if (this.f != null) {
            this.f.d.cancel();
        }
    }

    public final void a(int i, String str) {
        if (this.a != null && !b()) {
            c();
            if (this.c != null) {
                a(a(this.c));
            } else {
                this.a.a(i, str);
            }
        }
    }

    private List<l> a(l lVar) {
        if (lVar == null) {
            return null;
        }
        List arrayList = new ArrayList();
        lVar.H = this.d;
        arrayList.add(lVar);
        return arrayList;
    }

    public final void g_() {
        if (this.c != null) {
            this.a.a(a(this.c));
        } else {
            this.a.a(-6, "Time out");
        }
    }
}
