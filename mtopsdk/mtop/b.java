package mtopsdk.mtop;

import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.i;
import mtopsdk.common.util.j;
import mtopsdk.mtop.antiattack.a;
import mtopsdk.mtop.antiattack.d;
import mtopsdk.mtop.antiattack.e;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.common.k;
import mtopsdk.mtop.domain.EntranceEnum;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.Result;
import mtopsdk.mtop.util.c;
import mtopsdk.mtop.util.h;

public class b implements mtopsdk.mtop.domain.b {
    public static EnvModeEnum a = EnvModeEnum.ONLINE;
    public static a b = new mtopsdk.mtop.antiattack.b();
    public static d c = new e();
    static volatile boolean l = false;
    public EntranceEnum d = EntranceEnum.GW_OPEN;
    public String e;
    public String f;
    public MtopRequest g;
    public MtopNetworkProp h = new MtopNetworkProp();
    public Object i;
    public k j;
    public h k;

    public b(MtopRequest mtopRequest, MtopNetworkProp mtopNetworkProp, Object obj, k kVar) {
        this.g = mtopRequest;
        if (mtopNetworkProp != null) {
            this.h = mtopNetworkProp;
        }
        this.i = obj;
        this.j = kVar;
    }

    public final String a(String str) {
        StringBuilder stringBuilder;
        try {
            EnvModeEnum envModeEnum = a;
            this.h.envMode = envModeEnum;
            if (i.a(this.f)) {
                stringBuilder = new StringBuilder(40);
                stringBuilder.append(this.h.protocol.getProtocol());
                if (i.a(str)) {
                    stringBuilder.append(str);
                }
                stringBuilder.append(this.f);
                stringBuilder.append("/");
                stringBuilder.append(this.d.getEntrance());
                return stringBuilder.toString();
            }
            if (i.b(this.e)) {
                StringBuilder stringBuilder2 = new StringBuilder(40);
                stringBuilder2.append(this.h.protocol.getProtocol());
                if (i.a(str)) {
                    stringBuilder2.append(str);
                }
                stringBuilder2.append(c.a[envModeEnum.getEnvMode()]);
                stringBuilder2.append(this.d.getEntrance());
                return stringBuilder2.toString();
            }
            return this.e;
        } catch (Exception e) {
            stringBuilder = new StringBuilder("[getFullBaseUrl] create MtopProxyBase fullbaseurl error ---");
            stringBuilder.append(e.toString());
            j.e(stringBuilder.toString());
        }
    }

    public final void a(MtopResponse mtopResponse) {
        if (this.j instanceof mtopsdk.mtop.common.e) {
            ((mtopsdk.mtop.common.e) this.j).onFinished(new mtopsdk.mtop.common.i(mtopResponse), this.i);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("MtopProxyBase [entrance=");
        stringBuilder.append(this.d);
        stringBuilder.append(", fullBaseUrl=");
        stringBuilder.append(this.e);
        stringBuilder.append(", customDomain=");
        stringBuilder.append(this.f);
        stringBuilder.append(", mtopRequest=");
        stringBuilder.append(this.g);
        stringBuilder.append(", property=");
        stringBuilder.append(this.h);
        stringBuilder.append(", context=");
        stringBuilder.append(this.i);
        stringBuilder.append(", callback=");
        stringBuilder.append(this.j);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected final Result c() {
        StringBuilder stringBuilder;
        String str;
        StringBuilder stringBuilder2;
        String str2 = this.k.q;
        if (this.g != null) {
            if (this.g.isLegalRequest()) {
                if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
                    stringBuilder = new StringBuilder("[validateBusinessInit]");
                    stringBuilder.append(this.g.toString());
                    j.a(str2, stringBuilder.toString());
                }
                if (this.h != null) {
                    return new Result(Boolean.valueOf(true));
                }
                str = "MtopNetworkProp is invalid.";
                stringBuilder2 = new StringBuilder("[validateBusinessInit]");
                stringBuilder2.append(str);
                j.e(str2, stringBuilder2.toString());
                return new Result(false, "ANDROID_SYS_MTOPPROXYBASE_INIT_ERROR", str);
            }
        }
        stringBuilder = new StringBuilder("mtopRequest is invalid.");
        stringBuilder.append(this.g != null ? this.g.toString() : "mtopRequest=null");
        str = stringBuilder.toString();
        stringBuilder2 = new StringBuilder("[validateBusinessInit]");
        stringBuilder2.append(str);
        j.e(str2, stringBuilder2.toString());
        return new Result(false, "ANDROID_SYS_MTOPPROXYBASE_INIT_ERROR", str);
    }
}
