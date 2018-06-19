package com.xunlei.common.base;

import anet.channel.util.HttpConstant;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.encrypt.CharsetConvert;
import java.net.InetAddress;

public final class XLUtilTools {
    public static final String getServerDomain(String str) {
        String str2 = "";
        if (str == null) {
            return str2;
        }
        int indexOf = str.indexOf(HttpConstant.SCHEME_SPLIT);
        if (indexOf == -1) {
            return str2;
        }
        indexOf += 3;
        int indexOf2 = str.indexOf(Constants.COLON_SEPARATOR, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.indexOf("/", indexOf);
        }
        return indexOf2 >= 0 ? str.substring(indexOf, indexOf2) : str2;
    }

    public static final String parseJSONPString(String str) {
        int indexOf = str.indexOf(k.s);
        if (indexOf != -1) {
            str = str.substring(indexOf + 1);
        }
        indexOf = str.lastIndexOf(k.t);
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    public static String transformGBKString(String str) {
        String str2 = "";
        try {
            return new String(str.getBytes("ISO-8859-1"), CharsetConvert.GBK);
        } catch (String str3) {
            str3.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("transformGBKString error = ");
            stringBuilder.append(str3.getMessage());
            XLLog.e("XLUtilTools", stringBuilder.toString());
            return str2;
        }
    }

    public static String transformUTF8String(String str) {
        String str2 = "";
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF8");
        } catch (String str3) {
            str3.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("transformUTF8String error = ");
            stringBuilder.append(str3.getMessage());
            XLLog.e("XLUtilTools", stringBuilder.toString());
            return str2;
        }
    }

    public static String getHostAddress(String str) {
        String str2 = "unknown-host-ip";
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (String str3) {
            str3.printStackTrace();
            return str2;
        } catch (String str32) {
            str32.printStackTrace();
            return str2;
        }
    }

    public static boolean isApplicationInstalled(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x0018;
    L_0x0003:
        r1 = "";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x000c;
    L_0x000b:
        goto L_0x0018;
    L_0x000c:
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0017 }
        r1 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ NameNotFoundException -> 0x0017 }
        r2.getApplicationInfo(r3, r1);	 Catch:{ NameNotFoundException -> 0x0017 }
        r2 = 1;
        return r2;
    L_0x0017:
        return r0;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.base.XLUtilTools.isApplicationInstalled(android.content.Context, java.lang.String):boolean");
    }
}
