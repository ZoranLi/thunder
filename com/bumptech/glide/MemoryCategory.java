package com.bumptech.glide;

import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public enum MemoryCategory {
    LOW(PayBaseConstants.HALF_OF_FLOAT),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private float multiplier;

    private MemoryCategory(float f) {
        this.multiplier = f;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }
}
