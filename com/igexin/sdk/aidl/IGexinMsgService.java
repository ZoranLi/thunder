package com.igexin.sdk.aidl;

import android.os.IInterface;

public interface IGexinMsgService extends IInterface {
    byte[] extFunction(byte[] bArr);

    int isStarted(String str);

    int onASNLConnected(String str, String str2, String str3, long j);

    int onASNLNetworkConnected();

    int onASNLNetworkDisconnected();

    int onPSNLConnected(String str, String str2, String str3, long j);

    int receiveToPSNL(String str, String str2, byte[] bArr);

    int sendByASNL(String str, String str2, byte[] bArr);

    int setSilentTime(int i, int i2, String str);

    int startService(String str);

    int stopService(String str);
}
