package com.xunlei.downloadprovider.member.payment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xunlei.downloadprovider.member.payment.external.Destination;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;

public class PaySucInfo implements Parcelable {
    public static final Creator<PaySucInfo> CREATOR = new Creator<PaySucInfo>() {
        public final PaySucInfo createFromParcel(Parcel parcel) {
            return new PaySucInfo(parcel);
        }

        public final PaySucInfo[] newArray(int i) {
            return new PaySucInfo[i];
        }
    };
    public String activityExt;
    public boolean isRedPackagePay;
    public int monthOrDays;
    public String orderId;
    public PayUtil$OrderType orderType;
    public String referfrom;
    public Destination successDest;
    public int vasType;

    public int describeContents() {
        return 0;
    }

    public PaySucInfo(String str, int i, PayUtil$OrderType payUtil$OrderType, int i2, String str2) {
        this.vasType = i;
        this.orderType = payUtil$OrderType;
        this.monthOrDays = i2;
        this.orderId = str;
        this.referfrom = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.vasType);
        parcel.writeInt(this.orderType == 0 ? -1 : this.orderType.ordinal());
        parcel.writeInt(this.monthOrDays);
        parcel.writeSerializable(this.successDest);
        parcel.writeByte(this.isRedPackagePay);
        parcel.writeString(this.orderId);
        parcel.writeString(this.activityExt);
        parcel.writeString(this.referfrom);
    }

    private PaySucInfo(Parcel parcel) {
        PayUtil$OrderType payUtil$OrderType;
        this.vasType = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            payUtil$OrderType = null;
        } else {
            payUtil$OrderType = PayUtil$OrderType.values()[readInt];
        }
        this.orderType = payUtil$OrderType;
        this.monthOrDays = parcel.readInt();
        this.successDest = (Destination) parcel.readSerializable();
        this.isRedPackagePay = parcel.readByte() != (byte) 0;
        this.orderId = parcel.readString();
        this.activityExt = parcel.readString();
        this.referfrom = parcel.readString();
    }
}
