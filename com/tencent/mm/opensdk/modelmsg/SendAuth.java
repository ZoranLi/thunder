package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class SendAuth {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
        public String scope;
        public String state;

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean checkArgs() {
            /*
            r3 = this;
            r0 = r3.scope;
            r1 = 0;
            if (r0 == 0) goto L_0x0027;
        L_0x0005:
            r0 = r3.scope;
            r0 = r0.length();
            if (r0 == 0) goto L_0x0027;
        L_0x000d:
            r0 = r3.scope;
            r0 = r0.length();
            r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            if (r0 <= r2) goto L_0x0018;
        L_0x0017:
            return r1;
        L_0x0018:
            r0 = r3.state;
            if (r0 == 0) goto L_0x0025;
        L_0x001c:
            r0 = r3.state;
            r0 = r0.length();
            if (r0 <= r2) goto L_0x0025;
        L_0x0024:
            return r1;
        L_0x0025:
            r0 = 1;
            return r0;
        L_0x0027:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.modelmsg.SendAuth.Req.checkArgs():boolean");
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.scope = bundle.getString("_wxapi_sendauth_req_scope");
            this.state = bundle.getString("_wxapi_sendauth_req_state");
        }

        public int getType() {
            return 1;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_req_scope", this.scope);
            bundle.putString("_wxapi_sendauth_req_state", this.state);
        }
    }

    public static class Resp extends BaseResp {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
        public String code;
        public String country;
        public String lang;
        public String state;
        public String url;

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            return this.state == null || this.state.length() <= 1024;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.code = bundle.getString("_wxapi_sendauth_resp_token");
            this.state = bundle.getString("_wxapi_sendauth_resp_state");
            this.url = bundle.getString("_wxapi_sendauth_resp_url");
            this.lang = bundle.getString("_wxapi_sendauth_resp_lang");
            this.country = bundle.getString("_wxapi_sendauth_resp_country");
        }

        public int getType() {
            return 1;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_resp_token", this.code);
            bundle.putString("_wxapi_sendauth_resp_state", this.state);
            bundle.putString("_wxapi_sendauth_resp_url", this.url);
            bundle.putString("_wxapi_sendauth_resp_lang", this.lang);
            bundle.putString("_wxapi_sendauth_resp_country", this.country);
        }
    }

    private SendAuth() {
    }
}
