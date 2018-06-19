package com.xunlei.common.accelerator.bean;

import com.xunlei.common.accelerator.utils.UseInfoUtil;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;

public class XLAccelUser {
    public String mSessionID = "";
    public String mUserID = "0";
    public int mUserType = 2;
    public int mVipType = -1;

    public XLAccelUser(XLUserInfo xLUserInfo, int i, KnParams knParams) {
        try {
            this.mUserID = String.valueOf(Long.parseLong(xLUserInfo.getStringValue(USERINFOKEY.UserID)));
            int intValue = xLUserInfo.getIntValue(USERINFOKEY.VasType);
            int intValue2 = xLUserInfo.getIntValue(USERINFOKEY.IsVip);
            this.mSessionID = xLUserInfo.getStringValue(USERINFOKEY.SessionID);
            this.mVipType = intValue;
            if (i == 1 && !(intValue == 5 && intValue2 == 1)) {
                this.mVipType = 100;
            }
            if (isTryUser(intValue, intValue2, i, knParams) != 0) {
                this.mUserType = 2;
            } else {
                this.mUserType = 1;
            }
        } catch (XLUserInfo xLUserInfo2) {
            xLUserInfo2.printStackTrace();
        }
    }

    private boolean isTryUser(int i, int i2, int i3, KnParams knParams) {
        if (i == 5 && i2 == 1) {
            return false;
        }
        if (i3 != 1 || knParams == null) {
            if (i2 != 1) {
                this.mVipType = 0;
            }
        } else if (knParams.getOther_IsVip() == 1) {
            return false;
        } else {
            if (i2 != 1) {
                i = 0;
            }
            this.mVipType = i;
        }
        return true;
    }

    public boolean isTryUser() {
        return this.mUserType != 1;
    }

    public static XLAccelUser checkUser(int i, XLUserInfo xLUserInfo) {
        boolean z = false;
        if (i != 0 || xLUserInfo == null) {
            return new XLAccelUser(xLUserInfo, 0, null);
        }
        if (UseInfoUtil.isKnVip(xLUserInfo) == 0) {
            return new XLAccelUser(xLUserInfo, 0, null);
        }
        i = new KnParams();
        i.setOther_ExpireDate(xLUserInfo.getStringValue(USERINFOKEY.ExpireDate, 14));
        i.setOther_IsVip(xLUserInfo.getIntValue(USERINFOKEY.IsVip, 14));
        if (xLUserInfo.getIntValue(USERINFOKEY.IsYear, 14) == 1) {
            z = true;
        }
        i.setOther_IsYear(z);
        return new XLAccelUser(xLUserInfo, 1, i);
    }
}
