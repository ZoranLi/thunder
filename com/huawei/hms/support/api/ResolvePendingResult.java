package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;

public class ResolvePendingResult<T extends IMessageEntity> extends a<ResolveResult<T>, T> {
    protected ResolvePendingResult(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        super(apiClient, str, iMessageEntity, cls);
    }

    public static <R extends IMessageEntity> ResolvePendingResult<R> build(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<R> cls) {
        return new ResolvePendingResult(apiClient, str, iMessageEntity, cls);
    }

    public ResolveResult<T> onComplete(T t) {
        ResolveResult<T> resolveResult = new ResolveResult(t);
        resolveResult.setStatus(new Status(0));
        return resolveResult;
    }

    public T get() {
        return (IMessageEntity) ((ResolveResult) await()).getValue();
    }
}
