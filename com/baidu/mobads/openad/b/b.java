package com.baidu.mobads.openad.b;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.baidu.mobads.command.a;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils.ApkInfo;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.d;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.o;
import com.umeng.message.entity.UMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

public class b implements Observer {
    private static NotificationManager a = null;
    private static int b = 10091;
    private static HashMap<String, b> g = new HashMap();
    private a c = null;
    private Context d;
    private com.baidu.mobads.b.b e = null;
    private String f = "";
    private Handler h = new Handler(Looper.getMainLooper());

    public a a() {
        return this.c;
    }

    public static synchronized b a(String str) {
        b bVar;
        synchronized (b.class) {
            bVar = (b) g.get(str);
        }
        return bVar;
    }

    public static synchronized b b(String str) {
        b bVar;
        synchronized (b.class) {
            bVar = (b) g.remove(str);
        }
        return bVar;
    }

    public static synchronized void a(String str, b bVar) {
        synchronized (b.class) {
            g.put(str, bVar);
        }
    }

    public static synchronized int c(String str) {
        synchronized (b.class) {
            b bVar = (b) g.get(str);
            if (bVar == null || bVar.a() == null) {
                str = b;
                b = str + 1;
                return str;
            }
            str = bVar.a().f;
            return str;
        }
    }

