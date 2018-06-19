package com.alibaba.sdk.android.feedback.impl;

import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.util.n;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final class c implements IWxCallback {
    final /* synthetic */ Callable a;
    final /* synthetic */ Callable b;

    c(Callable callable, Callable callable2) {
        this.a = callable;
        this.b = callable2;
    }

    public final void onError(int i, String str) {
        try {
            if (this.b != null) {
                this.b.call();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        FeedbackAPI.mFeedbackCustomInfoMap.put("conf", FeedbackAPI.getConfFromSharedPreferences());
        n.a("getConfFailed", "network error");
        StringBuilder stringBuilder = new StringBuilder("conf onError:");
        stringBuilder.append(str);
        stringBuilder.append(". This might be error of the internet settings");
    }

    public final void onProgress(int i) {
    }

    public final void onSuccess(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
            try {
                JSONObject jSONObject = new JSONObject((String) objArr[0]);
                if (jSONObject.optInt("code") == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    FeedbackAPI.processConfData(jSONObject2);
                    FeedbackAPI.mFeedbackCustomInfoMap.put("conf", jSONObject2.toString());
                    FeedbackAPI.setConfToSharedPreferences(jSONObject2.toString());
                    if (this.a != null) {
                        this.a.call();
                    }
                    n.a("getConfSuccess", null);
                    new StringBuilder("success retrieved the conf: ").append(jSONObject2.toString());
                }
            } catch (Exception e) {
                FeedbackAPI.mFeedbackCustomInfoMap.put("conf", FeedbackAPI.getConfFromSharedPreferences());
                new StringBuilder("parse json data exception: ").append(e.getMessage());
                n.a("getConfFailed", "parse data error");
            }
        }
    }
}
