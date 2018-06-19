package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.bugly.crashreport.common.info.b;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/* compiled from: BUGLY */
public class ai {
    private static ai c;
    protected Context a;
    public Map<String, String> b = null;

    protected boolean a(int i) {
        if (!(i == 301 || i == 302 || i == 303)) {
            if (i != 307) {
                return false;
            }
        }
        return true;
    }

    private ai(Context context) {
        this.a = context;
    }

    public static ai a(Context context) {
        if (c == null) {
            c = new ai(context);
        }
        return c;
    }

    public byte[] a(String str, byte[] bArr, al alVar, Map<String, String> map) {
        Throwable th;
        int i;
        Throwable th2;
        ai aiVar = this;
        byte[] bArr2 = bArr;
        al alVar2 = alVar;
        byte[] bArr3 = null;
        int i2 = 0;
        if (str == null) {
            an.e("Failed for no URL.", new Object[0]);
            return null;
        }
        long j;
        if (bArr2 == null) {
            j = 0;
        } else {
            j = (long) bArr2.length;
        }
        r12 = new Object[4];
        int i3 = 1;
        r12[1] = Long.valueOf(j);
        r12[2] = Integer.valueOf(Process.myPid());
        r12[3] = Integer.valueOf(Process.myTid());
        an.c("request: %s, send: %d (pid=%d | tid=%d)", r12);
        String str2 = str;
        int i4 = 0;
        int i5 = i4;
        int i6 = i5;
        while (i4 <= 0 && i5 <= 0) {
            if (i6 != 0) {
                i6 = i2;
            } else {
                i4++;
                if (i4 > i3) {
                    StringBuilder stringBuilder = new StringBuilder("try time: ");
                    stringBuilder.append(i4);
                    an.c(stringBuilder.toString(), new Object[i2]);
                    SystemClock.sleep(((long) new Random(System.currentTimeMillis()).nextInt(10000)) + 10000);
                }
            }
            String f = b.f(aiVar.a);
            if (f == null) {
                an.d("Failed to request for network not avail", new Object[0]);
                Map<String, String> map2 = map;
                i3 = 1;
            } else {
                alVar2.a(str2, j, f);
                HttpURLConnection a = a(str2, bArr2, f, (Map) map);
                if (a != null) {
                    try {
                        int responseCode = a.getResponseCode();
                        if (responseCode == 200) {
                            try {
                                long j2;
                                aiVar.b = b(a);
                                byte[] a2 = a(a);
                                if (a2 == null) {
                                    j2 = 0;
                                } else {
                                    j2 = (long) a2.length;
                                }
                                alVar2.a(j2);
                                try {
                                    a.disconnect();
                                } catch (Throwable th3) {
                                    if (!an.a(th3)) {
                                        th3.printStackTrace();
                                    }
                                }
                                return a2;
                            } catch (IOException e) {
                                th3 = e;
                                i = i6;
                                i3 = 1;
                            }
                        } else {
                            if (a(responseCode)) {
                                try {
                                    String headerField = a.getHeaderField("Location");
                                    if (headerField == null) {
                                        try {
                                            StringBuilder stringBuilder2 = new StringBuilder("Failed to redirect: %d");
                                            stringBuilder2.append(responseCode);
                                            an.e(stringBuilder2.toString(), new Object[0]);
                                            try {
                                                a.disconnect();
                                            } catch (Throwable th32) {
                                                if (!an.a(th32)) {
                                                    th32.printStackTrace();
                                                }
                                            }
                                            return null;
                                        } catch (IOException e2) {
                                            th32 = e2;
                                            i6 = i5;
                                            i3 = 1;
                                            i = 1;
                                            i5 = i4;
                                            th2 = th32;
                                            try {
                                                if (!an.a(th2)) {
                                                    th2.printStackTrace();
                                                }
                                                try {
                                                    a.disconnect();
                                                } catch (Throwable th322) {
                                                    if (!an.a(th322)) {
                                                        th322.printStackTrace();
                                                    }
                                                }
                                                i4 = i5;
                                                i5 = i6;
                                                i6 = i;
                                                bArr3 = null;
                                                i2 = 0;
                                            } catch (Throwable th3222) {
                                                if (!an.a(th3222)) {
                                                    th3222.printStackTrace();
                                                }
                                            }
                                        }
                                    } else {
                                        String str3;
                                        Object[] objArr;
                                        i5++;
                                        try {
                                            str3 = "redirect code: %d ,to:%s";
                                            objArr = new Object[2];
                                            objArr[0] = Integer.valueOf(responseCode);
                                            i3 = 1;
                                        } catch (IOException e3) {
                                            th3222 = e3;
                                            i3 = 1;
                                            th2 = th3222;
                                            str2 = headerField;
                                            i = i3;
                                            i6 = i5;
                                            i5 = 0;
                                            if (an.a(th2)) {
                                                th2.printStackTrace();
                                            }
                                            a.disconnect();
                                            i4 = i5;
                                            i5 = i6;
                                            i6 = i;
                                            bArr3 = null;
                                            i2 = 0;
                                        }
                                        try {
                                            objArr[1] = headerField;
                                            an.c(str3, objArr);
                                            str2 = headerField;
                                            i6 = 1;
                                            i4 = 0;
                                        } catch (IOException e4) {
                                            th3222 = e4;
                                            th2 = th3222;
                                            str2 = headerField;
                                            i = i3;
                                            i6 = i5;
                                            i5 = 0;
                                            if (an.a(th2)) {
                                                th2.printStackTrace();
                                            }
                                            a.disconnect();
                                            i4 = i5;
                                            i5 = i6;
                                            i6 = i;
                                            bArr3 = null;
                                            i2 = 0;
                                        }
                                    }
                                } catch (IOException e5) {
                                    th3222 = e5;
                                    i3 = 1;
                                    i6 = i5;
                                    i = 1;
                                    i5 = i4;
                                    th2 = th3222;
                                    if (an.a(th2)) {
                                        th2.printStackTrace();
                                    }
                                    a.disconnect();
                                    i4 = i5;
                                    i5 = i6;
                                    i6 = i;
                                    bArr3 = null;
                                    i2 = 0;
                                }
                            } else {
                                i3 = 1;
                            }
                            try {
                                StringBuilder stringBuilder3 = new StringBuilder("response code ");
                                stringBuilder3.append(responseCode);
                                an.d(stringBuilder3.toString(), new Object[0]);
                                long contentLength = (long) a.getContentLength();
                                if (contentLength < 0) {
                                    contentLength = 0;
                                }
                                alVar2.a(contentLength);
                                try {
                                    a.disconnect();
                                } catch (Throwable th32222) {
                                    if (!an.a(th32222)) {
                                        th32222.printStackTrace();
                                    }
                                }
                            } catch (IOException e6) {
                                th32222 = e6;
                                i = i6;
                                i6 = i5;
                                i5 = i4;
                                th2 = th32222;
                                if (an.a(th2)) {
                                    th2.printStackTrace();
                                }
                                a.disconnect();
                                i4 = i5;
                                i5 = i6;
                                i6 = i;
                                bArr3 = null;
                                i2 = 0;
                            }
                        }
                    } catch (IOException e7) {
                        th32222 = e7;
                        i3 = 1;
                        i = i6;
                        i6 = i5;
                        i5 = i4;
                        th2 = th32222;
                        if (an.a(th2)) {
                            th2.printStackTrace();
                        }
                        a.disconnect();
                        i4 = i5;
                        i5 = i6;
                        i6 = i;
                        bArr3 = null;
                        i2 = 0;
                    }
                } else {
                    i3 = 1;
                    an.c("Failed to execute post.", new Object[0]);
                    alVar2.a(0);
                }
            }
            bArr3 = null;
            i2 = 0;
        }
        return bArr3;
    }

