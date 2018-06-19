package com.alibaba.baichuan.android.trade.adapter.mtop;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;

public class NetworkRequest implements Serializable {
    public String accessToken;
    public String apiName;
    public String apiVersion = "1.0";
    public String authParams = "";
    public Map extHeaders;
    public boolean isPost = true;
    public boolean needAuth = false;
    public boolean needCache = false;
    public boolean needLogin = false;
    public boolean needWua = false;
    public String openAppKey;
    public Map paramMap;
    public int requestType;
    public int timeOut = -1;

    public boolean check() {
        return (TextUtils.isEmpty(this.apiName) || TextUtils.isEmpty(this.apiVersion)) ? false : true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NetworkRequest [apiName=");
        stringBuilder.append(this.apiName);
        stringBuilder.append(", apiVersion=");
        stringBuilder.append(this.apiVersion);
        stringBuilder.append(", params=");
        stringBuilder.append(this.paramMap);
        stringBuilder.append(", openAppKey=");
        stringBuilder.append(this.openAppKey);
        stringBuilder.append(", accessToken=");
        stringBuilder.append(this.accessToken);
        stringBuilder.append(", needAuth=");
        stringBuilder.append(this.needAuth);
        stringBuilder.append(", needWua=");
        stringBuilder.append(this.needWua);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
