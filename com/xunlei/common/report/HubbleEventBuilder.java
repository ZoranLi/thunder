package com.xunlei.common.report;

public class HubbleEventBuilder {
    public static final String KEY_ATTRIBUTE1 = "attribute1";
    static final String KEY_SHOULEI_PUB_APILV = "shoulei_pub_apilv";
    static final String KEY_SHOULEI_PUB_DEVICEID = "shoulei_pub_deviceid";
    static final String KEY_SHOULEI_PUB_LOCATION = "shoulei_pub_location";
    static final String KEY_SHOULEI_USER_ID = "shoulei_pub_userid";

    public static StatEvent build(String str) {
        return StatEvent.build(str);
    }

    public static StatEvent build(String str, String str2) {
        str = StatEvent.build(str);
        str.setReserve1(str2);
        String str3 = KEY_ATTRIBUTE1;
        if (str2 == null) {
            str2 = "";
        }
        str.addString(str3, str2);
        return str;
    }
}
