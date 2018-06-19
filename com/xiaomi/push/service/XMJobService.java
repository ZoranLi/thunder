package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;

public class XMJobService extends Service {
    static Service a;
    private IBinder b = null;

    @TargetApi(21)
    static class a extends JobService {
        Binder a;
        private Handler b;

        private static class a extends Handler {
            JobService a;

            a(JobService jobService) {
                super(jobService.getMainLooper());
                this.a = jobService;
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JobParameters jobParameters = (JobParameters) message.obj;
                    StringBuilder stringBuilder = new StringBuilder("Job finished ");
                    stringBuilder.append(jobParameters.getJobId());
                    b.a(stringBuilder.toString());
                    this.a.jobFinished(jobParameters, false);
                    if (jobParameters.getJobId() == 1) {
                        com.xiaomi.push.service.timers.a.a(false);
                    }
                }
            }
        }

        a(Service service) {
            this.a = null;
            this.a = (Binder) com.xiaomi.channel.commonutils.reflect.a.a(this, "onBind", new Object[]{new Intent()});
            com.xiaomi.channel.commonutils.reflect.a.a(this, "attachBaseContext", new Object[]{service});
        }

        public boolean onStartJob(JobParameters jobParameters) {
            StringBuilder stringBuilder = new StringBuilder("Job started ");
            stringBuilder.append(jobParameters.getJobId());
            b.a(stringBuilder.toString());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.b == null) {
                this.b = new a(this);
            }
            this.b.sendMessage(Message.obtain(this.b, 1, jobParameters));
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            StringBuilder stringBuilder = new StringBuilder("Job stop ");
            stringBuilder.append(jobParameters.getJobId());
            b.a(stringBuilder.toString());
            return false;
        }
    }

    static Service a() {
        return a;
    }

    public IBinder onBind(Intent intent) {
        return this.b != null ? this.b : new Binder();
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 21) {
            this.b = new a(this).a;
        }
        a = this;
    }

    public void onDestroy() {
        super.onDestroy();
        a = null;
    }
}
