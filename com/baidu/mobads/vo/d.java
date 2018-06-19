package com.baidu.mobads.vo;

import android.app.Activity;
import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.baidu.mobads.a.a;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;

public abstract class d implements IXAdRequestInfo {
    private String a = DispatchConstants.ANDROID;
    protected String b = "";
    protected String c = "TODO";
    protected Context d;
    protected Activity e;
    protected SlotType f;
    protected IXAdProdInfo g;
    protected IXAdConstants h = XAdSDKFoundationFacade.getInstance().getAdConstants();
    protected IXAdURIUitls i = XAdSDKFoundationFacade.getInstance().getURIUitls();
    protected boolean j;
    protected IXAdActivityUtils k = XAdSDKFoundationFacade.getInstance().getActivityUtils();
    private String l = "";
    private int m;
    private int n;
    private int o = XAdSDKFoundationFacade.getInstance().getAdConstants().getAdCreativeTypeImage();
    private String p = "LP,DL";
    private String q = "";
    private int r;
    private int s = 0;
    private int t;
    private boolean u = true;
    private long v = System.currentTimeMillis();

    public abstract HashMap<String, String> a();

    public String getSex() {
        return "";
    }

    public String getUk() {
        return "";
    }

    public String getZip() {
        return "";
    }

    public d(Context context, Activity activity, SlotType slotType) {
        Context context2;
        Activity activity2 = context instanceof Activity ? (Activity) context : null;
        this.e = activity2;
        if (activity2 == null) {
            context2 = context;
        } else {
            context2 = activity2.getApplicationContext();
        }
        this.d = context2;
        if (this.e == null && activity != null) {
            this.e = activity;
        }
        this.j = this.k.webviewMultiProcess(this.e);
        this.f = slotType;
        this.g = new b(this, this.f);
        c(this.f.getValue());
        a(context);
    }

    public IXAdProdInfo d() {
        return this.g;
    }

