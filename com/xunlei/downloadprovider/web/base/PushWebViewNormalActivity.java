package com.xunlei.downloadprovider.web.base;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.MainTabActivity;

public class PushWebViewNormalActivity extends CustomWebViewActivity {
    protected final void a() {
        super.a();
        this.a.setOnQuitListener(new e(this));
    }

    public void onBackPressed() {
        h();
        if (this.f.h()) {
            this.f.i();
            return;
        }
        finish();
        b(this);
    }

    private static void b(Context context) {
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
        if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
            MainTabActivity.b(context, "thunder", null);
        }
    }
}
