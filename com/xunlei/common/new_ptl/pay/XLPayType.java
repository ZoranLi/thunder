package com.xunlei.common.new_ptl.pay;

public final class XLPayType {
    public static final int XL_ALIPAY_CONTRACT = 268435462;
    public static final int XL_ALI_PAY = 268435458;
    public static final int XL_ALL_CONTRACT = 536870914;
    public static final int XL_APPLE_PAY = 268435461;
    public static final int XL_GET_PRICE = 536870913;
    public static final int XL_WX_CONTRACT = 268435463;
    public static final int XL_WX_PAY = 268435457;

    public static final String getPayTypeString(int i) {
        return i == XL_WX_PAY ? "W1" : i == XL_ALI_PAY ? "SP" : i == XL_APPLE_PAY ? "AP" : i == XL_ALIPAY_CONTRACT ? "AM" : i == XL_WX_CONTRACT ? "W5" : "SP";
    }

    public static final int getPayTypeInt(String str) {
        if ("W1".equals(str)) {
            return XL_WX_PAY;
        }
        if ("SP".equals(str)) {
            return XL_ALI_PAY;
        }
        if ("AP".equals(str)) {
            return XL_APPLE_PAY;
        }
        if ("AM".equals(str)) {
            return XL_ALIPAY_CONTRACT;
        }
        return "W5".equals(str) != null ? XL_WX_CONTRACT : null;
    }
}
