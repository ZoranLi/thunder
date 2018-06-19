package mtopsdk.mtop.common;

import java.io.Serializable;
import java.util.Map;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.domain.b;
import mtopsdk.mtop.unit.UserUnit;

public class MtopNetworkProp implements Serializable, b {
    private static final long serialVersionUID = -3528337805304245196L;
    public boolean autoRedirect = true;
    public int bizId;
    public int connTimeout = 15000;
    public boolean correctTimeStamp = false;
    public EnvModeEnum envMode = EnvModeEnum.ONLINE;
    public boolean forceRefreshCache = false;
    public MethodEnum method = MethodEnum.GET;
    public ProtocolEnum protocol = ProtocolEnum.HTTP;
    public Map queryParameterMap;
    public String reqUserId;
    public Map requestHeaders;
    public int retryTimes = 1;
    public int socketTimeout = 15000;
    public String ttid;
    public boolean useCache = false;
    public UserUnit userUnit;
    public int wuaFlag = -1;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MtopNetworkProp [");
        stringBuilder.append("protocol=");
        stringBuilder.append(this.protocol);
        stringBuilder.append(", method=");
        stringBuilder.append(this.method);
        stringBuilder.append(", autoRedirect=");
        stringBuilder.append(this.autoRedirect);
        stringBuilder.append(", retryTimes=");
        stringBuilder.append(this.retryTimes);
        stringBuilder.append(", requestHeaders=");
        stringBuilder.append(this.requestHeaders);
        stringBuilder.append(", correctTimeStamp=");
        stringBuilder.append(this.correctTimeStamp);
        stringBuilder.append(", ttid=");
        stringBuilder.append(this.ttid);
        stringBuilder.append(", useCache=");
        stringBuilder.append(this.useCache);
        stringBuilder.append(", forceRefreshCache=");
        stringBuilder.append(this.forceRefreshCache);
        stringBuilder.append(", wuaFlag=");
        stringBuilder.append(this.wuaFlag);
        stringBuilder.append(", queryParameterMap=");
        stringBuilder.append(this.queryParameterMap);
        stringBuilder.append(", connTimeout=");
        stringBuilder.append(this.connTimeout);
        stringBuilder.append(", socketTimeout=");
        stringBuilder.append(this.socketTimeout);
        stringBuilder.append(", bizId=");
        stringBuilder.append(this.bizId);
        stringBuilder.append(", envMode=");
        stringBuilder.append(this.envMode);
        stringBuilder.append(", userUnit=");
        stringBuilder.append(this.userUnit);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
