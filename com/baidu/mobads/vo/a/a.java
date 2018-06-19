package com.baidu.mobads.vo.a;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.d;
import com.qihoo360.replugin.RePlugin;
import com.umeng.message.MsgConstant;
import java.util.HashMap;
import java.util.Map;

public abstract class a {
    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    protected Context l;
    protected d m;
    protected IXAdSystemUtils n;
    private a o;

    public static class a {
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        String e = "";

        public a(IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo) {
            if (iXAdInstanceInfo != null) {
                this.a = iXAdInstanceInfo.getAdId();
                this.b = iXAdInstanceInfo.getQueryKey();
                this.d = iXAdInstanceInfo.getCreativeType().getValue();
            }
            if (iXAdProdInfo != null) {
                this.e = iXAdProdInfo.getAdPlacementId();
                this.c = iXAdProdInfo.getProdType();
            }
        }
    }

    protected abstract HashMap<String, String> b();

    public a(a aVar) {
        this(aVar.a, aVar.b, aVar.c);
        this.o = aVar;
    }

    @Deprecated
    public a(String str, String str2, String str3) {
        this.b = RePlugin.PROCESS_UI;
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.j = "";
        this.k = "";
        this.o = null;
        this.m = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.n = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        this.l = XAdSDKFoundationFacade.getInstance().getApplicationContext();
        this.a = System.currentTimeMillis();
        this.b = str;
        this.c = str2;
        this.e = this.m.getAppSec(this.l);
        if (this.l != null) {
            this.d = this.l.getPackageName();
        }
        this.f = this.m.getAppId(this.l);
        this.h = this.n.getEncodedSN(this.l);
        this.i = DispatchConstants.ANDROID;
        str = new StringBuilder("android_");
        str.append(com.baidu.mobads.a.a.c);
        str.append("_4.1.30");
        this.g = str.toString();
        this.j = str3;
        this.k = XAdSDKFoundationFacade.getInstance().getSystemUtils().getCUID(this.l);
    }

    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("adid", this.b);
        hashMap.put("appsec", this.e);
        hashMap.put("appsid", this.f);
        hashMap.put("pack", this.d);
        hashMap.put("qk", this.c);
        hashMap.put("sn", this.h);
        String str = MsgConstant.KEY_TS;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        hashMap.put(str, stringBuilder.toString());
        hashMap.put("v", this.g);
        hashMap.put("os", this.i);
        hashMap.put("prod", this.j);
        hashMap.put("cuid", this.k);
        hashMap.put(IXAdRequestInfo.P_VER, "8.7036");
        if (this.o != null) {
            hashMap.put("adt", this.o.d);
            hashMap.put("apid", this.o.e);
        }
        return hashMap;
    }

    public HashMap<String, String> c() {
        HashMap<String, String> a = a();
        Map b = b();
        if (b != null) {
            a.putAll(b);
        }
        return a;
    }

    public String toString() {
        return a(c());
    }

    protected java.lang.String a(java.util.HashMap<java.lang.String, java.lang.String> r8) {
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
        r7 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0091 }
        r1 = r1.getCommonUtils();	 Catch:{ Exception -> 0x0091 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0091 }
        r2.<init>();	 Catch:{ Exception -> 0x0091 }
        r3 = r8.keySet();	 Catch:{ Exception -> 0x0091 }
        r3 = r3.iterator();	 Catch:{ Exception -> 0x0091 }
    L_0x001a:
        r4 = r3.hasNext();	 Catch:{ Exception -> 0x0091 }
        if (r4 == 0) goto L_0x0069;	 Catch:{ Exception -> 0x0091 }
    L_0x0020:
        r4 = r3.next();	 Catch:{ Exception -> 0x0091 }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x0091 }
        r5 = r8.get(r4);	 Catch:{ Exception -> 0x0091 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0091 }
        if (r4 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x0091 }
    L_0x002e:
        if (r5 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x0091 }
    L_0x0030:
        r4 = r7.a(r4);	 Catch:{ Exception -> 0x0091 }
        r5 = r7.a(r5);	 Catch:{ Exception -> 0x0091 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0091 }
        r6.<init>();	 Catch:{ Exception -> 0x0091 }
        r6.append(r4);	 Catch:{ Exception -> 0x0091 }
        r4 = "=";	 Catch:{ Exception -> 0x0091 }
        r6.append(r4);	 Catch:{ Exception -> 0x0091 }
        r6.append(r5);	 Catch:{ Exception -> 0x0091 }
        r4 = "&";	 Catch:{ Exception -> 0x0091 }
        r6.append(r4);	 Catch:{ Exception -> 0x0091 }
        r4 = r6.toString();	 Catch:{ Exception -> 0x0091 }
        r0.append(r4);	 Catch:{ Exception -> 0x0091 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0091 }
        r4.<init>();	 Catch:{ Exception -> 0x0091 }
        r4.append(r5);	 Catch:{ Exception -> 0x0091 }
        r5 = ",";	 Catch:{ Exception -> 0x0091 }
        r4.append(r5);	 Catch:{ Exception -> 0x0091 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0091 }
        r2.append(r4);	 Catch:{ Exception -> 0x0091 }
        goto L_0x001a;	 Catch:{ Exception -> 0x0091 }
    L_0x0069:
        r8 = "mobads,";	 Catch:{ Exception -> 0x0091 }
        r2.append(r8);	 Catch:{ Exception -> 0x0091 }
        r8 = r2.toString();	 Catch:{ Exception -> 0x0091 }
        r8 = r1.getMD5(r8);	 Catch:{ Exception -> 0x0091 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0091 }
        r2 = "vd=";	 Catch:{ Exception -> 0x0091 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0091 }
        r1.append(r8);	 Catch:{ Exception -> 0x0091 }
        r8 = "&";	 Catch:{ Exception -> 0x0091 }
        r1.append(r8);	 Catch:{ Exception -> 0x0091 }
        r8 = r1.toString();	 Catch:{ Exception -> 0x0091 }
        r0.append(r8);	 Catch:{ Exception -> 0x0091 }
        r8 = r0.toString();
        return r8;
    L_0x0091:
        r8 = "";
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.vo.a.a.a(java.util.HashMap):java.lang.String");
    }

    protected java.lang.String a(java.lang.String r4) {
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
        r3 = this;
        r0 = "UTF-8";	 Catch:{ Exception -> 0x0037 }
        r0 = java.net.URLEncoder.encode(r4, r0);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\+";	 Catch:{ Exception -> 0x0037 }
        r2 = "%20";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\%21";	 Catch:{ Exception -> 0x0037 }
        r2 = "!";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\%27";	 Catch:{ Exception -> 0x0037 }
        r2 = "'";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\%28";	 Catch:{ Exception -> 0x0037 }
        r2 = "(";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\%29";	 Catch:{ Exception -> 0x0037 }
        r2 = ")";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r1 = "\\%7E";	 Catch:{ Exception -> 0x0037 }
        r2 = "~";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0037 }
        r4 = r0;
    L_0x0037:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.vo.a.a.a(java.lang.String):java.lang.String");
    }
}
