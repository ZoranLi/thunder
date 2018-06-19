package com.xunlei.downloadprovider.launch.e;

import android.os.SystemClock;
import com.umeng.message.proguard.k;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: LaunchAnalysisReport */
public class b {
    private static long g = SystemClock.uptimeMillis();
    private static long h = SystemClock.elapsedRealtime();
    protected long a;
    public long b;
    public long c;
    public long d;
    private long e;
    private int f = 0;

    public static String a() {
        long uptimeMillis = SystemClock.uptimeMillis() - g;
        long elapsedRealtime = SystemClock.elapsedRealtime() - h;
        g += uptimeMillis;
        StringBuilder stringBuilder = new StringBuilder(" elapsed:[");
        stringBuilder.append(elapsedRealtime);
        stringBuilder.append("] deltats:[");
        stringBuilder.append(uptimeMillis);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void b() {
        this.e = SystemClock.elapsedRealtime();
        this.f++;
        if (this.d <= 0 || this.d < this.c) {
            this.d = this.c;
        }
        long j = this.d - this.a;
        long j2 = this.e - this.d;
        StatEvent build = HubbleEventBuilder.build("android_launch", "launch_page");
        build.add("stage1_time", j);
        build.add("stage2_time", j2);
        ThunderReport.reportEvent(build);
        StringBuilder stringBuilder = new StringBuilder("reportEndOfLoading:");
        stringBuilder.append(a());
        stringBuilder.append(k.s);
        stringBuilder.append(j);
        stringBuilder.append("ms|");
        stringBuilder.append(j2);
        stringBuilder.append("ms) counts = ");
        stringBuilder.append(this.f);
    }
}
