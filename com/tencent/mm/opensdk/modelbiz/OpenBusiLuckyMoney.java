package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class OpenBusiLuckyMoney {

    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String appId;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String timeStamp;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean checkArgs() {
            /*
            r2 = this;
            r0 = r2.appId;
            r1 = 0;
            if (r0 == 0) goto L_0x0044;
        L_0x0005:
            r0 = r2.appId;
            r0 = r0.length();
            if (r0 > 0) goto L_0x000e;
        L_0x000d:
            return r1;
        L_0x000e:
            r0 = r2.timeStamp;
            if (r0 == 0) goto L_0x0044;
        L_0x0012:
            r0 = r2.timeStamp;
            r0 = r0.length();
            if (r0 > 0) goto L_0x001b;
        L_0x001a:
            return r1;
        L_0x001b:
            r0 = r2.nonceStr;
            if (r0 == 0) goto L_0x0044;
        L_0x001f:
            r0 = r2.nonceStr;
            r0 = r0.length();
            if (r0 > 0) goto L_0x0028;
        L_0x0027:
            return r1;
        L_0x0028:
            r0 = r2.signType;
            if (r0 == 0) goto L_0x0044;
        L_0x002c:
            r0 = r2.signType;
            r0 = r0.length();
            if (r0 > 0) goto L_0x0035;
        L_0x0034:
            return r1;
        L_0x0035:
            r0 = r2.signature;
            if (r0 == 0) goto L_0x0044;
        L_0x0039:
            r0 = r2.signature;
            r0 = r0.length();
            if (r0 > 0) goto L_0x0042;
        L_0x0041:
            return r1;
        L_0x0042:
            r0 = 1;
            return r0;
        L_0x0044:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.modelbiz.OpenBusiLuckyMoney.Req.checkArgs():boolean");
        }

        public int getType() {
            return 13;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
            bundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
            bundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
            bundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
            bundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
            bundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
        }
    }
}
