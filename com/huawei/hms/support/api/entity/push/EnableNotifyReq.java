package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class EnableNotifyReq implements IMessageEntity {
    @a
    private boolean enable;
    @a
    private String packageName;

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" {\n\tpkgName: ");
        stringBuilder.append(this.packageName);
        stringBuilder.append("\n\tenable: ");
        stringBuilder.append(this.enable);
        stringBuilder.append("\n\t}");
        return stringBuilder.toString();
    }
}
