package com.alibaba.sdk.android.feedback.xblink.f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.h.a;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import com.alipay.sdk.util.h;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d implements Callback {
    private static final Pattern a = Pattern.compile("hybrid://(.+?):(.+?)/(.+?)(\\?(.*?))?");
    private static d g;
    private final int b = 0;
    private final int c = 1;
    private final int d = 2;
    private final int e = 3;
    private final int f = 4;
    private Handler h = new Handler(Looper.getMainLooper(), this);
    private boolean i = true;
    private final List j = new ArrayList();
    private boolean k;
    private ReentrantReadWriteLock l = new ReentrantReadWriteLock();
    private boolean m = false;

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (g == null) {
                g = new d();
            }
            dVar = g;
        }
        return dVar;
    }

    private f a(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = a.matcher(str);
        if (matcher.matches()) {
            f fVar = new f();
            int groupCount = matcher.groupCount();
            if (groupCount >= 5) {
                fVar.f = matcher.group(5);
            }
            if (groupCount >= 3) {
                fVar.d = matcher.group(1);
                fVar.g = matcher.group(2);
                fVar.e = matcher.group(3);
                return fVar;
            }
        }
        return null;
    }

    private void a(int i, f fVar) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = fVar;
        this.h.sendMessage(obtain);
    }

    private void a(com.alibaba.sdk.android.feedback.xblink.f.f r10, java.lang.String r11) {
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
        r0 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        r1 = 3;
        r2 = 4;
        r3 = 2;
        r4 = 1;
        r5 = 0;
        if (r0 == 0) goto L_0x0028;
    L_0x000b:
        r0 = "callMethod-obj:%s method:%s param:%s sid:%s";
        r6 = new java.lang.Object[r2];
        r7 = r10.d;
        r6[r5] = r7;
        r7 = r10.e;
        r6[r4] = r7;
        r7 = r10.f;
        r6[r3] = r7;
        r7 = r10.g;
        r6[r1] = r7;
        r0 = java.lang.String.format(r0, r6);
        r6 = "WVJsBridge";
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r6, r0);
    L_0x0028:
        r0 = r9.i;
        if (r0 == 0) goto L_0x017e;
    L_0x002c:
        r0 = r10.a;
        if (r0 != 0) goto L_0x0032;
    L_0x0030:
        goto L_0x017e;
    L_0x0032:
        r0 = r9.k;
        if (r0 != 0) goto L_0x008e;
    L_0x0036:
        r0 = r9.l;	 Catch:{ all -> 0x0083 }
        r0 = r0.readLock();	 Catch:{ all -> 0x0083 }
        r0.lock();	 Catch:{ all -> 0x0083 }
        r0 = r9.j;	 Catch:{ all -> 0x0083 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0083 }
        if (r0 != 0) goto L_0x0079;	 Catch:{ all -> 0x0083 }
    L_0x0047:
        r0 = r9.j;	 Catch:{ all -> 0x0083 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0083 }
    L_0x004d:
        r2 = r0.hasNext();	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x0079;	 Catch:{ all -> 0x0083 }
    L_0x0053:
        r2 = r0.next();	 Catch:{ all -> 0x0083 }
        r2 = (com.alibaba.sdk.android.feedback.xblink.f.g) r2;	 Catch:{ all -> 0x0083 }
        r6 = r10.d;	 Catch:{ all -> 0x0083 }
        r7 = r10.e;	 Catch:{ all -> 0x0083 }
        r8 = r10.f;	 Catch:{ all -> 0x0083 }
        r2 = r2.a(r11, r6, r7, r8);	 Catch:{ all -> 0x0083 }
        if (r2 != 0) goto L_0x004d;	 Catch:{ all -> 0x0083 }
    L_0x0065:
        r11 = "WVJsBridge";	 Catch:{ all -> 0x0083 }
        r0 = "preprocessor call fail, callMethod cancel.";	 Catch:{ all -> 0x0083 }
        com.alibaba.sdk.android.feedback.xblink.i.g.e(r11, r0);	 Catch:{ all -> 0x0083 }
        r9.a(r1, r10);	 Catch:{ all -> 0x0083 }
        r10 = r9.l;
        r10 = r10.readLock();
        r10.unlock();
        return;
    L_0x0079:
        r11 = r9.l;
        r11 = r11.readLock();
        r11.unlock();
        goto L_0x008e;
    L_0x0083:
        r10 = move-exception;
        r11 = r9.l;
        r11 = r11.readLock();
        r11.unlock();
        throw r10;
    L_0x008e:
        r11 = r10.d;
        r0 = r10.e;
        r11 = com.alibaba.sdk.android.feedback.xblink.f.k.a(r11, r0);
        if (r11 == 0) goto L_0x00dd;
    L_0x0098:
        r0 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        if (r0 == 0) goto L_0x00c9;
    L_0x009e:
        r0 = "WVJsBridge";
        r1 = new java.lang.StringBuilder;
        r2 = "call method through alias name. newObject: ";
        r1.<init>(r2);
        r2 = "name";
        r2 = r11.get(r2);
        r2 = (java.lang.String) r2;
        r1.append(r2);
        r2 = " newMethod: ";
        r1.append(r2);
        r2 = "method";
        r2 = r11.get(r2);
        r2 = (java.lang.String) r2;
        r1.append(r2);
        r1 = r1.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.c(r0, r1);
    L_0x00c9:
        r0 = "name";
        r0 = r11.get(r0);
        r0 = (java.lang.String) r0;
        r10.d = r0;
        r0 = "method";
        r11 = r11.get(r0);
        r11 = (java.lang.String) r11;
        r10.e = r11;
    L_0x00dd:
        r11 = r10.a;
        r0 = r10.d;
        r11 = r11.getJsObject(r0);
        if (r11 == 0) goto L_0x0160;
    L_0x00e7:
        r0 = r11 instanceof com.alibaba.sdk.android.feedback.xblink.f.a;
        if (r0 == 0) goto L_0x00f8;
    L_0x00eb:
        r0 = "WVJsBridge";
        r1 = "call new method execute.";
        com.alibaba.sdk.android.feedback.xblink.i.g.c(r0, r1);
        r10.b = r11;
        r9.a(r5, r10);
        return;
    L_0x00f8:
        r0 = r10.e;	 Catch:{ NoSuchMethodException -> 0x0140 }
        if (r0 == 0) goto L_0x017a;	 Catch:{ NoSuchMethodException -> 0x0140 }
    L_0x00fc:
        r0 = r11.getClass();	 Catch:{ NoSuchMethodException -> 0x0140 }
        r1 = r10.e;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r2 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x0140 }
        r6 = java.lang.Object.class;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r2[r5] = r6;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r5 = java.lang.String.class;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r2[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0140 }
        r1 = com.alibaba.sdk.android.feedback.xblink.f.n.class;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r1 = r0.isAnnotationPresent(r1);	 Catch:{ NoSuchMethodException -> 0x0140 }
        if (r1 == 0) goto L_0x0120;	 Catch:{ NoSuchMethodException -> 0x0140 }
    L_0x0118:
        r10.b = r11;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r10.c = r0;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r9.a(r4, r10);	 Catch:{ NoSuchMethodException -> 0x0140 }
        return;	 Catch:{ NoSuchMethodException -> 0x0140 }
    L_0x0120:
        r11 = "WVJsBridge";	 Catch:{ NoSuchMethodException -> 0x0140 }
        r0 = new java.lang.StringBuilder;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r1 = "callMethod: Method ";	 Catch:{ NoSuchMethodException -> 0x0140 }
        r0.<init>(r1);	 Catch:{ NoSuchMethodException -> 0x0140 }
        r1 = r10.e;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r0.append(r1);	 Catch:{ NoSuchMethodException -> 0x0140 }
        r1 = " didn't has @WindVaneInterface annotation, obj=";	 Catch:{ NoSuchMethodException -> 0x0140 }
        r0.append(r1);	 Catch:{ NoSuchMethodException -> 0x0140 }
        r1 = r10.d;	 Catch:{ NoSuchMethodException -> 0x0140 }
        r0.append(r1);	 Catch:{ NoSuchMethodException -> 0x0140 }
        r0 = r0.toString();	 Catch:{ NoSuchMethodException -> 0x0140 }
        com.alibaba.sdk.android.feedback.xblink.i.g.e(r11, r0);	 Catch:{ NoSuchMethodException -> 0x0140 }
        goto L_0x017a;
    L_0x0140:
        r11 = "WVJsBridge";
        r0 = new java.lang.StringBuilder;
        r1 = "callMethod: Method ";
        r0.<init>(r1);
        r1 = r10.e;
        r0.append(r1);
        r1 = " didn't found. It must has two parameter, Object.class and String.class, obj=";
        r0.append(r1);
        r1 = r10.d;
        r0.append(r1);
        r0 = r0.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r11, r0);
        goto L_0x017a;
    L_0x0160:
        r11 = "WVJsBridge";
        r0 = new java.lang.StringBuilder;
        r1 = "callMethod: Plugin ";
        r0.<init>(r1);
        r1 = r10.d;
        r0.append(r1);
        r1 = " didn't found, you should call WVPluginManager.registerPlugin first.";
        r0.append(r1);
        r0 = r0.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.e(r11, r0);
    L_0x017a:
        r9.a(r3, r10);
        return;
    L_0x017e:
        r11 = "WVJsBridge";
        r0 = "jsbridge is closed.";
        com.alibaba.sdk.android.feedback.xblink.i.g.e(r11, r0);
        r9.a(r2, r10);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.d.a(com.alibaba.sdk.android.feedback.xblink.f.f, java.lang.String):void");
    }

    public void a(XBHybridWebView xBHybridWebView, String str) {
        if (g.a()) {
            StringBuilder stringBuilder = new StringBuilder("callMethod: url=");
            stringBuilder.append(str);
            g.a("WVJsBridge", stringBuilder.toString());
        }
        if (this.m) {
            f a = a(str);
            if (a == null) {
                StringBuilder stringBuilder2 = new StringBuilder("url format error and call canceled. url=");
                stringBuilder2.append(str);
                g.e("WVJsBridge", stringBuilder2.toString());
                return;
            }
            a.a = xBHybridWebView;
            a.a().a(new e(this, a, xBHybridWebView.getUrl()));
            return;
        }
        g.e("WVJsBridge", "jsbridge is not init.");
    }

    public void a(boolean z) {
        this.i = z;
    }

    public synchronized void b() {
        if (!this.m) {
            k.a();
            this.m = true;
        }
    }

    public boolean handleMessage(Message message) {
        f fVar = (f) message.obj;
        if (fVar == null) {
            g.b("WVJsBridge", "CallMethodContext is null, and do nothing.");
            return false;
        }
        m mVar;
        String str;
        b bVar = new b(fVar.a, fVar.g);
        Object obj;
        switch (message.what) {
            case 0:
                obj = fVar.b;
                StringBuilder stringBuilder = new StringBuilder("WVApiPlugin execute . method: ");
                stringBuilder.append(fVar.e);
                stringBuilder.append(h.b);
                stringBuilder.append(fVar.d);
                g.e("WVJsBridge", stringBuilder.toString());
                if (!((a) obj).a(fVar.e, TextUtils.isEmpty(fVar.f) ? "{}" : fVar.f, bVar)) {
                    if (g.a()) {
                        StringBuilder stringBuilder2 = new StringBuilder("WVApiPlugin execute failed. method: ");
                        stringBuilder2.append(fVar.e);
                        g.e("WVJsBridge", stringBuilder2.toString());
                    }
                    a(2, fVar);
                }
                return true;
            case 1:
                obj = fVar.b;
                try {
                    Method method = fVar.c;
                    Object[] objArr = new Object[2];
                    objArr[0] = bVar;
                    objArr[1] = TextUtils.isEmpty(fVar.f) ? "{}" : fVar.f;
                    method.invoke(obj, objArr);
                    return true;
                } catch (Exception e) {
                    StringBuilder stringBuilder3 = new StringBuilder("call method ");
                    stringBuilder3.append(fVar.c);
                    stringBuilder3.append(" exception. ");
                    stringBuilder3.append(e.getMessage());
                    g.b("WVJsBridge", stringBuilder3.toString());
                    return true;
                }
            case 2:
                mVar = new m();
                str = "HY_NO_HANDLER";
                break;
            case 3:
                mVar = new m();
                str = "HY_NO_PERMISSION";
                break;
            case 4:
                mVar = new m();
                str = "HY_CLOSED";
                break;
            default:
                return false;
        }
        mVar.a(str);
        bVar.b(mVar);
        return true;
    }
}
