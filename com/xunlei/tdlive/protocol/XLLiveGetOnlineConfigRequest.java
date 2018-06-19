package com.xunlei.tdlive.protocol;

import com.xunlei.tdlive.protocol.XLLiveRequest.XLLiveRespBase;

public class XLLiveGetOnlineConfigRequest extends XLLiveRequest {

    public static class GetOnlineConfigResp extends XLLiveRespBase {
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://list.live.xunlei.com/get?type=appconf&_t=");
        stringBuilder.append(System.currentTimeMillis());
        return stringBuilder.toString();
    }

    protected Class<?> onGetObjectClass() {
        return GetOnlineConfigResp.class;
    }
}
