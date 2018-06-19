package com.xunlei.downloadprovider.pushmessage.getui;

import android.content.Context;
import com.igexin.sdk.PushManager;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.pushmessage.e;

/* compiled from: GetuiPushManager */
public class a extends e {
    private static volatile a c;

    public final String a() {
        return "gpush";
    }

    protected final void a(Context context, int[] iArr) {
    }

    protected final void a(String[] strArr) {
    }

    protected final String b() {
        return "getui_register_id";
    }

    private a() {
    }

    public static a g() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public final void a(Context context) {
        PushManager.getInstance().initialize(context, GetuiPushService.class);
        PushManager.getInstance().registerPushIntentService(context, GetuiPushReceiverIntentService.class);
    }

    public final String d() {
        return PushManager.getInstance().getClientid(BrothersApplication.getApplicationInstance());
    }
}
