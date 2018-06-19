package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;

public class Scope implements IMessageEntity {
    private final String mScopeUri;

    public Scope() {
        this.mScopeUri = null;
    }

    public Scope(String str) {
        this.mScopeUri = str;
    }

    public String getScopeUri() {
        return this.mScopeUri;
    }

    public boolean equeals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.mScopeUri.equals(((Scope) obj).mScopeUri);
        }
        return null;
    }
}
