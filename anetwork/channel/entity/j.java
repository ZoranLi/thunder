package anetwork.channel.entity;

import anet.channel.request.Request;
import anet.channel.request.Request.Builder;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.utils.d;
import anet.channel.util.HttpConstant;
import anet.channel.util.Utils;
import anet.channel.util.c;
import anetwork.channel.a.b;
import anetwork.channel.aidl.ParcelableRequest;
import anetwork.channel.f;
import anetwork.channel.f.a;
import com.xiaomi.push.service.av;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public final class j {
    public final ParcelableRequest a;
    public Request b = null;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public RequestStatistic f = null;
    public final String g;
    public final int h;
    private int i = 0;
    private int j = 0;

    public j(ParcelableRequest parcelableRequest, int i) {
        if (parcelableRequest == null) {
            throw new IllegalArgumentException("request is null");
        }
        this.a = parcelableRequest;
        this.h = i;
        this.g = a.a(parcelableRequest.m, i == 0 ? "HTTP" : "DGRD");
        this.j = parcelableRequest.j;
        if (this.j <= 0) {
            this.j = (int) (Utils.getNetworkTimeFactor() * 1181376512);
        }
        this.e = parcelableRequest.k;
        if (this.e <= 0) {
            this.e = (int) (15000.0f * Utils.getNetworkTimeFactor());
        }
        this.d = parcelableRequest.c;
        if (this.d < 0 || this.d > 3) {
            this.d = 2;
        }
        i = c.a(this.a.d);
        if (i == 0) {
            i = new StringBuilder("url is invalid. url=");
            i.append(this.a.d);
            throw new IllegalArgumentException(i.toString());
        }
        if (!b.b()) {
            i.g();
        } else if (av.b.equalsIgnoreCase(this.a.a("EnableSchemeReplace"))) {
            i.i();
        }
        this.f = new RequestStatistic(i.b(), String.valueOf(parcelableRequest.l));
        this.f.url = i.e();
        this.b = b(i);
    }

    private Request b(c cVar) {
        Builder requestStatistic = new Builder().setUrl(cVar).setMethod(this.a.h).setBody(this.a.b).setReadTimeout(this.e).setConnectTimeout(this.j).setRedirectEnable(this.a.f).setRedirectTimes(this.i).setBizId(this.a.l).setSeq(this.g).setRequestStatistic(this.f);
        if (this.a.i != null) {
            for (f fVar : this.a.i) {
                requestStatistic.addParam(fVar.a(), fVar.b());
            }
        }
        if (this.a.e != null) {
            requestStatistic.setCharset(this.a.e);
        }
        cVar = d.a(cVar.b()) ^ 1;
        Map hashMap = new HashMap();
        if (this.a.g != null) {
            for (anetwork.channel.a aVar : this.a.g) {
                String a = aVar.a();
                if (!HttpConstant.HOST.equalsIgnoreCase(a)) {
                    if (!":host".equalsIgnoreCase(a)) {
                        hashMap.put(a, aVar.b());
                    }
                }
                if (cVar == null) {
                    hashMap.put(HttpConstant.HOST, aVar.b());
                }
            }
        }
        requestStatistic.setHeaders(hashMap);
        return requestStatistic.build();
    }

    public final int a() {
        return this.e * (this.d + 1);
    }

    public final String a(String str) {
        return this.a.a(str);
    }

    public final void a(c cVar) {
        this.i++;
        this.f = new RequestStatistic(cVar.b(), String.valueOf(this.a.l));
        this.f.url = cVar.e();
        this.b = b(cVar);
    }
}
