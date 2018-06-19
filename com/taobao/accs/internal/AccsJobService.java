package com.taobao.accs.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.a;

@TargetApi(21)
/* compiled from: Taobao */
public class AccsJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        ALog.d("AccsJobService", "onStartJob", new Object[0]);
        ThreadPoolExecutorFactory.execute(new a(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        try {
            Intent intent = new Intent();
            intent.setPackage(getPackageName());
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            intent.setClassName(getPackageName(), a.channelService);
            startService(intent);
        } catch (Throwable th) {
            ALog.e("AccsJobService", "onStopJob", th, new Object[0]);
        }
        return false;
    }
}
