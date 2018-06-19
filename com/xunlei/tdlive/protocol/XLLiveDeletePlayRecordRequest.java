package com.xunlei.tdlive.protocol;

import com.xiaomi.mipush.sdk.Constants;

public class XLLiveDeletePlayRecordRequest extends XLLiveRequest {
    private String mRoomIds = "";

    protected boolean useHttpPost() {
        return true;
    }

    public XLLiveDeletePlayRecordRequest(String... strArr) {
        if (strArr != null) {
            StringBuffer stringBuffer = new StringBuffer("");
            for (String append : strArr) {
                stringBuffer.append(append);
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.mRoomIds = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://biz.live.xunlei.com/caller?c=ViewingHistory&a=multiDel&roomids=");
        stringBuilder.append(this.mRoomIds);
        return stringBuilder.toString();
    }
}
