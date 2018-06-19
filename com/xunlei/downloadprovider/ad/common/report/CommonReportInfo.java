package com.xunlei.downloadprovider.ad.common.report;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CommonReportInfo extends f implements Serializable {
    private String adType;
    private String advId;
    private boolean isDefaultAd = false;
    private String loadStyle;
    private String material;
    private String positionId;
    private String searchId;
    private String styleId;

    public String getPositionId() {
        return this.positionId;
    }

    public void setPositionId(String str) {
        this.positionId = str;
    }

    public String getStyleId() {
        return this.styleId;
    }

    public void setStyleId(String str) {
        this.styleId = str;
    }

    public String getSearchId() {
        return this.searchId;
    }

    public void setSearchId(String str) {
        this.searchId = str;
    }

    public String getAdvId() {
        return this.advId;
    }

    public void setAdvId(String str) {
        this.advId = str;
    }

    public String getAdType() {
        return this.adType;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String str) {
        this.material = str;
    }

    public boolean isDefaultAd() {
        return this.isDefaultAd;
    }

    public void setDefaultAd(boolean z) {
        this.isDefaultAd = z;
    }

    public String getLoadStyle() {
        return this.loadStyle;
    }

    public void setLoadStyle(String str) {
        this.loadStyle = str;
    }

    public Map<String, String> getReportParams() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("position_id", getPositionId());
        hashMap.put("styleid", getStyleId());
        hashMap.put("searchid", getSearchId());
        hashMap.put("ad_type", getAdType());
        hashMap.put("advid", getAdvId());
        hashMap.put("material", getMaterial());
        hashMap.put("is_default", this.isDefaultAd ? "1" : "0");
        if (!TextUtils.isEmpty(getLoadStyle())) {
            hashMap.put("load_style", getLoadStyle());
        }
        if (getExtras() != null) {
            hashMap.putAll(getExtras());
        }
        return hashMap;
    }
}
