package com.tencent.bugly.beta.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.a;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.y;
import com.tencent.open.SocialConstants;
import com.umeng.message.entity.UMessage;
import java.util.Locale;

/* compiled from: BUGLY */
public class c {
    public static c a = new c();
    public DownloadTask b;
    public String c;
    public y d;
    public b e;
    private NotificationManager f;
    private Notification g;
    private Context h = e.E.s;
    private boolean i = true;
    private long j;
    private Builder k;

    private c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.h.getPackageName());
        stringBuilder.append(".beta.DOWNLOAD_NOTIFY");
        this.c = stringBuilder.toString();
        this.f = (NotificationManager) this.h.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        this.h.registerReceiver(new BetaReceiver(), new IntentFilter(this.c));
    }

    public void a(DownloadTask downloadTask) {
        this.b = downloadTask;
        this.j = this.b.getSavedLength();
        this.i = downloadTask.isNeededNotify();
        if (this.i != null && e.E.R != null) {
            this.f.cancel(1000);
            downloadTask = new Intent(this.c);
            downloadTask.putExtra(SocialConstants.TYPE_REQUEST, 1);
            if (this.k == null) {
                this.k = new Builder(this.h);
            }
            Builder builder = this.k;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Beta.strNotificationDownloading);
            stringBuilder.append(e.E.y);
            builder = builder.setTicker(stringBuilder.toString()).setContentTitle(e.E.y);
            Locale locale = Locale.getDefault();
            String str = "%s %d%%";
            Object[] objArr = new Object[2];
            objArr[0] = Beta.strNotificationDownloading;
            long j = 0;
            if (this.b.getTotalLength() != 0) {
                j = (this.b.getSavedLength() * 100) / this.b.getTotalLength();
            }
            objArr[1] = Integer.valueOf((int) j);
            builder.setContentText(String.format(locale, str, objArr)).setContentIntent(PendingIntent.getBroadcast(this.h, 1, downloadTask, 268435456)).setAutoCancel(false);
            if (e.E.f > null) {
                this.k.setSmallIcon(e.E.f);
            } else if (!(e.E.z == null || e.E.z.applicationInfo == null)) {
                this.k.setSmallIcon(e.E.z.applicationInfo.icon);
            }
            try {
                if (e.E.g > null && this.h.getResources().getDrawable(e.E.g) != null) {
                    this.k.setLargeIcon(a.a(this.h.getResources().getDrawable(e.E.g)));
                }
            } catch (DownloadTask downloadTask2) {
                StringBuilder stringBuilder2 = new StringBuilder("[initNotify] ");
                stringBuilder2.append(downloadTask2.getMessage());
                an.c(c.class, stringBuilder2.toString(), new Object[0]);
            }
            this.g = this.k.build();
            this.f.notify(1000, this.g);
        }
    }

    public void a() {
        if (!this.i || this.b == null || !e.E.R) {
            return;
        }
        if (this.b.getSavedLength() - this.j > 307200 || this.b.getStatus() == 1 || this.b.getStatus() == 5 || this.b.getStatus() == 3) {
            this.j = this.b.getSavedLength();
            if (this.b.getStatus() == 1) {
                this.k.setAutoCancel(true).setContentText(Beta.strNotificationClickToInstall).setContentTitle(String.format("%s %s", new Object[]{e.E.y, Beta.strNotificationDownloadSucc}));
            } else if (this.b.getStatus() == 5) {
                this.k.setAutoCancel(false).setContentText(Beta.strNotificationClickToRetry).setContentTitle(String.format("%s %s", new Object[]{e.E.y, Beta.strNotificationDownloadError}));
            } else {
                long j = 0;
                Builder contentTitle;
                Locale locale;
                String str;
                Object[] objArr;
                if (this.b.getStatus() == 2) {
                    contentTitle = this.k.setContentTitle(e.E.y);
                    locale = Locale.getDefault();
                    str = "%s %d%%";
                    objArr = new Object[2];
                    objArr[0] = Beta.strNotificationDownloading;
                    if (this.b.getTotalLength() != 0) {
                        j = (this.b.getSavedLength() * 100) / this.b.getTotalLength();
                    }
                    objArr[1] = Integer.valueOf((int) j);
                    contentTitle.setContentText(String.format(locale, str, objArr)).setAutoCancel(false);
                } else if (this.b.getStatus() == 3) {
                    contentTitle = this.k.setContentTitle(e.E.y);
                    locale = Locale.getDefault();
                    str = "%s %d%%";
                    objArr = new Object[2];
                    objArr[0] = Beta.strNotificationClickToContinue;
                    if (this.b.getTotalLength() != 0) {
                        j = (this.b.getSavedLength() * 100) / this.b.getTotalLength();
                    }
                    objArr[1] = Integer.valueOf((int) j);
                    contentTitle.setContentText(String.format(locale, str, objArr)).setAutoCancel(false);
                }
            }
            this.g = this.k.build();
            this.f.notify(1000, this.g);
        }
    }

    public synchronized void a(y yVar, b bVar) {
        this.d = yVar;
        this.e = bVar;
        this.f.cancel(1001);
        bVar = new Intent(this.c);
        bVar.putExtra(SocialConstants.TYPE_REQUEST, 2);
        if (this.k == null) {
            this.k = new Builder(this.h);
        }
        Builder builder = this.k;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.E.y);
        stringBuilder.append(Beta.strNotificationHaveNewVersion);
        builder.setTicker(stringBuilder.toString()).setContentTitle(String.format("%s %s", new Object[]{e.E.y, Beta.strNotificationHaveNewVersion})).setContentIntent(PendingIntent.getBroadcast(this.h, 2, bVar, 268435456)).setAutoCancel(true).setContentText(String.format("%s.%s", new Object[]{yVar.e.d, Integer.valueOf(yVar.e.c)}));
        if (e.E.f > null) {
            this.k.setSmallIcon(e.E.f);
        } else if (!(e.E.z == null || e.E.z.applicationInfo == null)) {
            this.k.setSmallIcon(e.E.z.applicationInfo.icon);
        }
        if (e.E.g > null && this.h.getResources().getDrawable(e.E.g) != null) {
            this.k.setLargeIcon(a.a(this.h.getResources().getDrawable(e.E.g)));
        }
        this.g = this.k.build();
        this.f.notify(1001, this.g);
    }
}
