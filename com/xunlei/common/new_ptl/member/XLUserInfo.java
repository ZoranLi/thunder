package com.xunlei.common.new_ptl.member;

public interface XLUserInfo {

    public enum USERINFOKEY {
        VasId,
        UserName,
        UserID,
        UserNewNo,
        IsSubAccount,
        NickName,
        Account,
        SessionID,
        IsVip,
        Rank,
        Order,
        ExpireDate,
        VasType,
        PayId,
        PayName,
        isExpVip,
        Country,
        Province,
        City,
        IsSpecialNum,
        Role,
        IsAutoDeduct,
        IsRemind,
        TodayScore,
        AllowScore,
        PersonalSign,
        VipGrow,
        VipDayGrow,
        ImgURL,
        vip_level,
        IsYear,
        Rigster,
        Sex,
        Birthday,
        PhoneNumber,
        VipList
    }

    void clearUserData();

    void dump();

    String getAvatarUrl(int i);

    int getIntValue(USERINFOKEY userinfokey);

    int getIntValue(USERINFOKEY userinfokey, int i);

    String getJumpKey(int i);

    long getLongValue(USERINFOKEY userinfokey);

    long getLongValue(USERINFOKEY userinfokey, int i);

    String getStringValue(USERINFOKEY userinfokey);

    String getStringValue(USERINFOKEY userinfokey, int i);
}