    public b(Context context, a aVar) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "observer created");
        if (a == null) {
            a = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        }
        this.d = context.getApplicationContext();
        this.c = aVar;
        a(this.c.i, this);
    }

    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        this.c.g = iOAdDownloader.getState();
        obj = XAdSDKFoundationFacade.getInstance().getURIUitls().getFileName(iOAdDownloader.getOutputPath());
        if (!this.c.b.equals(obj)) {
            this.c.b = obj;
        }
        if (this.c.g == DownloadStatus.DOWNLOADING) {
            if (this.c.d < 0) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "download update---mExtraInfo.contentLength < 0");
                this.c.d = (long) iOAdDownloader.getFileSize();
                this.c.k = iOAdDownloader.getTargetURL();
                this.c.a(this.d);
                this.f = String.format(Locale.CHINA, "%.1fM", new Object[]{Float.valueOf(((float) this.c.d) / 1048576.0f)});
            }
            if (iOAdDownloader.getProgress() > 0.0f) {
                obj = (int) iOAdDownloader.getProgress();
                if (obj > this.c.e) {
                    this.c.e = obj;
                    if (this.c.m != null) {
                        a(iOAdDownloader);
                    }
                }
                return;
            }
        }
        StringBuilder stringBuilder;
        if (this.c.g == DownloadStatus.COMPLETED) {
            d commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            commonUtils.sendDownloadAdLog(this.d, 528, com.baidu.mobads.openad.c.b.COMPLETE, this.c.q, this.c.i, commonUtils.getAppId(this.d), "", ((o) XAdSDKFoundationFacade.getInstance().getSystemUtils()).getPhoneOSBrand(), Build.MODEL, VERSION.RELEASE, VERSION.SDK_INT);
            stringBuilder = new StringBuilder("download success-->>");
            stringBuilder.append(iOAdDownloader.getOutputPath());
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", stringBuilder.toString());
            obj = this.c.l;
            if (obj != null) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "launch installing .............");
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.c.c);
                stringBuilder2.append(this.c.b);
                String stringBuilder3 = stringBuilder2.toString();
                if (!this.c.i.contains(".")) {
                    ApkInfo localApkFileInfo = XAdSDKFoundationFacade.getInstance().getPackageUtils().getLocalApkFileInfo(this.d, stringBuilder3);
                    this.c.i = localApkFileInfo.packageName;
                }
                if (this.e == null) {
                    BroadcastReceiver aVar = new com.baidu.mobads.b.a(this.c);
                    this.e = new com.baidu.mobads.b.b(this.d, this.c.i, new File(stringBuilder3), obj);
                    this.e.a(aVar);
                    this.e.a();
                }
            }
            com.baidu.mobads.c.a.a().a(this.d, this.c);
            obj = com.baidu.mobads.command.a.a.a(this.c);
            if (obj != null) {
                com.baidu.mobads.production.b.f().getXMonitorActivation(this.d, l.a()).addAppInfoForMonitor(obj);
            }
        } else if (this.c.g == DownloadStatus.ERROR) {
            this.c.k = iOAdDownloader.getTargetURL();
            obj = XAdSDKFoundationFacade.getInstance().getAdLogger();
            Object[] objArr = new Object[2];
            objArr[0] = "OAdApkDownloaderObserver";
            stringBuilder = new StringBuilder("download failed-->>");
            stringBuilder.append(iOAdDownloader.getOutputPath());
            objArr[1] = stringBuilder.toString();
            obj.e(objArr);
            com.baidu.mobads.c.a.a().a(this.c);
        } else if (iOAdDownloader.getState() == DownloadStatus.INITING) {
            obj = this.c;
            obj.r++;
        }
        if (this.c.m != null) {
            a(iOAdDownloader);
        }
        this.c.a(this.d);
    }

    public void a(IOAdDownloader iOAdDownloader) {
        this.h.post(new c(this, iOAdDownloader));
    }

    private void d(String str) {
        Toast.makeText(this.d, str, 0).show();
    }

    @android.annotation.TargetApi(16)
    private android.app.Notification b(com.baidu.mobads.openad.interfaces.download.IOAdDownloader r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r12 = this;
        r0 = r12.c;
        r0 = r0.a;
        r1 = new java.lang.StringBuilder;
        r2 = "正在下载 ";
        r1.<init>(r2);
        r2 = r12.c;
        r2 = r2.a;
        r1.append(r2);
        r1 = r1.toString();
        r2 = "";
        r3 = r12.c;
        r3 = r3.g;
        r4 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.COMPLETED;
        r5 = 17301634; // 0x1080082 float:2.497962E-38 double:8.548143E-317;
        r6 = 17301633; // 0x1080081 float:2.4979616E-38 double:8.5481425E-317;
        if (r3 != r4) goto L_0x0046;
    L_0x0026:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r12.c;
        r3 = r3.g;
        r3 = r3.getMessage();
        r2.append(r3);
        r3 = ": ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r2 = " 点击这里安装应用";
        goto L_0x0110;
    L_0x0046:
        r3 = r12.c;
        r3 = r3.g;
        r4 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.PAUSED;
        if (r3 != r4) goto L_0x007a;
    L_0x004e:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r12.c;
        r2 = r2.g;
        r2 = r2.getMessage();
        r1.append(r2);
        r2 = ": ";
        r1.append(r2);
        r1.append(r0);
        r0 = r1.toString();
        r1 = "已为您暂停下载， 点击通知栏继续下载";
        r2 = r13.isPausedManually();
        if (r2 != 0) goto L_0x0076;
    L_0x0072:
        r2 = "目前不在wifi网络下， 点击这里继续下载";
        goto L_0x0110;
    L_0x0076:
        r2 = "点击这里继续下载";
        goto L_0x0110;
    L_0x007a:
        r3 = r12.c;
        r3 = r3.g;
        r4 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        if (r3 != r4) goto L_0x00a1;
    L_0x0082:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r12.c;
        r3 = r3.g;
        r3 = r3.getMessage();
        r2.append(r3);
        r3 = ": ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r2 = " 稍后点击这里重新下载";
        goto L_0x0110;
    L_0x00a1:
        r3 = r12.c;
        r3 = r3.g;
        r4 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.DOWNLOADING;
        if (r3 != r4) goto L_0x00e3;
    L_0x00a9:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r12.c;
        r3 = r3.g;
        r3 = r3.getMessage();
        r2.append(r3);
        r3 = ": ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r2 = new java.lang.StringBuilder;
        r3 = "下载进度: ";
        r2.<init>(r3);
        r3 = r12.c;
        r3 = r3.e;
        r2.append(r3);
        r3 = "%  应用大小: ";
        r2.append(r3);
        r3 = r12.f;
        r2.append(r3);
        r2 = r2.toString();
    L_0x00e1:
        r5 = r6;
        goto L_0x0110;
    L_0x00e3:
        r3 = r12.c;
        r3 = r3.g;
        r4 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.INITING;
        if (r3 != r4) goto L_0x00e1;
    L_0x00eb:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r12.c;
        r3 = r3.g;
        r3 = r3.getMessage();
        r2.append(r3);
        r3 = ": ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r2 = r12.c;
        r2 = r2.g;
        r2 = r2.getMessage();
        goto L_0x00e1;
    L_0x0110:
        r3 = new android.content.Intent;
        r4 = r12.d;
        r6 = com.baidu.mobads.AppActivity.getActivityClass();
        r3.<init>(r4, r6);
        r4 = "dealWithDownload";
        r6 = 1;
        r3.putExtra(r4, r6);
        r4 = "pausedManually";
        r13 = r13.isPausedManually();
        r3.putExtra(r4, r13);
        r13 = "status";
        r4 = r12.c;
        r4 = r4.g;
        r4 = r4.getCode();
        r3.putExtra(r13, r4);
        r13 = "pk";
        r4 = r12.c;
        r4 = r4.i;
        r3.putExtra(r13, r4);
        r13 = "localApkPath";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r7 = r12.c;
        r7 = r7.c;
        r4.append(r7);
        r7 = r12.c;
        r7 = r7.b;
        r4.append(r7);
        r4 = r4.toString();
        r3.putExtra(r13, r4);
        r13 = "title";
        r3.putExtra(r13, r0);
        r13 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r3.addFlags(r13);
        r7 = java.lang.System.currentTimeMillis();
        r13 = java.lang.Long.toString(r7);
        r3.setAction(r13);
        r13 = r12.d;
        r4 = r12.c;
        r4 = r4.f;
        r7 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
        r13 = android.app.PendingIntent.getActivity(r13, r4, r3, r7);
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 16;
        r7 = 0;
        if (r3 < r4) goto L_0x01c2;
    L_0x0184:
        r3 = r12.c;
        r3 = r3.h;
        if (r3 != 0) goto L_0x0195;
    L_0x018a:
        r3 = r12.c;
        r4 = new android.app.Notification$Builder;
        r8 = r12.d;
        r4.<init>(r8);
        r3.h = r4;
    L_0x0195:
        r3 = r12.c;
        r3 = r3.h;
        r3 = (android.app.Notification.Builder) r3;
        r0 = r3.setContentTitle(r0);
        r0 = r0.setContentText(r2);
        r0 = r0.setTicker(r1);
        r0 = r0.setSmallIcon(r5);
        r13 = r0.setContentIntent(r13);
        r13 = r13.setAutoCancel(r6);
        r0 = 100;
        r1 = r12.c;
        r1 = r1.e;
        r13 = r13.setProgress(r0, r1, r7);
        r13 = r13.build();
        goto L_0x0211;
    L_0x01c2:
        r3 = r12.c;
        r3 = r3.h;
        if (r3 != 0) goto L_0x01d1;
    L_0x01c8:
        r3 = r12.c;
        r8 = new android.app.Notification;
        r8.<init>();
        r3.h = r8;
    L_0x01d1:
        r3 = r12.c;
        r3 = r3.h;
        r3 = (android.app.Notification) r3;
        r3.icon = r5;
        r5 = r3.flags;
        r4 = r4 | r5;
        r3.flags = r4;
        r3.tickerText = r1;
        r3.contentIntent = r13;
        r1 = r3.getClass();	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r4 = "setLatestEventInfo";	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r5 = 4;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r8 = new java.lang.Class[r5];	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r9 = android.content.Context.class;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r8[r7] = r9;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r9 = java.lang.CharSequence.class;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r8[r6] = r9;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r9 = java.lang.CharSequence.class;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r10 = 2;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r8[r10] = r9;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r9 = android.app.PendingIntent.class;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r11 = 3;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r8[r11] = r9;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r1 = r1.getMethod(r4, r8);	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r4 = new java.lang.Object[r5];	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r5 = r12.d;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r4[r7] = r5;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r4[r6] = r0;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r4[r10] = r2;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r4[r11] = r13;	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
        r1.invoke(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210, NoSuchMethodException -> 0x0210 }
    L_0x0210:
        r13 = r3;
    L_0x0211:
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.b.b.b(com.baidu.mobads.openad.interfaces.download.IOAdDownloader):android.app.Notification");
    }
}
