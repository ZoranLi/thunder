package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.antibrush.AntiBrush;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService$ExtraInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message.ReqType;
import com.taobao.accs.data.MessageHandler.1;
import com.taobao.accs.flowcontrol.FlowControl;
import com.taobao.accs.net.b;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.ut.statistics.d;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.e;
import com.taobao.accs.utl.h;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a {
    public ConcurrentMap<String, ScheduledFuture<?>> a = new ConcurrentHashMap();
    public int b;
    protected TrafficsMonitor c;
    public FlowControl d;
    public AntiBrush e;
    public String f = "";
    private ConcurrentMap<String, Message> g = new ConcurrentHashMap();
    private boolean h = false;
    private Context i;
    private d j;
    private Message k;
    private b l;
    private String m = "MsgRecv_";
    private LinkedHashMap<String, String> n = new 1(this);
    private Runnable o = new c(this);

    private boolean b(int i) {
        if (!(i == -1 || i == -9 || i == -10)) {
            if (i != -11) {
                return false;
            }
        }
        return true;
    }

    public a(Context context, b bVar) {
        this.i = context;
        this.l = bVar;
        this.c = new TrafficsMonitor(this.i);
        this.d = new FlowControl(this.i);
        this.e = new AntiBrush(this.i);
        if (bVar == null) {
            context = this.m;
        } else {
            context = new StringBuilder();
            context.append(this.m);
            context.append(bVar.m);
            context = context.toString();
        }
        this.m = context;
        h();
        g();
    }

    public void a(byte[] bArr) throws IOException {
        a(bArr, null);
    }

    public void a(byte[] bArr, String str) throws IOException {
        h hVar = new h(bArr);
        StringBuilder stringBuilder;
        try {
            String str2;
            StringBuilder stringBuilder2;
            int a = hVar.a();
            int i = (a & 240) >> 4;
            if (ALog.isPrintLog(Level.D)) {
                str2 = this.m;
                stringBuilder2 = new StringBuilder("version:");
                stringBuilder2.append(i);
                ALog.d(str2, stringBuilder2.toString(), new Object[0]);
            }
            a &= 15;
            if (ALog.isPrintLog(Level.D)) {
                str2 = this.m;
                stringBuilder2 = new StringBuilder("compress:");
                stringBuilder2.append(a);
                ALog.d(str2, stringBuilder2.toString(), new Object[0]);
            }
            hVar.a();
            int b = hVar.b();
            if (ALog.isPrintLog(Level.D)) {
                String str3 = this.m;
                stringBuilder = new StringBuilder("totalLen:");
                stringBuilder.append(b);
                ALog.d(str3, stringBuilder.toString(), new Object[0]);
            }
            int i2 = 0;
            while (i2 < b) {
                int b2 = hVar.b();
                i2 += 2;
                if (b2 > 0) {
                    byte[] bArr2 = new byte[b2];
                    hVar.read(bArr2);
                    if (ALog.isPrintLog(Level.D)) {
                        String str4 = this.m;
                        StringBuilder stringBuilder3 = new StringBuilder("buf len:");
                        stringBuilder3.append(bArr2.length);
                        ALog.d(str4, stringBuilder3.toString(), new Object[0]);
                    }
                    i2 += bArr2.length;
                    a(a, bArr2, str, i);
                } else {
                    throw new IOException("data format error");
                }
            }
        } catch (String str5) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append(str5.toString());
            com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", stringBuilder.toString());
            ALog.e(this.m, "", str5, new Object[0]);
        } finally {
            hVar.close();
        }
    }

    private void a(int r41, byte[] r42, java.lang.String r43, int r44) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r40 = this;
        r7 = r40;
        r1 = r41;
        r8 = r42;
        r14 = r43;
        r2 = new com.taobao.accs.utl.h;
        r2.<init>(r8);
        r3 = r2.b();
        r9 = (long) r3;
        r3 = com.taobao.accs.utl.ALog.Level.D;
        r3 = com.taobao.accs.utl.ALog.isPrintLog(r3);
        r15 = 0;
        if (r3 == 0) goto L_0x0035;
    L_0x001b:
        r3 = r7.m;
        r4 = new java.lang.StringBuilder;
        r5 = "flag:";
        r4.<init>(r5);
        r5 = (int) r9;
        r5 = java.lang.Integer.toHexString(r5);
        r4.append(r5);
        r4 = r4.toString();
        r5 = new java.lang.Object[r15];
        com.taobao.accs.utl.ALog.d(r3, r4, r5);
    L_0x0035:
        r3 = r2.a();
        r11 = r2.a(r3);
        r3 = com.taobao.accs.utl.ALog.Level.D;
        r3 = com.taobao.accs.utl.ALog.isPrintLog(r3);
        if (r3 == 0) goto L_0x005a;
    L_0x0045:
        r3 = r7.m;
        r4 = new java.lang.StringBuilder;
        r5 = "target:";
        r4.<init>(r5);
        r4.append(r11);
        r4 = r4.toString();
        r5 = new java.lang.Object[r15];
        com.taobao.accs.utl.ALog.d(r3, r4, r5);
    L_0x005a:
        r3 = r2.a();
        r12 = r2.a(r3);
        r3 = com.taobao.accs.utl.ALog.Level.D;
        r3 = com.taobao.accs.utl.ALog.isPrintLog(r3);
        if (r3 == 0) goto L_0x007f;
    L_0x006a:
        r3 = r7.m;
        r4 = new java.lang.StringBuilder;
        r5 = "source:";
        r4.<init>(r5);
        r4.append(r12);
        r4 = r4.toString();
        r5 = new java.lang.Object[r15];
        com.taobao.accs.utl.ALog.d(r3, r4, r5);
    L_0x007f:
        r3 = r2.a();	 Catch:{ Exception -> 0x0656 }
        r13 = r2.a(r3);	 Catch:{ Exception -> 0x0656 }
        r3 = com.taobao.accs.utl.ALog.Level.D;
        r3 = com.taobao.accs.utl.ALog.isPrintLog(r3);
        if (r3 == 0) goto L_0x00a4;
    L_0x008f:
        r3 = r7.m;
        r4 = new java.lang.StringBuilder;
        r5 = "dataId:";
        r4.<init>(r5);
        r4.append(r13);
        r4 = r4.toString();
        r5 = new java.lang.Object[r15];
        com.taobao.accs.utl.ALog.d(r3, r4, r5);
    L_0x00a4:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r12);
        r3.append(r13);
        r6 = r3.toString();
        r3 = r2.available();
        r16 = 0;
        r5 = 2;
        r4 = 1;
        if (r3 <= 0) goto L_0x016c;
    L_0x00bd:
        r3 = r44;
        if (r3 != r5) goto L_0x00c6;
    L_0x00c1:
        r3 = r7.a(r2);
        goto L_0x00c8;
    L_0x00c6:
        r3 = r16;
    L_0x00c8:
        if (r1 != 0) goto L_0x00d6;
    L_0x00ca:
        r1 = r2.c();
        r8 = r1;
        r15 = r3;
        r20 = r6;
        r21 = r12;
        goto L_0x0173;
    L_0x00d6:
        if (r1 != r4) goto L_0x0161;
    L_0x00d8:
        r1 = new java.util.zip.GZIPInputStream;
        r1.<init>(r2);
        r5 = new java.io.ByteArrayOutputStream;
        r5.<init>();
        r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r4 = new byte[r4];	 Catch:{ Exception -> 0x010c }
    L_0x00e6:
        r15 = r1.read(r4);	 Catch:{ Exception -> 0x010c }
        if (r15 <= 0) goto L_0x00f7;
    L_0x00ec:
        r19 = r3;
        r3 = 0;
        r5.write(r4, r3, r15);	 Catch:{ Exception -> 0x00f5 }
        r3 = r19;	 Catch:{ Exception -> 0x00f5 }
        goto L_0x00e6;	 Catch:{ Exception -> 0x00f5 }
    L_0x00f5:
        r0 = move-exception;	 Catch:{ Exception -> 0x00f5 }
        goto L_0x010f;	 Catch:{ Exception -> 0x00f5 }
    L_0x00f7:
        r19 = r3;	 Catch:{ Exception -> 0x00f5 }
        r3 = r5.toByteArray();	 Catch:{ Exception -> 0x00f5 }
        r1.close();	 Catch:{ Exception -> 0x0103 }
        r5.close();	 Catch:{ Exception -> 0x0103 }
    L_0x0103:
        r8 = r3;
        r20 = r6;
        r21 = r12;
        goto L_0x0169;
    L_0x0109:
        r0 = move-exception;
        r2 = r0;
        goto L_0x015a;
    L_0x010c:
        r0 = move-exception;
        r19 = r3;
    L_0x010f:
        r3 = r0;
        r4 = r7.m;	 Catch:{ all -> 0x0109 }
        r15 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0109 }
        r20 = r6;	 Catch:{ all -> 0x0109 }
        r6 = "uncompress data error ";	 Catch:{ all -> 0x0109 }
        r15.<init>(r6);	 Catch:{ all -> 0x0109 }
        r6 = r3.toString();	 Catch:{ all -> 0x0109 }
        r15.append(r6);	 Catch:{ all -> 0x0109 }
        r6 = r15.toString();	 Catch:{ all -> 0x0109 }
        r21 = r12;	 Catch:{ all -> 0x0109 }
        r15 = 0;	 Catch:{ all -> 0x0109 }
        r12 = new java.lang.Object[r15];	 Catch:{ all -> 0x0109 }
        com.taobao.accs.utl.ALog.e(r4, r6, r12);	 Catch:{ all -> 0x0109 }
        r4 = "accs";	 Catch:{ all -> 0x0109 }
        r6 = "send_fail";	 Catch:{ all -> 0x0109 }
        r12 = "";	 Catch:{ all -> 0x0109 }
        r15 = "1";	 Catch:{ all -> 0x0109 }
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0109 }
        r14.<init>();	 Catch:{ all -> 0x0109 }
        r8 = r7.b;	 Catch:{ all -> 0x0109 }
        r14.append(r8);	 Catch:{ all -> 0x0109 }
        r8 = " uncompress data error ";	 Catch:{ all -> 0x0109 }
        r14.append(r8);	 Catch:{ all -> 0x0109 }
        r3 = r3.toString();	 Catch:{ all -> 0x0109 }
        r14.append(r3);	 Catch:{ all -> 0x0109 }
        r3 = r14.toString();	 Catch:{ all -> 0x0109 }
        com.taobao.accs.utl.b.a(r4, r6, r12, r15, r3);	 Catch:{ all -> 0x0109 }
        r1.close();	 Catch:{ Exception -> 0x0167 }
        r5.close();	 Catch:{ Exception -> 0x0167 }
        goto L_0x0167;
    L_0x015a:
        r1.close();	 Catch:{ Exception -> 0x0160 }
        r5.close();	 Catch:{ Exception -> 0x0160 }
    L_0x0160:
        throw r2;
    L_0x0161:
        r19 = r3;
        r20 = r6;
        r21 = r12;
    L_0x0167:
        r8 = r16;
    L_0x0169:
        r15 = r19;
        goto L_0x0173;
    L_0x016c:
        r20 = r6;
        r21 = r12;
        r8 = r16;
        r15 = r8;
    L_0x0173:
        r2.close();
        if (r8 != 0) goto L_0x018b;
    L_0x0178:
        r1 = r7.m;	 Catch:{ Exception -> 0x0186 }
        r2 = "oriData is null";	 Catch:{ Exception -> 0x0186 }
        r3 = 0;
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0183 }
        com.taobao.accs.utl.ALog.d(r1, r2, r4);	 Catch:{ Exception -> 0x0186 }
        goto L_0x01ad;
    L_0x0183:
        r0 = move-exception;
        goto L_0x0626;
    L_0x0186:
        r0 = move-exception;
        r1 = r0;
        r3 = 0;
        goto L_0x0627;
    L_0x018b:
        r1 = com.taobao.accs.utl.ALog.Level.D;	 Catch:{ Exception -> 0x0624 }
        r1 = com.taobao.accs.utl.ALog.isPrintLog(r1);	 Catch:{ Exception -> 0x0624 }
        if (r1 == 0) goto L_0x01ad;
    L_0x0193:
        r1 = r7.m;	 Catch:{ Exception -> 0x0186 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186 }
        r3 = "oriData:";	 Catch:{ Exception -> 0x0186 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0186 }
        r3 = java.lang.String.valueOf(r8);	 Catch:{ Exception -> 0x0186 }
        r2.append(r3);	 Catch:{ Exception -> 0x0186 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0186 }
        r3 = 0;
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0183 }
        com.taobao.accs.utl.ALog.d(r1, r2, r4);	 Catch:{ Exception -> 0x0186 }
    L_0x01ad:
        r1 = 15;
        r1 = r9 >> r1;
        r3 = 1;
        r5 = r1 & r3;
        r1 = (int) r5;
        r12 = com.taobao.accs.data.Message.b.a(r1);	 Catch:{ Exception -> 0x0624 }
        r1 = 13;	 Catch:{ Exception -> 0x0624 }
        r1 = r9 >> r1;	 Catch:{ Exception -> 0x0624 }
        r5 = 3;	 Catch:{ Exception -> 0x0624 }
        r3 = r1 & r5;	 Catch:{ Exception -> 0x0624 }
        r1 = (int) r3;	 Catch:{ Exception -> 0x0624 }
        r14 = com.taobao.accs.data.Message.ReqType.valueOf(r1);	 Catch:{ Exception -> 0x0624 }
        r1 = 12;	 Catch:{ Exception -> 0x0624 }
        r1 = r9 >> r1;	 Catch:{ Exception -> 0x0624 }
        r3 = 1;	 Catch:{ Exception -> 0x0624 }
        r5 = r1 & r3;	 Catch:{ Exception -> 0x0624 }
        r1 = (int) r5;	 Catch:{ Exception -> 0x0624 }
        r2 = 11;	 Catch:{ Exception -> 0x0624 }
        r5 = r9 >> r2;	 Catch:{ Exception -> 0x0624 }
        r26 = r1;	 Catch:{ Exception -> 0x0624 }
        r1 = r5 & r3;	 Catch:{ Exception -> 0x0624 }
        r1 = (int) r1;	 Catch:{ Exception -> 0x0624 }
        r6 = com.taobao.accs.data.Message.a.a(r1);	 Catch:{ Exception -> 0x0624 }
        r1 = 6;	 Catch:{ Exception -> 0x0624 }
        r24 = r9 >> r1;	 Catch:{ Exception -> 0x0624 }
        r27 = r9;	 Catch:{ Exception -> 0x0624 }
        r9 = r24 & r3;	 Catch:{ Exception -> 0x0624 }
        r2 = (int) r9;	 Catch:{ Exception -> 0x0624 }
        r3 = 1;	 Catch:{ Exception -> 0x0624 }
        if (r2 != r3) goto L_0x01ea;	 Catch:{ Exception -> 0x0624 }
    L_0x01e8:
        r10 = 1;	 Catch:{ Exception -> 0x0624 }
        goto L_0x01eb;	 Catch:{ Exception -> 0x0624 }
    L_0x01ea:
        r10 = 0;	 Catch:{ Exception -> 0x0624 }
    L_0x01eb:
        r2 = r7.m;	 Catch:{ Exception -> 0x0624 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0624 }
        r3.<init>();	 Catch:{ Exception -> 0x0624 }
        r4 = r7.b;	 Catch:{ Exception -> 0x0624 }
        r3.append(r4);	 Catch:{ Exception -> 0x0624 }
        r4 = " dataId";	 Catch:{ Exception -> 0x0624 }
        r3.append(r4);	 Catch:{ Exception -> 0x0624 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0624 }
        r4 = 9;	 Catch:{ Exception -> 0x0624 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0624 }
        r5 = 0;
        r4[r5] = r13;	 Catch:{ Exception -> 0x0621 }
        r5 = "type";	 Catch:{ Exception -> 0x0624 }
        r9 = 1;	 Catch:{ Exception -> 0x0624 }
        r4[r9] = r5;	 Catch:{ Exception -> 0x0624 }
        r5 = com.taobao.accs.data.Message.b.b(r12);	 Catch:{ Exception -> 0x0624 }
        r9 = 2;	 Catch:{ Exception -> 0x0624 }
        r4[r9] = r5;	 Catch:{ Exception -> 0x0624 }
        r5 = "reqType";	 Catch:{ Exception -> 0x0624 }
        r9 = 3;	 Catch:{ Exception -> 0x0624 }
        r4[r9] = r5;	 Catch:{ Exception -> 0x0624 }
        r5 = r14.name();	 Catch:{ Exception -> 0x0624 }
        r9 = 4;	 Catch:{ Exception -> 0x0624 }
        r4[r9] = r5;	 Catch:{ Exception -> 0x0624 }
        r5 = 5;	 Catch:{ Exception -> 0x0624 }
        r17 = "resType";	 Catch:{ Exception -> 0x0624 }
        r4[r5] = r17;	 Catch:{ Exception -> 0x0624 }
        r5 = com.taobao.accs.data.Message.a.b(r6);	 Catch:{ Exception -> 0x0624 }
        r4[r1] = r5;	 Catch:{ Exception -> 0x0624 }
        r1 = 7;	 Catch:{ Exception -> 0x0624 }
        r5 = "target";	 Catch:{ Exception -> 0x0624 }
        r4[r1] = r5;	 Catch:{ Exception -> 0x0624 }
        r1 = 8;	 Catch:{ Exception -> 0x0624 }
        r4[r1] = r11;	 Catch:{ Exception -> 0x0624 }
        com.taobao.accs.utl.ALog.i(r2, r3, r4);	 Catch:{ Exception -> 0x0624 }
        r1 = 1;
        if (r12 != r1) goto L_0x02ed;
    L_0x0239:
        r1 = com.taobao.accs.data.Message.ReqType.ACK;	 Catch:{ Exception -> 0x0186 }
        if (r14 == r1) goto L_0x0241;	 Catch:{ Exception -> 0x0186 }
    L_0x023d:
        r1 = com.taobao.accs.data.Message.ReqType.RES;	 Catch:{ Exception -> 0x0186 }
        if (r14 != r1) goto L_0x02ed;	 Catch:{ Exception -> 0x0186 }
    L_0x0241:
        r1 = r7.g;	 Catch:{ Exception -> 0x0186 }
        r1 = r1.remove(r13);	 Catch:{ Exception -> 0x0186 }
        r5 = r1;	 Catch:{ Exception -> 0x0186 }
        r5 = (com.taobao.accs.data.Message) r5;	 Catch:{ Exception -> 0x0186 }
        if (r5 == 0) goto L_0x02be;	 Catch:{ Exception -> 0x0186 }
    L_0x024c:
        r1 = r7.m;	 Catch:{ Exception -> 0x0186 }
        r2 = "reqMessage not null";	 Catch:{ Exception -> 0x0186 }
        r3 = 0;
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0183 }
        com.taobao.accs.utl.ALog.d(r1, r2, r4);	 Catch:{ Exception -> 0x0186 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2 = r26;
        r4 = 1;
        if (r2 != r4) goto L_0x026f;
    L_0x025d:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x026e }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x026e }
        r2.<init>(r8);	 Catch:{ Exception -> 0x026e }
        r1.<init>(r2);	 Catch:{ Exception -> 0x026e }
        r2 = "code";	 Catch:{ Exception -> 0x026e }
        r1 = r1.getInt(r2);	 Catch:{ Exception -> 0x026e }
        goto L_0x026f;
    L_0x026e:
        r1 = -3;
    L_0x026f:
        r3 = r1;
        r1 = r5.e();	 Catch:{ Exception -> 0x0186 }
        if (r1 == 0) goto L_0x027d;	 Catch:{ Exception -> 0x0186 }
    L_0x0276:
        r1 = r5.e();	 Catch:{ Exception -> 0x0186 }
        r1.onRecAck();	 Catch:{ Exception -> 0x0186 }
    L_0x027d:
        r1 = com.taobao.accs.data.Message.ReqType.RES;	 Catch:{ Exception -> 0x0186 }
        if (r14 != r1) goto L_0x0293;	 Catch:{ Exception -> 0x0186 }
    L_0x0281:
        r1 = r7;	 Catch:{ Exception -> 0x0186 }
        r2 = r5;	 Catch:{ Exception -> 0x0186 }
        r9 = r4;	 Catch:{ Exception -> 0x0186 }
        r4 = r14;	 Catch:{ Exception -> 0x0186 }
        r9 = r5;	 Catch:{ Exception -> 0x0186 }
        r29 = r10;	 Catch:{ Exception -> 0x0186 }
        r10 = 2;	 Catch:{ Exception -> 0x0186 }
        r5 = r8;	 Catch:{ Exception -> 0x0186 }
        r31 = r6;	 Catch:{ Exception -> 0x0186 }
        r30 = r20;	 Catch:{ Exception -> 0x0186 }
        r6 = r15;	 Catch:{ Exception -> 0x0186 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0186 }
        goto L_0x029e;	 Catch:{ Exception -> 0x0186 }
    L_0x0293:
        r9 = r5;	 Catch:{ Exception -> 0x0186 }
        r31 = r6;	 Catch:{ Exception -> 0x0186 }
        r29 = r10;	 Catch:{ Exception -> 0x0186 }
        r30 = r20;	 Catch:{ Exception -> 0x0186 }
        r10 = 2;	 Catch:{ Exception -> 0x0186 }
        r7.a(r9, r3, r15);	 Catch:{ Exception -> 0x0186 }
    L_0x029e:
        r5 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a;	 Catch:{ Exception -> 0x0186 }
        r2 = r9.F;	 Catch:{ Exception -> 0x0186 }
        r3 = anet.channel.GlobalAppRuntimeInfo.isAppBackground();	 Catch:{ Exception -> 0x0186 }
        r9 = r42;	 Catch:{ Exception -> 0x0186 }
        r1 = r9.length;	 Catch:{ Exception -> 0x0186 }
        r32 = r11;	 Catch:{ Exception -> 0x0186 }
        r10 = (long) r1;	 Catch:{ Exception -> 0x0186 }
        r1 = r5;	 Catch:{ Exception -> 0x0186 }
        r6 = r43;	 Catch:{ Exception -> 0x0186 }
        r4 = r6;	 Catch:{ Exception -> 0x0186 }
        r34 = r8;	 Catch:{ Exception -> 0x0186 }
        r33 = r15;	 Catch:{ Exception -> 0x0186 }
        r8 = r5;	 Catch:{ Exception -> 0x0186 }
        r15 = r6;	 Catch:{ Exception -> 0x0186 }
        r5 = r10;	 Catch:{ Exception -> 0x0186 }
        r1.<init>(r2, r3, r4, r5);	 Catch:{ Exception -> 0x0186 }
        r7.a(r8);	 Catch:{ Exception -> 0x0186 }
        goto L_0x02fd;	 Catch:{ Exception -> 0x0186 }
    L_0x02be:
        r31 = r6;	 Catch:{ Exception -> 0x0186 }
        r34 = r8;	 Catch:{ Exception -> 0x0186 }
        r29 = r10;	 Catch:{ Exception -> 0x0186 }
        r32 = r11;	 Catch:{ Exception -> 0x0186 }
        r33 = r15;	 Catch:{ Exception -> 0x0186 }
        r30 = r20;	 Catch:{ Exception -> 0x0186 }
        r9 = r42;	 Catch:{ Exception -> 0x0186 }
        r15 = r43;	 Catch:{ Exception -> 0x0186 }
        r1 = r7.m;	 Catch:{ Exception -> 0x0186 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186 }
        r2.<init>();	 Catch:{ Exception -> 0x0186 }
        r3 = r7.b;	 Catch:{ Exception -> 0x0186 }
        r2.append(r3);	 Catch:{ Exception -> 0x0186 }
        r3 = " data ack/res reqMessage is null,";	 Catch:{ Exception -> 0x0186 }
        r2.append(r3);	 Catch:{ Exception -> 0x0186 }
        r2.append(r13);	 Catch:{ Exception -> 0x0186 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0186 }
        r3 = 0;
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0183 }
        com.taobao.accs.utl.ALog.e(r1, r2, r4);	 Catch:{ Exception -> 0x0186 }
        goto L_0x02fd;	 Catch:{ Exception -> 0x0186 }
    L_0x02ed:
        r31 = r6;	 Catch:{ Exception -> 0x0186 }
        r34 = r8;	 Catch:{ Exception -> 0x0186 }
        r29 = r10;	 Catch:{ Exception -> 0x0186 }
        r32 = r11;	 Catch:{ Exception -> 0x0186 }
        r33 = r15;	 Catch:{ Exception -> 0x0186 }
        r30 = r20;	 Catch:{ Exception -> 0x0186 }
        r9 = r42;	 Catch:{ Exception -> 0x0186 }
        r15 = r43;	 Catch:{ Exception -> 0x0186 }
    L_0x02fd:
        if (r12 != 0) goto L_0x035c;	 Catch:{ Exception -> 0x0186 }
    L_0x02ff:
        r1 = com.taobao.accs.data.Message.ReqType.RES;	 Catch:{ Exception -> 0x0186 }
        if (r14 != r1) goto L_0x035c;	 Catch:{ Exception -> 0x0186 }
    L_0x0303:
        r1 = r7.g;	 Catch:{ Exception -> 0x0186 }
        r1 = r1.remove(r13);	 Catch:{ Exception -> 0x0186 }
        r1 = (com.taobao.accs.data.Message) r1;	 Catch:{ Exception -> 0x0186 }
        if (r1 == 0) goto L_0x0313;	 Catch:{ Exception -> 0x0186 }
    L_0x030d:
        r3 = r34;	 Catch:{ Exception -> 0x0186 }
        r7.a(r1, r3, r9, r15);	 Catch:{ Exception -> 0x0186 }
        return;	 Catch:{ Exception -> 0x0186 }
    L_0x0313:
        r3 = r34;	 Catch:{ Exception -> 0x0186 }
        r1 = r7.m;	 Catch:{ Exception -> 0x0186 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186 }
        r2.<init>();	 Catch:{ Exception -> 0x0186 }
        r4 = r7.b;	 Catch:{ Exception -> 0x0186 }
        r2.append(r4);	 Catch:{ Exception -> 0x0186 }
        r4 = " contorl ACK reqMessage is null";	 Catch:{ Exception -> 0x0186 }
        r2.append(r4);	 Catch:{ Exception -> 0x0186 }
        r2.append(r13);	 Catch:{ Exception -> 0x0186 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0186 }
        r4 = 0;
        r5 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0357 }
        com.taobao.accs.utl.ALog.e(r1, r2, r5);	 Catch:{ Exception -> 0x0186 }
        r1 = com.taobao.accs.utl.ALog.Level.D;	 Catch:{ Exception -> 0x0186 }
        r1 = com.taobao.accs.utl.ALog.isPrintLog(r1);	 Catch:{ Exception -> 0x0186 }
        if (r1 == 0) goto L_0x035e;	 Catch:{ Exception -> 0x0186 }
    L_0x033b:
        r1 = r7.m;	 Catch:{ Exception -> 0x0186 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186 }
        r4 = "Message not handled, body:";	 Catch:{ Exception -> 0x0186 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0186 }
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0186 }
        r4.<init>(r3);	 Catch:{ Exception -> 0x0186 }
        r2.append(r4);	 Catch:{ Exception -> 0x0186 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0186 }
        r4 = 0;
        r5 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0357 }
        com.taobao.accs.utl.ALog.d(r1, r2, r5);	 Catch:{ Exception -> 0x0186 }
        goto L_0x035e;
    L_0x0357:
        r0 = move-exception;
        r1 = r0;
        r3 = r4;
        goto L_0x0627;
    L_0x035c:
        r3 = r34;
    L_0x035e:
        r1 = 1;
        if (r12 != r1) goto L_0x0620;
    L_0x0361:
        r1 = com.taobao.accs.data.Message.ReqType.DATA;	 Catch:{ Exception -> 0x0624 }
        if (r14 != r1) goto L_0x0620;	 Catch:{ Exception -> 0x0624 }
    L_0x0365:
        if (r32 != 0) goto L_0x0368;	 Catch:{ Exception -> 0x0624 }
    L_0x0367:
        return;	 Catch:{ Exception -> 0x0624 }
    L_0x0368:
        r1 = "\\|";	 Catch:{ Exception -> 0x0624 }
        r10 = r32;	 Catch:{ Exception -> 0x0624 }
        r1 = r10.split(r1);	 Catch:{ Exception -> 0x0624 }
        if (r1 == 0) goto L_0x061f;	 Catch:{ Exception -> 0x0624 }
    L_0x0372:
        r2 = r1.length;	 Catch:{ Exception -> 0x0624 }
        r4 = 2;	 Catch:{ Exception -> 0x0624 }
        if (r2 >= r4) goto L_0x0378;	 Catch:{ Exception -> 0x0624 }
    L_0x0376:
        goto L_0x061f;	 Catch:{ Exception -> 0x0624 }
    L_0x0378:
        r2 = r7.m;	 Catch:{ Exception -> 0x0624 }
        r4 = "onPush";	 Catch:{ Exception -> 0x0624 }
        r5 = 0;
        r6 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0621 }
        com.taobao.accs.utl.ALog.d(r2, r4, r6);	 Catch:{ Exception -> 0x0624 }
        r2 = r7.j;	 Catch:{ Exception -> 0x0624 }
        if (r2 == 0) goto L_0x038b;
    L_0x0386:
        r2 = r7.j;	 Catch:{ Exception -> 0x0186 }
        r2.commitUT();	 Catch:{ Exception -> 0x0186 }
    L_0x038b:
        r2 = new com.taobao.accs.ut.statistics.d;	 Catch:{ Exception -> 0x0624 }
        r2.<init>();	 Catch:{ Exception -> 0x0624 }
        r7.j = r2;	 Catch:{ Exception -> 0x0624 }
        r2 = r7.j;	 Catch:{ Exception -> 0x0624 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0624 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x0624 }
        r2.c = r4;	 Catch:{ Exception -> 0x0624 }
        r2 = r7.i;	 Catch:{ Exception -> 0x0624 }
        r4 = 1;	 Catch:{ Exception -> 0x0624 }
        r5 = r1[r4];	 Catch:{ Exception -> 0x0624 }
        r2 = com.taobao.accs.utl.UtilityImpl.packageExist(r2, r5);	 Catch:{ Exception -> 0x0624 }
        if (r2 == 0) goto L_0x05f3;	 Catch:{ Exception -> 0x0624 }
    L_0x03a9:
        r2 = r1.length;	 Catch:{ Exception -> 0x0624 }
        r4 = 3;
        if (r2 < r4) goto L_0x03b2;
    L_0x03ad:
        r2 = 2;
        r4 = r1[r2];	 Catch:{ Exception -> 0x0186 }
        r14 = r4;
        goto L_0x03b4;
    L_0x03b2:
        r14 = r16;
    L_0x03b4:
        r2 = r7.j;	 Catch:{ Exception -> 0x0624 }
        r2.e = r14;	 Catch:{ Exception -> 0x0624 }
        r2 = r30;	 Catch:{ Exception -> 0x0624 }
        r4 = r7.c(r2);	 Catch:{ Exception -> 0x0624 }
        if (r4 == 0) goto L_0x03f4;
    L_0x03c0:
        r1 = r7.m;	 Catch:{ Exception -> 0x0186 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186 }
        r2.<init>();	 Catch:{ Exception -> 0x0186 }
        r3 = r7.b;	 Catch:{ Exception -> 0x0186 }
        r2.append(r3);	 Catch:{ Exception -> 0x0186 }
        r3 = " msg duplicate";	 Catch:{ Exception -> 0x0186 }
        r2.append(r3);	 Catch:{ Exception -> 0x0186 }
        r2.append(r13);	 Catch:{ Exception -> 0x0186 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0186 }
        r3 = 0;
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0183 }
        com.taobao.accs.utl.ALog.e(r1, r2, r4);	 Catch:{ Exception -> 0x0186 }
        r1 = r7.j;	 Catch:{ Exception -> 0x0186 }
        r2 = 1;	 Catch:{ Exception -> 0x0186 }
        r1.h = r2;	 Catch:{ Exception -> 0x0186 }
        r37 = r10;
        r16 = r21;
        r38 = r27;
        r8 = r29;
        r1 = r31;
        r19 = r33;
        r2 = 1;
        r10 = 0;
        goto L_0x0577;
    L_0x03f4:
        r7.d(r2);	 Catch:{ Exception -> 0x0624 }
        r2 = "accs";	 Catch:{ Exception -> 0x0624 }
        r2 = r2.equals(r14);	 Catch:{ Exception -> 0x0624 }
        if (r2 == 0) goto L_0x0436;
    L_0x03ff:
        r2 = r7.m;	 Catch:{ Exception -> 0x0186 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186 }
        r4.<init>();	 Catch:{ Exception -> 0x0186 }
        r5 = r7.b;	 Catch:{ Exception -> 0x0186 }
        r4.append(r5);	 Catch:{ Exception -> 0x0186 }
        r5 = " try deliver msg to ";	 Catch:{ Exception -> 0x0186 }
        r4.append(r5);	 Catch:{ Exception -> 0x0186 }
        r5 = 1;	 Catch:{ Exception -> 0x0186 }
        r6 = r1[r5];	 Catch:{ Exception -> 0x0186 }
        r4.append(r6);	 Catch:{ Exception -> 0x0186 }
        r5 = "/";	 Catch:{ Exception -> 0x0186 }
        r4.append(r5);	 Catch:{ Exception -> 0x0186 }
        r4.append(r14);	 Catch:{ Exception -> 0x0186 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0186 }
        r5 = 2;	 Catch:{ Exception -> 0x0186 }
        r6 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0186 }
        r5 = "dataId";	 Catch:{ Exception -> 0x0186 }
        r8 = 0;
        r6[r8] = r5;	 Catch:{ Exception -> 0x0431 }
        r5 = 1;
        r6[r5] = r13;	 Catch:{ Exception -> 0x0186 }
        com.taobao.accs.utl.ALog.e(r2, r4, r6);	 Catch:{ Exception -> 0x0186 }
        goto L_0x045f;
    L_0x0431:
        r0 = move-exception;
        r1 = r0;
        r3 = r8;
        goto L_0x0627;
    L_0x0436:
        r2 = r7.m;	 Catch:{ Exception -> 0x0624 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0624 }
        r4.<init>();	 Catch:{ Exception -> 0x0624 }
        r5 = r7.b;	 Catch:{ Exception -> 0x0624 }
        r4.append(r5);	 Catch:{ Exception -> 0x0624 }
        r5 = " try deliver msg to ";	 Catch:{ Exception -> 0x0624 }
        r4.append(r5);	 Catch:{ Exception -> 0x0624 }
        r5 = 1;	 Catch:{ Exception -> 0x0624 }
        r6 = r1[r5];	 Catch:{ Exception -> 0x0624 }
        r4.append(r6);	 Catch:{ Exception -> 0x0624 }
        r5 = "/";	 Catch:{ Exception -> 0x0624 }
        r4.append(r5);	 Catch:{ Exception -> 0x0624 }
        r4.append(r14);	 Catch:{ Exception -> 0x0624 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0624 }
        r5 = 0;
        r6 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0621 }
        com.taobao.accs.utl.ALog.i(r2, r4, r6);	 Catch:{ Exception -> 0x0624 }
    L_0x045f:
        r2 = new android.content.Intent;	 Catch:{ Exception -> 0x0624 }
        r4 = "com.taobao.accs.intent.action.RECEIVE";	 Catch:{ Exception -> 0x0624 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0624 }
        r4 = 1;	 Catch:{ Exception -> 0x0624 }
        r5 = r1[r4];	 Catch:{ Exception -> 0x0624 }
        r2.setPackage(r5);	 Catch:{ Exception -> 0x0624 }
        r4 = "command";	 Catch:{ Exception -> 0x0624 }
        r5 = 101; // 0x65 float:1.42E-43 double:5.0E-322;	 Catch:{ Exception -> 0x0624 }
        r2.putExtra(r4, r5);	 Catch:{ Exception -> 0x0624 }
        r4 = r1.length;	 Catch:{ Exception -> 0x0624 }
        r5 = 3;
        if (r4 < r5) goto L_0x047f;
    L_0x0477:
        r4 = "serviceId";	 Catch:{ Exception -> 0x0186 }
        r5 = 2;	 Catch:{ Exception -> 0x0186 }
        r5 = r1[r5];	 Catch:{ Exception -> 0x0186 }
        r2.putExtra(r4, r5);	 Catch:{ Exception -> 0x0186 }
    L_0x047f:
        r4 = "";	 Catch:{ Exception -> 0x0624 }
        r5 = r1.length;	 Catch:{ Exception -> 0x0624 }
        r6 = 4;
        if (r5 < r6) goto L_0x048d;
    L_0x0485:
        r5 = 3;
        r4 = r1[r5];	 Catch:{ Exception -> 0x0186 }
        r1 = "userInfo";	 Catch:{ Exception -> 0x0186 }
        r2.putExtra(r1, r4);	 Catch:{ Exception -> 0x0186 }
    L_0x048d:
        r1 = "data";	 Catch:{ Exception -> 0x0624 }
        r2.putExtra(r1, r3);	 Catch:{ Exception -> 0x0624 }
        r1 = "dataId";	 Catch:{ Exception -> 0x0624 }
        r2.putExtra(r1, r13);	 Catch:{ Exception -> 0x0624 }
        r1 = "packageName";	 Catch:{ Exception -> 0x0624 }
        r5 = r7.i;	 Catch:{ Exception -> 0x0624 }
        r5 = r5.getPackageName();	 Catch:{ Exception -> 0x0624 }
        r2.putExtra(r1, r5);	 Catch:{ Exception -> 0x0624 }
        r1 = "host";	 Catch:{ Exception -> 0x0624 }
        r2.putExtra(r1, r15);	 Catch:{ Exception -> 0x0624 }
        r1 = "conn_type";	 Catch:{ Exception -> 0x0624 }
        r5 = r7.b;	 Catch:{ Exception -> 0x0624 }
        r2.putExtra(r1, r5);	 Catch:{ Exception -> 0x0624 }
        r1 = "bizAck";	 Catch:{ Exception -> 0x0624 }
        r8 = r29;	 Catch:{ Exception -> 0x0624 }
        r2.putExtra(r1, r8);	 Catch:{ Exception -> 0x0624 }
        r1 = "appKey";	 Catch:{ Exception -> 0x0624 }
        r5 = r7.l;	 Catch:{ Exception -> 0x0624 }
        r5 = r5.i();	 Catch:{ Exception -> 0x0624 }
        r2.putExtra(r1, r5);	 Catch:{ Exception -> 0x0624 }
        r1 = "configTag";	 Catch:{ Exception -> 0x0624 }
        r5 = r7.l;	 Catch:{ Exception -> 0x0624 }
        r5 = r5.m;	 Catch:{ Exception -> 0x0624 }
        r2.putExtra(r1, r5);	 Catch:{ Exception -> 0x0624 }
        r5 = r33;	 Catch:{ Exception -> 0x0624 }
        r7.a(r5, r2);	 Catch:{ Exception -> 0x0624 }
        if (r8 == 0) goto L_0x04da;
    L_0x04d0:
        r11 = r27;
        r1 = (int) r11;
        r1 = (short) r1;
        r6 = r21;
        r7.a(r2, r6, r10, r1);	 Catch:{ Exception -> 0x0186 }
        goto L_0x04de;
    L_0x04da:
        r6 = r21;
        r11 = r27;
    L_0x04de:
        r1 = r7.i;	 Catch:{ Exception -> 0x0624 }
        com.taobao.accs.data.d.a(r1, r2);	 Catch:{ Exception -> 0x0624 }
        r19 = com.taobao.accs.utl.UTMini.getInstance();	 Catch:{ Exception -> 0x0624 }
        r20 = 66001; // 0x101d1 float:9.2487E-41 double:3.2609E-319;	 Catch:{ Exception -> 0x0624 }
        r21 = "MsgToBussPush";	 Catch:{ Exception -> 0x0624 }
        r22 = "commandId=101";	 Catch:{ Exception -> 0x0624 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0624 }
        r2 = "serviceId=";	 Catch:{ Exception -> 0x0624 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0624 }
        r1.append(r14);	 Catch:{ Exception -> 0x0624 }
        r2 = " dataId=";	 Catch:{ Exception -> 0x0624 }
        r1.append(r2);	 Catch:{ Exception -> 0x0624 }
        r1.append(r13);	 Catch:{ Exception -> 0x0624 }
        r23 = r1.toString();	 Catch:{ Exception -> 0x0624 }
        r1 = 221; // 0xdd float:3.1E-43 double:1.09E-321;	 Catch:{ Exception -> 0x0624 }
        r24 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0624 }
        r19.commitEvent(r20, r21, r22, r23, r24);	 Catch:{ Exception -> 0x0624 }
        r1 = "accs";	 Catch:{ Exception -> 0x0624 }
        r2 = "to_buss";	 Catch:{ Exception -> 0x0624 }
        r35 = r5;	 Catch:{ Exception -> 0x0624 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0624 }
        r36 = r6;	 Catch:{ Exception -> 0x0624 }
        r6 = "1commandId=101serviceId=";	 Catch:{ Exception -> 0x0624 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0624 }
        r5.append(r14);	 Catch:{ Exception -> 0x0624 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0624 }
        r37 = r10;	 Catch:{ Exception -> 0x0624 }
        r38 = r11;	 Catch:{ Exception -> 0x0624 }
        r10 = 0;	 Catch:{ Exception -> 0x0624 }
        com.taobao.accs.utl.b.a(r1, r2, r5, r10);	 Catch:{ Exception -> 0x0624 }
        r1 = r7.j;	 Catch:{ Exception -> 0x0624 }
        r1.b = r13;	 Catch:{ Exception -> 0x0624 }
        r1 = r7.j;	 Catch:{ Exception -> 0x0624 }
        r1.i = r4;	 Catch:{ Exception -> 0x0624 }
        r1 = r7.j;	 Catch:{ Exception -> 0x0624 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0624 }
        r2.<init>();	 Catch:{ Exception -> 0x0624 }
        if (r3 != 0) goto L_0x053f;	 Catch:{ Exception -> 0x0624 }
    L_0x053d:
        r3 = 0;	 Catch:{ Exception -> 0x0624 }
        goto L_0x0540;	 Catch:{ Exception -> 0x0624 }
    L_0x053f:
        r3 = r3.length;	 Catch:{ Exception -> 0x0624 }
    L_0x0540:
        r2.append(r3);	 Catch:{ Exception -> 0x0624 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0624 }
        r1.f = r2;	 Catch:{ Exception -> 0x0624 }
        r1 = r7.j;	 Catch:{ Exception -> 0x0624 }
        r2 = r7.i;	 Catch:{ Exception -> 0x0624 }
        r2 = com.taobao.accs.utl.UtilityImpl.getDeviceId(r2);	 Catch:{ Exception -> 0x0624 }
        r1.a = r2;	 Catch:{ Exception -> 0x0624 }
        r1 = r7.j;	 Catch:{ Exception -> 0x0624 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0624 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x0624 }
        r1.d = r2;	 Catch:{ Exception -> 0x0624 }
        r12 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a;	 Catch:{ Exception -> 0x0624 }
        r3 = anet.channel.GlobalAppRuntimeInfo.isAppBackground();	 Catch:{ Exception -> 0x0624 }
        r1 = r9.length;	 Catch:{ Exception -> 0x0624 }
        r5 = (long) r1;	 Catch:{ Exception -> 0x0624 }
        r1 = r12;	 Catch:{ Exception -> 0x0624 }
        r2 = r14;	 Catch:{ Exception -> 0x0624 }
        r4 = r15;	 Catch:{ Exception -> 0x0624 }
        r19 = r35;	 Catch:{ Exception -> 0x0624 }
        r16 = r36;	 Catch:{ Exception -> 0x0624 }
        r1.<init>(r2, r3, r4, r5);	 Catch:{ Exception -> 0x0624 }
        r7.a(r12);	 Catch:{ Exception -> 0x0624 }
        r1 = r31;	 Catch:{ Exception -> 0x0624 }
        r2 = 1;	 Catch:{ Exception -> 0x0624 }
    L_0x0577:
        if (r1 != r2) goto L_0x05f2;	 Catch:{ Exception -> 0x0624 }
    L_0x0579:
        r1 = "accs";	 Catch:{ Exception -> 0x0624 }
        r1 = r1.equals(r14);	 Catch:{ Exception -> 0x0624 }
        if (r1 == 0) goto L_0x05a1;
    L_0x0581:
        r1 = r7.m;	 Catch:{ Exception -> 0x0186 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186 }
        r3.<init>();	 Catch:{ Exception -> 0x0186 }
        r4 = r7.b;	 Catch:{ Exception -> 0x0186 }
        r3.append(r4);	 Catch:{ Exception -> 0x0186 }
        r4 = " try to send ack dataId ";	 Catch:{ Exception -> 0x0186 }
        r3.append(r4);	 Catch:{ Exception -> 0x0186 }
        r3.append(r13);	 Catch:{ Exception -> 0x0186 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0186 }
        r4 = 0;
        r5 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0357 }
        com.taobao.accs.utl.ALog.e(r1, r3, r5);	 Catch:{ Exception -> 0x0186 }
        r4 = 0;
        goto L_0x05bf;
    L_0x05a1:
        r1 = r7.m;	 Catch:{ Exception -> 0x0624 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0624 }
        r3.<init>();	 Catch:{ Exception -> 0x0624 }
        r4 = r7.b;	 Catch:{ Exception -> 0x0624 }
        r3.append(r4);	 Catch:{ Exception -> 0x0624 }
        r4 = " try to send ack dataId ";	 Catch:{ Exception -> 0x0624 }
        r3.append(r4);	 Catch:{ Exception -> 0x0624 }
        r3.append(r13);	 Catch:{ Exception -> 0x0624 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0624 }
        r4 = 0;
        r5 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x05ef }
        com.taobao.accs.utl.ALog.i(r1, r3, r5);	 Catch:{ Exception -> 0x05ef }
    L_0x05bf:
        r1 = r7.l;	 Catch:{ Exception -> 0x05ef }
        r12 = 0;
        r5 = r38;
        r3 = (int) r5;
        r3 = (short) r3;
        r18 = r8;
        r8 = r1;
        r9 = r37;
        r5 = r10;
        r10 = r16;
        r11 = r13;
        r13 = r3;
        r1 = r14;
        r14 = r15;
        r3 = r4;
        r15 = r19;
        r4 = com.taobao.accs.data.Message.a(r8, r9, r10, r11, r12, r13, r14, r15);	 Catch:{ Exception -> 0x0183 }
        r8 = r7.l;	 Catch:{ Exception -> 0x0183 }
        r8.b(r4, r2);	 Catch:{ Exception -> 0x0183 }
        r2 = r4.q;	 Catch:{ Exception -> 0x0183 }
        r7.a(r2, r1);	 Catch:{ Exception -> 0x0183 }
        if (r18 == 0) goto L_0x05f2;	 Catch:{ Exception -> 0x0183 }
    L_0x05e5:
        r1 = "accs";	 Catch:{ Exception -> 0x0183 }
        r2 = "ack";	 Catch:{ Exception -> 0x0183 }
        r4 = "";	 Catch:{ Exception -> 0x0183 }
        com.taobao.accs.utl.b.a(r1, r2, r4, r5);	 Catch:{ Exception -> 0x0183 }
        goto L_0x05f2;	 Catch:{ Exception -> 0x0183 }
    L_0x05ef:
        r0 = move-exception;	 Catch:{ Exception -> 0x0183 }
        r3 = r4;	 Catch:{ Exception -> 0x0183 }
        goto L_0x0626;	 Catch:{ Exception -> 0x0183 }
    L_0x05f2:
        return;	 Catch:{ Exception -> 0x0183 }
    L_0x05f3:
        r2 = 1;	 Catch:{ Exception -> 0x0183 }
        r3 = 0;	 Catch:{ Exception -> 0x0183 }
        r4 = r7.m;	 Catch:{ Exception -> 0x0183 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0183 }
        r6 = "package ";	 Catch:{ Exception -> 0x0183 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0183 }
        r6 = r1[r2];	 Catch:{ Exception -> 0x0183 }
        r5.append(r6);	 Catch:{ Exception -> 0x0183 }
        r6 = " not exist, unbind it";	 Catch:{ Exception -> 0x0183 }
        r5.append(r6);	 Catch:{ Exception -> 0x0183 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0183 }
        r6 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0183 }
        com.taobao.accs.utl.ALog.e(r4, r5, r6);	 Catch:{ Exception -> 0x0183 }
        r4 = r7.l;	 Catch:{ Exception -> 0x0183 }
        r5 = r7.l;	 Catch:{ Exception -> 0x0183 }
        r1 = r1[r2];	 Catch:{ Exception -> 0x0183 }
        r1 = com.taobao.accs.data.Message.a(r5, r1);	 Catch:{ Exception -> 0x0183 }
        r4.b(r1, r2);	 Catch:{ Exception -> 0x0183 }
        goto L_0x0620;
    L_0x061f:
        return;
    L_0x0620:
        return;
    L_0x0621:
        r0 = move-exception;
        r3 = r5;
        goto L_0x0626;
    L_0x0624:
        r0 = move-exception;
        r3 = 0;
    L_0x0626:
        r1 = r0;
    L_0x0627:
        r2 = r7.m;
        r4 = r1.toString();
        r3 = new java.lang.Object[r3];
        com.taobao.accs.utl.ALog.e(r2, r4, r3);
        r2 = "accs";
        r3 = "send_fail";
        r4 = "";
        r5 = "1";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r8 = r7.b;
        r6.append(r8);
        r8 = r1.toString();
        r6.append(r8);
        r6 = r6.toString();
        com.taobao.accs.utl.b.a(r2, r3, r4, r5, r6);
        r1.printStackTrace();
        return;
    L_0x0656:
        r0 = move-exception;
        r3 = r15;
        r1 = r0;
        r4 = r7.m;
        r5 = new java.lang.StringBuilder;
        r6 = "dataId read error ";
        r5.<init>(r6);
        r6 = r1.toString();
        r5.append(r6);
        r5 = r5.toString();
        r3 = new java.lang.Object[r3];
        com.taobao.accs.utl.ALog.e(r4, r5, r3);
        r2.close();
        r2 = "accs";
        r3 = "send_fail";
        r4 = "";
        r5 = "1";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r8 = r7.b;
        r6.append(r8);
        r8 = "data id read error";
        r6.append(r8);
        r1 = r1.toString();
        r6.append(r1);
        r1 = r6.toString();
        com.taobao.accs.utl.b.a(r2, r3, r4, r5, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.a.a(int, byte[], java.lang.String, int):void");
    }

    private void a(Message message, byte[] bArr, byte[] bArr2, String str) {
        byte[] bArr3;
        int i;
        Throwable th;
        Throwable th2;
        StringBuilder stringBuilder;
        a aVar = this;
        Message message2 = message;
        try {
            bArr3 = bArr;
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr3));
                if (ALog.isPrintLog(Level.D)) {
                    String str2 = aVar.m;
                    StringBuilder stringBuilder2 = new StringBuilder("parse Json:");
                    stringBuilder2.append(jSONObject.toString());
                    ALog.d(str2, stringBuilder2.toString(), new Object[0]);
                }
                i = jSONObject.getInt("code");
                if (i == 200) {
                    try {
                        switch (message2.t.intValue()) {
                            case 1:
                                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                aVar.f = e.a(jSONObject2, Constants.KEY_DEVICE_TOKEN, null);
                                UtilityImpl.saveUtdid(Constants.SP_FILE_NAME, aVar.i);
                                if (jSONObject2 != null) {
                                    JSONArray jSONArray = jSONObject2.getJSONArray(Constants.KEY_PACKAGE_NAMES);
                                    if (jSONArray != null) {
                                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                            String string = jSONArray.getString(i2);
                                            if (UtilityImpl.packageExist(aVar.i, string)) {
                                                aVar.l.j().a(message2.s);
                                            } else {
                                                ALog.e(aVar.m, "unbind app", Constants.KEY_ELECTION_PKG, string);
                                                aVar.l.b(Message.a(aVar.l, string), true);
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                aVar.l.j().b(message2.s);
                                break;
                            case 3:
                                aVar.l.j().a(message2.s, message2.E);
                                break;
                            case 4:
                                aVar.l.j().e(message2.s);
                                break;
                            default:
                                break;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                        ALog.e(aVar.m, "handleControlMessage", th2, new Object[0]);
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(aVar.b);
                        stringBuilder.append(th2.toString());
                        com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", stringBuilder.toString());
                        a(message2, i, null, bArr3, null);
                        a(new com.taobao.accs.ut.monitor.TrafficsMonitor.a(message2.F, GlobalAppRuntimeInfo.isAppBackground(), str, (long) bArr2.length));
                    }
                } else if (message2.t.intValue() == 3 && i == 300) {
                    aVar.l.j().b(message2.s);
                }
            } catch (Throwable th4) {
                th = th4;
                i = -8;
                th2 = th;
                ALog.e(aVar.m, "handleControlMessage", th2, new Object[0]);
                stringBuilder = new StringBuilder();
                stringBuilder.append(aVar.b);
                stringBuilder.append(th2.toString());
                com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", stringBuilder.toString());
                a(message2, i, null, bArr3, null);
                a(new com.taobao.accs.ut.monitor.TrafficsMonitor.a(message2.F, GlobalAppRuntimeInfo.isAppBackground(), str, (long) bArr2.length));
            }
        } catch (Throwable th5) {
            th = th5;
            bArr3 = bArr;
            i = -8;
            th2 = th;
            ALog.e(aVar.m, "handleControlMessage", th2, new Object[0]);
            stringBuilder = new StringBuilder();
            stringBuilder.append(aVar.b);
            stringBuilder.append(th2.toString());
            com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", stringBuilder.toString());
            a(message2, i, null, bArr3, null);
            a(new com.taobao.accs.ut.monitor.TrafficsMonitor.a(message2.F, GlobalAppRuntimeInfo.isAppBackground(), str, (long) bArr2.length));
        }
        a(message2, i, null, bArr3, null);
        a(new com.taobao.accs.ut.monitor.TrafficsMonitor.a(message2.F, GlobalAppRuntimeInfo.isAppBackground(), str, (long) bArr2.length));
    }

    private Map<Integer, String> a(h hVar) {
        Map<Integer, String> map;
        if (hVar == null) {
            return null;
        }
        try {
            int b = hVar.b();
            if (ALog.isPrintLog(Level.D)) {
                String str = this.m;
                StringBuilder stringBuilder = new StringBuilder("extHeaderLen:");
                stringBuilder.append(b);
                ALog.d(str, stringBuilder.toString(), new Object[0]);
            }
            map = null;
            int i = 0;
            while (i < b) {
                try {
                    int b2 = hVar.b();
                    i += 2;
                    int i2 = (64512 & b2) >> 10;
                    b2 &= Message.EXT_HEADER_VALUE_MAX_LEN;
                    String a = hVar.a(b2);
                    i += b2;
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(Integer.valueOf(i2), a);
                    if (ALog.isPrintLog(Level.D)) {
                        ALog.d(this.m, "", "extHeaderType", Integer.valueOf(i2), RequestHeaders.COLUMN_VALUE, a);
                    }
                } catch (Exception e) {
                    hVar = e;
                }
            }
        } catch (Exception e2) {
            hVar = e2;
            map = null;
            ALog.e(this.m, "parseExtHeader", hVar, new Object[0]);
            return map;
        }
        return map;
    }

    public void a(Message message, int i) {
        a(message, i, null, null, null);
    }

    public void a(Message message, int i, Map<Integer, String> map) {
        a(message, i, null, null, map);
    }

    public void a(Message message, int i, ReqType reqType, byte[] bArr, Map<Integer, String> map) {
        a aVar = this;
        Message message2 = message;
        if (message2.t != null && message.a() >= 0) {
            if (message.a() != 2) {
                int i2;
                Map map2;
                Map map3;
                int i3;
                byte[] bArr2;
                String str;
                StringBuilder stringBuilder;
                if (message2.M != null) {
                    aVar.a.remove(message2.M);
                }
                Map map4 = map;
                String str2 = null;
                if (aVar.e.checkAntiBrush(message2.f, map4)) {
                    i2 = ErrorCode.SERVIER_ANTI_BRUSH;
                    map4 = null;
                    map2 = map4;
                    map3 = map2;
                } else {
                    i2 = i;
                    map3 = reqType;
                    map2 = bArr;
                }
                int a = aVar.d.a(map4, message2.F);
                if (a != 0) {
                    i2 = a == 2 ? ErrorCode.SERVIER_HIGH_LIMIT : a == 3 ? ErrorCode.SERVIER_HIGH_LIMIT_BRUSH : ErrorCode.SERVIER_LOW_LIMIT;
                    i3 = i2;
                    map4 = null;
                    map3 = map4;
                    bArr2 = map3;
                } else {
                    i3 = i2;
                    bArr2 = map2;
                }
                if (ALog.isPrintLog(Level.D)) {
                    str = aVar.m;
                    stringBuilder = new StringBuilder("onResult command:");
                    stringBuilder.append(message2.t);
                    stringBuilder.append(" erorcode:");
                    stringBuilder.append(i3);
                    ALog.d(str, stringBuilder.toString(), new Object[0]);
                }
                if (message2.t.intValue() != 102) {
                    if (message2.t.intValue() == 105) {
                        AccsAbstractDataListener listener = GlobalClientInfo.getInstance(aVar.i).getListener(com.taobao.accs.internal.b.ELECTION_SERVICE_ID);
                        if (listener != null) {
                            listener.onResponse(com.taobao.accs.internal.b.ELECTION_SERVICE_ID, message2.M, i3, bArr2, null);
                            return;
                        } else {
                            ALog.e(aVar.m, "onResult election listener null", new Object[0]);
                            return;
                        }
                    }
                    StringBuilder stringBuilder2;
                    String str3;
                    StringBuilder stringBuilder3;
                    if (message2.e) {
                        str = aVar.m;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(aVar.b);
                        stringBuilder2.append(" message is cancel! command:");
                        stringBuilder2.append(message2.t);
                        ALog.e(str, stringBuilder2.toString(), new Object[0]);
                    } else if (!b(i3) || message2.t.intValue() == 100 || message2.P > Message.a) {
                        ALog.d(aVar.m, "prepare send broadcast", new Object[0]);
                        Intent c = c(message);
                        c.putExtra("errorCode", i3);
                        ReqType valueOf = ReqType.valueOf((message2.k >> 13) & 3);
                        if (map3 == ReqType.RES || valueOf == ReqType.REQ) {
                            c.putExtra(Constants.KEY_SEND_TYPE, "res");
                        }
                        if (i3 == 200) {
                            c.putExtra("data", bArr2);
                        }
                        c.putExtra("appKey", aVar.l.b);
                        c.putExtra(Constants.KEY_CONFIG_TAG, aVar.l.m);
                        a(map4, c);
                        d.a(aVar.i, c);
                        if (!TextUtils.isEmpty(message2.F)) {
                            StringBuilder stringBuilder4 = new StringBuilder("commandId=");
                            stringBuilder4.append(message2.t);
                            String stringBuilder5 = stringBuilder4.toString();
                            stringBuilder4 = new StringBuilder("serviceId=");
                            stringBuilder4.append(message2.F);
                            stringBuilder4.append(" errorCode=");
                            stringBuilder4.append(i3);
                            stringBuilder4.append(" dataId=");
                            stringBuilder4.append(message2.q);
                            UTMini.getInstance().commitEvent(66001, "MsgToBuss0", stringBuilder5, stringBuilder4.toString(), Integer.valueOf(221));
                            str3 = BaseMonitor.COUNT_POINT_TO_BUSS;
                            stringBuilder3 = new StringBuilder("1commandId=");
                            stringBuilder3.append(message2.t);
                            stringBuilder3.append("serviceId=");
                            stringBuilder3.append(message2.F);
                            com.taobao.accs.utl.b.a("accs", str3, stringBuilder3.toString(), 0.0d);
                        }
                    } else {
                        message2.R = System.currentTimeMillis();
                        message2.P++;
                        aVar.l.b(message2, true);
                    }
                    NetPerformanceMonitor e = message.e();
                    if (e != null) {
                        e.onToBizDate();
                        if (message2.f != null) {
                            str2 = message2.f.toString();
                        }
                        if (i3 == 200) {
                            e.setRet(true);
                            if (message2.P > 0) {
                                com.taobao.accs.utl.b.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                                String str4 = BaseMonitor.COUNT_POINT_RESEND;
                                stringBuilder = new StringBuilder("succ_");
                                stringBuilder.append(message2.P);
                                com.taobao.accs.utl.b.a("accs", str4, stringBuilder.toString(), 0.0d);
                            } else {
                                com.taobao.accs.utl.b.a("accs", BaseMonitor.ALARM_POINT_REQUEST, str2);
                            }
                        } else {
                            if (message2.P > 0) {
                                str2 = BaseMonitor.COUNT_POINT_RESEND;
                                stringBuilder2 = new StringBuilder("fail＿");
                                stringBuilder2.append(i3);
                                com.taobao.accs.utl.b.a("accs", str2, stringBuilder2.toString(), 0.0d);
                                com.taobao.accs.utl.b.a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail", 0.0d);
                            } else if (i3 != -13) {
                                str3 = BaseMonitor.ALARM_POINT_REQUEST;
                                String int2String = UtilityImpl.int2String(i3);
                                stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(aVar.b);
                                stringBuilder3.append(message2.F);
                                stringBuilder3.append(message2.Q);
                                com.taobao.accs.utl.b.a("accs", str3, str2, int2String, stringBuilder3.toString());
                            }
                            e.setRet(false);
                            e.setFailReason(i3);
                        }
                        AppMonitor.getInstance().commitStat(message.e());
                    }
                    b(message2, i3);
                    return;
                }
                return;
            }
        }
        ALog.d(aVar.m, "onError, skip ping/ack", new Object[0]);
    }

    public void a() {
        ALog.d(this.m, "onSendPing", new Object[0]);
        synchronized (a.class) {
            this.h = true;
        }
    }

    public void b() {
        ALog.d(this.m, "onRcvPing", new Object[0]);
        synchronized (a.class) {
            this.h = false;
        }
    }

    public boolean c() {
        return this.h;
    }

    public void a(Message message) {
        if (!(this.k == null || message.M == null || message.F == null || this.k.M != message.M || this.k.F != message.F)) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.F, message.M, Long.valueOf(Thread.currentThread().getId()));
        }
        if (!(message.a() == -1 || message.a() == 2)) {
            if (!message.c) {
                this.g.put(message.b(), message);
            }
        }
    }

    public void a(int i) {
        int i2 = 0;
        this.h = false;
        String[] strArr = (String[]) this.g.keySet().toArray(new String[0]);
        if (strArr != null && strArr.length > 0) {
            ALog.d(this.m, "onNetworkFail", new Object[0]);
            int length = strArr.length;
            while (i2 < length) {
                Message message = (Message) this.g.remove(strArr[i2]);
                if (message != null) {
                    a(message, i);
                }
                i2++;
            }
        }
    }

    public void b(Message message) {
        if (this.g.keySet() != null && this.g.keySet().size() > 0) {
            for (String str : this.g.keySet()) {
                Message message2 = (Message) this.g.get(str);
                if (!(message2 == null || message2.t == null || !message2.f().equals(message.f()))) {
                    switch (message.t.intValue()) {
                        case 1:
                        case 2:
                            if (message2.t.intValue() == 1 || message2.t.intValue() == 2) {
                                message2.e = true;
                                break;
                            }
                        case 3:
                        case 4:
                            if (message2.t.intValue() == 3 || message2.t.intValue() == 4) {
                                message2.e = true;
                                break;
                            }
                        case 5:
                        case 6:
                            if (message2.t.intValue() == 5 || message2.t.intValue() == 6) {
                                message2.e = true;
                                break;
                            }
                        default:
                            break;
                    }
                }
                if (message2 != null && message2.e) {
                    ALog.e(this.m, "cancelControlMessage", "command", message2.t);
                }
            }
        }
    }

    public int d() {
        return this.g.size();
    }

    public Collection<Message> e() {
        return this.g.values();
    }

    public Message a(String str) {
        return (Message) this.g.get(str);
    }

    public Message b(String str) {
        return !TextUtils.isEmpty(str) ? (Message) this.g.remove(str) : null;
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str) || this.n.containsKey(str) == null) {
            return false;
        }
        return true;
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!this.n.containsKey(str)) {
                this.n.put(str, str);
                i();
            }
        }
    }

    private void h() {
        try {
            File dir = this.i.getDir("accs", 0);
            StringBuilder stringBuilder = new StringBuilder("message");
            stringBuilder.append(this.l.i());
            File file = new File(dir, stringBuilder.toString());
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.n.put(readLine, readLine);
                    } else {
                        bufferedReader.close();
                        return;
                    }
                }
            }
            ALog.d(this.m, "message file not exist", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void i() {
        try {
            File dir = this.i.getDir("accs", 0);
            StringBuilder stringBuilder = new StringBuilder("message");
            stringBuilder.append(this.l.i());
            FileWriter fileWriter = new FileWriter(new File(dir, stringBuilder.toString()));
            fileWriter.write("");
            for (String str : this.n.keySet()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("\r\n");
                fileWriter.append(stringBuilder.toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Intent c(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.s);
        intent.putExtra("command", message.t);
        intent.putExtra(Constants.KEY_SERVICE_ID, message.F);
        intent.putExtra(Constants.KEY_USER_ID, message.E);
        if (message.t != null && message.t.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.M);
        }
        return intent;
    }

    private void a(Map<Integer, String> map, Intent intent) {
        if (map != null && intent != null) {
            intent.putExtra(TaoBaseService$ExtraInfo.EXT_HEADER, (HashMap) map);
        }
    }

    private void a(Intent intent, String str, String str2, short s) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("source", str);
            }
            if (TextUtils.isEmpty(str2) == null) {
                intent.putExtra("target", str2);
            }
            intent.putExtra(Constants.KEY_FLAGS, s);
        }
    }

    public d f() {
        return this.j;
    }

    private void b(Message message, int i) {
        if (message != null) {
            String deviceId = UtilityImpl.getDeviceId(this.i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            String stringBuilder2 = stringBuilder.toString();
            boolean z = i == 200;
            int intValue = message.t.intValue();
            if (intValue != 1) {
                if (intValue == 3) {
                    com.taobao.accs.ut.statistics.b bVar = new com.taobao.accs.ut.statistics.b();
                    bVar.a = deviceId;
                    bVar.b = stringBuilder2;
                    bVar.c = z;
                    bVar.e = message.E;
                    bVar.a(i);
                    bVar.commitUT();
                }
                return;
            }
            message = new com.taobao.accs.ut.statistics.a();
            message.a = deviceId;
            message.b = stringBuilder2;
            message.c = z;
            message.a(i);
            message.commitUT();
        }
    }

    private void a(String str, String str2) {
        com.taobao.accs.ut.statistics.e eVar = new com.taobao.accs.ut.statistics.e();
        eVar.a = UtilityImpl.getDeviceId(this.i);
        eVar.c = str;
        str = new StringBuilder();
        str.append(System.currentTimeMillis());
        eVar.d = str.toString();
        eVar.f = "";
        eVar.e = str2;
        eVar.b = "";
        eVar.commitUT();
    }

    public void g() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.o);
        } catch (Throwable th) {
            ALog.e(this.m, "restoreTraffics", th, new Object[0]);
        }
    }

    public void a(com.taobao.accs.ut.monitor.TrafficsMonitor.a aVar) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new b(this, aVar));
        } catch (com.taobao.accs.ut.monitor.TrafficsMonitor.a aVar2) {
            ALog.e(this.m, "addTrafficsInfo", aVar2, new Object[0]);
        }
    }
}
