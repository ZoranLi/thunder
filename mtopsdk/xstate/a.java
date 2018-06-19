package mtopsdk.xstate;

import java.util.HashMap;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;

public final class a {
    private static final HashMap a = new HashMap();
    private static mtopsdk.common.util.a b;

    public static String a() {
        return a("sid");
    }

    public static String a(String str) {
        if (b == null || b.b() == null) {
            if (j.a(TBSdkLog$LogEnable.WarnEnable)) {
                StringBuilder stringBuilder = new StringBuilder("[getValue]Attention :User XState Local Mode : key=");
                stringBuilder.append(str);
                j.c(stringBuilder.toString());
            }
            synchronized (a) {
                str = (String) a.get(str);
            }
            return str;
        }
        try {
            return ((mtopsdk.xstate.a.a) b.b()).a(str);
        } catch (Exception e) {
            if (j.a(TBSdkLog$LogEnable.WarnEnable)) {
                StringBuilder stringBuilder2 = new StringBuilder("[getValue] getValue by key=");
                stringBuilder2.append(str);
                stringBuilder2.append(" error ---");
                stringBuilder2.append(e.toString());
                j.e(stringBuilder2.toString());
                stringBuilder = new StringBuilder("[getValue]Attention :User XState Local Mode : key=");
                stringBuilder.append(str);
                j.c(stringBuilder.toString());
            }
            synchronized (a) {
                return (String) a.get(str);
            }
        }
    }

    public static void a(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 != 0) goto L_0x0008;
    L_0x0002:
        r3 = "[init]init() error,context is null";
        mtopsdk.common.util.j.e(r3);
        return;
    L_0x0008:
        r0 = a;	 Catch:{ Throwable -> 0x0031 }
        r1 = "ua";	 Catch:{ Throwable -> 0x0031 }
        r2 = mtopsdk.xstate.b.a.a();	 Catch:{ Throwable -> 0x0031 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0031 }
        r0 = a;	 Catch:{ Throwable -> 0x0031 }
        r1 = "pv";	 Catch:{ Throwable -> 0x0031 }
        r2 = "1.0";	 Catch:{ Throwable -> 0x0031 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0031 }
        r0 = a;	 Catch:{ Throwable -> 0x0031 }
        r1 = "t_offset";	 Catch:{ Throwable -> 0x0031 }
        r2 = "0";	 Catch:{ Throwable -> 0x0031 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0031 }
        r0 = a;	 Catch:{ Throwable -> 0x0031 }
        r1 = "utdid";	 Catch:{ Throwable -> 0x0031 }
        r2 = com.ut.device.UTDevice.getUtdid(r3);	 Catch:{ Throwable -> 0x0031 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0031 }
        goto L_0x0036;
    L_0x0031:
        r0 = "[initPhoneInfo]initPhoneInfo error";
        mtopsdk.common.util.j.f(r0);
    L_0x0036:
        r0 = b;
        if (r0 != 0) goto L_0x0049;
    L_0x003a:
        r0 = new mtopsdk.xstate.b;
        r1 = mtopsdk.xstate.a.a.class;
        r2 = mtopsdk.xstate.d.class;
        r0.<init>(r1, r2);
        b = r0;
        r0.a(r3);
        return;
    L_0x0049:
        d();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.xstate.a.a(android.content.Context):void");
    }

    public static void a(String str, String str2) {
        if (b == null || b.b() == null) {
            if (j.a(TBSdkLog$LogEnable.WarnEnable)) {
                StringBuilder stringBuilder = new StringBuilder("[setValue]Attention :User XState Local Mode: key:");
                stringBuilder.append(str);
                stringBuilder.append(" value:");
                stringBuilder.append(str2);
                j.b(stringBuilder.toString());
            }
            synchronized (a) {
                a.put(str, str2);
            }
            return;
        }
        try {
            ((mtopsdk.xstate.a.a) b.b()).a(str, str2);
        } catch (Exception e) {
            if (j.a(TBSdkLog$LogEnable.WarnEnable)) {
                StringBuilder stringBuilder2 = new StringBuilder("[setValue] setValue failed ,key=");
                stringBuilder2.append(str);
                stringBuilder2.append(",value=");
                stringBuilder2.append(str2);
                stringBuilder2.append("; ---");
                stringBuilder2.append(e.toString());
                j.e(stringBuilder2.toString());
                stringBuilder = new StringBuilder("[setValue]Attention :User XState Local Mode: key:");
                stringBuilder.append(str);
                stringBuilder.append(" value:");
                stringBuilder.append(str2);
                j.c(stringBuilder.toString());
            }
            synchronized (a) {
                a.put(str, str2);
            }
        }
    }

    public static String b() {
        return a("uid");
    }

    public static String c() {
        return a("t_offset");
    }

    protected static void d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = b;
        if (r0 == 0) goto L_0x004b;
    L_0x0004:
        r0 = b;
        r0 = r0.b();
        if (r0 == 0) goto L_0x004b;
    L_0x000c:
        r0 = b;	 Catch:{ Throwable -> 0x0046 }
        r0 = r0.b();	 Catch:{ Throwable -> 0x0046 }
        r0 = (mtopsdk.xstate.a.a) r0;	 Catch:{ Throwable -> 0x0046 }
        r0.a();	 Catch:{ Throwable -> 0x0046 }
        r0 = a;	 Catch:{ Throwable -> 0x0046 }
        monitor-enter(r0);	 Catch:{ Throwable -> 0x0046 }
        r1 = a;	 Catch:{ all -> 0x0043 }
        r1 = r1.keySet();	 Catch:{ all -> 0x0043 }
        r1 = r1.iterator();	 Catch:{ all -> 0x0043 }
    L_0x0024:
        r2 = r1.hasNext();	 Catch:{ all -> 0x0043 }
        if (r2 == 0) goto L_0x003c;	 Catch:{ all -> 0x0043 }
    L_0x002a:
        r2 = r1.next();	 Catch:{ all -> 0x0043 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x0043 }
        r3 = a;	 Catch:{ all -> 0x0043 }
        r3 = r3.get(r2);	 Catch:{ all -> 0x0043 }
        r3 = (java.lang.String) r3;	 Catch:{ all -> 0x0043 }
        a(r2, r3);	 Catch:{ all -> 0x0043 }
        goto L_0x0024;	 Catch:{ all -> 0x0043 }
    L_0x003c:
        r1 = a;	 Catch:{ all -> 0x0043 }
        r1.clear();	 Catch:{ all -> 0x0043 }
        monitor-exit(r0);	 Catch:{ all -> 0x0043 }
        return;
    L_0x0043:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ Throwable -> 0x0046 }
        throw r1;	 Catch:{ Throwable -> 0x0046 }
    L_0x0046:
        r0 = "[syncToRemote]service.init() error";
        mtopsdk.common.util.j.f(r0);
    L_0x004b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.xstate.a.d():void");
    }
}
