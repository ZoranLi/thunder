package com.taobao.dp;

import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import com.taobao.dp.client.IInitResultListener;

class a implements IUMIDInitListenerEx {
    final /* synthetic */ IInitResultListener a;
    final /* synthetic */ DeviceSecuritySDK b;

    a(DeviceSecuritySDK deviceSecuritySDK, IInitResultListener iInitResultListener) {
        this.b = deviceSecuritySDK;
        this.a = iInitResultListener;
    }

    public void onUMIDInitFinishedEx(String str, int i) {
        this.a.onInitFinished(str, i);
    }
}
