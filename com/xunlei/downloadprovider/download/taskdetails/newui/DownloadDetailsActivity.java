package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.umeng.message.proguard.l;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.h.j;

public class DownloadDetailsActivity extends FragmentActivity {
    private static final String b = "DownloadDetailsActivity";
    public DownloadDetailsActivityFragment a;
    private long c;
    private String d;

    public static void a(Context context, long j, String str) {
        Intent intent = new Intent(context, DownloadDetailsActivity.class);
        if (context instanceof Activity) {
            intent.setFlags(67108864);
        } else {
            intent.setFlags(268435456);
        }
        intent.putExtra(l.m, j);
        intent.putExtra("from", str);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_download_details);
        this.d = getIntent().getStringExtra("from");
        this.c = getIntent().getLongExtra(l.m, -1);
        this.a = (DownloadDetailsActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        this.a.a(this.c, this.d, false);
        c.a(this, "other_player_open_action", null);
        if (VERSION.SDK_INT >= 23) {
            j.b(this);
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color_dark));
        }
    }

    public static DownloadDetailsActivity a(Context context) {
        return (context == null || !(context instanceof DownloadDetailsActivity)) ? null : (DownloadDetailsActivity) context;
    }

    protected void onResume() {
        super.onResume();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a.a();
        a.a((Activity) this, i, i2, intent);
        this.a.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (this.a != null) {
            DownloadDetailsActivityFragment downloadDetailsActivityFragment = this.a;
            boolean z = true;
            if (downloadDetailsActivityFragment.d != null && downloadDetailsActivityFragment.d.g) {
                downloadDetailsActivityFragment.d.b(false);
            } else if (!downloadDetailsActivityFragment.n) {
                z = false;
            } else if (downloadDetailsActivityFragment.l == null || !downloadDetailsActivityFragment.l.i()) {
                if (downloadDetailsActivityFragment.l == null || !downloadDetailsActivityFragment.l.h()) {
                    downloadDetailsActivityFragment.o.checkConfirm();
                }
            } else if (downloadDetailsActivityFragment.i != null) {
                downloadDetailsActivityFragment.i.x();
            }
            if (z) {
                return;
            }
        }
        super.onBackPressed();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.xunlei.downloadprovider.download.report.a.a("dl_return", this.a.e());
    }
}
