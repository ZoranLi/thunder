package com.alibaba.baichuan.android.trade.adapter.ut.performance;

import com.alibaba.baichuan.android.trade.utils.c;
import com.alibaba.baichuan.android.trade.utils.g.a;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

public class Point4ShowNative extends PagePerformancePoint {
    private static final String c = "Point4ShowNative";
    public long allTime;
    public long analysisTime;
    public long goTaobaoTime;

    public static MeasureSet getMeasureSet() {
        return MeasureSet.a().a("analysisTime").a("goTaobaoTime").a("allTime");
    }

    public boolean checkData() {
        return checkTime(this.analysisTime) && checkTime(this.goTaobaoTime) && checkTime(this.allTime);
    }

    public MeasureValueSet getMeasureValues() {
        return MeasureValueSet.a().a("analysisTime", (double) this.analysisTime).a("goTaobaoTime", (double) this.goTaobaoTime).a("allTime", (double) this.allTime);
    }

    public String getMonitorPoint() {
        return "showNative";
    }

    public void timeBegin(String str) {
        if (str == null) {
            c.a(c, "timeBegin", "type is null");
            a.b();
            return;
        }
        Object obj = -1;
        int hashCode = str.hashCode();
        if (hashCode != -1748292663) {
            if (hashCode != -912160754) {
                if (hashCode == -197564381) {
                    if (str.equals("goTaobaoTime")) {
                        obj = 1;
                    }
                }
            } else if (str.equals("allTime")) {
                obj = 2;
            }
        } else if (str.equals("analysisTime")) {
            obj = null;
        }
        switch (obj) {
            case null:
                this.analysisTime = System.currentTimeMillis();
                return;
            case 1:
                this.goTaobaoTime = System.currentTimeMillis();
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
        if (hashCode != -1748292663) {
            if (hashCode != -912160754) {
                if (hashCode == -197564381) {
                    if (str.equals("goTaobaoTime")) {
                        obj = 1;
                    }
                }
            } else if (str.equals("allTime")) {
                obj = 2;
            }
        } else if (str.equals("analysisTime")) {
            obj = null;
        }
        switch (obj) {
            case null:
                this.analysisTime = System.currentTimeMillis() - this.analysisTime;
                return;
            case 1:
                this.goTaobaoTime = System.currentTimeMillis() - this.goTaobaoTime;
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
        StringBuilder stringBuilder = new StringBuilder("Point4ShowNative{analysisTime=");
        stringBuilder.append(this.analysisTime);
        stringBuilder.append(", goTaobaoTime=");
        stringBuilder.append(this.goTaobaoTime);
        stringBuilder.append(", allTime=");
        stringBuilder.append(this.allTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
