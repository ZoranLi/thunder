package com.xunlei.downloadprovider.member.payment.voucher;

import android.text.TextUtils;

public enum VoucherBizNo {
    OPEN_NORMAL("openvip"),
    OPEN_BJ("baijin"),
    OPEN_KN("quickbird"),
    OPEN_SVIP("supervip"),
    UPGRADE_NORMAL_2_BJ("upgradevip"),
    UPGRADE_COMMON_2_SVIP("upsupervip"),
    UPGRADE_KN_2_SVIP("upquickbird"),
    UNKNOWN("");
    
    private String value;

    private VoucherBizNo(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public static VoucherBizNo getVoucherBizNo(String str) {
        for (VoucherBizNo voucherBizNo : values()) {
            if (TextUtils.equals(str, voucherBizNo.getValue())) {
                return voucherBizNo;
            }
        }
        return UNKNOWN;
    }
}
