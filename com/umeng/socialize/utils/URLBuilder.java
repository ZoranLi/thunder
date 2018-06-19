package com.umeng.socialize.utils;

import android.content.Context;
import android.os.Build;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.net.utils.AesHelper;

public class URLBuilder {
    private String idmd5 = null;
    private String imei = null;
    private String mAppkey = null;
    private String mEntityKey = null;
    private String mHost = null;
    private String mOpId = null;
    private String mPath = null;
    private String mPlatfrom = null;
    private String mReqType = "0";
    private String mSessionId = null;
    private String mUID = null;
    private String mac = null;
    private String model = null;
    private String network = null;
    private String os = null;
    private String protoversion = null;
    private String sdkversion = null;
    private String ts = null;

    public URLBuilder(Context context) {
        this.imei = DeviceConfig.getDeviceId(context);
        if (this.imei != null) {
            this.idmd5 = AesHelper.md5(this.imei);
        }
        this.mac = DeviceConfig.getMac(context);
        this.network = DeviceConfig.getNetworkAccessMode(context)[0];
        this.model = Build.MODEL;
        this.sdkversion = "6.4.5";
        this.os = "Android";
        this.ts = String.valueOf(System.currentTimeMillis());
        this.protoversion = "2.0";
    }

    public URLBuilder setHost(String str) {
        this.mHost = str;
        return this;
    }

    public URLBuilder setPath(String str) {
        this.mPath = str;
        return this;
    }

    public URLBuilder setAppkey(String str) {
        this.mAppkey = str;
        return this;
    }

    public URLBuilder setEntityKey(String str) {
        this.mEntityKey = str;
        return this;
    }

    public URLBuilder withMedia(SHARE_MEDIA share_media) {
        this.mPlatfrom = share_media.toString();
        return this;
    }

    public URLBuilder withOpId(String str) {
        this.mOpId = str;
        return this;
    }

    public URLBuilder withSessionId(String str) {
        this.mSessionId = str;
        return this;
    }

    public URLBuilder withUID(String str) {
        this.mUID = str;
        return this;
    }

    public String to() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mHost);
        stringBuilder.append(this.mPath);
        stringBuilder.append(this.mAppkey);
        stringBuilder.append("/");
        stringBuilder.append(this.mEntityKey);
        stringBuilder.append("/?");
        stringBuilder.append(buildParams());
        return stringBuilder.toString();
    }

    public java.lang.String toEncript() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r4.mHost;
        r0.append(r1);
        r1 = r4.mPath;
        r0.append(r1);
        r1 = r4.mAppkey;
        r0.append(r1);
        r1 = "/";
        r0.append(r1);
        r1 = r4.mEntityKey;
        r0.append(r1);
        r1 = "/?";
        r0.append(r1);
        r1 = r4.buildParams();
        r2 = new java.lang.StringBuilder;
        r3 = "base url: ";
        r2.<init>(r3);
        r3 = r0.toString();
        r2.append(r3);
        r2 = r2.toString();
        com.umeng.socialize.utils.Log.net(r2);
        r2 = new java.lang.StringBuilder;
        r3 = "params: ";
        r2.<init>(r3);
        r2.append(r1);
        r2 = r2.toString();
        com.umeng.socialize.utils.Log.net(r2);
        r2 = r4.mAppkey;
        com.umeng.socialize.net.utils.AesHelper.setPassword(r2);
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0072 }
        r3 = "URLBuilder url=";	 Catch:{ Exception -> 0x0072 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0072 }
        r2.append(r1);	 Catch:{ Exception -> 0x0072 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0072 }
        com.umeng.socialize.utils.Log.net(r2);	 Catch:{ Exception -> 0x0072 }
        r2 = "UTF-8";	 Catch:{ Exception -> 0x0072 }
        r2 = com.umeng.socialize.net.utils.AesHelper.encryptNoPadding(r1, r2);	 Catch:{ Exception -> 0x0072 }
        r3 = "ud_get=";	 Catch:{ Exception -> 0x0072 }
        r0.append(r3);	 Catch:{ Exception -> 0x0072 }
        r0.append(r2);	 Catch:{ Exception -> 0x0072 }
        goto L_0x007a;
    L_0x0072:
        r2 = "fail to encrypt query string";
        com.umeng.socialize.utils.Log.w(r2);
        r0.append(r1);
    L_0x007a:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.URLBuilder.toEncript():java.lang.String");
    }

    private String buildParams() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("via=");
        stringBuilder.append(this.mPlatfrom.toLowerCase());
        stringBuilder.append("&opid=");
        stringBuilder.append(this.mOpId);
        stringBuilder.append("&ak=");
        stringBuilder.append(this.mAppkey);
        stringBuilder.append("&pcv=");
        stringBuilder.append(this.protoversion);
        stringBuilder.append("&tp=");
        stringBuilder.append(this.mReqType);
        if (this.imei != null) {
            stringBuilder.append("&imei=");
            stringBuilder.append(this.imei);
        }
        if (this.idmd5 != null) {
            stringBuilder.append("&md5imei=");
            stringBuilder.append(this.idmd5);
        }
        if (this.mac != null) {
            stringBuilder.append("&mac=");
            stringBuilder.append(this.mac);
        }
        if (this.network != null) {
            stringBuilder.append("&en=");
            stringBuilder.append(this.network);
        }
        if (this.model != null) {
            stringBuilder.append("&de=");
            stringBuilder.append(this.model);
        }
        if (this.sdkversion != null) {
            stringBuilder.append("&sdkv=");
            stringBuilder.append(this.sdkversion);
        }
        if (this.os != null) {
            stringBuilder.append("&os=");
            stringBuilder.append(this.os);
        }
        if (this.ts != null) {
            stringBuilder.append("&dt=");
            stringBuilder.append(this.ts);
        }
        if (this.mUID != null) {
            stringBuilder.append("&uid=");
            stringBuilder.append(this.mUID);
        }
        if (this.mEntityKey != null) {
            stringBuilder.append("&ek=");
            stringBuilder.append(this.mEntityKey);
        }
        if (this.mSessionId != null) {
            stringBuilder.append("&sid=");
            stringBuilder.append(this.mSessionId);
        }
        return stringBuilder.toString();
    }
}
