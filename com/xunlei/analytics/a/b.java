package com.xunlei.analytics.a;

import android.text.TextUtils;
import android.util.Log;
import com.xunlei.analytics.c.e;
import com.xunlei.analytics.config.a;
import com.xunlei.analytics.dbstore.AnalyticsConstant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b {
    private static final int a = 20000;
    private static final int b = 20000;

    private static String a() {
        int f = a.f();
        return f == 1 ? AnalyticsConstant.API_TEST_URL : f == 2 ? AnalyticsConstant.API_PRE_URL : AnalyticsConstant.API_RELEASE_URL;
    }

    private static String a(String str, int i, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a());
        stringBuilder.append("?appId=");
        stringBuilder.append(a.a());
        stringBuilder.append("&discardCount=");
        stringBuilder.append(i);
        stringBuilder.append("&sig=");
        stringBuilder.append(str);
        stringBuilder.append("&callId=");
        stringBuilder.append(str3);
        stringBuilder.append("&octet=");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private static String a(String str, byte[] bArr) {
        BufferedReader bufferedReader;
        Exception e;
        Throwable th;
        String str2 = "";
        OutputStream outputStream = null;
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setRequestProperty("accept", "*/*");
            openConnection.setRequestProperty("connection", "Keep-Alive");
            openConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            openConnection.setReadTimeout(20000);
            openConnection.setConnectTimeout(20000);
            openConnection.setRequestProperty("Content-Type", "application/octet-stream");
            String valueOf = String.valueOf(bArr.length);
            openConnection.setRequestProperty("Content-Length", valueOf);
            b(valueOf);
            openConnection.setDoOutput(true);
            openConnection.setDoInput(true);
            OutputStream outputStream2 = openConnection.getOutputStream();
            try {
                outputStream2.write(bArr);
                outputStream2.flush();
                bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
                while (true) {
                    try {
                        str = bufferedReader.readLine();
                        if (str == null) {
                            break;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str2);
                        stringBuilder.append(str);
                        str2 = stringBuilder.toString();
                    } catch (Exception e2) {
                        e = e2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return str2;
                    }
                }
                bufferedReader.close();
                return str2;
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                outputStream = outputStream2;
                try {
                    a(e);
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return str2;
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                outputStream = outputStream2;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            a(e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str2;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    private static String a(List<com.xunlei.analytics.dbstore.b> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (com.xunlei.analytics.dbstore.b bVar : list) {
            stringBuffer.append(bVar.c);
            stringBuffer.append("\n");
            a(bVar);
        }
        return stringBuffer.toString();
    }

    private static void a(com.xunlei.analytics.dbstore.b bVar) {
        if (e.a()) {
            StringBuilder stringBuilder = new StringBuilder("upload event content = ");
            stringBuilder.append(bVar.c);
            e.a(stringBuilder.toString());
        }
    }

    private static void a(Exception exception) {
        if (e.a()) {
            StringBuilder stringBuilder = new StringBuilder("upload error =");
            stringBuilder.append(Log.getStackTraceString(exception));
            e.a(stringBuilder.toString());
        }
    }

    private static void a(String str) {
        if (e.a()) {
            StringBuilder stringBuilder = new StringBuilder("event data request url  = ");
            stringBuilder.append(str);
            e.a(stringBuilder.toString());
        }
    }

    public static boolean a(List<com.xunlei.analytics.dbstore.b> list, int i) {
        try {
            byte[] a = com.xunlei.analytics.c.a.a(com.xunlei.analytics.c.a.a(a((List) list)), a.b());
            String a2 = com.xunlei.analytics.c.a.a(a);
            Map hashMap = new HashMap();
            hashMap.put("appId", a.a());
            hashMap.put("discardCount", String.valueOf(i));
            hashMap.put("octet", a2);
            String valueOf = String.valueOf(System.currentTimeMillis());
            hashMap.put("callId", valueOf);
            String a3 = a(com.xunlei.analytics.c.a.a(hashMap, a.b()), i, a2, valueOf);
            a(a3);
            return c(a(a3, a));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void b(String str) {
        if (e.a()) {
            StringBuilder stringBuilder = new StringBuilder("total upoload data length :");
            stringBuilder.append(str);
            e.a(stringBuilder.toString());
        }
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            d(str);
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("result") && jSONObject.getInt("result") == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void d(String str) {
        if (e.a()) {
            StringBuilder stringBuilder = new StringBuilder("mResult = ");
            stringBuilder.append(str);
            e.a(stringBuilder.toString());
        }
    }
}