    @android.annotation.TargetApi(4)
    protected java.util.HashMap<java.lang.String, java.lang.String> e() {
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
        r14 = this;
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r0 = r0.getSystemUtils();
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r1 = r1.getCommonUtils();
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = "net";	 Catch:{ Exception -> 0x03b6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r4.<init>();	 Catch:{ Exception -> 0x03b6 }
        r5 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r5 = r0.getNetworkCatagory(r5);	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "n";	 Catch:{ Exception -> 0x03b6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r4.<init>();	 Catch:{ Exception -> 0x03b6 }
        r5 = r14.getN();	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "at";	 Catch:{ Exception -> 0x03b6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r4.<init>();	 Catch:{ Exception -> 0x03b6 }
        r5 = r14.getAt();	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "v";	 Catch:{ Exception -> 0x03b6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r4.<init>();	 Catch:{ Exception -> 0x03b6 }
        r5 = r14.f();	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r5 = "_";	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r5 = com.baidu.mobads.a.a.c;	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r5 = "_4.1.30";	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "cs";	 Catch:{ Exception -> 0x03b6 }
        r4 = "";	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "pk";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r1.getAppPackage(r4);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "trftp";	 Catch:{ Exception -> 0x03b6 }
        r4 = "sdk_8.7036";	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r3 = r1.getAppId(r3);	 Catch:{ Exception -> 0x03b6 }
        r4 = "q";	 Catch:{ Exception -> 0x03b6 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r5.<init>();	 Catch:{ Exception -> 0x03b6 }
        r5.append(r3);	 Catch:{ Exception -> 0x03b6 }
        r6 = "_cpr";	 Catch:{ Exception -> 0x03b6 }
        r5.append(r6);	 Catch:{ Exception -> 0x03b6 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r4, r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = "appid";	 Catch:{ Exception -> 0x03b6 }
        r2.put(r4, r3);	 Catch:{ Exception -> 0x03b6 }
        r3 = "tp";	 Catch:{ Exception -> 0x03b6 }
        r4 = android.os.Build.MODEL;	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "brd";	 Catch:{ Exception -> 0x03b6 }
        r4 = r0.getPhoneOSBrand();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r3 = r1.getDisplayMetrics(r3);	 Catch:{ Exception -> 0x03b6 }
        r4 = "den";	 Catch:{ Exception -> 0x03b6 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r5.<init>();	 Catch:{ Exception -> 0x03b6 }
        r6 = r3.density;	 Catch:{ Exception -> 0x03b6 }
        r5.append(r6);	 Catch:{ Exception -> 0x03b6 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r4, r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = "w";	 Catch:{ Exception -> 0x03b6 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r5.<init>();	 Catch:{ Exception -> 0x03b6 }
        r6 = r14.getW();	 Catch:{ Exception -> 0x03b6 }
        r5.append(r6);	 Catch:{ Exception -> 0x03b6 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r4, r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = "h";	 Catch:{ Exception -> 0x03b6 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r5.<init>();	 Catch:{ Exception -> 0x03b6 }
        r6 = r14.getH();	 Catch:{ Exception -> 0x03b6 }
        r5.append(r6);	 Catch:{ Exception -> 0x03b6 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r4, r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r1.getScreenRect(r4);	 Catch:{ Exception -> 0x03b6 }
        r5 = "sw";	 Catch:{ Exception -> 0x03b6 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r6.<init>();	 Catch:{ Exception -> 0x03b6 }
        r7 = r4.width();	 Catch:{ Exception -> 0x03b6 }
        r6.append(r7);	 Catch:{ Exception -> 0x03b6 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r5, r6);	 Catch:{ Exception -> 0x03b6 }
        r5 = "sh";	 Catch:{ Exception -> 0x03b6 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r6.<init>();	 Catch:{ Exception -> 0x03b6 }
        r4 = r4.height();	 Catch:{ Exception -> 0x03b6 }
        r6.append(r4);	 Catch:{ Exception -> 0x03b6 }
        r4 = r6.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r5, r4);	 Catch:{ Exception -> 0x03b6 }
        r4 = "lw";	 Catch:{ Exception -> 0x03b6 }
        r5 = r14.getW();	 Catch:{ Exception -> 0x03b6 }
        r5 = (float) r5;	 Catch:{ Exception -> 0x03b6 }
        r6 = r3.density;	 Catch:{ Exception -> 0x03b6 }
        r5 = r5 / r6;	 Catch:{ Exception -> 0x03b6 }
        r5 = java.lang.Math.round(r5);	 Catch:{ Exception -> 0x03b6 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r4, r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = "lh";	 Catch:{ Exception -> 0x03b6 }
        r5 = r14.getH();	 Catch:{ Exception -> 0x03b6 }
        r5 = (float) r5;	 Catch:{ Exception -> 0x03b6 }
        r3 = r3.density;	 Catch:{ Exception -> 0x03b6 }
        r5 = r5 / r3;	 Catch:{ Exception -> 0x03b6 }
        r3 = java.lang.Math.round(r5);	 Catch:{ Exception -> 0x03b6 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r4, r3);	 Catch:{ Exception -> 0x03b6 }
        r3 = "sn";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r0.getSn(r4);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = 3;
        r4 = 2;
        r5 = 1;
        r6 = 0;
        r7 = "";	 Catch:{ Exception -> 0x01b4 }
        r8 = r14.d;	 Catch:{ Exception -> 0x01b4 }
        r8 = r0.getCell(r8);	 Catch:{ Exception -> 0x01b4 }
        r9 = r8.size();	 Catch:{ Exception -> 0x01b4 }
        if (r9 <= 0) goto L_0x01b6;	 Catch:{ Exception -> 0x01b4 }
    L_0x017e:
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b4 }
        r7.<init>();	 Catch:{ Exception -> 0x01b4 }
        r9 = r6;	 Catch:{ Exception -> 0x01b4 }
    L_0x0184:
        r10 = r8.size();	 Catch:{ Exception -> 0x01b4 }
        if (r9 >= r10) goto L_0x01aa;	 Catch:{ Exception -> 0x01b4 }
    L_0x018a:
        r10 = r8.get(r9);	 Catch:{ Exception -> 0x01b4 }
        r10 = (java.lang.String[]) r10;	 Catch:{ Exception -> 0x01b4 }
        r11 = "%s_%s_%s|";	 Catch:{ Exception -> 0x01b4 }
        r12 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01b4 }
        r13 = r10[r6];	 Catch:{ Exception -> 0x01b4 }
        r12[r6] = r13;	 Catch:{ Exception -> 0x01b4 }
        r13 = r10[r5];	 Catch:{ Exception -> 0x01b4 }
        r12[r5] = r13;	 Catch:{ Exception -> 0x01b4 }
        r10 = r10[r4];	 Catch:{ Exception -> 0x01b4 }
        r12[r4] = r10;	 Catch:{ Exception -> 0x01b4 }
        r10 = java.lang.String.format(r11, r12);	 Catch:{ Exception -> 0x01b4 }
        r7.append(r10);	 Catch:{ Exception -> 0x01b4 }
        r9 = r9 + 1;	 Catch:{ Exception -> 0x01b4 }
        goto L_0x0184;	 Catch:{ Exception -> 0x01b4 }
    L_0x01aa:
        r8 = r7.length();	 Catch:{ Exception -> 0x01b4 }
        r8 = r8 - r5;	 Catch:{ Exception -> 0x01b4 }
        r7 = r7.substring(r6, r8);	 Catch:{ Exception -> 0x01b4 }
        goto L_0x01b6;
    L_0x01b4:
        r7 = "";	 Catch:{ Exception -> 0x03b6 }
    L_0x01b6:
        r8 = "cid";	 Catch:{ Exception -> 0x03b6 }
        r2.put(r8, r7);	 Catch:{ Exception -> 0x03b6 }
        r7 = "nop";	 Catch:{ Exception -> 0x03b6 }
        r8 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r8 = r0.getNetworkOperator(r8);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r7, r8);	 Catch:{ Exception -> 0x03b6 }
        r7 = "im";	 Catch:{ Exception -> 0x03b6 }
        r8 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r8 = r1.getSubscriberId(r8);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r7, r8);	 Catch:{ Exception -> 0x03b6 }
        r7 = r14.d;	 Catch:{ Exception -> 0x01ff }
        r7 = r0.getGPS(r7);	 Catch:{ Exception -> 0x01ff }
        r8 = "";	 Catch:{ Exception -> 0x01ff }
        if (r7 == 0) goto L_0x0201;	 Catch:{ Exception -> 0x01ff }
    L_0x01db:
        java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01ff }
        r8 = "%s_%s_%s";	 Catch:{ Exception -> 0x01ff }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01ff }
        r9 = r7[r6];	 Catch:{ Exception -> 0x01ff }
        r9 = java.lang.Double.valueOf(r9);	 Catch:{ Exception -> 0x01ff }
        r3[r6] = r9;	 Catch:{ Exception -> 0x01ff }
        r9 = r7[r5];	 Catch:{ Exception -> 0x01ff }
        r9 = java.lang.Double.valueOf(r9);	 Catch:{ Exception -> 0x01ff }
        r3[r5] = r9;	 Catch:{ Exception -> 0x01ff }
        r9 = r7[r4];	 Catch:{ Exception -> 0x01ff }
        r7 = java.lang.Double.valueOf(r9);	 Catch:{ Exception -> 0x01ff }
        r3[r4] = r7;	 Catch:{ Exception -> 0x01ff }
        r8 = java.lang.String.format(r8, r3);	 Catch:{ Exception -> 0x01ff }
        goto L_0x0201;
    L_0x01ff:
        r8 = "";	 Catch:{ Exception -> 0x03b6 }
    L_0x0201:
        r3 = "g";	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r8);	 Catch:{ Exception -> 0x03b6 }
        r3 = "";	 Catch:{ Exception -> 0x0247 }
        r7 = r14.d;	 Catch:{ Exception -> 0x0248 }
        r7 = r0.getWIFI(r7);	 Catch:{ Exception -> 0x0248 }
        r8 = r7.size();	 Catch:{ Exception -> 0x0248 }
        if (r8 <= 0) goto L_0x0248;	 Catch:{ Exception -> 0x0248 }
    L_0x0214:
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0248 }
        r8.<init>();	 Catch:{ Exception -> 0x0248 }
        r9 = r6;	 Catch:{ Exception -> 0x0248 }
    L_0x021a:
        r10 = r7.size();	 Catch:{ Exception -> 0x0248 }
        if (r9 >= r10) goto L_0x023c;	 Catch:{ Exception -> 0x0248 }
    L_0x0220:
        r10 = r7.get(r9);	 Catch:{ Exception -> 0x0248 }
        r10 = (java.lang.String[]) r10;	 Catch:{ Exception -> 0x0248 }
        r11 = "%s_%s|";	 Catch:{ Exception -> 0x0248 }
        r12 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0248 }
        r13 = r10[r6];	 Catch:{ Exception -> 0x0248 }
        r12[r6] = r13;	 Catch:{ Exception -> 0x0248 }
        r10 = r10[r5];	 Catch:{ Exception -> 0x0248 }
        r12[r5] = r10;	 Catch:{ Exception -> 0x0248 }
        r10 = java.lang.String.format(r11, r12);	 Catch:{ Exception -> 0x0248 }
        r8.append(r10);	 Catch:{ Exception -> 0x0248 }
        r9 = r9 + 1;	 Catch:{ Exception -> 0x0248 }
        goto L_0x021a;	 Catch:{ Exception -> 0x0248 }
    L_0x023c:
        r4 = r8.length();	 Catch:{ Exception -> 0x0248 }
        r4 = r4 - r5;	 Catch:{ Exception -> 0x0248 }
        r4 = r8.substring(r6, r4);	 Catch:{ Exception -> 0x0248 }
        r3 = r4;
        goto L_0x0248;
    L_0x0247:
        r3 = r8;
    L_0x0248:
        r4 = "wi";	 Catch:{ Exception -> 0x03b6 }
        r2.put(r4, r3);	 Catch:{ Exception -> 0x03b6 }
        r3 = "swi";	 Catch:{ Exception -> 0x03b6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r4.<init>();	 Catch:{ Exception -> 0x03b6 }
        r5 = "wifi";	 Catch:{ Exception -> 0x03b6 }
        r6 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r6 = r0.getNetworkType(r6);	 Catch:{ Exception -> 0x03b6 }
        r5 = r5.equals(r6);	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "tab";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r0.isTablet(r4);	 Catch:{ Exception -> 0x03b6 }
        if (r4 == 0) goto L_0x0277;	 Catch:{ Exception -> 0x03b6 }
    L_0x0274:
        r4 = "1";	 Catch:{ Exception -> 0x03b6 }
        goto L_0x0279;	 Catch:{ Exception -> 0x03b6 }
    L_0x0277:
        r4 = "0";	 Catch:{ Exception -> 0x03b6 }
    L_0x0279:
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "sdc";	 Catch:{ Exception -> 0x03b6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r4.<init>();	 Catch:{ Exception -> 0x03b6 }
        r5 = r0.getAppSDC();	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r5 = ",";	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r5 = r0.getMem();	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "act";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.getAct();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "prod";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.getProd();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "os";	 Catch:{ Exception -> 0x03b6 }
        r4 = "android";	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "osv";	 Catch:{ Exception -> 0x03b6 }
        r4 = android.os.Build.VERSION.RELEASE;	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "bdr";	 Catch:{ Exception -> 0x03b6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r4.<init>();	 Catch:{ Exception -> 0x03b6 }
        r5 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "apinfo";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r1.getBaiduMapsInfo(r4);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "apid";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.getApid();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "chid";	 Catch:{ Exception -> 0x03b6 }
        r4 = r1.getChannelId();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "apt";	 Catch:{ Exception -> 0x03b6 }
        r4 = "0";	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "ap";	 Catch:{ Exception -> 0x03b6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r4.<init>();	 Catch:{ Exception -> 0x03b6 }
        r5 = r14.getAp();	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "nt";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r0.getNetType(r4);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "udid";	 Catch:{ Exception -> 0x03b6 }
        r4 = "";	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "ses";	 Catch:{ Exception -> 0x03b6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03b6 }
        r4.<init>();	 Catch:{ Exception -> 0x03b6 }
        r5 = r14.getSes();	 Catch:{ Exception -> 0x03b6 }
        r4.append(r5);	 Catch:{ Exception -> 0x03b6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "android_id";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r0.getAndroidId(r4);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "imei";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r0.getIMEI(r4);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "mac";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r0.getMacAddress(r4);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "cuid";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r0.getCUID(r4);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "snfrom";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r4 = r0.getSnFrom(r4);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "p_ver";	 Catch:{ Exception -> 0x03b6 }
        r4 = "8.7036";	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x03b6 }
        r3 = "req_id";	 Catch:{ Exception -> 0x03b6 }
        r4 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r5 = r14.getApid();	 Catch:{ Exception -> 0x03b6 }
        r1 = r1.createRequestId(r4, r5);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r3, r1);	 Catch:{ Exception -> 0x03b6 }
        r1 = "cssid";	 Catch:{ Exception -> 0x03b6 }
        r3 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r3 = r0.isWifiConnected(r3);	 Catch:{ Exception -> 0x03b6 }
        r3 = r3.booleanValue();	 Catch:{ Exception -> 0x03b6 }
        if (r3 == 0) goto L_0x0392;	 Catch:{ Exception -> 0x03b6 }
    L_0x038b:
        r3 = r14.d;	 Catch:{ Exception -> 0x03b6 }
        r0 = r0.getWifiConnected(r3);	 Catch:{ Exception -> 0x03b6 }
        goto L_0x0394;	 Catch:{ Exception -> 0x03b6 }
    L_0x0392:
        r0 = "";	 Catch:{ Exception -> 0x03b6 }
    L_0x0394:
        r2.put(r1, r0);	 Catch:{ Exception -> 0x03b6 }
        r0 = com.baidu.mobads.AdSettings.getSupportHttps();	 Catch:{ Exception -> 0x03b6 }
        r1 = com.baidu.mobads.AdSettings.b.HTTPS_PROTOCOL_TYPE;	 Catch:{ Exception -> 0x03b6 }
        r1 = r1.a();	 Catch:{ Exception -> 0x03b6 }
        r0 = r0.equals(r1);	 Catch:{ Exception -> 0x03b6 }
        if (r0 == 0) goto L_0x03b6;	 Catch:{ Exception -> 0x03b6 }
    L_0x03a7:
        r0 = "rpt";	 Catch:{ Exception -> 0x03b6 }
        r1 = com.baidu.mobads.AdSettings.b.HTTPS_PROTOCOL_TYPE;	 Catch:{ Exception -> 0x03b6 }
        r1 = r1.a();	 Catch:{ Exception -> 0x03b6 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x03b6 }
        r2.put(r0, r1);	 Catch:{ Exception -> 0x03b6 }
    L_0x03b6:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.vo.d.e():java.util.HashMap<java.lang.String, java.lang.String>");
    }

    public String b() {
        HashMap e = e();
        e.putAll(a());
        return XAdSDKFoundationFacade.getInstance().getURIUitls().getRequestAdUrl(this.b, e);
    }

    public boolean isCanClick() {
        return this.u;
    }

    public void a(boolean z) {
        this.u = z;
    }

    public String f() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public int getW() {
        return this.m;
    }

    public void d(int i) {
        this.m = i;
    }

    public int getH() {
        return this.n;
    }

    public void e(int i) {
        this.n = i;
    }

    public String getAct() {
        return this.p;
    }

    public void b(String str) {
        this.p = str;
    }

    public String getProd() {
        return this.q;
    }

    public void c(String str) {
        this.q = str;
    }

    public int getApt() {
        return this.r;
    }

    public void f(int i) {
        this.r = i;
    }

    public int getN() {
        return this.t;
    }

    public void g(int i) {
        this.t = i;
    }

    public long getSes() {
        return this.v;
    }

    public int getAp() {
        return this.s;
    }

    public void h(int i) {
        this.s = i;
    }

    public String getApid() {
        return this.l;
    }

    public void d(String str) {
        this.l = str;
    }

    public int getAt() {
        return this.o;
    }

    public void i(int i) {
        this.o = i;
    }

    private void a(Context context) {
        if ("0.0".equals(a.c)) {
            double b = g.b(context);
            if (b > 0.0d) {
                a.c = String.valueOf(b);
            }
        }
    }
}
