package com.xunlei.tdlive.protocol;

import com.xunlei.tdlive.protocol.XLLiveRequest.XLLiveRespBase;

public class XLLiveRsyncAccountRequest extends XLLiveRequest {
    private int mType;

    public static class RsyncAccountResp extends XLLiveRespBase {
    }

    public XLLiveRsyncAccountRequest(int i) {
        this.mType = i;
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://biz.live.xunlei.com/caller?c=user&a=rsyncaccount&type=");
        stringBuilder.append(this.mType);
        return stringBuilder.toString();
    }

    protected Class<?> onGetObjectClass() {
        return RsyncAccountResp.class;
    }
}
