package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: CommentDialog */
final class h implements OnDismissListener {
    final /* synthetic */ a a;

    h(a aVar) {
        this.a = aVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.a.b == null) {
            this.a.c.put(Long.valueOf(-1), this.a.a.getText().toString());
        } else {
            this.a.c.put(Long.valueOf(this.a.b.getId()), this.a.a.getText().toString());
        }
        if (this.a.o != null) {
            this.a.o.onDismiss(dialogInterface);
        }
    }
}
