package com.xunlei.downloadprovider.personal.user;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.settings.a.a;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;

public class FeedBackActivity extends CustomWebViewActivity {
    private static final String i = "FeedBackActivity";

    protected final void a() {
        super.a();
        this.a.setRightText("意见反馈");
        this.a.setOnRightTextClickListener(new d(this));
        this.a.a.setVisibility(0);
        if (this.f.getSettings() != null) {
            this.f.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f.getSettings().setSupportMultipleWindows(true);
        }
        this.f.setWebChromeClient(new e(this));
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 80001) {
            a.a((Activity) this);
        }
    }

    public void finish() {
        super.finish();
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
        if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
            MainTabActivity.b(this, MessageInfo.USER, null);
        }
    }
}
