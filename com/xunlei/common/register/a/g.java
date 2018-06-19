package com.xunlei.common.register.a;

import com.umeng.socialize.bean.HandlerRequestCode;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.register.XLRegisterListener;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.XLStatUtil;
import com.xunlei.common.stat.base.XLStatCommandID;

/* compiled from: XLStatRegisterListener */
public final class g implements XLRegisterListener {
    private XLStatUtil a = null;
    private String b = "unknown-host-ip";

    public final boolean onCheckBind(int i, String str, int i2, int i3) {
        return false;
    }

    public final boolean onCheckNeedVerifyCode(int i, String str, int i2, int i3, String str2) {
        return false;
    }

    public final boolean onCheckPassWordStrength(int i, String str, int i2, int i3) {
        return false;
    }

    private void a() {
        if ("unknown-host-ip".equals(this.b)) {
            new Thread(new Runnable(this) {
                private /* synthetic */ g a;

                {
                    this.a = r1;
                }

                public final void run() {
                    this.a.b = XLUtilTools.getHostAddress("zhuce.xunlei.com");
                }
            }).start();
        }
    }

    public g(XLStatUtil xLStatUtil) {
        this.a = xLStatUtil;
        a();
    }

    public final boolean onPhoneRegister(int i, String str, int i2, long j, String str2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_FAST_LOGIN;
        str.mSvrDomain = "zhuce.xunlei.com";
        str.mSvrIp = this.b;
        str.mUserId = j;
        str.mErrorCode = i;
        str.mRespTime = 0.0d;
        str.mRetryNum = 0;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.a.report(i2, str);
        i2 = new XLStatPack();
        i2.mCommandID = XLStatCommandID.XLCID_PHONE_CODE_VERTRELT;
        i2.mSvrDomain = "zhuce.xunlei.com";
        i2.mSvrIp = this.b;
        i2.mUserId = j;
        i2.mErrorCode = 0;
        i2.mRespTime = 0.0d;
        i2.mRetryNum = 0;
        i2.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.a.reportSpecialStat(2, i2);
        a();
        return false;
    }

    public final boolean onEmailRegister(int i, String str, int i2, long j, String str2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_MAIL_REG;
        str.mSvrDomain = "zhuce.xunlei.com";
        str.mSvrIp = this.b;
        str.mUserId = j;
        str.mErrorCode = i;
        str.mRespTime = 0;
        str.mRetryNum = 0;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.a.report(i2, str);
        a();
        return false;
    }

    public final boolean onSendMessage(int i, String str, int i2, int i3, String str2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_LOGIN_PHONE_CODE;
        if (i3 == 1) {
            str.mCommandID = XLStatCommandID.XLCID_REG_PHONE_CODE;
        }
        str.mSvrDomain = "zhuce.xunlei.com";
        str.mSvrIp = this.b;
        str.mErrorCode = i;
        str.mRespTime = 0.0d;
        str.mRetryNum = 0;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.a.report(i2, str);
        a();
        return false;
    }

    public final boolean onGetVerifyCode(int i, String str, int i2, byte[] bArr, String str2, String str3, String str4, String str5) {
        str = new XLStatPack();
        str.mCommandID = 200003;
        str.mSvrDomain = "zhuce.xunlei.com";
        str.mSvrIp = this.b;
        str.mErrorCode = i;
        str.mRespTime = null;
        str.mRetryNum = 0;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.a.report(i2, str);
        a();
        return false;
    }

    public final boolean onPhoneRegAndLogin(int i, String str, int i2, long j, String str2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_MOB_REG;
        str.mSvrDomain = "zhuce.xunlei.com";
        str.mSvrIp = this.b;
        str.mUserId = j;
        str.mErrorCode = i;
        str.mRespTime = 0.0d;
        str.mRetryNum = 0;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.a.report(i2, str);
        i2 = new XLStatPack();
        i2.mCommandID = XLStatCommandID.XLCID_PHONE_CODE_VERTRELT;
        i2.mSvrDomain = "zhuce.xunlei.com";
        i2.mSvrIp = this.b;
        i2.mUserId = j;
        i2.mErrorCode = 0;
        i2.mRespTime = 0.0d;
        i2.mRetryNum = 0;
        i2.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.a.reportSpecialStat(1, i2);
        a();
        return false;
    }

    public final boolean onOldUserNameRegister(int i, String str, int i2, long j, String str2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_NAME_REG;
        str.mSvrDomain = "zhuce.xunlei.com";
        str.mSvrIp = this.b;
        str.mUserId = j;
        str.mErrorCode = i;
        str.mRespTime = 0;
        str.mRetryNum = 0;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        this.a.report(i2, str);
        a();
        return false;
    }

    public final boolean onMobileVerifyCodeAccept(String str, int i) {
        XLStatUtil.mAcceptPhoneCode = true;
        XLStatPack xLStatPack = new XLStatPack();
        xLStatPack.mCommandID = XLStatCommandID.XLCID_PHONE_CODE_REQTACPT;
        xLStatPack.mSvrDomain = "zhuce.xunlei.com";
        xLStatPack.mSvrIp = this.b;
        xLStatPack.mErrorCode = 0;
        xLStatPack.mRespTime = 0.0d;
        xLStatPack.mRetryNum = 0;
        xLStatPack.mFlowId = System.currentTimeMillis();
        xLStatPack.mFinal = 1;
        this.a.reportSpecialStat(i, xLStatPack);
        this.a.registerSpecialStatReq(HandlerRequestCode.WX_REQUEST_CODE, i);
        a();
        return false;
    }
}
