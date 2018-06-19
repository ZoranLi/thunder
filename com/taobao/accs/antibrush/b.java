package com.taobao.accs.antibrush;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alipay.sdk.util.h;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.utl.ALog;
import java.util.StringTokenizer;

/* compiled from: Taobao */
public class b {
    public static final String KEY_SEC = "sec";
    public static final String TAG = "CookieMgr";
    public static CookieManager a = null;
    private static volatile boolean b = false;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            try {
                if (!GlobalConfig.enableCookie) {
                    ALog.i(TAG, "disable cookie", new Object[0]);
                } else if (b) {
                } else {
                    if (VERSION.SDK_INT < 21) {
                        CookieSyncManager.createInstance(context);
                    }
                    context = CookieManager.getInstance();
                    a = context;
                    context.setAcceptCookie(true);
                    if (VERSION.SDK_INT < 21) {
                        a.removeExpiredCookie();
                    }
                    b = true;
                }
            } catch (Context context2) {
                ALog.e(TAG, "setup", context2, new Object[0]);
            }
        }
    }

    private static boolean a() {
        if (!(b || GlobalClientInfo.a == null)) {
            a(GlobalClientInfo.a);
        }
        return b;
    }

    public static synchronized String a(String str) {
        String b;
        synchronized (b.class) {
            if (a()) {
                try {
                    b = b(a.getCookie(str));
                } catch (Throwable th) {
                    String str2 = TAG;
                    StringBuilder stringBuilder = new StringBuilder("get cookie failed. url=");
                    stringBuilder.append(str);
                    ALog.e(str2, stringBuilder.toString(), th, new Object[0]);
                    b = null;
                }
            } else {
                ALog.e(TAG, "cookieMgr not setup", new Object[0]);
                return null;
            }
        }
        return b;
    }

    public static String b(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, h.b);
        do {
            try {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf != -1) {
                    String trim = nextToken.substring(0, indexOf).trim();
                    nextToken = nextToken.substring(indexOf + 1).trim();
                    if (KEY_SEC.equals(trim)) {
                        str2 = c(nextToken);
                    }
                } else {
                    throw new IllegalArgumentException("Invalid cookie name-value pair");
                }
            } catch (Throwable th) {
                ALog.e(TAG, "parse", th, new Object[0]);
            }
        } while (stringTokenizer.hasMoreTokens());
        return str2;
    }

    private static String c(String str) {
        if (str == null || str.length() <= 2 || str.charAt(0) != '\"' || str.charAt(str.length() - 1) != '\"') {
            return (str == null || str.length() <= 2 || str.charAt(0) != '\'' || str.charAt(str.length() - 1) != '\'') ? str : str.substring(1, str.length() - 1);
        } else {
            return str.substring(1, str.length() - 1);
        }
    }
}
