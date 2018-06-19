package com.igexin.push.util;

import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.tencent.bugly.BuglyStrategy.a;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class r {
    public static final String a = "com.igexin.push.util.r";

    private static String a(InputStream inputStream, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[256];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            str = stringWriter.toString();
            return str;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static String a(String str) {
        String str2 = "utf-8";
        if (!TextUtils.isEmpty(str)) {
            for (String trim : str.split(h.b)) {
                String trim2 = trim2.trim();
                if (trim2.startsWith("charset")) {
                    String[] split = trim2.split("=", 2);
                    if (split.length == 2 && !TextUtils.isEmpty(split[1])) {
                        return split[1].trim();
                    }
                }
            }
        }
        return str2;
    }

    private static HttpURLConnection a(URL url, String str, String str2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.setReadTimeout(a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_USER_AGENT, "GETUI");
        httpURLConnection.setRequestProperty("Content-Type", str2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url.getHost());
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(url.getPort());
        httpURLConnection.setRequestProperty("HOST", stringBuilder.toString());
        return httpURLConnection;
    }

    private static byte[] a(java.io.InputStream r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x002d, all -> 0x0025 }
        r1.<init>(r5);	 Catch:{ Exception -> 0x002d, all -> 0x0025 }
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r5.<init>(r2);	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
    L_0x000f:
        r3 = r1.read(r2);	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r4 = -1;	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        if (r3 == r4) goto L_0x001b;	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
    L_0x0016:
        r4 = 0;	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r5.write(r2, r4, r3);	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        goto L_0x000f;	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
    L_0x001b:
        r5 = r5.toByteArray();	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r1.close();	 Catch:{ IOException -> 0x0022 }
    L_0x0022:
        return r5;
    L_0x0023:
        r5 = move-exception;
        goto L_0x0027;
    L_0x0025:
        r5 = move-exception;
        r1 = r0;
    L_0x0027:
        if (r1 == 0) goto L_0x002c;
    L_0x0029:
        r1.close();	 Catch:{ IOException -> 0x002c }
    L_0x002c:
        throw r5;
    L_0x002d:
        r1 = r0;
    L_0x002e:
        if (r1 == 0) goto L_0x0033;
    L_0x0030:
        r1.close();	 Catch:{ IOException -> 0x0033 }
    L_0x0033:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.r.a(java.io.InputStream):byte[]");
    }

    public static byte[] a(String str, String str2, byte[] bArr, int i, int i2) {
        Exception e;
        Throwable th;
        IOException e2;
        OutputStream outputStream = null;
        HttpURLConnection a;
        try {
            a = a(new URL(str), "POST", str2);
            try {
                a.setConnectTimeout(i);
                a.setReadTimeout(i2);
                try {
                    OutputStream outputStream2 = a.getOutputStream();
                    try {
                        outputStream2.write(bArr);
                        bArr = a(a);
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        return bArr;
                    } catch (Exception e3) {
                        e = e3;
                        outputStream = outputStream2;
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    throw e;
                }
            } catch (IOException e5) {
                e2 = e5;
                throw e2;
            } catch (Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                throw th;
            }
        } catch (IOException e6) {
            e2 = e6;
            OutputStream outputStream3 = null;
            throw e2;
        } catch (Throwable th4) {
            th = th4;
            a = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            throw th;
        }
    }

    public static byte[] a(String str, byte[] bArr, int i, int i2) {
        return a(str, "application/octet-stream", bArr, i, i2);
    }

    private static byte[] a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getErrorStream() == null ? a(httpURLConnection.getInputStream()) : b(httpURLConnection).getBytes();
    }

    private static String b(HttpURLConnection httpURLConnection) {
        Object a = a(httpURLConnection.getErrorStream(), a(httpURLConnection.getContentType()));
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(httpURLConnection.getResponseCode());
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(httpURLConnection.getResponseMessage());
        throw new IOException(stringBuilder.toString());
    }
}
