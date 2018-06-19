package com.xunlei.common.new_ptl.member.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.encrypt.AES;
import com.xunlei.common.encrypt.Base64;

/* compiled from: XLAutoLoginParcel */
public class d {
    private static final int c = 100;
    private static final String f = "user-aes-key";
    public final long a;
    public final String b;
    private String d;
    private String e;

    /* compiled from: XLAutoLoginParcel */
    public enum a {
        ;

        static {
            d = new int[]{1, 2, 3};
        }

        private static int[] a() {
            return (int[]) d.clone();
        }
    }

    public d(long j, String str, String str2, String str3) {
        this.a = j;
        this.b = str3;
    }

    public final boolean a() {
        return (this.a == 0 || TextUtils.isEmpty(this.b)) ? false : true;
    }

    public static d a(Context context) {
        long j;
        context = context.getSharedPreferences("xl-acc-auto-login", 0);
        if (context.getInt("version", 0) > 0) {
            j = context.getLong("userid", 0);
        } else {
            j = (long) context.getInt("uid", 0);
        }
        if (j != 0) {
            String string = context.getString("lkey", "");
            Context dVar = new d(j, "", "", context.getInt("kecd", 0) == 1 ? b(string) : string);
        } else {
            context = null;
        }
        StringBuilder stringBuilder = new StringBuilder("retrieveAutoLoginParcel uid = ");
        stringBuilder.append(j);
        XLLog.v("XLAutoLoginParcel", stringBuilder.toString());
        return context;
    }

    public static void a(d dVar, Context context, int i) {
        context = context.getSharedPreferences("xl-acc-auto-login", 0).edit();
        context.putInt("version", 100);
        context.putLong("userid", dVar.a);
        if (a.a == i || a.b == i) {
            i = "lkey";
            String str = dVar.b;
            String str2 = "";
            if (!TextUtils.isEmpty(str)) {
                str2 = Base64.encode(AES.encrypt(str, f));
            }
            context.putString(i, str2);
            context.putInt("kecd", 1);
        }
        context.apply();
        i = new StringBuilder("saveAutoLoginParcel uid = ");
        i.append(dVar.a);
        XLLog.v("XLAutoLoginParcel", i.toString());
    }

    public static void a(Context context, int i) {
        long j;
        context = context.getSharedPreferences("xl-acc-auto-login", 0);
        int i2 = context.getInt("version", 0);
        if (i2 > 0) {
            j = context.getLong("userid", 0);
        } else {
            j = (long) context.getInt("uid", 0);
        }
        if (j != 0) {
            Editor edit = context.edit();
            if (a.b == i) {
                if (i2 > 0) {
                    edit.putLong("userid", 0);
                }
                if (context.contains("uid") != null) {
                    edit.putInt("uid", 0);
                }
            }
            if (a.a == i || a.b == i) {
                edit.putString("lkey", "");
            }
            edit.apply();
        }
        i = new StringBuilder("removeAutoLoginParcel uid = ");
        i.append(j);
        XLLog.v("XLAutoLoginParcel", i.toString());
    }

    private static String a(String str) {
        return !TextUtils.isEmpty(str) ? Base64.encode(AES.encrypt(str, f)) : "";
    }

    private static String b(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            return new String(AES.decrypt(Base64.decode(str), f), "UTF-8");
        } catch (String str3) {
            str3.printStackTrace();
            return str2;
        }
    }

    private d() {
    }

    public static String b() {
        return XLDeviceGen.getInstance().getDeviceId();
    }

    public static String c() {
        return XLDeviceGen.getInstance().getDeviceIdSign();
    }
}
