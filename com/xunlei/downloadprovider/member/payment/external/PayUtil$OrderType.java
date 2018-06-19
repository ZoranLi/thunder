package com.xunlei.downloadprovider.member.payment.external;

public enum PayUtil$OrderType {
    OPEN,
    RENEW,
    UPGRADE;

    public final int toXLSdkOrderType() {
        return this == UPGRADE ? 1 : 0;
    }

    public final String getText() {
        String str = "";
        switch (k.a[ordinal()]) {
            case 1:
            case 2:
                return "开通";
            case 3:
                return "升级";
            default:
                return str;
        }
    }
}
