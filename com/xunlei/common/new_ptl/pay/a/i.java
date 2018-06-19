package com.xunlei.common.new_ptl.pay.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClient;
import com.xunlei.common.new_ptl.pay.XLContractor;
import com.xunlei.common.new_ptl.pay.XLOnPayListener;
import com.xunlei.common.new_ptl.pay.XLPayType;
import com.xunlei.common.new_ptl.pay.c.b;
import com.xunlei.common.new_ptl.pay.c.d;
import com.xunlei.common.new_ptl.pay.js.c;
import com.xunlei.common.new_ptl.pay.js.export.IXLPayJSHandler;
import com.xunlei.common.new_ptl.pay.param.XLAlipayParam;
import com.xunlei.common.new_ptl.pay.param.XLContractParam;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLPriceParam;
import com.xunlei.common.new_ptl.pay.param.XLWxPayParam;
import com.xunlei.common.stat.XLStatUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ssl.AbstractVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* compiled from: XLPayUtilProxy */
public final class i {
    private static final String a = "i";
    private static final int b = 4132;
    private static final int c = 4133;
    private static i d;
    private Context e = null;
    private int f = 0;
    private String g = "1";
    private String h = "ABCDEF0123456789";
    private String i = "2.7.2.178225";
    private boolean j = false;
    private Handler k = null;
    private XLStatUtil l = null;
    private j m = null;
    private BaseHttpClient n = null;
    private List<XLOnPayListener> o = new LinkedList();
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, h> p = new HashMap();
    private Map<WebView, c> q = new HashMap();
    private boolean r = true;

    /* compiled from: XLPayUtilProxy */
    class a extends AbstractVerifier {
        private final X509HostnameVerifier a;
        private final String b;
        private /* synthetic */ i c;

        public a(i iVar, X509HostnameVerifier x509HostnameVerifier) {
            this.a = x509HostnameVerifier;
        }

        public final void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
            StringBuilder stringBuilder = new StringBuilder("XLNewLoginVerifier pay verify host = ");
            stringBuilder.append(str);
            XLLog.v("XLNewLoginVerifier", stringBuilder.toString());
            if (a(strArr, strArr2)) {
                try {
                    this.a.verify(str, strArr, strArr2);
                    return;
                } catch (String str2) {
                    throw str2;
                }
            }
            throw new SSLException("CA certificate not belong to XunLei!");
        }

