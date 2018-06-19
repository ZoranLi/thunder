package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;

public abstract class HuaweiApiAvailability {
    public static final String ACTIVITY_NAME = "com.huawei.hms.core.activity.JumpActivity";
    public static final int HMS_SDK_VERSION_CODE = 20502300;
    public static final String SERVICES_ACTION = "com.huawei.hms.core.aidlservice";
    public static final String SERVICES_PACKAGE = "com.huawei.hwid";
    public static final String SERVICES_SIGNATURE = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    public static final int SERVICES_VERSION_CODE = 20502300;

    public abstract int isHuaweiMobileServicesAvailable(Context context);

    public abstract boolean isUserResolvableError(int i);

    public abstract void resolveError(Activity activity, int i, int i2);

    public static HuaweiApiAvailability getInstance() {
        return a.a();
    }
}
