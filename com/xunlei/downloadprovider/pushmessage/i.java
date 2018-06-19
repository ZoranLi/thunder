package com.xunlei.downloadprovider.pushmessage;

import com.xunlei.common.concurrent.XLCommand;
import com.xunlei.downloadprovider.pushmessage.b.a;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;

/* compiled from: PushResultDispatcher */
final class i extends XLCommand {
    final /* synthetic */ BasePushBiz a;

    i(BasePushBiz basePushBiz) {
        this.a = basePushBiz;
    }

    protected final Object execute() throws Exception {
        return Boolean.valueOf(a.a().a(this.a.getInfo().getMessageId(), this.a.getInfo().getOriginMsgBody()));
    }
}
