package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.v;
import dalvik.system.DexClassLoader;
import java.io.File;

public class TbsExtensionFunctionManager {
    public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final int SWITCH_BYTE_COOKIE = 1;
    public static final String USEX5_FILE_NAME = "usex5.txt";
    private static TbsExtensionFunctionManager b;
    private boolean a;

    private TbsExtensionFunctionManager() {
    }

    public static TbsExtensionFunctionManager getInstance() {
        if (b == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                if (b == null) {
                    b = new TbsExtensionFunctionManager();
                }
            }
        }
        return b;
    }

    public synchronized boolean canUseFunction(Context context, String str) {
        boolean z;
        File file = new File(context.getFilesDir(), str);
        z = file.exists() && file.isFile();
        return z;
    }

    public synchronized int getRomCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4) : context.getSharedPreferences(SP_NAME_FOR_COOKIE, 0);
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
    }

    public synchronized void initTbsBuglyIfNeed(Context context) {
        if (!this.a) {
            if (canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
                Object c;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    c = TbsShareManager.c(context);
                } else {
                    File m = aj.a().m(context);
                    if (m == null) {
                        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
                    }
                    if (m.listFiles() != null) {
                        if (m.listFiles().length > 0) {
                            c = m.getAbsolutePath();
                        }
                    }
                    TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
                    return;
                }
                if (TextUtils.isEmpty(c)) {
                    TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
                    return;
                }
                File m2 = aj.a().m(context);
                if (m2 == null) {
                    TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
                    return;
                }
                File file = new File(c, "tbs_bugly_dex.jar");
                try {
                    v.a(new DexClassLoader(file.getAbsolutePath(), m2.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", new Class[]{Context.class, String.class, String.class, String.class}, context, c, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
                    this.a = true;
                    TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                    return;
                } catch (Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("bugly init ,try init bugly failed(need new core):");
                    stringBuilder.append(Log.getStackTraceString(th));
                    TbsLog.i("TbsExtensionFunMana", stringBuilder.toString());
                    return;
                }
            }
            TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean setFunctionEnable(android.content.Context r4, java.lang.String r5, boolean r6) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = 0;
        if (r4 != 0) goto L_0x0006;
    L_0x0004:
        monitor-exit(r3);
        return r0;
    L_0x0006:
        r1 = new java.io.File;	 Catch:{ all -> 0x005e }
        r4 = r4.getFilesDir();	 Catch:{ all -> 0x005e }
        r1.<init>(r4, r5);	 Catch:{ all -> 0x005e }
        r4 = 1;
        if (r6 == 0) goto L_0x0039;
    L_0x0012:
        r6 = r1.exists();	 Catch:{ all -> 0x005e }
        if (r6 != 0) goto L_0x005c;
    L_0x0018:
        r6 = r1.createNewFile();	 Catch:{ IOException -> 0x0020 }
        if (r6 == 0) goto L_0x005c;
    L_0x001e:
        monitor-exit(r3);
        return r4;
    L_0x0020:
        r4 = move-exception;
        r6 = "TbsExtensionFunMana";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005e }
        r2 = "setFunctionEnable,createNewFile fail:";
        r1.<init>(r2);	 Catch:{ all -> 0x005e }
        r1.append(r5);	 Catch:{ all -> 0x005e }
        r5 = r1.toString();	 Catch:{ all -> 0x005e }
        com.tencent.smtt.utils.TbsLog.e(r6, r5);	 Catch:{ all -> 0x005e }
        r4.printStackTrace();	 Catch:{ all -> 0x005e }
        monitor-exit(r3);
        return r0;
    L_0x0039:
        r6 = r1.exists();	 Catch:{ all -> 0x005e }
        if (r6 == 0) goto L_0x005c;
    L_0x003f:
        r6 = r1.delete();	 Catch:{ all -> 0x005e }
        if (r6 == 0) goto L_0x0047;
    L_0x0045:
        monitor-exit(r3);
        return r4;
    L_0x0047:
        r4 = "TbsExtensionFunMana";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005e }
        r1 = "setFunctionEnable,file.delete fail:";
        r6.<init>(r1);	 Catch:{ all -> 0x005e }
        r6.append(r5);	 Catch:{ all -> 0x005e }
        r5 = r6.toString();	 Catch:{ all -> 0x005e }
        com.tencent.smtt.utils.TbsLog.e(r4, r5);	 Catch:{ all -> 0x005e }
        monitor-exit(r3);
        return r0;
    L_0x005c:
        monitor-exit(r3);
        return r4;
    L_0x005e:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsExtensionFunctionManager.setFunctionEnable(android.content.Context, java.lang.String, boolean):boolean");
    }
}
