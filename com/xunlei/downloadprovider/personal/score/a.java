package com.xunlei.downloadprovider.personal.score;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: UserScoreCenterActivity */
final class a implements MessageListener {
    final /* synthetic */ UserScoreCenterActivity a;

    a(UserScoreCenterActivity userScoreCenterActivity) {
        this.a = userScoreCenterActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 101:
                UserScoreCenterActivity.a(this.a, message.peekData());
                return;
            case 102:
            case 104:
            case 106:
                UserScoreCenterActivity.a(this.a);
                return;
            case 103:
                UserScoreCenterActivity.b(this.a, message.peekData());
                return;
            case 105:
                UserScoreCenterActivity.b(this.a);
                break;
            default:
                break;
        }
    }
}
