package com.xunlei.tdlive.protocol;

public class XLLiveInquireCheckInRequest extends XLLiveRequest {
    protected String onGetURL() {
        return "http://active.live.xunlei.com/caller?c=task&a=getsignininfonew";
    }
}
