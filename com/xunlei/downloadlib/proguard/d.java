package com.xunlei.downloadlib.proguard;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xunlei.downloadprovider.pushmessage.e;

/* compiled from: XLLog */
public enum d {
    LOG_LEVEL_VERBOSE(2),
    LOG_LEVEL_DEBUG(3),
    LOG_LEVEL_INFO(4),
    LOG_LEVEL_WARN(5),
    LOG_LEVEL_ERROR(6);
    
    private final int f;

    private d(int i) {
        this.f = i;
    }

    static d a(String str) {
        if (!str.equals(e.a)) {
            if (!str.equals("error")) {
                if (!str.equals(IXAdRequestInfo.WIDTH)) {
                    if (!str.equals("warn")) {
                        if (!str.equals("i")) {
                            if (!str.equals("info")) {
                                if (!str.equals(com.xunlei.downloadprovider.ad.downloadlist.d.a)) {
                                    if (str.equals("debug") == null) {
                                        return LOG_LEVEL_VERBOSE;
                                    }
                                }
                                return LOG_LEVEL_DEBUG;
                            }
                        }
                        return LOG_LEVEL_INFO;
                    }
                }
                return LOG_LEVEL_WARN;
            }
        }
        return LOG_LEVEL_ERROR;
    }

    public final int a() {
        return this.f;
    }

    public final String toString() {
        return a(true);
    }

    public final String a(boolean z) {
        switch (this) {
            case LOG_LEVEL_DEBUG:
                return z ? "D" : "DEBUG";
            case LOG_LEVEL_INFO:
                return z ? "I" : "INFO";
            case LOG_LEVEL_WARN:
                return z ? "W" : "WARN";
            case LOG_LEVEL_ERROR:
                return z ? "E" : "ERROR";
            default:
                return z ? "V" : "VERBOSE";
        }
    }
}
