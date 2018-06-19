package mtopsdk.mtop.b;

import android.os.Handler;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.f;
import mtopsdk.common.util.i;
import mtopsdk.common.util.j;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.common.a.a;
import mtopsdk.mtop.common.d;
import mtopsdk.mtop.common.k;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.util.e;
import mtopsdk.mtop.util.h;

public class b {
    private static final String TAG = "mtopsdk.MtopBuilder";
    private String customDomain = null;
    private String fullBaseUrl = null;
    private Handler handler = null;
    public k listener = null;
    public MtopNetworkProp mtopProp = new MtopNetworkProp();
    public MtopRequest request;
    public Object requestContext = null;
    protected h stat = new h();

    public b(MtopRequest mtopRequest, String str) {
        this.request = mtopRequest;
        this.mtopProp.ttid = str;
    }

    private a createListenerProxy(k kVar) {
        return kVar == null ? new a(new mtopsdk.mtop.common.b()) : kVar instanceof d ? new mtopsdk.mtop.common.a.b(kVar) : new a(kVar);
    }

    private boolean isUseCache() {
        if (!this.mtopProp.useCache) {
            if (!(this.listener instanceof d)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUseWua() {
        return this.mtopProp.wuaFlag >= 0;
    }

    public b addHttpQueryParameter(String str, String str2) {
        if (!i.b(str)) {
            if (!i.b(str2)) {
                if (this.mtopProp.queryParameterMap == null) {
                    this.mtopProp.queryParameterMap = new HashMap();
                }
                this.mtopProp.queryParameterMap.put(str, str2);
                return this;
            }
        }
        if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
            StringBuilder stringBuilder = new StringBuilder("[addHttpQueryParameter]add HttpQueryParameter error,key=");
            stringBuilder.append(str);
            stringBuilder.append(",value=");
            stringBuilder.append(str2);
            j.a(stringBuilder.toString());
        }
        return this;
    }

    public b addListener(k kVar) {
        this.listener = kVar;
        return this;
    }

    public b addMteeUa(String str) {
        addHttpQueryParameter("ua", str);
        return this;
    }

    public mtopsdk.mtop.common.a asyncRequest() {
        this.stat.a();
        mtopsdk.mtop.a createMtopProxy = createMtopProxy(this.listener);
        if (!f.b() || (!isUseCache() && !isUseWua())) {
            return createMtopProxy.b();
        }
        mtopsdk.mtop.common.a aVar = new mtopsdk.mtop.common.a(null, createMtopProxy);
        e.a().submit(new c(this, aVar, createMtopProxy));
        return aVar;
    }

    public b forceRefreshCache() {
        this.mtopProp.forceRefreshCache = true;
        return this;
    }

    public Object getReqContext() {
        return this.requestContext;
    }

    public b handler(Handler handler) {
        this.handler = handler;
        return this;
    }

    public b headers(Map map) {
        if (!(map == null || map.isEmpty())) {
            if (this.mtopProp.requestHeaders != null) {
                this.mtopProp.requestHeaders.putAll(map);
                return this;
            }
            this.mtopProp.requestHeaders = map;
        }
        return this;
    }

    protected void mtopCommitStatData(boolean z) {
        this.stat.a = z;
    }

    public b protocol(ProtocolEnum protocolEnum) {
        if (protocolEnum != null) {
            this.mtopProp.protocol = protocolEnum;
        }
        return this;
    }

    public b reqContext(Object obj) {
        this.requestContext = obj;
        return this;
    }

    public b reqMethod(MethodEnum methodEnum) {
        if (methodEnum != null) {
            this.mtopProp.method = methodEnum;
        }
        return this;
    }

    public b retryTime(int i) {
        this.mtopProp.retryTimes = i;
        return this;
    }

    public b setBizId(int i) {
        this.mtopProp.bizId = i;
        return this;
    }

    public b setCacheControlNoCache() {
        Map map = this.mtopProp.requestHeaders;
        if (map == null) {
            map = new HashMap();
        }
        map.put("cache-control", "no-cache");
        this.mtopProp.requestHeaders = map;
        return this;
    }

    public b setConnectionTimeoutMilliSecond(int i) {
        if (i > 0) {
            this.mtopProp.connTimeout = i;
        }
        return this;
    }

    public b setCustomDomain(String str) {
        if (str != null) {
            this.customDomain = str;
        }
        return this;
    }

    public b setJsonType(JsonTypeEnum jsonTypeEnum) {
        if (jsonTypeEnum != null) {
            addHttpQueryParameter("type", jsonTypeEnum.getJsonType());
        }
        return this;
    }

    public b setReqUserId(String str) {
        this.mtopProp.reqUserId = str;
        return this;
    }

    public b setSocketTimeoutMilliSecond(int i) {
        if (i > 0) {
            this.mtopProp.socketTimeout = i;
        }
        return this;
    }

    public mtopsdk.mtop.domain.MtopResponse syncRequest() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.stat;
        r0.a();
        r0 = r5.listener;
        r0 = r5.createListenerProxy(r0);
        r1 = r5.createMtopProxy(r0);
        r1.b();
        monitor-enter(r0);
        r1 = r0.b;	 Catch:{ Exception -> 0x0020 }
        if (r1 != 0) goto L_0x0025;	 Catch:{ Exception -> 0x0020 }
    L_0x0017:
        r1 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;	 Catch:{ Exception -> 0x0020 }
        r0.wait(r1);	 Catch:{ Exception -> 0x0020 }
        goto L_0x0025;
    L_0x001e:
        r1 = move-exception;
        goto L_0x0048;
    L_0x0020:
        r1 = "[apiCall] error";	 Catch:{ all -> 0x001e }
        mtopsdk.common.util.j.f(r1);	 Catch:{ all -> 0x001e }
    L_0x0025:
        monitor-exit(r0);	 Catch:{ all -> 0x001e }
        r1 = r0.b;
        r2 = r0.c;
        if (r2 == 0) goto L_0x0030;
    L_0x002c:
        r0 = r0.c;
        r5.requestContext = r0;
    L_0x0030:
        if (r1 != 0) goto L_0x0047;
    L_0x0032:
        r1 = new mtopsdk.mtop.domain.MtopResponse;
        r0 = r5.request;
        r0 = r0.getApiName();
        r2 = r5.request;
        r2 = r2.getVersion();
        r3 = "ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT";
        r4 = "MTOP异步调用超时";
        r1.<init>(r0, r2, r3, r4);
    L_0x0047:
        return r1;
    L_0x0048:
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.b.b.syncRequest():mtopsdk.mtop.domain.MtopResponse");
    }

    public b ttid(String str) {
        this.mtopProp.ttid = str;
        return this;
    }

    public b useCache() {
        this.mtopProp.useCache = true;
        return this;
    }

    public b useWua() {
        return useWua(0);
    }

    public b useWua(int i) {
        this.mtopProp.wuaFlag = i;
        return this;
    }

    public b(mtopsdk.mtop.domain.b bVar, String str) {
        MtopRequest mtopRequest = null;
        if (bVar != null) {
            mtopRequest = new MtopRequest();
            if (bVar != null) {
                mtopsdk.mtop.util.j.a(mtopRequest, bVar);
            }
        }
        this.request = mtopRequest;
        this.mtopProp.ttid = str;
    }

    public b(Object obj, String str) {
        MtopRequest mtopRequest = null;
        if (obj != null) {
            mtopRequest = new MtopRequest();
            if (obj != null) {
                mtopsdk.mtop.util.j.a(mtopRequest, obj);
            }
        }
        this.request = mtopRequest;
        this.mtopProp.ttid = str;
    }

    private mtopsdk.mtop.a createMtopProxy(k kVar) {
        mtopsdk.mtop.b aVar = new mtopsdk.mtop.a(this.request, this.mtopProp, this.requestContext, kVar);
        if (this.request != null) {
            this.stat.p = this.request.getKey();
        }
        aVar.k = this.stat;
        if (this.customDomain != null) {
            aVar.f = this.customDomain;
        }
        if (this.fullBaseUrl != null) {
            aVar.e = this.fullBaseUrl;
        }
        return aVar;
    }
}
