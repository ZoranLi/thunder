package org.android.agoo.control;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.client.a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
public abstract class BaseIntentService extends IntentService {
    private static final String TAG = "BaseIntentService";
    private static final String msgStatus = "4";
    private AgooFactory agooFactory;
    private Context mContext = null;
    private MessageService messageService;
    private NotifManager notifyManager;

    public abstract void onError(Context context, String str);

    public abstract void onMessage(Context context, Intent intent);

    public abstract void onRegistered(Context context, String str);

    protected void onUserCommand(Context context, Intent intent) {
    }

    public BaseIntentService() {
        super("AgooIntentService");
    }

    public void onCreate() {
        a.g.incrementAndGet();
        this.notifyManager = new NotifManager();
        this.notifyManager.init(getApplicationContext());
        this.messageService = new MessageService();
        this.messageService.a(getApplicationContext());
        this.agooFactory = new AgooFactory();
        this.agooFactory.init(getApplicationContext(), this.notifyManager, this.messageService);
        super.onCreate();
    }

    protected void onHandleIntent(Intent intent) {
        this.mContext = getApplicationContext();
        if (intent != null) {
            CharSequence action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                CharSequence agooCommand = IntentUtil.getAgooCommand(this.mContext);
                CharSequence thirdPushCommand = IntentUtil.getThirdPushCommand(this.mContext);
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("onHandleIntent,action=");
                stringBuilder.append(action);
                stringBuilder.append(",agooCommand=");
                stringBuilder.append(agooCommand);
                stringBuilder.append(",mipushCommand=");
                stringBuilder.append(thirdPushCommand);
                ALog.i(str, stringBuilder.toString(), new Object[0]);
                try {
                    StringBuilder stringBuilder2;
                    if (TextUtils.equals(action, agooCommand)) {
                        action = intent.getStringExtra("command");
                        String str2 = TAG;
                        stringBuilder2 = new StringBuilder("actionCommand --->[");
                        stringBuilder2.append(action);
                        stringBuilder2.append("]");
                        ALog.d(str2, stringBuilder2.toString(), new Object[0]);
                        if (TextUtils.equals(action, AgooConstants.AGOO_COMMAND_MESSAGE_READED) || TextUtils.equals(action, AgooConstants.AGOO_COMMAND_MESSAGE_DELETED)) {
                            onUserCommand(this.mContext, intent);
                        }
                    } else if (TextUtils.equals(action, thirdPushCommand)) {
                        action = intent.getStringExtra("command");
                        intent = intent.getStringExtra(AgooConstants.THIRD_PUSH_ID);
                        if (TextUtils.equals(action, AgooConstants.AGOO_COMMAND_MIPUSHID_REPORT)) {
                            this.notifyManager.reportThirdPushToken(intent, "MI_TOKEN", false);
                        } else if (TextUtils.equals(action, AgooConstants.AGOO_COMMAND_HUAWEIPUSHID_REPORT)) {
                            r0 = TAG;
                            r1 = new StringBuilder("HW_TOKEN report begin..regid=");
                            r1.append(intent);
                            ALog.d(r0, r1.toString(), new Object[0]);
                            this.notifyManager.reportThirdPushToken(intent, "HW_TOKEN", false);
                        } else if (TextUtils.equals(action, AgooConstants.AGOO_COMMAND_GCMIPUSHID_REPORT)) {
                            r0 = TAG;
                            r1 = new StringBuilder("GCM_TOKEN report begin..regid=");
                            r1.append(intent);
                            ALog.i(r0, r1.toString(), new Object[0]);
                            this.notifyManager.reportThirdPushToken(intent, "gcm", false);
                        }
                    } else if (action.equals(AgooConstants.INTENT_FROM_AGOO_MESSAGE)) {
                        handleRemoteMessage(this.mContext, intent);
                    } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                        handleRemovePackage(this.mContext, intent);
                    } else if (!(TextUtils.equals(action, AgooConstants.INTENT_FROM_AGOO_REPORT) == null && TextUtils.equals(action, PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) == null && TextUtils.equals(action, PushConsts.ACTION_BROADCAST_TO_BOOT) == null && TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED") == null && TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") == null && TextUtils.equals(action, PushConsts.ACTION_BROADCAST_USER_PRESENT) == null && TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED") == null && TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED") == null)) {
                        intent = TAG;
                        StringBuilder stringBuilder3 = new StringBuilder("is report cache msg,Config.isReportCacheMsg(mContext)=");
                        stringBuilder3.append(Config.c(this.mContext));
                        ALog.i(intent, stringBuilder3.toString(), new Object[0]);
                        if (!(Config.c(this.mContext) == null || com.taobao.accs.utl.a.c(this.mContext) == null)) {
                            Config.d(this.mContext);
                            this.agooFactory.reportCacheMsg();
                            this.messageService.a();
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (ALog.isPrintLog(Level.I) != null) {
                            intent = TAG;
                            stringBuilder2 = new StringBuilder("is clear all msg=");
                            stringBuilder2.append(Config.b(this.mContext, currentTimeMillis));
                            ALog.i(intent, stringBuilder2.toString(), new Object[0]);
                        }
                        if (Config.b(this.mContext, currentTimeMillis) != null) {
                            Config.a(this.mContext, currentTimeMillis);
                            this.messageService.a();
                        }
                    }
                } catch (Intent intent2) {
                    try {
                        if (ALog.isPrintLog(Level.E)) {
                            ALog.e(TAG, "onHandleIntent deal error", intent2, new Object[0]);
                        }
                    } catch (Throwable th) {
                        a.g.incrementAndGet();
                    }
                }
                a.g.incrementAndGet();
            }
        }
    }

    private final void handleRemovePackage(Context context, Intent intent) {
        if (intent != null) {
            if (context != null) {
                context = null;
                Uri data = intent.getData();
                if (data != null) {
                    context = data.getSchemeSpecificPart();
                }
                if (!TextUtils.isEmpty(context)) {
                    intent = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                    if (ALog.isPrintLog(Level.D)) {
                        String str = TAG;
                        StringBuilder stringBuilder = new StringBuilder("handleRemovePackage---->[replacing:");
                        stringBuilder.append(intent);
                        stringBuilder.append("],uninstallPack=");
                        stringBuilder.append(context);
                        ALog.d(str, stringBuilder.toString(), new Object[0]);
                    }
                    if (intent == null) {
                        this.notifyManager.doUninstall(context, intent);
                    }
                }
            }
        }
    }

    private final void handleRemoteMessage(android.content.Context r30, android.content.Intent r31) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r29 = this;
        r1 = r29;
        r2 = r31;
        r5 = "id";	 Catch:{ Throwable -> 0x0333 }
        r5 = r2.getStringExtra(r5);	 Catch:{ Throwable -> 0x0333 }
        r6 = "body";	 Catch:{ Throwable -> 0x0333 }
        r6 = r2.getStringExtra(r6);	 Catch:{ Throwable -> 0x0333 }
        r7 = "type";	 Catch:{ Throwable -> 0x0333 }
        r7 = r2.getStringExtra(r7);	 Catch:{ Throwable -> 0x0333 }
        r8 = "message_source";	 Catch:{ Throwable -> 0x0333 }
        r8 = r2.getStringExtra(r8);	 Catch:{ Throwable -> 0x0333 }
        r9 = "report";	 Catch:{ Throwable -> 0x0333 }
        r9 = r2.getStringExtra(r9);	 Catch:{ Throwable -> 0x0333 }
        r10 = "encrypted";	 Catch:{ Throwable -> 0x0333 }
        r10 = r2.getStringExtra(r10);	 Catch:{ Throwable -> 0x0333 }
        r11 = "extData";	 Catch:{ Throwable -> 0x0333 }
        r11 = r2.getStringExtra(r11);	 Catch:{ Throwable -> 0x0333 }
        r12 = "oriData";	 Catch:{ Throwable -> 0x0333 }
        r12 = r2.getStringExtra(r12);	 Catch:{ Throwable -> 0x0333 }
        r15 = "trace";	 Catch:{ Throwable -> 0x0085 }
        r3 = -1;	 Catch:{ Throwable -> 0x0085 }
        r3 = r2.getLongExtra(r15, r3);	 Catch:{ Throwable -> 0x0085 }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ Throwable -> 0x0085 }
        r3 = r3.longValue();	 Catch:{ Throwable -> 0x0085 }
        r15 = r30;
        r1.getTrace(r15, r3);	 Catch:{ Throwable -> 0x0083 }
        r3 = "msg_agoo_bundle";	 Catch:{ Throwable -> 0x0083 }
        r3 = r2.getBundleExtra(r3);	 Catch:{ Throwable -> 0x0083 }
        if (r3 == 0) goto L_0x005a;	 Catch:{ Throwable -> 0x0083 }
    L_0x0051:
        r4 = "accs_extra";	 Catch:{ Throwable -> 0x0083 }
        r3 = r3.getSerializable(r4);	 Catch:{ Throwable -> 0x0083 }
        r3 = (com.taobao.accs.base.TaoBaseService.ExtraInfo) r3;	 Catch:{ Throwable -> 0x0083 }
        goto L_0x005b;
    L_0x005a:
        r3 = 0;
    L_0x005b:
        r4 = "source";	 Catch:{ Throwable -> 0x007d }
        r4 = r2.getStringExtra(r4);	 Catch:{ Throwable -> 0x007d }
        r16 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0078 }
        if (r16 == 0) goto L_0x006a;	 Catch:{ Throwable -> 0x0078 }
    L_0x0067:
        r16 = "oldsdk";	 Catch:{ Throwable -> 0x0078 }
        goto L_0x006c;
    L_0x006a:
        r16 = r4;
    L_0x006c:
        r4 = "fromAppkey";	 Catch:{ Throwable -> 0x0076 }
        r4 = r2.getStringExtra(r4);	 Catch:{ Throwable -> 0x0076 }
        r13 = r3;
        r3 = r16;
        goto L_0x00a9;
    L_0x0076:
        r0 = move-exception;
        goto L_0x007b;
    L_0x0078:
        r0 = move-exception;
        r16 = r4;
    L_0x007b:
        r4 = r3;
        goto L_0x0081;
    L_0x007d:
        r0 = move-exception;
        r4 = r3;
        r16 = 0;
    L_0x0081:
        r3 = r0;
        goto L_0x008c;
    L_0x0083:
        r0 = move-exception;
        goto L_0x0088;
    L_0x0085:
        r0 = move-exception;
        r15 = r30;
    L_0x0088:
        r3 = r0;
        r4 = 0;
        r16 = 0;
    L_0x008c:
        r13 = "BaseIntentService";	 Catch:{ Throwable -> 0x0333 }
        r14 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0333 }
        r18 = r4;	 Catch:{ Throwable -> 0x0333 }
        r4 = "_trace,t=";	 Catch:{ Throwable -> 0x0333 }
        r14.<init>(r4);	 Catch:{ Throwable -> 0x0333 }
        r14.append(r3);	 Catch:{ Throwable -> 0x0333 }
        r3 = r14.toString();	 Catch:{ Throwable -> 0x0333 }
        r4 = 0;	 Catch:{ Throwable -> 0x0333 }
        r14 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.ALog.e(r13, r3, r14);	 Catch:{ Throwable -> 0x0333 }
        r3 = r16;	 Catch:{ Throwable -> 0x0333 }
        r13 = r18;	 Catch:{ Throwable -> 0x0333 }
        r4 = 0;	 Catch:{ Throwable -> 0x0333 }
    L_0x00a9:
        r14 = com.taobao.accs.utl.ALog.Level.I;	 Catch:{ Throwable -> 0x0333 }
        r14 = com.taobao.accs.utl.ALog.isPrintLog(r14);	 Catch:{ Throwable -> 0x0333 }
        r19 = r7;	 Catch:{ Throwable -> 0x0333 }
        r16 = 1;	 Catch:{ Throwable -> 0x0333 }
        if (r14 == 0) goto L_0x0101;	 Catch:{ Throwable -> 0x0333 }
    L_0x00b5:
        r14 = "BaseIntentService";	 Catch:{ Throwable -> 0x0333 }
        r7 = "handleRemoteMessage";	 Catch:{ Throwable -> 0x0333 }
        r22 = r12;	 Catch:{ Throwable -> 0x0333 }
        r12 = 12;	 Catch:{ Throwable -> 0x0333 }
        r12 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0333 }
        r18 = "message";	 Catch:{ Throwable -> 0x0333 }
        r17 = 0;	 Catch:{ Throwable -> 0x0333 }
        r12[r17] = r18;	 Catch:{ Throwable -> 0x0333 }
        r12[r16] = r6;	 Catch:{ Throwable -> 0x0333 }
        r18 = "source";	 Catch:{ Throwable -> 0x0333 }
        r21 = 2;	 Catch:{ Throwable -> 0x0333 }
        r12[r21] = r18;	 Catch:{ Throwable -> 0x0333 }
        r18 = 3;	 Catch:{ Throwable -> 0x0333 }
        r12[r18] = r8;	 Catch:{ Throwable -> 0x0333 }
        r18 = "msgId";	 Catch:{ Throwable -> 0x0333 }
        r20 = 4;	 Catch:{ Throwable -> 0x0333 }
        r12[r20] = r18;	 Catch:{ Throwable -> 0x0333 }
        r18 = 5;	 Catch:{ Throwable -> 0x0333 }
        r12[r18] = r5;	 Catch:{ Throwable -> 0x0333 }
        r18 = 6;	 Catch:{ Throwable -> 0x0333 }
        r23 = "utdid";	 Catch:{ Throwable -> 0x0333 }
        r12[r18] = r23;	 Catch:{ Throwable -> 0x0333 }
        r18 = 7;	 Catch:{ Throwable -> 0x0333 }
        r23 = com.taobao.accs.utl.a.b(r30);	 Catch:{ Throwable -> 0x0333 }
        r12[r18] = r23;	 Catch:{ Throwable -> 0x0333 }
        r18 = 8;	 Catch:{ Throwable -> 0x0333 }
        r23 = "fromPkg";	 Catch:{ Throwable -> 0x0333 }
        r12[r18] = r23;	 Catch:{ Throwable -> 0x0333 }
        r18 = 9;	 Catch:{ Throwable -> 0x0333 }
        r12[r18] = r3;	 Catch:{ Throwable -> 0x0333 }
        r18 = 10;	 Catch:{ Throwable -> 0x0333 }
        r23 = "fromAppkey";	 Catch:{ Throwable -> 0x0333 }
        r12[r18] = r23;	 Catch:{ Throwable -> 0x0333 }
        r18 = 11;	 Catch:{ Throwable -> 0x0333 }
        r12[r18] = r4;	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.ALog.i(r14, r7, r12);	 Catch:{ Throwable -> 0x0333 }
        goto L_0x0103;	 Catch:{ Throwable -> 0x0333 }
    L_0x0101:
        r22 = r12;	 Catch:{ Throwable -> 0x0333 }
    L_0x0103:
        r7 = new org.android.agoo.common.MsgDO;	 Catch:{ Throwable -> 0x0333 }
        r7.<init>();	 Catch:{ Throwable -> 0x0333 }
        r7.msgIds = r5;	 Catch:{ Throwable -> 0x0333 }
        r7.extData = r11;	 Catch:{ Throwable -> 0x0333 }
        r7.messageSource = r8;	 Catch:{ Throwable -> 0x0333 }
        r11 = "4";	 Catch:{ Throwable -> 0x0333 }
        r7.msgStatus = r11;	 Catch:{ Throwable -> 0x0333 }
        r7.reportStr = r9;	 Catch:{ Throwable -> 0x0333 }
        r7.fromPkg = r3;	 Catch:{ Throwable -> 0x0333 }
        r7.fromAppkey = r4;	 Catch:{ Throwable -> 0x0333 }
        r3 = com.taobao.accs.client.a.c();	 Catch:{ Throwable -> 0x0333 }
        r7.isStartProc = r3;	 Catch:{ Throwable -> 0x0333 }
        r3 = r1.mContext;	 Catch:{ Throwable -> 0x0333 }
        r3 = com.taobao.accs.utl.a.d(r3);	 Catch:{ Throwable -> 0x0333 }
        r7.notifyEnable = r3;	 Catch:{ Throwable -> 0x0333 }
        r3 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x0333 }
        if (r3 != 0) goto L_0x016a;	 Catch:{ Throwable -> 0x0333 }
    L_0x012c:
        r3 = 4;	 Catch:{ Throwable -> 0x0333 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ Throwable -> 0x0333 }
        r3 = r3.equals(r10);	 Catch:{ Throwable -> 0x0333 }
        if (r3 == 0) goto L_0x0155;	 Catch:{ Throwable -> 0x0333 }
    L_0x0137:
        r3 = "BaseIntentService";	 Catch:{ Throwable -> 0x0333 }
        r4 = "message is encrypted, attemp to decrypt msg";	 Catch:{ Throwable -> 0x0333 }
        r9 = 0;	 Catch:{ Throwable -> 0x0333 }
        r10 = new java.lang.Object[r9];	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.ALog.i(r3, r4, r10);	 Catch:{ Throwable -> 0x0333 }
        r6 = org.android.agoo.control.AgooFactory.parseEncryptedMsg(r6);	 Catch:{ Throwable -> 0x0333 }
        r3 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x0333 }
        if (r3 == 0) goto L_0x016a;	 Catch:{ Throwable -> 0x0333 }
    L_0x014b:
        r2 = "22";	 Catch:{ Throwable -> 0x0333 }
        r7.errorCode = r2;	 Catch:{ Throwable -> 0x0333 }
        r2 = r1.notifyManager;	 Catch:{ Throwable -> 0x0333 }
        r2.handlerACKMessage(r7, r13);	 Catch:{ Throwable -> 0x0333 }
        return;	 Catch:{ Throwable -> 0x0333 }
    L_0x0155:
        r2 = "BaseIntentService";	 Catch:{ Throwable -> 0x0333 }
        r3 = "msg encrypted flag not exist~~";	 Catch:{ Throwable -> 0x0333 }
        r4 = 0;	 Catch:{ Throwable -> 0x0333 }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.ALog.e(r2, r3, r4);	 Catch:{ Throwable -> 0x0333 }
        r2 = "24";	 Catch:{ Throwable -> 0x0169 }
        r7.errorCode = r2;	 Catch:{ Throwable -> 0x0169 }
        r2 = r1.notifyManager;	 Catch:{ Throwable -> 0x0169 }
        r2.report(r7, r13);	 Catch:{ Throwable -> 0x0169 }
        return;
    L_0x0169:
        return;
    L_0x016a:
        r3 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x0333 }
        if (r3 == 0) goto L_0x0184;
    L_0x0170:
        r2 = "21";	 Catch:{ Throwable -> 0x0179 }
        r7.errorCode = r2;	 Catch:{ Throwable -> 0x0179 }
        r2 = r1.notifyManager;	 Catch:{ Throwable -> 0x0179 }
        r2.report(r7, r13);	 Catch:{ Throwable -> 0x0179 }
    L_0x0179:
        r2 = "BaseIntentService";	 Catch:{ Throwable -> 0x0333 }
        r3 = "handleMessage--->[null]";	 Catch:{ Throwable -> 0x0333 }
        r4 = 0;	 Catch:{ Throwable -> 0x0333 }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.ALog.e(r2, r3, r4);	 Catch:{ Throwable -> 0x0333 }
        return;	 Catch:{ Throwable -> 0x0333 }
    L_0x0184:
        r3 = "body";	 Catch:{ Throwable -> 0x0333 }
        r2.putExtra(r3, r6);	 Catch:{ Throwable -> 0x0333 }
        r3 = r1.notifyManager;	 Catch:{ Throwable -> 0x01cf }
        r3.report(r7, r13);	 Catch:{ Throwable -> 0x01cf }
        r3 = r1.messageService;	 Catch:{ Throwable -> 0x01cf }
        r4 = "0";	 Catch:{ Throwable -> 0x01cf }
        r9 = r22;	 Catch:{ Throwable -> 0x01cf }
        r3.a(r5, r9, r4);	 Catch:{ Throwable -> 0x01cf }
        r22 = com.taobao.accs.utl.UTMini.getInstance();	 Catch:{ Throwable -> 0x01cf }
        r23 = 19999; // 0x4e1f float:2.8025E-41 double:9.881E-320;	 Catch:{ Throwable -> 0x01cf }
        r24 = "Page_Push";	 Catch:{ Throwable -> 0x01cf }
        r25 = "agoo_arrive_id";	 Catch:{ Throwable -> 0x01cf }
        r26 = 0;	 Catch:{ Throwable -> 0x01cf }
        r27 = 0;	 Catch:{ Throwable -> 0x01cf }
        r3 = 2;	 Catch:{ Throwable -> 0x01cf }
        r4 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x01cf }
        r3 = 0;	 Catch:{ Throwable -> 0x01cf }
        r9 = 0;	 Catch:{ Throwable -> 0x01cf }
        r4[r3] = r9;	 Catch:{ Throwable -> 0x01cf }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01cf }
        r9 = "messageId=";	 Catch:{ Throwable -> 0x01cf }
        r3.<init>(r9);	 Catch:{ Throwable -> 0x01cf }
        r9 = r7.msgIds;	 Catch:{ Throwable -> 0x01cf }
        r3.append(r9);	 Catch:{ Throwable -> 0x01cf }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x01cf }
        r4[r16] = r3;	 Catch:{ Throwable -> 0x01cf }
        r28 = r4;	 Catch:{ Throwable -> 0x01cf }
        r22.commitEvent(r23, r24, r25, r26, r27, r28);	 Catch:{ Throwable -> 0x01cf }
        r3 = "accs";	 Catch:{ Throwable -> 0x01cf }
        r4 = "agoo_arrive";	 Catch:{ Throwable -> 0x01cf }
        r9 = "arrive";	 Catch:{ Throwable -> 0x01cf }
        r10 = 0;	 Catch:{ Throwable -> 0x01cf }
        com.taobao.accs.utl.b.a(r3, r4, r9, r10);	 Catch:{ Throwable -> 0x01cf }
        goto L_0x01eb;
    L_0x01cf:
        r0 = move-exception;
        r3 = r0;
        r4 = "BaseIntentService";	 Catch:{ Throwable -> 0x0333 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0333 }
        r10 = "report message Throwable--->t=";	 Catch:{ Throwable -> 0x0333 }
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0333 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0333 }
        r9.append(r3);	 Catch:{ Throwable -> 0x0333 }
        r3 = r9.toString();	 Catch:{ Throwable -> 0x0333 }
        r9 = 0;	 Catch:{ Throwable -> 0x0333 }
        r10 = new java.lang.Object[r9];	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.ALog.e(r4, r3, r10);	 Catch:{ Throwable -> 0x0333 }
    L_0x01eb:
        r3 = r1.messageService;	 Catch:{ Throwable -> 0x0333 }
        r3 = r3.a(r5);	 Catch:{ Throwable -> 0x0333 }
        if (r3 == 0) goto L_0x0229;	 Catch:{ Throwable -> 0x0333 }
    L_0x01f3:
        r2 = com.taobao.accs.utl.ALog.Level.I;	 Catch:{ Throwable -> 0x0333 }
        r2 = com.taobao.accs.utl.ALog.isPrintLog(r2);	 Catch:{ Throwable -> 0x0333 }
        if (r2 == 0) goto L_0x021d;	 Catch:{ Throwable -> 0x0333 }
    L_0x01fb:
        r2 = "BaseIntentService";	 Catch:{ Throwable -> 0x0333 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0333 }
        r4 = "handleRemoteMessage hasMessageDuplicate,messageId=";	 Catch:{ Throwable -> 0x0333 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0333 }
        r3.append(r5);	 Catch:{ Throwable -> 0x0333 }
        r4 = ",utdid=";	 Catch:{ Throwable -> 0x0333 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0333 }
        r4 = com.taobao.accs.utl.a.b(r30);	 Catch:{ Throwable -> 0x0333 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0333 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0333 }
        r4 = 0;	 Catch:{ Throwable -> 0x0333 }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.ALog.i(r2, r3, r4);	 Catch:{ Throwable -> 0x0333 }
    L_0x021d:
        r2 = "accs";	 Catch:{ Throwable -> 0x0333 }
        r3 = "agoo_arrive";	 Catch:{ Throwable -> 0x0333 }
        r4 = "arrive_dup";	 Catch:{ Throwable -> 0x0333 }
        r5 = 0;	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.b.a(r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0333 }
        return;	 Catch:{ Throwable -> 0x0333 }
    L_0x0229:
        r3 = com.taobao.accs.utl.ALog.Level.I;	 Catch:{ Throwable -> 0x0333 }
        r3 = com.taobao.accs.utl.ALog.isPrintLog(r3);	 Catch:{ Throwable -> 0x0333 }
        if (r3 == 0) goto L_0x0254;	 Catch:{ Throwable -> 0x0333 }
    L_0x0231:
        r3 = "BaseIntentService";	 Catch:{ Throwable -> 0x0333 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0333 }
        r9 = "handleMessage--->[";	 Catch:{ Throwable -> 0x0333 }
        r4.<init>(r9);	 Catch:{ Throwable -> 0x0333 }
        r4.append(r6);	 Catch:{ Throwable -> 0x0333 }
        r9 = "],[";	 Catch:{ Throwable -> 0x0333 }
        r4.append(r9);	 Catch:{ Throwable -> 0x0333 }
        r4.append(r8);	 Catch:{ Throwable -> 0x0333 }
        r8 = "]";	 Catch:{ Throwable -> 0x0333 }
        r4.append(r8);	 Catch:{ Throwable -> 0x0333 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0333 }
        r8 = 0;	 Catch:{ Throwable -> 0x0333 }
        r9 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.ALog.i(r3, r4, r9);	 Catch:{ Throwable -> 0x0333 }
    L_0x0254:
        r3 = "duplicate";	 Catch:{ Throwable -> 0x0280 }
        r3 = r2.getStringExtra(r3);	 Catch:{ Throwable -> 0x0280 }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0280 }
        if (r4 != 0) goto L_0x02a4;	 Catch:{ Throwable -> 0x0280 }
    L_0x0260:
        r4 = "1";	 Catch:{ Throwable -> 0x0280 }
        r3 = android.text.TextUtils.equals(r3, r4);	 Catch:{ Throwable -> 0x0280 }
        if (r3 == 0) goto L_0x02a4;	 Catch:{ Throwable -> 0x0280 }
    L_0x0268:
        r3 = r6.hashCode();	 Catch:{ Throwable -> 0x0280 }
        r4 = r1.messageService;	 Catch:{ Throwable -> 0x0280 }
        r3 = r4.a(r5, r3);	 Catch:{ Throwable -> 0x0280 }
        if (r3 == 0) goto L_0x02a4;	 Catch:{ Throwable -> 0x0280 }
    L_0x0274:
        r3 = "accs";	 Catch:{ Throwable -> 0x0280 }
        r4 = "agoo_arrive";	 Catch:{ Throwable -> 0x0280 }
        r8 = "arrive_dupbody";	 Catch:{ Throwable -> 0x0280 }
        r9 = 0;	 Catch:{ Throwable -> 0x0280 }
        com.taobao.accs.utl.b.a(r3, r4, r8, r9);	 Catch:{ Throwable -> 0x0280 }
        return;
    L_0x0280:
        r0 = move-exception;
        r3 = r0;
        r4 = com.taobao.accs.utl.ALog.Level.E;	 Catch:{ Throwable -> 0x0333 }
        r4 = com.taobao.accs.utl.ALog.isPrintLog(r4);	 Catch:{ Throwable -> 0x0333 }
        if (r4 == 0) goto L_0x02a4;	 Catch:{ Throwable -> 0x0333 }
    L_0x028a:
        r4 = "BaseIntentService";	 Catch:{ Throwable -> 0x0333 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0333 }
        r9 = "hasMessageDuplicate message,e=";	 Catch:{ Throwable -> 0x0333 }
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0333 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0333 }
        r8.append(r3);	 Catch:{ Throwable -> 0x0333 }
        r3 = r8.toString();	 Catch:{ Throwable -> 0x0333 }
        r8 = 0;	 Catch:{ Throwable -> 0x0333 }
        r9 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.ALog.e(r4, r3, r9);	 Catch:{ Throwable -> 0x0333 }
    L_0x02a4:
        r3 = -1;
        r4 = "notify";	 Catch:{ Throwable -> 0x02b0 }
        r4 = r2.getStringExtra(r4);	 Catch:{ Throwable -> 0x02b0 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Throwable -> 0x02b0 }
        r3 = r4;
    L_0x02b0:
        r4 = "";	 Catch:{ Throwable -> 0x0333 }
        r8 = "has_test";	 Catch:{ Throwable -> 0x02e5 }
        r8 = r2.getStringExtra(r8);	 Catch:{ Throwable -> 0x02e5 }
        r9 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x02e5 }
        if (r9 != 0) goto L_0x02d9;	 Catch:{ Throwable -> 0x02e5 }
    L_0x02be:
        r9 = "1";	 Catch:{ Throwable -> 0x02e5 }
        r8 = android.text.TextUtils.equals(r8, r9);	 Catch:{ Throwable -> 0x02e5 }
        if (r8 == 0) goto L_0x02d9;	 Catch:{ Throwable -> 0x02e5 }
    L_0x02c6:
        r8 = r1.messageService;	 Catch:{ Throwable -> 0x02e5 }
        r9 = r19;
        r8.a(r5, r6, r9, r3);	 Catch:{ Throwable -> 0x02e7 }
        r8 = "accs";	 Catch:{ Throwable -> 0x02e7 }
        r10 = "agoo_arrive";	 Catch:{ Throwable -> 0x02e7 }
        r11 = "arrive_test";	 Catch:{ Throwable -> 0x02e7 }
        r12 = 0;	 Catch:{ Throwable -> 0x02e7 }
        com.taobao.accs.utl.b.a(r8, r10, r11, r12);	 Catch:{ Throwable -> 0x02e7 }
        return;	 Catch:{ Throwable -> 0x02e7 }
    L_0x02d9:
        r9 = r19;	 Catch:{ Throwable -> 0x02e7 }
        r8 = r29.getClass();	 Catch:{ Throwable -> 0x02e7 }
        r8 = r8.getName();	 Catch:{ Throwable -> 0x02e7 }
        r4 = r8;
        goto L_0x02e7;
    L_0x02e5:
        r9 = r19;
    L_0x02e7:
        r8 = r1.messageService;	 Catch:{ Throwable -> 0x0333 }
        r8.a(r5, r6, r9, r3);	 Catch:{ Throwable -> 0x0333 }
        r22 = com.taobao.accs.utl.UTMini.getInstance();	 Catch:{ Throwable -> 0x0333 }
        r23 = 19999; // 0x4e1f float:2.8025E-41 double:9.881E-320;	 Catch:{ Throwable -> 0x0333 }
        r24 = "Page_Push";	 Catch:{ Throwable -> 0x0333 }
        r25 = "agoo_arrive_real_id";	 Catch:{ Throwable -> 0x0333 }
        r26 = 0;	 Catch:{ Throwable -> 0x0333 }
        r27 = 0;	 Catch:{ Throwable -> 0x0333 }
        r3 = 2;	 Catch:{ Throwable -> 0x0333 }
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x0333 }
        r5 = 0;	 Catch:{ Throwable -> 0x0333 }
        r6 = 0;	 Catch:{ Throwable -> 0x0333 }
        r3[r5] = r6;	 Catch:{ Throwable -> 0x0333 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0333 }
        r6 = "messageId=";	 Catch:{ Throwable -> 0x0333 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x0333 }
        r6 = r7.msgIds;	 Catch:{ Throwable -> 0x0333 }
        r5.append(r6);	 Catch:{ Throwable -> 0x0333 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0333 }
        r3[r16] = r5;	 Catch:{ Throwable -> 0x0333 }
        r28 = r3;	 Catch:{ Throwable -> 0x0333 }
        r22.commitEvent(r23, r24, r25, r26, r27, r28);	 Catch:{ Throwable -> 0x0333 }
        r3 = "accs";	 Catch:{ Throwable -> 0x0333 }
        r5 = "agoo_arrive";	 Catch:{ Throwable -> 0x0333 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0333 }
        r7 = "arrive_real_";	 Catch:{ Throwable -> 0x0333 }
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0333 }
        r6.append(r4);	 Catch:{ Throwable -> 0x0333 }
        r4 = r6.toString();	 Catch:{ Throwable -> 0x0333 }
        r6 = 0;	 Catch:{ Throwable -> 0x0333 }
        com.taobao.accs.utl.b.a(r3, r5, r4, r6);	 Catch:{ Throwable -> 0x0333 }
        r29.onMessage(r30, r31);	 Catch:{ Throwable -> 0x0333 }
        return;
    L_0x0333:
        r0 = move-exception;
        r2 = r0;
        r3 = "accs";
        r4 = "agoo_arrive";
        r5 = new java.lang.StringBuilder;
        r6 = "arrive_exception";
        r5.<init>(r6);
        r2 = r2.toString();
        r5.append(r2);
        r2 = r5.toString();
        r5 = 0;
        com.taobao.accs.utl.b.a(r3, r4, r2, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.BaseIntentService.handleRemoteMessage(android.content.Context, android.content.Intent):void");
    }

    private final String getTrace(Context context, long j) {
        context = null;
        String str = TextUtils.isEmpty(null) ? "unknow" : null;
        if (TextUtils.isEmpty(null)) {
            context = "unknow";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appkey");
        stringBuffer.append("|");
        stringBuffer.append(j);
        stringBuffer.append("|");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("|");
        stringBuffer.append(str);
        stringBuffer.append("|");
        stringBuffer.append(context);
        return stringBuffer.toString();
    }

    public static final void runIntentInService(Context context, Intent intent, String str) {
        try {
            intent.setClassName(context, str);
            context.startService(intent);
        } catch (Context context2) {
            ALog.w(TAG, "runIntentInService", context2, new Object[0]);
        }
    }
}
