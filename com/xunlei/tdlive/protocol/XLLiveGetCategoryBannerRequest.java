package com.xunlei.tdlive.protocol;

public class XLLiveGetCategoryBannerRequest extends XLLiveRequest {
    private String mTypeID;

    public XLLiveGetCategoryBannerRequest(String str) {
        this.mTypeID = str;
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://biz.live.xunlei.com/caller?c=contenttype&a=getBanners&type_id=");
        stringBuilder.append(this.mTypeID);
        return stringBuilder.toString();
    }
}
