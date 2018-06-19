package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.recommend.fans.a.h;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.publiser.common.GenderInfo;
import com.xunlei.xllib.android.XLIntent;

public class FollowActivity extends BaseActivity {
    private static final String a = "FollowActivity";
    private FollowFragment c;
    private TextView d;
    private View e;
    private long f;
    private GenderInfo g;
    private aa h;
    private BroadcastReceiver i = new q(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fans_item_layout);
        this.d = (TextView) findViewById(R.id.speed_detection_headerbar).findViewById(R.id.titlebar_title);
        this.e = findViewById(R.id.speed_detection_headerbar).findViewById(R.id.titlebar_left);
        this.e.setOnClickListener(new s(this));
        this.f = getIntent().getLongExtra(SocializeConstants.TENCENT_UID, -1);
        this.g = (GenderInfo) getIntent().getSerializableExtra("user_sex");
        String stringExtra = getIntent().getStringExtra("follow_page_from");
        if (!TextUtils.isEmpty(stringExtra)) {
            h.a(stringExtra);
        }
        if (this.f == LoginHelper.a().g.c()) {
            this.d.setText("我的关注");
        } else if (this.g == GenderInfo.MALE || this.g != GenderInfo.FEMALE) {
            this.d.setText("他的关注");
        } else {
            this.d.setText("她的关注");
        }
        this.c = FollowFragment.a(this.f);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, this.c).commit();
        if (this.h == null) {
            this.h = new r(this);
        }
        ab.a().a(this.h);
        bundle = new IntentFilter();
        bundle.addAction("following_id_list_loaded");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.i, bundle);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            ab.a().b(this.h);
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.i);
    }

    public static void a(Context context, long j, String str) {
        a(context, j, null, str);
    }

    public static void a(Context context, long j, GenderInfo genderInfo, String str) {
        Intent xLIntent = new XLIntent(context, FollowActivity.class);
        xLIntent.putExtra(SocializeConstants.TENCENT_UID, j);
        xLIntent.putExtra("user_sex", genderInfo);
        xLIntent.putExtra("follow_page_from", str);
        context.startActivity(xLIntent);
    }

    static /* synthetic */ void a(FollowActivity followActivity, String str) {
        if (followActivity.c != null) {
            followActivity.c.a(str);
        }
    }
}
