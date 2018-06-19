package com.huawei.hms.support.api.client;

public class SubAppInfo {
    private String a;

    public SubAppInfo(SubAppInfo subAppInfo) {
        if (subAppInfo != null) {
            this.a = subAppInfo.getSubAppID();
        }
    }

    public SubAppInfo(String str) {
        this.a = str;
    }

    public String getSubAppID() {
        return this.a;
    }

    public void setSubAppID(String str) {
        this.a = str;
    }
}
