package com.xunlei.downloadprovider.ad.recommend.c;

import android.support.annotation.Nullable;
import android.view.View;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.downloadlist.c.i;

/* compiled from: RecommendAdShowReporter */
public class b implements i {
    private static final String d = "b";
    public int a;
    public int b;
    public l c = null;
    private String e;
    private String f;
    private View g = null;
    private String h = null;
    private String i = null;
    private String j;
    private l k;

    public final boolean b() {
        return false;
    }

    public b(View view, l lVar, String str, String str2, String str3, int i, int i2, String str4, String str5, @Nullable l lVar2) {
        this.g = view;
        this.c = lVar;
        this.f = str;
        this.e = str2;
        this.a = i;
        this.b = i2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = lVar2;
    }

    public final int a() {
        return this.a;
    }

    public final void c() {
        StringBuilder stringBuilder = new StringBuilder("RecommendShowReporter excute  position ");
        stringBuilder.append(this.b);
        stringBuilder.append(" pageIndex: ");
        stringBuilder.append(this.a);
        a.a();
        this.c.a(this.g);
    }
}
