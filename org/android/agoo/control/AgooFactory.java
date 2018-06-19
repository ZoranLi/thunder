package org.android.agoo.control;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import com.taobao.accs.base.TaoBaseService$ExtraInfo;
import com.taobao.accs.client.a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UTMini;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.b;
import org.android.agoo.common.d;
import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
public class AgooFactory {
    private static final String DEAL_MESSAGE = "accs.msgRecevie";
    private static final String TAG = "AgooFactory";
    private static Context mContext;
    private ScheduledThreadPoolExecutor mThreadPool;
    private MessageService messageService = null;
    protected NotifManager notifyManager = null;

    public void init(Context context, NotifManager notifManager, MessageService messageService) {
        mContext = context;
        this.mThreadPool = d.a();
        this.notifyManager = notifManager;
        if (this.notifyManager == null) {
            this.notifyManager = new NotifManager();
        }
        this.notifyManager.init(mContext);
        this.messageService = messageService;
        if (this.messageService == null) {
            this.messageService = new MessageService();
        }
        this.messageService.a(mContext);
    }

    public void saveMsg(byte[] bArr) {
        saveMsg(bArr, null);
    }

    public void saveMsg(byte[] bArr, String str) {
        if (bArr != null) {
            if (bArr.length > 0) {
                this.mThreadPool.execute(new a(this, bArr, str));
            }
        }
    }

    public void msgRecevie(byte[] bArr, String str) {
        msgRecevie(bArr, str, null);
    }

    public void msgRecevie(byte[] bArr, String str, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
        try {
            if (ALog.isPrintLog(Level.I)) {
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder("into--[AgooFactory,msgRecevie]:messageSource=");
                stringBuilder.append(str);
                ALog.i(str2, stringBuilder.toString(), new Object[0]);
            }
            this.mThreadPool.execute(new b(this, bArr, str, taoBaseService$ExtraInfo));
        } catch (byte[] bArr2) {
            str = TAG;
            taoBaseService$ExtraInfo = new StringBuilder("serviceImpl init task fail:");
            taoBaseService$ExtraInfo.append(bArr2.toString());
            ALog.e(str, taoBaseService$ExtraInfo.toString(), new Object[0]);
        }
    }

