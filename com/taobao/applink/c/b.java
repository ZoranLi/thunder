package com.taobao.applink.c;

import android.text.TextUtils;
import com.taobao.applink.TBAppLinkSDK;
import com.taobao.applink.util.TBAppLinkUtil;
import com.taobao.applink.util.d;
import com.taobao.applink.util.e;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class b {
    private static volatile b c;
    private CharSequence a;
    private String b;
    private Map d;
    private a e;

    public interface a {
        void a(a aVar);
    }

    private b() {
        this.a = "unkown";
        this.d = new HashMap();
        this.a = b(d.a(TBAppLinkUtil.getApplication()));
        this.b = TBAppLinkSDK.getInstance().sOpenParam.mAppkey;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    private String b(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder("a");
        stringBuilder.append(new StringBuilder(str).reverse().toString());
        stringBuilder.append("z");
        return stringBuilder.toString();
    }

    private void b(com.taobao.applink.c.b.a r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = "https://nbsdk-baichuan.alicdn.com/2.0.0/applink.htm?plat=android&appKey=%s";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = r11.b;
        r3 = 0;
        r1[r3] = r2;
        r0 = java.lang.String.format(r0, r1);
        r1 = 0;
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x0183, all -> 0x017f }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0183, all -> 0x017f }
        r0 = r2.openConnection();	 Catch:{ Exception -> 0x0183, all -> 0x017f }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0183, all -> 0x017f }
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x017d, all -> 0x017a }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x017d, all -> 0x017a }
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x017d, all -> 0x017a }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x017d, all -> 0x017a }
        if (r2 != r3) goto L_0x016a;	 Catch:{ Exception -> 0x017d, all -> 0x017a }
    L_0x002a:
        r2 = r0.getInputStream();	 Catch:{ Exception -> 0x017d, all -> 0x017a }
        r3 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0185 }
        r4 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0185 }
        r5 = "UTF-8";	 Catch:{ Exception -> 0x0185 }
        r4.<init>(r2, r5);	 Catch:{ Exception -> 0x0185 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0185 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0185 }
        r4.<init>();	 Catch:{ Exception -> 0x0185 }
    L_0x003f:
        r5 = r3.readLine();	 Catch:{ Exception -> 0x0185 }
        if (r5 == 0) goto L_0x0049;	 Catch:{ Exception -> 0x0185 }
    L_0x0045:
        r4.append(r5);	 Catch:{ Exception -> 0x0185 }
        goto L_0x003f;	 Catch:{ Exception -> 0x0185 }
    L_0x0049:
        r3 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0185 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0185 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0185 }
        r4 = r11.e;	 Catch:{ Exception -> 0x0185 }
        if (r4 != 0) goto L_0x005d;	 Catch:{ Exception -> 0x0185 }
    L_0x0056:
        r4 = new com.taobao.applink.c.a;	 Catch:{ Exception -> 0x0185 }
        r4.<init>();	 Catch:{ Exception -> 0x0185 }
        r11.e = r4;	 Catch:{ Exception -> 0x0185 }
    L_0x005d:
        r4 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r4.a(r3);	 Catch:{ Exception -> 0x0185 }
        r4 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r4 = r4.a();	 Catch:{ Exception -> 0x0185 }
        if (r4 != 0) goto L_0x008f;	 Catch:{ Exception -> 0x0185 }
    L_0x006a:
        r12 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0185 }
        r12.<init>();	 Catch:{ Exception -> 0x0185 }
        r3 = "isSuccess=1&configExist=0";	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = com.taobao.applink.util.TBAppLinkUtil.getConfigUrl();	 Catch:{ Exception -> 0x0185 }
        r12 = r12.toString();	 Catch:{ Exception -> 0x0185 }
        r11.b(r3, r1, r12);	 Catch:{ Exception -> 0x0185 }
        if (r0 == 0) goto L_0x0084;
    L_0x0081:
        r0.disconnect();
    L_0x0084:
        if (r2 == 0) goto L_0x008e;
    L_0x0086:
        r2.close();	 Catch:{ IOException -> 0x008a }
        return;
    L_0x008a:
        r12 = move-exception;
        r12.printStackTrace();
    L_0x008e:
        return;
    L_0x008f:
        r4 = "appLinkConfig";	 Catch:{ Exception -> 0x0185 }
        r3 = r3.optJSONObject(r4);	 Catch:{ Exception -> 0x0185 }
        if (r3 != 0) goto L_0x00bc;	 Catch:{ Exception -> 0x0185 }
    L_0x0097:
        r12 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0185 }
        r12.<init>();	 Catch:{ Exception -> 0x0185 }
        r3 = "isSuccess=0&configExist=0";	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = com.taobao.applink.util.TBAppLinkUtil.getConfigUrl();	 Catch:{ Exception -> 0x0185 }
        r12 = r12.toString();	 Catch:{ Exception -> 0x0185 }
        r11.b(r3, r1, r12);	 Catch:{ Exception -> 0x0185 }
        if (r0 == 0) goto L_0x00b1;
    L_0x00ae:
        r0.disconnect();
    L_0x00b1:
        if (r2 == 0) goto L_0x00bb;
    L_0x00b3:
        r2.close();	 Catch:{ IOException -> 0x00b7 }
        return;
    L_0x00b7:
        r12 = move-exception;
        r12.printStackTrace();
    L_0x00bb:
        return;
    L_0x00bc:
        r4 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r5 = "exp";	 Catch:{ Exception -> 0x0185 }
        r5 = r3.optLong(r5);	 Catch:{ Exception -> 0x0185 }
        r4.d = r5;	 Catch:{ Exception -> 0x0185 }
        r4 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r5 = "taobao_scheme";	 Catch:{ Exception -> 0x0185 }
        r5 = r3.optString(r5);	 Catch:{ Exception -> 0x0185 }
        r4.b = r5;	 Catch:{ Exception -> 0x0185 }
        r4 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r5 = "tmall_scheme";	 Catch:{ Exception -> 0x0185 }
        r5 = r3.optString(r5);	 Catch:{ Exception -> 0x0185 }
        r4.c = r5;	 Catch:{ Exception -> 0x0185 }
        r4 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r5 = "sign";	 Catch:{ Exception -> 0x0185 }
        r3 = r3.optString(r5);	 Catch:{ Exception -> 0x0185 }
        r4.f = r3;	 Catch:{ Exception -> 0x0185 }
        r3 = r11.d;	 Catch:{ Exception -> 0x0185 }
        if (r3 != 0) goto L_0x00ef;	 Catch:{ Exception -> 0x0185 }
    L_0x00e8:
        r3 = new java.util.HashMap;	 Catch:{ Exception -> 0x0185 }
        r3.<init>();	 Catch:{ Exception -> 0x0185 }
        r11.d = r3;	 Catch:{ Exception -> 0x0185 }
    L_0x00ef:
        r3 = r11.d;	 Catch:{ Exception -> 0x0185 }
        r4 = r11.b;	 Catch:{ Exception -> 0x0185 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0185 }
        r3.remove(r4);	 Catch:{ Exception -> 0x0185 }
        r3 = r11.d;	 Catch:{ Exception -> 0x0185 }
        r4 = r11.b;	 Catch:{ Exception -> 0x0185 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0185 }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0185 }
        r7 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r7 = r7.d;	 Catch:{ Exception -> 0x0185 }
        r9 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x0185 }
        r7 = r7 * r9;	 Catch:{ Exception -> 0x0185 }
        r9 = r5 + r7;	 Catch:{ Exception -> 0x0185 }
        r5 = java.lang.Long.valueOf(r9);	 Catch:{ Exception -> 0x0185 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x0185 }
        if (r12 == 0) goto L_0x011d;	 Catch:{ Exception -> 0x0185 }
    L_0x0118:
        r3 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r12.a(r3);	 Catch:{ Exception -> 0x0185 }
    L_0x011d:
        r12 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0185 }
        r12.<init>();	 Catch:{ Exception -> 0x0185 }
        r3 = "isSuccess=1&configExist=1&appkeyExist=1&taobao_scheme=";	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r3 = r3.b;	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = "&tmall_scheme=";	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r3 = r3.c;	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = "&sug=";	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r3 = r3.e;	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = "&sign=";	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r3 = r3.f;	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = "&exp=";	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = r11.e;	 Catch:{ Exception -> 0x0185 }
        r3 = r3.d;	 Catch:{ Exception -> 0x0185 }
        r12.append(r3);	 Catch:{ Exception -> 0x0185 }
        r3 = com.taobao.applink.util.TBAppLinkUtil.getConfigUrl();	 Catch:{ Exception -> 0x0185 }
        r12 = r12.toString();	 Catch:{ Exception -> 0x0185 }
        r11.b(r3, r1, r12);	 Catch:{ Exception -> 0x0185 }
        r1 = r2;
    L_0x016a:
        if (r0 == 0) goto L_0x016f;
    L_0x016c:
        r0.disconnect();
    L_0x016f:
        if (r1 == 0) goto L_0x01a9;
    L_0x0171:
        r1.close();	 Catch:{ IOException -> 0x0175 }
        return;
    L_0x0175:
        r12 = move-exception;
        r12.printStackTrace();
        return;
    L_0x017a:
        r12 = move-exception;
        r2 = r1;
        goto L_0x01ab;
    L_0x017d:
        r2 = r1;
        goto L_0x0185;
    L_0x017f:
        r12 = move-exception;
        r0 = r1;
        r2 = r0;
        goto L_0x01ab;
    L_0x0183:
        r0 = r1;
        r2 = r0;
    L_0x0185:
        r12 = new java.lang.StringBuffer;	 Catch:{ all -> 0x01aa }
        r12.<init>();	 Catch:{ all -> 0x01aa }
        r3 = "isSuccess=0&configExist=0";	 Catch:{ all -> 0x01aa }
        r12.append(r3);	 Catch:{ all -> 0x01aa }
        r3 = com.taobao.applink.util.TBAppLinkUtil.getConfigUrl();	 Catch:{ all -> 0x01aa }
        r12 = r12.toString();	 Catch:{ all -> 0x01aa }
        r11.b(r3, r1, r12);	 Catch:{ all -> 0x01aa }
        if (r0 == 0) goto L_0x019f;
    L_0x019c:
        r0.disconnect();
    L_0x019f:
        if (r2 == 0) goto L_0x01a9;
    L_0x01a1:
        r2.close();	 Catch:{ IOException -> 0x01a5 }
        return;
    L_0x01a5:
        r12 = move-exception;
        r12.printStackTrace();
    L_0x01a9:
        return;
    L_0x01aa:
        r12 = move-exception;
    L_0x01ab:
        if (r0 == 0) goto L_0x01b0;
    L_0x01ad:
        r0.disconnect();
    L_0x01b0:
        if (r2 == 0) goto L_0x01ba;
    L_0x01b2:
        r2.close();	 Catch:{ IOException -> 0x01b6 }
        goto L_0x01ba;
    L_0x01b6:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x01ba:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.applink.c.b.b(com.taobao.applink.c.b$a):void");
    }

    private void b(String str, String str2, String str3) {
        OutputStream outputStream;
        Throwable th;
        Throwable th2;
        StringBuffer stringBuffer = new StringBuffer();
        System.currentTimeMillis();
        stringBuffer.append("logtype=2&wappkey=");
        stringBuffer.append(this.b);
        stringBuffer.append("&packagename=");
        stringBuffer.append(com.taobao.applink.b.a.a(TBAppLinkUtil.getApplication()));
        stringBuffer.append("&os=android&deviceid=");
        stringBuffer.append(this.a);
        stringBuffer.append("&t=&sdkversion=2.0.0");
        if (!TextUtils.isEmpty(str3)) {
            stringBuffer.append("&");
            stringBuffer.append(str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("&type=");
            stringBuffer.append(str2);
        }
        if (!TextUtils.isEmpty(TBAppLinkSDK.getInstance().sOpenParam.mTtid)) {
            stringBuffer.append("&ttid=");
            stringBuffer.append(TBAppLinkSDK.getInstance().sOpenParam.mTtid);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("?");
        stringBuilder.append(stringBuffer.toString());
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(stringBuilder.toString()).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(ReaderCallback.GET_BAR_ANIMATING);
                httpURLConnection.setReadTimeout(ReaderCallback.GET_BAR_ANIMATING);
                outputStream = httpURLConnection.getOutputStream();
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                th2 = th;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
                throw th2;
            }
            try {
                outputStream.write(URLEncoder.encode(stringBuffer.toString(), "UTF-8").getBytes());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String str4 = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str4);
                    stringBuilder2.append("\n");
                    stringBuilder2.append(readLine);
                    str4 = stringBuilder2.toString();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                th2.getStackTrace().toString();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            }
        } catch (Throwable th5) {
            outputStream = null;
            th2 = th5;
            httpURLConnection = outputStream;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
            throw th2;
        }
    }

    public void a(a aVar) {
        try {
            new c(this, aVar).execute(new Void[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2, String str3) {
        if (!e.a(str)) {
            synchronized (this) {
                try {
                    new d(this, str, str2, str3).execute(new Void[0]);
                } catch (Exception e) {
                    e.getStackTrace().toString();
                }
            }
        }
    }

    public boolean a(String str) {
        return !this.d.containsKey(str) || ((Long) this.d.get(str)).longValue() - System.currentTimeMillis() < 1000;
    }

    public a b() {
        if (a(this.b)) {
            a(null);
        }
        return this.e;
    }
}
