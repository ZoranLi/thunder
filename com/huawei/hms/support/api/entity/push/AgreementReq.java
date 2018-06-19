package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.push.a.a.b.c;

public class AgreementReq implements IMessageEntity {
    @a
    private boolean firstTime;
    @a
    private String pkgName;
    @a
    private String token = "";

    public boolean isFirstTime() {
        return this.firstTime;
    }

    public void setFirstTime(boolean z) {
        this.firstTime = z;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" {\n\tisFirstTime: ");
        stringBuilder.append(this.firstTime);
        stringBuilder.append("\n\tpkgName: ");
        stringBuilder.append(this.pkgName);
        stringBuilder.append("\n\ttoken: ");
        stringBuilder.append(c.a(this.token));
        stringBuilder.append("\n\t}");
        return stringBuilder.toString();
    }
}
