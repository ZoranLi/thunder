package com.xunlei.downloadprovider.wxapi;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.umeng.socialize.weixin.view.WXCallbackActivity;

public class WXEntryActivity extends WXCallbackActivity implements IWXAPIEventHandler {
    private IWXAPI a = null;
    private String b = "";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void onResp(com.tencent.mm.opensdk.modelbase.BaseResp r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r8.transaction;
        r0 = android.text.TextUtils.isEmpty(r0);
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0054;
    L_0x000a:
        r0 = "xl_sdk_get_access_code#";
        r3 = r8.transaction;
        r3 = r3.indexOf(r0);
        r4 = -1;
        if (r3 == r4) goto L_0x0049;
    L_0x0015:
        r3 = "";
        r4 = 16781282; // 0x1000fe2 float:2.3521282E-38 double:8.291055E-317;
        r5 = r8.transaction;
        r0 = r0.length();
        r0 = r5.substring(r0);
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x002d }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x002d }
        goto L_0x002e;
    L_0x002d:
        r0 = r2;
    L_0x002e:
        r5 = r8.errCode;
        if (r5 != 0) goto L_0x0038;
    L_0x0032:
        r3 = r8;
        r3 = (com.tencent.mm.opensdk.modelmsg.SendAuth.Resp) r3;
        r3 = r3.code;
        goto L_0x0039;
    L_0x0038:
        r2 = r4;
    L_0x0039:
        r4 = r8.errCode;
        r5 = -2;
        if (r4 != r5) goto L_0x0041;
    L_0x003e:
        r2 = 16781283; // 0x1000fe3 float:2.3521285E-38 double:8.2910554E-317;
    L_0x0041:
        r4 = com.xunlei.common.new_ptl.member.XLUserUtil.getInstance();
        r4.acceptWxCode(r2, r3, r0);
        goto L_0x0055;
    L_0x0049:
        r0 = "xl_sdk_contract";
        r3 = r8.transaction;
        r0 = r3.indexOf(r0);
        if (r0 == r4) goto L_0x0054;
    L_0x0053:
        goto L_0x0055;
    L_0x0054:
        r1 = r2;
    L_0x0055:
        r0 = r8.errCode;
        if (r0 != 0) goto L_0x00a1;
    L_0x0059:
        r0 = com.xunlei.downloadprovider.member.login.a.a.a();
        r0 = r0.a;
        if (r0 == 0) goto L_0x00a1;
    L_0x0061:
        r0 = r8;
        r0 = (com.tencent.mm.opensdk.modelmsg.SendAuth.Resp) r0;
        r2 = com.xunlei.downloadprovider.member.login.a.a.a();
        r3 = r0.code;
        r0 = r0.state;
        r4 = "com.xunlei.downloadprovider.youliao.score";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x00a1;
    L_0x0074:
        r0 = new com.xunlei.common.net.volley.BaseJsonObjectRequest;
        r4 = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%appId&secret=%secret&code=%code&grant_type=authorization_code";
        r5 = "%appId";
        r6 = "wx3e6556568beeebdd";
        r4 = r4.replace(r5, r6);
        r5 = "%secret";
        r6 = "1d0e9649237be9fc548a641487d255d6";
        r4 = r4.replace(r5, r6);
        r5 = "%code";
        r3 = r4.replace(r5, r3);
        r4 = 0;
        r5 = new com.xunlei.downloadprovider.member.login.a.b;
        r5.<init>(r2);
        r6 = new com.xunlei.downloadprovider.member.login.a.c;
        r6.<init>(r2);
        r0.<init>(r3, r4, r5, r6);
        r2 = r2.b;
        r2.a(r0);
    L_0x00a1:
        if (r1 != 0) goto L_0x00ae;
    L_0x00a3:
        r0 = com.xunlei.downloadprovider.member.login.a.a.a();
        r0 = r0.a;
        if (r0 != 0) goto L_0x00ae;
    L_0x00ab:
        super.onResp(r8);
    L_0x00ae:
        r7.finish();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.wxapi.WXEntryActivity.onResp(com.tencent.mm.opensdk.modelbase.BaseResp):void");
    }
}
