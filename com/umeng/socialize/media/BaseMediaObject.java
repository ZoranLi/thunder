package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseMediaObject implements UMediaObject {
    protected String a = "";
    protected String b = "";
    protected Map<String, Object> c = new HashMap();
    protected String d = "";
    protected UMImage e;
    public String mText = null;

    public void setThumb(UMImage uMImage) {
        this.e = uMImage;
    }

    public BaseMediaObject(String str) {
        this.a = str;
    }

    public String getDescription() {
        return this.d;
    }

    public Map<String, Object> getmExtra() {
        return this.c;
    }

    public void setmExtra(String str, Object obj) {
        this.c.put(str, obj);
    }

    public void setDescription(String str) {
        this.d = str;
    }

    public String toUrl() {
        return this.a;
    }

    public UMImage getThumbImage() {
        return this.e;
    }

    public boolean isUrlMedia() {
        return !TextUtils.isEmpty(this.a);
    }

    public String getTitle() {
        return this.b;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    protected BaseMediaObject(Parcel parcel) {
        if (parcel != null) {
            this.a = parcel.readString();
            this.b = parcel.readString();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BaseMediaObject [media_url=");
        stringBuilder.append(this.a);
        stringBuilder.append(", qzone_title=");
        stringBuilder.append(this.b);
        stringBuilder.append(", qzone_thumb=]");
        return stringBuilder.toString();
    }
}
