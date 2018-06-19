package com.xunlei.downloadprovider.ad.common.report;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ExtrasReportInfo */
public class f {
    private Map<String, String> mExtras = new HashMap();

    public Map<String, String> getExtras() {
        return this.mExtras;
    }

    public void setExtras(Map<String, String> map) {
        this.mExtras.clear();
        putExtras(map);
    }

    public void putExtras(Map<String, String> map) {
        if (map != null) {
            this.mExtras.putAll(map);
        }
    }

    public void putExtra(String str, String str2) {
        this.mExtras.put(str, str2);
    }
}
