package mtopsdk.mtop.c.a;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import com.taobao.tao.remotebusiness.listener.c;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import mtopsdk.common.util.i;
import mtopsdk.common.util.j;
import mtopsdk.mtop.a;
import mtopsdk.mtop.a.d;
import mtopsdk.mtop.a.e;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;

public final class b implements a {
    private c a = null;
    private d b = d.a();

    public final Map a(a aVar) {
        if (aVar != null) {
            if (aVar.d != null) {
                this.a = d.c();
                if (this.a == null) {
                    j.e(aVar.k.q, "ISign for SDKConfig.getInstance().getGlobalSign is null");
                    return null;
                }
                MtopRequest mtopRequest = aVar.g;
                MtopNetworkProp mtopNetworkProp = aVar.h;
                Map hashMap = new HashMap();
                hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_PV, "1.0");
                String a = mtopsdk.xstate.a.a(DispatchConstants.LATITUDE);
                if (i.a(a)) {
                    String a2 = mtopsdk.xstate.a.a(DispatchConstants.LONGTITUDE);
                    if (i.a(a2)) {
                        hashMap.put(DispatchConstants.LATITUDE, a);
                        hashMap.put(DispatchConstants.LONGTITUDE, a2);
                    }
                }
                hashMap.put(DispatchConstants.TIMESTAMP, String.valueOf(e.a()));
                hashMap.put("sid", mtopsdk.xstate.a.a("sid"));
                hashMap.put("accessToken", mtopsdk.xstate.a.a("accessToken"));
                hashMap.put("utdid", mtopsdk.xstate.a.a("utdid"));
                hashMap.put("x-features", String.valueOf(mtopsdk.mtop.features.a.a()));
                hashMap.put("api", mtopRequest.getApiName().toLowerCase());
                hashMap.put("v", mtopRequest.getVersion().toLowerCase());
                hashMap.put("data", mtopRequest.getData());
                hashMap.put(Constants.KEY_TTID, i.a(mtopNetworkProp.ttid) ? mtopNetworkProp.ttid : mtopsdk.xstate.a.a(Constants.KEY_TTID));
                a = d.e();
                hashMap.put("appKey", a);
                hashMap.put("sid", mtopsdk.xstate.a.a("sid"));
                if (mtopNetworkProp.wuaFlag >= 0) {
                    hashMap.get(DispatchConstants.TIMESTAMP);
                    hashMap.put("wua", this.a.a());
                }
                String a3 = this.a.a((HashMap) hashMap, a);
                if (i.b(a3)) {
                    StringBuilder stringBuilder = new StringBuilder(128);
                    stringBuilder.append("api=");
                    stringBuilder.append(mtopRequest.getApiName());
                    stringBuilder.append(";v=");
                    stringBuilder.append(mtopRequest.getVersion());
                    stringBuilder.append(" getMtopApiWBSign  failed. [appKey=");
                    stringBuilder.append(a);
                    stringBuilder.append("]");
                    j.e(aVar.k.q, stringBuilder.toString());
                    return null;
                }
                hashMap.put("sign", a3);
                a(aVar, hashMap);
                return hashMap;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("[buildParams]mtopProxy or entrance is invalid.---");
        stringBuilder2.append(aVar);
        j.e(stringBuilder2.toString());
        return null;
    }

    private static void a(a aVar, Map map) {
        aVar = aVar.h;
        if (!(aVar.queryParameterMap == null || aVar.queryParameterMap.isEmpty())) {
            for (Entry entry : aVar.queryParameterMap.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        aVar = d.i();
        if (i.a(aVar)) {
            map.put("x-app-ver", aVar);
        }
        aVar = mtopsdk.xstate.a.a("ua");
        if (aVar != null) {
            map.put("user-agent", aVar);
        }
    }
}
