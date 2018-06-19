package com.alibaba.sdk.android.feedback.util.a;

import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.xblink.f.a.e;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

public class b extends a {
    private ByteArrayOutputStream c = new ByteArrayOutputStream();
    private float d = 0.0f;
    private boolean e;

    public b(String str) {
        super(null, str);
    }

    public b(Map map, IWxCallback iWxCallback, String str) {
        super(iWxCallback, a(str, map));
    }

    private static String a(String str, Map map) {
        String str2 = "";
        CharSequence stringBuilder = new StringBuilder();
        if (map != null) {
            Object obj = 1;
            for (Entry entry : map.entrySet()) {
                String str3 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str3)) {
                    if ("deviceId".equals(entry.getKey())) {
                        str2 = (String) entry.getValue();
                    } else {
                        if (obj == null) {
                            stringBuilder.append("&");
                        }
                        obj = null;
                        stringBuilder.append((String) entry.getKey());
                        stringBuilder.append("=");
                        stringBuilder.append(str3);
                    }
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder(str);
        try {
            StringBuilder stringBuilder3 = new StringBuilder(stringBuilder);
            stringBuilder3.append("&deviceId=");
            stringBuilder3.append(str2);
            CharSequence stringBuilder4 = new StringBuilder(stringBuilder);
            stringBuilder4.append("&deviceId=");
            stringBuilder4.append(URLEncoder.encode(str2, "UTF-8"));
            Object a = e.a(stringBuilder3.toString());
            if (!TextUtils.isEmpty(stringBuilder4.toString())) {
                stringBuilder2.append("?");
                stringBuilder2.append(stringBuilder4);
                if (!TextUtils.isEmpty(a)) {
                    stringBuilder2.append("&sign=");
                    stringBuilder2.append(a);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return stringBuilder2.toString();
    }

    public byte[] a() {
        return b();
    }

    public byte[] b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r11 = this;
        r0 = "";
        r1 = 1;
        r2 = 0;
        r3 = 0;
        r4 = new java.net.URL;	 Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        r5 = r11.b;	 Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        r5 = r4.openConnection();	 Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        r5 = (java.net.HttpURLConnection) r5;	 Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        r6 = "GET";	 Catch:{ Exception -> 0x00c2, all -> 0x00bf }
        r5.setRequestMethod(r6);	 Catch:{ Exception -> 0x00c2, all -> 0x00bf }
        r6 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;	 Catch:{ Exception -> 0x00c2, all -> 0x00bf }
        r5.setConnectTimeout(r6);	 Catch:{ Exception -> 0x00c2, all -> 0x00bf }
        r5.connect();	 Catch:{ Exception -> 0x00c2, all -> 0x00bf }
        r6 = r5.getResponseCode();	 Catch:{ Exception -> 0x00c2, all -> 0x00bf }
        r7 = r5.getResponseMessage();	 Catch:{ Exception -> 0x00b8, all -> 0x00bf }
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r6) goto L_0x0099;
    L_0x002b:
        r0 = r5.getInputStream();	 Catch:{ Exception -> 0x0097, all -> 0x00bf }
        r4 = r11.a;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        if (r4 == 0) goto L_0x006e;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
    L_0x0033:
        r4 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r8 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r9 = "UTF-8";	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r8.<init>(r0, r9);	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r4.<init>(r8);	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0069 }
        r8.<init>();	 Catch:{ Exception -> 0x0069 }
    L_0x0044:
        r9 = r4.readLine();	 Catch:{ Exception -> 0x0069 }
        if (r9 == 0) goto L_0x004e;	 Catch:{ Exception -> 0x0069 }
    L_0x004a:
        r8.append(r9);	 Catch:{ Exception -> 0x0069 }
        goto L_0x0044;	 Catch:{ Exception -> 0x0069 }
    L_0x004e:
        r9 = r11.a;	 Catch:{ Exception -> 0x0069 }
        r10 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0069 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0069 }
        r10[r2] = r8;	 Catch:{ Exception -> 0x0069 }
        r9.onSuccess(r10);	 Catch:{ Exception -> 0x0069 }
        if (r5 == 0) goto L_0x0060;
    L_0x005d:
        r5.disconnect();	 Catch:{ Exception -> 0x0060 }
    L_0x0060:
        if (r0 == 0) goto L_0x0065;
    L_0x0062:
        r0.close();	 Catch:{ Exception -> 0x0065 }
    L_0x0065:
        r4.close();	 Catch:{ Exception -> 0x0068 }
    L_0x0068:
        return r3;
    L_0x0069:
        r2 = move-exception;
        r8 = r6;
        r6 = r3;
        goto L_0x00d4;
    L_0x006e:
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r4.<init>();	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r8 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r8 = new byte[r8];	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
    L_0x0077:
        r9 = r0.read(r8);	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r10 = -1;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        if (r9 == r10) goto L_0x0082;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
    L_0x007e:
        r4.write(r8, r2, r9);	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        goto L_0x0077;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
    L_0x0082:
        r2 = r4.toByteArray();	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r4.close();	 Catch:{ Exception -> 0x008a, all -> 0x0091 }
        goto L_0x00ad;
    L_0x008a:
        r4 = move-exception;
        r8 = r6;
        r6 = r2;
        r2 = r4;
        r4 = r3;
        goto L_0x00d4;
    L_0x0091:
        r1 = move-exception;
        goto L_0x010e;
    L_0x0094:
        r2 = move-exception;
        r4 = r3;
        goto L_0x00bc;
    L_0x0097:
        r2 = move-exception;
        goto L_0x00ba;
    L_0x0099:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0097, all -> 0x00bf }
        r2 = "response.getStatusLine().getStatusCode() + ";	 Catch:{ Exception -> 0x0097, all -> 0x00bf }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0097, all -> 0x00bf }
        r0.append(r6);	 Catch:{ Exception -> 0x0097, all -> 0x00bf }
        r2 = "URL:";	 Catch:{ Exception -> 0x0097, all -> 0x00bf }
        r0.append(r2);	 Catch:{ Exception -> 0x0097, all -> 0x00bf }
        r0.append(r4);	 Catch:{ Exception -> 0x0097, all -> 0x00bf }
        r0 = r3;
        r2 = r0;
    L_0x00ad:
        if (r5 == 0) goto L_0x00b2;
    L_0x00af:
        r5.disconnect();	 Catch:{ Exception -> 0x00b2 }
    L_0x00b2:
        if (r0 == 0) goto L_0x00e8;
    L_0x00b4:
        r0.close();	 Catch:{ Exception -> 0x00e8 }
        goto L_0x00e8;
    L_0x00b8:
        r2 = move-exception;
        r7 = r0;
    L_0x00ba:
        r0 = r3;
        r4 = r0;
    L_0x00bc:
        r8 = r6;
        r6 = r4;
        goto L_0x00d4;
    L_0x00bf:
        r1 = move-exception;
        r0 = r3;
        goto L_0x010e;
    L_0x00c2:
        r4 = move-exception;
        r7 = r0;
        r8 = r2;
        r0 = r3;
        r6 = r0;
        goto L_0x00d2;
    L_0x00c8:
        r1 = move-exception;
        r0 = r3;
        r5 = r0;
        goto L_0x010e;
    L_0x00cc:
        r4 = move-exception;
        r7 = r0;
        r8 = r2;
        r0 = r3;
        r5 = r0;
        r6 = r5;
    L_0x00d2:
        r2 = r4;
        r4 = r6;
    L_0x00d4:
        r2.getMessage();	 Catch:{ all -> 0x010c }
        if (r5 == 0) goto L_0x00dc;
    L_0x00d9:
        r5.disconnect();	 Catch:{ Exception -> 0x00dc }
    L_0x00dc:
        if (r0 == 0) goto L_0x00e1;
    L_0x00de:
        r0.close();	 Catch:{ Exception -> 0x00e1 }
    L_0x00e1:
        if (r4 == 0) goto L_0x00e6;
    L_0x00e3:
        r4.close();	 Catch:{ Exception -> 0x00e6 }
    L_0x00e6:
        r2 = r6;
        r6 = r8;
    L_0x00e8:
        if (r2 == 0) goto L_0x00eb;
    L_0x00ea:
        return r2;
    L_0x00eb:
        r0 = new java.lang.StringBuilder;
        r2 = "doHttpRequestGet end, url:";
        r0.<init>(r2);
        r2 = r11.b;
        r0.append(r2);
        r0 = r11.e;
        if (r0 == 0) goto L_0x0105;
    L_0x00fb:
        r0 = r11.a;
        if (r0 == 0) goto L_0x0104;
    L_0x00ff:
        r0 = r11.a;
        r0.onError(r6, r7);
    L_0x0104:
        return r3;
    L_0x0105:
        r11.e = r1;
        r0 = r11.b();
        return r0;
    L_0x010c:
        r1 = move-exception;
        r3 = r4;
    L_0x010e:
        if (r5 == 0) goto L_0x0113;
    L_0x0110:
        r5.disconnect();	 Catch:{ Exception -> 0x0113 }
    L_0x0113:
        if (r0 == 0) goto L_0x0118;
    L_0x0115:
        r0.close();	 Catch:{ Exception -> 0x0118 }
    L_0x0118:
        if (r3 == 0) goto L_0x011d;
    L_0x011a:
        r3.close();	 Catch:{ Exception -> 0x011d }
    L_0x011d:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.util.a.b.b():byte[]");
    }
}
