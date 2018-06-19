package com.alibaba.baichuan.android.trade.adapter.ut.performance;

import com.alibaba.baichuan.android.trade.utils.c;
import com.alibaba.baichuan.android.trade.utils.g.a;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

public class Point4Init extends PerformancePoint {
    private static final String c = "Point4Init";
    public long allTime;
    public long securityInitTime;
    public long utInitTime;

    public static MeasureSet getMeasureSet() {
        return MeasureSet.a().a("securityInitTime").a("utInitTime").a("allTime");
    }

    public boolean checkData() {
        return checkTime(this.securityInitTime) && checkTime(this.utInitTime) && checkTime(this.allTime);
    }

    public MeasureValueSet getMeasureValues() {
        return MeasureValueSet.a().a("securityInitTime", (double) this.securityInitTime).a("utInitTime", (double) this.utInitTime).a("allTime", (double) this.allTime);
    }

    public String getMonitorPoint() {
        return "init";
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
            if (hashCode != -395475012) {
                if (hashCode == 2065809245) {
                    if (str.equals("securityInitTime")) {
                        obj = null;
                    }
                }
            } else if (str.equals("utInitTime")) {
                obj = 1;
            }
        } else if (str.equals("allTime")) {
            obj = 2;
        }
        switch (obj) {
            case null:
                this.securityInitTime = System.currentTimeMillis();
                return;
            case 1:
                this.utInitTime = System.currentTimeMillis();
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
            if (hashCode != -395475012) {
                if (hashCode == 2065809245) {
                    if (str.equals("securityInitTime")) {
                        obj = null;
                    }
                }
            } else if (str.equals("utInitTime")) {
                obj = 1;
            }
        } else if (str.equals("allTime")) {
            obj = 2;
        }
        switch (obj) {
            case null:
                this.securityInitTime = System.currentTimeMillis() - this.securityInitTime;
                return;
            case 1:
                this.utInitTime = System.currentTimeMillis() - this.utInitTime;
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
        StringBuilder stringBuilder = new StringBuilder("Point4Init{securityInitTime=");
        stringBuilder.append(this.securityInitTime);
        stringBuilder.append(", utInitTime=");
        stringBuilder.append(this.utInitTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