    private Map<String, String> b(HttpURLConnection httpURLConnection) {
        Map hashMap = new HashMap();
        httpURLConnection = httpURLConnection.getHeaderFields();
        if (httpURLConnection != null) {
            if (httpURLConnection.size() != 0) {
                for (String str : httpURLConnection.keySet()) {
                    List list = (List) httpURLConnection.get(str);
                    if (list.size() > 0) {
                        hashMap.put(str, list.get(0));
                    }
                }
                return hashMap;
            }
        }
        return null;
    }

    protected byte[] a(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                httpURLConnection = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    httpURLConnection.write(bArr, 0, read);
                }
                httpURLConnection.flush();
                httpURLConnection = httpURLConnection.toByteArray();
                try {
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return httpURLConnection;
            } catch (Throwable th2) {
                httpURLConnection = th2;
                try {
                    if (!an.a(httpURLConnection)) {
                        httpURLConnection.printStackTrace();
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (HttpURLConnection httpURLConnection2) {
                            httpURLConnection2.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    httpURLConnection2 = th3;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    throw httpURLConnection2;
                }
            }
        } catch (Throwable th5) {
            httpURLConnection2 = th5;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw httpURLConnection2;
        }
    }

    protected HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            an.e("destUrl is null.", new Object[0]);
            return null;
        }
        str = a(str2, str);
        if (str == null) {
            an.e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            str.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                map = map.entrySet().iterator();
                while (map.hasNext()) {
                    Entry entry = (Entry) map.next();
                    str.setRequestProperty((String) entry.getKey(), URLEncoder.encode((String) entry.getValue(), "utf-8"));
                }
            }
            str.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            str.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            str2 = str.getOutputStream();
            if (bArr == null) {
                str2.write(0);
            } else {
                str2.write(bArr);
            }
            return str;
        } catch (String str3) {
            if (an.a(str3) == null) {
                str3.printStackTrace();
            }
            an.e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    protected HttpURLConnection a(String str, String str2) {
        try {
            URL url = new URL(str2);
            if (str == null || str.toLowerCase(Locale.US).contains("wap") == null) {
                str = (HttpURLConnection) url.openConnection();
            } else {
                str = (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            }
            str.setConnectTimeout(a.MAX_USERDATA_VALUE_LENGTH);
            str.setReadTimeout(10000);
            str.setDoOutput(true);
            str.setDoInput(true);
            str.setRequestMethod("POST");
            str.setUseCaches(false);
            str.setInstanceFollowRedirects(false);
            return str;
        } catch (String str3) {
            if (an.a(str3) == null) {
                str3.printStackTrace();
            }
            return null;
        }
    }
}
