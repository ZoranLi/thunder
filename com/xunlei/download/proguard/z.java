package com.xunlei.download.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.util.HttpConstant;
import com.android.providers.downloads.XlTaskHelper;
import com.umeng.message.util.HttpRequest;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.download.proguard.d.c;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.parameter.GetTaskId;
import com.xunlei.downloadlib.parameter.P2spTaskParam;
import com.xunlei.downloadlib.parameter.UrlQuickInfo;
import com.xunlei.downloadlib.parameter.XLConstant.XLCreateTaskMode;
import com.xunlei.downloadlib.parameter.XLConstant.XLManagerStatus;
import com.xunlei.downloadlib.parameter.XLRangeInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfoEx;
import java.io.File;

/* compiled from: XlDownloadTask */
public class z implements Runnable {
    private static final int a = 500;
    public static final long f = -1;
    public static final String g = "ref_trace";
    private long A;
    private long B;
    private long C;
    private XLDownloadManager b;
    private long c;
    private long d;
    private boolean e;
    protected b h;
    protected final d i;
    protected final a j;
    protected final XlTaskHelper k;
    protected final Context l;
    protected final r m;
    protected final e n;
    protected final long o;
    protected final q p;
    protected GetTaskId q = new GetTaskId();
    protected long r;
    protected ContentValues s;
    protected long t;
    protected long u;
    private int v;
    private boolean w;
    private long x;
    private long y;
    private long z;

    /* compiled from: XlDownloadTask */
    public class a {
        public long A;
        public long B;
        public long C;
        public long D;
        public long E;
        public int F;
        public int G;
        public long H;
        public long I;
        public String J;
        final /* synthetic */ z K;
        public String a;
        public String b;
        public String c;
        public int d;
        public int e;
        public int f;
        public long g;
        public long h;
        public String i;
        public String j;
        public long k;
        public long l;
        public long m;
        public String n;
        public String o;
        public String p;
        public boolean q;
        public boolean r;
        public long s;
        public int t;
        public int u;
        public long v;
        public long w;
        public int x;
        public long y;
        public long z;

        public a(z zVar, d dVar) {
            this.K = zVar;
            if (dVar != null) {
                this.a = dVar.d;
                this.b = dVar.g;
                this.c = dVar.h;
                this.d = dVar.l;
                this.e = dVar.m;
                this.f = dVar.n;
                this.g = dVar.v;
                this.h = dVar.w;
                this.i = dVar.x;
                this.n = dVar.K;
                this.o = dVar.L;
                this.q = dVar.O;
                this.r = dVar.P;
                this.x = dVar.T;
                this.y = dVar.U;
                this.t = 190;
                this.u = -1;
                this.J = "";
            }
        }

        private ContentValues b() {
            ContentValues contentValues;
            if (this.K.s != null) {
                contentValues = new ContentValues(this.K.s);
                this.K.s.clear();
            } else {
                contentValues = new ContentValues();
            }
            contentValues.put("uri", this.a);
            contentValues.put(Impl._DATA, this.b);
            contentValues.put("mimetype", this.c);
            if (this.d != 192) {
                contentValues.put("status", Integer.valueOf(this.d));
            }
            contentValues.put(Impl.COLUMN_FAILED_CONNECTIONS, Integer.valueOf(this.e));
            contentValues.put("method", Integer.valueOf(this.f));
            if (this.g > 0) {
                contentValues.put("total_bytes", Long.valueOf(this.g));
            }
            if (this.h > 0) {
                contentValues.put(Impl.COLUMN_CURRENT_BYTES, Long.valueOf(this.h));
            }
            contentValues.put("etag", this.i);
            contentValues.put(Impl.COLUMN_LAST_MODIFICATION, Long.valueOf(this.K.m.a()));
            contentValues.put("errorMsg", this.j);
            contentValues.put("p2s_speed", Long.valueOf(this.B));
            contentValues.put("p2p_speed", Long.valueOf(this.z));
            contentValues.put("origin_speed", Long.valueOf(this.k));
            contentValues.put("download_speed", Long.valueOf(this.l));
            contentValues.put("cid", this.n);
            contentValues.put("gcid", this.o);
            contentValues.put("addition_vip_speed", Long.valueOf(this.m));
            contentValues.put("addition_lx_speed", Long.valueOf(this.v));
            contentValues.put("download_duration", Long.valueOf(this.E));
            contentValues.put("dcdn_speed", Long.valueOf(this.H));
            if (this.s > 0) {
                contentValues.put("vip_receive_size", Long.valueOf(this.s));
            }
            if (this.w > 0) {
                contentValues.put("lx_receive_size", Long.valueOf(this.w));
            }
            if (this.A > 0) {
                contentValues.put("p2p_receive_size", Long.valueOf(this.A));
            }
            if (this.C > 0) {
                contentValues.put("p2s_receive_size", Long.valueOf(this.C));
            }
            if (this.D > 0) {
                contentValues.put("origin_receive_size", Long.valueOf(this.D));
            }
            if (this.I > 0) {
                contentValues.put("dcdn_receive_size", Long.valueOf(this.I));
            }
            contentValues.put(Impl.COLUMN_RES_TOTAL, Integer.valueOf(this.F));
            contentValues.put(Impl.COLUMN_RES_USED_TOTAL, Integer.valueOf(this.G));
            contentValues.put("lx_status", Integer.valueOf(this.x));
            contentValues.put("lx_progress", Long.valueOf(this.y));
            contentValues.put("vip_status", Integer.valueOf(this.t));
            contentValues.put("vip_errno", Integer.valueOf(this.u));
            contentValues.put(Impl.COLUMN_RANGE_INFO, this.J);
            return contentValues;
        }

        public void a() {
            a(null, null);
        }

        private void a(String str, String[] strArr) {
            try {
                this.K.l.getContentResolver().update(this.K.i.j(), b(), str, strArr);
            } catch (Throwable e) {
                e.printStackTrace();
                an.a(e);
            }
        }
    }

    /* compiled from: XlDownloadTask */
    public static abstract class b {
        public abstract int getSubTaskVipErrNo(int i);

