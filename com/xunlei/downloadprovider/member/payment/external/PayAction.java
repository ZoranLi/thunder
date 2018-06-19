package com.xunlei.downloadprovider.member.payment.external;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayAction implements Parcelable {
    public static final Creator<PayAction> CREATOR = new d();
    int a;
    PayUtil$OrderType b;
    public int c;

    public int describeContents() {
        return 0;
    }

    public PayAction(PayUtil$OrderType payUtil$OrderType) {
        this.c = -1;
        this.a = 5;
        this.b = payUtil$OrderType;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b == 0 ? -1 : this.b.ordinal());
        parcel.writeInt(this.c);
    }

    private PayAction(Parcel parcel) {
        PayUtil$OrderType payUtil$OrderType;
        this.c = -1;
        this.a = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            payUtil$OrderType = null;
        } else {
            payUtil$OrderType = PayUtil$OrderType.values()[readInt];
        }
        this.b = payUtil$OrderType;
        this.c = parcel.readInt();
    }
}
