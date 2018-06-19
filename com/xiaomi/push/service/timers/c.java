package com.xiaomi.push.service.timers;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMJobService;
import com.xiaomi.smack.g;

@TargetApi(21)
public class c implements a {
    Context a;
    JobScheduler b;
    private boolean c = false;

    c(Context context) {
        this.a = context;
        this.b = (JobScheduler) context.getSystemService("jobscheduler");
    }

    public void a() {
        this.c = false;
        this.b.cancel(1);
    }

    void a(long j) {
        Builder builder = new Builder(1, new ComponentName(this.a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        StringBuilder stringBuilder = new StringBuilder("schedule Job = ");
        stringBuilder.append(build.getId());
        stringBuilder.append(" in ");
        stringBuilder.append(j);
        b.c(stringBuilder.toString());
        this.b.schedule(builder.build());
    }

    public void a(boolean z) {
        if (z || this.c) {
            long c = (long) g.c();
            if (z) {
                a();
                c -= SystemClock.elapsedRealtime() % c;
            }
            this.c = true;
            a(c);
        }
    }

    public boolean b() {
        return this.c;
    }
}
