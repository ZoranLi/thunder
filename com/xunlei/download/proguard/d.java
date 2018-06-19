package com.xunlei.download.proguard;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.util.HttpConstant;
import com.android.providers.downloads.DownloadService;
import com.android.providers.downloads.SizeLimitActivity;
import com.android.providers.downloads.XlTaskHelper;
import com.umeng.message.util.HttpRequest;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: DownloadInfo */
public class d {
    public static final String a = "isWifiRequired";
    private static b at = null;
    public static final String b = "total_bytes";
    public boolean A;
    public String B;
    public boolean C;
    public int D;
    public boolean E;
    public boolean F;
    public String G;
    public String H;
    public int I;
    public boolean J;
    public String K;
    public String L;
    public String M;
    public HashSet<Long> N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;
    public int T;
    public long U;
    public long V;
    public TaskType W;
    public long X;
    public long Y;
    public long Z;
    public long aa;
    public long ab;
    public long ac;
    public long ad;
    public long ae;
    public String af;
    public long ag;
    public int ah;
    public int ai;
    private a aj;
    private long ak;
    private List<Pair<String, String>> al;
    private Future<?> am;
    private g an;
    private Runnable ao;
    private final Context ap;
    private final r aq;
    private final q ar;
    private final e as;
    public long c;
    public String d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public long o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public long v;
    public long w;
    public String x;
    public int y;
    public int z;

    /* compiled from: DownloadInfo */
    static class a extends Thread {
        private int a;
        private Context b;

        public a(Context context, int i) {
            this.b = context;
            this.a = i;
        }

        public void run() {
            try {
                Thread.sleep((long) this.a);
                try {
                    this.b.startService(new Intent(this.b, DownloadService.class));
                } catch (Throwable e) {
                    e.printStackTrace();
                    an.a(e);
                }
            } catch (Throwable e2) {
                e2.printStackTrace();
                an.a(e2);
            }
        }
    }

    /* compiled from: DownloadInfo */
    static class b {
        private static final String a = "DownloadManager.DownloadSchedule";
        private static final int c = 10;
        private final int b;
        private int d = 0;
        private int e = 0;
        private HashSet<Long> f;

