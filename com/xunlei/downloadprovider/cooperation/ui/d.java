package com.xunlei.downloadprovider.cooperation.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.a.a;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.l;

/* compiled from: CooperationController */
final class d implements OnClickListener {
    final /* synthetic */ CooperationItem a;
    final /* synthetic */ boolean b;
    final /* synthetic */ Context c;
    final /* synthetic */ String d;
    final /* synthetic */ long e;
    final /* synthetic */ b f;

    d(b bVar, CooperationItem cooperationItem, boolean z, Context context, String str, long j) {
        this.f = bVar;
        this.a = cooperationItem;
        this.b = z;
        this.c = context;
        this.d = str;
        this.e = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(this.f);
        a.a(l.c(this.a.getDisplayLocation()), this.a.getAppPackageName(), "1");
        if (b.a(this.a) != null) {
            b.a(BrothersApplication.getApplicationInstance(), this.a.getAppName());
        } else if (this.b != null) {
            b.a(this.c, this.d, this.e);
        } else {
            b.b(this.a);
        }
    }
}
