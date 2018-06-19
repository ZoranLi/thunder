package com.xunlei.downloadprovider.member.payment.activity;

import android.text.TextUtils;
import com.xunlei.downloadprovider.d.d;
import java.util.List;

/* compiled from: IActivityImpl */
class n implements e {
    protected a a;

    protected boolean f() {
        return true;
    }

    n() {
    }

    public final boolean a() {
        if (this.a != null) {
            if (this.a.a()) {
                if (!TextUtils.isEmpty(this.a.c) && !d.a().h.d(this.a.c)) {
                    this.a = null;
                    return false;
                } else if (!f()) {
                    return false;
                } else {
                    if (com.xunlei.xllib.b.d.a(this.a.f)) {
                        return true;
                    }
                    for (List a : this.a.f) {
                        if (LimitCondition.a(a)) {
                            return true;
                        }
                    }
                    this.a = null;
                    return false;
                }
            }
        }
        this.a = null;
        return false;
    }

    public final void a(a aVar) {
        this.a = aVar;
    }

    public final b a(int i, int i2) {
        if (this.a == null) {
            return null;
        }
        i = this.a.a(i);
        if (i != 0) {
            if (i.size() > 0) {
                return (b) i.get(i2);
            }
        }
        return null;
    }

    public final int b() {
        if (this.a == null) {
            return -1;
        }
        return this.a.e;
    }

    public final String c() {
        if (this.a == null) {
            return "";
        }
        return this.a.a;
    }

    public final String d() {
        if (this.a == null) {
            return "";
        }
        return this.a.d;
    }

    public final int e() {
        if (this.a == null) {
            return Integer.MAX_VALUE;
        }
        return this.a.b;
    }
}
