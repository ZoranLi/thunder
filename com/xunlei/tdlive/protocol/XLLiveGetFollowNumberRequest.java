package com.xunlei.tdlive.protocol;

import com.xunlei.tdlive.protocol.XLLiveRequest.XLLiveRespBase;

public class XLLiveGetFollowNumberRequest extends XLLiveRequest {
    private String mUid;

    public XLLiveGetFollowNumberRequest(String str) {
        this.mUid = str;
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://biz.live.xunlei.com/caller?c=player&a=getfollownum&userid=");
        stringBuilder.append(this.mUid);
        return stringBuilder.toString();
    }

    protected Class<?> onGetObjectClass() {
        return XLLiveRespBase.class;
    }
}
