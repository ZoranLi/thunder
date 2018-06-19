package com.xiaomi.metoknlp.devicediscover;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class m extends Thread {
    private WeakReference a;
    private WeakReference b;
    private final int c;

    public m(Handler handler, Context context, int i) {
        this.a = new WeakReference(handler);
        this.b = new WeakReference(context);
        this.c = i;
        start();
    }

    private Handler a() {
        return this.a == null ? null : (Handler) this.a.get();
    }

    public static void a(Context context, Handler handler, int i) {
        m mVar = new m(handler, context, i);
    }

    private void a(java.lang.String r6, int r7, int r8, java.util.HashMap r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0078 }
        r2 = new java.io.FileReader;	 Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0078 }
        r3 = "/proc/net/arp";	 Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0078 }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0078 }
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0078 }
        r1.readLine();	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r8 = r8 - r7;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r8 = r8 + 1;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r7 = new java.lang.String[r8];	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r0 = 0;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r2 = r0;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x0017:
        if (r2 >= r8) goto L_0x0032;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x0019:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r3.append(r6);	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r4 = ".";	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r3.append(r2);	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r7[r2] = r3;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r2 = r2 + 1;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        goto L_0x0017;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x0032:
        r6 = r1.readLine();	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        if (r6 == 0) goto L_0x0069;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x0038:
        r8 = "[ ]+";	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r6 = r6.split(r8);	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r8 = r6.length;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r2 = 6;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        if (r8 < r2) goto L_0x0032;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x0042:
        r8 = r6[r0];	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r2 = 3;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r6 = r6[r2];	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r2 = r7.length;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r3 = r0;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x0049:
        if (r3 >= r2) goto L_0x0032;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x004b:
        r4 = r7[r3];	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r4 = r4.equals(r8);	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        if (r4 == 0) goto L_0x0066;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x0053:
        r4 = "..:..:..:..:..:..";	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r4 = r6.matches(r4);	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        if (r4 == 0) goto L_0x0066;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x005b:
        r4 = "00:00:00:00:00:00";	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        r4 = r4.equals(r6);	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
        if (r4 != 0) goto L_0x0066;	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x0063:
        r9.put(r8, r6);	 Catch:{ FileNotFoundException -> 0x0072, IOException -> 0x006f, all -> 0x006d }
    L_0x0066:
        r3 = r3 + 1;
        goto L_0x0049;
    L_0x0069:
        r1.close();	 Catch:{ IOException -> 0x006c }
    L_0x006c:
        return;
    L_0x006d:
        r6 = move-exception;
        goto L_0x009c;
    L_0x006f:
        r6 = move-exception;
        r0 = r1;
        goto L_0x0079;
    L_0x0072:
        r6 = move-exception;
        r0 = r1;
        goto L_0x008b;
    L_0x0075:
        r6 = move-exception;
        r1 = r0;
        goto L_0x009c;
    L_0x0078:
        r6 = move-exception;
    L_0x0079:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
        r8 = "get address read file error:";	 Catch:{ all -> 0x0075 }
        r7.<init>(r8);	 Catch:{ all -> 0x0075 }
        r7.append(r6);	 Catch:{ all -> 0x0075 }
        if (r0 == 0) goto L_0x0089;
    L_0x0085:
        r0.close();	 Catch:{ IOException -> 0x0089 }
        return;
    L_0x0089:
        return;
    L_0x008a:
        r6 = move-exception;
    L_0x008b:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
        r8 = "get address file not found:";	 Catch:{ all -> 0x0075 }
        r7.<init>(r8);	 Catch:{ all -> 0x0075 }
        r7.append(r6);	 Catch:{ all -> 0x0075 }
        if (r0 == 0) goto L_0x009b;
    L_0x0097:
        r0.close();	 Catch:{ IOException -> 0x009b }
        return;
    L_0x009b:
        return;
    L_0x009c:
        if (r1 == 0) goto L_0x00a1;
    L_0x009e:
        r1.close();	 Catch:{ IOException -> 0x00a1 }
    L_0x00a1:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.m.a(java.lang.String, int, int, java.util.HashMap):void");
    }

    private void a(HashMap hashMap) {
        Handler a = a();
        Message obtainMessage = a.obtainMessage(this.c);
        obtainMessage.obj = hashMap;
        a.sendMessage(obtainMessage);
    }

    private Context b() {
        return this.a == null ? null : (Context) this.b.get();
    }

    private HashMap c() {
        Object e;
        StringBuilder stringBuilder;
        HashMap hashMap = new HashMap();
        String b = j.b(b());
        if (b == null) {
            return hashMap;
        }
        b = b.substring(0, b.lastIndexOf("."));
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(40);
        try {
            int i;
            Runnable[] runnableArr = new Runnable[255];
            for (i = 1; i < 255; i++) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b);
                stringBuilder2.append(".");
                stringBuilder2.append(i);
                runnableArr[i] = new e(this, stringBuilder2.toString());
            }
            for (i = 1; i < 255; i++) {
                newFixedThreadPool.execute(runnableArr[i]);
            }
            try {
                newFixedThreadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
            } catch (Exception e2) {
                e = e2;
                stringBuilder = new StringBuilder("find device error:");
                stringBuilder.append(e);
                a(b, 1, 255, hashMap);
                return hashMap;
            }
        } catch (Exception e3) {
            new StringBuilder("multi-threading error: ").append(e3);
            try {
                newFixedThreadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
            } catch (Exception e4) {
                e = e4;
                stringBuilder = new StringBuilder("find device error:");
                stringBuilder.append(e);
                a(b, 1, 255, hashMap);
                return hashMap;
            }
            a(b, 1, 255, hashMap);
            return hashMap;
        } finally {
            newFixedThreadPool.shutdown();
            try {
                newFixedThreadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
            } catch (Exception e5) {
                new StringBuilder("find device error:").append(e5);
            }
        }
        a(b, 1, 255, hashMap);
        return hashMap;
    }

    public void run() {
        a(c());
    }
}
