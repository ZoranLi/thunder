package com.xunlei.downloadprovider.member.register.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserUtil;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.c.h;
import com.xunlei.downloadprovider.member.register.a;

public class BindMobileActivity extends MobileSetupActivity {
    private XLOnUserListener c;
    private String d;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = getIntent().getStringExtra("from");
        new StringBuilder("mFrom: ").append(this.d);
        bundle = this.d;
        boolean z = LoginHelper.a().b.d;
        StatEvent build = HubbleEventBuilder.build("android_login_third", "login_third_bind_show");
        build.add("type", z ? "register" : "login");
        build.add("from", bundle);
        a.a(build);
        if ("install_guide".equals(this.d) != null) {
            LoginHelper.a().b(this.a);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        StatEvent build = HubbleEventBuilder.build("android_login_third", "login_third_bind_back");
        build.add("clickid", "back");
        a.a(build);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!LoginHelper.a().b.d) {
            h a = h.a();
            int i = a.a.getInt(h.b(), 0);
            if (i <= 2) {
                a.a.edit().putInt(h.b(), i + 1).apply();
            }
        }
    }

    protected final String a() {
        return getString(R.string.bind_mobile_title);
    }

    protected final void a(TextView textView) {
        textView.setVisibility(8);
    }

    protected final void c() {
        if (i()) {
            b((int) R.string.bind_mobile_binding);
            XLUserUtil.getInstance().userAqBindMobile(d(), g(), this.c, null);
        }
    }

    public void finish() {
        setResult(-1);
        super.finish();
    }

    protected final void b() {
        a.a(HubbleEventBuilder.build("android_login_third", "login_third_bind_code"));
        if (i()) {
            if (this.c == null) {
                this.c = new q(this);
            }
            b((int) R.string.register_msg_sending_sms_waiting);
            XLUserUtil.getInstance().userAqSendMessage(d(), this.c, null);
        }
    }
}
