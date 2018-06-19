package com.xunlei.common.device;

import android.content.Context;
import android.support.annotation.NonNull;
import com.xunlei.common.device.a.c;

public abstract class XLDeviceGen {
    private static final XLDeviceGen mInstance = new c();

    public abstract String getDeviceId();

    public abstract String getDeviceIdSign();

    public abstract String getDeviceIdWithFlag();

    public abstract void initialize(int i, @NonNull String str, @NonNull String str2, @NonNull Context context) throws XLDeviceExecption;

    public static XLDeviceGen getInstance() {
        return mInstance;
    }
}
