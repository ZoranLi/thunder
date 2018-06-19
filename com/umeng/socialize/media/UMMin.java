package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject.MediaType;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

public class UMMin extends BaseMediaObject {
    private String f;
    private String g;

    public MediaType getMediaType() {
        return MediaType.WEBPAGE;
    }

    public Map<String, Object> toUrlExtraParams() {
        Map<String, Object> hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.b);
        }
        return hashMap;
    }

    public UMMin(String str) {
        super(str);
    }

    public void setUserName(String str) {
        this.f = str;
    }

    public String getUserName() {
        return this.f;
    }

    public void setPath(String str) {
        this.g = str;
    }

    public String getPath() {
        return this.g;
    }

    public byte[] toByte() {
        return this.e != null ? this.e.toByte() : null;
    }
}
