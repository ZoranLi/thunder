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
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.publiser.common.GenderInfo;
import com.xunlei.xllib.android.XLIntent;

public class FansActivity extends BaseActivity {
    private static final String a = "FansActivity";
    private FansFragment c;
    private TextView d;
    private View e;
    private long f;
    private GenderInfo g;
    private TextView h;
    private boolean i;
    private BroadcastReceiver j = new i(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fans_item_layout);
        this.d = (TextView) findViewById(R.id.speed_detection_headerbar).findViewById(R.id.titlebar_title);
        this.h = (TextView) findViewById(R.id.speed_detection_headerbar).findViewById(R.id.tv_num);
        this.e = findViewById(R.id.speed_detection_headerbar).findViewById(R.id.titlebar_left);
        this.e.setOnClickListener(new j(this));
        this.f = getIntent().getLongExtra(SocializeConstants.TENCENT_UID, -1);
        this.g = (GenderInfo) getIntent().getSerializableExtra("user_sex");
        String stringExtra = getIntent().getStringExtra("fans_page_from");
        if (!TextUtils.isEmpty(stringExtra)) {
            a.a(stringExtra);
        }
        if (this.f == LoginHelper.a().g.c()) {
            this.d.setText("我的粉丝");
        } else if (this.g == GenderInfo.MALE || this.g != GenderInfo.FEMALE) {
            this.d.setText("他的粉丝");
        } else {
            this.d.setText("她的粉丝");
        }
        this.c = FansFragment.a(this.f);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, this.c).commit();
        bundle = new IntentFilter();
        bundle.addAction("following_id_list_loaded");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.j, bundle);
    }

    protected void onResume() {
        super.onResume();
        this.i = false;
    }

    protected void onPause() {
        super.onPause();
        this.i = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.j);
    }

    public static void a(Context context, long j, String str) {
        a(context, j, null, str);
    }

    public static void a(Context context, long j, GenderInfo genderInfo, String str) {
        Intent xLIntent = new XLIntent(context, FansActivity.class);
        xLIntent.putExtra(SocializeConstants.TENCENT_UID, j);
        xLIntent.putExtra("user_sex", genderInfo);
        xLIntent.putExtra("fans_page_from", str);
        context.startActivity(xLIntent);
    }
}
