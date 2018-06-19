package com.alibaba.baichuan.android.trade.adapter.ut.performance;

import com.alibaba.baichuan.android.trade.utils.c;
import com.alibaba.baichuan.android.trade.utils.g.a;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

public class Point4UrlLoad extends PerformancePoint {
    private static final String c = "Point4UrlLoad";
    public long allTime;
    public long urlHandleTime;
    public long urlLoadTime;

    public static MeasureSet getMeasureSet() {
        return MeasureSet.a().a("urlHandleTime").a("urlLoadTime").a("allTime");
    }

    public boolean checkData() {
        return checkTime(this.urlHandleTime) && checkTime(this.urlLoadTime) && checkTime(this.allTime);
    }

    public MeasureValueSet getMeasureValues() {
        return MeasureValueSet.a().a("urlHandleTime", (double) this.urlHandleTime).a("urlLoadTime", (double) this.urlLoadTime).a("allTime", (double) this.allTime);
    }

    public String getMonitorPoint() {
        return "urlLoad";
    }

    public void timeBegin(String str) {
        if (str == null) {
            c.a(c, "timeBegin", "type is null");
            a.b();
            return;
        }
        Object obj = -1;
        int hashCode = str.hashCode();
        if (hashCode != -912160754) {
            if (hashCode != -738921630) {
                if (hashCode == 750896100) {
                    if (str.equals("urlHandleTime")) {
                        obj = null;
                    }
                }
            } else if (str.equals("urlLoadTime")) {
                obj = 1;
            }
        } else if (str.equals("allTime")) {
            obj = 2;
        }
        switch (obj) {
            case null:
                this.urlHandleTime = System.currentTimeMillis();
                return;
            case 1:
                this.urlLoadTime = System.currentTimeMillis();
                return;
            case 2:
                this.allTime = System.currentTimeMillis();
                return;
            default:
                c.a(c, "timeBegin", "type is not right");
                a.b();
                return;
        }
    }

    public void timeEnd(String str) {
        if (str == null) {
            c.a(c, "timeEnd", "type is null");
            a.b();
            return;
        }
        Object obj = -1;
        int hashCode = str.hashCode();
        if (hashCode != -912160754) {
            if (hashCode != -738921630) {
                if (hashCode == 750896100) {
                    if (str.equals("urlHandleTime")) {
                        obj = null;
                    }
                }
            } else if (str.equals("urlLoadTime")) {
                obj = 1;
            }
        } else if (str.equals("allTime")) {
            obj = 2;
        }
        switch (obj) {
            case null:
                this.urlHandleTime = System.currentTimeMillis() - this.urlHandleTime;
                return;
            case 1:
                this.urlLoadTime = System.currentTimeMillis() - this.urlLoadTime;
                return;
            case 2:
                this.allTime = System.currentTimeMillis() - this.allTime;
                return;
            default:
                c.a(c, "timeEnd", "type is not right");
                a.b();
                return;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Point4UrlLoad{urlHandleTime=");
        stringBuilder.append(this.urlHandleTime);
        stringBuilder.append(", urlLoadTime=");
        stringBuilder.append(this.urlLoadTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
