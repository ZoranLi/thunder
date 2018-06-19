package com.xunlei.downloadprovider.personal.playrecord;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: PlayRecordActivity */
final class d implements OnClickListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ PlayRecordActivity b;

    d(PlayRecordActivity playRecordActivity, boolean z) {
        this.b = playRecordActivity;
        this.a = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a != null) {
            this.b.y.clear();
        }
        PlayRecordActivity.b(this.b.K);
    }
}
