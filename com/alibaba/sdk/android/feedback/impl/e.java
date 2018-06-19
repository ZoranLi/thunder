package com.alibaba.sdk.android.feedback.impl;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.sdk.android.feedback.windvane.CustomHybirdActivity;
import java.util.concurrent.Callable;

final class e implements Callable {
    e() {
    }

    public final Object call() {
        Intent intent = new Intent(FeedbackAPI.mContext, CustomHybirdActivity.class);
        intent.putExtra("URL", FeedbackAPI.webviewUrl);
        if (!(FeedbackAPI.mContext instanceof Activity)) {
            intent.setFlags(268435456);
        }
        FeedbackAPI.mContext.startActivity(intent);
        return null;
    }
}
