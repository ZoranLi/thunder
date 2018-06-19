package com.xunlei.downloadprovider.pushmessage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.app.BaseActivity;

public class PushNotificationHandleActivity extends BaseActivity {
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    private void a(Intent intent) {
        new f().a((Context) this, intent);
        finish();
    }
}
