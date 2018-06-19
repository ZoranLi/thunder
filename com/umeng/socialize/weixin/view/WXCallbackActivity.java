package com.umeng.socialize.weixin.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMWXHandler;
import com.umeng.socialize.utils.Log;

public abstract class WXCallbackActivity extends Activity implements IWXAPIEventHandler {
    private final String TAG = WXCallbackActivity.class.getSimpleName();
    protected UMWXHandler mWxHandler = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = UMShareAPI.get(getApplicationContext());
        Log.um("WXCallbackActivity");
        this.mWxHandler = (UMWXHandler) bundle.getHandler(SHARE_MEDIA.WEIXIN);
        bundle = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("handleid=");
        stringBuilder.append(this.mWxHandler);
        Log.e(bundle, stringBuilder.toString());
        this.mWxHandler.onCreate(getApplicationContext(), PlatformConfig.getPlatform(SHARE_MEDIA.WEIXIN));
        handleIntent(getIntent());
    }

    protected void handleIntent(Intent intent) {
        this.mWxHandler.getWXApi().handleIntent(intent, this);
    }

    public void onNewIntent(Intent intent) {
        Log.d(this.TAG, "### WXCallbackActivity   onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        this.mWxHandler = (UMWXHandler) UMShareAPI.get(getApplicationContext()).getHandler(SHARE_MEDIA.WEIXIN);
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("handleid=");
        stringBuilder.append(this.mWxHandler);
        Log.e(str, stringBuilder.toString());
        this.mWxHandler.onCreate(getApplicationContext(), PlatformConfig.getPlatform(SHARE_MEDIA.WEIXIN));
        handleIntent(intent);
    }

    public void onResp(com.tencent.mm.opensdk.modelbase.BaseResp r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mWxHandler;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        if (r2 == 0) goto L_0x000f;
    L_0x0006:
        r0 = r1.mWxHandler;	 Catch:{ Exception -> 0x000f }
        r0 = r0.getWXEventHandler();	 Catch:{ Exception -> 0x000f }
        r0.onResp(r2);	 Catch:{ Exception -> 0x000f }
    L_0x000f:
        r1.finish();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.weixin.view.WXCallbackActivity.onResp(com.tencent.mm.opensdk.modelbase.BaseResp):void");
    }

    public void onReq(BaseReq baseReq) {
        if (this.mWxHandler != null) {
            this.mWxHandler.getWXEventHandler().onReq(baseReq);
        }
        finish();
    }
}
