package com.huawei.hms.support.api.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.a;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.push.GetTagsResp;
import com.huawei.hms.support.api.push.HmsPushConst.ErrorCode;
import com.huawei.hms.support.api.push.a.a.a.c;

public class GetTagsPendingResultImpl extends a<GetTagResult, GetTagsResp> {
    private ApiClient a;

    public GetTagsPendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        super(apiClient, str, iMessageEntity);
        this.a = apiClient;
    }

    public GetTagResult onComplete(GetTagsResp getTagsResp) {
        GetTagResult getTagResult = new GetTagResult();
        try {
            getTagsResp.setTags(new c(this.a.getContext(), "tags_info").a());
            getTagResult.setTagsRes(getTagsResp);
            getTagResult.setStatus(Status.SUCCESS);
        } catch (Exception e) {
            if (com.huawei.hms.support.log.a.d()) {
                StringBuilder stringBuilder = new StringBuilder("get tags failed, error:");
                stringBuilder.append(e.getMessage());
                com.huawei.hms.support.log.a.d("GetTagsPendingResultImpl", stringBuilder.toString());
            }
            getTagResult.setTagsRes(getTagsResp);
            getTagResult.setStatus(new Status(ErrorCode.REPORT_SYSTEM_ERROR));
        }
        return getTagResult;
    }
}
