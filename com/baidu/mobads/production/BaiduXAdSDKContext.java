package com.baidu.mobads.production;

import com.baidu.mobads.g.g;

public class BaiduXAdSDKContext {
    protected static Boolean isRemoteLoadSuccess = Boolean.valueOf(false);
    public static g mApkLoader;

    public static void exit() {
        mApkLoader = null;
        isRemoteLoadSuccess = Boolean.valueOf(false);
    }
}
