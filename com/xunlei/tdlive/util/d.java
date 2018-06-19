package com.xunlei.tdlive.util;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

/* compiled from: DipAndPix */
public class d {
    public static float a(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + PayBaseConstants.HALF_OF_FLOAT;
    }

    public static Point a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point(0, 0);
        windowManager.getDefaultDisplay().getSize(point);
        return point;
    }
}
