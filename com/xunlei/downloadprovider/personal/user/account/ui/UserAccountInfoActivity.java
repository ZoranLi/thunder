package com.xunlei.downloadprovider.personal.user.account.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.XLSexType;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.login.b.i;
import com.xunlei.downloadprovider.member.login.b.k;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.user.account.a.b;
import com.xunlei.downloadprovider.personal.user.account.address.b.d;
import com.xunlei.downloadprovider.personal.user.account.address.ui.UserRegionSelectProvinceActivity;
import com.xunlei.downloadprovider.personal.user.account.c;
import com.xunlei.downloadprovider.personal.user.account.l;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.personal.user.account.view.UserAccountItem;
import com.xunlei.downloadprovider.publiser.common.a.a;
import com.xunlei.xllib.android.XLIntent;

public class UserAccountInfoActivity extends BaseActivity {
    private k A = new o(this);
    private final String a = "user_data_sexy";
    private final String c = "user_data_birthday";
    private final int d = 101;
    private final int e = 105;
    private UserAccountItem f;
    private UserAccountItem g;
    private UserAccountItem h;
    private UserAccountItem i;
    private UserAccountItem j;
    private UserAccountItem k;
    private UserAccountItem l;
    private UserAccountItem m;
    private UserAccountItem n;
    private UserAccountItem o;
    private UserAccountItem p;
    private boolean q;
    private boolean r = false;
    private int s = -1;
    private int t;
    private LoginHelper u = LoginHelper.a();
    private XLSexType v;
    private StaticHandler w;
    private TitleBar x;
    private final h y = new w(this);
    private MessageListener z = new n(this);

    protected void onCreate(Bundle bundle) {
        StatEvent build;
        super.onCreate(bundle);
        d.a();
        if (d.b() == null) {
            i.b(LoginHelper.a().q);
        }
        setContentView(R.layout.activity_user_account_new);
        this.f = (UserAccountItem) findViewById(R.id.user_account_portrait);
        this.f.setAccountItemName(R.string.user_account_item_name_portrait);
        this.f.setItemTipPicVisibility(0);
        this.g = (UserAccountItem) findViewById(R.id.user_account_nickname);
        this.g.setAccountItemName(R.string.user_account_item_name_nickname);
        this.g.setItemTipPicVisibility(8);
        this.h = (UserAccountItem) findViewById(R.id.user_account_sexuality);
        this.h.setAccountItemName(R.string.user_account_item_name_sexuality);
        this.h.setItemTipPicVisibility(8);
        this.i = (UserAccountItem) findViewById(R.id.user_account_birthday);
        this.i.setAccountItemName(R.string.user_account_item_name_birthday);
        this.i.setItemTipPicVisibility(8);
        this.j = (UserAccountItem) findViewById(R.id.user_account_address);
        this.j.setAccountItemName(R.string.user_account_item_name_address);
        this.j.setItemTipPicVisibility(8);
        this.k = (UserAccountItem) findViewById(R.id.user_account_signature);
        this.k.setAccountItemName(R.string.user_account_item_name_signature);
        this.k.setItemTipPicVisibility(8);
        this.m = (UserAccountItem) findViewById(R.id.user_account_phone);
        this.m.setItemTipPicVisibility(8);
        this.m.setAccountItemName(R.string.user_account_item_name_phone);
        d();
        this.n = (UserAccountItem) findViewById(R.id.user_account_safe);
        this.s = l.a().c(21);
        this.n.setItemTipTextVisibility(0);
        this.n.setItemTipPic(R.drawable.third_weixin_circle);
        a(this.s);
        this.n.setAccountItemName(R.string.user_account_item_name_safe);
        this.u.a(new s(this));
        this.l = (UserAccountItem) findViewById(R.id.user_account_uid);
        this.l.setAccountItemName(R.string.user_account_item_name_uid);
        this.l.setItemGoVisibility(4);
        this.l.setItemTipPicVisibility(8);
        this.l.setItemTipText(String.valueOf(this.u.g.c()));
        this.o = (UserAccountItem) findViewById(R.id.user_account_password);
        com.xunlei.downloadprovider.member.login.c.h.a().a.getBoolean("key_third_login", false);
        this.o.setVisibility(8);
        this.o.setItemTipTextVisibility(8);
        this.o.setItemTipPicVisibility(8);
        this.o.setAccountItemName(R.string.user_account_item_name_password);
        this.p = (UserAccountItem) findViewById(R.id.user_account_member_info);
        if (this.u.l() != null) {
            this.p.setVisibility(0);
            this.p.setItemTipTextVisibility(8);
            this.p.setItemTipPicVisibility(8);
            this.p.setAccountItemName(R.string.user_account_item_name_info);
        } else {
            this.p.setVisibility(8);
        }
        this.x = new TitleBar((Activity) this);
        this.x.mTitle.setText(getResources().getString(R.string.user_account_title_bar_info));
        bundle = new m(this);
        OnLongClickListener pVar = new p(this);
        this.x.mTitle.setOnClickListener(new q(this));
        this.f.setOnClickListener(bundle);
        this.g.setOnClickListener(bundle);
        this.h.setOnClickListener(bundle);
        this.i.setOnClickListener(bundle);
        this.j.setOnClickListener(bundle);
        this.k.setOnClickListener(bundle);
        this.m.setOnClickListener(bundle);
        this.n.setOnClickListener(bundle);
        this.l.setOnLongClickListener(pVar);
        this.o.setOnClickListener(bundle);
        this.p.setOnClickListener(bundle);
        a();
        this.u.b();
        String e = this.u.e();
        this.u.l();
        b(e);
        b();
        this.t = a(this.u.g());
        if (this.t != -1) {
            this.h.setItemTipText(this.t);
            if (!(this.t == R.string.user_account_sexuality_male || this.t == R.string.user_account_sexuality_female)) {
                this.h.setItemTipIconVisibility(4);
            }
            h();
            g();
            c();
            bundle = getIntent().getStringExtra("extra_from");
            build = HubbleEventBuilder.build("android_personal_account", "account_conf_show");
            build.add("from", bundle);
            com.xunlei.downloadprovider.personal.user.account.k.a(build);
        }
        a(this.h, (int) R.string.user_account_set_default);
        h();
        g();
        c();
        bundle = getIntent().getStringExtra("extra_from");
        build = HubbleEventBuilder.build("android_personal_account", "account_conf_show");
        build.add("from", bundle);
        com.xunlei.downloadprovider.personal.user.account.k.a(build);
    }

