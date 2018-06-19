package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.strategy.StrategyCenter;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.d;
import com.taobao.accs.net.b;
import com.taobao.accs.net.k;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.a;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ACCSManagerImpl implements IACCSManager {
    public b a;
    private int b = 0;
    private String c;
    private String d = "ACCSMgrImpl_";

    public java.lang.String sendPushResponse(android.content.Context r20, com.taobao.accs.ACCSManager.AccsRequest r21, com.taobao.accs.base.TaoBaseService$ExtraInfo r22) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r19 = this;
        r1 = r19;
        r2 = r20;
        r3 = r21;
        r6 = 5;
        r7 = 4;
        r8 = 3;
        r9 = 2;
        r10 = 0;
        r11 = 1;
        r12 = 0;
        if (r2 == 0) goto L_0x01fe;
    L_0x000f:
        if (r3 != 0) goto L_0x0013;
    L_0x0011:
        goto L_0x01fe;
    L_0x0013:
        r13 = "accs";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r14 = "send_fail";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15 = "push response total";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.b.a(r13, r14, r15);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r13 = com.taobao.accs.utl.UtilityImpl.getFocusDisableStatus(r20);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r13 == 0) goto L_0x0030;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0022:
        r2 = "accs";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "send_fail";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r3.serviceId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = "1";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r7 = "sendPushResponse accs disable";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.b.a(r2, r4, r5, r6, r7);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        return r10;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0030:
        r13 = r1.a;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r13 = r13.i();	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r14 = android.text.TextUtils.isEmpty(r13);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r14 == 0) goto L_0x0061;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x003c:
        r2 = "accs";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "send_fail";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r3.serviceId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = "1";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r7 = "sendPushResponse appkey null";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.b.a(r2, r4, r5, r6, r7);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = r1.d;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = "sendPushResponse appkey null dataid:";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4.<init>(r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r3.dataId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4.append(r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = r4.toString();	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = new java.lang.Object[r12];	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.ALog.e(r2, r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        return r10;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0061:
        r14 = r3.dataId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r14 = android.text.TextUtils.isEmpty(r14);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r14 == 0) goto L_0x0087;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0069:
        r14 = com.taobao.accs.internal.ACCSManagerImpl.class;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        monitor-enter(r14);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15 = r1.b;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15 = r15 + r11;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r1.b = r15;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15.<init>();	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r1.b;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15.append(r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r15.toString();	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r3.dataId = r5;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        monitor-exit(r14);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        goto L_0x0087;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0083:
        r0 = move-exception;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = r0;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        monitor-exit(r14);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        throw r2;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0087:
        if (r22 != 0) goto L_0x008f;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0089:
        r4 = new com.taobao.accs.base.TaoBaseService$ExtraInfo;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4.<init>();	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        goto L_0x0091;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x008f:
        r4 = r22;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0091:
        r3.host = r10;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r20.getPackageName();	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4.fromPackage = r5;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r4.connType;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r5 == 0) goto L_0x00a4;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x009d:
        r5 = r4.fromHost;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r5 != 0) goto L_0x00a2;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x00a1:
        goto L_0x00a4;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x00a2:
        r5 = r11;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        goto L_0x00b8;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x00a4:
        r4.connType = r12;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r1.d;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r14 = "pushresponse use channel";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15 = new java.lang.Object[r9];	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r17 = "host";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15[r12] = r17;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10 = r4.fromHost;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15[r11] = r10;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.ALog.w(r5, r14, r15);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r12;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x00b8:
        r10 = r1.d;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r14 = "sendPushResponse";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15 = 8;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15 = new java.lang.Object[r15];	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r17 = "sendbyInapp";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15[r12] = r17;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r17 = java.lang.Boolean.valueOf(r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15[r11] = r17;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r17 = "host";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15[r9] = r17;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r11 = r4.fromHost;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15[r8] = r11;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r11 = "pkg";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15[r7] = r11;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r11 = r4.fromPackage;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15[r6] = r11;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r11 = "dataId";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r16 = 6;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15[r16] = r11;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r11 = 7;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = r3.dataId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r15[r11] = r6;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.ALog.i(r10, r14, r15);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r5 == 0) goto L_0x014d;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x00ea:
        r5 = r1.d;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = "sendPushResponse inapp by";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r7 = new java.lang.Object[r9];	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r8 = "app";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r7[r12] = r8;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r8 = r4.fromPackage;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r9 = 1;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r7[r9] = r8;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.ALog.i(r5, r6, r7);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = new java.net.URL;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = r4.fromHost;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5.<init>(r6);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r3.host = r5;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r20.getPackageName();	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = r4.fromPackage;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r5 == 0) goto L_0x0120;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0111:
        r5 = com.taobao.accs.utl.UtilityImpl.isMainProcess(r20);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r5 == 0) goto L_0x0120;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0117:
        r4 = r20.getPackageName();	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r1.sendRequest(r2, r3, r4, r12);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        goto L_0x0261;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0120:
        r5 = new android.content.Intent;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = "com.taobao.accs.intent.action.SEND";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5.<init>(r6);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = r4.fromPackage;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = "com.taobao.accs.data.MsgDistributeService";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5.setClassName(r4, r6);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "packageName";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = r20.getPackageName();	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5.putExtra(r4, r6);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "reqdata";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5.putExtra(r4, r3);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "appKey";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5.putExtra(r4, r13);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "configTag";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = r1.c;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5.putExtra(r4, r6);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2.startService(r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        goto L_0x0261;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x014d:
        r5 = 100;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = r1.a(r2, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r6 != 0) goto L_0x0189;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0155:
        r6 = "accs";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10 = "send_fail";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r11 = r3.serviceId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r13 = "1";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r14 = "push response intent null";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.b.a(r6, r10, r11, r13, r14);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = r3.serviceId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10 = r3.dataId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r1.a(r2, r5, r6, r10);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r1.d;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = "sendPushResponse input null";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10 = 6;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r11 = "context";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r12] = r11;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r11 = 1;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r11] = r2;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = "response";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r9] = r2;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r8] = r3;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = "extraInfo";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r7] = r2;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = 5;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r2] = r4;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.ALog.e(r5, r6, r10);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = 0;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        return r2;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x0189:
        r5 = r1.d;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r7 = "sendPushResponse channel by";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r8 = new java.lang.Object[r9];	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r9 = "app";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r8[r12] = r9;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r9 = r4.fromPackage;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10 = 1;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r8[r10] = r9;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.ALog.i(r5, r7, r8);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = r4.fromPackage;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = "com.taobao.accs.ChannelService";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.setClassName(r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "send_type";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = com.taobao.accs.data.Message.ReqType.REQ;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.putExtra(r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "appKey";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.putExtra(r4, r13);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "userInfo";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r3.userId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.putExtra(r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "serviceId";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r3.serviceId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.putExtra(r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "data";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r3.data;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.putExtra(r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "dataId";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r3.dataId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.putExtra(r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "configTag";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r1.c;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.putExtra(r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = r3.businessId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r4 != 0) goto L_0x01e0;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x01d9:
        r4 = "businessId";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r3.businessId;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.putExtra(r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x01e0:
        r4 = r3.tag;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r4 != 0) goto L_0x01ef;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x01e8:
        r4 = "extTag";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r3.tag;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.putExtra(r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x01ef:
        r4 = r3.target;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        if (r4 == 0) goto L_0x01fa;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x01f3:
        r4 = "target";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = r3.target;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6.putExtra(r4, r5);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x01fa:
        r2.startService(r6);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        goto L_0x0261;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
    L_0x01fe:
        r5 = r1.d;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = "sendPushResponse input null";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10 = 6;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r11 = "context";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r12] = r11;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r11 = 1;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r11] = r2;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = "response";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r9] = r2;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r8] = r3;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = "extraInfo";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r7] = r2;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = 5;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r10[r2] = r22;	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.ALog.e(r5, r6, r10);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = "accs";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r4 = "send_fail";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r5 = "";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r6 = "1";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r7 = "sendPushResponse null";	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        com.taobao.accs.utl.b.a(r2, r4, r5, r6, r7);	 Catch:{ all -> 0x0083, Throwable -> 0x022b }
        r2 = 0;
        return r2;
    L_0x022b:
        r0 = move-exception;
        r2 = r0;
        r4 = "accs";
        r5 = "send_fail";
        r6 = r3.serviceId;
        r7 = "1";
        r8 = new java.lang.StringBuilder;
        r9 = "push response ";
        r8.<init>(r9);
        r9 = r2.toString();
        r8.append(r9);
        r8 = r8.toString();
        com.taobao.accs.utl.b.a(r4, r5, r6, r7, r8);
        r4 = r1.d;
        r5 = new java.lang.StringBuilder;
        r6 = "sendPushResponse dataid:";
        r5.<init>(r6);
        r3 = r3.dataId;
        r5.append(r3);
        r3 = r5.toString();
        r5 = new java.lang.Object[r12];
        com.taobao.accs.utl.ALog.e(r4, r3, r2, r5);
    L_0x0261:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.sendPushResponse(android.content.Context, com.taobao.accs.ACCSManager$AccsRequest, com.taobao.accs.base.TaoBaseService$ExtraInfo):java.lang.String");
    }

    public ACCSManagerImpl(Context context, String str) {
        GlobalClientInfo.a = context.getApplicationContext();
        this.a = new k(GlobalClientInfo.a, 1, str);
        this.c = str;
        context = new StringBuilder();
        context.append(this.d);
        context.append(this.a.m);
        this.d = context.toString();
    }

    public void bindApp(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        bindApp(context, str, "accs", str2, iAppReceiver);
    }

    public void bindApp(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, com.taobao.accs.IAppReceiver r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        if (r6 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r8 = r5.d;
        r0 = new java.lang.StringBuilder;
        r1 = "bindApp APPKEY:";
        r0.<init>(r1);
        r0.append(r7);
        r0 = r0.toString();
        r1 = 0;
        r2 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.d(r8, r0, r2);
        r8 = r6.getPackageName();
        r0 = 1;
        r8 = com.taobao.accs.data.Message.a(r8, r0);
        r2 = com.taobao.accs.utl.UtilityImpl.getFocusDisableStatus(r6);
        if (r2 == 0) goto L_0x0034;
    L_0x0028:
        r2 = r5.d;
        r3 = "accs disabled, try enable";
        r4 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r2, r3, r4);
        com.taobao.accs.utl.UtilityImpl.focusEnableService(r6);
    L_0x0034:
        r2 = r5.a;
        r2 = r2.k();
        if (r2 == 0) goto L_0x0052;
    L_0x003c:
        r2 = r5.a;
        r2 = r2.i;
        r2 = r2.getAppSecret();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0052;
    L_0x004a:
        r6 = r5.a;
        r7 = -15;
        r6.b(r8, r7);
        return;
    L_0x0052:
        r2 = android.text.TextUtils.isEmpty(r7);
        if (r2 == 0) goto L_0x0060;
    L_0x0058:
        r6 = r5.a;
        r7 = -14;
        r6.b(r8, r7);
        return;
    L_0x0060:
        r8 = r5.a;
        r8.a = r9;
        r8 = r5.a;
        r8.b = r7;
        r8 = r5.a;
        r8 = r8.i;
        r8 = r8.getAppSecret();
        com.taobao.accs.utl.UtilityImpl.saveAppKey(r6, r7, r8);
        if (r10 == 0) goto L_0x007e;
    L_0x0075:
        r8 = com.taobao.accs.client.GlobalClientInfo.getInstance(r6);
        r2 = r5.c;
        r8.setAppReceiver(r2, r10);
    L_0x007e:
        com.taobao.accs.utl.UtilityImpl.enableService(r6);
        r8 = r5.a(r6, r0);
        if (r8 != 0) goto L_0x0088;
    L_0x0087:
        return;
    L_0x0088:
        r10 = com.taobao.accs.client.GlobalClientInfo.getInstance(r6);	 Catch:{ Throwable -> 0x00fe }
        r10 = r10.getPackageInfo();	 Catch:{ Throwable -> 0x00fe }
        r10 = r10.versionName;	 Catch:{ Throwable -> 0x00fe }
        r2 = com.taobao.accs.utl.UtilityImpl.appVersionChanged(r6);	 Catch:{ Throwable -> 0x00fe }
        if (r2 != 0) goto L_0x00a3;	 Catch:{ Throwable -> 0x00fe }
    L_0x0098:
        r2 = "ACCS_SDK";	 Catch:{ Throwable -> 0x00fe }
        r2 = com.taobao.accs.utl.UtilityImpl.utdidChanged(r2, r6);	 Catch:{ Throwable -> 0x00fe }
        if (r2 == 0) goto L_0x00a1;	 Catch:{ Throwable -> 0x00fe }
    L_0x00a0:
        goto L_0x00a3;	 Catch:{ Throwable -> 0x00fe }
    L_0x00a1:
        r2 = r1;	 Catch:{ Throwable -> 0x00fe }
        goto L_0x00a4;	 Catch:{ Throwable -> 0x00fe }
    L_0x00a3:
        r2 = r0;	 Catch:{ Throwable -> 0x00fe }
    L_0x00a4:
        if (r2 == 0) goto L_0x00ab;	 Catch:{ Throwable -> 0x00fe }
    L_0x00a6:
        r3 = "fouce_bind";	 Catch:{ Throwable -> 0x00fe }
        r8.putExtra(r3, r0);	 Catch:{ Throwable -> 0x00fe }
    L_0x00ab:
        r3 = "appKey";	 Catch:{ Throwable -> 0x00fe }
        r8.putExtra(r3, r7);	 Catch:{ Throwable -> 0x00fe }
        r7 = "ttid";	 Catch:{ Throwable -> 0x00fe }
        r8.putExtra(r7, r9);	 Catch:{ Throwable -> 0x00fe }
        r7 = "appVersion";	 Catch:{ Throwable -> 0x00fe }
        r8.putExtra(r7, r10);	 Catch:{ Throwable -> 0x00fe }
        r7 = "app_sercet";	 Catch:{ Throwable -> 0x00fe }
        r9 = r5.a;	 Catch:{ Throwable -> 0x00fe }
        r9 = r9.i;	 Catch:{ Throwable -> 0x00fe }
        r9 = r9.getAppSecret();	 Catch:{ Throwable -> 0x00fe }
        r8.putExtra(r7, r9);	 Catch:{ Throwable -> 0x00fe }
        r7 = com.taobao.accs.utl.UtilityImpl.isMainProcess(r6);	 Catch:{ Throwable -> 0x00fe }
        if (r7 == 0) goto L_0x00d6;	 Catch:{ Throwable -> 0x00fe }
    L_0x00cd:
        r7 = r5.a;	 Catch:{ Throwable -> 0x00fe }
        r7 = com.taobao.accs.data.Message.a(r7, r6, r8);	 Catch:{ Throwable -> 0x00fe }
        r5.a(r6, r7, r0, r2);	 Catch:{ Throwable -> 0x00fe }
    L_0x00d6:
        r7 = r5.a;	 Catch:{ Throwable -> 0x00fe }
        r6 = r6.getApplicationContext();	 Catch:{ Throwable -> 0x00fe }
        r7.b(r6);	 Catch:{ Throwable -> 0x00fe }
        r6 = new java.lang.String[r0];	 Catch:{ Throwable -> 0x00f4 }
        r7 = "accs";	 Catch:{ Throwable -> 0x00f4 }
        r6[r1] = r7;	 Catch:{ Throwable -> 0x00f4 }
        r7 = new com.taobao.accs.utl.i$a;	 Catch:{ Throwable -> 0x00f4 }
        r7.<init>();	 Catch:{ Throwable -> 0x00f4 }
        com.taobao.accs.utl.i.a(r6, r7);	 Catch:{ Throwable -> 0x00f4 }
        com.taobao.accs.utl.i.f();	 Catch:{ Throwable -> 0x00f4 }
        com.taobao.accs.utl.i.e();	 Catch:{ Throwable -> 0x00f4 }
        return;
    L_0x00f4:
        r6 = r5.d;	 Catch:{ Throwable -> 0x00fe }
        r7 = "no orange sdk";	 Catch:{ Throwable -> 0x00fe }
        r8 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00fe }
        com.taobao.accs.utl.ALog.w(r6, r7, r8);	 Catch:{ Throwable -> 0x00fe }
        return;
    L_0x00fe:
        r6 = move-exception;
        r7 = r5.d;
        r8 = "bindApp exception";
        r9 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r7, r8, r6, r9);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.bindApp(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.taobao.accs.IAppReceiver):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r8, com.taobao.accs.data.Message r9, int r10, boolean r11) {
        /*
        r7 = this;
        r0 = r7.a;
        r0.a();
        r0 = 0;
        if (r9 != 0) goto L_0x0020;
    L_0x0008:
        r9 = r7.d;
        r11 = "message is null";
        r0 = new java.lang.Object[r0];
        com.taobao.accs.utl.ALog.e(r9, r11, r0);
        r8 = r8.getPackageName();
        r8 = com.taobao.accs.data.Message.a(r8, r10);
        r9 = r7.a;
        r10 = -2;
        r9.b(r8, r10);
        return;
    L_0x0020:
        r8 = 2;
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2 = 1;
        switch(r10) {
            case 1: goto L_0x00a6;
            case 2: goto L_0x0073;
            case 3: goto L_0x0029;
            default: goto L_0x0027;
        };
    L_0x0027:
        goto L_0x00da;
    L_0x0029:
        r3 = r7.a;
        r3 = r3.j();
        r4 = r9.f();
        r5 = r9.E;
        r3 = r3.b(r4, r5);
        if (r3 == 0) goto L_0x00da;
    L_0x003b:
        if (r11 != 0) goto L_0x00da;
    L_0x003d:
        r3 = r7.d;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r9.f();
        r4.append(r5);
        r5 = "/";
        r4.append(r5);
        r5 = r9.E;
        r4.append(r5);
        r5 = " isUserBinded";
        r4.append(r5);
        r4 = r4.toString();
        r5 = new java.lang.Object[r8];
        r6 = "isForceBind";
        r5[r0] = r6;
        r11 = java.lang.Boolean.valueOf(r11);
        r5[r2] = r11;
        com.taobao.accs.utl.ALog.i(r3, r4, r5);
        r11 = r7.a;
        r11.b(r9, r1);
        goto L_0x00a4;
    L_0x0073:
        r11 = r7.a;
        r11 = r11.j();
        r3 = r9.f();
        r11 = r11.d(r3);
        if (r11 == 0) goto L_0x00da;
    L_0x0083:
        r11 = r7.d;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r9.f();
        r3.append(r4);
        r4 = " isAppUnbinded";
        r3.append(r4);
        r3 = r3.toString();
        r4 = new java.lang.Object[r0];
        com.taobao.accs.utl.ALog.i(r11, r3, r4);
        r11 = r7.a;
        r11.b(r9, r1);
    L_0x00a4:
        r11 = r0;
        goto L_0x00db;
    L_0x00a6:
        r3 = r7.a;
        r3 = r3.j();
        r4 = r9.f();
        r3 = r3.c(r4);
        if (r3 == 0) goto L_0x00da;
    L_0x00b6:
        if (r11 != 0) goto L_0x00da;
    L_0x00b8:
        r11 = r7.d;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r9.f();
        r3.append(r4);
        r4 = " isAppBinded";
        r3.append(r4);
        r3 = r3.toString();
        r4 = new java.lang.Object[r0];
        com.taobao.accs.utl.ALog.i(r11, r3, r4);
        r11 = r7.a;
        r11.b(r9, r1);
        goto L_0x00a4;
    L_0x00da:
        r11 = r2;
    L_0x00db:
        if (r11 == 0) goto L_0x00f5;
    L_0x00dd:
        r11 = r7.d;
        r1 = "sendControlMessage";
        r8 = new java.lang.Object[r8];
        r3 = "command";
        r8[r0] = r3;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r2] = r10;
        com.taobao.accs.utl.ALog.i(r11, r1, r8);
        r8 = r7.a;
        r8.b(r9, r2);
    L_0x00f5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.a(android.content.Context, com.taobao.accs.data.Message, int, boolean):void");
    }

    public void unbindApp(Context context) {
        String str = this.d;
        StringBuilder stringBuilder = new StringBuilder("unbindApp");
        stringBuilder.append(UtilityImpl.getStackMsg(new Exception()));
        ALog.e(str, stringBuilder.toString(), new Object[0]);
        if (!UtilityImpl.getFocusDisableStatus(context)) {
            Intent a = a(context, 2);
            if (a == null) {
                a(context, 2, null, null);
                return;
            }
            if (UtilityImpl.isMainProcess(context)) {
                a(context, Message.b(this.a, context, a), 2, false);
            }
        }
    }

    public void bindUser(Context context, String str) {
        bindUser(context, str, false);
    }

    public void bindUser(Context context, String str, boolean z) {
        try {
            ALog.i(this.d, "bindUser", "userId", str);
            if (UtilityImpl.getFocusDisableStatus(context)) {
                ALog.e(this.d, "accs disabled", new Object[0]);
                return;
            }
            Intent a = a(context, 3);
            if (a == null) {
                ALog.e(this.d, "intent null", new Object[0]);
                a(context, 3, null, null);
                return;
            }
            Object i = this.a.i();
            if (TextUtils.isEmpty(i)) {
                ALog.e(this.d, "appKey null", new Object[0]);
                return;
            }
            if (UtilityImpl.appVersionChanged(context) || z) {
                ALog.i(this.d, "force bind User", new Object[0]);
                a.putExtra(Constants.KEY_FOUCE_BIND, true);
                z = true;
            }
            a.putExtra("appKey", i);
            a.putExtra(Constants.KEY_USER_ID, str);
            if (UtilityImpl.isMainProcess(context) != null) {
                a(context, Message.c(this.a, a), 3, z);
            }
            this.a.b(context.getApplicationContext());
        } catch (Context context2) {
            ALog.e(this.d, "bindUser", context2, new Object[0]);
        }
    }

    public void unbindUser(Context context) {
        if (!UtilityImpl.getFocusDisableStatus(context) && !UtilityImpl.getFocusDisableStatus(context)) {
            Intent a = a(context, 4);
            if (a == null) {
                a(context, 4, null, null);
                return;
            }
            Object i = this.a.i();
            if (!TextUtils.isEmpty(i)) {
                a.putExtra("appKey", i);
                if (UtilityImpl.isMainProcess(context)) {
                    a(context, Message.d(this.a, a), 4, false);
                }
            }
        }
    }

    public void bindService(Context context, String str) {
        if (!UtilityImpl.getFocusDisableStatus(context) && !UtilityImpl.getFocusDisableStatus(context)) {
            Intent a = a(context, 5);
            if (a == null) {
                a(context, 5, str, null);
                return;
            }
            Object i = this.a.i();
            if (!TextUtils.isEmpty(i)) {
                a.putExtra("appKey", i);
                a.putExtra(Constants.KEY_SERVICE_ID, str);
                if (UtilityImpl.isMainProcess(context) != null) {
                    a(context, Message.a(this.a, a), 5, false);
                }
                this.a.b(context.getApplicationContext());
            }
        }
    }

    public void unbindService(Context context, String str) {
        if (!UtilityImpl.getFocusDisableStatus(context)) {
            Intent a = a(context, 6);
            if (a == null) {
                a(context, 6, str, null);
                return;
            }
            Object i = this.a.i();
            if (!TextUtils.isEmpty(i)) {
                a.putExtra("appKey", i);
                a.putExtra(Constants.KEY_SERVICE_ID, str);
                if (UtilityImpl.isMainProcess(context) != null) {
                    a(context, Message.b(this.a, a), 6, false);
                }
            }
        }
    }

    public String sendData(Context context, String str, String str2, byte[] bArr, String str3) {
        return sendData(context, str, str2, bArr, str3, null);
    }

    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendData(context, str, str2, bArr, str3, str4, null);
    }

    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendData(context, new AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    public String sendData(Context context, AccsRequest accsRequest) {
        StringBuilder stringBuilder;
        try {
            boolean focusDisableStatus = UtilityImpl.getFocusDisableStatus(context);
            if (UtilityImpl.isMainProcess(context)) {
                if (!focusDisableStatus) {
                    if (accsRequest != null) {
                        if (TextUtils.isEmpty(accsRequest.dataId)) {
                            synchronized (ACCSManagerImpl.class) {
                                this.b++;
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(this.b);
                                accsRequest.dataId = stringBuilder2.toString();
                            }
                        }
                        if (TextUtils.isEmpty(this.a.i())) {
                            com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "data appkey null");
                            context = this.d;
                            StringBuilder stringBuilder3 = new StringBuilder("send data appkey null dataid:");
                            stringBuilder3.append(accsRequest.dataId);
                            ALog.e(context, stringBuilder3.toString(), new Object[0]);
                            return null;
                        }
                        this.a.a();
                        Message a = Message.a(this.a, context, context.getPackageName(), accsRequest);
                        if (a.e() != null) {
                            a.e().onSend();
                        }
                        this.a.b(a, true);
                        return accsRequest.dataId;
                    }
                }
                if (focusDisableStatus) {
                    com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "accs disable");
                } else {
                    com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "data null");
                }
                context = this.d;
                stringBuilder = new StringBuilder("send data dataInfo null or disable:");
                stringBuilder.append(focusDisableStatus);
                ALog.e(context, stringBuilder.toString(), new Object[0]);
                return null;
            }
            ALog.e(this.d, "send data not in mainprocess", new Object[0]);
            return null;
        } catch (Context context2) {
            StringBuilder stringBuilder4 = new StringBuilder("data ");
            stringBuilder4.append(context2.toString());
            com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", stringBuilder4.toString());
            String str = this.d;
            stringBuilder = new StringBuilder("send data dataid:");
            stringBuilder.append(accsRequest.dataId);
            ALog.e(str, stringBuilder.toString(), context2, new Object[0]);
        }
    }

    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendRequest(context, str, str2, bArr, str3, str4, null);
    }

    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendRequest(context, new AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    public String sendRequest(Context context, AccsRequest accsRequest, String str, boolean z) {
        if (accsRequest == null) {
            try {
                ALog.e(this.d, "sendRequest request null", new Object[0]);
                com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, null, "1", "request null");
                return null;
            } catch (Context context2) {
                if (accsRequest != null) {
                    StringBuilder stringBuilder = new StringBuilder("request ");
                    stringBuilder.append(context2.toString());
                    com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", stringBuilder.toString());
                    str = this.d;
                    z = new StringBuilder("sendRequest dataid:");
                    z.append(accsRequest.dataId);
                    ALog.e(str, z.toString(), context2, new Object[0]);
                }
            }
        } else if (!UtilityImpl.isMainProcess(context2)) {
            ALog.e(this.d, "send data not in mainprocess", new Object[0]);
            return null;
        } else if (UtilityImpl.getFocusDisableStatus(context2)) {
            ALog.e(this.d, "sendRequest disable", new Object[0]);
            com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "accs disable");
            return null;
        } else {
            if (TextUtils.isEmpty(accsRequest.dataId)) {
                synchronized (ACCSManagerImpl.class) {
                    this.b++;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(this.b);
                    accsRequest.dataId = stringBuilder2.toString();
                }
            }
            if (TextUtils.isEmpty(this.a.i())) {
                com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request appkey null");
                context2 = this.d;
                str = new StringBuilder("sendRequest appkey null dataid:");
                str.append(accsRequest.dataId);
                ALog.e(context2, str.toString(), new Object[0]);
                return null;
            }
            this.a.a();
            if (str == null) {
                str = context2.getPackageName();
            }
            Message b = Message.b(this.a, context2, str, accsRequest, z);
            if (b.e() != null) {
                b.e().onSend();
            }
            this.a.b(b, true);
            return accsRequest.dataId;
        }
    }

    public String sendRequest(Context context, AccsRequest accsRequest) {
        return sendRequest(context, accsRequest, null, true);
    }

    public boolean isNetworkReachable(Context context) {
        return UtilityImpl.isNetworkConnected(context);
    }

    private Intent a(Context context, int i) {
        if (i == 1 || UtilityImpl.getServiceEnabled(context)) {
            Intent intent = new Intent();
            intent.setAction(Constants.ACTION_COMMAND);
            intent.setClassName(context.getPackageName(), a.channelService);
            intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
            intent.putExtra("command", i);
            intent.putExtra("appKey", this.a.b);
            intent.putExtra(Constants.KEY_CONFIG_TAG, this.c);
            return intent;
        }
        StringBuilder stringBuilder = new StringBuilder("getIntent null command:");
        stringBuilder.append(i);
        stringBuilder.append(" serviceEnable:");
        stringBuilder.append(UtilityImpl.getServiceEnabled(context));
        ALog.e(this.d, stringBuilder.toString(), new Object[0]);
        return null;
    }

    public void forceDisableService(Context context) {
        UtilityImpl.focusDisableService(context);
    }

    public void forceEnableService(Context context) {
        UtilityImpl.focusEnableService(context);
    }

    @Deprecated
    public void setMode(Context context, int i) {
        ACCSClient.setEnvironment(context, i);
    }

    private void a(Context context, int i, String str, String str2) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", i);
        intent.putExtra(Constants.KEY_SERVICE_ID, str);
        intent.putExtra(Constants.KEY_DATA_ID, str2);
        intent.putExtra("appKey", this.a.b);
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.c);
        intent.putExtra("errorCode", i == 2 ? 200 : 300);
        d.a(context, intent);
    }

    public void setProxy(Context context, String str, int i) {
        context = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        if (!TextUtils.isEmpty(str)) {
            context.putString(Constants.KEY_PROXY_HOST, str);
        }
        context.putInt(Constants.KEY_PROXY_PORT, i);
        context.apply();
    }

    public void startInAppConnection(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        startInAppConnection(context, str, null, str2, iAppReceiver);
    }

    public void startInAppConnection(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        GlobalClientInfo.getInstance(context).setAppReceiver(this.c, iAppReceiver);
        if (UtilityImpl.isMainProcess(context) == null) {
            ALog.d(this.d, "inapp only init in main process!", new Object[0]);
            return;
        }
        str2 = this.d;
        StringBuilder stringBuilder = new StringBuilder("startInAppConnection APPKEY:");
        stringBuilder.append(str);
        ALog.d(str2, stringBuilder.toString(), new Object[0]);
        if (TextUtils.isEmpty(str) == null) {
            if (TextUtils.equals(this.a.i(), str) == null) {
                this.a.a = str3;
                this.a.b = str;
                UtilityImpl.saveAppKey(context, str, this.a.i.getAppSecret());
            }
            this.a.a();
        }
    }

    public void setLoginInfo(Context context, ILoginInfo iLoginInfo) {
        GlobalClientInfo.getInstance(context).setLoginInfoImpl(this.a.m, iLoginInfo);
    }

    public void clearLoginInfo(Context context) {
        GlobalClientInfo.getInstance(context).clearLoginInfoImpl();
    }

    public boolean cancel(Context context, String str) {
        return this.a.a(str);
    }

    public Map<String, Boolean> getChannelState() throws Exception {
        String userUnit = getUserUnit();
        b bVar = this.a;
        GlobalClientInfo.getContext();
        String b = bVar.b(null);
        Map<String, Boolean> hashMap = new HashMap();
        hashMap.put(userUnit, Boolean.valueOf(false));
        hashMap.put(b, Boolean.valueOf(false));
        Session throwsException = SessionCenter.getInstance(this.a.i.getAppKey()).getThrowsException(b, 60000);
        Session throwsException2 = SessionCenter.getInstance(this.a.i.getAppKey()).getThrowsException(userUnit, 60000);
        if (throwsException != null) {
            hashMap.put(b, Boolean.valueOf(true));
        }
        if (throwsException2 != null) {
            hashMap.put(userUnit, Boolean.valueOf(true));
        }
        userUnit = this.d;
        StringBuilder stringBuilder = new StringBuilder("getChannelState ");
        stringBuilder.append(hashMap.toString());
        ALog.d(userUnit, stringBuilder.toString(), new Object[0]);
        return hashMap;
    }

    public Map<String, Boolean> forceReConnectChannel() throws Exception {
        SessionCenter.getInstance(this.a.i.getAppKey()).forceRecreateAccsSession();
        return getChannelState();
    }

    public String getUserUnit() {
        Context context = GlobalClientInfo.getContext();
        if (context == null) {
            ALog.e(this.d, "context is null", new Object[0]);
            return null;
        }
        String b = this.a.b(StrategyCenter.getInstance().getUnitPrefix(GlobalClientInfo.getInstance(context).getUserId(this.a.m), UtilityImpl.getDeviceId(context)));
        if (ALog.isPrintLog(Level.D)) {
            String str = this.d;
            StringBuilder stringBuilder = new StringBuilder("getUserUnit ");
            stringBuilder.append(b);
            ALog.d(str, stringBuilder.toString(), new Object[0]);
        }
        return b;
    }

    public boolean isChannelError(int i) {
        return ErrorCode.isChannelError(i);
    }

    public void registerSerivce(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    public void unRegisterSerivce(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    public void registerDataListener(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    public void unRegisterDataListener(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    public void sendBusinessAck(String str, String str2, String str3, short s, String str4, Map<Integer, String> map) {
        this.a.b(Message.a(this.a, str, str2, str3, true, s, str4, map), true);
    }

    public void updateConfig(AccsClientConfig accsClientConfig) {
        if (this.a instanceof k) {
            ((k) this.a).a(accsClientConfig);
        }
    }
}
