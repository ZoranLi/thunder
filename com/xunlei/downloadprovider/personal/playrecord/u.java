package com.xunlei.downloadprovider.personal.playrecord;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: PlayRecordActivity */
final class u implements OnLongClickListener {
    final /* synthetic */ VideoPlayRecord a;
    final /* synthetic */ c b;

    u(c cVar, VideoPlayRecord videoPlayRecord) {
        this.b = cVar;
        this.a = videoPlayRecord;
    }

    public final boolean onLongClick(View view) {
        if (this.b.a.C == null) {
            if ((this.a instanceof b) != null) {
                PlayRecordActivity.b(this.b.a, (b) this.a);
            } else {
                PlayRecordActivity.c(this.b.a, this.a);
            }
        }
        return true;
    }
}