        public abstract void removeNotPlayerBtSubTask(XLTaskInfo xLTaskInfo, int i);

        public abstract void stopTask();

        public abstract int tryEnterLXChannel(XLTaskInfo xLTaskInfo, int i, boolean z);

        public abstract int tryEnterVipChannel(XLTaskInfo xLTaskInfo, int i, boolean z);
    }

    private boolean a(long j) {
        return (j == -1 || j == 0) ? false : true;
    }

    public ContentValues a(Context context, ContentValues contentValues) {
        return contentValues;
    }

    public void a(Context context, long j, String str, String str2) {
    }

    public void a(Context context, long j, String str, String str2, String str3) {
    }

    void h() {
    }

    public z(Context context, r rVar, d dVar, q qVar, e eVar) {
        long j = -1;
        this.r = -1;
        this.c = 0;
        this.s = new ContentValues();
        this.d = 0;
        this.e = false;
        this.v = 0;
        this.w = false;
        this.t = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.u = 0;
        this.l = context;
        this.m = rVar;
        this.n = eVar;
        this.i = dVar;
        this.p = qVar;
        this.j = new a(this, dVar);
        if (this.i != null) {
            j = this.i.c;
        }
        this.o = j;
        this.k = XlTaskHelper.a();
        this.h = j.a(context, this.i, this.j);
        if (this.h == null) {
            this.h = new b(this) {
                final /* synthetic */ z a;

                public int getSubTaskVipErrNo(int i) {
                    return -1;
                }

                public void removeNotPlayerBtSubTask(XLTaskInfo xLTaskInfo, int i) {
                }

                public void stopTask() {
                }

                public int tryEnterLXChannel(XLTaskInfo xLTaskInfo, int i, boolean z) {
                    return 190;
                }

                public int tryEnterVipChannel(XLTaskInfo xLTaskInfo, int i, boolean z) {
                    return 190;
                }

                {
                    this.a = r1;
                }
            };
        }
    }

    public void run() {
        a("run begin...");
        if (d.a(this.l, this.i.c) == 200) {
            StringBuilder stringBuilder = new StringBuilder("run end Download ");
            stringBuilder.append(this.i.c);
            stringBuilder.append(" already finished; skipping");
            a(stringBuilder.toString());
            return;
        }
        this.t = this.i.X;
        this.x = this.i.Y;
        this.y = this.i.Z;
        this.z = this.i.aa;
        this.A = this.i.ab;
        this.B = this.i.ad;
        this.C = this.i.ac;
        this.u = SystemClock.elapsedRealtime();
        this.d = SystemClock.elapsedRealtime();
        this.b = XLDownloadManager.getInstance(this.l);
        a("begin to create task.");
        boolean z = this.j.h != 0;
        this.w = z;
        StringBuilder stringBuilder2;
        try {
            e();
            d();
            int i = 0;
            while (true) {
                XLManagerStatus managerStatus = this.b.getManagerStatus();
                if (managerStatus == XLManagerStatus.MANAGER_RUNNING) {
                    break;
                }
                i++;
                if (i <= 20) {
                    Thread.sleep(100);
                } else {
                    stringBuilder2 = new StringBuilder("wait too long for engine init! status = ");
                    stringBuilder2.append(managerStatus);
                    throw new p(491, stringBuilder2.toString());
                }
            }
            a("engine init ok!");
            if (this.j.b == null && this.i.W != TaskType.BT && this.i.W != TaskType.CID && k.a(this.i.i, this.i.f)) {
                a(true, null);
            }
            if (this.j.b == null) {
                this.r = a("", "", ab.b(this.l, this.j.a), z);
            } else {
                i = this.j.b.lastIndexOf(File.separator);
                if (i != -1) {
                    this.r = a(this.j.b.substring(0, i), this.j.b.substring(i + 1), ab.b(this.l, this.j.a), z);
                } else {
                    throw new p(Impl.STATUS_FILE_ERROR, "invalid save path!");
                }
            }
            this.r = this.q.getTaskId();
            stringBuilder = new StringBuilder("create task ");
            stringBuilder.append(this.r);
            a(stringBuilder.toString());
            stringBuilder = new StringBuilder("create task finished: mStatus = ");
            stringBuilder.append(this.j.d);
            stringBuilder.append(", errorMsg = ");
            stringBuilder.append(this.j.j);
            a(stringBuilder.toString());
            this.j.a();
            while (c()) {
                try {
                    Thread.sleep(100);
                } catch (Throwable e) {
                    an.a(e);
                }
            }
        } catch (Throwable e2) {
            e2.printStackTrace();
            an.a(e2);
            this.j.d = e2.getFinalStatus();
            this.j.j = e2.getMessage();
            stringBuilder = new StringBuilder("create task finished: mStatus = ");
            stringBuilder.append(this.j.d);
            stringBuilder.append(", errorMsg = ");
            stringBuilder.append(this.j.j);
            a(stringBuilder.toString());
            this.j.a();
            b();
            a("run end...");
        } catch (Throwable e22) {
            try {
                e22.printStackTrace();
                an.a(e22);
                this.j.j = e22.getMessage();
                this.j.d = 491;
                stringBuilder = new StringBuilder("create task finished: mStatus = ");
                stringBuilder.append(this.j.d);
                stringBuilder.append(", errorMsg = ");
                stringBuilder.append(this.j.j);
                a(stringBuilder.toString());
                this.j.a();
                b();
                a("run end...");
            } catch (Throwable th) {
                stringBuilder2 = new StringBuilder("create task finished: mStatus = ");
                stringBuilder2.append(this.j.d);
                stringBuilder2.append(", errorMsg = ");
                stringBuilder2.append(this.j.j);
                a(stringBuilder2.toString());
                this.j.a();
                b();
                a("run end...");
            }
        }
        a("run end...");
    }

    protected boolean a(int i) {
        i = this.m.a(i);
        if (i != 0) {
            if (i.isConnected()) {
                return ak.a(i.getType());
            }
        }
        return false;
    }

