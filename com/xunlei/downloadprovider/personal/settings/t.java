package com.xunlei.downloadprovider.personal.settings;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: RoomCleanActivity */
final class t implements MessageListener {
    final /* synthetic */ RoomCleanActivity a;

    t(RoomCleanActivity roomCleanActivity) {
        this.a = roomCleanActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 100) {
            RoomCleanActivity.a(this.a, message);
        }
    }
}
