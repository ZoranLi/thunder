package com.xunlei.tdlive.protocol;

public class XLLiveGetCategoryRequest extends XLLiveRequest {
    protected String onGetURL() {
        return "http://biz.live.xunlei.com/caller?c=contenttype&a=getTypes";
    }

    protected boolean useHttpPost() {
        return true;
    }
}
