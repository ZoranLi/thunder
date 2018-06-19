package com.xunlei.downloadprovider.personal.lixianspace.business;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.view.InputDeviceCompat;
import com.xunlei.common.androidutil.notification.NotificationManagerWrapper;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.personal.lixianspace.a;
import com.xunlei.downloadprovider.personal.lixianspace.b.b;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo.CollectState;
import com.xunlei.downloadprovider.personal.lixianspace.ui.LXSpaceEntryActivity;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.downloadprovider.pushmessage.c.c;
import com.xunlei.downloadprovider.pushmessage.e;
import com.xunlei.downloadprovider.pushmessage.m;
import java.util.List;

/* compiled from: LXSpaceTaskStateMgr */
final class d extends b {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void a(LXTaskInfo lXTaskInfo, int i, String str) {
        if ((i == 0 ? 1 : 0) != 0 && lXTaskInfo != null) {
            c.a(this.a, lXTaskInfo);
        }
    }

    public final void b(List<LXTaskInfo> list, int i) {
        boolean z = false;
        if ((i == 0 ? 1 : 0) != 0 && com.xunlei.xllib.b.d.a(list) == 0) {
            i = this.a;
            if (!com.xunlei.xllib.b.d.a(list) && a.d()) {
                for (LXTaskInfo a : list) {
                    boolean a2 = i.a(a);
                    if (!z) {
                        z = a2;
                    }
                }
                if (z) {
                    i.a();
                }
            }
        }
    }

    public final void a(long j, int i) {
        if ((i == 0 ? 1 : 0) != 0) {
            i = this.a;
            if (a.d() && i.b.remove(Long.valueOf(j)) != null) {
                i.a();
            }
        }
    }

    public final void a(List<LXTaskInfo> list, int i) {
        if (this.a.a != null) {
            if ((i == 0 ? 1 : 0) != 0 && com.xunlei.xllib.b.d.a(list) == 0) {
                i = 0;
                int i2 = i;
                for (LXTaskInfo lXTaskInfo : list) {
                    if (lXTaskInfo != null && ((lXTaskInfo.i != CollectState.downloading || lXTaskInfo.e <= 0) && this.a.b.contains(Long.valueOf(lXTaskInfo.a)))) {
                        this.a.b.remove(Long.valueOf(lXTaskInfo.a));
                        i2 = lXTaskInfo.i == CollectState.complete ? 1 : 0;
                        i = 1;
                    }
                }
                if (i != 0) {
                    a.a.a(this.a.b);
                }
                if (!(i2 == 0 || a.d() == null)) {
                    list = BrothersApplication.getApplicationInstance();
                    i = m.b(list, "迅雷离线下载", "离线任务下载完成，点击高速取回本地", SettingStateController.getInstance().isSoundOn());
                    if (!l.b()) {
                        i.setLargeIcon(BitmapFactory.decodeResource(list.getResources(), R.mipmap.ic_launcher));
                    }
                    Intent intent = new Intent(list, LXSpaceEntryActivity.class);
                    intent.putExtra("extra_from", "entry:push");
                    intent.addFlags(268435456);
                    i.setContentIntent(PendingIntent.getActivity(list, 0, intent, 134217728));
                    com.xunlei.downloadprovider.pushmessage.report.l.b(PushResult.OFFLINE_DOWNLOAD_DONE, "offline_download_done", "", e.c().d(), "", "");
                    if (c.a(BrothersApplication.getApplicationInstance())) {
                        com.xunlei.downloadprovider.pushmessage.report.l.a(PushResult.OFFLINE_DOWNLOAD_DONE, "offline_download_done", "", e.c().d(), "", "");
                    }
                    NotificationManagerWrapper.getInstance(list).postNotification(InputDeviceCompat.SOURCE_KEYBOARD, i.build());
                }
            }
        }
    }

    public final void a(String str, int i, LXTaskInfo lXTaskInfo) {
        if (i == 0) {
            c.a(this.a, lXTaskInfo);
        }
    }
}
