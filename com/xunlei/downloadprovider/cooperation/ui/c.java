package com.xunlei.downloadprovider.cooperation.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.cooperation.a.a;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.l;

/* compiled from: CooperationController */
final class c implements OnClickListener {
    final /* synthetic */ CooperationItem a;
    final /* synthetic */ b b;

    c(b bVar, CooperationItem cooperationItem) {
        this.b = bVar;
        this.a = cooperationItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(this.b);
        a.a(l.c(this.a.getDisplayLocation()), this.a.getAppPackageName(), "0");
    }
}
