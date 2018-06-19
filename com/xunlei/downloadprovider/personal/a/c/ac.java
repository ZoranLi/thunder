package com.xunlei.downloadprovider.personal.a.c;

import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: UserInfoViewHolder */
final class ac implements MessageListener {
    final /* synthetic */ s a;

    ac(s sVar) {
        this.a = sVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_LENGTH) {
            this.a.R = message.arg1;
            this.a.e(this.a.R);
        }
    }
}
