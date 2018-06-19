package com.xunlei.downloadprovider.member.payment.external;

import android.text.TextUtils;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.i;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class PayUtil {
    public static boolean a = false;
    public static boolean b = false;
    private static final SimpleDateFormat c = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());

    public static float a(int i, float f, float f2) {
        float f3 = (((float) i) * f) - f2;
        return f3 < 0.0f ? 0.0f : f3;
    }

    public static String a(int i) {
        String str = "会员";
        if (i != 5) {
            if (i == 204) {
                return "快鸟会员";
            }
            if (i != 209) {
                switch (i) {
                    case 2:
                        return "普通会员";
                    case 3:
                        return "白金会员";
                    default:
                        return str;
                }
            }
        }
        return "超级会员";
    }

    public static String b(int i) {
        return a(i);
    }

    public static String a(OrderType orderType, int i) {
        orderType = orderType.getText();
        i = a(i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(orderType);
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() < 6) {
            return str;
        }
        String substring = str.substring(0, 4);
        String substring2 = str.substring(4, 6);
        str = str.substring(6);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(substring);
        stringBuilder.append("-");
        stringBuilder.append(substring2);
        stringBuilder.append("-");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String a(float f) {
        int i = (int) f;
        if (((float) i) != f) {
            return new DecimalFormat("0.0").format((double) f);
        }
        return String.valueOf(i);
    }

    public static String b(float f) {
        int i = (int) f;
        if (((float) i) != f) {
            return new DecimalFormat("0.00").format((double) f);
        }
        return String.valueOf(i);
    }

    public static long b(String str) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        if (!TextUtils.isDigitsOnly(str)) {
            return -1;
        }
        instance.set(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(4, 6)) - 1, Integer.parseInt(str.substring(6, 8)));
        long timeInMillis = instance.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
        long j = timeInMillis % 86400000;
        timeInMillis /= 86400000;
        return j > 0 ? timeInMillis + 1 : timeInMillis;
    }

    public static boolean a(int i, int i2, int i3) {
        return Math.max(i2, i) == Math.min(i, i3);
    }

    public static boolean a(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        date = Calendar.getInstance();
        date.setTime(date2);
        if (instance.get(1) == date.get(1) && instance.get(2) == date.get(2) && instance.get(5) == date.get(5)) {
            return true;
        }
        return null;
    }

    public static Date c(String str) {
        try {
            return c.parse(str);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static java.lang.Integer d(java.lang.String r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0005 }
        goto L_0x0006;
    L_0x0005:
        r0 = -1;
    L_0x0006:
        r0 = java.lang.Integer.valueOf(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.external.PayUtil.d(java.lang.String):java.lang.Integer");
    }

    public static String c(int i) {
        return i.b(i) != 0 ? "25" : "12.6";
    }

    public static boolean b() {
        GregorianCalendar gregorianCalendar;
        j a = j.a();
        if (!TextUtils.isEmpty(a.f())) {
            String f = a.f();
            if (f.length() >= 6 && TextUtils.isDigitsOnly(f)) {
                gregorianCalendar = new GregorianCalendar(Integer.parseInt(f.substring(0, 4)), Integer.parseInt(f.substring(4, 6)) - 1, Integer.parseInt(f.substring(6)));
                return gregorianCalendar == null && gregorianCalendar.getTimeInMillis() < System.currentTimeMillis() + 86400000;
            }
        }
        gregorianCalendar = null;
        if (gregorianCalendar == null) {
            return false;
        }
    }

    public static void a() {
        XLThreadPool.execute(new j());
        new StringBuilder("---PayUtil---sendMessageToService ---").append(Thread.currentThread().getId());
        j.a();
        if (!l.b()) {
            LoginHelper.a().a(false);
        }
    }
}
