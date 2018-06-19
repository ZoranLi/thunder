package anet.channel.strategy.dispatch;

import anet.channel.flow.b;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import com.taobao.accs.common.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;

/* compiled from: Taobao */
class c {
    static AtomicInteger a = new AtomicInteger(0);
    static HostnameVerifier b = new d();
    static Random c = new Random();

    c() {
    }

    static List<IConnStrategy> a(String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        if (!NetworkStatusHelper.h()) {
            list = StrategyCenter.getInstance().getConnStrategyListByHost(DispatchConstants.getAmdcServerDomain());
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (!((IConnStrategy) listIterator.next()).getProtocol().protocol.equalsIgnoreCase(str)) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }

    public static void a(Map map) {
        if (map == null) {
            ALog.e("awcn.DispatchCore", "amdc request's parameter invalid!", null, new Object[0]);
            return;
        }
        String schemeByHost = StrategyCenter.getInstance().getSchemeByHost(DispatchConstants.getAmdcServerDomain(), HttpConstant.HTTP);
        List a = a(schemeByHost);
        for (int i = 0; i < 3; i++) {
            IConnStrategy iConnStrategy;
            String a2;
            Map hashMap = new HashMap(map);
            if (i != 2) {
                iConnStrategy = !a.isEmpty() ? (IConnStrategy) a.remove(0) : null;
                if (iConnStrategy != null) {
                    a2 = a(schemeByHost, iConnStrategy.getIp(), iConnStrategy.getPort(), hashMap, i);
                } else {
                    a2 = a(schemeByHost, null, 0, hashMap, i);
                }
            } else {
                String[] amdcServerFixIp = DispatchConstants.getAmdcServerFixIp();
                if (amdcServerFixIp == null || amdcServerFixIp.length <= 0) {
                    a2 = a(schemeByHost, null, 0, hashMap, i);
                } else {
                    a2 = a(schemeByHost, amdcServerFixIp[c.nextInt(amdcServerFixIp.length)], 0, hashMap, i);
                }
                iConnStrategy = null;
            }
            int a3 = a(a2, hashMap, i);
            if (iConnStrategy != null) {
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = a3 == 0;
                StrategyCenter.getInstance().notifyConnEvent(DispatchConstants.getAmdcServerDomain(), iConnStrategy, connEvent);
            }
            if (a3 == 0 || a3 == 2) {
                break;
            }
        }
    }

    private static String a(String str, String str2, int i, Map<String, String> map, int i2) {
        StringBuilder stringBuilder = new StringBuilder(64);
        if (!(i2 != 2 || "https".equalsIgnoreCase(str) == 0 || c.nextBoolean() == 0)) {
            str = HttpConstant.HTTP;
        }
        stringBuilder.append(str);
        stringBuilder.append(HttpConstant.SCHEME_SPLIT);
        if (str2 != null) {
            if (i == 0) {
                if ("https".equalsIgnoreCase(str) != null) {
                    str = Constants.PORT;
                } else {
                    int i3 = 80;
                }
                i = str;
            }
            stringBuilder.append(str2);
            stringBuilder.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            stringBuilder.append(i);
        } else {
            stringBuilder.append(DispatchConstants.getAmdcServerDomain());
        }
        stringBuilder.append(DispatchConstants.serverPath);
        str = new TreeMap();
        str.put("appkey", map.remove("appkey"));
        str.put("v", map.remove("v"));
        str.put("deviceId", map.remove("deviceId"));
        str.put("platform", map.remove("platform"));
        stringBuilder.append('?');
        stringBuilder.append(d.b(str, "utf-8"));
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r19, java.util.Map r20, int r21) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = r19;
        r2 = r20;
        r3 = r21;
        r4 = new java.lang.StringBuilder;
        r5 = "AMDC";
        r4.<init>(r5);
        r5 = a;
        r5 = r5.incrementAndGet();
        r5 = java.lang.String.valueOf(r5);
        r4.append(r5);
        r4 = r4.toString();
        r5 = "awcn.DispatchCore";
        r6 = "send amdc request";
        r7 = 2;
        r8 = new java.lang.Object[r7];
        r9 = "url";
        r10 = 0;
        r8[r10] = r9;
        r9 = 1;
        r8[r9] = r1;
        anet.channel.util.ALog.i(r5, r6, r4, r8);
        r5 = "Env";
        r5 = r2.remove(r5);
        r5 = (anet.channel.entity.ENV) r5;
        r8 = new java.net.URL;	 Catch:{ Throwable -> 0x029a, all -> 0x0296 }
        r8.<init>(r1);	 Catch:{ Throwable -> 0x029a, all -> 0x0296 }
        r11 = r8.openConnection();	 Catch:{ Throwable -> 0x0291, all -> 0x0296 }
        r11 = (java.net.HttpURLConnection) r11;	 Catch:{ Throwable -> 0x0291, all -> 0x0296 }
        r12 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r11.setConnectTimeout(r12);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r11.setReadTimeout(r12);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12 = "POST";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r11.setRequestMethod(r12);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r11.setDoOutput(r9);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r11.setDoInput(r9);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12 = "Connection";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r13 = "close";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r11.addRequestProperty(r12, r13);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12 = "Accept-Encoding";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r13 = "gzip";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r11.addRequestProperty(r12, r13);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r11.setInstanceFollowRedirects(r10);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12 = r8.getProtocol();	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r13 = "https";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12 = r12.equals(r13);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        if (r12 == 0) goto L_0x0081;
    L_0x0073:
        r12 = r11;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r12 = (javax.net.ssl.HttpsURLConnection) r12;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r13 = b;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r12.setHostnameVerifier(r13);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        goto L_0x0081;
    L_0x007c:
        r0 = move-exception;
        r1 = r0;
        r7 = r8;
        goto L_0x028f;
    L_0x0081:
        r12 = r11.getOutputStream();	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r13 = "utf-8";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r2 = anet.channel.strategy.utils.d.b(r2, r13);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r2 = r2.getBytes();	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12.write(r2);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12 = r11.getResponseCode();	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r13 = r11.getHeaderFields();	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r14 = anet.channel.util.ALog.isPrintLog(r9);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        if (r14 == 0) goto L_0x00bb;
    L_0x00a0:
        r14 = "awcn.DispatchCore";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r15 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r6 = "amdc response. code: ";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r15.<init>(r6);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r15.append(r12);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r6 = r15.toString();	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r15 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r16 = "\nheaders";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r15[r10] = r16;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r15[r9] = r13;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        anet.channel.util.ALog.d(r14, r6, r4, r15);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x00bb:
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        if (r12 == r6) goto L_0x00e4;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x00bf:
        r1 = 302; // 0x12e float:4.23E-43 double:1.49E-321;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        if (r12 == r1) goto L_0x00c9;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x00c3:
        r1 = 307; // 0x133 float:4.3E-43 double:1.517E-321;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        if (r12 != r1) goto L_0x00c8;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x00c7:
        goto L_0x00c9;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x00c8:
        r7 = r9;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x00c9:
        r1 = java.lang.String.valueOf(r12);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r2 = "response code not 200";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        a(r1, r2, r8, r3, r7);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        if (r11 == 0) goto L_0x00e3;
    L_0x00d4:
        r11.disconnect();	 Catch:{ Exception -> 0x00d8 }
        goto L_0x00e3;
    L_0x00d8:
        r0 = move-exception;
        r1 = "awcn.DispatchCore";
        r2 = "http disconnect failed";
        r3 = new java.lang.Object[r10];
        r4 = 0;
        anet.channel.util.ALog.e(r1, r2, r4, r0, r3);
    L_0x00e3:
        return r7;
    L_0x00e4:
        r6 = "x-am-code";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r6 = anet.channel.strategy.utils.d.a(r13, r6);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12 = "1000";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12 = r12.equals(r6);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        if (r12 != 0) goto L_0x0127;
    L_0x00f2:
        r1 = "1007";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r1 = r1.equals(r6);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        if (r1 != 0) goto L_0x0104;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x00fa:
        r1 = "1008";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r1 = r1.equals(r6);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        if (r1 == 0) goto L_0x0103;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x0102:
        goto L_0x0104;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x0103:
        r7 = r9;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x0104:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r2 = "return code: ";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r1.append(r6);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        a(r6, r1, r8, r3, r7);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        if (r11 == 0) goto L_0x0126;
    L_0x0117:
        r11.disconnect();	 Catch:{ Exception -> 0x011b }
        goto L_0x0126;
    L_0x011b:
        r0 = move-exception;
        r1 = "awcn.DispatchCore";
        r2 = "http disconnect failed";
        r3 = new java.lang.Object[r10];
        r4 = 0;
        anet.channel.util.ALog.e(r1, r2, r4, r0, r3);
    L_0x0126:
        return r7;
    L_0x0127:
        r12 = "x-am-sign";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12 = anet.channel.strategy.utils.d.a(r13, r12);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r12 = r12.trim();	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r14 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        if (r14 == 0) goto L_0x0150;
    L_0x0137:
        r1 = "-1001";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r2 = "response sign is empty";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        a(r1, r2, r8, r3, r9);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        if (r11 == 0) goto L_0x014f;
    L_0x0140:
        r11.disconnect();	 Catch:{ Exception -> 0x0144 }
        goto L_0x014f;
    L_0x0144:
        r0 = move-exception;
        r1 = "awcn.DispatchCore";
        r2 = "http disconnect failed";
        r3 = new java.lang.Object[r10];
        r4 = 0;
        anet.channel.util.ALog.e(r1, r2, r4, r0, r3);
    L_0x014f:
        return r9;
    L_0x0150:
        r14 = new anet.channel.strategy.utils.c;	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r15 = r11.getInputStream();	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r14.<init>(r15);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r15 = "gzip";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r10 = "Content-Encoding";	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r10 = anet.channel.strategy.utils.d.a(r13, r10);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r10 = r15.equalsIgnoreCase(r10);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r10 = a(r14, r10);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r13 = anet.channel.util.ALog.isPrintLog(r9);	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        if (r13 == 0) goto L_0x0182;
    L_0x016f:
        r13 = "awcn.DispatchCore";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r15 = "amdc response body";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r9 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r16 = "\nbody";	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r17 = 0;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r9[r17] = r16;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r16 = 1;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        r9[r16] = r10;	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
        anet.channel.util.ALog.d(r13, r15, r4, r9);	 Catch:{ Throwable -> 0x007c, all -> 0x0289 }
    L_0x0182:
        r2 = r2.length;	 Catch:{ Throwable -> 0x028c, all -> 0x0289 }
        r18 = r8;
        r7 = (long) r2;
        r13 = r14.a();	 Catch:{ Throwable -> 0x0285, all -> 0x0289 }
        a(r1, r7, r13);	 Catch:{ Throwable -> 0x0285, all -> 0x0289 }
        r1 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x0285, all -> 0x0289 }
        if (r1 == 0) goto L_0x01b1;	 Catch:{ Throwable -> 0x0285, all -> 0x0289 }
    L_0x0193:
        r1 = "-1002";	 Catch:{ Throwable -> 0x0285, all -> 0x0289 }
        r2 = "read answer error";	 Catch:{ Throwable -> 0x0285, all -> 0x0289 }
        r7 = r18;
        r5 = 1;
        a(r1, r2, r7, r3, r5);	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        if (r11 == 0) goto L_0x01af;
    L_0x019f:
        r11.disconnect();	 Catch:{ Exception -> 0x01a3 }
        goto L_0x01af;
    L_0x01a3:
        r0 = move-exception;
        r1 = "awcn.DispatchCore";
        r2 = "http disconnect failed";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        anet.channel.util.ALog.e(r1, r2, r4, r0, r3);
    L_0x01af:
        r1 = 1;
        return r1;
    L_0x01b1:
        r7 = r18;
        r1 = anet.channel.strategy.dispatch.a.b();	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        if (r1 == 0) goto L_0x01be;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
    L_0x01b9:
        r1 = r1.sign(r10);	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        goto L_0x01bf;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
    L_0x01be:
        r1 = 0;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
    L_0x01bf:
        r2 = r1.equalsIgnoreCase(r12);	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        if (r2 != 0) goto L_0x01fb;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
    L_0x01c5:
        r2 = "awcn.DispatchCore";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r5 = "check ret sign failed";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r6 = 4;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r8 = "retSign";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r9 = 0;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r6[r9] = r8;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r8 = 1;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r6[r8] = r12;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r8 = "checkSign";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r9 = 2;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r6[r9] = r8;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r8 = 3;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r6[r8] = r1;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        anet.channel.util.ALog.e(r2, r5, r4, r6);	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r1 = "-1003";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r2 = "check sign failed";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r5 = 1;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        a(r1, r2, r7, r3, r5);	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        if (r11 == 0) goto L_0x01f9;
    L_0x01e9:
        r11.disconnect();	 Catch:{ Exception -> 0x01ed }
        goto L_0x01f9;
    L_0x01ed:
        r0 = move-exception;
        r1 = "awcn.DispatchCore";
        r2 = "http disconnect failed";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        anet.channel.util.ALog.e(r1, r2, r4, r0, r3);
    L_0x01f9:
        r1 = 1;
        return r1;
    L_0x01fb:
        r1 = new org.json.JSONTokener;	 Catch:{ JSONException -> 0x0250 }
        r1.<init>(r10);	 Catch:{ JSONException -> 0x0250 }
        r1 = r1.nextValue();	 Catch:{ JSONException -> 0x0250 }
        r1 = (org.json.JSONObject) r1;	 Catch:{ JSONException -> 0x0250 }
        r2 = anet.channel.GlobalAppRuntimeInfo.getEnv();	 Catch:{ JSONException -> 0x0250 }
        if (r2 == r5) goto L_0x022b;	 Catch:{ JSONException -> 0x0250 }
    L_0x020c:
        r1 = "awcn.DispatchCore";	 Catch:{ JSONException -> 0x0250 }
        r2 = "env change, do not notify result";	 Catch:{ JSONException -> 0x0250 }
        r5 = 0;	 Catch:{ JSONException -> 0x0250 }
        r6 = new java.lang.Object[r5];	 Catch:{ JSONException -> 0x0250 }
        anet.channel.util.ALog.w(r1, r2, r4, r6);	 Catch:{ JSONException -> 0x0250 }
        if (r11 == 0) goto L_0x0229;
    L_0x0218:
        r11.disconnect();	 Catch:{ Exception -> 0x021c }
        goto L_0x0229;
    L_0x021c:
        r0 = move-exception;
        r1 = "awcn.DispatchCore";
        r2 = "http disconnect failed";
        r3 = 0;
        r4 = new java.lang.Object[r3];
        r5 = 0;
        anet.channel.util.ALog.e(r1, r2, r5, r0, r4);
        goto L_0x022a;
    L_0x0229:
        r3 = 0;
    L_0x022a:
        return r3;
    L_0x022b:
        r2 = anet.channel.strategy.dispatch.HttpDispatcher.getInstance();	 Catch:{ JSONException -> 0x0250 }
        r5 = new anet.channel.strategy.dispatch.DispatchEvent;	 Catch:{ JSONException -> 0x0250 }
        r8 = 1;	 Catch:{ JSONException -> 0x0250 }
        r5.<init>(r8, r1);	 Catch:{ JSONException -> 0x0250 }
        r2.fireEvent(r5);	 Catch:{ JSONException -> 0x0250 }
        r1 = "request success";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r2 = 0;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        a(r6, r1, r7, r3, r2);	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        if (r11 == 0) goto L_0x024f;
    L_0x0240:
        r11.disconnect();	 Catch:{ Exception -> 0x0244 }
        goto L_0x024f;
    L_0x0244:
        r0 = move-exception;
        r1 = "awcn.DispatchCore";
        r3 = "http disconnect failed";
        r4 = new java.lang.Object[r2];
        r5 = 0;
        anet.channel.util.ALog.e(r1, r3, r5, r0, r4);
    L_0x024f:
        return r2;
    L_0x0250:
        r1 = anet.channel.strategy.dispatch.HttpDispatcher.getInstance();	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r2 = new anet.channel.strategy.dispatch.DispatchEvent;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r5 = 0;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r6 = 0;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r2.<init>(r5, r6);	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r1.fireEvent(r2);	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r1 = "awcn.DispatchCore";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r2 = "resolve amdc anser failed";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r6 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        anet.channel.util.ALog.e(r1, r2, r4, r6);	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r1 = "-1004";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r2 = "resolve answer failed";	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        r5 = 1;	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        a(r1, r2, r7, r3, r5);	 Catch:{ Throwable -> 0x0283, all -> 0x0289 }
        if (r11 == 0) goto L_0x0281;
    L_0x0271:
        r11.disconnect();	 Catch:{ Exception -> 0x0275 }
        goto L_0x0281;
    L_0x0275:
        r0 = move-exception;
        r1 = "awcn.DispatchCore";
        r2 = "http disconnect failed";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        anet.channel.util.ALog.e(r1, r2, r4, r0, r3);
    L_0x0281:
        r1 = 1;
        return r1;
    L_0x0283:
        r0 = move-exception;
        goto L_0x028e;
    L_0x0285:
        r0 = move-exception;
        r7 = r18;
        goto L_0x028e;
    L_0x0289:
        r0 = move-exception;
        r1 = r0;
        goto L_0x02d3;
    L_0x028c:
        r0 = move-exception;
        r7 = r8;
    L_0x028e:
        r1 = r0;
    L_0x028f:
        r6 = r11;
        goto L_0x029e;
    L_0x0291:
        r0 = move-exception;
        r7 = r8;
        r1 = r0;
        r6 = 0;
        goto L_0x029e;
    L_0x0296:
        r0 = move-exception;
        r1 = r0;
        r11 = 0;
        goto L_0x02d3;
    L_0x029a:
        r0 = move-exception;
        r1 = r0;
        r6 = 0;
        r7 = 0;
    L_0x029e:
        r2 = r1.getMessage();	 Catch:{ all -> 0x02d0 }
        r5 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x02d0 }
        if (r5 == 0) goto L_0x02ac;	 Catch:{ all -> 0x02d0 }
    L_0x02a8:
        r2 = r1.toString();	 Catch:{ all -> 0x02d0 }
    L_0x02ac:
        r5 = "-1000";	 Catch:{ all -> 0x02d0 }
        r8 = 1;	 Catch:{ all -> 0x02d0 }
        a(r5, r2, r7, r3, r8);	 Catch:{ all -> 0x02d0 }
        r2 = "awcn.DispatchCore";	 Catch:{ all -> 0x02d0 }
        r3 = "amdc request fail";	 Catch:{ all -> 0x02d0 }
        r5 = 0;	 Catch:{ all -> 0x02d0 }
        r7 = new java.lang.Object[r5];	 Catch:{ all -> 0x02d0 }
        anet.channel.util.ALog.e(r2, r3, r4, r1, r7);	 Catch:{ all -> 0x02d0 }
        if (r6 == 0) goto L_0x02ce;
    L_0x02be:
        r6.disconnect();	 Catch:{ Exception -> 0x02c2 }
        goto L_0x02ce;
    L_0x02c2:
        r0 = move-exception;
        r1 = "awcn.DispatchCore";
        r2 = "http disconnect failed";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        anet.channel.util.ALog.e(r1, r2, r4, r0, r3);
    L_0x02ce:
        r1 = 1;
        return r1;
    L_0x02d0:
        r0 = move-exception;
        r1 = r0;
        r11 = r6;
    L_0x02d3:
        if (r11 == 0) goto L_0x02e5;
    L_0x02d5:
        r11.disconnect();	 Catch:{ Exception -> 0x02d9 }
        goto L_0x02e5;
    L_0x02d9:
        r0 = move-exception;
        r2 = "awcn.DispatchCore";
        r3 = "http disconnect failed";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        anet.channel.util.ALog.e(r2, r3, r5, r0, r4);
    L_0x02e5:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.dispatch.c.a(java.lang.String, java.util.Map, int):int");
    }

    static java.lang.String a(java.io.InputStream r4, boolean r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = new java.io.BufferedInputStream;
        r0.<init>(r4);
        r4 = new java.io.ByteArrayOutputStream;
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4.<init>(r1);
        r2 = 0;
        if (r5 == 0) goto L_0x001a;
    L_0x000f:
        r5 = new java.util.zip.GZIPInputStream;	 Catch:{ IOException -> 0x0018 }
        r5.<init>(r0);	 Catch:{ IOException -> 0x0018 }
        r0 = r5;	 Catch:{ IOException -> 0x0018 }
        goto L_0x001a;	 Catch:{ IOException -> 0x0018 }
    L_0x0016:
        r4 = move-exception;	 Catch:{ IOException -> 0x0018 }
        goto L_0x004e;	 Catch:{ IOException -> 0x0018 }
    L_0x0018:
        r4 = move-exception;	 Catch:{ IOException -> 0x0018 }
        goto L_0x0040;	 Catch:{ IOException -> 0x0018 }
    L_0x001a:
        r5 = new android.util.Base64InputStream;	 Catch:{ IOException -> 0x0018 }
        r5.<init>(r0, r2);	 Catch:{ IOException -> 0x0018 }
        r0 = new byte[r1];	 Catch:{ IOException -> 0x003e, all -> 0x003b }
    L_0x0021:
        r1 = r5.read(r0);	 Catch:{ IOException -> 0x003e, all -> 0x003b }
        r3 = -1;	 Catch:{ IOException -> 0x003e, all -> 0x003b }
        if (r1 == r3) goto L_0x002c;	 Catch:{ IOException -> 0x003e, all -> 0x003b }
    L_0x0028:
        r4.write(r0, r2, r1);	 Catch:{ IOException -> 0x003e, all -> 0x003b }
        goto L_0x0021;	 Catch:{ IOException -> 0x003e, all -> 0x003b }
    L_0x002c:
        r0 = new java.lang.String;	 Catch:{ IOException -> 0x003e, all -> 0x003b }
        r4 = r4.toByteArray();	 Catch:{ IOException -> 0x003e, all -> 0x003b }
        r1 = "utf-8";	 Catch:{ IOException -> 0x003e, all -> 0x003b }
        r0.<init>(r4, r1);	 Catch:{ IOException -> 0x003e, all -> 0x003b }
        r5.close();	 Catch:{ IOException -> 0x003a }
    L_0x003a:
        return r0;
    L_0x003b:
        r4 = move-exception;
        r0 = r5;
        goto L_0x004e;
    L_0x003e:
        r4 = move-exception;
        r0 = r5;
    L_0x0040:
        r5 = "awcn.DispatchCore";	 Catch:{ all -> 0x0016 }
        r1 = "";	 Catch:{ all -> 0x0016 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0016 }
        r3 = 0;	 Catch:{ all -> 0x0016 }
        anet.channel.util.ALog.e(r5, r1, r3, r4, r2);	 Catch:{ all -> 0x0016 }
        r0.close();	 Catch:{ IOException -> 0x004d }
    L_0x004d:
        return r3;
    L_0x004e:
        r0.close();	 Catch:{ IOException -> 0x0051 }
    L_0x0051:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.dispatch.c.a(java.io.InputStream, boolean):java.lang.String");
    }

    static void a(java.lang.String r1, java.lang.String r2, java.net.URL r3, int r4, int r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 1;
        if (r5 != r0) goto L_0x0006;
    L_0x0003:
        r5 = 2;
        if (r4 != r5) goto L_0x002d;
    L_0x0006:
        r5 = anet.channel.GlobalAppRuntimeInfo.isTargetProcess();
        if (r5 == 0) goto L_0x002d;
    L_0x000c:
        r5 = new anet.channel.statist.AmdcStatistic;	 Catch:{ Exception -> 0x002d }
        r5.<init>();	 Catch:{ Exception -> 0x002d }
        r5.errorCode = r1;	 Catch:{ Exception -> 0x002d }
        r5.errorMsg = r2;	 Catch:{ Exception -> 0x002d }
        if (r3 == 0) goto L_0x0023;	 Catch:{ Exception -> 0x002d }
    L_0x0017:
        r1 = r3.getHost();	 Catch:{ Exception -> 0x002d }
        r5.host = r1;	 Catch:{ Exception -> 0x002d }
        r1 = r3.toString();	 Catch:{ Exception -> 0x002d }
        r5.url = r1;	 Catch:{ Exception -> 0x002d }
    L_0x0023:
        r5.retryTimes = r4;	 Catch:{ Exception -> 0x002d }
        r1 = anet.channel.appmonitor.AppMonitor.getInstance();	 Catch:{ Exception -> 0x002d }
        r1.commitStat(r5);	 Catch:{ Exception -> 0x002d }
        return;
    L_0x002d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.dispatch.c.a(java.lang.String, java.lang.String, java.net.URL, int, int):void");
    }

    static void a(String str, long j, long j2) {
        try {
            b bVar = new b();
            bVar.a = "amdc";
            bVar.b = HttpConstant.HTTP;
            bVar.c = str;
            bVar.d = j;
            bVar.e = j2;
            anet.channel.flow.c.a().commitFlow(bVar);
        } catch (String str2) {
            ALog.e("awcn.DispatchCore", "commit flow info failed!", 0, str2, new Object[0]);
        }
    }
}
