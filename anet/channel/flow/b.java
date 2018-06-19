package anet.channel.flow;

import anet.channel.statist.RequestStatistic;

/* compiled from: Taobao */
public class b {
    public String a;
    public String b;
    public String c;
    public long d;
    public long e;

    public b(String str, RequestStatistic requestStatistic) {
        this.a = str;
        this.b = requestStatistic.protocolType;
        this.c = requestStatistic.url;
        this.d = requestStatistic.sendDataSize;
        this.e = requestStatistic.recDataSize;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FlowStat{refer='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", protocoltype='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", req_identifier='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", upstream=");
        stringBuilder.append(this.d);
        stringBuilder.append(", downstream=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
