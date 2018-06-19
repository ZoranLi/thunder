package com.xunlei.downloadprovider.publiser.visitors.model;

import com.xunlei.downloadprovider.member.login.XLSexType;

public enum Gender {
    MALE,
    FEMALE,
    UNKNOWN;

    public static Gender parse(XLSexType xLSexType) {
        switch (a.a[xLSexType.ordinal()]) {
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            default:
                return UNKNOWN;
        }
    }
}
