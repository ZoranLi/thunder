package com.umeng.socialize.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class WeixinPreferences {
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_EXPIRES_IN = "expires_in";
    private static final String KEY_OPENID = "openid";
    private static final String KEY_REFRESH_TOKEN = "refresh_token";
    private static final String KEY_REFRESH_TOKEN_TTL = "rt_expires_in";
    private static final String KEY_UID = "unionid";
    private String mAccessToken;
    private long mAccessTokenTTL;
    private String mOpenid;
    private String mRefreshToken;
    private long mRefreshTokenTTL;
    private String mUID;
    private SharedPreferences sharedPreferences = null;

    public WeixinPreferences(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("full");
        this.sharedPreferences = context.getSharedPreferences(stringBuilder.toString(), 0);
        this.mUID = this.sharedPreferences.getString(KEY_UID, null);
        this.mOpenid = this.sharedPreferences.getString("openid", null);
        this.mAccessToken = this.sharedPreferences.getString("access_token", null);
        this.mAccessTokenTTL = this.sharedPreferences.getLong("expires_in", 0);
        this.mRefreshToken = this.sharedPreferences.getString("refresh_token", null);
        this.mRefreshTokenTTL = this.sharedPreferences.getLong(KEY_REFRESH_TOKEN_TTL, 0);
    }

    public WeixinPreferences setBundle(Bundle bundle) {
        this.mUID = bundle.getString(KEY_UID);
        this.mOpenid = bundle.getString("openid");
        this.mAccessToken = bundle.getString("access_token");
        this.mRefreshToken = bundle.getString("refresh_token");
        Object string = bundle.getString("expires_in");
        if (!TextUtils.isEmpty(string)) {
            this.mAccessTokenTTL = (Long.valueOf(string).longValue() * 1000) + System.currentTimeMillis();
        }
        long j = bundle.getLong("refresh_token_expires");
        if (j != 0) {
            this.mRefreshTokenTTL = (j * 1000) + System.currentTimeMillis();
        }
        commit();
        return this;
    }

    public String getUID() {
        return this.mUID;
    }

    public String getmOpenid() {
        return this.mOpenid;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public Map<String, String> getmap() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("access_token", this.mAccessToken);
        hashMap.put(KEY_UID, this.mUID);
        hashMap.put("openid", this.mOpenid);
        hashMap.put("refresh_token", this.mRefreshToken);
        hashMap.put("expires_in", String.valueOf(this.mAccessTokenTTL));
        return hashMap;
    }

    public boolean isAccessTokenAvailable() {
        return (TextUtils.isEmpty(this.mAccessToken) || (this.mAccessTokenTTL - System.currentTimeMillis() <= 0)) ? false : true;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public long getmAccessTokenTTL() {
        return this.mAccessTokenTTL;
    }

    public boolean isAuthValid() {
        return (TextUtils.isEmpty(this.mRefreshToken) || (this.mRefreshTokenTTL - System.currentTimeMillis() <= 0)) ? false : true;
    }

    public boolean isAuth() {
        return !TextUtils.isEmpty(getAccessToken());
    }

    public void delete() {
        this.sharedPreferences.edit().clear().commit();
        this.mAccessToken = "";
        this.mRefreshToken = "";
    }

    public void commit() {
        this.sharedPreferences.edit().putString(KEY_UID, this.mUID).putString("openid", this.mOpenid).putString("access_token", this.mAccessToken).putString("refresh_token", this.mRefreshToken).putLong(KEY_REFRESH_TOKEN_TTL, this.mRefreshTokenTTL).putLong("expires_in", this.mAccessTokenTTL).commit();
    }
}
