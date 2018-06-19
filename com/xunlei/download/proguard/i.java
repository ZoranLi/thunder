package com.xunlei.download.proguard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager$Property;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.parameter.TorrentInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.vip_channel_v2.VipChannelV2Manager;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: ExtendEntryVip2Task */
public class i implements com.xunlei.download.proguard.h.b {
    static final String a = "ExtendEntryVip2Task";
    private static VipChannelV2Manager b = null;
    private static XLDownloadManager c = null;
    private static DownloadManager d = null;
    private static boolean e = false;
    private static String f = "";

    /* compiled from: ExtendEntryVip2Task */
    enum a {
        Init,
        Queryed,
        Commiting,
        Commited,
        GetAccRes,
        Finish,
        Failure
    }

    /* compiled from: ExtendEntryVip2Task */
    static class b {
        public a a = a.Init;
        public y b;
        public x c;
        public u d;
        private XLTaskInfo e;
        private int f = -1;
        private int g = 190;
        private t h;
        private boolean i;

        public b(XLTaskInfo xLTaskInfo, int i) {
            this.e = xLTaskInfo;
            this.f = i;
            this.h = new t(xLTaskInfo.mTaskId, i);
            this.i = null;
        }

        public void a(boolean z) {
            this.a = a.Init;
            if (this.b != null) {
                this.b.d();
            }
            if (this.c != null) {
                this.c.d();
            }
            if (this.d != null) {
                this.d.d();
                if (z) {
                    this.d.c(this.e, this.f);
                }
            }
        }

        public boolean a() {
            return this.i;
        }

        public void b(boolean z) {
            this.i = z;
        }

        public t b() {
            return this.h;
        }

        public XLTaskInfo c() {
            return this.e;
        }

        public int d() {
            return this.f;
        }
    }

    /* compiled from: ExtendEntryVip2Task */
    static class c extends com.xunlei.download.proguard.z.b {
        private static final int A = 8;
        private static final int B = 9;
        private static final int C = 10;
        private static final int D = 11;
        private static final int E = 12;
        private static final int F = 13;
        private static final int G = 14;
        private static final int H = 15;
        private static final int I = 16;
        private static final int J = 17;
        private static final int K = 18;
        private static final int L = 19;
        static final String a = "VipChannel2TaskImpl";
        private static final String p = "dcdn";
        private static final String q = "switch";
        private static final String r = "610";
        private static final String s = "611";
        private static final int t = 0;
        private static final int u = 1;
        private static final int v = 2;
        private static final int w = 3;
        private static final int x = 4;
        private static final int y = 5;
        private static final int z = 7;
        private com.xunlei.download.proguard.v.b M = new com.xunlei.download.proguard.v.b(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void a(com.xunlei.download.proguard.v.c cVar, int i) {
                switch (cVar) {
                    case TrialQuery:
                        this.a.b(i);
                        return;
                    case TrialCommit:
                        this.a.c(i);
                        return;
                    case TransResQuery:
                        this.a.a(i);
                        return;
                    case TransOffline:
                        this.a.d(i);
                        return;
                    default:
                        an.d(c.a, "no this type");
                        return;
                }
            }

            public void a(com.xunlei.download.proguard.v.c cVar, int i, int i2, int i3, int i4) {
                switch (cVar) {
                    case TrialQuery:
                        this.a.b(i, i2, i3, i4);
                        return;
                    case TrialCommit:
                        this.a.c(i, i2, i3, i4);
                        return;
                    case TransResQuery:
                        this.a.a(i, i2, i3, i4);
                        return;
                    case TransOffline:
                        this.a.d(i, i2, i3, i4);
                        return;
                    default:
                        an.d(c.a, "no this type");
                        return;
                }
            }

            public void a(int i, String str, String str2) {
                this.a.a(i, str, str2);
            }
        };
        private d b;
        private com.xunlei.download.proguard.z.a c;
        private Context d;
        private TorrentInfo e = null;
        private long f = -1;
        private boolean g = false;
        private long h = 0;
        private int i = -1;
        private int j = 190;
        private w k;
        private HashMap<Integer, b> l = new HashMap();
        private t m;
        private boolean n;
        private long o;

