package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

public interface DatagramTransport {

    public interface a {
        void a(int i, IMessageEntity iMessageEntity);
    }

    void a(ApiClient apiClient, a aVar);

    void b(ApiClient apiClient, a aVar);
}
