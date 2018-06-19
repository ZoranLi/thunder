package com.xunlei.downloadprovider.vod.recordpublish;

import android.os.Handler;
import android.os.Message;

/* compiled from: RecordVideoPreviewActivity */
final class b extends Handler {
    final /* synthetic */ RecordVideoPreviewActivity a;

    b(RecordVideoPreviewActivity recordVideoPreviewActivity) {
        this.a = recordVideoPreviewActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1234) {
            this.a.c();
            this.a.j.removeMessages(1234);
            this.a.j.sendEmptyMessageDelayed(1234, 1000);
        }
    }
}
