package com.xunlei.downloadprovider.member.payment.bean;

public interface IPayMeal {
    public static final int type_activity = 1;
    public static final int type_normal = 2;

    int getLocateMonth();

    int getRealPayMonth();

    float getRealPayPrice();

    float getSaveAmount();

    int getType();

    void setIsTotalPriceMode(boolean z);
}
