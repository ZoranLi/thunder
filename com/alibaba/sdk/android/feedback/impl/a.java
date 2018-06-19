package com.alibaba.sdk.android.feedback.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.sdk.android.feedback.util.ErrorCode;
import com.alibaba.sdk.android.feedback.util.FeedbackErrorCallback;
import java.util.ArrayList;
import java.util.List;

public class a {
    private List a = new ArrayList();

    private void a(Context context, String str) {
        if (context != null) {
            Intent intent = new Intent(context, ErrorPageActivity.class);
            intent.putExtra("errorMsg", str);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    private void b(Context context, String str, ErrorCode errorCode) {
        for (FeedbackErrorCallback feedbackErrorCallback : this.a) {
            if (feedbackErrorCallback != null) {
                try {
                    feedbackErrorCallback.onError(context, str, errorCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(Context context, String str, ErrorCode errorCode) {
        if (this.a.isEmpty()) {
            a(context, str);
        } else {
            b(context, str, errorCode);
        }
    }

    public void a(FeedbackErrorCallback feedbackErrorCallback) {
        if (feedbackErrorCallback != null) {
            this.a.add(feedbackErrorCallback);
        }
    }
}
