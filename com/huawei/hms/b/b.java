package com.huawei.hms.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: AbstractDialog */
class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.d();
    }
}
