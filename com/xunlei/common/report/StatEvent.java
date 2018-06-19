package com.xunlei.common.report;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class StatEvent implements Serializable {
    private static final long serialVersionUID = 0;
    public final String mEventId;
    protected final HashMap<String, String> mExtraData = new HashMap();
    public String mReserve1 = null;
    public String mReserve2 = null;

    public StatEvent(String str) {
        this.mEventId = str;
    }

    public static StatEvent build(String str) {
        return new StatEvent(str);
    }

    public final StatEvent setReserve1(String str) {
        this.mReserve1 = str;
        return this;
    }

    public final StatEvent setReserve2(String str) {
        this.mReserve2 = str;
        return this;
    }

    public final HashMap<String, String> getExtraData() {
        return this.mExtraData;
    }

    public final StatEvent add(String str, int i) {
        return addString(str, String.valueOf(i));
    }

    public final StatEvent add(String str, long j) {
        return addString(str, String.valueOf(j));
    }

    public final StatEvent add(String str, boolean z) {
        return addString(str, String.valueOf(z));
    }

    public final StatEvent add(String str, String str2) {
        return addString(str, str2);
    }

    public final StatEvent addString(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = this.mExtraData;
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put(str, str2);
        }
        return this;
    }

    public final StatEvent addInt(String str, int i) {
        return addString(str, String.valueOf(i));
    }

    public final StatEvent addLong(String str, long j) {
        return addString(str, String.valueOf(j));
    }

    public final StatEvent addBool(String str, boolean z) {
        return addString(str, String.valueOf(z));
    }

    public final StatEvent addAll(Map<String, String> map) {
        if (map != null) {
            this.mExtraData.putAll(map);
        }
        return this;
    }

    public final boolean hasExtraData() {
        return this.mExtraData.size() != 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatEvent{mEventId='");
        stringBuilder.append(this.mEventId);
        stringBuilder.append('\'');
        stringBuilder.append(", mReserve1='");
        stringBuilder.append(this.mReserve1);
        stringBuilder.append('\'');
        stringBuilder.append(", mExtraData=");
        stringBuilder.append(this.mExtraData);
        stringBuilder.append(", mReserve2='");
        stringBuilder.append(this.mReserve2);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
