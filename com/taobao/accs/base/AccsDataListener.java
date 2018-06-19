package com.taobao.accs.base;

import com.taobao.accs.base.TaoBaseService.ConnectInfo;

/* compiled from: Taobao */
public interface AccsDataListener {
    void onAntiBrush(boolean z, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo);

    void onBind(String str, int i, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo);

    void onConnected(ConnectInfo connectInfo);

    void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo);

    void onDisconnected(ConnectInfo connectInfo);

    void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo);

    void onSendData(String str, String str2, int i, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo);

    void onUnbind(String str, int i, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo);
}
