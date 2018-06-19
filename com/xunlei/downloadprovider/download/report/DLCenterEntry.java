package com.xunlei.downloadprovider.download.report;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum DLCenterEntry {
    home("home"),
    browser("browser"),
    personal_center("personal_center"),
    personal_my_collection("personal_my_collection"),
    search("search"),
    icon("icon"),
    download_push("download_push"),
    other(DispatchConstants.OTHER),
    sniff("sniff"),
    dl_center("dl_center"),
    file_bt("file_bt"),
    file_bt_in("file_bt_in");
    
    private static final Map<String, DLCenterEntry> sValuesMap = null;
    private String value;

    static {
        Map hashMap = new HashMap();
        DLCenterEntry[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            DLCenterEntry dLCenterEntry = values[i];
            hashMap.put(dLCenterEntry.value, dLCenterEntry);
            i++;
        }
        sValuesMap = Collections.unmodifiableMap(hashMap);
    }

    private DLCenterEntry(String str) {
        this.value = str;
    }

    public static DLCenterEntry enumValueOf(String str) {
        return sValuesMap.containsKey(str) ? (DLCenterEntry) sValuesMap.get(str) : null;
    }

    public final String toString() {
        return getValue();
    }

    public final String getValue() {
        return this.value;
    }
}
