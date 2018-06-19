package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.log.e.i;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

/* compiled from: EventType */
public enum f {
    ALARM(65501, 30, "alarmData", ReaderCallback.GET_BAR_ANIMATING),
    COUNTER(65502, 30, "counterData", ReaderCallback.GET_BAR_ANIMATING),
    OFFLINE_COUNTER(65133, 30, "counterData", ReaderCallback.GET_BAR_ANIMATING),
    STAT(65503, 30, "statData", ReaderCallback.GET_BAR_ANIMATING);
    
    static String TAG = "EventType";
    private int e;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean m;
    private String t;

    public static f[] a() {
        return (f[]) a.clone();
    }

    private f(int i, int i2, String str, int i3) {
        this.i = 25;
        this.j = 180;
        this.e = i;
        this.h = i2;
        this.m = true;
        this.t = str;
        this.k = i3;
    }

    public final int m3a() {
        return this.e;
    }

    public final boolean isOpen() {
        return this.m;
    }

    public final void b(boolean z) {
        this.m = z;
    }

    public final int b() {
        return this.h;
    }

    public final void b(int i) {
        i.a(TAG, "[setTriggerCount]", this.t, String.valueOf(i));
        this.h = i;
    }

    public static f a(int i) {
        f[] a = a();
        for (f fVar : a) {
            if (fVar != null && fVar.a() == i) {
                return fVar;
            }
        }
        return 0;
    }

    public final String m4a() {
        return this.t;
    }

    public final int c() {
        return this.i;
    }

    public final int d() {
        return this.j;
    }

    public final void setStatisticsInterval(int i) {
        this.i = i;
        this.j = i;
    }

    public final int e() {
        return this.k;
    }

    public final void c(int i) {
        this.k = i;
    }
}
