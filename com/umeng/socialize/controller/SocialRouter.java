package com.umeng.socialize.controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.PlatformConfig.Platform;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.handler.UMMoreHandler;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class SocialRouter {
    private static final String BUNDLE_KEY_ACTION = "share_action";
    private static final String BUNDLE_KEY_AUTH_PLATFORM = "umeng_share_platform";
    private String APIVERSION = "6.4.5";
    private ParamsGuard guard;
    private SparseArray<UMAuthListener> mAuthListenerContainer;
    private SHARE_MEDIA mAuthPlatform;
    private Context mContext;
    private SparseArray<UMAuthListener> mFetchUserInfoListenerContainer;
    private SparseArray<UMShareListener> mShareListenerContainer;
    private final Map<SHARE_MEDIA, UMSSOHandler> platformHandlers = new HashMap();
    private final List<Pair<SHARE_MEDIA, String>> supportedPlatform = new ArrayList();

    static class ParamsGuard {
        private Map<SHARE_MEDIA, UMSSOHandler> handlers;

        public ParamsGuard(Map<SHARE_MEDIA, UMSSOHandler> map) {
            this.handlers = map;
        }

        public boolean auth(Context context, SHARE_MEDIA share_media) {
            if (checkContext(context) == null || checkPlatformConfig(share_media) == null) {
                return false;
            }
            if (((UMSSOHandler) this.handlers.get(share_media)).isSupportAuth() != null) {
                return true;
            }
            context = new StringBuilder();
            context.append(share_media.toString());
            context.append(UmengText.NOT_SUPPORT_PLATFROM);
            Log.w(context.toString());
            return false;
        }

        public boolean share(ShareAction shareAction) {
            shareAction = shareAction.getPlatform();
            if (shareAction == null) {
                return false;
            }
            if ((shareAction == SHARE_MEDIA.SINA || shareAction == SHARE_MEDIA.QQ || shareAction == SHARE_MEDIA.WEIXIN) && !((Platform) PlatformConfig.configs.get(shareAction)).isConfigured()) {
                Log.um(UmengText.errorWithUrl(UmengText.noKey(shareAction), UrlUtil.ALL_NO_CONFIG));
                return false;
            } else if (checkPlatformConfig(shareAction) == null) {
                return false;
            } else {
                return true;
            }
        }

        private boolean checkContext(Context context) {
            if (context != null) {
                return true;
            }
            Log.e("Context is null");
            return null;
        }

        private boolean checkPlatformConfig(SHARE_MEDIA share_media) {
            PlatformConfig.configs.get(share_media);
            if (((UMSSOHandler) this.handlers.get(share_media)) != null) {
                return true;
            }
            Log.url(UmengText.noJar(share_media), UrlUtil.ALL_NO_JAR);
            return null;
        }
    }

    public final void setmContext(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public SocialRouter(Context context) {
        List list = this.supportedPlatform;
        list.add(new Pair(SHARE_MEDIA.LAIWANG, "com.umeng.socialize.handler.UMLWHandler"));
        list.add(new Pair(SHARE_MEDIA.LAIWANG_DYNAMIC, "com.umeng.socialize.handler.UMLWHandler"));
        list.add(new Pair(SHARE_MEDIA.SINA, "com.umeng.socialize.handler.SinaSimplyHandler"));
        list.add(new Pair(SHARE_MEDIA.PINTEREST, "com.umeng.socialize.handler.UMPinterestHandler"));
        list.add(new Pair(SHARE_MEDIA.QZONE, "com.umeng.qq.handler.UmengQZoneHandler"));
        list.add(new Pair(SHARE_MEDIA.QQ, "com.umeng.qq.handler.UmengQQHandler"));
        list.add(new Pair(SHARE_MEDIA.RENREN, "com.umeng.socialize.handler.RenrenSsoHandler"));
        list.add(new Pair(SHARE_MEDIA.TENCENT, "com.umeng.socialize.handler.TencentWBSsoHandler"));
        list.add(new Pair(SHARE_MEDIA.WEIXIN, "com.umeng.weixin.handler.UmengWXHandler"));
        list.add(new Pair(SHARE_MEDIA.WEIXIN_CIRCLE, "com.umeng.weixin.handler.UmengWXHandler"));
        list.add(new Pair(SHARE_MEDIA.WEIXIN_FAVORITE, "com.umeng.weixin.handler.UmengWXHandler"));
        list.add(new Pair(SHARE_MEDIA.YIXIN, "com.umeng.socialize.handler.UMYXHandler"));
        list.add(new Pair(SHARE_MEDIA.YIXIN_CIRCLE, "com.umeng.socialize.handler.UMYXHandler"));
        list.add(new Pair(SHARE_MEDIA.EMAIL, "com.umeng.socialize.handler.EmailHandler"));
        list.add(new Pair(SHARE_MEDIA.EVERNOTE, "com.umeng.socialize.handler.UMEvernoteHandler"));
        list.add(new Pair(SHARE_MEDIA.FACEBOOK, "com.umeng.socialize.handler.UMFacebookHandler"));
        list.add(new Pair(SHARE_MEDIA.FACEBOOK_MESSAGER, "com.umeng.socialize.handler.UMFacebookHandler"));
        list.add(new Pair(SHARE_MEDIA.FLICKR, "com.umeng.socialize.handler.UMFlickrHandler"));
        list.add(new Pair(SHARE_MEDIA.FOURSQUARE, "com.umeng.socialize.handler.UMFourSquareHandler"));
        list.add(new Pair(SHARE_MEDIA.GOOGLEPLUS, "com.umeng.socialize.handler.UMGooglePlusHandler"));
        list.add(new Pair(SHARE_MEDIA.INSTAGRAM, "com.umeng.socialize.handler.UMInstagramHandler"));
        list.add(new Pair(SHARE_MEDIA.KAKAO, "com.umeng.socialize.handler.UMKakaoHandler"));
        list.add(new Pair(SHARE_MEDIA.LINE, "com.umeng.socialize.handler.UMLineHandler"));
        list.add(new Pair(SHARE_MEDIA.LINKEDIN, "com.umeng.socialize.handler.UMLinkedInHandler"));
        list.add(new Pair(SHARE_MEDIA.POCKET, "com.umeng.socialize.handler.UMPocketHandler"));
        list.add(new Pair(SHARE_MEDIA.WHATSAPP, "com.umeng.socialize.handler.UMWhatsAppHandler"));
        list.add(new Pair(SHARE_MEDIA.YNOTE, "com.umeng.socialize.handler.UMYNoteHandler"));
        list.add(new Pair(SHARE_MEDIA.SMS, "com.umeng.socialize.handler.SmsHandler"));
        list.add(new Pair(SHARE_MEDIA.DOUBAN, "com.umeng.socialize.handler.DoubanHandler"));
        list.add(new Pair(SHARE_MEDIA.TUMBLR, "com.umeng.socialize.handler.UMTumblrHandler"));
        list.add(new Pair(SHARE_MEDIA.TWITTER, "com.umeng.socialize.handler.TwitterHandler"));
        list.add(new Pair(SHARE_MEDIA.ALIPAY, "com.umeng.socialize.handler.AlipayHandler"));
        list.add(new Pair(SHARE_MEDIA.MORE, "com.umeng.socialize.handler.UMMoreHandler"));
        list.add(new Pair(SHARE_MEDIA.DINGTALK, "com.umeng.socialize.handler.UMDingSSoHandler"));
        list.add(new Pair(SHARE_MEDIA.VKONTAKTE, "com.umeng.socialize.handler.UMVKHandler"));
        list.add(new Pair(SHARE_MEDIA.DROPBOX, "com.umeng.socialize.handler.UMDropBoxHandler"));
        this.guard = new ParamsGuard(this.platformHandlers);
        this.mContext = null;
        this.mAuthListenerContainer = new SparseArray();
        this.mShareListenerContainer = new SparseArray();
        this.mFetchUserInfoListenerContainer = new SparseArray();
        this.mContext = context;
        init();
    }

    private void checkAppkey(Context context) {
        context = SocializeUtils.getAppkey(context);
        if (TextUtils.isEmpty(context)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.APPKEY_NOT_FOUND, UrlUtil.ALL_NO_APPKEY));
        } else if (SocializeNetUtils.isConSpeCharacters(context)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        } else if (SocializeNetUtils.isSelfAppkey(context) != null) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        }
    }

    private void init() {
        for (Pair pair : this.supportedPlatform) {
            Object obj;
            if (pair.first != SHARE_MEDIA.WEIXIN_CIRCLE) {
                if (pair.first != SHARE_MEDIA.WEIXIN_FAVORITE) {
                    if (pair.first == SHARE_MEDIA.FACEBOOK_MESSAGER) {
                        obj = (UMSSOHandler) this.platformHandlers.get(SHARE_MEDIA.FACEBOOK);
                    } else if (pair.first == SHARE_MEDIA.YIXIN_CIRCLE) {
                        obj = (UMSSOHandler) this.platformHandlers.get(SHARE_MEDIA.YIXIN);
                    } else if (pair.first == SHARE_MEDIA.LAIWANG_DYNAMIC) {
                        obj = (UMSSOHandler) this.platformHandlers.get(SHARE_MEDIA.LAIWANG);
                    } else {
                        if (pair.first != SHARE_MEDIA.TENCENT) {
                            if (pair.first == SHARE_MEDIA.MORE) {
                                obj = new UMMoreHandler();
                            } else if (pair.first == SHARE_MEDIA.SINA) {
                                if (!Config.isUmengSina.booleanValue()) {
                                    obj = newHandler("com.umeng.socialize.handler.SinaSsoHandler");
                                }
                            } else if (pair.first == SHARE_MEDIA.WEIXIN) {
                                if (!Config.isUmengWx.booleanValue()) {
                                    obj = newHandler("com.umeng.socialize.handler.UMWXHandler");
                                }
                            } else if (pair.first == SHARE_MEDIA.QQ) {
                                if (!Config.isUmengQQ.booleanValue()) {
                                    obj = newHandler("com.umeng.socialize.handler.UMQQSsoHandler");
                                }
                            } else if (pair.first == SHARE_MEDIA.QZONE && !Config.isUmengQQ.booleanValue()) {
                                obj = newHandler("com.umeng.socialize.handler.QZoneSsoHandler");
                            }
                        }
                        obj = newHandler((String) pair.second);
                    }
                    this.platformHandlers.put(pair.first, obj);
                }
            }
            obj = (UMSSOHandler) this.platformHandlers.get(SHARE_MEDIA.WEIXIN);
            this.platformHandlers.put(pair.first, obj);
        }
    }

    private com.umeng.socialize.handler.UMSSOHandler newHandler(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = 0;
        r1 = java.lang.Class.forName(r4);	 Catch:{ Exception -> 0x000c }
        r1 = r1.newInstance();	 Catch:{ Exception -> 0x000c }
        r1 = (com.umeng.socialize.handler.UMSSOHandler) r1;	 Catch:{ Exception -> 0x000c }
        r0 = r1;
    L_0x000c:
        if (r0 != 0) goto L_0x0053;
    L_0x000e:
        r1 = "SinaSimplyHandler";
        r1 = r4.contains(r1);
        r2 = 0;
        if (r1 == 0) goto L_0x0020;
    L_0x0017:
        r4 = java.lang.Boolean.valueOf(r2);
        com.umeng.socialize.Config.isUmengSina = r4;
        r4 = "com.umeng.socialize.handler.SinaSsoHandler";
        goto L_0x0000;
    L_0x0020:
        r1 = "UmengQQHandler";
        r1 = r4.contains(r1);
        if (r1 == 0) goto L_0x0031;
    L_0x0028:
        r4 = java.lang.Boolean.valueOf(r2);
        com.umeng.socialize.Config.isUmengQQ = r4;
        r4 = "com.umeng.socialize.handler.UMQQSsoHandler";
        goto L_0x0000;
    L_0x0031:
        r1 = "UmengQZoneHandler";
        r1 = r4.contains(r1);
        if (r1 == 0) goto L_0x0042;
    L_0x0039:
        r4 = java.lang.Boolean.valueOf(r2);
        com.umeng.socialize.Config.isUmengQQ = r4;
        r4 = "com.umeng.socialize.handler.QZoneSsoHandler";
        goto L_0x0000;
    L_0x0042:
        r1 = "UmengWXHandler";
        r4 = r4.contains(r1);
        if (r4 == 0) goto L_0x0053;
    L_0x004a:
        r4 = java.lang.Boolean.valueOf(r2);
        com.umeng.socialize.Config.isUmengWx = r4;
        r4 = "com.umeng.socialize.handler.UMWXHandler";
        goto L_0x0000;
    L_0x0053:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.controller.SocialRouter.newHandler(java.lang.String):com.umeng.socialize.handler.UMSSOHandler");
    }

    public final UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        UMSSOHandler uMSSOHandler = (UMSSOHandler) this.platformHandlers.get(share_media);
        if (uMSSOHandler != null) {
            uMSSOHandler.onCreate(this.mContext, PlatformConfig.getPlatform(share_media));
        }
        return uMSSOHandler;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        UMSSOHandler handler = getHandler(i);
        if (handler != null) {
            handler.onActivityResult(i, i2, intent);
        }
    }

    @Deprecated
    public final void onCreate(Activity activity, int i, UMAuthListener uMAuthListener) {
        UMSSOHandler handler = getHandler(i);
        if (handler == null) {
            return;
        }
        if (i == 10103 || i == 11101) {
            handler.onCreate(activity, PlatformConfig.getPlatform(getShareMediaByrequestCode(i)));
            setAuthListener(SHARE_MEDIA.QQ, uMAuthListener, handler, String.valueOf(System.currentTimeMillis()));
        }
    }

    private UMSSOHandler getHandler(int i) {
        int i2 = 10103;
        if (i != 10103) {
            if (i != 11101) {
                i2 = i;
            }
        }
        if (i == HandlerRequestCode.FACEBOOK_REQUEST_SHARE_CODE || i == HandlerRequestCode.FACEBOOK_REQUEST_AUTH_CODE || i == HandlerRequestCode.FACEBOOK_REQUEST_SHARE_MESSAGE_CODE) {
            i2 = 64206;
        }
        if (i == 32973 || i == 765) {
            i2 = 5659;
        }
        if (i == HandlerRequestCode.SINASSO_REQUEST_CODE) {
            i2 = 5659;
        }
        for (UMSSOHandler uMSSOHandler : this.platformHandlers.values()) {
            if (uMSSOHandler != null && r0 == uMSSOHandler.getRequestCode()) {
                return uMSSOHandler;
            }
        }
        return 0;
    }

    public final SHARE_MEDIA getShareMediaByrequestCode(int i) {
        if (i != 10103) {
            if (i != 11101) {
                if (i != 32973) {
                    if (i != 765) {
                        return SHARE_MEDIA.QQ;
                    }
                }
                return SHARE_MEDIA.SINA;
            }
        }
        return SHARE_MEDIA.QQ;
    }

    public final void deleteOauth(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        if (this.guard.auth(activity, share_media)) {
            if (uMAuthListener == null) {
                uMAuthListener = new UMAuthListener() {
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                    }

                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                    }

                    public void onError(SHARE_MEDIA share_media, int i, Throwable th) {
                    }

                    public void onStart(SHARE_MEDIA share_media) {
                    }
                };
            }
            ((UMSSOHandler) this.platformHandlers.get(share_media)).onCreate(activity, PlatformConfig.getPlatform(share_media));
            ((UMSSOHandler) this.platformHandlers.get(share_media)).deleteAuth(uMAuthListener);
        }
    }

    public final void getPlatformInfo(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.guard.auth(activity, share_media)) {
            UMSSOHandler uMSSOHandler = (UMSSOHandler) this.platformHandlers.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.getInfostart(ContextUtil.getContext(), share_media, uMSSOHandler.getSDKVersion(), valueOf);
            }
            final int ordinal = share_media.ordinal();
            saveFetchUserInfoListener(ordinal, uMAuthListener);
            UMAuthListener anonymousClass2 = new UMAuthListener() {
                public void onStart(SHARE_MEDIA share_media) {
                    UMAuthListener access$000 = SocialRouter.this.getAndRemoveFetchUserInfoListener(ordinal);
                    if (access$000 != null) {
                        access$000.onStart(share_media);
                    }
                }

                public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                    UMAuthListener access$000 = SocialRouter.this.getAndRemoveFetchUserInfoListener(ordinal);
                    if (access$000 != null) {
                        access$000.onComplete(share_media, i, map);
                    }
                    if (ContextUtil.getContext() != 0) {
                        SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media.toString().toLowerCase(), "success", "", valueOf);
                    }
                }

                public void onError(SHARE_MEDIA share_media, int i, Throwable th) {
                    UMAuthListener access$000 = SocialRouter.this.getAndRemoveFetchUserInfoListener(ordinal);
                    if (access$000 != null) {
                        access$000.onError(share_media, i, th);
                    }
                    if (th != null) {
                        Log.toast(activity, UmengText.AUTH_FAIL_LOG);
                        Log.um(th.getMessage());
                        i = new StringBuilder();
                        i.append(UmengText.SOLVE);
                        i.append(UrlUtil.ALL_AUTHFAIL);
                        Log.um(i.toString());
                    } else {
                        Log.um("null");
                    }
                    if (ContextUtil.getContext() != 0 && th != null) {
                        SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media.toString().toLowerCase(), "fail", th.getMessage(), valueOf);
                    }
                }

                public void onCancel(SHARE_MEDIA share_media, int i) {
                    UMAuthListener access$000 = SocialRouter.this.getAndRemoveFetchUserInfoListener(ordinal);
                    if (access$000 != null) {
                        access$000.onCancel(share_media, i);
                    }
                    if (ContextUtil.getContext() != 0) {
                        SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media.toString().toLowerCase(), "cancel", "", valueOf);
                    }
                }
            };
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    uMAuthListener.onStart(share_media);
                }
            });
            uMSSOHandler.getPlatformInfo(anonymousClass2);
        }
    }

    public final boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        if (!this.guard.auth(activity, share_media)) {
            return null;
        }
        ((UMSSOHandler) this.platformHandlers.get(share_media)).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return ((UMSSOHandler) this.platformHandlers.get(share_media)).isInstall();
    }

    public final boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        if (!this.guard.auth(activity, share_media)) {
            return null;
        }
        ((UMSSOHandler) this.platformHandlers.get(share_media)).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return ((UMSSOHandler) this.platformHandlers.get(share_media)).isSupport();
    }

    public final String getSDKVersion(Activity activity, SHARE_MEDIA share_media) {
        if (!this.guard.auth(activity, share_media)) {
            return "";
        }
        ((UMSSOHandler) this.platformHandlers.get(share_media)).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return ((UMSSOHandler) this.platformHandlers.get(share_media)).getSDKVersion();
    }

    public final boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        if (!this.guard.auth(activity, share_media)) {
            return null;
        }
        ((UMSSOHandler) this.platformHandlers.get(share_media)).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return ((UMSSOHandler) this.platformHandlers.get(share_media)).isAuthorize();
    }

    public final void doOauthVerify(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.guard.auth(activity, share_media)) {
            UMSSOHandler uMSSOHandler = (UMSSOHandler) this.platformHandlers.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            activity = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.authstart(ContextUtil.getContext(), share_media, uMSSOHandler.getSDKVersion(), uMSSOHandler.isInstall(), activity);
            }
            int ordinal = share_media.ordinal();
            saveAuthListener(ordinal, uMAuthListener);
            activity = getAuthListener(ordinal, activity);
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    uMAuthListener.onStart(share_media);
                }
            });
            uMSSOHandler.authorize(activity);
            this.mAuthPlatform = share_media;
        }
    }

    private UMAuthListener getAuthListener(final int i, final String str) {
        return new UMAuthListener() {
            public void onStart(SHARE_MEDIA share_media) {
                UMAuthListener access$100 = SocialRouter.this.getAndRemoveAuthListener(i);
                if (access$100 != null) {
                    access$100.onStart(share_media);
                }
            }

            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                UMAuthListener access$100 = SocialRouter.this.getAndRemoveAuthListener(i);
                if (access$100 != null) {
                    access$100.onComplete(share_media, i, map);
                }
                if (ContextUtil.getContext() != 0) {
                    SocialAnalytics.authendt(ContextUtil.getContext(), share_media.toString().toLowerCase(), "success", "", str);
                }
            }

            public void onError(SHARE_MEDIA share_media, int i, Throwable th) {
                UMAuthListener access$100 = SocialRouter.this.getAndRemoveAuthListener(i);
                if (access$100 != null) {
                    access$100.onError(share_media, i, th);
                }
                if (th != null) {
                    i = new StringBuilder("error:");
                    i.append(th.getMessage());
                    Log.um(i.toString());
                } else {
                    Log.um("error:null");
                }
                if (ContextUtil.getContext() != 0 && th != null) {
                    SocialAnalytics.authendt(ContextUtil.getContext(), share_media.toString().toLowerCase(), "fail", th.getMessage(), str);
                }
            }

            public void onCancel(SHARE_MEDIA share_media, int i) {
                UMAuthListener access$100 = SocialRouter.this.getAndRemoveAuthListener(i);
                if (access$100 != null) {
                    access$100.onCancel(share_media, i);
                }
                if (ContextUtil.getContext() != 0) {
                    SocialAnalytics.authendt(ContextUtil.getContext(), share_media.toString().toLowerCase(), "cancel", "", str);
                }
            }
        };
    }

    private void parseShareContent(ShareContent shareContent) {
        StringBuilder stringBuilder = new StringBuilder("sharetext=");
        stringBuilder.append(shareContent.mText);
        Log.umd(stringBuilder.toString());
        if (shareContent.mMedia != null) {
            StringBuilder stringBuilder2;
            StringBuilder stringBuilder3;
            if (shareContent.mMedia instanceof UMImage) {
                UMImage uMImage = (UMImage) shareContent.mMedia;
                if (uMImage.isUrlMedia()) {
                    stringBuilder2 = new StringBuilder("urlimage=");
                    stringBuilder2.append(uMImage.asUrlImage());
                    stringBuilder2.append(" compressStyle=");
                    stringBuilder2.append(uMImage.compressStyle);
                    stringBuilder2.append(" isLoadImgByCompress=");
                    stringBuilder2.append(uMImage.isLoadImgByCompress);
                    stringBuilder2.append("  compressFormat=");
                    stringBuilder2.append(uMImage.compressFormat);
                    Log.umd(stringBuilder2.toString());
                } else {
                    byte[] asBinImage = uMImage.asBinImage();
                    StringBuilder stringBuilder4 = new StringBuilder("localimage=");
                    stringBuilder4.append(asBinImage == null ? 0 : asBinImage.length);
                    stringBuilder4.append(" compressStyle=");
                    stringBuilder4.append(uMImage.compressStyle);
                    stringBuilder4.append(" isLoadImgByCompress=");
                    stringBuilder4.append(uMImage.isLoadImgByCompress);
                    stringBuilder4.append("  compressFormat=");
                    stringBuilder4.append(uMImage.compressFormat);
                    Log.umd(stringBuilder4.toString());
                }
                if (uMImage.getThumbImage() != null) {
                    uMImage = uMImage.getThumbImage();
                    if (uMImage.isUrlMedia()) {
                        stringBuilder2 = new StringBuilder("urlthumbimage=");
                        stringBuilder2.append(uMImage.asUrlImage());
                        Log.umd(stringBuilder2.toString());
                    } else {
                        stringBuilder2 = new StringBuilder("localthumbimage=");
                        stringBuilder2.append(uMImage.asBinImage().length);
                        Log.umd(stringBuilder2.toString());
                    }
                }
            }
            if (shareContent.mMedia instanceof UMVideo) {
                UMVideo uMVideo = (UMVideo) shareContent.mMedia;
                stringBuilder2 = new StringBuilder("video=");
                stringBuilder2.append(uMVideo.toUrl());
                Log.umd(stringBuilder2.toString());
                stringBuilder2 = new StringBuilder("video title=");
                stringBuilder2.append(uMVideo.getTitle());
                Log.umd(stringBuilder2.toString());
                stringBuilder2 = new StringBuilder("video desc=");
                stringBuilder2.append(uMVideo.getDescription());
                Log.umd(stringBuilder2.toString());
                if (TextUtils.isEmpty(uMVideo.toUrl())) {
                    Log.um(UmengText.urlEmpty(0));
                }
                if (uMVideo.getThumbImage() != null) {
                    if (uMVideo.getThumbImage().isUrlMedia()) {
                        stringBuilder3 = new StringBuilder("urlthumbimage=");
                        stringBuilder3.append(uMVideo.getThumbImage().asUrlImage());
                        Log.umd(stringBuilder3.toString());
                    } else {
                        stringBuilder3 = new StringBuilder("localthumbimage=");
                        stringBuilder3.append(uMVideo.getThumbImage().asBinImage());
                        Log.umd(stringBuilder3.toString());
                    }
                }
            }
            if (shareContent.mMedia instanceof UMusic) {
                UMusic uMusic = (UMusic) shareContent.mMedia;
                stringBuilder3 = new StringBuilder("music=");
                stringBuilder3.append(uMusic.toUrl());
                Log.umd(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder("music title=");
                stringBuilder3.append(uMusic.getTitle());
                Log.umd(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder("music desc=");
                stringBuilder3.append(uMusic.getDescription());
                Log.umd(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder("music target=");
                stringBuilder3.append(uMusic.getmTargetUrl());
                Log.umd(stringBuilder3.toString());
                if (TextUtils.isEmpty(uMusic.toUrl())) {
                    Log.um(UmengText.urlEmpty(1));
                }
                if (uMusic.getThumbImage() != null) {
                    if (uMusic.getThumbImage().isUrlMedia()) {
                        stringBuilder3 = new StringBuilder("urlthumbimage=");
                        stringBuilder3.append(uMusic.getThumbImage().asUrlImage());
                        Log.umd(stringBuilder3.toString());
                    } else {
                        stringBuilder3 = new StringBuilder("localthumbimage=");
                        stringBuilder3.append(uMusic.getThumbImage().asBinImage());
                        Log.umd(stringBuilder3.toString());
                    }
                }
            }
            if (shareContent.mMedia instanceof UMWeb) {
                UMWeb uMWeb = (UMWeb) shareContent.mMedia;
                stringBuilder3 = new StringBuilder("web=");
                stringBuilder3.append(uMWeb.toUrl());
                Log.umd(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder("web title=");
                stringBuilder3.append(uMWeb.getTitle());
                Log.umd(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder("web desc=");
                stringBuilder3.append(uMWeb.getDescription());
                Log.umd(stringBuilder3.toString());
                if (uMWeb.getThumbImage() != null) {
                    if (uMWeb.getThumbImage().isUrlMedia()) {
                        stringBuilder3 = new StringBuilder("urlthumbimage=");
                        stringBuilder3.append(uMWeb.getThumbImage().asUrlImage());
                        Log.umd(stringBuilder3.toString());
                    } else {
                        stringBuilder3 = new StringBuilder("localthumbimage=");
                        stringBuilder3.append(uMWeb.getThumbImage().asBinImage());
                        Log.umd(stringBuilder3.toString());
                    }
                }
                if (TextUtils.isEmpty(uMWeb.toUrl())) {
                    Log.um(UmengText.urlEmpty(2));
                }
            }
        }
        if (shareContent.file != null) {
            stringBuilder = new StringBuilder("file=");
            stringBuilder.append(shareContent.file.getName());
            Log.umd(stringBuilder.toString());
        }
    }

    public final void share(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        checkAppkey(activity);
        WeakReference weakReference = new WeakReference(activity);
        if (this.guard.share(shareAction) != null) {
            if (Config.DEBUG != null) {
                activity = new StringBuilder("api version:");
                activity.append(this.APIVERSION);
                Log.umd(activity.toString());
                activity = new StringBuilder("sharemedia=");
                activity.append(shareAction.getPlatform().toString());
                Log.umd(activity.toString());
                activity = new StringBuilder();
                activity.append(UmengText.SHARE_STYLE);
                activity.append(shareAction.getShareContent().getShareType());
                Log.umd(activity.toString());
                parseShareContent(shareAction.getShareContent());
            }
            activity = shareAction.getPlatform();
            UMSSOHandler uMSSOHandler = (UMSSOHandler) this.platformHandlers.get(activity);
            uMSSOHandler.onCreate((Context) weakReference.get(), PlatformConfig.getPlatform(activity));
            if (!(activity.toString().equals("TENCENT") || activity.toString().equals("RENREN") || activity.toString().equals("DOUBAN"))) {
                if (activity.toString().equals("WEIXIN")) {
                    SocialAnalytics.log((Context) weakReference.get(), "wxsession", shareAction.getShareContent().mText, shareAction.getShareContent().mMedia);
                } else if (activity.toString().equals("WEIXIN_CIRCLE")) {
                    SocialAnalytics.log((Context) weakReference.get(), "wxtimeline", shareAction.getShareContent().mText, shareAction.getShareContent().mMedia);
                } else if (activity.toString().equals("WEIXIN_FAVORITE")) {
                    SocialAnalytics.log((Context) weakReference.get(), "wxfavorite", shareAction.getShareContent().mText, shareAction.getShareContent().mMedia);
                } else {
                    SocialAnalytics.log((Context) weakReference.get(), activity.toString().toLowerCase(), shareAction.getShareContent().mText, shareAction.getShareContent().mMedia);
                }
            }
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                boolean z = false;
                if (shareAction.getShareContent().mMedia instanceof UMImage) {
                    z = ((UMImage) shareAction.getShareContent().mMedia).isHasWaterMark();
                }
                SocialAnalytics.sharestart(ContextUtil.getContext(), shareAction.getPlatform(), uMSSOHandler.getSDKVersion(), uMSSOHandler.isInstall(), shareAction.getShareContent().getShareType(), valueOf, z);
            }
            activity = activity.ordinal();
            saveShareListener(activity, uMShareListener);
            final UMShareListener anonymousClass6 = new UMShareListener() {
                public void onStart(SHARE_MEDIA share_media) {
                    UMShareListener access$200 = SocialRouter.this.getAndRemoveShareListener(activity);
                    if (access$200 != null) {
                        access$200.onStart(share_media);
                    }
                }

                public void onResult(SHARE_MEDIA share_media) {
                    if (ContextUtil.getContext() != null) {
                        SocialAnalytics.shareend(ContextUtil.getContext(), share_media.toString().toLowerCase(), "success", "", valueOf);
                    }
                    UMShareListener access$200 = SocialRouter.this.getAndRemoveShareListener(activity);
                    if (access$200 != null) {
                        access$200.onResult(share_media);
                    }
                }

                public void onError(SHARE_MEDIA share_media, Throwable th) {
                    if (!(ContextUtil.getContext() == null || th == null)) {
                        SocialAnalytics.shareend(ContextUtil.getContext(), share_media.toString().toLowerCase(), "fail", th.getMessage(), valueOf);
                    }
                    UMShareListener access$200 = SocialRouter.this.getAndRemoveShareListener(activity);
                    if (access$200 != null) {
                        access$200.onError(share_media, th);
                    }
                    if (th != null) {
                        share_media = new StringBuilder("error:");
                        share_media.append(th.getMessage());
                        Log.um(share_media.toString());
                        share_media = new StringBuilder();
                        share_media.append(UmengText.SOLVE);
                        share_media.append(UrlUtil.ALL_SHAREFAIL);
                        Log.um(share_media.toString());
                        return;
                    }
                    Log.um("error:null");
                }

                public void onCancel(SHARE_MEDIA share_media) {
                    if (ContextUtil.getContext() != null) {
                        SocialAnalytics.shareend(ContextUtil.getContext(), share_media.toString().toLowerCase(), "cancel", "", valueOf);
                    }
                    UMShareListener access$200 = SocialRouter.this.getAndRemoveShareListener(activity);
                    if (access$200 != null) {
                        access$200.onCancel(share_media);
                    }
                }
            };
            if (shareAction.getUrlValid() == null) {
                QueuedWork.runInMain(new Runnable() {
                    public void run() {
                        UMShareListener uMShareListener = anonymousClass6;
                        SHARE_MEDIA platform = shareAction.getPlatform();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(UmengErrorCode.NotInstall.getMessage());
                        stringBuilder.append(UmengText.WEB_HTTP);
                        uMShareListener.onError(platform, new Throwable(stringBuilder.toString()));
                    }
                });
                return;
            }
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    if (uMShareListener != null) {
                        uMShareListener.onStart(shareAction.getPlatform());
                    }
                }
            });
            uMSSOHandler.share(shareAction.getShareContent(), anonymousClass6);
        }
    }

    private synchronized void saveAuthListener(int i, UMAuthListener uMAuthListener) {
        this.mAuthListenerContainer.put(i, uMAuthListener);
    }

    private synchronized UMAuthListener getAndRemoveAuthListener(int i) {
        UMAuthListener uMAuthListener;
        this.mAuthPlatform = null;
        uMAuthListener = (UMAuthListener) this.mAuthListenerContainer.get(i, null);
        if (uMAuthListener != null) {
            this.mAuthListenerContainer.remove(i);
        }
        return uMAuthListener;
    }

    private synchronized void saveFetchUserInfoListener(int i, UMAuthListener uMAuthListener) {
        this.mFetchUserInfoListenerContainer.put(i, uMAuthListener);
    }

    private synchronized UMAuthListener getAndRemoveFetchUserInfoListener(int i) {
        UMAuthListener uMAuthListener;
        uMAuthListener = (UMAuthListener) this.mFetchUserInfoListenerContainer.get(i, null);
        if (uMAuthListener != null) {
            this.mFetchUserInfoListenerContainer.remove(i);
        }
        return uMAuthListener;
    }

    private synchronized void saveShareListener(int i, UMShareListener uMShareListener) {
        this.mShareListenerContainer.put(i, uMShareListener);
    }

    private synchronized UMShareListener getAndRemoveShareListener(int i) {
        UMShareListener uMShareListener;
        uMShareListener = (UMShareListener) this.mShareListenerContainer.get(i, null);
        if (uMShareListener != null) {
            this.mShareListenerContainer.remove(i);
        }
        return uMShareListener;
    }

    private synchronized void clearListener() {
        this.mAuthListenerContainer.clear();
        this.mShareListenerContainer.clear();
        this.mFetchUserInfoListenerContainer.clear();
    }

    private void setAuthListener(SHARE_MEDIA share_media, UMAuthListener uMAuthListener, UMSSOHandler uMSSOHandler, String str) {
        if (!uMSSOHandler.isHasAuthListener()) {
            share_media = share_media.ordinal();
            saveAuthListener(share_media, uMAuthListener);
            uMSSOHandler.setAuthListener(getAuthListener(share_media, str));
        }
    }

    public final void release() {
        clearListener();
        UMSSOHandler uMSSOHandler = (UMSSOHandler) this.platformHandlers.get(SHARE_MEDIA.SINA);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        uMSSOHandler = (UMSSOHandler) this.platformHandlers.get(SHARE_MEDIA.MORE);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        uMSSOHandler = (UMSSOHandler) this.platformHandlers.get(SHARE_MEDIA.DINGTALK);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        uMSSOHandler = (UMSSOHandler) this.platformHandlers.get(SHARE_MEDIA.WEIXIN);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        uMSSOHandler = (UMSSOHandler) this.platformHandlers.get(SHARE_MEDIA.QQ);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        this.mAuthPlatform = null;
    }

    private void safelyCloseDialog(Dialog dialog) {
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Dialog dialog2) {
                dialog2.printStackTrace();
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        int i;
        String str = "";
        if (this.mAuthPlatform == null || !(this.mAuthPlatform == SHARE_MEDIA.WEIXIN || this.mAuthPlatform == SHARE_MEDIA.QQ || this.mAuthPlatform == SHARE_MEDIA.SINA)) {
            i = -1;
        } else {
            str = this.mAuthPlatform.toString();
            i = 0;
        }
        bundle.putString(BUNDLE_KEY_AUTH_PLATFORM, str);
        bundle.putInt(BUNDLE_KEY_ACTION, i);
        this.mAuthPlatform = null;
    }

    public final void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        if (bundle != null && uMAuthListener != null) {
            Object string = bundle.getString(BUNDLE_KEY_AUTH_PLATFORM, null);
            if (bundle.getInt(BUNDLE_KEY_ACTION, -1) == null && TextUtils.isEmpty(string) == null) {
                SHARE_MEDIA convertToEmun = SHARE_MEDIA.convertToEmun(string);
                if (convertToEmun != null) {
                    UMSSOHandler uMSSOHandler;
                    if (convertToEmun == SHARE_MEDIA.QQ) {
                        uMSSOHandler = (UMSSOHandler) this.platformHandlers.get(convertToEmun);
                        uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(convertToEmun));
                    } else {
                        uMSSOHandler = getHandler(convertToEmun);
                    }
                    if (uMSSOHandler != null) {
                        setAuthListener(convertToEmun, uMAuthListener, uMSSOHandler, String.valueOf(System.currentTimeMillis()));
                    }
                }
            }
        }
    }

    public final void setShareConfig(UMShareConfig uMShareConfig) {
        if (this.platformHandlers != null && !this.platformHandlers.isEmpty()) {
            for (Entry value : this.platformHandlers.entrySet()) {
                UMSSOHandler uMSSOHandler = (UMSSOHandler) value.getValue();
                if (uMSSOHandler != null) {
                    uMSSOHandler.setShareConfig(uMShareConfig);
                }
            }
        }
    }
}