    private void a() {
        this.u.a(this.y);
    }

    private void a(int i) {
        if (i != -1) {
            this.n.setItemTipPic(R.drawable.third_weixin_circle);
        } else {
            this.n.setItemTipPic(R.drawable.third_weixin_circle_gray);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 101) {
            if (intent != null) {
                this.q = intent.getBooleanExtra(UserAccountPortraitSettingActivity.a, 0);
            }
        }
    }

    private static void a(UserAccountItem userAccountItem, int i) {
        userAccountItem.setItemTipTextVisibility(0);
        userAccountItem.setItemTipText(i);
        userAccountItem.setItemTipTextColor(Color.parseColor("#1294f6"));
    }

    private static void a(UserAccountItem userAccountItem, String str) {
        userAccountItem.setItemTipText(str);
        userAccountItem.setItemTipTextColor(Color.parseColor("#999999"));
    }

    private static void b(UserAccountItem userAccountItem, int i) {
        userAccountItem.setItemTipText(i);
        userAccountItem.setItemTipTextColor(Color.parseColor("#999999"));
    }

    private void b() {
        String d = this.u.g.d();
        if (m.a(d)) {
            a(this.g, (int) R.string.user_account_nickname_default);
        } else {
            a(this.g, d);
        }
    }

    private void c() {
        String j = this.u.j();
        Object k = this.u.k();
        if (TextUtils.isEmpty(j) && TextUtils.isEmpty(k)) {
            a(this.j, (int) R.string.user_account_address_default);
            return;
        }
        if (j.equals(k)) {
            j = a.b(j);
        } else {
            String a = a.a(k);
            j = a.b(j);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(a);
            j = stringBuilder.toString();
        }
        a(this.j, j);
    }

