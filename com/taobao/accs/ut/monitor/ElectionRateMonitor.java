package com.taobao.accs.ut.monitor;

import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.utl.BaseMonitor;

@Monitor(module = "accs", monitorPoint = "ele_succ_rate")
/* compiled from: Taobao */
public class ElectionRateMonitor extends BaseMonitor {
    @Dimension
    public int eleVer = 1;
    @Dimension
    public int errorCode;
    @Dimension
    public String errorMsg;
    @Dimension
    public String reason;
    @Dimension
    public int ret;
    @Dimension
    public int sdkVer = 221;
    @Measure(constantValue = 0.0d, max = 15000.0d, min = 0.0d)
    public long time;
    @Dimension
    public String type = "none";
}
