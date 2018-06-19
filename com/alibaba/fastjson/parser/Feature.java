package com.alibaba.fastjson.parser;

public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray;
    
    public final int mask;

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i, Feature feature) {
        return (i & feature.mask) != 0;
    }

    public static int config(int i, Feature feature, boolean z) {
        if (z) {
            return i | feature.mask;
        }
        return i & (feature.mask ^ -1);
    }

    public static int of(Feature[] featureArr) {
        int i = 0;
        if (featureArr == null) {
            return 0;
        }
        int i2 = 0;
        while (i < featureArr.length) {
            i2 |= featureArr[i].mask;
            i++;
        }
        return i2;
    }
}
