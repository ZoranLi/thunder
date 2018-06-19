package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.personal.lixianspace.a;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.downloadprovider.pushmessage.e;
import com.xunlei.downloadprovider.pushmessage.report.l;

public class LXSpaceEntryActivity extends BaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    private void a(Intent intent) {
        if (!(intent == null || TextUtils.equals("entry:push", intent.getStringExtra("extra_from")) == null)) {
            l.c(PushResult.OFFLINE_DOWNLOAD_DONE, "offline_download_done", "", e.c().d(), "", "");
        }
        a.a(this);
        finish();
    }
}
