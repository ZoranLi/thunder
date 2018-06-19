package com.huawei.hms.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: AbstractDialog */
class d implements OnCancelListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.c();
    }
}
