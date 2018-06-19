package anet.channel;

import anet.channel.security.ISecurity;
import anet.channel.strategy.dispatch.IAmdcSign;

/* compiled from: Taobao */
class d implements IAmdcSign {
    final /* synthetic */ String a;
    final /* synthetic */ ISecurity b;
    final /* synthetic */ SessionCenter c;

    d(SessionCenter sessionCenter, String str, ISecurity iSecurity) {
        this.c = sessionCenter;
        this.a = str;
        this.b = iSecurity;
    }

    public String getAppkey() {
        return this.a;
    }

    public String sign(String str) {
        return this.b.sign(this.c.context, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
    }

    public boolean useSecurityGuard() {
        return !this.b.isSecOff();
    }
}
