package com.umeng.message.proguard;

import android.content.Context;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

/* compiled from: SizeFactory */
public class j {
    private static float a = 1.0f;

    private static void a(Context context) {
        a = context.getResources().getDisplayMetrics().density;
    }

    public static int a(Context context, float f) {
        a(context);
        return (int) ((f * a) + PayBaseConstants.HALF_OF_FLOAT);
    }

    public static int b(Context context, float f) {
        a(context);
        return (int) ((f / a) + PayBaseConstants.HALF_OF_FLOAT);
    }

    public static int c(Context context, float f) {
        a(context);
        return (int) ((f * a) + PayBaseConstants.HALF_OF_FLOAT);
    }

    public static int d(Context context, float f) {
        a(context);
        return (int) ((f / a) + PayBaseConstants.HALF_OF_FLOAT);
    }
}
