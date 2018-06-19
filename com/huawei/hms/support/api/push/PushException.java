package com.huawei.hms.support.api.push;

public class PushException extends RuntimeException {
    public static final String EXCEPITON_DEL_TAGS_FAILED = "delete tags failed";
    public static final String EXCEPITON_DEL_TAGS_LIST_NULL = "the key list of delete tags is null";
    public static final String EXCEPITON_DEL_TOKEN_FAILED = "delete token failed";
    public static final String EXCEPITON_GET_TAGS_FAILED = "get tags failed";
    public static final String EXCEPITON_NO_TAG_NEED_DEL = "no tag need to delete";
    public static final String EXCEPITON_SET_TAGS_FAILED = "set tags failed";
    public static final String EXCEPITON_TAGS_NULL = "tags is null";
    public static final String EXCEPITON_TOKEN_INVALID = "push token invalid";

    public PushException(String str, Throwable th) {
        super(str, th);
    }

    public PushException(String str) {
        super(str);
    }

    public PushException(Throwable th) {
        super(th);
    }
}
