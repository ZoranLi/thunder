package com.tencent.bugly.beta;

import com.tencent.bugly.proguard.y;

/* compiled from: BUGLY */
public class UpgradeInfo {
    public String apkMd5;
    public String apkUrl;
    public long fileSize;
    public String id = "";
    public String imageUrl;
    public String newFeature = "";
    public long popInterval = 0;
    public int popTimes = 0;
    public long publishTime = 0;
    public int publishType = 0;
    public String title = "";
    public int updateType;
    public int upgradeType = 1;
    public int versionCode;
    public String versionName = "";

    public UpgradeInfo(y yVar) {
        if (yVar != null) {
            this.id = yVar.m;
            this.title = yVar.a;
            this.newFeature = yVar.b;
            this.publishTime = yVar.c;
            this.publishType = yVar.d;
            this.upgradeType = yVar.g;
            this.popTimes = yVar.h;
            this.popInterval = yVar.i;
            this.versionCode = yVar.e.c;
            this.versionName = yVar.e.d;
            this.apkMd5 = yVar.e.i;
            this.apkUrl = yVar.f.b;
            this.fileSize = yVar.f.d;
            this.imageUrl = (String) yVar.l.get("IMG_title");
            this.updateType = yVar.p;
        }
    }
}
