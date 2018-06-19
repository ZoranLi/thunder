package anet.channel.statist;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;

@Monitor(module = "networkPrefer", monitorPoint = "network")
/* compiled from: Taobao */
public class RequestStatistic extends StatObject {
    @Dimension
    public volatile String bizId;
    @Measure
    public volatile long cacheTime = 0;
    @Measure
    public volatile long firstDataTime = 0;
    @Dimension
    public volatile String host;
    @Dimension
    public volatile String ip;
    @Dimension
    public volatile String isBg = "";
    @Dimension
    public volatile boolean isDNS = false;
    @Dimension
    public volatile boolean isProxy;
    @Dimension
    public volatile boolean isSSL;
    @Dimension
    public volatile String isSni = "";
    @Dimension
    public volatile String msg = "";
    @Dimension
    public volatile String netType = "";
    @Measure(max = 60000.0d)
    public volatile long oneWayTime = 0;
    @Dimension
    public volatile int port;
    @Dimension
    public volatile String protocolType;
    @Dimension
    public volatile String proxyType = "";
    @Measure
    public volatile long recDataSize = 0;
    @Measure
    public volatile long recDataTime = 0;
    @Dimension
    public volatile boolean ret;
    @Dimension
    public volatile int retryTimes;
    @Measure
    public volatile long sendBeforeTime = 0;
    @Measure
    public volatile long sendDataSize = 0;
    @Measure
    public volatile long sendDataTime = 0;
    @Measure
    public volatile long serverRT = 0;
    public volatile long start = 0;
    @Dimension
    public volatile int statusCode = 0;
    @Deprecated
    public volatile long tcpLinkDate = 0;
    public volatile String url;
    @Measure
    public volatile long waitingTime = 0;

    public RequestStatistic(String str, String str2) {
        this.host = str;
        this.proxyType = NetworkStatusHelper.i();
        this.isProxy = this.proxyType.isEmpty() ^ 1;
        this.netType = NetworkStatusHelper.b();
        this.isBg = GlobalAppRuntimeInfo.isAppBackground() != null ? "bg" : "fg";
        this.bizId = str2;
    }

    public void setConnType(ConnType connType) {
        this.isSSL = connType.isSSL();
        this.protocolType = connType.toString();
    }

    public void setIPAndPort(String str, int i) {
        this.ip = str;
        this.port = i;
        if (str != null && i != 0) {
            this.isDNS = true;
        }
    }
}
