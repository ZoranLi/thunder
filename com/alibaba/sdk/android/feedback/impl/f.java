package com.alibaba.sdk.android.feedback.impl;

import com.alibaba.sdk.android.feedback.util.IUnreadCountCallback;
import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.util.n;
import org.json.JSONObject;

final class f implements IWxCallback {
    final /* synthetic */ IUnreadCountCallback a;

    f(IUnreadCountCallback iUnreadCountCallback) {
        this.a = iUnreadCountCallback;
    }

    public final void onError(int i, String str) {
        if (this.a != null) {
            this.a.onError(i, str);
            n.a("getUnreadCountFailed", "network error");
            StringBuilder stringBuilder = new StringBuilder("getFeedbackUnreadCount error:");
            stringBuilder.append(str);
            stringBuilder.append(". This might be error of the internet settings");
        }
    }

    public final void onProgress(int i) {
    }

    public final void onSuccess(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
            try {
                JSONObject jSONObject = new JSONObject((String) objArr[0]);
                if (jSONObject.optInt("code") == 0) {
                    int optInt = jSONObject.getJSONObject("data").optInt("msgCount");
                    if (this.a != null) {
                        this.a.onSuccess(optInt);
                    }
                    n.a("getUnreadCountSuccess", null);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                n.a("getUnreadCountFailed", "parse data error");
            }
        }
        onError(0, "");
    }
}
