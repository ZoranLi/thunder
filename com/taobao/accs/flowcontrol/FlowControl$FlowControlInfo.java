package com.taobao.accs.flowcontrol;

import java.io.Serializable;

/* compiled from: Taobao */
public class FlowControl$FlowControlInfo implements Serializable {
    private static final long serialVersionUID = -2259991484877844919L;
    public String bizId;
    public long delayTime;
    public long expireTime;
    public String serviceId;
    public long startTime;
    public int status;

    public FlowControl$FlowControlInfo(String str, String str2, int i, long j, long j2, long j3) {
        this.serviceId = str;
        this.bizId = str2;
        this.status = i;
        this.delayTime = j;
        str = 0;
        if (j2 <= 0) {
            j2 = 0;
        }
        this.expireTime = j2;
        if (j3 > 0) {
            str = j3;
        }
        this.startTime = str;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - (this.startTime + this.expireTime) > 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("flow ctrl serviceId:");
        stringBuffer.append(this.serviceId);
        stringBuffer.append(" bizId:");
        stringBuffer.append(this.bizId);
        stringBuffer.append(" status:");
        stringBuffer.append(this.status);
        stringBuffer.append(" delayTime:");
        stringBuffer.append(this.delayTime);
        stringBuffer.append(" startTime:");
        stringBuffer.append(this.startTime);
        stringBuffer.append(" expireTime:");
        stringBuffer.append(this.expireTime);
        return stringBuffer.toString();
    }
}
