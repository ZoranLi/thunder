package com.xunlei.common.androidutil;

public class HandlerUtil {
    private static int mId = 16777216;

    public static final int generateId() {
        int i = mId + 1;
        mId = i;
        return i;
    }
}
