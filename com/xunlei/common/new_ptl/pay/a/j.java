package com.xunlei.common.new_ptl.pay.a;

import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.pay.XLAllContractResp;
import com.xunlei.common.new_ptl.pay.XLContractResp;
import com.xunlei.common.new_ptl.pay.XLContractor$XLContractOperate;
import com.xunlei.common.new_ptl.pay.XLOnPayListener;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.XLStatUtil;
import com.xunlei.common.stat.base.XLStatCommandID;

/* compiled from: XLStatPayListener */
public final class j implements XLOnPayListener {
    private static final String a = "pay.xunlei.com";
    private XLStatUtil b = null;
    private String c = "unknown-host-ip";

    public final void onQueryContract(int i, String str, Object obj, int i2, XLAllContractResp xLAllContractResp) {
    }

    private void a() {
        if ("unknown-host-ip".equals(this.c)) {
            new Thread(new Runnable(this) {
                private /* synthetic */ j a;

                {
                    this.a = r1;
                }

                public final void run() {
                    this.a.c = XLUtilTools.getHostAddress(j.a);
                }
            }).start();
        }
    }

    public j(XLStatUtil xLStatUtil) {
        this.b = xLStatUtil;
    }

    public final void onWxPay(int i, String str, Object obj, String str2, int i2) {
        str = new XLStatPack();
        str.mCommandID = 300000;
        str.mErrorCode = i;
        str.mSvrDomain = a;
        str.mSvrIp = this.c;
        str.mRespTime = null;
        str.mRetryNum = 0;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.b.report(i2, str);
        a();
    }

    public final void onAliPay(int i, String str, Object obj, String str2, int i2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_PAY_ALI;
        str.mErrorCode = i;
        str.mSvrDomain = a;
        str.mSvrIp = this.c;
        str.mRespTime = null;
        str.mRetryNum = 0;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.b.report(i2, str);
        a();
    }

    public final void onGetPrice(int i, String str, Object obj, int i2, String str2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_PAY_PRICE;
        str.mErrorCode = i;
        str.mSvrDomain = a;
        str.mSvrIp = this.c;
        str.mRespTime = 0.0d;
        str.mRetryNum = 1;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.b.report(i2, str);
        a();
    }

    private void a(int i, int i2, XLContractResp xLContractResp) {
        XLStatPack xLStatPack = new XLStatPack();
        xLStatPack.mErrorCode = i;
        xLStatPack.mSvrDomain = a;
        xLStatPack.mSvrIp = this.c;
        xLStatPack.mRespTime = 0.0d;
        xLStatPack.mRetryNum = 0;
        xLStatPack.mFlowId = System.currentTimeMillis();
        xLStatPack.mFinal = 1;
        switch (xLContractResp.mOperateType) {
            case 8192:
                if (xLContractResp.mContractType != 4096) {
                    xLStatPack.mCommandID = XLStatCommandID.XLCID_WXCT_CONTRACT;
                    break;
                } else {
                    xLStatPack.mCommandID = XLStatCommandID.XLCID_ALICT_CONTRACT;
                    break;
                }
            case XLContractor$XLContractOperate.XL_OPERATE_QUERY /*8193*/:
                if (xLContractResp.mContractType != 4096) {
                    xLStatPack.mCommandID = XLStatCommandID.XLCID_WXCT_QUERY;
                    break;
                } else {
                    xLStatPack.mCommandID = XLStatCommandID.XLCID_ALICT_QUERY;
                    break;
                }
            case 8194:
                if (xLContractResp.mContractType != 4096) {
                    xLStatPack.mCommandID = XLStatCommandID.XLCID_WXCT_DISCONTRACT;
                    break;
                } else {
                    xLStatPack.mCommandID = XLStatCommandID.XLCID_ALICT_DISCONTRACT;
                    break;
                }
            default:
                break;
        }
        this.b.report(i2, xLStatPack);
        a();
    }

    public final void onContractOperate(int i, String str, Object obj, int i2, XLContractResp xLContractResp) {
        str = new XLStatPack();
        str.mErrorCode = i;
        str.mSvrDomain = a;
        str.mSvrIp = this.c;
        str.mRespTime = 0.0d;
        str.mRetryNum = 0;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        switch (xLContractResp.mOperateType) {
            case 8192:
                if (xLContractResp.mContractType != 4096) {
                    str.mCommandID = XLStatCommandID.XLCID_WXCT_CONTRACT;
                    break;
                } else {
                    str.mCommandID = XLStatCommandID.XLCID_ALICT_CONTRACT;
                    break;
                }
            case XLContractor$XLContractOperate.XL_OPERATE_QUERY /*8193*/:
                if (xLContractResp.mContractType != 4096) {
                    str.mCommandID = XLStatCommandID.XLCID_WXCT_QUERY;
                    break;
                } else {
                    str.mCommandID = XLStatCommandID.XLCID_ALICT_QUERY;
                    break;
                }
            case 8194:
                if (xLContractResp.mContractType != 4096) {
                    str.mCommandID = XLStatCommandID.XLCID_WXCT_DISCONTRACT;
                    break;
                } else {
                    str.mCommandID = XLStatCommandID.XLCID_ALICT_DISCONTRACT;
                    break;
                }
            default:
                break;
        }
        this.b.report(i2, str);
        a();
    }
}
