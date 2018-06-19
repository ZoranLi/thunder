package com.xunlei.downloadprovider.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.download.center.DownloadCenterActivity;
import com.xunlei.downloadprovider.download.create.DownloadBtFileExplorerActivity;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.h.j;
import com.xunlei.downloadprovider.loading.LoadingActivity;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovider.personal.user.account.ui.UserAccountPortraitSettingActivity;
import com.xunlei.downloadprovider.pushmessage.p;
import com.xunlei.downloadprovider.search.ui.search.SearchOperateActivity;

public class BaseActivity extends FragmentActivity {
    private final String a = BaseActivity.class.getSimpleName();
    public boolean b;

    public int e() {
        return -1;
    }

    public boolean q_() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = new StringBuilder("onCreate:");
        bundle.append(this);
        bundle.append("--");
        bundle.append(getTaskId());
        if ((this instanceof MainTabActivity) == null) {
            bundle = q_();
            int e = e();
            if (VERSION.SDK_INT >= 23) {
                if (bundle != null) {
                    j.a((Activity) this);
                    getWindow().setStatusBarColor(e);
                } else {
                    j.b((Activity) this);
                    getWindow().setStatusBarColor(e);
                }
            }
        }
        if ((this instanceof LoadingActivity) == null) {
            p.b(getApplicationContext());
        }
    }

    public void setContentView(int i) {
        if (VERSION.SDK_INT >= 19) {
            Object obj;
            if (!((this instanceof DownloadCenterActivity) || (this instanceof SearchOperateActivity) || (this instanceof DownloadBtFileExplorerActivity) || (this instanceof UserAccountPortraitSettingActivity))) {
                if (!(this instanceof ReportActivity)) {
                    obj = null;
                    if (obj != null) {
                        i = getLayoutInflater().inflate(i, null);
                        if (i != 0) {
                            j.b((Context) this);
                            super.setContentView(i);
                        }
                        return;
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                i = getLayoutInflater().inflate(i, null);
                if (i != 0) {
                    j.b((Context) this);
                    super.setContentView(i);
                }
                return;
            }
        }
        super.setContentView(i);
    }

    public void onResume() {
        new StringBuilder("onResume:").append(this);
        super.onResume();
        this.b = true;
        ThunderReport.onResumeActivity(this);
    }

    public void onStop() {
        super.onStop();
    }

    public void onPause() {
        new StringBuilder("onPause:").append(this);
        this.b = false;
        super.onPause();
        ThunderReport.onPauseActivity(this);
    }

    public void onDestroy() {
        new StringBuilder("onDestroy:").append(this);
        super.onDestroy();
    }
}
