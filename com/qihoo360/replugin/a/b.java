package com.qihoo360.replugin.a;

import android.content.Intent;
import android.text.TextUtils;
import com.qihoo360.loader2.ac;
import com.qihoo360.replugin.b.c;

/* compiled from: IPC */
public final class b {
    public static String a;
    public static int b;
    public static String c;
    public static String d;
    public static boolean e;
    public static boolean f;

    public static boolean a(String str, Intent intent) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("sendLocalBroadcast2Plugin: target=");
            stringBuilder.append(str);
            stringBuilder.append(" intent=");
            stringBuilder.append(intent);
            c.a("IPC", stringBuilder.toString());
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ac.c().b(str, intent);
            return true;
        } catch (String str2) {
            str2.printStackTrace();
            return false;
        }
    }

    public static boolean b(String str, Intent intent) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("sendLocalBroadcast2Process: target=");
            stringBuilder.append(str);
            stringBuilder.append(" intent=");
            stringBuilder.append(intent);
            c.a("IPC", stringBuilder.toString());
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ac.c().a(str, intent);
            return true;
        } catch (String str2) {
            str2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Intent intent) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("sendLocalBroadcast2All: intent=");
            stringBuilder.append(intent);
            c.a("IPC", stringBuilder.toString());
        }
        try {
            ac.c().a(null, intent);
            return true;
        } catch (Intent intent2) {
            intent2.printStackTrace();
            return null;
        }
    }

    public static boolean b(Intent intent) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("sendLocalBroadcast2AllSync: intent=");
            stringBuilder.append(intent);
            c.a("IPC", stringBuilder.toString());
        }
        try {
            ac.c().c(null, intent);
            return true;
        } catch (Intent intent2) {
            intent2.printStackTrace();
            return null;
        }
    }
}
