package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.socialize.PlatformConfig.Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.net.PlatformTokenUploadReq;
import com.umeng.socialize.net.PlatformTokenUploadResponse;
import com.umeng.socialize.net.RestAPI;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.Log;
import com.xunlei.downloadprovider.ad.home.a.f;
import java.lang.ref.WeakReference;

public abstract class UMSSOHandler {
    protected static final String ACCESSTOKEN = "accessToken";
    protected static final String ACCESS_SECRET = "access_secret";
    protected static final String ACCESS_TOKEN = "access_token";
    protected static final String CITY = "city";
    protected static final String COUNTRY = "country";
    protected static final String EMAIL = "email";
    protected static final String EXPIRATION = "expiration";
    protected static final String EXPIRES_IN = "expires_in";
    protected static final String FIRST_NAME = "first_name";
    protected static final String GENDER = "gender";
    protected static final String ICON = "iconurl";
    protected static final String ID = "id";
    protected static final String JSON = "json";
    protected static final String LAST_NAME = "last_name";
    protected static final String MIDDLE_NAME = "middle_name";
    protected static final String NAME = "name";
    protected static final String OPENID = "openid";
    @Deprecated
    protected static final String PROFILE_IMAGE_URL = "profile_image_url";
    protected static final String PROVINCE = "province";
    protected static final String REFRESHTOKEN = "refreshToken";
    protected static final String REFRESH_TOKEN = "refresh_token";
    @Deprecated
    protected static final String SCREEN_NAME = "screen_name";
    protected static final String UID = "uid";
    protected static final String UNIONID = "unionid";
    protected static final String USID = "usid";
    private static final UMShareConfig mDefaultShareConfig = new UMShareConfig();
    private Platform mConfig = null;
    private Context mContext = null;
    protected UMShareConfig mShareConfig;
    protected int mThumbLimit = 32768;
    protected WeakReference<Activity> mWeakAct;

    public void authorize(UMAuthListener uMAuthListener) {
    }

    public void deleteAuth(UMAuthListener uMAuthListener) {
    }

    public int getRequestCode() {
        return 0;
    }

    public String getSDKVersion() {
        return "";
    }

    protected String getToName() {
        return "";
    }

    public boolean isHasAuthListener() {
        return true;
    }

    public boolean isSupportAuth() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onResume() {
    }

    public void release() {
    }

    public void setAuthListener(UMAuthListener uMAuthListener) {
    }

    public abstract boolean share(ShareContent shareContent, UMShareListener uMShareListener);

    public void onCreate(Context context, Platform platform) {
        this.mContext = ContextUtil.getContext();
        this.mConfig = platform;
        if ((context instanceof Activity) != null) {
            this.mWeakAct = new WeakReference((Activity) context);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Platform getConfig() {
        return this.mConfig;
    }

    public final void setShareConfig(UMShareConfig uMShareConfig) {
        this.mShareConfig = uMShareConfig;
    }

    protected final UMShareConfig getShareConfig() {
        if (this.mShareConfig == null) {
            return mDefaultShareConfig;
        }
        return this.mShareConfig;
    }

    public void getPlatformInfo(UMAuthListener uMAuthListener) {
        Log.d("'getPlatformInfo', it works!");
    }

    public boolean isInstall() {
        Log.e("该平台不支持查询安装");
        return true;
    }

    public boolean isSupport() {
        Log.e("该平台不支持查询sdk支持");
        return true;
    }

    public boolean isAuthorize() {
        Log.e("该平台不支持查询是否授权");
        return true;
    }

    public String getGender(Object obj) {
        String string = ResContainer.getString(ContextUtil.getContext(), "umeng_socialize_male");
        String string2 = ResContainer.getString(ContextUtil.getContext(), "umeng_socialize_female");
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            if (!(obj.equals("m") || obj.equals("1"))) {
                if (!obj.equals("男")) {
                    if (!(obj.equals(f.a) || obj.equals("0"))) {
                        if (!obj.equals("女")) {
                            return obj.toString();
                        }
                    }
                    return string2;
                }
            }
            return string;
        } else if (!(obj instanceof Integer)) {
            return obj.toString();
        } else {
            Integer num = (Integer) obj;
            if (num.intValue() == 1) {
                return string;
            }
            if (num.intValue() == 0) {
                return string2;
            }
            return obj.toString();
        }
    }

    protected void uploadAuthData(final Bundle bundle) throws SocializeException {
        new Thread(new Runnable() {
            public void run() {
                PlatformTokenUploadReq platformTokenUploadReq = new PlatformTokenUploadReq(UMSSOHandler.this.getContext());
                platformTokenUploadReq.addStringParams("to", UMSSOHandler.this.getToName());
                platformTokenUploadReq.addStringParams("usid", bundle.getString("uid"));
                platformTokenUploadReq.addStringParams("access_token", bundle.getString("access_token"));
                platformTokenUploadReq.addStringParams("refresh_token", bundle.getString("refresh_token"));
                platformTokenUploadReq.addStringParams("expires_in", bundle.getString("expires_in"));
                PlatformTokenUploadResponse uploadPlatformToken = RestAPI.uploadPlatformToken(platformTokenUploadReq);
                StringBuilder stringBuilder = new StringBuilder("upload token resp = ");
                stringBuilder.append(uploadPlatformToken == null ? "is null" : uploadPlatformToken.mMsg);
                Log.e(stringBuilder.toString());
            }
        }).start();
    }
}
