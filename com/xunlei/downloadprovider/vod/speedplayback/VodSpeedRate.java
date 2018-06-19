package com.xunlei.downloadprovider.vod.speedplayback;

import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public enum VodSpeedRate {
    RATE_0_POINT_5(PayBaseConstants.HALF_OF_FLOAT),
    RATE_0_POINT_75(0.75f),
    RATE_1_POINT_0(1.0f),
    RATE_1_POINT_25(1.25f),
    RATE_1_POINT_5(1.5f);
    
    private float value;

    private VodSpeedRate(float f) {
        this.value = f;
    }

    public final float getRateValue() {
        return this.value;
    }

    public final String getRateDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.value);
        stringBuilder.append("X");
        return stringBuilder.toString();
    }
}
