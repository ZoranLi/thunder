package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public class ae {
    public static boolean a = false;
    private static ae b;
    private static af c;

    /* compiled from: BUGLY */
    class a extends Thread {
        final /* synthetic */ ae a;
        private int b;
        private ad c;
        private String d;
        private ContentValues e;
        private boolean f;
        private String[] g;
        private String h;
        private String[] i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String n;
        private String[] o;
        private int p;
        private String q;
        private byte[] r;

        public a(ae aeVar, int i, ad adVar) {
            this.a = aeVar;
            this.b = i;
            this.c = adVar;
        }

        public void a(String str, ContentValues contentValues) {
            this.d = str;
            this.e = contentValues;
        }

        public void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f = z;
            this.d = str;
            this.g = strArr;
            this.h = str2;
            this.i = strArr2;
            this.j = str3;
            this.k = str4;
            this.l = str5;
            this.m = str6;
        }

        public void a(String str, String str2, String[] strArr) {
            this.d = str;
            this.n = str2;
            this.o = strArr;
        }

        public void a(int i, String str, byte[] bArr) {
            this.p = i;
            this.q = str;
            this.r = bArr;
        }

        public void a(int i) {
            this.p = i;
        }

        public void a(int i, String str) {
            this.p = i;
            this.q = str;
        }

        public void run() {
            switch (this.b) {
                case 1:
                    r0.a.a(r0.d, r0.e, r0.c);
                    return;
                case 2:
                    r0.a.a(r0.d, r0.n, r0.o, r0.c);
                    return;
                case 3:
                    r0.a.a(r0.f, r0.d, r0.g, r0.h, r0.i, r0.j, r0.k, r0.l, r0.m, r0.c);
                    return;
                case 4:
                    r0.a.a(r0.p, r0.q, r0.r, r0.c);
                    return;
                case 5:
                    r0.a.a(r0.p, r0.c);
                    return;
                case 6:
                    r0.a.a(r0.p, r0.q, r0.c);
                    break;
                default:
                    break;
            }
        }
    }

    private boolean a(int r5, java.lang.String r6, byte[] r7, com.tencent.bugly.proguard.ad r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0037 in list [B:4:0x0019]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = new com.tencent.bugly.proguard.ag;	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
        r1.<init>();	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
        r2 = (long) r5;	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
        r1.a = r2;	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
        r1.f = r6;	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
        r1.e = r5;	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
        r1.g = r7;	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
        r5 = r4.d(r1);	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
        if (r8 == 0) goto L_0x0037;
    L_0x0019:
        r6 = java.lang.Boolean.valueOf(r5);
        r8.a(r6);
        goto L_0x0037;
    L_0x0021:
        r5 = move-exception;
        goto L_0x0038;
    L_0x0023:
        r5 = move-exception;
        r6 = com.tencent.bugly.proguard.an.a(r5);	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
        if (r6 != 0) goto L_0x002d;	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
    L_0x002a:
        r5.printStackTrace();	 Catch:{ Throwable -> 0x0023, all -> 0x0021 }
    L_0x002d:
        if (r8 == 0) goto L_0x0036;
    L_0x002f:
        r5 = java.lang.Boolean.valueOf(r0);
        r8.a(r5);
    L_0x0036:
        r5 = r0;
    L_0x0037:
        return r5;
    L_0x0038:
        if (r8 == 0) goto L_0x0041;
    L_0x003a:
        r6 = java.lang.Boolean.valueOf(r0);
        r8.a(r6);
    L_0x0041:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.a(int, java.lang.String, byte[], com.tencent.bugly.proguard.ad):boolean");
    }

    private ae(Context context, List<com.tencent.bugly.a> list) {
        c = new af(context, list);
    }

    public static synchronized ae a(Context context, List<com.tencent.bugly.a> list) {
        synchronized (ae.class) {
            if (b == null) {
                b = new ae(context, list);
            }
            context = b;
        }
        return context;
    }

    public static synchronized ae a() {
        ae aeVar;
        synchronized (ae.class) {
            aeVar = b;
        }
        return aeVar;
    }

    public long a(String str, ContentValues contentValues, ad adVar, boolean z) {
        if (z) {
            return a(str, contentValues, adVar);
        }
        z = new a(this, 1, adVar);
        z.a(str, contentValues);
        am.a().a(z);
        return null;
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, ad adVar, boolean z) {
        return a(false, str, strArr, str2, strArr2, null, null, null, null, adVar, z);
    }

    public Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, ad adVar, boolean z2) {
        if (z2) {
            ae aeVar = this;
            ad adVar2 = adVar;
            return a(z, str, strArr, str2, strArr2, str3, str4, str5, str6, adVar);
        }
        Runnable aVar = new a(this, 3, adVar);
        aVar.a(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
        am.a().a(aVar);
        return null;
    }

    public int a(String str, String str2, String[] strArr, ad adVar, boolean z) {
        if (z) {
            return a(str, str2, strArr, adVar);
        }
        z = new a(this, 2, adVar);
        z.a(str, str2, strArr);
        am.a().a(z);
        return null;
    }

    private synchronized long a(String str, ContentValues contentValues, ad adVar) {
        long j;
        SQLiteDatabase sQLiteDatabase = null;
        j = 0;
        try {
            SQLiteDatabase writableDatabase = c.getWritableDatabase();
            if (!(writableDatabase == null || contentValues == null)) {
                try {
                    long replace = writableDatabase.replace(str, "_id", contentValues);
                    if (replace >= 0) {
                        an.c("[Database] insert %s success.", str);
                    } else {
                        an.d("[Database] replace %s error.", str);
                    }
                    j = replace;
                } catch (Throwable th) {
                    str = th;
                    if (adVar != null) {
                        adVar.a(Long.valueOf(0));
                    }
                    if (!(a == null || writableDatabase == null)) {
                        writableDatabase.close();
                    }
                    throw str;
                }
            }
            if (adVar != null) {
                adVar.a(Long.valueOf(j));
            }
            if (!(a == null || writableDatabase == null)) {
                writableDatabase.close();
            }
        } catch (Throwable th2) {
            str = th2;
            if (an.a(str) == null) {
                str.printStackTrace();
            }
            if (adVar != null) {
                adVar.a(Long.valueOf(0));
            }
            sQLiteDatabase.close();
            return j;
        }
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.database.Cursor a(boolean r15, java.lang.String r16, java.lang.String[] r17, java.lang.String r18, java.lang.String[] r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, com.tencent.bugly.proguard.ad r24) {
        /*
        r14 = this;
        r1 = r24;
        monitor-enter(r14);
        r2 = 0;
        r3 = c;	 Catch:{ Throwable -> 0x002b }
        r4 = r3.getWritableDatabase();	 Catch:{ Throwable -> 0x002b }
        if (r4 == 0) goto L_0x0022;
    L_0x000c:
        r5 = r15;
        r6 = r16;
        r7 = r17;
        r8 = r18;
        r9 = r19;
        r10 = r20;
        r11 = r21;
        r12 = r22;
        r13 = r23;
        r3 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12, r13);	 Catch:{ Throwable -> 0x002b }
        r2 = r3;
    L_0x0022:
        if (r1 == 0) goto L_0x0039;
    L_0x0024:
        r1.a(r2);	 Catch:{ all -> 0x0041 }
        goto L_0x0039;
    L_0x0028:
        r0 = move-exception;
        r3 = r0;
        goto L_0x003b;
    L_0x002b:
        r0 = move-exception;
        r3 = r0;
        r4 = com.tencent.bugly.proguard.an.a(r3);	 Catch:{ all -> 0x0028 }
        if (r4 != 0) goto L_0x0036;
    L_0x0033:
        r3.printStackTrace();	 Catch:{ all -> 0x0028 }
    L_0x0036:
        if (r1 == 0) goto L_0x0039;
    L_0x0038:
        goto L_0x0024;
    L_0x0039:
        monitor-exit(r14);
        return r2;
    L_0x003b:
        if (r1 == 0) goto L_0x0044;
    L_0x003d:
        r1.a(r2);	 Catch:{ all -> 0x0041 }
        goto L_0x0044;
    L_0x0041:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0045;
    L_0x0044:
        throw r3;	 Catch:{ all -> 0x0041 }
    L_0x0045:
        monitor-exit(r14);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.a(boolean, java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.bugly.proguard.ad):android.database.Cursor");
    }

    private synchronized int a(String str, String str2, String[] strArr, ad adVar) {
        int i;
        SQLiteDatabase sQLiteDatabase = null;
        i = 0;
        try {
            SQLiteDatabase writableDatabase = c.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    i = writableDatabase.delete(str, str2, strArr);
                } catch (Throwable th) {
                    str = th;
                    sQLiteDatabase = writableDatabase;
                    if (adVar != null) {
                        adVar.a(Integer.valueOf(0));
                    }
                    if (!(a == null || sQLiteDatabase == null)) {
                        sQLiteDatabase.close();
                    }
                    throw str;
                }
            }
            if (adVar != null) {
                adVar.a(Integer.valueOf(i));
            }
            if (!(a == null || writableDatabase == null)) {
                writableDatabase.close();
            }
        } catch (Throwable th2) {
            str = th2;
            if (an.a(str) == null) {
                str.printStackTrace();
            }
            if (adVar != null) {
                adVar.a(Integer.valueOf(0));
            }
            sQLiteDatabase.close();
            return i;
        }
        return i;
    }

    public boolean a(int i, String str, byte[] bArr, ad adVar, boolean z) {
        if (z) {
            return a(i, str, bArr, adVar);
        }
        z = new a(this, 4, adVar);
        z.a(i, str, bArr);
        am.a().a(z);
        return true;
    }

    public Map<String, byte[]> a(int i, ad adVar, boolean z) {
        if (z) {
            return a(i, adVar);
        }
        z = new a(this, 5, adVar);
        z.a(i);
        am.a().a(z);
        return 0;
    }

    public boolean a(int i, String str, ad adVar, boolean z) {
        if (z) {
            return a(i, str, adVar);
        }
        z = new a(this, 6, adVar);
        z.a(i, str);
        am.a().a(z);
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, byte[]> a(int r4, com.tencent.bugly.proguard.ad r5) {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = 0;
        r4 = r3.c(r4);	 Catch:{ Throwable -> 0x0036 }
        if (r4 == 0) goto L_0x002d;	 Catch:{ Throwable -> 0x0036 }
    L_0x0007:
        r1 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0036 }
        r1.<init>();	 Catch:{ Throwable -> 0x0036 }
        r4 = r4.iterator();	 Catch:{ Throwable -> 0x002a, all -> 0x0028 }
    L_0x0010:
        r0 = r4.hasNext();	 Catch:{ Throwable -> 0x002a, all -> 0x0028 }
        if (r0 == 0) goto L_0x0026;	 Catch:{ Throwable -> 0x002a, all -> 0x0028 }
    L_0x0016:
        r0 = r4.next();	 Catch:{ Throwable -> 0x002a, all -> 0x0028 }
        r0 = (com.tencent.bugly.proguard.ag) r0;	 Catch:{ Throwable -> 0x002a, all -> 0x0028 }
        r2 = r0.g;	 Catch:{ Throwable -> 0x002a, all -> 0x0028 }
        if (r2 == 0) goto L_0x0010;	 Catch:{ Throwable -> 0x002a, all -> 0x0028 }
    L_0x0020:
        r0 = r0.f;	 Catch:{ Throwable -> 0x002a, all -> 0x0028 }
        r1.put(r0, r2);	 Catch:{ Throwable -> 0x002a, all -> 0x0028 }
        goto L_0x0010;
    L_0x0026:
        r0 = r1;
        goto L_0x002d;
    L_0x0028:
        r4 = move-exception;
        goto L_0x0044;
    L_0x002a:
        r4 = move-exception;
        r0 = r1;
        goto L_0x0037;
    L_0x002d:
        if (r5 == 0) goto L_0x0043;
    L_0x002f:
        r5.a(r0);
        goto L_0x0043;
    L_0x0033:
        r4 = move-exception;
        r1 = r0;
        goto L_0x0044;
    L_0x0036:
        r4 = move-exception;
    L_0x0037:
        r1 = com.tencent.bugly.proguard.an.a(r4);	 Catch:{ all -> 0x0033 }
        if (r1 != 0) goto L_0x0040;	 Catch:{ all -> 0x0033 }
    L_0x003d:
        r4.printStackTrace();	 Catch:{ all -> 0x0033 }
    L_0x0040:
        if (r5 == 0) goto L_0x0043;
    L_0x0042:
        goto L_0x002f;
    L_0x0043:
        return r0;
    L_0x0044:
        if (r5 == 0) goto L_0x0049;
    L_0x0046:
        r5.a(r1);
    L_0x0049:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.a(int, com.tencent.bugly.proguard.ad):java.util.Map<java.lang.String, byte[]>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(com.tencent.bugly.proguard.ag r9) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = 0;
        if (r9 != 0) goto L_0x0006;
    L_0x0004:
        monitor-exit(r8);
        return r0;
    L_0x0006:
        r1 = 0;
        r2 = c;	 Catch:{ Throwable -> 0x005a }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x005a }
        if (r2 == 0) goto L_0x004c;
    L_0x000f:
        r1 = r8.b(r9);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        if (r1 == 0) goto L_0x004c;
    L_0x0015:
        r3 = "t_lr";
        r4 = "_id";
        r3 = r2.replace(r3, r4, r1);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r5 = 0;
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r1 < 0) goto L_0x003c;
    L_0x0023:
        r1 = "[Database] insert %s success.";
        r5 = 1;
        r6 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r7 = "t_lr";
        r6[r0] = r7;	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        com.tencent.bugly.proguard.an.c(r1, r6);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r9.a = r3;	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r9 = a;	 Catch:{ all -> 0x0079 }
        if (r9 == 0) goto L_0x003a;
    L_0x0035:
        if (r2 == 0) goto L_0x003a;
    L_0x0037:
        r2.close();	 Catch:{ all -> 0x0079 }
    L_0x003a:
        monitor-exit(r8);
        return r5;
    L_0x003c:
        r9 = a;	 Catch:{ all -> 0x0079 }
        if (r9 == 0) goto L_0x0045;
    L_0x0040:
        if (r2 == 0) goto L_0x0045;
    L_0x0042:
        r2.close();	 Catch:{ all -> 0x0079 }
    L_0x0045:
        monitor-exit(r8);
        return r0;
    L_0x0047:
        r9 = move-exception;
        goto L_0x006f;
    L_0x0049:
        r9 = move-exception;
        r1 = r2;
        goto L_0x005b;
    L_0x004c:
        r9 = a;	 Catch:{ all -> 0x0079 }
        if (r9 == 0) goto L_0x0055;
    L_0x0050:
        if (r2 == 0) goto L_0x0055;
    L_0x0052:
        r2.close();	 Catch:{ all -> 0x0079 }
    L_0x0055:
        monitor-exit(r8);
        return r0;
    L_0x0057:
        r9 = move-exception;
        r2 = r1;
        goto L_0x006f;
    L_0x005a:
        r9 = move-exception;
    L_0x005b:
        r2 = com.tencent.bugly.proguard.an.a(r9);	 Catch:{ all -> 0x0057 }
        if (r2 != 0) goto L_0x0064;
    L_0x0061:
        r9.printStackTrace();	 Catch:{ all -> 0x0057 }
    L_0x0064:
        r9 = a;	 Catch:{ all -> 0x0079 }
        if (r9 == 0) goto L_0x006d;
    L_0x0068:
        if (r1 == 0) goto L_0x006d;
    L_0x006a:
        r1.close();	 Catch:{ all -> 0x0079 }
    L_0x006d:
        monitor-exit(r8);
        return r0;
    L_0x006f:
        r0 = a;	 Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x0078;
    L_0x0073:
        if (r2 == 0) goto L_0x0078;
    L_0x0075:
        r2.close();	 Catch:{ all -> 0x0079 }
    L_0x0078:
        throw r9;	 Catch:{ all -> 0x0079 }
    L_0x0079:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.a(com.tencent.bugly.proguard.ag):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean d(com.tencent.bugly.proguard.ag r9) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = 0;
        if (r9 != 0) goto L_0x0006;
    L_0x0004:
        monitor-exit(r8);
        return r0;
    L_0x0006:
        r1 = 0;
        r2 = c;	 Catch:{ Throwable -> 0x005a }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x005a }
        if (r2 == 0) goto L_0x004c;
    L_0x000f:
        r1 = r8.c(r9);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        if (r1 == 0) goto L_0x004c;
    L_0x0015:
        r3 = "t_pf";
        r4 = "_id";
        r3 = r2.replace(r3, r4, r1);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r5 = 0;
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r1 < 0) goto L_0x003c;
    L_0x0023:
        r1 = "[Database] insert %s success.";
        r5 = 1;
        r6 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r7 = "t_pf";
        r6[r0] = r7;	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        com.tencent.bugly.proguard.an.c(r1, r6);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r9.a = r3;	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r9 = a;	 Catch:{ all -> 0x0079 }
        if (r9 == 0) goto L_0x003a;
    L_0x0035:
        if (r2 == 0) goto L_0x003a;
    L_0x0037:
        r2.close();	 Catch:{ all -> 0x0079 }
    L_0x003a:
        monitor-exit(r8);
        return r5;
    L_0x003c:
        r9 = a;	 Catch:{ all -> 0x0079 }
        if (r9 == 0) goto L_0x0045;
    L_0x0040:
        if (r2 == 0) goto L_0x0045;
    L_0x0042:
        r2.close();	 Catch:{ all -> 0x0079 }
    L_0x0045:
        monitor-exit(r8);
        return r0;
    L_0x0047:
        r9 = move-exception;
        goto L_0x006f;
    L_0x0049:
        r9 = move-exception;
        r1 = r2;
        goto L_0x005b;
    L_0x004c:
        r9 = a;	 Catch:{ all -> 0x0079 }
        if (r9 == 0) goto L_0x0055;
    L_0x0050:
        if (r2 == 0) goto L_0x0055;
    L_0x0052:
        r2.close();	 Catch:{ all -> 0x0079 }
    L_0x0055:
        monitor-exit(r8);
        return r0;
    L_0x0057:
        r9 = move-exception;
        r2 = r1;
        goto L_0x006f;
    L_0x005a:
        r9 = move-exception;
    L_0x005b:
        r2 = com.tencent.bugly.proguard.an.a(r9);	 Catch:{ all -> 0x0057 }
        if (r2 != 0) goto L_0x0064;
    L_0x0061:
        r9.printStackTrace();	 Catch:{ all -> 0x0057 }
    L_0x0064:
        r9 = a;	 Catch:{ all -> 0x0079 }
        if (r9 == 0) goto L_0x006d;
    L_0x0068:
        if (r1 == 0) goto L_0x006d;
    L_0x006a:
        r1.close();	 Catch:{ all -> 0x0079 }
    L_0x006d:
        monitor-exit(r8);
        return r0;
    L_0x006f:
        r0 = a;	 Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x0078;
    L_0x0073:
        if (r2 == 0) goto L_0x0078;
    L_0x0075:
        r2.close();	 Catch:{ all -> 0x0079 }
    L_0x0078:
        throw r9;	 Catch:{ all -> 0x0079 }
    L_0x0079:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.d(com.tencent.bugly.proguard.ag):boolean");
    }

    public synchronized java.util.List<com.tencent.bugly.proguard.ag> a(int r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = c;	 Catch:{ all -> 0x00de }
        r0 = r0.getWritableDatabase();	 Catch:{ all -> 0x00de }
        r9 = 0;
        if (r0 == 0) goto L_0x00dc;
    L_0x000a:
        if (r11 < 0) goto L_0x0026;
    L_0x000c:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r2 = "_tp = ";	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r1.append(r11);	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r11 = r1.toString();	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r4 = r11;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        goto L_0x0027;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
    L_0x001c:
        r11 = move-exception;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r1 = r11;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r11 = r9;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        goto L_0x00cd;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
    L_0x0021:
        r11 = move-exception;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r1 = r11;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r11 = r9;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        goto L_0x00b4;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
    L_0x0026:
        r4 = r9;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
    L_0x0027:
        r2 = "t_lr";	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r3 = 0;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r5 = 0;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r6 = 0;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r7 = 0;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r8 = 0;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r1 = r0;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r11 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        if (r11 != 0) goto L_0x0045;
    L_0x0035:
        if (r11 == 0) goto L_0x003a;
    L_0x0037:
        r11.close();	 Catch:{ all -> 0x00de }
    L_0x003a:
        r11 = a;	 Catch:{ all -> 0x00de }
        if (r11 == 0) goto L_0x0043;	 Catch:{ all -> 0x00de }
    L_0x003e:
        if (r0 == 0) goto L_0x0043;	 Catch:{ all -> 0x00de }
    L_0x0040:
        r0.close();	 Catch:{ all -> 0x00de }
    L_0x0043:
        monitor-exit(r10);
        return r9;
    L_0x0045:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b3 }
        r1.<init>();	 Catch:{ Throwable -> 0x00b3 }
        r2 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00b3 }
        r2.<init>();	 Catch:{ Throwable -> 0x00b3 }
    L_0x004f:
        r3 = r11.moveToNext();	 Catch:{ Throwable -> 0x00b3 }
        r4 = 0;	 Catch:{ Throwable -> 0x00b3 }
        if (r3 == 0) goto L_0x007b;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0056:
        r3 = r10.a(r11);	 Catch:{ Throwable -> 0x00b3 }
        if (r3 == 0) goto L_0x0060;	 Catch:{ Throwable -> 0x00b3 }
    L_0x005c:
        r2.add(r3);	 Catch:{ Throwable -> 0x00b3 }
        goto L_0x004f;
    L_0x0060:
        r3 = "_id";	 Catch:{ Throwable -> 0x0073 }
        r3 = r11.getColumnIndex(r3);	 Catch:{ Throwable -> 0x0073 }
        r5 = r11.getLong(r3);	 Catch:{ Throwable -> 0x0073 }
        r3 = " or _id = ";	 Catch:{ Throwable -> 0x0073 }
        r1.append(r3);	 Catch:{ Throwable -> 0x0073 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0073 }
        goto L_0x004f;
    L_0x0073:
        r3 = "[Database] unknown id.";	 Catch:{ Throwable -> 0x00b3 }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x00b3 }
        com.tencent.bugly.proguard.an.d(r3, r4);	 Catch:{ Throwable -> 0x00b3 }
        goto L_0x004f;	 Catch:{ Throwable -> 0x00b3 }
    L_0x007b:
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00b3 }
        r3 = r1.length();	 Catch:{ Throwable -> 0x00b3 }
        if (r3 <= 0) goto L_0x00a3;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0085:
        r3 = 4;	 Catch:{ Throwable -> 0x00b3 }
        r1 = r1.substring(r3);	 Catch:{ Throwable -> 0x00b3 }
        r3 = "t_lr";	 Catch:{ Throwable -> 0x00b3 }
        r1 = r0.delete(r3, r1, r9);	 Catch:{ Throwable -> 0x00b3 }
        r3 = "[Database] deleted %s illegal data %d";	 Catch:{ Throwable -> 0x00b3 }
        r5 = 2;	 Catch:{ Throwable -> 0x00b3 }
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00b3 }
        r6 = "t_lr";	 Catch:{ Throwable -> 0x00b3 }
        r5[r4] = r6;	 Catch:{ Throwable -> 0x00b3 }
        r4 = 1;	 Catch:{ Throwable -> 0x00b3 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x00b3 }
        r5[r4] = r1;	 Catch:{ Throwable -> 0x00b3 }
        com.tencent.bugly.proguard.an.d(r3, r5);	 Catch:{ Throwable -> 0x00b3 }
    L_0x00a3:
        if (r11 == 0) goto L_0x00a8;
    L_0x00a5:
        r11.close();	 Catch:{ all -> 0x00de }
    L_0x00a8:
        r11 = a;	 Catch:{ all -> 0x00de }
        if (r11 == 0) goto L_0x00b1;	 Catch:{ all -> 0x00de }
    L_0x00ac:
        if (r0 == 0) goto L_0x00b1;	 Catch:{ all -> 0x00de }
    L_0x00ae:
        r0.close();	 Catch:{ all -> 0x00de }
    L_0x00b1:
        monitor-exit(r10);
        return r2;
    L_0x00b3:
        r1 = move-exception;
    L_0x00b4:
        r2 = com.tencent.bugly.proguard.an.a(r1);	 Catch:{ all -> 0x00cc }
        if (r2 != 0) goto L_0x00bd;	 Catch:{ all -> 0x00cc }
    L_0x00ba:
        r1.printStackTrace();	 Catch:{ all -> 0x00cc }
    L_0x00bd:
        if (r11 == 0) goto L_0x00c2;
    L_0x00bf:
        r11.close();	 Catch:{ all -> 0x00de }
    L_0x00c2:
        r11 = a;	 Catch:{ all -> 0x00de }
        if (r11 == 0) goto L_0x00dc;	 Catch:{ all -> 0x00de }
    L_0x00c6:
        if (r0 == 0) goto L_0x00dc;	 Catch:{ all -> 0x00de }
    L_0x00c8:
        r0.close();	 Catch:{ all -> 0x00de }
        goto L_0x00dc;	 Catch:{ all -> 0x00de }
    L_0x00cc:
        r1 = move-exception;	 Catch:{ all -> 0x00de }
    L_0x00cd:
        if (r11 == 0) goto L_0x00d2;	 Catch:{ all -> 0x00de }
    L_0x00cf:
        r11.close();	 Catch:{ all -> 0x00de }
    L_0x00d2:
        r11 = a;	 Catch:{ all -> 0x00de }
        if (r11 == 0) goto L_0x00db;	 Catch:{ all -> 0x00de }
    L_0x00d6:
        if (r0 == 0) goto L_0x00db;	 Catch:{ all -> 0x00de }
    L_0x00d8:
        r0.close();	 Catch:{ all -> 0x00de }
    L_0x00db:
        throw r1;	 Catch:{ all -> 0x00de }
    L_0x00dc:
        monitor-exit(r10);
        return r9;
    L_0x00de:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.a(int):java.util.List<com.tencent.bugly.proguard.ag>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.util.List<com.tencent.bugly.proguard.ag> r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        if (r6 == 0) goto L_0x008b;
    L_0x0003:
        r0 = r6.size();	 Catch:{ all -> 0x0088 }
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        goto L_0x008b;
    L_0x000b:
        r0 = c;	 Catch:{ all -> 0x0088 }
        r0 = r0.getWritableDatabase();	 Catch:{ all -> 0x0088 }
        if (r0 == 0) goto L_0x0086;
    L_0x0013:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0088 }
        r1.<init>();	 Catch:{ all -> 0x0088 }
        r6 = r6.iterator();	 Catch:{ all -> 0x0088 }
    L_0x001c:
        r2 = r6.hasNext();	 Catch:{ all -> 0x0088 }
        if (r2 == 0) goto L_0x0033;
    L_0x0022:
        r2 = r6.next();	 Catch:{ all -> 0x0088 }
        r2 = (com.tencent.bugly.proguard.ag) r2;	 Catch:{ all -> 0x0088 }
        r3 = " or _id = ";
        r1.append(r3);	 Catch:{ all -> 0x0088 }
        r2 = r2.a;	 Catch:{ all -> 0x0088 }
        r1.append(r2);	 Catch:{ all -> 0x0088 }
        goto L_0x001c;
    L_0x0033:
        r6 = r1.toString();	 Catch:{ all -> 0x0088 }
        r2 = r6.length();	 Catch:{ all -> 0x0088 }
        if (r2 <= 0) goto L_0x0042;
    L_0x003d:
        r2 = 4;
        r6 = r6.substring(r2);	 Catch:{ all -> 0x0088 }
    L_0x0042:
        r2 = 0;
        r1.setLength(r2);	 Catch:{ all -> 0x0088 }
        r1 = "t_lr";
        r3 = 0;
        r6 = r0.delete(r1, r6, r3);	 Catch:{ Throwable -> 0x006b }
        r1 = "[Database] deleted %s data %d";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x006b }
        r4 = "t_lr";
        r3[r2] = r4;	 Catch:{ Throwable -> 0x006b }
        r2 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x006b }
        r3[r2] = r6;	 Catch:{ Throwable -> 0x006b }
        com.tencent.bugly.proguard.an.c(r1, r3);	 Catch:{ Throwable -> 0x006b }
        r6 = a;	 Catch:{ all -> 0x0088 }
        if (r6 == 0) goto L_0x0086;
    L_0x0064:
        r0.close();	 Catch:{ all -> 0x0088 }
        monitor-exit(r5);
        return;
    L_0x0069:
        r6 = move-exception;
        goto L_0x007e;
    L_0x006b:
        r6 = move-exception;
        r1 = com.tencent.bugly.proguard.an.a(r6);	 Catch:{ all -> 0x0069 }
        if (r1 != 0) goto L_0x0075;
    L_0x0072:
        r6.printStackTrace();	 Catch:{ all -> 0x0069 }
    L_0x0075:
        r6 = a;	 Catch:{ all -> 0x0088 }
        if (r6 == 0) goto L_0x0086;
    L_0x0079:
        r0.close();	 Catch:{ all -> 0x0088 }
        monitor-exit(r5);
        return;
    L_0x007e:
        r1 = a;	 Catch:{ all -> 0x0088 }
        if (r1 == 0) goto L_0x0085;
    L_0x0082:
        r0.close();	 Catch:{ all -> 0x0088 }
    L_0x0085:
        throw r6;	 Catch:{ all -> 0x0088 }
    L_0x0086:
        monitor-exit(r5);
        return;
    L_0x0088:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
    L_0x008b:
        monitor-exit(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.a(java.util.List):void");
    }

    public synchronized void b(int i) {
        SQLiteDatabase writableDatabase = c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    StringBuilder stringBuilder = new StringBuilder("_tp = ");
                    stringBuilder.append(i);
                    i = stringBuilder.toString();
                } catch (int i2) {
                    if (!an.a(i2)) {
                        i2.printStackTrace();
                    }
                    if (!(a == 0 || writableDatabase == null)) {
                        writableDatabase.close();
                        return;
                    }
                    return;
                }
            }
            i2 = 0;
            i2 = writableDatabase.delete("t_lr", i2, null);
            an.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(i2));
            if (!(a == 0 || writableDatabase == null)) {
                writableDatabase.close();
            }
        }
    }

    protected ContentValues b(ag agVar) {
        if (agVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (agVar.a > 0) {
                contentValues.put("_id", Long.valueOf(agVar.a));
            }
            contentValues.put("_tp", Integer.valueOf(agVar.b));
            contentValues.put("_pc", agVar.c);
            contentValues.put("_th", agVar.d);
            contentValues.put("_tm", Long.valueOf(agVar.e));
            if (agVar.g != null) {
                contentValues.put("_dt", agVar.g);
            }
            return contentValues;
        } catch (ag agVar2) {
            if (!an.a(agVar2)) {
                agVar2.printStackTrace();
            }
            return null;
        }
    }

    protected ag a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ag agVar = new ag();
            agVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            agVar.b = cursor.getInt(cursor.getColumnIndex("_tp"));
            agVar.c = cursor.getString(cursor.getColumnIndex("_pc"));
            agVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            agVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            agVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return agVar;
        } catch (Cursor cursor2) {
            if (!an.a(cursor2)) {
                cursor2.printStackTrace();
            }
            return null;
        }
    }

    private synchronized java.util.List<com.tencent.bugly.proguard.ag> c(int r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = 0;
        r1 = c;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bb }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x00bf, all -> 0x00bb }
        if (r1 == 0) goto L_0x00b1;
    L_0x000a:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r3 = "_id = ";	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r2.append(r12);	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r10 = r2.toString();	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r3 = "t_pf";	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r4 = 0;	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r6 = 0;	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r7 = 0;	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r8 = 0;	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r9 = 0;	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r2 = r1;	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r5 = r10;	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r2 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        if (r2 != 0) goto L_0x0037;
    L_0x0027:
        if (r2 == 0) goto L_0x002c;
    L_0x0029:
        r2.close();	 Catch:{ all -> 0x00e0 }
    L_0x002c:
        r12 = a;	 Catch:{ all -> 0x00e0 }
        if (r12 == 0) goto L_0x0035;	 Catch:{ all -> 0x00e0 }
    L_0x0030:
        if (r1 == 0) goto L_0x0035;	 Catch:{ all -> 0x00e0 }
    L_0x0032:
        r1.close();	 Catch:{ all -> 0x00e0 }
    L_0x0035:
        monitor-exit(r11);
        return r0;
    L_0x0037:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a9 }
        r3.<init>();	 Catch:{ Throwable -> 0x00a9 }
        r4 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00a9 }
        r4.<init>();	 Catch:{ Throwable -> 0x00a9 }
    L_0x0041:
        r5 = r2.moveToNext();	 Catch:{ Throwable -> 0x00a9 }
        r6 = 0;	 Catch:{ Throwable -> 0x00a9 }
        if (r5 == 0) goto L_0x006d;	 Catch:{ Throwable -> 0x00a9 }
    L_0x0048:
        r5 = r11.b(r2);	 Catch:{ Throwable -> 0x00a9 }
        if (r5 == 0) goto L_0x0052;	 Catch:{ Throwable -> 0x00a9 }
    L_0x004e:
        r4.add(r5);	 Catch:{ Throwable -> 0x00a9 }
        goto L_0x0041;
    L_0x0052:
        r5 = "_tp";	 Catch:{ Throwable -> 0x0065 }
        r5 = r2.getColumnIndex(r5);	 Catch:{ Throwable -> 0x0065 }
        r5 = r2.getString(r5);	 Catch:{ Throwable -> 0x0065 }
        r7 = " or _tp = ";	 Catch:{ Throwable -> 0x0065 }
        r3.append(r7);	 Catch:{ Throwable -> 0x0065 }
        r3.append(r5);	 Catch:{ Throwable -> 0x0065 }
        goto L_0x0041;
    L_0x0065:
        r5 = "[Database] unknown id.";	 Catch:{ Throwable -> 0x00a9 }
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00a9 }
        com.tencent.bugly.proguard.an.d(r5, r6);	 Catch:{ Throwable -> 0x00a9 }
        goto L_0x0041;	 Catch:{ Throwable -> 0x00a9 }
    L_0x006d:
        r5 = r3.length();	 Catch:{ Throwable -> 0x00a9 }
        if (r5 <= 0) goto L_0x0099;	 Catch:{ Throwable -> 0x00a9 }
    L_0x0073:
        r5 = " and _id = ";	 Catch:{ Throwable -> 0x00a9 }
        r3.append(r5);	 Catch:{ Throwable -> 0x00a9 }
        r3.append(r12);	 Catch:{ Throwable -> 0x00a9 }
        r12 = 4;	 Catch:{ Throwable -> 0x00a9 }
        r12 = r10.substring(r12);	 Catch:{ Throwable -> 0x00a9 }
        r3 = "t_pf";	 Catch:{ Throwable -> 0x00a9 }
        r12 = r1.delete(r3, r12, r0);	 Catch:{ Throwable -> 0x00a9 }
        r3 = "[Database] deleted %s illegal data %d.";	 Catch:{ Throwable -> 0x00a9 }
        r5 = 2;	 Catch:{ Throwable -> 0x00a9 }
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00a9 }
        r7 = "t_pf";	 Catch:{ Throwable -> 0x00a9 }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00a9 }
        r6 = 1;	 Catch:{ Throwable -> 0x00a9 }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Throwable -> 0x00a9 }
        r5[r6] = r12;	 Catch:{ Throwable -> 0x00a9 }
        com.tencent.bugly.proguard.an.d(r3, r5);	 Catch:{ Throwable -> 0x00a9 }
    L_0x0099:
        if (r2 == 0) goto L_0x009e;
    L_0x009b:
        r2.close();	 Catch:{ all -> 0x00e0 }
    L_0x009e:
        r12 = a;	 Catch:{ all -> 0x00e0 }
        if (r12 == 0) goto L_0x00a7;	 Catch:{ all -> 0x00e0 }
    L_0x00a2:
        if (r1 == 0) goto L_0x00a7;	 Catch:{ all -> 0x00e0 }
    L_0x00a4:
        r1.close();	 Catch:{ all -> 0x00e0 }
    L_0x00a7:
        monitor-exit(r11);
        return r4;
    L_0x00a9:
        r12 = move-exception;
        goto L_0x00c2;
    L_0x00ab:
        r12 = move-exception;
        r2 = r0;
        goto L_0x00da;
    L_0x00ae:
        r12 = move-exception;
        r2 = r0;
        goto L_0x00c2;
    L_0x00b1:
        r12 = a;	 Catch:{ all -> 0x00e0 }
        if (r12 == 0) goto L_0x00d7;	 Catch:{ all -> 0x00e0 }
    L_0x00b5:
        if (r1 == 0) goto L_0x00d7;	 Catch:{ all -> 0x00e0 }
    L_0x00b7:
        r1.close();	 Catch:{ all -> 0x00e0 }
        goto L_0x00d7;
    L_0x00bb:
        r12 = move-exception;
        r1 = r0;
        r2 = r1;
        goto L_0x00da;
    L_0x00bf:
        r12 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x00c2:
        r3 = com.tencent.bugly.proguard.an.a(r12);	 Catch:{ all -> 0x00d9 }
        if (r3 != 0) goto L_0x00cb;	 Catch:{ all -> 0x00d9 }
    L_0x00c8:
        r12.printStackTrace();	 Catch:{ all -> 0x00d9 }
    L_0x00cb:
        if (r2 == 0) goto L_0x00d0;
    L_0x00cd:
        r2.close();	 Catch:{ all -> 0x00e0 }
    L_0x00d0:
        r12 = a;	 Catch:{ all -> 0x00e0 }
        if (r12 == 0) goto L_0x00d7;
    L_0x00d4:
        if (r1 == 0) goto L_0x00d7;
    L_0x00d6:
        goto L_0x00b7;
    L_0x00d7:
        monitor-exit(r11);
        return r0;
    L_0x00d9:
        r12 = move-exception;
    L_0x00da:
        if (r2 == 0) goto L_0x00e2;
    L_0x00dc:
        r2.close();	 Catch:{ all -> 0x00e0 }
        goto L_0x00e2;	 Catch:{ all -> 0x00e0 }
    L_0x00e0:
        r12 = move-exception;	 Catch:{ all -> 0x00e0 }
        goto L_0x00ec;	 Catch:{ all -> 0x00e0 }
    L_0x00e2:
        r0 = a;	 Catch:{ all -> 0x00e0 }
        if (r0 == 0) goto L_0x00eb;	 Catch:{ all -> 0x00e0 }
    L_0x00e6:
        if (r1 == 0) goto L_0x00eb;	 Catch:{ all -> 0x00e0 }
    L_0x00e8:
        r1.close();	 Catch:{ all -> 0x00e0 }
    L_0x00eb:
        throw r12;	 Catch:{ all -> 0x00e0 }
    L_0x00ec:
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.c(int):java.util.List<com.tencent.bugly.proguard.ag>");
    }

    private synchronized boolean a(int i, String str, ad adVar) {
        boolean z;
        SQLiteDatabase sQLiteDatabase = null;
        z = false;
        try {
            SQLiteDatabase writableDatabase = c.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (ap.a(str)) {
                        str = new StringBuilder("_id = ");
                        str.append(i);
                        i = str.toString();
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("_id = ");
                        stringBuilder.append(i);
                        stringBuilder.append(" and _tp = \"");
                        stringBuilder.append(str);
                        stringBuilder.append("\"");
                        i = stringBuilder.toString();
                    }
                    an.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", i, null)));
                    if (writableDatabase.delete("t_pf", i, null) > 0) {
                        z = true;
                    }
                } catch (Throwable th) {
                    i = th;
                    if (adVar != null) {
                        adVar.a(Boolean.valueOf(false));
                    }
                    if (!(a == null || writableDatabase == null)) {
                        writableDatabase.close();
                    }
                    throw i;
                }
            }
            if (adVar != null) {
                adVar.a(Boolean.valueOf(z));
            }
            if (!(a == 0 || writableDatabase == null)) {
                writableDatabase.close();
            }
        } catch (Throwable th2) {
            i = th2;
            if (an.a(i) == null) {
                i.printStackTrace();
            }
            if (adVar != null) {
                adVar.a(Boolean.valueOf(false));
            }
            sQLiteDatabase.close();
            return z;
        }
        return z;
    }

    protected ContentValues c(ag agVar) {
        if (agVar != null) {
            if (!ap.a(agVar.f)) {
                try {
                    ContentValues contentValues = new ContentValues();
                    if (agVar.a > 0) {
                        contentValues.put("_id", Long.valueOf(agVar.a));
                    }
                    contentValues.put("_tp", agVar.f);
                    contentValues.put("_tm", Long.valueOf(agVar.e));
                    if (agVar.g != null) {
                        contentValues.put("_dt", agVar.g);
                    }
                    return contentValues;
                } catch (ag agVar2) {
                    if (!an.a(agVar2)) {
                        agVar2.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return null;
    }

    protected ag b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ag agVar = new ag();
            agVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            agVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            agVar.f = cursor.getString(cursor.getColumnIndex("_tp"));
            agVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return agVar;
        } catch (Cursor cursor2) {
            if (!an.a(cursor2)) {
                cursor2.printStackTrace();
            }
            return null;
        }
    }
}
