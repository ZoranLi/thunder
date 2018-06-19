package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alipay.sdk.cons.c;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.umeng.socialize.PlatformConfig.APPIDPlatform;
import com.umeng.socialize.PlatformConfig.Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.media.SinaShareContent;
import com.umeng.socialize.media.WBShareCallBackActivity;
import com.umeng.socialize.net.DeleteRequest;
import com.umeng.socialize.net.UserinfoRequest;
import com.umeng.socialize.net.UserinfoResponse;
import com.umeng.socialize.net.base.SocializeClient;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.util.Map;

public class SinaSsoHandler extends UMSSOHandler {
    private static final int REQUEST_CODE = 5659;
    private static final String REQUEST_USERINFO = "https://api.weibo.com/2/users/show.json";
    public static final String SCOPE = "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog,invitation_write";
    private static final String TAG = "SinaSsoHandler";
    private static final String USERNAME = "userName";
    protected String VERSION = "6.4.5";
    private APPIDPlatform config = null;
    private AuthInfo mAuthInfo;
    private AuthListener mAuthListener;
    private Context mContext;
    private SsoHandler mSsoHandler;
    private WeiboMultiMessage message;
    private WbShareHandler shareHandler;
    private UMShareListener shareListener;
    private SinaPreferences sinaPreferences;

    class AuthListener implements WbAuthListener {
        private UMAuthListener mListener = null;

        AuthListener(UMAuthListener uMAuthListener) {
            this.mListener = uMAuthListener;
        }

        public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
            oauth2AccessToken = SinaSsoHandler.this.tokenToBundle(oauth2AccessToken);
            SinaSsoHandler.this.setAuthData(oauth2AccessToken);
            SinaSsoHandler.this.uploadAuthData(oauth2AccessToken);
            if (this.mListener != null) {
                oauth2AccessToken.putString(c.e, oauth2AccessToken.getString(SinaSsoHandler.USERNAME));
                oauth2AccessToken.putString("accessToken", oauth2AccessToken.getString("access_token"));
                oauth2AccessToken.putString("refreshToken", oauth2AccessToken.getString(Oauth2AccessToken.KEY_REFRESH_TOKEN));
                oauth2AccessToken.putString("expiration", oauth2AccessToken.getString("expires_in"));
                this.mListener.onComplete(SHARE_MEDIA.SINA, 0, SocializeUtils.bundleTomap(oauth2AccessToken));
            }
        }