        public b(int i) {
            this.b = i;
            this.f = new HashSet();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(com.xunlei.download.proguard.d r10) {
            /*
            r9 = this;
            r0 = r10.ah;
            r1 = 1;
            if (r0 != 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r2 = r10.ae;
            r4 = 0;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            r2 = 10;
            r3 = 0;
            if (r0 == 0) goto L_0x0026;
        L_0x0011:
            r0 = r9.f;
            r6 = r10.ae;
            r6 = java.lang.Long.valueOf(r6);
            r0 = r0.contains(r6);
            if (r0 == 0) goto L_0x0024;
        L_0x001f:
            r0 = r9.e;
            if (r0 >= r2) goto L_0x0024;
        L_0x0023:
            goto L_0x005f;
        L_0x0024:
            r1 = r3;
            goto L_0x005f;
        L_0x0026:
            r0 = r10.ap;
            r0 = com.xunlei.download.DownloadManager.getInstanceFor(r0);
            r0 = r0.getRecommandMaxConcurrentDownloads();
            r6 = r9.b;
            if (r0 <= r6) goto L_0x0038;
        L_0x0036:
            r0 = r9.b;
        L_0x0038:
            r6 = "DownloadManager.DownloadSchedule";
            r7 = new java.lang.StringBuilder;
            r8 = "mRunningCount = ";
            r7.<init>(r8);
            r8 = r9.d;
            r7.append(r8);
            r8 = ", mSubTaskCount = ";
            r7.append(r8);
            r8 = r9.e;
            r7.append(r8);
            r7 = r7.toString();
            com.xunlei.download.proguard.an.b(r6, r7);
            r6 = r9.d;
            if (r6 >= r0) goto L_0x0024;
        L_0x005b:
            r0 = r9.e;
            if (r0 >= r2) goto L_0x0024;
        L_0x005f:
            if (r1 == 0) goto L_0x006e;
        L_0x0061:
            r6 = r10.ag;
            r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
            if (r0 < 0) goto L_0x006e;
        L_0x0067:
            r4 = r10.c;
            r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r10 == 0) goto L_0x006e;
        L_0x006d:
            r1 = r3;
        L_0x006e:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.d.b.a(com.xunlei.download.proguard.d):boolean");
        }

        public void b(d dVar) {
            if (dVar.ah != 0) {
                if (dVar.W != TaskType.GROUP) {
                    this.e++;
                } else {
                    this.f.add(Long.valueOf(dVar.c));
                }
                if (dVar.ae == 0) {
                    this.d++;
                }
            }
        }

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f.clear();
        }
    }

    /* compiled from: DownloadInfo */
    public enum c {
        OK,
        NO_CONNECTION,
        UNUSABLE_DUE_TO_SIZE,
        RECOMMENDED_UNUSABLE_DUE_TO_SIZE,
        CANNOT_USE_ROAMING,
        TYPE_DISALLOWED_BY_REQUESTOR,
        BLOCKED
    }

    /* compiled from: DownloadInfo */
    public static class d {
        private ContentResolver a;
        private Cursor b;

        public d(ContentResolver contentResolver, Cursor cursor) {
            this.a = contentResolver;
            this.b = cursor;
        }

        public d a(Context context, r rVar, q qVar, e eVar) {
            d dVar = new d(context, rVar, qVar, eVar);
            a(dVar);
            b(dVar);
            dVar.J = this.b.getInt(this.b.getColumnIndexOrThrow("xunlei_spdy")) != null ? true : null;
            return dVar;
        }

        public void a(d dVar) {
            dVar.c = c("_id").longValue();
            dVar.d = a("uri");
            boolean z = false;
            dVar.e = b(Impl.COLUMN_NO_INTEGRITY).intValue() == 1;
            dVar.f = a(Impl.COLUMN_FILE_NAME_HINT);
            dVar.g = a(Impl._DATA);
            dVar.h = am.a(a("mimetype"));
            dVar.i = b(Impl.COLUMN_DESTINATION).intValue();
            dVar.j = b(Impl.COLUMN_VISIBILITY).intValue();
            dVar.l = b("status").intValue();
            dVar.m = b(Impl.COLUMN_FAILED_CONNECTIONS).intValue();
            dVar.n = b("method").intValue() & 268435455;
            dVar.o = c(Impl.COLUMN_LAST_MODIFICATION).longValue();
            dVar.p = a(Impl.COLUMN_NOTIFICATION_PACKAGE);
            dVar.q = a(Impl.COLUMN_NOTIFICATION_CLASS);
            dVar.r = a(Impl.COLUMN_NOTIFICATION_EXTRAS);
            dVar.s = a(Impl.COLUMN_COOKIE_DATA);
            dVar.t = a(Impl.COLUMN_USER_AGENT);
            dVar.u = a(Impl.COLUMN_REFERER);
            dVar.v = c("total_bytes").longValue();
            dVar.w = c(Impl.COLUMN_CURRENT_BYTES).longValue();
            dVar.x = a("etag");
            dVar.y = b("uid").intValue();
            dVar.z = b("scanned").intValue();
            dVar.A = b(Impl.COLUMN_DELETED).intValue() == 1;
            dVar.B = a("mediaprovider_uri");
            dVar.C = b(Impl.COLUMN_IS_PUBLIC_API).intValue() != 0;
            dVar.E = b(Impl.COLUMN_ALLOW_ROAMING).intValue() != 0;
            dVar.F = b(Impl.COLUMN_ALLOW_METERED).intValue() != 0;
            dVar.G = a("title");
            dVar.H = a("description");
            dVar.I = b(Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT).intValue();
            dVar.K = a("cid");
            dVar.L = a("gcid");
            dVar.V = c("create_time").longValue();
            dVar.O = b("is_vip_speedup").intValue() != 0;
            dVar.P = b("is_lx_speedup").intValue() != 0;
            dVar.Q = b("is_dcdn_speedup").intValue() != 0;
            if (b(Impl.COLUMN_SYNCRO_LX_TASK_TO_SERVER).intValue() != 0) {
                z = true;
            }
            dVar.R = z;
            dVar.U = c("lx_progress").longValue();
            dVar.T = b("lx_status").intValue();
            if (dVar.T == 0) {
                dVar.T = 190;
            }
            dVar.S = b("vip_status").intValue();
            if (dVar.S == 0) {
                dVar.S = 190;
            }
            dVar.M = a("bt_select_set");
            dVar.W = TaskType.values()[b("task_type").intValue()];
            dVar.X = c("download_duration").longValue();
            dVar.Y = c("vip_receive_size").longValue();
            dVar.Z = c("lx_receive_size").longValue();
            dVar.aa = c("p2s_receive_size").longValue();
            dVar.ab = c("p2p_receive_size").longValue();
            dVar.ad = c("origin_receive_size").longValue();
            dVar.ac = c("dcdn_receive_size").longValue();
            dVar.ae = c(Impl.COLUMN_GROUP_ID).longValue();
            dVar.N = ai.a(dVar.M);
            dVar.af = a(Impl.COLUMN_XL_ORIGIN);
            int intValue = b(Impl.COLUMN_ALLOWED_NETWORK_TYPES).intValue();
            if (dVar.ae == 0 && XlTaskHelper.a().a(dVar.c)) {
                dVar.D = intValue | 1;
            } else {
                dVar.D = intValue;
            }
            synchronized (this) {
                dVar.k = b(Impl.COLUMN_CONTROL).intValue();
            }
            dVar.ag = s.a().b();
            dVar.ah = b(Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI).intValue();
        }

        private void b(d dVar) {
            Cursor query;
            dVar.al.clear();
            try {
                query = this.a.query(Uri.withAppendedPath(dVar.j(), RequestHeaders.URI_SEGMENT), null, null, null, null);
            } catch (Throwable e) {
                e.printStackTrace();
                an.a(e);
                query = null;
            }
            if (query != null) {
                try {
                    int columnIndexOrThrow = query.getColumnIndexOrThrow("header");
                    int columnIndexOrThrow2 = query.getColumnIndexOrThrow(RequestHeaders.COLUMN_VALUE);
                    query.moveToFirst();
                    while (!query.isAfterLast()) {
                        a(dVar, query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2));
                        query.moveToNext();
                    }
                } finally {
                    query.close();
                }
            }
            if (dVar.s != null) {
                a(dVar, HttpConstant.COOKIE, dVar.s);
            }
            if (dVar.u != null) {
                a(dVar, HttpRequest.HEADER_REFERER, dVar.u);
            }
        }

        private void a(d dVar, String str, String str2) {
            dVar.al.add(Pair.create(str, str2));
        }

        private String a(String str) {
            str = this.b.getString(this.b.getColumnIndexOrThrow(str));
            return TextUtils.isEmpty(str) ? null : str;
        }

        private Integer b(String str) {
            return Integer.valueOf(this.b.getInt(this.b.getColumnIndexOrThrow(str)));
        }

        private Long c(String str) {
            return Long.valueOf(this.b.getLong(this.b.getColumnIndexOrThrow(str)));
        }
    }

    private int b(int i) {
        if (i == 7) {
            return 4;
        }
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                return 0;
        }
    }

