package com.xiaomi.channel.commonutils.network;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.channel.commonutils.string.c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class d {
    public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static int a(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = -1;
        r1 = "connectivity";	 Catch:{ Exception -> 0x0018 }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x0018 }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Exception -> 0x0018 }
        if (r2 != 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r2 = r2.getActiveNetworkInfo();	 Catch:{  }
        if (r2 != 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r2 = r2.getType();
        return r2;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.a(android.content.Context):int");
    }

    public static com.xiaomi.channel.commonutils.network.b a(android.content.Context r3, java.lang.String r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new com.xiaomi.channel.commonutils.network.b;
        r0.<init>();
        r1 = 0;
        r4 = b(r4);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r3 = b(r3, r4);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r3.setConnectTimeout(r4);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r4 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r3.setReadTimeout(r4);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        if (r5 != 0) goto L_0x001c;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
    L_0x001a:
        r5 = "GET";	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
    L_0x001c:
        r3.setRequestMethod(r5);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        if (r6 == 0) goto L_0x003f;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
    L_0x0021:
        r4 = r6.keySet();	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r4 = r4.iterator();	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
    L_0x0029:
        r5 = r4.hasNext();	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        if (r5 == 0) goto L_0x003f;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
    L_0x002f:
        r5 = r4.next();	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r5 = (java.lang.String) r5;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r2 = r6.get(r5);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r2 = (java.lang.String) r2;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r3.setRequestProperty(r5, r2);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        goto L_0x0029;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
    L_0x003f:
        r4 = android.text.TextUtils.isEmpty(r7);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r5 = 0;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r6 = 1;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        if (r4 != 0) goto L_0x006c;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
    L_0x0047:
        r3.setDoOutput(r6);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r4 = r7.getBytes();	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r7 = r3.getOutputStream();	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r2 = r4.length;	 Catch:{ IOException -> 0x0067, Throwable -> 0x0062, all -> 0x005d }
        r7.write(r4, r5, r2);	 Catch:{ IOException -> 0x0067, Throwable -> 0x0062, all -> 0x005d }
        r7.flush();	 Catch:{ IOException -> 0x0067, Throwable -> 0x0062, all -> 0x005d }
        r7.close();	 Catch:{ IOException -> 0x0067, Throwable -> 0x0062, all -> 0x005d }
        goto L_0x006c;
    L_0x005d:
        r3 = move-exception;
        r4 = r1;
        r1 = r7;
        goto L_0x00f8;
    L_0x0062:
        r3 = move-exception;
        r4 = r1;
        r1 = r7;
        goto L_0x00ea;
    L_0x0067:
        r3 = move-exception;
        r4 = r1;
        r1 = r7;
        goto L_0x00f6;
    L_0x006c:
        r4 = r3.getResponseCode();	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r0.a = r4;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r7 = "Http POST Response Code: ";	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r4.<init>(r7);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r7 = r0.a;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r4.append(r7);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
    L_0x007e:
        r4 = r3.getHeaderFieldKey(r5);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r7 = r3.getHeaderField(r5);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        if (r4 != 0) goto L_0x00dc;
    L_0x0088:
        if (r7 == 0) goto L_0x008b;
    L_0x008a:
        goto L_0x00dc;
    L_0x008b:
        r4 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x009f, Throwable -> 0x00e8, all -> 0x00e5 }
        r5 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x009f, Throwable -> 0x00e8, all -> 0x00e5 }
        r6 = new com.xiaomi.channel.commonutils.network.d$a;	 Catch:{ IOException -> 0x009f, Throwable -> 0x00e8, all -> 0x00e5 }
        r7 = r3.getInputStream();	 Catch:{ IOException -> 0x009f, Throwable -> 0x00e8, all -> 0x00e5 }
        r6.<init>(r7);	 Catch:{ IOException -> 0x009f, Throwable -> 0x00e8, all -> 0x00e5 }
        r5.<init>(r6);	 Catch:{ IOException -> 0x009f, Throwable -> 0x00e8, all -> 0x00e5 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x009f, Throwable -> 0x00e8, all -> 0x00e5 }
        goto L_0x00b2;
    L_0x009f:
        r4 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r5 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r6 = new com.xiaomi.channel.commonutils.network.d$a;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r3 = r3.getErrorStream();	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r6.<init>(r3);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r5.<init>(r6);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
    L_0x00b2:
        r3 = r4.readLine();	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
        r5 = new java.lang.StringBuffer;	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
        r5.<init>();	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
        r6 = "line.separator";	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
        r6 = java.lang.System.getProperty(r6);	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
    L_0x00c1:
        if (r3 == 0) goto L_0x00ce;	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
    L_0x00c3:
        r5.append(r3);	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
        r5.append(r6);	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
        r3 = r4.readLine();	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
        goto L_0x00c1;	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
    L_0x00ce:
        r3 = r5.toString();	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
        r0.c = r3;	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
        r4.close();	 Catch:{ IOException -> 0x00da, Throwable -> 0x00d8 }
        return r0;
    L_0x00d8:
        r3 = move-exception;
        goto L_0x00ea;
    L_0x00da:
        r3 = move-exception;
        goto L_0x00f6;
    L_0x00dc:
        r2 = r0.b;	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r2.put(r4, r7);	 Catch:{ IOException -> 0x00f4, Throwable -> 0x00e8, all -> 0x00e5 }
        r5 = r5 + 1;
        r5 = r5 + r6;
        goto L_0x007e;
    L_0x00e5:
        r3 = move-exception;
        r4 = r1;
        goto L_0x00f8;
    L_0x00e8:
        r3 = move-exception;
        r4 = r1;
    L_0x00ea:
        r5 = new java.io.IOException;	 Catch:{ all -> 0x00f7 }
        r3 = r3.getMessage();	 Catch:{ all -> 0x00f7 }
        r5.<init>(r3);	 Catch:{ all -> 0x00f7 }
        throw r5;	 Catch:{ all -> 0x00f7 }
    L_0x00f4:
        r3 = move-exception;	 Catch:{ all -> 0x00f7 }
        r4 = r1;	 Catch:{ all -> 0x00f7 }
    L_0x00f6:
        throw r3;	 Catch:{ all -> 0x00f7 }
    L_0x00f7:
        r3 = move-exception;
    L_0x00f8:
        if (r1 == 0) goto L_0x00fd;
    L_0x00fa:
        r1.close();	 Catch:{ IOException -> 0x0102 }
    L_0x00fd:
        if (r4 == 0) goto L_0x0102;	 Catch:{ IOException -> 0x0102 }
    L_0x00ff:
        r4.close();	 Catch:{ IOException -> 0x0102 }
    L_0x0102:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.a(android.content.Context, java.lang.String, java.lang.String, java.util.Map, java.lang.String):com.xiaomi.channel.commonutils.network.b");
    }

    public static b a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", null, a((Map) map));
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context");
        } else if (url == null) {
            throw new IllegalArgumentException("url");
        } else {
            URL url2 = !z ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection b = b(context, url2);
                b.setConnectTimeout(10000);
                b.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    b.setRequestProperty(HttpRequest.HEADER_USER_AGENT, str);
                }
                if (str2 != null) {
                    b.setRequestProperty(HttpConstant.COOKIE, str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        b.setRequestProperty(str3, (String) map.get(str3));
                    }
                }
                if (bVar != null && (url.getProtocol().equals(HttpConstant.HTTP) || url.getProtocol().equals("https"))) {
                    bVar.a = b.getResponseCode();
                    if (bVar.b == null) {
                        bVar.b = new HashMap();
                    }
                    int i = 0;
                    while (true) {
                        CharSequence headerFieldKey = b.getHeaderFieldKey(i);
                        CharSequence headerField = b.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!(TextUtils.isEmpty(headerFieldKey) || TextUtils.isEmpty(headerField))) {
                            bVar.b.put(headerFieldKey, headerField);
                        }
                        i++;
                    }
                }
                return new a(b.getInputStream());
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                IOException iOException = new IOException(th.getMessage());
            }
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream a;
        Throwable th;
        try {
            a = a(context, url, z, str, str3);
            try {
                StringBuilder stringBuilder = new StringBuilder(1024);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a, str2));
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (-1 == read) {
                        break;
                    }
                    stringBuilder.append(cArr, 0, read);
                }
                if (a != null) {
                    try {
                        a.close();
                    } catch (IOException e) {
                        new StringBuilder("Failed to close responseStream").append(e.toString());
                    }
                }
                return stringBuilder.toString();
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    try {
                        a.close();
                    } catch (IOException e2) {
                        new StringBuilder("Failed to close responseStream").append(e2.toString());
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = new String();
        str2 = String.format("%sbe988a6134bc8254465424e5a70ef037", new Object[]{str});
        return String.format("%s&key=%s", new Object[]{str, c.a(str2)});
    }

    public static java.lang.String a(java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, java.io.File r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r7.exists();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r7.getName();
        r2 = new java.net.URL;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r2.<init>(r5);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5 = r2.openConnection();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5 = (java.net.HttpURLConnection) r5;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r2 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5.setReadTimeout(r2);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5.setConnectTimeout(r2);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r2 = 1;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5.setDoInput(r2);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5.setDoOutput(r2);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r2 = 0;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5.setUseCaches(r2);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r3 = "POST";	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5.setRequestMethod(r3);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r3 = "Connection";	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r4 = "Keep-Alive";	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5.setRequestProperty(r3, r4);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r3 = "Content-Type";	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r4 = "multipart/form-data;boundary=*****";	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5.setRequestProperty(r3, r4);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        if (r6 == 0) goto L_0x0065;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
    L_0x0041:
        r6 = r6.entrySet();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r6 = r6.iterator();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
    L_0x0049:
        r3 = r6.hasNext();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        if (r3 == 0) goto L_0x0065;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
    L_0x004f:
        r3 = r6.next();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r4 = r3.getKey();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r4 = (java.lang.String) r4;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r3 = r3.getValue();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r3 = (java.lang.String) r3;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5.setRequestProperty(r4, r3);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        goto L_0x0049;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
    L_0x0065:
        r6 = 77;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r0 = r0.length();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r6 = r6 + r0;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r3 = r7.length();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r0 = (int) r3;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r6 = r6 + r0;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r0 = r8.length();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r6 = r6 + r0;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r5.setFixedLengthStreamingMode(r6);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r6 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r0 = r5.getOutputStream();	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r6.<init>(r0);	 Catch:{ IOException -> 0x013e, Throwable -> 0x0131, all -> 0x012d }
        r0 = "--*****\r\n";	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r6.writeBytes(r0);	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r3 = "Content-Disposition: form-data; name=\"";	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r0.<init>(r3);	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r0.append(r8);	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r8 = "\";filename=\"";	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r0.append(r8);	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r8 = r7.getName();	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r0.append(r8);	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r8 = "\"\r\n";	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r0.append(r8);	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r8 = r0.toString();	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r6.writeBytes(r8);	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r8 = "\r\n";	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r6.writeBytes(r8);	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r8 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r8.<init>(r7);	 Catch:{ IOException -> 0x012a, Throwable -> 0x0127, all -> 0x0124 }
        r7 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r7 = new byte[r7];	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
    L_0x00b8:
        r0 = r8.read(r7);	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r3 = -1;	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        if (r0 == r3) goto L_0x00c6;	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
    L_0x00bf:
        r6.write(r7, r2, r0);	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r6.flush();	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        goto L_0x00b8;	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
    L_0x00c6:
        r7 = "\r\n";	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r6.writeBytes(r7);	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r7 = "--";	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r6.writeBytes(r7);	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r7 = "*****";	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r6.writeBytes(r7);	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r7 = "--";	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r6.writeBytes(r7);	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r7 = "\r\n";	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r6.writeBytes(r7);	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r6.flush();	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r7 = new java.lang.StringBuffer;	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r7.<init>();	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r0 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r2 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r3 = new com.xiaomi.channel.commonutils.network.d$a;	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r5 = r5.getInputStream();	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r3.<init>(r5);	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0120, Throwable -> 0x011c, all -> 0x0118 }
    L_0x00fa:
        r5 = r0.readLine();	 Catch:{ IOException -> 0x0116, Throwable -> 0x0114, all -> 0x0112 }
        if (r5 == 0) goto L_0x0104;	 Catch:{ IOException -> 0x0116, Throwable -> 0x0114, all -> 0x0112 }
    L_0x0100:
        r7.append(r5);	 Catch:{ IOException -> 0x0116, Throwable -> 0x0114, all -> 0x0112 }
        goto L_0x00fa;	 Catch:{ IOException -> 0x0116, Throwable -> 0x0114, all -> 0x0112 }
    L_0x0104:
        r5 = r7.toString();	 Catch:{ IOException -> 0x0116, Throwable -> 0x0114, all -> 0x0112 }
        r8.close();	 Catch:{ IOException -> 0x0111 }
        r6.close();	 Catch:{ IOException -> 0x0111 }
        r0.close();	 Catch:{ IOException -> 0x0111 }
    L_0x0111:
        return r5;
    L_0x0112:
        r5 = move-exception;
        goto L_0x011a;
    L_0x0114:
        r5 = move-exception;
        goto L_0x011e;
    L_0x0116:
        r5 = move-exception;
        goto L_0x0122;
    L_0x0118:
        r5 = move-exception;
        r0 = r1;
    L_0x011a:
        r1 = r8;
        goto L_0x0143;
    L_0x011c:
        r5 = move-exception;
        r0 = r1;
    L_0x011e:
        r1 = r8;
        goto L_0x0134;
    L_0x0120:
        r5 = move-exception;
        r0 = r1;
    L_0x0122:
        r1 = r8;
        goto L_0x0141;
    L_0x0124:
        r5 = move-exception;
        r0 = r1;
        goto L_0x0143;
    L_0x0127:
        r5 = move-exception;
        r0 = r1;
        goto L_0x0134;
    L_0x012a:
        r5 = move-exception;
        r0 = r1;
        goto L_0x0141;
    L_0x012d:
        r5 = move-exception;
        r6 = r1;
        r0 = r6;
        goto L_0x0143;
    L_0x0131:
        r5 = move-exception;
        r6 = r1;
        r0 = r6;
    L_0x0134:
        r7 = new java.io.IOException;	 Catch:{ all -> 0x0142 }
        r5 = r5.getMessage();	 Catch:{ all -> 0x0142 }
        r7.<init>(r5);	 Catch:{ all -> 0x0142 }
        throw r7;	 Catch:{ all -> 0x0142 }
    L_0x013e:
        r5 = move-exception;	 Catch:{ all -> 0x0142 }
        r6 = r1;	 Catch:{ all -> 0x0142 }
        r0 = r6;	 Catch:{ all -> 0x0142 }
    L_0x0141:
        throw r5;	 Catch:{ all -> 0x0142 }
    L_0x0142:
        r5 = move-exception;
    L_0x0143:
        if (r1 == 0) goto L_0x0148;
    L_0x0145:
        r1.close();	 Catch:{ IOException -> 0x0152 }
    L_0x0148:
        if (r6 == 0) goto L_0x014d;	 Catch:{ IOException -> 0x0152 }
    L_0x014a:
        r6.close();	 Catch:{ IOException -> 0x0152 }
    L_0x014d:
        if (r0 == 0) goto L_0x0152;	 Catch:{ IOException -> 0x0152 }
    L_0x014f:
        r0.close();	 Catch:{ IOException -> 0x0152 }
    L_0x0152:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.a(java.lang.String, java.util.Map, java.io.File, java.lang.String):java.lang.String");
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                try {
                    stringBuffer.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    new StringBuilder("Failed to convert from params map to string: ").append(e.toString());
                    new StringBuilder("map: ").append(map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static HttpURLConnection b(Context context, URL url) {
        URLConnection openConnection = (HttpConstant.HTTP.equals(url.getProtocol()) && b(context)) ? url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection();
        return (HttpURLConnection) openConnection;
    }

    private static URL b(String str) {
        return new URL(str);
    }

    public static boolean b(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "phone";
        r0 = r3.getSystemService(r0);
        r0 = (android.telephony.TelephonyManager) r0;
        r0 = r0.getSimCountryIso();
        r1 = "CN";
        r0 = r1.equalsIgnoreCase(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x0016;
    L_0x0015:
        return r1;
    L_0x0016:
        r0 = "connectivity";	 Catch:{ Exception -> 0x0044 }
        r3 = r3.getSystemService(r0);	 Catch:{ Exception -> 0x0044 }
        r3 = (android.net.ConnectivityManager) r3;	 Catch:{ Exception -> 0x0044 }
        if (r3 != 0) goto L_0x0021;
    L_0x0020:
        return r1;
    L_0x0021:
        r3 = r3.getActiveNetworkInfo();	 Catch:{  }
        if (r3 != 0) goto L_0x0028;
    L_0x0027:
        return r1;
    L_0x0028:
        r3 = r3.getExtraInfo();
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 != 0) goto L_0x0044;
    L_0x0032:
        r0 = r3.length();
        r2 = 3;
        if (r0 >= r2) goto L_0x003a;
    L_0x0039:
        return r1;
    L_0x003a:
        r0 = "ctwap";
        r3 = r3.contains(r0);
        if (r3 == 0) goto L_0x0044;
    L_0x0042:
        r3 = 1;
        return r3;
    L_0x0044:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.b(android.content.Context):boolean");
    }

    public static boolean c(Context context) {
        return a(context) >= 0;
    }

    public static boolean d(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "connectivity";	 Catch:{ Exception -> 0x000d }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x000d }
        r1 = (android.net.ConnectivityManager) r1;	 Catch:{ Exception -> 0x000d }
        r1 = r1.getActiveNetworkInfo();	 Catch:{ Exception -> 0x000d }
        goto L_0x000e;
    L_0x000d:
        r1 = 0;
    L_0x000e:
        if (r1 == 0) goto L_0x0018;
    L_0x0010:
        r1 = r1.isConnected();
        if (r1 == 0) goto L_0x0018;
    L_0x0016:
        r1 = 1;
        return r1;
    L_0x0018:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.d(android.content.Context):boolean");
    }

    public static boolean e(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "connectivity";	 Catch:{ Exception -> 0x001b }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x001b }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Exception -> 0x001b }
        if (r2 != 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r2 = r2.getActiveNetworkInfo();	 Catch:{  }
        if (r2 != 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r2 = r2.getType();
        r1 = 1;
        if (r1 != r2) goto L_0x001b;
    L_0x001a:
        return r1;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.e(android.content.Context):boolean");
    }

    public static boolean f(Context context) {
        if (!(g(context) || h(context))) {
            if (!i(context)) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(Context context) {
        NetworkInfo j = j(context);
        return j != null && j.getType() == 0 && 13 == j.getSubtype();
    }

    public static boolean h(Context context) {
        NetworkInfo j = j(context);
        if (j == null || j.getType() != 0) {
            return false;
        }
        String subtypeName = j.getSubtypeName();
        if ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName)) {
            return true;
        }
        switch (j.getSubtype()) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                break;
            default:
                return false;
        }
        return true;
    }

    public static boolean i(Context context) {
        NetworkInfo j = j(context);
        if (j == null || j.getType() != 0) {
            return false;
        }
        int subtype = j.getSubtype();
        if (!(subtype == 4 || subtype == 7 || subtype == 11)) {
            switch (subtype) {
                case 1:
                case 2:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static android.net.NetworkInfo j(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "connectivity";	 Catch:{ Exception -> 0x0011 }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x0011 }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Exception -> 0x0011 }
        if (r2 != 0) goto L_0x000c;	 Catch:{ Exception -> 0x0011 }
    L_0x000b:
        return r0;	 Catch:{ Exception -> 0x0011 }
    L_0x000c:
        r2 = r2.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0011 }
        return r2;
    L_0x0011:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.j(android.content.Context):android.net.NetworkInfo");
    }

    public static java.lang.String k(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = e(r2);
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r2 = "wifi";
        return r2;
    L_0x0009:
        r0 = "connectivity";	 Catch:{ Exception -> 0x004f }
        r2 = r2.getSystemService(r0);	 Catch:{ Exception -> 0x004f }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Exception -> 0x004f }
        if (r2 != 0) goto L_0x0016;
    L_0x0013:
        r2 = "";
        return r2;
    L_0x0016:
        r2 = r2.getActiveNetworkInfo();	 Catch:{ Exception -> 0x004c }
        if (r2 != 0) goto L_0x001f;
    L_0x001c:
        r2 = "";
        return r2;
    L_0x001f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r2.getTypeName();
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r1 = r2.getSubtypeName();
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r2 = r2.getExtraInfo();
        r0.append(r2);
        r2 = r0.toString();
        r2 = r2.toLowerCase();
        return r2;
    L_0x004c:
        r2 = "";
        return r2;
    L_0x004f:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.k(android.content.Context):java.lang.String");
    }
}
