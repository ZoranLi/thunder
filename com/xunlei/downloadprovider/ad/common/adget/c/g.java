package com.xunlei.downloadprovider.ad.common.adget.c;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: SplashRenderModel */
public final class g extends l {
    public AD_SYSTEM_TYPE a = AD_SYSTEM_TYPE.SOURCE_GDT_FLAG;

    public final void f() {
    }

    public final void g() {
    }

    public g(String str) {
        this.s = str;
    }

    public final AD_SYSTEM_TYPE c() {
        return this.a;
    }

    public final int d() {
        return this.a == AD_SYSTEM_TYPE.SOURCE_GDT_FLAG ? 5 : 6;
    }

    public final String y() {
        return this.a == AD_SYSTEM_TYPE.SOURCE_GDT_FLAG ? SocializeProtocolConstants.PROTOCOL_KEY_TENCENT : "baidu";
    }

    public final String z() {
        return this.a == AD_SYSTEM_TYPE.SOURCE_GDT_FLAG ? "腾讯" : "百度";
    }
}
