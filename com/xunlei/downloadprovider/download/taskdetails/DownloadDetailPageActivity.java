package com.xunlei.downloadprovider.download.taskdetails;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.message.proguard.l;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.taskdetails.DownloadCenterDetailFragment.b;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.download.tasklist.task.s;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.xllib.android.XLIntent;

public class DownloadDetailPageActivity extends BaseActivity implements b {
    private long a;
    private String c;
    private DownloadDetailPageActivityFragment d;

    public static void a(Context context, long j, String str) {
        Intent xLIntent = new XLIntent(context, DownloadDetailPageActivity.class);
        if (context instanceof Activity) {
            xLIntent.setFlags(67108864);
        } else {
            xLIntent.setFlags(268435456);
        }
        xLIntent.putExtra(l.m, j);
        xLIntent.putExtra("from", str);
        context.startActivity(xLIntent);
    }

    public void onBackPressed() {
        if (this.d == null || !this.d.isVisible()) {
            try {
                super.onBackPressed();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                finish();
                return;
            }
        }
        this.d.c();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_download_detail_page);
        this.d = (DownloadDetailPageActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        this.c = getIntent().getStringExtra("from");
        this.a = getIntent().getLongExtra(l.m, -1);
        bundle = h.e().a(this.a);
        if (bundle != null) {
            bundle.i();
            bundle.j();
            this.d.a((s) bundle, this.c);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a.a();
        a.a((Activity) this, i, i2, intent);
    }

    public final void a() {
        finish();
    }
}
