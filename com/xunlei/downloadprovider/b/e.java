package com.xunlei.downloadprovider.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: AppPraiseDlg */
final class e implements OnCancelListener {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a.h = null;
        dialogInterface = h.a();
        if (dialogInterface.c == -1) {
            dialogInterface.c = dialogInterface.a.getInt("show_count", 0);
        }
        int i = dialogInterface.c + 1;
        dialogInterface.c = i;
        dialogInterface.a.edit().putInt("show_count", i).apply();
        long currentTimeMillis = System.currentTimeMillis();
        dialogInterface.e = currentTimeMillis;
        dialogInterface.a.edit().putLong("last_show_time", currentTimeMillis).apply();
    }
}
