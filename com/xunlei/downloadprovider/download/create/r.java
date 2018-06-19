package com.xunlei.downloadprovider.download.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: ClipboardHandlerActivity */
final class r implements OnClickListener {
    final /* synthetic */ ClipboardHandlerActivity a;

    r(ClipboardHandlerActivity clipboardHandlerActivity) {
        this.a = clipboardHandlerActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String stringExtra = this.a.getIntent().getStringExtra("copy_url");
        a.o(stringExtra);
        ClipboardHandlerActivity.a(this.a, stringExtra);
        this.a.c.dismiss();
    }
}
