package com.huawei.hms.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.d.a;
import com.huawei.hms.core.aidl.f;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.ResultCallback;

/* compiled from: HuaweiApiClientImpl */
class c extends a {
    final /* synthetic */ ResultCallback a;
    final /* synthetic */ HuaweiApiClientImpl b;

    c(HuaweiApiClientImpl huaweiApiClientImpl, ResultCallback resultCallback) {
        this.b = huaweiApiClientImpl;
        this.a = resultCallback;
    }

    public void a(b bVar) {
        if (bVar != null) {
            f a = com.huawei.hms.core.aidl.a.a(bVar.c());
            IMessageEntity responseHeader = new ResponseHeader();
            a.a(bVar.b, responseHeader);
            this.a.onResult(new BundleResult(responseHeader.getStatusCode(), bVar.a()));
            return;
        }
        this.a.onResult(new BundleResult(-1, null));
    }
}
