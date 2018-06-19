package com.alibaba.sdk.android.feedback.windvane;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;

class c implements OnClickListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ CustomHybirdActivity b;

    c(CustomHybirdActivity customHybirdActivity, TextView textView) {
        this.b = customHybirdActivity;
        this.a = textView;
    }

    public void onClick(View view) {
        CustomHybirdActivity.access$204(this.b);
        if (this.b.mTitleClickCount == 10) {
            String str = (String) FeedbackAPI.mFeedbackCustomInfoMap.get("uid");
            if (!TextUtils.isEmpty(str)) {
                this.a.setText(str);
            }
        }
    }
}
