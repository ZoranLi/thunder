package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.QueuedWork.DialogThread;
import com.umeng.socialize.common.QueuedWork.UMAsyncTask;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.controller.SocialRouter;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.ActionBarRequest;
import com.umeng.socialize.net.ActionBarResponse;
import com.umeng.socialize.net.RestAPI;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.uploadlog.UMLog;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.SocializeSpUtils;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public class UMShareAPI {
    private static UMShareAPI singleton;
    private UMShareConfig mDefaultShareConfig = new UMShareConfig();
    private SocialRouter router;

    private static class InitThread extends UMAsyncTask<Void> {
        private boolean isToday = false;
        private Context mContext;

        public InitThread(Context context) {
            this.mContext = context;
            Object uMId = SocializeSpUtils.getUMId(context);
            if (!TextUtils.isEmpty(uMId)) {
                Config.UID = uMId;
            }
            uMId = SocializeSpUtils.getUMEk(context);
            if (!TextUtils.isEmpty(uMId)) {
                Config.EntityKey = uMId;
            }
            this.isToday = SocializeUtils.isToday(SocializeSpUtils.getTime(context));
        }

        protected Void doInBackground() {
            boolean isNewInstall = isNewInstall();
            Log.y("----sdkversion:6.4.5---\n 如有任何错误，请开启debug模式:在设置各平台APPID的地方添加代码：Config.DEBUG = true\n所有编译问题或者设置问题，请参考文档：https://at.umeng.com/0fqeCy?cid=476");
            if (TextUtils.isEmpty(Config.EntityKey) || TextUtils.isEmpty(Config.UID) || !this.isToday) {
                ActionBarResponse queryShareId = RestAPI.queryShareId(new ActionBarRequest(this.mContext, isNewInstall));
                if (queryShareId != null && queryShareId.isOk()) {
                    setInstalled();
                    Config.EntityKey = queryShareId.mEntityKey;
                    Config.SessionId = queryShareId.mSid;
                    Config.UID = queryShareId.mUid;
                    SocializeSpUtils.putUMId(this.mContext, Config.UID);
                    SocializeSpUtils.putUMEk(this.mContext, Config.EntityKey);
                    SocializeSpUtils.putTime(this.mContext);
                }
            }
            SocialAnalytics.dauStats(this.mContext, isNewInstall);
            return null;
        }

        private boolean isNewInstall() {
            return this.mContext.getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).getBoolean("newinstall", false);
        }

        public void setInstalled() {
            Editor edit = this.mContext.getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).edit();
            edit.putBoolean("newinstall", true);
            edit.commit();
        }
    }

    private UMShareAPI(Context context) {
        ContextUtil.setContext(context.getApplicationContext());
        this.router = new SocialRouter(context.getApplicationContext());
        new InitThread(context.getApplicationContext()).execute();
    }

    public static UMShareAPI get(Context context) {
        if (singleton == null || singleton.router == null) {
            singleton = new UMShareAPI(context);
        }
        singleton.router.setmContext(context);
        return singleton;
    }

    public static void init(Context context, String str) {
        SocializeConstants.APPKEY = str;
        get(context);
    }

    public void doOauthVerify(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        UMLog.putAuth();
        singleton.router.setmContext(activity);
        if (Config.DEBUG && !judgePlatform(activity, share_media)) {
            return;
        }
        if (activity != null) {
            final Activity activity2 = activity;
            final SHARE_MEDIA share_media2 = share_media;
            final UMAuthListener uMAuthListener2 = uMAuthListener;
            new DialogThread<Void>(activity) {
                protected Void doInBackground() {
                    if (UMShareAPI.this.router == null) {
                        UMShareAPI.this.router = new SocialRouter(activity2);
                    }
                    UMShareAPI.this.router.doOauthVerify(activity2, share_media2, uMAuthListener2);
                    return null;
                }
            }.execute();
            return;
        }
        Log.d("UMerror", "doOauthVerify activity is null");
    }

    public void deleteOauth(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        if (activity != null) {
            singleton.router.setmContext(activity);
            final Activity activity2 = activity;
            final SHARE_MEDIA share_media2 = share_media;
            final UMAuthListener uMAuthListener2 = uMAuthListener;
            new DialogThread<Void>(activity) {
                protected Object doInBackground() {
                    if (UMShareAPI.this.router != null) {
                        UMShareAPI.this.router.deleteOauth(activity2, share_media2, uMAuthListener2);
                    }
                    return null;
                }
            }.execute();
            return;
        }
        Log.d("UMerror", "deleteOauth activity is null");
    }

    public void getPlatformInfo(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        if (activity != null) {
            UMLog.putAuth();
            if (Config.DEBUG) {
                if (judgePlatform(activity, share_media)) {
                    UrlUtil.getInfoPrint(share_media);
                } else {
                    return;
                }
            }
            singleton.router.setmContext(activity);
            final Activity activity2 = activity;
            final SHARE_MEDIA share_media2 = share_media;
            final UMAuthListener uMAuthListener2 = uMAuthListener;
            new DialogThread<Void>(activity) {
                protected Object doInBackground() {
                    if (UMShareAPI.this.router != null) {
                        UMShareAPI.this.router.getPlatformInfo(activity2, share_media2, uMAuthListener2);
                    }
                    return null;
                }
            }.execute();
            return;
        }
        Log.d("UMerror", "getPlatformInfo activity argument is null");
    }

    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        if (this.router != null) {
            return this.router.isInstall(activity, share_media);
        }
        this.router = new SocialRouter(activity);
        return this.router.isInstall(activity, share_media);
    }

    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        if (this.router != null) {
            return this.router.isAuthorize(activity, share_media);
        }
        this.router = new SocialRouter(activity);
        return this.router.isAuthorize(activity, share_media);
    }

    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        if (this.router != null) {
            return this.router.isSupport(activity, share_media);
        }
        this.router = new SocialRouter(activity);
        return this.router.isSupport(activity, share_media);
    }

    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        if (this.router != null) {
            return this.router.getSDKVersion(activity, share_media);
        }
        this.router = new SocialRouter(activity);
        return this.router.getSDKVersion(activity, share_media);
    }

    public void doShare(Activity activity, ShareAction shareAction, UMShareListener uMShareListener) {
        UMLog.putShare();
        final WeakReference weakReference = new WeakReference(activity);
        if (Config.DEBUG) {
            if (judgePlatform(activity, shareAction.getPlatform())) {
                UrlUtil.sharePrint(shareAction.getPlatform());
            } else {
                return;
            }
        }
        if (weakReference.get() == null || ((Activity) weakReference.get()).isFinishing()) {
            Log.d("UMerror", "Share activity is null");
            return;
        }
        singleton.router.setmContext(activity);
        final ShareAction shareAction2 = shareAction;
        final UMShareListener uMShareListener2 = uMShareListener;
        new DialogThread<Void>((Context) weakReference.get()) {
            protected Void doInBackground() {
                if (weakReference.get() != null) {
                    if (!((Activity) weakReference.get()).isFinishing()) {
                        if (UMShareAPI.this.router != null) {
                            UMShareAPI.this.router.share((Activity) weakReference.get(), shareAction2, uMShareListener2);
                        } else {
                            UMShareAPI.this.router = new SocialRouter((Context) weakReference.get());
                            UMShareAPI.this.router.share((Activity) weakReference.get(), shareAction2, uMShareListener2);
                        }
                        return null;
                    }
                }
                return null;
            }
        }.execute();
    }

    private boolean judgePlatform(Activity activity, SHARE_MEDIA share_media) {
        Method[] declaredMethods = activity.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            if (declaredMethods[i].getName().equals("onActivityResult")) {
                i2 = true;
            }
            i++;
        }
        if (i2 == 0) {
            Log.url("您的activity中没有重写onActivityResult方法", UrlUtil.ALL_NO_ONACTIVITY);
        }
        if (share_media == SHARE_MEDIA.QQ) {
            share_media = UmengTool.checkQQByself(activity);
            if (share_media.contains("没有")) {
                if (share_media.contains("没有在AndroidManifest.xml中检测到")) {
                    UmengTool.showDialogWithURl(activity, share_media, UrlUtil.QQ_TENCENT_INITFAIL);
                } else if (share_media.contains(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
                    UmengTool.showDialogWithURl(activity, share_media, UrlUtil.QQ_SHARE_FAIL);
                } else if (share_media.contains("qq应用id")) {
                    UmengTool.showDialogWithURl(activity, share_media, UrlUtil.QQ_SHARESUCCESS_CANCEL);
                } else if (share_media.contains("qq的id配置")) {
                    UmengTool.showDialogWithURl(activity, share_media, UrlUtil.ALL_NO_CONFIG);
                } else {
                    UmengTool.showDialog(activity, share_media);
                }
                return false;
            }
            Log.um(UmengTool.checkQQByself(activity));
            return true;
        } else if (share_media == SHARE_MEDIA.WEIXIN) {
            share_media = UmengTool.checkWxBySelf(activity);
            if (share_media.contains("不正确")) {
                if (share_media.contains("WXEntryActivity配置不正确")) {
                    UmengTool.showDialogWithURl(activity, share_media, UrlUtil.WX_NO_CALLBACK);
                } else {
                    UmengTool.showDialog(activity, share_media);
                }
                UmengTool.checkWx(activity);
                return false;
            }
            Log.um(UmengTool.checkWxBySelf(activity));
            return true;
        } else if (share_media == SHARE_MEDIA.SINA) {
            if (UmengTool.checkSinaBySelf(activity).contains("不正确") != null) {
                UmengTool.checkSina(activity);
                return false;
            }
            Log.um(UmengTool.checkSinaBySelf(activity));
            return true;
        } else if (share_media != SHARE_MEDIA.FACEBOOK) {
            if (share_media == SHARE_MEDIA.VKONTAKTE) {
                Log.um(UmengTool.checkVKByself(activity));
            }
            if (share_media == SHARE_MEDIA.LINKEDIN) {
                Log.um(UmengTool.checkLinkin(activity));
            }
            if (share_media == SHARE_MEDIA.KAKAO) {
                Log.um(UmengTool.checkKakao(activity));
            }
            return true;
        } else if (UmengTool.checkFBByself(activity).contains("没有") != null) {
            UmengTool.checkFacebook(activity);
            return false;
        } else {
            Log.um(UmengTool.checkFBByself(activity));
            return true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.router != null) {
            this.router.onActivityResult(i, i2, intent);
        } else {
            Log.v("auth fail", "router=null");
        }
        intent = new StringBuilder("onActivityResult =");
        intent.append(i);
        intent.append("  resultCode=");
        intent.append(i2);
        Log.um(intent.toString());
    }

    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        return this.router != null ? this.router.getHandler(share_media) : null;
    }

    public void release() {
        this.router.release();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.router.onSaveInstanceState(bundle);
    }

    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        this.router.fetchAuthResultWithBundle(activity, bundle, uMAuthListener);
    }

    public void setShareConfig(UMShareConfig uMShareConfig) {
        this.router.setShareConfig(uMShareConfig);
    }
}
