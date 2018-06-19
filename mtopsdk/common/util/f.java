package mtopsdk.common.util;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;

public final class f {
    private static AtomicInteger a = new AtomicInteger();

    public static int a() {
        return a.incrementAndGet() & Integer.MAX_VALUE;
    }

    public static java.io.Serializable a(java.io.File r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x0031 }
        r1.<init>(r5, r6);	 Catch:{ Throwable -> 0x0031 }
        r2 = r1.exists();	 Catch:{ Throwable -> 0x0031 }
        if (r2 != 0) goto L_0x000d;	 Catch:{ Throwable -> 0x0031 }
    L_0x000c:
        return r0;	 Catch:{ Throwable -> 0x0031 }
    L_0x000d:
        r2 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0031 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x0031 }
        r1 = new java.io.ObjectInputStream;	 Catch:{ Throwable -> 0x002c, all -> 0x0029 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x002c, all -> 0x0029 }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x002c, all -> 0x0029 }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x002c, all -> 0x0029 }
        r3 = r1.readObject();	 Catch:{ Throwable -> 0x002c, all -> 0x0029 }
        r3 = (java.io.Serializable) r3;	 Catch:{ Throwable -> 0x002c, all -> 0x0029 }
        r1.close();	 Catch:{ Throwable -> 0x002d, all -> 0x0029 }
        r2.close();	 Catch:{ IOException -> 0x0049 }
        return r3;
    L_0x0029:
        r5 = move-exception;
        r0 = r2;
        goto L_0x004a;
    L_0x002c:
        r3 = r0;
    L_0x002d:
        r0 = r2;
        goto L_0x0032;
    L_0x002f:
        r5 = move-exception;
        goto L_0x004a;
    L_0x0031:
        r3 = r0;
    L_0x0032:
        r1 = "readObject error.fileDir={%s},fileName={%s}";	 Catch:{ all -> 0x002f }
        r2 = 2;	 Catch:{ all -> 0x002f }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x002f }
        r4 = 0;	 Catch:{ all -> 0x002f }
        r2[r4] = r5;	 Catch:{ all -> 0x002f }
        r5 = 1;	 Catch:{ all -> 0x002f }
        r2[r5] = r6;	 Catch:{ all -> 0x002f }
        r5 = java.lang.String.format(r1, r2);	 Catch:{ all -> 0x002f }
        mtopsdk.common.util.j.d(r5);	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x0049;
    L_0x0046:
        r0.close();	 Catch:{ IOException -> 0x0049 }
    L_0x0049:
        return r3;
    L_0x004a:
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        r0.close();	 Catch:{ IOException -> 0x004f }
    L_0x004f:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.f.a(java.io.File, java.lang.String):java.io.Serializable");
    }

    public static boolean a(java.io.Serializable r7, java.io.File r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 1;
        r1 = 0;
        r2 = 0;
        r3 = r8.exists();	 Catch:{ Throwable -> 0x004e }
        if (r3 != 0) goto L_0x000c;	 Catch:{ Throwable -> 0x004e }
    L_0x0009:
        r8.mkdirs();	 Catch:{ Throwable -> 0x004e }
    L_0x000c:
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x004e }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x004e }
        r4.<init>();	 Catch:{ Throwable -> 0x004e }
        r4.append(r9);	 Catch:{ Throwable -> 0x004e }
        r5 = new java.util.Random;	 Catch:{ Throwable -> 0x004e }
        r5.<init>();	 Catch:{ Throwable -> 0x004e }
        r6 = 10;	 Catch:{ Throwable -> 0x004e }
        r5 = r5.nextInt(r6);	 Catch:{ Throwable -> 0x004e }
        r4.append(r5);	 Catch:{ Throwable -> 0x004e }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x004e }
        r3.<init>(r8, r4);	 Catch:{ Throwable -> 0x004e }
        r4 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x004f }
        r4.<init>(r3);	 Catch:{ Throwable -> 0x004f }
        r2 = new java.io.ObjectOutputStream;	 Catch:{ Throwable -> 0x004a, all -> 0x0047 }
        r5 = new java.io.BufferedOutputStream;	 Catch:{ Throwable -> 0x004a, all -> 0x0047 }
        r5.<init>(r4);	 Catch:{ Throwable -> 0x004a, all -> 0x0047 }
        r2.<init>(r5);	 Catch:{ Throwable -> 0x004a, all -> 0x0047 }
        r2.writeObject(r7);	 Catch:{ Throwable -> 0x004a, all -> 0x0047 }
        r2.flush();	 Catch:{ Throwable -> 0x004a, all -> 0x0047 }
        r2.close();	 Catch:{ Throwable -> 0x004a, all -> 0x0047 }
        r4.close();	 Catch:{ IOException -> 0x0068 }
        goto L_0x0068;
    L_0x0047:
        r7 = move-exception;
        r2 = r4;
        goto L_0x0074;
    L_0x004a:
        r2 = r4;
        goto L_0x004f;
    L_0x004c:
        r7 = move-exception;
        goto L_0x0074;
    L_0x004e:
        r3 = r2;
    L_0x004f:
        r4 = "writeObject error.fileDir={%s},fileName={%s},object={%s}";	 Catch:{ all -> 0x004c }
        r5 = 3;	 Catch:{ all -> 0x004c }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x004c }
        r5[r1] = r8;	 Catch:{ all -> 0x004c }
        r5[r0] = r9;	 Catch:{ all -> 0x004c }
        r0 = 2;	 Catch:{ all -> 0x004c }
        r5[r0] = r7;	 Catch:{ all -> 0x004c }
        r7 = java.lang.String.format(r4, r5);	 Catch:{ all -> 0x004c }
        mtopsdk.common.util.j.d(r7);	 Catch:{ all -> 0x004c }
        if (r2 == 0) goto L_0x0067;
    L_0x0064:
        r2.close();	 Catch:{ IOException -> 0x0067 }
    L_0x0067:
        r0 = r1;
    L_0x0068:
        if (r0 == 0) goto L_0x0073;
    L_0x006a:
        r7 = new java.io.File;
        r7.<init>(r8, r9);
        r0 = r3.renameTo(r7);
    L_0x0073:
        return r0;
    L_0x0074:
        if (r2 == 0) goto L_0x0079;
    L_0x0076:
        r2.close();	 Catch:{ IOException -> 0x0079 }
    L_0x0079:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.f.a(java.io.Serializable, java.io.File, java.lang.String):boolean");
    }

    public static boolean b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
