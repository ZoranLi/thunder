package com.baidu.mobads.utils;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;

public class t implements IXAdViewUtils {
    public boolean isAdViewOutsideScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect windowRect = XAdSDKFoundationFacade.getInstance().getCommonUtils().getWindowRect(view.getContext());
        int width = iArr[0] + (view.getWidth() / 2);
        int height = iArr[1] + (view.getHeight() / 2);
        if (width > 0 && width < windowRect.width() && height > 0) {
            if (height < windowRect.height()) {
                return false;
            }
        }
        return true;
    }

    public boolean isScreenOn(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return true;
        }
    }

    public boolean isAdViewTooSmall(View view) {
        return (view == null || (view.getWidth() >= 10 && view.getHeight() >= 10)) ? null : true;
    }

    public boolean isAdViewShown(View view) {
        return (view == null || view.isShown() == null) ? null : true;
    }

    public boolean isVisible(View view, int i) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                Rect rect = new Rect();
                if (!view.getGlobalVisibleRect(rect)) {
                    return false;
                }
                long height = ((long) rect.height()) * ((long) rect.width());
                long height2 = ((long) view.getHeight()) * ((long) view.getWidth());
                if (height2 > 0 && 100 * height >= ((long) i) * height2) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public int getVisiblePercent(android.view.View r6, android.content.Context r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x0041;
    L_0x0003:
        r1 = r6.isShown();	 Catch:{ Exception -> 0x0040 }
        if (r1 == 0) goto L_0x0041;	 Catch:{ Exception -> 0x0040 }
    L_0x0009:
        r7 = r7.getResources();	 Catch:{ Exception -> 0x0040 }
        r7 = r7.getDisplayMetrics();	 Catch:{ Exception -> 0x0040 }
        r1 = r7.heightPixels;	 Catch:{ Exception -> 0x0040 }
        r7 = r7.widthPixels;	 Catch:{ Exception -> 0x0040 }
        r2 = new android.graphics.Rect;	 Catch:{ Exception -> 0x0040 }
        r2.<init>();	 Catch:{ Exception -> 0x0040 }
        r6.getGlobalVisibleRect(r2);	 Catch:{ Exception -> 0x0040 }
        r3 = r2.top;	 Catch:{ Exception -> 0x0040 }
        if (r3 > r1) goto L_0x003f;	 Catch:{ Exception -> 0x0040 }
    L_0x0021:
        r1 = r2.left;	 Catch:{ Exception -> 0x0040 }
        if (r1 > r7) goto L_0x003f;	 Catch:{ Exception -> 0x0040 }
    L_0x0025:
        r7 = r2.width();	 Catch:{ Exception -> 0x0040 }
        r1 = r2.height();	 Catch:{ Exception -> 0x0040 }
        r7 = r7 * r1;	 Catch:{ Exception -> 0x0040 }
        r1 = (double) r7;	 Catch:{ Exception -> 0x0040 }
        r7 = r6.getWidth();	 Catch:{ Exception -> 0x0040 }
        r6 = r6.getHeight();	 Catch:{ Exception -> 0x0040 }
        r7 = r7 * r6;
        r6 = (double) r7;
        r3 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r3 = r3 * r1;
        r3 = r3 / r6;
        r6 = (int) r3;
        return r6;
    L_0x003f:
        return r0;
    L_0x0040:
        return r0;
    L_0x0041:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.t.getVisiblePercent(android.view.View, android.content.Context):int");
    }

    public int getViewState(View view) {
        if (!isScreenOn(view.getContext())) {
            return 4;
        }
        if (!isAdViewShown(view)) {
            return 1;
        }
        if (a(view)) {
            return isVisible(view, 50) == null ? 3 : null;
        } else {
            return 6;
        }
    }

    private boolean a(View view) {
        return (view.getWidth() <= 15 || view.getHeight() <= 15) ? null : true;
    }
}
