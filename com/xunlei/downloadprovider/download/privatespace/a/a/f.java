package com.xunlei.downloadprovider.download.privatespace.a.a;

import org.android.spdy.TnetStatusCode;

/* compiled from: BindVerifyErrorCode */
public final class f {
    public static String a(int i) {
        return i != -20000 ? i != TnetStatusCode.EASY_REASON_HANDSHAKE_ERROR ? i != -1000 ? i != 201 ? i != 402 ? "出错啦，请稍候重试！" : "图形验证码验证不通过" : "请获取图形验证码" : "网络连接失败，请稍候重试" : "参数错误" : "数据解析异常";
    }
}
