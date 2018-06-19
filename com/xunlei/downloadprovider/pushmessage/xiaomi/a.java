package com.xunlei.downloadprovider.pushmessage.xiaomi;

import android.content.Context;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.pushmessage.e;
import java.util.List;

/* compiled from: XiaoMiPushManager */
public final class a extends e {
    public final String a() {
        return "mipush";
    }

    protected final String b() {
        return "xiao_mi_register_id";
    }

    public final void a(Context context) {
        if (com.xunlei.downloadprovider.pushmessage.a.a.a(BrothersApplication.getApplicationInstance()) != null) {
            MiPushClient.registerPush(BrothersApplication.getApplicationInstance(), "2882303761517301192", "5171730196192");
            Logger.setLogger(BrothersApplication.getApplicationInstance(), new b(this));
        }
    }

    public final void a(String[] strArr) {
        if (strArr != null) {
            XLThreadPool.execute(new c(this, strArr));
        }
    }

    protected final void a(Context context, int[] iArr) {
        for (int clearNotification : iArr) {
            MiPushClient.clearNotification(context.getApplicationContext(), clearNotification);
        }
    }

    protected final String f() {
        return com.xunlei.downloadprovider.pushmessage.a.a.a(BrothersApplication.getApplicationInstance()) ? "1" : "0";
    }

    static /* synthetic */ void a(List list, String[] strArr) {
        for (String str : strArr) {
            if (list == null || list.isEmpty() || !list.contains(str)) {
                MiPushClient.subscribe(BrothersApplication.getApplicationInstance(), str, null);
            }
        }
    }

    static /* synthetic */ void b(List list, String[] strArr) {
        if (list != null) {
            if (!list.isEmpty()) {
                for (String str : list) {
                    if (str != null) {
                        Object obj = null;
                        for (Object equals : strArr) {
                            if (str.equals(equals)) {
                                obj = 1;
                                break;
                            }
                        }
                        if (obj == null) {
                            MiPushClient.unsubscribe(BrothersApplication.getApplicationInstance(), str, null);
                        }
                    }
                }
            }
        }
    }
}
