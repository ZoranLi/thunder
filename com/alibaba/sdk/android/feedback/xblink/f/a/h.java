package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.view.inputmethod.InputMethodManager;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;

public class h extends a {
    public boolean a(String str, String str2, b bVar) {
        if (FeedbackAPI.mContext != null && "down".equals(str)) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) FeedbackAPI.mContext.getSystemService("input_method");
                if (FeedbackAPI.activity == null) {
                    return false;
                }
                inputMethodManager.hideSoftInputFromWindow(FeedbackAPI.activity.getWindow().getDecorView().getWindowToken(), 0);
                return true;
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return false;
    }
}
