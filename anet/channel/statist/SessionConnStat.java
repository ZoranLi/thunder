package anet.channel.statist;

@Monitor(module = "networkPrefer", monitorPoint = "conn_stat")
/* compiled from: Taobao */
public class SessionConnStat extends StatObject {
    @Measure(max = 60000.0d)
    public long costTime = 0;
    @Dimension
    public String errorCode;
    @Dimension
    public int firstIpType = 1;
    @Dimension
    public String host;
    @Dimension
    public int ret;
    @Dimension
    public int retryTimes;
    public long startTime = 0;
    @Dimension
    public int succIpType = 1;
}
