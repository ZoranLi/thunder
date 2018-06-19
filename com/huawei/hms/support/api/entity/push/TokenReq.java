package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class TokenReq implements IMessageEntity {
    @a
    private boolean firstTime;
    @a
    private String packageName;

    public boolean isFirstTime() {
        return this.firstTime;
    }

    public void setFirstTime(boolean z) {
        this.firstTime = z;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" {\n\tpkgName: ");
        stringBuilder.append(this.packageName);
        stringBuilder.append("\n\tisFirstTime: ");
        stringBuilder.append(this.firstTime);
        stringBuilder.append("\n\t}");
        return stringBuilder.toString();
    }
}
