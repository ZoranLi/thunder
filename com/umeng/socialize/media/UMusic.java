package com.umeng.socialize.media;

import android.os.Parcel;
import com.umeng.socialize.media.UMediaObject.MediaType;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

public class UMusic extends BaseMediaObject {
    private String f;
    private String g;
    private String h;
    private String i;
    private int j;
    private String k;

    public void setmTargetUrl(String str) {
        this.k = str;
    }

    public String getmTargetUrl() {
        return this.k;
    }

    public int getDuration() {
        return this.j;
    }

    public void setDuration(int i) {
        this.j = i;
    }

    public String getLowBandUrl() {
        return this.i;
    }

    public void setLowBandUrl(String str) {
        this.i = str;
    }

    public UMusic(String str) {
        super(str);
    }

    public String getHighBandDataUrl() {
        return this.g;
    }

    public void setHighBandDataUrl(String str) {
        this.g = str;
    }

    public String getH5Url() {
        return this.h;
    }

    public void setH5Url(String str) {
        this.h = str;
    }

    public MediaType getMediaType() {
        return MediaType.MUSIC;
    }

    protected UMusic(Parcel parcel) {
        super(parcel);
    }

    public final Map<String, Object> toUrlExtraParams() {
        Map<String, Object> hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.b);
        }
        return hashMap;
    }

    public byte[] toByte() {
        return this.e != null ? this.e.toByte() : null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UMusic [title=");
        stringBuilder.append(this.b);
        stringBuilder.append("media_url=");
        stringBuilder.append(this.a);
        stringBuilder.append(", qzone_title=");
        stringBuilder.append(this.b);
        stringBuilder.append(", qzone_thumb=]");
        return stringBuilder.toString();
    }

    public UMImage getThumbImage() {
        return this.e;
    }

    public String getLowBandDataUrl() {
        return this.f;
    }

    public void setLowBandDataUrl(String str) {
        this.f = str;
    }
}
