package com.alibaba.sdk.android.feedback.util;

public interface IUnreadCountCallback {
    void onError(int i, String str);

    void onSuccess(int i);
}
