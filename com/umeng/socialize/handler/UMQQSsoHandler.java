package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.authjs.a;
import com.alipay.sdk.cons.c;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.umeng.message.proguard.k;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig.Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.QQShareContent;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class UMQQSsoHandler extends UMTencentSSOHandler {
    private static final String TAG = "UMQQSsoHandler";
    private final String UNIONID_PARAM = "&unionid=1";
    private final String UNIONID_REQUEST_URL = "https://graph.qq.com/oauth2.0/me?access_token=";
    private IUiListener mShareListener;
    private QQPreferences qqPreferences;

    public int getRequestCode() {
        return 10103;
    }

    public String getSDKVersion() {
        return "3.1.0";
    }

    protected String getToName() {
        return "qq";
    }

    public boolean isSupportAuth() {
        return true;
    }

    public void onCreate(Context context, Platform platform) {
        super.onCreate(context, platform);
        if (context != null) {
            this.qqPreferences = new QQPreferences(context, SHARE_MEDIA.QQ.toString());
        }
    }

    public boolean share(ShareContent shareContent, final UMShareListener uMShareListener) {
        if (this.mTencent == null) {
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    UMShareListener uMShareListener = uMShareListener;
                    SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.ShareFailed.getMessage());
                    stringBuilder.append(UmengText.tencentEmpty(Config.isUmengQQ.booleanValue()));
                    uMShareListener.onError(share_media, new Throwable(stringBuilder.toString()));
                }
            });
            return false;
        } else if (isInstall()) {
            shareContent = buildShareContent(shareContent);
            Object string = shareContent.getString("error");
            if (TextUtils.isEmpty(string)) {
                this.mShareListener = getSharelistener(uMShareListener);
                shareToQQ(shareContent);
                return false;
            }
            onShareParamsError(uMShareListener, string);
            return false;
        } else {
            onNotInstall(uMShareListener);
            return false;
        }
    }

    protected void onNotInstall(final UMShareListener uMShareListener) {
        if (Config.isJumptoAppStore) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(SocializeConstants.DOWN_URL_QQ));
            ((Activity) this.mWeakAct.get()).startActivity(intent);
        }
        QueuedWork.runInMain(new Runnable() {
            public void run() {
                uMShareListener.onError(SHARE_MEDIA.QQ, new Throwable(UmengErrorCode.NotInstall.getMessage()));
            }
        });
    }

    protected void onShareParamsError(final UMShareListener uMShareListener, final String str) {
        QueuedWork.runInMain(new Runnable() {
            public void run() {
                UMShareListener uMShareListener = uMShareListener;
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(UmengErrorCode.ShareDataTypeIllegal.getMessage());
                stringBuilder.append(str);
                uMShareListener.onError(share_media, new Throwable(stringBuilder.toString()));
            }
        });
    }

    protected Bundle buildShareContent(ShareContent shareContent) {
        shareContent = new QQShareContent(shareContent).buildParams(getShareConfig().isHideQzoneOnQQFriendList(), getShareConfig().getAppName());
        shareContent.putString("appName", getShareConfig().getAppName());
        return shareContent;
    }

    private IUiListener getSharelistener(final UMShareListener uMShareListener) {
        return new IUiListener() {
            public void onError(UiError uiError) {
                uiError = uiError == null ? "" : uiError.errorMessage;
                UMShareListener uMShareListener = uMShareListener;
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(UmengErrorCode.ShareFailed.getMessage());
                stringBuilder.append(uiError);
                uMShareListener.onError(share_media, new Throwable(stringBuilder.toString()));
            }

            public void onCancel() {
                uMShareListener.onCancel(SHARE_MEDIA.QQ);
            }

            public void onComplete(Object obj) {
                uMShareListener.onResult(SHARE_MEDIA.QQ);
            }
        };
    }

    public boolean isAuthorize() {
        return this.qqPreferences != null ? this.qqPreferences.isAuthValid() : false;
    }

    public void authorize(UMAuthListener uMAuthListener) {
        this.mAuthListener = uMAuthListener;
        loginDeal();
    }

    public void setAuthListener(UMAuthListener uMAuthListener) {
        super.setAuthListener(uMAuthListener);
        this.mAuthListener = uMAuthListener;
    }

    public boolean isHasAuthListener() {
        return this.mAuthListener != null;
    }

    protected IUiListener getAuthlistener(final UMAuthListener uMAuthListener) {
        return new IUiListener() {
            public void onError(UiError uiError) {
                if (uMAuthListener != null) {
                    UMAuthListener uMAuthListener = uMAuthListener;
                    SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.AuthorizeFailed.getMessage());
                    stringBuilder.append("==> errorCode = ");
                    stringBuilder.append(uiError.errorCode);
                    stringBuilder.append(", errorMsg = ");
                    stringBuilder.append(uiError.errorMessage);
                    stringBuilder.append(", detail = ");
                    stringBuilder.append(uiError.errorDetail);
                    uMAuthListener.onError(share_media, 0, new Throwable(stringBuilder.toString()));
                }
            }

            public void onCancel() {
                if (uMAuthListener != null) {
                    uMAuthListener.onCancel(SHARE_MEDIA.QQ, 0);
                }
            }

            public void onComplete(final Object obj) {
                SocializeUtils.safeCloseDialog(UMQQSsoHandler.this.mProgressDialog);
                final Bundle parseOauthData = UMQQSsoHandler.this.parseOauthData(obj);
                if (UMQQSsoHandler.this.qqPreferences == null && UMQQSsoHandler.this.getContext() != null) {
                    UMQQSsoHandler.this.qqPreferences = new QQPreferences(UMQQSsoHandler.this.getContext(), SHARE_MEDIA.QQ.toString());
                }
                if (UMQQSsoHandler.this.qqPreferences != null) {
                    UMQQSsoHandler.this.qqPreferences.setAuthData(parseOauthData).commit();
                }
                QueuedWork.runInBack(new Runnable() {
                    public void run() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("https://graph.qq.com/oauth2.0/me?access_token=");
                        stringBuilder.append(UMQQSsoHandler.this.getAccessToken(UMQQSsoHandler.this.qqPreferences));
                        stringBuilder.append("&unionid=1");
                        Object access$200 = UMQQSsoHandler.this.getUnionIdRequest(stringBuilder.toString());
                        if (!TextUtils.isEmpty(access$200)) {
                            try {
                                JSONObject jSONObject = new JSONObject(access$200.replace(a.c, "").replace(k.s, "").replace(k.t, ""));
                                String optString = jSONObject.optString("unionid");
                                UMQQSsoHandler.this.setmOpenid(jSONObject.optString("openid"));
                                UMQQSsoHandler.this.setUnionid(optString);
                                if (UMQQSsoHandler.this.qqPreferences != null) {
                                    UMQQSsoHandler.this.qqPreferences.commit();
                                }
                                access$200 = jSONObject.optString(XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2);
                                if (!TextUtils.isEmpty(access$200)) {
                                    Log.um(access$200);
                                }
                            } catch (JSONException e) {
                                Log.um(e.getMessage());
                                e.printStackTrace();
                            }
                        }
                        UMQQSsoHandler.this.initOpenidAndToken((JSONObject) obj);
                        final Map bundleTomap = SocializeUtils.bundleTomap(parseOauthData);
                        bundleTomap.put("unionid", UMQQSsoHandler.this.getUnionid(UMQQSsoHandler.this.qqPreferences));
                        if (uMAuthListener != null) {
                            QueuedWork.runInMain(new Runnable() {
                                public void run() {
                                    uMAuthListener.onComplete(SHARE_MEDIA.QQ, 0, bundleTomap);
                                }
                            });
                        }
                        UMQQSsoHandler.this.uploadAuthData(parseOauthData);
                    }
                }, true);
            }
        };
    }

    private void qqPreferencesDelete() {
        if (this.qqPreferences != null) {
            this.qqPreferences.delete();
        }
    }

    private void setUnionid(String str) {
        if (this.qqPreferences != null) {
            this.qqPreferences.setUnionid(str);
        }
    }

    private void setmOpenid(String str) {
        if (this.qqPreferences != null) {
            this.qqPreferences.setmOpenid(str);
        }
    }

    public boolean isInstall() {
        if (this.mTencent != null) {
            if (this.mTencent.isSupportSSOLogin((Activity) this.mWeakAct.get())) {
                return true;
            }
        }
        return false;
    }

    public boolean isSupport() {
        return this.mTencent.isSupportSSOLogin((Activity) this.mWeakAct.get());
    }

    public void deleteAuth(final UMAuthListener uMAuthListener) {
        this.mTencent.logout(getContext());
        qqPreferencesDelete();
        QueuedWork.runInMain(new Runnable() {
            public void run() {
                uMAuthListener.onComplete(SHARE_MEDIA.QQ, 1, null);
            }
        });
    }

    private void loginDeal() {
        if (!isInstall()) {
            this.mTencent.loginServerSide((Activity) this.mWeakAct.get(), "all", getAuthlistener(this.mAuthListener));
        } else if (!(this.mWeakAct.get() == null || ((Activity) this.mWeakAct.get()).isFinishing())) {
            this.mTencent.login((Activity) this.mWeakAct.get(), "all", getAuthlistener(this.mAuthListener));
        }
    }

    public void initOpenidAndToken(org.json.JSONObject r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = "access_token";	 Catch:{ Exception -> 0x002f }
        r0 = r4.getString(r0);	 Catch:{ Exception -> 0x002f }
        r1 = "expires_in";	 Catch:{ Exception -> 0x002f }
        r1 = r4.getString(r1);	 Catch:{ Exception -> 0x002f }
        r2 = "openid";	 Catch:{ Exception -> 0x002f }
        r4 = r4.getString(r2);	 Catch:{ Exception -> 0x002f }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x002f }
        if (r2 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x002f }
    L_0x0018:
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x002f }
        if (r2 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x002f }
    L_0x001e:
        r2 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x002f }
        if (r2 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x002f }
    L_0x0024:
        r2 = r3.mTencent;	 Catch:{ Exception -> 0x002f }
        r2.setAccessToken(r0, r1);	 Catch:{ Exception -> 0x002f }
        r0 = r3.mTencent;	 Catch:{ Exception -> 0x002f }
        r0.setOpenId(r4);	 Catch:{ Exception -> 0x002f }
    L_0x002e:
        return;
    L_0x002f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.handler.UMQQSsoHandler.initOpenidAndToken(org.json.JSONObject):void");
    }

    protected void shareToQQ(final Bundle bundle) {
        if (validTencent()) {
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    if (UMQQSsoHandler.this.mWeakAct.get() != null && !((Activity) UMQQSsoHandler.this.mWeakAct.get()).isFinishing()) {
                        UMQQSsoHandler.this.mTencent.shareToQQ((Activity) UMQQSsoHandler.this.mWeakAct.get(), bundle, UMQQSsoHandler.this.mShareListener);
                    }
                }
            });
        } else {
            this.mShareListener.onError(new UiError(-1, UmengText.QQ_ERROR, UmengText.QQ_ERROR));
        }
    }

    private String getUnionIdRequest(String str) {
        String str2 = "";
        try {
            str = new URL(str).openConnection();
            if (str == null) {
                return str2;
            }
            str.connect();
            str = str.getInputStream();
            if (str == null) {
                return str2;
            }
            return convertStreamToString(str);
        } catch (String str3) {
            str3.printStackTrace();
            return str2;
        }
    }

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(readLine);
                stringBuilder2.append("/n");
                stringBuilder.append(stringBuilder2.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (InputStream inputStream2) {
                    inputStream2.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 10103) {
            Tencent.onActivityResultData(i, i2, intent, this.mShareListener);
        }
        if (i == 11101) {
            Tencent.onActivityResultData(i, i2, intent, getAuthlistener(this.mAuthListener));
        }
    }

    private void fetchUserInfo(final UMAuthListener uMAuthListener) {
        Object accessToken = getAccessToken(this.qqPreferences);
        if (isValidAccessToken(accessToken)) {
            try {
                Object expiresIn = getExpiresIn(this.qqPreferences);
                Object openId = getOpenId(this.qqPreferences);
                if (!(TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(expiresIn) || TextUtils.isEmpty(openId))) {
                    this.mTencent.setAccessToken(accessToken, expiresIn);
                    this.mTencent.setOpenId(openId);
                }
                new UserInfo(getContext(), this.mTencent.getQQToken()).getUserInfo(getFetchUserInfoListener(uMAuthListener));
                return;
            } catch (final Exception e) {
                QueuedWork.runInMain(new Runnable() {
                    public void run() {
                        UMAuthListener uMAuthListener = uMAuthListener;
                        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(UmengErrorCode.RequestForUserProfileFailed.getMessage());
                        stringBuilder.append(e.getMessage());
                        uMAuthListener.onError(share_media, 2, new Throwable(stringBuilder.toString()));
                    }
                });
                return;
            }
        }
        QueuedWork.runInMain(new Runnable() {
            public void run() {
                UMAuthListener uMAuthListener = uMAuthListener;
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(UmengErrorCode.RequestForUserProfileFailed.getMessage());
                stringBuilder.append("token is invalid");
                uMAuthListener.onError(share_media, 2, new Throwable(stringBuilder.toString()));
            }
        });
    }

    public IUiListener getFetchUserInfoListener(final UMAuthListener uMAuthListener) {
        return new IUiListener() {
            public void onComplete(java.lang.Object r6) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r5 = this;
                r0 = r2;
                if (r0 != 0) goto L_0x0005;
            L_0x0004:
                return;
            L_0x0005:
                r0 = 2;
                r1 = com.umeng.socialize.handler.UMQQSsoHandler.this;	 Catch:{ JSONException -> 0x0048 }
                r6 = r6.toString();	 Catch:{ JSONException -> 0x0048 }
                r6 = r1.parseUserInfo(r6);	 Catch:{ JSONException -> 0x0048 }
                r1 = com.umeng.socialize.handler.UMQQSsoHandler.this;	 Catch:{ JSONException -> 0x0048 }
                r1.appendTokenToUserInfo(r6);	 Catch:{ JSONException -> 0x0048 }
                r1 = "ret";	 Catch:{ JSONException -> 0x0048 }
                r1 = r6.get(r1);	 Catch:{ JSONException -> 0x0048 }
                r1 = (java.lang.CharSequence) r1;	 Catch:{ JSONException -> 0x0048 }
                r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x0048 }
                if (r1 != 0) goto L_0x0040;	 Catch:{ JSONException -> 0x0048 }
            L_0x0023:
                r1 = "ret";	 Catch:{ JSONException -> 0x0048 }
                r1 = r6.get(r1);	 Catch:{ JSONException -> 0x0048 }
                r1 = (java.lang.String) r1;	 Catch:{ JSONException -> 0x0048 }
                r2 = "100030";	 Catch:{ JSONException -> 0x0048 }
                r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x0048 }
                if (r1 == 0) goto L_0x0040;	 Catch:{ JSONException -> 0x0048 }
            L_0x0033:
                r6 = com.umeng.socialize.handler.UMQQSsoHandler.this;	 Catch:{ JSONException -> 0x0048 }
                r6.qqPreferencesDelete();	 Catch:{ JSONException -> 0x0048 }
                r6 = com.umeng.socialize.handler.UMQQSsoHandler.this;	 Catch:{ JSONException -> 0x0048 }
                r1 = r2;	 Catch:{ JSONException -> 0x0048 }
                r6.authAndFetchUserInfo(r1);	 Catch:{ JSONException -> 0x0048 }
                return;	 Catch:{ JSONException -> 0x0048 }
            L_0x0040:
                r1 = r2;	 Catch:{ JSONException -> 0x0048 }
                r2 = com.umeng.socialize.bean.SHARE_MEDIA.QQ;	 Catch:{ JSONException -> 0x0048 }
                r1.onComplete(r2, r0, r6);	 Catch:{ JSONException -> 0x0048 }
                return;
            L_0x0048:
                r6 = r2;
                r1 = com.umeng.socialize.bean.SHARE_MEDIA.QQ;
                r2 = new java.lang.Throwable;
                r3 = new java.lang.StringBuilder;
                r3.<init>();
                r4 = com.umeng.socialize.bean.UmengErrorCode.RequestForUserProfileFailed;
                r4 = r4.getMessage();
                r3.append(r4);
                r4 = "parse json error";
                r3.append(r4);
                r3 = r3.toString();
                r2.<init>(r3);
                r6.onError(r1, r0, r2);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.handler.UMQQSsoHandler.10.onComplete(java.lang.Object):void");
            }

            public void onError(UiError uiError) {
                if (uMAuthListener != null) {
                    UMAuthListener uMAuthListener = uMAuthListener;
                    SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.RequestForUserProfileFailed.getMessage());
                    stringBuilder.append(uiError.errorMessage);
                    uMAuthListener.onError(share_media, 2, new Throwable(stringBuilder.toString()));
                }
            }

            public void onCancel() {
                if (uMAuthListener != null) {
                    uMAuthListener.onCancel(SHARE_MEDIA.QQ, 2);
                }
            }
        };
    }

    private void appendTokenToUserInfo(Map<String, String> map) {
        if (map != null) {
            String accessToken = getAccessToken(this.qqPreferences);
            String openId = getOpenId(this.qqPreferences);
            String expiresIn = getExpiresIn(this.qqPreferences);
            String unionid = getUnionid(this.qqPreferences);
            map.put("openid", openId);
            map.put("uid", openId);
            map.put("access_token", accessToken);
            map.put("expires_in", expiresIn);
            map.put("accessToken", accessToken);
            map.put("expiration", expiresIn);
            map.put("unionid", unionid);
        }
    }

    private Map<String, String> parseUserInfo(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        str = new HashMap();
        str.put("screen_name", jSONObject.optString("nickname"));
        str.put(c.e, jSONObject.optString("nickname"));
        str.put("gender", getGender(jSONObject.optString("gender")));
        str.put("profile_image_url", jSONObject.optString("figureurl_qq_2"));
        str.put("iconurl", jSONObject.optString("figureurl_qq_2"));
        str.put("is_yellow_year_vip", jSONObject.optString("is_yellow_year_vip"));
        str.put("yellow_vip_level", jSONObject.optString("yellow_vip_level"));
        str.put("msg", jSONObject.optString("msg"));
        str.put("city", jSONObject.optString("city"));
        str.put("vip", jSONObject.optString("vip"));
        str.put(KEYS.RET, jSONObject.optString(KEYS.RET));
        str.put("level", jSONObject.optString("level"));
        str.put("province", jSONObject.optString("province"));
        str.put("is_yellow_vip", jSONObject.optString("is_yellow_vip"));
        return str;
    }

    private boolean isValidAccessToken(String str) {
        return TextUtils.isEmpty(str) == null ? true : null;
    }

    private String getAccessToken(QQPreferences qQPreferences) {
        return qQPreferences != null ? qQPreferences.getmAccessToken() : null;
    }

    private String getUnionid(QQPreferences qQPreferences) {
        return qQPreferences != null ? qQPreferences.getUnionid() : null;
    }

    private String getOpenId(QQPreferences qQPreferences) {
        return qQPreferences != null ? qQPreferences.getmUID() : null;
    }

    private String getExpiresIn(QQPreferences qQPreferences) {
        if (qQPreferences == null) {
            return null;
        }
        qQPreferences = new StringBuilder();
        qQPreferences.append(QQPreferences.getExpiresIn());
        return qQPreferences.toString();
    }

    public void getPlatformInfo(UMAuthListener uMAuthListener) {
        if (!isAuthorize() || getShareConfig().isNeedAuthOnGetUserInfo()) {
            authAndFetchUserInfo(uMAuthListener);
        } else {
            fetchUserInfo(uMAuthListener);
        }
    }

    private void authAndFetchUserInfo(final UMAuthListener uMAuthListener) {
        authorize(new UMAuthListener() {
            public void onStart(SHARE_MEDIA share_media) {
            }

            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                UMQQSsoHandler.this.fetchUserInfo(uMAuthListener);
            }

            public void onError(SHARE_MEDIA share_media, int i, Throwable th) {
                uMAuthListener.onError(SHARE_MEDIA.QQ, 2, th);
            }

            public void onCancel(SHARE_MEDIA share_media, int i) {
                uMAuthListener.onCancel(SHARE_MEDIA.QQ, 2);
            }
        });
    }
}
