package com.xunlei.tdlive.protocol;

public class XLLivePushTagRequest extends XLLiveRequest {
    public static final String T_ADD = "add";
    public static final String T_REMOVE = "remove";
    private final String mPeerId;
    private final String mType;

    public XLLivePushTagRequest(String str, String str2) {
        this.mType = str;
        this.mPeerId = str2;
    }

    protected String onGetURL() {
        StringBuilder stringBuilder = new StringBuilder("http://biz.live.xunlei.com/caller?c=news&a=tagwithuserid&type=");
        stringBuilder.append(this.mType);
        stringBuilder.append("&peerid=");
        stringBuilder.append(this.mPeerId);
        return stringBuilder.toString();
    }
}
