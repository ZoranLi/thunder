package com.xunlei.tdlive.protocol;

public class XLLiveReportPushResultRequest extends XLLiveRequest {
    private final boolean mClicked;
    private final String mPlayerId;

    public XLLiveReportPushResultRequest(String str, boolean z) {
        this.mPlayerId = str;
        this.mClicked = z;
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://biz.live.xunlei.com/caller?c=news&a=reportispushsuccess&playerid=");
        stringBuilder.append(this.mPlayerId);
        stringBuilder.append("&clicked=");
        stringBuilder.append(this.mClicked);
        return stringBuilder.toString();
    }
}
