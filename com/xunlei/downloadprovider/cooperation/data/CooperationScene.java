package com.xunlei.downloadprovider.cooperation.data;

import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.cooperation.l;
import java.io.Serializable;

public class CooperationScene implements Serializable {
    private static final long serialVersionUID = 0;
    private String mAttachment;
    private String mContent;
    private String mDescription;
    private String mLeftDescription;
    private int mLocation = -1;
    private String mRightDescription;
    private String mThirdDescription;
    private String mTitle;

    public CooperationScene(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.mTitle = str2;
        this.mThirdDescription = str3;
        this.mRightDescription = str4;
        this.mLeftDescription = str5;
        this.mDescription = str6;
        this.mContent = str7;
        this.mLocation = i;
        this.mAttachment = str;
    }

    public int getLocation() {
        return this.mLocation;
    }

    public void setLocation(int i) {
        this.mLocation = i;
    }

    public String getDisplayLocationName() {
        return l.c(getLocation());
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getThirdDescription() {
        return this.mThirdDescription;
    }

    public void setThirdDescription(String str) {
        this.mThirdDescription = str;
    }

    public String getRightDescription() {
        return this.mRightDescription;
    }

    public void setRightDescription(String str) {
        this.mRightDescription = str;
    }

    public String getLeftDescription() {
        return this.mLeftDescription;
    }

    public void setLeftDescription(String str) {
        this.mLeftDescription = str;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public String getAttachment() {
        return this.mAttachment;
    }

    public void setAttachment(String str) {
        this.mAttachment = str;
    }

    private Object parseAttachment(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            obj = ((String) obj).split(Constants.COLON_SEPARATOR, 2);
            if (obj.length == 0) {
                return null;
            }
            if (obj[0].toLowerCase().equals("int")) {
                return Integer.valueOf(Integer.parseInt(obj[1]));
            }
            if (obj[0].toLowerCase().equals("boolean") != null) {
                return Boolean.valueOf(Boolean.parseBoolean("ss[1]"));
            }
            return null;
        } catch (Object obj2) {
            obj2.printStackTrace();
        }
    }

    public CooperationScene clone() {
        return new CooperationScene(this.mLocation, this.mAttachment, this.mTitle, this.mThirdDescription, this.mRightDescription, this.mLeftDescription, this.mDescription, this.mContent);
    }
}
