package com.taobao.tao.remotebusiness.listener;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.jaq.SecurityVerification;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;
import mtopsdk.mtop.a.d;
import mtopsdk.mtop.common.e;
import mtopsdk.mtop.common.f;
import mtopsdk.mtop.common.g;
import mtopsdk.mtop.common.k;

public class c {
    private SecurityGuardManager a = null;
    private d b = null;
    private SecurityVerification c;

    public static String a(String str, MtopBusiness mtopBusiness, boolean z, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" [");
        if (mtopBusiness != null) {
            stringBuilder.append("apiName=");
            stringBuilder.append(mtopBusiness.request.getApiName());
            stringBuilder.append(";version=");
            stringBuilder.append(mtopBusiness.request.getVersion());
            stringBuilder.append(";requestType=");
            stringBuilder.append(mtopBusiness.getRequestType());
            if (z) {
                stringBuilder.append(";clazz=");
                stringBuilder.append(mtopBusiness.clazz);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String a(Map map, String str) {
        List list;
        if (!(map == null || map.isEmpty())) {
            if (!TextUtils.isEmpty(str)) {
                for (Entry entry : map.entrySet()) {
                    if (str.equalsIgnoreCase((String) entry.getKey())) {
                        list = (List) entry.getValue();
                        break;
                    }
                }
            }
        }
        list = null;
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    public static k a(MtopBusiness mtopBusiness, k kVar) {
        List arrayList = new ArrayList();
        arrayList.add(e.class);
        if (kVar instanceof IRemoteProcessListener) {
            arrayList.add(g.class);
            arrayList.add(f.class);
        }
        if ((kVar instanceof IRemoteCacheListener) || mtopBusiness.mtopProp.useCache) {
            arrayList.add(mtopsdk.mtop.common.d.class);
        }
        return (k) Proxy.newProxyInstance(k.class.getClassLoader(), (Class[]) arrayList.toArray(new Class[arrayList.size()]), new a(mtopBusiness, kVar));
    }

    public static void a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ Exception -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.listener.c.a(java.io.Closeable):void");
    }

    public static boolean a(String str) {
        if (!(str.equals("POST") || str.equals("PUT"))) {
            if (!str.equals("PATCH")) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(java.util.Map r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "Content-Encoding";	 Catch:{ Exception -> 0x0010 }
        r1 = a(r1, r0);	 Catch:{ Exception -> 0x0010 }
        r0 = "gzip";	 Catch:{ Exception -> 0x0010 }
        r1 = r0.equalsIgnoreCase(r1);	 Catch:{ Exception -> 0x0010 }
        if (r1 == 0) goto L_0x0010;
    L_0x000e:
        r1 = 1;
        return r1;
    L_0x0010:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.listener.c.a(java.util.Map):boolean");
    }

    public static java.lang.String b(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = mtopsdk.common.util.i.b(r6);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return r6;
    L_0x0007:
        r0 = "MD5";	 Catch:{ Exception -> 0x004d }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x004d }
        r1 = "utf-8";	 Catch:{ Exception -> 0x004d }
        r1 = r6.getBytes(r1);	 Catch:{ Exception -> 0x004d }
        r0.update(r1);	 Catch:{ Exception -> 0x004d }
        r0 = r0.digest();	 Catch:{ Exception -> 0x004d }
        r1 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x004d }
        r1.<init>();	 Catch:{ Exception -> 0x004d }
        r2 = 0;	 Catch:{ Exception -> 0x004d }
    L_0x0020:
        r3 = r0.length;	 Catch:{ Exception -> 0x004d }
        if (r2 >= r3) goto L_0x0048;	 Catch:{ Exception -> 0x004d }
    L_0x0023:
        r3 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ Exception -> 0x004d }
        r4 = r0[r2];	 Catch:{ Exception -> 0x004d }
        r3 = r3 & r4;	 Catch:{ Exception -> 0x004d }
        r3 = java.lang.Integer.toHexString(r3);	 Catch:{ Exception -> 0x004d }
    L_0x002c:
        r4 = r3.length();	 Catch:{ Exception -> 0x004d }
        r5 = 2;	 Catch:{ Exception -> 0x004d }
        if (r4 >= r5) goto L_0x0042;	 Catch:{ Exception -> 0x004d }
    L_0x0033:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004d }
        r5 = "0";	 Catch:{ Exception -> 0x004d }
        r4.<init>(r5);	 Catch:{ Exception -> 0x004d }
        r4.append(r3);	 Catch:{ Exception -> 0x004d }
        r3 = r4.toString();	 Catch:{ Exception -> 0x004d }
        goto L_0x002c;	 Catch:{ Exception -> 0x004d }
    L_0x0042:
        r1.append(r3);	 Catch:{ Exception -> 0x004d }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x004d }
        goto L_0x0020;	 Catch:{ Exception -> 0x004d }
    L_0x0048:
        r0 = r1.toString();	 Catch:{ Exception -> 0x004d }
        return r0;
    L_0x004d:
        r0 = new java.lang.StringBuilder;
        r1 = "[getMd5] compute md5 value failed for source str=";
        r0.<init>(r1);
        r0.append(r6);
        r6 = r0.toString();
        mtopsdk.common.util.j.f(r6);
        r6 = 0;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.listener.c.b(java.lang.String):java.lang.String");
    }

    private static String c(String str) {
        return str == null ? "" : str;
    }

    public java.lang.String a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.c;	 Catch:{ Throwable -> 0x000f }
        if (r1 == 0) goto L_0x0014;	 Catch:{ Throwable -> 0x000f }
    L_0x0005:
        r1 = r3.c;	 Catch:{ Throwable -> 0x000f }
        r2 = 20;	 Catch:{ Throwable -> 0x000f }
        r1 = r1.doJAQVerfificationSync(r0, r2);	 Catch:{ Throwable -> 0x000f }
        r0 = r1;
        return r0;
    L_0x000f:
        r1 = "[getSecBodyDataEx] SecurityVerification doJAQVerfificationSync error";
        mtopsdk.common.util.j.f(r1);
    L_0x0014:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.listener.c.a():java.lang.String");
    }

    public java.lang.String a(java.util.HashMap r18, java.lang.String r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r19;
        r3 = 0;
        if (r1 == 0) goto L_0x013d;
    L_0x0009:
        if (r2 != 0) goto L_0x000d;
    L_0x000b:
        goto L_0x013d;
    L_0x000d:
        r4 = r0.a;
        if (r4 != 0) goto L_0x0017;
    L_0x0011:
        r1 = "[getMtopApiWBSign]SecurityGuardManager is null,please call ISign init()";
        mtopsdk.common.util.j.e(r1);
        return r3;
    L_0x0017:
        r4 = new com.alibaba.wireless.security.open.SecurityGuardParamContext;	 Catch:{ Throwable -> 0x0135 }
        r4.<init>();	 Catch:{ Throwable -> 0x0135 }
        r4.appKey = r2;	 Catch:{ Throwable -> 0x0135 }
        r5 = 7;	 Catch:{ Throwable -> 0x0135 }
        r4.requestType = r5;	 Catch:{ Throwable -> 0x0135 }
        if (r1 == 0) goto L_0x0115;	 Catch:{ Throwable -> 0x0135 }
    L_0x0023:
        r5 = r18.size();	 Catch:{ Throwable -> 0x0135 }
        if (r5 > 0) goto L_0x002b;	 Catch:{ Throwable -> 0x0135 }
    L_0x0029:
        goto L_0x0115;	 Catch:{ Throwable -> 0x0135 }
    L_0x002b:
        r5 = "api";	 Catch:{ Throwable -> 0x0135 }
        r5 = r1.get(r5);	 Catch:{ Throwable -> 0x0135 }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x0135 }
        r6 = "v";	 Catch:{ Throwable -> 0x0135 }
        r6 = r1.get(r6);	 Catch:{ Throwable -> 0x0135 }
        r6 = (java.lang.String) r6;	 Catch:{ Throwable -> 0x0135 }
        r7 = "data";	 Catch:{ Throwable -> 0x0135 }
        r7 = r1.get(r7);	 Catch:{ Throwable -> 0x0135 }
        r7 = (java.lang.String) r7;	 Catch:{ Throwable -> 0x0135 }
        r8 = "accessToken";	 Catch:{ Throwable -> 0x0135 }
        r8 = r1.get(r8);	 Catch:{ Throwable -> 0x0135 }
        r8 = (java.lang.String) r8;	 Catch:{ Throwable -> 0x0135 }
        r9 = "t";	 Catch:{ Throwable -> 0x0135 }
        r9 = r1.get(r9);	 Catch:{ Throwable -> 0x0135 }
        r9 = (java.lang.String) r9;	 Catch:{ Throwable -> 0x0135 }
        r10 = "utdid";	 Catch:{ Throwable -> 0x0135 }
        r10 = r1.get(r10);	 Catch:{ Throwable -> 0x0135 }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x0135 }
        r11 = "pv";	 Catch:{ Throwable -> 0x0135 }
        r11 = r1.get(r11);	 Catch:{ Throwable -> 0x0135 }
        r11 = (java.lang.String) r11;	 Catch:{ Throwable -> 0x0135 }
        r12 = "x-features";	 Catch:{ Throwable -> 0x0135 }
        r12 = r1.get(r12);	 Catch:{ Throwable -> 0x0135 }
        r12 = (java.lang.String) r12;	 Catch:{ Throwable -> 0x0135 }
        r13 = "ttid";	 Catch:{ Throwable -> 0x0135 }
        r13 = r1.get(r13);	 Catch:{ Throwable -> 0x0135 }
        r13 = (java.lang.String) r13;	 Catch:{ Throwable -> 0x0135 }
        r14 = "sid";	 Catch:{ Throwable -> 0x0135 }
        r14 = r1.get(r14);	 Catch:{ Throwable -> 0x0135 }
        r14 = (java.lang.String) r14;	 Catch:{ Throwable -> 0x0135 }
        r15 = "wua";	 Catch:{ Throwable -> 0x0135 }
        r1 = r1.get(r15);	 Catch:{ Throwable -> 0x0135 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0135 }
        r15 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0135 }
        r3 = 64;	 Catch:{ Throwable -> 0x0135 }
        r15.<init>(r3);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r5);	 Catch:{ Throwable -> 0x0135 }
        r3 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r3);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r6);	 Catch:{ Throwable -> 0x0135 }
        r3 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r3);	 Catch:{ Throwable -> 0x0135 }
        r3 = b(r7);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r3);	 Catch:{ Throwable -> 0x0135 }
        r3 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r3);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = c(r8);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r9);	 Catch:{ Throwable -> 0x0135 }
        r2 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = c(r10);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = c(r11);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = c(r12);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = c(r13);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = c(r14);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r2 = "&";	 Catch:{ Throwable -> 0x0135 }
        r15.append(r2);	 Catch:{ Throwable -> 0x0135 }
        r1 = c(r1);	 Catch:{ Throwable -> 0x0135 }
        r15.append(r1);	 Catch:{ Throwable -> 0x0135 }
        r3 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0135 }
        r1 = 2;	 Catch:{ Throwable -> 0x0135 }
        r3.<init>(r1);	 Catch:{ Throwable -> 0x0135 }
        r1 = "INPUT";	 Catch:{ Throwable -> 0x0135 }
        r2 = r15.toString();	 Catch:{ Throwable -> 0x0135 }
        r3.put(r1, r2);	 Catch:{ Throwable -> 0x0135 }
        goto L_0x0116;	 Catch:{ Throwable -> 0x0135 }
    L_0x0115:
        r3 = 0;	 Catch:{ Throwable -> 0x0135 }
    L_0x0116:
        r1 = "ATLAS";	 Catch:{ Throwable -> 0x0135 }
        r2 = "a";	 Catch:{ Throwable -> 0x0135 }
        r3.put(r1, r2);	 Catch:{ Throwable -> 0x0135 }
        r4.paramMap = r3;	 Catch:{ Throwable -> 0x0135 }
        r1 = r0.a;	 Catch:{ Throwable -> 0x0135 }
        r1 = r1.getSecureSignatureComp();	 Catch:{ Throwable -> 0x0135 }
        r2 = mtopsdk.mtop.a.d.g();	 Catch:{ Throwable -> 0x0135 }
        if (r2 == 0) goto L_0x012c;	 Catch:{ Throwable -> 0x0135 }
    L_0x012b:
        goto L_0x012e;	 Catch:{ Throwable -> 0x0135 }
    L_0x012c:
        r2 = "";	 Catch:{ Throwable -> 0x0135 }
    L_0x012e:
        r3 = r1.signRequest(r4, r2);	 Catch:{ Throwable -> 0x0135 }
        r16 = r3;
        return r16;
    L_0x0135:
        r1 = "[getMtopApiWBSign] ISecureSignatureComponent signRequest error";
        mtopsdk.common.util.j.f(r1);
        r16 = 0;
        return r16;
    L_0x013d:
        r1 = new java.lang.StringBuilder;
        r3 = "[getMtopApiWBSign] appkey or params is null.appkey=";
        r1.<init>(r3);
        r1.append(r2);
        r1 = r1.toString();
        mtopsdk.common.util.j.e(r1);
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.listener.c.a(java.util.HashMap, java.lang.String):java.lang.String");
    }

    public java.lang.String a(mtopsdk.b.a r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r4.b;
        if (r1 == 0) goto L_0x000b;
    L_0x0008:
        r4 = r4.b;
        return r4;
    L_0x000b:
        r1 = r3.a;
        r1 = r1.getStaticDataStoreComp();
        r2 = mtopsdk.mtop.a.d.g();	 Catch:{ Exception -> 0x0021 }
        r4 = r4.a;	 Catch:{ Exception -> 0x0021 }
        if (r2 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x0021 }
    L_0x0019:
        goto L_0x001c;	 Catch:{ Exception -> 0x0021 }
    L_0x001a:
        r2 = "";	 Catch:{ Exception -> 0x0021 }
    L_0x001c:
        r4 = r1.getAppKeyByIndex(r4, r2);	 Catch:{ Exception -> 0x0021 }
        return r4;
    L_0x0021:
        r4 = "[getAppkey]getAppKeyByIndex error.";
        mtopsdk.common.util.j.f(r4);
        r4 = r0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.listener.c.a(mtopsdk.b.a):java.lang.String");
    }

    public void a(Context context, int i) {
        String str;
        if (context == null) {
            str = "[init]SecuritySignImpl init.context is null";
        } else {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.b = d.a();
                this.a = SecurityGuardManager.getInstance(context);
                IStaticDataStoreComponent staticDataStoreComp = this.a.getStaticDataStoreComp();
                String g = d.g();
                if (g == null) {
                    g = "";
                }
                String appKeyByIndex = staticDataStoreComp.getAppKeyByIndex(i, g);
                if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
                    StringBuilder stringBuilder = new StringBuilder("[init]SecuritySignImpl ISign init.set GlobalAppKey=");
                    stringBuilder.append(appKeyByIndex);
                    j.a(stringBuilder.toString());
                }
                this.c = new SecurityVerification(context);
                if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
                    StringBuilder stringBuilder2 = new StringBuilder("[init]SecuritySignImpl ISign init succeed.init time=");
                    stringBuilder2.append(System.currentTimeMillis() - currentTimeMillis);
                    j.a(stringBuilder2.toString());
                }
                return;
            } catch (Throwable th) {
                StringBuilder stringBuilder3 = new StringBuilder("[init]SecuritySignImpl init securityguard error.---");
                stringBuilder3.append(th.toString());
                str = stringBuilder3.toString();
            }
        }
        j.e(str);
    }
}
