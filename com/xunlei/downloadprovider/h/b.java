package com.xunlei.downloadprovider.h;

import com.xunlei.common.commonutil.ConvertUtil;

/* compiled from: BizConvertUtil */
public final class b {
    public static String a(long j) {
        return ConvertUtil.decimal2String(j, 10000, 10000, "万");
    }
}
