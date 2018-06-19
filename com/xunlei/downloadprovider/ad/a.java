package com.xunlei.downloadprovider.ad;

import android.app.Application;
import com.xunlei.common.XLCommonModule;

/* compiled from: ADContextHolder */
public final class a {
    public static Application a;

    public static Application a() {
        if (a == null) {
            a = XLCommonModule.getInstance().getApplication();
        }
        return a;
    }
}
