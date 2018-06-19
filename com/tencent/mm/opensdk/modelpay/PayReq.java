package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.opensdk.a.a;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class PayReq extends BaseReq {
    private static final int EXTDATA_MAX_LENGTH = 1024;
    private static final String TAG = "MicroMsg.PaySdk.PayReq";
    public String appId;
    public String extData;
    public String nonceStr;
    public Options options;
    public String packageValue;
    public String partnerId;
    public String prepayId;
    public String sign;
    public String signType;
    public String timeStamp;

    public static class Options {
        public static final int INVALID_FLAGS = -1;
        public String callbackClassName;
        public int callbackFlags = -1;

        public void fromBundle(Bundle bundle) {
            this.callbackClassName = a.b(bundle, "_wxapi_payoptions_callback_classname");
            this.callbackFlags = a.a(bundle, "_wxapi_payoptions_callback_flags");
        }

        public void toBundle(Bundle bundle) {
            bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
            bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean checkArgs() {
        /*
        r3 = this;
        r0 = r3.appId;
        r1 = 0;
        if (r0 == 0) goto L_0x006d;
    L_0x0005:
        r0 = r3.appId;
        r0 = r0.length();
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = r3.partnerId;
        if (r0 == 0) goto L_0x006d;
    L_0x0012:
        r0 = r3.partnerId;
        r0 = r0.length();
        if (r0 != 0) goto L_0x001b;
    L_0x001a:
        return r1;
    L_0x001b:
        r0 = r3.prepayId;
        if (r0 == 0) goto L_0x006d;
    L_0x001f:
        r0 = r3.prepayId;
        r0 = r0.length();
        if (r0 != 0) goto L_0x0028;
    L_0x0027:
        return r1;
    L_0x0028:
        r0 = r3.nonceStr;
        if (r0 == 0) goto L_0x006d;
    L_0x002c:
        r0 = r3.nonceStr;
        r0 = r0.length();
        if (r0 != 0) goto L_0x0035;
    L_0x0034:
        return r1;
    L_0x0035:
        r0 = r3.timeStamp;
        if (r0 == 0) goto L_0x006d;
    L_0x0039:
        r0 = r3.timeStamp;
        r0 = r0.length();
        if (r0 != 0) goto L_0x0042;
    L_0x0041:
        return r1;
    L_0x0042:
        r0 = r3.packageValue;
        if (r0 == 0) goto L_0x006d;
    L_0x0046:
        r0 = r3.packageValue;
        r0 = r0.length();
        if (r0 != 0) goto L_0x004f;
    L_0x004e:
        return r1;
    L_0x004f:
        r0 = r3.sign;
        if (r0 == 0) goto L_0x006d;
    L_0x0053:
        r0 = r3.sign;
        r0 = r0.length();
        if (r0 != 0) goto L_0x005c;
    L_0x005b:
        return r1;
    L_0x005c:
        r0 = r3.extData;
        if (r0 == 0) goto L_0x006b;
    L_0x0060:
        r0 = r3.extData;
        r0 = r0.length();
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r0 <= r2) goto L_0x006b;
    L_0x006a:
        return r1;
    L_0x006b:
        r0 = 1;
        return r0;
    L_0x006d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.modelpay.PayReq.checkArgs():boolean");
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.appId = a.b(bundle, "_wxapi_payreq_appid");
        this.partnerId = a.b(bundle, "_wxapi_payreq_partnerid");
        this.prepayId = a.b(bundle, "_wxapi_payreq_prepayid");
        this.nonceStr = a.b(bundle, "_wxapi_payreq_noncestr");
        this.timeStamp = a.b(bundle, "_wxapi_payreq_timestamp");
        this.packageValue = a.b(bundle, "_wxapi_payreq_packagevalue");
        this.sign = a.b(bundle, "_wxapi_payreq_sign");
        this.extData = a.b(bundle, "_wxapi_payreq_extdata");
        this.signType = a.b(bundle, "_wxapi_payreq_sign_type");
        this.options = new Options();
        this.options.fromBundle(bundle);
    }

    public int getType() {
        return 5;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_payreq_appid", this.appId);
        bundle.putString("_wxapi_payreq_partnerid", this.partnerId);
        bundle.putString("_wxapi_payreq_prepayid", this.prepayId);
        bundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
        bundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
        bundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
        bundle.putString("_wxapi_payreq_sign", this.sign);
        bundle.putString("_wxapi_payreq_extdata", this.extData);
        bundle.putString("_wxapi_payreq_sign_type", this.signType);
        if (this.options != null) {
            this.options.toBundle(bundle);
        }
    }
}
