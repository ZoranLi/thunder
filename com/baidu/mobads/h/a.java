package com.baidu.mobads.h;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class a {
    private static Method d;
    private static Method e;
    private static Method f;
    private static Class<?> g;
    private static char[] n = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    private Context a = null;
    private TelephonyManager b = null;
    private a c = new a();
    private WifiManager h = null;
    private b i = null;
    private long j = 0;
    private String k = null;
    private int l;
    private String m;

    private class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public char e;
        final /* synthetic */ a f;

        private a(a aVar) {
            this.f = aVar;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = null;
        }

        private boolean b() {
            return this.a >= 0 && this.b > 0;
        }

        public String a() {
            if (!b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.e);
            stringBuffer.append(IXAdRequestInfo.HEIGHT);
            if (this.c != 460) {
                stringBuffer.append(this.c);
            }
            stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", new Object[]{Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b)}));
            return stringBuffer.toString();
        }
    }

    protected class b {
        public List<ScanResult> a = null;
        final /* synthetic */ a b;
        private long c = 0;

        public b(a aVar, List<ScanResult> list) {
            this.b = aVar;
            this.a = list;
            this.c = System.currentTimeMillis();
            b();
        }

        public int a() {
            if (this.a == null) {
                return 0;
            }
            return this.a.size();
        }

        public String a(int i) {
            String str = null;
            if (a() <= 0) {
                return null;
            }
            Object obj;
            boolean a = this.b.c();
            if (a) {
                i--;
                obj = null;
            } else {
                obj = 1;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.a.size();
            int i2 = 0;
            Object obj2 = 1;
            Object obj3 = obj;
            for (int i3 = i2; i3 < size; i3++) {
                if (((ScanResult) this.a.get(i3)).level != 0) {
                    String str2 = ((ScanResult) this.a.get(i3)).BSSID;
                    int i4 = ((ScanResult) this.a.get(i3)).level;
                    str2 = str2.replace(Constants.COLON_SEPARATOR, "");
                    if (this.b.k == null || !str2.equals(this.b.k)) {
                        if (i2 < i) {
                            stringBuffer.append(IXAdRequestInfo.HEIGHT);
                            stringBuffer.append(str2);
                            stringBuffer.append("m");
                            stringBuffer.append(StrictMath.abs(i4));
                            i2++;
                            obj2 = null;
                        }
                        if (i2 > i && r8 != null) {
                            break;
                        }
                    }
                    this.b.l = StrictMath.abs(i4);
                    obj3 = 1;
                }
            }
            if (a) {
                i = new StringBuilder(IXAdRequestInfo.HEIGHT);
                i.append(this.b.k);
                i.append("km");
                i.append(this.b.l);
                str = i.toString();
            }
            if (obj2 != null) {
                return str;
            }
            i = new StringBuilder();
            i.append(str);
            i.append(stringBuffer.toString());
            return i.toString();
        }

        private void b() {
            if (a() > 0) {
                int size = this.a.size() - 1;
                int i = 1;
                while (size > 0 && r2 != 0) {
                    i = 0;
                    int i2 = 0;
                    while (i < size) {
                        int i3 = i + 1;
                        if (((ScanResult) this.a.get(i)).level < ((ScanResult) this.a.get(i3)).level) {
                            ScanResult scanResult = (ScanResult) this.a.get(i3);
                            this.a.set(i3, this.a.get(i));
                            this.a.set(i, scanResult);
                            i2 = 1;
                        }
                        i = i3;
                    }
                    size--;
                    i = i2;
                }
            }
        }

        private boolean c() {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            if (currentTimeMillis >= 0) {
                if (currentTimeMillis <= 500) {
                    return false;
                }
            }
            return true;
        }
    }

    private int b(int i) {
        return i == Integer.MAX_VALUE ? -1 : i;
    }

    public a(android.content.Context r6) {
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
        r5 = this;
        r5.<init>();
        r0 = 0;
        r5.a = r0;
        r5.b = r0;
        r1 = new com.baidu.mobads.h.a$a;
        r1.<init>();
        r5.c = r1;
        r5.h = r0;
        r5.i = r0;
        r1 = 0;
        r5.j = r1;
        r5.k = r0;
        r1 = 0;
        r5.l = r1;
        r5.m = r0;
        r6 = r6.getApplicationContext();
        r5.a = r6;
        r6 = r5.a;
        r6 = r6.getPackageName();
        r2 = r5.a;	 Catch:{ Exception -> 0x0057 }
        r3 = "phone";	 Catch:{ Exception -> 0x0057 }
        r2 = r2.getSystemService(r3);	 Catch:{ Exception -> 0x0057 }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x0057 }
        r5.b = r2;	 Catch:{ Exception -> 0x0057 }
        r2 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0057 }
        r2 = r2.getBase64();	 Catch:{ Exception -> 0x0057 }
        r3 = "uvNYwANvpyP-iyfb";	 Catch:{ Exception -> 0x0057 }
        r2 = r2.decodeStr(r3);	 Catch:{ Exception -> 0x0057 }
        r3 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0057 }
        r3 = r3.getCommonUtils();	 Catch:{ Exception -> 0x0057 }
        r4 = r5.b;	 Catch:{ Exception -> 0x0057 }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0057 }
        r1 = r3.a(r4, r2, r1);	 Catch:{ Exception -> 0x0057 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0057 }
        r0 = r1;
    L_0x0057:
        r1 = new java.lang.StringBuilder;
        r2 = "&";
        r1.<init>(r2);
        r1.append(r6);
        r6 = "&";
        r1.append(r6);
        r1.append(r0);
        r6 = r1.toString();
        r5.m = r6;
        r6 = r5.a;
        r0 = "wifi";
        r6 = r6.getSystemService(r0);
        r6 = (android.net.wifi.WifiManager) r6;
        r5.h = r6;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.a.<init>(android.content.Context):void");
    }

    public java.lang.String a() {
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
        r1 = this;
        r0 = 10;
        r0 = r1.a(r0);	 Catch:{ Exception -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.a.a():java.lang.String");
    }

    private java.lang.String a(int r5) {
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
        r0 = 3;
        if (r5 >= r0) goto L_0x0004;
    L_0x0003:
        r5 = r0;
    L_0x0004:
        r0 = 0;
        r1 = r4.b();	 Catch:{ Exception -> 0x0025 }
        if (r1 == 0) goto L_0x0015;	 Catch:{ Exception -> 0x0025 }
    L_0x000b:
        r2 = r1.b();	 Catch:{ Exception -> 0x0025 }
        if (r2 != 0) goto L_0x0012;	 Catch:{ Exception -> 0x0025 }
    L_0x0011:
        goto L_0x0015;	 Catch:{ Exception -> 0x0025 }
    L_0x0012:
        r4.c = r1;	 Catch:{ Exception -> 0x0025 }
        goto L_0x001e;	 Catch:{ Exception -> 0x0025 }
    L_0x0015:
        r1 = r4.b;	 Catch:{ Exception -> 0x0025 }
        r1 = r1.getCellLocation();	 Catch:{ Exception -> 0x0025 }
        r4.a(r1);	 Catch:{ Exception -> 0x0025 }
    L_0x001e:
        r1 = r4.c;	 Catch:{ Exception -> 0x0025 }
        r1 = r1.a();	 Catch:{ Exception -> 0x0025 }
        goto L_0x0026;
    L_0x0025:
        r1 = r0;
    L_0x0026:
        if (r1 != 0) goto L_0x002a;
    L_0x0028:
        r1 = "Z";
    L_0x002a:
        r2 = r4.i;	 Catch:{ Exception -> 0x004a }
        if (r2 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x004a }
    L_0x002e:
        r2 = r4.i;	 Catch:{ Exception -> 0x004a }
        r2 = r2.c();	 Catch:{ Exception -> 0x004a }
        if (r2 == 0) goto L_0x0043;	 Catch:{ Exception -> 0x004a }
    L_0x0036:
        r2 = new com.baidu.mobads.h.a$b;	 Catch:{ Exception -> 0x004a }
        r3 = r4.h;	 Catch:{ Exception -> 0x004a }
        r3 = r3.getScanResults();	 Catch:{ Exception -> 0x004a }
        r2.<init>(r4, r3);	 Catch:{ Exception -> 0x004a }
        r4.i = r2;	 Catch:{ Exception -> 0x004a }
    L_0x0043:
        r2 = r4.i;	 Catch:{ Exception -> 0x004a }
        r5 = r2.a(r5);	 Catch:{ Exception -> 0x004a }
        goto L_0x004b;
    L_0x004a:
        r5 = r0;
    L_0x004b:
        if (r5 == 0) goto L_0x005c;
    L_0x004d:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2.append(r5);
        r1 = r2.toString();
    L_0x005c:
        r5 = "Z";
        r5 = r1.equals(r5);
        if (r5 == 0) goto L_0x0065;
    L_0x0064:
        return r0;
    L_0x0065:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5.append(r1);
        r0 = "t";
        r5.append(r0);
        r0 = java.lang.System.currentTimeMillis();
        r5.append(r0);
        r0 = r4.m;
        r5.append(r0);
        r5 = r5.toString();
        r5 = a(r5);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.a.a(int):java.lang.String");
    }

    private void a(android.telephony.CellLocation r8) {
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
        if (r8 == 0) goto L_0x0105;
    L_0x0002:
        r0 = r7.b;
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        goto L_0x0105;
    L_0x0008:
        r0 = new com.baidu.mobads.h.a$a;
        r1 = 0;
        r0.<init>();
        r2 = r7.b;
        r2 = r2.getNetworkOperator();
        r3 = 0;
        if (r2 == 0) goto L_0x0066;
    L_0x0017:
        r4 = r2.length();
        if (r4 <= 0) goto L_0x0066;
    L_0x001d:
        r4 = r2.length();	 Catch:{ Exception -> 0x0066 }
        r5 = 3;	 Catch:{ Exception -> 0x0066 }
        if (r4 < r5) goto L_0x0038;	 Catch:{ Exception -> 0x0066 }
    L_0x0024:
        r4 = r2.substring(r3, r5);	 Catch:{ Exception -> 0x0066 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0066 }
        r4 = r4.intValue();	 Catch:{ Exception -> 0x0066 }
        if (r4 >= 0) goto L_0x0036;	 Catch:{ Exception -> 0x0066 }
    L_0x0032:
        r4 = r7.c;	 Catch:{ Exception -> 0x0066 }
        r4 = r4.c;	 Catch:{ Exception -> 0x0066 }
    L_0x0036:
        r0.c = r4;	 Catch:{ Exception -> 0x0066 }
    L_0x0038:
        r2 = r2.substring(r5);	 Catch:{ Exception -> 0x0066 }
        if (r2 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x0066 }
    L_0x003e:
        r4 = r2.toCharArray();	 Catch:{ Exception -> 0x0066 }
        r5 = r3;	 Catch:{ Exception -> 0x0066 }
    L_0x0043:
        r6 = r4.length;	 Catch:{ Exception -> 0x0066 }
        if (r5 >= r6) goto L_0x0052;	 Catch:{ Exception -> 0x0066 }
    L_0x0046:
        r6 = r4[r5];	 Catch:{ Exception -> 0x0066 }
        r6 = java.lang.Character.isDigit(r6);	 Catch:{ Exception -> 0x0066 }
        if (r6 == 0) goto L_0x0052;	 Catch:{ Exception -> 0x0066 }
    L_0x004e:
        r5 = r5 + 1;	 Catch:{ Exception -> 0x0066 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0066 }
    L_0x0051:
        r5 = r3;	 Catch:{ Exception -> 0x0066 }
    L_0x0052:
        r2 = r2.substring(r3, r5);	 Catch:{ Exception -> 0x0066 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0066 }
        r2 = r2.intValue();	 Catch:{ Exception -> 0x0066 }
        if (r2 >= 0) goto L_0x0064;	 Catch:{ Exception -> 0x0066 }
    L_0x0060:
        r2 = r7.c;	 Catch:{ Exception -> 0x0066 }
        r2 = r2.d;	 Catch:{ Exception -> 0x0066 }
    L_0x0064:
        r0.d = r2;	 Catch:{ Exception -> 0x0066 }
    L_0x0066:
        r2 = r8 instanceof android.telephony.gsm.GsmCellLocation;
        if (r2 == 0) goto L_0x007e;
    L_0x006a:
        r8 = (android.telephony.gsm.GsmCellLocation) r8;
        r1 = r8.getLac();
        r0.a = r1;
        r8 = r8.getCid();
        r0.b = r8;
        r8 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r0.e = r8;
        goto L_0x00fc;
    L_0x007e:
        r2 = r8 instanceof android.telephony.cdma.CdmaCellLocation;
        if (r2 == 0) goto L_0x00fc;
    L_0x0082:
        r2 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        r0.e = r2;
        r2 = g;
        if (r2 != 0) goto L_0x00b8;
    L_0x008a:
        r2 = "android.telephony.cdma.CdmaCellLocation";	 Catch:{ Exception -> 0x00b5 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x00b5 }
        g = r2;	 Catch:{ Exception -> 0x00b5 }
        r4 = "getBaseStationId";	 Catch:{ Exception -> 0x00b5 }
        r5 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.getMethod(r4, r5);	 Catch:{ Exception -> 0x00b5 }
        d = r2;	 Catch:{ Exception -> 0x00b5 }
        r2 = g;	 Catch:{ Exception -> 0x00b5 }
        r4 = "getNetworkId";	 Catch:{ Exception -> 0x00b5 }
        r5 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.getMethod(r4, r5);	 Catch:{ Exception -> 0x00b5 }
        e = r2;	 Catch:{ Exception -> 0x00b5 }
        r2 = g;	 Catch:{ Exception -> 0x00b5 }
        r4 = "getSystemId";	 Catch:{ Exception -> 0x00b5 }
        r5 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.getMethod(r4, r5);	 Catch:{ Exception -> 0x00b5 }
        f = r2;	 Catch:{ Exception -> 0x00b5 }
        goto L_0x00b8;
    L_0x00b5:
        g = r1;
        return;
    L_0x00b8:
        r1 = g;
        if (r1 == 0) goto L_0x00fc;
    L_0x00bc:
        r1 = g;
        r1 = r1.isInstance(r8);
        if (r1 == 0) goto L_0x00fc;
    L_0x00c4:
        r1 = f;	 Catch:{ Exception -> 0x00fb }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00fb }
        r1 = r1.invoke(r8, r2);	 Catch:{ Exception -> 0x00fb }
        r1 = (java.lang.Integer) r1;	 Catch:{ Exception -> 0x00fb }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x00fb }
        if (r1 >= 0) goto L_0x00d8;	 Catch:{ Exception -> 0x00fb }
    L_0x00d4:
        r1 = r7.c;	 Catch:{ Exception -> 0x00fb }
        r1 = r1.d;	 Catch:{ Exception -> 0x00fb }
    L_0x00d8:
        r0.d = r1;	 Catch:{ Exception -> 0x00fb }
        r1 = d;	 Catch:{ Exception -> 0x00fb }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00fb }
        r1 = r1.invoke(r8, r2);	 Catch:{ Exception -> 0x00fb }
        r1 = (java.lang.Integer) r1;	 Catch:{ Exception -> 0x00fb }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x00fb }
        r0.b = r1;	 Catch:{ Exception -> 0x00fb }
        r1 = e;	 Catch:{ Exception -> 0x00fb }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00fb }
        r8 = r1.invoke(r8, r2);	 Catch:{ Exception -> 0x00fb }
        r8 = (java.lang.Integer) r8;	 Catch:{ Exception -> 0x00fb }
        r8 = r8.intValue();	 Catch:{ Exception -> 0x00fb }
        r0.a = r8;	 Catch:{ Exception -> 0x00fb }
        goto L_0x00fc;
    L_0x00fb:
        return;
    L_0x00fc:
        r8 = r0.b();
        if (r8 == 0) goto L_0x0104;
    L_0x0102:
        r7.c = r0;
    L_0x0104:
        return;
    L_0x0105:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.a.a(android.telephony.CellLocation):void");
    }

    private com.baidu.mobads.h.a.a b() {
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
        r5 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r0.intValue();
        r1 = 0;
        r2 = 17;
        if (r0 >= r2) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r5.b;	 Catch:{ Exception -> 0x0049, Exception -> 0x0049 }
        r0 = r0.getAllCellInfo();	 Catch:{ Exception -> 0x0049, Exception -> 0x0049 }
        if (r0 == 0) goto L_0x0049;	 Catch:{ Exception -> 0x0049, Exception -> 0x0049 }
    L_0x0018:
        r2 = r0.size();	 Catch:{ Exception -> 0x0049, Exception -> 0x0049 }
        if (r2 <= 0) goto L_0x0049;	 Catch:{ Exception -> 0x0049, Exception -> 0x0049 }
    L_0x001e:
        r0 = r0.iterator();	 Catch:{ Exception -> 0x0049, Exception -> 0x0049 }
        r2 = r1;
    L_0x0023:
        r3 = r0.hasNext();	 Catch:{ Exception -> 0x0048 }
        if (r3 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x0048 }
    L_0x0029:
        r3 = r0.next();	 Catch:{ Exception -> 0x0048 }
        r3 = (android.telephony.CellInfo) r3;	 Catch:{ Exception -> 0x0048 }
        r4 = r3.isRegistered();	 Catch:{ Exception -> 0x0048 }
        if (r4 == 0) goto L_0x0023;	 Catch:{ Exception -> 0x0048 }
    L_0x0035:
        r3 = r5.a(r3);	 Catch:{ Exception -> 0x0048 }
        if (r3 == 0) goto L_0x0046;
    L_0x003b:
        r0 = r3.b();	 Catch:{ Exception -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x0041:
        goto L_0x0043;
    L_0x0042:
        r1 = r3;
    L_0x0043:
        return r1;
    L_0x0044:
        r1 = r3;
        goto L_0x0049;
    L_0x0046:
        r2 = r3;
        goto L_0x0023;
    L_0x0048:
        r1 = r2;
    L_0x0049:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.a.b():com.baidu.mobads.h.a$a");
    }

    private com.baidu.mobads.h.a.a a(android.telephony.CellInfo r7) {
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
        r6 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r0.intValue();
        r1 = 0;
        r2 = 17;
        if (r0 >= r2) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r2 = new com.baidu.mobads.h.a$a;
        r2.<init>();
        r1 = 0;
        r3 = r7 instanceof android.telephony.CellInfoGsm;
        r4 = 1;
        r5 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        if (r3 == 0) goto L_0x004f;
    L_0x001d:
        r1 = r7;
        r1 = (android.telephony.CellInfoGsm) r1;
        r1 = r1.getCellIdentity();
        r3 = r1.getMcc();
        r3 = r6.b(r3);
        r2.c = r3;
        r3 = r1.getMnc();
        r3 = r6.b(r3);
        r2.d = r3;
        r3 = r1.getLac();
        r3 = r6.b(r3);
        r2.a = r3;
        r1 = r1.getCid();
        r1 = r6.b(r1);
        r2.b = r1;
        r2.e = r5;
        goto L_0x00b4;
    L_0x004f:
        r3 = r7 instanceof android.telephony.CellInfoCdma;
        if (r3 == 0) goto L_0x007d;
    L_0x0053:
        r1 = r7;
        r1 = (android.telephony.CellInfoCdma) r1;
        r1 = r1.getCellIdentity();
        r3 = r1.getSystemId();
        r3 = r6.b(r3);
        r2.d = r3;
        r3 = r1.getNetworkId();
        r3 = r6.b(r3);
        r2.a = r3;
        r1 = r1.getBasestationId();
        r1 = r6.b(r1);
        r2.b = r1;
        r1 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        r2.e = r1;
        goto L_0x00b4;
    L_0x007d:
        r3 = r7 instanceof android.telephony.CellInfoLte;
        if (r3 == 0) goto L_0x00b3;
    L_0x0081:
        r1 = r7;
        r1 = (android.telephony.CellInfoLte) r1;
        r1 = r1.getCellIdentity();
        r3 = r1.getMcc();
        r3 = r6.b(r3);
        r2.c = r3;
        r3 = r1.getMnc();
        r3 = r6.b(r3);
        r2.d = r3;
        r3 = r1.getTac();
        r3 = r6.b(r3);
        r2.a = r3;
        r1 = r1.getCi();
        r1 = r6.b(r1);
        r2.b = r1;
        r2.e = r5;
        goto L_0x00b4;
    L_0x00b3:
        r4 = r1;
    L_0x00b4:
        r1 = 18;
        if (r0 < r1) goto L_0x00ee;
    L_0x00b8:
        if (r4 != 0) goto L_0x00ee;
    L_0x00ba:
        r0 = r7 instanceof android.telephony.CellInfoWcdma;	 Catch:{ Exception -> 0x00ee }
        if (r0 == 0) goto L_0x00ee;	 Catch:{ Exception -> 0x00ee }
    L_0x00be:
        r7 = (android.telephony.CellInfoWcdma) r7;	 Catch:{ Exception -> 0x00ee }
        r7 = r7.getCellIdentity();	 Catch:{ Exception -> 0x00ee }
        r0 = r7.getMcc();	 Catch:{ Exception -> 0x00ee }
        r0 = r6.b(r0);	 Catch:{ Exception -> 0x00ee }
        r2.c = r0;	 Catch:{ Exception -> 0x00ee }
        r0 = r7.getMnc();	 Catch:{ Exception -> 0x00ee }
        r0 = r6.b(r0);	 Catch:{ Exception -> 0x00ee }
        r2.d = r0;	 Catch:{ Exception -> 0x00ee }
        r0 = r7.getLac();	 Catch:{ Exception -> 0x00ee }
        r0 = r6.b(r0);	 Catch:{ Exception -> 0x00ee }
        r2.a = r0;	 Catch:{ Exception -> 0x00ee }
        r7 = r7.getCid();	 Catch:{ Exception -> 0x00ee }
        r7 = r6.b(r7);	 Catch:{ Exception -> 0x00ee }
        r2.b = r7;	 Catch:{ Exception -> 0x00ee }
        r2.e = r5;	 Catch:{ Exception -> 0x00ee }
    L_0x00ee:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.a.a(android.telephony.CellInfo):com.baidu.mobads.h.a$a");
    }

    private boolean c() {
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
        r0 = 0;
        r4.k = r0;
        r1 = 0;
        r4.l = r1;
        r2 = r4.h;
        r2 = r2.getConnectionInfo();
        if (r2 != 0) goto L_0x000f;
    L_0x000e:
        return r1;
    L_0x000f:
        r2 = r2.getBSSID();	 Catch:{ Exception -> 0x002f }
        if (r2 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x002f }
    L_0x0015:
        r0 = ":";	 Catch:{ Exception -> 0x002f }
        r3 = "";	 Catch:{ Exception -> 0x002f }
        r0 = r2.replace(r0, r3);	 Catch:{ Exception -> 0x002f }
    L_0x001d:
        r2 = r0.length();	 Catch:{ Exception -> 0x002f }
        r3 = 12;	 Catch:{ Exception -> 0x002f }
        if (r2 == r3) goto L_0x0026;	 Catch:{ Exception -> 0x002f }
    L_0x0025:
        return r1;	 Catch:{ Exception -> 0x002f }
    L_0x0026:
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x002f }
        r2.<init>(r0);	 Catch:{ Exception -> 0x002f }
        r4.k = r2;	 Catch:{ Exception -> 0x002f }
        r0 = 1;
        return r0;
    L_0x002f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.a.c():boolean");
    }

    private static String a(String str) {
        if (str == null) {
            return null;
        }
        str = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        int i = 0;
        byte[] bArr = new byte[(str.length + 2)];
        int length = str.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (str[i] ^ nextInt);
            i++;
            i2 = i3;
        }
        str = i2 + 1;
        bArr[i2] = nextInt;
        bArr[str] = nextInt2;
        return a(bArr);
    }

    private static String a(byte[] bArr) {
        char[] cArr = new char[(((bArr.length + 2) / 3) * 4)];
        int i = 0;
        int i2 = i;
        while (i < bArr.length) {
            Object obj;
            int i3 = (bArr[i] & 255) << 8;
            int i4 = i + 1;
            Object obj2 = 1;
            if (i4 < bArr.length) {
                i3 |= bArr[i4] & 255;
                obj = 1;
            } else {
                obj = null;
            }
            i3 <<= 8;
            int i5 = i + 2;
            if (i5 < bArr.length) {
                i3 |= 255 & bArr[i5];
            } else {
                obj2 = null;
            }
            int i6 = 64;
            cArr[i2 + 3] = n[obj2 != null ? 63 - (i3 & 63) : 64];
            i3 >>= 6;
            int i7 = i2 + 2;
            char[] cArr2 = n;
            if (obj != null) {
                i6 = 63 - (i3 & 63);
            }
            cArr[i7] = cArr2[i6];
            i3 >>= 6;
            cArr[i2 + 1] = n[63 - (i3 & 63)];
            cArr[i2 + 0] = n[63 - ((i3 >> 6) & 63)];
            i += 3;
            i2 += 4;
        }
        return new String(cArr);
    }
}
