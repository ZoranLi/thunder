package com.huawei.hms.support.api.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.push.AgreementReq;
import com.huawei.hms.support.api.entity.push.AgreementResp;
import com.huawei.hms.support.api.entity.push.DeleteTokenReq;
import com.huawei.hms.support.api.entity.push.DeleteTokenResp;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.EnableNotifyResp;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.PushStateReq;
import com.huawei.hms.support.api.entity.push.PushStateResp;
import com.huawei.hms.support.api.entity.push.TokenReq;
import com.huawei.hms.support.api.push.a.a.a.c;
import com.huawei.hms.support.log.a;
import java.util.List;
import java.util.Map;

public class HuaweiPushApiImp implements HuaweiPushApi {
    public PendingResult<TokenResult> getToken(ApiClient apiClient) {
        Context context = apiClient.getContext();
        if (a.b()) {
            StringBuilder stringBuilder = new StringBuilder("get token, pkgName:");
            stringBuilder.append(context.getPackageName());
            a.b("HuaweiPushApiImp", stringBuilder.toString());
        }
        c cVar = new c(context, "push_client_self_info");
        cVar.a("hasRequestToken", true);
        IMessageEntity tokenReq = new TokenReq();
        tokenReq.setPackageName(apiClient.getPackageName());
        if (cVar.a("hasRequestAgreement")) {
            tokenReq.setFirstTime(false);
        } else {
            tokenReq.setFirstTime(true);
            cVar.a("hasRequestAgreement", true);
        }
        return new GetTokenPendingResultImpl(apiClient, PushNaming.getToken, tokenReq);
    }

    public void deleteToken(ApiClient apiClient, String str) throws PushException {
        Context context = apiClient.getContext();
        if (a.b()) {
            StringBuilder stringBuilder = new StringBuilder("invoke method: deleteToken, pkgName:");
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(com.huawei.hms.support.api.push.a.a.b.c.a(str));
            a.b("HuaweiPushApiImp", stringBuilder.toString());
        }
        if (TextUtils.isEmpty(str)) {
            if (a.a() != null) {
                a.a("HuaweiPushApiImp", "token is null, can not deregister token");
            }
            throw new PushException(PushException.EXCEPITON_TOKEN_INVALID);
        }
        try {
            c cVar = new c(context, "push_client_self_info");
            if (str.equals(com.huawei.hms.support.api.push.a.a.a.a(context, "push_client_self_info", "token_info"))) {
                cVar.a("hasRequestToken", false);
                com.huawei.hms.support.api.push.a.a.a.b(context, "push_client_self_info", "token_info");
            }
            IMessageEntity deleteTokenReq = new DeleteTokenReq();
            deleteTokenReq.setPkgName(context.getPackageName());
            deleteTokenReq.setToken(str);
            ResolvePendingResult.build(apiClient, PushNaming.deleteToken, deleteTokenReq, DeleteTokenResp.class).get();
            com.huawei.hms.support.api.push.a.a.a.a.a(apiClient, PushNaming.deleteToken);
        } catch (ApiClient apiClient2) {
            StringBuilder stringBuilder2;
            if (a.a() != null) {
                stringBuilder2 = new StringBuilder("delete token failed, e=");
                stringBuilder2.append(apiClient2.getMessage());
                a.a("HuaweiPushApiImp", stringBuilder2.toString());
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(apiClient2);
            stringBuilder2.append(PushException.EXCEPITON_DEL_TOKEN_FAILED);
            throw new PushException(stringBuilder2.toString());
        }
    }

    public PendingResult<HandleTagsResult> setTags(ApiClient apiClient, Map<String, String> map) throws PushException {
        return new a().a(apiClient, (Map) map);
    }

    public PendingResult<GetTagResult> getTags(ApiClient apiClient) throws PushException {
        return new a().a(apiClient);
    }

    public PendingResult<HandleTagsResult> deleteTags(ApiClient apiClient, List<String> list) throws PushException {
        return new a().a(apiClient, (List) list);
    }

    public boolean getPushState(ApiClient apiClient) {
        IMessageEntity pushStateReq = new PushStateReq();
        pushStateReq.setPkgName(apiClient.getPackageName());
        ResolvePendingResult.build(apiClient, PushNaming.getPushState, pushStateReq, PushStateResp.class).get();
        com.huawei.hms.support.api.push.a.a.a.a.a(apiClient, PushNaming.getPushState);
        return true;
    }

    public void enableReceiveNormalMsg(ApiClient apiClient, boolean z) {
        if (a.b()) {
            StringBuilder stringBuilder = new StringBuilder("invoke enableReceiveNormalMsg, set flag:");
            stringBuilder.append(z);
            a.b("HuaweiPushApiImp", stringBuilder.toString());
        }
        new c(apiClient.getContext(), "push_switch").a("normal_msg_enable", z ^ 1);
        com.huawei.hms.support.api.push.a.a.a.a.a(apiClient, PushNaming.enableReceiveNormalMsg);
    }

    public void enableReceiveNotifyMsg(ApiClient apiClient, boolean z) {
        if (a.b()) {
            StringBuilder stringBuilder = new StringBuilder("invoke enableReceiveNotifyMsg, set flag:");
            stringBuilder.append(z);
            a.b("HuaweiPushApiImp", stringBuilder.toString());
        }
        IMessageEntity enableNotifyReq = new EnableNotifyReq();
        enableNotifyReq.setPackageName(apiClient.getPackageName());
        enableNotifyReq.setEnable(z);
        ResolvePendingResult.build(apiClient, PushNaming.setNotifyFlag, enableNotifyReq, EnableNotifyResp.class).get();
    }

    public void queryAgreement(ApiClient apiClient) throws PushException {
        if (a.b()) {
            a.b("HuaweiPushApiImp", "invoke queryAgreement");
        }
        Context context = apiClient.getContext();
        IMessageEntity agreementReq = new AgreementReq();
        agreementReq.setPkgName(context.getPackageName());
        String a = com.huawei.hms.support.api.push.a.a.a.a(context, "push_client_self_info", "token_info");
        if (new c(context, "push_client_self_info").a("hasRequestAgreement")) {
            agreementReq.setFirstTime(false);
        } else {
            agreementReq.setFirstTime(true);
        }
        agreementReq.setToken(a);
        ResolvePendingResult.build(apiClient, PushNaming.handleAgreement, agreementReq, AgreementResp.class).get();
    }
}
