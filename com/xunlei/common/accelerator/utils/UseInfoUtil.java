package com.xunlei.common.accelerator.utils;

import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;

public class UseInfoUtil {
    public static boolean isKnVip(XLUserInfo xLUserInfo) {
        if (xLUserInfo != null) {
            int intValue = xLUserInfo.getIntValue(USERINFOKEY.VasType, 14);
            xLUserInfo = xLUserInfo.getIntValue(USERINFOKEY.VasType);
            if ((intValue == 2 || intValue == 3) && xLUserInfo != 4) {
                return true;
            }
        }
        return null;
    }
}
