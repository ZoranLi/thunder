package com.xunlei.downloadprovider.notification;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.androidutil.ApkHelper$ApkInfo;
import com.xunlei.common.androidutil.notification.NotificationManagerFacade;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.center.DownloadCenterActivity;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.k;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.download.tasklist.list.banner.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.banner.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.banner.a.h;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.launch.dispatch.mocklink.LinkDownloadCenterActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.external.Destination;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.xllib.android.XLIntent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressLint({"HandlerLeak"})
/* compiled from: DownloadNotification */
public final class c implements NotificationManagerFacade {
    public static List<Long> a = new ArrayList();
    private static List<Long> g = new ArrayList();
    private static c h;
    public k b;
    public boolean c = false;
    public Handler d = new d(this);
    protected boolean e;
    private long f = 0;
    private Context i;
    private NotificationManagerFacade j;
    private int k = -1;
    private List<TaskInfo> l = new ArrayList();
    private List<TaskInfo> m = new ArrayList();
    private List<TaskInfo> n = new ArrayList();
    private boolean o;
    private BroadcastReceiver p = new e(this);
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private boolean t = true;

    /* compiled from: DownloadNotification */
    private static class a {
        Context a;
        RemoteViews b;

        public a(Context context) {
            this.a = context;
        }
    }

    /* compiled from: DownloadNotification */
    private static class b extends a {
        public b(Context context) {
            super(context);
            if (com.xunlei.downloadprovider.pushmessage.c.c.b(context)) {
                this.b = new RemoteViews(context.getPackageName(), R.layout.noti_bxbb_black);
            } else {
                this.b = new RemoteViews(context.getPackageName(), R.layout.noti_bxbb_white);
            }
        }
    }

    /* compiled from: DownloadNotification */
    private static class c extends a {
        public c(Context context) {
            super(context);
            if (com.xunlei.downloadprovider.pushmessage.c.c.b(context)) {
                this.b = new RemoteViews(context.getPackageName(), R.layout.noti_running_black);
            } else {
                this.b = new RemoteViews(context.getPackageName(), R.layout.noti_running_white);
            }
        }
    }

    private c(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r2.<init>();
        r0 = 0;
        r2.f = r0;
        r0 = -1;
        r2.k = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r2.l = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r2.m = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r2.n = r0;
        r0 = 0;
        r2.c = r0;
        r1 = new com.xunlei.downloadprovider.notification.d;
        r1.<init>(r2);
        r2.d = r1;
        r1 = new com.xunlei.downloadprovider.notification.e;
        r1.<init>(r2);
        r2.p = r1;
        r2.q = r0;
        r2.r = r0;
        r2.s = r0;
        r0 = 1;
        r2.t = r0;
        r2.i = r3;	 Catch:{ Exception -> 0x0042 }
        r3 = com.xunlei.downloadprovider.notification.f.a(r3);	 Catch:{ Exception -> 0x0042 }
        r2.j = r3;	 Catch:{ Exception -> 0x0042 }
        return;
    L_0x0042:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.notification.c.<init>(android.content.Context):void");
    }

    public static synchronized c a(Context context) {
        synchronized (c.class) {
            new StringBuilder("DownloadNotification---getInstance---").append(Thread.currentThread().getId());
            if (h == null) {
                h = new c(context);
            }
            context = h;
        }
        return context;
    }

    public final void cancelAllNotifications() {
        this.j.cancelAllNotifications();
    }

    public final void cancelNotification(int i) {
        this.j.cancelNotification(i);
    }

    public final void postNotification(int i, Notification notification) {
        this.j.postNotification(i, notification);
    }

    public final void a(TaskInfo taskInfo, boolean z) {
        if (taskInfo.getTaskId() == com.xunlei.downloadprovider.download.c.a.a().e) {
            if (z) {
                cancelNotification(27866);
            } else if (taskInfo.getTaskStatus() == true) {
                cancelNotification(27866);
            }
        }
    }

