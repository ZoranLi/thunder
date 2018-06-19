package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.network.Host;
import com.xiaomi.push.protobuf.a.a;
import com.xiaomi.stats.f;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class aj {
    private static final Pattern a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
    private static long b;
    private static ThreadPoolExecutor c = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((c.getActiveCount() <= 0 || currentTimeMillis - b >= 1800000) && f.a().c()) {
            a d = az.a().d();
            if (d != null && d.m() > 0) {
                b = currentTimeMillis;
                a(d.l(), true);
            }
        }
    }

    public static void a(List<String> list, boolean z) {
        c.execute(new ak(list, z));
    }

    public static void b() {
        Object c = c("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(c)) {
            StringBuilder stringBuilder = new StringBuilder("dump tcp for uid = ");
            stringBuilder.append(Process.myUid());
            b.a(stringBuilder.toString());
            b.a(c);
        }
        c = c("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(c)) {
            stringBuilder = new StringBuilder("dump tcp6 for uid = ");
            stringBuilder.append(Process.myUid());
            b.a(stringBuilder.toString());
            b.a(c);
        }
    }

    private static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            StringBuilder stringBuilder = new StringBuilder("ConnectivityTest: begin to connect to ");
            stringBuilder.append(str);
            b.a(stringBuilder.toString());
            Socket socket = new Socket();
            socket.connect(Host.b(str, 5222), ReaderCallback.GET_BAR_ANIMATING);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            StringBuilder stringBuilder2 = new StringBuilder("ConnectivityTest: connect to ");
            stringBuilder2.append(str);
            stringBuilder2.append(" in ");
            stringBuilder2.append(currentTimeMillis2);
            b.a(stringBuilder2.toString());
            socket.close();
            return true;
        } catch (Throwable th) {
            StringBuilder stringBuilder3 = new StringBuilder("ConnectivityTest: could not connect to:");
            stringBuilder3.append(str);
            stringBuilder3.append(" exception: ");
            stringBuilder3.append(th.getClass().getSimpleName());
            stringBuilder3.append(" description: ");
            stringBuilder3.append(th.getMessage());
            b.d(stringBuilder3.toString());
            return false;
        }
    }

    private static java.lang.String c(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.File;
        r0.<init>(r4);
        r4 = 0;
        r1 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0035, all -> 0x002e }
        r2 = new java.io.FileReader;	 Catch:{ Exception -> 0x0035, all -> 0x002e }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0035, all -> 0x002e }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0035, all -> 0x002e }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0036, all -> 0x002c }
        r0.<init>();	 Catch:{ Exception -> 0x0036, all -> 0x002c }
    L_0x0015:
        r2 = r1.readLine();	 Catch:{ Exception -> 0x0036, all -> 0x002c }
        if (r2 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x0036, all -> 0x002c }
    L_0x001b:
        r3 = "\n";	 Catch:{ Exception -> 0x0036, all -> 0x002c }
        r0.append(r3);	 Catch:{ Exception -> 0x0036, all -> 0x002c }
        r0.append(r2);	 Catch:{ Exception -> 0x0036, all -> 0x002c }
        goto L_0x0015;	 Catch:{ Exception -> 0x0036, all -> 0x002c }
    L_0x0024:
        r0 = r0.toString();	 Catch:{ Exception -> 0x0036, all -> 0x002c }
        com.xiaomi.channel.commonutils.file.a.a(r1);
        return r0;
    L_0x002c:
        r4 = move-exception;
        goto L_0x0031;
    L_0x002e:
        r0 = move-exception;
        r1 = r4;
        r4 = r0;
    L_0x0031:
        com.xiaomi.channel.commonutils.file.a.a(r1);
        throw r4;
    L_0x0035:
        r1 = r4;
    L_0x0036:
        com.xiaomi.channel.commonutils.file.a.a(r1);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.aj.c(java.lang.String):java.lang.String");
    }
}