    public static void a() {
        if (at != null) {
            at.a();
        }
    }

    private d(Context context, r rVar, q qVar, e eVar) {
        int a;
        this.ak = 0;
        this.al = new ArrayList();
        this.ap = context;
        this.aq = rVar;
        this.ar = qVar;
        this.as = eVar;
        this.ai = k.a.nextInt(1001);
        if (at == null) {
            int i = 10;
            try {
                a = ad.a(context, DownloadManager.KEY_MAX_CONCURRENT_DOWNLOADS, 10);
            } finally {
                i = 
/*
Method generation error in method: com.xunlei.download.proguard.d.<init>(android.content.Context, com.xunlei.download.proguard.r, com.xunlei.download.proguard.q, com.xunlei.download.proguard.e):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r4_5 'i' int) = (r4_4 'i' int), (r3_3 'a' int) in method: com.xunlei.download.proguard.d.<init>(android.content.Context, com.xunlei.download.proguard.r, com.xunlei.download.proguard.q, com.xunlei.download.proguard.e):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 27 more

*/

                public Collection<Pair<String, String>> b() {
                    return Collections.unmodifiableList(this.al);
                }

                public void c() {
                    if (this.p != null) {
                        Intent intent;
                        if (this.C) {
                            intent = new Intent(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                            intent.setPackage(this.p);
                            intent.putExtra(DownloadManager.EXTRA_DOWNLOAD_ID, this.c);
                        } else if (this.q != null) {
                            intent = new Intent(Impl.ACTION_DOWNLOAD_COMPLETED);
                            intent.setClassName(this.p, this.q);
                            if (this.r != null) {
                                intent.putExtra(Impl.COLUMN_NOTIFICATION_EXTRAS, this.r);
                            }
                            intent.setData(i());
                        } else {
                            return;
                        }
                        this.aq.a(intent);
                    }
                }

                public void a(int i) {
                    Intent intent = new Intent(DownloadManager.ACTION_DOWNLOAD_START_OR_COMPLETE);
                    intent.setPackage(this.p);
                    intent.putExtra(DownloadManager.EXTRA_DOWNLOAD_ID, this.c);
                    intent.putExtra(DownloadManager.EXTRA_DOWNLOAD_STATE, DownloadManager.translateStatus(i));
                    intent.putExtra(DownloadManager.EXTRA_DOWNLOAD_STATE_ORIGINAL, i);
                    this.aq.a(intent);
                }

                public long a(long j) {
                    if (this.m == 0) {
                        return j;
                    }
                    if (this.n > null) {
                        return this.o + ((long) this.n);
                    }
                    return this.o + ((long) ((30 * (1000 + this.ai)) * (1 << (this.m - 1))));
                }

                public boolean d() {
                    if (this.k == 1) {
                        return false;
                    }
                    int i = this.l;
                    if (i == 0 || i == 190) {
                        return true;
                    }
                    if (i != 192) {
                        switch (i) {
                            case 194:
                                long a = this.aq.a();
                                return a(a) <= a;
                            case 195:
                            case 196:
                                break;
                            default:
                                switch (i) {
                                    case 198:
                                        return false;
                                    case 199:
                                        return Environment.getExternalStorageState().equals("mounted");
                                    default:
                                        return false;
                                }
                        }
                    } else if (this.W == TaskType.GROUP) {
                        return true;
                    }
                    c c = c(this.v);
                    StringBuilder stringBuilder = new StringBuilder("isReadyToDownload() state = ");
                    stringBuilder.append(c);
                    stringBuilder.append(", mTotalBytes= ");
                    stringBuilder.append(this.v);
                    a(stringBuilder.toString());
                    return c == c.OK;
                }

                public boolean e() {
                    if (Impl.isStatusCompleted(this.l) && this.j == 1) {
                        return true;
                    }
                    return false;
                }

                public boolean b(long j) {
                    return this.N == null ? 0 : this.N.contains(Long.valueOf(j));
                }

                public c c(long j) {
                    NetworkInfo a = this.aq.a(this.y);
                    if (a != null) {
                        if (a.isConnected()) {
                            if (this.aq.c() && !n()) {
                                return c.CANNOT_USE_ROAMING;
                            }
                            if (this.aq.b() && !this.F) {
                                return c.TYPE_DISALLOWED_BY_REQUESTOR;
                            }
                            if (XlTaskHelper.a().a(a)) {
                                return c.NO_CONNECTION;
                            }
                            return a(a.getType(), j);
                        }
                    }
                    return c.NO_CONNECTION;
                }

                private boolean n() {
                    if (this.C) {
                        return this.E;
                    }
                    return this.i != 3;
                }

                private c a(int i, long j) {
                    if (this.C) {
                        int b = b(i);
                        if ((this.D == -1 ? 1 : null) == null && (b & this.D) == 0) {
                            return c.TYPE_DISALLOWED_BY_REQUESTOR;
                        }
                    }
                    return b(i, j);
                }

                private c b(int i, long j) {
                    if (j <= 0) {
                        return c.OK;
                    }
                    if (ak.a(i) != 0) {
                        if (this.W != TaskType.GROUP) {
                            if (this.ae == 0) {
                                i = this.aq.d();
                                if (i != 0 && i.longValue() >= 0 && j > i.longValue()) {
                                    return c.UNUSABLE_DUE_TO_SIZE;
                                }
                                if (this.I == 0) {
                                    i = this.aq.e();
                                    if (i != 0 && i.longValue() >= 0 && j > i.longValue()) {
                                        return c.RECOMMENDED_UNUSABLE_DUE_TO_SIZE;
                                    }
                                }
                            }
                        }
                        i = this.aq.d();
                        if (i != 0 && i.longValue() >= 0 && this.I == 0) {
                            return c.UNUSABLE_DUE_TO_SIZE;
                        }
                    }
                    return c.OK;
                }

                public boolean f() {
                    StringBuilder stringBuilder;
                    boolean z = (this.am == null || this.am.isDone()) ? false : true;
                    if (this.am != null && this.am.isDone()) {
                        stringBuilder = new StringBuilder("isDone() ret=");
                        stringBuilder.append(this.am.isDone());
                        a(stringBuilder.toString());
                        try {
                            this.am.get();
                        } catch (Throwable e) {
                            StringBuilder stringBuilder2 = new StringBuilder("ce ");
                            stringBuilder2.append(e.toString());
                            a(stringBuilder2.toString());
                            an.a(e);
                        }
                    }
                    stringBuilder = new StringBuilder("isActiveTask() ret=");
                    stringBuilder.append(z);
                    a(stringBuilder.toString());
                    return z;
                }

                private boolean o() {
                    if (this.l != 192) {
                        this.l = 192;
                        this.k = 0;
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("status", Integer.valueOf(this.l));
                        contentValues.put(Impl.COLUMN_CONTROL, Integer.valueOf(0));
                        try {
                            if (this.ap.getContentResolver().update(j(), contentValues, "deleted=0", null) > 0) {
                                return true;
                            }
                            return false;
                        } catch (Throwable e) {
                            e.printStackTrace();
                            an.a(e);
                        }
                    }
                    return true;
                }

                public boolean a(ExecutorService executorService) {
                    synchronized (this) {
                        this.ak = SystemClock.elapsedRealtime();
                        boolean z = true;
                        if (this.l == 190 && this.k == 1) {
                            a("stop pending task");
                            executorService = DownloadManager.getInstanceFor(this.ap).getDownloadUri(this.c);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("status", Integer.valueOf(193));
                            this.ap.getContentResolver().update(executorService, contentValues, null, null);
                            return false;
                        }
                        boolean d = d();
                        if (!d || !at.a(this)) {
                            z = false;
                        }
                        StringBuilder stringBuilder = new StringBuilder("isReady = ");
                        stringBuilder.append(d);
                        stringBuilder.append(", scheduleOK = ");
                        stringBuilder.append(z);
                        stringBuilder.append(", groupId = ");
                        stringBuilder.append(this.ae);
                        a(stringBuilder.toString());
                        if (z) {
                            if (f()) {
                                if (this.J == null && this.an != null && this.an.a() == null) {
                                    executorService = new StringBuilder("task is still running, wait to exit. mStatus = ");
                                    executorService.append(this.l);
                                    a(executorService.toString());
                                    g();
                                }
                                o();
                            } else {
                                long a = (long) a(this.ap, this.c);
                                if (a != ((long) this.l)) {
                                    executorService = new StringBuilder("create task: task status changed. mStatus = ");
                                    executorService.append(this.l);
                                    executorService.append("status=");
                                    executorService.append(a);
                                    a(executorService.toString());
                                    g();
                                    return false;
                                } else if (o()) {
                                    Runnable a2;
                                    a(this.l);
                                    StringBuilder stringBuilder2 = new StringBuilder("create task: mXlTask = ");
                                    stringBuilder2.append(this.J);
                                    stringBuilder2.append(", mUri = ");
                                    stringBuilder2.append(this.d);
                                    a(stringBuilder2.toString());
                                    if (this.J) {
                                        a2 = j.a(this.ap, this.aq, this, this.ar, this.as);
                                        if (a2 == null) {
                                            Runnable zVar = new z(this.ap, this.aq, this, this.ar, this.as);
                                        }
                                        this.ao = a2;
                                    } else {
                                        this.an = new g(this.ap, this.aq, this, this.ar, this.as);
                                        a2 = this.an;
                                    }
                                    this.am = executorService.submit(a2);
                                    executorService = new StringBuilder("create task: mSubmittedTask = ");
                                    executorService.append(this.am);
                                    a(executorService.toString());
                                } else {
                                    return false;
                                }
                            }
                            if (this.l == 192) {
                                at.b(this);
                            }
                        } else if (d) {
                            if (this.l == 192) {
                                executorService = new StringBuilder("queue task: ");
                                executorService.append(this.G);
                                a(executorService.toString());
                                executorService = new ContentValues();
                                executorService.put(Impl.COLUMN_CONTROL, Integer.valueOf(10));
                                this.ap.getContentResolver().update(j(), executorService, null, null);
                            } else if (this.l != 190) {
                                executorService = new ContentValues();
                                executorService.put("status", Integer.valueOf(190));
                                this.ap.getContentResolver().update(j(), executorService, null, null);
                            }
                        }
                        executorService = f();
                        return executorService;
                    }
                }

                void g() {
                    if (this.aj != null) {
                        this.aj.interrupt();
                    }
                    this.aj = new a(this.ap, 500);
                    this.aj.start();
                }

                public boolean a(f fVar) {
                    boolean k;
                    synchronized (this) {
                        k = k();
                        if (k) {
                            fVar.a(this);
                        }
                    }
                    return k;
                }

                public boolean h() {
                    if (!(this.i == 1 || this.i == 5 || this.i == 3)) {
                        if (this.i != 2) {
                            return false;
                        }
                    }
                    return true;
                }

                public Uri i() {
                    return DownloadManager.getInstanceFor(this.ap).getDownloadUri(this.c);
                }

                public Uri j() {
                    if (this.ae == 0) {
                        return DownloadManager.getInstanceFor(this.ap).getDownloadUri(this.c);
                    }
                    return ContentUris.withAppendedId(DownloadManager.getInstanceFor(this.ap).getTaskGroupUri(this.ae), this.c);
                }

                public void a(m mVar) {
                    mVar.println("DownloadInfo:");
                    mVar.a();
                    mVar.a("mId", Long.valueOf(this.c));
                    mVar.a("mLastMod", Long.valueOf(this.o));
                    mVar.a("mPackage", this.p);
                    mVar.a("mUid", Integer.valueOf(this.y));
                    mVar.println();
                    mVar.a("mUri", this.d);
                    mVar.println();
                    mVar.a("mMimeType", this.h);
                    mVar.a("mCookies", this.s != null ? "yes" : "no");
                    mVar.a("mReferer", this.u != null ? "yes" : "no");
                    mVar.a("mUserAgent", this.t);
                    mVar.println();
                    mVar.a("mFileName", this.g);
                    mVar.a("mDestination", Integer.valueOf(this.i));
                    mVar.println();
                    mVar.a("mStatus", Impl.statusToString(this.l));
                    mVar.a("mCurrentBytes", Long.valueOf(this.w));
                    mVar.a("mTotalBytes", Long.valueOf(this.v));
                    mVar.println();
                    mVar.a("mNumFailed", Integer.valueOf(this.m));
                    mVar.a("mRetryAfter", Integer.valueOf(this.n));
                    mVar.a("mETag", this.x);
                    mVar.a("mIsPublicApi", Boolean.valueOf(this.C));
                    mVar.println();
                    mVar.a("mAllowedNetworkTypes", Integer.valueOf(this.D));
                    mVar.a("mAllowRoaming", Boolean.valueOf(this.E));
                    mVar.a("mAllowMetered", Boolean.valueOf(this.F));
                    mVar.println();
                    mVar.b();
                }

                public long d(long j) {
                    if (Impl.isStatusCompleted(this.l)) {
                        return Long.MAX_VALUE;
                    }
                    if (this.l != 194) {
                        return 0;
                    }
                    long a = a(j);
                    if (a <= j) {
                        return 0;
                    }
                    return a - j;
                }

                public boolean k() {
                    return this.z == 0 && ((this.i == 0 || this.i == 4 || this.i == 6) && Impl.isStatusSuccess(this.l));
                }

                void a(boolean z, long j) {
                    if (this.W != TaskType.GROUP) {
                        if (this.ae == 0) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(j());
                            intent.setClassName(this.p, SizeLimitActivity.class.getName());
                            intent.setFlags(268435456);
                            intent.putExtra(a, z);
                            intent.putExtra("total_bytes", j);
                            this.ap.startActivity(intent);
                        }
                    }
                }

                public static int a(Context context, long j) {
                    try {
                        context = context.getContentResolver().query(DownloadManager.getInstanceFor(context).getDownloadUri(j), new String[]{"status"}, null, null, null);
                    } catch (Throwable e) {
                        e.printStackTrace();
                        an.a(e);
                        context = null;
                    }
                    if (context == null) {
                        return 190;
                    }
                    try {
                        if (context.moveToFirst()) {
                            j = context.getInt(0);
                            return j;
                        }
                        context.close();
                        return 190;
                    } finally {
                        context.close();
                    }
                }

                public String l() {
                    int i = this.i;
                    if (i != 0) {
                        if (i == 4) {
                            return this.f;
                        }
                        if (i != 6) {
                            return j().toString();
                        }
                    }
                    return this.g != null ? Uri.fromFile(new File(this.g)).toString() : null;
                }

                private void a(String str) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.ak;
                    StringBuilder stringBuilder;
                    if (j > c.x) {
                        stringBuilder = new StringBuilder("[");
                        stringBuilder.append(this.c);
                        stringBuilder.append("] ");
                        stringBuilder.append(j);
                        stringBuilder.append(" ");
                        stringBuilder.append(str);
                        an.c("DownloadManager", stringBuilder.toString());
                    } else {
                        stringBuilder = new StringBuilder("[");
                        stringBuilder.append(this.c);
                        stringBuilder.append("] ");
                        stringBuilder.append(j);
                        stringBuilder.append(" ");
                        stringBuilder.append(str);
                        an.b("DownloadManager", stringBuilder.toString());
                    }
                    this.ak = elapsedRealtime;
                }

                public long m() {
                    return this.ao instanceof z ? ((z) this.ao).i() : -1;
                }
            }
