package com.xunlei.downloadprovider.download.downloadvod.a;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.aplayer.aplayerandroid.APlayerAndroid;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.dialog.XLBaseDialogActivity;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.taskdetails.newui.DownloadDetailsActivity;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.loading.LoadingActivity;
import com.xunlei.downloadprovider.member.login.ui.LoginDlgActivity;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: DownloadVodNotifyManager */
public class d {
    private static final String d = "d";
    public ConcurrentLinkedQueue<TaskInfo> a = new ConcurrentLinkedQueue();
    public volatile boolean b = false;
    public boolean c = false;
    private volatile boolean e = false;
    private HandlerThread f;
    private Handler g;
    private TaskInfo h;

    public static void a() {
        f.a(BrothersApplication.getApplicationInstance(), "task_bxbb_notify_checked", true);
    }

    public static void b() {
        String str = "5.60.2.5510";
        if (TextUtils.isEmpty(f.a(BrothersApplication.getApplicationInstance(), "task_bxbb_notify_create_task_flag"))) {
            f.a(BrothersApplication.getApplicationInstance(), "task_bxbb_notify_create_task_flag", str);
        }
    }

    public final synchronized Handler c() {
        if (this.f == null) {
            this.f = new HandlerThread("DownloadVodNotifyCheck");
            this.f.start();
            this.g = null;
        }
        if (this.g == null) {
            this.g = new Handler(this.f.getLooper());
        }
        return this.g;
    }

    public final void d() {
        c().post(new e(this));
    }

    private void a(TaskInfo taskInfo, boolean z) {
        n.a();
        Object c = n.c(taskInfo.mLocalFileName);
        StringBuilder stringBuilder = new StringBuilder("bxbb onSchedule taskId = ");
        stringBuilder.append(taskInfo.getTaskId());
        stringBuilder.append(" play = ");
        stringBuilder.append(c);
        if (TextUtils.isEmpty(c)) {
            this.e = false;
            taskInfo.setVodStatus(true);
            taskInfo.mRunningInfo.e = SystemClock.elapsedRealtime();
            return;
        }
        APlayerAndroid aPlayerAndroid = new APlayerAndroid();
        aPlayerAndroid.setOnOpenCompleteListener(new g(this, taskInfo, z));
        aPlayerAndroid.open(c);
    }

    public final void a(TaskInfo taskInfo) {
        StringBuilder stringBuilder = new StringBuilder("bxbb showBxbbNotify taskId = ");
        stringBuilder.append(taskInfo.getTaskId());
        stringBuilder.append(" path = ");
        stringBuilder.append(taskInfo.mLocalFileName);
        this.b = true;
        a();
        this.h = taskInfo;
        Activity c = AppStatusChgObserver.b().c();
        if (b(c)) {
            f();
        } else {
            c.runOnUiThread(new h(this));
        }
    }

    private void f() {
        c().postDelayed(new j(this), 5000);
    }

    private static boolean b(Activity activity) {
        if (!(activity == null || activity.isFinishing() || (activity instanceof LaunchActivity) || (activity instanceof LoadingActivity) || (activity instanceof VodPlayerActivityNew) || (activity instanceof DownloadDetailsActivity) || (activity instanceof XLBaseDialogActivity))) {
            if ((activity instanceof LoginDlgActivity) == null) {
                return null;
            }
        }
        return true;
    }

    static /* synthetic */ void a(d dVar) {
        if (!dVar.b) {
            if (dVar.e) {
                dVar.c().postDelayed(new f(dVar), 5000);
                return;
            }
            TaskInfo taskInfo = (TaskInfo) dVar.a.poll();
            if (taskInfo != null) {
                dVar.e = true;
                Object obj = taskInfo.mLocalFileName;
                StringBuilder stringBuilder = new StringBuilder("bxbb onSchedule taskId = ");
                stringBuilder.append(taskInfo.getTaskId());
                stringBuilder.append(" path = ");
                stringBuilder.append(obj);
                if (TextUtils.isEmpty(obj)) {
                    dVar.e = false;
                    taskInfo.setVodStatus(3);
                    taskInfo.mRunningInfo.e = SystemClock.elapsedRealtime();
                } else if (taskInfo.getTaskStatus() != 8) {
                    dVar.a(taskInfo, true);
                } else if (e.c(obj)) {
                    dVar.a(taskInfo, false);
                } else {
                    dVar.e = false;
                    taskInfo.setVodStatus(3);
                    taskInfo.mRunningInfo.e = SystemClock.elapsedRealtime();
                }
            }
        }
    }
}
