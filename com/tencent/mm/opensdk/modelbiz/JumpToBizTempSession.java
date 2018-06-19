package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public final class JumpToBizTempSession {
    public static final int SHOW_CHAT = 1;
    public static final int SHOW_MENU = 0;

    public static class Req extends BaseReq {
        private static final int MAX_SESSION_FROM_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizTempSession.Req";
        public String sessionFrom;
        public int showType;
        public String toUserName;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean checkArgs() {
            /*
            r3 = this;
            r0 = r3.toUserName;
            r1 = 0;
            if (r0 == 0) goto L_0x001f;
        L_0x0005:
            r0 = r3.toUserName;
            r0 = r0.length();
            if (r0 > 0) goto L_0x000e;
        L_0x000d:
            return r1;
        L_0x000e:
            r0 = r3.sessionFrom;
            if (r0 == 0) goto L_0x001f;
        L_0x0012:
            r0 = r3.sessionFrom;
            r0 = r0.length();
            r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            if (r0 <= r2) goto L_0x001d;
        L_0x001c:
            return r1;
        L_0x001d:
            r0 = 1;
            return r0;
        L_0x001f:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.modelbiz.JumpToBizTempSession.Req.checkArgs():boolean");
        }

        public int getType() {
            return 10;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_session_from", this.sessionFrom);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_show_type", this.showType);
        }
    }
}
