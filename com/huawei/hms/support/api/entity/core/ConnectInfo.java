package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

public class ConnectInfo implements IMessageEntity {
    @a
    private List<String> apiNameList;
    @a
    private String fingerprint;
    @a
    private List<Scope> scopeList;
    @a
    private String subAppID;

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.apiNameList = list;
        this.scopeList = list2;
        this.fingerprint = str;
        this.subAppID = str2;
    }

    public List<String> getApiNameList() {
        return this.apiNameList;
    }

    public void setApiNameList(List<String> list) {
        this.apiNameList = list;
    }

    public List<Scope> getScopeList() {
        return this.scopeList;
    }

    public void setScopeList(List<Scope> list) {
        this.scopeList = list;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public void setFingerprint(String str) {
        this.fingerprint = str;
    }

    public String getSubAppID() {
        return this.subAppID;
    }

    public void setSubAppID(String str) {
        this.subAppID = str;
    }
}
