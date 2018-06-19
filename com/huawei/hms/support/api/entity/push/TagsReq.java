package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.push.a.a.b.c;

public class TagsReq implements IMessageEntity {
    @a
    private String apkVersion;
    @a
    private String content = "";
    @a
    private long cycle = 0;
    @a
    private int operType;
    @a
    private String pkgName;
    @a
    private int plusType;
    @a
    private String token;

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public long getCycle() {
        return this.cycle;
    }

    public void setCycle(long j) {
        this.cycle = j;
    }

    public int getOperType() {
        return this.operType;
    }

    public void setOperType(int i) {
        this.operType = i;
    }

    public int getPlusType() {
        return this.plusType;
    }

    public void setPlusType(int i) {
        this.plusType = i;
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

    public String getApkVersion() {
        return this.apkVersion;
    }

    public void setApkVersion(String str) {
        this.apkVersion = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" {\n\tcycle: ");
        stringBuilder.append(this.cycle);
        stringBuilder.append("\n\toperType: ");
        stringBuilder.append(this.operType);
        stringBuilder.append("\n\tplusType: ");
        stringBuilder.append(this.plusType);
        stringBuilder.append("\n\ttoken: ");
        stringBuilder.append(c.a(this.token));
        stringBuilder.append("\n\tpkgName: ");
        stringBuilder.append(this.pkgName);
        stringBuilder.append("\n\tapkVersion: ");
        stringBuilder.append(this.apkVersion);
        stringBuilder.append("\n\tcontent: ");
        stringBuilder.append(this.content);
        stringBuilder.append("\n\t\n\t}");
        return stringBuilder.toString();
    }
}
