package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.a.a;

public class AuthInfoResp extends AbstractResp {
    @a
    private AuthorizationInfo authInfo;

    public int getRtnCode() {
        return super.getRtnCode();
    }

    public AuthorizationInfo getAuthInfo() {
        return this.authInfo;
    }

    public void setAuthInfo(AuthorizationInfo authorizationInfo) {
        this.authInfo = authorizationInfo;
    }
}