        private static boolean a(String[] strArr, String[] strArr2) {
            int i = 0;
            if (strArr != null) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    if (!TextUtils.isEmpty(strArr[i2]) && strArr[i2].contains("xunlei.com")) {
                        strArr = 1;
                        break;
                    }
                    i2++;
                }
                strArr = null;
                if (strArr != null) {
                    return strArr;
                }
            } else {
                strArr = null;
            }
            if (strArr2 == null) {
                return strArr;
            }
            while (i < strArr2.length) {
                if (!TextUtils.isEmpty(strArr2[i]) && strArr2[i].contains("xunlei.com")) {
                    return 1;
                }
                i++;
            }
            return strArr;
        }
    }

    private i() {
    }

    public static i a() {
        if (d == null) {
            d = new i();
        }
        return d;
    }

    public final void a(android.content.Context r7, int r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.j;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        if (r7 == 0) goto L_0x00a8;
    L_0x0007:
        r0 = 1;
        r6.j = r0;
        r6.r = r12;
        r6.e = r7;
        r6.f = r8;
        r6.g = r9;
        r6.h = r10;
        r8 = new com.xunlei.common.httpclient.AsyncHttpClient;
        r9 = r6.i;
        r8.<init>(r9);
        r6.n = r8;
        r8 = org.apache.http.conn.ssl.SSLSocketFactory.class;	 Catch:{ Exception -> 0x0032 }
        r9 = 0;	 Catch:{ Exception -> 0x0032 }
        r10 = new java.lang.Class[r9];	 Catch:{ Exception -> 0x0032 }
        r8 = r8.getDeclaredConstructor(r10);	 Catch:{ Exception -> 0x0032 }
        r8.setAccessible(r0);	 Catch:{ Exception -> 0x0032 }
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0032 }
        r8 = r8.newInstance(r9);	 Catch:{ Exception -> 0x0032 }
        r8 = (org.apache.http.conn.ssl.SSLSocketFactory) r8;	 Catch:{ Exception -> 0x0032 }
        goto L_0x0036;
    L_0x0032:
        r8 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
    L_0x0036:
        r9 = new com.xunlei.common.new_ptl.pay.a.i$a;
        r10 = r8.getHostnameVerifier();
        r9.<init>(r6, r10);
        r8.setHostnameVerifier(r9);
        r9 = r6.n;
        r9.setSSLSocketFactory(r8);
        r8 = com.xunlei.common.new_ptl.pay.b.a.a.a();
        r9 = r6.e;
        r8.a(r9);
        r8 = com.xunlei.common.device.XLDeviceGen.getInstance();	 Catch:{ XLDeviceExecption -> 0x005c }
        r9 = r6.f;	 Catch:{ XLDeviceExecption -> 0x005c }
        r10 = r6.i;	 Catch:{ XLDeviceExecption -> 0x005c }
        r8.initialize(r9, r11, r10, r7);	 Catch:{ XLDeviceExecption -> 0x005c }
        goto L_0x0077;
    L_0x005c:
        r7 = move-exception;
        r7.printStackTrace();
        r8 = "PayUtilProxy";
        r9 = new java.lang.StringBuilder;
        r10 = "XLDeviceGen initialize error = ";
        r9.<init>(r10);
        r7 = r7.getMessage();
        r9.append(r7);
        r7 = r9.toString();
        com.xunlei.common.base.XLLog.v(r8, r7);
    L_0x0077:
        r7 = com.xunlei.common.stat.XLStatUtil.getInstance();
        r6.l = r7;
        r0 = r6.l;
        r1 = r6.e;
        r2 = r6.f;
        r3 = r6.g;
        r4 = r6.i;
        r5 = r6.h;
        r0.init(r1, r2, r3, r4, r5);
        r7 = new com.xunlei.common.new_ptl.pay.a.j;
        r8 = r6.l;
        r7.<init>(r8);
        r6.m = r7;
        r7 = r6.m;
        r6.a(r7);
        r7 = new com.xunlei.common.new_ptl.pay.a.i$1;
        r7.<init>(r6);
        r6.k = r7;
        r7 = a;
        r8 = "xl pay util init";
        com.xunlei.common.base.XLLog.v(r7, r8);
    L_0x00a8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.pay.a.i.a(android.content.Context, int, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    public final void b() {
        if (this.j) {
            this.j = false;
            this.l.uninit();
            XLLog.v(a, "xl pay util uninit");
        }
    }

    public final synchronized void a(XLOnPayListener xLOnPayListener) {
        this.o.add(xLOnPayListener);
    }

    public final synchronized void b(XLOnPayListener xLOnPayListener) {
        this.o.remove(xLOnPayListener);
    }

    public final Handler c() {
        return this.k;
    }

    public final Context d() {
        return this.e;
    }

    public final BaseHttpClient e() {
        return this.n;
    }

    public final String f() {
        return this.i;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final int i() {
        return this.f;
    }

    public final String j() {
        return this.e.getApplicationInfo().packageName;
    }

    private boolean m() {
        return this.r;
    }

    public final XLStatUtil k() {
        return this.l;
    }

    public final void a(Object... objArr) {
        if (this.k != null) {
            this.k.obtainMessage(c, objArr).sendToTarget();
        }
    }

    private synchronized h b(int i) {
        return (h) this.p.get(Integer.valueOf(i));
    }

    public final void a(int i, int i2) {
        d dVar = (d) b(i);
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public final void a(h hVar) {
        b(hVar);
    }

    public final int a(XLWxPayParam xLWxPayParam, Object obj) {
        return a(xLWxPayParam, obj, null);
    }

    public final int a(XLAlipayParam xLAlipayParam, Object obj) {
        return a(xLAlipayParam, obj, null);
    }

    public final int a(XLWxPayParam xLWxPayParam, Object obj, XLOnPayListener xLOnPayListener) {
        if (!this.j) {
            return null;
        }
        h dVar = new d();
        dVar.a();
        dVar.a((XLPayParam) xLWxPayParam);
        dVar.a(obj);
        dVar.a(xLOnPayListener);
        b(dVar);
        this.l.registerStatReq(dVar.b());
        return dVar.b();
    }

    public final int a(XLAlipayParam xLAlipayParam, Object obj, XLOnPayListener xLOnPayListener) {
        if (!this.j) {
            return null;
        }
        h aVar = new com.xunlei.common.new_ptl.pay.c.a(XLPayType.XL_ALI_PAY);
        aVar.a();
        aVar.a((XLPayParam) xLAlipayParam);
        aVar.a(obj);
        aVar.a(xLOnPayListener);
        b(aVar);
        this.l.registerStatReq(aVar.b());
        return aVar.b();
    }

    public final int a(XLPriceParam xLPriceParam, Object obj) {
        if (!this.j) {
            return null;
        }
        h cVar = new com.xunlei.common.new_ptl.pay.c.c();
        cVar.a();
        cVar.a(xLPriceParam);
        cVar.a(obj);
        b(cVar);
        this.l.registerStatReq(cVar.b());
        return cVar.b();
    }

    public final int a(XLContractParam xLContractParam, Object obj) {
        if (!this.j) {
            return null;
        }
        h bVar = new b();
        bVar.a();
        bVar.a(xLContractParam);
        bVar.a(obj);
        b(bVar);
        this.l.registerStatReq(bVar.b());
        return bVar.b();
    }

    private boolean a(WebView webView, Activity activity, IXLPayJSHandler iXLPayJSHandler) {
        c cVar = new c();
        activity = cVar.a(webView, activity, iXLPayJSHandler);
        if (activity != null) {
            this.q.put(webView, cVar);
        }
        return activity;
    }

    private boolean a(WebView webView) {
        c cVar = (c) this.q.get(webView);
        if (cVar != null) {
            cVar.a();
            this.q.remove(webView);
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.os.Message r14) {
        /*
        r13 = this;
        r0 = r14.what;
        switch(r0) {
            case 4132: goto L_0x01c1;
            case 4133: goto L_0x0007;
            default: goto L_0x0005;
        };
    L_0x0005:
        goto L_0x01cb;
    L_0x0007:
        r14 = r14.obj;
        r14 = (java.lang.Object[]) r14;
        r0 = 0;
        r1 = r14[r0];
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r2 = 3;
        r3 = 2;
        r4 = 5;
        r5 = 4;
        r6 = 1;
        switch(r1) {
            case 268435457: goto L_0x0168;
            case 268435458: goto L_0x0112;
            case 268435462: goto L_0x00d5;
            case 268435463: goto L_0x0098;
            case 536870913: goto L_0x005b;
            case 536870914: goto L_0x001e;
            default: goto L_0x001c;
        };
    L_0x001c:
        goto L_0x01bd;
    L_0x001e:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x0051;
    L_0x0026:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (com.xunlei.common.new_ptl.pay.XLAllContractResp) r12;
        r7.onQueryContract(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x001e;
    L_0x0051:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01bd;
    L_0x005b:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x008e;
    L_0x0063:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (java.lang.String) r12;
        r7.onGetPrice(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x005b;
    L_0x008e:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01bd;
    L_0x0098:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x00cb;
    L_0x00a0:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (com.xunlei.common.new_ptl.pay.XLContractResp) r12;
        r7.onContractOperate(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x0098;
    L_0x00cb:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01bd;
    L_0x00d5:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x0108;
    L_0x00dd:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (com.xunlei.common.new_ptl.pay.XLContractResp) r12;
        r7.onContractOperate(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x00d5;
    L_0x0108:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01bd;
    L_0x0112:
        r1 = "XLPayUtil";
        r7 = "call back to XL_ALI_PAY";
        com.xunlei.common.base.XLLog.v(r1, r7);
    L_0x0119:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x015f;
    L_0x0121:
        r1 = "XLPayUtil";
        r7 = new java.lang.StringBuilder;
        r8 = "call back to XL_ALI_PAY index = ";
        r7.<init>(r8);
        r7.append(r0);
        r7 = r7.toString();
        com.xunlei.common.base.XLLog.v(r1, r7);
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r11 = r1;
        r11 = (java.lang.String) r11;
        r1 = r14[r4];
        r1 = (java.lang.Integer) r1;
        r12 = r1.intValue();
        r7.onAliPay(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x0119;
    L_0x015f:
        r14 = r14[r4];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01bd;
    L_0x0168:
        r1 = "XLPayUtil";
        r7 = "call back to XL_WX_PAY";
        com.xunlei.common.base.XLLog.v(r1, r7);
    L_0x016f:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x01b5;
    L_0x0177:
        r1 = "XLPayUtil";
        r7 = new java.lang.StringBuilder;
        r8 = "call back to XL_WX_PAY index = ";
        r7.<init>(r8);
        r7.append(r0);
        r7 = r7.toString();
        com.xunlei.common.base.XLLog.v(r1, r7);
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r11 = r1;
        r11 = (java.lang.String) r11;
        r1 = r14[r4];
        r1 = (java.lang.Integer) r1;
        r12 = r1.intValue();
        r7.onWxPay(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x016f;
    L_0x01b5:
        r14 = r14[r4];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
    L_0x01bd:
        r13.c(r0);
        goto L_0x01cb;
    L_0x01c1:
        r14 = r14.obj;
        r14 = (com.xunlei.common.new_ptl.pay.a.h) r14;
        if (r14 == 0) goto L_0x01cb;
    L_0x01c7:
        r14.c();
        return;
    L_0x01cb:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.pay.a.i.a(android.os.Message):void");
    }

    private void b(h hVar) {
        if (this.k != null) {
            c(hVar);
            this.k.sendMessage(this.k.obtainMessage(4132, hVar));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.os.Message r14) {
        /*
        r13 = this;
        r14 = r14.obj;
        r14 = (java.lang.Object[]) r14;
        r0 = 0;
        r1 = r14[r0];
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r2 = 3;
        r3 = 2;
        r4 = 5;
        r5 = 4;
        r6 = 1;
        switch(r1) {
            case 268435457: goto L_0x0161;
            case 268435458: goto L_0x010b;
            case 268435462: goto L_0x00ce;
            case 268435463: goto L_0x0091;
            case 536870913: goto L_0x0054;
            case 536870914: goto L_0x0017;
            default: goto L_0x0015;
        };
    L_0x0015:
        goto L_0x01b6;
    L_0x0017:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x004a;
    L_0x001f:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (com.xunlei.common.new_ptl.pay.XLAllContractResp) r12;
        r7.onQueryContract(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x0017;
    L_0x004a:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01b6;
    L_0x0054:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x0087;
    L_0x005c:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (java.lang.String) r12;
        r7.onGetPrice(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x0054;
    L_0x0087:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01b6;
    L_0x0091:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x00c4;
    L_0x0099:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (com.xunlei.common.new_ptl.pay.XLContractResp) r12;
        r7.onContractOperate(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x0091;
    L_0x00c4:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01b6;
    L_0x00ce:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x0101;
    L_0x00d6:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (com.xunlei.common.new_ptl.pay.XLContractResp) r12;
        r7.onContractOperate(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x00ce;
    L_0x0101:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01b6;
    L_0x010b:
        r1 = "XLPayUtil";
        r7 = "call back to XL_ALI_PAY";
        com.xunlei.common.base.XLLog.v(r1, r7);
    L_0x0112:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x0158;
    L_0x011a:
        r1 = "XLPayUtil";
        r7 = new java.lang.StringBuilder;
        r8 = "call back to XL_ALI_PAY index = ";
        r7.<init>(r8);
        r7.append(r0);
        r7 = r7.toString();
        com.xunlei.common.base.XLLog.v(r1, r7);
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r11 = r1;
        r11 = (java.lang.String) r11;
        r1 = r14[r4];
        r1 = (java.lang.Integer) r1;
        r12 = r1.intValue();
        r7.onAliPay(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x0112;
    L_0x0158:
        r14 = r14[r4];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01b6;
    L_0x0161:
        r1 = "XLPayUtil";
        r7 = "call back to XL_WX_PAY";
        com.xunlei.common.base.XLLog.v(r1, r7);
    L_0x0168:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x01ae;
    L_0x0170:
        r1 = "XLPayUtil";
        r7 = new java.lang.StringBuilder;
        r8 = "call back to XL_WX_PAY index = ";
        r7.<init>(r8);
        r7.append(r0);
        r7 = r7.toString();
        com.xunlei.common.base.XLLog.v(r1, r7);
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r11 = r1;
        r11 = (java.lang.String) r11;
        r1 = r14[r4];
        r1 = (java.lang.Integer) r1;
        r12 = r1.intValue();
        r7.onWxPay(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x0168;
    L_0x01ae:
        r14 = r14[r4];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
    L_0x01b6:
        r13.c(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.pay.a.i.b(android.os.Message):void");
    }

    private synchronized void c(h hVar) {
        this.p.put(Integer.valueOf(hVar.b()), hVar);
    }

    private synchronized void c(int i) {
        this.p.remove(Integer.valueOf(i));
    }

    private void n() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = org.apache.http.conn.ssl.SSLSocketFactory.class;	 Catch:{ Exception -> 0x0016 }
        r1 = 0;	 Catch:{ Exception -> 0x0016 }
        r2 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0016 }
        r0 = r0.getDeclaredConstructor(r2);	 Catch:{ Exception -> 0x0016 }
        r2 = 1;	 Catch:{ Exception -> 0x0016 }
        r0.setAccessible(r2);	 Catch:{ Exception -> 0x0016 }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0016 }
        r0 = r0.newInstance(r1);	 Catch:{ Exception -> 0x0016 }
        r0 = (org.apache.http.conn.ssl.SSLSocketFactory) r0;	 Catch:{ Exception -> 0x0016 }
        goto L_0x001a;
    L_0x0016:
        r0 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
    L_0x001a:
        r1 = new com.xunlei.common.new_ptl.pay.a.i$a;
        r2 = r0.getHostnameVerifier();
        r1.<init>(r3, r2);
        r0.setHostnameVerifier(r1);
        r1 = r3.n;
        r1.setSSLSocketFactory(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.pay.a.i.n():void");
    }

    public final int l() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.i;
        r1 = ".";
        r0 = r0.lastIndexOf(r1);
        r1 = -1;
        if (r0 == r1) goto L_0x001c;
    L_0x000b:
        r1 = r2.i;
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x001c }
        r0 = r0.intValue();	 Catch:{ NumberFormatException -> 0x001c }
        goto L_0x001d;
    L_0x001c:
        r0 = 0;
    L_0x001d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.pay.a.i.l():int");
    }

    public static XLContractor a(int i) {
        switch (i) {
            case 4096:
                return new com.xunlei.common.new_ptl.pay.c.a.c(a());
            case 4097:
                return new com.xunlei.common.new_ptl.pay.c.b.d(a());
            default:
                return 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.xunlei.common.new_ptl.pay.a.i r13, android.os.Message r14) {
        /*
        r0 = r14.what;
        switch(r0) {
            case 4132: goto L_0x01c1;
            case 4133: goto L_0x0007;
            default: goto L_0x0005;
        };
    L_0x0005:
        goto L_0x01cb;
    L_0x0007:
        r14 = r14.obj;
        r14 = (java.lang.Object[]) r14;
        r0 = 0;
        r1 = r14[r0];
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r2 = 3;
        r3 = 2;
        r4 = 5;
        r5 = 4;
        r6 = 1;
        switch(r1) {
            case 268435457: goto L_0x0168;
            case 268435458: goto L_0x0112;
            case 268435462: goto L_0x00d5;
            case 268435463: goto L_0x0098;
            case 536870913: goto L_0x005b;
            case 536870914: goto L_0x001e;
            default: goto L_0x001c;
        };
    L_0x001c:
        goto L_0x01bd;
    L_0x001e:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x0051;
    L_0x0026:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (com.xunlei.common.new_ptl.pay.XLAllContractResp) r12;
        r7.onQueryContract(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x001e;
    L_0x0051:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01bd;
    L_0x005b:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x008e;
    L_0x0063:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (java.lang.String) r12;
        r7.onGetPrice(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x005b;
    L_0x008e:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01bd;
    L_0x0098:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x00cb;
    L_0x00a0:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (com.xunlei.common.new_ptl.pay.XLContractResp) r12;
        r7.onContractOperate(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x0098;
    L_0x00cb:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01bd;
    L_0x00d5:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x0108;
    L_0x00dd:
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r1 = (java.lang.Integer) r1;
        r11 = r1.intValue();
        r1 = r14[r4];
        r12 = r1;
        r12 = (com.xunlei.common.new_ptl.pay.XLContractResp) r12;
        r7.onContractOperate(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x00d5;
    L_0x0108:
        r14 = r14[r5];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01bd;
    L_0x0112:
        r1 = "XLPayUtil";
        r7 = "call back to XL_ALI_PAY";
        com.xunlei.common.base.XLLog.v(r1, r7);
    L_0x0119:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x015f;
    L_0x0121:
        r1 = "XLPayUtil";
        r7 = new java.lang.StringBuilder;
        r8 = "call back to XL_ALI_PAY index = ";
        r7.<init>(r8);
        r7.append(r0);
        r7 = r7.toString();
        com.xunlei.common.base.XLLog.v(r1, r7);
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r11 = r1;
        r11 = (java.lang.String) r11;
        r1 = r14[r4];
        r1 = (java.lang.Integer) r1;
        r12 = r1.intValue();
        r7.onAliPay(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x0119;
    L_0x015f:
        r14 = r14[r4];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
        goto L_0x01bd;
    L_0x0168:
        r1 = "XLPayUtil";
        r7 = "call back to XL_WX_PAY";
        com.xunlei.common.base.XLLog.v(r1, r7);
    L_0x016f:
        r1 = r13.o;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x01b5;
    L_0x0177:
        r1 = "XLPayUtil";
        r7 = new java.lang.StringBuilder;
        r8 = "call back to XL_WX_PAY index = ";
        r7.<init>(r8);
        r7.append(r0);
        r7 = r7.toString();
        com.xunlei.common.base.XLLog.v(r1, r7);
        r1 = r13.o;
        r1 = r1.get(r0);
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.XLOnPayListener) r7;
        r1 = r14[r6];
        r1 = (java.lang.Integer) r1;
        r8 = r1.intValue();
        r1 = r14[r3];
        r9 = r1;
        r9 = (java.lang.String) r9;
        r10 = r14[r2];
        r1 = r14[r5];
        r11 = r1;
        r11 = (java.lang.String) r11;
        r1 = r14[r4];
        r1 = (java.lang.Integer) r1;
        r12 = r1.intValue();
        r7.onWxPay(r8, r9, r10, r11, r12);
        r0 = r0 + 1;
        goto L_0x016f;
    L_0x01b5:
        r14 = r14[r4];
        r14 = (java.lang.Integer) r14;
        r0 = r14.intValue();
    L_0x01bd:
        r13.c(r0);
        goto L_0x01cb;
    L_0x01c1:
        r13 = r14.obj;
        r13 = (com.xunlei.common.new_ptl.pay.a.h) r13;
        if (r13 == 0) goto L_0x01cb;
    L_0x01c7:
        r13.c();
        return;
    L_0x01cb:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.pay.a.i.a(com.xunlei.common.new_ptl.pay.a.i, android.os.Message):void");
    }
}
