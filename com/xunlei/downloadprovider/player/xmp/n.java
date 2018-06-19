package com.xunlei.downloadprovider.player.xmp;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

/* compiled from: PlayerPositionLooper */
final class n extends Handler {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public final void handleMessage(Message message) {
        int position;
        switch (message.what) {
            case 2:
                message = this.a;
                position = message.a.a.getPosition();
                if (position >= 0 && message.b != null) {
                    message.b.a(position);
                }
                message.e.sendEmptyMessageDelayed(2, 500);
                return;
            case 3:
                message = this.a;
                Object config = message.a.a.getConfig(31);
                boolean z = false;
                if (TextUtils.isEmpty(config) || !TextUtils.isDigitsOnly(config)) {
                    position = 0;
                } else {
                    position = Integer.parseInt(config);
                }
                if (position < 0) {
                    position = 0;
                }
                int c = message.a.c();
                StringBuilder stringBuilder = new StringBuilder("doUpdateBufferPosition--duration=");
                stringBuilder.append(c);
                stringBuilder.append("|currentBufferPos=");
                stringBuilder.append(position);
                if (c > 0) {
                    if (position > 0 && c - position < 2000) {
                        z = true;
                    }
                    if (position < message.d) {
                        position = message.d;
                    } else {
                        message.d = position;
                    }
                    if (message.b != null) {
                        message.b.a(position, z);
                    }
                    if (!z) {
                        message.e.sendEmptyMessageDelayed(3, 500);
                        break;
                    }
                    message.c = true;
                    message.e();
                    return;
                }
                message.c = true;
                message.e();
                return;
            default:
                break;
        }
    }
}
