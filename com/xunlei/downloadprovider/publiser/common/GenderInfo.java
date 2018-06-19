package com.xunlei.downloadprovider.publiser.common;

import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;

public enum GenderInfo {
    NONE(0),
    MALE(1),
    FEMALE(2);
    
    int mType;

    public final int getType() {
        return this.mType;
    }

    public final String getTypeStr() {
        if (this.mType == 0) {
            return "u";
        }
        return this.mType == 1 ? "m" : f.a;
    }

    private GenderInfo(int i) {
        this.mType = i;
    }

    public static GenderInfo castStringToGenderInfo(String str) {
        if (!"m".equals(str)) {
            if (!IChatUser.GENDER_MALE.equals(str)) {
                if (!f.a.equals(str)) {
                    if (IChatUser.GENDER_FEMALE.equals(str) == null) {
                        return NONE;
                    }
                }
                return FEMALE;
            }
        }
        return MALE;
    }

    public static int castStringToGender1(String str) {
        if ("m".equals(str)) {
            return 1;
        }
        return f.a.equals(str) != null ? 2 : null;
    }

    public static int castStringToGender(String str) {
        if (IChatUser.GENDER_FEMALE.equals(str)) {
            return 2;
        }
        return IChatUser.GENDER_MALE.equals(str) != null ? 1 : null;
    }
}
