package com.igexin.sdk.message;

public class GTCmdMessage extends BaseMessage {
    private int a;

    public GTCmdMessage(int i) {
        this.a = i;
    }

    public int getAction() {
        return this.a;
    }

    public void setAction(int i) {
        this.a = i;
    }
}
