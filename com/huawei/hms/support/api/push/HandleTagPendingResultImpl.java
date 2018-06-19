package com.huawei.hms.support.api.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.a;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.push.TagsResp;
import com.huawei.hms.support.api.push.HmsPushConst.ErrorCode;
import com.huawei.hms.support.api.push.a.a.a.c;
import org.json.JSONObject;

public class HandleTagPendingResultImpl extends a<HandleTagsResult, TagsResp> {
    private ApiClient a;

    public HandleTagPendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        super(apiClient, str, iMessageEntity);
        this.a = apiClient;
    }

    public HandleTagsResult onComplete(TagsResp tagsResp) {
        if (com.huawei.hms.support.log.a.a()) {
            StringBuilder stringBuilder = new StringBuilder("report tag completely, retcode is:");
            stringBuilder.append(tagsResp.getRetCode());
            com.huawei.hms.support.log.a.a("HandleTagPendingResultImpl", stringBuilder.toString());
        }
        if (ErrorCode.REPORT_TAG_SUCCESS == tagsResp.getRetCode()) {
            if (com.huawei.hms.support.log.a.a()) {
                com.huawei.hms.support.log.a.a("HandleTagPendingResultImpl", "report tag success.");
            }
            a(this.a, tagsResp.getContent());
        }
        HandleTagsResult handleTagsResult = new HandleTagsResult();
        handleTagsResult.setStatus(new Status(tagsResp.getRetCode()));
        handleTagsResult.setTagsRes(tagsResp);
        return handleTagsResult;
    }

    private static void a(ApiClient apiClient, String str) {
        if (apiClient == null) {
            if (com.huawei.hms.support.log.a.a() != null) {
                com.huawei.hms.support.log.a.a("HandleTagPendingResultImpl", "the client is null when adding or deleting tags from file.");
            }
            return;
        }
        try {
            str = com.huawei.hms.support.api.push.a.a.a.a.a(str);
            if (str != null) {
                c cVar = new c(apiClient.getContext(), "tags_info");
                apiClient = str.length();
                for (int i = 0; i < apiClient; i++) {
                    JSONObject optJSONObject = str.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("tagKey");
                        int optInt = optJSONObject.optInt("opType");
                        if (1 == optInt) {
                            cVar.a(optString, optJSONObject.optString("tagValue"));
                        } else if (2 == optInt) {
                            cVar.d(optString);
                        }
                    }
                }
            }
        } catch (ApiClient apiClient2) {
            if (com.huawei.hms.support.log.a.c() != null) {
                StringBuilder stringBuilder = new StringBuilder("when adding or deleting tags from file excepiton,");
                stringBuilder.append(apiClient2.getMessage());
                com.huawei.hms.support.log.a.c("HandleTagPendingResultImpl", stringBuilder.toString());
            }
        }
    }
}
