package com.xunlei.downloadprovider.ad.c.d;

import android.content.pm.ApplicationInfo;

/* compiled from: ReportAPPPackageInfo */
public final class e {
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public int f;
    public String g;
    public long h;
    public long i;
    public int j;
    public int k;
    public String l;
    public String m;
    public int n;
    public int o;
    public ApplicationInfo p;
    public boolean q;
    public boolean r;
    public int s;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SortablePackageInfo{packageName='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", displayName='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", installer='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", tags='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append(", selected=");
        stringBuilder.append(this.e);
        stringBuilder.append(", versionCode=");
        stringBuilder.append(this.f);
        stringBuilder.append(", version='");
        stringBuilder.append(this.g);
        stringBuilder.append('\'');
        stringBuilder.append(", firstInstalled=");
        stringBuilder.append(this.h);
        stringBuilder.append(", lastUpdated=");
        stringBuilder.append(this.i);
        stringBuilder.append(", uid=");
        stringBuilder.append(this.j);
        stringBuilder.append(", rating=");
        stringBuilder.append(this.k);
        stringBuilder.append(", dataDir='");
        stringBuilder.append(this.l);
        stringBuilder.append('\'');
        stringBuilder.append(", comment='");
        stringBuilder.append(this.m);
        stringBuilder.append('\'');
        stringBuilder.append(", category=");
        stringBuilder.append(this.n);
        stringBuilder.append(", targetsdk=");
        stringBuilder.append(this.o);
        stringBuilder.append(", appInfo=");
        stringBuilder.append(this.p);
        stringBuilder.append(", systemAPP=");
        stringBuilder.append(this.q);
        stringBuilder.append(", updateSystemAPP=");
        stringBuilder.append(this.r);
        stringBuilder.append(", flags=");
        stringBuilder.append(this.s);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
