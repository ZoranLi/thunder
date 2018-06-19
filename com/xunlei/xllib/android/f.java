package com.xunlei.xllib.android;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: XunleiPeerIdSolution */
public abstract class f {
    private static String a;

    public static java.lang.String a(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "";
        if (r2 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r1 = "wifi";	 Catch:{ Exception -> 0x0027 }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x0027 }
        r2 = (android.net.wifi.WifiManager) r2;	 Catch:{ Exception -> 0x0027 }
        if (r2 != 0) goto L_0x0011;	 Catch:{ Exception -> 0x0027 }
    L_0x000f:
        r2 = 0;	 Catch:{ Exception -> 0x0027 }
        goto L_0x0015;	 Catch:{ Exception -> 0x0027 }
    L_0x0011:
        r2 = r2.getConnectionInfo();	 Catch:{ Exception -> 0x0027 }
    L_0x0015:
        if (r2 == 0) goto L_0x0027;	 Catch:{ Exception -> 0x0027 }
    L_0x0017:
        r2 = r2.getMacAddress();	 Catch:{ Exception -> 0x0027 }
        r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0026 }
        if (r0 != 0) goto L_0x0026;	 Catch:{ Exception -> 0x0026 }
    L_0x0021:
        r0 = r2.toUpperCase();	 Catch:{ Exception -> 0x0026 }
        goto L_0x0027;
    L_0x0026:
        r0 = r2;
    L_0x0027:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.android.f.a(android.content.Context):java.lang.String");
    }

    public static String b(Context context) {
        if (context != null) {
            if (TextUtils.isEmpty(a)) {
                context = context.getApplicationContext().getDir("lnv1awq", 0);
                File file = new File(context, ".lnv1awq");
                if (file.exists()) {
                    Object obj = "";
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[512];
                            int read = fileInputStream.read(bArr);
                            obj = read > 0 ? new String(bArr, 0, read).trim() : obj;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    String str = null;
                    if (!TextUtils.isEmpty(obj)) {
                        Matcher matcher = Pattern.compile("[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-(?:[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}|[0-9a-fA-F]{16})").matcher(obj);
                        if (matcher.find()) {
                            str = obj.substring(matcher.start(), matcher.end()).toUpperCase();
                        }
                    }
                    a = str;
                }
                if (TextUtils.isEmpty(a)) {
                    a = UUID.randomUUID().toString().toUpperCase();
                    if (!context.exists()) {
                        context.mkdir();
                    }
                    try {
                        context = new FileOutputStream(file);
                        try {
                            context.write(a.getBytes("UTF-8"));
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        context.close();
                    } catch (Context context2) {
                        context2.printStackTrace();
                    }
                }
                return a;
            }
        }
        return a;
    }
}
