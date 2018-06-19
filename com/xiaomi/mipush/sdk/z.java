package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;

public class z {
    private static volatile AbstractPushManager a;

    public static AbstractPushManager a(Context context) {
        if (v.HUAWEI.equals(d.a(context)) && d.a()) {
            if (!d.b(context)) {
                if (a != null) {
                    a.unregister();
                    a = null;
                }
                return a;
            } else if (a == null) {
                synchronized (z.class) {
                    if (a == null) {
                        try {
                            a = (AbstractPushManager) Class.forName("com.xiaomi.assemble.control.HmsPushManager").getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context});
                        } catch (Throwable th) {
                            b.d(th.toString());
                            return null;
                        }
                    }
                }
            }
        }
        return a;
    }
}
