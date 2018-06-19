package com.alibaba.fastjson.serializer;

public enum SerializerFeature {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString;
    
    public static final SerializerFeature[] EMPTY = null;
    public final int mask;

    static {
        EMPTY = new SerializerFeature[0];
    }

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i, SerializerFeature serializerFeature) {
        return (i & serializerFeature.mask) != 0;
    }

    public static boolean isEnabled(int i, int i2, SerializerFeature serializerFeature) {
        serializerFeature = serializerFeature.mask;
        if ((i & serializerFeature) == 0) {
            if ((i2 & serializerFeature) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int config(int i, SerializerFeature serializerFeature, boolean z) {
        if (z) {
            return i | serializerFeature.mask;
        }
        return i & (serializerFeature.mask ^ -1);
    }

    public static int of(SerializerFeature[] serializerFeatureArr) {
        int i = 0;
        if (serializerFeatureArr == null) {
            return 0;
        }
        int i2 = 0;
        while (i < serializerFeatureArr.length) {
            i2 |= serializerFeatureArr[i].mask;
            i++;
        }
        return i2;
    }
}
