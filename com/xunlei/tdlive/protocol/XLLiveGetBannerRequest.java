package com.xunlei.tdlive.protocol;

import com.xunlei.tdlive.protocol.XLLiveRequest.XLLiveRespBase;

public class XLLiveGetBannerRequest extends XLLiveRequest {

    public static final class GetBannerResp extends XLLiveRespBase {
        public Data data;

        public static class Data {
        }
    }

    protected String onGetURL() {
        return "http://list.live.xunlei.com/get?type=appbanner";
    }

    protected Class<?> onGetObjectClass() {
        return GetBannerResp.class;
    }
}
