package com.alibaba.baichuan.android.trade.adapter.ut.performance;

import com.alibaba.baichuan.android.trade.adapter.ut.performance.dimension.Dimension;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.io.Serializable;

public abstract class PerformancePoint implements Serializable {
    protected long a = 1000000000;
    protected Dimension b;

    PerformancePoint() {
    }

    public static DimensionSet getDimensionSet() {
        return Dimension.getDimensionSet();
    }

    public boolean checkData() {
        return true;
    }

    public boolean checkTime(long j) {
        if (j >= 0) {
            if (j <= this.a) {
                return true;
            }
        }
        return false;
    }

    public DimensionValueSet getDimensionValues() {
        initDimension();
        return this.b.getDimensionValues();
    }

    public abstract MeasureValueSet getMeasureValues();

    public abstract String getMonitorPoint();

    public void initDimension() {
        if (this.b == null) {
            this.b = new Dimension();
        }
    }

    public abstract void timeBegin(String str);

    public abstract void timeEnd(String str);

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PerformancePoint{dimension=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
