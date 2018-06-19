package com.umeng.socialize.handler;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.PlatformConfig.APPIDPlatform;
import com.umeng.socialize.PlatformConfig.Platform;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.UmengText;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class UMTencentSSOHandler extends UMSSOHandler {
    protected static final String FIGUREURL_QQ_2 = "figureurl_qq_2";
    protected static final String IS_YELLOW_VIP = "is_yellow_vip";
    protected static final String IS_YELLOW_YEAR_VIP = "is_yellow_year_vip";
    protected static final String LEVEL = "level";
    protected static final String MSG = "msg";
    protected static final String NICKNAME = "nickname";
    private static final String PUBLIC_ACCOUNT = "100424468";
    protected static final String RET = "ret";
    private static final String TAG = "UMTencentSSOHandler";
    protected static final String VIP = "vip";
    protected static final String YELLOW_VIP_LEVEL = "yellow_vip_level";
    protected static Map<String, String> mImageCache = new HashMap();
    protected String VERSION = "6.4.5";
    public APPIDPlatform config = null;
    protected UMAuthListener mAuthListener;
    protected String mImageUrl = null;
    protected ProgressDialog mProgressDialog = null;
    protected UMShareListener mShareListener;
    protected Tencent mTencent;

    protected interface ObtainAppIdListener {
        void onComplete();
    }

    public interface ObtainImageUrlListener {
        void onComplete(String str);
    }

    public void onCreate(Context context, Platform platform) {
        super.onCreate(context, platform);
        StringBuilder stringBuilder = new StringBuilder("qq full version:");
        stringBuilder.append(this.VERSION);
        Log.um(stringBuilder.toString());
        this.config = (APPIDPlatform) platform;
        stringBuilder = new StringBuilder("appid qq:");
        stringBuilder.append(this.config.appId);
        Log.d("appid", stringBuilder.toString());
        this.mTencent = Tencent.createInstance(this.config.appId, context);
        if (this.mTencent == null) {
            Log.e(TAG, UmengText.QQ_TENCENT_ERROR);
            throw new SocializeException(UmengText.QQ_TENCENT_ERROR);
        }
    }

    protected Bundle parseOauthData(Object obj) {
        Bundle bundle = new Bundle();
        if (obj == null) {
            return bundle;
        }
        obj = obj.toString().trim();
        if (TextUtils.isEmpty(obj)) {
            return bundle;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(obj);
        } catch (Object obj2) {
            obj2.printStackTrace();
        }
        if (jSONObject == null) {
            return bundle;
        }
        bundle.putString("auth_time", jSONObject.optString("auth_time", ""));
        bundle.putString("pay_token", jSONObject.optString("pay_token", ""));
        bundle.putString(Constants.PARAM_PLATFORM_ID, jSONObject.optString(Constants.PARAM_PLATFORM_ID, ""));
        bundle.putString("ret", String.valueOf(jSONObject.optInt("ret", -1)));
        bundle.putString("sendinstall", jSONObject.optString("sendinstall", ""));
        bundle.putString("page_type", jSONObject.optString("page_type", ""));
        bundle.putString("appid", jSONObject.optString("appid", ""));
        bundle.putString("openid", jSONObject.optString("openid", ""));
        bundle.putString("uid", jSONObject.optString("openid", ""));
        bundle.putString("expires_in", jSONObject.optString("expires_in", ""));
        bundle.putString("pfkey", jSONObject.optString("pfkey", ""));
        bundle.putString("access_token", jSONObject.optString("access_token", ""));
        return bundle;
    }

    public void getBitmapUrl(UMediaObject uMediaObject, String str, ObtainImageUrlListener obtainImageUrlListener) {
        System.currentTimeMillis();
        uMediaObject = (uMediaObject instanceof UMImage) != null ? (UMImage) uMediaObject : null;
        if (uMediaObject != null) {
            String str2 = (String) mImageCache.get(uMediaObject.asFileImage().toString());
            if (TextUtils.isEmpty(str2) == null) {
                this.mImageUrl = str2;
                uMediaObject = TAG;
                str = new StringBuilder("obtain image url form cache...");
                str.append(this.mImageUrl);
                Log.i(uMediaObject, str.toString());
            }
        }
        Log.i(TAG, "doInBackground end...");
        obtainImageUrlListener.onComplete(this.mImageUrl);
    }

    private void setImageUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            mImageCache.put(str, str2);
            this.mImageUrl = str2;
        }
    }

    protected boolean validTencent() {
        return this.mTencent != null && this.mTencent.getAppId().equals(this.config.appId);
    }
}