    public final void a(Collection<Long> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                for (Long indexOf : collection) {
                    int indexOf2 = g.indexOf(indexOf);
                    if (indexOf2 != -1) {
                        g.remove(indexOf2);
                    }
                }
                new StringBuilder("after remove size=").append(g.size());
                if (g.size() == null) {
                    cancelNotification(27861);
                } else {
                    e();
                }
            }
        }
    }

    private void e() {
        String string = this.i.getString(R.string.noti_failed_sum, new Object[]{Integer.valueOf(g.size())});
        CharSequence a = a(string, 20);
        Builder contentText = new Builder(this.i).setAutoCancel(true).setTicker(string).setSmallIcon(R.drawable.bt_noti_default_logo).setNumber(0).setPriority(2).setContentTitle(a).setContentText(this.i.getString(R.string.noti_look_now));
        if (!l.b()) {
            contentText.setLargeIcon(BitmapFactory.decodeResource(this.i.getResources(), R.mipmap.ic_launcher));
        }
        PendingIntent a2 = a(((Long) g.get(g.size() - 1)).longValue());
        PendingIntent broadcast = PendingIntent.getBroadcast(this.i, 27861, new Intent("com.xunlei.action.COMMON_DELETE_NOTI_CLICK"), 134217728);
        Notification build = contentText.build();
        build.contentIntent = a2;
        build.deleteIntent = broadcast;
        postNotification(27861, build);
        com.xunlei.downloadprovider.download.report.a.a("download_fail");
    }

    private PendingIntent a(long j) {
        return PendingIntent.getActivity(this.i, (int) j, LinkDownloadCenterActivity.b(this.i, j, "from_failed_noti"), 134217728);
    }

    public final void a(boolean z) {
        g();
        if (!z || a.size() <= 1) {
            if (!z && a.size() > 0) {
                b(z);
            }
            return;
        }
        b(z);
    }

    private void b(boolean z) {
        List<Long> list = a;
        if (!(list == null || list.isEmpty())) {
            for (Long longValue : list) {
                cancelNotification((int) (longValue.longValue() + 28156));
            }
        }
        String string = this.i.getString(R.string.noti_done_sum, new Object[]{Integer.valueOf(a.size())});
        CharSequence a = a(string, 20);
        Builder contentText = new Builder(this.i).setAutoCancel(true).setTicker(string).setSmallIcon(R.drawable.bt_noti_default_logo).setNumber(0).setPriority(2).setContentTitle(a).setContentText(this.i.getString(R.string.noti_look_now));
        if (!l.b()) {
            contentText.setLargeIcon(BitmapFactory.decodeResource(this.i.getResources(), R.mipmap.ic_launcher));
        }
        contentText.setVibrate(new long[]{500, 100, 500});
        if (SettingStateController.getInstance().isSoundOn() && z) {
            z = new StringBuilder("android.resource://");
            z.append(this.i.getPackageName());
            z.append("/2131296257");
            contentText.setSound(Uri.parse(z.toString()));
        } else {
            contentText.setSound(false);
        }
        if (l.e()) {
            z = PendingIntent.getActivity(this.i, 8000, LinkDownloadCenterActivity.b(this.i, -1, "from_done_noti"), 134217728);
        } else {
            z = PendingIntent.getBroadcast(this.i, 8000, new Intent("com.xunlei.action.COMMON_MERGE_FILES_CLICK"), 134217728);
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this.i, 8000, new Intent("com.xunlei.action.COMMON_DELETE_NOTI_CLICK"), 134217728);
        Notification build = contentText.build();
        build.contentIntent = z;
        build.deleteIntent = broadcast;
        postNotification(true, build);
    }

    private long f() {
        if (this.f == 0) {
            this.f = System.currentTimeMillis();
        }
        return this.f;
    }

    private void a(List<TaskInfo> list) {
        c cVar = this;
        if (list == null || list.isEmpty()) {
            cVar.q = 0;
            h();
            i();
            return;
        }
        Object obj;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        n.a();
        long e = n.e();
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        boolean z = false;
        for (TaskInfo taskInfo : list) {
            if (taskInfo.getTaskStatus() == 2 || taskInfo.getTaskStatus() == 1 || taskInfo.getTaskStatus() == 0) {
                long j4;
                long j5 = j3 + taskInfo.mFileSize;
                j3 = j + taskInfo.mDownloadedSize;
                j = j2 + taskInfo.mDownloadSpeed;
                arrayList.add(taskInfo);
                if (!cVar.m.contains(taskInfo)) {
                    cVar.m.add(taskInfo);
                    com.xunlei.downloadprovider.download.report.a.a("download_in");
                }
                if (taskInfo.mHasVipChannelSpeedup) {
                    LoginHelper.a();
                    obj = (com.xunlei.downloadprovider.member.login.b.l.b() && LoginHelper.a().l()) ? 1 : null;
                    if (obj != null || j()) {
                        z = true;
                    }
                }
                if (com.xunlei.downloadprovider.download.util.k.a(taskInfo)) {
                    if ((taskInfo.mDownloadedSize * 100) / taskInfo.mFileSize >= 1) {
                        arrayList2.add(taskInfo);
                    }
                    if (!cVar.n.contains(taskInfo)) {
                        cVar.n.add(taskInfo);
                        com.xunlei.downloadprovider.download.report.a.a("download_in_bxbb");
                    }
                }
                if (h.c(taskInfo.mUrl)) {
                    j4 = j;
                } else {
                    e c = e.c();
                    j2 = taskInfo.mDownloadSpeed;
                    j4 = j;
                    if (c.d != LoginHelper.a().g.c()) {
                        c.d = LoginHelper.a().g.c();
                        c.c = false;
                    }
                    obj = (d.a().l.a() && c.b && !c.c && c.a.c() && f.b(j2)) ? 1 : null;
                    if (obj != null) {
                        h.a(taskInfo.mUrl);
                        e.c().c = true;
                        e.c();
                        e.d();
                    }
                }
                j = j3;
                j3 = j5;
                j2 = j4;
            }
        }
        int size = arrayList.size();
        int size2 = arrayList2.size();
        if (size > 0) {
            Object obj2;
            List list2;
            int i;
            Object obj3;
            int i2;
            int i3;
            Context context;
            Object[] objArr;
            CharSequence string;
            Builder builder;
            Notification build;
            a bVar;
            TaskInfo taskInfo2;
            String str;
            ApkHelper$ApkInfo apkInfo;
            StringBuilder stringBuilder;
            PendingIntent activity;
            RemoteViews remoteViews;
            if (size < 0 || size == cVar.q) {
                obj2 = null;
            } else {
                cVar.q = size;
                obj2 = 1;
            }
            if (size2 < 0 || size2 == cVar.r) {
                obj = null;
            } else {
                cVar.r = size2;
                obj = 1;
            }
            if (j3 > 52428800) {
                list2 = arrayList2;
                i = 1;
            } else {
                list2 = arrayList2;
                i = 3;
            }
            Object obj4 = obj;
            if (j3 <= 0) {
                obj3 = obj2;
                i2 = 0;
            } else if (j == j3) {
                obj3 = obj2;
                i2 = 100;
            } else {
                obj3 = obj2;
                i2 = (int) ((j * 100) / j3);
            }
            Object obj5;
            if (Math.abs(cVar.s - i2) >= i) {
                cVar.s = i2;
                obj5 = 1;
            } else {
                obj5 = null;
            }
            boolean z2 = j2 <= 0;
            if (cVar.t != z2) {
                cVar.t = z2;
                obj = 1;
            } else {
                obj = null;
            }
            if (obj3 == null && r4 == null && !z) {
                if (obj == null) {
                    i3 = size2;
                    if (i3 > 0) {
                        i();
                    } else if (obj4 != null) {
                        context = cVar.i;
                        objArr = new Object[1];
                        arrayList = list2;
                        objArr[0] = Integer.valueOf(arrayList.size());
                        string = context.getString(R.string.noti_bxbb_msg, objArr);
                        builder = new Builder(cVar.i);
                        if (VERSION.SDK_INT >= 16) {
                            builder.setPriority(2);
                        }
                        builder.setSmallIcon(R.drawable.bt_noti_default_logo);
                        builder.setLargeIcon(BitmapFactory.decodeResource(cVar.i.getResources(), R.mipmap.ic_launcher));
                        builder.setTicker(string);
                        builder.setWhen(f());
                        builder.setNumber(0);
                        builder.setDefaults(0);
                        builder.setAutoCancel(true);
                        build = builder.build();
                        if (arrayList.size() > 0) {
                            bVar = new b(cVar.i);
                            taskInfo2 = (TaskInfo) arrayList.get(0);
                            context = BrothersApplication.getApplicationInstance().getApplicationContext();
                            if (TextUtils.isEmpty(taskInfo2.mDisplayName)) {
                                string = taskInfo2.mDisplayName;
                            } else {
                                str = taskInfo2.mTitle;
                                if (XLFileTypeUtil.getFileCategoryTypeByName(taskInfo2.mLocalFileName) == EFileCategoryType.E_SOFTWARE_CATEGORY && 8 == taskInfo2.getTaskStatus()) {
                                    if (TextUtils.isEmpty(taskInfo2.mAppName)) {
                                        string = taskInfo2.mAppName;
                                    } else {
                                        apkInfo = ApkHelper.getApkInfo(context, taskInfo2.mLocalFileName);
                                        if (apkInfo != null) {
                                            string = apkInfo.getApkLabel();
                                            if (string != null) {
                                                stringBuilder = new StringBuilder();
                                                stringBuilder.append(string.toString());
                                                stringBuilder.append(ShareConstants.PATCH_SUFFIX);
                                                taskInfo2.mAppName = stringBuilder.toString();
                                                string = taskInfo2.mAppName;
                                                taskInfo2.mDisplayName = string;
                                            }
                                        }
                                    }
                                }
                                string = str;
                            }
                            bVar.b.setTextViewText(R.id.noti_bxbb_title, string);
                            bVar.b.setTextViewText(R.id.noti_sub_title, bVar.a.getString(R.string.noti_bxbb_msg, new Object[]{Integer.valueOf(arrayList.size())}));
                            bVar.b.setImageViewResource(R.id.noti_logo, XLFileTypeUtil.getFileIconResIdForVideo(taskInfo2.mTitle.trim()));
                            activity = PendingIntent.getActivity(bVar.a, 27867, LinkDownloadCenterActivity.a(bVar.a, taskInfo2.getTaskId(), taskInfo2), 268435456);
                            build.contentIntent = activity;
                            bVar.b.setOnClickPendingIntent(R.id.noti_accelerate_now_bxbb, activity);
                            bVar.b.setOnClickPendingIntent(R.id.noti_whole, activity);
                            remoteViews = bVar.b;
                            if (remoteViews != null) {
                                build.contentView = remoteViews;
                                postNotification(27868, build);
                            }
                        }
                        return;
                    }
                    return;
                }
            }
            TaskInfo taskInfo3 = (TaskInfo) arrayList.get(0);
            i3 = size2;
            CharSequence string2 = cVar.i.getString(R.string.noti_downloading, new Object[]{Integer.valueOf(size)});
            Builder builder2 = new Builder(cVar.i);
            if (VERSION.SDK_INT >= 16) {
                builder2.setPriority(2);
            }
            builder2.setTicker(string2);
            long j6 = e;
            builder2.setWhen(f());
            builder2.setNumber(0);
            builder2.setDefaults(0);
            builder2.setLargeIcon(BitmapFactory.decodeResource(cVar.i.getResources(), R.mipmap.ic_launcher));
            switch (size) {
                case 1:
                    builder2.setSmallIcon(R.drawable.bt_noti_one_logo);
                    break;
                case 2:
                    builder2.setSmallIcon(R.drawable.bt_noti_two_logo);
                    break;
                case 3:
                    builder2.setSmallIcon(R.drawable.bt_noti_three_logo);
                    break;
                default:
                    builder2.setSmallIcon(R.drawable.bt_noti_default_logo);
                    break;
            }
            build = builder2.build();
            build.flags |= 32;
            build.flags |= 2;
            PendingIntent activity2 = PendingIntent.getActivity(cVar.i, 27857, LinkDownloadCenterActivity.b(cVar.i, taskInfo3.getTaskId(), "from_running_noti"), 268435456);
            build.contentIntent = activity2;
            bVar = new c(cVar.i);
            bVar.b.setTextViewText(R.id.noti_task_num, bVar.a.getString(R.string.noti_downloading, new Object[]{Integer.valueOf(size)}));
            if (j3 > 0) {
                bVar.b.setProgressBar(R.id.noti_task_pb, 100, (int) ((j * 100) / j3), false);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(ConvertUtil.byteConvert(j2));
            stringBuilder2.append("/s");
            bVar.b.setTextViewText(R.id.noti_speed, stringBuilder2.toString());
            if (j6 != 0) {
                cVar.o = true;
            }
            e = (j6 <= j2 || j2 <= 1) ? j6 : j2 - 1;
            Boolean valueOf = Boolean.valueOf(z);
            z2 = cVar.e;
            boolean z3 = cVar.o;
            BroadcastReceiver broadcastReceiver = cVar.p;
            RemoteViews remoteViews2 = bVar.b;
            Intent xLIntent = new XLIntent();
            LoginHelper.a();
            if (com.xunlei.downloadprovider.member.login.b.l.b()) {
                int i4;
                if (!LoginHelper.a().l()) {
                    if (!j()) {
                        remoteViews2.setViewVisibility(R.id.noti_accelerate_speed, 8);
                        remoteViews2.setViewVisibility(R.id.noti_accelerate_now_vip, 0);
                        remoteViews2.setViewVisibility(R.id.noti_accelerate_, 8);
                        xLIntent.setFlags(67108864);
                        activity = PendingIntent.getActivity(bVar.a, 27862, b(bVar.a), 268435456);
                    }
                }
                if (valueOf.booleanValue()) {
                    remoteViews2.setViewVisibility(R.id.noti_accelerate_speed, 0);
                    remoteViews2.setViewVisibility(R.id.noti_accelerate_now_vip, 8);
                    remoteViews2.setViewVisibility(R.id.noti_accelerate_, 0);
                    i4 = 0;
                    i2 = 8;
                    activity = null;
                } else {
                    remoteViews2.setViewVisibility(R.id.noti_accelerate_speed, 8);
                    remoteViews2.setViewVisibility(R.id.noti_accelerate_now_vip, 0);
                    remoteViews2.setViewVisibility(R.id.noti_accelerate_, 8);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("accelerate_this_time");
                    bVar.a.registerReceiver(broadcastReceiver, intentFilter);
                    Intent intent = new Intent("accelerate_this_time");
                    intent.putExtra("bar_or_button", "button");
                    activity = PendingIntent.getBroadcast(bVar.a, 27865, intent, 268435456);
                    if (z2) {
                        i2 = 8;
                        remoteViews2.setViewVisibility(R.id.noti_accelerate_now_vip, 8);
                        i4 = 0;
                        remoteViews2.setViewVisibility(R.id.noti_accelerate_, 0);
                    } else {
                        i2 = 8;
                        i4 = 0;
                    }
                }
                if (z3) {
                    remoteViews2.setViewVisibility(R.id.noti_accelerate_speed, i4);
                } else {
                    remoteViews2.setViewVisibility(R.id.noti_accelerate_speed, i2);
                }
            } else {
                remoteViews2.setViewVisibility(R.id.noti_accelerate_speed, 8);
                remoteViews2.setViewVisibility(R.id.noti_accelerate_now_vip, 0);
                remoteViews2.setViewVisibility(R.id.noti_accelerate_, 8);
                xLIntent.setFlags(67108864);
                activity = PendingIntent.getActivity(bVar.a, 27862, b(bVar.a), 268435456);
            }
            remoteViews2.setOnClickPendingIntent(R.id.noti_accelerate_now_vip, activity);
            remoteViews = bVar.b;
            StringBuilder stringBuilder3 = new StringBuilder(" (+");
            stringBuilder3.append(ConvertUtil.byteConvert(e));
            stringBuilder3.append("/s)");
            remoteViews.setTextViewText(R.id.noti_accelerate_speed, stringBuilder3.toString());
            remoteViews = bVar.b;
            remoteViews.setOnClickPendingIntent(R.id.noti_whole, activity2);
            build.contentView = remoteViews;
            postNotification(27857, build);
            if (i3 > 0) {
                i();
            } else if (obj4 != null) {
                context = cVar.i;
                objArr = new Object[1];
                arrayList = list2;
                objArr[0] = Integer.valueOf(arrayList.size());
                string = context.getString(R.string.noti_bxbb_msg, objArr);
                builder = new Builder(cVar.i);
                if (VERSION.SDK_INT >= 16) {
                    builder.setPriority(2);
                }
                builder.setSmallIcon(R.drawable.bt_noti_default_logo);
                builder.setLargeIcon(BitmapFactory.decodeResource(cVar.i.getResources(), R.mipmap.ic_launcher));
                builder.setTicker(string);
                builder.setWhen(f());
                builder.setNumber(0);
                builder.setDefaults(0);
                builder.setAutoCancel(true);
                build = builder.build();
                if (arrayList.size() > 0) {
                    bVar = new b(cVar.i);
                    taskInfo2 = (TaskInfo) arrayList.get(0);
                    context = BrothersApplication.getApplicationInstance().getApplicationContext();
                    if (TextUtils.isEmpty(taskInfo2.mDisplayName)) {
                        str = taskInfo2.mTitle;
                        if (TextUtils.isEmpty(taskInfo2.mAppName)) {
                            apkInfo = ApkHelper.getApkInfo(context, taskInfo2.mLocalFileName);
                            if (apkInfo != null) {
                                string = apkInfo.getApkLabel();
                                if (string != null) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(string.toString());
                                    stringBuilder.append(ShareConstants.PATCH_SUFFIX);
                                    taskInfo2.mAppName = stringBuilder.toString();
                                    string = taskInfo2.mAppName;
                                    taskInfo2.mDisplayName = string;
                                }
                            }
                            string = str;
                        } else {
                            string = taskInfo2.mAppName;
                        }
                    } else {
                        string = taskInfo2.mDisplayName;
                    }
                    bVar.b.setTextViewText(R.id.noti_bxbb_title, string);
                    bVar.b.setTextViewText(R.id.noti_sub_title, bVar.a.getString(R.string.noti_bxbb_msg, new Object[]{Integer.valueOf(arrayList.size())}));
                    bVar.b.setImageViewResource(R.id.noti_logo, XLFileTypeUtil.getFileIconResIdForVideo(taskInfo2.mTitle.trim()));
                    activity = PendingIntent.getActivity(bVar.a, 27867, LinkDownloadCenterActivity.a(bVar.a, taskInfo2.getTaskId(), taskInfo2), 268435456);
                    build.contentIntent = activity;
                    bVar.b.setOnClickPendingIntent(R.id.noti_accelerate_now_bxbb, activity);
                    bVar.b.setOnClickPendingIntent(R.id.noti_whole, activity);
                    remoteViews = bVar.b;
                    if (remoteViews != null) {
                        build.contentView = remoteViews;
                        postNotification(27868, build);
                    }
                }
                return;
            }
            return;
        }
        cVar.q = 0;
        h();
        i();
    }

    public static void a() {
        a.clear();
    }

    public static void b() {
        g.clear();
    }

    public static int c() {
        return a.size();
    }

    private void g() {
        cancelNotification(27856);
        cancelNotification(27860);
    }

    private void h() {
        n.a();
        if (n.i() <= 0) {
            this.m.clear();
        }
        g();
        cancelNotification(27857);
    }

    private void i() {
        this.r = 0;
        n.a();
        if (n.i() <= 0) {
            this.n.clear();
            g();
            cancelNotification(27868);
            return;
        }
        g();
        cancelNotification(27868);
    }

    private static String a(String str, int i) {
        if (str == null) {
            return "";
        }
        int i2 = 0;
        int i3 = i2;
        while (i2 < str.length()) {
            i3 = str.charAt(i2) < '' ? i3 + 1 : i3 + 2;
            if (i3 > i) {
                i = 1;
                break;
            }
            i2++;
        }
        i = 0;
        if (i == 0) {
            return str.substring(0, i2);
        }
        i = new StringBuilder();
        i.append(str.substring(0, i2));
        i.append("...");
        return i.toString();
    }

    private static boolean j() {
        LoginHelper.a();
        return com.xunlei.downloadprovider.member.login.b.l.b() && LoginHelper.a().g.g > 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.xunlei.downloadprovider.notification.c r12, com.xunlei.downloadprovider.download.engine.task.info.TaskInfo r13, int r14, android.os.Bundle r15) {
        /*
        r0 = r13.isTaskInvisible();
        if (r0 != 0) goto L_0x0241;
    L_0x0006:
        r0 = 0;
        r12.a(r13, r0);
        r1 = r12.c;
        if (r1 != 0) goto L_0x0034;
    L_0x000e:
        r1 = r12.b;
        r2 = r1.a;
        if (r2 == 0) goto L_0x001f;
    L_0x0014:
        r1 = r1.a;
        r1 = r1.g();
        r1 = r1.h();
        goto L_0x0023;
    L_0x001f:
        r1 = java.util.Collections.emptyList();
    L_0x0023:
        r2 = new java.lang.StringBuilder;
        r3 = "msg.what = TaskInfo.TASK_STATE_CHANGED_NOTIFY refresh taskListSize=";
        r2.<init>(r3);
        r3 = r1.size();
        r2.append(r3);
        r12.a(r1);
    L_0x0034:
        r12.c = r0;
        if (r15 == 0) goto L_0x0241;
    L_0x0038:
        r1 = "hasBeforeState";
        r15 = r15.getBoolean(r1);
        if (r15 == 0) goto L_0x0241;
    L_0x0040:
        r12.c = r0;
        r15 = r13.getTaskStatus();
        r1 = 2130903040; // 0x7f030000 float:1.7412887E38 double:1.0528059867E-314;
        r2 = 2130837737; // 0x7f0200e9 float:1.7280437E38 double:1.0527737227E-314;
        r3 = 2131362564; // 0x7f0a0304 float:1.8344912E38 double:1.0530330217E-314;
        r4 = 17;
        r5 = -1;
        r6 = 8;
        r7 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
        r8 = 20;
        r9 = 1;
        if (r15 == r6) goto L_0x011e;
    L_0x005a:
        r10 = 16;
        if (r15 == r10) goto L_0x0060;
    L_0x005e:
        goto L_0x0241;
    L_0x0060:
        if (r14 == r10) goto L_0x0241;
    L_0x0062:
        if (r14 == r6) goto L_0x0241;
    L_0x0064:
        if (r14 == r4) goto L_0x0241;
    L_0x0066:
        if (r14 == r5) goto L_0x0241;
    L_0x0068:
        r12.g();
        if (r13 == 0) goto L_0x008a;
    L_0x006d:
        r14 = g;
        r4 = r13.getTaskId();
        r15 = java.lang.Long.valueOf(r4);
        r14 = r14.contains(r15);
        if (r14 != 0) goto L_0x008a;
    L_0x007d:
        r14 = g;
        r4 = r13.getTaskId();
        r15 = java.lang.Long.valueOf(r4);
        r14.add(r15);
    L_0x008a:
        r14 = g;
        r14 = r14.size();
        if (r14 <= r9) goto L_0x0099;
    L_0x0092:
        r12.g();
        r12.e();
        return;
    L_0x0099:
        if (r13 == 0) goto L_0x0241;
    L_0x009b:
        r14 = r13.mTitle;
        r15 = new android.support.v4.app.NotificationCompat$Builder;
        r4 = r12.i;
        r15.<init>(r4);
        r4 = new java.lang.StringBuilder;
        r5 = "下载失败:";
        r4.<init>(r5);
        r5 = a(r14, r8);
        r4.append(r5);
        r4 = r4.toString();
        r5 = r12.i;
        r3 = r5.getString(r3);
        r5 = new java.lang.StringBuilder;
        r6 = "下载失败:";
        r5.<init>(r6);
        r14 = a(r14, r8);
        r5.append(r14);
        r14 = r5.toString();
        r15.setSmallIcon(r2);
        r2 = com.xunlei.downloadprovider.h.l.b();
        if (r2 != 0) goto L_0x00e4;
    L_0x00d7:
        r2 = r12.i;
        r2 = r2.getResources();
        r1 = android.graphics.BitmapFactory.decodeResource(r2, r1);
        r15.setLargeIcon(r1);
    L_0x00e4:
        r15.setTicker(r14);
        r15.setAutoCancel(r9);
        r15.setNumber(r0);
        r13 = r13.getTaskId();
        r13 = r12.a(r13);
        r15.setContentTitle(r4);
        r15.setContentText(r3);
        r15.setContentIntent(r13);
        r13 = new android.content.Intent;
        r14 = "com.xunlei.action.COMMON_DELETE_NOTI_CLICK";
        r13.<init>(r14);
        r14 = r12.i;
        r0 = 27861; // 0x6cd5 float:3.9042E-41 double:1.3765E-319;
        r13 = android.app.PendingIntent.getBroadcast(r14, r0, r13, r7);
        r15.setDeleteIntent(r13);
        r13 = r15.build();
        r12.postNotification(r0, r13);
        r12 = "download_fail";
        com.xunlei.downloadprovider.download.report.a.a(r12);
        goto L_0x0241;
    L_0x011e:
        if (r14 == r6) goto L_0x0241;
    L_0x0120:
        if (r14 == r4) goto L_0x0241;
    L_0x0122:
        if (r14 == r5) goto L_0x0241;
    L_0x0124:
        r12.g();
        if (r13 == 0) goto L_0x0146;
    L_0x0129:
        r14 = a;
        r10 = r13.getTaskId();
        r15 = java.lang.Long.valueOf(r10);
        r14 = r14.indexOf(r15);
        if (r14 != r5) goto L_0x0146;
    L_0x0139:
        r14 = a;
        r4 = r13.getTaskId();
        r15 = java.lang.Long.valueOf(r4);
        r14.add(r15);
    L_0x0146:
        r14 = a;
        r14 = r14.size();
        if (r14 <= r9) goto L_0x0152;
    L_0x014e:
        r12.a(r9);
        return;
    L_0x0152:
        if (r13 == 0) goto L_0x0240;
    L_0x0154:
        r14 = r13.mTitle;
        r15 = new android.support.v4.app.NotificationCompat$Builder;
        r4 = r12.i;
        r15.<init>(r4);
        r4 = new java.lang.StringBuilder;
        r5 = "下载完成:";
        r4.<init>(r5);
        r5 = a(r14, r8);
        r4.append(r5);
        r4 = r4.toString();
        r5 = r12.i;
        r3 = r5.getString(r3);
        r5 = new java.lang.StringBuilder;
        r6 = "下载完成:";
        r5.<init>(r6);
        r14 = a(r14, r8);
        r5.append(r14);
        r14 = r5.toString();
        r15.setSmallIcon(r2);
        r2 = com.xunlei.downloadprovider.h.l.b();
        if (r2 != 0) goto L_0x019d;
    L_0x0190:
        r2 = r12.i;
        r2 = r2.getResources();
        r1 = android.graphics.BitmapFactory.decodeResource(r2, r1);
        r15.setLargeIcon(r1);
    L_0x019d:
        r15.setTicker(r14);
        r15.setAutoCancel(r9);
        r15.setNumber(r0);
        r14 = 3;
        r14 = new long[r14];
        r14 = {500, 100, 500};
        r15.setVibrate(r14);
        r14 = com.xunlei.common.businessutil.SettingStateController.getInstance();
        r14 = r14.isSoundOn();
        if (r14 == 0) goto L_0x01da;
    L_0x01b9:
        r14 = new java.lang.StringBuilder;
        r0 = "android.resource://";
        r14.<init>(r0);
        r0 = r12.i;
        r0 = r0.getPackageName();
        r14.append(r0);
        r0 = "/2131296257";
        r14.append(r0);
        r14 = r14.toString();
        r14 = android.net.Uri.parse(r14);
        r15.setSound(r14);
        goto L_0x01de;
    L_0x01da:
        r14 = 0;
        r15.setSound(r14);
    L_0x01de:
        r14 = com.xunlei.downloadprovider.h.l.e();
        if (r14 == 0) goto L_0x01fc;
    L_0x01e4:
        r14 = r12.i;
        r0 = r13.getTaskId();
        r2 = "from_done_noti";
        r14 = com.xunlei.downloadprovider.launch.dispatch.mocklink.LinkDownloadCenterActivity.b(r14, r0, r2);
        r0 = r12.i;
        r1 = r13.getTaskId();
        r1 = (int) r1;
        r14 = android.app.PendingIntent.getActivity(r0, r1, r14, r7);
        goto L_0x0217;
    L_0x01fc:
        r14 = new android.content.Intent;
        r0 = "com.xunlei.action.COMMON_FILE_CLICK";
        r14.<init>(r0);
        r0 = "TaskId";
        r1 = r13.getTaskId();
        r14.putExtra(r0, r1);
        r0 = r12.i;
        r1 = r13.getTaskId();
        r1 = (int) r1;
        r14 = android.app.PendingIntent.getBroadcast(r0, r1, r14, r7);
    L_0x0217:
        r15.setContentTitle(r4);
        r15.setContentText(r3);
        r15.setContentIntent(r14);
        r14 = new android.content.Intent;
        r0 = "com.xunlei.action.COMMON_DELETE_NOTI_CLICK";
        r14.<init>(r0);
        r0 = r12.i;
        r1 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;
        r14 = android.app.PendingIntent.getBroadcast(r0, r1, r14, r7);
        r15.setDeleteIntent(r14);
        r14 = r15.build();
        r0 = r13.getTaskId();
        r13 = (int) r0;
        r13 = r13 + 28156;
        r12.postNotification(r13, r14);
    L_0x0240:
        return;
    L_0x0241:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.notification.c.a(com.xunlei.downloadprovider.notification.c, com.xunlei.downloadprovider.download.engine.task.info.TaskInfo, int, android.os.Bundle):void");
    }

    static /* synthetic */ void a(c cVar, Object obj) {
        cVar.g();
        if (obj != null) {
            try {
                List list = (List) obj;
                if (!cVar.c) {
                    new StringBuilder("msg.what = TaskInfo.UPDATE_ALL_RUNNING_TASK refresh taskListSize=").append(list.size());
                    cVar.a(list);
                }
                cVar.c = false;
                return;
            } catch (c cVar2) {
                new StringBuilder("UPDATE_ALL_RUNNING_TASK error=").append(cVar2.getMessage());
                return;
            }
        }
        cVar2.q = 0;
        cVar2.h();
        cVar2.i();
    }

    static /* synthetic */ void a(c cVar, TaskInfo taskInfo) {
        new StringBuilder("ADD_TASK_SUCCESS mNewTasksNum=").append(cVar.k);
        if (cVar.k > 0) {
            cVar.k--;
        }
        if (taskInfo != null) {
            if (cVar.k >= 0) {
                cVar.l.add(taskInfo);
                new StringBuilder("add task size=").append(cVar.l.size());
            }
            if (cVar.k == 0) {
                taskInfo = cVar.l;
                if (taskInfo != null && taskInfo.size() > 0) {
                    int size = taskInfo.size();
                    String str = ((TaskInfo) taskInfo.get(0)).mTitle;
                    Builder builder = new Builder(cVar.i);
                    CharSequence string = cVar.i.getString(R.string.noti_new_task_title, new Object[]{a(str, 30), Integer.valueOf(size)});
                    CharSequence string2 = cVar.i.getString(R.string.noti_new_task_content, new Object[]{Integer.valueOf(size)});
                    taskInfo = cVar.i.getString(R.string.noti_new_task_ticker_text, new Object[]{a(str, 20), Integer.valueOf(size)});
                    builder.setSmallIcon(R.drawable.bt_noti_default_logo);
                    if (!l.b()) {
                        builder.setLargeIcon(BitmapFactory.decodeResource(cVar.i.getResources(), R.mipmap.ic_launcher));
                    }
                    builder.setTicker(taskInfo);
                    builder.setAutoCancel(true);
                    builder.setNumber(0);
                    if (SettingStateController.getInstance().isSoundOn() != null) {
                        builder.setDefaults(1);
                    } else {
                        builder.setDefaults(0);
                    }
                    taskInfo = PendingIntent.getActivity(cVar.i, 27860, LinkDownloadCenterActivity.b(cVar.i, -1, DLCenterEntry.download_push.toString()), 134217728);
                    builder.setContentTitle(string);
                    builder.setContentText(string2);
                    builder.setContentIntent(taskInfo);
                    cVar.postNotification(27860, builder.build());
                    cVar.k = -1;
                    cVar.l.clear();
                }
            } else if (cVar.k == -1 && taskInfo != null) {
                String str2;
                String string3 = cVar.i.getString(R.string.noti_new_one_task_content);
                if (TextUtils.isEmpty(taskInfo.mDisplayName)) {
                    str2 = taskInfo.mTitle;
                } else {
                    str2 = taskInfo.mDisplayName;
                }
                Builder b = m.b(cVar.i, cVar.i.getString(R.string.noti_new_one_task_ticker_text, new Object[]{a(str2, 20)}), string3, SettingStateController.getInstance().isSoundOn());
                if (!l.b()) {
                    b.setLargeIcon(BitmapFactory.decodeResource(cVar.i.getResources(), R.mipmap.ic_launcher));
                }
                Notification build = b.build();
                build.contentIntent = PendingIntent.getActivity(cVar.i, (int) taskInfo.getTaskId(), LinkDownloadCenterActivity.b(cVar.i, taskInfo.getTaskId(), DLCenterEntry.download_push.toString()), 134217728);
                cVar.postNotification(27856, build);
                cVar.l.clear();
                cVar.k = -1;
            }
        }
    }

    static /* synthetic */ void a(c cVar) {
        new StringBuilder("ADD_TASK_FAILED mNewTasksNum=").append(cVar.k);
        if (cVar.k > 0) {
            cVar.k--;
        }
    }

    static /* synthetic */ void a(c cVar, List list) {
        long j = com.xunlei.downloadprovider.download.c.a.a().e;
        Activity c = AppStatusChgObserver.b().c();
        if (AppStatusChgObserver.b().a) {
            if (!((AppStatusChgObserver.b().c() instanceof DownloadCenterActivity) || q.a(c))) {
                for (TaskInfo taskInfo : list) {
                    boolean z = taskInfo.mIsEnteredHighSpeedTrial;
                    boolean e = com.xunlei.downloadprovider.download.c.a.a().e(taskInfo.getTaskId());
                    if (z && j == taskInfo.getTaskId() && com.xunlei.downloadprovider.download.util.k.k(taskInfo) && e) {
                        XLToast.showLongToast(cVar.i, "您的免费会员试用已结束,请到下载中心查看");
                        com.xunlei.downloadprovider.download.c.a.a().f(taskInfo.getTaskId());
                        com.xunlei.downloadprovider.download.report.a.a();
                        return;
                    }
                }
            }
            return;
        }
        if (!com.xunlei.xllib.b.d.a(list)) {
            for (TaskInfo taskInfo2 : list) {
                boolean z2 = taskInfo2.mIsEnteredHighSpeedTrial;
                if (com.xunlei.downloadprovider.download.c.a.a().e(taskInfo2.getTaskId()) && z2 && com.xunlei.downloadprovider.download.util.k.k(taskInfo2)) {
                    if (taskInfo2 != null) {
                        list = new Builder(cVar.i);
                        CharSequence charSequence = "迅雷提示";
                        CharSequence charSequence2 = "您的免费会员试用已结束,点击查看";
                        CharSequence charSequence3 = "";
                        list.setSmallIcon(R.drawable.bt_noti_default_logo);
                        if (!l.b()) {
                            list.setLargeIcon(BitmapFactory.decodeResource(cVar.i.getResources(), R.mipmap.ic_launcher));
                        }
                        list.setAutoCancel(true);
                        list.setNumber(0);
                        if (SettingStateController.getInstance().isSoundOn()) {
                            list.setDefaults(1);
                        } else {
                            list.setDefaults(0);
                        }
                        PendingIntent activity = PendingIntent.getActivity(cVar.i, (int) taskInfo2.getTaskId(), LinkDownloadCenterActivity.b(cVar.i, taskInfo2.getTaskId(), "task_free_trial_notify"), 134217728);
                        list.setContentTitle(charSequence);
                        list.setContentText(charSequence2);
                        list.setTicker(charSequence3);
                        list.setContentIntent(activity);
                        cVar.postNotification(27866, list.build());
                        com.xunlei.downloadprovider.download.report.a.b();
                    }
                    com.xunlei.downloadprovider.download.c.a.a().f(taskInfo2.getTaskId());
                    return;
                }
            }
        }
    }

    static /* synthetic */ Intent b(Context context) {
        PayEntryParam payEntryParam = new PayEntryParam(PayFrom.DOWNLOAD_NOTIFICATION);
        payEntryParam.c = new Destination(LinkDownloadCenterActivity.class);
        context = PaymentEntryActivity.b(context, payEntryParam);
        context.putExtra("from", "download_noti");
        return context;
    }
}
