package com.alibaba.baichuan.android.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;

public final class a implements Callback {
    private static a b;
    private static Handler c;
    public boolean a = false;
    private boolean d = true;
    private boolean e;

    private a() {
        c = new Handler(Looper.getMainLooper(), this);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    public static com.alibaba.baichuan.android.a.c a(java.lang.String r4) {
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
        r0 = 0;
        if (r4 == 0) goto L_0x0067;
    L_0x0003:
        r1 = "bchybrid://";
        r1 = r4.startsWith(r1);
        if (r1 != 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r1 = new com.alibaba.baichuan.android.a.c;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r1.<init>();	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r2 = 58;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r3 = 11;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r2 = r4.indexOf(r2, r3);	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r3 = r4.substring(r3, r2);	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r1.c = r3;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r3 = 47;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r3 = r4.indexOf(r3, r2);	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r2 = r2 + 1;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r2 = r4.substring(r2, r3);	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r1.f = r2;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r2 = 63;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r2 = r4.indexOf(r2, r3);	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        if (r2 <= 0) goto L_0x0046;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
    L_0x0035:
        r3 = r3 + 1;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r3 = r4.substring(r3, r2);	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r1.d = r3;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r2 = r2 + 1;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r4 = r4.substring(r2);	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r1.e = r4;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        goto L_0x004e;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
    L_0x0046:
        r3 = r3 + 1;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r4 = r4.substring(r3);	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r1.d = r4;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
    L_0x004e:
        r4 = r1.c;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r4 = r4.length();	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        if (r4 <= 0) goto L_0x0067;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
    L_0x0056:
        r4 = r1.f;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r4 = r4.length();	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        if (r4 <= 0) goto L_0x0067;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
    L_0x005e:
        r4 = r1.d;	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        r4 = r4.length();	 Catch:{ StringIndexOutOfBoundsException -> 0x0067 }
        if (r4 <= 0) goto L_0x0067;
    L_0x0066:
        return r1;
    L_0x0067:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.a.a.a(java.lang.String):com.alibaba.baichuan.android.a.c");
    }

    private static void a(int i, c cVar) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = cVar;
        c.sendMessage(obtain);
    }

    public final synchronized void b() {
        this.a = true;
    }

    public final boolean handleMessage(Message message) {
        c cVar = (c) message.obj;
        if (cVar == null) {
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            return false;
        }
        d dVar = new d(cVar.a, cVar.f, cVar.c, cVar.d);
        message = message.what;
        if (message != null) {
            switch (message) {
                case 2:
                    message = e.d;
                    break;
                case 3:
                    message = e.e;
                    break;
                case 4:
                    message = e.f;
                    break;
                default:
                    return false;
            }
            dVar.b(message);
            return true;
        }
        if (((com.alibaba.baichuan.android.a.b.a) cVar.b).a(cVar.d, TextUtils.isEmpty(cVar.e) ? "{}" : cVar.e, dVar) == null) {
            new StringBuilder("AlibcApiPlugin execute failed. method: ").append(cVar.d);
            AlibcContext.b();
            a(2, cVar);
        }
        return true;
    }

    static /* synthetic */ void a(a aVar, c cVar) {
        String.format("callMethod-obj:%s method:%s param:%s sid:%s", new Object[]{cVar.c, cVar.d, cVar.e, cVar.f});
        AlibcContext.b();
        if (aVar.d) {
            if (cVar.a != null) {
                if (aVar.e == null && b.a() != null && b.a().isEmpty() == null) {
                    for (com.alibaba.baichuan.android.a.b.a a : b.a()) {
                        if (!a.a()) {
                            AlibcContext.b();
                            a(3, cVar);
                            return;
                        }
                    }
                }
                aVar = cVar.a.a(cVar.c);
                if (aVar == null || !(aVar instanceof com.alibaba.baichuan.android.a.b.a)) {
                    aVar = new StringBuilder("callMethod: Plugin ");
                    aVar.append(cVar.c);
                    aVar.append(" didn't found, you should call WVPluginManager.registerPlugin first.");
                    AlibcContext.b();
                    a(2, cVar);
                    return;
                }
                AlibcContext.b();
                cVar.b = aVar;
                a(0, cVar);
                return;
            }
        }
        AlibcContext.b();
        a(4, cVar);
    }
}
