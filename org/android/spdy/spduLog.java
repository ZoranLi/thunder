package org.android.spdy;

import com.xunlei.common.new_ptl.pay.XLPayErrorCode;

public class spduLog {
    private static long savedTraffic;

    public static void Logd(String str, String str2) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            str = new StringBuilder();
            str.append(Thread.currentThread().getId());
            str.append(" - ");
            str.append(str2);
        }
    }

    public static void Logd(String str, String str2, long j) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            str = new StringBuilder();
            str.append(Thread.currentThread().getId());
            str.append(" - ");
            str.append(str2);
            str.append((System.nanoTime() - j) / XLPayErrorCode.XLP_NET_GATE_ERROR_BASE);
        }
    }

    public static void Loge(String str, String str2) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            str = new StringBuilder();
            str.append(Thread.currentThread().getId());
            str.append(" - ");
            str.append(str2);
        }
    }

    public static void Logi(String str, String str2) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            str = new StringBuilder();
            str.append(Thread.currentThread().getId());
            str.append(" - ");
            str.append(str2);
        }
    }

    public static void Logv(String str, String str2) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            str = new StringBuilder();
            str.append(Thread.currentThread().getId());
            str.append(" - ");
            str.append(str2);
        }
    }

    public static void Logw(String str, String str2) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            str = new StringBuilder();
            str.append(Thread.currentThread().getId());
            str.append(" - ");
            str.append(str2);
        }
    }

    public static void Logf(String str, String str2) {
        if (str != null && str2 != null) {
            str = new StringBuilder();
            str.append(Thread.currentThread().getId());
            str.append(" - ");
            str.append(str2);
        }
    }

    public static void addTraffic(long j) {
        savedTraffic += j;
    }

    public static long getSavedTraffic() {
        return savedTraffic;
    }

    public static long now() {
        return SpdyAgent.enableDebug ? System.nanoTime() : 0;
    }
}
