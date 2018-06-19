package com.xunlei.common.new_ptl.pay.param;

import android.text.TextUtils;

public class XLWxDisContractParam implements XLPayParam {
    public String mBizNo = "";
    public String mParamExt = "";
    public String mSessionId = "";
    public long mUserId = 0;

    public String getAidFrom() {
        return "";
    }

    public String getCash() {
        return "";
    }

    public int getNum() {
        return 0;
    }

    public String getReferFrom() {
        return "";
    }

    public String getSource() {
        return "";
    }

    public String getUniqueOrderFlag() {
        return "";
    }

    public long getUserId() {
        return this.mUserId;
    }

    public String getSessionId() {
        if (TextUtils.isEmpty(this.mSessionId)) {
            return "";
        }
        return this.mSessionId;
    }

    public String getBizNo() {
        if (TextUtils.isEmpty(this.mBizNo)) {
            return "";
        }
        return this.mBizNo;
    }

    public String getParamExt() {
        if (TextUtils.isEmpty(this.mParamExt)) {
            return "";
        }
        return this.mParamExt;
    }
}
