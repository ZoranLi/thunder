package com.alipay.sdk.app;

import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public enum i {
    SUCCEEDED(9000, "处理成功"),
    FAILED(CONFIGID.RECORD_BIT, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(CONFIGID.RECORD_WIDTH, "参数错误"),
    DOUBLE_REQUEST(ReaderCallback.GET_BAR_ANIMATING, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");
    
    public int h;
    public String i;

    private i(int i, String str) {
        this.h = i;
        this.i = str;
    }

    private void b(int i) {
        this.h = i;
    }

    private int a() {
        return this.h;
    }

    private void a(String str) {
        this.i = str;
    }

    private String b() {
        return this.i;
    }

    public static i a(int i) {
        if (i == CONFIGID.RECORD_WIDTH) {
            return PARAMS_ERROR;
        }
        if (i == ReaderCallback.GET_BAR_ANIMATING) {
            return DOUBLE_REQUEST;
        }
        if (i == 8000) {
            return PAY_WAITTING;
        }
        if (i == 9000) {
            return SUCCEEDED;
        }
        switch (i) {
            case 6001:
                return CANCELED;
            case 6002:
                return NETWORK_ERROR;
            default:
                return FAILED;
        }
    }
}
