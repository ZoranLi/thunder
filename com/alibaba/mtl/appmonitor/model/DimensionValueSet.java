package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DimensionValueSet implements Parcelable, b {
    public static final Creator<DimensionValueSet> CREATOR = new d();
    protected Map<String, String> a;

    public int describeContents() {
        return 0;
    }

    public static DimensionValueSet a() {
        return (DimensionValueSet) a.a().a(DimensionValueSet.class, new Object[0]);
    }

    @Deprecated
    public DimensionValueSet() {
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
    }

    public final DimensionValueSet a(String str, String str2) {
        Map map = this.a;
        if (str2 == null) {
            str2 = "null";
        }
        map.put(str, str2);
        return this;
    }

    public final boolean a(String str) {
        return this.a.containsKey(str);
    }

    public final String b(String str) {
        return (String) this.a.get(str);
    }

    public final Map<String, String> b() {
        return this.a;
    }

    public int hashCode() {
        return 31 + (this.a == null ? 0 : this.a.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DimensionValueSet dimensionValueSet = (DimensionValueSet) obj;
        if (this.a == null) {
            if (dimensionValueSet.a != null) {
                return false;
            }
        } else if (this.a.equals(dimensionValueSet.a) == null) {
            return false;
        }
        return true;
    }

    public void d() {
        this.a.clear();
    }

    public void a(Object... objArr) {
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.a);
    }

    static DimensionValueSet a(Parcel parcel) {
        DimensionValueSet a;
        try {
            a = a();
            try {
                a.a = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
            } catch (Throwable th) {
                parcel = th;
                parcel.printStackTrace();
                return a;
            }
        } catch (Throwable th2) {
            parcel = th2;
            a = null;
            parcel.printStackTrace();
            return a;
        }
        return a;
    }

    public final DimensionValueSet a(DimensionValueSet dimensionValueSet) {
        if (dimensionValueSet != null) {
            dimensionValueSet = dimensionValueSet.a;
            if (dimensionValueSet != null) {
                for (Entry entry : dimensionValueSet.entrySet()) {
                    this.a.put(entry.getKey(), entry.getValue() != null ? (String) entry.getValue() : "null");
                }
            }
        }
        return this;
    }
}
