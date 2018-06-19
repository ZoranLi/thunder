package com.xunlei.downloadprovider.personal.settings.a;

import android.content.Context;
import android.widget.Toast;
import com.alibaba.sdk.android.feedback.util.ErrorCode;
import com.alibaba.sdk.android.feedback.util.FeedbackErrorCallback;

/* compiled from: AliFeedbackHelper */
final class b implements FeedbackErrorCallback {
    b() {
    }

    public final void onError(Context context, String str, ErrorCode errorCode) {
        errorCode = new StringBuilder("ErrMsg is: ");
        errorCode.append(str);
        Toast.makeText(context, errorCode.toString(), null).show();
    }
}
