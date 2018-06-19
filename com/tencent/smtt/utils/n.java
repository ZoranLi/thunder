package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import anet.channel.util.HttpConstant;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.push.service.av;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class n {

    public interface a {
        void a(int i);
    }

    public static String a(String str, Map<String, String> map, byte[] bArr, a aVar, boolean z) {
        String str2 = null;
        if (bArr == null) {
            return null;
        }
        HttpURLConnection a = a(str, (Map) map);
        if (a != null) {
            if (z) {
                a(a, bArr);
            } else {
                b(a, bArr);
            }
            str2 = a(a, aVar, false);
        }
        return str2;
    }

    public static String a(String str, byte[] bArr, a aVar, boolean z) {
        String c;
        byte[] a;
        String str2 = null;
        if (z) {
            try {
                c = q.a().c();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        c = p.a().b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(c);
        str = stringBuilder.toString();
        if (z) {
            try {
                a = q.a().a(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                a = bArr;
            }
        } else {
            a = p.a().a(bArr);
        }
        if (a == null) {
            return null;
        }
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", HttpRequest.CONTENT_TYPE_FORM);
        hashMap.put("Content-Length", String.valueOf(a.length));
        HttpURLConnection a2 = a(str, hashMap);
        if (a2 != null) {
            b(a2, a);
            str2 = a(a2, aVar, z);
        }
        return str2;
    }

    private static String a(HttpURLConnection httpURLConnection, a aVar, boolean z) {
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = null;
        Closeable byteArrayOutputStream;
        try {
            Closeable inflaterInputStream;
            String str;
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                inflaterInputStream = (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) ? (contentEncoding == null || !contentEncoding.equalsIgnoreCase("deflate")) ? inputStream : new InflaterInputStream(inputStream, new Inflater(true)) : new GZIPInputStream(inputStream);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th2) {
                    closeable2 = inflaterInputStream;
                    th = th2;
                    byteArrayOutputStream = null;
                    a(closeable2);
                    a(byteArrayOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[128];
                    while (true) {
                        int read = inflaterInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str = z ? new String(byteArrayOutputStream.toByteArray(), "utf-8") : new String(p.a().c(byteArrayOutputStream.toByteArray()));
                } catch (Throwable th3) {
                    closeable2 = inflaterInputStream;
                    th = th3;
                    a(closeable2);
                    a(byteArrayOutputStream);
                    throw th;
                }
            }
            inflaterInputStream = null;
            byteArrayOutputStream = inflaterInputStream;
            a(inflaterInputStream);
            a(byteArrayOutputStream);
            return str;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            a(closeable2);
            a(byteArrayOutputStream);
            throw th;
        }
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        Exception e;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                String str2;
                String str3;
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(20000);
                if (VERSION.SDK_INT > 13) {
                    str2 = HttpConstant.CONNECTION;
                    str3 = "close";
                } else {
                    str2 = "http.keepAlive";
                    str3 = av.b;
                }
                httpURLConnection2.setRequestProperty(str2, str3);
                for (Entry entry : map.entrySet()) {
                    httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                return httpURLConnection2;
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = httpURLConnection2;
                e.printStackTrace();
                return httpURLConnection;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return httpURLConnection;
        }
    }

    private static void a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ Exception -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.n.a(java.io.Closeable):void");
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        Closeable gZIPOutputStream;
        Exception e;
        Throwable th;
        try {
            gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    a(null);
                    a(gZIPOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    a(null);
                    a(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            gZIPOutputStream = null;
            e.printStackTrace();
            a(null);
            a(gZIPOutputStream);
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
            a(null);
            a(gZIPOutputStream);
            throw th;
        }
        a(null);
        a(gZIPOutputStream);
    }

    private static void b(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
