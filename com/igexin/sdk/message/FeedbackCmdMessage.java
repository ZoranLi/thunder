package com.igexin.sdk.message;

public class FeedbackCmdMessage extends GTCmdMessage {
    private String a;
    private String b;
    private String c;
    private long d;

    public FeedbackCmdMessage(String str, String str2, String str3, long j, int i) {
        super(i);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
    }

    public String getActionId() {
        return this.b;
    }

    public String getResult() {
        return this.c;
    }

    public String getTaskId() {
        return this.a;
    }

    public long getTimeStamp() {
        return this.d;
    }

    public void setActionId(String str) {
        this.b = str;
    }

    public void setResult(String str) {
        this.c = str;
    }

    public void setTaskId(String str) {
        this.a = str;
    }

    public void setTimeStamp(long j) {
        this.d = j;
    }
}
