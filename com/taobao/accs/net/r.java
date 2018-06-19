package com.taobao.accs.net;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.HttpConstant;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.ut.statistics.c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.b;
import com.taobao.accs.utl.f;
import com.taobao.accs.utl.i;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* compiled from: Taobao */
public class r extends b implements SessionCb, Spdycb {
    private Object A = new Object();
    private long B;
    private long C;
    private long D;
    private long E;
    private int F = -1;
    private String G = null;
    private SessionMonitor H;
    private c I;
    private boolean J = false;
    private String K = "";
    private boolean L = false;
    private h M = new h(m());
    private String N;
    protected ScheduledFuture<?> n;
    protected String o;
    protected int p;
    protected String q;
    protected int r;
    private int s = 3;
    private LinkedList<Message> t = new LinkedList();
    private a u;
    private boolean v = true;
    private String w;
    private String x;
    private SpdyAgent y = null;
    private SpdySession z = null;

    /* compiled from: Taobao */
    private class a extends Thread {
        public int a = null;
        long b;
        final /* synthetic */ r c;
        private final String d = getName();

        public a(r rVar, String str) {
            this.c = rVar;
            super(str);
        }

        private void a(boolean z) {
            while (this.c.s != 1) {
                StringBuilder stringBuilder;
                if (UtilityImpl.isNetworkConnected(this.c.d)) {
                    if (z) {
                        this.a = 0;
                    }
                    String str = this.d;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(this.c.c);
                    stringBuilder2.append(" try connect, force = ");
                    stringBuilder2.append(z);
                    stringBuilder2.append(" failTimes = ");
                    stringBuilder2.append(this.a);
                    ALog.e(str, stringBuilder2.toString(), new Object[0]);
                    if (this.c.s || this.a < true) {
                        if (this.c.s) {
                            break;
                        }
                        if (!this.c.c || this.a) {
                            z = this.d;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(this.c.c);
                            stringBuilder.append(" try connect, need sleep");
                            ALog.i(z, stringBuilder.toString(), new Object[0]);
                            try {
                                sleep(5000);
                            } catch (boolean z2) {
                                z2.printStackTrace();
                            }
                        } else {
                            z2 = this.d;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(this.c.c);
                            stringBuilder.append(" try connect in app, no sleep");
                            ALog.i(z2, stringBuilder.toString(), new Object[0]);
                        }
                        this.c.K = "";
                        if (this.a) {
                            this.c.M.b(this.c.m());
                        }
                        this.c.d(null);
                        this.c.H.setRetryTimes(this.a);
                        if (!this.c.s) {
                            this.a += true;
                            z2 = this.d;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(this.c.c);
                            stringBuilder.append(" try connect fail, ready for reconnect");
                            ALog.e(z2, stringBuilder.toString(), new Object[0]);
                            z2 = false;
                        } else {
                            this.b = System.currentTimeMillis();
                            return;
                        }
                    }
                    this.c.J = true;
                    z2 = this.d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(this.c.c);
                    stringBuilder.append(" try connect fail 4 times");
                    ALog.e(z2, stringBuilder.toString(), new Object[0]);
                    return;
                }
                z2 = this.d;
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.c.c);
                stringBuilder.append(" Network not available");
                ALog.e(z2, stringBuilder.toString(), new Object[0]);
                return;
            }
            if (this.c.s && System.currentTimeMillis() - this.b > 5000) {
                this.a = 0;
            }
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.taobao.accs.net.r.a.run():void. bs: [B:183:0x04d3, B:189:0x04f2, B:216:0x0579]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r18 = this;
            r1 = r18;
            r2 = r1.d;
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = r1.c;
            r4 = r4.c;
            r3.append(r4);
            r4 = " NetworkThread run";
            r3.append(r4);
            r3 = r3.toString();
            r4 = 0;
            r5 = new java.lang.Object[r4];
            com.taobao.accs.utl.ALog.i(r2, r3, r5);
            r1.a = r4;
            r2 = 0;
        L_0x0022:
            r3 = r1.c;
            r3 = r3.v;
            if (r3 == 0) goto L_0x0596;
        L_0x002a:
            r3 = r1.d;
            r5 = "ready to get message";
            r6 = new java.lang.Object[r4];
            com.taobao.accs.utl.ALog.d(r3, r5, r6);
            r3 = r1.c;
            r3 = r3.t;
            monitor-enter(r3);
            r5 = r1.c;	 Catch:{ all -> 0x0592 }
            r5 = r5.t;	 Catch:{ all -> 0x0592 }
            r5 = r5.size();	 Catch:{ all -> 0x0592 }
            if (r5 != 0) goto L_0x0061;
        L_0x0046:
            r5 = r1.d;	 Catch:{ InterruptedException -> 0x0059 }
            r6 = "no message, wait";	 Catch:{ InterruptedException -> 0x0059 }
            r7 = new java.lang.Object[r4];	 Catch:{ InterruptedException -> 0x0059 }
            com.taobao.accs.utl.ALog.d(r5, r6, r7);	 Catch:{ InterruptedException -> 0x0059 }
            r5 = r1.c;	 Catch:{ InterruptedException -> 0x0059 }
            r5 = r5.t;	 Catch:{ InterruptedException -> 0x0059 }
            r5.wait();	 Catch:{ InterruptedException -> 0x0059 }
            goto L_0x0061;
        L_0x0059:
            r0 = move-exception;
            r2 = r0;
            r2.printStackTrace();	 Catch:{ all -> 0x0592 }
            monitor-exit(r3);	 Catch:{ all -> 0x0592 }
            goto L_0x0596;	 Catch:{ all -> 0x0592 }
        L_0x0061:
            r5 = r1.d;	 Catch:{ all -> 0x0592 }
            r6 = "try get message";	 Catch:{ all -> 0x0592 }
            r7 = new java.lang.Object[r4];	 Catch:{ all -> 0x0592 }
            com.taobao.accs.utl.ALog.d(r5, r6, r7);	 Catch:{ all -> 0x0592 }
            r5 = r1.c;	 Catch:{ all -> 0x0592 }
            r5 = r5.t;	 Catch:{ all -> 0x0592 }
            r5 = r5.size();	 Catch:{ all -> 0x0592 }
            if (r5 == 0) goto L_0x008f;	 Catch:{ all -> 0x0592 }
        L_0x0076:
            r2 = r1.c;	 Catch:{ all -> 0x0592 }
            r2 = r2.t;	 Catch:{ all -> 0x0592 }
            r2 = r2.getFirst();	 Catch:{ all -> 0x0592 }
            r2 = (com.taobao.accs.data.Message) r2;	 Catch:{ all -> 0x0592 }
            r5 = r2.e();	 Catch:{ all -> 0x0592 }
            if (r5 == 0) goto L_0x008f;	 Catch:{ all -> 0x0592 }
        L_0x0088:
            r5 = r2.e();	 Catch:{ all -> 0x0592 }
            r5.onTakeFromQueue();	 Catch:{ all -> 0x0592 }
        L_0x008f:
            monitor-exit(r3);	 Catch:{ all -> 0x0592 }
            r3 = r1.c;
            r3 = r3.v;
            if (r3 == 0) goto L_0x0596;
        L_0x0098:
            if (r2 == 0) goto L_0x0022;
        L_0x009a:
            r3 = r1.d;
            r5 = "send message not null";
            r6 = new java.lang.Object[r4];
            com.taobao.accs.utl.ALog.d(r3, r5, r6);
            r3 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;
            r7 = 1;
            r8 = r2.a();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = r1.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10.<init>();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = r11.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10.append(r11);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = " send:";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10.append(r11);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = com.taobao.accs.data.Message.b.b(r8);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10.append(r11);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = " status:";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10.append(r11);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = r11.s;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10.append(r11);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r10.toString();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            com.taobao.accs.utl.ALog.i(r9, r10, r11);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = 2;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r8 != r9) goto L_0x01e3;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x00de:
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r8 != r7) goto L_0x010d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x00e4:
            r8 = r1.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = "INAPP ping, skip";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            com.taobao.accs.utl.ALog.d(r8, r9, r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r3 = r1.d;	 Catch:{ Throwable -> 0x04a1 }
            r5 = "send succ, remove it";	 Catch:{ Throwable -> 0x04a1 }
            r6 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x04a1 }
            com.taobao.accs.utl.ALog.d(r3, r5, r6);	 Catch:{ Throwable -> 0x04a1 }
            r3 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r3 = r3.t;	 Catch:{ Throwable -> 0x04a1 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x04a1 }
            r5 = r1.c;	 Catch:{ all -> 0x0109 }
            r5 = r5.t;	 Catch:{ all -> 0x0109 }
            r5.remove(r2);	 Catch:{ all -> 0x0109 }
            monitor-exit(r3);	 Catch:{ all -> 0x0109 }
            goto L_0x0022;	 Catch:{ all -> 0x0109 }
        L_0x0109:
            r0 = move-exception;	 Catch:{ all -> 0x0109 }
            r5 = r0;	 Catch:{ all -> 0x0109 }
            monitor-exit(r3);	 Catch:{ all -> 0x0109 }
            throw r5;	 Catch:{ Throwable -> 0x04a1 }
        L_0x010d:
            r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r10.B;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = r8 - r10;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = com.taobao.accs.net.g.a(r8);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.b();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8 - r7;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8 * 1000;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = (long) r8;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r10 >= 0) goto L_0x0137;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x012d:
            r8 = r2.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r8 == 0) goto L_0x0132;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0131:
            goto L_0x0137;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0132:
            r1.a(r4);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            goto L_0x0319;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0137:
            r8 = r1.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = "ms:";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.<init>(r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = r12.B;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r14 = r10 - r12;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.append(r14);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = " force:";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.append(r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r2.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.append(r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = r9.toString();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            com.taobao.accs.utl.ALog.d(r8, r9, r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r1.a(r7);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.z;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r8 == 0) goto L_0x02f5;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x016d:
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.s;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r8 != r7) goto L_0x02f5;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0175:
            r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r10.B;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = r8 - r10;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = com.taobao.accs.net.g.a(r8);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.b();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8 - r7;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8 * 1000;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = (long) r8;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r10 < 0) goto L_0x0319;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0195:
            r8 = r1.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.<init>();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r10.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.append(r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = " onSendPing";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.append(r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = r9.toString();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            com.taobao.accs.utl.ALog.i(r8, r9, r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.e;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8.a();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.z;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8.submitPing();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.H;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8.onSendPing();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8.B = r9;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = java.lang.System.nanoTime();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8.C = r9;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8.f();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            goto L_0x0319;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x01e3:
            if (r8 != r7) goto L_0x02f7;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x01e5:
            r1.a(r7);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.s;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r8 != r7) goto L_0x02f5;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x01f0:
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.z;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r8 == 0) goto L_0x02f5;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x01f8:
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r10.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r2.a(r8, r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r2.a(r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r8.length;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r10 <= r11) goto L_0x0224;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0210:
            r10 = r2.t;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r10.intValue();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r10 == r11) goto L_0x0224;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x021a:
            r8 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.e;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = -4;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8.a(r2, r9);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            goto L_0x0319;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0224:
            r10 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = r10.z;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = r2.d();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r13 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r14 = 0;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r8 != 0) goto L_0x0235;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0233:
            r15 = r4;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            goto L_0x0237;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0235:
            r10 = r8.length;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r15 = r10;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0237:
            r16 = r8;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11.sendCustomControlFrame(r12, r13, r14, r15, r16);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r1.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11.<init>();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = r12.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11.append(r12);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = " send data len";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11.append(r12);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = r11.toString();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = 5;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r8 != 0) goto L_0x025a;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0258:
            r13 = r4;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            goto L_0x025b;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x025a:
            r13 = r8.length;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x025b:
            r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12[r4] = r13;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r13 = "dataId";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12[r7] = r13;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r13 = r2.b();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12[r9] = r13;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r13 = 3;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r14 = "utdid";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12[r13] = r14;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r13 = 4;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r14 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r14 = r14.j;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12[r13] = r14;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            com.taobao.accs.utl.ALog.e(r10, r11, r12);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r10.e;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10.a(r2);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r2.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r10 == 0) goto L_0x02be;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0285:
            r10 = r1.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11.<init>();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = r12.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11.append(r12);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = " sendCFrame end ack";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11.append(r12);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = r11.toString();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = new java.lang.Object[r9];	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = "dataId";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9[r4] = r12;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = r2.d();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9[r7] = r12;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            com.taobao.accs.utl.ALog.e(r10, r11, r9);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = r9.l;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r2.d();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.put(r10, r2);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x02be:
            r9 = r2.e();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            if (r9 == 0) goto L_0x02cb;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x02c4:
            r9 = r2.e();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.onSendData();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x02cb:
            r9 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r2.b();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = r2.Q;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = (long) r11;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.a(r10, r11);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = r9.e;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r14 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r11 = r2.F;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r12 = anet.channel.GlobalAppRuntimeInfo.isAppBackground();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r13 = r10.m();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r8.length;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r5 = (long) r8;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10 = r14;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = r14;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r14 = r5;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r10.<init>(r11, r12, r13, r14);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9.a(r8);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            goto L_0x0319;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x02f5:
            r5 = r4;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            goto L_0x031a;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x02f7:
            r1.a(r4);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r5 = r1.d;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r6.<init>();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = r1.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = r9.c;	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r6.append(r9);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r9 = " skip msg ";	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r6.append(r9);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r6.append(r8);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r6 = r6.toString();	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            r8 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
            com.taobao.accs.utl.ALog.e(r5, r6, r8);	 Catch:{ Throwable -> 0x03de, all -> 0x03d9 }
        L_0x0319:
            r5 = r7;
        L_0x031a:
            r6 = r1.c;	 Catch:{ Throwable -> 0x03d5, all -> 0x03d1 }
            r6.q();	 Catch:{ Throwable -> 0x03d5, all -> 0x03d1 }
            if (r5 != 0) goto L_0x03b1;
        L_0x0321:
            r5 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r5.l();	 Catch:{ Throwable -> 0x04a1 }
            r5 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r5 = r5.H;	 Catch:{ Throwable -> 0x04a1 }
            if (r5 == 0) goto L_0x0339;	 Catch:{ Throwable -> 0x04a1 }
        L_0x032e:
            r5 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r5 = r5.H;	 Catch:{ Throwable -> 0x04a1 }
            r6 = "send fail";	 Catch:{ Throwable -> 0x04a1 }
            r5.setCloseReason(r6);	 Catch:{ Throwable -> 0x04a1 }
        L_0x0339:
            r5 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r5 = r5.t;	 Catch:{ Throwable -> 0x04a1 }
            monitor-enter(r5);	 Catch:{ Throwable -> 0x04a1 }
            r6 = r1.c;	 Catch:{ all -> 0x03ad }
            r6 = r6.t;	 Catch:{ all -> 0x03ad }
            r6 = r6.size();	 Catch:{ all -> 0x03ad }
            r6 = r6 - r7;	 Catch:{ all -> 0x03ad }
        L_0x034b:
            if (r6 < 0) goto L_0x0385;	 Catch:{ all -> 0x03ad }
        L_0x034d:
            r7 = r1.c;	 Catch:{ all -> 0x03ad }
            r7 = r7.t;	 Catch:{ all -> 0x03ad }
            r7 = r7.get(r6);	 Catch:{ all -> 0x03ad }
            r7 = (com.taobao.accs.data.Message) r7;	 Catch:{ all -> 0x03ad }
            if (r7 == 0) goto L_0x0382;	 Catch:{ all -> 0x03ad }
        L_0x035b:
            r8 = r7.t;	 Catch:{ all -> 0x03ad }
            if (r8 == 0) goto L_0x0382;	 Catch:{ all -> 0x03ad }
        L_0x035f:
            r8 = r7.t;	 Catch:{ all -> 0x03ad }
            r8 = r8.intValue();	 Catch:{ all -> 0x03ad }
            r9 = 100;	 Catch:{ all -> 0x03ad }
            if (r8 == r9) goto L_0x0371;	 Catch:{ all -> 0x03ad }
        L_0x0369:
            r8 = r7.t;	 Catch:{ all -> 0x03ad }
            r8 = r8.intValue();	 Catch:{ all -> 0x03ad }
            if (r8 != r3) goto L_0x0382;	 Catch:{ all -> 0x03ad }
        L_0x0371:
            r8 = r1.c;	 Catch:{ all -> 0x03ad }
            r8 = r8.e;	 Catch:{ all -> 0x03ad }
            r9 = -1;	 Catch:{ all -> 0x03ad }
            r8.a(r7, r9);	 Catch:{ all -> 0x03ad }
            r7 = r1.c;	 Catch:{ all -> 0x03ad }
            r7 = r7.t;	 Catch:{ all -> 0x03ad }
            r7.remove(r6);	 Catch:{ all -> 0x03ad }
        L_0x0382:
            r6 = r6 + -1;	 Catch:{ all -> 0x03ad }
            goto L_0x034b;	 Catch:{ all -> 0x03ad }
        L_0x0385:
            r3 = r1.d;	 Catch:{ all -> 0x03ad }
            r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x03ad }
            r6.<init>();	 Catch:{ all -> 0x03ad }
            r7 = r1.c;	 Catch:{ all -> 0x03ad }
            r7 = r7.c;	 Catch:{ all -> 0x03ad }
            r6.append(r7);	 Catch:{ all -> 0x03ad }
            r7 = " network disconnected, wait";	 Catch:{ all -> 0x03ad }
            r6.append(r7);	 Catch:{ all -> 0x03ad }
            r6 = r6.toString();	 Catch:{ all -> 0x03ad }
            r7 = new java.lang.Object[r4];	 Catch:{ all -> 0x03ad }
            com.taobao.accs.utl.ALog.e(r3, r6, r7);	 Catch:{ all -> 0x03ad }
            r3 = r1.c;	 Catch:{ all -> 0x03ad }
            r3 = r3.t;	 Catch:{ all -> 0x03ad }
            r3.wait();	 Catch:{ all -> 0x03ad }
            monitor-exit(r5);	 Catch:{ all -> 0x03ad }
            goto L_0x0022;	 Catch:{ all -> 0x03ad }
        L_0x03ad:
            r0 = move-exception;	 Catch:{ all -> 0x03ad }
            r3 = r0;	 Catch:{ all -> 0x03ad }
            monitor-exit(r5);	 Catch:{ all -> 0x03ad }
            throw r3;	 Catch:{ Throwable -> 0x04a1 }
        L_0x03b1:
            r3 = r1.d;	 Catch:{ Throwable -> 0x04a1 }
            r5 = "send succ, remove it";	 Catch:{ Throwable -> 0x04a1 }
            r6 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x04a1 }
            com.taobao.accs.utl.ALog.d(r3, r5, r6);	 Catch:{ Throwable -> 0x04a1 }
            r3 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r3 = r3.t;	 Catch:{ Throwable -> 0x04a1 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x04a1 }
            r5 = r1.c;	 Catch:{ all -> 0x03cd }
            r5 = r5.t;	 Catch:{ all -> 0x03cd }
            r5.remove(r2);	 Catch:{ all -> 0x03cd }
            monitor-exit(r3);	 Catch:{ all -> 0x03cd }
            goto L_0x0022;	 Catch:{ all -> 0x03cd }
        L_0x03cd:
            r0 = move-exception;	 Catch:{ all -> 0x03cd }
            r5 = r0;	 Catch:{ all -> 0x03cd }
            monitor-exit(r3);	 Catch:{ all -> 0x03cd }
            throw r5;	 Catch:{ Throwable -> 0x04a1 }
        L_0x03d1:
            r0 = move-exception;
            r6 = r5;
            goto L_0x04d0;
        L_0x03d5:
            r0 = move-exception;
            r6 = r5;
            r5 = r0;
            goto L_0x03e1;
        L_0x03d9:
            r0 = move-exception;
            r5 = r0;
            r6 = r7;
            goto L_0x04d1;
        L_0x03de:
            r0 = move-exception;
            r5 = r0;
            r6 = r7;
        L_0x03e1:
            r8 = "accs";	 Catch:{ all -> 0x04cf }
            r9 = "send_fail";	 Catch:{ all -> 0x04cf }
            r10 = r2.F;	 Catch:{ all -> 0x04cf }
            r11 = "1";	 Catch:{ all -> 0x04cf }
            r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x04cf }
            r12.<init>();	 Catch:{ all -> 0x04cf }
            r13 = r1.c;	 Catch:{ all -> 0x04cf }
            r13 = r13.c;	 Catch:{ all -> 0x04cf }
            r12.append(r13);	 Catch:{ all -> 0x04cf }
            r13 = r5.toString();	 Catch:{ all -> 0x04cf }
            r12.append(r13);	 Catch:{ all -> 0x04cf }
            r12 = r12.toString();	 Catch:{ all -> 0x04cf }
            com.taobao.accs.utl.b.a(r8, r9, r10, r11, r12);	 Catch:{ all -> 0x04cf }
            r5.printStackTrace();	 Catch:{ all -> 0x04cf }
            r8 = r1.d;	 Catch:{ all -> 0x04cf }
            r9 = "service connection run";	 Catch:{ all -> 0x04cf }
            r10 = new java.lang.Object[r4];	 Catch:{ all -> 0x04cf }
            com.taobao.accs.utl.ALog.e(r8, r9, r5, r10);	 Catch:{ all -> 0x04cf }
            if (r6 != 0) goto L_0x04a4;
        L_0x0411:
            r5 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r5.l();	 Catch:{ Throwable -> 0x04a1 }
            r5 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r5 = r5.H;	 Catch:{ Throwable -> 0x04a1 }
            if (r5 == 0) goto L_0x0429;	 Catch:{ Throwable -> 0x04a1 }
        L_0x041e:
            r5 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r5 = r5.H;	 Catch:{ Throwable -> 0x04a1 }
            r6 = "send fail";	 Catch:{ Throwable -> 0x04a1 }
            r5.setCloseReason(r6);	 Catch:{ Throwable -> 0x04a1 }
        L_0x0429:
            r5 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r5 = r5.t;	 Catch:{ Throwable -> 0x04a1 }
            monitor-enter(r5);	 Catch:{ Throwable -> 0x04a1 }
            r6 = r1.c;	 Catch:{ all -> 0x049d }
            r6 = r6.t;	 Catch:{ all -> 0x049d }
            r6 = r6.size();	 Catch:{ all -> 0x049d }
            r6 = r6 - r7;	 Catch:{ all -> 0x049d }
        L_0x043b:
            if (r6 < 0) goto L_0x0475;	 Catch:{ all -> 0x049d }
        L_0x043d:
            r7 = r1.c;	 Catch:{ all -> 0x049d }
            r7 = r7.t;	 Catch:{ all -> 0x049d }
            r7 = r7.get(r6);	 Catch:{ all -> 0x049d }
            r7 = (com.taobao.accs.data.Message) r7;	 Catch:{ all -> 0x049d }
            if (r7 == 0) goto L_0x0472;	 Catch:{ all -> 0x049d }
        L_0x044b:
            r8 = r7.t;	 Catch:{ all -> 0x049d }
            if (r8 == 0) goto L_0x0472;	 Catch:{ all -> 0x049d }
        L_0x044f:
            r8 = r7.t;	 Catch:{ all -> 0x049d }
            r8 = r8.intValue();	 Catch:{ all -> 0x049d }
            r9 = 100;	 Catch:{ all -> 0x049d }
            if (r8 == r9) goto L_0x0461;	 Catch:{ all -> 0x049d }
        L_0x0459:
            r8 = r7.t;	 Catch:{ all -> 0x049d }
            r8 = r8.intValue();	 Catch:{ all -> 0x049d }
            if (r8 != r3) goto L_0x0472;	 Catch:{ all -> 0x049d }
        L_0x0461:
            r8 = r1.c;	 Catch:{ all -> 0x049d }
            r8 = r8.e;	 Catch:{ all -> 0x049d }
            r9 = -1;	 Catch:{ all -> 0x049d }
            r8.a(r7, r9);	 Catch:{ all -> 0x049d }
            r7 = r1.c;	 Catch:{ all -> 0x049d }
            r7 = r7.t;	 Catch:{ all -> 0x049d }
            r7.remove(r6);	 Catch:{ all -> 0x049d }
        L_0x0472:
            r6 = r6 + -1;	 Catch:{ all -> 0x049d }
            goto L_0x043b;	 Catch:{ all -> 0x049d }
        L_0x0475:
            r3 = r1.d;	 Catch:{ all -> 0x049d }
            r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x049d }
            r6.<init>();	 Catch:{ all -> 0x049d }
            r7 = r1.c;	 Catch:{ all -> 0x049d }
            r7 = r7.c;	 Catch:{ all -> 0x049d }
            r6.append(r7);	 Catch:{ all -> 0x049d }
            r7 = " network disconnected, wait";	 Catch:{ all -> 0x049d }
            r6.append(r7);	 Catch:{ all -> 0x049d }
            r6 = r6.toString();	 Catch:{ all -> 0x049d }
            r7 = new java.lang.Object[r4];	 Catch:{ all -> 0x049d }
            com.taobao.accs.utl.ALog.e(r3, r6, r7);	 Catch:{ all -> 0x049d }
            r3 = r1.c;	 Catch:{ all -> 0x049d }
            r3 = r3.t;	 Catch:{ all -> 0x049d }
            r3.wait();	 Catch:{ all -> 0x049d }
            monitor-exit(r5);	 Catch:{ all -> 0x049d }
            goto L_0x0022;	 Catch:{ all -> 0x049d }
        L_0x049d:
            r0 = move-exception;	 Catch:{ all -> 0x049d }
            r3 = r0;	 Catch:{ all -> 0x049d }
            monitor-exit(r5);	 Catch:{ all -> 0x049d }
            throw r3;	 Catch:{ Throwable -> 0x04a1 }
        L_0x04a1:
            r0 = move-exception;	 Catch:{ Throwable -> 0x04a1 }
            r3 = r0;	 Catch:{ Throwable -> 0x04a1 }
            goto L_0x04c4;	 Catch:{ Throwable -> 0x04a1 }
        L_0x04a4:
            r3 = r1.d;	 Catch:{ Throwable -> 0x04a1 }
            r5 = "send succ, remove it";	 Catch:{ Throwable -> 0x04a1 }
            r6 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x04a1 }
            com.taobao.accs.utl.ALog.d(r3, r5, r6);	 Catch:{ Throwable -> 0x04a1 }
            r3 = r1.c;	 Catch:{ Throwable -> 0x04a1 }
            r3 = r3.t;	 Catch:{ Throwable -> 0x04a1 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x04a1 }
            r5 = r1.c;	 Catch:{ all -> 0x04c0 }
            r5 = r5.t;	 Catch:{ all -> 0x04c0 }
            r5.remove(r2);	 Catch:{ all -> 0x04c0 }
            monitor-exit(r3);	 Catch:{ all -> 0x04c0 }
            goto L_0x0022;	 Catch:{ all -> 0x04c0 }
        L_0x04c0:
            r0 = move-exception;	 Catch:{ all -> 0x04c0 }
            r5 = r0;	 Catch:{ all -> 0x04c0 }
            monitor-exit(r3);	 Catch:{ all -> 0x04c0 }
            throw r5;	 Catch:{ Throwable -> 0x04a1 }
        L_0x04c4:
            r5 = r1.d;
            r6 = " run finally error";
            r7 = new java.lang.Object[r4];
            com.taobao.accs.utl.ALog.e(r5, r6, r3, r7);
            goto L_0x0022;
        L_0x04cf:
            r0 = move-exception;
        L_0x04d0:
            r5 = r0;
        L_0x04d1:
            if (r6 != 0) goto L_0x0569;
        L_0x04d3:
            r2 = r1.c;	 Catch:{ Throwable -> 0x0566 }
            r2.l();	 Catch:{ Throwable -> 0x0566 }
            r2 = r1.c;	 Catch:{ Throwable -> 0x0566 }
            r2 = r2.H;	 Catch:{ Throwable -> 0x0566 }
            if (r2 == 0) goto L_0x04eb;	 Catch:{ Throwable -> 0x0566 }
        L_0x04e0:
            r2 = r1.c;	 Catch:{ Throwable -> 0x0566 }
            r2 = r2.H;	 Catch:{ Throwable -> 0x0566 }
            r6 = "send fail";	 Catch:{ Throwable -> 0x0566 }
            r2.setCloseReason(r6);	 Catch:{ Throwable -> 0x0566 }
        L_0x04eb:
            r2 = r1.c;	 Catch:{ Throwable -> 0x0566 }
            r2 = r2.t;	 Catch:{ Throwable -> 0x0566 }
            monitor-enter(r2);	 Catch:{ Throwable -> 0x0566 }
            r6 = r1.c;	 Catch:{ all -> 0x0562 }
            r6 = r6.t;	 Catch:{ all -> 0x0562 }
            r6 = r6.size();	 Catch:{ all -> 0x0562 }
            r6 = r6 - r7;	 Catch:{ all -> 0x0562 }
        L_0x04fd:
            if (r6 < 0) goto L_0x053b;	 Catch:{ all -> 0x0562 }
        L_0x04ff:
            r7 = r1.c;	 Catch:{ all -> 0x0562 }
            r7 = r7.t;	 Catch:{ all -> 0x0562 }
            r7 = r7.get(r6);	 Catch:{ all -> 0x0562 }
            r7 = (com.taobao.accs.data.Message) r7;	 Catch:{ all -> 0x0562 }
            if (r7 == 0) goto L_0x0535;	 Catch:{ all -> 0x0562 }
        L_0x050d:
            r8 = r7.t;	 Catch:{ all -> 0x0562 }
            if (r8 == 0) goto L_0x0535;	 Catch:{ all -> 0x0562 }
        L_0x0511:
            r8 = r7.t;	 Catch:{ all -> 0x0562 }
            r8 = r8.intValue();	 Catch:{ all -> 0x0562 }
            r9 = 100;	 Catch:{ all -> 0x0562 }
            if (r8 == r9) goto L_0x0523;	 Catch:{ all -> 0x0562 }
        L_0x051b:
            r8 = r7.t;	 Catch:{ all -> 0x0562 }
            r8 = r8.intValue();	 Catch:{ all -> 0x0562 }
            if (r8 != r3) goto L_0x0537;	 Catch:{ all -> 0x0562 }
        L_0x0523:
            r8 = r1.c;	 Catch:{ all -> 0x0562 }
            r8 = r8.e;	 Catch:{ all -> 0x0562 }
            r10 = -1;	 Catch:{ all -> 0x0562 }
            r8.a(r7, r10);	 Catch:{ all -> 0x0562 }
            r7 = r1.c;	 Catch:{ all -> 0x0562 }
            r7 = r7.t;	 Catch:{ all -> 0x0562 }
            r7.remove(r6);	 Catch:{ all -> 0x0562 }
            goto L_0x0538;	 Catch:{ all -> 0x0562 }
        L_0x0535:
            r9 = 100;	 Catch:{ all -> 0x0562 }
        L_0x0537:
            r10 = -1;	 Catch:{ all -> 0x0562 }
        L_0x0538:
            r6 = r6 + -1;	 Catch:{ all -> 0x0562 }
            goto L_0x04fd;	 Catch:{ all -> 0x0562 }
        L_0x053b:
            r3 = r1.d;	 Catch:{ all -> 0x0562 }
            r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0562 }
            r6.<init>();	 Catch:{ all -> 0x0562 }
            r7 = r1.c;	 Catch:{ all -> 0x0562 }
            r7 = r7.c;	 Catch:{ all -> 0x0562 }
            r6.append(r7);	 Catch:{ all -> 0x0562 }
            r7 = " network disconnected, wait";	 Catch:{ all -> 0x0562 }
            r6.append(r7);	 Catch:{ all -> 0x0562 }
            r6 = r6.toString();	 Catch:{ all -> 0x0562 }
            r7 = new java.lang.Object[r4];	 Catch:{ all -> 0x0562 }
            com.taobao.accs.utl.ALog.e(r3, r6, r7);	 Catch:{ all -> 0x0562 }
            r3 = r1.c;	 Catch:{ all -> 0x0562 }
            r3 = r3.t;	 Catch:{ all -> 0x0562 }
            r3.wait();	 Catch:{ all -> 0x0562 }
            monitor-exit(r2);	 Catch:{ all -> 0x0562 }
            goto L_0x0591;	 Catch:{ all -> 0x0562 }
        L_0x0562:
            r0 = move-exception;	 Catch:{ all -> 0x0562 }
            r3 = r0;	 Catch:{ all -> 0x0562 }
            monitor-exit(r2);	 Catch:{ all -> 0x0562 }
            throw r3;	 Catch:{ Throwable -> 0x0566 }
        L_0x0566:
            r0 = move-exception;	 Catch:{ Throwable -> 0x0566 }
            r2 = r0;	 Catch:{ Throwable -> 0x0566 }
            goto L_0x0588;	 Catch:{ Throwable -> 0x0566 }
        L_0x0569:
            r3 = r1.d;	 Catch:{ Throwable -> 0x0566 }
            r6 = "send succ, remove it";	 Catch:{ Throwable -> 0x0566 }
            r7 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0566 }
            com.taobao.accs.utl.ALog.d(r3, r6, r7);	 Catch:{ Throwable -> 0x0566 }
            r3 = r1.c;	 Catch:{ Throwable -> 0x0566 }
            r3 = r3.t;	 Catch:{ Throwable -> 0x0566 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x0566 }
            r6 = r1.c;	 Catch:{ all -> 0x0584 }
            r6 = r6.t;	 Catch:{ all -> 0x0584 }
            r6.remove(r2);	 Catch:{ all -> 0x0584 }
            monitor-exit(r3);	 Catch:{ all -> 0x0584 }
            goto L_0x0591;	 Catch:{ all -> 0x0584 }
        L_0x0584:
            r0 = move-exception;	 Catch:{ all -> 0x0584 }
            r2 = r0;	 Catch:{ all -> 0x0584 }
            monitor-exit(r3);	 Catch:{ all -> 0x0584 }
            throw r2;	 Catch:{ Throwable -> 0x0566 }
        L_0x0588:
            r3 = r1.d;
            r6 = " run finally error";
            r4 = new java.lang.Object[r4];
            com.taobao.accs.utl.ALog.e(r3, r6, r2, r4);
        L_0x0591:
            throw r5;
        L_0x0592:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r3);	 Catch:{ all -> 0x0592 }
            throw r2;
        L_0x0596:
            r2 = r1.c;
            r2.l();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.r.a.run():void");
        }
    }

    protected boolean h() {
        return false;
    }

    public r(Context context, int i, String str) {
        super(context, i, str);
        r();
    }

    public void a() {
        this.v = true;
        a(this.d);
        if (this.u == null) {
            String d = d();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.c);
            stringBuilder.append(" start thread");
            ALog.i(d, stringBuilder.toString(), new Object[0]);
            stringBuilder = new StringBuilder("NetworkThread_");
            stringBuilder.append(this.m);
            this.u = new a(this, stringBuilder.toString());
            this.u.setPriority(2);
            this.u.start();
        }
        a(false, false);
    }

    protected void a(com.taobao.accs.data.Message r6, boolean r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.v;
        r1 = 0;
        if (r0 == 0) goto L_0x00cd;
    L_0x0005:
        if (r6 != 0) goto L_0x0009;
    L_0x0007:
        goto L_0x00cd;
    L_0x0009:
        r0 = com.taobao.accs.common.ThreadPoolExecutorFactory.getScheduledExecutor();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r0 = r0.getQueue();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r0 = r0.size();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        if (r0 <= r2) goto L_0x0021;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
    L_0x0019:
        r7 = new java.util.concurrent.RejectedExecutionException;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r0 = "accs";	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r7.<init>(r0);	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        throw r7;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
    L_0x0021:
        r0 = com.taobao.accs.common.ThreadPoolExecutorFactory.getScheduledExecutor();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r2 = new com.taobao.accs.net.s;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r2.<init>(r5, r6, r7);	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r3 = r6.O;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r7 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r7 = r0.schedule(r2, r3, r7);	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r0 = r6.a();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r2 = 1;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        if (r0 != r2) goto L_0x0051;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
    L_0x0039:
        r0 = r6.M;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
    L_0x003d:
        r0 = r6.c();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        if (r0 == 0) goto L_0x0048;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
    L_0x0043:
        r0 = r6.M;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r5.a(r0);	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
    L_0x0048:
        r0 = r5.e;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r0 = r0.a;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r2 = r6.M;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r0.put(r2, r7);	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
    L_0x0051:
        r7 = r6.e();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        if (r7 == 0) goto L_0x0074;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
    L_0x0057:
        r7 = r6.e();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r0 = r5.d;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r0 = com.taobao.accs.utl.UtilityImpl.getDeviceId(r0);	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r7.setDeviceId(r0);	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r7 = r6.e();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r0 = r5.c;	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r7.setConnType(r0);	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r7 = r6.e();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
        r7.onEnterQueueData();	 Catch:{ RejectedExecutionException -> 0x0099, Throwable -> 0x0075 }
    L_0x0074:
        return;
    L_0x0075:
        r7 = move-exception;
        r0 = r5.e;
        r2 = -8;
        r0.a(r6, r2);
        r6 = r5.d();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = r5.c;
        r0.append(r2);
        r2 = "send error";
        r0.append(r2);
        r0 = r0.toString();
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r6, r0, r7, r1);
        return;
    L_0x0099:
        r7 = r5.e;
        r0 = 70008; // 0x11178 float:9.8102E-41 double:3.45885E-319;
        r7.a(r6, r0);
        r6 = r5.d();
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r5.c;
        r7.append(r0);
        r0 = "send queue full count:";
        r7.append(r0);
        r0 = com.taobao.accs.common.ThreadPoolExecutorFactory.getScheduledExecutor();
        r0 = r0.getQueue();
        r0 = r0.size();
        r7.append(r0);
        r7 = r7.toString();
        r0 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r6, r7, r0);
        return;
    L_0x00cd:
        r6 = r5.d();
        r7 = new java.lang.StringBuilder;
        r0 = "not running or msg null! ";
        r7.<init>(r0);
        r0 = r5.v;
        r7.append(r0);
        r7 = r7.toString();
        r0 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r6, r7, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.r.a(com.taobao.accs.data.Message, boolean):void");
    }

    public void e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        super.e();
        r0 = 0;
        r4.v = r0;
        r4.l();
        r1 = r4.H;
        if (r1 == 0) goto L_0x0014;
    L_0x000d:
        r1 = r4.H;
        r2 = "shut down";
        r1.setCloseReason(r2);
    L_0x0014:
        r1 = r4.t;
        monitor-enter(r1);
        r2 = r4.t;	 Catch:{ Exception -> 0x001f }
        r2.notifyAll();	 Catch:{ Exception -> 0x001f }
        goto L_0x001f;
    L_0x001d:
        r0 = move-exception;
        goto L_0x003d;
    L_0x001f:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        r1 = r4.d();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r4.c;
        r2.append(r3);
        r3 = "shut down";
        r2.append(r3);
        r2 = r2.toString();
        r0 = new java.lang.Object[r0];
        com.taobao.accs.utl.ALog.e(r1, r2, r0);
        return;
    L_0x003d:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.r.e():void");
    }

    public void a(boolean z, boolean z2) {
        String d = d();
        StringBuilder stringBuilder = new StringBuilder("try ping, force:");
        stringBuilder.append(z);
        ALog.d(d, stringBuilder.toString(), new Object[0]);
        if (this.c == 1) {
            ALog.d(d(), "INAPP, skip", new Object[0]);
        } else {
            b(Message.a(z, (int) (z2 ? (Math.random() * 10.0d) * 1000.0d : 0.0d)), z);
        }
    }

    public void l() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.d();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r3.c;
        r1.append(r2);
        r2 = " force close!";
        r1.append(r2);
        r1 = r1.toString();
        r2 = 0;
        r2 = new java.lang.Object[r2];
        com.taobao.accs.utl.ALog.e(r0, r1, r2);
        r0 = r3.z;	 Catch:{ Exception -> 0x0028 }
        r0.closeSession();	 Catch:{ Exception -> 0x0028 }
        r0 = r3.H;	 Catch:{ Exception -> 0x0028 }
        r1 = 1;	 Catch:{ Exception -> 0x0028 }
        r0.setCloseType(r1);	 Catch:{ Exception -> 0x0028 }
    L_0x0028:
        r0 = 3;
        r3.c(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.r.l():void");
    }

    public c c() {
        if (this.I == null) {
            this.I = new c();
        }
        this.I.b = this.c;
        this.I.d = this.t.size();
        this.I.i = UtilityImpl.isNetworkConnected(this.d);
        this.I.f = this.K;
        this.I.a = this.s;
        int i = 0;
        this.I.c = this.H == null ? false : this.H.getRet();
        this.I.j = n();
        c cVar = this.I;
        if (this.e != null) {
            i = this.e.d();
        }
        cVar.e = i;
        this.I.g = this.x;
        return this.I;
    }

    private void a(Message message) {
        if (message.t != null) {
            if (this.t.size() != 0) {
                for (int size = this.t.size() - 1; size >= 0; size--) {
                    Message message2 = (Message) this.t.get(size);
                    if (!(message2 == null || message2.t == null || !message2.f().equals(message.f()))) {
                        switch (message.t.intValue()) {
                            case 1:
                            case 2:
                                if (message2.t.intValue() == 1 || message2.t.intValue() == 2) {
                                    this.t.remove(size);
                                    break;
                                }
                            case 3:
                            case 4:
                                if (message2.t.intValue() == 3 || message2.t.intValue() == 4) {
                                    this.t.remove(size);
                                    break;
                                }
                            case 5:
                            case 6:
                                if (message2.t.intValue() == 5 || message2.t.intValue() == 6) {
                                    this.t.remove(size);
                                    break;
                                }
                            default:
                                break;
                        }
                        String d = d();
                        StringBuilder stringBuilder = new StringBuilder("clearRepeatControlCommand message:");
                        stringBuilder.append(message2.t);
                        stringBuilder.append("/");
                        stringBuilder.append(message2.f());
                        ALog.d(d, stringBuilder.toString(), new Object[0]);
                    }
                }
                if (this.e != null) {
                    this.e.b(message);
                }
            }
        }
    }

    private void d(String str) {
        String str2 = str;
        if (this.s != 2) {
            if (r10.s != 1) {
                StringBuilder stringBuilder;
                if (r10.M == null) {
                    r10.M = new h(m());
                }
                List<IConnStrategy> a = r10.M.a(m());
                int i = Constants.PORT;
                if (a == null || a.size() <= 0) {
                    if (str2 != null) {
                        r10.o = str2;
                    } else {
                        r10.o = m();
                    }
                    if (System.currentTimeMillis() % 2 == 0) {
                        i = 80;
                    }
                    r10.p = i;
                    b.a("accs", BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
                    str2 = d();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(r10.c);
                    stringBuilder.append(" get ip from amdc fail!!");
                    ALog.i(str2, stringBuilder.toString(), new Object[0]);
                } else {
                    for (IConnStrategy iConnStrategy : a) {
                        if (iConnStrategy != null) {
                            String d = d();
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(r10.c);
                            stringBuilder2.append(" connect strategys ip:");
                            stringBuilder2.append(iConnStrategy.getIp());
                            stringBuilder2.append(" port:");
                            stringBuilder2.append(iConnStrategy.getPort());
                            ALog.e(d, stringBuilder2.toString(), new Object[0]);
                        }
                    }
                    if (r10.L) {
                        r10.M.b();
                        r10.L = false;
                    }
                    IConnStrategy a2 = r10.M.a();
                    r10.o = a2 == null ? m() : a2.getIp();
                    if (a2 != null) {
                        i = a2.getPort();
                    }
                    r10.p = i;
                    b.a("accs", BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
                    str2 = d();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(r10.c);
                    stringBuilder.append(" get ip from amdc succ:");
                    stringBuilder.append(r10.o);
                    stringBuilder.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    stringBuilder.append(r10.p);
                    stringBuilder.append(" originPos:");
                    stringBuilder.append(r10.M.c());
                    ALog.e(str2, stringBuilder.toString(), new Object[0]);
                }
                StringBuilder stringBuilder3 = new StringBuilder("https://");
                stringBuilder3.append(r10.o);
                stringBuilder3.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                stringBuilder3.append(r10.p);
                stringBuilder3.append("/accs/");
                r10.w = stringBuilder3.toString();
                str2 = d();
                stringBuilder = new StringBuilder();
                stringBuilder.append(r10.c);
                stringBuilder.append(" connect URL:");
                stringBuilder.append(r10.w);
                ALog.e(str2, stringBuilder.toString(), new Object[0]);
                r10.N = String.valueOf(System.currentTimeMillis());
                if (r10.H != null) {
                    AppMonitor.getInstance().commitStat(r10.H);
                }
                r10.H = new SessionMonitor();
                r10.H.setConnectType(r10.c == 0 ? NotificationCompat.CATEGORY_SERVICE : "inapp");
                Exception exception = r10.y;
                if (exception != null) {
                    try {
                        r10.D = System.currentTimeMillis();
                        r10.E = System.nanoTime();
                        r10.q = UtilityImpl.getProxyHost(r10.d);
                        r10.r = UtilityImpl.getProxyPort(r10.d);
                        r10.B = System.currentTimeMillis();
                        r10.H.onStartConnect();
                        Object obj = r10.A;
                        synchronized (obj) {
                            try {
                                String str3;
                                int i2;
                                SessionInfo sessionInfo;
                                if (TextUtils.isEmpty(r10.q) || r10.r < 0 || !r10.J) {
                                    str2 = d();
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(r10.c);
                                    stringBuilder.append(" connect normal");
                                    ALog.e(str2, stringBuilder.toString(), new Object[0]);
                                    str3 = r10.o;
                                    i2 = r10.p;
                                    stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append(m());
                                    stringBuilder3.append("_");
                                    stringBuilder3.append(r10.b);
                                    sessionInfo = new SessionInfo(str3, i2, stringBuilder3.toString(), null, 0, r10.N, r10, 4226);
                                    r10.K = "";
                                    sessionInfo = r16;
                                    sessionInfo.setPubKeySeqNum(o());
                                    sessionInfo.setConnectionTimeoutMs(b.ACCS_RECEIVE_TIMEOUT);
                                    r10.z = r10.y.createSession(sessionInfo);
                                    c(2);
                                    r10.H.connection_stop_date = 0;
                                    r10.A.wait();
                                }
                                str2 = d();
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(r10.c);
                                stringBuilder.append(" connect with proxy:");
                                stringBuilder.append(r10.q);
                                stringBuilder.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                stringBuilder.append(r10.r);
                                ALog.e(str2, stringBuilder.toString(), new Object[0]);
                                str3 = r10.o;
                                i2 = r10.p;
                                stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(m());
                                stringBuilder3.append("_");
                                stringBuilder3.append(r10.b);
                                String stringBuilder4 = stringBuilder3.toString();
                                String str4 = r10.q;
                                int i3 = r10.r;
                                String str5 = r10.N;
                                sessionInfo = r16;
                                sessionInfo.setPubKeySeqNum(o());
                                sessionInfo.setConnectionTimeoutMs(b.ACCS_RECEIVE_TIMEOUT);
                                r10.z = r10.y.createSession(sessionInfo);
                                c(2);
                                r10.H.connection_stop_date = 0;
                                r10.A.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                r10.J = false;
                            }
                        }
                    } catch (Exception e22) {
                        exception.printStackTrace();
                    } finally {
                        exception = e22;
                    }
                }
            }
        }
    }

    private int o() {
        boolean k = k();
        int i = 0;
        if (AccsClientConfig.mEnv != 2) {
            int channelPubKey = this.i.getChannelPubKey();
            if (channelPubKey > 0) {
                ALog.i(d(), "use custom pub key", new Object[]{"pubKey", Integer.valueOf(channelPubKey)});
                return channelPubKey;
            }
            i = k ? 4 : 3;
        }
        return i;
    }

    private void p() {
        if (this.z == null) {
            c(3);
            return;
        }
        String appsign;
        try {
            String encode = URLEncoder.encode(UtilityImpl.getDeviceId(this.d));
            appsign = UtilityImpl.getAppsign(this.d, i(), this.i.getAppSecret(), UtilityImpl.getDeviceId(this.d), this.m);
            String c = c(this.w);
            String d = d();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.c);
            stringBuilder.append(" auth URL:");
            stringBuilder.append(c);
            ALog.e(d, stringBuilder.toString(), new Object[0]);
            this.x = c;
            if (a(encode, i(), appsign)) {
                URL url = new URL(c);
                SpdyRequest spdyRequest = new SpdyRequest(new URL(c), "GET", RequestPriority.DEFAULT_PRIORITY, 80000, b.ACCS_RECEIVE_TIMEOUT);
                spdyRequest.setDomain(m());
                this.z.submitRequest(spdyRequest, new SpdyDataProvider(null), m(), this);
                return;
            }
            encode = d();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.c);
            stringBuilder2.append(" auth param error!");
            ALog.e(encode, stringBuilder2.toString(), new Object[0]);
            d(-6);
        } catch (Throwable th) {
            appsign = d();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.c);
            stringBuilder3.append(" auth exception ");
            ALog.e(appsign, stringBuilder3.toString(), th, new Object[0]);
            d(-7);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
        r11 = this;
        r0 = r11.d;
        r0 = com.taobao.accs.utl.l.a(r0);
        r1 = 2;
        r2 = 1;
        if (r0 != r1) goto L_0x000b;
    L_0x000a:
        return r2;
    L_0x000b:
        r0 = android.text.TextUtils.isEmpty(r12);
        r3 = 0;
        if (r0 != 0) goto L_0x001e;
    L_0x0012:
        r0 = android.text.TextUtils.isEmpty(r13);
        if (r0 != 0) goto L_0x001e;
    L_0x0018:
        r0 = android.text.TextUtils.isEmpty(r14);
        if (r0 == 0) goto L_0x00a1;
    L_0x001e:
        r0 = 3;
        r11.c(r0);
        r12 = android.text.TextUtils.isEmpty(r12);
        if (r12 == 0) goto L_0x002a;
    L_0x0028:
        r0 = r2;
        goto L_0x0038;
    L_0x002a:
        r12 = android.text.TextUtils.isEmpty(r13);
        if (r12 == 0) goto L_0x0032;
    L_0x0030:
        r0 = r1;
        goto L_0x0038;
    L_0x0032:
        r12 = android.text.TextUtils.isEmpty(r14);
        if (r12 == 0) goto L_0x0028;
    L_0x0038:
        r12 = r11.H;
        r12.setFailReason(r0);
        r12 = r11.H;
        r12.onConnectStop();
        r12 = r11.c;
        if (r12 != 0) goto L_0x0049;
    L_0x0046:
        r12 = "service";
        goto L_0x004b;
    L_0x0049:
        r12 = "inapp";
    L_0x004b:
        r13 = r11.u;
        if (r13 == 0) goto L_0x0054;
    L_0x004f:
        r13 = r11.u;
        r13 = r13.a;
        goto L_0x0055;
    L_0x0054:
        r13 = r3;
    L_0x0055:
        r4 = com.taobao.accs.utl.UTMini.getInstance();
        r5 = 66001; // 0x101d1 float:9.2487E-41 double:3.2609E-319;
        r14 = new java.lang.StringBuilder;
        r6 = "DISCONNECT ";
        r14.<init>(r6);
        r14.append(r12);
        r6 = r14.toString();
        r7 = java.lang.Integer.valueOf(r0);
        r8 = java.lang.Integer.valueOf(r13);
        r12 = 221; // 0xdd float:3.1E-43 double:1.09E-321;
        r9 = java.lang.Integer.valueOf(r12);
        r10 = new java.lang.String[r1];
        r12 = r11.x;
        r10[r3] = r12;
        r12 = r11.K;
        r10[r2] = r12;
        r4.commitEvent(r5, r6, r7, r8, r9, r10);
        r12 = "accs";
        r14 = "connect";
        r1 = new java.lang.StringBuilder;
        r2 = "retrytimes:";
        r1.<init>(r2);
        r1.append(r13);
        r13 = r1.toString();
        r0 = java.lang.String.valueOf(r0);
        r1 = "";
        com.taobao.accs.utl.b.a(r12, r14, r13, r0, r1);
        r2 = r3;
    L_0x00a1:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.r.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private synchronized void q() {
        if (this.c != 1) {
            this.B = System.currentTimeMillis();
            this.C = System.nanoTime();
            g.a(this.d).a();
        }
    }

    private synchronized void c(int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.d();	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r1.<init>();	 Catch:{ all -> 0x00ed }
        r2 = r6.c;	 Catch:{ all -> 0x00ed }
        r1.append(r2);	 Catch:{ all -> 0x00ed }
        r2 = " notifyStatus:";	 Catch:{ all -> 0x00ed }
        r1.append(r2);	 Catch:{ all -> 0x00ed }
        r2 = r6.a(r7);	 Catch:{ all -> 0x00ed }
        r1.append(r2);	 Catch:{ all -> 0x00ed }
        r1 = r1.toString();	 Catch:{ all -> 0x00ed }
        r2 = 0;	 Catch:{ all -> 0x00ed }
        r3 = new java.lang.Object[r2];	 Catch:{ all -> 0x00ed }
        com.taobao.accs.utl.ALog.e(r0, r1, r3);	 Catch:{ all -> 0x00ed }
        r0 = r6.s;	 Catch:{ all -> 0x00ed }
        if (r7 != r0) goto L_0x0047;	 Catch:{ all -> 0x00ed }
    L_0x0029:
        r7 = r6.d();	 Catch:{ all -> 0x00ed }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r0.<init>();	 Catch:{ all -> 0x00ed }
        r1 = r6.c;	 Catch:{ all -> 0x00ed }
        r0.append(r1);	 Catch:{ all -> 0x00ed }
        r1 = " ignore notifyStatus";	 Catch:{ all -> 0x00ed }
        r0.append(r1);	 Catch:{ all -> 0x00ed }
        r0 = r0.toString();	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.Object[r2];	 Catch:{ all -> 0x00ed }
        com.taobao.accs.utl.ALog.i(r7, r0, r1);	 Catch:{ all -> 0x00ed }
        monitor-exit(r6);
        return;
    L_0x0047:
        r6.s = r7;	 Catch:{ all -> 0x00ed }
        r0 = 1;	 Catch:{ all -> 0x00ed }
        switch(r7) {
            case 1: goto L_0x0091;
            case 2: goto L_0x0074;
            case 3: goto L_0x004f;
            case 4: goto L_0x00c3;
            default: goto L_0x004d;
        };	 Catch:{ all -> 0x00ed }
    L_0x004d:
        goto L_0x00c3;	 Catch:{ all -> 0x00ed }
    L_0x004f:
        r6.q();	 Catch:{ all -> 0x00ed }
        r1 = r6.d;	 Catch:{ all -> 0x00ed }
        r1 = com.taobao.accs.net.g.a(r1);	 Catch:{ all -> 0x00ed }
        r1.d();	 Catch:{ all -> 0x00ed }
        r1 = r6.A;	 Catch:{ all -> 0x00ed }
        monitor-enter(r1);	 Catch:{ all -> 0x00ed }
        r3 = r6.A;	 Catch:{ Exception -> 0x0066 }
        r3.notifyAll();	 Catch:{ Exception -> 0x0066 }
        goto L_0x0066;
    L_0x0064:
        r7 = move-exception;
        goto L_0x0072;
    L_0x0066:
        monitor-exit(r1);	 Catch:{ all -> 0x0064 }
        r1 = r6.e;	 Catch:{ all -> 0x00ed }
        r3 = -10;	 Catch:{ all -> 0x00ed }
        r1.a(r3);	 Catch:{ all -> 0x00ed }
        r6.a(r2, r0);	 Catch:{ all -> 0x00ed }
        goto L_0x00c3;
    L_0x0072:
        monitor-exit(r1);	 Catch:{ all -> 0x0064 }
        throw r7;	 Catch:{ all -> 0x00ed }
    L_0x0074:
        r1 = r6.n;	 Catch:{ all -> 0x00ed }
        if (r1 == 0) goto L_0x007d;	 Catch:{ all -> 0x00ed }
    L_0x0078:
        r1 = r6.n;	 Catch:{ all -> 0x00ed }
        r1.cancel(r0);	 Catch:{ all -> 0x00ed }
    L_0x007d:
        r0 = r6.N;	 Catch:{ all -> 0x00ed }
        r1 = com.taobao.accs.common.ThreadPoolExecutorFactory.getScheduledExecutor();	 Catch:{ all -> 0x00ed }
        r3 = new com.taobao.accs.net.t;	 Catch:{ all -> 0x00ed }
        r3.<init>(r6, r0);	 Catch:{ all -> 0x00ed }
        r4 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;	 Catch:{ all -> 0x00ed }
        r0 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00ed }
        r1.schedule(r3, r4, r0);	 Catch:{ all -> 0x00ed }
        goto L_0x00c3;	 Catch:{ all -> 0x00ed }
    L_0x0091:
        r1 = r6.d;	 Catch:{ all -> 0x00ed }
        r1 = com.taobao.accs.net.g.a(r1);	 Catch:{ all -> 0x00ed }
        r1.f();	 Catch:{ all -> 0x00ed }
        r6.q();	 Catch:{ all -> 0x00ed }
        r1 = r6.n;	 Catch:{ all -> 0x00ed }
        if (r1 == 0) goto L_0x00a6;	 Catch:{ all -> 0x00ed }
    L_0x00a1:
        r1 = r6.n;	 Catch:{ all -> 0x00ed }
        r1.cancel(r0);	 Catch:{ all -> 0x00ed }
    L_0x00a6:
        r0 = r6.A;	 Catch:{ all -> 0x00ed }
        monitor-enter(r0);	 Catch:{ all -> 0x00ed }
        r1 = r6.A;	 Catch:{ Exception -> 0x00b1 }
        r1.notifyAll();	 Catch:{ Exception -> 0x00b1 }
        goto L_0x00b1;
    L_0x00af:
        r7 = move-exception;
        goto L_0x00c1;
    L_0x00b1:
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        r0 = r6.t;	 Catch:{ all -> 0x00ed }
        monitor-enter(r0);	 Catch:{ all -> 0x00ed }
        r1 = r6.t;	 Catch:{ Exception -> 0x00bd }
        r1.notifyAll();	 Catch:{ Exception -> 0x00bd }
        goto L_0x00bd;
    L_0x00bb:
        r7 = move-exception;
        goto L_0x00bf;
    L_0x00bd:
        monitor-exit(r0);	 Catch:{ all -> 0x00bb }
        goto L_0x00c3;	 Catch:{ all -> 0x00bb }
    L_0x00bf:
        monitor-exit(r0);	 Catch:{ all -> 0x00bb }
        throw r7;	 Catch:{ all -> 0x00ed }
    L_0x00c1:
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        throw r7;	 Catch:{ all -> 0x00ed }
    L_0x00c3:
        r0 = r6.d();	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r1.<init>();	 Catch:{ all -> 0x00ed }
        r3 = r6.c;	 Catch:{ all -> 0x00ed }
        r1.append(r3);	 Catch:{ all -> 0x00ed }
        r3 = " notifyStatus:";	 Catch:{ all -> 0x00ed }
        r1.append(r3);	 Catch:{ all -> 0x00ed }
        r7 = r6.a(r7);	 Catch:{ all -> 0x00ed }
        r1.append(r7);	 Catch:{ all -> 0x00ed }
        r7 = " handled";	 Catch:{ all -> 0x00ed }
        r1.append(r7);	 Catch:{ all -> 0x00ed }
        r7 = r1.toString();	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.Object[r2];	 Catch:{ all -> 0x00ed }
        com.taobao.accs.utl.ALog.i(r0, r7, r1);	 Catch:{ all -> 0x00ed }
        monitor-exit(r6);
        return;
    L_0x00ed:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.r.c(int):void");
    }

    public String m() {
        String channelHost = this.i.getChannelHost();
        String d = d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(" getChannelHost:");
        stringBuilder.append(channelHost);
        ALog.i(d, stringBuilder.toString(), new Object[0]);
        return channelHost == null ? "" : channelHost;
    }

    private void r() {
        try {
            SpdyAgent.enableDebug = true;
            this.y = SpdyAgent.getInstance(this.d, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (SpdyAgent.checkLoadSucc()) {
                f.a();
                if (!k()) {
                    this.y.setAccsSslCallback(new u(this));
                }
                if (!i.a(false)) {
                    String str = this.c == 0 ? NotificationCompat.CATEGORY_SERVICE : "inapp";
                    ALog.d(d(), "into--[setTnetLogPath]", new Object[0]);
                    Object tnetLogFilePath = UtilityImpl.getTnetLogFilePath(this.d, str);
                    String d = d();
                    StringBuilder stringBuilder = new StringBuilder("config tnet log path:");
                    stringBuilder.append(tnetLogFilePath);
                    ALog.d(d, stringBuilder.toString(), new Object[0]);
                    if (!TextUtils.isEmpty(tnetLogFilePath)) {
                        this.y.configLogFile(tnetLogFilePath, UtilityImpl.TNET_FILE_SIZE, 5);
                    }
                }
                return;
            }
            ALog.e(d(), "loadSoFail", new Object[0]);
            f.b();
        } catch (Throwable th) {
            ALog.e(d(), "loadSoFail", th, new Object[0]);
        }
    }

    public boolean n() {
        return this.v;
    }

    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        String d;
        StringBuilder stringBuilder;
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (SpdySession spdySession2) {
                d = d();
                stringBuilder = new StringBuilder("session cleanUp has exception: ");
                stringBuilder.append(spdySession2);
                ALog.e(d, stringBuilder.toString(), new Object[0]);
            }
        }
        spdySession2 = this.u != null ? this.u.a : null;
        d = d();
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(" spdySessionFailedError, retryTimes:");
        stringBuilder.append(spdySession2);
        stringBuilder.append(" errorId:");
        stringBuilder.append(i);
        ALog.e(d, stringBuilder.toString(), new Object[0]);
        this.J = false;
        this.L = true;
        c(3);
        this.H.setFailReason(i);
        this.H.onConnectStop();
        String str = this.c == 0 ? NotificationCompat.CATEGORY_SERVICE : "inapp";
        UTMini instance = UTMini.getInstance();
        StringBuilder stringBuilder2 = new StringBuilder("DISCONNECT ");
        stringBuilder2.append(str);
        instance.commitEvent(66001, stringBuilder2.toString(), Integer.valueOf(i), Integer.valueOf(spdySession2), Integer.valueOf(221), new String[]{this.x, this.K});
        d = BaseMonitor.ALARM_POINT_CONNECT;
        stringBuilder = new StringBuilder("retrytimes:");
        stringBuilder.append(spdySession2);
        b.a("accs", d, stringBuilder.toString(), String.valueOf(i), "");
    }

    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.F = superviseConnectInfo.connectTime;
        spdySession = superviseConnectInfo.handshakeTime;
        String d = d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(" spdySessionConnectCB sessionConnectInterval:");
        stringBuilder.append(this.F);
        stringBuilder.append(" sslTime:");
        stringBuilder.append(spdySession);
        stringBuilder.append(" reuse:");
        stringBuilder.append(superviseConnectInfo.sessionTicketReused);
        ALog.e(d, stringBuilder.toString(), new Object[0]);
        p();
        this.H.setRet(true);
        this.H.onConnectStop();
        this.H.tcp_time = (long) this.F;
        this.H.ssl_time = (long) spdySession;
        d = this.c == 0 ? NotificationCompat.CATEGORY_SERVICE : "inapp";
        UTMini instance = UTMini.getInstance();
        StringBuilder stringBuilder2 = new StringBuilder("CONNECTED ");
        stringBuilder2.append(d);
        stringBuilder2.append(" ");
        stringBuilder2.append(superviseConnectInfo.sessionTicketReused);
        instance.commitEvent(66001, stringBuilder2.toString(), String.valueOf(this.F), String.valueOf(spdySession), Integer.valueOf(221), new String[]{String.valueOf(superviseConnectInfo.sessionTicketReused), this.x, this.K});
        b.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "");
    }

    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        obj = d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(" spdySessionCloseCallback, errorCode:");
        stringBuilder.append(i);
        ALog.e(obj, stringBuilder.toString(), new Object[0]);
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (SpdySession spdySession2) {
                obj = d();
                stringBuilder = new StringBuilder("session cleanUp has exception: ");
                stringBuilder.append(spdySession2);
                ALog.e(obj, stringBuilder.toString(), new Object[0]);
            }
        }
        c(3);
        this.H.onCloseConnect();
        if (this.H.getConCloseDate() > null && this.H.getConStopDate() > null) {
            this.H.getConCloseDate();
            this.H.getConStopDate();
        }
        spdySession2 = new StringBuilder();
        spdySession2.append(this.H.getCloseReason());
        spdySession2.append("tnet error:");
        spdySession2.append(i);
        this.H.setCloseReason(spdySession2.toString());
        if (superviseConnectInfo != null) {
            this.H.live_time = (long) superviseConnectInfo.keepalive_period_second;
        }
        AppMonitor.getInstance().commitStat(this.H);
        for (Message message : this.e.e()) {
            if (message.e() != null) {
                message.e().setFailReason("session close");
                AppMonitor.getInstance().commitStat(message.e());
            }
        }
        spdySession2 = this.c == null ? NotificationCompat.CATEGORY_SERVICE : "inapp";
        obj = d();
        superviseConnectInfo = new StringBuilder("spdySessionCloseCallback, conKeepTime:");
        superviseConnectInfo.append(this.H.live_time);
        superviseConnectInfo.append(" connectType:");
        superviseConnectInfo.append(spdySession2);
        ALog.d(obj, superviseConnectInfo.toString(), new Object[0]);
        UTMini instance = UTMini.getInstance();
        obj = new StringBuilder("DISCONNECT CLOSE ");
        obj.append(spdySession2);
        instance.commitEvent(66001, obj.toString(), Integer.valueOf(i), Long.valueOf(this.H.live_time), Integer.valueOf(221), new String[]{this.x, this.K});
    }

    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        spdySession = d();
        obj = new StringBuilder("spdyPingRecvCallback uniId:");
        obj.append(j);
        ALog.d(spdySession, obj.toString(), new Object[0]);
        if (j >= 0) {
            this.e.b();
            g.a(this.d).e();
            g.a(this.d).a();
            this.H.onPingCBReceive();
            if (this.H.ping_rec_times % 2 == null) {
                UtilityImpl.setServiceTime(this.d, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
            }
        }
    }

    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        q();
        spdySession = d();
        obj = new StringBuilder();
        obj.append(this.c);
        obj.append(" onFrame, type:");
        obj.append(i2);
        obj.append(" len:");
        obj.append(bArr.length);
        ALog.e(spdySession, obj.toString(), new Object[0]);
        spdySession = "";
        if (ALog.isPrintLog(Level.D) != null && bArr.length < 512) {
            StringBuilder stringBuilder;
            i3 = System.currentTimeMillis();
            obj = spdySession;
            for (byte b : bArr) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(obj);
                stringBuilder.append(Integer.toHexString(255 & b));
                stringBuilder.append(" ");
                obj = stringBuilder.toString();
            }
            spdySession = d();
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" log time:");
            stringBuilder.append(System.currentTimeMillis() - i3);
            ALog.d(spdySession, stringBuilder.toString(), new Object[0]);
        }
        if (i2 == 200) {
            try {
                spdySession = System.currentTimeMillis();
                this.e.a(bArr);
                i2 = this.e.f();
                if (i2 != 0) {
                    i2.c = String.valueOf(spdySession);
                    i2.g = this.c == null ? NotificationCompat.CATEGORY_SERVICE : "inapp";
                    i2.commitUT();
                }
            } catch (SpdySession spdySession2) {
                ALog.e(d(), "onDataReceive ", spdySession2, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "SERVICE_DATA_RECEIVE", UtilityImpl.getStackMsg(spdySession2));
            }
            ALog.d(d(), "try handle msg", new Object[0]);
            g();
        } else {
            spdySession2 = d();
            obj = new StringBuilder();
            obj.append(this.c);
            obj.append(" drop frame len:");
            obj.append(bArr.length);
            ALog.e(spdySession2, obj.toString(), new Object[0]);
        }
        ALog.d(d(), "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
        ALog.d(d(), "spdyStreamCloseCallback", new Object[0]);
        if (i != 0) {
            ALog.e(d(), "spdyStreamCloseCallback", new Object[]{"statusCode", Integer.valueOf(i)});
            d(i);
        }
    }

    public void spdyRequestRecvCallback(SpdySession spdySession, long j, Object obj) {
        ALog.d(d(), "spdyRequestRecvCallback", new Object[0]);
    }

    public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
        this.B = System.currentTimeMillis();
        this.C = System.nanoTime();
        try {
            j = UtilityImpl.getHeader(map);
            int parseInt = Integer.parseInt((String) j.get(HttpConstant.STATUS));
            map = d();
            obj = new StringBuilder();
            obj.append(this.c);
            obj.append(" spdyOnStreamResponse httpStatusCode: ");
            obj.append(parseInt);
            ALog.e(map, obj.toString(), new Object[0]);
            if (parseInt == 200) {
                c(1);
                String str = (String) j.get("x-at");
                if (TextUtils.isEmpty(str) == null) {
                    this.k = str;
                }
                j = this.H;
                long j2 = 0;
                if (this.H.connection_stop_date > null) {
                    j2 = System.currentTimeMillis() - this.H.connection_stop_date;
                }
                j.auth_time = j2;
                j = this.c == null ? NotificationCompat.CATEGORY_SERVICE : "inapp";
                UTMini instance = UTMini.getInstance();
                map = new StringBuilder("CONNECTED 200 ");
                map.append(j);
                instance.commitEvent(66001, map.toString(), this.x, this.K, Integer.valueOf(221), new String[]{"0"});
                b.a("accs", "auth", "");
            } else {
                d(parseInt);
            }
        } catch (long j3) {
            ALog.e(d(), j3.toString(), new Object[0]);
            l();
            this.H.setCloseReason("exception");
        }
        ALog.d(d(), "spdyOnStreamResponse", new Object[0]);
    }

    private void d(int i) {
        this.k = null;
        l();
        int i2 = this.u != null ? this.u.a : 0;
        SessionMonitor sessionMonitor = this.H;
        StringBuilder stringBuilder = new StringBuilder("code not 200 is");
        stringBuilder.append(i);
        sessionMonitor.setCloseReason(stringBuilder.toString());
        this.L = true;
        String str = this.c == 0 ? NotificationCompat.CATEGORY_SERVICE : "inapp";
        UTMini instance = UTMini.getInstance();
        StringBuilder stringBuilder2 = new StringBuilder("CONNECTED NO 200 ");
        stringBuilder2.append(str);
        instance.commitEvent(66001, stringBuilder2.toString(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(221), new String[]{this.x, this.K});
        b.a("accs", "auth", "", String.valueOf(i), "");
    }

    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        ALog.d(d(), "spdyDataSendCallback", new Object[0]);
    }

    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        ALog.d(d(), "spdyDataRecvCallback", new Object[0]);
    }

    public void b() {
        this.J = false;
        this.f = 0;
    }

    public void bioPingRecvCallback(SpdySession spdySession, int i) {
        spdySession = d();
        StringBuilder stringBuilder = new StringBuilder("bioPingRecvCallback uniId:");
        stringBuilder.append(i);
        ALog.w(spdySession, stringBuilder.toString(), new Object[0]);
    }

    protected void a(String str, String str2) {
        try {
            c(4);
            l();
            this.H.setCloseReason(str2);
        } catch (String str3) {
            str3.printStackTrace();
        }
    }

    public boolean a(String str) {
        boolean z;
        synchronized (this.t) {
            z = true;
            for (int size = this.t.size() - 1; size >= 0; size--) {
                Message message = (Message) this.t.get(size);
                if (message != null && message.a() == 1 && message.M != null && message.M.equals(str)) {
                    this.t.remove(size);
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public byte[] getSSLMeta(SpdySession spdySession) {
        return UtilityImpl.SecurityGuardGetSslTicket2(this.d, this.m, this.b, spdySession.getDomain());
    }

    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        return UtilityImpl.SecurityGuardPutSslTicket2(this.d, this.m, this.b, spdySession.getDomain(), bArr);
    }

    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
        ALog.d(d(), "spdyDataChunkRecvCB", new Object[0]);
    }

    protected String d() {
        StringBuilder stringBuilder = new StringBuilder("SilenceConn_");
        stringBuilder.append(this.m);
        return stringBuilder.toString();
    }

    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        b(i);
    }

    protected void a(Context context) {
        if (!this.g) {
            super.a(context);
            GlobalAppRuntimeInfo.setBackground(false);
            this.g = true;
            ALog.e(d(), "init awcn success!", new Object[0]);
        }
    }
}
