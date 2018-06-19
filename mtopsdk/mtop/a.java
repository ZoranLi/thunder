package mtopsdk.mtop;

import java.util.Map;
import mtopsdk.common.util.i;
import mtopsdk.mtop.a.d;
import mtopsdk.mtop.a.g;
import mtopsdk.mtop.c.a.b;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.common.k;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.unit.UserUnit;
import mtopsdk.mtop.unit.UserUnit.UnitType;
import mtopsdk.mtop.util.Result;
import mtopsdk.mtop.util.h;

public final class a extends b {
    private mtopsdk.mtop.c.a.a m = new b();
    private mtopsdk.mtop.d.a n = new mtopsdk.mtop.d.b();

    public a(MtopRequest mtopRequest, MtopNetworkProp mtopNetworkProp, Object obj, k kVar) {
        super(mtopRequest, mtopNetworkProp, obj, kVar);
    }

    public final MtopResponse a() {
        d();
        Result c = c();
        if (c.isSuccess()) {
            Map a = this.m.a(this);
            if (a == null) {
                return new MtopResponse(this.g.getApiName(), this.g.getVersion(), "ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR", "生成Mtop签名sign失败");
            }
            MtopResponse a2 = this.n.a(this, a);
            this.k.f = a2.getRetCode();
            this.k.g();
            a2.setMtopStat(this.k);
            return a2;
        }
        MtopResponse mtopResponse = this.g != null ? new MtopResponse(this.g.getApiName(), this.g.getVersion(), c.getErrCode(), c.getErrInfo()) : new MtopResponse(c.getErrCode(), c.getErrInfo());
        a(mtopResponse);
        return mtopResponse;
    }

    public final mtopsdk.mtop.common.a b() {
        d();
        Result c = c();
        if (c.isSuccess()) {
            Map a = this.m.a(this);
            if (a != null) {
                return this.n.b(this, a);
            }
            a(new MtopResponse(this.g.getApiName(), this.g.getVersion(), "ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR", "生成Mtop签名sign失败"));
            return new mtopsdk.mtop.common.a(null, this);
        }
        a(this.g != null ? new MtopResponse(this.g.getApiName(), this.g.getVersion(), c.getErrCode(), c.getErrInfo()) : new MtopResponse(c.getErrCode(), c.getErrInfo()));
        return new mtopsdk.mtop.common.a(null, this);
    }

    private void d() {
        if (!b.l) {
            synchronized (b.class) {
                if (!b.l) {
                    d.a();
                    EnvModeEnum h = d.h();
                    if (h != null) {
                        b.a = h;
                    }
                    mtopsdk.mtop.a.a.a();
                    b.l = true;
                }
            }
        }
        if (this.k == null) {
            this.k = new h();
            this.k.a();
            if (this.g != null) {
                this.k.p = this.g.getKey();
            }
        }
        String str = this.h.reqUserId;
        if (i.b(str)) {
            str = mtopsdk.xstate.a.a("uid");
        }
        d.a();
        d.f();
        this.h.userUnit = i.b(null) ? new UserUnit(str, UnitType.CENTER, "") : new UserUnit(str, UnitType.UNIT, null);
        g.a();
        if (!g.c()) {
            this.h.protocol = ProtocolEnum.HTTP;
        }
    }
}
