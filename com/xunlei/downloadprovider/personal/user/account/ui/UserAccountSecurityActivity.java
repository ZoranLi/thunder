package com.xunlei.downloadprovider.personal.user.account.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.message.proguard.k;
import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.a;
import com.xunlei.downloadprovider.personal.user.account.l;

public class UserAccountSecurityActivity extends BaseActivity {
    private View a;
    private TextView c;
    private View d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private View k;
    private LoginHelper l;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    private OnClickListener p = new aq(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_account_security);
        this.a = findViewById(R.id.titlebar_left);
        this.a.setOnClickListener(new an(this));
        this.c = (TextView) findViewById(R.id.titlebar_title);
        this.c.setText(R.string.user_account_security_title);
        this.d = findViewById(R.id.layout_mobile);
        this.d.setOnClickListener(new ao(this));
        this.e = (TextView) findViewById(R.id.tv_wechat_nickname);
        this.f = (TextView) findViewById(R.id.tv_qq_nickname);
        this.g = (TextView) findViewById(R.id.tv_weibo_nickname);
        this.h = (ImageView) findViewById(R.id.iv_wechat_toggle_btn);
        this.i = (ImageView) findViewById(R.id.iv_qq_toggle_btn);
        this.j = (ImageView) findViewById(R.id.iv_weibo_toggle_btn);
        this.h.setOnClickListener(this.p);
        this.i.setOnClickListener(this.p);
        this.j.setOnClickListener(this.p);
        this.k = findViewById(R.id.layout_modify_password);
        this.k.setOnClickListener(new ap(this));
        this.l = LoginHelper.a();
        bundle = l.a();
        int c = bundle.c(21);
        int c2 = bundle.c(15);
        int c3 = bundle.c(1);
        a(this.h, c);
        a(this.i, c2);
        a(this.j, c3);
        if (c != -1) {
            a(21, bundle.b(21));
        }
        if (c2 != -1) {
            a(15, bundle.b(15));
        }
        if (c3 != -1) {
            a(1, bundle.b(1));
        }
        this.l.a(new am(this));
    }

    private void a(View view, int i) {
        int i2 = R.drawable.toggle_btn_on;
        if (i == 1) {
            view.setBackgroundResource(R.drawable.toggle_btn_on);
            view.setOnClickListener(new at(this));
            return;
        }
        if (i != 0) {
            i2 = R.drawable.toggle_btn_off;
        }
        view.setBackgroundResource(i2);
    }

    private void a(int i, String str) {
        i = i != 1 ? i != 15 ? i != 21 ? 0 : this.e : this.f : this.g;
        if (i != 0) {
            if (TextUtils.isEmpty(str)) {
                i.setVisibility(8);
            } else {
                i.setVisibility(0);
                StringBuilder stringBuilder = new StringBuilder(k.s);
                stringBuilder.append(str);
                stringBuilder.append(k.t);
                i.setText(stringBuilder.toString());
            }
        }
    }

    static /* synthetic */ XLBindedOtherAccountItem[] a(XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr) {
        XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr2 = new XLBindedOtherAccountItem[]{new XLBindedOtherAccountItem(21, -1), new XLBindedOtherAccountItem(15, -1), new XLBindedOtherAccountItem(1, -1)};
        for (XLBindedOtherAccountItem xLBindedOtherAccountItem : xLBindedOtherAccountItemArr) {
            int i = xLBindedOtherAccountItem.mThirdTypeId;
            if (i == 1) {
                xLBindedOtherAccountItemArr2[2] = xLBindedOtherAccountItem;
            } else if (i == 15) {
                xLBindedOtherAccountItemArr2[1] = xLBindedOtherAccountItem;
            } else if (i == 21) {
                xLBindedOtherAccountItemArr2[0] = xLBindedOtherAccountItem;
            }
        }
        return xLBindedOtherAccountItemArr2;
    }

    static /* synthetic */ void a(TextView textView, int i) {
        if (i == -1) {
            textView.setText("");
        }
    }

    static /* synthetic */ void a(UserAccountSecurityActivity userAccountSecurityActivity, View view, int i, int i2) {
        if (i2 == -1) {
            StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_third_bind");
            build.add("account_type", com.xunlei.downloadprovider.personal.user.account.k.a(i));
            com.xunlei.downloadprovider.personal.user.account.k.a(build);
            userAccountSecurityActivity.l.a(i, new ar(userAccountSecurityActivity, view));
            return;
        }
        if (i2 == 0) {
            build = HubbleEventBuilder.build("android_personal_account", "account_third_unbind");
            build.add("account_type", com.xunlei.downloadprovider.personal.user.account.k.a(i));
            com.xunlei.downloadprovider.personal.user.account.k.a(build);
            i2 = userAccountSecurityActivity.l;
            i2.m = new as(userAccountSecurityActivity, view);
            a.a(i, i2.q);
        }
    }

    static /* synthetic */ void a(UserAccountSecurityActivity userAccountSecurityActivity, int i, int i2) {
        if (i == 1) {
            userAccountSecurityActivity.o = i2;
        } else if (i == 15) {
            userAccountSecurityActivity.n = i2;
        } else if (i == 21) {
            userAccountSecurityActivity.m = i2;
        }
    }
}
