package com.huawei.hms.api.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.api.transport.DatagramTransport.a;

public class IPCTransport implements DatagramTransport {
    private final String a;
    private final IMessageEntity b;
    private final Class<? extends IMessageEntity> c;

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls) {
        this.a = str;
        this.b = iMessageEntity;
        this.c = cls;
    }

    public final void a(ApiClient apiClient, a aVar) {
        apiClient = a(apiClient, new f(this.c, aVar));
        if (apiClient != null) {
            aVar.a(apiClient, null);
        }
    }

    public final void b(ApiClient apiClient, a aVar) {
        a(apiClient, aVar);
    }

    private int a(com.huawei.hms.support.api.client.ApiClient r5, com.huawei.hms.core.aidl.d r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new com.huawei.hms.core.aidl.b;
        r1 = r4.a;
        r2 = com.huawei.hms.api.internal.g.a();
        r2 = r2.b();
        r0.<init>(r1, r2);
        r1 = r0.c();
        r1 = com.huawei.hms.core.aidl.a.a(r1);
        r2 = r4.b;
        r3 = new android.os.Bundle;
        r3.<init>();
        r2 = r1.a(r2, r3);
        r0.a(r2);
        r2 = new com.huawei.hms.core.aidl.RequestHeader;
        r2.<init>();
        r3 = r5.getAppID();
        r2.setAppID(r3);
        r3 = r5.getPackageName();
        r2.setPackageName(r3);
        r3 = 20502300; // 0x138d71c float:3.3949796E-38 double:1.0129482E-316;
        r2.setSdkVersion(r3);
        r3 = r5 instanceof com.huawei.hms.api.HuaweiApiClientImpl;
        if (r3 == 0) goto L_0x0049;
    L_0x0042:
        r3 = r5.getSessionId();
        r2.setSessionId(r3);
    L_0x0049:
        r3 = new android.os.Bundle;
        r3.<init>();
        r1 = r1.a(r2, r3);
        r0.b = r1;
        r5 = (com.huawei.hms.api.HuaweiApiClientImpl) r5;	 Catch:{ Exception -> 0x005f }
        r5 = r5.getService();	 Catch:{ Exception -> 0x005f }
        r5.a(r0, r6);	 Catch:{ Exception -> 0x005f }
        r5 = 0;
        return r5;
    L_0x005f:
        r5 = 907135001; // 0x3611c819 float:2.1723156E-6 double:4.4818424E-315;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.internal.IPCTransport.a(com.huawei.hms.support.api.client.ApiClient, com.huawei.hms.core.aidl.d):int");
    }
}
