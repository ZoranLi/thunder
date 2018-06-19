package com.xunlei.tdlive.protocol;

public class XLLiveGetPKIndexList extends XLLiveRequest {
    private int mCount;
    private int mStart;

    public XLLiveGetPKIndexList(int i, int i2) {
        this.mStart = i;
        this.mCount = i2;
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://biz.live.xunlei.com/caller?c=newvoicecallpk&a=getindexpklist&start=");
        stringBuilder.append(this.mStart);
        stringBuilder.append("&count=");
        stringBuilder.append(this.mCount);
        return stringBuilder.toString();
    }
}
