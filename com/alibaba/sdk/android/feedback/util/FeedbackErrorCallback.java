package com.alibaba.sdk.android.feedback.util;

import android.content.Context;

public interface FeedbackErrorCallback {
    void onError(Context context, String str, ErrorCode errorCode);
}
