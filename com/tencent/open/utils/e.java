package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class e {
    private static Map<String, e> a = Collections.synchronizedMap(new HashMap());
    private static String b;
    private Context c = null;
    private String d = null;
    private JSONObject e = null;
    private long f = 0;
    private int g = 0;
    private boolean h = true;

    public static e a(Context context, String str) {
        e eVar;
        synchronized (a) {
            f.a("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                b = str;
            }
            if (str == null) {
                str = b != null ? b : "0";
            }
            eVar = (e) a.get(str);
            if (eVar == null) {
                eVar = new e(context, str);
                a.put(str, eVar);
            }
            f.a("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return eVar;
    }

    private e(Context context, String str) {
        this.c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    private void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = "com.tencent.open.config.json";
        r0 = r2.c(r0);
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000e }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x000e }
        r2.e = r1;	 Catch:{ JSONException -> 0x000e }
        return;
    L_0x000e:
        r0 = new org.json.JSONObject;
        r0.<init>();
        r2.e = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.e.a():void");
    }

    private java.lang.String c(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "";
        r1 = r4.d;	 Catch:{ FileNotFoundException -> 0x0025 }
        if (r1 == 0) goto L_0x001d;	 Catch:{ FileNotFoundException -> 0x0025 }
    L_0x0006:
        r1 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0025 }
        r1.<init>();	 Catch:{ FileNotFoundException -> 0x0025 }
        r1.append(r5);	 Catch:{ FileNotFoundException -> 0x0025 }
        r2 = ".";	 Catch:{ FileNotFoundException -> 0x0025 }
        r1.append(r2);	 Catch:{ FileNotFoundException -> 0x0025 }
        r2 = r4.d;	 Catch:{ FileNotFoundException -> 0x0025 }
        r1.append(r2);	 Catch:{ FileNotFoundException -> 0x0025 }
        r1 = r1.toString();	 Catch:{ FileNotFoundException -> 0x0025 }
        goto L_0x001e;	 Catch:{ FileNotFoundException -> 0x0025 }
    L_0x001d:
        r1 = r5;	 Catch:{ FileNotFoundException -> 0x0025 }
    L_0x001e:
        r2 = r4.c;	 Catch:{ FileNotFoundException -> 0x0025 }
        r1 = r2.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x0025 }
        goto L_0x002f;
    L_0x0025:
        r1 = r4.c;	 Catch:{ IOException -> 0x007d }
        r1 = r1.getAssets();	 Catch:{ IOException -> 0x007d }
        r1 = r1.open(r5);	 Catch:{ IOException -> 0x007d }
    L_0x002f:
        r5 = new java.io.BufferedReader;
        r2 = new java.io.InputStreamReader;
        r3 = "UTF-8";
        r3 = java.nio.charset.Charset.forName(r3);
        r2.<init>(r1, r3);
        r5.<init>(r2);
        r2 = new java.lang.StringBuffer;
        r2.<init>();
    L_0x0044:
        r3 = r5.readLine();	 Catch:{ IOException -> 0x0061 }
        if (r3 == 0) goto L_0x004e;	 Catch:{ IOException -> 0x0061 }
    L_0x004a:
        r2.append(r3);	 Catch:{ IOException -> 0x0061 }
        goto L_0x0044;	 Catch:{ IOException -> 0x0061 }
    L_0x004e:
        r2 = r2.toString();	 Catch:{ IOException -> 0x0061 }
        r1.close();	 Catch:{ IOException -> 0x0059 }
        r5.close();	 Catch:{ IOException -> 0x0059 }
        goto L_0x005d;
    L_0x0059:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x005d:
        r0 = r2;
        goto L_0x0070;
    L_0x005f:
        r0 = move-exception;
        goto L_0x0071;
    L_0x0061:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x005f }
        r1.close();	 Catch:{ IOException -> 0x006c }
        r5.close();	 Catch:{ IOException -> 0x006c }
        goto L_0x0070;
    L_0x006c:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0070:
        return r0;
    L_0x0071:
        r1.close();	 Catch:{ IOException -> 0x0078 }
        r5.close();	 Catch:{ IOException -> 0x0078 }
        goto L_0x007c;
    L_0x0078:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x007c:
        throw r0;
    L_0x007d:
        r5 = move-exception;
        r5.printStackTrace();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.e.c(java.lang.String):java.lang.String");
    }

    private void a(String str, String str2) {
        try {
            if (this.d != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".");
                stringBuilder.append(this.d);
                str = stringBuilder.toString();
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (String str3) {
            str3.printStackTrace();
        }
    }

    private void b() {
        if (this.g != 0) {
            d("update thread is running, return");
            return;
        }
        this.g = 1;
        final Bundle bundle = new Bundle();
        bundle.putString("appid", this.d);
        bundle.putString("appid_for_getting_config", this.d);
        bundle.putString("status_os", VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new Thread(this) {
            final /* synthetic */ e b;

            public void run() {
                try {
                    this.b.a(i.d(HttpUtils.openUrl2(this.b.c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).a));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.b.g = 0;
            }
        }.start();
    }

    private void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f = SystemClock.elapsedRealtime();
    }

    private void c() {
        int optInt = this.e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f >= ((long) (optInt * 3600000))) {
            b();
        }
    }

    public int a(String str) {
        StringBuilder stringBuilder = new StringBuilder("get ");
        stringBuilder.append(str);
        d(stringBuilder.toString());
        c();
        return this.e.optInt(str);
    }

    public boolean b(String str) {
        StringBuilder stringBuilder = new StringBuilder("get ");
        stringBuilder.append(str);
        d(stringBuilder.toString());
        c();
        str = this.e.opt(str);
        if (str == null) {
            return false;
        }
        if (str instanceof Integer) {
            if (str.equals(Integer.valueOf(0)) == null) {
                return true;
            }
            return false;
        } else if (str instanceof Boolean) {
            return ((Boolean) str).booleanValue();
        } else {
            return false;
        }
    }

    private void d(String str) {
        if (this.h) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("; appid: ");
            stringBuilder.append(this.d);
            f.a("openSDK_LOG.OpenConfig", stringBuilder.toString());
        }
    }
}
