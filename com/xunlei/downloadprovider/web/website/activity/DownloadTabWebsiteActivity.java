package com.xunlei.downloadprovider.web.website.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.web.website.a;
import com.xunlei.downloadprovider.web.website.g.b;
import com.xunlei.downloadprovider.web.website.view.CollectionUserSyncTipBottomView;
import com.xunlei.xllib.android.XLIntent;

public class DownloadTabWebsiteActivity extends BaseActivity {
    private View a;

    public static void a(Context context) {
        context.startActivity(new XLIntent(context, DownloadTabWebsiteActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_collection);
        this.a = findViewById(R.id.back);
        this.a.setOnClickListener(new d(this));
        a.a().a = (CollectionUserSyncTipBottomView) findViewById(R.id.cloud_sync_bottom_card);
        a.a().b = true;
        b.a();
        b.c();
    }

    protected void onDestroy() {
        a.a().c();
        super.onDestroy();
    }
}
