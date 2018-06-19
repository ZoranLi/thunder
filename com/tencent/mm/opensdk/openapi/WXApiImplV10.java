package com.tencent.mm.opensdk.openapi;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.opensdk.a.d;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.channel.a.a.a;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.mm.opensdk.modelbiz.HandleScanResult;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.wxop.stat.MtaSDkException;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatReportStrategy;
import com.tencent.wxop.stat.StatService;
import com.tencent.wxop.stat.common.StatConstants;
import com.xunlei.download.proguard.c;

final class WXApiImplV10 implements IWXAPI {
    private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static ActivityLifecycleCb activityCb;
    private static String wxappPayEntryClassname;
    private String appId;
    private boolean checkSignature = false;
    private Context context;
    private boolean detached = false;

    private static final class ActivityLifecycleCb implements ActivityLifecycleCallbacks {
        private static final int DELAYED = 800;
        private static final String TAG = "MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb";
        private Context context;
        private Handler handler;
        private boolean isForeground;
        private Runnable onPausedRunnable;
        private Runnable onResumedRunnable;

        private ActivityLifecycleCb(Context context) {
            this.isForeground = false;
            this.handler = new Handler(Looper.getMainLooper());
            this.onPausedRunnable = new Runnable() {
                public void run() {
                    if (WXApiImplV10.activityCb != null && ActivityLifecycleCb.this.isForeground) {
                        StatService.trackCustomKVEvent(ActivityLifecycleCb.this.context, "onBackground_WX", null);
                        ActivityLifecycleCb.this.isForeground = false;
                    }
                }
            };
            this.onResumedRunnable = new Runnable() {
                public void run() {
                    if (WXApiImplV10.activityCb != null && !ActivityLifecycleCb.this.isForeground) {
                        StatService.trackCustomKVEvent(ActivityLifecycleCb.this.context, "onForeground_WX", null);
                        ActivityLifecycleCb.this.isForeground = true;
                    }
                }
            };
            this.context = context;
        }

        public final void detach() {
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.context = null;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(activity.getComponentName().getClassName());
            stringBuilder.append("  onActivityPaused");
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.postDelayed(this.onPausedRunnable, 800);
        }

