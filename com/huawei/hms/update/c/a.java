package com.huawei.hms.update.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.c.e;
import com.huawei.hms.update.e.o;
import com.huawei.hms.update.e.q;

/* compiled from: UpdateManager */
public class a {
    private static int a;
    private static Class<?> b;

    public static String b() {
        return "core.connnect";
    }

    public static void a(Activity activity, int i) {
        if (b == null) {
            a(activity);
            if (a((Context) activity)) {
                b(activity, i);
            } else {
                c(activity, i);
            }
        }
    }

    private static void b(Activity activity, int i) {
        Intent intent = new Intent(activity, BridgeActivity.class);
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, o.class.getName());
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_EX_NAME, q.class.getName());
        a(o.class);
        activity.startActivityForResult(intent, i);
    }

    private static void c(Activity activity, int i) {
        Intent intent = new Intent(activity, BridgeActivity.class);
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, q.class.getName());
        a(q.class);
        activity.startActivityForResult(intent, i);
    }

    private static boolean a(Context context) {
        return ((long) new e(context).b("com.huawei.appmarket")) >= 70203000 ? true : null;
    }

    public static int a() {
        return a;
    }

    public static void a(Activity activity) {
        a = new e(activity).b(HuaweiApiAvailability.SERVICES_PACKAGE);
    }

    public static void a(Class<?> cls) {
        b = cls;
    }
}
