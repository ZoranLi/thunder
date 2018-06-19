package com.xunlei.downloadprovider.personal.user.account.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.xllib.android.XLIntent;

public class UserAccountCurrentMobileActivity extends BaseActivity {
    private TextView a;
    private LoginHelper c = LoginHelper.a();
    private h d;

    public static void a(Context context) {
        context.startActivity(new XLIntent(context, UserAccountCurrentMobileActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_accout_current_mobile);
        ((TextView) findViewById(R.id.titlebar_title)).setText("绑定手机号");
        findViewById(R.id.titlebar_left).setOnClickListener(new d(this));
        findViewById(R.id.btn_change_mobile).setOnClickListener(new e(this));
        this.a = (TextView) findViewById(R.id.tv_current_mobile);
        bundle = new StringBuilder("你的手机号：");
        bundle.append(this.c.i());
        this.a.setText(bundle.toString());
        this.d = new f(this);
        this.c.a(this.d);
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_personal_account", "account_phone_conf_show"));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.c.b(this.d);
    }
}
