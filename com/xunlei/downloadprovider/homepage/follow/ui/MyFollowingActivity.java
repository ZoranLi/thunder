package com.xunlei.downloadprovider.homepage.follow.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.xllib.android.XLIntent;

public class MyFollowingActivity extends BaseActivity {
    public static void a(Context context) {
        context.startActivity(new XLIntent(context, MyFollowingActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_following);
        findViewById(R.id.titlebar_left).setOnClickListener(new ae(this));
        ((TextView) findViewById(R.id.titlebar_title)).setText("我的关注");
    }
}
