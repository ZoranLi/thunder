package com.xunlei.tdlive.protocol;

public class XLLiveExposureReportedRequest extends XLLiveRequest {
    private String mLiveCardIds;

    public XLLiveExposureReportedRequest(String str) {
        this.mLiveCardIds = str;
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://sdkstat.live.xunlei.com/stat?sdk_ids=");
        stringBuilder.append(this.mLiveCardIds);
        return stringBuilder.toString();
    }
}