        public void cancel() {
            if (this.mListener != null) {
                this.mListener.onCancel(SHARE_MEDIA.SINA, 0);
            }
        }

        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            if (this.mListener != null) {
                UMAuthListener uMAuthListener = this.mListener;
                SHARE_MEDIA share_media = SHARE_MEDIA.SINA;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(UmengErrorCode.AuthorizeFailed.getMessage());
                stringBuilder.append(wbConnectErrorMessage.getErrorMessage());
                uMAuthListener.onError(share_media, 0, new Throwable(stringBuilder.toString()));
            }
        }
    }

    public int getRequestCode() {
        return 5659;
    }

    public String getSDKVersion() {
        return "3.1.4";
    }

    protected String getToName() {
        return "sina";
    }

    public boolean isSupport() {
        return true;
    }

    public boolean isSupportAuth() {
        return true;
    }

    public void onCreate(Context context, Platform platform) {
        super.onCreate(context, platform);
        this.mContext = context.getApplicationContext();
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) platform;
        this.config = aPPIDPlatform;
        this.sinaPreferences = new SinaPreferences(this.mContext, "sina");
        this.mAuthInfo = new AuthInfo(context, aPPIDPlatform.appId, ((APPIDPlatform) getConfig()).redirectUrl, SCOPE);
        if ((context instanceof Activity) != null) {
            WbSdk.install(context, this.mAuthInfo);
            Activity activity = (Activity) context;
            this.mSsoHandler = new SsoHandler(activity);
            this.shareHandler = new WbShareHandler(activity);
            this.shareHandler.registerApp();
            context = new StringBuilder("sina full version:");
            context.append(this.VERSION);
            Log.um(context.toString());
            context = TAG;
            platform = new StringBuilder("handleid=");
            platform.append(this);
            Log.e(context, platform.toString());
        }
    }

    public WbShareHandler getWbHandler() {
        return this.shareHandler;
    }

    public WeiboMultiMessage getMessage() {
        return this.message;
    }

    public boolean isInstall() {
        return isClientInstalled();
    }

    public boolean isAuthorize() {
        return this.sinaPreferences != null ? this.sinaPreferences.isAuthorized() : false;
    }

    private boolean isClientInstalled() {
        WbAppInfo wbAppInfo = WeiboAppManager.getInstance((Context) this.mWeakAct.get()).getWbAppInfo();
        return wbAppInfo != null && wbAppInfo.isLegal();
    }

    public void authorize(UMAuthListener uMAuthListener) {
        this.mAuthListener = new AuthListener(uMAuthListener);
        if (this.mSsoHandler != null) {
            if (getShareConfig().isSinaAuthWithWebView() != null) {
                this.mSsoHandler.authorizeWeb(this.mAuthListener);
                return;
            }
            this.mSsoHandler.authorize(this.mAuthListener);
        }
    }

    private void userinfo(final UMAuthListener uMAuthListener) {
        UserinfoResponse userinfoResponse = (UserinfoResponse) new SocializeClient().execute(new UserinfoRequest(getUID(), getmAccessToken(), this.config.appId));
        if (userinfoResponse != null) {
            final Map map = userinfoResponse.result;
            if (map != null && !map.containsKey("error")) {
                map.put("iconurl", map.get("profile_image_url"));
                map.put(c.e, map.get("screen_name"));
                map.put("gender", getGender(map.get("gender")));
                if (this.sinaPreferences != null) {
                    map.put("uid", this.sinaPreferences.getUID());
                    map.put("access_token", this.sinaPreferences.getmAccessToken());
                    map.put("refreshToken", this.sinaPreferences.getmRefreshToken());
                    map.put("expires_in", String.valueOf(this.sinaPreferences.getmTTL()));
                    map.put("accessToken", this.sinaPreferences.getmAccessToken());
                    map.put("refreshToken", this.sinaPreferences.getmRefreshToken());
                    map.put("expiration", String.valueOf(this.sinaPreferences.getmTTL()));
                    QueuedWork.runInMain(new Runnable() {
                        public void run() {
                            uMAuthListener.onComplete(SHARE_MEDIA.SINA, 2, map);
                        }
                    });
                    return;
                }
            } else if (map != null) {
                if (this.sinaPreferences != null) {
                    this.sinaPreferences.delete();
                }
                QueuedWork.runInMain(new Runnable() {
                    public void run() {
                        UMAuthListener uMAuthListener = uMAuthListener;
                        SHARE_MEDIA share_media = SHARE_MEDIA.SINA;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(UmengErrorCode.RequestForUserProfileFailed);
                        stringBuilder.append(((String) map.get("error")).toString());
                        uMAuthListener.onError(share_media, 2, new Throwable(stringBuilder.toString()));
                    }
                });
                return;
            } else {
                QueuedWork.runInMain(new Runnable() {
                    public void run() {
                        UMAuthListener uMAuthListener = uMAuthListener;
                        SHARE_MEDIA share_media = SHARE_MEDIA.SINA;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(UmengErrorCode.RequestForUserProfileFailed);
                        stringBuilder.append(UmengText.DATA_EMPTY);
                        uMAuthListener.onError(share_media, 2, new Throwable(stringBuilder.toString()));
                    }
                });
            }
            return;
        }
        QueuedWork.runInMain(new Runnable() {
            public void run() {
                UMAuthListener uMAuthListener = uMAuthListener;
                SHARE_MEDIA share_media = SHARE_MEDIA.SINA;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(UmengErrorCode.RequestForUserProfileFailed);
                stringBuilder.append(UmengText.SINA_GET_ERROR);
                uMAuthListener.onError(share_media, 2, new Throwable(stringBuilder.toString()));
            }
        });
    }

    public void getPlatformInfo(UMAuthListener uMAuthListener) {
        if (getShareConfig().isNeedAuthOnGetUserInfo() || !this.sinaPreferences.isAuthValid()) {
            authAndFetchUserInfo(uMAuthListener);
        } else {
            userinfo(uMAuthListener);
        }
    }

    private void authAndFetchUserInfo(final UMAuthListener uMAuthListener) {
        authorize(new UMAuthListener() {
            public void onStart(SHARE_MEDIA share_media) {
            }

            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                QueuedWork.runInBack(new Runnable() {
                    public void run() {
                        SinaSsoHandler.this.userinfo(uMAuthListener);
                    }
                }, 0);
            }

            public void onError(SHARE_MEDIA share_media, int i, Throwable th) {
                uMAuthListener.onError(share_media, i, th);
            }

            public void onCancel(SHARE_MEDIA share_media, int i) {
                uMAuthListener.onCancel(share_media, i);
            }
        });
    }

    private String getUID() {
        return this.sinaPreferences != null ? this.sinaPreferences.getUID() : "";
    }

    private String getmAccessToken() {
        return this.sinaPreferences != null ? this.sinaPreferences.getmAccessToken() : "";
    }

    public void deleteAuth(final UMAuthListener uMAuthListener) {
        URequest deleteRequest = new DeleteRequest(this.config.appId, getmAccessToken());
        if (this.sinaPreferences != null) {
            this.sinaPreferences.delete();
        }
        new SocializeClient().execute(deleteRequest);
        AccessTokenKeeper.clear(ContextUtil.getContext());
        if (this.sinaPreferences != null) {
            this.sinaPreferences.delete();
        }
        QueuedWork.runInMain(new Runnable() {
            public void run() {
                uMAuthListener.onComplete(SinaSsoHandler.this.getConfig().getName(), 1, null);
            }
        });
    }

    public boolean share(ShareContent shareContent, UMShareListener uMShareListener) {
        this.message = new SinaShareContent(shareContent).getMessage();
        this.shareListener = uMShareListener;
        if (this.mWeakAct.get() != null && ((Activity) this.mWeakAct.get()).isFinishing() == null) {
            ((Activity) this.mWeakAct.get()).startActivity(new Intent((Context) this.mWeakAct.get(), WBShareCallBackActivity.class));
        }
        return true;
    }

    private void setAuthData(Bundle bundle) {
        if (this.sinaPreferences != null) {
            this.sinaPreferences.setAuthData(bundle).commit();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mSsoHandler != null) {
            this.mSsoHandler.authorizeCallBack(i, i2, intent);
        }
        this.mSsoHandler = 0;
    }

    public void onSuccess() {
        if (this.shareListener != null) {
            this.shareListener.onResult(SHARE_MEDIA.SINA);
        }
    }

    public void onError() {
        if (this.shareListener != null) {
            this.shareListener.onError(SHARE_MEDIA.SINA, new Throwable(UmengErrorCode.ShareFailed.getMessage()));
        }
    }

    public void onCancel() {
        if (this.shareListener != null) {
            this.shareListener.onCancel(SHARE_MEDIA.SINA);
        }
    }

    private Bundle tokenToBundle(Oauth2AccessToken oauth2AccessToken) {
        Bundle bundle = new Bundle();
        bundle.putString(USERNAME, oauth2AccessToken.getUid());
        bundle.putString("uid", oauth2AccessToken.getUid());
        bundle.putString("access_token", oauth2AccessToken.getToken());
        bundle.putString(Oauth2AccessToken.KEY_REFRESH_TOKEN, oauth2AccessToken.getRefreshToken());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(oauth2AccessToken.getExpiresTime());
        bundle.putString("expires_in", stringBuilder.toString());
        return bundle;
    }

    public void release() {
        super.release();
        this.mSsoHandler = null;
    }
}
