package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.transport.DatagramTransport.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PendingResultImpl */
class c implements a {
    final /* synthetic */ AtomicBoolean a;
    final /* synthetic */ a b;

    c(a aVar, AtomicBoolean atomicBoolean) {
        this.b = aVar;
        this.a = atomicBoolean;
    }

    public void a(int i, IMessageEntity iMessageEntity) {
        if (!this.a.get()) {
            this.b.a(i, iMessageEntity);
        }
        this.b.a.countDown();
    }
}
