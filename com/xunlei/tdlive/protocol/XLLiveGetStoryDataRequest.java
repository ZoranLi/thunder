package com.xunlei.tdlive.protocol;

public class XLLiveGetStoryDataRequest extends XLLiveRequest {
    long mPage;

    public XLLiveGetStoryDataRequest(long j) {
        this.mPage = j;
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://rank.live.xunlei.com/v1/room/story?page=");
        stringBuilder.append(this.mPage);
        return stringBuilder.toString();
    }
}
