package com.getui.gtc.d.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class a {
    private static a a;
    private SharedPreferences b;

    private a(Context context) {
        this.b = context.getSharedPreferences("GINSIGHT-SDK-PREFERENCE", 0);
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    public final String a(String str) {
        try {
            return this.b.getString(str, null);
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            return null;
        }
    }

    public final boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return TextUtils.isEmpty(str2) ? this.b.edit().remove(str).commit() : this.b.edit().putString(str, str2).commit();
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            return false;
        }
    }
}
