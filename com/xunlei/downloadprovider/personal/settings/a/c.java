package com.xunlei.downloadprovider.personal.settings.a;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import java.util.concurrent.Callable;

/* compiled from: AliFeedbackHelper */
final class c implements Callable {
    c() {
    }

    public final Object call() throws Exception {
        FeedbackAPI.getFeedbackUnreadCount(new d(this));
        return null;
    }
}
