package com.alibaba.baichuan.android.trade.adapter.ut.performance.dimension;

import com.alibaba.baichuan.android.trade.utils.c;
import com.alibaba.baichuan.android.trade.utils.g.a;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;

public class PageDimension extends Dimension {
    private static final String e = "PageDimension";
    public String pageType;
    public String taokeType = "0";

    public static DimensionSet getDimensionSet() {
        DimensionSet dimensionSet = Dimension.getDimensionSet();
        if (dimensionSet != null) {
            dimensionSet.a("pageType");
            dimensionSet.a("taokeType");
        }
        return dimensionSet;
    }

    public DimensionValueSet getDimensionValues() {
        if (this.pageType != null) {
            if (this.taokeType != null) {
                DimensionValueSet dimensionValues = super.getDimensionValues();
                if (dimensionValues != null) {
                    dimensionValues.a("pageType", this.pageType);
                    dimensionValues.a("taokeType", this.taokeType);
                }
                return dimensionValues;
            }
        }
        c.a(e, "getDimensionValues", "pageType/taokeType is null");
        a.b();
        return null;
    }
}
