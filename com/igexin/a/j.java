package com.igexin.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareConstants;

final class j implements e {
    j() {
    }

    public final void a(String str) {
        System.loadLibrary(str);
    }

    public final String[] a() {
        if (VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            return Build.SUPPORTED_ABIS;
        }
        return new String[]{Build.CPU_ABI};
    }

    public final void b(String str) {
        System.load(str);
    }

    public final String c(String str) {
        return (str.startsWith(ShareConstants.SO_PATH) && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    public final String d(String str) {
        return str.substring(3, str.length() - 3);
    }
}
