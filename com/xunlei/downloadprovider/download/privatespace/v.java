package com.xunlei.downloadprovider.download.privatespace;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.xllib.b.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PrivateSpaceHelper */
public class v {
    private static int c;
    private static v d;
    final SharedPreferences a = BrothersApplication.getApplicationInstance().getSharedPreferences("private_space_pre", 0);
    final Editor b = this.a.edit();

    private v() {
    }

    public static v a() {
        if (d == null) {
            synchronized (v.class) {
                if (d == null) {
                    d = new v();
                }
            }
        }
        return d;
    }

    static void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            Request acVar = new ac("https://privilege-vip-ssl.xunlei.com/privatespace/v1.0/auth/set", new w(aVar), new ab(aVar), str);
            acVar.setShouldCache(null);
            a(acVar);
        }
    }

    static void b(String str, a aVar) {
        Request afVar = new af("https://privilege-vip-ssl.xunlei.com/privatespace/v1.0/auth/verify", new ad(aVar), new ae(aVar), str);
        afVar.setShouldCache(null);
        a(afVar);
    }

    public static void c(String str, a aVar) {
        Request aiVar = new ai("https://privilege-vip-ssl.xunlei.com/privatespace/v1.0/auth/update", new ag(aVar), new ah(aVar), str);
        aiVar.setShouldCache(null);
        a(aiVar);
    }

    final boolean b() {
        return this.a.getBoolean(c(), false);
    }

    static String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("_open_private_space");
        return stringBuilder.toString();
    }

    final boolean d() {
        SharedPreferences sharedPreferences = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("_is_need_reverify");
        return sharedPreferences.getBoolean(stringBuilder.toString(), false);
    }

    final void a(boolean z) {
        z = b() && z;
        Editor editor = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("_is_need_reverify");
        editor.putBoolean(stringBuilder.toString(), z).commit();
        XLThreadPool.execute(new y(this, z));
    }

    static java.io.File e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r0 = com.xunlei.common.businessutil.DownloadConfig.getRealDownloadPath(r0);
        r1 = new java.io.File;
        r2 = ".privateSpace";
        r1.<init>(r0, r2);
        r0 = r1.exists();
        if (r0 != 0) goto L_0x0018;
    L_0x0015:
        r1.mkdir();
    L_0x0018:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x002c }
        r2 = r1.getPath();	 Catch:{ Exception -> 0x002c }
        r3 = ".nomedia";	 Catch:{ Exception -> 0x002c }
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x002c }
        r2 = r0.exists();	 Catch:{ Exception -> 0x002c }
        if (r2 != 0) goto L_0x002c;	 Catch:{ Exception -> 0x002c }
    L_0x0029:
        r0.createNewFile();	 Catch:{ Exception -> 0x002c }
    L_0x002c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.privatespace.v.e():java.io.File");
    }

    private static void a(Request<?> request) {
        request.setRetryPolicy(new d(20000, 1, 1.0f));
        VolleyRequestManager.getMainThreadRequestQueue().a((Request) request);
    }

    static /* synthetic */ Map a(String str) {
        Map hashMap = new HashMap();
        hashMap.put("version", "v1.0");
        StringBuilder stringBuilder = new StringBuilder();
        int i = c;
        c = i + 1;
        stringBuilder.append(i);
        hashMap.put("sequence", stringBuilder.toString());
        hashMap.put("client_version", "5.60.2.5510");
        hashMap.put("compress_flag", "0");
        hashMap.put("command_type", "1");
        hashMap.put("deviceid", AndroidConfig.getHubbleDeviceGUID());
        stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        hashMap.put("userid", stringBuilder.toString());
        hashMap.put("peerid", AndroidConfig.getHubbleDeviceGUID(BrothersApplication.getApplicationInstance()));
        hashMap.put("sessionid", LoginHelper.a().c());
        hashMap.put("client_type", "android-shoulei");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("timestamp", String.valueOf(currentTimeMillis));
        hashMap.put("password", str);
        StringBuilder stringBuilder2 = new StringBuilder("android-shoulei");
        stringBuilder2.append(LoginHelper.a().g.c());
        stringBuilder2.append(str);
        stringBuilder2.append(currentTimeMillis);
        hashMap.put("token", g.a(stringBuilder2.toString().getBytes()).toUpperCase());
        return hashMap;
    }
}
