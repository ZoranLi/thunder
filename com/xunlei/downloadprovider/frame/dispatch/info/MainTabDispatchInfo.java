package com.xunlei.downloadprovider.frame.dispatch.info;

import java.io.Serializable;

public class MainTabDispatchInfo implements Serializable {
    private String mFrom;
    private int mTo;

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public int getTo() {
        return this.mTo;
    }

    public void setTo(int i) {
        this.mTo = i;
    }
}
