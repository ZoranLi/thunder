package com.tencent.bugly.beta.global;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
public class ResBean implements Parcelable, Creator<ResBean> {
    public static final Creator<ResBean> CREATOR = new ResBean();
    public static ResBean a;
    public static final String[] b = new String[]{"IMG_title", "VAL_style"};
    public final String c = "#273238";
    public final String d = "#757575";
    private Map<String, String> e = new ConcurrentHashMap();

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public ResBean(Parcel parcel) {
        try {
            for (Object put : b) {
                this.e.put(put, parcel.readString());
            }
        } catch (Parcel parcel2) {
            parcel2.printStackTrace();
        }
    }

    public String a(String str) {
        return (String) this.e.get(str);
    }

    public void a(String str, Object obj) {
        if (obj instanceof String) {
            this.e.put(str, (String) obj);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        for (Object obj : b) {
            parcel.writeString((String) this.e.get(obj));
        }
    }

    public ResBean a(Parcel parcel) {
        return new ResBean(parcel);
    }

    public ResBean[] a(int i) {
        return new ResBean[0];
    }
}
