package com.alibaba.mtl.appmonitor.model;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.List;
import java.util.UUID;

/* compiled from: Metric */
public class i implements b {
    public String a;
    public String b;
    public DimensionSet c;
    public MeasureSet d;
    public String e;
    private String f;
    private boolean g;
    private String h = null;

    public i(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = dimensionSet;
        this.d = measureSet;
        this.f = null;
        this.g = z;
    }

    public final synchronized String a() {
        if (this.e == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(UUID.randomUUID().toString());
            stringBuilder.append("$");
            stringBuilder.append(this.a);
            stringBuilder.append("$");
            stringBuilder.append(this.b);
            this.e = stringBuilder.toString();
        }
        return this.e;
    }

    public static Measure a(String str, List<Measure> list) {
        if (list != null) {
            for (Measure measure : list) {
                if (TextUtils.equals(str, measure.c)) {
                    return measure;
                }
            }
        }
        return null;
    }

    public final synchronized boolean b() {
        if ("1".equalsIgnoreCase(this.h)) {
            return true;
        }
        if ("0".equalsIgnoreCase(this.h)) {
            return false;
        }
        return this.g;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * ((((this.f == null ? 0 : this.f.hashCode()) + 31) * 31) + (this.a == null ? 0 : this.a.hashCode()));
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f == null) {
            if (iVar.f != null) {
                return false;
            }
        } else if (!this.f.equals(iVar.f)) {
            return false;
        }
        if (this.a == null) {
            if (iVar.a != null) {
                return false;
            }
        } else if (!this.a.equals(iVar.a)) {
            return false;
        }
        if (this.b == null) {
            if (iVar.b != null) {
                return false;
            }
        } else if (this.b.equals(iVar.b) == null) {
            return false;
        }
        return true;
    }

    public final void d() {
        this.a = null;
        this.b = null;
        this.f = null;
        this.g = false;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public final void a(Object... objArr) {
        this.a = (String) objArr[0];
        this.b = (String) objArr[1];
        if (objArr.length > 2) {
            this.f = (String) objArr[2];
        }
    }

    public final synchronized void a(String str) {
        this.h = str;
    }
}
