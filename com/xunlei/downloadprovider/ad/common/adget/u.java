package com.xunlei.downloadprovider.ad.common.adget;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j.a;
import java.util.List;

/* compiled from: ThunderADManager */
final class u implements b {
    final /* synthetic */ v a;
    final /* synthetic */ THUNDER_AD_INFO b;
    final /* synthetic */ t c;

    u(t tVar, v vVar, THUNDER_AD_INFO thunder_ad_info) {
        this.c = tVar;
        this.a = vVar;
        this.b = thunder_ad_info;
    }

    public final void a(List<l> list) {
        this.a.a((List) list);
    }

    public final void a() {
        t.a(this.c, this.b, this.a, new a((byte) (this.b.getDefStyle().mLoadStrate & 6), this.b.getPositionId(), null, null, null, SocializeProtocolConstants.PROTOCOL_KEY_TENCENT, this.b.mDefStyle, null));
    }

    public final void a(a aVar) {
        t.a(this.c, this.b, this.a, aVar);
    }
}