    public void a(int i, XLTaskInfo xLTaskInfo, XLRangeInfo xLRangeInfo) {
        int i2 = i;
        XLTaskInfo xLTaskInfo2 = xLTaskInfo;
        XLRangeInfo xLRangeInfo2 = xLRangeInfo;
        this.j.d = i2;
        if (xLTaskInfo2 != null) {
            long j = ((xLTaskInfo2.mP2PSpeed + xLTaskInfo2.mP2SSpeed) + xLTaskInfo2.mAdditionalResVipSpeed) + xLTaskInfo2.mAdditionalResPeerBytes;
            if (i2 == 192) {
                r0.j.k = xLTaskInfo2.mOriginSpeed;
                r0.j.l = xLTaskInfo2.mDownloadSpeed;
                r0.j.m = xLTaskInfo2.mAdditionalResPeerSpeed;
                r0.j.v = xLTaskInfo2.mAdditionalResVipSpeed;
                r0.j.z = xLTaskInfo2.mP2PSpeed;
                r0.j.B = xLTaskInfo2.mP2SSpeed;
                r0.j.H = xLTaskInfo2.mAdditionalResDCDNSpeed;
                r0.j.I = xLTaskInfo2.mAdditionalResDCDNBytes;
            } else {
                r0.j.k = 0;
                r0.j.l = 0;
                r0.j.m = 0;
                r0.j.v = 0;
                r0.j.z = 0;
                r0.j.B = 0;
                r0.j.H = 0;
            }
            if (xLTaskInfo2.mDownloadSize > 0) {
                r0.j.h = xLTaskInfo2.mDownloadSize;
            }
            if (xLTaskInfo2.mFileSize > 0) {
                r0.j.g = xLTaskInfo2.mFileSize;
            }
            if (!TextUtils.isEmpty(xLTaskInfo2.mCid)) {
                r0.j.n = xLTaskInfo2.mCid;
            }
            if (!TextUtils.isEmpty(xLTaskInfo2.mGcid)) {
                r0.j.o = xLTaskInfo2.mGcid;
            }
            r0.j.s = xLTaskInfo2.mAdditionalResPeerBytes + r0.x;
            r0.j.w = xLTaskInfo2.mAdditionalResVipRecvBytes + r0.y;
            r0.j.A = xLTaskInfo2.mP2PRecvBytes + r0.A;
            r0.j.C = xLTaskInfo2.mP2SRecvBytes + r0.z;
            r0.j.D = xLTaskInfo2.mOriginRecvBytes + r0.B;
            r0.j.E = (SystemClock.elapsedRealtime() - r0.u) + r0.t;
            r0.j.I = xLTaskInfo2.mAdditionalResDCDNBytes + r0.C;
            if (r0.j.l > 0) {
                r0.n.a(r0.o, r0.j.l);
            }
            StringBuilder stringBuilder = new StringBuilder("update task info: speed = ");
            stringBuilder.append(r0.j.k);
            stringBuilder.append(", mXlAccSpeed = ");
            stringBuilder.append(j);
            stringBuilder.append(", mCurrentBytes = ");
            stringBuilder.append(r0.j.h);
            a(stringBuilder.toString());
        } else if (i2 != 192) {
            r0.j.k = 0;
            r0.j.l = 0;
            r0.j.m = 0;
            r0.j.v = 0;
            r0.j.z = 0;
            r0.j.B = 0;
            r0.j.H = 0;
        }
        if (!(xLRangeInfo2 == null || xLRangeInfo2.mRangeInfo == null)) {
            r0.j.J = xLRangeInfo2.mRangeInfo;
        }
        if (i2 != 193) {
            r0.j.a("status!=193", null);
        } else {
            r0.j.a();
        }
        if (i2 == 192) {
            if (!(r0.i.W == TaskType.MAGNET || r0.i.W == TaskType.BT || xLTaskInfo2 == null)) {
                r0.j.x = r0.h.tryEnterLXChannel(xLTaskInfo2, 0, false);
            }
            if (r0.i.W != TaskType.MAGNET && r0.i.W != TaskType.BT && xLTaskInfo2 != null) {
                r0.j.t = r0.h.tryEnterVipChannel(xLTaskInfo2, 0, false);
                r0.j.u = r0.h.getSubTaskVipErrNo(0);
            }
        }
    }

    protected void b(int i) {
        XLTaskInfoEx xLTaskInfoEx = new XLTaskInfoEx();
        if (this.b.getTaskInfoEx(this.r, xLTaskInfoEx) != 9000) {
            this.j.F = 0;
            this.j.G = 0;
        } else if (i == 192) {
            this.j.F = ((xLTaskInfoEx.mP2pAbandonTotal + xLTaskInfoEx.mP2pUsedTotal) + xLTaskInfoEx.mP2sAbandonTotal) + xLTaskInfoEx.mP2sUsedTotal;
            this.j.G = xLTaskInfoEx.mP2pUsedTotal + xLTaskInfoEx.mP2sUsedTotal;
        } else {
            this.j.F = 0;
            this.j.G = 0;
            this.j.t = 190;
            this.j.u = -1;
        }
    }

    private void j() throws p {
        synchronized (this.i) {
            if (this.i.k == 1) {
                throw new p(193, "download paused by owner");
            } else if (this.i.k == 10) {
                throw new p(190, "greater than max downloading num");
            } else {
                if (this.i.l != Impl.STATUS_CANCELED) {
                    if (!this.i.A) {
                    }
                }
                s.a().a(this.i.c);
                throw new p(Impl.STATUS_CANCELED, "download canceled");
            }
        }
        e();
    }

    private static long b(String str) {
        StatFs statFs = new StatFs(str);
        return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
    }

