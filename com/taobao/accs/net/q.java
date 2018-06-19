package com.taobao.accs.net;

import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.taobao.accs.internal.AccsJobService;

/* compiled from: Taobao */
public class q extends g {
    public static final int DEAMON_JOB_ID = 2051;
    public static final int HB_JOB_ID = 2050;

    protected q(Context context) {
        super(context);
    }

    protected void a(int i) {
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        Builder builder = new Builder(HB_JOB_ID, new ComponentName(this.a.getPackageName(), AccsJobService.class.getName()));
        long j = (long) (i * 1000);
        jobScheduler.schedule(builder.setMinimumLatency(j).setOverrideDeadline(j).setRequiredNetworkType(1).build());
    }
}
