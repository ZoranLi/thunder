package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import org.json.JSONArray;

public class VipExtras implements Parcelable {
    public static final Creator<VipExtras> CREATOR = new k();
    public SparseArray<VipExtra> a = new SparseArray();

    public int describeContents() {
        return 0;
    }

    public final SparseArray<VipExtra> a() {
        if (this.a == null) {
            this.a = new SparseArray();
        }
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcelable[] parcelableArr = new VipExtra[this.a.size()];
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            parcelableArr[i2] = (VipExtra) this.a.valueAt(i2);
        }
        parcel.writeParcelableArray(parcelableArr, i);
    }

    protected VipExtras(Parcel parcel) {
        parcel = parcel.readParcelableArray(VipExtra.class.getClassLoader());
        if (parcel != null) {
            for (Object obj : parcel) {
                VipExtra vipExtra = (VipExtra) obj;
                this.a.put(vipExtra.c, vipExtra);
            }
        }
    }

    public static VipExtras a(JSONArray jSONArray) {
        VipExtras vipExtras = new VipExtras();
        if (jSONArray != null) {
            if (jSONArray.length() != 0) {
                SparseArray sparseArray = vipExtras.a;
                for (int i = 0; i < jSONArray.length(); i++) {
                    VipExtra a = VipExtra.a(jSONArray.optJSONObject(i));
                    if (a != null) {
                        sparseArray.put(a.c, a);
                    }
                }
                return vipExtras;
            }
        }
        return vipExtras;
    }
}
