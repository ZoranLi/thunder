package anetwork.channel.a;

import android.preference.PreferenceManager;
import anetwork.channel.http.NetworkSdkSetting;

/* compiled from: Taobao */
public final class b {
    private static volatile boolean a = true;
    private static volatile boolean b = true;
    private static volatile boolean c = true;
    private static volatile boolean d = true;
    private static volatile boolean e = true;
    private static volatile boolean f = false;
    private static volatile long g;
    private static volatile a h;

    public static void a() {
        a cVar = new c();
        h = cVar;
        cVar.a();
        g = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).getLong("Cache.Flag", 0);
    }

    public static boolean b() {
        return a;
    }

    public static boolean c() {
        return b;
    }

    public static boolean d() {
        return d;
    }

    public static boolean e() {
        return d && f;
    }

    public static boolean f() {
        return e;
    }
}
