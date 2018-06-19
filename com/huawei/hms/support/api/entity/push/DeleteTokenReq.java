package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.push.a.a.b.c;

public class DeleteTokenReq implements IMessageEntity {
    @a
    private String pkgName;
    @a
    private String token;

    public String getPkgName() {
        return this.pkgName;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" {\n\tpkgName: ");
        stringBuilder.append(this.pkgName);
        stringBuilder.append("\n\ttoken: ");
        stringBuilder.append(c.a(this.token));
        stringBuilder.append("\n\t}");
        return stringBuilder.toString();
    }
}
