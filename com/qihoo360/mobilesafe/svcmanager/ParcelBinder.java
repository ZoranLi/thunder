package com.qihoo360.mobilesafe.svcmanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ParcelBinder implements Parcelable {
    public static final Creator<ParcelBinder> CREATOR = new b();
    final IBinder a;

    public int describeContents() {
        return 0;
    }

    private ParcelBinder(Parcel parcel) {
        this.a = parcel.readStrongBinder();
    }

    public ParcelBinder(IBinder iBinder) {
        this.a = iBinder;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.a);
    }
}
