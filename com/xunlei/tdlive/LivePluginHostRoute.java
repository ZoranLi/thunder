package com.xunlei.tdlive;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.authphone.r$a;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.c.h;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.member.payment.external.l.b;
import com.xunlei.downloadprovider.member.register.ui.AuthMobileActivity;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper.Entrance;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.tdlive.route.ActivityHelper;
import com.xunlei.tdlive.route.BaseXLLiveRoute;
import com.xunlei.tdlive.route.util.Route;
import com.xunlei.tdlive.route.util.Route.IRoute;
import com.xunlei.tdlive.route.util.UriUtil;
import java.util.HashMap;
import java.util.Map;

public class LivePluginHostRoute extends BaseXLLiveRoute {
    IRoute authPhone = new IRoute() {
        public int action(final Context context, String str, Uri uri) {
            if (r.b == null) {
                if (TextUtils.isEmpty(LivePluginHostRoute.this.mLoginHelper.i()) != null) {
                    r.a().a(new c<r$a>() {
                        public void onFail(String str) {
                            LivePluginAppRouteDispatcher.fireAuthPhoneEvent(-1, str);
                        }

                        public void onSuccess(r$a com_xunlei_downloadprovider_member_login_authphone_r_a) {
                            if ("NOAUTH".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a) != null) {
                                ActivityHelper.transform(context, new ActivityHelper() {
                                    public void onActivityCreated(Activity activity, Bundle bundle) {
                                        super.onActivityCreated(activity, bundle);
                                        bundle = new Intent(activity, AuthMobileActivity.class);
                                        bundle.putExtra("from", "live_liveroom_comment");
                                        bundle.addFlags(67108864);
                                        activity.startActivityForResult(bundle, 100);
                                        r.c = true;
                                        h.a().d();
                                    }

                                    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                                        super.onActivityResult(activity, i, i2, intent);
                                        activity.finish();
                                        if (!(i2 != -1 || intent == null || intent.getBooleanExtra("result", false) == 0)) {
                                            r.b = true;
                                        }
                                        if (r.b != 0) {
                                            LivePluginAppRouteDispatcher.fireAuthPhoneEvent(0, "");
                                        } else {
                                            LivePluginAppRouteDispatcher.fireAuthPhoneEvent(-1, "unknown error");
                                        }
                                    }
                                });
                            } else {
                                LivePluginAppRouteDispatcher.fireAuthPhoneEvent(null, "");
                            }
                        }
                    });
                    return 0;
                }
            }
            LivePluginAppRouteDispatcher.fireAuthPhoneEvent(0, "");
            return 0;
        }
    };
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                "com.xunlei.tdlive.plugin.app.onActivityResult".equals(intent.getAction());
            }
        }
    };
    IRoute download = new IRoute() {
        public int action(android.content.Context r9, java.lang.String r10, android.net.Uri r11) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r9 = "url";	 Catch:{ Throwable -> 0x0024 }
            r10 = "";	 Catch:{ Throwable -> 0x0024 }
            r0 = com.xunlei.tdlive.route.util.UriUtil.getParam(r11, r9, r10);	 Catch:{ Throwable -> 0x0024 }
            if (r0 == 0) goto L_0x0024;	 Catch:{ Throwable -> 0x0024 }
        L_0x000a:
            r9 = r0.length();	 Catch:{ Throwable -> 0x0024 }
            if (r9 <= 0) goto L_0x0024;	 Catch:{ Throwable -> 0x0024 }
        L_0x0010:
            r5 = new com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;	 Catch:{ Throwable -> 0x0024 }
            r9 = "";	 Catch:{ Throwable -> 0x0024 }
            r10 = "";	 Catch:{ Throwable -> 0x0024 }
            r5.<init>(r9, r0, r10);	 Catch:{ Throwable -> 0x0024 }
            r1 = "";	 Catch:{ Throwable -> 0x0024 }
            r2 = 0;	 Catch:{ Throwable -> 0x0024 }
            r4 = "";	 Catch:{ Throwable -> 0x0024 }
            r6 = 0;	 Catch:{ Throwable -> 0x0024 }
            r7 = 0;	 Catch:{ Throwable -> 0x0024 }
            com.xunlei.downloadprovider.download.c.a(r0, r1, r2, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0024 }
        L_0x0024:
            r9 = 0;
            return r9;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.LivePluginHostRoute.13.action(android.content.Context, java.lang.String, android.net.Uri):int");
        }
    };
    IRoute limitSpeed = new IRoute() {
        public int action(android.content.Context r5, java.lang.String r6, android.net.Uri r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r5 = 0;
            r6 = "limit";	 Catch:{ Throwable -> 0x0029 }
            r6 = com.xunlei.tdlive.route.util.UriUtil.getParam(r7, r6, r5);	 Catch:{ Throwable -> 0x0029 }
            if (r6 <= 0) goto L_0x0020;	 Catch:{ Throwable -> 0x0029 }
        L_0x0009:
            com.xunlei.downloadprovider.download.engine.task.n.a();	 Catch:{ Throwable -> 0x0029 }
            r0 = com.xunlei.downloadprovider.download.engine.task.n.h();	 Catch:{ Throwable -> 0x0029 }
            r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Throwable -> 0x0029 }
            r0 = r0 / r2;	 Catch:{ Throwable -> 0x0029 }
            r6 = (long) r6;	 Catch:{ Throwable -> 0x0029 }
            r2 = r0 - r6;	 Catch:{ Throwable -> 0x0029 }
            r6 = (int) r2;	 Catch:{ Throwable -> 0x0029 }
            r7 = com.xunlei.downloadprovider.download.engine.task.n.a();	 Catch:{ Throwable -> 0x0029 }
            r0 = (long) r6;	 Catch:{ Throwable -> 0x0029 }
            r7.d(r0);	 Catch:{ Throwable -> 0x0029 }
            goto L_0x0029;	 Catch:{ Throwable -> 0x0029 }
        L_0x0020:
            r6 = com.xunlei.downloadprovider.download.engine.task.n.a();	 Catch:{ Throwable -> 0x0029 }
            r0 = -1;	 Catch:{ Throwable -> 0x0029 }
            r6.d(r0);	 Catch:{ Throwable -> 0x0029 }
        L_0x0029:
            return r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.LivePluginHostRoute.14.action(android.content.Context, java.lang.String, android.net.Uri):int");
        }
    };
    IRoute login = new IRoute() {
        public int action(Context context, String str, Uri uri) {
            if (UriUtil.getParam(uri, "silent", false) != null) {
                LivePluginHostRoute.this.mLoginHelper.a(false);
            } else {
                LivePluginHostRoute.this.mLoginHelper.a(LoginPageType.LOGIN_FLOAT, context, null, LoginFrom.XL_LIVE, 268435456, null);
            }
            return 0;
        }
    };
    private LoginHelper mLoginHelper = LoginHelper.a();
    IRoute notifyLiveRoomShow = new IRoute() {
        public int action(Context context, String str, Uri uri) {
            context = UriUtil.getParam(uri, "userid", "");
            if (context != null && context.length() > null) {
                long parseLong = Long.parseLong(context);
                if (parseLong > 0) {
                    if (parseLong != LoginHelper.a().g.c()) {
                        VisitorNetworkHelper.a().a(parseLong, Entrance.LIVE_ROOM_VISIT, "", "", "", "");
                    }
                }
                return 0;
            }
            return 0;
        }
    };
    IRoute pay = new IRoute() {
        b mXLOnPayListener;

        public int action(android.content.Context r9, java.lang.String r10, android.net.Uri r11) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r9 = com.xunlei.downloadprovider.app.AppStatusChgObserver.b();
            r9 = r9.c();
            r10 = "version";
            r0 = "";
            r10 = com.xunlei.tdlive.route.util.UriUtil.getParam(r11, r10, r0);
            r0 = "payType";
            r1 = 0;
            r2 = com.xunlei.tdlive.route.util.UriUtil.getParam(r11, r0, r1);
            r0 = "vasType";
            com.xunlei.tdlive.route.util.UriUtil.getParam(r11, r0, r1);
            r0 = "payNum";
            r0 = com.xunlei.tdlive.route.util.UriUtil.getParam(r11, r0, r1);
            r3 = "paySource";
            r4 = "";
            r3 = com.xunlei.tdlive.route.util.UriUtil.getParam(r11, r3, r4);
            r4 = "obj";
            r5 = "";
            r11 = com.xunlei.tdlive.route.util.UriUtil.getParam(r11, r4, r5);
            if (r9 != 0) goto L_0x0043;
        L_0x0034:
            r3 = -1;
            r9 = -1;
            r4 = com.xunlei.common.new_ptl.pay.XLPayErrorCode.getErrorDesc(r9);
            r5 = "";
            r6 = "";
            r7 = -1;
            com.xunlei.tdlive.LivePluginAppRouteDispatcher.firePayEvent(r2, r3, r4, r5, r6, r7);
            return r1;
        L_0x0043:
            r4 = r8.mXLOnPayListener;
            if (r4 != 0) goto L_0x0055;
        L_0x0047:
            r4 = com.xunlei.downloadprovider.member.payment.external.l.a();
            r5 = new com.xunlei.tdlive.LivePluginHostRoute$6$1;
            r5.<init>(r2);
            r8.mXLOnPayListener = r5;
            r4.a(r5);
        L_0x0055:
            r4 = new java.lang.StringBuilder;
            r5 = "sdk_ver=";
            r4.<init>(r5);
            r4.append(r10);
            r10 = "&source=";
            r4.append(r10);
            r4.append(r3);
            r10 = r4.toString();
            r3 = android.text.TextUtils.isEmpty(r11);
            if (r3 != 0) goto L_0x009d;
        L_0x0071:
            r3 = r11.charAt(r1);
            r4 = 38;
            if (r3 != r4) goto L_0x0089;
        L_0x0079:
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r3.append(r10);
            r3.append(r11);
            r10 = r3.toString();
            goto L_0x009d;
        L_0x0089:
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r3.append(r10);
            r10 = "&";
            r3.append(r10);
            r3.append(r11);
            r10 = r3.toString();
        L_0x009d:
            if (r2 != 0) goto L_0x00d4;
        L_0x009f:
            r9 = new com.xunlei.common.new_ptl.pay.param.XLWxPayParam;	 Catch:{ Throwable -> 0x0109 }
            r9.<init>();	 Catch:{ Throwable -> 0x0109 }
            r2 = "wx3e6556568beeebdd";	 Catch:{ Throwable -> 0x0109 }
            r9.mAppId = r2;	 Catch:{ Throwable -> 0x0109 }
            r2 = "live";	 Catch:{ Throwable -> 0x0109 }
            r9.mBizNo = r2;	 Catch:{ Throwable -> 0x0109 }
            r9.mNum = r0;	 Catch:{ Throwable -> 0x0109 }
            r0 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ Throwable -> 0x0109 }
            r0 = r0.g;	 Catch:{ Throwable -> 0x0109 }
            r2 = r0.c();	 Catch:{ Throwable -> 0x0109 }
            r0 = (int) r2;	 Catch:{ Throwable -> 0x0109 }
            r2 = (long) r0;	 Catch:{ Throwable -> 0x0109 }
            r9.mUserId = r2;	 Catch:{ Throwable -> 0x0109 }
            r0 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ Throwable -> 0x0109 }
            r0 = r0.c();	 Catch:{ Throwable -> 0x0109 }
            r9.mSessionId = r0;	 Catch:{ Throwable -> 0x0109 }
            r10 = android.net.Uri.encode(r10);	 Catch:{ Throwable -> 0x0109 }
            r9.mParamExt = r10;	 Catch:{ Throwable -> 0x0109 }
            r10 = com.xunlei.common.new_ptl.pay.XLPayUtil.getInstance();	 Catch:{ Throwable -> 0x0109 }
            r10.userWxPay(r9, r11);	 Catch:{ Throwable -> 0x0109 }
            goto L_0x0109;	 Catch:{ Throwable -> 0x0109 }
        L_0x00d4:
            r3 = 1;	 Catch:{ Throwable -> 0x0109 }
            if (r2 != r3) goto L_0x0109;	 Catch:{ Throwable -> 0x0109 }
        L_0x00d7:
            r2 = new com.xunlei.common.new_ptl.pay.param.XLAlipayParam;	 Catch:{ Throwable -> 0x0109 }
            r2.<init>();	 Catch:{ Throwable -> 0x0109 }
            r3 = "live";	 Catch:{ Throwable -> 0x0109 }
            r2.mBizNo = r3;	 Catch:{ Throwable -> 0x0109 }
            r2.mNum = r0;	 Catch:{ Throwable -> 0x0109 }
            r0 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ Throwable -> 0x0109 }
            r0 = r0.g;	 Catch:{ Throwable -> 0x0109 }
            r3 = r0.c();	 Catch:{ Throwable -> 0x0109 }
            r0 = (int) r3;	 Catch:{ Throwable -> 0x0109 }
            r3 = (long) r0;	 Catch:{ Throwable -> 0x0109 }
            r2.mUserId = r3;	 Catch:{ Throwable -> 0x0109 }
            r0 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ Throwable -> 0x0109 }
            r0 = r0.c();	 Catch:{ Throwable -> 0x0109 }
            r2.mSessionId = r0;	 Catch:{ Throwable -> 0x0109 }
            r2.mActivity = r9;	 Catch:{ Throwable -> 0x0109 }
            r9 = android.net.Uri.encode(r10);	 Catch:{ Throwable -> 0x0109 }
            r2.mParamExt = r9;	 Catch:{ Throwable -> 0x0109 }
            r9 = com.xunlei.common.new_ptl.pay.XLPayUtil.getInstance();	 Catch:{ Throwable -> 0x0109 }
            r9.userAliPay(r2, r11);	 Catch:{ Throwable -> 0x0109 }
        L_0x0109:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.LivePluginHostRoute.6.action(android.content.Context, java.lang.String, android.net.Uri):int");
        }
    };
    IRoute queryHostInfo = new IRoute() {
        public int action(Context context, String str, Uri uri) {
            LivePluginAppRouteDispatcher.fireInitEvent(AndroidConfig.getHubbleDeviceGUID(), MainTabActivity.class.getName());
            return null;
        }
    };
    IRoute queryUserInfo = new IRoute() {
        public int action(Context context, String str, Uri uri) {
            LivePluginHostRoute.this.mLoginHelper;
            if (l.b() != null) {
                LivePluginHostRoute.this.mLoginHelper.b();
            }
            return null;
        }
    };
    IRoute share = new IRoute() {
        public int action(Context context, String str, Uri uri) {
            final int param = UriUtil.getParam(uri, "platform", 0);
            final String param2 = UriUtil.getParam(uri, "shareUrl", "");
            final String param3 = UriUtil.getParam(uri, "imageUrl", "");
            final String param4 = UriUtil.getParam(uri, "title", "");
            final String param5 = UriUtil.getParam(uri, "content", "");
            ActivityHelper.transform(context, new ActivityHelper() {
                int resumeCount;

                public void onActivityCreated(final android.app.Activity r5, android.os.Bundle r6) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r4 = this;
                    r6 = r3;	 Catch:{ Throwable -> 0x0055 }
                    r0 = 1;	 Catch:{ Throwable -> 0x0055 }
                    if (r6 != r0) goto L_0x0008;	 Catch:{ Throwable -> 0x0055 }
                L_0x0005:
                    r6 = com.xunlei.downloadprovidershare.ShareOperationType.WEIXIN;	 Catch:{ Throwable -> 0x0055 }
                    goto L_0x0027;	 Catch:{ Throwable -> 0x0055 }
                L_0x0008:
                    r6 = r3;	 Catch:{ Throwable -> 0x0055 }
                    r0 = 2;	 Catch:{ Throwable -> 0x0055 }
                    if (r6 == r0) goto L_0x0025;	 Catch:{ Throwable -> 0x0055 }
                L_0x000d:
                    r6 = r3;	 Catch:{ Throwable -> 0x0055 }
                    r0 = 3;	 Catch:{ Throwable -> 0x0055 }
                    if (r6 != r0) goto L_0x0015;	 Catch:{ Throwable -> 0x0055 }
                L_0x0012:
                    r6 = com.xunlei.downloadprovidershare.ShareOperationType.SINA;	 Catch:{ Throwable -> 0x0055 }
                    goto L_0x0027;	 Catch:{ Throwable -> 0x0055 }
                L_0x0015:
                    r6 = r3;	 Catch:{ Throwable -> 0x0055 }
                    r0 = 4;	 Catch:{ Throwable -> 0x0055 }
                    if (r6 != r0) goto L_0x001d;	 Catch:{ Throwable -> 0x0055 }
                L_0x001a:
                    r6 = com.xunlei.downloadprovidershare.ShareOperationType.QZONE;	 Catch:{ Throwable -> 0x0055 }
                    goto L_0x0027;	 Catch:{ Throwable -> 0x0055 }
                L_0x001d:
                    r6 = r3;	 Catch:{ Throwable -> 0x0055 }
                    r0 = 5;	 Catch:{ Throwable -> 0x0055 }
                    if (r6 != r0) goto L_0x0025;	 Catch:{ Throwable -> 0x0055 }
                L_0x0022:
                    r6 = com.xunlei.downloadprovidershare.ShareOperationType.QQ;	 Catch:{ Throwable -> 0x0055 }
                    goto L_0x0027;	 Catch:{ Throwable -> 0x0055 }
                L_0x0025:
                    r6 = com.xunlei.downloadprovidershare.ShareOperationType.WEIXIN_CIRCLE;	 Catch:{ Throwable -> 0x0055 }
                L_0x0027:
                    r0 = com.xunlei.xllib.android.b.a(r5);	 Catch:{ Throwable -> 0x0055 }
                    if (r0 != 0) goto L_0x0036;	 Catch:{ Throwable -> 0x0055 }
                L_0x002d:
                    r6 = "无网络连接";	 Catch:{ Throwable -> 0x0055 }
                    com.xunlei.common.commonview.XLToast.showToast(r5, r6);	 Catch:{ Throwable -> 0x0055 }
                    r5.finish();	 Catch:{ Throwable -> 0x0055 }
                    return;	 Catch:{ Throwable -> 0x0055 }
                L_0x0036:
                    r0 = new com.xunlei.downloadprovidershare.a.f;	 Catch:{ Throwable -> 0x0055 }
                    r1 = "xllive";	 Catch:{ Throwable -> 0x0055 }
                    r2 = r4;	 Catch:{ Throwable -> 0x0055 }
                    r3 = r5;	 Catch:{ Throwable -> 0x0055 }
                    r0.<init>(r1, r2, r3);	 Catch:{ Throwable -> 0x0055 }
                    r1 = r6;	 Catch:{ Throwable -> 0x0055 }
                    r0.h = r1;	 Catch:{ Throwable -> 0x0055 }
                    r1 = r7;	 Catch:{ Throwable -> 0x0055 }
                    r0.d = r1;	 Catch:{ Throwable -> 0x0055 }
                    com.xunlei.downloadprovider.f.a.a();	 Catch:{ Throwable -> 0x0055 }
                    r1 = new com.xunlei.tdlive.LivePluginHostRoute$5$1$1;	 Catch:{ Throwable -> 0x0055 }
                    r1.<init>(r5);	 Catch:{ Throwable -> 0x0055 }
                    com.xunlei.downloadprovider.f.a.a(r5, r6, r0, r1);	 Catch:{ Throwable -> 0x0055 }
                    return;
                L_0x0055:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.LivePluginHostRoute.5.1.onActivityCreated(android.app.Activity, android.os.Bundle):void");
                }

                public void onActivityResumed(Activity activity) {
                    int i = this.resumeCount;
                    this.resumeCount = i + 1;
                    if (i > 0) {
                        activity.finish();
                    }
                }

                public void onActivityResult(android.app.Activity r1, int r2, int r3, android.content.Intent r4) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = this;
                    r1 = com.umeng.socialize.UMShareAPI.get(r1);	 Catch:{ Throwable -> 0x0008 }
                    r1.onActivityResult(r2, r3, r4);	 Catch:{ Throwable -> 0x0008 }
                    return;
                L_0x0008:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.LivePluginHostRoute.5.1.onActivityResult(android.app.Activity, int, int, android.content.Intent):void");
                }
            });
            return 0;
        }
    };
    IRoute showHomePage = new IRoute() {
        public int action(Context context, String str, Uri uri) {
            MainTabActivity.b(LivePluginHostRoute.this.getContext(), "thunder", null);
            return null;
        }
    };
    IRoute showLivePage = new IRoute() {
        public int action(Context context, String str, Uri uri) {
            MainTabActivity.b(LivePluginHostRoute.this.getContext(), "xllive", null);
            return null;
        }
    };
    IRoute showUserCenter = new IRoute() {
        public int action(Context context, String str, Uri uri) {
            try {
                Context c = AppStatusChgObserver.b().c();
                context = UriUtil.getParam(uri, "userid", "");
                m.a(c, Long.valueOf(context).longValue(), "rad", UriUtil.getParam(uri, "nickname", ""), UriUtil.getParam(uri, "avatar", ""), From.XL_LIVE);
                Map hashMap = new HashMap();
                hashMap.put("userid", context);
                ThunderStator.traceEvent(LivePluginHostRoute.this.getContext(), "center_page_show", UriUtil.getParam(uri, "from", ""), null, hashMap);
            } catch (Context context2) {
                context2.printStackTrace();
            }
            return null;
        }
    };
    IRoute traceEvent = new IRoute() {
        public int action(Context context, String str, Uri uri) {
            context = new HashMap();
            for (String str2 : uri.getQueryParameterNames()) {
                if (!(str2.equals(com.alipay.sdk.cons.c.e) || str2.equals("attr1") || str2.equals("attr2"))) {
                    context.put(str2, UriUtil.getParam(uri, str2, ""));
                }
            }
            ThunderStator.getInstance().traceEvent(UriUtil.getParam(uri, com.alipay.sdk.cons.c.e, ""), UriUtil.getParam(uri, "attr1", ""), UriUtil.getParam(uri, "attr2", ""), context);
            return null;
        }
    };

    public LivePluginHostRoute(Context context) {
        super(context);
        LocalBroadcastManager.getInstance(context).registerReceiver(this.broadcastReceiver, new IntentFilter("com.xunlei.tdlive.plugin.app.onActivityResult"));
    }

    protected void onInit(Route route) {
        route.register("xllive.plugin.host://queryHostInfo", this.queryHostInfo);
        route.register("xllive.plugin.host://share", this.share);
        route.register("xllive.plugin.host://pay", this.pay);
        route.register("xllive.plugin.host://login", this.login);
        route.register("xllive.plugin.host://authPhone", this.authPhone);
        route.register("xllive.plugin.host://queryUserInfo", this.queryUserInfo);
        route.register("xllive.plugin.host://showUserCenter", this.showUserCenter);
        route.register("xllive.plugin.host://showHomePage", this.showHomePage);
        route.register("xllive.plugin.host://showLivePage", this.showLivePage);
        route.register("xllive.plugin.host://notifyLiveRoomShow", this.notifyLiveRoomShow);
        route.register("xllive.plugin.host://traceEvent", this.traceEvent);
        route.register("xllive.plugin.host://download", this.download);
        route.register("xllive.plugin.host://limitSpeed", this.limitSpeed);
    }
}
