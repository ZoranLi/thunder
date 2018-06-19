package com.xunlei.download.proguard;

import com.xunlei.downloadlib.XLDownloadManager;

/* compiled from: Vip2TaskStat */
class t {
    private static final String a = "Vip2TaskStat";
    private static final String b = "DcdnHasQuery";
    private static final String c = "DcdnQueryCost";
    private static final String d = "DcdnQueryResult";
    private static final String e = "VipDcdnQuerySwitch";
    private static final String f = "VipDcdnQueryTimes";
    private static final String g = "VipDcdnQueryConnErrorCode";
    private static final String h = "VipDcdnQueryHttpRespErrorCode";
    private static final String i = "VipTrialHasQuery";
    private static final String j = "VipTrialQueryResult";
    private static final String k = "VipTrialUsedTimes";
    private static final String l = "VipTrialLeftTimes";
    private static final String m = "VipTrialQueryCost";
    private static final String n = "VipTrialQueryConnErrorCode";
    private static final String o = "VipTrialQueryHttpRespErrorCode";
    private static final String p = "VipTrialHasSubmit";
    private static final String q = "VipTrialSubmitResult";
    private static final String r = "VipTrialSubmitCost";
    private static final String s = "VipTrialSubmitConnErrorCode";
    private static final String t = "VipTrialSubmitHttpRespErrorCode";
    private static final String u = "VipLXHasSubmit";
    private static final String v = "VipLXSubmitResult";
    private static final String w = "VipLXSubmitConnErrorCode";
    private static final String x = "VipLXSubmitHttpRespErrorCode";
    private long A;
    private int B;
    private int C = 0;
    private int D = 0;
    private long E = 0;
    private long F = 0;
    private long y = 0;
    private long z = 0;

    public t(long j, int i) {
        this.A = j;
        this.B = i;
    }

    public void a(boolean z) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("setVipDcdnQuerySwitchStat vipDcdnQuerySwitch:");
        stringBuilder.append(z);
        an.b(str, stringBuilder.toString());
        if (z) {
            a(e, "1");
        } else {
            a(e, "0");
        }
    }

    public void a() {
        an.b(a, "setDcdnHasQueryStat");
        a(b, "1");
    }

    public void b() {
        an.b(a, "beginDcdnQuery");
        this.y = System.currentTimeMillis();
    }

    public void c() {
        an.b(a, "endDcdnQuery");
        if (this.y == 0) {
            an.c(a, "endDcdnQuery error");
            return;
        }
        this.z += System.currentTimeMillis() - this.y;
        String str = c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.z / ((long) this.C));
        a(str, stringBuilder.toString());
    }

    public void a(int i, int i2, int i3) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("setDcdnQueryResultStat queryResult:");
        stringBuilder.append(i);
        stringBuilder.append(",connErrCode:");
        stringBuilder.append(i2);
        stringBuilder.append(",httpRespCode:");
        stringBuilder.append(i3);
        an.b(str, stringBuilder.toString());
        a(d, String.valueOf(i + 1));
        a(g, String.valueOf(i2));
        a(h, String.valueOf(i3));
    }

    public void d() {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("addDcdnQueryTimes mQueryTime:");
        stringBuilder.append(this.C);
        an.b(str, stringBuilder.toString());
        this.C++;
        l();
    }

    private void l() {
        an.b(a, "setDcdnQueryTimesStat");
        String str = f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.C);
        a(str, stringBuilder.toString());
    }

    public void a(String str, String str2) {
        XLDownloadManager.getInstance().statExternalInfo(this.A, this.B, str, str2);
    }

    public void e() {
        an.b(a, "setVipTrialHasQuery");
        a(i, "1");
    }

    public void b(int i, int i2, int i3) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("setVipTrialQueryResult result:");
        stringBuilder.append(i);
        stringBuilder.append(",connErrCode:");
        stringBuilder.append(i2);
        stringBuilder.append(",httpRespCode:");
        stringBuilder.append(i3);
        an.b(str, stringBuilder.toString());
        a(j, String.valueOf(i));
        a(n, String.valueOf(i2));
        a(o, String.valueOf(i3));
    }

    public void a(int i) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("setVipTrialUsedTimes usedTimes:");
        stringBuilder.append(i);
        an.b(str, stringBuilder.toString());
        a(k, String.valueOf(i));
    }

    public void b(int i) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("setVipTrialLeftTimes leftTimes:");
        stringBuilder.append(i);
        an.b(str, stringBuilder.toString());
        a(l, String.valueOf(i));
    }

    public void f() {
        an.b(a, "beginVipTrialQuery");
        if (0 == this.E) {
            this.E = System.currentTimeMillis();
        } else {
            an.c(a, "mbeginVipTrialQuery is not 0");
        }
    }

    public void g() {
        an.b(a, "endVipTrialQuery");
        if (0 != this.E) {
            a(System.currentTimeMillis() - this.E);
            this.E = 0;
            return;
        }
        an.c(a, "mbeginVipTrialQuery is 0");
    }

    private void a(long j) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("setVipTrialQueryCost costTime:");
        stringBuilder.append(j);
        an.b(str, stringBuilder.toString());
        a(m, String.valueOf(j));
    }

    public void h() {
        an.b(a, "setVipTrialSubmit");
        a(p, "1");
    }

    public void c(int i, int i2, int i3) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("setVipTrialSubmitResult result:");
        stringBuilder.append(i);
        stringBuilder.append(",connErrCode:");
        stringBuilder.append(i2);
        stringBuilder.append(",httpRespCode:");
        stringBuilder.append(i3);
        an.b(str, stringBuilder.toString());
        a(q, String.valueOf(i));
        a(s, String.valueOf(i2));
        a(t, String.valueOf(i3));
    }

    public void i() {
        an.b(a, "beginVipTrialSubmit");
        if (0 == this.F) {
            this.F = System.currentTimeMillis();
        } else {
            an.c(a, "mbeginVipTrialSubmit is not 0");
        }
    }

    public void j() {
        an.b(a, "endVipTrialSubmit");
        if (0 != this.F) {
            b(System.currentTimeMillis() - this.F);
            this.F = 0;
            return;
        }
        an.c(a, "mbeginVipTrialSubmit is 0");
    }

    private void b(long j) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("setVipTrialSubmitCost costTime:");
        stringBuilder.append(j);
        an.b(str, stringBuilder.toString());
        a(r, String.valueOf(j));
    }

    public void k() {
        an.b(a, "setVipLXSubmit");
        a(u, "1");
    }

    public void d(int i, int i2, int i3) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("setVipLXSubmitResult result:");
        stringBuilder.append(i);
        stringBuilder.append(",connErrCode:");
        stringBuilder.append(i2);
        stringBuilder.append(",httpRespCode:");
        stringBuilder.append(i3);
        an.b(str, stringBuilder.toString());
        a(v, String.valueOf(i));
        a(w, String.valueOf(i2));
        a(x, String.valueOf(i3));
    }
}