        public final void onActivityResumed(Activity activity) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(activity.getComponentName().getClassName());
            stringBuilder.append("  onActivityResumed");
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.handler.postDelayed(this.onResumedRunnable, 800);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }
    }

    WXApiImplV10(Context context, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("<init>, appId = ");
        stringBuilder.append(str);
        stringBuilder.append(", checkSignature = ");
        stringBuilder.append(z);
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkSumConsistent(byte[] r5, byte[] r6) {
        /*
        r4 = this;
        r0 = 0;
        if (r5 == 0) goto L_0x0021;
    L_0x0003:
        r1 = r5.length;
        if (r1 == 0) goto L_0x0021;
    L_0x0006:
        if (r6 == 0) goto L_0x0021;
    L_0x0008:
        r1 = r6.length;
        if (r1 != 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r1 = r5.length;
        r2 = r6.length;
        if (r1 == r2) goto L_0x0011;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0;
    L_0x0012:
        r2 = r5.length;
        if (r1 >= r2) goto L_0x001f;
    L_0x0015:
        r2 = r5[r1];
        r3 = r6[r1];
        if (r2 == r3) goto L_0x001c;
    L_0x001b:
        return r0;
    L_0x001c:
        r1 = r1 + 1;
        goto L_0x0012;
    L_0x001f:
        r5 = 1;
        return r5;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.openapi.WXApiImplV10.checkSumConsistent(byte[], byte[]):boolean");
    }

    private boolean createChatroom(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private void initMta(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder("AWXOP");
        stringBuilder.append(str);
        str = stringBuilder.toString();
        StatConfig.setAppKey(context, str);
        StatConfig.setEnableSmartReporting(true);
        StatConfig.setStatSendStrategy(StatReportStrategy.PERIOD);
        StatConfig.setSendPeriodMinutes(60);
        StatConfig.setInstallChannel(context, "Wechat_Sdk");
        try {
            StatService.startStatService(context, str, StatConstants.VERSION);
        } catch (MtaSDkException e) {
            new StringBuilder("initMta exception:").append(e.getMessage());
        }
    }

    private boolean joinChatroom(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendAddCardToWX(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendChooseCardFromWX(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendHandleScanResult(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizProfileReq(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        String[] strArr = new String[5];
        strArr[0] = this.appId;
        strArr[1] = bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
        strArr[2] = bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_scene"));
        strArr[3] = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type"));
        strArr[4] = stringBuilder.toString();
        Cursor query = contentResolver.query(parse, null, null, strArr, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizTempSessionReq(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession");
        String[] strArr = new String[4];
        strArr[0] = this.appId;
        strArr[1] = bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name");
        strArr[2] = bundle.getString("_wxapi_jump_to_biz_webview_req_session_from");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_show_type"));
        strArr[3] = stringBuilder.toString();
        Cursor query = contentResolver.query(parse, null, null, strArr, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizWebviewReq(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        String[] strArr = new String[4];
        strArr[0] = this.appId;
        strArr[1] = bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name");
        strArr[2] = bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_scene"));
        strArr[3] = stringBuilder.toString();
        Cursor query = contentResolver.query(parse, null, null, strArr, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenWebview(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context).getString("_wxapp_pay_entry_classname_", null);
            new StringBuilder("pay, set wxappPayEntryClassname = ").append(wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                } catch (Exception e) {
                    new StringBuilder("get from metaData failed : ").append(e.getMessage());
                }
            }
            if (wxappPayEntryClassname == null) {
                return false;
            }
        }
        Args args = new Args();
        args.bundle = bundle;
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = wxappPayEntryClassname;
        return MMessageActV2.send(context, args);
    }

    public final void detach() {
        this.detached = true;
        if (activityCb != null && VERSION.SDK_INT >= 14) {
            Application application;
            if (this.context instanceof Activity) {
                application = ((Activity) this.context).getApplication();
            } else {
                if (this.context instanceof Service) {
                    application = ((Service) this.context).getApplication();
                }
                activityCb.detach();
            }
            application.unregisterActivityLifecycleCallbacks(activityCb);
            activityCb.detach();
        }
        this.context = null;
    }

    public final int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        } else if (!isWXAppInstalled()) {
            return 0;
        } else {
            int i = new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
            if (i == 0) {
                try {
                    return this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
                } catch (Exception e) {
                    new StringBuilder("get from metaData failed : ").append(e.getMessage());
                }
            }
            return i;
        }
    }

    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        try {
            if (!WXApiImplComm.isIntentFromWx(intent, Token.WX_TOKEN_VALUE_MSG)) {
                return false;
            }
            if (this.detached) {
                throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
            }
            String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
            int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
            String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
            if (stringExtra2 == null || stringExtra2.length() == 0 || !checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), b.a(stringExtra, intExtra, stringExtra2))) {
                return false;
            }
            switch (intent.getIntExtra("_wxapi_command_type", 0)) {
                case 1:
                    iWXAPIEventHandler.onResp(new Resp(intent.getExtras()));
                    return true;
                case 2:
                    iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                    return true;
                case 3:
                    iWXAPIEventHandler.onReq(new Req(intent.getExtras()));
                    return true;
                case 4:
                    iWXAPIEventHandler.onReq(new ShowMessageFromWX.Req(intent.getExtras()));
                    return true;
                case 5:
                    iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                    return true;
                case 6:
                    iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                    return true;
                case 9:
                    iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                    return true;
                case 12:
                    iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                    return true;
                case 14:
                    iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                    return true;
                case 15:
                    iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                    return true;
                case 16:
                    iWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(intent.getExtras()));
                    return true;
                case 17:
                    iWXAPIEventHandler.onResp(new HandleScanResult.Resp(intent.getExtras()));
                    return true;
                default:
                    return false;
            }
        } catch (Exception e) {
            new StringBuilder("handleIntent fail, ex = ").append(e.getMessage());
            return false;
        }
    }

    public final boolean isWXAppInstalled() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.detached;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalStateException;
        r1 = "isWXAppInstalled fail, WXMsgImpl has been detached";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = 0;
        r1 = r4.context;	 Catch:{ NameNotFoundException -> 0x0029 }
        r1 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0029 }
        r2 = "com.tencent.mm";	 Catch:{ NameNotFoundException -> 0x0029 }
        r3 = 64;	 Catch:{ NameNotFoundException -> 0x0029 }
        r1 = r1.getPackageInfo(r2, r3);	 Catch:{ NameNotFoundException -> 0x0029 }
        if (r1 != 0) goto L_0x001e;	 Catch:{ NameNotFoundException -> 0x0029 }
    L_0x001d:
        return r0;	 Catch:{ NameNotFoundException -> 0x0029 }
    L_0x001e:
        r2 = r4.context;	 Catch:{ NameNotFoundException -> 0x0029 }
        r1 = r1.signatures;	 Catch:{ NameNotFoundException -> 0x0029 }
        r3 = r4.checkSignature;	 Catch:{ NameNotFoundException -> 0x0029 }
        r1 = com.tencent.mm.opensdk.openapi.WXApiImplComm.validateAppSignature(r2, r1, r3);	 Catch:{ NameNotFoundException -> 0x0029 }
        return r1;
    L_0x0029:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.openapi.WXApiImplV10.isWXAppInstalled():boolean");
    }

    public final boolean isWXAppSupportAPI() {
        if (!this.detached) {
            return getWXAppSupportAPI() >= Build.SDK_INT;
        } else {
            throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
    }

    public final boolean openWXApp() {
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        } else if (!isWXAppInstalled()) {
            return false;
        } else {
            try {
                this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                return true;
            } catch (Exception e) {
                new StringBuilder("startActivity fail, exception = ").append(e.getMessage());
                return false;
            }
        }
    }

    public final boolean registerApp(String str) {
        return registerApp(str, 0);
    }

    public final boolean registerApp(String str, long j) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            return false;
        } else {
            if (str != null) {
                this.appId = str;
            }
            if (activityCb == null && VERSION.SDK_INT >= 14) {
                Application application;
                if (this.context instanceof Activity) {
                    initMta(this.context, str);
                    activityCb = new ActivityLifecycleCb(this.context);
                    application = ((Activity) this.context).getApplication();
                } else if (this.context instanceof Service) {
                    initMta(this.context, str);
                    activityCb = new ActivityLifecycleCb(this.context);
                    application = ((Service) this.context).getApplication();
                }
                application.registerActivityLifecycleCallbacks(activityCb);
            }
            if (str != null) {
                this.appId = str;
            }
            new StringBuilder("register app ").append(this.context.getPackageName());
            a aVar = new a();
            aVar.W = "com.tencent.mm";
            aVar.X = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
            StringBuilder stringBuilder = new StringBuilder("weixin://registerapp?appid=");
            stringBuilder.append(this.appId);
            aVar.content = stringBuilder.toString();
            aVar.Y = j;
            return com.tencent.mm.opensdk.channel.a.a.a(this.context, aVar);
        }
    }

    public final boolean sendReq(BaseReq baseReq) {
        if (this.detached) {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature) || !baseReq.checkArgs()) {
            return false;
        } else {
            new StringBuilder("sendReq, req type = ").append(baseReq.getType());
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            if (baseReq.getType() == 5) {
                return sendPayReq(this.context, bundle);
            }
            if (baseReq.getType() == 7) {
                return sendJumpToBizProfileReq(this.context, bundle);
            }
            if (baseReq.getType() == 8) {
                return sendJumpToBizWebviewReq(this.context, bundle);
            }
            if (baseReq.getType() == 10) {
                return sendJumpToBizTempSessionReq(this.context, bundle);
            }
            if (baseReq.getType() == 9) {
                return sendAddCardToWX(this.context, bundle);
            }
            if (baseReq.getType() == 16) {
                return sendChooseCardFromWX(this.context, bundle);
            }
            if (baseReq.getType() == 11) {
                return sendOpenRankListReq(this.context, bundle);
            }
            if (baseReq.getType() == 12) {
                return sendOpenWebview(this.context, bundle);
            }
            if (baseReq.getType() == 13) {
                return sendOpenBusiLuckyMoney(this.context, bundle);
            }
            if (baseReq.getType() == 14) {
                return createChatroom(this.context, bundle);
            }
            if (baseReq.getType() == 15) {
                return joinChatroom(this.context, bundle);
            }
            if (baseReq.getType() == 17) {
                return sendHandleScanResult(this.context, bundle);
            }
            if (baseReq.getType() == 2 && bundle.getInt("_wxapi_sendmessagetowx_req_media_type") == 36) {
                SendMessageToWX.Req req = (SendMessageToWX.Req) baseReq;
                if (getWXAppSupportAPI() < Build.MINIPROGRAM_SUPPORT_SDK_INT) {
                    IMediaObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                    req.message.mediaObject = wXWebpageObject;
                } else {
                    WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) req.message.mediaObject;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(wXMiniProgramObject.userName);
                    stringBuilder.append("@app");
                    wXMiniProgramObject.userName = stringBuilder.toString();
                    String str = wXMiniProgramObject.path;
                    if (!d.h(str)) {
                        String[] split = str.split("\\?");
                        if (split.length > 1) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(split[0]);
                            stringBuilder2.append(".html?");
                            stringBuilder2.append(split[1]);
                            str = stringBuilder2.toString();
                        } else {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(split[0]);
                            stringBuilder3.append(c.m);
                            str = stringBuilder3.toString();
                        }
                        wXMiniProgramObject.path = str;
                    }
                }
                req.scene = 0;
                baseReq.toBundle(bundle);
            }
            Args args = new Args();
            args.bundle = bundle;
            StringBuilder stringBuilder4 = new StringBuilder("weixin://sendreq?appid=");
            stringBuilder4.append(this.appId);
            args.content = stringBuilder4.toString();
            args.targetPkgName = "com.tencent.mm";
            args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return MMessageActV2.send(this.context, args);
        }
    }

    public final boolean sendResp(BaseResp baseResp) {
        if (this.detached) {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature) || !baseResp.checkArgs()) {
            return false;
        } else {
            Bundle bundle = new Bundle();
            baseResp.toBundle(bundle);
            Args args = new Args();
            args.bundle = bundle;
            StringBuilder stringBuilder = new StringBuilder("weixin://sendresp?appid=");
            stringBuilder.append(this.appId);
            args.content = stringBuilder.toString();
            args.targetPkgName = "com.tencent.mm";
            args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return MMessageActV2.send(this.context, args);
        }
    }

    public final void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        } else if (WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            new StringBuilder("unregisterApp, appId = ").append(this.appId);
            if (this.appId != null && this.appId.length() != 0) {
                new StringBuilder("unregister app ").append(this.context.getPackageName());
                a aVar = new a();
                aVar.W = "com.tencent.mm";
                aVar.X = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
                StringBuilder stringBuilder = new StringBuilder("weixin://unregisterapp?appid=");
                stringBuilder.append(this.appId);
                aVar.content = stringBuilder.toString();
                com.tencent.mm.opensdk.channel.a.a.a(this.context, aVar);
            }
        }
    }
}
