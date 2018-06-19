package com.xunlei.downloadprovider.plugin.videoplayervod.report;

import java.io.Serializable;

public class VodReportInfo implements Serializable {
    private static final long serialVersionUID = 0;
    public String mPlayFrom = "old_detail_other";
    public String mPlayType = "native";

    public VodReportInfo(String str, String str2) {
        this.mPlayFrom = str;
        this.mPlayType = str2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("VodReportInfo{mPlayType='");
        stringBuilder.append(this.mPlayType);
        stringBuilder.append('\'');
        stringBuilder.append(", mPlayFrom='");
        stringBuilder.append(this.mPlayFrom);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
