package com.taobao.accs.base;

/* compiled from: Taobao */
public enum TaoBaseService$ExtHeaderType {
    TYPE_BUSINESS,
    TYPE_SID,
    TYPE_USERID,
    TYPE_COOKIE,
    TYPE_TAG,
    TYPE_STATUS,
    TYPE_DELAY,
    TYPE_EXPIRE,
    TYPE_LOCATION,
    TYPE_UNIT,
    TYPE_NEED_BUSINESS_ACK;

    public static TaoBaseService$ExtHeaderType valueOf(int i) {
        switch (i) {
            case 0:
                return TYPE_BUSINESS;
            case 1:
                return TYPE_SID;
            case 2:
                return TYPE_USERID;
            case 3:
                return TYPE_COOKIE;
            case 4:
                return TYPE_TAG;
            case 5:
                return TYPE_STATUS;
            case 6:
                return TYPE_DELAY;
            case 7:
                return TYPE_EXPIRE;
            case 8:
                return TYPE_LOCATION;
            case 9:
                return TYPE_UNIT;
            case 10:
                return TYPE_NEED_BUSINESS_ACK;
            default:
                return 0;
        }
    }
}
