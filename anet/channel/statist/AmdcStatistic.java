package anet.channel.statist;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;

@Monitor(module = "networkPrefer", monitorPoint = "amdc")
/* compiled from: Taobao */
public class AmdcStatistic extends StatObject {
    @Dimension
    public String errorCode;
    @Dimension
    public String errorMsg;
    @Dimension
    public String host;
    @Dimension
    public String netType = NetworkStatusHelper.a().toString();
    @Dimension
    public String proxyType = NetworkStatusHelper.i();
    @Dimension
    public int retryTimes;
    @Dimension
    public String trace;
    @Dimension
    public String ttid = GlobalAppRuntimeInfo.getTtid();
    @Dimension
    public String url;
}
