package com.taobao.accs.net;

import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
class i implements IDispatchEventListener {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void onEvent(DispatchEvent dispatchEvent) {
        ThreadPoolExecutorFactory.schedule(new j(this), 2000, TimeUnit.MILLISECONDS);
    }
}
