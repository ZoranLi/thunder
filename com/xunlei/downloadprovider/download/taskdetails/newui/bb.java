package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

/* compiled from: TaskDetailEditController */
final class bb implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ aw c;

    bb(aw awVar, int i, List list) {
        this.c = awVar;
        this.a = i;
        this.b = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.c.a();
        if (this.c.d != null) {
            this.c.d.dismiss();
            this.c.d = null;
        }
        dialogInterface = this.c;
        boolean z = true;
        if (this.a != 1) {
            z = false;
        }
        aw.a(dialogInterface, z, this.b);
    }
}
