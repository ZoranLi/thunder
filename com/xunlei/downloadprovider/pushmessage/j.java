package com.xunlei.downloadprovider.pushmessage;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.common.concurrent.XLCommandListener;
import com.xunlei.common.concurrent.XLCommandResult;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;

/* compiled from: PushResultDispatcher */
final class j implements XLCommandListener {
    final /* synthetic */ BasePushBiz a;
    final /* synthetic */ Context b;

    j(BasePushBiz basePushBiz, Context context) {
        this.a = basePushBiz;
        this.b = context;
    }

    public final void onResponse(XLCommandResult xLCommandResult) {
        if (!(xLCommandResult == null || xLCommandResult.data == null)) {
            if (xLCommandResult.isSuccessful()) {
                if (((Boolean) xLCommandResult.data).booleanValue() == null) {
                    xLCommandResult = this.a.shouldInterceptNotification(this.b);
                    if (xLCommandResult.a) {
                        this.a.onError(this.b, xLCommandResult.b);
                        return;
                    } else if (TextUtils.isEmpty(this.a.getInfo().getValidBigPic()) != null) {
                        m.a(this.b, this.a, null);
                        return;
                    } else {
                        h.a(this.b, this.a);
                        return;
                    }
                }
                this.a.onError(this.b, "the message has pop");
                return;
            }
        }
        this.a.onError(this.b, "dispatch sendCommand onResponse error");
    }
}
