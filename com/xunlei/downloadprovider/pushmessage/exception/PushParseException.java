package com.xunlei.downloadprovider.pushmessage.exception;

public class PushParseException extends Exception {
    private static final String TAG = "push.PushParseException";
    private String errorMsg = "";

    public PushParseException(String str) {
        this.errorMsg = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void printStackTrace() {
        new StringBuilder("errorMsg: ").append(getErrorMsg());
        super.printStackTrace();
    }
}
