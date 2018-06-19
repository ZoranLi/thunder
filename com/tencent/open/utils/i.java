package com.tencent.open.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.taobao.agoo.a.a.b;
import com.tencent.open.a.f;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.av;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class i {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static int e = -1;
    private static String f = null;
    private static String g = "0123456789ABCDEF";

    /* compiled from: ProGuard */
    public static class a {
        public String a;
        public long b;
        public long c;

        public a(String str, int i) {
            this.a = str;
            this.b = (long) i;
            if (this.a != null) {
                this.c = (long) this.a.length();
            }
        }
    }

    private static char a(int i) {
        i &= 15;
        return i < 10 ? (char) (48 + i) : (char) (97 + (i - 10));
    }

    public static android.os.Bundle a(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new android.os.Bundle;
        r0.<init>();
        if (r7 == 0) goto L_0x0032;
    L_0x0007:
        r1 = "&";	 Catch:{ Exception -> 0x0031 }
        r7 = r7.split(r1);	 Catch:{ Exception -> 0x0031 }
        r1 = r7.length;	 Catch:{ Exception -> 0x0031 }
        r2 = 0;	 Catch:{ Exception -> 0x0031 }
        r3 = r2;	 Catch:{ Exception -> 0x0031 }
    L_0x0010:
        if (r3 >= r1) goto L_0x0032;	 Catch:{ Exception -> 0x0031 }
    L_0x0012:
        r4 = r7[r3];	 Catch:{ Exception -> 0x0031 }
        r5 = "=";	 Catch:{ Exception -> 0x0031 }
        r4 = r4.split(r5);	 Catch:{ Exception -> 0x0031 }
        r5 = r4.length;	 Catch:{ Exception -> 0x0031 }
        r6 = 2;	 Catch:{ Exception -> 0x0031 }
        if (r5 != r6) goto L_0x002e;	 Catch:{ Exception -> 0x0031 }
    L_0x001e:
        r5 = r4[r2];	 Catch:{ Exception -> 0x0031 }
        r5 = java.net.URLDecoder.decode(r5);	 Catch:{ Exception -> 0x0031 }
        r6 = 1;	 Catch:{ Exception -> 0x0031 }
        r4 = r4[r6];	 Catch:{ Exception -> 0x0031 }
        r4 = java.net.URLDecoder.decode(r4);	 Catch:{ Exception -> 0x0031 }
        r0.putString(r5, r4);	 Catch:{ Exception -> 0x0031 }
    L_0x002e:
        r3 = r3 + 1;
        goto L_0x0010;
    L_0x0031:
        r0 = 0;
    L_0x0032:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.i.a(java.lang.String):android.os.Bundle");
    }

    public static org.json.JSONObject a(org.json.JSONObject r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r7 != 0) goto L_0x0007;
    L_0x0002:
        r7 = new org.json.JSONObject;
        r7.<init>();
    L_0x0007:
        if (r8 == 0) goto L_0x0056;
    L_0x0009:
        r0 = "&";
        r8 = r8.split(r0);
        r0 = 0;
        r1 = r8.length;
        r2 = r0;
    L_0x0012:
        if (r2 >= r1) goto L_0x0056;
    L_0x0014:
        r3 = r8[r2];
        r4 = "=";
        r3 = r3.split(r4);
        r4 = r3.length;
        r5 = 2;
        if (r4 != r5) goto L_0x0053;
    L_0x0020:
        r4 = 1;
        r5 = r3[r0];	 Catch:{ Exception -> 0x0034 }
        r5 = java.net.URLDecoder.decode(r5);	 Catch:{ Exception -> 0x0034 }
        r3[r0] = r5;	 Catch:{ Exception -> 0x0034 }
        r5 = r3[r4];	 Catch:{ Exception -> 0x0034 }
        r5 = java.net.URLDecoder.decode(r5);	 Catch:{ Exception -> 0x0034 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0034 }
        goto L_0x0034;
    L_0x0032:
        r3 = move-exception;
        goto L_0x003c;
    L_0x0034:
        r5 = r3[r0];	 Catch:{ JSONException -> 0x0032 }
        r3 = r3[r4];	 Catch:{ JSONException -> 0x0032 }
        r7.put(r5, r3);	 Catch:{ JSONException -> 0x0032 }
        goto L_0x0053;
    L_0x003c:
        r4 = "openSDK_LOG.Util";
        r5 = new java.lang.StringBuilder;
        r6 = "decodeUrlToJson has exception: ";
        r5.<init>(r6);
        r3 = r3.getMessage();
        r5.append(r3);
        r3 = r5.toString();
        com.tencent.open.a.f.e(r4, r3);
    L_0x0053:
        r2 = r2 + 1;
        goto L_0x0012;
    L_0x0056:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.i.a(org.json.JSONObject, java.lang.String):org.json.JSONObject");
    }

    public static android.os.Bundle b(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "auth://";
        r1 = "http://";
        r2 = r2.replace(r0, r1);
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0021 }
        r0.<init>(r2);	 Catch:{ MalformedURLException -> 0x0021 }
        r2 = r0.getQuery();	 Catch:{ MalformedURLException -> 0x0021 }
        r2 = a(r2);	 Catch:{ MalformedURLException -> 0x0021 }
        r0 = r0.getRef();	 Catch:{ MalformedURLException -> 0x0021 }
        r0 = a(r0);	 Catch:{ MalformedURLException -> 0x0021 }
        r2.putAll(r0);	 Catch:{ MalformedURLException -> 0x0021 }
        return r2;
    L_0x0021:
        r2 = new android.os.Bundle;
        r2.<init>();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.i.b(java.lang.String):android.os.Bundle");
    }

    public static org.json.JSONObject c(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "auth://";
        r1 = "http://";
        r2 = r2.replace(r0, r1);
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x001e }
        r0.<init>(r2);	 Catch:{ MalformedURLException -> 0x001e }
        r2 = 0;	 Catch:{ MalformedURLException -> 0x001e }
        r1 = r0.getQuery();	 Catch:{ MalformedURLException -> 0x001e }
        r2 = a(r2, r1);	 Catch:{ MalformedURLException -> 0x001e }
        r0 = r0.getRef();	 Catch:{ MalformedURLException -> 0x001e }
        a(r2, r0);	 Catch:{ MalformedURLException -> 0x001e }
        return r2;
    L_0x001e:
        r2 = new org.json.JSONObject;
        r2.<init>();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.i.c(java.lang.String):org.json.JSONObject");
    }

    public static JSONObject d(String str) throws JSONException {
        if (str.equals(av.b)) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            StringBuilder stringBuilder = new StringBuilder("{online:");
            stringBuilder.append(str.charAt(str.length() - 2));
            stringBuilder.append(h.d);
            str = stringBuilder.toString();
        }
        return new JSONObject(str);
    }

    public static String a() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Throwable e) {
            f.a("openSDK_LOG.Util", "getUserIp SocketException ", e);
        }
        return "";
    }

    public static boolean e(String str) {
        if (str != null) {
            if (str.length() != null) {
                return null;
            }
        }
        return true;
    }

    private static boolean g(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r4 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0060 }
        r1 = "com.tencent.mtt";	 Catch:{ NameNotFoundException -> 0x0060 }
        r2 = 64;	 Catch:{ NameNotFoundException -> 0x0060 }
        r4 = r4.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0060 }
        r1 = r4.versionName;	 Catch:{ NameNotFoundException -> 0x0060 }
        r2 = "4.3";	 Catch:{ NameNotFoundException -> 0x0060 }
        r2 = com.tencent.open.utils.g.a(r1, r2);	 Catch:{ NameNotFoundException -> 0x0060 }
        if (r2 < 0) goto L_0x005f;	 Catch:{ NameNotFoundException -> 0x0060 }
    L_0x0017:
        r2 = "4.4";	 Catch:{ NameNotFoundException -> 0x0060 }
        r1 = r1.startsWith(r2);	 Catch:{ NameNotFoundException -> 0x0060 }
        if (r1 != 0) goto L_0x005f;	 Catch:{ NameNotFoundException -> 0x0060 }
    L_0x001f:
        r4 = r4.signatures;	 Catch:{ NameNotFoundException -> 0x0060 }
        if (r4 == 0) goto L_0x005f;
    L_0x0023:
        r1 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x0047 }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0047 }
        r4 = r4[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0047 }
        r4 = r4.toByteArray();	 Catch:{ NoSuchAlgorithmException -> 0x0047 }
        r1.update(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0047 }
        r4 = r1.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0047 }
        r4 = a(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0047 }
        r1.reset();	 Catch:{ NoSuchAlgorithmException -> 0x0047 }
        r1 = "d8391a394d4a179e6fe7bdb8a301258b";	 Catch:{ NoSuchAlgorithmException -> 0x0047 }
        r4 = r4.equals(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0047 }
        if (r4 == 0) goto L_0x005f;
    L_0x0045:
        r4 = 1;
        return r4;
    L_0x0047:
        r4 = move-exception;
        r1 = "openSDK_LOG.Util";	 Catch:{ NameNotFoundException -> 0x0060 }
        r2 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0060 }
        r3 = "isQQBrowerAvailable has exception: ";	 Catch:{ NameNotFoundException -> 0x0060 }
        r2.<init>(r3);	 Catch:{ NameNotFoundException -> 0x0060 }
        r4 = r4.getMessage();	 Catch:{ NameNotFoundException -> 0x0060 }
        r2.append(r4);	 Catch:{ NameNotFoundException -> 0x0060 }
        r4 = r2.toString();	 Catch:{ NameNotFoundException -> 0x0060 }
        com.tencent.open.a.f.e(r1, r4);	 Catch:{ NameNotFoundException -> 0x0060 }
    L_0x005f:
        return r0;
    L_0x0060:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.i.g(android.content.Context):boolean");
    }

    public static boolean a(android.content.Context r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = g(r4);	 Catch:{ Exception -> 0x0017 }
        if (r1 == 0) goto L_0x000f;
    L_0x0007:
        r2 = "com.tencent.mtt";	 Catch:{ Exception -> 0x0018 }
        r3 = "com.tencent.mtt.MainActivity";	 Catch:{ Exception -> 0x0018 }
        a(r4, r2, r3, r5);	 Catch:{ Exception -> 0x0018 }
        goto L_0x0042;	 Catch:{ Exception -> 0x0018 }
    L_0x000f:
        r2 = "com.android.browser";	 Catch:{ Exception -> 0x0018 }
        r3 = "com.android.browser.BrowserActivity";	 Catch:{ Exception -> 0x0018 }
        a(r4, r2, r3, r5);	 Catch:{ Exception -> 0x0018 }
        goto L_0x0042;
    L_0x0017:
        r1 = r0;
    L_0x0018:
        if (r1 == 0) goto L_0x0033;
    L_0x001a:
        r1 = "com.android.browser";	 Catch:{ Exception -> 0x0022 }
        r2 = "com.android.browser.BrowserActivity";	 Catch:{ Exception -> 0x0022 }
        a(r4, r1, r2, r5);	 Catch:{ Exception -> 0x0022 }
        goto L_0x0042;
    L_0x0022:
        r1 = "com.google.android.browser";	 Catch:{ Exception -> 0x002a }
        r2 = "com.android.browser.BrowserActivity";	 Catch:{ Exception -> 0x002a }
        a(r4, r1, r2, r5);	 Catch:{ Exception -> 0x002a }
        goto L_0x0042;
    L_0x002a:
        r1 = "com.android.chrome";	 Catch:{ Exception -> 0x0032 }
        r2 = "com.google.android.apps.chrome.Main";	 Catch:{ Exception -> 0x0032 }
        a(r4, r1, r2, r5);	 Catch:{ Exception -> 0x0032 }
        goto L_0x0042;
    L_0x0032:
        return r0;
    L_0x0033:
        r1 = "com.google.android.browser";	 Catch:{ Exception -> 0x003b }
        r2 = "com.android.browser.BrowserActivity";	 Catch:{ Exception -> 0x003b }
        a(r4, r1, r2, r5);	 Catch:{ Exception -> 0x003b }
        goto L_0x0042;
    L_0x003b:
        r1 = "com.android.chrome";	 Catch:{ Exception -> 0x0044 }
        r2 = "com.google.android.apps.chrome.Main";	 Catch:{ Exception -> 0x0044 }
        a(r4, r1, r2, r5);	 Catch:{ Exception -> 0x0044 }
    L_0x0042:
        r4 = 1;
        return r4;
    L_0x0044:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.i.a(android.content.Context, java.lang.String):boolean");
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static String f(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(i(str));
            byte[] digest = instance.digest();
            if (digest == null) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : digest) {
                stringBuilder.append(a(i >>> 4));
                stringBuilder.append(a(i));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            StringBuilder stringBuilder2 = new StringBuilder("encrypt has exception: ");
            stringBuilder2.append(e.getMessage());
            f.e("openSDK_LOG.Util", stringBuilder2.toString());
            return str;
        }
    }

    public static boolean b() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String num = Integer.toString(b & 255, 16);
            if (num.length() == 1) {
                StringBuilder stringBuilder2 = new StringBuilder("0");
                stringBuilder2.append(num);
                num = stringBuilder2.toString();
            }
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static final String a(Context context) {
        if (context != null) {
            context = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
            if (context != null) {
                return context.toString();
            }
        }
        return null;
    }

    public static final boolean g(String str) {
        if (str == null) {
            return false;
        }
        if (!str.startsWith("http://")) {
            if (str.startsWith("https://") == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(String str) {
        if (str == null || new File(str).exists() == null) {
            return false;
        }
        return true;
    }

    public static final String a(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str4 = "UTF-8";
        if (TextUtils.isEmpty(str2)) {
            str2 = str4;
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i2 = 0;
            int i3 = i2;
            while (i2 < str.length()) {
                int i4 = i2 + 1;
                i3 += str.substring(i2, i4).getBytes(str2).length;
                if (i3 > i) {
                    i = str.substring(0, i2);
                    try {
                        if (TextUtils.isEmpty(str3) == null) {
                            str = new StringBuilder();
                            str.append(i);
                            str.append(str3);
                            str = str.toString();
                        } else {
                            str = i;
                        }
                        return str;
                    } catch (String str5) {
                        String str6 = i;
                        i = str5;
                        str5 = str6;
                        str2 = System.out;
                        str3 = new StringBuilder("StructMsg sSubString error : ");
                        str3.append(i.getMessage());
                        str2.println(str3.toString());
                        return str5;
                    }
                }
                i2 = i4;
            }
            return str5;
        } catch (Exception e) {
            i = e;
            str2 = System.out;
            str3 = new StringBuilder("StructMsg sSubString error : ");
            str3.append(i.getMessage());
            str2.println(str3.toString());
            return str5;
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        context = connectivityManager.getAllNetworkInfo();
        if (context != null) {
            for (NetworkInfo isConnectedOrConnecting : context) {
                if (isConnectedOrConnecting.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA, str4);
        bundle.putString(Constants.APP_ID, str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        return bundle;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", str);
        bundle.putString("code", str2);
        bundle.putString("tmcost", str3);
        bundle.putString("rate", str4);
        bundle.putString(b.JSON_CMD, str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString("share_type", str8);
        bundle.putString("detail", str9);
        bundle.putString("os_ver", VERSION.RELEASE);
        bundle.putString("network", com.tencent.open.b.a.a(d.a()));
        bundle.putString("apn", com.tencent.open.b.a.b(d.a()));
        bundle.putString("model_name", Build.MODEL);
        bundle.putString("sdk_ver", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString("packagename", d.b());
        bundle.putString("app_ver", d(d.a(), d.b()));
        return bundle;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider != null) {
                context = locationManager.getLastKnownLocation(bestProvider);
                if (context == null) {
                    return "";
                }
                double latitude = context.getLatitude();
                double longitude = context.getLongitude();
                context = new StringBuilder();
                context.append(latitude);
                context.append("*");
                context.append(longitude);
                context = context.toString();
                f = context;
                return context;
            }
        } catch (Context context2) {
            f.b("openSDK_LOG.Util", "getLocation>>>", context2);
        }
        return "";
    }

    public static void b(Context context, String str) {
        StringBuilder stringBuilder;
        if (context != null) {
            try {
                context = context.getPackageManager().getPackageInfo(str, 0);
                str = context.versionName;
                b = str;
                a = str.substring(0, b.lastIndexOf(46));
                d = b.substring(b.lastIndexOf(46) + 1, b.length());
                e = context.versionCode;
            } catch (Context context2) {
                stringBuilder = new StringBuilder("getPackageInfo has exception: ");
                stringBuilder.append(context2.getMessage());
                f.e("openSDK_LOG.Util", stringBuilder.toString());
            } catch (Context context22) {
                stringBuilder = new StringBuilder("getPackageInfo has exception: ");
                stringBuilder.append(context22.getMessage());
                f.e("openSDK_LOG.Util", stringBuilder.toString());
            }
        }
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return b;
    }

    public static String d(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return a;
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return "";
        }
        context = d(context, str);
        c = context;
        return context;
    }

    public static byte[] i(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0007 }
        r1 = r1.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x0007 }
        return r1;
    L_0x0007:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.i.i(java.lang.String):byte[]");
    }

    public static boolean d(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = r6.getResources();	 Catch:{ Throwable -> 0x0026 }
        r6 = r6.getDisplayMetrics();	 Catch:{ Throwable -> 0x0026 }
        r0 = r6.widthPixels;	 Catch:{ Throwable -> 0x0026 }
        r0 = (float) r0;	 Catch:{ Throwable -> 0x0026 }
        r1 = r6.xdpi;	 Catch:{ Throwable -> 0x0026 }
        r0 = r0 / r1;	 Catch:{ Throwable -> 0x0026 }
        r1 = r6.heightPixels;	 Catch:{ Throwable -> 0x0026 }
        r1 = (float) r1;	 Catch:{ Throwable -> 0x0026 }
        r6 = r6.ydpi;	 Catch:{ Throwable -> 0x0026 }
        r1 = r1 / r6;	 Catch:{ Throwable -> 0x0026 }
        r2 = (double) r0;	 Catch:{ Throwable -> 0x0026 }
        r4 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;	 Catch:{ Throwable -> 0x0026 }
        r2 = java.lang.Math.pow(r2, r4);	 Catch:{ Throwable -> 0x0026 }
        r0 = (double) r1;	 Catch:{ Throwable -> 0x0026 }
        r0 = java.lang.Math.pow(r0, r4);	 Catch:{ Throwable -> 0x0026 }
        r2 = r2 + r0;	 Catch:{ Throwable -> 0x0026 }
        r0 = java.lang.Math.sqrt(r2);	 Catch:{ Throwable -> 0x0026 }
        goto L_0x0028;
    L_0x0026:
        r0 = 0;
    L_0x0028:
        r2 = 4619004367821864960; // 0x401a000000000000 float:0.0 double:6.5;
        r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r6 <= 0) goto L_0x0030;
    L_0x002e:
        r6 = 1;
        return r6;
    L_0x0030:
        r6 = 0;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.i.d(android.content.Context):boolean");
    }

    public static boolean f(Context context, String str) {
        boolean z = !d(context) || g.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) == null;
        if (z && g.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) != null) {
            z = false;
        }
        if (z) {
            return g.c(context, str) < null;
        } else {
            return z;
        }
    }

    public static boolean e(Context context) {
        if ((!d(context) || g.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) == null) && g.c(context, "4.1") < 0) {
            if (g.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean f(Context context) {
        if (g.c(context, "5.9.5") < 0) {
            if (g.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) == null) {
                return null;
            }
        }
        return true;
    }
}
