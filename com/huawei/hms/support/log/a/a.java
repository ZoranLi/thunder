package com.huawei.hms.support.log.a;

import android.content.Context;
import com.huawei.hms.support.log.c;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: FileLogNode */
public class a implements c {
    private File a;

    /* compiled from: FileLogNode */
    public static class a implements c {
        private final c a;
        private c b;
        private final Executor c = Executors.newSingleThreadExecutor();

        public a(c cVar) {
            this.a = cVar;
        }

        public void a(Context context, String str) {
            this.c.execute(new b(this, context, str));
            if (this.b != null) {
                this.b.a(context, str);
            }
        }

        public void a(String str, int i, String str2, String str3) {
            this.c.execute(new c(this, str, i, str2, str3));
            if (this.b != null) {
                this.b.a(str, i, str2, str3);
            }
        }
    }

    public void a(Context context, String str) {
        if (!(context == null || str == null)) {
            if (!str.isEmpty()) {
                if (this.a == null) {
                    context = context.getExternalFilesDir(null);
                    if (context != null) {
                        File file = new File(context, "Log");
                        if (!(file.isDirectory() == null && file.mkdirs() == null)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append(MsgConstant.CACHE_LOG_FILE_EXT);
                            this.a = new File(file, stringBuilder.toString());
                            this.a.setReadable(true);
                            this.a.setWritable(true);
                            this.a.setExecutable(false, false);
                        }
                    }
                }
            }
        }
    }

    public void a(String str, int i, String str2, String str3) {
        if (this.a != 0 && str != null) {
            i = new StringBuilder();
            i.append(str);
            i.append('\n');
            str = i.toString();
            if (a(str) != 0) {
                b(str);
            }
        }
    }

    private boolean a(String str) {
        if (this.a.length() + ((long) str.length()) > 524288) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.getPath());
            stringBuilder.append(".bak");
            if (this.a.renameTo(new File(stringBuilder.toString())) == null) {
                return null;
            }
        }
        return true;
    }

    private void b(java.lang.String r6) {
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
        r5 = this;
        r0 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x003e, FileNotFoundException -> 0x003e, all -> 0x0031 }
        r2 = r5.a;	 Catch:{ FileNotFoundException -> 0x003e, FileNotFoundException -> 0x003e, all -> 0x0031 }
        r3 = 1;	 Catch:{ FileNotFoundException -> 0x003e, FileNotFoundException -> 0x003e, all -> 0x0031 }
        r1.<init>(r2, r3);	 Catch:{ FileNotFoundException -> 0x003e, FileNotFoundException -> 0x003e, all -> 0x0031 }
        r2 = new java.io.BufferedOutputStream;	 Catch:{ FileNotFoundException -> 0x002f, FileNotFoundException -> 0x002f, all -> 0x002c }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x002f, FileNotFoundException -> 0x002f, all -> 0x002c }
        r3 = new java.io.OutputStreamWriter;	 Catch:{ FileNotFoundException -> 0x0040, FileNotFoundException -> 0x0040, all -> 0x002a }
        r4 = "UTF-8";	 Catch:{ FileNotFoundException -> 0x0040, FileNotFoundException -> 0x0040, all -> 0x002a }
        r3.<init>(r2, r4);	 Catch:{ FileNotFoundException -> 0x0040, FileNotFoundException -> 0x0040, all -> 0x002a }
        r3.write(r6);	 Catch:{ FileNotFoundException -> 0x0028, FileNotFoundException -> 0x0028, all -> 0x0025 }
        r3.flush();	 Catch:{ FileNotFoundException -> 0x0028, FileNotFoundException -> 0x0028, all -> 0x0025 }
        a(r3);
    L_0x001e:
        a(r2);
        a(r1);
        return;
    L_0x0025:
        r6 = move-exception;
        r0 = r3;
        goto L_0x0034;
    L_0x0028:
        r0 = r3;
        goto L_0x0040;
    L_0x002a:
        r6 = move-exception;
        goto L_0x0034;
    L_0x002c:
        r6 = move-exception;
        r2 = r0;
        goto L_0x0034;
    L_0x002f:
        r2 = r0;
        goto L_0x0040;
    L_0x0031:
        r6 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x0034:
        a(r0);
        a(r2);
        a(r1);
        throw r6;
    L_0x003e:
        r1 = r0;
        r2 = r1;
    L_0x0040:
        a(r0);
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.log.a.a.b(java.lang.String):void");
    }

    private static void a(java.io.Closeable r0) {
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
        if (r0 == 0) goto L_0x0006;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.log.a.a.a(java.io.Closeable):void");
    }
}
