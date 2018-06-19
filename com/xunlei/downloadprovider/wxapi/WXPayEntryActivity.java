package com.xunlei.downloadprovider.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xunlei.common.base.XLLog;
import com.xunlei.downloadprovider.member.payment.external.l;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI a = null;

    public void onReq(BaseReq baseReq) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = WXAPIFactory.createWXAPI(this, "");
        this.a.handleIntent(getIntent(), this);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a.handleIntent(intent, this);
    }

    public void onResp(BaseResp baseResp) {
        StringBuilder stringBuilder = new StringBuilder("onPayFinish, errCode = ");
        stringBuilder.append(baseResp.errCode);
        XLLog.v("MicroMsg.SDKSample.WXPayEntryActivity", stringBuilder.toString());
        if (baseResp.getType() == 5) {
            int intValue = Integer.valueOf(((PayResp) baseResp).extData).intValue();
            l a = l.a();
            a.a.acceptWxPayResult(intValue, baseResp.errCode);
        }
        finish();
    }
}
