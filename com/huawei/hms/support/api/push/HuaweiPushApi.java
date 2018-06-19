package com.huawei.hms.support.api.push;

import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import java.util.List;
import java.util.Map;

public interface HuaweiPushApi {
    PendingResult<HandleTagsResult> deleteTags(ApiClient apiClient, List<String> list) throws PushException;

    void deleteToken(ApiClient apiClient, String str) throws PushException;

    void enableReceiveNormalMsg(ApiClient apiClient, boolean z);

    void enableReceiveNotifyMsg(ApiClient apiClient, boolean z);

    boolean getPushState(ApiClient apiClient);

    PendingResult<GetTagResult> getTags(ApiClient apiClient) throws PushException;

    PendingResult<TokenResult> getToken(ApiClient apiClient);

    void queryAgreement(ApiClient apiClient) throws PushException;

    PendingResult<HandleTagsResult> setTags(ApiClient apiClient, Map<String, String> map) throws PushException;
}
