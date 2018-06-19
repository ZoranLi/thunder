package com.xiaomi.metoknlp.a;

public class b {
    public static java.lang.String a(java.lang.String r6, java.util.Map r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "";
        r1 = android.text.TextUtils.isEmpty(r6);
        if (r1 == 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00c1 }
        r1.<init>(r6);	 Catch:{ MalformedURLException -> 0x00c1 }
        r6 = 0;
        r2 = r1.getProtocol();	 Catch:{ Exception -> 0x00b8, all -> 0x00ab }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x00b8, all -> 0x00ab }
        r3 = "https";	 Catch:{ Exception -> 0x00b8, all -> 0x00ab }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x00b8, all -> 0x00ab }
        if (r2 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x00b8, all -> 0x00ab }
    L_0x001f:
        r1 = r1.openConnection();	 Catch:{ Exception -> 0x00b8, all -> 0x00ab }
        r1 = (javax.net.ssl.HttpsURLConnection) r1;	 Catch:{ Exception -> 0x00b8, all -> 0x00ab }
        goto L_0x002c;	 Catch:{ Exception -> 0x00b8, all -> 0x00ab }
    L_0x0026:
        r1 = r1.openConnection();	 Catch:{ Exception -> 0x00b8, all -> 0x00ab }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ Exception -> 0x00b8, all -> 0x00ab }
    L_0x002c:
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r1.setConnectTimeout(r2);	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r1.setReadTimeout(r2);	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r2 = "GET";	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r1.setRequestMethod(r2);	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r2 = 0;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r1.setDoOutput(r2);	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        if (r7 == 0) goto L_0x0063;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
    L_0x003f:
        r2 = r7.size();	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        if (r2 <= 0) goto L_0x0063;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
    L_0x0045:
        r2 = r7.keySet();	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
    L_0x004d:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        if (r3 == 0) goto L_0x0063;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
    L_0x0053:
        r3 = r2.next();	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r4 = r7.get(r3);	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r1.addRequestProperty(r3, r4);	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        goto L_0x004d;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
    L_0x0063:
        r1.connect();	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r7 = r1.getResponseCode();	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        if (r7 != r2) goto L_0x009e;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
    L_0x006e:
        r7 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r2 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r3 = r1.getInputStream();	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r7.<init>(r2);	 Catch:{ Exception -> 0x00b9, all -> 0x00a9 }
        r6 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x009c, all -> 0x0097 }
        r6.<init>();	 Catch:{ Exception -> 0x009c, all -> 0x0097 }
    L_0x0081:
        r2 = r7.readLine();	 Catch:{ Exception -> 0x009c, all -> 0x0097 }
        if (r2 == 0) goto L_0x008b;	 Catch:{ Exception -> 0x009c, all -> 0x0097 }
    L_0x0087:
        r6.append(r2);	 Catch:{ Exception -> 0x009c, all -> 0x0097 }
        goto L_0x0081;	 Catch:{ Exception -> 0x009c, all -> 0x0097 }
    L_0x008b:
        r6 = r6.toString();	 Catch:{ Exception -> 0x009c, all -> 0x0097 }
        r7.close();	 Catch:{ Exception -> 0x0095, all -> 0x0097 }
        r0 = r6;
        r6 = r7;
        goto L_0x009e;
    L_0x0095:
        r0 = r6;
        goto L_0x009c;
    L_0x0097:
        r6 = move-exception;
        r5 = r7;
        r7 = r6;
        r6 = r5;
        goto L_0x00ad;
    L_0x009c:
        r6 = r7;
        goto L_0x00b9;
    L_0x009e:
        if (r6 == 0) goto L_0x00a3;
    L_0x00a0:
        r6.close();	 Catch:{  }
    L_0x00a3:
        if (r1 == 0) goto L_0x00c1;	 Catch:{  }
    L_0x00a5:
        r1.disconnect();	 Catch:{  }
        return r0;
    L_0x00a9:
        r7 = move-exception;
        goto L_0x00ad;
    L_0x00ab:
        r7 = move-exception;
        r1 = r6;
    L_0x00ad:
        if (r6 == 0) goto L_0x00b2;
    L_0x00af:
        r6.close();	 Catch:{ Exception -> 0x00b7 }
    L_0x00b2:
        if (r1 == 0) goto L_0x00b7;	 Catch:{ Exception -> 0x00b7 }
    L_0x00b4:
        r1.disconnect();	 Catch:{ Exception -> 0x00b7 }
    L_0x00b7:
        throw r7;
    L_0x00b8:
        r1 = r6;
    L_0x00b9:
        if (r6 == 0) goto L_0x00be;
    L_0x00bb:
        r6.close();	 Catch:{  }
    L_0x00be:
        if (r1 == 0) goto L_0x00c1;
    L_0x00c0:
        goto L_0x00a5;
    L_0x00c1:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.b.a(java.lang.String, java.util.Map):java.lang.String");
    }
}
