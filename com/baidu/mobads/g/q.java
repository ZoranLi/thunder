package com.baidu.mobads.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.lang.Thread.UncaughtExceptionHandler;

public class q implements UncaughtExceptionHandler {
    public static String a = "";
    private static UncaughtExceptionHandler b;
    private static volatile q c;
    private Context d;
    private a e;

    interface a {
        void a(String str);
    }

    public static q a(Context context) {
        if (c == null) {
            synchronized (q.class) {
                if (c == null) {
                    c = new q(context);
                }
            }
        }
        return c;
    }

    private q(Context context) {
        this.d = context.getApplicationContext();
        b = Thread.getDefaultUncaughtExceptionHandler();
        new Thread(new r(this)).start();
    }

    public void a() {
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof q)) {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a = a(th);
            if (a != null) {
                a(a, Log.getStackTraceString(th));
                th.printStackTrace();
                if (this.e != null) {
                    this.e.a(a);
                }
            }
            if (b != null) {
                b.uncaughtException(thread, th);
            }
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void b() {
        this.e = null;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        th = th.getStackTrace();
        if (th == null || th.length <= 0) {
            return null;
        }
        for (StackTraceElement className : th) {
            String className2 = className.getClassName();
            if (className2.startsWith("junit.framework")) {
                return null;
            }
            if (className2.startsWith("com.baidu.mobads.container")) {
                return "remote";
            }
            if (className2.startsWith("com.baidu.mobads.loader")) {
                return "loader";
            }
            if (className2.startsWith("com.baidu.mobads_vr")) {
                return "vr";
            }
            if (className2.startsWith("com.baidu.mobads")) {
                return "proxy";
            }
        }
        return null;
    }

    private SharedPreferences c() {
        return this.d.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private Editor d() {
        return c().edit();
    }

    private void a(String str, String str2) {
        Editor d = d();
        d.putString("key_crash_source", str);
        d.putString("key_crash_trace", str2);
        d.putString("key_crash_ad", a);
        if (VERSION.SDK_INT >= 9) {
            d.apply();
        } else {
            d.commit();
        }
    }

    private String a(String str) {
        return c().getString(str, "");
    }

    private void e() {
        Editor d = d();
        d.clear();
        if (VERSION.SDK_INT >= 9) {
            d.apply();
        } else {
            d.commit();
        }
    }
}
