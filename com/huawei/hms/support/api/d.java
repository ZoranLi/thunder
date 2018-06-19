package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.transport.DatagramTransport.a;

/* compiled from: PendingResultImpl */
class d implements a {
    final /* synthetic */ a a;
    final /* synthetic */ ResultCallback b;
    final /* synthetic */ a c;

    d(a aVar, a aVar2, ResultCallback resultCallback) {
        this.c = aVar;
        this.a = aVar2;
        this.b = resultCallback;
    }

    public void a(int i, IMessageEntity iMessageEntity) {
        this.c.a(i, iMessageEntity);
        this.a.a(this.b, this.c.b);
    }
}
