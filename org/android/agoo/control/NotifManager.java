package org.android.agoo.control;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.base.TaoBaseService$ExtraInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.a;
import com.taobao.accs.utl.b;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.common.d;
import org.json.JSONObject;

/* compiled from: Taobao */
public class NotifManager {
    private static final String ACK_MESSAGE = "accs.ackMessage";
    private static final int EVENT_ID = 66001;
    private static final String TAG = "NotifManager";
    private static Context mContext;
    private ScheduledThreadPoolExecutor mThreadPool;

    public void init(Context context) {
        mContext = context;
        this.mThreadPool = d.a();
    }

    public void handlerACKMessage(MsgDO msgDO, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
        if (msgDO != null) {
            if (TextUtils.isEmpty(msgDO.msgIds) && TextUtils.isEmpty(msgDO.removePacks) && TextUtils.isEmpty(msgDO.errorCode)) {
                taoBaseService$ExtraInfo = new StringBuilder("msgids=");
                taoBaseService$ExtraInfo.append(msgDO.msgIds);
                taoBaseService$ExtraInfo.append(",removePacks=");
                taoBaseService$ExtraInfo.append(msgDO.removePacks);
                taoBaseService$ExtraInfo.append(",errorCode=");
                taoBaseService$ExtraInfo.append(msgDO.errorCode);
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, a.b(mContext), "handlerACKMessageRetuen", taoBaseService$ExtraInfo.toString());
                return;
            }
            String str;
            StringBuilder stringBuilder;
            try {
                Map hashMap = new HashMap();
                hashMap.put("api", AgooConstants.AGOO_SERVICE_AGOOACK);
                String str2 = AgooConstants.MESSAGE_ID;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(msgDO.msgIds);
                stringBuilder2.append("@");
                stringBuilder2.append(msgDO.messageSource);
                hashMap.put(str2, stringBuilder2.toString());
                if (!TextUtils.isEmpty(msgDO.removePacks)) {
                    hashMap.put("del_pack", msgDO.removePacks);
                }
                if (!TextUtils.isEmpty(msgDO.errorCode)) {
                    hashMap.put("ec", msgDO.errorCode);
                }
                if (!TextUtils.isEmpty(msgDO.type)) {
                    hashMap.put("type", msgDO.type);
                }
                if (!TextUtils.isEmpty(msgDO.extData)) {
                    hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, msgDO.extData);
                }
                hashMap.put("appkey", Config.a(mContext));
                hashMap.put("utdid", a.b(mContext));
                byte[] bytes = new JSONObject(hashMap).toString().getBytes("UTF-8");
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, a.b(mContext), "handlerACKMessageSendData", msgDO.msgIds);
                b.a("accs", BaseMonitor.COUNT_AGOO_ACK, "handlerACKMessage", 0.0d);
                AccsRequest accsRequest = new AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, bytes, null, null, null, null);
                if (msgDO != null) {
                    accsRequest.setTag(msgDO.msgIds);
                }
                taoBaseService$ExtraInfo = ACCSManager.getAccsInstance(mContext, Config.a(mContext), Config.b(mContext)).sendPushResponse(mContext, accsRequest, taoBaseService$ExtraInfo);
                str = TAG;
                stringBuilder = new StringBuilder("handlerACKMessage,endRequest,dataId=");
                stringBuilder.append(taoBaseService$ExtraInfo);
                ALog.i(str, stringBuilder.toString(), new Object[0]);
            } catch (TaoBaseService$ExtraInfo taoBaseService$ExtraInfo2) {
                if (ALog.isPrintLog(Level.E)) {
                    str = TAG;
                    stringBuilder = new StringBuilder("handlerACKMessage Throwable,msgIds=");
                    stringBuilder.append(msgDO.msgIds);
                    stringBuilder.append(",type=");
                    stringBuilder.append(msgDO.type);
                    stringBuilder.append(",e=");
                    stringBuilder.append(taoBaseService$ExtraInfo2.toString());
                    ALog.e(str, stringBuilder.toString(), new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, a.b(mContext), "handlerACKMessageExceptionFailed", taoBaseService$ExtraInfo2.toString());
            }
        }
    }

    public void report(MsgDO msgDO, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
        if (!TextUtils.isEmpty(msgDO.reportStr)) {
            try {
                if (Integer.parseInt(msgDO.reportStr) >= -1) {
                    reportMethod(msgDO, taoBaseService$ExtraInfo);
                    if (msgDO.isFromCache == null) {
                        b.a("accs", BaseMonitor.COUNT_AGOO_ACK, msgDO.msgStatus, 0.0d);
                    }
                }
            } catch (MsgDO msgDO2) {
                ALog.e(TAG, "[report] is error", msgDO2, new Object[0]);
            }
        }
    }

    public void reportNotifyMessage(MsgDO msgDO) {
        if (msgDO != null) {
            try {
                b.a("accs", BaseMonitor.COUNT_AGOO_REPORT_ID, msgDO.msgIds, 0.0d);
                AccsRequest accsRequest = new AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, convertMsgToBytes(msgDO), null, null, null, null);
                IACCSManager accsInstance = ACCSManager.getAccsInstance(mContext, Config.a(mContext), Config.b(mContext));
                String sendRequest = accsInstance.sendRequest(mContext, accsRequest);
                accsInstance.sendPushResponse(mContext, accsRequest, null);
                if (ALog.isPrintLog(Level.E)) {
                    ALog.e(TAG, "reportNotifyMessage", Constants.KEY_DATA_ID, sendRequest, "status", msgDO.msgStatus);
                }
                b.a("accs", BaseMonitor.COUNT_AGOO_CLICK, msgDO.msgStatus, 0.0d);
                b.a("accs", BaseMonitor.COUNT_AGOO_ACK, msgDO.msgStatus, 0.0d);
            } catch (MsgDO msgDO2) {
                ALog.e(TAG, "[reportNotifyMessage] is error", msgDO2, new Object[0]);
                b.a("accs", "error", msgDO2.toString(), 0.0d);
            }
        }
    }

    private byte[] convertMsgToBytes(MsgDO msgDO) throws UnsupportedEncodingException {
        Map hashMap = new HashMap();
        hashMap.put("api", "agooReport");
        String str = AgooConstants.MESSAGE_ID;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(msgDO.msgIds);
        stringBuilder.append("@");
        stringBuilder.append(msgDO.messageSource);
        hashMap.put(str, stringBuilder.toString());
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, msgDO.extData);
        hashMap.put("status", msgDO.msgStatus);
        if (!TextUtils.isEmpty(msgDO.errorCode)) {
            hashMap.put("ec", msgDO.errorCode);
        }
        if (!TextUtils.isEmpty(msgDO.type)) {
            hashMap.put("type", msgDO.type);
        }
        if (!TextUtils.isEmpty(msgDO.fromPkg)) {
            hashMap.put("fromPkg", msgDO.fromPkg);
        }
        if (!TextUtils.isEmpty(msgDO.fromAppkey)) {
            hashMap.put(AgooConstants.MESSAGE_FROM_APPKEY, msgDO.fromAppkey);
        }
        if (!TextUtils.isEmpty(msgDO.notifyEnable)) {
            hashMap.put("notifyEnable", msgDO.notifyEnable);
        }
        if (!TextUtils.isEmpty(msgDO.extData)) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, msgDO.extData);
        }
        hashMap.put("isStartProc", Boolean.toString(msgDO.isStartProc));
        hashMap.put("appkey", Config.a(mContext));
        hashMap.put("utdid", a.b(mContext));
        return new JSONObject(hashMap).toString().getBytes("UTF-8");
    }

    private void reportMethod(MsgDO msgDO, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
        if (msgDO == null) {
            try {
                ALog.e(TAG, "reportMethod msg null", new Object[0]);
                return;
            } catch (MsgDO msgDO2) {
                b.a("accs", "error", msgDO2.toString(), 0.0d);
                return;
            }
        }
        AccsRequest accsRequest = new AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, convertMsgToBytes(msgDO2), null, null, null, null);
        accsRequest.setTag(msgDO2.msgIds);
        taoBaseService$ExtraInfo = ACCSManager.getAccsInstance(mContext, Config.a(mContext), Config.b(mContext)).sendPushResponse(mContext, accsRequest, taoBaseService$ExtraInfo);
        if (ALog.isPrintLog(Level.E)) {
            ALog.e(TAG, AgooConstants.MESSAGE_REPORT, Constants.KEY_DATA_ID, taoBaseService$ExtraInfo, "status", msgDO2.msgStatus, "errorcode", msgDO2.errorCode);
        }
    }

    public void reportThirdPushToken(String str, String str2, boolean z) {
        ThreadPoolExecutorFactory.schedule(new g(this, str2, str, z), 10, TimeUnit.SECONDS);
    }

    public void reportThirdPushToken(String str, String str2) {
        reportThirdPushToken(str, str2, true);
    }

    public void doUninstall(String str, boolean z) {
        try {
            z = new HashMap();
            z.put("pack", str);
            z.put("appkey", Config.a(mContext));
            z.put("utdid", a.b(mContext));
            ACCSManager.getAccsInstance(mContext, Config.a(mContext), Config.b(mContext)).sendPushResponse(mContext, new AccsRequest(null, "agooKick", new JSONObject(z).toString().getBytes("UTF-8"), null, null, null, null), new TaoBaseService$ExtraInfo());
        } catch (String str2) {
            ALog.e(TAG, "[doUninstall] is error", str2, new Object[0]);
        }
    }

    public void pingApp(String str, String str2, String str3, int i) {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            if (!TextUtils.isEmpty(str3)) {
                if (ALog.isPrintLog(Level.I)) {
                    String str4 = TAG;
                    StringBuilder stringBuilder = new StringBuilder("pingApp [print param],percent=");
                    stringBuilder.append(i);
                    stringBuilder.append(",pack=");
                    stringBuilder.append(str2);
                    stringBuilder.append(",service=");
                    stringBuilder.append(str3);
                    stringBuilder.append(",action=");
                    stringBuilder.append(str);
                    ALog.i(str4, stringBuilder.toString(), new Object[0]);
                }
                this.mThreadPool.execute(new h(this, i, str2, str, str3));
            }
        }
    }

    private boolean isAppInstalled(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0013 }
        if (r1 == 0) goto L_0x0008;	 Catch:{ Throwable -> 0x0013 }
    L_0x0007:
        return r0;	 Catch:{ Throwable -> 0x0013 }
    L_0x0008:
        r1 = mContext;	 Catch:{ Throwable -> 0x0013 }
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x0013 }
        r3 = r1.getPackageInfo(r3, r0);	 Catch:{ Throwable -> 0x0013 }
        goto L_0x0014;
    L_0x0013:
        r3 = 0;
    L_0x0014:
        if (r3 != 0) goto L_0x0017;
    L_0x0016:
        return r0;
    L_0x0017:
        r3 = "NotifManager";
        r1 = "isAppInstalled true..";
        r0 = new java.lang.Object[r0];
        com.taobao.accs.utl.ALog.i(r3, r1, r0);
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.NotifManager.isAppInstalled(java.lang.String):boolean");
    }

    private java.lang.String getVersion(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x002c }
        if (r0 == 0) goto L_0x0009;	 Catch:{ Throwable -> 0x002c }
    L_0x0006:
        r5 = "null";	 Catch:{ Throwable -> 0x002c }
        return r5;	 Catch:{ Throwable -> 0x002c }
    L_0x0009:
        r0 = mContext;	 Catch:{ Throwable -> 0x002c }
        r0 = r0.getPackageManager();	 Catch:{ Throwable -> 0x002c }
        r1 = 0;	 Catch:{ Throwable -> 0x002c }
        r5 = r0.getPackageInfo(r5, r1);	 Catch:{ Throwable -> 0x002c }
        r5 = r5.versionName;	 Catch:{ Throwable -> 0x002c }
        r0 = "NotifManager";	 Catch:{ Throwable -> 0x002c }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x002c }
        r3 = "getVersion###版本号为 : ";	 Catch:{ Throwable -> 0x002c }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x002c }
        r2.append(r5);	 Catch:{ Throwable -> 0x002c }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x002c }
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x002c }
        com.taobao.accs.utl.ALog.d(r0, r2, r1);	 Catch:{ Throwable -> 0x002c }
        return r5;
    L_0x002c:
        r5 = "null";
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.NotifManager.getVersion(java.lang.String):java.lang.String");
    }
}
