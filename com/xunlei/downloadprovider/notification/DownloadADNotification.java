package com.xunlei.downloadprovider.notification;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.RemoteViews;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.message.proguard.l;
import com.xunlei.common.androidutil.notification.NotificationManagerFacade;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.pushmessage.c.c;
import com.xunlei.xllib.android.XLIntent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class DownloadADNotification {
    Context a;
    Map<Integer, Bitmap> b = new HashMap();
    private NotificationManagerFacade c;
    private Set<Integer> d = new HashSet();
    private Set<Integer> e = new HashSet();

    public static class ADDownloadReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            context = new a();
            String action = intent.getAction();
            long longExtra = intent.getLongExtra(l.m, -1);
            n.a();
            intent = n.f(longExtra);
            if (!(longExtra == -1 || intent == null)) {
                boolean z;
                g a;
                TaskInfo f;
                int hashCode = action.hashCode();
                if (hashCode == -288765769) {
                    if (action.equals("com.xunlei.action.AD_STATE_CHG_CLICK")) {
                        z = true;
                        switch (z) {
                            case false:
                                if (intent.getTaskStatus() == 8) {
                                    g.a();
                                    g.a(BrothersApplication.getApplicationInstance(), intent);
                                }
                                context = BrothersApplication.getApplicationInstance().getSystemService("statusbar");
                                if (VERSION.SDK_INT > 16) {
                                    intent = context.getClass().getMethod("collapse", new Class[0]);
                                } else {
                                    intent = context.getClass().getMethod("collapsePanels", new Class[0]);
                                }
                                intent.invoke(context, new Object[0]);
                                return;
                            case true:
                                a = g.a();
                                n.a();
                                f = n.f(longExtra);
                                if (f.getTaskStatus() != 8) {
                                    n.a().c(false, new long[]{longExtra});
                                }
                                a.a(longExtra);
                                a.a.a((int) f.getTaskId());
                                context.getClass();
                                a.a(intent, "delete");
                                return;
                            case true:
                                if (intent.getTaskStatus() != 16) {
                                    n.a();
                                    n.a(false, new long[]{longExtra});
                                } else if (intent.getTaskStatus() == 4) {
                                    n.a();
                                    n.a(new long[]{longExtra});
                                } else {
                                    n.a();
                                    n.b(false, new long[]{longExtra});
                                }
                                context.getClass();
                                a.a(intent, "download_or_pause");
                                break;
                            default:
                                break;
                        }
                    }
                } else if (hashCode == -205942637) {
                    if (action.equals("com.xunlei.action.AD_REMOVE_CLICK")) {
                        z = true;
                        switch (z) {
                            case false:
                                if (intent.getTaskStatus() == 8) {
                                    g.a();
                                    g.a(BrothersApplication.getApplicationInstance(), intent);
                                }
                                context = BrothersApplication.getApplicationInstance().getSystemService("statusbar");
                                if (VERSION.SDK_INT > 16) {
                                    intent = context.getClass().getMethod("collapsePanels", new Class[0]);
                                } else {
                                    intent = context.getClass().getMethod("collapse", new Class[0]);
                                }
                                intent.invoke(context, new Object[0]);
                                return;
                            case true:
                                a = g.a();
                                n.a();
                                f = n.f(longExtra);
                                if (f.getTaskStatus() != 8) {
                                    n.a().c(false, new long[]{longExtra});
                                }
                                a.a(longExtra);
                                a.a.a((int) f.getTaskId());
                                context.getClass();
                                a.a(intent, "delete");
                                return;
                            case true:
                                if (intent.getTaskStatus() != 16) {
                                    n.a();
                                    n.a(false, new long[]{longExtra});
                                } else if (intent.getTaskStatus() == 4) {
                                    n.a();
                                    n.b(false, new long[]{longExtra});
                                } else {
                                    n.a();
                                    n.a(new long[]{longExtra});
                                }
                                context.getClass();
                                a.a(intent, "download_or_pause");
                                break;
                            default:
                                break;
                        }
                    }
                } else if (hashCode == 1189834739) {
                    if (action.equals("com.xunlei.action.AD_OTHER_CLICK")) {
                        z = false;
                        switch (z) {
                            case false:
                                if (intent.getTaskStatus() == 8) {
                                    g.a();
                                    g.a(BrothersApplication.getApplicationInstance(), intent);
                                }
                                try {
                                    context = BrothersApplication.getApplicationInstance().getSystemService("statusbar");
                                    if (VERSION.SDK_INT > 16) {
                                        intent = context.getClass().getMethod("collapse", new Class[0]);
                                    } else {
                                        intent = context.getClass().getMethod("collapsePanels", new Class[0]);
                                    }
                                    intent.invoke(context, new Object[0]);
                                    return;
                                } catch (Context context2) {
                                    context2.printStackTrace();
                                    return;
                                }
                            case true:
                                a = g.a();
                                n.a();
                                f = n.f(longExtra);
                                if (f != null && f.isTaskInvisible()) {
                                    if (f.getTaskStatus() != 8) {
                                        n.a().c(false, new long[]{longExtra});
                                    }
                                    a.a(longExtra);
                                    a.a.a((int) f.getTaskId());
                                }
                                context2.getClass();
                                a.a(intent, "delete");
                                return;
                            case true:
                                if (intent.getTaskStatus() != 16) {
                                    n.a();
                                    n.a(false, new long[]{longExtra});
                                } else if (intent.getTaskStatus() == 4) {
                                    n.a();
                                    n.a(new long[]{longExtra});
                                } else {
                                    n.a();
                                    n.b(false, new long[]{longExtra});
                                }
                                context2.getClass();
                                a.a(intent, "download_or_pause");
                                break;
                            default:
                                break;
                        }
                    }
                }
                z = true;
                switch (z) {
                    case false:
                        if (intent.getTaskStatus() == 8) {
                            g.a();
                            g.a(BrothersApplication.getApplicationInstance(), intent);
                        }
                        context2 = BrothersApplication.getApplicationInstance().getSystemService("statusbar");
                        if (VERSION.SDK_INT > 16) {
                            intent = context2.getClass().getMethod("collapsePanels", new Class[0]);
                        } else {
                            intent = context2.getClass().getMethod("collapse", new Class[0]);
                        }
                        intent.invoke(context2, new Object[0]);
                        return;
                    case true:
                        a = g.a();
                        n.a();
                        f = n.f(longExtra);
                        if (f.getTaskStatus() != 8) {
                            n.a().c(false, new long[]{longExtra});
                        }
                        a.a(longExtra);
                        a.a.a((int) f.getTaskId());
                        context2.getClass();
                        a.a(intent, "delete");
                        return;
                    case true:
                        if (intent.getTaskStatus() != 16) {
                            n.a();
                            n.a(false, new long[]{longExtra});
                        } else if (intent.getTaskStatus() == 4) {
                            n.a();
                            n.b(false, new long[]{longExtra});
                        } else {
                            n.a();
                            n.a(new long[]{longExtra});
                        }
                        context2.getClass();
                        a.a(intent, "download_or_pause");
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static class a {
        final String a;
        final String b;
        final String c;
        private final String d;
        private final String e;
        private final String f;
        private final String g;

        private a() {
            this.d = "adv_download_click";
            this.e = "clickid";
            this.f = "advid";
            this.g = "download_status";
            this.a = DispatchConstants.OTHER;
            this.b = "delete";
            this.c = "download_or_pause";
        }

        public static void a(TaskInfo taskInfo, String str) {
            Map hashMap = new HashMap();
            Object obj = "unknow";
            int taskStatus = taskInfo.getTaskStatus();
            if (taskStatus == 2) {
                obj = "downloading";
            } else if (taskStatus == 4) {
                obj = "pause_download";
            } else if (taskStatus == 8) {
                obj = "download_complete";
            } else if (taskStatus == 16) {
                obj = "download_failed";
            }
            hashMap.put("download_status", obj);
            hashMap.put("clickid", str);
            hashMap.put("advid", taskInfo.mCreateOrigin);
            com.xunlei.downloadprovider.ad.home.a.a("adv_download_click", hashMap);
        }
    }

    public DownloadADNotification(Context context) {
        this.a = context;
        this.c = f.a(context);
        context = new ADDownloadReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xunlei.action.AD_REMOVE_CLICK");
        intentFilter.addAction("com.xunlei.action.AD_STATE_CHG_CLICK");
        intentFilter.addAction("com.xunlei.action.AD_OTHER_CLICK");
        this.a.registerReceiver(context, intentFilter);
    }

    public final void a(int i) {
        this.c.cancelNotification(i);
        this.d.remove(Integer.valueOf(i));
    }

    public final void a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            if (g.a().b != null && g.a().b.contains(Long.valueOf(taskInfo.getTaskId()))) {
                return;
            }
            if (taskInfo.getTaskStatus() != 8 || this.d.contains(Integer.valueOf((int) taskInfo.getTaskId()))) {
                Notification build;
                RemoteViews remoteViews;
                int i;
                CharSequence charSequence;
                this.d.add(Integer.valueOf((int) taskInfo.getTaskId()));
                if (taskInfo.getTaskStatus() != 8) {
                    this.e.remove(Integer.valueOf((int) taskInfo.getTaskId()));
                } else if (!this.e.contains(Integer.valueOf((int) taskInfo.getTaskId()))) {
                    this.e.add(Integer.valueOf((int) taskInfo.getTaskId()));
                } else {
                    return;
                }
                new StringBuilder("task update ").append(taskInfo.getTaskId());
                if (!this.b.keySet().contains(Integer.valueOf((int) taskInfo.getTaskId()))) {
                    String str = taskInfo.mIconUrl;
                    if (!(str == null || str.equals(""))) {
                        new Handler(this.a.getMainLooper()).post(new a(this, str, taskInfo));
                    }
                }
                if (VERSION.SDK_INT >= 16) {
                    build = new Builder(this.a).setPriority(2).setSmallIcon(R.drawable.icon).build();
                } else {
                    build = new Notification();
                }
                if (taskInfo.getTaskStatus() != 8) {
                    build.flags |= 32;
                    build.flags = 2 | build.flags;
                } else {
                    this.c.cancelNotification((int) taskInfo.getTaskId());
                }
                Intent xLIntent = new XLIntent();
                xLIntent.setAction("com.xunlei.action.AD_OTHER_CLICK");
                xLIntent.putExtra(l.m, taskInfo.getTaskId());
                xLIntent.putExtra("from", "from_running_noti");
                PendingIntent broadcast = PendingIntent.getBroadcast(this.a, (int) taskInfo.getTaskId(), xLIntent, 134217728);
                build.contentIntent = broadcast;
                if (c.b(BrothersApplication.getApplicationInstance())) {
                    remoteViews = new RemoteViews(this.a.getPackageName(), R.layout.noti_running_ad_black);
                } else {
                    remoteViews = new RemoteViews(this.a.getPackageName(), R.layout.noti_running_ad_white);
                }
                remoteViews.setTextViewText(R.id.noti_task_name, taskInfo.mTitle);
                if (taskInfo.mFileSize > 0) {
                    i = (int) ((taskInfo.mDownloadedSize * 100) / taskInfo.mFileSize);
                    remoteViews.setProgressBar(R.id.noti_task_pb, 100, i, false);
                } else {
                    i = 0;
                }
                if (taskInfo.getTaskStatus() == 8) {
                    remoteViews.setViewVisibility(R.id.install_btn, 0);
                    remoteViews.setViewVisibility(R.id.noti_chg_state_btn, 8);
                } else {
                    remoteViews.setViewVisibility(R.id.install_btn, 8);
                    remoteViews.setViewVisibility(R.id.noti_chg_state_btn, 0);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("%");
                remoteViews.setTextViewText(R.id.noti_download_progress_txt, stringBuilder.toString());
                int taskStatus = taskInfo.getTaskStatus();
                if (taskStatus == 4) {
                    charSequence = "已暂停";
                } else if (taskStatus == 8) {
                    charSequence = "已完成";
                } else if (taskStatus != 16) {
                    switch (taskStatus) {
                        case 1:
                            charSequence = "等待中";
                            break;
                        case 2:
                            charSequence = "下载中";
                            break;
                        default:
                            charSequence = "下载中";
                            break;
                    }
                } else {
                    charSequence = "下载失败";
                }
                remoteViews.setTextViewText(R.id.noti_download_state, charSequence);
                i = taskInfo.getTaskStatus();
                int i2 = R.drawable.noti_download_btn;
                if (!(i == 4 || i == 8 || i == 16)) {
                    switch (i) {
                        case 1:
                            break;
                        default:
                            i2 = R.drawable.noti_pause_btn;
                            break;
                    }
                }
                remoteViews.setImageViewResource(R.id.noti_chg_state_btn, i2);
                Intent xLIntent2 = new XLIntent();
                xLIntent2.setAction("com.xunlei.action.AD_OTHER_CLICK");
                xLIntent2.putExtra(l.m, taskInfo.getTaskId());
                remoteViews.setOnClickPendingIntent(R.id.noti_whole, PendingIntent.getBroadcast(BrothersApplication.getApplicationInstance(), (int) taskInfo.getTaskId(), xLIntent2, 134217728));
                xLIntent2 = new XLIntent();
                xLIntent2.setAction("com.xunlei.action.AD_STATE_CHG_CLICK");
                xLIntent2.putExtra(l.m, taskInfo.getTaskId());
                remoteViews.setOnClickPendingIntent(R.id.noti_chg_state_btn, PendingIntent.getBroadcast(BrothersApplication.getApplicationInstance(), (int) taskInfo.getTaskId(), xLIntent2, 134217728));
                xLIntent2 = new XLIntent();
                xLIntent2.setAction("com.xunlei.action.AD_REMOVE_CLICK");
                xLIntent2.putExtra(l.m, taskInfo.getTaskId());
                remoteViews.setOnClickPendingIntent(R.id.noti_close_btn, PendingIntent.getBroadcast(BrothersApplication.getApplicationInstance(), (int) taskInfo.getTaskId(), xLIntent2, 134217728));
                Bitmap bitmap = (Bitmap) this.b.get(Integer.valueOf((int) taskInfo.getTaskId()));
                if (bitmap != null) {
                    remoteViews.setImageViewBitmap(R.id.noti_logo, bitmap);
                }
                remoteViews.setOnClickPendingIntent(R.id.noti_whole, broadcast);
                build.contentView = remoteViews;
                this.c.postNotification((int) taskInfo.getTaskId(), build);
            }
        }
    }
}
