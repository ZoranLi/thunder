package com.xunlei.downloadprovider.pushmessage.huawei;

import android.content.Context;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClient.Builder;
import com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks;
import com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener;
import com.huawei.hms.support.api.push.HuaweiPush;
import com.xunlei.downloadprovider.pushmessage.e;

/* compiled from: HuaweiPushManager */
public final class a extends e implements ConnectionCallbacks, OnConnectionFailedListener {
    private HuaweiPushReceiver c = null;
    private HuaweiApiClient d = null;

    public final String a() {
        return "hwpush";
    }

    protected final void a(Context context, int[] iArr) {
    }

    protected final void a(String[] strArr) {
    }

    protected final String b() {
        return "huawei_register_id";
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void a(Context context) {
        this.c = new HuaweiPushReceiver();
        this.d = new Builder(context).addApi(HuaweiPush.PUSH_API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        this.d.connect();
    }

    public final void onConnected() {
        HuaweiPush.HuaweiPushApi.getToken(this.d).setResultCallback(new b(this));
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        new StringBuilder("HuaweiApiClient连接失败，错误码：").append(connectionResult.getErrorCode());
    }
}
