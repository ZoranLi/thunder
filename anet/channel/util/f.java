package anet.channel.util;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import java.io.File;

/* compiled from: Taobao */
public class f {
    private static File a;

    public static File a(String str) {
        if (a == null) {
            Context context = GlobalAppRuntimeInfo.getContext();
            if (context != null) {
                File externalCacheDir = context.getExternalCacheDir();
                a = externalCacheDir;
                if (externalCacheDir == null) {
                    a = context.getCacheDir();
                }
            }
        }
        return new File(a, str);
    }

    public static synchronized void a(java.io.Serializable r13, java.io.File r14) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = anet.channel.util.f.class;
        monitor-enter(r0);
        r1 = 0;
        r2 = 0;
        if (r13 == 0) goto L_0x00bd;
    L_0x0007:
        if (r14 != 0) goto L_0x000b;
    L_0x0009:
        goto L_0x00bd;
    L_0x000b:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00c8 }
        r5 = 2;
        r6 = 1;
        r7 = java.util.UUID.randomUUID();	 Catch:{ Exception -> 0x0050, all -> 0x004d }
        r7 = r7.toString();	 Catch:{ Exception -> 0x0050, all -> 0x004d }
        r8 = "-";	 Catch:{ Exception -> 0x0050, all -> 0x004d }
        r9 = "";	 Catch:{ Exception -> 0x0050, all -> 0x004d }
        r7 = r7.replace(r8, r9);	 Catch:{ Exception -> 0x0050, all -> 0x004d }
        r7 = a(r7);	 Catch:{ Exception -> 0x0050, all -> 0x004d }
        r7.createNewFile();	 Catch:{ Exception -> 0x004a, all -> 0x004d }
        r7.setReadable(r6);	 Catch:{ Exception -> 0x004a, all -> 0x004d }
        r8 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x004a, all -> 0x004d }
        r8.<init>(r7);	 Catch:{ Exception -> 0x004a, all -> 0x004d }
        r9 = new java.io.ObjectOutputStream;	 Catch:{ Exception -> 0x0048 }
        r10 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x0048 }
        r10.<init>(r8);	 Catch:{ Exception -> 0x0048 }
        r9.<init>(r10);	 Catch:{ Exception -> 0x0048 }
        r9.writeObject(r13);	 Catch:{ Exception -> 0x0048 }
        r9.flush();	 Catch:{ Exception -> 0x0048 }
        r9.close();	 Catch:{ Exception -> 0x0048 }
        r8.close();	 Catch:{ IOException -> 0x0046 }
    L_0x0046:
        r13 = r6;
        goto L_0x006c;
    L_0x0048:
        r13 = move-exception;
        goto L_0x0053;
    L_0x004a:
        r13 = move-exception;
        r8 = r2;
        goto L_0x0053;
    L_0x004d:
        r13 = move-exception;
        r8 = r2;
        goto L_0x00b7;
    L_0x0050:
        r13 = move-exception;
        r7 = r2;
        r8 = r7;
    L_0x0053:
        r9 = "awcn.SerializeHelper";	 Catch:{ all -> 0x00b6 }
        r10 = "persist fail. ";	 Catch:{ all -> 0x00b6 }
        r11 = new java.lang.Object[r5];	 Catch:{ all -> 0x00b6 }
        r12 = "file";	 Catch:{ all -> 0x00b6 }
        r11[r1] = r12;	 Catch:{ all -> 0x00b6 }
        r12 = r14.getName();	 Catch:{ all -> 0x00b6 }
        r11[r6] = r12;	 Catch:{ all -> 0x00b6 }
        anet.channel.util.ALog.e(r9, r10, r2, r13, r11);	 Catch:{ all -> 0x00b6 }
        if (r8 == 0) goto L_0x006b;
    L_0x0068:
        r8.close();	 Catch:{ IOException -> 0x006b }
    L_0x006b:
        r13 = r1;
    L_0x006c:
        if (r13 == 0) goto L_0x00b4;
    L_0x006e:
        r13 = r7.renameTo(r14);	 Catch:{ all -> 0x00c8 }
        if (r13 == 0) goto L_0x009b;	 Catch:{ all -> 0x00c8 }
    L_0x0074:
        r13 = "awcn.SerializeHelper";	 Catch:{ all -> 0x00c8 }
        r7 = "persist end.";	 Catch:{ all -> 0x00c8 }
        r8 = 4;	 Catch:{ all -> 0x00c8 }
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x00c8 }
        r9 = "file";	 Catch:{ all -> 0x00c8 }
        r8[r1] = r9;	 Catch:{ all -> 0x00c8 }
        r14 = r14.getAbsoluteFile();	 Catch:{ all -> 0x00c8 }
        r8[r6] = r14;	 Catch:{ all -> 0x00c8 }
        r14 = "cost";	 Catch:{ all -> 0x00c8 }
        r8[r5] = r14;	 Catch:{ all -> 0x00c8 }
        r14 = 3;	 Catch:{ all -> 0x00c8 }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00c8 }
        r9 = r5 - r3;	 Catch:{ all -> 0x00c8 }
        r1 = java.lang.Long.valueOf(r9);	 Catch:{ all -> 0x00c8 }
        r8[r14] = r1;	 Catch:{ all -> 0x00c8 }
        anet.channel.util.ALog.i(r13, r7, r2, r8);	 Catch:{ all -> 0x00c8 }
        monitor-exit(r0);
        return;
    L_0x009b:
        r13 = "awcn.SerializeHelper";	 Catch:{ all -> 0x00c8 }
        r14 = "rename failed.";	 Catch:{ all -> 0x00c8 }
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x00c8 }
        anet.channel.util.ALog.e(r13, r14, r2, r1);	 Catch:{ all -> 0x00c8 }
        r13 = anet.channel.appmonitor.AppMonitor.getInstance();	 Catch:{ all -> 0x00c8 }
        r14 = new anet.channel.statist.ExceptionStatistic;	 Catch:{ all -> 0x00c8 }
        r1 = -106; // 0xffffffffffffff96 float:NaN double:NaN;	 Catch:{ all -> 0x00c8 }
        r3 = "rt";	 Catch:{ all -> 0x00c8 }
        r14.<init>(r1, r2, r3);	 Catch:{ all -> 0x00c8 }
        r13.commitStat(r14);	 Catch:{ all -> 0x00c8 }
    L_0x00b4:
        monitor-exit(r0);
        return;
    L_0x00b6:
        r13 = move-exception;
    L_0x00b7:
        if (r8 == 0) goto L_0x00bc;
    L_0x00b9:
        r8.close();	 Catch:{ IOException -> 0x00bc }
    L_0x00bc:
        throw r13;	 Catch:{ all -> 0x00c8 }
    L_0x00bd:
        r13 = "awcn.SerializeHelper";	 Catch:{ all -> 0x00c8 }
        r14 = "persist fail. Invalid parameter";	 Catch:{ all -> 0x00c8 }
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x00c8 }
        anet.channel.util.ALog.e(r13, r14, r2, r1);	 Catch:{ all -> 0x00c8 }
        monitor-exit(r0);
        return;
    L_0x00c8:
        r13 = move-exception;
        monitor-exit(r0);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.f.a(java.io.Serializable, java.io.File):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized <T> T a(java.io.File r8) {
        /*
        r0 = anet.channel.util.f.class;
        monitor-enter(r0);
        r1 = 0;
        r2 = 3;
        r3 = 0;
        r4 = r8.exists();	 Catch:{ Throwable -> 0x004f, all -> 0x004d }
        if (r4 != 0) goto L_0x0029;
    L_0x000c:
        r4 = anet.channel.util.ALog.isPrintLog(r2);	 Catch:{ Throwable -> 0x004f, all -> 0x004d }
        if (r4 == 0) goto L_0x0027;
    L_0x0012:
        r4 = "awcn.SerializeHelper";
        r5 = "file not exist.";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x004f, all -> 0x004d }
        r7 = "file";
        r6[r1] = r7;	 Catch:{ Throwable -> 0x004f, all -> 0x004d }
        r7 = 1;
        r8 = r8.getName();	 Catch:{ Throwable -> 0x004f, all -> 0x004d }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x004f, all -> 0x004d }
        anet.channel.util.ALog.w(r4, r5, r3, r6);	 Catch:{ Throwable -> 0x004f, all -> 0x004d }
    L_0x0027:
        monitor-exit(r0);
        return r3;
    L_0x0029:
        r4 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x004f, all -> 0x004d }
        r4.<init>(r8);	 Catch:{ Throwable -> 0x004f, all -> 0x004d }
        r8 = new java.io.ObjectInputStream;	 Catch:{ Throwable -> 0x004a }
        r5 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x004a }
        r5.<init>(r4);	 Catch:{ Throwable -> 0x004a }
        r8.<init>(r5);	 Catch:{ Throwable -> 0x004a }
        r5 = r8.readObject();	 Catch:{ Throwable -> 0x004a }
        r8.close();	 Catch:{ Throwable -> 0x0048 }
        r4.close();	 Catch:{ IOException -> 0x0043 }
        goto L_0x0069;
    L_0x0043:
        r8 = move-exception;
    L_0x0044:
        r8.printStackTrace();	 Catch:{ all -> 0x0073 }
        goto L_0x0069;
    L_0x0048:
        r8 = move-exception;
        goto L_0x0052;
    L_0x004a:
        r8 = move-exception;
        r5 = r3;
        goto L_0x0052;
    L_0x004d:
        r8 = move-exception;
        goto L_0x006d;
    L_0x004f:
        r8 = move-exception;
        r4 = r3;
        r5 = r4;
    L_0x0052:
        r2 = anet.channel.util.ALog.isPrintLog(r2);	 Catch:{ all -> 0x006b }
        if (r2 == 0) goto L_0x0061;
    L_0x0058:
        r2 = "awcn.SerializeHelper";
        r6 = "restore file fail.";
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x006b }
        anet.channel.util.ALog.w(r2, r6, r3, r8, r1);	 Catch:{ all -> 0x006b }
    L_0x0061:
        if (r4 == 0) goto L_0x0069;
    L_0x0063:
        r4.close();	 Catch:{ IOException -> 0x0067 }
        goto L_0x0069;
    L_0x0067:
        r8 = move-exception;
        goto L_0x0044;
    L_0x0069:
        monitor-exit(r0);
        return r5;
    L_0x006b:
        r8 = move-exception;
        r3 = r4;
    L_0x006d:
        if (r3 == 0) goto L_0x0079;
    L_0x006f:
        r3.close();	 Catch:{ IOException -> 0x0075 }
        goto L_0x0079;
    L_0x0073:
        r8 = move-exception;
        goto L_0x007a;
    L_0x0075:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0073 }
    L_0x0079:
        throw r8;	 Catch:{ all -> 0x0073 }
    L_0x007a:
        monitor-exit(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.f.a(java.io.File):T");
    }
}
