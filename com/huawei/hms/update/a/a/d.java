package com.huawei.hms.update.a.a;

import com.alibaba.wireless.security.SecExceptionCode;

/* compiled from: UpdateStatus */
public final class d {
    public static String a(int i) {
        if (i == 1000) {
            return "CHECK_OK";
        }
        if (i == SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_PARAM) {
            return "CHECK_CANCELED";
        }
        if (i == 2000) {
            return "DOWNLOAD_SUCCESS";
        }
        switch (i) {
            case 1201:
                return "CHECK_FAILURE";
            case 1202:
                return "CHECK_NO_UPDATE";
            case 1203:
                return "CHECK_NO_SUPPORTED";
            default:
                switch (i) {
                    case 2100:
                        return "DOWNLOADING";
                    case 2101:
                        return "DOWNLOAD_CANCELED";
                    default:
                        switch (i) {
                            case 2201:
                                return "DOWNLOAD_FAILURE";
                            case 2202:
                                return "DOWNLOAD_HASH_ERROR";
                            case 2203:
                                return "DOWNLOAD_NO_SPACE";
                            case 2204:
                                return "DOWNLOAD_NO_STORAGE";
                            default:
                                StringBuilder stringBuilder = new StringBuilder("UNKNOWN - ");
                                stringBuilder.append(Integer.toString(i));
                                return stringBuilder.toString();
                        }
                }
        }
    }
}
