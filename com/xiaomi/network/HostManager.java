package com.xiaomi.network;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.a;
import com.xiaomi.channel.commonutils.network.c;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HostManager {
    private static HostManagerFactory factory = null;
    protected static boolean hostLoaded = false;
    protected static Context sAppContext;
    private static String sAppName;
    private static String sAppVersion;
    private static HostManager sInstance;
    protected static Map<String, Fallback> sReservedHosts = new HashMap();
    private final long MAX_REQUEST_FAILURE_CNT;
    private String currentISP;
    private long lastRemoteRequestTimestamp;
    protected Map<String, Fallbacks> mHostsMapping;
    private long remoteRequestFailureCount;
    private HostFilter sHostFilter;
    protected HttpGet sHttpGetter;
    private String sUserId;

    public interface HostManagerFactory {
        HostManager a(Context context, HostFilter hostFilter, HttpGet httpGet, String str);
    }

    public interface HttpGet {
        String a(String str);
    }

    protected HostManager(Context context, HostFilter hostFilter, HttpGet httpGet, String str) {
        this(context, hostFilter, httpGet, str, null, null);
    }

    protected HostManager(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        this.mHostsMapping = new HashMap();
        this.sUserId = "0";
        this.remoteRequestFailureCount = 0;
        this.MAX_REQUEST_FAILURE_CNT = 15;
        this.lastRemoteRequestTimestamp = 0;
        this.currentISP = "isp_prov_city_country_ip";
        this.sHttpGetter = httpGet;
        if (hostFilter == null) {
            hostFilter = new a(this);
        }
        this.sHostFilter = hostFilter;
        this.sUserId = str;
        if (str2 == null) {
            str2 = context.getPackageName();
        }
        sAppName = str2;
        if (str3 == null) {
            str3 = getVersionName();
        }
        sAppVersion = str3;
    }

    public static void addReservedHost(String str, String str2) {
        Fallback fallback = (Fallback) sReservedHosts.get(str);
        synchronized (sReservedHosts) {
            if (fallback == null) {
                fallback = new Fallback(str);
                fallback.a(604800000);
                fallback.b(str2);
                sReservedHosts.put(str, fallback);
            } else {
                fallback.b(str2);
            }
        }
    }

    static java.lang.String getActiveNetworkLabel() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = sAppContext;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = "unknown";
        return r0;
    L_0x0007:
        r0 = sAppContext;	 Catch:{ Throwable -> 0x006c }
        r1 = "connectivity";	 Catch:{ Throwable -> 0x006c }
        r0 = r0.getSystemService(r1);	 Catch:{ Throwable -> 0x006c }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Throwable -> 0x006c }
        if (r0 != 0) goto L_0x0016;	 Catch:{ Throwable -> 0x006c }
    L_0x0013:
        r0 = "unknown";	 Catch:{ Throwable -> 0x006c }
        return r0;	 Catch:{ Throwable -> 0x006c }
    L_0x0016:
        r0 = r0.getActiveNetworkInfo();	 Catch:{ Throwable -> 0x006c }
        if (r0 != 0) goto L_0x001f;	 Catch:{ Throwable -> 0x006c }
    L_0x001c:
        r0 = "unknown";	 Catch:{ Throwable -> 0x006c }
        return r0;	 Catch:{ Throwable -> 0x006c }
    L_0x001f:
        r1 = r0.getType();	 Catch:{ Throwable -> 0x006c }
        r2 = 1;	 Catch:{ Throwable -> 0x006c }
        if (r1 != r2) goto L_0x004f;	 Catch:{ Throwable -> 0x006c }
    L_0x0026:
        r0 = sAppContext;	 Catch:{ Throwable -> 0x006c }
        r1 = "wifi";	 Catch:{ Throwable -> 0x006c }
        r0 = r0.getSystemService(r1);	 Catch:{ Throwable -> 0x006c }
        r0 = (android.net.wifi.WifiManager) r0;	 Catch:{ Throwable -> 0x006c }
        if (r0 == 0) goto L_0x006c;	 Catch:{ Throwable -> 0x006c }
    L_0x0032:
        r1 = r0.getConnectionInfo();	 Catch:{ Throwable -> 0x006c }
        if (r1 == 0) goto L_0x006c;	 Catch:{ Throwable -> 0x006c }
    L_0x0038:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x006c }
        r2 = "WIFI-";	 Catch:{ Throwable -> 0x006c }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x006c }
        r0 = r0.getConnectionInfo();	 Catch:{ Throwable -> 0x006c }
        r0 = r0.getSSID();	 Catch:{ Throwable -> 0x006c }
        r1.append(r0);	 Catch:{ Throwable -> 0x006c }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x006c }
        return r0;	 Catch:{ Throwable -> 0x006c }
    L_0x004f:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x006c }
        r1.<init>();	 Catch:{ Throwable -> 0x006c }
        r2 = r0.getTypeName();	 Catch:{ Throwable -> 0x006c }
        r1.append(r2);	 Catch:{ Throwable -> 0x006c }
        r2 = "-";	 Catch:{ Throwable -> 0x006c }
        r1.append(r2);	 Catch:{ Throwable -> 0x006c }
        r0 = r0.getSubtypeName();	 Catch:{ Throwable -> 0x006c }
        r1.append(r0);	 Catch:{ Throwable -> 0x006c }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x006c }
        return r0;
    L_0x006c:
        r0 = "unknown";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.HostManager.getActiveNetworkLabel():java.lang.String");
    }

    public static synchronized HostManager getInstance() {
        HostManager hostManager;
        synchronized (HostManager.class) {
            if (sInstance == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            hostManager = sInstance;
        }
        return hostManager;
    }

    private java.lang.String getVersionName() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = sAppContext;	 Catch:{ Exception -> 0x0017 }
        r0 = r0.getPackageManager();	 Catch:{ Exception -> 0x0017 }
        r1 = sAppContext;	 Catch:{ Exception -> 0x0017 }
        r1 = r1.getPackageName();	 Catch:{ Exception -> 0x0017 }
        r2 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;	 Catch:{ Exception -> 0x0017 }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ Exception -> 0x0017 }
        if (r0 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x0017 }
    L_0x0014:
        r0 = r0.versionName;	 Catch:{ Exception -> 0x0017 }
        return r0;
    L_0x0017:
        r0 = "0";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.HostManager.getVersionName():java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.content.Context r9, com.xiaomi.network.HostFilter r10, com.xiaomi.network.HostManager.HttpGet r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
        r0 = com.xiaomi.network.HostManager.class;
        monitor-enter(r0);
        r1 = r9.getApplicationContext();	 Catch:{ all -> 0x002f }
        sAppContext = r1;	 Catch:{ all -> 0x002f }
        if (r1 != 0) goto L_0x000d;
    L_0x000b:
        sAppContext = r9;	 Catch:{ all -> 0x002f }
    L_0x000d:
        r1 = sInstance;	 Catch:{ all -> 0x002f }
        if (r1 != 0) goto L_0x002d;
    L_0x0011:
        r1 = factory;	 Catch:{ all -> 0x002f }
        if (r1 != 0) goto L_0x0025;
    L_0x0015:
        r1 = new com.xiaomi.network.HostManager;	 Catch:{ all -> 0x002f }
        r2 = r1;
        r3 = r9;
        r4 = r10;
        r5 = r11;
        r6 = r12;
        r7 = r13;
        r8 = r14;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x002f }
        sInstance = r1;	 Catch:{ all -> 0x002f }
        monitor-exit(r0);
        return;
    L_0x0025:
        r13 = factory;	 Catch:{ all -> 0x002f }
        r9 = r13.a(r9, r10, r11, r12);	 Catch:{ all -> 0x002f }
        sInstance = r9;	 Catch:{ all -> 0x002f }
    L_0x002d:
        monitor-exit(r0);
        return;
    L_0x002f:
        r9 = move-exception;
        monitor-exit(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.HostManager.init(android.content.Context, com.xiaomi.network.HostFilter, com.xiaomi.network.HostManager$HttpGet, java.lang.String, java.lang.String, java.lang.String):void");
    }

    static java.lang.String obfuscate(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r6.length();	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r1 = r6.getBytes(r1);	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r2 = 0;	 Catch:{ UnsupportedEncodingException -> 0x002c }
    L_0x000b:
        r3 = r1.length;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        if (r2 >= r3) goto L_0x0026;	 Catch:{ UnsupportedEncodingException -> 0x002c }
    L_0x000e:
        r3 = r1[r2];	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r4 = r3 & 240;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r5 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        if (r4 == r5) goto L_0x0023;	 Catch:{ UnsupportedEncodingException -> 0x002c }
    L_0x0016:
        r5 = r3 >> 4;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r5 = r5 + r0;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r5 = r5 & 15;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r5 = (byte) r5;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r3 = r3 & 15;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r3 = r3 ^ r5;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r3 = r3 | r4;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r3 = (byte) r3;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r1[r2] = r3;	 Catch:{ UnsupportedEncodingException -> 0x002c }
    L_0x0023:
        r2 = r2 + 1;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        goto L_0x000b;	 Catch:{ UnsupportedEncodingException -> 0x002c }
    L_0x0026:
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r0.<init>(r1);	 Catch:{ UnsupportedEncodingException -> 0x002c }
        return r0;
    L_0x002c:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.HostManager.obfuscate(java.lang.String):java.lang.String");
    }

    private java.util.ArrayList<com.xiaomi.network.Fallback> requestRemoteFallbacks(java.util.ArrayList<java.lang.String> r22) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r21 = this;
        r1 = r21;
        r2 = r22;
        r21.purge();
        r3 = r1.mHostsMapping;
        monitor-enter(r3);
        r21.checkHostMapping();	 Catch:{ all -> 0x027e }
        r4 = r1.mHostsMapping;	 Catch:{ all -> 0x027e }
        r4 = r4.keySet();	 Catch:{ all -> 0x027e }
        r4 = r4.iterator();	 Catch:{ all -> 0x027e }
    L_0x0017:
        r5 = r4.hasNext();	 Catch:{ all -> 0x027e }
        if (r5 == 0) goto L_0x002d;	 Catch:{ all -> 0x027e }
    L_0x001d:
        r5 = r4.next();	 Catch:{ all -> 0x027e }
        r5 = (java.lang.String) r5;	 Catch:{ all -> 0x027e }
        r6 = r2.contains(r5);	 Catch:{ all -> 0x027e }
        if (r6 != 0) goto L_0x0017;	 Catch:{ all -> 0x027e }
    L_0x0029:
        r2.add(r5);	 Catch:{ all -> 0x027e }
        goto L_0x0017;	 Catch:{ all -> 0x027e }
    L_0x002d:
        monitor-exit(r3);	 Catch:{ all -> 0x027e }
        r3 = sReservedHosts;
        r3 = r3.isEmpty();
        r4 = sReservedHosts;
        monitor-enter(r4);
        r5 = sReservedHosts;	 Catch:{ all -> 0x027a }
        r5 = r5.values();	 Catch:{ all -> 0x027a }
        r5 = r5.toArray();	 Catch:{ all -> 0x027a }
        r6 = r5.length;	 Catch:{ all -> 0x027a }
        r8 = r3;	 Catch:{ all -> 0x027a }
        r3 = 0;	 Catch:{ all -> 0x027a }
    L_0x0044:
        if (r3 >= r6) goto L_0x005b;	 Catch:{ all -> 0x027a }
    L_0x0046:
        r9 = r5[r3];	 Catch:{ all -> 0x027a }
        r9 = (com.xiaomi.network.Fallback) r9;	 Catch:{ all -> 0x027a }
        r10 = r9.b();	 Catch:{ all -> 0x027a }
        if (r10 != 0) goto L_0x0058;	 Catch:{ all -> 0x027a }
    L_0x0050:
        r8 = sReservedHosts;	 Catch:{ all -> 0x027a }
        r9 = r9.b;	 Catch:{ all -> 0x027a }
        r8.remove(r9);	 Catch:{ all -> 0x027a }
        r8 = 1;	 Catch:{ all -> 0x027a }
    L_0x0058:
        r3 = r3 + 1;	 Catch:{ all -> 0x027a }
        goto L_0x0044;	 Catch:{ all -> 0x027a }
    L_0x005b:
        monitor-exit(r4);	 Catch:{ all -> 0x027a }
        r3 = r21.getHost();
        r3 = r2.contains(r3);
        if (r3 != 0) goto L_0x006d;
    L_0x0066:
        r3 = r21.getHost();
        r2.add(r3);
    L_0x006d:
        r3 = new java.util.ArrayList;
        r4 = r22.size();
        r3.<init>(r4);
        r4 = 0;
    L_0x0077:
        r5 = r22.size();
        if (r4 >= r5) goto L_0x0084;
    L_0x007d:
        r5 = 0;
        r3.add(r5);
        r4 = r4 + 1;
        goto L_0x0077;
    L_0x0084:
        r4 = sAppContext;	 Catch:{ Exception -> 0x0244 }
        r4 = com.xiaomi.channel.commonutils.network.d.e(r4);	 Catch:{ Exception -> 0x0244 }
        if (r4 == 0) goto L_0x008f;	 Catch:{ Exception -> 0x0244 }
    L_0x008c:
        r4 = "wifi";	 Catch:{ Exception -> 0x0244 }
        goto L_0x0091;	 Catch:{ Exception -> 0x0244 }
    L_0x008f:
        r4 = "wap";	 Catch:{ Exception -> 0x0244 }
    L_0x0091:
        r5 = r1.sUserId;	 Catch:{ Exception -> 0x0244 }
        r5 = r1.getRemoteFallbackJSON(r2, r4, r5, r8);	 Catch:{ Exception -> 0x0244 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0244 }
        if (r6 != 0) goto L_0x025b;	 Catch:{ Exception -> 0x0244 }
    L_0x009d:
        r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0244 }
        r6.<init>(r5);	 Catch:{ Exception -> 0x0244 }
        com.xiaomi.channel.commonutils.logger.b.b(r5);	 Catch:{ Exception -> 0x0244 }
        r5 = "OK";	 Catch:{ Exception -> 0x0244 }
        r8 = "S";	 Catch:{ Exception -> 0x0244 }
        r8 = r6.getString(r8);	 Catch:{ Exception -> 0x0244 }
        r5 = r5.equalsIgnoreCase(r8);	 Catch:{ Exception -> 0x0244 }
        if (r5 == 0) goto L_0x025b;	 Catch:{ Exception -> 0x0244 }
    L_0x00b3:
        r5 = "R";	 Catch:{ Exception -> 0x0244 }
        r5 = r6.getJSONObject(r5);	 Catch:{ Exception -> 0x0244 }
        r6 = "province";	 Catch:{ Exception -> 0x0244 }
        r6 = r5.getString(r6);	 Catch:{ Exception -> 0x0244 }
        r8 = "city";	 Catch:{ Exception -> 0x0244 }
        r8 = r5.getString(r8);	 Catch:{ Exception -> 0x0244 }
        r9 = "isp";	 Catch:{ Exception -> 0x0244 }
        r9 = r5.getString(r9);	 Catch:{ Exception -> 0x0244 }
        r10 = "ip";	 Catch:{ Exception -> 0x0244 }
        r10 = r5.getString(r10);	 Catch:{ Exception -> 0x0244 }
        r11 = "country";	 Catch:{ Exception -> 0x0244 }
        r11 = r5.getString(r11);	 Catch:{ Exception -> 0x0244 }
        r12 = r5.getJSONObject(r4);	 Catch:{ Exception -> 0x0244 }
        r13 = "wap";	 Catch:{ Exception -> 0x0244 }
        r13 = r4.equals(r13);	 Catch:{ Exception -> 0x0244 }
        if (r13 == 0) goto L_0x00e7;	 Catch:{ Exception -> 0x0244 }
    L_0x00e3:
        r4 = getActiveNetworkLabel();	 Catch:{ Exception -> 0x0244 }
    L_0x00e7:
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0244 }
        r14 = "get bucket: ip = ";	 Catch:{ Exception -> 0x0244 }
        r13.<init>(r14);	 Catch:{ Exception -> 0x0244 }
        r13.append(r10);	 Catch:{ Exception -> 0x0244 }
        r14 = " net = ";	 Catch:{ Exception -> 0x0244 }
        r13.append(r14);	 Catch:{ Exception -> 0x0244 }
        r13.append(r9);	 Catch:{ Exception -> 0x0244 }
        r13.append(r4);	 Catch:{ Exception -> 0x0244 }
        r4 = " hosts = ";	 Catch:{ Exception -> 0x0244 }
        r13.append(r4);	 Catch:{ Exception -> 0x0244 }
        r4 = r12.toString();	 Catch:{ Exception -> 0x0244 }
        r13.append(r4);	 Catch:{ Exception -> 0x0244 }
        r4 = r13.toString();	 Catch:{ Exception -> 0x0244 }
        com.xiaomi.channel.commonutils.logger.b.a(r4);	 Catch:{ Exception -> 0x0244 }
        r4 = 0;	 Catch:{ Exception -> 0x0244 }
    L_0x0110:
        r13 = r22.size();	 Catch:{ Exception -> 0x0244 }
        if (r4 >= r13) goto L_0x01bf;	 Catch:{ Exception -> 0x0244 }
    L_0x0116:
        r13 = r2.get(r4);	 Catch:{ Exception -> 0x0244 }
        r13 = (java.lang.String) r13;	 Catch:{ Exception -> 0x0244 }
        r7 = r12.optJSONArray(r13);	 Catch:{ Exception -> 0x0244 }
        if (r7 != 0) goto L_0x0137;	 Catch:{ Exception -> 0x0244 }
    L_0x0122:
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0244 }
        r14 = "no bucket found for ";	 Catch:{ Exception -> 0x0244 }
        r7.<init>(r14);	 Catch:{ Exception -> 0x0244 }
        r7.append(r13);	 Catch:{ Exception -> 0x0244 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x0244 }
        com.xiaomi.channel.commonutils.logger.b.a(r7);	 Catch:{ Exception -> 0x0244 }
        r19 = r12;	 Catch:{ Exception -> 0x0244 }
        goto L_0x01b9;	 Catch:{ Exception -> 0x0244 }
    L_0x0137:
        r14 = new com.xiaomi.network.Fallback;	 Catch:{ Exception -> 0x0244 }
        r14.<init>(r13);	 Catch:{ Exception -> 0x0244 }
        r13 = 0;	 Catch:{ Exception -> 0x0244 }
    L_0x013d:
        r15 = r7.length();	 Catch:{ Exception -> 0x0244 }
        if (r13 >= r15) goto L_0x016b;	 Catch:{ Exception -> 0x0244 }
    L_0x0143:
        r15 = r7.getString(r13);	 Catch:{ Exception -> 0x0244 }
        r18 = android.text.TextUtils.isEmpty(r15);	 Catch:{ Exception -> 0x0244 }
        if (r18 != 0) goto L_0x0160;	 Catch:{ Exception -> 0x0244 }
    L_0x014d:
        r19 = r12;	 Catch:{ Exception -> 0x0244 }
        r12 = new com.xiaomi.network.c;	 Catch:{ Exception -> 0x0244 }
        r18 = r7.length();	 Catch:{ Exception -> 0x0244 }
        r20 = r7;	 Catch:{ Exception -> 0x0244 }
        r7 = r18 - r13;	 Catch:{ Exception -> 0x0244 }
        r12.<init>(r15, r7);	 Catch:{ Exception -> 0x0244 }
        r14.a(r12);	 Catch:{ Exception -> 0x0244 }
        goto L_0x0164;	 Catch:{ Exception -> 0x0244 }
    L_0x0160:
        r20 = r7;	 Catch:{ Exception -> 0x0244 }
        r19 = r12;	 Catch:{ Exception -> 0x0244 }
    L_0x0164:
        r13 = r13 + 1;	 Catch:{ Exception -> 0x0244 }
        r12 = r19;	 Catch:{ Exception -> 0x0244 }
        r7 = r20;	 Catch:{ Exception -> 0x0244 }
        goto L_0x013d;	 Catch:{ Exception -> 0x0244 }
    L_0x016b:
        r19 = r12;	 Catch:{ Exception -> 0x0244 }
        r3.set(r4, r14);	 Catch:{ Exception -> 0x0244 }
        r14.g = r11;	 Catch:{ Exception -> 0x0244 }
        r14.c = r6;	 Catch:{ Exception -> 0x0244 }
        r14.e = r9;	 Catch:{ Exception -> 0x0244 }
        r14.f = r10;	 Catch:{ Exception -> 0x0244 }
        r14.d = r8;	 Catch:{ Exception -> 0x0244 }
        r7 = "stat-percent";	 Catch:{ Exception -> 0x0244 }
        r7 = r5.has(r7);	 Catch:{ Exception -> 0x0244 }
        if (r7 == 0) goto L_0x018b;	 Catch:{ Exception -> 0x0244 }
    L_0x0182:
        r7 = "stat-percent";	 Catch:{ Exception -> 0x0244 }
        r12 = r5.getDouble(r7);	 Catch:{ Exception -> 0x0244 }
        r14.a(r12);	 Catch:{ Exception -> 0x0244 }
    L_0x018b:
        r7 = "stat-domain";	 Catch:{ Exception -> 0x0244 }
        r7 = r5.has(r7);	 Catch:{ Exception -> 0x0244 }
        if (r7 == 0) goto L_0x019c;	 Catch:{ Exception -> 0x0244 }
    L_0x0193:
        r7 = "stat-domain";	 Catch:{ Exception -> 0x0244 }
        r7 = r5.getString(r7);	 Catch:{ Exception -> 0x0244 }
        r14.c(r7);	 Catch:{ Exception -> 0x0244 }
    L_0x019c:
        r7 = "ttl";	 Catch:{ Exception -> 0x0244 }
        r7 = r5.has(r7);	 Catch:{ Exception -> 0x0244 }
        if (r7 == 0) goto L_0x01b2;	 Catch:{ Exception -> 0x0244 }
    L_0x01a4:
        r7 = "ttl";	 Catch:{ Exception -> 0x0244 }
        r7 = r5.getInt(r7);	 Catch:{ Exception -> 0x0244 }
        r12 = (long) r7;	 Catch:{ Exception -> 0x0244 }
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x0244 }
        r12 = r12 * r16;	 Catch:{ Exception -> 0x0244 }
        r14.a(r12);	 Catch:{ Exception -> 0x0244 }
    L_0x01b2:
        r7 = r14.e();	 Catch:{ Exception -> 0x0244 }
        r1.setCurrentISP(r7);	 Catch:{ Exception -> 0x0244 }
    L_0x01b9:
        r4 = r4 + 1;	 Catch:{ Exception -> 0x0244 }
        r12 = r19;	 Catch:{ Exception -> 0x0244 }
        goto L_0x0110;	 Catch:{ Exception -> 0x0244 }
    L_0x01bf:
        r4 = "reserved";	 Catch:{ Exception -> 0x0244 }
        r4 = r5.optJSONObject(r4);	 Catch:{ Exception -> 0x0244 }
        if (r4 == 0) goto L_0x025b;	 Catch:{ Exception -> 0x0244 }
    L_0x01c7:
        r6 = 604800000; // 0x240c8400 float:3.046947E-17 double:2.988109026E-315;	 Catch:{ Exception -> 0x0244 }
        r8 = "reserved-ttl";	 Catch:{ Exception -> 0x0244 }
        r8 = r5.has(r8);	 Catch:{ Exception -> 0x0244 }
        if (r8 == 0) goto L_0x01dd;	 Catch:{ Exception -> 0x0244 }
    L_0x01d2:
        r6 = "reserved-ttl";	 Catch:{ Exception -> 0x0244 }
        r5 = r5.getInt(r6);	 Catch:{ Exception -> 0x0244 }
        r5 = (long) r5;	 Catch:{ Exception -> 0x0244 }
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x0244 }
        r6 = r5 * r7;	 Catch:{ Exception -> 0x0244 }
    L_0x01dd:
        r5 = r4.keys();	 Catch:{ Exception -> 0x0244 }
    L_0x01e1:
        r8 = r5.hasNext();	 Catch:{ Exception -> 0x0244 }
        if (r8 == 0) goto L_0x025b;	 Catch:{ Exception -> 0x0244 }
    L_0x01e7:
        r8 = r5.next();	 Catch:{ Exception -> 0x0244 }
        r8 = (java.lang.String) r8;	 Catch:{ Exception -> 0x0244 }
        r9 = r4.optJSONArray(r8);	 Catch:{ Exception -> 0x0244 }
        if (r9 != 0) goto L_0x0205;	 Catch:{ Exception -> 0x0244 }
    L_0x01f3:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0244 }
        r10 = "no bucket found for ";	 Catch:{ Exception -> 0x0244 }
        r9.<init>(r10);	 Catch:{ Exception -> 0x0244 }
        r9.append(r8);	 Catch:{ Exception -> 0x0244 }
        r8 = r9.toString();	 Catch:{ Exception -> 0x0244 }
        com.xiaomi.channel.commonutils.logger.b.a(r8);	 Catch:{ Exception -> 0x0244 }
        goto L_0x01e1;	 Catch:{ Exception -> 0x0244 }
    L_0x0205:
        r10 = new com.xiaomi.network.Fallback;	 Catch:{ Exception -> 0x0244 }
        r10.<init>(r8);	 Catch:{ Exception -> 0x0244 }
        r10.a(r6);	 Catch:{ Exception -> 0x0244 }
        r11 = 0;	 Catch:{ Exception -> 0x0244 }
    L_0x020e:
        r12 = r9.length();	 Catch:{ Exception -> 0x0244 }
        if (r11 >= r12) goto L_0x022e;	 Catch:{ Exception -> 0x0244 }
    L_0x0214:
        r12 = r9.getString(r11);	 Catch:{ Exception -> 0x0244 }
        r13 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Exception -> 0x0244 }
        if (r13 != 0) goto L_0x022b;	 Catch:{ Exception -> 0x0244 }
    L_0x021e:
        r13 = new com.xiaomi.network.c;	 Catch:{ Exception -> 0x0244 }
        r14 = r9.length();	 Catch:{ Exception -> 0x0244 }
        r14 = r14 - r11;	 Catch:{ Exception -> 0x0244 }
        r13.<init>(r12, r14);	 Catch:{ Exception -> 0x0244 }
        r10.a(r13);	 Catch:{ Exception -> 0x0244 }
    L_0x022b:
        r11 = r11 + 1;	 Catch:{ Exception -> 0x0244 }
        goto L_0x020e;	 Catch:{ Exception -> 0x0244 }
    L_0x022e:
        r9 = sReservedHosts;	 Catch:{ Exception -> 0x0244 }
        monitor-enter(r9);	 Catch:{ Exception -> 0x0244 }
        r11 = r1.sHostFilter;	 Catch:{ all -> 0x0240 }
        r11 = r11.a(r8);	 Catch:{ all -> 0x0240 }
        if (r11 == 0) goto L_0x023e;	 Catch:{ all -> 0x0240 }
    L_0x0239:
        r11 = sReservedHosts;	 Catch:{ all -> 0x0240 }
        r11.put(r8, r10);	 Catch:{ all -> 0x0240 }
    L_0x023e:
        monitor-exit(r9);	 Catch:{ all -> 0x0240 }
        goto L_0x01e1;	 Catch:{ all -> 0x0240 }
    L_0x0240:
        r0 = move-exception;	 Catch:{ all -> 0x0240 }
        r4 = r0;	 Catch:{ all -> 0x0240 }
        monitor-exit(r9);	 Catch:{ all -> 0x0240 }
        throw r4;	 Catch:{ Exception -> 0x0244 }
    L_0x0244:
        r0 = move-exception;
        r4 = r0;
        r5 = new java.lang.StringBuilder;
        r6 = "failed to get bucket ";
        r5.<init>(r6);
        r4 = r4.getMessage();
        r5.append(r4);
        r4 = r5.toString();
        com.xiaomi.channel.commonutils.logger.b.a(r4);
    L_0x025b:
        r4 = 0;
    L_0x025c:
        r5 = r22.size();
        if (r4 >= r5) goto L_0x0276;
    L_0x0262:
        r5 = r3.get(r4);
        r5 = (com.xiaomi.network.Fallback) r5;
        if (r5 == 0) goto L_0x0273;
    L_0x026a:
        r6 = r2.get(r4);
        r6 = (java.lang.String) r6;
        r1.updateFallbacks(r6, r5);
    L_0x0273:
        r4 = r4 + 1;
        goto L_0x025c;
    L_0x0276:
        r21.persist();
        return r3;
    L_0x027a:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r4);	 Catch:{ all -> 0x027a }
        throw r2;
    L_0x027e:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r3);	 Catch:{ all -> 0x027e }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.HostManager.requestRemoteFallbacks(java.util.ArrayList):java.util.ArrayList<com.xiaomi.network.Fallback>");
    }

    public static synchronized void setHostManagerFactory(HostManagerFactory hostManagerFactory) {
        synchronized (HostManager.class) {
            factory = hostManagerFactory;
            sInstance = null;
        }
    }

    protected boolean checkHostMapping() {
        synchronized (this.mHostsMapping) {
            if (hostLoaded) {
                return true;
            }
            hostLoaded = true;
            this.mHostsMapping.clear();
            try {
                Object loadHosts = loadHosts();
                if (!TextUtils.isEmpty(loadHosts)) {
                    fromJSON(loadHosts);
                    b.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("load bucket failure: ");
                stringBuilder.append(th.getMessage());
                b.a(stringBuilder.toString());
            }
        }
        return false;
    }

    public void clear() {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
        }
    }

    protected void fromJSON(String str) {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            int i = 0;
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                Fallbacks fromJSON = new Fallbacks().fromJSON(optJSONArray.getJSONObject(i2));
                this.mHostsMapping.put(fromJSON.getHost(), fromJSON);
            }
            optJSONArray = jSONObject.optJSONArray("reserved");
            while (i < optJSONArray.length()) {
                Fallback a = new Fallback("").a(optJSONArray.getJSONObject(i));
                sReservedHosts.put(a.b, a);
                i++;
            }
        }
    }

    public Fallback getFallbacksByHost(String str) {
        return getFallbacksByHost(str, true);
    }

    public Fallback getFallbacksByHost(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        } else if (!this.sHostFilter.a(str)) {
            return null;
        } else {
            Fallback localFallback = getLocalFallback(str);
            if (localFallback != null && localFallback.b()) {
                return localFallback;
            }
            if (z && d.c(sAppContext)) {
                Fallback requestRemoteFallback = requestRemoteFallback(str);
                if (requestRemoteFallback != null) {
                    return requestRemoteFallback;
                }
            }
            return new b(this, str, localFallback);
        }
    }

    public Fallback getFallbacksByURL(String str) {
        if (!TextUtils.isEmpty(str)) {
            return getFallbacksByHost(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    protected String getHost() {
        return "resolver.msg.xiaomi.net";
    }

    protected Fallback getLocalFallback(String str) {
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            Fallbacks fallbacks = (Fallbacks) this.mHostsMapping.get(str);
        }
        if (fallbacks != null) {
            Fallback fallback = fallbacks.getFallback();
            if (fallback != null) {
                return fallback;
            }
        }
        return null;
    }

    protected String getProcessName() {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) sAppContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "com.xiaomi";
    }

    public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2, boolean z) {
        Iterator it;
        ArrayList arrayList2 = new ArrayList();
        List<c> arrayList3 = new ArrayList();
        arrayList3.add(new a("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new a("conpt", obfuscate(d.k(sAppContext))));
        }
        if (z) {
            arrayList3.add(new a("reserved", "1"));
        }
        arrayList3.add(new a("uuid", str2));
        arrayList3.add(new a("list", com.xiaomi.channel.commonutils.string.d.a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        Fallback localFallback = getLocalFallback("resolver.msg.xiaomi.net");
        str = String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", new Object[]{"resolver.msg.xiaomi.net"});
        if (localFallback == null) {
            arrayList2.add(str);
            synchronized (sReservedHosts) {
                localFallback = (Fallback) sReservedHosts.get("resolver.msg.xiaomi.net");
                if (localFallback != null) {
                    it = localFallback.a(true).iterator();
                    while (it.hasNext()) {
                        str = (String) it.next();
                        arrayList2.add(String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", new Object[]{str}));
                    }
                }
            }
        } else {
            arrayList2 = localFallback.a(str);
        }
        it = arrayList2.iterator();
        IOException iOException = null;
        while (it.hasNext()) {
            Builder buildUpon = Uri.parse((String) it.next()).buildUpon();
            for (c cVar : arrayList3) {
                buildUpon.appendQueryParameter(cVar.a(), cVar.b());
            }
            try {
                return this.sHttpGetter == null ? d.a(sAppContext, new URL(buildUpon.toString())) : this.sHttpGetter.a(buildUpon.toString());
            } catch (IOException e) {
                iOException = e;
            }
        }
        if (iOException == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("network exception: ");
        stringBuilder.append(iOException.getMessage());
        b.a(stringBuilder.toString());
        throw iOException;
    }

    protected String loadHosts() {
        Reader bufferedReader;
        Throwable th;
        StringBuilder stringBuilder;
        Throwable th2;
        try {
            File file = new File(sAppContext.getFilesDir(), getProcessName());
            if (file.isFile()) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuilder2.append(readLine);
                        } else {
                            String stringBuilder3 = stringBuilder2.toString();
                            com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
                            return stringBuilder3;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        stringBuilder = new StringBuilder("load host exception ");
                        stringBuilder.append(th.getMessage());
                        b.a(stringBuilder.toString());
                        com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
                        return null;
                    } catch (Throwable th4) {
                        th2 = th4;
                        com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
                        throw th2;
                    }
                }
            }
            com.xiaomi.channel.commonutils.file.a.a(null);
            return null;
        } catch (Throwable th5) {
            bufferedReader = null;
            th2 = th5;
            com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
            throw th2;
        }
    }

    public void persist() {
        synchronized (this.mHostsMapping) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(sAppContext.openFileOutput(getProcessName(), 0)));
                Object jSONObject = toJSON().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("persist bucket failure: ");
                stringBuilder.append(e.getMessage());
                b.a(stringBuilder.toString());
            }
        }
    }

    public void purge() {
        synchronized (this.mHostsMapping) {
            for (Fallbacks purge : this.mHostsMapping.values()) {
                purge.purge(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    for (String str : this.mHostsMapping.keySet()) {
                        if (((Fallbacks) this.mHostsMapping.get(str)).getFallbacks().isEmpty()) {
                            this.mHostsMapping.remove(str);
                        }
                    }
                }
            }
        }
    }

    public void refreshFallbacks() {
        ArrayList arrayList;
        synchronized (this.mHostsMapping) {
            int size;
            checkHostMapping();
            arrayList = new ArrayList(this.mHostsMapping.keySet());
            for (size = arrayList.size() - 1; size >= 0; size--) {
                Fallbacks fallbacks = (Fallbacks) this.mHostsMapping.get(arrayList.get(size));
                if (!(fallbacks == null || fallbacks.getFallback() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList requestRemoteFallbacks = requestRemoteFallbacks(arrayList);
        for (size = 0; size < arrayList.size(); size++) {
            if (requestRemoteFallbacks.get(size) != null) {
                updateFallbacks((String) arrayList.get(size), (Fallback) requestRemoteFallbacks.get(size));
            }
        }
    }

    protected Fallback requestRemoteFallback(String str) {
        if (System.currentTimeMillis() - this.lastRemoteRequestTimestamp > (this.remoteRequestFailureCount * 60) * 1000) {
            this.lastRemoteRequestTimestamp = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            Fallback fallback = (Fallback) requestRemoteFallbacks(arrayList).get(0);
            if (fallback != null) {
                this.remoteRequestFailureCount = 0;
                return fallback;
            } else if (this.remoteRequestFailureCount < 15) {
                this.remoteRequestFailureCount++;
            }
        }
        return null;
    }

    public void setCurrentISP(String str) {
        this.currentISP = str;
    }

    protected JSONObject toJSON() {
        JSONObject jSONObject;
        synchronized (this.mHostsMapping) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (Fallbacks toJSON : this.mHostsMapping.values()) {
                jSONArray.put(toJSON.toJSON());
            }
            jSONObject.put("data", jSONArray);
            jSONArray = new JSONArray();
            for (Fallback f : sReservedHosts.values()) {
                jSONArray.put(f.f());
            }
            jSONObject.put("reserved", jSONArray);
        }
        return jSONObject;
    }

    public void updateFallbacks(String str, Fallback fallback) {
        if (!TextUtils.isEmpty(str)) {
            if (fallback != null) {
                if (this.sHostFilter.a(str)) {
                    synchronized (this.mHostsMapping) {
                        checkHostMapping();
                        if (this.mHostsMapping.containsKey(str)) {
                            ((Fallbacks) this.mHostsMapping.get(str)).addFallback(fallback);
                        } else {
                            Fallbacks fallbacks = new Fallbacks(str);
                            fallbacks.addFallback(fallback);
                            this.mHostsMapping.put(str, fallbacks);
                        }
                    }
                    return;
                }
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("the argument is invalid ");
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(fallback);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
