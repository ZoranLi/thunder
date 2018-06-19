package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.d;

public class XAdLandingPageExtraInfo extends XAdCommandExtraInfo {
    public static final Creator<XAdLandingPageExtraInfo> CREATOR = new c();
    public int e75;
    public int from;
    public boolean isFullScreen;
    public String lpMurl;
    public String lpShoubaiStyle;
    public int orientation;
    public int os;
    public String prodType;
    public String sn;
    public String title;
    public String v;

    public XAdLandingPageExtraInfo(String str, IXAdInstanceInfo iXAdInstanceInfo) {
        super(str, iXAdInstanceInfo);
        this.isFullScreen = false;
        this.orientation = 1;
        this.e75 = 1;
        this.from = 0;
        this.os = 1;
    }

    private XAdLandingPageExtraInfo(Parcel parcel) {
        super(parcel);
        boolean z = false;
        this.isFullScreen = false;
        this.orientation = 1;
        this.e75 = 1;
        this.from = 0;
        this.os = 1;
        this.url = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.isFullScreen = z;
        this.orientation = parcel.readInt();
        this.e75 = parcel.readInt();
        this.from = parcel.readInt();
        this.adid = parcel.readString();
        this.qk = parcel.readString();
        this.packageNameOfPubliser = parcel.readString();
        this.appsid = parcel.readString();
        this.appsec = parcel.readString();
        this.os = parcel.readInt();
        this.prodType = parcel.readString();
        this.v = parcel.readString();
        this.sn = parcel.readString();
        this.title = parcel.readString();
        this.lpShoubaiStyle = parcel.readString();
        this.lpMurl = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        d commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        super.writeToParcel(parcel, i);
        parcel.writeString(this.url);
        parcel.writeByte((byte) this.isFullScreen);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.e75);
        parcel.writeInt(this.from);
        parcel.writeString(this.adid);
        parcel.writeString(this.qk);
        parcel.writeString(this.packageNameOfPubliser);
        parcel.writeString(this.appsid);
        parcel.writeString(this.appsec);
        parcel.writeInt(1);
        parcel.writeString(this.mProdType);
        parcel.writeString(commonUtils.b());
        parcel.writeString(systemUtils.getEncodedSN(XAdSDKFoundationFacade.getInstance().getApplicationContext()));
        this.title = TextUtils.isEmpty(this.title) != 0 ? "" : this.title;
        parcel.writeString(this.title);
        parcel.writeString(this.lpShoubaiStyle);
        parcel.writeString(this.lpMurl);
    }
}
