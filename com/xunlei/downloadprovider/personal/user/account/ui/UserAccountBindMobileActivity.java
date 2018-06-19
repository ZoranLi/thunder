package com.xunlei.downloadprovider.personal.user.account.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.user.account.k;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import com.xunlei.downloadprovider.web.base.core.ag;
import com.xunlei.xllib.android.XLIntent;

public class UserAccountBindMobileActivity extends CustomWebViewActivity {
    private boolean i;
    private String j;
    private String k = "cancel";
    private boolean l = false;
    private ag m = new b(this);

    public static void a(Context context, String str) {
        Intent xLIntent = new XLIntent(context, UserAccountBindMobileActivity.class);
        xLIntent.putExtra("url", "http://aq.xunlei.com/wap/account_check.html");
        xLIntent.putExtra("title", "绑定手机号");
        xLIntent.putExtra("is_bind", TextUtils.isEmpty(LoginHelper.a().i()) ^ 1);
        xLIntent.putExtra("from", str);
        context.startActivity(xLIntent);
    }

    public static void a(Context context, boolean z, String str) {
        Intent xLIntent = new XLIntent(context, UserAccountBindMobileActivity.class);
        xLIntent.putExtra("url", "http://aq.xunlei.com/wap/account_check.html");
        xLIntent.putExtra("title", "绑定手机号");
        xLIntent.putExtra("is_bind", z);
        xLIntent.putExtra("from", str);
        context.startActivity(xLIntent);
    }

    protected final void a() {
        setContentView(R.layout.activity_user_account_bind_mobile);
        Intent intent = getIntent();
        this.i = intent.getBooleanExtra("is_bind", false);
        this.j = intent.getStringExtra("from");
        this.f = (CustomWebView) findViewById(R.id.webView);
        this.f.setWebChromeClient(this.e);
        this.f.a(new a(this));
        this.f.a(this.m);
        b();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.k.equals("cancel")) {
            k.a(this.i, this.j, "cancel", 0);
        }
    }

    static /* synthetic */ void a(UserAccountBindMobileActivity userAccountBindMobileActivity, int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("onBindMobileComplete() errorCode=");
        stringBuilder.append(i);
        stringBuilder.append(" errDesc=");
        stringBuilder.append(str);
        if (i == 0) {
            LoginHelper.a().b();
            userAccountBindMobileActivity.k = "success";
            k.a(userAccountBindMobileActivity.i, userAccountBindMobileActivity.j, "success", i);
            userAccountBindMobileActivity.finish();
            return;
        }
        XLToast.showToast(userAccountBindMobileActivity, "绑定手机号失败");
        userAccountBindMobileActivity.k = "fail";
        k.a(userAccountBindMobileActivity.i, userAccountBindMobileActivity.j, "fail", i);
    }
}
