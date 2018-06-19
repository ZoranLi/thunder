package com.xiaomi.mipush.sdk;

import com.xiaomi.push.service.module.PushChannelRegion;

public class PushConfiguration {
    private boolean mGeoEnable;
    private boolean mOpenHmsPush;
    private PushChannelRegion mRegion;

    public static class a {
        private PushChannelRegion a;
        private boolean b;
        private boolean c;
    }

    public PushConfiguration() {
        this.mRegion = PushChannelRegion.China;
        this.mGeoEnable = false;
        this.mOpenHmsPush = false;
    }

    private PushConfiguration(a aVar) {
        this.mRegion = aVar.a == null ? PushChannelRegion.China : aVar.a;
        this.mGeoEnable = aVar.b;
        this.mOpenHmsPush = aVar.c;
    }

    public boolean getGeoEnable() {
        return this.mGeoEnable;
    }

    public boolean getOpenHmsPush() {
        return this.mOpenHmsPush;
    }

    public PushChannelRegion getRegion() {
        return this.mRegion;
    }

    public void setGeoEnable(boolean z) {
        this.mGeoEnable = z;
    }

    public void setOpenHmsPush(boolean z) {
        this.mOpenHmsPush = z;
    }

    public void setRegion(PushChannelRegion pushChannelRegion) {
        this.mRegion = pushChannelRegion;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PushConfiguration{");
        stringBuffer.append("Region:");
        stringBuffer.append(this.mRegion == null ? "null" : this.mRegion.name());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
