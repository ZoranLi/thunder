package com.taobao.accs.internal;

import android.app.job.JobParameters;
import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
class a implements Runnable {
    final /* synthetic */ JobParameters a;
    final /* synthetic */ AccsJobService b;

    a(AccsJobService accsJobService, JobParameters jobParameters) {
        this.b = accsJobService;
        this.a = jobParameters;
    }

    public void run() {
        try {
            String packageName = this.b.getPackageName();
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            intent.setClassName(packageName, com.taobao.accs.utl.a.channelService);
            this.b.startService(intent);
            this.b.jobFinished(this.a, false);
        } catch (Throwable th) {
            ALog.e("AccsJobService", "onStartJob", th, new Object[0]);
        }
    }
}
