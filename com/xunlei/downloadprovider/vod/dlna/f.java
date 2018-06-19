package com.xunlei.downloadprovider.vod.dlna;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

/* compiled from: DLNAListDialog */
final class f implements OnKeyListener {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != null) {
            return true;
        }
        this.a.f();
        return null;
    }
}
