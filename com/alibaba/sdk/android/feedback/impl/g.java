package com.alibaba.sdk.android.feedback.impl;

import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.util.a.b;
import java.util.Map;

final class g implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ IWxCallback b;

    g(Map map, IWxCallback iWxCallback) {
        this.a = map;
        this.b = iWxCallback;
    }

    public final void run() {
        Map map = this.a;
        IWxCallback iWxCallback = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FeedbackAPI.feedbackUrl);
        stringBuilder.append("/getUnreadCount.do");
        new b(map, iWxCallback, stringBuilder.toString()).a();
    }
}
