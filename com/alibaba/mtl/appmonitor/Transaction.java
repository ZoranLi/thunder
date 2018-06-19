package com.alibaba.mtl.appmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;

public class Transaction implements Parcelable {
    public static final Creator<Transaction> CREATOR = new u();
    protected Integer a;
    protected String b;
    protected String c;
    protected DimensionValueSet d;
    protected String e;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.d, i);
        parcel.writeInt(this.a.intValue());
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.e);
    }

    static Transaction a(Parcel parcel) {
        Transaction transaction = new Transaction();
        try {
            transaction.d = (DimensionValueSet) parcel.readParcelable(Transaction.class.getClassLoader());
            transaction.a = Integer.valueOf(parcel.readInt());
            transaction.b = parcel.readString();
            transaction.c = parcel.readString();
            transaction.e = parcel.readString();
        } catch (Parcel parcel2) {
            parcel2.printStackTrace();
        }
        return transaction;
    }
}