    public android.os.Bundle msgReceiverPreHandler(byte[] r34, java.lang.String r35, com.taobao.accs.base.TaoBaseService$ExtraInfo r36, boolean r37) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r33 = this;
        r8 = r33;
        r1 = r34;
        r9 = r35;
        r10 = r36;
        r2 = 66002; // 0x101d2 float:9.2489E-41 double:3.26093E-319;
        r11 = 0;
        r12 = 0;
        if (r1 == 0) goto L_0x02bc;
    L_0x000f:
        r3 = r1.length;	 Catch:{ Throwable -> 0x02b9 }
        if (r3 > 0) goto L_0x0014;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0012:
        goto L_0x02bc;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0014:
        r13 = new java.lang.String;	 Catch:{ Throwable -> 0x02b9 }
        r3 = "utf-8";	 Catch:{ Throwable -> 0x02b9 }
        r13.<init>(r1, r3);	 Catch:{ Throwable -> 0x02b9 }
        r1 = com.taobao.accs.utl.ALog.Level.I;	 Catch:{ Throwable -> 0x02b9 }
        r1 = com.taobao.accs.utl.ALog.isPrintLog(r1);	 Catch:{ Throwable -> 0x02b9 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0023:
        r1 = "AgooFactory";	 Catch:{ Throwable -> 0x02b9 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02b9 }
        r4 = "msgRecevie,message--->[";	 Catch:{ Throwable -> 0x02b9 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x02b9 }
        r3.append(r13);	 Catch:{ Throwable -> 0x02b9 }
        r4 = "],utdid=";	 Catch:{ Throwable -> 0x02b9 }
        r3.append(r4);	 Catch:{ Throwable -> 0x02b9 }
        r4 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r4 = com.taobao.accs.utl.a.b(r4);	 Catch:{ Throwable -> 0x02b9 }
        r3.append(r4);	 Catch:{ Throwable -> 0x02b9 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x02b9 }
        r4 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x02b9 }
        com.taobao.accs.utl.ALog.i(r1, r3, r4);	 Catch:{ Throwable -> 0x02b9 }
    L_0x0046:
        r1 = android.text.TextUtils.isEmpty(r13);	 Catch:{ Throwable -> 0x02b9 }
        if (r1 == 0) goto L_0x0079;	 Catch:{ Throwable -> 0x02b9 }
    L_0x004c:
        r1 = com.taobao.accs.utl.UTMini.getInstance();	 Catch:{ Throwable -> 0x02b9 }
        r3 = "accs.msgRecevie";	 Catch:{ Throwable -> 0x02b9 }
        r4 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r4 = com.taobao.accs.utl.a.b(r4);	 Catch:{ Throwable -> 0x02b9 }
        r5 = "message==null";	 Catch:{ Throwable -> 0x02b9 }
        r1.commitEvent(r2, r3, r4, r5);	 Catch:{ Throwable -> 0x02b9 }
        r1 = "AgooFactory";	 Catch:{ Throwable -> 0x02b9 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02b9 }
        r3 = "handleMessage message==null,utdid=";	 Catch:{ Throwable -> 0x02b9 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x02b9 }
        r3 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r3 = com.taobao.accs.utl.a.b(r3);	 Catch:{ Throwable -> 0x02b9 }
        r2.append(r3);	 Catch:{ Throwable -> 0x02b9 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x02b9 }
        r3 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x02b9 }
        com.taobao.accs.utl.ALog.i(r1, r2, r3);	 Catch:{ Throwable -> 0x02b9 }
        return r11;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0079:
        r14 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x02b9 }
        r14.<init>(r13);	 Catch:{ Throwable -> 0x02b9 }
        r15 = r14.length();	 Catch:{ Throwable -> 0x02b9 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02b9 }
        r7.<init>();	 Catch:{ Throwable -> 0x02b9 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02b9 }
        r6.<init>();	 Catch:{ Throwable -> 0x02b9 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02b9 }
        r5.<init>();	 Catch:{ Throwable -> 0x02b9 }
        r1 = r11;	 Catch:{ Throwable -> 0x02b9 }
        r2 = r1;	 Catch:{ Throwable -> 0x02b9 }
        r4 = r12;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0094:
        if (r4 >= r15) goto L_0x0294;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0096:
        r3 = new android.os.Bundle;	 Catch:{ Throwable -> 0x02b9 }
        r3.<init>();	 Catch:{ Throwable -> 0x02b9 }
        r1 = r14.getJSONObject(r4);	 Catch:{ Throwable -> 0x02b9 }
        if (r1 == 0) goto L_0x0275;	 Catch:{ Throwable -> 0x02b9 }
    L_0x00a1:
        r11 = new org.android.agoo.common.MsgDO;	 Catch:{ Throwable -> 0x02b9 }
        r11.<init>();	 Catch:{ Throwable -> 0x02b9 }
        r12 = "p";	 Catch:{ Throwable -> 0x02b9 }
        r12 = r1.getString(r12);	 Catch:{ Throwable -> 0x02b9 }
        r22 = r2;	 Catch:{ Throwable -> 0x02b9 }
        r2 = "i";	 Catch:{ Throwable -> 0x02b9 }
        r2 = r1.getString(r2);	 Catch:{ Throwable -> 0x02b9 }
        r23 = r14;	 Catch:{ Throwable -> 0x02b9 }
        r14 = "b";	 Catch:{ Throwable -> 0x02b9 }
        r14 = r1.getString(r14);	 Catch:{ Throwable -> 0x02b9 }
        r24 = r13;	 Catch:{ Throwable -> 0x02b9 }
        r13 = "f";	 Catch:{ Throwable -> 0x02b9 }
        r26 = r5;	 Catch:{ Throwable -> 0x02b9 }
        r25 = r6;	 Catch:{ Throwable -> 0x02b9 }
        r5 = r1.getLong(r13);	 Catch:{ Throwable -> 0x02b9 }
        r13 = "ext";	 Catch:{ Throwable -> 0x02b9 }
        r13 = r1.isNull(r13);	 Catch:{ Throwable -> 0x02b9 }
        if (r13 != 0) goto L_0x00d7;	 Catch:{ Throwable -> 0x02b9 }
    L_0x00d0:
        r13 = "ext";	 Catch:{ Throwable -> 0x02b9 }
        r13 = r1.getString(r13);	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x00d9;	 Catch:{ Throwable -> 0x02b9 }
    L_0x00d7:
        r13 = r22;	 Catch:{ Throwable -> 0x02b9 }
    L_0x00d9:
        r7.append(r2);	 Catch:{ Throwable -> 0x02b9 }
        r27 = r1;	 Catch:{ Throwable -> 0x02b9 }
        r1 = r15 + -1;	 Catch:{ Throwable -> 0x02b9 }
        if (r4 >= r1) goto L_0x00ea;	 Catch:{ Throwable -> 0x02b9 }
    L_0x00e2:
        r28 = r15;	 Catch:{ Throwable -> 0x02b9 }
        r15 = ",";	 Catch:{ Throwable -> 0x02b9 }
        r7.append(r15);	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x00ec;	 Catch:{ Throwable -> 0x02b9 }
    L_0x00ea:
        r28 = r15;	 Catch:{ Throwable -> 0x02b9 }
    L_0x00ec:
        r11.msgIds = r2;	 Catch:{ Throwable -> 0x02b9 }
        r11.extData = r13;	 Catch:{ Throwable -> 0x02b9 }
        r11.removePacks = r12;	 Catch:{ Throwable -> 0x02b9 }
        r11.messageSource = r9;	 Catch:{ Throwable -> 0x02b9 }
        r15 = android.text.TextUtils.isEmpty(r14);	 Catch:{ Throwable -> 0x02b9 }
        if (r15 == 0) goto L_0x0111;	 Catch:{ Throwable -> 0x02b9 }
    L_0x00fa:
        r1 = "11";	 Catch:{ Throwable -> 0x02b9 }
        r11.errorCode = r1;	 Catch:{ Throwable -> 0x02b9 }
        r1 = r8.notifyManager;	 Catch:{ Throwable -> 0x02b9 }
        r1.handlerACKMessage(r11, r10);	 Catch:{ Throwable -> 0x02b9 }
    L_0x0103:
        r12 = r4;	 Catch:{ Throwable -> 0x02b9 }
        r16 = r7;	 Catch:{ Throwable -> 0x02b9 }
        r32 = r13;	 Catch:{ Throwable -> 0x02b9 }
        r31 = r24;	 Catch:{ Throwable -> 0x02b9 }
        r11 = r25;	 Catch:{ Throwable -> 0x02b9 }
        r15 = r26;	 Catch:{ Throwable -> 0x02b9 }
    L_0x010e:
        r13 = r3;	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x0272;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0111:
        r15 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Throwable -> 0x02b9 }
        if (r15 == 0) goto L_0x0121;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0117:
        r1 = "12";	 Catch:{ Throwable -> 0x02b9 }
        r11.errorCode = r1;	 Catch:{ Throwable -> 0x02b9 }
        r1 = r8.notifyManager;	 Catch:{ Throwable -> 0x02b9 }
        r1.handlerACKMessage(r11, r10);	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x0103;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0121:
        r16 = -1;	 Catch:{ Throwable -> 0x02b9 }
        r15 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1));	 Catch:{ Throwable -> 0x02b9 }
        if (r15 != 0) goto L_0x0131;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0127:
        r1 = "13";	 Catch:{ Throwable -> 0x02b9 }
        r11.errorCode = r1;	 Catch:{ Throwable -> 0x02b9 }
        r1 = r8.notifyManager;	 Catch:{ Throwable -> 0x02b9 }
        r1.handlerACKMessage(r11, r10);	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x0103;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0131:
        r15 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r15 = checkPackage(r15, r12);	 Catch:{ Throwable -> 0x02b9 }
        if (r15 != 0) goto L_0x0184;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0139:
        r5 = "AgooFactory";	 Catch:{ Throwable -> 0x02b9 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02b9 }
        r11 = "msgRecevie checkpackage is del,pack=";	 Catch:{ Throwable -> 0x02b9 }
        r6.<init>(r11);	 Catch:{ Throwable -> 0x02b9 }
        r6.append(r12);	 Catch:{ Throwable -> 0x02b9 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x02b9 }
        r11 = 0;	 Catch:{ Throwable -> 0x02b9 }
        r14 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x02b9 }
        com.taobao.accs.utl.ALog.d(r5, r6, r14);	 Catch:{ Throwable -> 0x02b9 }
        r16 = com.taobao.accs.utl.UTMini.getInstance();	 Catch:{ Throwable -> 0x02b9 }
        r17 = 66002; // 0x101d2 float:9.2489E-41 double:3.26093E-319;	 Catch:{ Throwable -> 0x02b9 }
        r18 = "accs.msgRecevie";	 Catch:{ Throwable -> 0x02b9 }
        r5 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r19 = com.taobao.accs.utl.a.b(r5);	 Catch:{ Throwable -> 0x02b9 }
        r20 = "deletePack";	 Catch:{ Throwable -> 0x02b9 }
        r21 = r12;	 Catch:{ Throwable -> 0x02b9 }
        r16.commitEvent(r17, r18, r19, r20, r21);	 Catch:{ Throwable -> 0x02b9 }
        r15 = r26;	 Catch:{ Throwable -> 0x02b9 }
        r15.append(r12);	 Catch:{ Throwable -> 0x02b9 }
        r5 = r25;	 Catch:{ Throwable -> 0x02b9 }
        r5.append(r2);	 Catch:{ Throwable -> 0x02b9 }
        if (r4 >= r1) goto L_0x017b;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0171:
        r1 = ",";	 Catch:{ Throwable -> 0x02b9 }
        r15.append(r1);	 Catch:{ Throwable -> 0x02b9 }
        r1 = ",";	 Catch:{ Throwable -> 0x02b9 }
        r5.append(r1);	 Catch:{ Throwable -> 0x02b9 }
    L_0x017b:
        r12 = r4;	 Catch:{ Throwable -> 0x02b9 }
        r11 = r5;	 Catch:{ Throwable -> 0x02b9 }
        r16 = r7;	 Catch:{ Throwable -> 0x02b9 }
        r32 = r13;	 Catch:{ Throwable -> 0x02b9 }
        r31 = r24;	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x010e;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0184:
        r16 = r25;	 Catch:{ Throwable -> 0x02b9 }
        r15 = r26;	 Catch:{ Throwable -> 0x02b9 }
        r1 = getFlag(r5, r11);	 Catch:{ Throwable -> 0x02b9 }
        r5 = "encrypted";	 Catch:{ Throwable -> 0x02b9 }
        r5 = r1.getString(r5);	 Catch:{ Throwable -> 0x02b9 }
        r6 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r6 = r6.getPackageName();	 Catch:{ Throwable -> 0x02b9 }
        r6 = r6.equals(r12);	 Catch:{ Throwable -> 0x02b9 }
        if (r6 == 0) goto L_0x01e0;	 Catch:{ Throwable -> 0x02b9 }
    L_0x019e:
        r6 = 4;	 Catch:{ Throwable -> 0x02b9 }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x02b9 }
        r5 = android.text.TextUtils.equals(r5, r6);	 Catch:{ Throwable -> 0x02b9 }
        if (r5 != 0) goto L_0x01de;	 Catch:{ Throwable -> 0x02b9 }
    L_0x01a9:
        r1 = "AgooFactory";	 Catch:{ Throwable -> 0x02b9 }
        r2 = "msgRecevie msg encrypted flag not exist, cannot prase!!!";	 Catch:{ Throwable -> 0x02b9 }
        r5 = 0;	 Catch:{ Throwable -> 0x02b9 }
        r6 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x02b9 }
        com.taobao.accs.utl.ALog.e(r1, r2, r6);	 Catch:{ Throwable -> 0x02b9 }
        r17 = com.taobao.accs.utl.UTMini.getInstance();	 Catch:{ Throwable -> 0x02b9 }
        r18 = 66002; // 0x101d2 float:9.2489E-41 double:3.26093E-319;	 Catch:{ Throwable -> 0x02b9 }
        r19 = "accs.msgRecevie";	 Catch:{ Throwable -> 0x02b9 }
        r1 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r20 = com.taobao.accs.utl.a.b(r1);	 Catch:{ Throwable -> 0x02b9 }
        r21 = "encrypted!=4";	 Catch:{ Throwable -> 0x02b9 }
        r22 = "15";	 Catch:{ Throwable -> 0x02b9 }
        r17.commitEvent(r18, r19, r20, r21, r22);	 Catch:{ Throwable -> 0x02b9 }
        r1 = "24";	 Catch:{ Throwable -> 0x02b9 }
        r11.errorCode = r1;	 Catch:{ Throwable -> 0x02b9 }
        r1 = r8.notifyManager;	 Catch:{ Throwable -> 0x02b9 }
        r1.handlerACKMessage(r11, r10);	 Catch:{ Throwable -> 0x02b9 }
        r12 = r4;	 Catch:{ Throwable -> 0x02b9 }
        r32 = r13;	 Catch:{ Throwable -> 0x02b9 }
        r11 = r16;	 Catch:{ Throwable -> 0x02b9 }
        r31 = r24;	 Catch:{ Throwable -> 0x02b9 }
        r13 = r3;	 Catch:{ Throwable -> 0x02b9 }
        r16 = r7;	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x0272;	 Catch:{ Throwable -> 0x02b9 }
    L_0x01de:
        r5 = 0;	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x01e1;	 Catch:{ Throwable -> 0x02b9 }
    L_0x01e0:
        r5 = 1;	 Catch:{ Throwable -> 0x02b9 }
    L_0x01e1:
        if (r1 == 0) goto L_0x01e6;	 Catch:{ Throwable -> 0x02b9 }
    L_0x01e3:
        r3.putAll(r1);	 Catch:{ Throwable -> 0x02b9 }
    L_0x01e6:
        r1 = "t";	 Catch:{ Throwable -> 0x01fa }
        r6 = r27;	 Catch:{ Throwable -> 0x01fa }
        r1 = r6.getString(r1);	 Catch:{ Throwable -> 0x01fa }
        r6 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x01fa }
        if (r6 != 0) goto L_0x020f;	 Catch:{ Throwable -> 0x01fa }
    L_0x01f4:
        r6 = "time";	 Catch:{ Throwable -> 0x01fa }
        r3.putString(r6, r1);	 Catch:{ Throwable -> 0x01fa }
        goto L_0x020f;
    L_0x01fa:
        r1 = com.taobao.accs.utl.ALog.Level.I;	 Catch:{ Throwable -> 0x02b9 }
        r1 = com.taobao.accs.utl.ALog.isPrintLog(r1);	 Catch:{ Throwable -> 0x02b9 }
        if (r1 == 0) goto L_0x020f;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0202:
        r1 = "AgooFactory";	 Catch:{ Throwable -> 0x02b9 }
        r6 = "agoo msg has no time";	 Catch:{ Throwable -> 0x02b9 }
        r29 = r4;	 Catch:{ Throwable -> 0x02b9 }
        r11 = 0;	 Catch:{ Throwable -> 0x02b9 }
        r4 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x02b9 }
        com.taobao.accs.utl.ALog.i(r1, r6, r4);	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x0211;	 Catch:{ Throwable -> 0x02b9 }
    L_0x020f:
        r29 = r4;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0211:
        r1 = "trace";	 Catch:{ Throwable -> 0x02b9 }
        r30 = r7;	 Catch:{ Throwable -> 0x02b9 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x02b9 }
        r3.putLong(r1, r6);	 Catch:{ Throwable -> 0x02b9 }
        r1 = "id";	 Catch:{ Throwable -> 0x02b9 }
        r3.putString(r1, r2);	 Catch:{ Throwable -> 0x02b9 }
        r1 = "body";	 Catch:{ Throwable -> 0x02b9 }
        r3.putString(r1, r14);	 Catch:{ Throwable -> 0x02b9 }
        r1 = "source";	 Catch:{ Throwable -> 0x02b9 }
        r3.putString(r1, r12);	 Catch:{ Throwable -> 0x02b9 }
        r1 = "fromAppkey";	 Catch:{ Throwable -> 0x02b9 }
        r2 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r2 = org.android.agoo.common.Config.a(r2);	 Catch:{ Throwable -> 0x02b9 }
        r3.putString(r1, r2);	 Catch:{ Throwable -> 0x02b9 }
        r1 = "extData";	 Catch:{ Throwable -> 0x02b9 }
        r3.putString(r1, r13);	 Catch:{ Throwable -> 0x02b9 }
        r1 = "oriData";	 Catch:{ Throwable -> 0x02b9 }
        r11 = r24;	 Catch:{ Throwable -> 0x02b9 }
        r3.putString(r1, r11);	 Catch:{ Throwable -> 0x02b9 }
        if (r37 == 0) goto L_0x025b;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0244:
        r2 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r1 = r8;	 Catch:{ Throwable -> 0x02b9 }
        r7 = r3;	 Catch:{ Throwable -> 0x02b9 }
        r3 = r12;	 Catch:{ Throwable -> 0x02b9 }
        r12 = r29;	 Catch:{ Throwable -> 0x02b9 }
        r4 = r7;	 Catch:{ Throwable -> 0x02b9 }
        r31 = r11;	 Catch:{ Throwable -> 0x02b9 }
        r11 = r16;	 Catch:{ Throwable -> 0x02b9 }
        r6 = r9;	 Catch:{ Throwable -> 0x02b9 }
        r32 = r13;	 Catch:{ Throwable -> 0x02b9 }
        r16 = r30;	 Catch:{ Throwable -> 0x02b9 }
        r13 = r7;	 Catch:{ Throwable -> 0x02b9 }
        r7 = r10;	 Catch:{ Throwable -> 0x02b9 }
        r1.sendMsgToBussiness(r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x0272;	 Catch:{ Throwable -> 0x02b9 }
    L_0x025b:
        r31 = r11;	 Catch:{ Throwable -> 0x02b9 }
        r32 = r13;	 Catch:{ Throwable -> 0x02b9 }
        r11 = r16;	 Catch:{ Throwable -> 0x02b9 }
        r12 = r29;	 Catch:{ Throwable -> 0x02b9 }
        r16 = r30;	 Catch:{ Throwable -> 0x02b9 }
        r13 = r3;	 Catch:{ Throwable -> 0x02b9 }
        r1 = "type";	 Catch:{ Throwable -> 0x02b9 }
        r2 = "common-push";	 Catch:{ Throwable -> 0x02b9 }
        r13.putString(r1, r2);	 Catch:{ Throwable -> 0x02b9 }
        r1 = "message_source";	 Catch:{ Throwable -> 0x02b9 }
        r13.putString(r1, r9);	 Catch:{ Throwable -> 0x02b9 }
    L_0x0272:
        r2 = r32;	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x0283;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0275:
        r22 = r2;	 Catch:{ Throwable -> 0x02b9 }
        r12 = r4;	 Catch:{ Throwable -> 0x02b9 }
        r11 = r6;	 Catch:{ Throwable -> 0x02b9 }
        r16 = r7;	 Catch:{ Throwable -> 0x02b9 }
        r31 = r13;	 Catch:{ Throwable -> 0x02b9 }
        r23 = r14;	 Catch:{ Throwable -> 0x02b9 }
        r28 = r15;	 Catch:{ Throwable -> 0x02b9 }
        r13 = r3;	 Catch:{ Throwable -> 0x02b9 }
        r15 = r5;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0283:
        r4 = r12 + 1;	 Catch:{ Throwable -> 0x02b9 }
        r6 = r11;	 Catch:{ Throwable -> 0x02b9 }
        r1 = r13;	 Catch:{ Throwable -> 0x02b9 }
        r5 = r15;	 Catch:{ Throwable -> 0x02b9 }
        r7 = r16;	 Catch:{ Throwable -> 0x02b9 }
        r14 = r23;	 Catch:{ Throwable -> 0x02b9 }
        r15 = r28;	 Catch:{ Throwable -> 0x02b9 }
        r13 = r31;	 Catch:{ Throwable -> 0x02b9 }
        r11 = 0;	 Catch:{ Throwable -> 0x02b9 }
        r12 = 0;	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x0094;	 Catch:{ Throwable -> 0x02b9 }
    L_0x0294:
        r15 = r5;	 Catch:{ Throwable -> 0x02b9 }
        r11 = r6;	 Catch:{ Throwable -> 0x02b9 }
        r2 = r15.length();	 Catch:{ Throwable -> 0x02b9 }
        if (r2 <= 0) goto L_0x02b8;	 Catch:{ Throwable -> 0x02b9 }
    L_0x029c:
        r2 = new org.android.agoo.common.MsgDO;	 Catch:{ Throwable -> 0x02b9 }
        r2.<init>();	 Catch:{ Throwable -> 0x02b9 }
        r3 = r11.toString();	 Catch:{ Throwable -> 0x02b9 }
        r2.msgIds = r3;	 Catch:{ Throwable -> 0x02b9 }
        r3 = r15.toString();	 Catch:{ Throwable -> 0x02b9 }
        r2.removePacks = r3;	 Catch:{ Throwable -> 0x02b9 }
        r3 = "10";	 Catch:{ Throwable -> 0x02b9 }
        r2.errorCode = r3;	 Catch:{ Throwable -> 0x02b9 }
        r2.messageSource = r9;	 Catch:{ Throwable -> 0x02b9 }
        r3 = r8.notifyManager;	 Catch:{ Throwable -> 0x02b9 }
        r3.handlerACKMessage(r2, r10);	 Catch:{ Throwable -> 0x02b9 }
    L_0x02b8:
        return r1;	 Catch:{ Throwable -> 0x02b9 }
    L_0x02b9:
        r0 = move-exception;	 Catch:{ Throwable -> 0x02b9 }
        r1 = r0;	 Catch:{ Throwable -> 0x02b9 }
        goto L_0x02eb;	 Catch:{ Throwable -> 0x02b9 }
    L_0x02bc:
        r1 = com.taobao.accs.utl.UTMini.getInstance();	 Catch:{ Throwable -> 0x02b9 }
        r3 = "accs.msgRecevie";	 Catch:{ Throwable -> 0x02b9 }
        r4 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r4 = com.taobao.accs.utl.a.b(r4);	 Catch:{ Throwable -> 0x02b9 }
        r5 = "data==null";	 Catch:{ Throwable -> 0x02b9 }
        r1.commitEvent(r2, r3, r4, r5);	 Catch:{ Throwable -> 0x02b9 }
        r1 = "AgooFactory";	 Catch:{ Throwable -> 0x02b9 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02b9 }
        r3 = "handleMessage data==null,utdid=";	 Catch:{ Throwable -> 0x02b9 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x02b9 }
        r3 = mContext;	 Catch:{ Throwable -> 0x02b9 }
        r3 = com.taobao.accs.utl.a.b(r3);	 Catch:{ Throwable -> 0x02b9 }
        r2.append(r3);	 Catch:{ Throwable -> 0x02b9 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x02b9 }
        r3 = 0;	 Catch:{ Throwable -> 0x02b9 }
        r4 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x02b9 }
        com.taobao.accs.utl.ALog.i(r1, r2, r4);	 Catch:{ Throwable -> 0x02b9 }
        r1 = 0;
        return r1;
    L_0x02eb:
        r2 = com.taobao.accs.utl.ALog.Level.E;
        r2 = com.taobao.accs.utl.ALog.isPrintLog(r2);
        if (r2 == 0) goto L_0x0309;
    L_0x02f3:
        r2 = "AgooFactory";
        r3 = new java.lang.StringBuilder;
        r4 = "msgRecevie is error,e=";
        r3.<init>(r4);
        r3.append(r1);
        r1 = r3.toString();
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.taobao.accs.utl.ALog.e(r2, r1, r3);
    L_0x0309:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.AgooFactory.msgReceiverPreHandler(byte[], java.lang.String, com.taobao.accs.base.TaoBaseService$ExtraInfo, boolean):android.os.Bundle");
    }

    public static String parseEncryptedMsg(String str) {
        try {
            byte[] a;
            String a2 = Config.a(mContext);
            if (a.a != 2) {
                SecurityGuardManager instance = SecurityGuardManager.getInstance(mContext);
                if (instance != null) {
                    ALog.d(TAG, "SecurityGuardManager not null!", new Object[0]);
                    ISecureSignatureComponent secureSignatureComp = instance.getSecureSignatureComp();
                    SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                    securityGuardParamContext.appKey = a2;
                    Map map = securityGuardParamContext.paramMap;
                    String str2 = SecureSignatureDefine.OPEN_KEY_SIGN_INPUT;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a2);
                    stringBuilder.append(com.taobao.accs.utl.a.b(mContext));
                    map.put(str2, stringBuilder.toString());
                    securityGuardParamContext.requestType = 3;
                    a = b.a(secureSignatureComp.signRequest(securityGuardParamContext, a.c));
                    if (a == null) {
                    }
                    ALog.e(TAG, "aesDecrypt key is null!", new Object[0]);
                    return null;
                }
                ALog.e(TAG, "SecurityGuardManager is null", new Object[0]);
            } else if (TextUtils.isEmpty(com.taobao.accs.utl.a.b)) {
                ALog.e(TAG, "getAppsign secret null", new Object[0]);
            } else {
                a = com.taobao.accs.utl.a.b.getBytes("utf-8");
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a2);
                stringBuilder2.append(com.taobao.accs.utl.a.b(mContext));
                a = b.a(a, stringBuilder2.toString().getBytes("utf-8"));
                if (a == null && a.length > 0) {
                    return new String(b.a(org.android.agoo.common.a.a(str, 16), new SecretKeySpec(b.a(a), "AES"), b.a(a2.getBytes("utf-8"))), "utf-8");
                }
                ALog.e(TAG, "aesDecrypt key is null!", new Object[0]);
                return null;
            }
            a = null;
            if (a == null) {
            }
            ALog.e(TAG, "aesDecrypt key is null!", new Object[0]);
            return null;
        } catch (String str3) {
            ALog.e(TAG, "parseEncryptedMsg failure: ", str3, new Object[0]);
            return null;
        }
    }

    public void reportCacheMsg() {
        try {
            this.mThreadPool.execute(new c(this));
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("reportCacheMsg fail:");
            stringBuilder.append(th.toString());
            ALog.e(str, stringBuilder.toString(), new Object[0]);
        }
    }

    public void updateMsg(byte[] bArr, boolean z) {
        this.mThreadPool.execute(new d(this, bArr, z));
    }

    public void updateNotifyMsg(String str, String str2) {
        this.mThreadPool.execute(new e(this, str, str2));
    }

    public void updateMsgStatus(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    if (ALog.isPrintLog(Level.I)) {
                        String str3 = TAG;
                        StringBuilder stringBuilder = new StringBuilder("updateNotifyMsg begin,messageId=");
                        stringBuilder.append(str);
                        stringBuilder.append(",status=");
                        stringBuilder.append(str2);
                        stringBuilder.append(",reportTimes=");
                        stringBuilder.append(Config.e(mContext));
                        ALog.i(str3, stringBuilder.toString(), new Object[0]);
                    }
                    if (TextUtils.equals(str2, "8")) {
                        this.messageService.a(str, "2");
                        return;
                    }
                    if (TextUtils.equals(str2, "9") != null) {
                        this.messageService.a(str, "3");
                    }
                }
            }
        } catch (String str4) {
            str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("updateNotifyMsg e=");
            stringBuilder2.append(str4.toString());
            ALog.e(str2, stringBuilder2.toString(), new Object[0]);
        }
    }

    private static final boolean checkPackage(android.content.Context r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x000d }
        r1 = r1.getApplicationInfo(r2, r0);	 Catch:{ Throwable -> 0x000d }
        if (r1 == 0) goto L_0x000d;
    L_0x000b:
        r1 = 1;
        return r1;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.AgooFactory.checkPackage(android.content.Context, java.lang.String):boolean");
    }

    private static android.os.Bundle getFlag(long r8, org.android.agoo.common.MsgDO r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new android.os.Bundle;
        r0.<init>();
        r8 = java.lang.Long.toBinaryString(r8);	 Catch:{ Throwable -> 0x0099 }
        r8 = r8.toCharArray();	 Catch:{ Throwable -> 0x0099 }
        if (r8 == 0) goto L_0x0099;	 Catch:{ Throwable -> 0x0099 }
    L_0x000f:
        r9 = r8.length;	 Catch:{ Throwable -> 0x0099 }
        r1 = 8;	 Catch:{ Throwable -> 0x0099 }
        if (r1 > r9) goto L_0x0099;	 Catch:{ Throwable -> 0x0099 }
    L_0x0014:
        r9 = r8.length;	 Catch:{ Throwable -> 0x0099 }
        r2 = 1;	 Catch:{ Throwable -> 0x0099 }
        r3 = 49;	 Catch:{ Throwable -> 0x0099 }
        if (r1 > r9) goto L_0x006b;	 Catch:{ Throwable -> 0x0099 }
    L_0x001a:
        r9 = "encrypted";	 Catch:{ Throwable -> 0x0099 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0099 }
        r4.<init>();	 Catch:{ Throwable -> 0x0099 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0099 }
        r5.<init>();	 Catch:{ Throwable -> 0x0099 }
        r6 = r8[r2];	 Catch:{ Throwable -> 0x0099 }
        r5.append(r6);	 Catch:{ Throwable -> 0x0099 }
        r6 = 2;	 Catch:{ Throwable -> 0x0099 }
        r7 = r8[r6];	 Catch:{ Throwable -> 0x0099 }
        r5.append(r7);	 Catch:{ Throwable -> 0x0099 }
        r7 = 3;	 Catch:{ Throwable -> 0x0099 }
        r7 = r8[r7];	 Catch:{ Throwable -> 0x0099 }
        r5.append(r7);	 Catch:{ Throwable -> 0x0099 }
        r7 = 4;	 Catch:{ Throwable -> 0x0099 }
        r7 = r8[r7];	 Catch:{ Throwable -> 0x0099 }
        r5.append(r7);	 Catch:{ Throwable -> 0x0099 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0099 }
        r5 = java.lang.Integer.parseInt(r5, r6);	 Catch:{ Throwable -> 0x0099 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0099 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0099 }
        r0.putString(r9, r4);	 Catch:{ Throwable -> 0x0099 }
        r9 = 6;	 Catch:{ Throwable -> 0x0099 }
        r9 = r8[r9];	 Catch:{ Throwable -> 0x0099 }
        if (r9 != r3) goto L_0x005f;	 Catch:{ Throwable -> 0x0099 }
    L_0x0054:
        r9 = "report";	 Catch:{ Throwable -> 0x0099 }
        r4 = "1";	 Catch:{ Throwable -> 0x0099 }
        r0.putString(r9, r4);	 Catch:{ Throwable -> 0x0099 }
        r9 = "1";	 Catch:{ Throwable -> 0x0099 }
        r10.reportStr = r9;	 Catch:{ Throwable -> 0x0099 }
    L_0x005f:
        r9 = 7;	 Catch:{ Throwable -> 0x0099 }
        r9 = r8[r9];	 Catch:{ Throwable -> 0x0099 }
        if (r9 != r3) goto L_0x006b;	 Catch:{ Throwable -> 0x0099 }
    L_0x0064:
        r9 = "notify";	 Catch:{ Throwable -> 0x0099 }
        r10 = "1";	 Catch:{ Throwable -> 0x0099 }
        r0.putString(r9, r10);	 Catch:{ Throwable -> 0x0099 }
    L_0x006b:
        r9 = r8.length;	 Catch:{ Throwable -> 0x0099 }
        r10 = 9;	 Catch:{ Throwable -> 0x0099 }
        if (r10 > r9) goto L_0x007b;	 Catch:{ Throwable -> 0x0099 }
    L_0x0070:
        r9 = r8[r1];	 Catch:{ Throwable -> 0x0099 }
        if (r9 != r3) goto L_0x007b;	 Catch:{ Throwable -> 0x0099 }
    L_0x0074:
        r9 = "has_test";	 Catch:{ Throwable -> 0x0099 }
        r1 = "1";	 Catch:{ Throwable -> 0x0099 }
        r0.putString(r9, r1);	 Catch:{ Throwable -> 0x0099 }
    L_0x007b:
        r9 = r8.length;	 Catch:{ Throwable -> 0x0099 }
        r1 = 10;	 Catch:{ Throwable -> 0x0099 }
        if (r1 > r9) goto L_0x008b;	 Catch:{ Throwable -> 0x0099 }
    L_0x0080:
        r9 = r8[r10];	 Catch:{ Throwable -> 0x0099 }
        if (r9 != r3) goto L_0x008b;	 Catch:{ Throwable -> 0x0099 }
    L_0x0084:
        r9 = "duplicate";	 Catch:{ Throwable -> 0x0099 }
        r10 = "1";	 Catch:{ Throwable -> 0x0099 }
        r0.putString(r9, r10);	 Catch:{ Throwable -> 0x0099 }
    L_0x008b:
        r9 = 11;	 Catch:{ Throwable -> 0x0099 }
        r10 = r8.length;	 Catch:{ Throwable -> 0x0099 }
        if (r9 > r10) goto L_0x0099;	 Catch:{ Throwable -> 0x0099 }
    L_0x0090:
        r8 = r8[r1];	 Catch:{ Throwable -> 0x0099 }
        if (r8 != r3) goto L_0x0099;	 Catch:{ Throwable -> 0x0099 }
    L_0x0094:
        r8 = "popup";	 Catch:{ Throwable -> 0x0099 }
        r0.putInt(r8, r2);	 Catch:{ Throwable -> 0x0099 }
    L_0x0099:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.AgooFactory.getFlag(long, org.android.agoo.common.MsgDO):android.os.Bundle");
    }

    private void sendMsgToBussiness(Context context, String str, Bundle bundle, boolean z, String str2, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
        Intent intent = new Intent();
        intent.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
        intent.setPackage(str);
        intent.putExtras(bundle);
        intent.putExtra("type", "common-push");
        intent.putExtra(AgooConstants.MESSAGE_SOURCE, str2);
        intent.addFlags(32);
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(AgooConstants.MESSAGE_ACCS_EXTRA, taoBaseService$ExtraInfo);
            intent.putExtra(AgooConstants.MESSAGE_AGOO_BUNDLE, bundle2);
        } catch (TaoBaseService$ExtraInfo taoBaseService$ExtraInfo2) {
            ALog.e(TAG, "sendMsgToBussiness", taoBaseService$ExtraInfo2, new Object[0]);
        }
        if (ALog.isPrintLog(Level.I) != null) {
            taoBaseService$ExtraInfo2 = TAG;
            StringBuilder stringBuilder = new StringBuilder("sendMsgToBussiness intent:");
            stringBuilder.append(bundle.toString());
            stringBuilder.append(",utdid=");
            stringBuilder.append(com.taobao.accs.utl.a.b(context));
            stringBuilder.append(",pack=");
            stringBuilder.append(str);
            stringBuilder.append(",agooFlag=");
            stringBuilder.append(z);
            ALog.i(taoBaseService$ExtraInfo2, stringBuilder.toString(), new Object[0]);
        }
        if (z) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.a.b(context), "agooMsg", "15");
            sendMsgByBindService(str, intent);
            return;
        }
        intent.setClassName(str, a.a(str));
        context.startService(intent);
    }

    private void sendMsgByBindService(String str, Intent intent) {
        try {
            if (ALog.isPrintLog(Level.D)) {
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder("onHandleMessage current tid:");
                stringBuilder.append(Thread.currentThread().getId());
                ALog.d(str2, stringBuilder.toString(), new Object[0]);
            }
            this.mThreadPool.execute(new b(this, str, intent));
        } catch (String str3) {
            ALog.e(TAG, "sendMsgByBindService error >>", str3, new Object[0]);
        }
    }
}