        public int tryEnterLXChannel(XLTaskInfo xLTaskInfo, int i, boolean z) {
            return 491;
        }

        public c(Context context, d dVar, com.xunlei.download.proguard.z.a aVar) {
            this.d = context;
            this.b = dVar;
            this.c = aVar;
            this.n = a();
            context = String.format("RecId:%d ", new Object[]{Long.valueOf(this.b.c)});
            dVar = a;
            aVar = new StringBuilder();
            aVar.append(context);
            aVar.append(String.format("Construct VipChannel2TaskImpl object", new Object[0]));
            an.a(dVar, aVar.toString());
        }

        public void stopTask() {
            an.a(a, String.format("stopTask, RecId:%d ", new Object[]{Long.valueOf(this.b.c)}));
            a(false);
        }

        public void removeNotPlayerBtSubTask(XLTaskInfo xLTaskInfo, int i) {
            String format = String.format("RecId:%d,task[%d:%d] ", new Object[]{Long.valueOf(this.b.c), Long.valueOf(xLTaskInfo.mTaskId), Integer.valueOf(i)});
            String str = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(format);
            stringBuilder.append(String.format("removeNotPlayerBtSubTask", new Object[0]));
            an.a(str, stringBuilder.toString());
            Iterator it = this.l.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                Integer num = (Integer) entry.getKey();
                if (!num.equals(Integer.valueOf(i))) {
                    if (((b) entry.getValue()).d != null) {
                        ((b) entry.getValue()).d.c(xLTaskInfo, num.intValue());
                    }
                    it.remove();
                    c(xLTaskInfo.mTaskId, num.intValue());
                }
            }
        }

        public int getSubTaskVipErrNo(int i) {
            b bVar = (b) this.l.get(Integer.valueOf(i));
            if (bVar == null) {
                return -1;
            }
            i = bVar.d;
            if (i == 0) {
                return -1;
            }
            return i.b;
        }

        public int tryEnterVipChannel(XLTaskInfo xLTaskInfo, int i, boolean z) {
            String b = b(xLTaskInfo);
            String a = a(xLTaskInfo);
            if (a.isEmpty() || a(xLTaskInfo, i)) {
                return 190;
            }
            if (this.b.W == TaskType.BT && !this.e) {
                z = String.format("RecId:%d,task[%d] ", new Object[]{Long.valueOf(this.b.c), Long.valueOf(xLTaskInfo.mTaskId)});
                this.e = new TorrentInfo();
                String path = Uri.parse(this.b.d).getPath();
                if (!new File(path).exists()) {
                    path = ab.a(this.b.g, this.b.x);
                }
                if (9000 != i.c.getTorrentInfo(path, this.e)) {
                    xLTaskInfo = a;
                    i = new StringBuilder();
                    i.append(z);
                    i.append(String.format("getTorrentInfo failure, call_ret:%d, torrentPath:%s", new Object[]{Integer.valueOf(r5), path}));
                    an.d(xLTaskInfo, i.toString());
                    return 491;
                }
                String str = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(z);
                stringBuilder.append(String.format("getTorrentInfo, url:%s, path:%s", new Object[]{this.b.d, path}));
                an.a(str, stringBuilder.toString());
            }
            if (0 != this.f && this.b.R) {
                a(xLTaskInfo, i, a, b);
            }
            z = (b) this.l.get(Integer.valueOf(i));
            if (z == null) {
                z = new b(xLTaskInfo, i);
                this.l.put(Integer.valueOf(i), z);
                a(0, i, null);
            }
            b bVar = z;
            if (this.g) {
                return a(xLTaskInfo, i, a, b, bVar);
            }
            return b(xLTaskInfo, i, a, b, bVar);
        }

