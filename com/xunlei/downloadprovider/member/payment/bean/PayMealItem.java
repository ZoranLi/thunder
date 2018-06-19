package com.xunlei.downloadprovider.member.payment.bean;

import com.xunlei.downloadprovider.member.payment.external.PayUtil;

public class PayMealItem implements IPayMeal {
    public boolean isTotalPriceMode;
    public int month;
    public float monthUnitPrice;
    public float totalMoney;

    public int getType() {
        return 2;
    }

    public int getRealPayMonth() {
        return this.month;
    }

    public float getRealPayPrice() {
        return this.totalMoney;
    }

    public float getSaveAmount() {
        return PayUtil.a(this.month, this.monthUnitPrice, this.totalMoney);
    }

    public int getLocateMonth() {
        return this.month;
    }

    public void setIsTotalPriceMode(boolean z) {
        this.isTotalPriceMode = z;
    }
}
