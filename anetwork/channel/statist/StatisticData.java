package anetwork.channel.statist;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.StringUtils;
import java.io.Serializable;

/* compiled from: Taobao */
public class StatisticData implements Serializable, Cloneable {
    private static final long serialVersionUID = -3538602124202475612L;
    @Deprecated
    public String api_v = "";
    public long cacheTime = 0;
    public String connectionType = "";
    public long dataSpeed = 0;
    @Deprecated
    public int dnsTime = 0;
    public long firstDataTime = 0;
    public String host = "";
    public String ip_port = "";
    @Deprecated
    public int isDNSTimeout = 0;
    public boolean isRequestSuccess = false;
    public boolean isSSL = false;
    @Deprecated
    public boolean isSpdy = false;
    public String netStatSum;
    @Deprecated
    public long netTime = 0;
    @Deprecated
    public long oneWayTime_AEngine = 0;
    public long oneWayTime_ANet = 0;
    @Deprecated
    public long oneWayTime_Jni = 0;
    public long postBodyTime = 0;
    public long recDataTime = 0;
    @Deprecated
    public long receiveDataTime = 0;
    @Deprecated
    public int redirectTime;
    @Deprecated
    public long responseBodySize = 0;
    public int resultCode = 0;
    public int retryTime;
    public long rtt = 0;
    public long sendBeforeTime = 0;
    public long sendSize = 0;
    public long serverRT = 0;
    @Deprecated
    public long spdyWaitTime = 0;
    @Deprecated
    public long tcpConnTime = 0;
    @Deprecated
    public long tcpLinkDate = 0;
    @Deprecated
    public String timeoutType = "";
    public long totalSize = 0;

    public void filledBy(RequestStatistic requestStatistic) {
        if (requestStatistic != null) {
            this.resultCode = requestStatistic.statusCode;
            this.connectionType = requestStatistic.protocolType;
            this.isRequestSuccess = requestStatistic.ret;
            this.host = requestStatistic.host;
            if (!(requestStatistic.ip == null || requestStatistic.port == 0)) {
                this.ip_port = String.format("%s:%d", new Object[]{requestStatistic.ip, Integer.valueOf(requestStatistic.port)});
            }
            this.isSSL = requestStatistic.isSSL;
            this.oneWayTime_ANet = requestStatistic.oneWayTime;
            this.cacheTime = requestStatistic.cacheTime;
            this.firstDataTime = requestStatistic.firstDataTime;
            this.sendBeforeTime = requestStatistic.sendBeforeTime;
            this.recDataTime = requestStatistic.recDataTime;
            this.sendSize = requestStatistic.sendDataSize;
            this.totalSize = requestStatistic.recDataSize;
            this.serverRT = requestStatistic.serverRT;
            this.dataSpeed = this.recDataTime != 0 ? this.totalSize / this.recDataTime : this.totalSize;
        }
    }

    public String sumNetStat() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("isSuccess=");
        stringBuilder.append(this.isRequestSuccess);
        stringBuilder.append(",host=");
        stringBuilder.append(this.host);
        stringBuilder.append(",resultCode=");
        stringBuilder.append(this.resultCode);
        stringBuilder.append(",connType=");
        stringBuilder.append(this.connectionType);
        stringBuilder.append(",oneWayTime_ANet=");
        stringBuilder.append(this.oneWayTime_ANet);
        stringBuilder.append(",ip_port=");
        stringBuilder.append(this.ip_port);
        stringBuilder.append(",isSSL=");
        stringBuilder.append(this.isSSL);
        stringBuilder.append(",cacheTime=");
        stringBuilder.append(this.cacheTime);
        stringBuilder.append(",postBodyTime=");
        stringBuilder.append(this.postBodyTime);
        stringBuilder.append(",firstDataTime=");
        stringBuilder.append(this.firstDataTime);
        stringBuilder.append(",recDataTime=");
        stringBuilder.append(this.recDataTime);
        stringBuilder.append(",serverRT=");
        stringBuilder.append(this.serverRT);
        stringBuilder.append(",rtt=");
        stringBuilder.append(this.rtt);
        stringBuilder.append(",sendSize=");
        stringBuilder.append(this.sendSize);
        stringBuilder.append(",totalSize=");
        stringBuilder.append(this.totalSize);
        stringBuilder.append(",dataSpeed=");
        stringBuilder.append(this.dataSpeed);
        stringBuilder.append(",retryTime=");
        stringBuilder.append(this.retryTime);
        return stringBuilder.toString();
    }

    public String toString() {
        if (StringUtils.isBlank(this.netStatSum)) {
            this.netStatSum = sumNetStat();
        }
        StringBuilder stringBuilder = new StringBuilder("StatisticData [");
        stringBuilder.append(this.netStatSum);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
