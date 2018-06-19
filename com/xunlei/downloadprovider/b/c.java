package com.xunlei.downloadprovider.b;

import android.view.View.OnClickListener;

/* compiled from: AppPraiseDlg */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(android.view.View r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a6 }
        r0 = "market://details?id=";	 Catch:{ Exception -> 0x00a6 }
        r6.<init>(r0);	 Catch:{ Exception -> 0x00a6 }
        r0 = r5.a;	 Catch:{ Exception -> 0x00a6 }
        r0 = r0.i;	 Catch:{ Exception -> 0x00a6 }
        r0 = r0.getPackageName();	 Catch:{ Exception -> 0x00a6 }
        r6.append(r0);	 Catch:{ Exception -> 0x00a6 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x00a6 }
        r6 = android.net.Uri.parse(r6);	 Catch:{ Exception -> 0x00a6 }
        r0 = new com.xunlei.xllib.android.XLIntent;	 Catch:{ Exception -> 0x00a6 }
        r1 = "android.intent.action.VIEW";	 Catch:{ Exception -> 0x00a6 }
        r0.<init>(r1, r6);	 Catch:{ Exception -> 0x00a6 }
        r6 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x00a6 }
        r0.addFlags(r6);	 Catch:{ Exception -> 0x00a6 }
        r6 = r5.a;	 Catch:{ Exception -> 0x00a6 }
        r6 = r6.i;	 Catch:{ Exception -> 0x00a6 }
        r6 = r6.getPackageManager();	 Catch:{ Exception -> 0x00a6 }
        r1 = 0;	 Catch:{ Exception -> 0x00a6 }
        r6 = r6.queryIntentActivities(r0, r1);	 Catch:{ Exception -> 0x00a6 }
        r1 = new java.util.HashSet;	 Catch:{ Exception -> 0x00a6 }
        r1.<init>();	 Catch:{ Exception -> 0x00a6 }
        r6 = r6.iterator();	 Catch:{ Exception -> 0x00a6 }
    L_0x0040:
        r2 = r6.hasNext();	 Catch:{ Exception -> 0x00a6 }
        if (r2 == 0) goto L_0x0054;	 Catch:{ Exception -> 0x00a6 }
    L_0x0046:
        r2 = r6.next();	 Catch:{ Exception -> 0x00a6 }
        r2 = (android.content.pm.ResolveInfo) r2;	 Catch:{ Exception -> 0x00a6 }
        r2 = r2.activityInfo;	 Catch:{ Exception -> 0x00a6 }
        r2 = r2.packageName;	 Catch:{ Exception -> 0x00a6 }
        r1.add(r2);	 Catch:{ Exception -> 0x00a6 }
        goto L_0x0040;	 Catch:{ Exception -> 0x00a6 }
    L_0x0054:
        r6 = "";	 Catch:{ Exception -> 0x00a6 }
        r2 = com.xunlei.downloadprovider.b.f.a();	 Catch:{ Exception -> 0x00a6 }
        r2 = r2.j;	 Catch:{ Exception -> 0x00a6 }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x00a6 }
    L_0x0060:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x00a6 }
        if (r3 == 0) goto L_0x0076;	 Catch:{ Exception -> 0x00a6 }
    L_0x0066:
        r3 = r2.next();	 Catch:{ Exception -> 0x00a6 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x00a6 }
        r4 = r1.contains(r3);	 Catch:{ Exception -> 0x00a6 }
        if (r4 == 0) goto L_0x0060;	 Catch:{ Exception -> 0x00a6 }
    L_0x0072:
        r0.setPackage(r3);	 Catch:{ Exception -> 0x00a6 }
        r6 = r3;	 Catch:{ Exception -> 0x00a6 }
    L_0x0076:
        r1 = r5.a;	 Catch:{ Exception -> 0x00a6 }
        r1 = r1.i;	 Catch:{ Exception -> 0x00a6 }
        r1.startActivity(r0);	 Catch:{ Exception -> 0x00a6 }
        r0 = com.xunlei.downloadprovider.b.h.a();	 Catch:{ Exception -> 0x00a6 }
        r1 = 1;	 Catch:{ Exception -> 0x00a6 }
        r0.b = r1;	 Catch:{ Exception -> 0x00a6 }
        r0 = r0.a;	 Catch:{ Exception -> 0x00a6 }
        r0 = r0.edit();	 Catch:{ Exception -> 0x00a6 }
        r2 = "is_praised";	 Catch:{ Exception -> 0x00a6 }
        r0 = r0.putInt(r2, r1);	 Catch:{ Exception -> 0x00a6 }
        r0.apply();	 Catch:{ Exception -> 0x00a6 }
        r0 = r5.a;	 Catch:{ Exception -> 0x00a6 }
        r0 = r0.a;	 Catch:{ Exception -> 0x00a6 }
        r2 = "praise";	 Catch:{ Exception -> 0x00a6 }
        com.xunlei.downloadprovider.b.g.a(r0, r2, r1, r6);	 Catch:{ Exception -> 0x00a6 }
        r6 = r5.a;	 Catch:{ Exception -> 0x00a6 }
        r6.cancel();	 Catch:{ Exception -> 0x00a6 }
        return;
    L_0x00a6:
        r6 = r5.a;
        r6 = r6.i;
        r0 = "您没有安装应用市场";
        com.xunlei.common.commonview.XLToast.showToast(r6, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.b.c.onClick(android.view.View):void");
    }
}