        private void a(boolean z) {
            String format = String.format("RecId:%d ", new Object[]{Long.valueOf(this.b.c)});
            String str = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(format);
            stringBuilder.append(String.format("innerStopTask, NeedStopAcc:%b", new Object[]{Boolean.valueOf(z)}));
            an.a(str, stringBuilder.toString());
            if (this.k != null) {
                this.k.d();
                this.k = null;
            }
            for (Entry value : this.l.entrySet()) {
                b bVar = (b) value.getValue();
                bVar.a(z);
                c(bVar.c().mTaskId, bVar.d());
            }
            this.l.clear();
        }

        private boolean a(XLTaskInfo xLTaskInfo, int i) {
            String property = i.d.getProperty(DownloadManager$Property.PROP_USER_ID, "0");
            if (TextUtils.isEmpty(property)) {
                property = "0";
            }
            long parseLong = Long.parseLong(property);
            boolean b = l.a().b() ^ true;
            if (parseLong == this.f && b == this.g) {
                return false;
            }
            if (0 == this.h) {
                this.h = System.currentTimeMillis();
                return true;
            } else if (System.currentTimeMillis() - this.h < 1000) {
                return true;
            } else {
                xLTaskInfo = String.format("RecId:%d,task[%d:%d] ", new Object[]{Long.valueOf(this.b.c), Long.valueOf(xLTaskInfo.mTaskId), Integer.valueOf(i)});
                this.f = parseLong;
                this.h = 0;
                if (this.g != b) {
                    a(true);
                }
                this.g = b;
                property = i.d.getProperty(DownloadManager$Property.PROP_SESSION_ID, "");
                String str = "client";
                String c = i.f;
                if (0 == this.f) {
                    property = "-";
                    str = "-";
                    c = "0";
                }
                int VipChannelUpdateUserInfo = i.b.VipChannelUpdateUserInfo(this.f, property, str, c);
                String str2 = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(xLTaskInfo);
                stringBuilder.append(String.format("s_VipChannelV2Manager.VipChannelUpdateUserInfo err_code:%d, vip:%b, uid:%d, SessId:%s, AppId:%s", new Object[]{Integer.valueOf(VipChannelUpdateUserInfo), Boolean.valueOf(this.g), Long.valueOf(this.f), property, c}));
                an.a(str2, stringBuilder.toString());
                return false;
            }
        }

        private int a(XLTaskInfo xLTaskInfo, int i, String str, String str2, b bVar) {
            if (!this.g || this.b.O) {
                return e(xLTaskInfo, i, str, str2, bVar);
            }
            return 190;
        }

