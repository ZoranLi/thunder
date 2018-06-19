package com.xunlei.common.androidutil;

import android.annotation.SuppressLint;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class DipPixelUtil {
    @SuppressLint({"DefaultLocale"})
    public static int dip2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + PayBaseConstants.HALF_OF_FLOAT);
    }

    public static int sp2pix(float f) {
        return (int) ((f * getResources().getDisplayMetrics().scaledDensity) + PayBaseConstants.HALF_OF_FLOAT);
    }

    private static android.content.res.Resources getResources() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.common.XLCommonModule.getInstance();	 Catch:{ Throwable -> 0x000d }
        r0 = r0.getContext();	 Catch:{ Throwable -> 0x000d }
        r0 = r0.getResources();	 Catch:{ Throwable -> 0x000d }
        return r0;
    L_0x000d:
        r0 = android.content.res.Resources.getSystem();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.androidutil.DipPixelUtil.getResources():android.content.res.Resources");
    }
}
