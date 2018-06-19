package com.qihoo360.loader2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qihoo360.replugin.b.c;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PluginStatusController */
public final class ah {
    @SuppressLint({"StaticFieldLeak"})
    public static Application a;

    /* compiled from: PluginStatusController */
    private static class a {
        JSONObject a;

        a(String str) throws JSONException {
            this.a = new JSONObject(str);
        }

        public final int a() {
            return this.a.optInt("ver");
        }
    }

    public static int a(String str, int i) {
        a a = a(str);
        if (a == null) {
            if (c.a != 0) {
                StringBuilder stringBuilder = new StringBuilder("PStatusC.getStatus(): ps is null. pn=");
                stringBuilder.append(str);
                c.a("ws001", stringBuilder.toString());
            }
            return 0;
        } else if (i == -1 || a.a() == i) {
            int optInt = a.a.optInt(SocializeProtocolConstants.PROTOCOL_KEY_ST);
            if (c.a) {
                StringBuilder stringBuilder2 = new StringBuilder("PStatusC.getStatus(): ver match. ver=");
                stringBuilder2.append(i);
                stringBuilder2.append("; pn=");
                stringBuilder2.append(str);
                stringBuilder2.append("; st=");
                stringBuilder2.append(optInt);
                c.a("ws001", stringBuilder2.toString());
            }
            return optInt;
        } else {
            if (c.a) {
                StringBuilder stringBuilder3 = new StringBuilder("PStatusC.getStatus(): ver not match. ver=");
                stringBuilder3.append(i);
                stringBuilder3.append("; expect=");
                stringBuilder3.append(a.a());
                stringBuilder3.append("; pn=");
                stringBuilder3.append(str);
                c.a("ws001", stringBuilder3.toString());
            }
            return 0;
        }
    }

    private static a a(String str) {
        SharedPreferences sharedPreferences = a.getSharedPreferences("plugins", 0);
        StringBuilder stringBuilder = new StringBuilder("ps-");
        stringBuilder.append(str);
        Object string = sharedPreferences.getString(stringBuilder.toString(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new a(string);
        } catch (Throwable e) {
            if (c.a) {
                c.a("ws001", "PStatusC.getStatus(): json err.", e);
            }
            a(a, str);
            return null;
        }
    }

    static void a(Context context, String str) {
        context = context.getSharedPreferences("plugins", 0).edit();
        StringBuilder stringBuilder = new StringBuilder("ps-");
        stringBuilder.append(str);
        context.remove(stringBuilder.toString()).commit();
    }
}