        private int b(XLTaskInfo xLTaskInfo, int i, String str, String str2, b bVar) {
            XLTaskInfo xLTaskInfo2 = xLTaskInfo;
            int i2 = i;
            Object obj = bVar;
            if (-1 == this.i) {
                r0.i = i2;
            }
            if (i2 == r0.i) {
                int i3 = 491;
                if (a.Failure == obj.a) {
                    r0.j = 491;
                    obj.g = 491;
                    return 491;
                }
                r7 = new Object[3];
                boolean z = false;
                r7[0] = Long.valueOf(r0.b.c);
                r7[1] = Long.valueOf(xLTaskInfo2.mTaskId);
                r7[2] = Integer.valueOf(i);
                String format = String.format("RecId:%d,task[%d:%d] ", r7);
                String str3;
                StringBuilder stringBuilder;
                int b;
                if (a.Init == obj.a) {
                    b bVar2 = (b) l.a().g(r0.b.c);
                    if (bVar2 != null) {
                        u uVar = bVar2.d;
                        r0.i = bVar2.f;
                        r0.j = bVar2.g;
                        if (i2 == r0.i) {
                            b(xLTaskInfo2.mTaskId, i2);
                            str3 = a;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(format);
                            stringBuilder.append(String.format("recyle use TrialResources, RecCount:%d", new Object[]{Integer.valueOf(uVar.c)}));
                            an.a(str3, stringBuilder.toString());
                            b = uVar.b(xLTaskInfo2, i2);
                            obj.a = 200 == b ? a.Finish : a.Failure;
                            obj.d = uVar;
                            if (a.Finish == obj.a) {
                                i3 = 200;
                            }
                            r0.j = i3;
                            obj.g = i3;
                            return b;
                        } else if (200 == r0.j) {
                            return 501;
                        } else {
                            return r0.j;
                        }
                    }
                    b = c(xLTaskInfo, i, str, str2, bVar);
                    if (b == 190) {
                        return 190;
                    }
                    if (b != 200) {
                        l.a().a(r0.b.c, 0);
                        l.a().a(r0.b.c, false);
                        obj.a = a.Failure;
                        return 491;
                    }
                    b = obj.b.c();
                    l.a().a(r0.b.c, b);
                    l a = l.a();
                    long j = r0.b.c;
                    if (b > 0) {
                        z = true;
                    }
                    a.a(j, z);
                    obj.a = a.Queryed;
                    return 190;
                } else if (a.Queryed == obj.a) {
                    String str4;
                    StringBuilder stringBuilder2;
                    if (i.e) {
                        str4 = a;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(format);
                        stringBuilder2.append(String.format("auto commit Trial", new Object[0]));
                        an.a(str4, stringBuilder2.toString());
                        obj.a = a.Commiting;
                    }
                    if (l.a().e(r0.b.c)) {
                        str4 = a;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(format);
                        stringBuilder2.append(String.format("user commit Trial", new Object[0]));
                        an.a(str4, stringBuilder2.toString());
                        obj.a = a.Commiting;
                    }
                    return 190;
                } else if (a.Commiting == obj.a) {
                    b = d(xLTaskInfo, i, str, str2, bVar);
                    if (b == 190) {
                        return 190;
                    }
                    if (b != 200) {
                        obj.a = a.Failure;
                        return 491;
                    }
                    obj.a = a.Commited;
                    return 190;
                } else if (a.Commited == obj.a) {
                    b = e(xLTaskInfo, i, str, str2, bVar);
                    if (b == 190) {
                        return 190;
                    }
                    if (b != 200) {
                        obj.a = a.Failure;
                        return 491;
                    }
                    obj.a = a.GetAccRes;
                    return 190;
                } else {
                    if (a.GetAccRes == obj.a) {
                        if (!TextUtils.isEmpty(obj.d.d)) {
                            str3 = a;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(format);
                            stringBuilder.append(String.format("save TrialResource to buffer", new Object[0]));
                            an.a(str3, stringBuilder.toString());
                            l.a().a(r0.b.c, obj);
                        }
                        r0.j = 200;
                        obj.g = 200;
                        obj.a = a.Finish;
                    }
                    if (a.Finish == obj.a && ((b) l.a().g(r0.b.c)) == null) {
                        str3 = a;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(format);
                        stringBuilder.append(String.format("APP stop trial, need StopAccelerate", new Object[0]));
                        an.a(str3, stringBuilder.toString());
                        obj.d.c(xLTaskInfo2, i2);
                    }
                    return 200;
                }
            } else if (200 == r0.j) {
                return 501;
            } else {
                return r0.j;
            }
        }

        private int c(XLTaskInfo xLTaskInfo, int i, String str, String str2, b bVar) {
            if (bVar.b == null) {
                bVar.b = new y(this.M);
                bVar.b.a(this.d, this.b, this.c, this.e, i.b, i.c, i.d);
            }
            return bVar.b.c(xLTaskInfo, i, str, str2);
        }

        private int d(XLTaskInfo xLTaskInfo, int i, String str, String str2, b bVar) {
            if (bVar.c == null) {
                bVar.c = new x(this.M);
                bVar.c.a(this.d, this.b, this.c, this.e, i.b, i.c, i.d);
                bVar.c.b = bVar.b.b;
            }
            return bVar.c.c(xLTaskInfo, i, str, str2);
        }

