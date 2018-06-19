package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig.Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.QZoneShareContent;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONObject;

public class QZoneSsoHandler extends UMTencentSSOHandler {
    private static final String TAG = "QZoneSsoHandler";
    private QZoneShareContent mShareContent;
    private QQPreferences qqPreferences;

    public int getRequestCode() {
        return 10104;
    }

    protected String getToName() {
        return Constants.SOURCE_QZONE;
    }

    public boolean isSupportAuth() {
        return true;
    }

    public void onCreate(Context context, Platform platform) {
        super.onCreate(context, platform);
        this.qqPreferences = new QQPreferences(context, SHARE_MEDIA.QQ.toString());
    }

    public boolean share(ShareContent shareContent, final UMShareListener uMShareListener) {
        if (uMShareListener != null) {
            this.mShareListener = uMShareListener;
        }
        if (this.mTencent == null) {
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    UMShareListener uMShareListener = uMShareListener;
                    SHARE_MEDIA share_media = SHARE_MEDIA.QZONE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.ShareFailed.getMessage());
                    stringBuilder.append(UmengText.tencentEmpty(Config.isUmengQQ.booleanValue()));
                    uMShareListener.onError(share_media, new Throwable(stringBuilder.toString()));
                }
            });
            return false;
        } else if (isInstall(getConfig())) {
            this.mShareContent = new QZoneShareContent(shareContent);
            shareToQZone();
            return false;
        } else {
            if (Config.isJumptoAppStore != null) {
                shareContent = new Intent("android.intent.action.VIEW");
                shareContent.setData(Uri.parse(SocializeConstants.DOWN_URL_QQ));
                ((Activity) this.mWeakAct.get()).startActivity(shareContent);
            }
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    uMShareListener.onError(SHARE_MEDIA.QQ, new Throwable(UmengErrorCode.NotInstall.getMessage()));
                }
            });
            return false;
        }
    }

    private void shareToQZone() {
        Bundle buildParamsQzone = this.mShareContent.buildParamsQzone();
        buildParamsQzone.putString("appName", getShareConfig().getAppName());
        if (this.mShareContent.getisPublish()) {
            doPublishToQzone(buildParamsQzone);
        } else {
            defaultQZoneShare(buildParamsQzone);
        }
    }

    public void deleteAuth(final UMAuthListener uMAuthListener) {
        this.mTencent.logout(getContext());
        if (this.qqPreferences != null) {
            this.qqPreferences.delete();
        }
        QueuedWork.runInMain(new Runnable() {
            public void run() {
                uMAuthListener.onComplete(SHARE_MEDIA.QZONE, 1, null);
            }
        });
    }

    private boolean isInstall(Platform platform) {
        return (this.mWeakAct.get() != null && ((Activity) this.mWeakAct.get()).isFinishing() == null && this.mTencent.isSupportSSOLogin((Activity) this.mWeakAct.get()) == null) ? null : true;
    }

    public void authorize(UMAuthListener uMAuthListener) {
        if (isInstall(getConfig())) {
            this.mAuthListener = uMAuthListener;
            loginDeal();
        }
    }

    private void loginDeal() {
        Log.i(TAG, "QQ oauth login...");
        if (this.mWeakAct.get() != null && !((Activity) this.mWeakAct.get()).isFinishing()) {
            this.mTencent.login((Activity) this.mWeakAct.get(), "all", getAuthlistener(this.mAuthListener));
        }
    }

    private IUiListener getAuthlistener(UMAuthListener uMAuthListener) {
        return new IUiListener() {
            public void onError(UiError uiError) {
                UMAuthListener uMAuthListener = QZoneSsoHandler.this.mAuthListener;
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(UmengErrorCode.AuthorizeFailed.getMessage());
                stringBuilder.append(" ==> errorCode = ");
                stringBuilder.append(uiError.errorCode);
                stringBuilder.append(", errorMsg = ");
                stringBuilder.append(uiError.errorMessage);
                stringBuilder.append(", detail = ");
                stringBuilder.append(uiError.errorDetail);
                uMAuthListener.onError(share_media, null, new Throwable(stringBuilder.toString()));
            }

            public void onCancel() {
                QZoneSsoHandler.this.mAuthListener.onCancel(SHARE_MEDIA.QQ, 0);
            }

            public void onComplete(Object obj) {
                SocializeUtils.safeCloseDialog(QZoneSsoHandler.this.mProgressDialog);
                Bundle parseOauthData = QZoneSsoHandler.this.parseOauthData(obj);
                QZoneSsoHandler.this.qqPreferences.setAuthData(parseOauthData).commit();
                QZoneSsoHandler.this.initOpenidAndToken((JSONObject) obj);
                if (QZoneSsoHandler.this.mAuthListener != null) {
                    QZoneSsoHandler.this.mAuthListener.onComplete(SHARE_MEDIA.QQ, 0, SocializeUtils.bundleTomap(parseOauthData));
                }
                QZoneSsoHandler.this.uploadAuthData(parseOauthData);
                if (parseOauthData != null && TextUtils.isEmpty(parseOauthData.getString(KEYS.RET)) == null) {
                }
            }
        };
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
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.handler.QZoneSsoHandler.initOpenidAndToken(org.json.JSONObject):void");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, getmShareListener(this.mShareListener));
        }
        if (i == 11101) {
            Tencent.onActivityResultData(i, i2, intent, getAuthlistener(this.mAuthListener));
        }
    }

    public IUiListener getmShareListener(final UMShareListener uMShareListener) {
        return new IUiListener() {
            public void onComplete(Object obj) {
                if (uMShareListener != null) {
                    uMShareListener.onResult(SHARE_MEDIA.QZONE);
                }
            }

            public void onError(UiError uiError) {
                if (uMShareListener != null) {
                    UMShareListener uMShareListener = uMShareListener;
                    SHARE_MEDIA share_media = SHARE_MEDIA.QZONE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.ShareFailed.getMessage());
                    stringBuilder.append(uiError.errorMessage);
                    uMShareListener.onError(share_media, new Throwable(stringBuilder.toString()));
                }
            }

            public void onCancel() {
                if (uMShareListener != null) {
                    uMShareListener.onCancel(SHARE_MEDIA.QZONE);
                }
            }
        };
    }

    private void doPublishToQzone(final Bundle bundle) {
        if (bundle != null) {
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    if (QZoneSsoHandler.this.mWeakAct.get() != null && !((Activity) QZoneSsoHandler.this.mWeakAct.get()).isFinishing()) {
                        QZoneSsoHandler.this.mTencent.publishToQzone((Activity) QZoneSsoHandler.this.mWeakAct.get(), bundle, QZoneSsoHandler.this.getmShareListener(QZoneSsoHandler.this.mShareListener));
                    }
                }
            });
        }
    }

    private void defaultQZoneShare(final Bundle bundle) {
        if (bundle != null) {
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    if (QZoneSsoHandler.this.mWeakAct.get() != null && !((Activity) QZoneSsoHandler.this.mWeakAct.get()).isFinishing()) {
                        QZoneSsoHandler.this.mTencent.shareToQzone((Activity) QZoneSsoHandler.this.mWeakAct.get(), bundle, QZoneSsoHandler.this.getmShareListener(QZoneSsoHandler.this.mShareListener));
                    }
                }
            });
        }
    }
}
