package com.alibaba.baichuan.android.trade.b;

import com.alibaba.baichuan.android.trade.adapter.ut.performance.PagePerformancePoint;
import com.alibaba.baichuan.android.trade.adapter.ut.performance.Point4ShowH5;
import com.alibaba.baichuan.android.trade.adapter.ut.performance.Point4ShowNative;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.g.b;
import com.alibaba.baichuan.android.trade.utils.c;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class a implements Serializable {
    private static final String f = "a";
    public Set a = new HashSet();
    public PagePerformancePoint b;
    public boolean c;
    public String d;
    public AlibcTradeCallback e;

    private void a(b bVar, com.alibaba.baichuan.android.trade.model.a aVar) {
        this.c = bVar == null ? false : bVar.a(aVar);
        a();
        c(bVar == null ? "Other_Page" : bVar.f());
    }

    public void a() {
        this.a.add("goTaobaoTime");
        this.b = this.c ? new Point4ShowNative() : new Point4ShowH5();
    }

    public void a(b bVar) {
        if (bVar == null || this.b == null) {
            c.a(f, "changePoint", "basePage/pagePerformancePoint is null");
            com.alibaba.baichuan.android.trade.utils.g.a.b();
        }
        if (this.b instanceof Point4ShowNative) {
            Point4ShowNative point4ShowNative = (Point4ShowNative) this.b;
            PagePerformancePoint point4ShowH5 = new Point4ShowH5();
            point4ShowH5.analysisTime = point4ShowNative.analysisTime;
            point4ShowH5.setPageType(bVar.f());
            this.b = point4ShowH5;
            this.c = false;
            return;
        }
        c.a(f, "changePoint", "pagePerformancePoint is not Point4ShowNative");
        com.alibaba.baichuan.android.trade.utils.g.a.b();
    }

    public void a(String str) {
        if (this.b == null) {
            c.a(f, "timeBegin", "pagePerformancePoint is null");
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            return;
        }
        this.b.timeBegin(str);
    }

    public void b(String str) {
        if (this.b == null) {
            c.a(f, "timeEnd", "pagePerformancePoint is null");
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            return;
        }
        this.b.timeEnd(str);
    }

    public void c(String str) {
        if (this.b == null) {
            c.a(f, "setPageType", "pagePerformancePoint is null");
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            return;
        }
        this.b.setPageType(str);
    }

    public void d(String str) {
        if (this.b == null) {
            c.a(f, "setTaokeType", "pagePerformancePoint is null");
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            return;
        }
        this.b.setTaokeType(str);
    }

    public a(b bVar, com.alibaba.baichuan.android.trade.model.a aVar) {
        a(bVar, aVar);
        this.d = aVar.d;
    }
}