        private int e(XLTaskInfo xLTaskInfo, int i, String str, String str2, b bVar) {
            XLTaskInfo xLTaskInfo2 = xLTaskInfo;
            int i2 = i;
            b bVar2 = bVar;
            String str3 = this.g ? "" : bVar2.c.c;
            if (a(xLTaskInfo2.mTaskId, i2, i.d.getProperty(DownloadManager$Property.PROP_SESSION_ID, ""), str3)) {
                return 200;
            }
            if (bVar2.d == null) {
                bVar2.d = new u(r6.M);
                bVar2.d.a(r6.d, r6.b, r6.c, r6.e, i.b, i.c, i.d);
                bVar2.d.d = str3;
                b(bVar.c().mTaskId, i2);
            }
            int c = bVar2.d.c(xLTaskInfo2, i2, str, str2);
            if (bVar2.d.c()) {
                return 200;
            }
            return c;
        }

        private int a(XLTaskInfo xLTaskInfo, int i, String str, String str2) {
            if (this.k == null) {
                this.k = new w(this.M);
                this.k.a(this.d, this.b, this.c, this.e, i.b, i.c, i.d);
                this.o = xLTaskInfo.mTaskId;
            }
            return this.k.c(xLTaskInfo, i, str, str2);
        }

        protected String a(XLTaskInfo xLTaskInfo) {
            if (this.b.W != TaskType.CID || TextUtils.isEmpty(this.c.o)) {
                xLTaskInfo = xLTaskInfo.mGcid;
            } else {
                xLTaskInfo = this.c.o;
            }
            return TextUtils.isEmpty(xLTaskInfo) ? "" : xLTaskInfo;
        }

        protected String b(XLTaskInfo xLTaskInfo) {
            if (this.b.W != TaskType.CID || TextUtils.isEmpty(this.c.n)) {
                xLTaskInfo = xLTaskInfo.mCid;
            } else {
                xLTaskInfo = this.c.n;
            }
            return TextUtils.isEmpty(xLTaskInfo) ? "" : xLTaskInfo;
        }

        private boolean a() {
            return !XLDownloadManager.getInstance().getSettingValue(p, q, false);
        }

        private boolean a(long j, int i, String str, String str2) {
            String str3 = a;
            StringBuilder stringBuilder = new StringBuilder("startDcdn taskId:");
            long j2 = j;
            stringBuilder.append(j2);
            stringBuilder.append(",subIndex:");
            int i2 = i;
            stringBuilder.append(i2);
            stringBuilder.append(",m_bCanMemAcc:");
            stringBuilder.append(this.g);
            an.b(str3, stringBuilder.toString());
            if (this.n) {
                return false;
            }
            if (!((b) r0.l.get(Integer.valueOf(i2))).a()) {
                b(j2, i2);
                if (r0.g) {
                    XLDownloadManager.getInstance().startDcdn(j2, i2, str, r, "");
                } else {
                    XLDownloadManager.getInstance().startDcdn(j2, i2, str, s, str2);
                }
                ((b) r0.l.get(Integer.valueOf(i2))).b(true);
            }
            return true;
        }

