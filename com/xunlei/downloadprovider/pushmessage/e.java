package com.xunlei.downloadprovider.pushmessage;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.pushmessage.xiaomi.a;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: PushManager */
public abstract class e {
    public static final String a = "e";
    static final /* synthetic */ boolean b = true;
    private static e c;
    private String d = null;

    public abstract String a();

    public abstract void a(Context context);

    public abstract void a(Context context, int[] iArr);

    public abstract void a(String[] strArr);

    public abstract String b();

    public String f() {
        return "1";
    }

    public static e c() {
        if (b || c != null) {
            return c;
        }
        throw new AssertionError();
    }

    public static void a(Context context, String str) {
        if (b || c == null) {
            if (l.b()) {
                if (BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER.equals(str) != null) {
                    str = new a();
                    c = str;
                    str.a(context);
                }
            } else if (!l.c() || !p.a(context)) {
                str = new com.xunlei.downloadprovider.pushmessage.umeng.a();
                c = str;
                str.a(context);
            } else if (BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER.equals(str) != null) {
                str = new com.xunlei.downloadprovider.pushmessage.huawei.a();
                c = str;
                str.a(context);
            }
            if (c == null) {
                str = new com.xunlei.downloadprovider.pushmessage.umeng.a();
                c = str;
                str.a(context);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public String d() {
        return this.d;
    }

    public static void a(String str) {
        c.d = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
        r11 = this;
        r5 = r11.d();
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r0 = com.xunlei.downloadprovider.launch.c.a.a(r0);
        if (r0 == 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r0 = com.xunlei.downloadprovider.pushmessage.b.b.a();
        r1 = r11.b();
        r0 = r0.a(r1);
        r1 = android.text.TextUtils.isEmpty(r0);
        r2 = 1;
        if (r1 != 0) goto L_0x0049;
    L_0x0029:
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x0049;
    L_0x002f:
        r0 = com.xunlei.downloadprovider.pushmessage.b.b.a();
        r1 = r0.a;
        r3 = 0;
        if (r1 != 0) goto L_0x003a;
    L_0x0038:
        r0 = r3;
        goto L_0x0042;
    L_0x003a:
        r0 = r0.a;
        r1 = "last_register_version_code";
        r0 = r0.getInt(r1, r3);
    L_0x0042:
        r1 = 11100; // 0x2b5c float:1.5554E-41 double:5.484E-320;
        if (r0 != r1) goto L_0x0047;
    L_0x0046:
        r3 = r2;
    L_0x0047:
        if (r3 != 0) goto L_0x00be;
    L_0x0049:
        r6 = r11.f();
        r8 = new java.util.ArrayList;
        r8.<init>();
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 == 0) goto L_0x0059;
    L_0x0058:
        return;
    L_0x0059:
        r3 = com.xunlei.common.androidutil.AndroidConfig.getHubbleDeviceGUID();
        r0 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r0 = r0.g;
        r0 = r0.c();
        r4 = java.lang.String.valueOf(r0);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = android.os.Build.MODEL;
        r0.append(r1);
        r1 = android.os.Build.VERSION.SDK_INT;
        r0.append(r1);
        r7 = r0.toString();
        r0 = "anonymous";
        r8.add(r0);
        r0 = new java.util.Random;
        r0.<init>();
        r1 = 100;
        r0 = r0.nextInt(r1);
        r0 = r0 + r2;
        r0 = java.lang.String.valueOf(r0);
        r8.add(r0);
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r0 = com.xunlei.downloadprovider.pushmessage.report.a.a(r0);
        r9 = r11.a();
        r1 = r0.b;
        r1 = com.xunlei.xllib.android.b.a(r1);
        if (r1 == 0) goto L_0x00b3;
    L_0x00aa:
        r0 = r0.a;
        r1 = 0;
        r2 = "http://api-shoulei-ssl.xunlei.com/push_services/peer/register/";
        r10 = 1;
        r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    L_0x00b3:
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r0 = com.xunlei.downloadprovider.pushmessage.report.a.a(r0);
        r0.a();
    L_0x00be:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.e.e():void");
    }

    public final void a(boolean z) {
        String f = f();
        List arrayList = new ArrayList();
        Object d = d();
        if (!TextUtils.isEmpty(d)) {
            String hubbleDeviceGUID = AndroidConfig.getHubbleDeviceGUID();
            String valueOf = z ? String.valueOf(LoginHelper.a().g.c()) : "0";
            z = new StringBuilder();
            z.append(Build.MODEL);
            z.append(VERSION.SDK_INT);
            String stringBuilder = z.toString();
            arrayList.add("anonymous");
            arrayList.add(String.valueOf(new Random().nextInt(100) + 1));
            z = com.xunlei.downloadprovider.pushmessage.report.a.a(BrothersApplication.getApplicationInstance());
            String a = a();
            if (b.a(z.b)) {
                z.a.a(true, "http://api-shoulei-ssl.xunlei.com/push_services/peer/update/", hubbleDeviceGUID, valueOf, d, f, stringBuilder, arrayList, a, true);
            }
        }
    }
}
