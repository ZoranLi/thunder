package com.qihoo360.replugin;

import android.content.Context;

public class RePluginEventCallbacks {
    protected final Context a;

    public enum InstallResult {
        SUCCEED,
        V5_FILE_BUILD_FAIL,
        V5_FILE_UPDATE_FAIL,
        READ_PKG_INFO_FAIL,
        VERIFY_SIGN_FAIL,
        VERIFY_VER_FAIL,
        COPY_APK_FAIL
    }

    public RePluginEventCallbacks(Context context) {
        this.a = context;
    }
}
