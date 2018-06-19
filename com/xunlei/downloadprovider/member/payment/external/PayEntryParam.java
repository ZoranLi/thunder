package com.xunlei.downloadprovider.member.payment.external;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.f;
import java.util.HashMap;

public final class PayEntryParam implements Parcelable {
    public static final Creator<PayEntryParam> CREATOR = new f();
    public PayFrom a;
    public String b;
    public Destination c;
    public String d;
    public PayAction e;
    private HashMap<String, Object> f;

    public final int describeContents() {
        return 0;
    }

    public PayEntryParam(PayFrom payFrom) {
        this.a = payFrom;
        this.b = f.a(payFrom);
    }

    public final PayEntryParam a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("null".equalsIgnoreCase(str)) {
                str = f.a(null);
            }
            this.b = str;
        }
        return this;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PayEntryParam{payFrom=");
        stringBuilder.append(this.a);
        stringBuilder.append(", reportRefer='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", successDest=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final PayEntryParam a(String str, Object obj) {
        if (!(TextUtils.isEmpty(str) || obj == null)) {
            if (this.f == null) {
                this.f = new HashMap();
            }
            this.f.put(str, obj);
        }
        return this;
    }

    public final Object b(String str) {
        if (this.f != null) {
            if (!this.f.isEmpty()) {
                return this.f.get(str);
            }
        }
        return null;
    }

    public final long c(String str) {
        str = b(str);
        return (str == null || !(str instanceof Long)) ? 0 : ((Long) str).longValue();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a == null ? -1 : this.a.ordinal());
        parcel.writeString(this.b);
        parcel.writeSerializable(this.c);
        parcel.writeSerializable(this.f);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i);
    }

    protected PayEntryParam(Parcel parcel) {
        PayFrom payFrom;
        int readInt = parcel.readInt();
        if (readInt == -1) {
            payFrom = null;
        } else {
            payFrom = PayFrom.values()[readInt];
        }
        this.a = payFrom;
        this.b = parcel.readString();
        this.c = (Destination) parcel.readSerializable();
        this.f = (HashMap) parcel.readSerializable();
        this.d = parcel.readString();
        this.e = (PayAction) parcel.readParcelable(PayAction.class.getClassLoader());
    }
}
