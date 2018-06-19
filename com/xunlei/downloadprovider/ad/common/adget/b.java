package com.xunlei.downloadprovider.ad.common.adget;

import android.text.TextUtils;
import android.view.View;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: ADGetModel */
public final class b extends l {
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public float f;
    public String g;
    public String h;
    public int i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o = "";
    public String p;
    public boolean q;
    public int r = 0;

    public final int d() {
        return 4;
    }

    public final String a() {
        return TextUtils.isEmpty(this.l) ? y() : this.l;
    }

    public final String b() {
        return this.j;
    }

    public b(String str) {
        this.s = str;
    }

    public final AD_SYSTEM_TYPE c() {
        return AD_SYSTEM_TYPE.SOURCE_XUNLEI_FLAG;
    }

    public final String e() {
        return TextUtils.isEmpty(this.k) ? y() : this.k;
    }

    public final void a(float f) {
        this.f = f;
        super.a(f);
    }

    public final void onClick(View view) {
        super.onClick(view);
        if (this.i == 0) {
            a(view.getContext(), s(), j());
            return;
        }
        if (this.i == 5) {
            view = view.getContext();
            if (!a(view, s())) {
                a(view, t(), j());
            }
        }
    }

    public final void f() {
        if (P()) {
            String str;
            String str2 = this.H;
            String A = A();
            if (this.v == null) {
                str = "";
            } else {
                str = this.v.mStyleId;
            }
            o.a(this, str2, A, str);
        }
    }

    public final void g() {
        if (P()) {
            String str;
            String str2 = this.H;
            String A = A();
            if (this.v == null) {
                str = "";
            } else {
                str = this.v.mStyleId;
            }
            o.b(this, str2, A, str);
        }
    }

    private boolean P() {
        return !"ssp".equals(y());
    }

    public final void h() {
        super.h();
    }

    public final boolean i() {
        return this.q;
    }

    public final String j() {
        return this.a;
    }

    public final String k() {
        return this.c;
    }

    public final String l() {
        return this.d;
    }

    public final String m() {
        return this.b;
    }

    public final long n() {
        return this.e;
    }

    public final String o() {
        return this.n;
    }

    public final String p() {
        return this.m;
    }

    public final float q() {
        if (this.f < 1.0f) {
            this.f = f.b();
        }
        a(this.f);
        return this.f;
    }

    public final String r() {
        return this.o;
    }

    public final String s() {
        return this.g;
    }

    public final String t() {
        return this.h;
    }

    public final int u() {
        return this.i;
    }

    public final int v() {
        return this.r;
    }

    public final boolean w() {
        return this.i == 2;
    }

    public final String x() {
        return this.p;
    }
}
