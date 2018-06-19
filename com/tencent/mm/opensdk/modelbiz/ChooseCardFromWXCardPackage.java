package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class ChooseCardFromWXCardPackage {
    private static final String TAG = "MicroMsg.ChooseCardFromWXCardPackage";

    public static class Req extends BaseReq {
        public String appId;
        public String canMultiSelect;
        public String cardId;
        public String cardSign;
        public String cardType;
        public String locationId;
        public String nonceStr;
        public String signType;
        public String timeStamp;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean checkArgs() {
            /*
            r2 = this;
            r0 = r2.appId;
            r1 = 0;
            if (r0 == 0) goto L_0x002a;
        L_0x0005:
            r0 = r2.appId;
            r0 = r0.length();
            if (r0 > 0) goto L_0x000e;
        L_0x000d:
            return r1;
        L_0x000e:
            r0 = r2.signType;
            if (r0 == 0) goto L_0x002a;
        L_0x0012:
            r0 = r2.signType;
            r0 = r0.length();
            if (r0 > 0) goto L_0x001b;
        L_0x001a:
            return r1;
        L_0x001b:
            r0 = r2.cardSign;
            if (r0 == 0) goto L_0x002a;
        L_0x001f:
            r0 = r2.cardSign;
            r0 = r0.length();
            if (r0 > 0) goto L_0x0028;
        L_0x0027:
            return r1;
        L_0x0028:
            r0 = 1;
            return r0;
        L_0x002a:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Req.checkArgs():boolean");
        }

        public int getType() {
            return 16;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
            bundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
            bundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
            bundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
            bundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
            bundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
        }
    }

    public static class Resp extends BaseResp {
        public String cardItemList;

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            if (this.cardItemList != null) {
                if (this.cardItemList.length() != 0) {
                    return true;
                }
            }
            return false;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            String string = bundle.getString("_wxapi_choose_card_from_wx_card_list");
            if (string != null && string.length() > 0) {
                this.cardItemList = string;
            }
        }

        public int getType() {
            return 16;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
        }
    }
}
