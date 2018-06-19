package com.xunlei.downloadprovider.personal.playrecord;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: PlayRecordActivity */
final class s implements OnClickListener {
    final /* synthetic */ PlayRecordActivity a;

    s(PlayRecordActivity playRecordActivity) {
        this.a = playRecordActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        PlayRecordActivity.o(this.a);
        PlayRecordActivity.b(this.a.K);
        this.a.h();
    }
}
