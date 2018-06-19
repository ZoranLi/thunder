package mtopsdk.mtop.b;

import android.content.Context;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.i;
import mtopsdk.common.util.j;
import mtopsdk.mtop.a.d;

public class a {
    private static volatile a a = null;
    private static volatile boolean b = false;

    private a() {
    }

    public static a a(Context context) {
        return a(context, null);
    }

    public static a a(Context context, String str) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
            if (!b) {
                b(context, str);
            }
        }
        if (i.a(str)) {
            d.a().a(str);
        }
        return a;
    }

    private static synchronized void b(Context context, String str) {
        synchronized (a.class) {
            if (!b) {
                if (context == null) {
                    j.e("[Mtop init] The Parameter context can not be null.");
                    throw new IllegalArgumentException("The Parameter context can not be null.");
                }
                if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
                    StringBuilder stringBuilder = new StringBuilder("[init] ttid=");
                    stringBuilder.append(str);
                    j.a(stringBuilder.toString());
                }
                mtopsdk.mtop.a.a.a(context, str);
                b = true;
            }
        }
    }
}
