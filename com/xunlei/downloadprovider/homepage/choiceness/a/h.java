package com.xunlei.downloadprovider.homepage.choiceness.a;

import android.content.Context;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: ChoicenessDynamicRecommendHelper */
public final class h {
    public static final float a = ((float) d.a().b.w());
    private static h g;
    public int b = 0;
    public i c;
    public m d = null;
    e e = null;
    public final Set<String> f;
    private final Context h = BrothersApplication.getApplicationInstance();
    private e i = null;

    private h() {
        new StringBuilder("init. isDynamicRecommendEnabled: ").append(b());
        this.f = new HashSet();
        a(0);
        this.d = null;
        this.i = null;
        this.e = null;
        this.f.clear();
    }

    public static h a() {
        if (g == null) {
            g = new h();
        }
        return g;
    }

    public static boolean b() {
        return d.a().b.v();
    }

    private int a(m mVar, List<e> list) {
        mVar = list.indexOf(mVar);
        int size = list.size();
        int i = -1;
        for (mVar++; mVar < size; mVar++) {
            e eVar = (e) list.get(mVar);
            eVar.d();
            if (i != -1) {
                float f = (float) (mVar - i);
                if (f > 1.0f) {
                    break;
                } else if (eVar.d() && f <= 1.0f) {
                    i = -1;
                }
            }
            if (i == -1 && eVar.e() && !this.c.b(eVar)) {
                i = mVar;
            }
        }
        if (i != -1) {
            return i;
        }
        return -1;
    }

    public final void c() {
        a(0);
        this.f.clear();
    }

    public final void a(int i) {
        int i2 = this.b;
        boolean z = true;
        if (i == 0) {
            if (i2 != 2) {
                z = false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("checkState. isStateValid: ");
        stringBuilder.append(z);
        stringBuilder.append(" oldState: ");
        stringBuilder.append(this.b);
        stringBuilder.append(" newState: ");
        stringBuilder.append(i);
        if (z) {
            stringBuilder = new StringBuilder("setState. success. oldState: ");
            stringBuilder.append(this.b);
            stringBuilder.append(" newState: ");
            stringBuilder.append(i);
            this.b = i;
        }
    }

    static /* synthetic */ boolean a(h hVar, m mVar, m mVar2) {
        StringBuilder stringBuilder = new StringBuilder("replaceRecommendData. anchor: ");
        stringBuilder.append(mVar.b.getTitle());
        stringBuilder.append(" newInfo: ");
        stringBuilder.append(mVar2.b.getTitle());
        List list = a.a(hVar.h).d;
        if (list != null) {
            int a = hVar.a(mVar, list);
            if (a != -1) {
                e eVar = (e) list.get(a);
                if (eVar instanceof m) {
                    mVar2.n = ((m) eVar).n + 1;
                }
                if (a.a(hVar.h).a(a, (e) mVar2)) {
                    i iVar = hVar.c;
                    int c = iVar.c(eVar);
                    List list2 = iVar.a;
                    if (list2 != null) {
                        if (!list2.isEmpty()) {
                            if (c >= 0) {
                                if (c < list2.size()) {
                                    list2.set(c, mVar2);
                                    iVar.notifyItemChanged(c);
                                    mVar2 = 1;
                                    if (mVar2 != null) {
                                        return true;
                                    }
                                    a.a(hVar.h).a(a, eVar);
                                }
                            }
                        }
                    }
                    mVar2 = null;
                    if (mVar2 != null) {
                        return true;
                    }
                    a.a(hVar.h).a(a, eVar);
                }
            }
        }
        return false;
    }
}
