package com.xunlei.downloadprovider.publiser.common.guide.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.publiser.common.guide.a.a.a;
import com.xunlei.downloadprovider.publiser.common.guide.b.g;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: BusinessGroup */
public final class b extends a {
    private List<a> c;
    private a d;
    private boolean e;

    private static int a(int i) {
        return i <= 0 ? 600 : i;
    }

    public final int f() {
        return 10;
    }

    public b() {
        this.c = null;
        this.d = null;
        this.e = false;
        this.c = new ArrayList();
    }

    public final void a(a aVar) {
        this.c.add(aVar);
    }

    public final void a(g gVar) {
        for (a a : this.c) {
            a.a(gVar);
        }
    }

    public final void a(Context context) {
        new StringBuilder("handle, mShouldHandledBusiness != null: ").append(this.d != null);
        if (this.d != null) {
            this.d.a(context);
        }
    }

    public final boolean b() {
        for (a b : this.c) {
            if (b.b()) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i, a aVar) {
        i = b(a(i), aVar);
        i.a();
        LinkedList linkedList = new LinkedList();
        i = a(aVar, i, linkedList);
        for (a aVar2 : this.c) {
            if (aVar2.b()) {
                linkedList.add(Integer.valueOf(1000));
                aVar2.a(-1, i);
            }
        }
    }

    public final boolean c() {
        for (a c : this.c) {
            if (c.c()) {
                return true;
            }
        }
        return false;
    }

    public final void a(a aVar) {
        i b = b(a(-1), aVar);
        b.a();
        LinkedList linkedList = new LinkedList();
        aVar = a(aVar, b, linkedList);
        for (a aVar2 : this.c) {
            if (aVar2.c()) {
                linkedList.add(Integer.valueOf(1000));
                aVar2.a(aVar);
            }
        }
    }

    public final boolean d() {
        for (a d : this.c) {
            if (d.d()) {
                return true;
            }
        }
        return false;
    }

    public final void e() {
        if (this.d != null) {
            this.d.e();
        }
    }

    public final Object g() {
        return this.d != null ? this.d.g() : null;
    }

    @NonNull
    private a a(@Nullable a aVar, i iVar, LinkedList<Integer> linkedList) {
        return new c(this, iVar, linkedList, aVar);
    }

    @NonNull
    private i b(int i, @Nullable a aVar) {
        i iVar = new i(i);
        iVar.a(new d(this, aVar));
        return iVar;
    }

    public final boolean a() {
        if (!this.e) {
            this.e = true;
            a aVar = null;
            for (a aVar2 : this.c) {
                if (aVar2.a()) {
                    if (aVar != null) {
                        if (aVar2.f() <= aVar.f()) {
                        }
                    }
                    aVar = aVar2;
                }
            }
            new StringBuilder("voteShouldHandledBusiness result: ").append(aVar == null ? "null" : Integer.valueOf(aVar.f()));
            this.d = aVar;
        }
        new StringBuilder("shouldHandle, mShouldHandledBusiness != null: ").append(this.d != null);
        if (this.d == null || !this.d.a()) {
            return false;
        }
        return true;
    }
}
