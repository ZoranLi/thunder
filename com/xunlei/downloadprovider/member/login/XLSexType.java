package com.xunlei.downloadprovider.member.login;

import com.xunlei.downloadprovider.ad.home.a.f;

public enum XLSexType {
    UNKNOWN("u"),
    MALE("m"),
    FEMALE(f.a);
    
    private String mSex;

    private XLSexType(String str) {
        this.mSex = str;
    }

    public final String toString() {
        return this.mSex;
    }

    public static XLSexType getXLSexType(String str) {
        XLSexType xLSexType = UNKNOWN;
        int hashCode = str.hashCode();
        if (hashCode != 102) {
            if (hashCode != 109) {
                if (hashCode == 117) {
                    if (str.equals("u") != null) {
                        str = null;
                        switch (str) {
                            case null:
                                return UNKNOWN;
                            case 1:
                                return MALE;
                            case 2:
                                return FEMALE;
                            default:
                                return xLSexType;
                        }
                    }
                }
            } else if (str.equals("m") != null) {
                str = true;
                switch (str) {
                    case null:
                        return UNKNOWN;
                    case 1:
                        return MALE;
                    case 2:
                        return FEMALE;
                    default:
                        return xLSexType;
                }
            }
        } else if (str.equals(f.a) != null) {
            str = 2;
            switch (str) {
                case null:
                    return UNKNOWN;
                case 1:
                    return MALE;
                case 2:
                    return FEMALE;
                default:
                    return xLSexType;
            }
        }
        str = -1;
        switch (str) {
            case null:
                return UNKNOWN;
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            default:
                return xLSexType;
        }
    }
}
