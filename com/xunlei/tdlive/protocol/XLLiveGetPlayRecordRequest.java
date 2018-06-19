package com.xunlei.tdlive.protocol;

public class XLLiveGetPlayRecordRequest extends XLLiveRequest {
    protected String onGetURL() {
        return "http://biz.live.xunlei.com/caller?c=ViewingHistory&a=getList";
    }

    protected boolean useHttpPost() {
        return true;
    }
}
