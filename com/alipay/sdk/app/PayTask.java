package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.data.c;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.h;
import com.alipay.sdk.util.i;
import com.alipay.sdk.util.k;
import java.util.HashMap;
import java.util.Map;

public class PayTask {
    static final Object a = e.class;
    private Activity b;
    private com.alipay.sdk.widget.a c;
    private String d = "wappaygw.alipay.com/service/rest.htm";
    private String e = "mclient.alipay.com/service/rest.htm";
    private String f = "mclient.alipay.com/home/exterfaceAssign.htm";
    private Map<String, a> g = new HashMap();

    private class a {
        String a;
        String b;
        final /* synthetic */ PayTask c;

        private a(PayTask payTask) {
            this.c = payTask;
            this.a = "";
            this.b = "";
        }

        private String a() {
            return this.a;
        }

        private void a(String str) {
            this.a = str;
        }

        private String b() {
            return this.b;
        }

        private void b(String str) {
            this.b = str;
        }
    }

    public String getVersion() {
        return com.alipay.sdk.cons.a.e;
    }

    public PayTask(Activity activity) {
        this.b = activity;
        b a = b.a();
        Context context = this.b;
        c.a();
        a.a(context);
        com.alipay.sdk.app.statistic.a.a(activity);
        this.c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.b);
    }

    public synchronized java.lang.String pay(java.lang.String r10, boolean r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        monitor-enter(r9);
        if (r11 == 0) goto L_0x000a;
    L_0x0003:
        r9.b();	 Catch:{ all -> 0x0007 }
        goto L_0x000a;
    L_0x0007:
        r10 = move-exception;
        goto L_0x0121;
    L_0x000a:
        r11 = new com.alipay.sdk.sys.a;	 Catch:{ Throwable -> 0x00fa }
        r0 = r9.b;	 Catch:{ Throwable -> 0x00fa }
        r11.<init>(r0);	 Catch:{ Throwable -> 0x00fa }
        r11 = r11.a(r10);	 Catch:{ Throwable -> 0x00fa }
        r0 = "paymethod=\"expressGateway\"";	 Catch:{ Throwable -> 0x00fa }
        r0 = r11.contains(r0);	 Catch:{ Throwable -> 0x00fa }
        r1 = 0;	 Catch:{ Throwable -> 0x00fa }
        if (r0 != 0) goto L_0x004b;	 Catch:{ Throwable -> 0x00fa }
    L_0x001e:
        r0 = r9.b;	 Catch:{ Throwable -> 0x00fa }
        r0 = com.alipay.sdk.util.k.b(r0);	 Catch:{ Throwable -> 0x00fa }
        if (r0 == 0) goto L_0x004b;	 Catch:{ Throwable -> 0x00fa }
    L_0x0026:
        r0 = new com.alipay.sdk.util.e;	 Catch:{ Throwable -> 0x00fa }
        r2 = r9.b;	 Catch:{ Throwable -> 0x00fa }
        r3 = new com.alipay.sdk.app.g;	 Catch:{ Throwable -> 0x00fa }
        r3.<init>(r9);	 Catch:{ Throwable -> 0x00fa }
        r0.<init>(r2, r3);	 Catch:{ Throwable -> 0x00fa }
        r2 = r0.a(r11);	 Catch:{ Throwable -> 0x00fa }
        r0.a = r1;	 Catch:{ Throwable -> 0x00fa }
        r0 = "failed";	 Catch:{ Throwable -> 0x00fa }
        r0 = android.text.TextUtils.equals(r2, r0);	 Catch:{ Throwable -> 0x00fa }
        if (r0 != 0) goto L_0x004b;	 Catch:{ Throwable -> 0x00fa }
    L_0x0040:
        r11 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x00fa }
        if (r11 == 0) goto L_0x004f;	 Catch:{ Throwable -> 0x00fa }
    L_0x0046:
        r2 = com.alipay.sdk.app.h.a();	 Catch:{ Throwable -> 0x00fa }
        goto L_0x004f;	 Catch:{ Throwable -> 0x00fa }
    L_0x004b:
        r2 = r9.b(r11);	 Catch:{ Throwable -> 0x00fa }
    L_0x004f:
        r11 = r9.b;	 Catch:{ Throwable -> 0x00fa }
        r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x0059;	 Catch:{ Throwable -> 0x00de }
    L_0x0057:
        goto L_0x00d2;	 Catch:{ Throwable -> 0x00de }
    L_0x0059:
        r0 = ";";	 Catch:{ Throwable -> 0x00de }
        r0 = r2.split(r0);	 Catch:{ Throwable -> 0x00de }
        r3 = 0;	 Catch:{ Throwable -> 0x00de }
        r4 = r1;	 Catch:{ Throwable -> 0x00de }
        r1 = r3;	 Catch:{ Throwable -> 0x00de }
    L_0x0062:
        r5 = r0.length;	 Catch:{ Throwable -> 0x00de }
        if (r1 >= r5) goto L_0x00d1;	 Catch:{ Throwable -> 0x00de }
    L_0x0065:
        r5 = r0[r1];	 Catch:{ Throwable -> 0x00de }
        r6 = "result={";	 Catch:{ Throwable -> 0x00de }
        r5 = r5.startsWith(r6);	 Catch:{ Throwable -> 0x00de }
        if (r5 == 0) goto L_0x00ce;	 Catch:{ Throwable -> 0x00de }
    L_0x006f:
        r5 = r0[r1];	 Catch:{ Throwable -> 0x00de }
        r6 = "}";	 Catch:{ Throwable -> 0x00de }
        r5 = r5.endsWith(r6);	 Catch:{ Throwable -> 0x00de }
        if (r5 == 0) goto L_0x00ce;	 Catch:{ Throwable -> 0x00de }
    L_0x0079:
        r5 = r0[r1];	 Catch:{ Throwable -> 0x00de }
        r6 = 8;	 Catch:{ Throwable -> 0x00de }
        r7 = r0[r1];	 Catch:{ Throwable -> 0x00de }
        r7 = r7.length();	 Catch:{ Throwable -> 0x00de }
        r7 = r7 + -1;	 Catch:{ Throwable -> 0x00de }
        r5 = r5.substring(r6, r7);	 Catch:{ Throwable -> 0x00de }
        r6 = "&";	 Catch:{ Throwable -> 0x00de }
        r5 = r5.split(r6);	 Catch:{ Throwable -> 0x00de }
        r6 = r3;	 Catch:{ Throwable -> 0x00de }
    L_0x0090:
        r7 = r5.length;	 Catch:{ Throwable -> 0x00de }
        if (r6 >= r7) goto L_0x00ce;	 Catch:{ Throwable -> 0x00de }
    L_0x0093:
        r7 = r5[r6];	 Catch:{ Throwable -> 0x00de }
        r8 = "trade_token=\"";	 Catch:{ Throwable -> 0x00de }
        r7 = r7.startsWith(r8);	 Catch:{ Throwable -> 0x00de }
        if (r7 == 0) goto L_0x00b8;	 Catch:{ Throwable -> 0x00de }
    L_0x009d:
        r7 = r5[r6];	 Catch:{ Throwable -> 0x00de }
        r8 = "\"";	 Catch:{ Throwable -> 0x00de }
        r7 = r7.endsWith(r8);	 Catch:{ Throwable -> 0x00de }
        if (r7 == 0) goto L_0x00b8;	 Catch:{ Throwable -> 0x00de }
    L_0x00a7:
        r4 = r5[r6];	 Catch:{ Throwable -> 0x00de }
        r7 = 13;	 Catch:{ Throwable -> 0x00de }
        r5 = r5[r6];	 Catch:{ Throwable -> 0x00de }
        r5 = r5.length();	 Catch:{ Throwable -> 0x00de }
        r5 = r5 + -1;	 Catch:{ Throwable -> 0x00de }
        r4 = r4.substring(r7, r5);	 Catch:{ Throwable -> 0x00de }
        goto L_0x00ce;	 Catch:{ Throwable -> 0x00de }
    L_0x00b8:
        r7 = r5[r6];	 Catch:{ Throwable -> 0x00de }
        r8 = "trade_token=";	 Catch:{ Throwable -> 0x00de }
        r7 = r7.startsWith(r8);	 Catch:{ Throwable -> 0x00de }
        if (r7 == 0) goto L_0x00cb;	 Catch:{ Throwable -> 0x00de }
    L_0x00c2:
        r4 = r5[r6];	 Catch:{ Throwable -> 0x00de }
        r5 = 12;	 Catch:{ Throwable -> 0x00de }
        r4 = r4.substring(r5);	 Catch:{ Throwable -> 0x00de }
        goto L_0x00ce;	 Catch:{ Throwable -> 0x00de }
    L_0x00cb:
        r6 = r6 + 1;	 Catch:{ Throwable -> 0x00de }
        goto L_0x0090;	 Catch:{ Throwable -> 0x00de }
    L_0x00ce:
        r1 = r1 + 1;	 Catch:{ Throwable -> 0x00de }
        goto L_0x0062;	 Catch:{ Throwable -> 0x00de }
    L_0x00d1:
        r1 = r4;	 Catch:{ Throwable -> 0x00de }
    L_0x00d2:
        r0 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x00de }
        if (r0 != 0) goto L_0x00e6;	 Catch:{ Throwable -> 0x00de }
    L_0x00d8:
        r0 = "pref_trade_token";	 Catch:{ Throwable -> 0x00de }
        com.alipay.sdk.util.i.a(r11, r0, r1);	 Catch:{ Throwable -> 0x00de }
        goto L_0x00e6;
    L_0x00de:
        r11 = move-exception;
        r0 = "biz";	 Catch:{ Throwable -> 0x00fa }
        r1 = "SaveTradeTokenError";	 Catch:{ Throwable -> 0x00fa }
        com.alipay.sdk.app.statistic.a.a(r0, r1, r11);	 Catch:{ Throwable -> 0x00fa }
    L_0x00e6:
        r11 = com.alipay.sdk.data.a.b();	 Catch:{ all -> 0x0007 }
        r0 = r9.b;	 Catch:{ all -> 0x0007 }
        r11.a(r0);	 Catch:{ all -> 0x0007 }
        r9.c();	 Catch:{ all -> 0x0007 }
        r11 = r9.b;	 Catch:{ all -> 0x0007 }
    L_0x00f4:
        com.alipay.sdk.app.statistic.a.a(r11, r10);	 Catch:{ all -> 0x0007 }
        goto L_0x010d;
    L_0x00f8:
        r11 = move-exception;
        goto L_0x010f;
    L_0x00fa:
        r2 = com.alipay.sdk.app.h.a();	 Catch:{ all -> 0x00f8 }
        r11 = com.alipay.sdk.data.a.b();	 Catch:{ all -> 0x0007 }
        r0 = r9.b;	 Catch:{ all -> 0x0007 }
        r11.a(r0);	 Catch:{ all -> 0x0007 }
        r9.c();	 Catch:{ all -> 0x0007 }
        r11 = r9.b;	 Catch:{ all -> 0x0007 }
        goto L_0x00f4;
    L_0x010d:
        monitor-exit(r9);
        return r2;
    L_0x010f:
        r0 = com.alipay.sdk.data.a.b();	 Catch:{ all -> 0x0007 }
        r1 = r9.b;	 Catch:{ all -> 0x0007 }
        r0.a(r1);	 Catch:{ all -> 0x0007 }
        r9.c();	 Catch:{ all -> 0x0007 }
        r0 = r9.b;	 Catch:{ all -> 0x0007 }
        com.alipay.sdk.app.statistic.a.a(r0, r10);	 Catch:{ all -> 0x0007 }
        throw r11;	 Catch:{ all -> 0x0007 }
    L_0x0121:
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.pay(java.lang.String, boolean):java.lang.String");
    }

    public synchronized String fetchTradeToken() {
        return i.b(this.b, h.a, "");
    }

    public synchronized java.lang.String fetchOrderInfoFromH5PayUrl(java.lang.String r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Throwable -> 0x02f8 }
        if (r0 != 0) goto L_0x02f8;	 Catch:{ Throwable -> 0x02f8 }
    L_0x0007:
        r0 = r12.trim();	 Catch:{ Throwable -> 0x02f8 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r2 = "https://";	 Catch:{ Throwable -> 0x02f8 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = r11.d;	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02f8 }
        r1 = r0.startsWith(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r1 != 0) goto L_0x0037;	 Catch:{ Throwable -> 0x02f8 }
    L_0x0021:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r2 = "http://";	 Catch:{ Throwable -> 0x02f8 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = r11.d;	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02f8 }
        r1 = r0.startsWith(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r1 == 0) goto L_0x009c;	 Catch:{ Throwable -> 0x02f8 }
    L_0x0037:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r2 = "(http|https)://";	 Catch:{ Throwable -> 0x02f8 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = r11.d;	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = "\\?";	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02f8 }
        r2 = "";	 Catch:{ Throwable -> 0x02f8 }
        r1 = r0.replaceFirst(r1, r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.trim();	 Catch:{ Throwable -> 0x02f8 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r2 != 0) goto L_0x009c;	 Catch:{ Throwable -> 0x02f8 }
    L_0x005c:
        r12 = com.alipay.sdk.util.k.a(r1);	 Catch:{ Throwable -> 0x02f8 }
        r0 = "req_data";	 Catch:{ Throwable -> 0x02f8 }
        r12 = r12.get(r0);	 Catch:{ Throwable -> 0x02f8 }
        r12 = (java.lang.String) r12;	 Catch:{ Throwable -> 0x02f8 }
        r0 = "<request_token>";	 Catch:{ Throwable -> 0x02f8 }
        r1 = "</request_token>";	 Catch:{ Throwable -> 0x02f8 }
        r12 = com.alipay.sdk.util.k.a(r0, r1, r12);	 Catch:{ Throwable -> 0x02f8 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r1 = "_input_charset=\"utf-8\"&ordertoken=\"";	 Catch:{ Throwable -> 0x02f8 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r12);	 Catch:{ Throwable -> 0x02f8 }
        r12 = "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"";	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r12);	 Catch:{ Throwable -> 0x02f8 }
        r12 = new com.alipay.sdk.sys.a;	 Catch:{ Throwable -> 0x02f8 }
        r1 = r11.b;	 Catch:{ Throwable -> 0x02f8 }
        r12.<init>(r1);	 Catch:{ Throwable -> 0x02f8 }
        r1 = "sc";	 Catch:{ Throwable -> 0x02f8 }
        r2 = "h5tonative";	 Catch:{ Throwable -> 0x02f8 }
        r12 = r12.a(r1, r2);	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r12);	 Catch:{ Throwable -> 0x02f8 }
        r12 = "\"";	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r12);	 Catch:{ Throwable -> 0x02f8 }
        r12 = r0.toString();	 Catch:{ Throwable -> 0x02f8 }
        monitor-exit(r11);
        return r12;
    L_0x009c:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r2 = "https://";	 Catch:{ Throwable -> 0x02f8 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = r11.e;	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02f8 }
        r1 = r0.startsWith(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r1 != 0) goto L_0x00c8;	 Catch:{ Throwable -> 0x02f8 }
    L_0x00b2:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r2 = "http://";	 Catch:{ Throwable -> 0x02f8 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = r11.e;	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02f8 }
        r1 = r0.startsWith(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r1 == 0) goto L_0x012d;	 Catch:{ Throwable -> 0x02f8 }
    L_0x00c8:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r2 = "(http|https)://";	 Catch:{ Throwable -> 0x02f8 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = r11.e;	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = "\\?";	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02f8 }
        r2 = "";	 Catch:{ Throwable -> 0x02f8 }
        r1 = r0.replaceFirst(r1, r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.trim();	 Catch:{ Throwable -> 0x02f8 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r2 != 0) goto L_0x012d;	 Catch:{ Throwable -> 0x02f8 }
    L_0x00ed:
        r12 = com.alipay.sdk.util.k.a(r1);	 Catch:{ Throwable -> 0x02f8 }
        r0 = "req_data";	 Catch:{ Throwable -> 0x02f8 }
        r12 = r12.get(r0);	 Catch:{ Throwable -> 0x02f8 }
        r12 = (java.lang.String) r12;	 Catch:{ Throwable -> 0x02f8 }
        r0 = "<request_token>";	 Catch:{ Throwable -> 0x02f8 }
        r1 = "</request_token>";	 Catch:{ Throwable -> 0x02f8 }
        r12 = com.alipay.sdk.util.k.a(r0, r1, r12);	 Catch:{ Throwable -> 0x02f8 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r1 = "_input_charset=\"utf-8\"&ordertoken=\"";	 Catch:{ Throwable -> 0x02f8 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r12);	 Catch:{ Throwable -> 0x02f8 }
        r12 = "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"";	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r12);	 Catch:{ Throwable -> 0x02f8 }
        r12 = new com.alipay.sdk.sys.a;	 Catch:{ Throwable -> 0x02f8 }
        r1 = r11.b;	 Catch:{ Throwable -> 0x02f8 }
        r12.<init>(r1);	 Catch:{ Throwable -> 0x02f8 }
        r1 = "sc";	 Catch:{ Throwable -> 0x02f8 }
        r2 = "h5tonative";	 Catch:{ Throwable -> 0x02f8 }
        r12 = r12.a(r1, r2);	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r12);	 Catch:{ Throwable -> 0x02f8 }
        r12 = "\"";	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r12);	 Catch:{ Throwable -> 0x02f8 }
        r12 = r0.toString();	 Catch:{ Throwable -> 0x02f8 }
        monitor-exit(r11);
        return r12;
    L_0x012d:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r2 = "https://";	 Catch:{ Throwable -> 0x02f8 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = r11.f;	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02f8 }
        r1 = r0.startsWith(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r1 != 0) goto L_0x0159;	 Catch:{ Throwable -> 0x02f8 }
    L_0x0143:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r2 = "http://";	 Catch:{ Throwable -> 0x02f8 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = r11.f;	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02f8 }
        r1 = r0.startsWith(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r1 == 0) goto L_0x01b8;	 Catch:{ Throwable -> 0x02f8 }
    L_0x0159:
        r1 = "alipay.wap.create.direct.pay.by.user";	 Catch:{ Throwable -> 0x02f8 }
        r1 = r0.contains(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r1 == 0) goto L_0x01b8;	 Catch:{ Throwable -> 0x02f8 }
    L_0x0161:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r2 = "(http|https)://";	 Catch:{ Throwable -> 0x02f8 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = r11.f;	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = "\\?";	 Catch:{ Throwable -> 0x02f8 }
        r1.append(r2);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02f8 }
        r2 = "";	 Catch:{ Throwable -> 0x02f8 }
        r0 = r0.replaceFirst(r1, r2);	 Catch:{ Throwable -> 0x02f8 }
        r0 = r0.trim();	 Catch:{ Throwable -> 0x02f8 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x02f8 }
        if (r0 != 0) goto L_0x01b8;
    L_0x0186:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x01b8 }
        r0.<init>();	 Catch:{ Throwable -> 0x01b8 }
        r1 = "url";	 Catch:{ Throwable -> 0x01b8 }
        r0.put(r1, r12);	 Catch:{ Throwable -> 0x01b8 }
        r1 = "bizcontext";	 Catch:{ Throwable -> 0x01b8 }
        r2 = new com.alipay.sdk.sys.a;	 Catch:{ Throwable -> 0x01b8 }
        r3 = r11.b;	 Catch:{ Throwable -> 0x01b8 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x01b8 }
        r3 = "sc";	 Catch:{ Throwable -> 0x01b8 }
        r4 = "h5tonative";	 Catch:{ Throwable -> 0x01b8 }
        r2 = r2.a(r3, r4);	 Catch:{ Throwable -> 0x01b8 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x01b8 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01b8 }
        r2 = "new_external_info==";	 Catch:{ Throwable -> 0x01b8 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x01b8 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x01b8 }
        r1.append(r0);	 Catch:{ Throwable -> 0x01b8 }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x01b8 }
        monitor-exit(r11);
        return r0;
    L_0x01b8:
        r0 = "^(http|https)://(maliprod\\.alipay\\.com\\/w\\/trade_pay\\.do.?|mali\\.alipay\\.com\\/w\\/trade_pay\\.do.?|mclient\\.alipay\\.com\\/w\\/trade_pay\\.do.?)";	 Catch:{ Throwable -> 0x02f8 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ Throwable -> 0x02f8 }
        r0 = r0.matcher(r12);	 Catch:{ Throwable -> 0x02f8 }
        r0 = r0.find();	 Catch:{ Throwable -> 0x02f8 }
        if (r0 == 0) goto L_0x02f8;	 Catch:{ Throwable -> 0x02f8 }
    L_0x01c8:
        r0 = "?";	 Catch:{ Throwable -> 0x02f8 }
        r1 = "";	 Catch:{ Throwable -> 0x02f8 }
        r12 = com.alipay.sdk.util.k.a(r0, r1, r12);	 Catch:{ Throwable -> 0x02f8 }
        r0 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Throwable -> 0x02f8 }
        if (r0 != 0) goto L_0x02f8;	 Catch:{ Throwable -> 0x02f8 }
    L_0x01d6:
        r12 = com.alipay.sdk.util.k.a(r12);	 Catch:{ Throwable -> 0x02f8 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r0.<init>();	 Catch:{ Throwable -> 0x02f8 }
        r1 = 0;	 Catch:{ Throwable -> 0x02f8 }
        r2 = 1;	 Catch:{ Throwable -> 0x02f8 }
        r3 = "trade_no";	 Catch:{ Throwable -> 0x02f8 }
        r7 = 2;	 Catch:{ Throwable -> 0x02f8 }
        r6 = new java.lang.String[r7];	 Catch:{ Throwable -> 0x02f8 }
        r4 = "trade_no";	 Catch:{ Throwable -> 0x02f8 }
        r8 = 0;	 Catch:{ Throwable -> 0x02f8 }
        r6[r8] = r4;	 Catch:{ Throwable -> 0x02f8 }
        r4 = "alipay_trade_no";	 Catch:{ Throwable -> 0x02f8 }
        r9 = 1;	 Catch:{ Throwable -> 0x02f8 }
        r6[r9] = r4;	 Catch:{ Throwable -> 0x02f8 }
        r4 = r0;	 Catch:{ Throwable -> 0x02f8 }
        r5 = r12;	 Catch:{ Throwable -> 0x02f8 }
        r1 = a(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x02f8 }
        if (r1 == 0) goto L_0x02f8;	 Catch:{ Throwable -> 0x02f8 }
    L_0x01f8:
        r1 = 1;	 Catch:{ Throwable -> 0x02f8 }
        r2 = 0;	 Catch:{ Throwable -> 0x02f8 }
        r3 = "pay_phase_id";	 Catch:{ Throwable -> 0x02f8 }
        r10 = 3;	 Catch:{ Throwable -> 0x02f8 }
        r6 = new java.lang.String[r10];	 Catch:{ Throwable -> 0x02f8 }
        r4 = "payPhaseId";	 Catch:{ Throwable -> 0x02f8 }
        r6[r8] = r4;	 Catch:{ Throwable -> 0x02f8 }
        r4 = "pay_phase_id";	 Catch:{ Throwable -> 0x02f8 }
        r6[r9] = r4;	 Catch:{ Throwable -> 0x02f8 }
        r4 = "out_relation_id";	 Catch:{ Throwable -> 0x02f8 }
        r6[r7] = r4;	 Catch:{ Throwable -> 0x02f8 }
        r4 = r0;	 Catch:{ Throwable -> 0x02f8 }
        r5 = r12;	 Catch:{ Throwable -> 0x02f8 }
        a(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x02f8 }
        r1 = "&biz_sub_type=\"TRADE\"";	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r1);	 Catch:{ Throwable -> 0x02f8 }
        r1 = "&biz_type=\"trade\"";	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r1);	 Catch:{ Throwable -> 0x02f8 }
        r1 = "app_name";	 Catch:{ Throwable -> 0x02f8 }
        r1 = r12.get(r1);	 Catch:{ Throwable -> 0x02f8 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x02f8 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r2 == 0) goto L_0x0239;	 Catch:{ Throwable -> 0x02f8 }
    L_0x0228:
        r2 = "cid";	 Catch:{ Throwable -> 0x02f8 }
        r2 = r12.get(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = (java.lang.CharSequence) r2;	 Catch:{ Throwable -> 0x02f8 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x02f8 }
        if (r2 != 0) goto L_0x0239;	 Catch:{ Throwable -> 0x02f8 }
    L_0x0236:
        r1 = "ali1688";	 Catch:{ Throwable -> 0x02f8 }
        goto L_0x025d;	 Catch:{ Throwable -> 0x02f8 }
    L_0x0239:
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x02f8 }
        if (r2 == 0) goto L_0x025d;	 Catch:{ Throwable -> 0x02f8 }
    L_0x023f:
        r2 = "sid";	 Catch:{ Throwable -> 0x02f8 }
        r2 = r12.get(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = (java.lang.CharSequence) r2;	 Catch:{ Throwable -> 0x02f8 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x02f8 }
        if (r2 == 0) goto L_0x025b;	 Catch:{ Throwable -> 0x02f8 }
    L_0x024d:
        r2 = "s_id";	 Catch:{ Throwable -> 0x02f8 }
        r2 = r12.get(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = (java.lang.CharSequence) r2;	 Catch:{ Throwable -> 0x02f8 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x02f8 }
        if (r2 != 0) goto L_0x025d;	 Catch:{ Throwable -> 0x02f8 }
    L_0x025b:
        r1 = "tb";	 Catch:{ Throwable -> 0x02f8 }
    L_0x025d:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r3 = "&app_name=\"";	 Catch:{ Throwable -> 0x02f8 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x02f8 }
        r2.append(r1);	 Catch:{ Throwable -> 0x02f8 }
        r1 = "\"";	 Catch:{ Throwable -> 0x02f8 }
        r2.append(r1);	 Catch:{ Throwable -> 0x02f8 }
        r1 = r2.toString();	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r1);	 Catch:{ Throwable -> 0x02f8 }
        r1 = 1;	 Catch:{ Throwable -> 0x02f8 }
        r2 = 1;	 Catch:{ Throwable -> 0x02f8 }
        r3 = "extern_token";	 Catch:{ Throwable -> 0x02f8 }
        r4 = 4;	 Catch:{ Throwable -> 0x02f8 }
        r6 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x02f8 }
        r4 = "extern_token";	 Catch:{ Throwable -> 0x02f8 }
        r6[r8] = r4;	 Catch:{ Throwable -> 0x02f8 }
        r4 = "cid";	 Catch:{ Throwable -> 0x02f8 }
        r6[r9] = r4;	 Catch:{ Throwable -> 0x02f8 }
        r4 = "sid";	 Catch:{ Throwable -> 0x02f8 }
        r6[r7] = r4;	 Catch:{ Throwable -> 0x02f8 }
        r4 = "s_id";	 Catch:{ Throwable -> 0x02f8 }
        r6[r10] = r4;	 Catch:{ Throwable -> 0x02f8 }
        r4 = r0;	 Catch:{ Throwable -> 0x02f8 }
        r5 = r12;	 Catch:{ Throwable -> 0x02f8 }
        r1 = a(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x02f8 }
        if (r1 != 0) goto L_0x0296;	 Catch:{ Throwable -> 0x02f8 }
    L_0x0292:
        r12 = "";	 Catch:{ Throwable -> 0x02f8 }
        monitor-exit(r11);
        return r12;
    L_0x0296:
        r1 = 1;
        r2 = 0;
        r3 = "appenv";	 Catch:{ Throwable -> 0x02f8 }
        r6 = new java.lang.String[r9];	 Catch:{ Throwable -> 0x02f8 }
        r4 = "appenv";	 Catch:{ Throwable -> 0x02f8 }
        r6[r8] = r4;	 Catch:{ Throwable -> 0x02f8 }
        r4 = r0;	 Catch:{ Throwable -> 0x02f8 }
        r5 = r12;	 Catch:{ Throwable -> 0x02f8 }
        a(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x02f8 }
        r1 = "&pay_channel_id=\"alipay_sdk\"";	 Catch:{ Throwable -> 0x02f8 }
        r0.append(r1);	 Catch:{ Throwable -> 0x02f8 }
        r1 = new com.alipay.sdk.app.PayTask$a;	 Catch:{ Throwable -> 0x02f8 }
        r1.<init>();	 Catch:{ Throwable -> 0x02f8 }
        r2 = "return_url";	 Catch:{ Throwable -> 0x02f8 }
        r2 = r12.get(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x02f8 }
        r1.a = r2;	 Catch:{ Throwable -> 0x02f8 }
        r2 = "pay_order_id";	 Catch:{ Throwable -> 0x02f8 }
        r12 = r12.get(r2);	 Catch:{ Throwable -> 0x02f8 }
        r12 = (java.lang.String) r12;	 Catch:{ Throwable -> 0x02f8 }
        r1.b = r12;	 Catch:{ Throwable -> 0x02f8 }
        r12 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02f8 }
        r12.<init>();	 Catch:{ Throwable -> 0x02f8 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x02f8 }
        r12.append(r0);	 Catch:{ Throwable -> 0x02f8 }
        r0 = "&bizcontext=\"";	 Catch:{ Throwable -> 0x02f8 }
        r12.append(r0);	 Catch:{ Throwable -> 0x02f8 }
        r0 = new com.alipay.sdk.sys.a;	 Catch:{ Throwable -> 0x02f8 }
        r2 = r11.b;	 Catch:{ Throwable -> 0x02f8 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x02f8 }
        r2 = "sc";	 Catch:{ Throwable -> 0x02f8 }
        r3 = "h5tonative";	 Catch:{ Throwable -> 0x02f8 }
        r0 = r0.a(r2, r3);	 Catch:{ Throwable -> 0x02f8 }
        r12.append(r0);	 Catch:{ Throwable -> 0x02f8 }
        r0 = "\"";	 Catch:{ Throwable -> 0x02f8 }
        r12.append(r0);	 Catch:{ Throwable -> 0x02f8 }
        r12 = r12.toString();	 Catch:{ Throwable -> 0x02f8 }
        r0 = r11.g;	 Catch:{ Throwable -> 0x02f8 }
        r0.put(r12, r1);	 Catch:{ Throwable -> 0x02f8 }
        monitor-exit(r11);
        return r12;
    L_0x02f6:
        r12 = move-exception;
        goto L_0x02fc;
    L_0x02f8:
        r12 = "";	 Catch:{ all -> 0x02f6 }
        monitor-exit(r11);
        return r12;
    L_0x02fc:
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.fetchOrderInfoFromH5PayUrl(java.lang.String):java.lang.String");
    }

    private static boolean a(boolean z, boolean z2, String str, StringBuilder stringBuilder, Map<String, String> map, String... strArr) {
        String str2 = "";
        for (Object obj : strArr) {
            if (!TextUtils.isEmpty((CharSequence) map.get(obj))) {
                str2 = (String) map.get(obj);
                break;
            }
        }
        if (TextUtils.isEmpty(str2) != null) {
            if (z2) {
                return false;
            }
        } else if (z) {
            stringBuilder.append("&");
            stringBuilder.append(str);
            stringBuilder.append("=\"");
            stringBuilder.append(str2);
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(str);
            stringBuilder.append("=\"");
            stringBuilder.append(str2);
            stringBuilder.append("\"");
        }
        return true;
    }

    public synchronized com.alipay.sdk.util.H5PayResultModel h5Pay(java.lang.String r10, boolean r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = new com.alipay.sdk.util.H5PayResultModel;	 Catch:{ all -> 0x013d }
        r0.<init>();	 Catch:{ all -> 0x013d }
        r10.trim();	 Catch:{ Throwable -> 0x013b }
        r11 = r9.pay(r10, r11);	 Catch:{ Throwable -> 0x013b }
        r1 = ";";	 Catch:{ Throwable -> 0x013b }
        r11 = r11.split(r1);	 Catch:{ Throwable -> 0x013b }
        r1 = new java.util.HashMap;	 Catch:{ Throwable -> 0x013b }
        r1.<init>();	 Catch:{ Throwable -> 0x013b }
        r2 = r11.length;	 Catch:{ Throwable -> 0x013b }
        r3 = 0;	 Catch:{ Throwable -> 0x013b }
        r4 = r3;	 Catch:{ Throwable -> 0x013b }
    L_0x001b:
        if (r4 >= r2) goto L_0x0053;	 Catch:{ Throwable -> 0x013b }
    L_0x001d:
        r5 = r11[r4];	 Catch:{ Throwable -> 0x013b }
        r6 = "={";	 Catch:{ Throwable -> 0x013b }
        r6 = r5.indexOf(r6);	 Catch:{ Throwable -> 0x013b }
        r6 = r5.substring(r3, r6);	 Catch:{ Throwable -> 0x013b }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x013b }
        r7.<init>();	 Catch:{ Throwable -> 0x013b }
        r7.append(r6);	 Catch:{ Throwable -> 0x013b }
        r8 = "={";	 Catch:{ Throwable -> 0x013b }
        r7.append(r8);	 Catch:{ Throwable -> 0x013b }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x013b }
        r8 = r5.indexOf(r7);	 Catch:{ Throwable -> 0x013b }
        r7 = r7.length();	 Catch:{ Throwable -> 0x013b }
        r8 = r8 + r7;	 Catch:{ Throwable -> 0x013b }
        r7 = "}";	 Catch:{ Throwable -> 0x013b }
        r7 = r5.lastIndexOf(r7);	 Catch:{ Throwable -> 0x013b }
        r5 = r5.substring(r8, r7);	 Catch:{ Throwable -> 0x013b }
        r1.put(r6, r5);	 Catch:{ Throwable -> 0x013b }
        r4 = r4 + 1;	 Catch:{ Throwable -> 0x013b }
        goto L_0x001b;	 Catch:{ Throwable -> 0x013b }
    L_0x0053:
        r11 = "resultStatus";	 Catch:{ Throwable -> 0x013b }
        r11 = r1.containsKey(r11);	 Catch:{ Throwable -> 0x013b }
        if (r11 == 0) goto L_0x0066;	 Catch:{ Throwable -> 0x013b }
    L_0x005b:
        r11 = "resultStatus";	 Catch:{ Throwable -> 0x013b }
        r11 = r1.get(r11);	 Catch:{ Throwable -> 0x013b }
        r11 = (java.lang.String) r11;	 Catch:{ Throwable -> 0x013b }
        r0.setResultCode(r11);	 Catch:{ Throwable -> 0x013b }
    L_0x0066:
        r11 = "callBackUrl";	 Catch:{ Throwable -> 0x013b }
        r11 = r1.containsKey(r11);	 Catch:{ Throwable -> 0x013b }
        if (r11 == 0) goto L_0x007b;	 Catch:{ Throwable -> 0x013b }
    L_0x006e:
        r10 = "callBackUrl";	 Catch:{ Throwable -> 0x013b }
        r10 = r1.get(r10);	 Catch:{ Throwable -> 0x013b }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x013b }
        r0.setReturnUrl(r10);	 Catch:{ Throwable -> 0x013b }
        goto L_0x013b;	 Catch:{ Throwable -> 0x013b }
    L_0x007b:
        r11 = "result";	 Catch:{ Throwable -> 0x013b }
        r11 = r1.containsKey(r11);	 Catch:{ Throwable -> 0x013b }
        if (r11 == 0) goto L_0x013b;	 Catch:{ Throwable -> 0x013b }
    L_0x0083:
        r11 = "result";	 Catch:{ Throwable -> 0x013b }
        r11 = r1.get(r11);	 Catch:{ Throwable -> 0x013b }
        r11 = (java.lang.String) r11;	 Catch:{ Throwable -> 0x013b }
        r1 = r11.length();	 Catch:{ Throwable -> 0x013b }
        r2 = 15;	 Catch:{ Throwable -> 0x013b }
        if (r1 <= r2) goto L_0x0125;	 Catch:{ Throwable -> 0x013b }
    L_0x0093:
        r1 = r9.g;	 Catch:{ Throwable -> 0x013b }
        r1 = r1.get(r10);	 Catch:{ Throwable -> 0x013b }
        r1 = (com.alipay.sdk.app.PayTask.a) r1;	 Catch:{ Throwable -> 0x013b }
        if (r1 == 0) goto L_0x00c3;	 Catch:{ Throwable -> 0x013b }
    L_0x009d:
        r11 = r1.b;	 Catch:{ Throwable -> 0x013b }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ Throwable -> 0x013b }
        if (r11 == 0) goto L_0x00ab;	 Catch:{ Throwable -> 0x013b }
    L_0x00a5:
        r11 = r1.a;	 Catch:{ Throwable -> 0x013b }
        r0.setReturnUrl(r11);	 Catch:{ Throwable -> 0x013b }
        goto L_0x00bc;	 Catch:{ Throwable -> 0x013b }
    L_0x00ab:
        r11 = com.alipay.sdk.data.a.b();	 Catch:{ Throwable -> 0x013b }
        r11 = r11.j;	 Catch:{ Throwable -> 0x013b }
        r2 = "$OrderId$";	 Catch:{ Throwable -> 0x013b }
        r1 = r1.b;	 Catch:{ Throwable -> 0x013b }
        r11 = r11.replace(r2, r1);	 Catch:{ Throwable -> 0x013b }
        r0.setReturnUrl(r11);	 Catch:{ Throwable -> 0x013b }
    L_0x00bc:
        r11 = r9.g;	 Catch:{ Throwable -> 0x013b }
        r11.remove(r10);	 Catch:{ Throwable -> 0x013b }
        monitor-exit(r9);
        return r0;
    L_0x00c3:
        r10 = "&callBackUrl=\"";	 Catch:{ Throwable -> 0x013b }
        r1 = "\"";	 Catch:{ Throwable -> 0x013b }
        r10 = com.alipay.sdk.util.k.a(r10, r1, r11);	 Catch:{ Throwable -> 0x013b }
        r1 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x013b }
        if (r1 == 0) goto L_0x010f;	 Catch:{ Throwable -> 0x013b }
    L_0x00d1:
        r10 = "&call_back_url=\"";	 Catch:{ Throwable -> 0x013b }
        r1 = "\"";	 Catch:{ Throwable -> 0x013b }
        r10 = com.alipay.sdk.util.k.a(r10, r1, r11);	 Catch:{ Throwable -> 0x013b }
        r1 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x013b }
        if (r1 == 0) goto L_0x010f;	 Catch:{ Throwable -> 0x013b }
    L_0x00df:
        r10 = "&return_url=\"";	 Catch:{ Throwable -> 0x013b }
        r1 = "\"";	 Catch:{ Throwable -> 0x013b }
        r10 = com.alipay.sdk.util.k.a(r10, r1, r11);	 Catch:{ Throwable -> 0x013b }
        r1 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x013b }
        if (r1 == 0) goto L_0x010f;	 Catch:{ Throwable -> 0x013b }
    L_0x00ed:
        r10 = "&return_url=";	 Catch:{ Throwable -> 0x013b }
        r1 = "&";	 Catch:{ Throwable -> 0x013b }
        r10 = com.alipay.sdk.util.k.a(r10, r1, r11);	 Catch:{ Throwable -> 0x013b }
        r1 = "utf-8";	 Catch:{ Throwable -> 0x013b }
        r10 = java.net.URLDecoder.decode(r10, r1);	 Catch:{ Throwable -> 0x013b }
        r1 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x013b }
        if (r1 == 0) goto L_0x010f;	 Catch:{ Throwable -> 0x013b }
    L_0x0101:
        r10 = "&callBackUrl=";	 Catch:{ Throwable -> 0x013b }
        r1 = "&";	 Catch:{ Throwable -> 0x013b }
        r10 = com.alipay.sdk.util.k.a(r10, r1, r11);	 Catch:{ Throwable -> 0x013b }
        r11 = "utf-8";	 Catch:{ Throwable -> 0x013b }
        r10 = java.net.URLDecoder.decode(r10, r11);	 Catch:{ Throwable -> 0x013b }
    L_0x010f:
        r11 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x013b }
        if (r11 == 0) goto L_0x011b;	 Catch:{ Throwable -> 0x013b }
    L_0x0115:
        r10 = com.alipay.sdk.data.a.b();	 Catch:{ Throwable -> 0x013b }
        r10 = r10.j;	 Catch:{ Throwable -> 0x013b }
    L_0x011b:
        r11 = "utf-8";	 Catch:{ Throwable -> 0x013b }
        r10 = java.net.URLDecoder.decode(r10, r11);	 Catch:{ Throwable -> 0x013b }
        r0.setReturnUrl(r10);	 Catch:{ Throwable -> 0x013b }
        goto L_0x013b;	 Catch:{ Throwable -> 0x013b }
    L_0x0125:
        r11 = r9.g;	 Catch:{ Throwable -> 0x013b }
        r11 = r11.get(r10);	 Catch:{ Throwable -> 0x013b }
        r11 = (com.alipay.sdk.app.PayTask.a) r11;	 Catch:{ Throwable -> 0x013b }
        if (r11 == 0) goto L_0x013b;	 Catch:{ Throwable -> 0x013b }
    L_0x012f:
        r11 = r11.a;	 Catch:{ Throwable -> 0x013b }
        r0.setReturnUrl(r11);	 Catch:{ Throwable -> 0x013b }
        r11 = r9.g;	 Catch:{ Throwable -> 0x013b }
        r11.remove(r10);	 Catch:{ Throwable -> 0x013b }
        monitor-exit(r9);
        return r0;
    L_0x013b:
        monitor-exit(r9);
        return r0;
    L_0x013d:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.h5Pay(java.lang.String, boolean):com.alipay.sdk.util.H5PayResultModel");
    }

    private static String a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("={");
        str2 = stringBuilder.toString();
        return str.substring(str.indexOf(str2) + str2.length(), str.lastIndexOf(h.d));
    }

    private com.alipay.sdk.util.e.a a() {
        return new g(this);
    }

    private void b() {
        if (this.c != null) {
            this.c.a();
        }
    }

    private void c() {
        if (this.c != null) {
            this.c.b();
        }
    }

    private String a(String str) {
        str = new com.alipay.sdk.sys.a(this.b).a(str);
        if (str.contains("paymethod=\"expressGateway\"")) {
            return b(str);
        }
        if (!k.b(this.b)) {
            return b(str);
        }
        e eVar = new e(this.b, new g(this));
        Object a = eVar.a(str);
        eVar.a = null;
        if (TextUtils.equals(a, e.b)) {
            return b(str);
        }
        return TextUtils.isEmpty(a) != null ? h.a() : a;
    }

    private java.lang.String b(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r8.b();
        r0 = new com.alipay.sdk.packet.impl.d;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r0.<init>();	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r1 = r8.b;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r9 = r0.a(r1, r9);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r9 = r9.a();	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r0 = "form";	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r9 = r9.optJSONObject(r0);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r0 = "onload";	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r9 = r9.optJSONObject(r0);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r9 = com.alipay.sdk.protocol.b.a(r9);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r0 = 0;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r1 = r0;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x0024:
        r2 = r9.size();	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        if (r1 >= r2) goto L_0x0099;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x002a:
        r2 = r9.get(r1);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r2 = (com.alipay.sdk.protocol.b) r2;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r2 = r2.a;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r3 = com.alipay.sdk.protocol.a.Update;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        if (r2 != r3) goto L_0x0096;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x0036:
        r2 = r9.get(r1);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r2 = (com.alipay.sdk.protocol.b) r2;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r2 = r2.b;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r3 = r2.length;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r4 = 3;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        if (r3 != r4) goto L_0x0096;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x0042:
        r3 = "tid";	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r4 = r2[r0];	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r3 = android.text.TextUtils.equals(r3, r4);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        if (r3 == 0) goto L_0x0096;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x004c:
        r3 = com.alipay.sdk.sys.b.a();	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r3 = r3.a;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r4 = com.alipay.sdk.tid.b.a();	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r5 = 1;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r6 = r2[r5];	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        if (r6 != 0) goto L_0x0096;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x005f:
        r6 = 2;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r7 = r2[r6];	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        if (r7 == 0) goto L_0x0069;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x0068:
        goto L_0x0096;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x0069:
        r5 = r2[r5];	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r4.a = r5;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r2 = r2[r6];	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r4.b = r2;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r2 = new com.alipay.sdk.tid.a;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r5 = com.alipay.sdk.util.a.a(r3);	 Catch:{ Exception -> 0x008d, all -> 0x0091 }
        r5 = r5.a();	 Catch:{ Exception -> 0x008d, all -> 0x0091 }
        r3 = com.alipay.sdk.util.a.a(r3);	 Catch:{ Exception -> 0x008d, all -> 0x0091 }
        r3 = r3.b();	 Catch:{ Exception -> 0x008d, all -> 0x0091 }
        r6 = r4.a;	 Catch:{ Exception -> 0x008d, all -> 0x0091 }
        r4 = r4.b;	 Catch:{ Exception -> 0x008d, all -> 0x0091 }
        r2.a(r5, r3, r6, r4);	 Catch:{ Exception -> 0x008d, all -> 0x0091 }
    L_0x008d:
        r2.close();	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        goto L_0x0096;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x0091:
        r9 = move-exception;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r2.close();	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        throw r9;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x0096:
        r1 = r1 + 1;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        goto L_0x0024;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x0099:
        r8.c();	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x009c:
        r1 = r9.size();	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        if (r0 >= r1) goto L_0x00c9;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x00a2:
        r1 = r9.get(r0);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r1 = (com.alipay.sdk.protocol.b) r1;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r1 = r1.a;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r2 = com.alipay.sdk.protocol.a.WapPay;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        if (r1 != r2) goto L_0x00bc;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
    L_0x00ae:
        r9 = r9.get(r0);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r9 = (com.alipay.sdk.protocol.b) r9;	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r9 = r8.a(r9);	 Catch:{ IOException -> 0x00ce, Throwable -> 0x00c1 }
        r8.c();
        return r9;
    L_0x00bc:
        r0 = r0 + 1;
        goto L_0x009c;
    L_0x00bf:
        r9 = move-exception;
        goto L_0x00f5;
    L_0x00c1:
        r9 = move-exception;
        r0 = "biz";	 Catch:{ all -> 0x00bf }
        r1 = "H5PayDataAnalysisError";	 Catch:{ all -> 0x00bf }
        com.alipay.sdk.app.statistic.a.a(r0, r1, r9);	 Catch:{ all -> 0x00bf }
    L_0x00c9:
        r8.c();
        r9 = 0;
        goto L_0x00e0;
    L_0x00ce:
        r9 = move-exception;
        r0 = com.alipay.sdk.app.i.NETWORK_ERROR;	 Catch:{ all -> 0x00bf }
        r0 = r0.h;	 Catch:{ all -> 0x00bf }
        r0 = com.alipay.sdk.app.i.a(r0);	 Catch:{ all -> 0x00bf }
        r1 = "net";	 Catch:{ all -> 0x00bf }
        com.alipay.sdk.app.statistic.a.a(r1, r9);	 Catch:{ all -> 0x00bf }
        r8.c();
        r9 = r0;
    L_0x00e0:
        if (r9 != 0) goto L_0x00ea;
    L_0x00e2:
        r9 = com.alipay.sdk.app.i.FAILED;
        r9 = r9.h;
        r9 = com.alipay.sdk.app.i.a(r9);
    L_0x00ea:
        r0 = r9.h;
        r9 = r9.i;
        r1 = "";
        r9 = com.alipay.sdk.app.h.a(r0, r9, r1);
        return r9;
    L_0x00f5:
        r8.c();
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.b(java.lang.String):java.lang.String");
    }

    private java.lang.String a(com.alipay.sdk.protocol.b r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r5 = r5.b;
        r0 = new android.content.Intent;
        r1 = r4.b;
        r2 = com.alipay.sdk.app.H5PayActivity.class;
        r0.<init>(r1, r2);
        r1 = new android.os.Bundle;
        r1.<init>();
        r2 = 0;
        r2 = r5[r2];
        r3 = "url";
        r1.putString(r3, r2);
        r2 = 2;
        r3 = r5.length;
        if (r3 != r2) goto L_0x0024;
    L_0x001c:
        r2 = 1;
        r5 = r5[r2];
        r2 = "cookie";
        r1.putString(r2, r5);
    L_0x0024:
        r0.putExtras(r1);
        r5 = r4.b;
        r5.startActivity(r0);
        r5 = a;
        monitor-enter(r5);
        r0 = a;	 Catch:{ InterruptedException -> 0x0044 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0044 }
        monitor-exit(r5);
        r5 = com.alipay.sdk.app.h.a;
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 == 0) goto L_0x0041;
    L_0x003d:
        r5 = com.alipay.sdk.app.h.a();
    L_0x0041:
        return r5;
    L_0x0042:
        r0 = move-exception;
        goto L_0x004a;
    L_0x0044:
        r0 = com.alipay.sdk.app.h.a();	 Catch:{ all -> 0x0042 }
        monitor-exit(r5);	 Catch:{ all -> 0x0042 }
        return r0;
    L_0x004a:
        monitor-exit(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(com.alipay.sdk.protocol.b):java.lang.String");
    }
}
