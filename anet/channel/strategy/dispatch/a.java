package anet.channel.strategy.dispatch;

import android.content.Context;
import anet.channel.util.ALog;

/* compiled from: Taobao */
public class a {
    public static volatile double a;
    public static volatile double b;
    private static volatile Context c;
    private static volatile int d;
    private static volatile long e;
    private static IAmdcSign f;

    public static void a(int i, int i2) {
        ALog.i("awcn.AmdcRuntimeInfo", "set amdc limit", null, "level", Integer.valueOf(i), "time", Integer.valueOf(i2));
        if (d != i) {
            d = i;
            e = System.currentTimeMillis() + (((long) i2) * 1000);
        }
    }

    public static int a() {
        if (d > 0 && System.currentTimeMillis() - e > 0) {
            e = 0;
            d = 0;
        }
        return d;
    }

    public static void a(Context context) {
        c = context;
    }

    public static void a(IAmdcSign iAmdcSign) {
        f = iAmdcSign;
    }

    public static IAmdcSign b() {
        return f;
    }
}
