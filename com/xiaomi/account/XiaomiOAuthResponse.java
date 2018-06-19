package com.xiaomi.account;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.account.IXiaomiAuthResponse.Stub;

public class XiaomiOAuthResponse implements Parcelable {
    public static final Creator<XiaomiOAuthResponse> CREATOR = new Creator<XiaomiOAuthResponse>() {
        public final XiaomiOAuthResponse createFromParcel(Parcel parcel) {
            return new XiaomiOAuthResponse(parcel);
        }

        public final XiaomiOAuthResponse[] newArray(int i) {
            return new XiaomiOAuthResponse[i];
        }
    };
    private static final String TAG = "com.xiaomi.account.XiaomiOAuthResponse";
    private IXiaomiAuthResponse mResponse;

    public int describeContents() {
        return 0;
    }

    public XiaomiOAuthResponse(IXiaomiAuthResponse iXiaomiAuthResponse) {
        this.mResponse = iXiaomiAuthResponse;
    }

    public XiaomiOAuthResponse(Parcel parcel) {
        this.mResponse = Stub.asInterface(parcel.readStrongBinder());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mResponse.asBinder());
    }

    public void onResult(Bundle bundle) {
        setIXiaomiAuthResponseResult(this.mResponse, bundle);
    }

    public void onError(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("extra_error_code", i);
        bundle.putString("extra_error_description", str);
        setIXiaomiAuthResponseResult(this.mResponse, bundle);
    }

    public void onCancel() {
        setIXiaomiAuthResponseCancel(this.mResponse);
    }

    public static void setIXiaomiAuthResponseResult(com.xiaomi.account.IXiaomiAuthResponse r3, android.os.Bundle r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 == 0) goto L_0x0025;
    L_0x0002:
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        goto L_0x0025;
    L_0x0005:
        r3.onResult(r4);	 Catch:{ RuntimeException -> 0x000a, RemoteException -> 0x0009 }
        return;
    L_0x0009:
        return;
    L_0x000a:
        r4 = move-exception;
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = "extra_error_code";
        r2 = -1;
        r0.putInt(r1, r2);
        r1 = "extra_error_description";
        r4 = r4.getMessage();
        r0.putString(r1, r4);
        r3.onResult(r0);	 Catch:{ RuntimeException -> 0x0024, RemoteException -> 0x0023 }
        return;
    L_0x0023:
        return;
    L_0x0024:
        return;
    L_0x0025:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.XiaomiOAuthResponse.setIXiaomiAuthResponseResult(com.xiaomi.account.IXiaomiAuthResponse, android.os.Bundle):void");
    }

    public static void setIXiaomiAuthResponseCancel(com.xiaomi.account.IXiaomiAuthResponse r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0.onCancel();	 Catch:{ RuntimeException -> 0x0008, RemoteException -> 0x0007 }
        return;
    L_0x0007:
        return;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.XiaomiOAuthResponse.setIXiaomiAuthResponseCancel(com.xiaomi.account.IXiaomiAuthResponse):void");
    }
}
