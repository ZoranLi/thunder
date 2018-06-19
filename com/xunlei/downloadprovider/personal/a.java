package com.xunlei.downloadprovider.personal;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: UserCenterFragment */
final class a implements MessageListener {
    final /* synthetic */ UserCenterFragment a;

    a(UserCenterFragment userCenterFragment) {
        this.a = userCenterFragment;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
            case 1002:
            case 1003:
                this.a.f.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }
}
