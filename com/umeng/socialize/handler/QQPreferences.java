package com.umeng.socialize.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class QQPreferences {
    private static final String ACCESS_TOKEN = "access_token";
    private static final String EXPIRES_IN = "expires_in";
    private static final String OPENID = "openid";
    private static final String UID = "uid";
    private static final String UNIONID = "unionid";
    private static long mtl;
    private String mAccessToken = null;
    private String mOpenid = null;
    private String mUID = null;
    private SharedPreferences sharedPreferences = null;
    private String unionid = null;

    public QQPreferences(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("full");
        this.sharedPreferences = context.getSharedPreferences(stringBuilder.toString(), 0);
        this.mAccessToken = this.sharedPreferences.getString("access_token", null);
        this.mUID = this.sharedPreferences.getString("uid", null);
        this.mOpenid = this.sharedPreferences.getString("openid", null);
        mtl = this.sharedPreferences.getLong("expires_in", 0);
        this.unionid = this.sharedPreferences.getString(UNIONID, null);
    }

    public String getmAccessToken() {
        return this.mAccessToken;
    }

    public void setmUID(String str) {
        this.mUID = str;
    }

    public void setUnionid(String str) {
        this.unionid = str;
    }

    public String getUnionid() {
        return this.unionid;
    }

    public void setmOpenid(String str) {
        this.mOpenid = str;
    }

    public static long getExpiresIn() {
        return mtl;
    }

    public String getmUID() {
        return this.mUID;
    }

    public QQPreferences setAuthData(Bundle bundle) {
        this.mAccessToken = bundle.getString("access_token");
        mtl = (Long.valueOf(bundle.getString("expires_in")).longValue() * 1000) + System.currentTimeMillis();
        this.mOpenid = bundle.getString("openid");
        this.mUID = bundle.getString("openid");
        this.unionid = bundle.getString(UNIONID);
        return this;
    }

    public boolean isAuthValid() {
        return (this.mAccessToken == null || (mtl - System.currentTimeMillis() <= 0)) ? false : true;
    }

    public void commit() {
        this.sharedPreferences.edit().putString("access_token", this.mAccessToken).putLong("expires_in", mtl).putString("uid", this.mUID).putString("openid", this.mOpenid).putString(UNIONID, this.unionid).commit();
    }

    public void delete() {
        this.mAccessToken = null;
        mtl = 0;
        this.sharedPreferences.edit().clear().commit();
    }
}
