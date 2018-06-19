package com.xunlei.common.new_ptl.pay.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.encrypt.URLCoder;
import com.xunlei.common.new_ptl.pay.XLPayType;
import com.xunlei.common.new_ptl.pay.a.c;
import com.xunlei.common.new_ptl.pay.a.e;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.param.XLAliPayContractParam;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLPriceParam;
import com.xunlei.common.new_ptl.pay.param.XLWxContractParam;
import com.xunlei.common.new_ptl.pay.param.XLWxPayParam;

/* compiled from: XLMemPayRequest */
public final class a extends e {
    private XLPayParam a = null;

    public a(XLPayParam xLPayParam) {
        this.a = xLPayParam;
    }

    public final String a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.a != null) {
            stringBuffer.append("version=v2.1&sessionid=");
            stringBuffer.append(this.a.getSessionId());
            stringBuffer.append("&userid=");
            stringBuffer.append(this.a.getUserId());
            stringBuffer.append("&");
            if (i == XLPayType.XL_WX_PAY) {
                XLWxPayParam xLWxPayParam = (XLWxPayParam) this.a;
                stringBuffer.append("other1=");
                stringBuffer.append(xLWxPayParam.getWxAppId());
                stringBuffer.append("&");
            }
            stringBuffer.append("paytype=");
            stringBuffer.append(XLPayType.getPayTypeString(i));
            stringBuffer.append("&num=");
            stringBuffer.append(this.a.getNum());
            stringBuffer.append("&bizno=");
            stringBuffer.append(this.a.getBizNo());
            stringBuffer.append("&cash=");
            stringBuffer.append(this.a.getCash());
            stringBuffer.append("&");
            stringBuffer.append("peerId=android&mref=");
            stringBuffer.append(this.a.getSource());
            stringBuffer.append("&referfrom=");
            stringBuffer.append(this.a.getReferFrom());
            stringBuffer.append("&aidfrom=");
            stringBuffer.append(this.a.getAidFrom());
            stringBuffer.append("&");
            stringBuffer.append("xAppName=");
            i = new StringBuilder("ANDROID-");
            i.append(i.a().j());
            stringBuffer.append(i.toString());
            stringBuffer.append("&xSdkVersion=");
            stringBuffer.append(i.a().l());
            stringBuffer.append("&xDeviceId=");
            stringBuffer.append(XLDeviceGen.getInstance().getDeviceId());
            stringBuffer.append("&xDeviceName=");
            stringBuffer.append(c.c());
            stringBuffer.append("&xDeviceModel=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&xOSVersion=");
            stringBuffer.append(VERSION.RELEASE);
            stringBuffer.append("&xClientVersion=");
            stringBuffer.append(i.a().g());
            stringBuffer.append("&xPlatformVersion=10&xHaobaoId=");
            stringBuffer.append(i.a().h());
            stringBuffer.append("&");
            stringBuffer.append("extorderid=");
            stringBuffer.append(this.a.getUniqueOrderFlag());
            stringBuffer.append("&ext2=");
            stringBuffer.append(this.a.getParamExt());
        }
        return stringBuffer.toString();
    }

    public final String a() {
        XLPriceParam xLPriceParam = (XLPriceParam) this.a;
        StringBuffer stringBuffer = new StringBuffer();
        if (xLPriceParam != null) {
            stringBuffer.append("version=v2.1&sessionid=");
            stringBuffer.append(xLPriceParam.getSessionId());
            stringBuffer.append("&userid=");
            stringBuffer.append(xLPriceParam.getUserId());
            stringBuffer.append("&num=");
            stringBuffer.append(xLPriceParam.getNum());
            stringBuffer.append("&bizno=");
            stringBuffer.append(xLPriceParam.getBizNo());
            stringBuffer.append("&peerId=android&ext2=");
            stringBuffer.append(xLPriceParam.getParamExt());
        }
        return stringBuffer.toString();
    }

    public final String b(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.a != null) {
            stringBuffer.append("version=v2.1&sessionid=");
            stringBuffer.append(this.a.getSessionId());
            stringBuffer.append("&userid=");
            stringBuffer.append(this.a.getUserId());
            stringBuffer.append("&");
            if (i == XLPayType.XL_WX_CONTRACT) {
                XLWxContractParam xLWxContractParam = (XLWxContractParam) this.a;
                stringBuffer.append("other1=");
                stringBuffer.append(xLWxContractParam.getWxAppId());
                stringBuffer.append("&");
            }
            if (i == XLPayType.XL_ALIPAY_CONTRACT) {
                stringBuffer.append("fgUrl=");
                String str = "";
                if (i == XLPayType.XL_ALIPAY_CONTRACT) {
                    XLAliPayContractParam xLAliPayContractParam = (XLAliPayContractParam) this.a;
                    if (!TextUtils.isEmpty(xLAliPayContractParam.mContractResultScheme)) {
                        str = URLCoder.encode(xLAliPayContractParam.getContractResultScheme(), "UTF-8");
                    }
                }
                stringBuffer.append(str);
                stringBuffer.append("&");
            }
            stringBuffer.append("paytype=");
            stringBuffer.append(XLPayType.getPayTypeString(i));
            stringBuffer.append("&num=");
            stringBuffer.append(this.a.getNum());
            stringBuffer.append("&bizno=");
            stringBuffer.append(this.a.getBizNo());
            stringBuffer.append("&cash=");
            stringBuffer.append(this.a.getCash());
            stringBuffer.append("&");
            stringBuffer.append("peerId=android&mref=");
            stringBuffer.append(this.a.getSource());
            stringBuffer.append("&referfrom=");
            stringBuffer.append(this.a.getReferFrom());
            stringBuffer.append("&aidfrom=");
            stringBuffer.append(this.a.getAidFrom());
            stringBuffer.append("&");
            stringBuffer.append("xAppName=");
            i = new StringBuilder("ANDROID-");
            i.append(i.a().j());
            stringBuffer.append(i.toString());
            stringBuffer.append("&xSdkVersion=");
            stringBuffer.append(i.a().l());
            stringBuffer.append("&xDeviceId=");
            stringBuffer.append(XLDeviceGen.getInstance().getDeviceId());
            stringBuffer.append("&xDeviceName=");
            stringBuffer.append(c.c());
            stringBuffer.append("&xDeviceModel=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&xOSVersion=");
            stringBuffer.append(VERSION.RELEASE);
            stringBuffer.append("&xClientVersion=");
            stringBuffer.append(i.a().g());
            stringBuffer.append("&xPlatformVersion=10&xHaobaoId=");
            stringBuffer.append(i.a().h());
            stringBuffer.append("&");
            stringBuffer.append("extorderid=");
            stringBuffer.append(this.a.getUniqueOrderFlag());
            stringBuffer.append("&ext2=");
            stringBuffer.append(this.a.getParamExt());
        }
        return stringBuffer.toString();
    }

    public final String c(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.a != null) {
            stringBuffer.append("version=v2.1&sessionid=");
            stringBuffer.append(this.a.getSessionId());
            stringBuffer.append("&userid=");
            stringBuffer.append(this.a.getUserId());
            stringBuffer.append("&");
            stringBuffer.append("paytype=");
            stringBuffer.append(XLPayType.getPayTypeString(i));
            stringBuffer.append("&bizno=");
            stringBuffer.append(this.a.getBizNo());
            stringBuffer.append("&");
            stringBuffer.append("peerId=android&");
            stringBuffer.append("ext2=");
            stringBuffer.append(this.a.getParamExt());
        }
        return stringBuffer.toString();
    }

    public final String d(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.a != null) {
            stringBuffer.append("version=v2.1&sessionid=");
            stringBuffer.append(this.a.getSessionId());
            stringBuffer.append("&userid=");
            stringBuffer.append(this.a.getUserId());
            stringBuffer.append("&");
            stringBuffer.append("paytype=");
            stringBuffer.append(XLPayType.getPayTypeString(i));
            stringBuffer.append("&bizno=");
            stringBuffer.append(this.a.getBizNo());
            stringBuffer.append("&");
            stringBuffer.append("peerId=android&");
            stringBuffer.append("ext2=");
            stringBuffer.append(this.a.getParamExt());
        }
        return stringBuffer.toString();
    }

    private String e(int i) {
        String str = "";
        if (i != XLPayType.XL_ALIPAY_CONTRACT) {
            return str;
        }
        XLAliPayContractParam xLAliPayContractParam = (XLAliPayContractParam) this.a;
        return !TextUtils.isEmpty(xLAliPayContractParam.mContractResultScheme) ? URLCoder.encode(xLAliPayContractParam.getContractResultScheme(), "UTF-8") : str;
    }
}
