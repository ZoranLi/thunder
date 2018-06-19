package com.xunlei.downloadprovider.personal.settings;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.androidutil.ClipboardUtil;

/* compiled from: AboutBoxActivity */
final class h implements OnClickListener {
    final /* synthetic */ StringBuilder a;
    final /* synthetic */ AboutBoxActivity b;

    h(AboutBoxActivity aboutBoxActivity, StringBuilder stringBuilder) {
        this.b = aboutBoxActivity;
        this.a = stringBuilder;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        ClipboardUtil.copyToClipboard(this.b.getApplicationContext(), this.a.toString(), "thunder");
    }
}
