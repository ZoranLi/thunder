package com.taobao.accs.ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import anet.channel.statist.StatObject;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
public class TrafficsMonitor {
    private Map<String, List<a>> a = new HashMap();
    private Map<String, String> b = new HashMap<String, String>(this) {
        final /* synthetic */ TrafficsMonitor a;

        {
            this.a = r2;
            put(IXAdRequestInfo.IMSI, "512");
            put("motu", "513");
            put("acds", "514");
            put(GlobalClientInfo.AGOO_SERVICE_ID, "515");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "515");
            put("agooTokenReport", "515");
            put("accsSelf", Constants.DEFAULT_UIN);
        }
    };
    private int c = 0;
    private Context d;
    private String e = "";

    /* compiled from: Taobao */
    public static class a {
        String a;
        String b;
        String c;
        boolean d;
        String e;
        long f;

        public a(String str, boolean z, String str2, long j) {
            this.c = str;
            this.d = z;
            this.e = str2;
            this.f = j;
        }

        public a(String str, String str2, String str3, boolean z, String str4, long j) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = str4;
            this.f = j;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder("date:");
            stringBuilder2.append(this.a);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(" ");
            stringBuilder2 = new StringBuilder("bizId:");
            stringBuilder2.append(this.b);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(" ");
            stringBuilder2 = new StringBuilder("serviceId:");
            stringBuilder2.append(this.c);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(" ");
            stringBuilder2 = new StringBuilder("host:");
            stringBuilder2.append(this.e);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(" ");
            stringBuilder2 = new StringBuilder("isBackground:");
            stringBuilder2.append(this.d);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(" ");
            stringBuilder2 = new StringBuilder("size:");
            stringBuilder2.append(this.f);
            stringBuilder.append(stringBuilder2.toString());
            return stringBuilder.toString();
        }
    }

    @Monitor(module = "NetworkSDK", monitorPoint = "TrafficStats")
    /* compiled from: Taobao */
    public static class StatTrafficMonitor extends BaseMonitor {
        @Dimension
        public String bizId;
        @Dimension
        public String date;
        @Dimension
        public String host;
        @Dimension
        public boolean isBackground;
        @Dimension
        public String serviceId;
        @Measure
        public long size;
    }

    public TrafficsMonitor(Context context) {
        this.d = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.taobao.accs.ut.monitor.TrafficsMonitor.a r14) {
        /*
        r13 = this;
        if (r14 == 0) goto L_0x00bf;
    L_0x0002:
        r0 = r14.e;
        if (r0 == 0) goto L_0x00bf;
    L_0x0006:
        r0 = r14.f;
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x00bf;
    L_0x000e:
        r0 = r14.c;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0019;
    L_0x0016:
        r0 = "accsSelf";
        goto L_0x001b;
    L_0x0019:
        r0 = r14.c;
    L_0x001b:
        r14.c = r0;
        r0 = r13.a;
        monitor-enter(r0);
        r1 = r13.b;	 Catch:{ all -> 0x00bc }
        r2 = r14.c;	 Catch:{ all -> 0x00bc }
        r1 = r1.get(r2);	 Catch:{ all -> 0x00bc }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x00bc }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x00bc }
        if (r2 == 0) goto L_0x0032;
    L_0x0030:
        monitor-exit(r0);	 Catch:{ all -> 0x00bc }
        return;
    L_0x0032:
        r14.b = r1;	 Catch:{ all -> 0x00bc }
        r2 = com.taobao.accs.utl.ALog.Level.D;	 Catch:{ all -> 0x00bc }
        r2 = com.taobao.accs.utl.ALog.isPrintLog(r2);	 Catch:{ all -> 0x00bc }
        r3 = 0;
        if (r2 == 0) goto L_0x0060;
    L_0x003d:
        r2 = "TrafficsMonitor";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bc }
        r5 = "addTrafficInfo count:";
        r4.<init>(r5);	 Catch:{ all -> 0x00bc }
        r5 = r13.c;	 Catch:{ all -> 0x00bc }
        r4.append(r5);	 Catch:{ all -> 0x00bc }
        r5 = " ";
        r4.append(r5);	 Catch:{ all -> 0x00bc }
        r5 = r14.toString();	 Catch:{ all -> 0x00bc }
        r4.append(r5);	 Catch:{ all -> 0x00bc }
        r4 = r4.toString();	 Catch:{ all -> 0x00bc }
        r5 = new java.lang.Object[r3];	 Catch:{ all -> 0x00bc }
        com.taobao.accs.utl.ALog.d(r2, r4, r5);	 Catch:{ all -> 0x00bc }
    L_0x0060:
        r2 = r13.a;	 Catch:{ all -> 0x00bc }
        r2 = r2.get(r1);	 Catch:{ all -> 0x00bc }
        r2 = (java.util.List) r2;	 Catch:{ all -> 0x00bc }
        r4 = 1;
        if (r2 == 0) goto L_0x009f;
    L_0x006b:
        r5 = r2.iterator();	 Catch:{ all -> 0x00bc }
    L_0x006f:
        r6 = r5.hasNext();	 Catch:{ all -> 0x00bc }
        if (r6 == 0) goto L_0x0098;
    L_0x0075:
        r6 = r5.next();	 Catch:{ all -> 0x00bc }
        r6 = (com.taobao.accs.ut.monitor.TrafficsMonitor.a) r6;	 Catch:{ all -> 0x00bc }
        r7 = r6.d;	 Catch:{ all -> 0x00bc }
        r8 = r14.d;	 Catch:{ all -> 0x00bc }
        if (r7 != r8) goto L_0x006f;
    L_0x0081:
        r7 = r6.e;	 Catch:{ all -> 0x00bc }
        if (r7 == 0) goto L_0x006f;
    L_0x0085:
        r7 = r6.e;	 Catch:{ all -> 0x00bc }
        r8 = r14.e;	 Catch:{ all -> 0x00bc }
        r7 = r7.equals(r8);	 Catch:{ all -> 0x00bc }
        if (r7 == 0) goto L_0x006f;
    L_0x008f:
        r7 = r6.f;	 Catch:{ all -> 0x00bc }
        r9 = r14.f;	 Catch:{ all -> 0x00bc }
        r11 = r7 + r9;
        r6.f = r11;	 Catch:{ all -> 0x00bc }
        goto L_0x0099;
    L_0x0098:
        r3 = r4;
    L_0x0099:
        if (r3 == 0) goto L_0x00a7;
    L_0x009b:
        r2.add(r14);	 Catch:{ all -> 0x00bc }
        goto L_0x00a7;
    L_0x009f:
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x00bc }
        r2.<init>();	 Catch:{ all -> 0x00bc }
        r2.add(r14);	 Catch:{ all -> 0x00bc }
    L_0x00a7:
        r14 = r13.a;	 Catch:{ all -> 0x00bc }
        r14.put(r1, r2);	 Catch:{ all -> 0x00bc }
        r14 = r13.c;	 Catch:{ all -> 0x00bc }
        r14 = r14 + r4;
        r13.c = r14;	 Catch:{ all -> 0x00bc }
        monitor-exit(r0);	 Catch:{ all -> 0x00bc }
        r14 = r13.c;
        r0 = 10;
        if (r14 < r0) goto L_0x00bf;
    L_0x00b8:
        r13.b();
        goto L_0x00bf;
    L_0x00bc:
        r14 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00bc }
        throw r14;
    L_0x00bf:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.ut.monitor.TrafficsMonitor.a(com.taobao.accs.ut.monitor.TrafficsMonitor$a):void");
    }

    private void b() {
        synchronized (this.a) {
            String str;
            int i;
            String formatDay = UtilityImpl.formatDay(System.currentTimeMillis());
            if (TextUtils.isEmpty(this.e) || this.e.equals(formatDay)) {
                str = formatDay;
                i = 0;
            } else {
                str = this.e;
                i = 1;
            }
            for (String str2 : this.a.keySet()) {
                for (a aVar : (List) this.a.get(str2)) {
                    if (aVar != null) {
                        com.taobao.accs.c.a.a(this.d).a(aVar.e, aVar.c, (String) this.b.get(aVar.c), aVar.d, aVar.f, str);
                    }
                }
            }
            if (ALog.isPrintLog(Level.D)) {
                StringBuilder stringBuilder = new StringBuilder("savetoDay:");
                stringBuilder.append(str);
                stringBuilder.append(" saveTraffics");
                stringBuilder.append(this.a.toString());
                ALog.d("TrafficsMonitor", stringBuilder.toString(), new Object[0]);
            }
            if (i != 0) {
                this.a.clear();
                c();
            } else if (ALog.isPrintLog(Level.D)) {
                StringBuilder stringBuilder2 = new StringBuilder("no need commit lastsaveDay:");
                stringBuilder2.append(this.e);
                stringBuilder2.append(" currday:");
                stringBuilder2.append(formatDay);
                ALog.d("TrafficsMonitor", stringBuilder2.toString(), new Object[0]);
            }
            this.e = formatDay;
            this.c = 0;
        }
    }

    public void a() {
        try {
            synchronized (this.a) {
                this.a.clear();
            }
            List<a> a = com.taobao.accs.c.a.a(this.d).a(true);
            if (a != null) {
                for (a a2 : a) {
                    a(a2);
                }
            }
        } catch (Exception e) {
            ALog.w("TrafficsMonitor", e.toString(), new Object[0]);
        }
    }

    private void c() {
        List<a> a = com.taobao.accs.c.a.a(this.d).a(false);
        if (a != null) {
            try {
                for (a aVar : a) {
                    if (aVar != null) {
                        StatObject statTrafficMonitor = new StatTrafficMonitor();
                        statTrafficMonitor.bizId = aVar.b;
                        statTrafficMonitor.date = aVar.a;
                        statTrafficMonitor.host = aVar.e;
                        statTrafficMonitor.isBackground = aVar.d;
                        statTrafficMonitor.size = aVar.f;
                        AppMonitor.getInstance().commitStat(statTrafficMonitor);
                    }
                }
                com.taobao.accs.c.a.a(this.d).a();
            } catch (Throwable th) {
                ALog.e("", th.toString(), new Object[0]);
                th.printStackTrace();
            }
        }
    }
}
