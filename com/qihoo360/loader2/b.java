package com.qihoo360.loader2;

import android.os.Build;
import android.os.Build.VERSION;

/* compiled from: BuildCompat */
public final class b {
    public static final String[] a;
    public static final String[] b;
    public static final String[] c;

    static {
        if (VERSION.SDK_INT < 21) {
            a = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } else if (Build.SUPPORTED_ABIS != null) {
            a = new String[Build.SUPPORTED_ABIS.length];
            System.arraycopy(Build.SUPPORTED_ABIS, 0, a, 0, a.length);
        } else {
            a = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        if (VERSION.SDK_INT < 21) {
            b = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } else if (Build.SUPPORTED_32_BIT_ABIS != null) {
            b = new String[Build.SUPPORTED_32_BIT_ABIS.length];
            System.arraycopy(Build.SUPPORTED_32_BIT_ABIS, 0, b, 0, b.length);
        } else {
            b = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        if (VERSION.SDK_INT < 21) {
            c = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } else if (Build.SUPPORTED_64_BIT_ABIS != null) {
            c = new String[Build.SUPPORTED_64_BIT_ABIS.length];
            System.arraycopy(Build.SUPPORTED_64_BIT_ABIS, 0, c, 0, c.length);
        } else {
            c = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
    }
}
