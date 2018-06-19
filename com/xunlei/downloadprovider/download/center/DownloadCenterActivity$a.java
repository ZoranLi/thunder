package com.xunlei.downloadprovider.download.center;

import android.content.BroadcastReceiver;

class DownloadCenterActivity$a extends BroadcastReceiver {
    final /* synthetic */ DownloadCenterActivity a;

    private DownloadCenterActivity$a(DownloadCenterActivity downloadCenterActivity) {
        this.a = downloadCenterActivity;
    }

    public final void onReceive(android.content.Context r5, android.content.Intent r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r5 = r6.getAction();
        if (r5 == 0) goto L_0x008e;
    L_0x0006:
        r0 = "com.xunLei.downloadCenter.MoreOperate";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x008e;
    L_0x000e:
        r5 = "taskInfo";	 Catch:{ Exception -> 0x008e }
        r5 = r6.getSerializableExtra(r5);	 Catch:{ Exception -> 0x008e }
        r5 = (com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo) r5;	 Catch:{ Exception -> 0x008e }
        r0 = com.xunlei.downloadprovider.download.tasklist.task.h.e();	 Catch:{ Exception -> 0x008e }
        r1 = r5.getTaskId();	 Catch:{ Exception -> 0x008e }
        r5 = r0.c(r1);	 Catch:{ Exception -> 0x008e }
        r0 = "from";	 Catch:{ Exception -> 0x008e }
        r6 = r6.getStringExtra(r0);	 Catch:{ Exception -> 0x008e }
        if (r5 == 0) goto L_0x0071;	 Catch:{ Exception -> 0x008e }
    L_0x002a:
        r0 = r4.a;	 Catch:{ Exception -> 0x008e }
        r1 = r0.c;	 Catch:{ Exception -> 0x008e }
        if (r1 != 0) goto L_0x004a;	 Catch:{ Exception -> 0x008e }
    L_0x0030:
        r1 = new com.xunlei.downloadprovider.download.taskdetails.DownloadCenterDetailFragment;	 Catch:{ Exception -> 0x008e }
        r1.<init>();	 Catch:{ Exception -> 0x008e }
        r0.c = r1;	 Catch:{ Exception -> 0x008e }
        r1 = r0.getSupportFragmentManager();	 Catch:{ Exception -> 0x008e }
        r1 = r1.beginTransaction();	 Catch:{ Exception -> 0x008e }
        r2 = 2131886483; // 0x7f120193 float:1.9407546E38 double:1.053291872E-314;	 Catch:{ Exception -> 0x008e }
        r3 = r0.c;	 Catch:{ Exception -> 0x008e }
        r1.replace(r2, r3);	 Catch:{ Exception -> 0x008e }
        r1.commitAllowingStateLoss();	 Catch:{ Exception -> 0x008e }
    L_0x004a:
        r1 = r0.c;	 Catch:{ Exception -> 0x008e }
        if (r1 == 0) goto L_0x0071;	 Catch:{ Exception -> 0x008e }
    L_0x004e:
        r1 = r0.c;	 Catch:{ Exception -> 0x008e }
        if (r5 == 0) goto L_0x0067;	 Catch:{ Exception -> 0x008e }
    L_0x0052:
        r2 = new com.xunlei.downloadprovider.download.taskdetails.DownloadCenterDetailFragment$a;	 Catch:{ Exception -> 0x008e }
        r3 = 0;	 Catch:{ Exception -> 0x008e }
        r2.<init>(r3);	 Catch:{ Exception -> 0x008e }
        r2.c = r5;	 Catch:{ Exception -> 0x008e }
        r2.d = r6;	 Catch:{ Exception -> 0x008e }
        r1.e = r2;	 Catch:{ Exception -> 0x008e }
        r5 = r1.isAdded();	 Catch:{ Exception -> 0x008e }
        if (r5 == 0) goto L_0x0067;	 Catch:{ Exception -> 0x008e }
    L_0x0064:
        r1.a(r2, r3);	 Catch:{ Exception -> 0x008e }
    L_0x0067:
        r5 = r0.a;	 Catch:{ Exception -> 0x008e }
        r5 = r5.b;	 Catch:{ Exception -> 0x008e }
        r5 = r5.a;	 Catch:{ Exception -> 0x008e }
        r6 = 4;	 Catch:{ Exception -> 0x008e }
        r5.setVisibility(r6);	 Catch:{ Exception -> 0x008e }
    L_0x0071:
        r5 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x008e }
        r6 = 21;	 Catch:{ Exception -> 0x008e }
        if (r5 < r6) goto L_0x008d;	 Catch:{ Exception -> 0x008e }
    L_0x0077:
        r5 = r4.a;	 Catch:{ Exception -> 0x008e }
        r5 = r5.getWindow();	 Catch:{ Exception -> 0x008e }
        r6 = r4.a;	 Catch:{ Exception -> 0x008e }
        r6 = r6.getResources();	 Catch:{ Exception -> 0x008e }
        r0 = 2131689535; // 0x7f0f003f float:1.9008088E38 double:1.053194567E-314;	 Catch:{ Exception -> 0x008e }
        r6 = r6.getColor(r0);	 Catch:{ Exception -> 0x008e }
        r5.setStatusBarColor(r6);	 Catch:{ Exception -> 0x008e }
    L_0x008d:
        return;
    L_0x008e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.center.DownloadCenterActivity$a.onReceive(android.content.Context, android.content.Intent):void");
    }
}
