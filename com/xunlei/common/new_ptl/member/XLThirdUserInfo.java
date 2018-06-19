package com.xunlei.common.new_ptl.member;

import org.json.JSONObject;

public class XLThirdUserInfo {
    private JSONObject mThirdUserInfo = null;

    public XLThirdUserInfo(JSONObject jSONObject) {
        this.mThirdUserInfo = jSONObject;
    }

    public String getStringValue(String str) {
        if (this.mThirdUserInfo == null) {
            return null;
        }
        return this.mThirdUserInfo.optString(str);
    }
}
