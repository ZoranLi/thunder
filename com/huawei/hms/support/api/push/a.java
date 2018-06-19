package com.huawei.hms.support.api.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.push.GetTagsReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.TagsReq;
import com.huawei.hms.support.api.push.a.a.a.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PushTagManager */
class a {
    a() {
    }

    PendingResult<HandleTagsResult> a(ApiClient apiClient, Map<String, String> map) throws PushException {
        StringBuilder stringBuilder;
        if (map == null) {
            if (com.huawei.hms.support.log.a.a() != null) {
                com.huawei.hms.support.log.a.a("PushTagManager", PushException.EXCEPITON_TAGS_NULL);
            }
            throw new PushException(PushException.EXCEPITON_TAGS_NULL);
        }
        Context context = apiClient.getContext();
        if (com.huawei.hms.support.log.a.a()) {
            StringBuilder stringBuilder2 = new StringBuilder("set tags, pkgName:");
            stringBuilder2.append(context.getPackageName());
            com.huawei.hms.support.log.a.a("PushTagManager", stringBuilder2.toString());
        }
        map = a(context, (Map) map);
        try {
            JSONArray jSONArray = new JSONArray();
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagKey", str);
                jSONObject.put("tagValue", str2);
                jSONObject.put("opType", 1);
                if (jSONObject.length() > 0) {
                    jSONArray.put(jSONObject);
                }
            }
            if (jSONArray.length() > null) {
                if (com.huawei.hms.support.log.a.a() != null) {
                    StringBuilder stringBuilder3 = new StringBuilder("begin to setTags: ");
                    stringBuilder3.append(jSONArray.toString());
                    com.huawei.hms.support.log.a.a("PushTagManager", stringBuilder3.toString());
                }
                return a(apiClient, jSONArray.toString(), 0, 2);
            }
            if (com.huawei.hms.support.log.a.a() != null) {
                com.huawei.hms.support.log.a.a("PushTagManager", "no tag need to upload");
            }
            throw new PushException(PushException.EXCEPITON_TAGS_NULL);
        } catch (ApiClient apiClient2) {
            if (com.huawei.hms.support.log.a.a() != null) {
                stringBuilder = new StringBuilder("set tags exception,");
                stringBuilder.append(apiClient2.toString());
                com.huawei.hms.support.log.a.a("PushTagManager", stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(apiClient2);
            stringBuilder.append(PushException.EXCEPITON_SET_TAGS_FAILED);
            throw new PushException(stringBuilder.toString());
        }
    }

    PendingResult<HandleTagsResult> a(ApiClient apiClient, List<String> list) throws PushException {
        if (com.huawei.hms.support.log.a.b()) {
            com.huawei.hms.support.log.a.b("PushTagManager", "invoke method: deleteTags");
        }
        try {
            a((List) list);
            Context context = apiClient.getContext();
            if (com.huawei.hms.support.log.a.a()) {
                StringBuilder stringBuilder = new StringBuilder("delete tags, pkgName:");
                stringBuilder.append(context.getPackageName());
                com.huawei.hms.support.log.a.a("PushTagManager", stringBuilder.toString());
            }
            list = com.huawei.hms.support.api.push.a.a.a.a.a((List) list, context);
            if (list.length() > 0) {
                if (com.huawei.hms.support.log.a.a()) {
                    StringBuilder stringBuilder2 = new StringBuilder("begin to deleTags: ");
                    stringBuilder2.append(list.toString());
                    com.huawei.hms.support.log.a.a("PushTagManager", stringBuilder2.toString());
                }
                return a(apiClient, list.toString(), 0, 2);
            }
            if (com.huawei.hms.support.log.a.a() != null) {
                com.huawei.hms.support.log.a.a("PushTagManager", PushException.EXCEPITON_NO_TAG_NEED_DEL);
            }
            throw new PushException(PushException.EXCEPITON_NO_TAG_NEED_DEL);
        } catch (ApiClient apiClient2) {
            if (com.huawei.hms.support.log.a.c() != null) {
                StringBuilder stringBuilder3 = new StringBuilder("delete tag error: ");
                stringBuilder3.append(apiClient2.getMessage());
                com.huawei.hms.support.log.a.c("PushTagManager", stringBuilder3.toString());
            }
            throw new PushException(PushException.EXCEPITON_DEL_TAGS_FAILED, apiClient2);
        }
    }

    PendingResult<GetTagResult> a(ApiClient apiClient) throws PushException {
        return new GetTagsPendingResultImpl(apiClient, PushNaming.getTags, new GetTagsReq());
    }

    private static Map<String, String> a(Context context, Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        c cVar = new c(context, "tags_info");
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (cVar.c(str)) {
                String b = cVar.b(str);
                if (!TextUtils.isEmpty(str2) && str2.equals(b)) {
                    if (com.huawei.hms.support.log.a.a()) {
                        StringBuilder stringBuilder = new StringBuilder("tag has reported:");
                        stringBuilder.append(entry);
                        com.huawei.hms.support.log.a.a("PushTagManager", stringBuilder.toString());
                    }
                }
            }
            hashMap.put(str, str2);
        }
        return hashMap;
    }

    private PendingResult<HandleTagsResult> a(ApiClient apiClient, String str, long j, int i) throws PushException {
        Context context = apiClient.getContext();
        Object a = com.huawei.hms.support.api.push.a.a.a.a(context, "push_client_self_info", "token_info");
        if (TextUtils.isEmpty(a)) {
            if (com.huawei.hms.support.log.a.c() != null) {
                com.huawei.hms.support.log.a.c("PushTagManager", "token is null, should register a token first. error code:[907122004]");
            }
            throw new PushException(PushException.EXCEPITON_TOKEN_INVALID);
        }
        IMessageEntity tagsReq = new TagsReq();
        tagsReq.setContent(str);
        tagsReq.setCycle(j);
        tagsReq.setOperType(1);
        tagsReq.setPlusType(i);
        tagsReq.setToken(a);
        tagsReq.setPkgName(context.getPackageName());
        tagsReq.setApkVersion(com.huawei.hms.support.api.push.a.a.b(context));
        return new HandleTagPendingResultImpl(apiClient, PushNaming.setTags, tagsReq);
    }

    private void a(List<String> list) {
        if (list != null) {
            if (list.isEmpty() == null) {
                return;
            }
        }
        if (com.huawei.hms.support.log.a.a() != null) {
            com.huawei.hms.support.log.a.a("PushTagManager", "the key list is null");
        }
        throw new PushException(PushException.EXCEPITON_DEL_TAGS_LIST_NULL);
    }
}
