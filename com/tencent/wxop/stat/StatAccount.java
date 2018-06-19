package com.tencent.wxop.stat;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import com.xunlei.downloadprovider.pushmessage.e;
import org.json.JSONException;
import org.json.JSONObject;

public class StatAccount {
    public static final int CUSTOM_TYPE = 7;
    public static final int DEFAULT_TYPE = 0;
    public static final int EMAIL_TYPE = 6;
    public static final int PHONE_NUM_TYPE = 5;
    public static final int QQ_NUM_TYPE = 1;
    public static final int QQ_OPENID_TYPE = 3;
    public static final int WECHAT_ID_TYPE = 2;
    public static final int WECHAT_OPENID_TYPE = 4;
    private String a = "";
    private int b = 0;
    private String c = "";
    private String d = "";

    public StatAccount(String str) {
        this.a = str;
    }

    public StatAccount(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public String getAccount() {
        return this.a;
    }

    public int getAccountType() {
        return this.b;
    }

    public String getExt() {
        return this.c;
    }

    public String getExt1() {
        return this.d;
    }

    public void setAccount(String str) {
        this.a = str;
    }

    public void setAccountType(int i) {
        this.b = i;
    }

    public void setExt(String str) {
        this.c = str;
    }

    public void setExt1(String str) {
        this.d = str;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        if (l.c(this.a)) {
            try {
                r.a(jSONObject, "a", this.a);
                jSONObject.put(DispatchConstants.TIMESTAMP, this.b);
                r.a(jSONObject, e.a, this.c);
                r.a(jSONObject, "e1", this.d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatAccount [account=");
        stringBuilder.append(this.a);
        stringBuilder.append(", accountType=");
        stringBuilder.append(this.b);
        stringBuilder.append(", ext=");
        stringBuilder.append(this.c);
        stringBuilder.append(", ext1=");
        stringBuilder.append(this.d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
