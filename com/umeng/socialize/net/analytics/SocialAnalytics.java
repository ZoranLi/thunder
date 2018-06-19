package com.umeng.socialize.net.analytics;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.umeng.socialize.Config;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.base.SocializeClient;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.stats.AuthStatsRequest;
import com.umeng.socialize.net.stats.DauStatsRequest;
import com.umeng.socialize.net.stats.ShareStatsRequest;
import com.umeng.socialize.net.stats.ShareboardStatsRequest;
import com.umeng.socialize.net.stats.StatsAPIs;
import com.umeng.socialize.net.stats.StatsRequest;
import com.umeng.socialize.net.stats.UserInfoStatsRequest;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.uploadlog.UMLog;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.SocializeSpUtils;
import com.xiaomi.push.service.av;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class SocialAnalytics {
    private static SocializeClient a = new SocializeClient();
    private static ExecutorService b = Executors.newCachedThreadPool();

    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ UMediaObject d;

        AnonymousClass1(Context context, String str, String str2, UMediaObject uMediaObject) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = uMediaObject;
        }

        public final void run() {
            URequest aVar = new a(this.a, this.b, this.c);
            aVar.a(this.d);
            b bVar = (b) SocialAnalytics.a.execute(aVar);
            if (bVar == null || !bVar.isOk()) {
                Log.d(" fail to send log");
            } else {
                Log.d(" send log succeed");
            }
        }
    }

    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ SHARE_MEDIA b;
        final /* synthetic */ boolean c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        AnonymousClass2(Context context, SHARE_MEDIA share_media, boolean z, String str, String str2) {
            this.a = context;
            this.b = share_media;
            this.c = z;
            this.d = str;
            this.e = str2;
        }

        public final void run() {
            AuthStatsRequest authStatsRequest = new AuthStatsRequest(this.a, SocializeReseponse.class);
            authStatsRequest.addStringParams("style", this.b.getauthstyle(this.c));
            authStatsRequest.addStringParams("platform", this.b.toString().toLowerCase());
            authStatsRequest.addStringParams("version", this.d);
            authStatsRequest.addStringParams("tag", this.e);
            if (this.b == SHARE_MEDIA.QQ) {
                if (Config.isUmengQQ.booleanValue()) {
                    authStatsRequest.addStringParams("isumeng", "true");
                } else {
                    authStatsRequest.addStringParams("isumeng", av.b);
                }
            }
            if (this.b == SHARE_MEDIA.SINA) {
                if (Config.isUmengSina.booleanValue()) {
                    authStatsRequest.addStringParams("isumeng", "true");
                } else {
                    authStatsRequest.addStringParams("isumeng", av.b);
                }
            }
            if (this.b == SHARE_MEDIA.WEIXIN || this.b == SHARE_MEDIA.WEIXIN_CIRCLE || this.b == SHARE_MEDIA.WEIXIN_FAVORITE) {
                if (Config.isUmengWx.booleanValue()) {
                    authStatsRequest.addStringParams("isumeng", "true");
                } else {
                    authStatsRequest.addStringParams("isumeng", av.b);
                }
            }
            StatsAPIs.authStatsStart(authStatsRequest);
        }
    }

    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        AnonymousClass3(Context context, String str, String str2, String str3, String str4) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        public final void run() {
            AuthStatsRequest authStatsRequest = new AuthStatsRequest(this.a, SocializeReseponse.class);
            authStatsRequest.addStringParams("result", this.b);
            if (!TextUtils.isEmpty(this.c)) {
                authStatsRequest.addStringParams("errormsg", this.c);
            }
            authStatsRequest.addStringParams("platform", this.d);
            authStatsRequest.addStringParams("tag", this.e);
            StatsAPIs.authStatsEnd(authStatsRequest);
        }
    }

    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ SHARE_MEDIA b;
        final /* synthetic */ boolean c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ String f;
        final /* synthetic */ boolean g;

        AnonymousClass4(Context context, SHARE_MEDIA share_media, boolean z, String str, int i, String str2, boolean z2) {
            this.a = context;
            this.b = share_media;
            this.c = z;
            this.d = str;
            this.e = i;
            this.f = str2;
            this.g = z2;
        }

        public final void run() {
            ShareStatsRequest shareStatsRequest = new ShareStatsRequest(this.a, SocializeReseponse.class);
            shareStatsRequest.addStringParams("style", this.b.getsharestyle(this.c));
            shareStatsRequest.addStringParams("platform", this.b.toString().toLowerCase());
            shareStatsRequest.addStringParams("version", this.d);
            shareStatsRequest.addStringParams("sharetype", String.valueOf(this.e));
            shareStatsRequest.addStringParams("tag", this.f);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.g);
            shareStatsRequest.addStringParams("usecompose", stringBuilder.toString());
            if (this.b == SHARE_MEDIA.QQ) {
                if (Config.isUmengQQ.booleanValue()) {
                    shareStatsRequest.addStringParams("isumeng", "true");
                } else {
                    shareStatsRequest.addStringParams("isumeng", av.b);
                }
            }
            if (this.b == SHARE_MEDIA.SINA) {
                if (Config.isUmengSina.booleanValue()) {
                    shareStatsRequest.addStringParams("isumeng", "true");
                } else {
                    shareStatsRequest.addStringParams("isumeng", av.b);
                }
            }
            if (this.b == SHARE_MEDIA.WEIXIN || this.b == SHARE_MEDIA.WEIXIN_CIRCLE || this.b == SHARE_MEDIA.WEIXIN_FAVORITE) {
                if (Config.isUmengWx.booleanValue()) {
                    shareStatsRequest.addStringParams("isumeng", "true");
                } else {
                    shareStatsRequest.addStringParams("isumeng", av.b);
                }
            }
            StatsAPIs.shareStatsStart(shareStatsRequest);
        }
    }

    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        AnonymousClass5(Context context, String str, String str2, String str3, String str4) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        public final void run() {
            ShareStatsRequest shareStatsRequest = new ShareStatsRequest(this.a, SocializeReseponse.class);
            shareStatsRequest.addStringParams("result", this.b);
            if (!TextUtils.isEmpty(this.c)) {
                shareStatsRequest.addStringParams("errormsg", this.c);
            }
            shareStatsRequest.addStringParams("platform", this.d);
            shareStatsRequest.addStringParams("tag", this.e);
            StatsAPIs.shareStatsEnd(shareStatsRequest);
        }
    }

    final class AnonymousClass6 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ SHARE_MEDIA b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        AnonymousClass6(Context context, SHARE_MEDIA share_media, String str, String str2) {
            this.a = context;
            this.b = share_media;
            this.c = str;
            this.d = str2;
        }

        public final void run() {
            UserInfoStatsRequest userInfoStatsRequest = new UserInfoStatsRequest(this.a, SocializeReseponse.class);
            userInfoStatsRequest.addStringParams("platform", this.b.toString().toLowerCase());
            userInfoStatsRequest.addStringParams("version", this.c);
            userInfoStatsRequest.addStringParams("tag", this.d);
            if (this.b == SHARE_MEDIA.QQ) {
                if (Config.isUmengQQ.booleanValue()) {
                    userInfoStatsRequest.addStringParams("isumeng", "true");
                } else {
                    userInfoStatsRequest.addStringParams("isumeng", av.b);
                }
            }
            if (this.b == SHARE_MEDIA.SINA) {
                if (Config.isUmengSina.booleanValue()) {
                    userInfoStatsRequest.addStringParams("isumeng", "true");
                } else {
                    userInfoStatsRequest.addStringParams("isumeng", av.b);
                }
            }
            if (this.b == SHARE_MEDIA.WEIXIN || this.b == SHARE_MEDIA.WEIXIN_CIRCLE || this.b == SHARE_MEDIA.WEIXIN_FAVORITE) {
                if (Config.isUmengWx.booleanValue()) {
                    userInfoStatsRequest.addStringParams("isumeng", "true");
                } else {
                    userInfoStatsRequest.addStringParams("isumeng", av.b);
                }
            }
            StatsAPIs.userInfoStatsStart(userInfoStatsRequest);
        }
    }

    final class AnonymousClass7 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        AnonymousClass7(Context context, String str, String str2, String str3, String str4) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        public final void run() {
            UserInfoStatsRequest userInfoStatsRequest = new UserInfoStatsRequest(this.a, SocializeReseponse.class);
            userInfoStatsRequest.addStringParams("result", this.b);
            if (!TextUtils.isEmpty(this.c)) {
                userInfoStatsRequest.addStringParams("errormsg", this.c);
            }
            userInfoStatsRequest.addStringParams("tag", this.d);
            userInfoStatsRequest.addStringParams("platform", this.e);
            StatsAPIs.userInfoStatsEnd(userInfoStatsRequest);
        }
    }

    final class AnonymousClass8 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ boolean b;

        AnonymousClass8(Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        public final void run() {
            try {
                DauStatsRequest dauStatsRequest = new DauStatsRequest(this.a, SocializeReseponse.class);
                Bundle shareAndAuth = UMLog.getShareAndAuth();
                if (shareAndAuth != null) {
                    dauStatsRequest.addStringParams("isshare", String.valueOf(shareAndAuth.getBoolean("share")));
                    dauStatsRequest.addStringParams("isauth", String.valueOf(shareAndAuth.getBoolean("auth")));
                    dauStatsRequest.addStringParams("isjump", String.valueOf(shareAndAuth.getBoolean("isjump")));
                    dauStatsRequest.addStringParams(SocializeConstants.USHARETYPE, Config.shareType);
                    dauStatsRequest.addStringParams("ni", this.b ? "1" : "0");
                    dauStatsRequest.addStringParams("pkname", ContextUtil.getPackageName());
                    dauStatsRequest.addStringParams("useshareview", String.valueOf(UMLog.isOpenShareEdit()));
                }
                StatsAPIs.dauStats(dauStatsRequest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    final class AnonymousClass9 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass9(Context context) {
            this.a = context;
        }

        public final void run() {
            Object shareBoardConfig = SocializeSpUtils.getShareBoardConfig(this.a);
            if (!TextUtils.isEmpty(shareBoardConfig)) {
                try {
                    String[] split = shareBoardConfig.split(h.b);
                    if (split.length == 2) {
                        Object obj = split[0];
                        shareBoardConfig = split[1];
                        if (!(TextUtils.isEmpty(obj) || TextUtils.isEmpty(shareBoardConfig))) {
                            StatsRequest shareboardStatsRequest = new ShareboardStatsRequest(this.a, SocializeReseponse.class);
                            shareboardStatsRequest.addStringParams("position", shareBoardConfig);
                            shareboardStatsRequest.addStringParams("menubg", obj);
                            StatsAPIs.shareboardStats(shareboardStatsRequest);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void log(Context context, String str, String str2, UMediaObject uMediaObject) {
        a(new AnonymousClass1(context, str, str2, uMediaObject));
    }

    public static void authstart(Context context, SHARE_MEDIA share_media, String str, boolean z, String str2) {
        a(new AnonymousClass2(context, share_media, z, str, str2));
    }

    public static void authendt(Context context, String str, String str2, String str3, String str4) {
        a(new AnonymousClass3(context, str2, str3, str, str4));
    }

    public static void sharestart(Context context, SHARE_MEDIA share_media, String str, boolean z, int i, String str2, boolean z2) {
        a(new AnonymousClass4(context, share_media, z, str, i, str2, z2));
    }

    public static void shareend(Context context, String str, String str2, String str3, String str4) {
        a(new AnonymousClass5(context, str2, str3, str, str4));
    }

    public static void getInfostart(Context context, SHARE_MEDIA share_media, String str, String str2) {
        a(new AnonymousClass6(context, share_media, str, str2));
    }

    public static void getInfoendt(Context context, String str, String str2, String str3, String str4) {
        a(new AnonymousClass7(context, str2, str3, str4, str));
    }

    public static void dauStats(Context context, boolean z) {
        a(new AnonymousClass8(context, z));
    }

    public static void shareBoardStats(Context context) {
        a(new AnonymousClass9(context));
    }

    private static void a(Runnable runnable) {
        if (b != null && runnable != null) {
            b.submit(runnable);
        }
    }
}
