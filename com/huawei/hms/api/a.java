package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.internal.e;

/* compiled from: HuaweiApiAvailabilityImpl */
final class a extends HuaweiApiAvailability {
    private static final a a = new a();

    public final boolean isUserResolvableError(int i) {
        if (i != 6) {
            switch (i) {
                case 1:
                case 2:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private a() {
    }

    public static a a() {
        return a;
    }

    public final int isHuaweiMobileServicesAvailable(Context context) {
        com.huawei.hms.c.a.a(context, "context must not be null.");
        return e.a(context);
    }

    public final void resolveError(Activity activity, int i, int i2) {
        com.huawei.hms.c.a.a(activity, "activity must not be null.");
        com.huawei.hms.c.a.a("must be called on ui-thread.");
        StringBuilder stringBuilder = new StringBuilder("Enter resolveError, errorCode: ");
        stringBuilder.append(i);
        com.huawei.hms.support.log.a.b("HuaweiApiAvailabilityImpl", stringBuilder.toString());
        if (i != 6) {
            switch (i) {
                case 1:
                case 2:
                    com.huawei.hms.update.c.a.a(activity, i2);
                    return;
                default:
                    break;
            }
        }
        a(activity, com.huawei.hms.api.internal.a.class.getName(), i2);
    }

    private static void a(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, BridgeActivity.class);
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, str);
        activity.startActivityForResult(intent, i);
    }
}
