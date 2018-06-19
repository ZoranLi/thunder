package com.alibaba.baichuan.android.trade.adapter.ut.performance;

import com.alibaba.baichuan.android.trade.utils.c;
import com.alibaba.baichuan.android.trade.utils.g.a;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

public class Point4ShowH5 extends PagePerformancePoint {
    private static final String c = "Point4ShowH5";
    public long allTime;
    public long analysisTime;
    public long taokeTime;
    public long urlHandleTime;
    public long urlLoadTime;

    public static MeasureSet getMeasureSet() {
        return MeasureSet.a().a("analysisTime").a("taokeTime").a("urlHandleTime").a("urlLoadTime").a("allTime");
    }

    public boolean checkData() {
        return checkTime(this.analysisTime) && checkTime(this.taokeTime) && checkTime(this.urlHandleTime) && checkTime(this.urlLoadTime) && checkTime(this.allTime);
    }

    public MeasureValueSet getMeasureValues() {
        return MeasureValueSet.a().a("analysisTime", (double) this.analysisTime).a("taokeTime", (double) this.taokeTime).a("urlHandleTime", (double) this.urlHandleTime).a("urlLoadTime", (double) this.urlLoadTime).a("allTime", (double) this.allTime);
    }

    public String getMonitorPoint() {
        return "showH5";
    }

    public void timeBegin(String str) {
        if (str == null) {
            c.a(c, "timeBegin", "type is null");
            a.b();
            return;
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1748292663:
                if (str.equals("analysisTime")) {
                    obj = null;
                    break;
                }
                break;
            case -912160754:
                if (str.equals("allTime")) {
                    obj = 4;
                    break;
                }
                break;
            case -738921630:
                if (str.equals("urlLoadTime")) {
                    obj = 3;
                    break;
                }
                break;
            case 750896100:
                if (str.equals("urlHandleTime")) {
                    obj = 2;
                    break;
                }
                break;
            case 930452841:
                if (str.equals("taokeTime")) {
                    obj = 1;
                    break;
                }
                break;
            default:
                break;
        }
        switch (obj) {
            case null:
                this.analysisTime = System.currentTimeMillis();
                return;
            case 1:
                this.taokeTime = System.currentTimeMillis();
                return;
            case 2:
                this.urlHandleTime = System.currentTimeMillis();
                return;
            case 3:
                this.urlLoadTime = System.currentTimeMillis();
                return;
            case 4:
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
        switch (str.hashCode()) {
            case -1748292663:
                if (str.equals("analysisTime")) {
                    obj = null;
                    break;
                }
                break;
            case -912160754:
                if (str.equals("allTime")) {
                    obj = 4;
                    break;
                }
                break;
            case -738921630:
                if (str.equals("urlLoadTime")) {
                    obj = 3;
                    break;
                }
                break;
            case 750896100:
                if (str.equals("urlHandleTime")) {
                    obj = 2;
                    break;
                }
                break;
            case 930452841:
                if (str.equals("taokeTime")) {
                    obj = 1;
                    break;
                }
                break;
            default:
                break;
        }
        switch (obj) {
            case null:
                this.analysisTime = System.currentTimeMillis() - this.analysisTime;
                return;
            case 1:
                this.taokeTime = System.currentTimeMillis() - this.taokeTime;
                return;
            case 2:
                this.urlHandleTime = System.currentTimeMillis() - this.urlHandleTime;
                return;
            case 3:
                this.urlLoadTime = System.currentTimeMillis() - this.urlLoadTime;
                return;
            case 4:
                this.allTime = System.currentTimeMillis() - this.allTime;
                return;
            default:
                c.a(c, "timeEnd", "type is not right");
                a.b();
                return;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Point4ShowH5{analysisTime=");
        stringBuilder.append(this.analysisTime);
        stringBuilder.append(", taokeTime=");
        stringBuilder.append(this.taokeTime);
        stringBuilder.append(", urlHandleTime=");
        stringBuilder.append(this.urlHandleTime);
        stringBuilder.append(", urlLoadTime=");
        stringBuilder.append(this.urlLoadTime);
        stringBuilder.append(", allTime=");
        stringBuilder.append(this.allTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
