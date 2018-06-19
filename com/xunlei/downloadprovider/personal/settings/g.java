package com.xunlei.downloadprovider.personal.settings;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: AboutBoxActivity */
final class g implements OnClickListener {
    final /* synthetic */ StringBuilder a;
    final /* synthetic */ AboutBoxActivity b;

    g(AboutBoxActivity aboutBoxActivity, StringBuilder stringBuilder) {
        this.b = aboutBoxActivity;
        this.a = stringBuilder;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
