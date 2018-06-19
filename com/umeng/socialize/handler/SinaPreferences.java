package com.umeng.socialize.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class SinaPreferences {
    private static final String FOLLOW = "isfollow";
    private static final String KEY_ACCESS_KEY = "access_key";
    private static final String KEY_ACCESS_SECRET = "access_secret";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_REFRESH_TOKEN = "refresh_token";
    private static final String KEY_SSO_TTL = "expires_in";
    private static final String KEY_SSO_UID = "uid";
    private static final String KEY_TTL = "expires_in";
    private static final String KEY_UID = "uid";
    private static final String KEY_USER_NAME = "userName";
    private boolean isfollow = false;
    private String mAccessKey = null;
    private String mAccessSecret = null;
    private String mAccessToken = null;
    private String mRefreshToken = null;
    private long mTTL = 0;
    private String mUID = null;
    private String mUserName = null;
    private SharedPreferences sharedPreferences = null;

    public SinaPreferences(Context context, String str) {
        this.sharedPreferences = context.getSharedPreferences(str, 0);
        this.mAccessKey = this.sharedPreferences.getString(KEY_ACCESS_KEY, null);
        this.mRefreshToken = this.sharedPreferences.getString("refresh_token", null);
        this.mAccessSecret = this.sharedPreferences.getString(KEY_ACCESS_SECRET, null);
        this.mAccessToken = this.sharedPreferences.getString("access_token", null);
        this.mUID = this.sharedPreferences.getString("uid", null);
        this.mTTL = this.sharedPreferences.getLong("expires_in", 0);
        this.isfollow = this.sharedPreferences.getBoolean("isfollow", false);
    }

    public SinaPreferences setAuthData(Map<String, String> map) {
        this.mAccessKey = (String) map.get(KEY_ACCESS_KEY);
        this.mAccessSecret = (String) map.get(KEY_ACCESS_SECRET);
        this.mAccessToken = (String) map.get("access_token");
        this.mRefreshToken = (String) map.get("refresh_token");
        this.mUID = (String) map.get("uid");
        if (!TextUtils.isEmpty((CharSequence) map.get("expires_in"))) {
            this.mTTL = (Long.valueOf((String) map.get("expires_in")).longValue() * 1000) + System.currentTimeMillis();
        }
        return this;
    }

    public String getmAccessToken() {
        return this.mAccessToken;
    }

    public long getmTTL() {
        return this.mTTL;
    }

    public String getmRefreshToken() {
        return this.mRefreshToken;
    }

    public SinaPreferences setAuthData(Bundle bundle) {
        this.mAccessToken = bundle.getString("access_token");
        this.mRefreshToken = bundle.getString("refresh_token");
        this.mUID = bundle.getString("uid");
        if (!TextUtils.isEmpty(bundle.getString("expires_in"))) {
            this.mTTL = (Long.valueOf(bundle.getString("expires_in")).longValue() * 1000) + System.currentTimeMillis();
        }
        return this;
    }

    public Map<String, String> getAuthData() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(KEY_ACCESS_KEY, this.mAccessKey);
        hashMap.put(KEY_ACCESS_SECRET, this.mAccessSecret);
        hashMap.put("uid", this.mUID);
        hashMap.put("expires_in", String.valueOf(this.mTTL));
        return hashMap;
    }

    public String getUID() {
        return this.mUID;
    }

    public boolean isAuthorized() {
        return !TextUtils.isEmpty(this.mAccessToken);
    }

    public boolean isAuthValid() {
        return isAuthorized() && !(this.mTTL - System.currentTimeMillis() <= 0);
    }

    public void commit() {
        this.sharedPreferences.edit().putString(KEY_ACCESS_KEY, this.mAccessKey).putString(KEY_ACCESS_SECRET, this.mAccessSecret).putString("access_token", this.mAccessToken).putString("refresh_token", this.mRefreshToken).putString("uid", this.mUID).putLong("expires_in", this.mTTL).commit();
    }

    public void delete() {
        this.mAccessKey = null;
        this.mAccessSecret = null;
        this.mAccessToken = null;
        this.mUID = null;
        this.mTTL = 0;
        this.sharedPreferences.edit().clear().commit();
    }
}
