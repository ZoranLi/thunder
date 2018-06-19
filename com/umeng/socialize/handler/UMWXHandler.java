package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig.APPIDPlatform;
import com.umeng.socialize.PlatformConfig.Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.WeiXinShareContent;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import com.umeng.socialize.weixin.net.WXAuthUtils;
import com.xunlei.downloadprovider.ad.home.a.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class UMWXHandler extends UMSSOHandler {
    private static final String ERRMSG = "errmsg";
    private static final String ERRORCODE = "errcode";
    private static final String ERROR_CODE_TOKEN_ACCESS_FAIL = "42002";
    private static final String ERROR_CODE_TOKEN_FAIL = "40001";
    private static final String ERROR_CODE_TOKEN_REFESH_FAIL = "40030";
    private static final String HEADIMGURL = "headimgurl";
    private static final String LANGUAGE = "language";
    private static final String NICKNAME = "nickname";
    private static final String PRIVILEGE = "privilege";
    private static final int REFRESH_TOKEN_EXPIRES = 604800;
    private static final String REFRESH_TOKEN_EXPIRES_KEY = "refresh_token_expires";
    private static final int REQUEST_CODE = 10086;
    private static final int RESP_TYPE_AUTH = 1;
    private static final int RESP_TYPE_SHARE = 2;
    private static final String SEX = "sex";
    private static final String TAG = "UMWXHandler";
    private static String sScope = "snsapi_userinfo,snsapi_friend,snsapi_message";
    private String VERSION = "6.4.5";
    private APPIDPlatform config;
    private boolean isToCircle = false;
    private UMAuthListener mAuthListener;
    private IWXAPIEventHandler mEventHandler = new IWXAPIEventHandler() {
        public void onReq(BaseReq baseReq) {
        }

        public void onResp(BaseResp baseResp) {
            switch (baseResp.getType()) {
                case 1:
                    UMWXHandler.this.onAuthCallback((Resp) baseResp);
                    return;
                case 2:
                    UMWXHandler.this.onShareCallback((SendMessageToWX.Resp) baseResp);
                    break;
                default:
                    break;
            }
        }
    };
    private SHARE_MEDIA mTarget = SHARE_MEDIA.WEIXIN;
    private IWXAPI mWXApi;
    private UMShareListener umShareListener;
    private WeixinPreferences weixinPreferences;

    public String getSDKVersion() {
        return "3.1.1";
    }

    protected String getToName() {
        return "wxsession";
    }

    public boolean isSupportAuth() {
        return true;
    }

    public void onCreate(Context context, Platform platform) {
        super.onCreate(context, platform);
        this.weixinPreferences = new WeixinPreferences(context.getApplicationContext(), "weixin");
        this.config = (APPIDPlatform) platform;
        this.mWXApi = WXAPIFactory.createWXAPI(context.getApplicationContext(), this.config.appId);
        this.mWXApi.registerApp(this.config.appId);
        context = TAG;
        platform = new StringBuilder("handleid=");
        platform.append(this);
        Log.e(context, platform.toString());
        context = new StringBuilder("wechat full version:");
        context.append(this.VERSION);
        Log.um(context.toString());
    }

    public void setAuthListener(UMAuthListener uMAuthListener) {
        super.setAuthListener(uMAuthListener);
        this.mAuthListener = uMAuthListener;
    }

    public boolean isHasAuthListener() {
        return this.mAuthListener != null;
    }

    public void authorize(final UMAuthListener uMAuthListener) {
        if (this.config != null) {
            this.mTarget = this.config.getName();
        }
        this.mAuthListener = uMAuthListener;
        if (!isInstall()) {
            if (Config.isJumptoAppStore) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(SocializeConstants.DOWN_URL_WX));
                ((Activity) this.mWeakAct.get()).startActivity(intent);
            }
            runInMainThread(new Runnable() {
                public void run() {
                    uMAuthListener.onError(UMWXHandler.this.mTarget, 0, new Throwable(UmengErrorCode.NotInstall.getMessage()));
                }
            });
        } else if (isAuthValid()) {
            if (!isAccessTokenAvailable()) {
                String refreshToken = getRefreshToken();
                StringBuilder stringBuilder = new StringBuilder("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=");
                stringBuilder.append(this.config.appId);
                stringBuilder.append("&grant_type=refresh_token&refresh_token=");
                stringBuilder.append(refreshToken);
                loadOauthData(stringBuilder.toString());
            }
            final Map authWithRefreshToken = getAuthWithRefreshToken(getRefreshToken());
            if (authWithRefreshToken.containsKey(ERRORCODE) && (((String) authWithRefreshToken.get(ERRORCODE)).equals(ERROR_CODE_TOKEN_ACCESS_FAIL) || ((String) authWithRefreshToken.get(ERRORCODE)).equals(ERROR_CODE_TOKEN_REFESH_FAIL))) {
                weixinPreferencesDelete();
                authorize(uMAuthListener);
                return;
            }
            runInMainThread(new Runnable() {
                public void run() {
                    UMWXHandler.this.mAuthListener.onComplete(SHARE_MEDIA.WEIXIN, 0, authWithRefreshToken);
                }
            });
        } else {
            uMAuthListener = new Req();
            uMAuthListener.scope = sScope;
            uMAuthListener.state = "none";
            this.mWXApi.sendReq(uMAuthListener);
        }
    }

    private void runInMainThread(Runnable runnable) {
        QueuedWork.runInMain(runnable);
    }

    public boolean isAuthorize() {
        return this.weixinPreferences.isAuth();
    }

    private void loadOauthData(String str) {
        setBundle(parseAuthData(WXAuthUtils.request(str)));
    }

    private Bundle parseAuthData(String str) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(str)) {
            return bundle;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.keys();
            while (str.hasNext()) {
                String str2 = (String) str.next();
                bundle.putString(str2, jSONObject.optString(str2));
            }
            bundle.putLong(REFRESH_TOKEN_EXPIRES_KEY, 604800);
            bundle.putString("accessToken", bundle.getString("access_token"));
            bundle.putString("expiration", bundle.getString("expires_in"));
            bundle.putString("refreshToken", bundle.getString(Oauth2AccessToken.KEY_REFRESH_TOKEN));
            bundle.putString("uid", bundle.getString("unionid"));
        } catch (String str3) {
            str3.printStackTrace();
        }
        return bundle;
    }

    private java.util.Map<java.lang.String, java.lang.String> getAuthWithRefreshToken(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "https://api.weixin.qq.com/sns/oauth2/refresh_token?";
        r0.append(r1);
        r1 = "appid=";
        r0.append(r1);
        r1 = r2.config;
        r1 = r1.appId;
        r0.append(r1);
        r1 = "&grant_type=refresh_token";
        r0.append(r1);
        r1 = "&refresh_token=";
        r0.append(r1);
        r0.append(r3);
        r3 = r0.toString();
        r3 = com.umeng.socialize.weixin.net.WXAuthUtils.request(r3);
        r3 = com.umeng.socialize.utils.SocializeUtils.jsonToMap(r3);	 Catch:{ Exception -> 0x0039 }
        r0 = "unionid";	 Catch:{ Exception -> 0x003a }
        r1 = r2.getUnionId();	 Catch:{ Exception -> 0x003a }
        r3.put(r0, r1);	 Catch:{ Exception -> 0x003a }
        goto L_0x003a;
    L_0x0039:
        r3 = 0;
    L_0x003a:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.handler.UMWXHandler.getAuthWithRefreshToken(java.lang.String):java.util.Map<java.lang.String, java.lang.String>");
    }

    private void getAuthWithCode(String str, final UMAuthListener uMAuthListener) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
        stringBuilder.append("appid=");
        stringBuilder.append(this.config.appId);
        stringBuilder.append("&secret=");
        stringBuilder.append(this.config.appkey);
        stringBuilder.append("&code=");
        stringBuilder.append(str);
        stringBuilder.append("&grant_type=authorization_code");
        new Thread(new Runnable() {
            public void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r3 = this;
                r0 = r0;
                r0 = r0.toString();
                r0 = com.umeng.socialize.weixin.net.WXAuthUtils.request(r0);
                r1 = com.umeng.socialize.utils.SocializeUtils.jsonToMap(r0);	 Catch:{ Exception -> 0x002f }
                if (r1 == 0) goto L_0x0016;	 Catch:{ Exception -> 0x002f }
            L_0x0010:
                r2 = r1.size();	 Catch:{ Exception -> 0x002f }
                if (r2 != 0) goto L_0x001b;	 Catch:{ Exception -> 0x002f }
            L_0x0016:
                r2 = com.umeng.socialize.handler.UMWXHandler.this;	 Catch:{ Exception -> 0x002f }
                r2.getMap();	 Catch:{ Exception -> 0x002f }
            L_0x001b:
                r2 = com.umeng.socialize.handler.UMWXHandler.this;	 Catch:{ Exception -> 0x002f }
                r0 = r2.parseAuthData(r0);	 Catch:{ Exception -> 0x002f }
                r2 = com.umeng.socialize.handler.UMWXHandler.this;	 Catch:{ Exception -> 0x002f }
                r2.setBundle(r0);	 Catch:{ Exception -> 0x002f }
                r2 = new com.umeng.socialize.handler.UMWXHandler$3$1;	 Catch:{ Exception -> 0x002f }
                r2.<init>(r0, r1);	 Catch:{ Exception -> 0x002f }
                com.umeng.socialize.common.QueuedWork.runInMain(r2);	 Catch:{ Exception -> 0x002f }
                return;
            L_0x002f:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.handler.UMWXHandler.3.run():void");
            }
        }).start();
    }

    public boolean isInstall() {
        return this.mWXApi != null && this.mWXApi.isWXAppInstalled();
    }

    protected void onAuthCallback(Resp resp) {
        if (resp.errCode == 0) {
            getAuthWithCode(resp.code, this.mAuthListener);
        } else if (resp.errCode == -2) {
            if (this.mAuthListener != null) {
                this.mAuthListener.onCancel(SHARE_MEDIA.WEIXIN, 0);
            } else {
                Log.e("UMWXHandlerauthListener == null");
            }
        } else if (resp.errCode != -6) {
            resp = TextUtils.concat(new CharSequence[]{"weixin auth error (", String.valueOf(resp.errCode), "):", resp.errStr});
            if (this.mAuthListener != null) {
                UMAuthListener uMAuthListener = this.mAuthListener;
                SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(UmengErrorCode.AuthorizeFailed.getMessage());
                stringBuilder.append(resp);
                uMAuthListener.onError(share_media, 0, new Throwable(stringBuilder.toString()));
            }
        } else if (this.mAuthListener != null) {
            resp = this.mAuthListener;
            SHARE_MEDIA share_media2 = SHARE_MEDIA.WEIXIN;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(UmengErrorCode.AuthorizeFailed.getMessage());
            stringBuilder2.append(UmengText.errorWithUrl(UmengText.AUTH_DENIED, UrlUtil.WX_ERROR_SIGN));
            resp.onError(share_media2, 0, new Throwable(stringBuilder2.toString()));
        } else {
            Log.e("UMWXHandlerauthListener == null");
        }
    }

    public void deleteAuth(final UMAuthListener uMAuthListener) {
        weixinPreferencesDelete();
        QueuedWork.runInMain(new Runnable() {
            public void run() {
                uMAuthListener.onComplete(SHARE_MEDIA.WEIXIN, 1, null);
            }
        });
    }

    public int getRequestCode() {
        return this.isToCircle ? HandlerRequestCode.WX_CIRCLE_REQUEST_CODE : 10086;
    }

    private void fetchUserInfo(final UMAuthListener uMAuthListener) {
        String openid = getOpenid();
        String accessToken = getAccessToken();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://api.weixin.qq.com/sns/userinfo?access_token=");
        stringBuilder.append(accessToken);
        stringBuilder.append("&openid=");
        stringBuilder.append(openid);
        stringBuilder.append("&lang=zh_CN");
        openid = WXAuthUtils.request(stringBuilder.toString());
        if (!TextUtils.isEmpty(openid)) {
            if (!openid.startsWith("##")) {
                final Map parseUserInfo = parseUserInfo(openid);
                if (parseUserInfo == null) {
                    QueuedWork.runInMain(new Runnable() {
                        public void run() {
                            UMAuthListener uMAuthListener = uMAuthListener;
                            SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(UmengErrorCode.RequestForUserProfileFailed.getMessage());
                            stringBuilder.append(openid);
                            uMAuthListener.onError(share_media, 2, new Throwable(stringBuilder.toString()));
                        }
                    });
                    return;
                } else if (!parseUserInfo.containsKey(ERRORCODE)) {
                    QueuedWork.runInMain(new Runnable() {
                        public void run() {
                            uMAuthListener.onComplete(SHARE_MEDIA.WEIXIN, 2, parseUserInfo);
                        }
                    });
                    return;
                } else if (((String) parseUserInfo.get(ERRORCODE)).equals(ERROR_CODE_TOKEN_FAIL)) {
                    weixinPreferencesDelete();
                    authorize(uMAuthListener);
                    return;
                } else {
                    QueuedWork.runInMain(new Runnable() {
                        public void run() {
                            UMAuthListener uMAuthListener = uMAuthListener;
                            SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(UmengErrorCode.RequestForUserProfileFailed.getMessage());
                            stringBuilder.append((String) parseUserInfo.get(UMWXHandler.ERRORCODE));
                            uMAuthListener.onError(share_media, 2, new Throwable(stringBuilder.toString()));
                        }
                    });
                    return;
                }
            }
        }
        QueuedWork.runInMain(new Runnable() {
            public void run() {
                UMAuthListener uMAuthListener = uMAuthListener;
                SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(UmengErrorCode.RequestForUserProfileFailed.getMessage());
                stringBuilder.append(openid);
                uMAuthListener.onError(share_media, 2, new Throwable(stringBuilder.toString()));
            }
        });
    }

    public void getPlatformInfo(final UMAuthListener uMAuthListener) {
        if (getShareConfig().isNeedAuthOnGetUserInfo()) {
            weixinPreferencesDelete();
        }
        authorize(new UMAuthListener() {
            public void onStart(SHARE_MEDIA share_media) {
            }

            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                QueuedWork.runInBack(new Runnable() {
                    public void run() {
                        UMWXHandler.this.fetchUserInfo(uMAuthListener);
                    }
                }, 1);
            }

            public void onError(SHARE_MEDIA share_media, int i, Throwable th) {
                if (uMAuthListener != null) {
                    uMAuthListener.onError(share_media, i, th);
                }
            }

            public void onCancel(SHARE_MEDIA share_media, int i) {
                if (uMAuthListener != null) {
                    uMAuthListener.onCancel(share_media, i);
                }
            }
        });
    }

    private java.util.Map<java.lang.String, java.lang.String> parseUserInfo(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 == 0) goto L_0x000b;
    L_0x0006:
        r6 = java.util.Collections.emptyMap();
        return r6;
    L_0x000b:
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x012b }
        r1.<init>(r6);	 Catch:{ JSONException -> 0x012b }
        r2 = "errcode";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.has(r2);	 Catch:{ JSONException -> 0x012b }
        if (r2 == 0) goto L_0x0039;	 Catch:{ JSONException -> 0x012b }
    L_0x001d:
        r2 = "UMWXHandler";	 Catch:{ JSONException -> 0x012b }
        com.umeng.socialize.utils.Log.e(r2, r6);	 Catch:{ JSONException -> 0x012b }
        r6 = "errcode";	 Catch:{ JSONException -> 0x012b }
        r2 = "errcode";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.getString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "errmsg";	 Catch:{ JSONException -> 0x012b }
        r2 = "errmsg";	 Catch:{ JSONException -> 0x012b }
        r1 = r1.getString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r1);	 Catch:{ JSONException -> 0x012b }
        return r0;	 Catch:{ JSONException -> 0x012b }
    L_0x0039:
        r6 = "openid";	 Catch:{ JSONException -> 0x012b }
        r2 = "openid";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "screen_name";	 Catch:{ JSONException -> 0x012b }
        r2 = "nickname";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "name";	 Catch:{ JSONException -> 0x012b }
        r2 = "nickname";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "language";	 Catch:{ JSONException -> 0x012b }
        r2 = "language";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "city";	 Catch:{ JSONException -> 0x012b }
        r2 = "city";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "province";	 Catch:{ JSONException -> 0x012b }
        r2 = "province";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "country";	 Catch:{ JSONException -> 0x012b }
        r2 = "country";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "profile_image_url";	 Catch:{ JSONException -> 0x012b }
        r2 = "headimgurl";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "iconurl";	 Catch:{ JSONException -> 0x012b }
        r2 = "headimgurl";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "unionid";	 Catch:{ JSONException -> 0x012b }
        r2 = "unionid";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "uid";	 Catch:{ JSONException -> 0x012b }
        r2 = "unionid";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "gender";	 Catch:{ JSONException -> 0x012b }
        r2 = "sex";	 Catch:{ JSONException -> 0x012b }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x012b }
        r2 = r5.getGender(r2);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r2);	 Catch:{ JSONException -> 0x012b }
        r6 = "privilege";	 Catch:{ JSONException -> 0x012b }
        r6 = r1.optJSONArray(r6);	 Catch:{ JSONException -> 0x012b }
        r1 = 0;	 Catch:{ JSONException -> 0x012b }
        if (r6 != 0) goto L_0x00cc;	 Catch:{ JSONException -> 0x012b }
    L_0x00ca:
        r2 = r1;	 Catch:{ JSONException -> 0x012b }
        goto L_0x00d0;	 Catch:{ JSONException -> 0x012b }
    L_0x00cc:
        r2 = r6.length();	 Catch:{ JSONException -> 0x012b }
    L_0x00d0:
        if (r2 <= 0) goto L_0x00ec;	 Catch:{ JSONException -> 0x012b }
    L_0x00d2:
        r3 = new java.lang.String[r2];	 Catch:{ JSONException -> 0x012b }
    L_0x00d4:
        if (r1 >= r2) goto L_0x00e3;	 Catch:{ JSONException -> 0x012b }
    L_0x00d6:
        r4 = r6.get(r1);	 Catch:{ JSONException -> 0x012b }
        r4 = r4.toString();	 Catch:{ JSONException -> 0x012b }
        r3[r1] = r4;	 Catch:{ JSONException -> 0x012b }
        r1 = r1 + 1;	 Catch:{ JSONException -> 0x012b }
        goto L_0x00d4;	 Catch:{ JSONException -> 0x012b }
    L_0x00e3:
        r6 = "privilege";	 Catch:{ JSONException -> 0x012b }
        r1 = r3.toString();	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r1);	 Catch:{ JSONException -> 0x012b }
    L_0x00ec:
        r6 = "access_token";	 Catch:{ JSONException -> 0x012b }
        r1 = r5.getAccessToken();	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r1);	 Catch:{ JSONException -> 0x012b }
        r6 = "refreshToken";	 Catch:{ JSONException -> 0x012b }
        r1 = r5.getRefreshToken();	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r1);	 Catch:{ JSONException -> 0x012b }
        r6 = "expires_in";	 Catch:{ JSONException -> 0x012b }
        r1 = r5.getmAccessTokenTTL();	 Catch:{ JSONException -> 0x012b }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r1);	 Catch:{ JSONException -> 0x012b }
        r6 = "accessToken";	 Catch:{ JSONException -> 0x012b }
        r1 = r5.getAccessToken();	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r1);	 Catch:{ JSONException -> 0x012b }
        r6 = "refreshToken";	 Catch:{ JSONException -> 0x012b }
        r1 = r5.getRefreshToken();	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r1);	 Catch:{ JSONException -> 0x012b }
        r6 = "expiration";	 Catch:{ JSONException -> 0x012b }
        r1 = r5.getmAccessTokenTTL();	 Catch:{ JSONException -> 0x012b }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ JSONException -> 0x012b }
        r0.put(r6, r1);	 Catch:{ JSONException -> 0x012b }
        return r0;
    L_0x012b:
        r6 = java.util.Collections.emptyMap();
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.handler.UMWXHandler.parseUserInfo(java.lang.String):java.util.Map<java.lang.String, java.lang.String>");
    }

    public String getGender(Object obj) {
        String string = ResContainer.getString(ContextUtil.getContext(), "umeng_socialize_male");
        String string2 = ResContainer.getString(ContextUtil.getContext(), "umeng_socialize_female");
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            if (!(obj.equals("m") || obj.equals("1"))) {
                if (!obj.equals(UmengText.MAN)) {
                    if (!(obj.equals(f.a) || obj.equals("2"))) {
                        if (!obj.equals(UmengText.WOMAN)) {
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
            if (num.intValue() == 2) {
                return string2;
            }
            return obj.toString();
        }
    }

    public boolean share(ShareContent shareContent, final UMShareListener uMShareListener) {
        if (this.config != null) {
            this.mTarget = this.config.getName();
        }
        if (isInstall()) {
            WeiXinShareContent weiXinShareContent = new WeiXinShareContent(shareContent);
            if (!isAbleShareEmoji(this.mTarget, weiXinShareContent)) {
                QueuedWork.runInMain(new Runnable() {
                    public void run() {
                        UMShareListener uMShareListener = uMShareListener;
                        SHARE_MEDIA access$000 = UMWXHandler.this.mTarget;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(UmengErrorCode.ShareDataTypeIllegal.getMessage());
                        stringBuilder.append(UmengText.WX_CIRCLE_NOT_SUPPORT_EMOJ);
                        uMShareListener.onError(access$000, new Throwable(stringBuilder.toString()));
                    }
                });
                return false;
            } else if (isAbleShareMin(this.mTarget, weiXinShareContent)) {
                this.umShareListener = uMShareListener;
                return shareTo(new WeiXinShareContent(shareContent));
            } else {
                QueuedWork.runInMain(new Runnable() {
                    public void run() {
                        UMShareListener uMShareListener = uMShareListener;
                        SHARE_MEDIA access$000 = UMWXHandler.this.mTarget;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(UmengErrorCode.ShareDataTypeIllegal.getMessage());
                        stringBuilder.append(UmengText.WX_CIRCLE_NOT_SUPPORT_MIN);
                        uMShareListener.onError(access$000, new Throwable(stringBuilder.toString()));
                    }
                });
                return false;
            }
        }
        if (Config.isJumptoAppStore != null) {
            shareContent = new Intent("android.intent.action.VIEW");
            shareContent.setData(Uri.parse(SocializeConstants.DOWN_URL_WX));
            ((Activity) this.mWeakAct.get()).startActivity(shareContent);
        }
        QueuedWork.runInMain(new Runnable() {
            public void run() {
                uMShareListener.onError(UMWXHandler.this.mTarget, new Throwable(UmengErrorCode.NotInstall.getMessage()));
            }
        });
        return false;
    }

    public boolean isAbleShareEmoji(SHARE_MEDIA share_media, WeiXinShareContent weiXinShareContent) {
        return (weiXinShareContent.getmStyle() == 64 && (share_media == SHARE_MEDIA.WEIXIN_CIRCLE || share_media == SHARE_MEDIA.WEIXIN_FAVORITE)) ? null : true;
    }

    public boolean isAbleShareMin(SHARE_MEDIA share_media, WeiXinShareContent weiXinShareContent) {
        return (weiXinShareContent.getmStyle() == 128 && (share_media == SHARE_MEDIA.WEIXIN_CIRCLE || share_media == SHARE_MEDIA.WEIXIN_FAVORITE)) ? null : true;
    }

    public boolean isSupport() {
        return this.mWXApi.isWXAppSupportAPI();
    }

    public boolean shareTo(WeiXinShareContent weiXinShareContent) {
        BaseReq req = new SendMessageToWX.Req();
        req.transaction = buildTransaction(weiXinShareContent.getStrStyle());
        req.message = weiXinShareContent.getWxMediaMessage();
        switch (this.mTarget) {
            case WEIXIN:
                req.scene = 0;
                break;
            case WEIXIN_CIRCLE:
                req.scene = 1;
                break;
            case WEIXIN_FAVORITE:
                req.scene = 2;
                break;
            default:
                req.scene = 2;
                break;
        }
        if (req.message == null) {
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    UMShareListener access$600 = UMWXHandler.this.umShareListener;
                    SHARE_MEDIA access$000 = UMWXHandler.this.mTarget;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.UnKnowCode.getMessage());
                    stringBuilder.append("message = null");
                    access$600.onError(access$000, new Throwable(stringBuilder.toString()));
                }
            });
            return false;
        } else if (req.message.mediaObject == null) {
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    UMShareListener access$600 = UMWXHandler.this.umShareListener;
                    SHARE_MEDIA access$000 = UMWXHandler.this.mTarget;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.UnKnowCode.getMessage());
                    stringBuilder.append("mediaobject = null");
                    access$600.onError(access$000, new Throwable(stringBuilder.toString()));
                }
            });
            return false;
        } else {
            weiXinShareContent = this.mWXApi.sendReq(req);
            if (weiXinShareContent == null) {
                QueuedWork.runInMain(new Runnable() {
                    public void run() {
                        UMShareListener access$600 = UMWXHandler.this.umShareListener;
                        SHARE_MEDIA access$000 = UMWXHandler.this.mTarget;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(UmengErrorCode.UnKnowCode.getMessage());
                        stringBuilder.append(UmengText.SHARE_CONTENT_FAIL);
                        access$600.onError(access$000, new Throwable(stringBuilder.toString()));
                    }
                });
            }
            return weiXinShareContent;
        }
    }

    protected void onShareCallback(SendMessageToWX.Resp resp) {
        SHARE_MEDIA share_media;
        StringBuilder stringBuilder;
        UMShareListener uMShareListener;
        SHARE_MEDIA share_media2;
        StringBuilder stringBuilder2;
        switch (resp.errCode) {
            case -6:
                if (this.umShareListener != null) {
                    resp = this.umShareListener;
                    share_media = this.mTarget;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.ShareFailed.getMessage());
                    stringBuilder.append(UmengText.errorWithUrl(UmengText.AUTH_DENIED, UrlUtil.WX_ERROR_SIGN));
                    resp.onError(share_media, new Throwable(stringBuilder.toString()));
                    return;
                }
                break;
            case -5:
                if (this.umShareListener != null) {
                    resp = this.umShareListener;
                    share_media = this.mTarget;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.ShareFailed.getMessage());
                    stringBuilder.append(UmengText.VERSION_NOT_SUPPORT);
                    resp.onError(share_media, new Throwable(stringBuilder.toString()));
                    return;
                }
                break;
            case -3:
            case -1:
                if (this.umShareListener != null) {
                    uMShareListener = this.umShareListener;
                    share_media2 = this.mTarget;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(UmengErrorCode.ShareFailed.getMessage());
                    stringBuilder2.append(resp.errStr);
                    uMShareListener.onError(share_media2, new Throwable(stringBuilder2.toString()));
                    return;
                }
                break;
            case -2:
                if (this.umShareListener != null) {
                    this.umShareListener.onCancel(this.mTarget);
                    return;
                }
                break;
            case 0:
                if (this.umShareListener != null) {
                    new HashMap().put("uid", resp.openId);
                    this.umShareListener.onResult(this.mTarget);
                    return;
                }
                break;
            default:
                if (this.umShareListener != null) {
                    uMShareListener = this.umShareListener;
                    share_media2 = this.mTarget;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(UmengErrorCode.ShareFailed.getMessage());
                    stringBuilder2.append("code:");
                    stringBuilder2.append(resp.errCode);
                    stringBuilder2.append("msg:");
                    stringBuilder2.append(resp.errStr);
                    uMShareListener.onError(share_media2, new Throwable(stringBuilder2.toString()));
                    break;
                }
                break;
        }
    }

    public IWXAPIEventHandler getWXEventHandler() {
        return this.mEventHandler;
    }

    public IWXAPI getWXApi() {
        return this.mWXApi;
    }

    private String buildTransaction(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(System.currentTimeMillis());
        return stringBuilder.toString();
    }

    private boolean isAuthValid() {
        return this.weixinPreferences != null ? this.weixinPreferences.isAuthValid() : false;
    }

    private boolean isAccessTokenAvailable() {
        return this.weixinPreferences != null ? this.weixinPreferences.isAccessTokenAvailable() : false;
    }

    private void weixinPreferencesDelete() {
        if (this.weixinPreferences != null) {
            this.weixinPreferences.delete();
        }
    }

    private String getRefreshToken() {
        return this.weixinPreferences != null ? this.weixinPreferences.getRefreshToken() : "";
    }

    private String getOpenid() {
        return this.weixinPreferences != null ? this.weixinPreferences.getmOpenid() : "";
    }

    private String getUnionId() {
        return this.weixinPreferences != null ? this.weixinPreferences.getUID() : "";
    }

    private String getAccessToken() {
        return this.weixinPreferences != null ? this.weixinPreferences.getAccessToken() : "";
    }

    private long getmAccessTokenTTL() {
        return this.weixinPreferences != null ? this.weixinPreferences.getmAccessTokenTTL() : 0;
    }

    private void setBundle(Bundle bundle) {
        if (this.weixinPreferences != null) {
            this.weixinPreferences.setBundle(bundle).commit();
        }
    }

    private Map<String, String> getMap() {
        return this.weixinPreferences != null ? this.weixinPreferences.getmap() : null;
    }

    public void release() {
        super.release();
        this.mAuthListener = null;
    }
}
