package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.transport.DatagramTransport.a;

/* compiled from: PendingResultImpl */
class b implements a {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a(int i, IMessageEntity iMessageEntity) {
        this.a.a(i, iMessageEntity);
        this.a.a.countDown();
    }
}
