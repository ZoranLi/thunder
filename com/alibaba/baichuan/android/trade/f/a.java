package com.alibaba.baichuan.android.trade.f;

import com.alibaba.baichuan.android.trade.AlibcContext;

public final class a {
    public static String a() {
        String str;
        switch (AlibcContext.g) {
            case PRE:
                str = "http://nbsdk-baichuan.taobao.com/%s/%s/%s/meta.htm?plat=android";
                break;
            case TEST:
                str = "http://100.69.205.47/%s/%s/%s/meta.htm?plat=android";
                break;
            default:
                str = "https://nbsdk-baichuan.alicdn.com/%s/%s/%s/meta.htm?plat=android";
                break;
        }
        return String.format(str, new Object[]{AlibcContext.d, AlibcContext.c(), "1.0.0"});
    }
}
