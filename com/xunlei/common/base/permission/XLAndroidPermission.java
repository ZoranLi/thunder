package com.xunlei.common.base.permission;

import android.content.Context;

public class XLAndroidPermission {
    private static XLAndroidPermission mInstance;
    private XLAndroidPermissionManager mAcpManager;

    public static XLAndroidPermission getInstance(Context context) {
        if (mInstance == null) {
            synchronized (XLAndroidPermission.class) {
                if (mInstance == null) {
                    mInstance = new XLAndroidPermission(context);
                }
            }
        }
        return mInstance;
    }

    private XLAndroidPermission(Context context) {
        this.mAcpManager = new XLAndroidPermissionManager(context.getApplicationContext());
    }

    public void request(XLAndroidPermissionOptions xLAndroidPermissionOptions, XLAndroidPermissionListener xLAndroidPermissionListener) {
        if (xLAndroidPermissionOptions == null) {
            NullPointerException nullPointerException = new NullPointerException("AcpOptions is null...");
        }
        if (xLAndroidPermissionListener == null) {
            nullPointerException = new NullPointerException("AcpListener is null...");
        }
        this.mAcpManager.request(xLAndroidPermissionOptions, xLAndroidPermissionListener);
    }

    XLAndroidPermissionManager getAcpManager() {
        return this.mAcpManager;
    }
}
