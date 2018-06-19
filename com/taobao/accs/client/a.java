package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.TaobaoConstants;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class a {
    public static final int SECURITY_OFF = 2;
    public static final int SECURITY_OPEN = 1;
    public static final int SECURITY_TAOBAO = 0;
    public static int a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static IProcessName f;
    public static AtomicInteger g = new AtomicInteger(-1);
    private static volatile a h;
    private static Context i;
    private ActivityManager j;
    private ConnectivityManager k;

    public static a a(Context context) {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a(context);
                }
            }
        }
        return h;
    }

    private a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        } else if (i == null) {
            i = context.getApplicationContext();
        }
    }

    public ActivityManager a() {
        if (this.j == null) {
            this.j = (ActivityManager) i.getSystemService("activity");
        }
        return this.j;
    }

    public ConnectivityManager b() {
        if (this.k == null) {
            this.k = (ConnectivityManager) i.getSystemService("connectivity");
        }
        return this.k;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(b)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(TaobaoConstants.DEFAULT_INTENT_SERVICE_CLASS_NAME);
            str = stringBuilder.toString();
        } else {
            str = b;
        }
        ALog.d("AdapterGlobalClientInfo", "getAgooCustomServiceName", c.e, str);
        return str;
    }

    public static boolean c() {
        return g.intValue() == 0;
    }
}
