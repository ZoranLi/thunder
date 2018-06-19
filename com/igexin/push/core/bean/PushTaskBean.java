package com.igexin.push.core.bean;

import android.text.TextUtils;
import com.igexin.push.core.g;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class PushTaskBean {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private List<BaseAction> f;
    private byte[] g;
    private String h;
    private String i;
    private int j;
    private int k;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private Map<String, String> o;
    private int p;
    private int q;

    public String getAction() {
        return this.a;
    }

    public List<BaseAction> getActionChains() {
        return this.f;
    }

    public String getAppKey() {
        return this.i;
    }

    public String getAppid() {
        return this.b;
    }

    public BaseAction getBaseAction(String str) {
        for (BaseAction baseAction : getActionChains()) {
            if (baseAction.getActionId().equals(str)) {
                return baseAction;
            }
        }
        return null;
    }

    public Map<String, String> getConditionMap() {
        return this.o;
    }

    public int getCurrentActionid() {
        return this.j;
    }

    public int getExecuteTimes() {
        return this.q;
    }

    public String getId() {
        return this.c;
    }

    public String getMessageId() {
        return this.d;
    }

    public String getMsgAddress() {
        return this.h;
    }

    public byte[] getMsgExtra() {
        return this.g;
    }

    public int getPerActionid() {
        return this.k;
    }

    public int getStatus() {
        return this.p;
    }

    public String getTaskId() {
        return this.e;
    }

    public boolean isCDNType() {
        return this.n;
    }

    public boolean isHttpImg() {
        return this.l;
    }

    public boolean isStop() {
        return this.m;
    }

    public void parse(JSONObject jSONObject) {
        String string = jSONObject.getString(AgooConstants.MESSAGE_ID);
        String string2 = jSONObject.getString("appid");
        String string3 = jSONObject.getString("messageid");
        String string4 = jSONObject.getString("taskid");
        String string5 = jSONObject.has("appkey") ? jSONObject.getString("appkey") : null;
        if (string2 != null && string != null && string3 != null && string4 != null && string2.equals(g.a)) {
            setAppid(string2);
            setMessageId(string3);
            setTaskId(string4);
            setId(string);
            if (TextUtils.isEmpty(string5)) {
                string5 = g.b;
            }
            setAppKey(string5);
            setCurrentActionid(1);
            if (jSONObject.has("cdnType")) {
                setCDNType(jSONObject.getBoolean("cdnType"));
            }
        }
    }

    public void setAction(String str) {
        this.a = str;
    }

    public void setActionChains(List<BaseAction> list) {
        this.f = list;
    }

    public void setAppKey(String str) {
        this.i = str;
    }

    public void setAppid(String str) {
        this.b = str;
    }

    public void setCDNType(boolean z) {
        this.n = z;
    }

    public void setConditionMap(Map<String, String> map) {
        this.o = map;
    }

    public void setCurrentActionid(int i) {
        this.j = i;
    }

    public void setExecuteTimes(int i) {
        this.q = i;
    }

    public void setHttpImg(boolean z) {
        this.l = z;
    }

    public void setId(String str) {
        this.c = str;
    }

    public void setMessageId(String str) {
        this.d = str;
    }

    public void setMsgAddress(String str) {
        this.h = str;
    }

    public void setMsgExtra(byte[] bArr) {
        this.g = bArr;
    }

    public void setPerActionid(int i) {
        this.k = i;
    }

    public void setStatus(int i) {
        this.p = i;
    }

    public void setStop(boolean z) {
        this.m = z;
    }

    public void setTaskId(String str) {
        this.e = str;
    }
}
