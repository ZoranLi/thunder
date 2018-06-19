package com.alibaba.sdk.android.feedback.impl;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.R;

public class ErrorPageActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CharSequence stringExtra = getIntent().getStringExtra("errorMsg");
        setContentView(R.layout.ali_feedback_error);
        TextView textView = (TextView) findViewById(R.id.errorMsg);
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "出错了！请稍后再试";
        }
        textView.setText(stringExtra);
        ((Button) findViewById(R.id.error_view_refresh_btn)).setOnClickListener(new b(this));
    }
}
