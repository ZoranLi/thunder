package com.xunlei.downloadprovider.personal.playrecord;

import android.os.Handler.Callback;
import android.os.Message;
import java.util.Set;

/* compiled from: PlayRecordActivity */
final class r implements Callback {
    final /* synthetic */ Set a;
    final /* synthetic */ PlayRecordActivity b;

    r(PlayRecordActivity playRecordActivity, Set set) {
        this.b = playRecordActivity;
        this.a = set;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == null) {
            this.b.x.removeAll(this.a);
            this.b.l();
        }
        this.b.F.dismiss();
        this.b.F = null;
        return true;
    }
}
