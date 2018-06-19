package com.tencent.smtt.sdk.a;

import a.a;
import android.content.Context;

final class c extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;

    c(String str, Context context, a aVar) {
        this.a = context;
        this.b = aVar;
        super(str);
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 8;
        if (r0 >= r1) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = com.tencent.smtt.sdk.a.b.a;
        r1 = 0;
        if (r0 != 0) goto L_0x0020;
    L_0x000c:
        r0 = "65dRa93L";	 Catch:{ UnsupportedEncodingException -> 0x0017 }
        r2 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x0017 }
        r0 = r0.getBytes(r2);	 Catch:{ UnsupportedEncodingException -> 0x0017 }
        com.tencent.smtt.sdk.a.b.a = r0;	 Catch:{ UnsupportedEncodingException -> 0x0017 }
        goto L_0x0020;
    L_0x0017:
        com.tencent.smtt.sdk.a.b.a = r1;
        r0 = "sdkreport";
        r2 = "Post failed -- get POST_DATA_KEY failed!";
        com.tencent.smtt.utils.TbsLog.e(r0, r2);
    L_0x0020:
        r0 = com.tencent.smtt.sdk.a.b.a;
        if (r0 != 0) goto L_0x002c;
    L_0x0024:
        r0 = "sdkreport";
        r1 = "Post failed -- POST_DATA_KEY is null!";
        com.tencent.smtt.utils.TbsLog.e(r0, r1);
        return;
    L_0x002c:
        r0 = r8.a;
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r0);
        r0 = r0.mPreferences;
        r2 = "tbs_deskey_token";
        r3 = "";
        r0 = r0.getString(r2, r3);
        r2 = "";
        r3 = "";
        r4 = android.text.TextUtils.isEmpty(r0);
        r5 = 0;
        r6 = 1;
        if (r4 != 0) goto L_0x0061;
    L_0x0048:
        r2 = "&";
        r2 = r0.indexOf(r2);
        r2 = r0.substring(r5, r2);
        r3 = "&";
        r3 = r0.indexOf(r3);
        r3 = r3 + r6;
        r4 = r0.length();
        r3 = r0.substring(r3, r4);
    L_0x0061:
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 != 0) goto L_0x0080;
    L_0x0067:
        r0 = r2.length();
        r4 = 96;
        if (r0 != r4) goto L_0x0080;
    L_0x006f:
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 != 0) goto L_0x0080;
    L_0x0075:
        r0 = r3.length();
        r4 = 24;
        if (r0 == r4) goto L_0x007e;
    L_0x007d:
        goto L_0x0080;
    L_0x007e:
        r0 = r5;
        goto L_0x0081;
    L_0x0080:
        r0 = r6;
    L_0x0081:
        r4 = com.tencent.smtt.utils.x.a();	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        if (r0 == 0) goto L_0x00a3;	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
    L_0x0087:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r2.<init>();	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r4 = r4.b();	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r2.append(r4);	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r4 = com.tencent.smtt.utils.p.a();	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r4 = r4.b();	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r2.append(r4);	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        goto L_0x00b6;	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
    L_0x00a3:
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r7.<init>();	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r4 = r4.f();	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r7.append(r4);	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r7.append(r2);	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r2 = r7.toString();	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
    L_0x00b6:
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r4.<init>(r2);	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r2 = r4.openConnection();	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r4 = "POST";	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r2.setRequestMethod(r4);	 Catch:{ IOException -> 0x0181, AssertionError -> 0x016c, NoClassDefFoundError -> 0x0157 }
        r2.setDoOutput(r6);
        r2.setDoInput(r6);
        r2.setUseCaches(r5);
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r2.setConnectTimeout(r4);
        r4 = android.os.Build.VERSION.SDK_INT;
        r5 = 13;
        if (r4 <= r5) goto L_0x00e1;
    L_0x00da:
        r4 = "Connection";
        r5 = "close";
        r2.setRequestProperty(r4, r5);
    L_0x00e1:
        r4 = r8.b;	 Catch:{ Exception -> 0x00eb }
        r5 = r8.a;	 Catch:{ Exception -> 0x00eb }
        r4 = com.tencent.smtt.sdk.a.b.c(r4, r5);	 Catch:{ Exception -> 0x00eb }
        r1 = r4;
        goto L_0x00ef;
    L_0x00eb:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x00ef:
        if (r1 != 0) goto L_0x00f9;
    L_0x00f1:
        r0 = "sdkreport";
        r1 = "post -- jsonData is null!";
        com.tencent.smtt.utils.TbsLog.e(r0, r1);
        return;
    L_0x00f9:
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0156 }
        r4 = "utf-8";	 Catch:{ Throwable -> 0x0156 }
        r1 = r1.getBytes(r4);	 Catch:{ Throwable -> 0x0156 }
        if (r0 == 0) goto L_0x010e;	 Catch:{ Throwable -> 0x0156 }
    L_0x0105:
        r0 = com.tencent.smtt.utils.p.a();	 Catch:{ Throwable -> 0x0156 }
        r0 = r0.a(r1);	 Catch:{ Throwable -> 0x0156 }
        goto L_0x0112;	 Catch:{ Throwable -> 0x0156 }
    L_0x010e:
        r0 = com.tencent.smtt.utils.p.a(r1, r3);	 Catch:{ Throwable -> 0x0156 }
    L_0x0112:
        r1 = "Content-Type";
        r3 = "application/x-www-form-urlencoded";
        r2.setRequestProperty(r1, r3);
        r1 = "Content-Length";
        r3 = r0.length;
        r3 = java.lang.String.valueOf(r3);
        r2.setRequestProperty(r1, r3);
        r1 = r2.getOutputStream();	 Catch:{ Throwable -> 0x013e }
        r1.write(r0);	 Catch:{ Throwable -> 0x013e }
        r1.flush();	 Catch:{ Throwable -> 0x013e }
        r0 = r2.getResponseCode();	 Catch:{ Throwable -> 0x013e }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Throwable -> 0x013e }
        if (r0 != r1) goto L_0x0136;	 Catch:{ Throwable -> 0x013e }
    L_0x0135:
        return;	 Catch:{ Throwable -> 0x013e }
    L_0x0136:
        r0 = "sdkreport";	 Catch:{ Throwable -> 0x013e }
        r1 = "Post failed -- not 200";	 Catch:{ Throwable -> 0x013e }
        com.tencent.smtt.utils.TbsLog.e(r0, r1);	 Catch:{ Throwable -> 0x013e }
        return;
    L_0x013e:
        r0 = move-exception;
        r1 = "sdkreport";
        r2 = new java.lang.StringBuilder;
        r3 = "Post failed -- exceptions:";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r2.append(r0);
        r0 = r2.toString();
        com.tencent.smtt.utils.TbsLog.e(r1, r0);
    L_0x0156:
        return;
    L_0x0157:
        r0 = move-exception;
        r1 = "sdkreport";
        r2 = new java.lang.StringBuilder;
        r3 = "Post failed -- NoClassDefFoundError:";
        r2.<init>(r3);
        r2.append(r0);
        r0 = r2.toString();
        com.tencent.smtt.utils.TbsLog.e(r1, r0);
        return;
    L_0x016c:
        r0 = move-exception;
        r1 = "sdkreport";
        r2 = new java.lang.StringBuilder;
        r3 = "Post failed -- AssertionError:";
        r2.<init>(r3);
        r2.append(r0);
        r0 = r2.toString();
        com.tencent.smtt.utils.TbsLog.e(r1, r0);
        return;
    L_0x0181:
        r0 = move-exception;
        r1 = "sdkreport";
        r2 = new java.lang.StringBuilder;
        r3 = "Post failed -- IOException:";
        r2.<init>(r3);
        r2.append(r0);
        r0 = r2.toString();
        com.tencent.smtt.utils.TbsLog.e(r1, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.c.run():void");
    }
}
