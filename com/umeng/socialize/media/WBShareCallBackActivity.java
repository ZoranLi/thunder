package com.umeng.socialize.media;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.SinaSsoHandler;
import com.umeng.socialize.utils.Log;

public class WBShareCallBackActivity extends Activity implements WbShareCallback {
    private final String TAG = WBShareCallBackActivity.class.getSimpleName();
    protected SinaSsoHandler sinaSsoHandler = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.um("WBShareCallBackActivity");
        this.sinaSsoHandler = (SinaSsoHandler) UMShareAPI.get(getApplicationContext()).getHandler(SHARE_MEDIA.SINA);
        bundle = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("handleid=");
        stringBuilder.append(this.sinaSsoHandler);
        Log.e(bundle, stringBuilder.toString());
        this.sinaSsoHandler.onCreate(this, PlatformConfig.getPlatform(SHARE_MEDIA.SINA));
        if (getIntent() == null || getIntent().getExtras() == null) {
            bundle = this.sinaSsoHandler.getMessage();
            if (bundle == null || this.sinaSsoHandler == null || this.sinaSsoHandler.getWbHandler() == null) {
                Log.um("sina error");
                return;
            } else {
                this.sinaSsoHandler.getWbHandler().shareMessage(bundle, false);
                return;
            }
        }
        finish();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        UMShareAPI uMShareAPI = UMShareAPI.get(getApplicationContext());
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("handleid=");
        stringBuilder.append(this.sinaSsoHandler);
        Log.e(str, stringBuilder.toString());
        this.sinaSsoHandler = (SinaSsoHandler) uMShareAPI.getHandler(SHARE_MEDIA.SINA);
        this.sinaSsoHandler.onCreate(this, PlatformConfig.getPlatform(SHARE_MEDIA.SINA));
        if (this.sinaSsoHandler.getWbHandler() != null) {
            this.sinaSsoHandler.getWbHandler().doResultIntent(intent, this);
        }
        finish();
    }

    public void onWbShareSuccess() {
        if (this.sinaSsoHandler != null) {
            this.sinaSsoHandler.onSuccess();
        }
    }

    public void onWbShareCancel() {
        if (this.sinaSsoHandler != null) {
            this.sinaSsoHandler.onCancel();
        }
    }

    public void onWbShareFail() {
        if (this.sinaSsoHandler != null) {
            this.sinaSsoHandler.onError();
        }
    }
}
