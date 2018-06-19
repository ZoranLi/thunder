package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.c;
import com.xiaomi.channel.commonutils.file.a;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.f;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

public class bf {
    public static final Object a = new Object();

    public static List<f> a(Context context) {
        RandomAccessFile randomAccessFile;
        FileLock lock;
        Throwable e;
        File file = new File(context.getFilesDir(), "tiny_data.data");
        FileLock fileLock = null;
        if (file.exists()) {
            byte[] b = b(context);
            synchronized (a) {
                try {
                    File file2 = new File(context.getFilesDir(), "tiny_data.lock");
                    a.a(file2);
                    randomAccessFile = new RandomAccessFile(file2, "rw");
                    try {
                        lock = randomAccessFile.getChannel().lock();
                        try {
                            List<f> a = a(file, b);
                            file.delete();
                            if (lock != null) {
                                if (lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (Throwable e2) {
                                        b.a(e2);
                                    }
                                }
                            }
                            a.a(randomAccessFile);
                            return a;
                        } catch (Exception e3) {
                            e2 = e3;
                            try {
                                b.a(e2);
                                if (lock != null) {
                                    if (lock.isValid()) {
                                        try {
                                            lock.release();
                                        } catch (Throwable e22) {
                                            b.a(e22);
                                        }
                                    }
                                }
                                a.a(randomAccessFile);
                                return null;
                            } catch (Throwable th) {
                                e22 = th;
                                fileLock = lock;
                                try {
                                    fileLock.release();
                                } catch (Throwable e4) {
                                    b.a(e4);
                                }
                                a.a(randomAccessFile);
                                throw e22;
                            }
                        }
                    } catch (Exception e5) {
                        e22 = e5;
                        lock = null;
                        b.a(e22);
                        if (lock != null) {
                            if (lock.isValid()) {
                                lock.release();
                            }
                        }
                        a.a(randomAccessFile);
                        return null;
                    } catch (Throwable th2) {
                        e22 = th2;
                        fileLock.release();
                        a.a(randomAccessFile);
                        throw e22;
                    }
                } catch (Exception e6) {
                    e22 = e6;
                    randomAccessFile = null;
                    lock = randomAccessFile;
                    b.a(e22);
                    if (lock != null) {
                        if (lock.isValid()) {
                            lock.release();
                        }
                    }
                    a.a(randomAccessFile);
                    return null;
                } catch (Throwable th3) {
                    e22 = th3;
                    randomAccessFile = null;
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                    }
                    a.a(randomAccessFile);
                    throw e22;
                }
            }
        }
        b.a("TinyData no ready file to get data.");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.xiaomi.xmpush.thrift.f> a(java.io.File r6, byte[] r7) {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 4;
        r2 = new byte[r1];
        r3 = 0;
        r4 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x005e }
        r4.<init>(r6);	 Catch:{ Exception -> 0x005e }
    L_0x000e:
        r6 = r4.read(r2);	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        r3 = -1;
        if (r6 == r3) goto L_0x0052;
    L_0x0015:
        if (r6 == r1) goto L_0x001d;
    L_0x0017:
        r6 = "TinyData read from cache file failed cause lengthBuffer error";
    L_0x0019:
        com.xiaomi.channel.commonutils.logger.b.d(r6);	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        goto L_0x0052;
    L_0x001d:
        r6 = com.xiaomi.channel.commonutils.misc.b.a(r2);	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        if (r6 <= 0) goto L_0x004f;
    L_0x0023:
        r3 = 30720; // 0x7800 float:4.3048E-41 double:1.51777E-319;
        if (r6 <= r3) goto L_0x0028;
    L_0x0027:
        goto L_0x004f;
    L_0x0028:
        r3 = new byte[r6];	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        r5 = r4.read(r3);	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        if (r5 == r6) goto L_0x0033;
    L_0x0030:
        r6 = "TinyData read from cache file failed cause buffer size not equal length";
        goto L_0x0019;
    L_0x0033:
        r6 = com.xiaomi.channel.commonutils.android.c.a(r7, r3);	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        if (r6 == 0) goto L_0x0049;
    L_0x0039:
        r3 = r6.length;	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        if (r3 != 0) goto L_0x003d;
    L_0x003c:
        goto L_0x0049;
    L_0x003d:
        r3 = new com.xiaomi.xmpush.thrift.f;	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        r3.<init>();	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        com.xiaomi.xmpush.thrift.au.a(r3, r6);	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        r0.add(r3);	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        goto L_0x000e;
    L_0x0049:
        r6 = "TinyData read from cache file failed cause decrypt fail";
        com.xiaomi.channel.commonutils.logger.b.d(r6);	 Catch:{ Exception -> 0x0058, all -> 0x0056 }
        goto L_0x000e;
    L_0x004f:
        r6 = "TinyData read from cache file failed cause lengthBuffer < 1 || too big";
        goto L_0x0019;
    L_0x0052:
        com.xiaomi.channel.commonutils.file.a.a(r4);
        return r0;
    L_0x0056:
        r6 = move-exception;
        goto L_0x0066;
    L_0x0058:
        r6 = move-exception;
        r3 = r4;
        goto L_0x005f;
    L_0x005b:
        r6 = move-exception;
        r4 = r3;
        goto L_0x0066;
    L_0x005e:
        r6 = move-exception;
    L_0x005f:
        com.xiaomi.channel.commonutils.logger.b.a(r6);	 Catch:{ all -> 0x005b }
        com.xiaomi.channel.commonutils.file.a.a(r3);
        return r0;
    L_0x0066:
        com.xiaomi.channel.commonutils.file.a.a(r4);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bf.a(java.io.File, byte[]):java.util.List<com.xiaomi.xmpush.thrift.f>");
    }

    public static void a(Context context, f fVar) {
        Throwable e;
        StringBuilder stringBuilder = new StringBuilder("TinyData cache data to file begin itemId:");
        stringBuilder.append(fVar.m());
        b.c(stringBuilder.toString());
        synchronized (a) {
            RandomAccessFile randomAccessFile;
            FileLock fileLock = null;
            try {
                FileLock lock;
                File file = new File(context.getFilesDir(), "tiny_data.lock");
                a.a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    lock = randomAccessFile.getChannel().lock();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        b.a(e);
                        if (fileLock != null) {
                            if (fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (Throwable e3) {
                                    b.a(e3);
                                }
                            }
                        }
                        a.a(randomAccessFile);
                    } catch (Throwable th) {
                        e3 = th;
                        try {
                            fileLock.release();
                        } catch (Throwable e4) {
                            b.a(e4);
                        }
                        a.a(randomAccessFile);
                        throw e3;
                    }
                }
                try {
                    b(context, fVar);
                    if (lock != null) {
                        if (lock.isValid()) {
                            try {
                                lock.release();
                            } catch (Throwable e32) {
                                b.a(e32);
                            }
                        }
                    }
                } catch (Exception e5) {
                    e32 = e5;
                    fileLock = lock;
                    b.a(e32);
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            fileLock.release();
                        }
                    }
                    a.a(randomAccessFile);
                } catch (Throwable th2) {
                    e32 = th2;
                    fileLock = lock;
                    fileLock.release();
                    a.a(randomAccessFile);
                    throw e32;
                }
            } catch (Exception e6) {
                e32 = e6;
                randomAccessFile = null;
                b.a(e32);
                if (fileLock != null) {
                    if (fileLock.isValid()) {
                        fileLock.release();
                    }
                }
                a.a(randomAccessFile);
            } catch (Throwable th3) {
                e32 = th3;
                randomAccessFile = null;
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                a.a(randomAccessFile);
                throw e32;
            }
            a.a(randomAccessFile);
        }
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(com.xiaomi.channel.commonutils.string.a.a(str), 16);
        copyOf[0] = (byte) 68;
        copyOf[15] = (byte) 84;
        return copyOf;
    }

    private static void b(Context context, f fVar) {
        Throwable th;
        OutputStream outputStream;
        Throwable th2;
        try {
            byte[] b = c.b(b(context), au.a(fVar));
            if (b != null) {
                if (b.length > 0) {
                    if (b.length > 30720) {
                        b.a("TinyData write to cache file failed case too much data content");
                        a.a(null);
                        a.a(null);
                        return;
                    }
                    OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream.write(com.xiaomi.channel.commonutils.misc.b.a(b.length));
                        bufferedOutputStream.write(b);
                        bufferedOutputStream.flush();
                        a.a(null);
                        a.a(bufferedOutputStream);
                        return;
                    } catch (Throwable e) {
                        th = e;
                        outputStream = bufferedOutputStream;
                        th2 = th;
                        b.a("TinyData write to cache file failed cause io exception", th2);
                        a.a(null);
                        a.a(outputStream);
                    } catch (Throwable e2) {
                        th = e2;
                        outputStream = bufferedOutputStream;
                        th2 = th;
                        try {
                            b.a("TinyData write to cache file  failed", th2);
                            a.a(null);
                            a.a(outputStream);
                        } catch (Throwable th3) {
                            th2 = th3;
                            a.a(null);
                            a.a(outputStream);
                            throw th2;
                        }
                    } catch (Throwable e22) {
                        th = e22;
                        outputStream = bufferedOutputStream;
                        th2 = th;
                        a.a(null);
                        a.a(outputStream);
                        throw th2;
                    }
                }
            }
            b.a("TinyData write to cache file failed case encryption fail");
            a.a(null);
            a.a(null);
        } catch (IOException e3) {
            th2 = e3;
            outputStream = null;
            b.a("TinyData write to cache file failed cause io exception", th2);
            a.a(null);
            a.a(outputStream);
        } catch (Exception e4) {
            th2 = e4;
            outputStream = null;
            b.a("TinyData write to cache file  failed", th2);
            a.a(null);
            a.a(outputStream);
        } catch (Throwable th4) {
            th2 = th4;
            outputStream = null;
            a.a(null);
            a.a(outputStream);
            throw th2;
        }
    }

    private static byte[] b(Context context) {
        String b = bb.a(context).b("mipush", "td_key", "");
        if (TextUtils.isEmpty(b)) {
            b = d.a(20);
            bb.a(context).a("mipush", "td_key", b);
        }
        return a(b);
    }
}
