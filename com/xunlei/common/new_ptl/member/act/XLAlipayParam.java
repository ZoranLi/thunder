package com.xunlei.common.new_ptl.member.act;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class XLAlipayParam implements Parcelable {
    public static final Creator<XLAlipayParam> CREATOR = new Creator<XLAlipayParam>() {
        public final XLAlipayParam[] newArray(int i) {
            return new XLAlipayParam[i];
        }

        public final XLAlipayParam createFromParcel(Parcel parcel) {
            return new XLAlipayParam(parcel);
        }
    };
    private String mAppId = "";
    public int mNeedLoading = 1;
    public String mTargetId = "";

    public int describeContents() {
        return 0;
    }

    public XLAlipayParam(Parcel parcel) {
        this.mAppId = parcel.readString();
        this.mTargetId = parcel.readString();
        this.mNeedLoading = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppId);
        parcel.writeString(this.mTargetId);
        parcel.writeInt(this.mNeedLoading);
    }
}
