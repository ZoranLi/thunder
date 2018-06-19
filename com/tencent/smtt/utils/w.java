package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.connect.common.Constants;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tinker.android.dx.instruction.Opcodes;

public class w {
    private static String a = null;
    private static String b = "GA";
    private static String c = "GE";
    private static String d = "9422";
    private static String e = "0";
    private static String f = "";
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;

    private static String a() {
        StringBuilder stringBuilder = new StringBuilder(" ");
        stringBuilder.append(Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", ""));
        stringBuilder.append(" ");
        return stringBuilder.toString();
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), "0", b, c, d, e, f, g);
        a = a;
        return a;
    }

    private static java.lang.String a(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, boolean r17) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = "PHONE";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = b(r9);
        r3.append(r4);
        r4 = "*";
        r3.append(r4);
        r4 = c(r9);
        r3.append(r4);
        r3 = r3.toString();
        r4 = 0;
        r5 = r9.getApplicationContext();	 Catch:{ NameNotFoundException -> 0x0049 }
        r5 = r5.getApplicationInfo();	 Catch:{ NameNotFoundException -> 0x0049 }
        r6 = r9.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0049 }
        r7 = r5.packageName;	 Catch:{ NameNotFoundException -> 0x0049 }
        r8 = 0;	 Catch:{ NameNotFoundException -> 0x0049 }
        r6 = r6.getPackageInfo(r7, r8);	 Catch:{ NameNotFoundException -> 0x0049 }
        r5 = r5.packageName;	 Catch:{ NameNotFoundException -> 0x0049 }
        r7 = android.text.TextUtils.isEmpty(r16);	 Catch:{ NameNotFoundException -> 0x0045 }
        if (r7 != 0) goto L_0x0042;	 Catch:{ NameNotFoundException -> 0x0045 }
    L_0x003f:
        r6 = r16;	 Catch:{ NameNotFoundException -> 0x0045 }
        goto L_0x0051;	 Catch:{ NameNotFoundException -> 0x0045 }
    L_0x0042:
        r6 = r6.versionName;	 Catch:{ NameNotFoundException -> 0x0045 }
        goto L_0x0051;
    L_0x0045:
        r0 = move-exception;
        r6 = r5;
        r5 = r0;
        goto L_0x004c;
    L_0x0049:
        r0 = move-exception;
        r5 = r0;
        r6 = r4;
    L_0x004c:
        r5.printStackTrace();
        r5 = r6;
        r6 = r4;
    L_0x0051:
        r4 = a(r5);
        r7 = "QB";
        r7 = r7.equals(r4);
        if (r7 == 0) goto L_0x0062;
    L_0x005d:
        if (r17 == 0) goto L_0x0069;
    L_0x005f:
        r1 = "PAD";
        goto L_0x0069;
    L_0x0062:
        r7 = d(r9);
        if (r7 == 0) goto L_0x0069;
    L_0x0068:
        goto L_0x005f;
    L_0x0069:
        r7 = "QV=3";
        r2.append(r7);
        r7 = "PL";
        r8 = "ADR";
        a(r2, r7, r8);
        r7 = "PR";
        a(r2, r7, r4);
        r4 = "PP";
        a(r2, r4, r5);
        r4 = "PPVN";
        a(r2, r4, r6);
        r4 = android.text.TextUtils.isEmpty(r10);
        if (r4 != 0) goto L_0x0090;
    L_0x008a:
        r4 = "TBSVC";
        r5 = r10;
        a(r2, r4, r5);
    L_0x0090:
        r4 = "CO";
        r5 = "SYS";
        a(r2, r4, r5);
        r4 = android.text.TextUtils.isEmpty(r11);
        if (r4 != 0) goto L_0x00a3;
    L_0x009d:
        r4 = "COVC";
        r5 = r11;
        a(r2, r4, r5);
    L_0x00a3:
        r4 = "PB";
        r5 = r13;
        a(r2, r4, r5);
        r4 = "VE";
        r5 = r12;
        a(r2, r4, r5);
        r4 = "DE";
        a(r2, r4, r1);
        r1 = "CHID";
        r4 = android.text.TextUtils.isEmpty(r15);
        if (r4 == 0) goto L_0x00bf;
    L_0x00bc:
        r4 = "0";
        goto L_0x00c0;
    L_0x00bf:
        r4 = r15;
    L_0x00c0:
        a(r2, r1, r4);
        r1 = "LCID";
        r4 = r14;
        a(r2, r1, r4);
        r1 = a();
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x00db }
        r5 = "UTF-8";	 Catch:{ Exception -> 0x00db }
        r5 = r1.getBytes(r5);	 Catch:{ Exception -> 0x00db }
        r6 = "ISO8859-1";	 Catch:{ Exception -> 0x00db }
        r4.<init>(r5, r6);	 Catch:{ Exception -> 0x00db }
        r1 = r4;
    L_0x00db:
        r4 = android.text.TextUtils.isEmpty(r1);
        if (r4 != 0) goto L_0x00e6;
    L_0x00e1:
        r4 = "MO";
        a(r2, r4, r1);
    L_0x00e6:
        r1 = "RL";
        a(r2, r1, r3);
        r1 = android.os.Build.VERSION.RELEASE;
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x00fb }
        r4 = "UTF-8";	 Catch:{ Exception -> 0x00fb }
        r4 = r1.getBytes(r4);	 Catch:{ Exception -> 0x00fb }
        r5 = "ISO8859-1";	 Catch:{ Exception -> 0x00fb }
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x00fb }
        r1 = r3;
    L_0x00fb:
        r3 = android.text.TextUtils.isEmpty(r1);
        if (r3 != 0) goto L_0x0106;
    L_0x0101:
        r3 = "OS";
        a(r2, r3, r1);
    L_0x0106:
        r1 = "API";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = android.os.Build.VERSION.SDK_INT;
        r3.append(r4);
        r3 = r3.toString();
        a(r2, r1, r3);
        r1 = r2.toString();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.w.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private static String a(String str) {
        return str.equals("com.tencent.mm") ? "WX" : str.equals("com.tencent.mobileqq") ? Constants.SOURCE_QQ : str.equals("com.qzone") ? "QZ" : str.equals(TbsConfig.APP_QB) ? "QB" : "TRD";
    }

    private static void a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append("&");
        stringBuilder.append(str);
        stringBuilder.append("=");
        stringBuilder.append(str2);
    }

    private static int b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return defaultDisplay != null ? defaultDisplay.getWidth() : -1;
    }

    private static int c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return defaultDisplay != null ? defaultDisplay.getHeight() : -1;
    }

    private static boolean d(Context context) {
        if (h) {
            return i;
        }
        i = (Math.min(b(context), c(context)) * Opcodes.AND_LONG) / e(context) >= 700;
        h = true;
        return i;
    }

    private static int e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            return Opcodes.AND_LONG;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }
}
