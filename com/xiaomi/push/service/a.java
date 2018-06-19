package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.module.PushChannelRegion;
import com.xiaomi.xmpush.thrift.g;
import java.io.File;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class a {
    private static volatile a r;
    private final Object a = new Object();
    private final String b = "mipush_region";
    private final String c = "mipush_region.lock";
    private final String d = "success.";
    private final String e = "fail.";
    private final String f = ".";
    private final Object g = new Object();
    private final Object h = new Object();
    private final Object i = new Object();
    private final Object j = new Object();
    private Context k;
    private String l;
    private String m = null;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;

    public a(Context context) {
        this.k = context;
    }

    public static a a(Context context) {
        if (r == null) {
            synchronized (a.class) {
                if (r == null) {
                    r = new a(context);
                }
            }
        }
        return r;
    }

    private void a(Context context, PushChannelRegion pushChannelRegion) {
        RandomAccessFile randomAccessFile;
        FileLock lock;
        Throwable e;
        synchronized (this.a) {
            FileLock fileLock = null;
            try {
                File file = new File(context.getFilesDir(), "mipush_region.lock");
                com.xiaomi.channel.commonutils.file.a.a(file);
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
                        com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                    } catch (Throwable th) {
                        e3 = th;
                        try {
                            fileLock.release();
                        } catch (Throwable e4) {
                            b.a(e4);
                        }
                        com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                        throw e3;
                    }
                }
                try {
                    b(context, pushChannelRegion);
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
                    com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                } catch (Throwable th2) {
                    e32 = th2;
                    fileLock = lock;
                    fileLock.release();
                    com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
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
                com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
            } catch (Throwable th3) {
                e32 = th3;
                randomAccessFile = null;
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                throw e32;
            }
            com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
        }
    }

    private void a(String str, String str2) {
        if (am.a(this.k).a(g.GlobalRegionIOSwitch.a(), true)) {
            be.a(this.k, str, "region_io", 1, str2);
        }
    }

    private String b(Context context) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        FileLock fileLock = null;
        if (new File(context.getFilesDir(), "mipush_region").exists()) {
            synchronized (this.a) {
                FileLock lock;
                try {
                    File file = new File(context.getFilesDir(), "mipush_region.lock");
                    com.xiaomi.channel.commonutils.file.a.a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        lock = randomAccessFile.getChannel().lock();
                        try {
                            String c = c(context);
                            if (lock != null) {
                                if (lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (Throwable e2) {
                                        b.a(e2);
                                    }
                                }
                            }
                            com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                            return c;
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                b.a(e);
                                if (lock != null) {
                                    if (lock.isValid()) {
                                        try {
                                            lock.release();
                                        } catch (Throwable e4) {
                                            b.a(e4);
                                        }
                                    }
                                }
                                com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                                return null;
                            } catch (Throwable th) {
                                e4 = th;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (Throwable e22) {
                                        b.a(e22);
                                    }
                                }
                                com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                                throw e4;
                            }
                        }
                    } catch (Exception e5) {
                        e4 = e5;
                        lock = null;
                        b.a(e4);
                        if (lock != null) {
                            if (lock.isValid()) {
                                lock.release();
                            }
                        }
                        com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                        return null;
                    } catch (Throwable th2) {
                        e4 = th2;
                        fileLock.release();
                        com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                        throw e4;
                    }
                } catch (Exception e6) {
                    e4 = e6;
                    lock = null;
                    randomAccessFile = lock;
                    b.a(e4);
                    if (lock != null) {
                        if (lock.isValid()) {
                            lock.release();
                        }
                    }
                    com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                    return null;
                } catch (Throwable th3) {
                    e4 = th3;
                    randomAccessFile = null;
                    fileLock.release();
                    com.xiaomi.channel.commonutils.file.a.a(randomAccessFile);
                    throw e4;
                }
            }
        }
        b.a("Region no ready file to get data.");
        return null;
    }

    private void b(Context context, PushChannelRegion pushChannelRegion) {
        Throwable e;
        OutputStream outputStream = null;
        try {
            OutputStream openFileOutput = context.openFileOutput("mipush_region", 32768);
            try {
                openFileOutput.write(pushChannelRegion.name().getBytes());
                openFileOutput.flush();
                com.xiaomi.channel.commonutils.file.a.a(openFileOutput);
            } catch (Exception e2) {
                e = e2;
                outputStream = openFileOutput;
                try {
                    b.a(e);
                    com.xiaomi.channel.commonutils.file.a.a(outputStream);
                } catch (Throwable th) {
                    e = th;
                    openFileOutput = outputStream;
                    com.xiaomi.channel.commonutils.file.a.a(openFileOutput);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                com.xiaomi.channel.commonutils.file.a.a(openFileOutput);
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            b.a(e);
            com.xiaomi.channel.commonutils.file.a.a(outputStream);
        }
    }

    private java.lang.String c(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:25:0x0047 in {9, 11, 13, 15, 17, 19, 21, 24, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = "";
        r1 = 0;
        r2 = "mipush_region";	 Catch:{ Exception -> 0x003f, all -> 0x003b }
        r6 = r6.openFileInput(r2);	 Catch:{ Exception -> 0x003f, all -> 0x003b }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0036, all -> 0x0033 }
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0036, all -> 0x0033 }
        r3.<init>(r6);	 Catch:{ Exception -> 0x0036, all -> 0x0033 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0036, all -> 0x0033 }
    L_0x0013:
        r1 = r2.readLine();	 Catch:{ Exception -> 0x0031 }
        if (r1 == 0) goto L_0x002a;	 Catch:{ Exception -> 0x0031 }
    L_0x0019:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0031 }
        r3.<init>();	 Catch:{ Exception -> 0x0031 }
        r3.append(r0);	 Catch:{ Exception -> 0x0031 }
        r3.append(r1);	 Catch:{ Exception -> 0x0031 }
        r1 = r3.toString();	 Catch:{ Exception -> 0x0031 }
        r0 = r1;
        goto L_0x0013;
    L_0x002a:
        com.xiaomi.channel.commonutils.file.a.a(r6);
        com.xiaomi.channel.commonutils.file.a.a(r2);
        return r0;
    L_0x0031:
        r1 = move-exception;
        goto L_0x0043;
    L_0x0033:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0049;
    L_0x0036:
        r2 = move-exception;
        r4 = r2;
        r2 = r1;
        r1 = r4;
        goto L_0x0043;
    L_0x003b:
        r0 = move-exception;
        r6 = r1;
        r2 = r6;
        goto L_0x0049;
    L_0x003f:
        r6 = move-exception;
        r2 = r1;
        r1 = r6;
        r6 = r2;
    L_0x0043:
        com.xiaomi.channel.commonutils.logger.b.a(r1);	 Catch:{ all -> 0x0048 }
        goto L_0x002a;
        return r0;
    L_0x0048:
        r0 = move-exception;
    L_0x0049:
        com.xiaomi.channel.commonutils.file.a.a(r6);
        com.xiaomi.channel.commonutils.file.a.a(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.a.c(android.content.Context):java.lang.String");
    }

    public String a() {
        return a(true);
    }

    public java.lang.String a(boolean r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.n;
        if (r0 != 0) goto L_0x00c6;
    L_0x0004:
        r0 = new java.lang.Thread;
        r1 = new com.xiaomi.push.service.b;
        r1.<init>(r7);
        r0.<init>(r1);
        r0.start();
        r0 = java.lang.System.currentTimeMillis();
        r2 = r7.g;
        monitor-enter(r2);
        r3 = r7.g;	 Catch:{ InterruptedException -> 0x0034 }
        r4 = r7.k;	 Catch:{ InterruptedException -> 0x0034 }
        r4 = com.xiaomi.push.service.am.a(r4);	 Catch:{ InterruptedException -> 0x0034 }
        r5 = com.xiaomi.xmpush.thrift.g.GlobalRegionIOWait;	 Catch:{ InterruptedException -> 0x0034 }
        r5 = r5.a();	 Catch:{ InterruptedException -> 0x0034 }
        r6 = 100;	 Catch:{ InterruptedException -> 0x0034 }
        r4 = r4.a(r5, r6);	 Catch:{ InterruptedException -> 0x0034 }
        r4 = (long) r4;	 Catch:{ InterruptedException -> 0x0034 }
        r3.wait(r4);	 Catch:{ InterruptedException -> 0x0034 }
        goto L_0x0034;
    L_0x0031:
        r8 = move-exception;
        goto L_0x00c4;
    L_0x0034:
        monitor-exit(r2);	 Catch:{ all -> 0x0031 }
        r2 = java.lang.System.currentTimeMillis();
        r4 = r2 - r0;
        r0 = 1;
        r7.n = r0;
        r0 = r7.i;
        monitor-enter(r0);
        r1 = r7.p;	 Catch:{ all -> 0x00c1 }
        r2 = r7.m;	 Catch:{ all -> 0x00c1 }
        r7.l = r2;	 Catch:{ all -> 0x00c1 }
        monitor-exit(r0);	 Catch:{ all -> 0x00c1 }
        if (r8 == 0) goto L_0x00c6;
    L_0x004a:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r8.append(r4);
        r0 = ".";
        r8.append(r0);
        r0 = r7.k;
        r0 = com.xiaomi.push.service.bb.a(r0);
        r2 = "mipush_extra";
        r3 = "mipush_registed";
        r4 = 0;
        r0 = r0.a(r2, r3, r4);
        r8.append(r0);
        r8 = r8.toString();
        if (r1 == 0) goto L_0x009d;
    L_0x006f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r7.k;
        r1 = r1.getPackageName();
        r0.append(r1);
        r1 = " get region success.";
        r0.append(r1);
        r0 = r0.toString();
        com.xiaomi.channel.commonutils.logger.b.c(r0);
        r0 = "category_region_write";
        r1 = new java.lang.StringBuilder;
        r2 = "success.";
        r1.<init>(r2);
    L_0x0092:
        r1.append(r8);
        r8 = r1.toString();
        r7.a(r0, r8);
        goto L_0x00c6;
    L_0x009d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r7.k;
        r1 = r1.getPackageName();
        r0.append(r1);
        r1 = " get region fail.";
        r0.append(r1);
        r0 = r0.toString();
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        r0 = "category_region_write";
        r1 = new java.lang.StringBuilder;
        r2 = "fail.";
        r1.<init>(r2);
        goto L_0x0092;
    L_0x00c1:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00c1 }
        throw r8;
    L_0x00c4:
        monitor-exit(r2);	 Catch:{ all -> 0x0031 }
        throw r8;
    L_0x00c6:
        r8 = r7.l;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.a.a(boolean):java.lang.String");
    }

    public void a(com.xiaomi.push.service.module.PushChannelRegion r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        r6 = java.lang.System.currentTimeMillis();
        r0 = r12.k;
        r0 = com.xiaomi.push.service.am.a(r0);
        r1 = com.xiaomi.xmpush.thrift.g.GlobalRegionIOWait;
        r1 = r1.a();
        r2 = 100;
        r8 = r0.a(r1, r2);
        r0 = r12.o;
        if (r0 != 0) goto L_0x00cb;
    L_0x001a:
        r9 = 0;
        r0 = r12.a(r9);
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x00cb;
    L_0x0025:
        r10 = new java.lang.Thread;
        r11 = new com.xiaomi.push.service.c;
        r0 = r11;
        r1 = r12;
        r2 = r13;
        r3 = r6;
        r5 = r8;
        r0.<init>(r1, r2, r3, r5);
        r10.<init>(r11);
        r10.start();
        r13 = r12.h;
        monitor-enter(r13);
        r0 = r12.h;	 Catch:{ InterruptedException -> 0x0044 }
        r1 = (long) r8;	 Catch:{ InterruptedException -> 0x0044 }
        r0.wait(r1);	 Catch:{ InterruptedException -> 0x0044 }
        goto L_0x0044;
    L_0x0041:
        r0 = move-exception;
        goto L_0x00c9;
    L_0x0044:
        monitor-exit(r13);	 Catch:{ all -> 0x0041 }
        r0 = java.lang.System.currentTimeMillis();
        r2 = r0 - r6;
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r13.append(r2);
        r0 = ".";
        r13.append(r0);
        r0 = r12.k;
        r0 = com.xiaomi.push.service.bb.a(r0);
        r1 = "mipush_extra";
        r2 = "mipush_registed";
        r0 = r0.a(r1, r2, r9);
        r13.append(r0);
        r13 = r13.toString();
        r0 = r12.q;
        if (r0 == 0) goto L_0x009f;
    L_0x0071:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r12.k;
        r1 = r1.getPackageName();
        r0.append(r1);
        r1 = " set region success.";
        r0.append(r1);
        r0 = r0.toString();
        com.xiaomi.channel.commonutils.logger.b.c(r0);
        r0 = "category_region_read";
        r1 = new java.lang.StringBuilder;
        r2 = "success.";
        r1.<init>(r2);
    L_0x0094:
        r1.append(r13);
        r13 = r1.toString();
        r12.a(r0, r13);
        goto L_0x00c3;
    L_0x009f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r12.k;
        r1 = r1.getPackageName();
        r0.append(r1);
        r1 = " set region fail.";
        r0.append(r1);
        r0 = r0.toString();
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        r0 = "category_region_read";
        r1 = new java.lang.StringBuilder;
        r2 = "fail.";
        r1.<init>(r2);
        goto L_0x0094;
    L_0x00c3:
        r13 = 1;
        r12.o = r13;
        r12.n = r9;
        return;
    L_0x00c9:
        monitor-exit(r13);	 Catch:{ all -> 0x0041 }
        throw r0;
    L_0x00cb:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.a.a(com.xiaomi.push.service.module.PushChannelRegion):void");
    }
}
