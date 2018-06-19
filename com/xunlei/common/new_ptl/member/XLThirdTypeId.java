package com.xunlei.common.new_ptl.member;

public class XLThirdTypeId {
    public static final int XL_TT_ALI = 4;
    public static final int XL_TT_QQ = 15;
    public static final int XL_TT_SINA = 1;
    public static final int XL_TT_WX = 21;
    public static final int XL_TT_XM = 8;

    public static final String getXLThirdTypeName(int i) {
        return 21 == i ? "weixin" : 1 == i ? "weibo" : 15 == i ? "qq" : 4 == i ? "zfb" : 8 == i ? "xm" : "unknown";
    }
}
