package com.huawei.hms.support.api.a;

import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;

/* compiled from: ConnectService */
public final class a {
    public static PendingResult<ResolveResult<ConnectResp>> a(ApiClient apiClient, ConnectInfo connectInfo) {
        return new b(apiClient, CoreNaming.CONNECT, connectInfo);
    }

    public static ResolvePendingResult<DisconnectResp> a(ApiClient apiClient, DisconnectInfo disconnectInfo) {
        return ResolvePendingResult.build(apiClient, CoreNaming.DISCONNECT, disconnectInfo, DisconnectResp.class);
    }
}