        private void c(long j, int i) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("stopDcdn taskId:");
            stringBuilder.append(j);
            stringBuilder.append(",subIndex:");
            stringBuilder.append(i);
            an.b(str, stringBuilder.toString());
            if (!this.n && ((b) this.l.get(Integer.valueOf(i))).a()) {
                XLDownloadManager.getInstance().stopDcdn(j, i);
                ((b) this.l.get(Integer.valueOf(i))).b(false);
            }
        }

        private void a(int i, int i2, Bundle bundle) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("addVip2TaskStat type:");
            stringBuilder.append(i);
            stringBuilder.append(",idx:");
            stringBuilder.append(i2);
            an.b(str, stringBuilder.toString());
            i2 = ((b) this.l.get(Integer.valueOf(i2))).b();
            if (i2 == 0) {
                an.d(a, "ProcessGetAccRes vip2TaskStat error");
                return;
            }
            switch (i) {
                case 0:
                    i2.a(this.n);
                    return;
                case 1:
                    i2.a();
                    return;
                case 2:
                    i2.b();
                    return;
                case 3:
                    i2.c();
                    return;
                case 4:
                    i2.a(bundle.getInt("result"), bundle.getInt("connErrCode"), bundle.getInt("httpRespCode"));
                    return;
                case 5:
                    i2.d();
                    return;
                case 7:
                    i2.e();
                    return;
                case 8:
                    i2.b(bundle.getInt("result"), bundle.getInt("connErrCode"), bundle.getInt("httpRespCode"));
                    return;
                case 9:
                    i2.a(bundle.getInt("usedtimes"));
                    return;
                case 10:
                    i2.b(bundle.getInt("lefttimes"));
                    return;
                case 11:
                    i2.f();
                    return;
                case 12:
                    i2.g();
                    return;
                case 13:
                    i2.h();
                    return;
                case 14:
                    i2.c(bundle.getInt("result"), bundle.getInt("connErrCode"), bundle.getInt("httpRespCode"));
                    return;
                case 15:
                    i2.i();
                    return;
                case 16:
                    i2.j();
                    return;
                case 17:
                    i2.k();
                    return;
                case 18:
                    i2.d(bundle.getInt("result"), bundle.getInt("connErrCode"), bundle.getInt("httpRespCode"));
                    return;
                case 19:
                    i2.a(bundle.getString("key"), bundle.getString(RequestHeaders.COLUMN_VALUE));
                    return;
                default:
                    i2 = a;
                    bundle = new StringBuilder("addVip2TaskStat has no this cmdtype:");
                    bundle.append(i);
                    an.c(i2, bundle.toString());
                    return;
            }
        }

        private void a(int i) {
            a(1, i, null);
            a(2, i, null);
        }

        private void a(int i, int i2, int i3, int i4) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("vipAccQueryEnd idx:");
            stringBuilder.append(i);
            stringBuilder.append(",result:");
            stringBuilder.append(i2);
            an.b(str, stringBuilder.toString());
            a(5, i, null);
            Bundle bundle = new Bundle();
            bundle.putInt("result", i2);
            bundle.putInt("connErrCode", i3);
            bundle.putInt("httpRespCode", i4);
            a(4, i, bundle);
            a(3, i, null);
        }

        public void a(long j, int i) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("setTaskLxState taskId:");
            stringBuilder.append(j);
            stringBuilder.append(",subIndex:");
            stringBuilder.append(i);
            an.b(str, stringBuilder.toString());
            XLDownloadManager.getInstance().setTaskLxState(j, i, 1);
        }

        public void b(long j, int i) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("setTaskGsState taskId:");
            stringBuilder.append(j);
            stringBuilder.append(",subIndex:");
            stringBuilder.append(i);
            an.b(str, stringBuilder.toString());
            if (this.g) {
                XLDownloadManager.getInstance().setTaskGsState(j, i, 1);
                a(j, i);
                return;
            }
            XLDownloadManager.getInstance().setTaskGsState(j, i, 2);
        }

        private void b(int i) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("vipTrialQueryBegin idx:");
            stringBuilder.append(i);
            an.b(str, stringBuilder.toString());
            a(7, i, null);
            a(11, i, null);
        }

        private void b(int i, int i2, int i3, int i4) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("vipTrialQueryEnd idx:");
            stringBuilder.append(i);
            stringBuilder.append(",result:");
            stringBuilder.append(i2);
            an.b(str, stringBuilder.toString());
            b e = e(i);
            if (e == null) {
                an.c(a, "vipTrialQueryEnd currContainer is null");
                return;
            }
            a(12, i, null);
            Bundle bundle = new Bundle();
            bundle.putInt("result", i2);
            bundle.putInt("connErrCode", i3);
            bundle.putInt("httpRespCode", i4);
            a(8, i, bundle);
            if (i2 == 0) {
                i2 = e.b.e();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("usedtimes", i2.nTrialUsedTimes);
                a(9, i, bundle2);
                bundle2 = new Bundle();
                bundle2.putInt("lefttimes", i2.nTrialLeftTimes);
                a(10, i, bundle2);
            }
        }

        private void c(int i) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("vipTrialSubmitBegin idx:");
            stringBuilder.append(i);
            an.b(str, stringBuilder.toString());
            a(13, i, null);
            a(15, i, null);
        }

        private void c(int i, int i2, int i3, int i4) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("vipTrialSubmitEnd idx:");
            stringBuilder.append(i);
            stringBuilder.append(",result:");
            stringBuilder.append(i2);
            an.b(str, stringBuilder.toString());
            if (e(i) == null) {
                an.c(a, "currContainer is null");
                return;
            }
            a(16, i, null);
            Bundle bundle = new Bundle();
            bundle.putInt("result", i2);
            bundle.putInt("connErrCode", i3);
            bundle.putInt("httpRespCode", i4);
            a(14, i, bundle);
        }

        private void d(int i) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("vipLXSubmitBegin idx:");
            stringBuilder.append(i);
            an.b(str, stringBuilder.toString());
            if (this.m == 0) {
                this.m = new t(this.o, -1);
            }
            this.m.k();
        }

        private void d(int i, int i2, int i3, int i4) {
            i = a;
            StringBuilder stringBuilder = new StringBuilder("vipLXSubmitEnd result:");
            stringBuilder.append(i2);
            an.b(i, stringBuilder.toString());
            if (this.m != 0) {
                this.m.d(i2, i3, i4);
            } else {
                an.c(a, "vipLXSubmitEnd mVip2TaskStat is null");
            }
        }

        private void a(int i, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("key", str);
            bundle.putString(RequestHeaders.COLUMN_VALUE, str2);
            a(19, i, bundle);
        }

        private b e(int i) {
            b bVar = (b) this.l.get(Integer.valueOf(i));
            if (bVar == null) {
                an.c(a, "currContainer is null");
            }
            return bVar;
        }
    }

    public void onInitVipChannel(Context context) {
        if (b == null) {
            d = DownloadManager.getInstanceFor(context);
            c = XLDownloadManager.getInstance(context);
            b = VipChannelV2Manager.getInstance(context);
            int c = ad.c(context);
            f = ad.a(context, "com.xunlei.download.APP_ID", "40");
            String packageName = context.getPackageName();
            context = b.VipChannelInit(context, "xl_android", c, ad.a(context, DownloadManager.KEY_APP_KEY, ""), packageName, ad.b(context), context.getFilesDir().getPath());
            an.a(a, String.format("s_VipChannelV2Manager.VipChannelInit, ret:%d, ClientName:%s, ClientVer:%d, AppId:%s, AppKey:%s, AppName:%s, AppVersion:%s, StoragePath:%s", new Object[]{Integer.valueOf(context), "xl_android", Integer.valueOf(c), f, r11, packageName, r12, r13}));
            if (context != null) {
                String str = a;
                StringBuilder stringBuilder = new StringBuilder("s_VipChannelV2Manager.VipChannelInit error:");
                stringBuilder.append(context);
                an.d(str, stringBuilder.toString());
            }
        }
    }

    public void onUninitVipChannel(Context context) {
        context = b.VipChannelUninit();
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("s_VipChannelV2Manager.VipChannelUninit ret:");
        stringBuilder.append(context);
        an.a(str, stringBuilder.toString());
    }

    public com.xunlei.download.proguard.z.b newVipChannelTask(Context context, d dVar, com.xunlei.download.proguard.z.a aVar) {
        if (!(context == null || dVar == null)) {
            if (aVar != null) {
                return new c(context, dVar, aVar);
            }
        }
        return null;
    }
}
