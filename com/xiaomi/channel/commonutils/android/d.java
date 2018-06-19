package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.reflect.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

public class d {
    private static String a = null;
    private static String b = "";
    private static String c;
    private static String d;

    public static String a() {
        return VERSION.SDK_INT > 8 ? Build.SERIAL : null;
    }

    public static String a(Context context) {
        if (c == null) {
            String c = c(context);
            String b = b(context);
            String a = a();
            StringBuilder stringBuilder = new StringBuilder("a-");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(c);
            stringBuilder2.append(b);
            stringBuilder2.append(a);
            stringBuilder.append(com.xiaomi.channel.commonutils.string.d.b(stringBuilder2.toString()));
            c = stringBuilder.toString();
        }
        return c;
    }

    @TargetApi(17)
    public static int b() {
        if (VERSION.SDK_INT < 17) {
            return -1;
        }
        Object a = a.a("android.os.UserHandle", "myUserId", new Object[0]);
        return a == null ? -1 : ((Integer) Integer.class.cast(a)).intValue();
    }

    public static String b(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static java.lang.String c(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = d(r3);
        r1 = 10;
    L_0x0006:
        if (r0 != 0) goto L_0x0017;
    L_0x0008:
        r2 = r1 + -1;
        if (r1 <= 0) goto L_0x0017;
    L_0x000c:
        r0 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0011 }
    L_0x0011:
        r0 = d(r3);
        r1 = r2;
        goto L_0x0006;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.d.c(android.content.Context):java.lang.String");
    }

    public static String d(Context context) {
        if (a != null) {
            return a;
        }
        try {
            String str;
            if (f.a()) {
                Object a = a.a("miui.telephony.TelephonyManager", "getDefault", new Object[0]);
                if (a != null) {
                    a = a.a(a, "getMiuiDeviceId", new Object[0]);
                    if (a != null && (a instanceof String)) {
                        str = (String) String.class.cast(a);
                        if (str == null && l(context)) {
                            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                        }
                        if (str != null) {
                            a = str;
                        }
                        return str;
                    }
                }
            }
            str = null;
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            if (str != null) {
                a = str;
            }
            return str;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static java.lang.String e(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = g(r3);
        r1 = 10;
    L_0x0006:
        if (r0 != 0) goto L_0x0017;
    L_0x0008:
        r2 = r1 + -1;
        if (r1 <= 0) goto L_0x0017;
    L_0x000c:
        r0 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0011 }
    L_0x0011:
        r0 = g(r3);
        r1 = r2;
        goto L_0x0006;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.d.e(android.content.Context):java.lang.String");
    }

    public static String f(Context context) {
        if (VERSION.SDK_INT < 22) {
            return "";
        }
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (!l(context)) {
            return "";
        }
        CharSequence d = d(context);
        a = d;
        if (TextUtils.isEmpty(d)) {
            return "";
        }
        try {
            Object obj = (TelephonyManager) context.getSystemService("phone");
            Integer num = (Integer) a.a(obj, "getPhoneCount", new Object[0]);
            if (num == null || num.intValue() <= 1) {
                return "";
            }
            for (int i = 0; i < num.intValue(); i++) {
                String str = (String) a.a(obj, "getDeviceId", Integer.valueOf(i));
                if (!(TextUtils.isEmpty(str) || TextUtils.equals(a, str))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(b);
                    stringBuilder.append(str);
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    b = stringBuilder.toString();
                }
            }
            String substring = b.substring(0, b.length() - 1);
            b = substring;
            return substring;
        } catch (Exception e) {
            b.d(e.toString());
            return "";
        }
    }

    public static String g(Context context) {
        f(context);
        if (TextUtils.isEmpty(b)) {
            return "";
        }
        String str = "";
        for (String str2 : b.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(com.xiaomi.channel.commonutils.string.d.a(str2));
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            str = stringBuilder.toString();
        }
        return str.substring(0, str.length() - 1);
    }

    public static ArrayList<String> h(Context context) {
        a = d(context);
        b = f(context);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(a);
        if (TextUtils.isEmpty(b)) {
            return arrayList;
        }
        for (Object add : b.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static synchronized String i(Context context) {
        synchronized (d.class) {
            if (d != null) {
                String str = d;
                return str;
            }
            str = b(context);
            String a = a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(a);
            str = com.xiaomi.channel.commonutils.string.d.b(stringBuilder.toString());
            d = str;
            return str;
        }
    }

    public static String j(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static String k(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Throwable e) {
            b.a(e);
            return null;
        }
    }

    private static boolean l(Context context) {
        return context.getPackageManager().checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE, context.getPackageName()) == 0;
    }
}