    private void d() {
        String i = this.u.i();
        if (TextUtils.isEmpty(i)) {
            a(this.m, (int) R.string.user_account_protection);
        } else {
            this.m.setItemTipText(i);
        }
    }

    private void g() {
        String h = this.u.h();
        if (TextUtils.isEmpty(h)) {
            a(this.k, (int) R.string.user_account_signature_default);
        } else {
            a(this.k, h);
        }
    }

    private void h() {
        String f = this.u.f();
        String str = "";
        if (!TextUtils.isEmpty(f) && f.length() == 8) {
            str = m.a(Integer.valueOf(f.substring(4, 6)).intValue(), Integer.valueOf(f.substring(6, 8)).intValue());
        }
        if (TextUtils.isEmpty(str)) {
            a(this.i, (int) R.string.user_account_birthday_default);
        } else {
            a(this.i, str);
        }
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str.trim())) {
                m.a(str, this.f.getAccountItemTipPic());
            }
        }
    }

    protected void onResume() {
        super.onResume();
        a();
        this.w = new StaticHandler(this.z);
        this.u.a(this.A);
        if (this.q) {
            this.u.b();
        }
        this.s = l.a().c(21);
        a(this.s);
        if (!this.r) {
            com.xunlei.downloadprovider.personal.user.account.k.d("cancel");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.u.b(this.y);
        this.u.b(this.A);
        if (this.w != null) {
            this.w.removeCallbacksAndMessages(null);
        }
    }

    public static void a(Context context, String str) {
        Intent xLIntent = new XLIntent();
        xLIntent.putExtra("extra_from", str);
        xLIntent.setClass(context, UserAccountInfoActivity.class);
        context.startActivity(xLIntent);
    }

    private static int a(XLSexType xLSexType) {
        if (XLSexType.UNKNOWN.equals(xLSexType)) {
            return R.string.user_account_unknown;
        }
        if (XLSexType.MALE.equals(xLSexType)) {
            return R.string.user_account_sexuality_male;
        }
        return XLSexType.FEMALE.equals(xLSexType) != null ? R.string.user_account_sexuality_female : -1;
    }

    static /* synthetic */ void a(UserAccountInfoActivity userAccountInfoActivity) {
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(userAccountInfoActivity, UserAccountPortraitSettingActivity.class);
        userAccountInfoActivity.startActivityForResult(xLIntent, 101);
    }

    static /* synthetic */ void c(UserAccountInfoActivity userAccountInfoActivity) {
        b uVar = new u(userAccountInfoActivity);
        com.xunlei.downloadprovider.personal.user.account.a.a vVar = new v(userAccountInfoActivity);
        CharSequence string = userAccountInfoActivity.getString(R.string.user_account_sexuality_male);
        CharSequence string2 = userAccountInfoActivity.getString(R.string.user_account_sexuality_female);
        userAccountInfoActivity = com.xunlei.downloadprovider.personal.user.account.a.a(userAccountInfoActivity, R.layout.alert_notitle_twice);
        vVar.a((ImageView) userAccountInfoActivity.findViewById(R.id.item_first_iv), (ImageView) userAccountInfoActivity.findViewById(R.id.item_second_iv));
        userAccountInfoActivity.findViewById(R.id.cancel).setOnClickListener(new com.xunlei.downloadprovider.personal.user.account.b(userAccountInfoActivity, uVar));
        RelativeLayout relativeLayout = (RelativeLayout) userAccountInfoActivity.findViewById(R.id.item_rl_first);
        ((TextView) userAccountInfoActivity.findViewById(R.id.item_first)).setText(string);
        relativeLayout.setOnClickListener(new c(userAccountInfoActivity, uVar));
        RelativeLayout relativeLayout2 = (RelativeLayout) userAccountInfoActivity.findViewById(R.id.item_rl_second);
        ((TextView) userAccountInfoActivity.findViewById(R.id.item_second)).setText(string2);
        relativeLayout2.setOnClickListener(new com.xunlei.downloadprovider.personal.user.account.d(userAccountInfoActivity, uVar));
        userAccountInfoActivity.show();
    }

    static /* synthetic */ void d(UserAccountInfoActivity userAccountInfoActivity) {
        com.xunlei.downloadprovider.personal.user.account.view.a aVar = new com.xunlei.downloadprovider.personal.user.account.view.a(userAccountInfoActivity, userAccountInfoActivity.u.f());
        aVar.a = new t(userAccountInfoActivity, aVar);
        aVar.show();
    }

    static /* synthetic */ void e(UserAccountInfoActivity userAccountInfoActivity) {
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(userAccountInfoActivity, UserRegionSelectProvinceActivity.class);
        userAccountInfoActivity.startActivity(xLIntent);
        com.xunlei.downloadprovider.personal.user.account.k.a(HubbleEventBuilder.build("android_personal_account", "account_place_conf"));
    }

    static /* synthetic */ void f(UserAccountInfoActivity userAccountInfoActivity) {
        UserAccountEditActivity.a(userAccountInfoActivity, 2);
        com.xunlei.downloadprovider.personal.user.account.k.a(HubbleEventBuilder.build("android_personal_account", "account_sign_conf"));
    }

    static /* synthetic */ void h(UserAccountInfoActivity userAccountInfoActivity) {
        LoginHelper loginHelper = userAccountInfoActivity.u;
        loginHelper.o = new r(userAccountInfoActivity);
        com.xunlei.downloadprovider.member.login.b.a.a(loginHelper.q);
    }

    static /* synthetic */ void i(UserAccountInfoActivity userAccountInfoActivity) {
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(userAccountInfoActivity, UserAccountMemberActivity.class);
        userAccountInfoActivity.startActivity(xLIntent);
    }

    static /* synthetic */ void j(UserAccountInfoActivity userAccountInfoActivity) {
        CharSequence itemTipText = userAccountInfoActivity.l.getItemTipText();
        userAccountInfoActivity = userAccountInfoActivity.getBaseContext();
        Toast.makeText(userAccountInfoActivity, R.string.successfully_copy_to_clipboard, 0).show();
        ((ClipboardManager) userAccountInfoActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("uid", itemTipText));
    }

    static /* synthetic */ void o(UserAccountInfoActivity userAccountInfoActivity) {
        if (!userAccountInfoActivity.isFinishing()) {
            userAccountInfoActivity.b();
            userAccountInfoActivity.t = a(userAccountInfoActivity.u.g());
            String e = userAccountInfoActivity.u.e();
            userAccountInfoActivity.u.l();
            userAccountInfoActivity.b(e);
            userAccountInfoActivity.h();
            userAccountInfoActivity.g();
            userAccountInfoActivity.c();
            userAccountInfoActivity.d();
        }
    }

    static /* synthetic */ void p(UserAccountInfoActivity userAccountInfoActivity) {
        if (userAccountInfoActivity.v != null) {
            if (userAccountInfoActivity.v.equals(XLSexType.MALE)) {
                b(userAccountInfoActivity.h, (int) R.string.user_account_sexuality_male);
                userAccountInfoActivity.t = R.string.user_account_sexuality_male;
                com.xunlei.downloadprovider.personal.user.account.k.c("success", IChatUser.GENDER_MALE);
            } else if (userAccountInfoActivity.v.equals(XLSexType.FEMALE)) {
                b(userAccountInfoActivity.h, (int) R.string.user_account_sexuality_female);
                userAccountInfoActivity.t = R.string.user_account_sexuality_female;
                com.xunlei.downloadprovider.personal.user.account.k.c("success", IChatUser.GENDER_FEMALE);
            }
        }
    }

    static /* synthetic */ void a(String str) {
        if (str != null) {
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != 1203681492) {
                if (hashCode == 1218470398) {
                    if (str.equals("user_data_birthday") != null) {
                        obj = 1;
                    }
                }
            } else if (str.equals("user_data_sexy") != null) {
                obj = null;
            }
            switch (obj) {
                case null:
                    com.xunlei.downloadprovider.personal.user.account.k.c("fail", null);
                    return;
                case 1:
                    com.xunlei.downloadprovider.personal.user.account.k.a("fail");
                    break;
                default:
                    break;
            }
        }
    }
}
