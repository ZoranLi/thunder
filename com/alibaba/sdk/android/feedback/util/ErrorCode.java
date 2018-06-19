package com.alibaba.sdk.android.feedback.util;

import com.alibaba.wireless.security.SecExceptionCode;

public enum ErrorCode {
    NULL_ERROR(1001, true),
    CONFIG_ERROR(1002, true),
    UNREAD_ERROR(1003, false),
    CAMERA_ERROR(1004, true),
    ALBUM_ERROR(1005, true),
    NETWORK_ERROR(1006, false),
    DATA_PARSE_ERROR(1007, false),
    CONTEXT_ERROR(1008, true),
    UNKNOWN_ERROR(SecExceptionCode.SEC_ERROR_OPENSDK, true);
    
    private int errorCode;
    private boolean isVisible;

    private ErrorCode(int i, boolean z) {
        this.errorCode = i;
        this.isVisible = z;
    }

    public static ErrorCode getErrorCode(int i) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.getCode() == i) {
                return errorCode;
            }
        }
        return null;
    }

    public final int getCode() {
        return this.errorCode;
    }

    public final boolean getVisible() {
        return this.isVisible;
    }
}