    protected void d() throws com.xunlei.download.proguard.p {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r17 = this;
        r0 = r17;
        r1 = r0.i;
        r1 = r1.g;
        r2 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r3 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        if (r1 == 0) goto L_0x008a;
    L_0x000d:
        r1 = new java.io.File;
        r5 = r0.i;
        r5 = r5.g;
        r1.<init>(r5);
        r1 = r1.getParentFile();
        r5 = r1.exists();
        if (r5 != 0) goto L_0x0038;
    L_0x0020:
        r2 = "checkAvailableSpace";
        r3 = new java.lang.StringBuilder;
        r4 = "not find path=";
        r3.<init>(r4);
        r1 = r1.getAbsolutePath();
        r3.append(r1);
        r1 = r3.toString();
        com.xunlei.download.proguard.an.b(r2, r1);
        return;
    L_0x0038:
        r1 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x0089 }
        r5 = b(r1);	 Catch:{ Exception -> 0x0089 }
        r7 = 52428800; // 0x3200000 float:4.7019774E-37 double:2.5903269E-316;
        r1 = r0.i;
        r9 = r1.v;
        r11 = 0;
        r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        r9 = 10485760; // 0xa00000 float:1.469368E-38 double:5.180654E-317;
        if (r1 > 0) goto L_0x005a;
    L_0x0050:
        r1 = r0.i;
        r1 = r1.W;
        r9 = com.xunlei.download.DownloadManager.TaskType.MAGNET;
        if (r1 != r9) goto L_0x0071;
    L_0x0058:
        r7 = r3;
        goto L_0x0071;
    L_0x005a:
        r1 = r0.i;
        r11 = r1.v;
        r1 = r0.i;
        r13 = r1.w;
        r15 = r11 - r13;
        r1 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1));
        if (r1 >= 0) goto L_0x0069;
    L_0x0068:
        goto L_0x0058;
    L_0x0069:
        r11 = 104857600; // 0x6400000 float:3.6111186E-35 double:5.1806538E-316;
        r1 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1));
        if (r1 >= 0) goto L_0x0071;
    L_0x0070:
        r7 = r9;
    L_0x0071:
        r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r1 >= 0) goto L_0x008a;
    L_0x0075:
        r1 = new com.xunlei.download.proguard.p;
        r3 = new java.lang.StringBuilder;
        r4 = "checkAvailableSpace,size=";
        r3.<init>(r4);
        r3.append(r5);
        r3 = r3.toString();
        r1.<init>(r2, r3);
        throw r1;
    L_0x0089:
        return;
    L_0x008a:
        r1 = r0.l;
        r1 = com.xunlei.download.DownloadManager.getInstanceFor(r1);
        r5 = r0.l;
        r1 = r1.getTaskDBFile(r5);
        if (r1 != 0) goto L_0x009e;
    L_0x0098:
        r1 = r0.l;
        r1 = r1.getFilesDir();
    L_0x009e:
        r1 = r1.getParentFile();
        r5 = r1.exists();
        if (r5 != 0) goto L_0x00c0;
    L_0x00a8:
        r2 = "checkAvailableSpace";
        r3 = new java.lang.StringBuilder;
        r4 = "not find path=";
        r3.<init>(r4);
        r1 = r1.getAbsolutePath();
        r3.append(r1);
        r1 = r3.toString();
        com.xunlei.download.proguard.an.b(r2, r1);
        return;
    L_0x00c0:
        r1 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x00e1 }
        r5 = b(r1);	 Catch:{ Exception -> 0x00e1 }
        r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r1 >= 0) goto L_0x00e0;
    L_0x00cc:
        r1 = new com.xunlei.download.proguard.p;
        r3 = new java.lang.StringBuilder;
        r4 = "checkAvailableSpace,db,size=";
        r3.<init>(r4);
        r3.append(r5);
        r3 = r3.toString();
        r1.<init>(r2, r3);
        throw r1;
    L_0x00e0:
        return;
    L_0x00e1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.z.d():void");
    }

    protected c e() throws p {
        c c = this.i.c(this.j.g);
        StringBuilder stringBuilder = new StringBuilder("checkConnectivity() state = ");
        stringBuilder.append(c);
        stringBuilder.append(", mTotalBytes = ");
        stringBuilder.append(this.j.g);
        stringBuilder.append(", mAllowedNetworkTypes=");
        stringBuilder.append(this.i.D);
        a(stringBuilder.toString());
        if (c == c.OK) {
            return c;
        }
        int i = 196;
        if (c == c.UNUSABLE_DUE_TO_SIZE) {
            this.i.a(true, this.j.g);
        } else if (c == c.RECOMMENDED_UNUSABLE_DUE_TO_SIZE) {
            this.i.a(false, this.j.g);
        } else {
            i = 195;
        }
        throw new p(i, c.name());
    }

    protected String f() {
        String str = "";
        for (Pair pair : this.i.b()) {
            if (!TextUtils.isEmpty((CharSequence) pair.first) && ((String) pair.first).equalsIgnoreCase(HttpConstant.COOKIE)) {
                str = (String) pair.second;
            }
        }
        return str;
    }

    protected String g() {
        String str = "";
        for (Pair pair : this.i.b()) {
            if (!TextUtils.isEmpty((CharSequence) pair.first) && ((String) pair.first).equalsIgnoreCase(HttpRequest.HEADER_REFERER)) {
                str = (String) pair.second;
            }
        }
        return str;
    }

    public long a(String str, String str2, String str3, boolean z) throws p {
        String str4 = str3;
        boolean z2 = z;
        XLDownloadManager instance = XLDownloadManager.getInstance(this.l);
        int ordinal = XLCreateTaskMode.NEW_TASK.ordinal();
        if (z2) {
            ordinal = XLCreateTaskMode.CONTINUE_TASK.ordinal();
        }
        int i = ordinal;
        String f = f();
        String g = g();
        int a = a(r0.o, str4);
        StringBuilder stringBuilder = new StringBuilder("create xl task: name = ");
        String str5 = str2;
        stringBuilder.append(str5);
        stringBuilder.append(", path = ");
        String str6 = str;
        stringBuilder.append(str6);
        stringBuilder.append(", createMode = ");
        stringBuilder.append(i);
        stringBuilder.append(", uri = ");
        stringBuilder.append(str4);
        stringBuilder.append(", cookie=");
        stringBuilder.append(f);
        stringBuilder.append(", refUrl=");
        stringBuilder.append(g);
        stringBuilder.append(", seqId");
        stringBuilder.append(a);
        a(stringBuilder.toString());
        ordinal = instance.createP2spTask(new P2spTaskParam(str5, str6, str4, f, g, "", "", i, a), r0.q);
        if (ordinal != 9000) {
            int b = XlTaskHelper.b(ordinal);
            StringBuilder stringBuilder2 = new StringBuilder("create task failed: ");
            stringBuilder2.append(XlTaskHelper.a(ordinal));
            throw new p(b, stringBuilder2.toString());
        }
        long taskId = r0.q.getTaskId();
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            a(instance, z2, taskId);
        }
        String str7 = r0.i.af;
        if (TextUtils.isEmpty(str7)) {
            str7 = r0.i.p;
        }
        instance.setDownloadTaskOrigin(taskId, str7);
        Object obj = null;
        for (Pair pair : r0.i.b()) {
            if (((String) pair.first).equalsIgnoreCase(HttpRequest.HEADER_USER_AGENT)) {
                obj = 1;
            }
            instance.setHttpHeaderProperty(taskId, (String) pair.first, (String) pair.second);
        }
        if (obj == null) {
            instance.setOriginUserAgent(taskId, k());
        }
        ordinal = instance.startTask(taskId, k.b(r0.i.i, r0.i.f));
        if (ordinal != 9000) {
            b = XlTaskHelper.b(ordinal);
            stringBuilder2 = new StringBuilder("start task failed:");
            stringBuilder2.append(XlTaskHelper.a(ordinal));
            throw new p(b, stringBuilder2.toString());
        }
        stringBuilder = new StringBuilder("xl taskId = ");
        stringBuilder.append(taskId);
        a(stringBuilder.toString());
        return taskId;
    }

    protected void a(XLDownloadManager xLDownloadManager, boolean z, long j) throws p {
        if (!z && this.j.g <= 0 && a(this.i.y) != null) {
            a("tryEnterPrefetchMode()");
            xLDownloadManager = this.b.enterPrefetchMode(j);
            if (xLDownloadManager != true) {
                j = XlTaskHelper.b(xLDownloadManager);
                StringBuilder stringBuilder = new StringBuilder("enterPrefetchMode failed: ");
                stringBuilder.append(XlTaskHelper.a(xLDownloadManager));
                throw new p(j, stringBuilder.toString());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c() {
        /*
        r13 = this;
        r0 = 0;
        r1 = 0;
        r2 = 491; // 0x1eb float:6.88E-43 double:2.426E-321;
        r3 = 1;
        r4 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        r13.j();	 Catch:{ p -> 0x01f3, Throwable -> 0x018d, all -> 0x0186 }
        r5 = r13.w;	 Catch:{ p -> 0x01f3, Throwable -> 0x018d, all -> 0x0186 }
        if (r5 != 0) goto L_0x0011;
    L_0x000e:
        r13.a();	 Catch:{ p -> 0x01f3, Throwable -> 0x018d, all -> 0x0186 }
    L_0x0011:
        r5 = android.os.SystemClock.elapsedRealtime();	 Catch:{ p -> 0x01f3, Throwable -> 0x018d, all -> 0x0186 }
        r7 = r13.c;	 Catch:{ p -> 0x01f3, Throwable -> 0x018d, all -> 0x0186 }
        r9 = 0;
        r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r11 == 0) goto L_0x002e;
    L_0x001d:
        r7 = r13.c;	 Catch:{ p -> 0x01f3, Throwable -> 0x018d, all -> 0x0186 }
        r9 = r5 - r7;
        r7 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r11 <= 0) goto L_0x0028;
    L_0x0027:
        goto L_0x002e;
    L_0x0028:
        r2 = r0;
        r6 = r2;
        r5 = r1;
        r8 = r5;
        goto L_0x010b;
    L_0x002e:
        r13.c = r5;	 Catch:{ p -> 0x01f3, Throwable -> 0x018d, all -> 0x0186 }
        r5 = new com.xunlei.downloadlib.parameter.XLTaskInfo;	 Catch:{ p -> 0x0180, Throwable -> 0x017a, all -> 0x0177 }
        r5.<init>();	 Catch:{ p -> 0x0180, Throwable -> 0x017a, all -> 0x0177 }
        r6 = r13.b;	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        r7 = r13.r;	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        r6 = r6.getTaskInfo(r7, r3, r5);	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        r7 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;
        if (r6 != r7) goto L_0x00f8;
    L_0x0041:
        r6 = r5.mTaskStatus;	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        r7 = 2;
        r8 = 3;
        if (r6 == r8) goto L_0x004e;
    L_0x0047:
        r6 = r5.mTaskStatus;	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        if (r6 != r7) goto L_0x004c;
    L_0x004b:
        goto L_0x004e;
    L_0x004c:
        r6 = r0;
        goto L_0x006d;
    L_0x004e:
        r6 = new java.lang.StringBuilder;	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        r9 = "stop task. mTaskStatus = ";
        r6.<init>(r9);	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        r9 = r5.mTaskStatus;	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        r6.append(r9);	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        r6 = r6.toString();	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        r13.a(r6);	 Catch:{ p -> 0x016e, Throwable -> 0x0167, all -> 0x0162 }
        r6 = com.xunlei.download.proguard.s.a();	 Catch:{ p -> 0x00ef, Throwable -> 0x00e9, all -> 0x00e4 }
        r9 = r13.i;	 Catch:{ p -> 0x00ef, Throwable -> 0x00e9, all -> 0x00e4 }
        r9 = r9.c;	 Catch:{ p -> 0x00ef, Throwable -> 0x00e9, all -> 0x00e4 }
        r6.a(r9);	 Catch:{ p -> 0x00ef, Throwable -> 0x00e9, all -> 0x00e4 }
        r6 = r3;
    L_0x006d:
        r9 = r5.mTaskStatus;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        if (r9 != r8) goto L_0x00ce;
    L_0x0071:
        r7 = r5.mErrorCode;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r8 = 111141; // 0x1b225 float:1.55742E-40 double:5.4911E-319;
        if (r7 == r8) goto L_0x00b6;
    L_0x0078:
        r7 = r13.k;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r8 = r13.m;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r9 = r13.i;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r9 = r9.y;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r8 = r8.a(r9);	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r7 = r7.a(r8);	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        if (r7 == 0) goto L_0x008b;
    L_0x008a:
        goto L_0x00b6;
    L_0x008b:
        r7 = r5.mErrorCode;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        if (r7 == 0) goto L_0x00a6;
    L_0x008f:
        r7 = r5.mErrorCode;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r7 = com.android.providers.downloads.XlTaskHelper.b(r7);	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r4 = r5.mErrorCode;	 Catch:{ p -> 0x00a1, Throwable -> 0x00dc, all -> 0x009d }
        r4 = com.android.providers.downloads.XlTaskHelper.a(r4);	 Catch:{ p -> 0x00a1, Throwable -> 0x00dc, all -> 0x009d }
        goto L_0x00fb;
    L_0x009d:
        r2 = move-exception;
        r8 = r1;
        goto L_0x0267;
    L_0x00a1:
        r2 = move-exception;
        r4 = r1;
        r8 = r4;
        goto L_0x0173;
    L_0x00a6:
        r4 = "info.mErrorCode=0";
        r7 = r2;
        goto L_0x00fb;
    L_0x00ab:
        r0 = move-exception;
        r8 = r1;
        r4 = r2;
        goto L_0x01e6;
    L_0x00b0:
        r4 = move-exception;
        r8 = r1;
        r7 = r2;
        r2 = r4;
        goto L_0x0172;
    L_0x00b6:
        r4 = 195; // 0xc3 float:2.73E-43 double:9.63E-322;
        r7 = "DownloadManager";
        r8 = new java.lang.StringBuilder;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r9 = "Portal Wifi. mErrorCode = ";
        r8.<init>(r9);	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r9 = r5.mErrorCode;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r8.append(r9);	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        r8 = r8.toString();	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        com.xunlei.download.proguard.an.d(r7, r8);	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        goto L_0x00f9;
    L_0x00ce:
        r8 = r5.mTaskStatus;	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        if (r8 != r7) goto L_0x00d5;
    L_0x00d2:
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        goto L_0x00f9;
    L_0x00d5:
        r13.d();	 Catch:{ p -> 0x00e1, Throwable -> 0x00dc, all -> 0x00d9 }
        goto L_0x00f9;
    L_0x00d9:
        r2 = move-exception;
        goto L_0x0164;
    L_0x00dc:
        r4 = move-exception;
        r8 = r1;
        r7 = r6;
        goto L_0x016a;
    L_0x00e1:
        r2 = move-exception;
        goto L_0x0170;
    L_0x00e4:
        r2 = move-exception;
        r8 = r1;
        r6 = r3;
        goto L_0x0268;
    L_0x00e9:
        r4 = move-exception;
        r8 = r1;
        r6 = r3;
        r7 = r6;
        goto L_0x016b;
    L_0x00ef:
        r2 = move-exception;
        r8 = r1;
        r6 = r3;
        r7 = r4;
        r4 = r8;
        r1 = r5;
        r5 = r6;
        goto L_0x01f9;
    L_0x00f8:
        r6 = r0;
    L_0x00f9:
        r7 = r4;
        r4 = r1;
    L_0x00fb:
        r8 = new com.xunlei.downloadlib.parameter.XLRangeInfo;	 Catch:{ p -> 0x015f, Throwable -> 0x0158, all -> 0x0154 }
        r8.<init>();	 Catch:{ p -> 0x015f, Throwable -> 0x0158, all -> 0x0154 }
        r1 = r13.b;	 Catch:{ p -> 0x0152, Throwable -> 0x0149, all -> 0x0146 }
        r9 = r13.r;	 Catch:{ p -> 0x0152, Throwable -> 0x0149, all -> 0x0146 }
        r11 = -1;
        r1.getDownloadRangeInfo(r9, r11, r8);	 Catch:{ p -> 0x0152, Throwable -> 0x0149, all -> 0x0146 }
        r2 = r3;
        r1 = r4;
        r4 = r7;
    L_0x010b:
        r7 = r13.j;
        r7 = r7.d;
        r9 = r13.j;
        r9.d = r4;
        r9 = r13.j;
        r9.j = r1;
        if (r2 == 0) goto L_0x0122;
    L_0x0119:
        r13.b(r4);	 Catch:{ Exception -> 0x0120 }
        r13.a(r4, r5, r8);	 Catch:{ Exception -> 0x0120 }
        goto L_0x0122;
    L_0x0120:
        r1 = move-exception;
        goto L_0x0132;
    L_0x0122:
        r1 = r13.j;	 Catch:{ Exception -> 0x0120 }
        r1 = r1.d;	 Catch:{ Exception -> 0x0120 }
        r1 = com.xunlei.download.Downloads.Impl.isStatusCompleted(r1);	 Catch:{ Exception -> 0x0120 }
        if (r1 == 0) goto L_0x0138;
    L_0x012c:
        r1 = r13.i;	 Catch:{ Exception -> 0x0120 }
        r1.c();	 Catch:{ Exception -> 0x0120 }
        goto L_0x0138;
    L_0x0132:
        r1.printStackTrace();
        com.xunlei.download.proguard.an.a(r1);
    L_0x0138:
        if (r6 == 0) goto L_0x013d;
    L_0x013a:
        r13.b();
    L_0x013d:
        if (r7 == r4) goto L_0x0254;
    L_0x013f:
        r1 = r13.i;
        r1.a(r4);
        goto L_0x0254;
    L_0x0146:
        r2 = move-exception;
        goto L_0x0266;
    L_0x0149:
        r1 = move-exception;
        r7 = r6;
        r6 = r3;
        r12 = r4;
        r4 = r1;
        r1 = r5;
        r5 = r12;
        goto L_0x0192;
    L_0x0152:
        r2 = move-exception;
        goto L_0x0173;
    L_0x0154:
        r2 = move-exception;
        r8 = r1;
        goto L_0x0266;
    L_0x0158:
        r7 = move-exception;
        r8 = r1;
        r1 = r5;
        r5 = r4;
        r4 = r7;
        r7 = r6;
        goto L_0x017e;
    L_0x015f:
        r2 = move-exception;
        r8 = r1;
        goto L_0x0173;
    L_0x0162:
        r2 = move-exception;
        r6 = r0;
    L_0x0164:
        r8 = r1;
        goto L_0x0268;
    L_0x0167:
        r4 = move-exception;
        r7 = r0;
        r8 = r1;
    L_0x016a:
        r6 = r3;
    L_0x016b:
        r1 = r5;
        r5 = r8;
        goto L_0x0192;
    L_0x016e:
        r2 = move-exception;
        r6 = r0;
    L_0x0170:
        r8 = r1;
        r7 = r4;
    L_0x0172:
        r4 = r8;
    L_0x0173:
        r1 = r5;
        r5 = r3;
        goto L_0x01f9;
    L_0x0177:
        r2 = move-exception;
        r6 = r0;
        goto L_0x0189;
    L_0x017a:
        r4 = move-exception;
        r7 = r0;
        r5 = r1;
        r8 = r5;
    L_0x017e:
        r6 = r3;
        goto L_0x0192;
    L_0x0180:
        r2 = move-exception;
        r6 = r0;
        r8 = r1;
        r5 = r3;
        goto L_0x01f7;
    L_0x0186:
        r2 = move-exception;
        r3 = r0;
        r6 = r3;
    L_0x0189:
        r5 = r1;
        r8 = r5;
        goto L_0x0268;
    L_0x018d:
        r4 = move-exception;
        r6 = r0;
        r7 = r6;
        r5 = r1;
        r8 = r5;
    L_0x0192:
        r9 = "unknow error.";
        r4.printStackTrace();	 Catch:{ all -> 0x01e1 }
        com.xunlei.download.proguard.an.a(r4);	 Catch:{ all -> 0x01e1 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01e1 }
        r5 = "stop task. status = 491, errorMsg = ";
        r4.<init>(r5);	 Catch:{ all -> 0x01e1 }
        r4.append(r9);	 Catch:{ all -> 0x01e1 }
        r4 = r4.toString();	 Catch:{ all -> 0x01e1 }
        r13.a(r4);	 Catch:{ all -> 0x01e1 }
        r4 = r13.j;
        r4 = r4.d;
        r5 = r13.j;
        r5.d = r2;
        r5 = r13.j;
        r5.j = r9;
        r13.b(r2);	 Catch:{ Exception -> 0x01cd }
        r13.a(r2, r1, r8);	 Catch:{ Exception -> 0x01cd }
        r1 = r13.j;	 Catch:{ Exception -> 0x01cd }
        r1 = r1.d;	 Catch:{ Exception -> 0x01cd }
        r1 = com.xunlei.download.Downloads.Impl.isStatusCompleted(r1);	 Catch:{ Exception -> 0x01cd }
        if (r1 == 0) goto L_0x01d4;
    L_0x01c7:
        r1 = r13.i;	 Catch:{ Exception -> 0x01cd }
        r1.c();	 Catch:{ Exception -> 0x01cd }
        goto L_0x01d4;
    L_0x01cd:
        r1 = move-exception;
        r1.printStackTrace();
        com.xunlei.download.proguard.an.a(r1);
    L_0x01d4:
        r13.b();
        if (r4 == r2) goto L_0x01de;
    L_0x01d9:
        r1 = r13.i;
        r1.a(r2);
    L_0x01de:
        r6 = r3;
        goto L_0x0254;
    L_0x01e1:
        r0 = move-exception;
        r5 = r1;
        r4 = r2;
        r6 = r3;
        r1 = r9;
    L_0x01e6:
        r2 = r0;
        goto L_0x0268;
    L_0x01e9:
        r0 = move-exception;
        r4 = r2;
        r3 = r6;
        r6 = r7;
        r2 = r0;
        r12 = r5;
        r5 = r1;
        r1 = r12;
        goto L_0x0268;
    L_0x01f3:
        r2 = move-exception;
        r5 = r0;
        r6 = r5;
        r8 = r1;
    L_0x01f7:
        r7 = r4;
        r4 = r8;
    L_0x01f9:
        r9 = r2.getFinalStatus();	 Catch:{ all -> 0x0263 }
        r7 = r2.getMessage();	 Catch:{ all -> 0x025d }
        r2.printStackTrace();	 Catch:{ all -> 0x0258 }
        com.xunlei.download.proguard.an.a(r2);	 Catch:{ all -> 0x0258 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0258 }
        r4 = "stop task. status = ";
        r2.<init>(r4);	 Catch:{ all -> 0x0258 }
        r2.append(r9);	 Catch:{ all -> 0x0258 }
        r4 = ", errorMsg = ";
        r2.append(r4);	 Catch:{ all -> 0x0258 }
        r2.append(r7);	 Catch:{ all -> 0x0258 }
        r2 = r2.toString();	 Catch:{ all -> 0x0258 }
        r13.a(r2);	 Catch:{ all -> 0x0258 }
        r2 = r13.j;
        r2 = r2.d;
        r4 = r13.j;
        r4.d = r9;
        r4 = r13.j;
        r4.j = r7;
        r13.b(r9);	 Catch:{ Exception -> 0x0242 }
        r13.a(r9, r1, r8);	 Catch:{ Exception -> 0x0242 }
        r1 = r13.j;	 Catch:{ Exception -> 0x0242 }
        r1 = r1.d;	 Catch:{ Exception -> 0x0242 }
        r1 = com.xunlei.download.Downloads.Impl.isStatusCompleted(r1);	 Catch:{ Exception -> 0x0242 }
        if (r1 == 0) goto L_0x0249;
    L_0x023c:
        r1 = r13.i;	 Catch:{ Exception -> 0x0242 }
        r1.c();	 Catch:{ Exception -> 0x0242 }
        goto L_0x0249;
    L_0x0242:
        r1 = move-exception;
        r1.printStackTrace();
        com.xunlei.download.proguard.an.a(r1);
    L_0x0249:
        r13.b();
        if (r2 == r9) goto L_0x01de;
    L_0x024e:
        r1 = r13.i;
        r1.a(r9);
        goto L_0x01de;
    L_0x0254:
        if (r6 != 0) goto L_0x0257;
    L_0x0256:
        return r3;
    L_0x0257:
        return r0;
    L_0x0258:
        r2 = move-exception;
        r5 = r1;
        r6 = r3;
        r1 = r7;
        goto L_0x0261;
    L_0x025d:
        r2 = move-exception;
        r3 = r5;
        r5 = r1;
        r1 = r4;
    L_0x0261:
        r4 = r9;
        goto L_0x0268;
    L_0x0263:
        r2 = move-exception;
        r3 = r5;
        r5 = r1;
    L_0x0266:
        r1 = r4;
    L_0x0267:
        r4 = r7;
    L_0x0268:
        r0 = r13.j;
        r0 = r0.d;
        r7 = r13.j;
        r7.d = r4;
        r7 = r13.j;
        r7.j = r1;
        if (r3 == 0) goto L_0x027f;
    L_0x0276:
        r13.b(r4);	 Catch:{ Exception -> 0x027d }
        r13.a(r4, r5, r8);	 Catch:{ Exception -> 0x027d }
        goto L_0x027f;
    L_0x027d:
        r1 = move-exception;
        goto L_0x028f;
    L_0x027f:
        r1 = r13.j;	 Catch:{ Exception -> 0x027d }
        r1 = r1.d;	 Catch:{ Exception -> 0x027d }
        r1 = com.xunlei.download.Downloads.Impl.isStatusCompleted(r1);	 Catch:{ Exception -> 0x027d }
        if (r1 == 0) goto L_0x0295;
    L_0x0289:
        r1 = r13.i;	 Catch:{ Exception -> 0x027d }
        r1.c();	 Catch:{ Exception -> 0x027d }
        goto L_0x0295;
    L_0x028f:
        r1.printStackTrace();
        com.xunlei.download.proguard.an.a(r1);
    L_0x0295:
        if (r6 == 0) goto L_0x029a;
    L_0x0297:
        r13.b();
    L_0x029a:
        if (r0 == r4) goto L_0x02a1;
    L_0x029c:
        r0 = r13.i;
        r0.a(r4);
    L_0x02a1:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.z.c():boolean");
    }

    public void b() {
        if (a(this.r)) {
            if (this.i.ag < 0 || this.i.c == this.i.ag || this.j.d != 190) {
                this.b.stopTaskWithReason(this.r, this.j.d);
            } else {
                this.b.stopTaskWithReason(this.r, 191);
            }
            this.b.releaseTask(this.r);
        }
        this.h.stopTask();
        this.n.a(this.i.c, 0);
        if (this.i.ae == 0) {
            XlTaskHelper.a().b(new long[]{this.i.c});
        }
        h();
    }

    private String k() {
        String str = this.i.t;
        return str == null ? c.t : str;
    }

    protected int a(long j, String str) {
        return XlTaskHelper.a(j, str);
    }

    public void a(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.d;
        StringBuilder stringBuilder;
        if (j > c.x) {
            stringBuilder = new StringBuilder("[");
            stringBuilder.append(this.o);
            stringBuilder.append("] ");
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(str);
            an.c("DownloadManager", stringBuilder.toString());
        } else {
            stringBuilder = new StringBuilder("[");
            stringBuilder.append(this.o);
            stringBuilder.append("] ");
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(str);
            an.b("DownloadManager", stringBuilder.toString());
        }
        this.d = elapsedRealtime;
    }

    private void a(boolean z, String str) throws p {
        if (this.j.b == null) {
            this.j.b = k.a(this.l, ab.b(this.l, this.i.d), this.i.f, null, null, this.j.c, this.i.i, this.j.g, this.p, str);
            str = new StringBuilder("isUserSet=");
            str.append(z);
            str.append(", mInfoDelta.mFileName = ");
            str.append(this.j.b);
            a(str.toString());
            if (!z) {
                if (this.j.b) {
                    if (this.b.setFileName(this.r, this.j.b)) {
                        z = this.j.b.lastIndexOf(46);
                        String str2 = this.j.b;
                        String str3 = "";
                        boolean z2 = false;
                        if (z <= false) {
                            str3 = this.j.b.substring(z);
                            str2 = this.j.b.substring(0, z);
                        }
                        while (z2 < true) {
                            z = this.j;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(str2);
                            stringBuilder.append("_");
                            stringBuilder.append(z2);
                            stringBuilder.append(str3);
                            z.b = stringBuilder.toString();
                            if (!this.b.setFileName(this.r, this.j.b)) {
                                break;
                            }
                            z2++;
                        }
                    }
                }
            }
        }
    }

    public void a() throws p {
        if (!this.e) {
            this.v++;
            if (this.v > 600) {
                throw new p(491, "xunlei - Too many redirects to get header.");
            }
            UrlQuickInfo urlQuickInfo = new UrlQuickInfo();
            if (this.b.getUrlQuickInfo(this.r, urlQuickInfo) == 9000 && (urlQuickInfo.mState == 2 || urlQuickInfo.mState == 3)) {
                this.e = true;
                StringBuilder stringBuilder = new StringBuilder("getUrlQuickInfo() mState = ");
                stringBuilder.append(urlQuickInfo.mState);
                stringBuilder.append(", mFileNameAdvice = ");
                stringBuilder.append(urlQuickInfo.mFileNameAdvice);
                stringBuilder.append(", mContentType = ");
                stringBuilder.append(urlQuickInfo.mContentType);
                stringBuilder.append(", mFileSize = ");
                stringBuilder.append(urlQuickInfo.mFileSize);
                a(stringBuilder.toString());
                if (this.j.c == null) {
                    this.j.c = am.a(urlQuickInfo.mContentType);
                }
                if (urlQuickInfo.mFileSize >= 0) {
                    this.j.g = urlQuickInfo.mFileSize;
                } else {
                    this.j.g = -1;
                }
                a(false, urlQuickInfo.mFileNameAdvice);
                this.j.a();
                if (a(this.i.y)) {
                    e();
                }
            }
        }
    }

    public long i() {
        return this.r;
    }
}
