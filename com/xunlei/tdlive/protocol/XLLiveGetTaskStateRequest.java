package com.xunlei.tdlive.protocol;

public class XLLiveGetTaskStateRequest extends XLLiveRequest {
    protected String onGetURL() {
        return "http://active.live.xunlei.com/caller?c=task&a=getCompleteTaskNumNew";
    }
}
