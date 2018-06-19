package com.xunlei.common.commonview;

import android.content.Context;

public class XLToast {
    private static final NetworkToastManager sNetworkToastManager = new NetworkToastManager(null);

    public static void showToast(Context context, String str) {
        showToast(context, str, 0, 0);
    }

    public static void showToast(Context context, String str, int i) {
        showToast(context, str, i, 0);
    }

    public static void showToast(Context context, String str, int i, int i2) {
        Impl.showToastImpl(context, ToastType.TOAST_TYPE_NONE, str, i, 80, i2);
    }

    public static void showToastWithDuration(Context context, String str, int i) {
        showToast(context, str, 0, i);
    }

    public static void showLongToast(Context context, String str) {
        showToast(context, str, 0, 1);
    }

    public static void showNoNetworkToast(Context context) {
        if (!sNetworkToastManager.isNoNetworkToastForbidden()) {
            showToast(context, "无网络连接");
        }
    }

    public static void cancelAllToast() {
        Impl.cancelAllToast();
    }

    public static void setNoNetworkToastForbidden(boolean z) {
        sNetworkToastManager.setNoNetworkToastForbidden(z);
    }
}
