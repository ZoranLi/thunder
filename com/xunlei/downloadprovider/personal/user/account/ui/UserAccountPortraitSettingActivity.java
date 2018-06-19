package com.xunlei.downloadprovider.personal.user.account.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xunlei.common.androidutil.HandlerUtil$MessageListener;
import com.xunlei.common.androidutil.HandlerUtil$StaticHandler;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.common.new_ptl.member.XLUserUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.e$h;
import com.xunlei.downloadprovider.member.login.b.i;
import com.xunlei.downloadprovider.personal.user.account.h;
import com.xunlei.downloadprovider.personal.user.account.l;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.xllib.android.XLIntent;

public class UserAccountPortraitSettingActivity extends BaseActivity {
    public static String a = "refreshPortrait";
    private final int c = 107;
    private HandlerUtil$StaticHandler d;
    private h e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private boolean m;
    private int n = -1;
    private int o = -1;
    private int p = -1;
    private LoginHelper q = LoginHelper.a();
    private final com.xunlei.downloadprovider.member.login.b.h r = new al(this);
    private HandlerUtil$MessageListener s = new ac(this);
    private e$h t = new ad(this);

    private static boolean b(int i) {
        if (i != 0) {
            if (1 != i) {
                return false;
            }
        }
        return true;
    }

    protected final boolean q_() {
        return false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = new h(this, getApplicationContext());
        setContentView(R.layout.activity_user_account_portrait);
        this.f = (ImageView) findViewById(R.id.user_account_portrait_iv);
        this.g = (ImageView) findViewById(R.id.iv_portrait_weixin);
        this.j = (ImageView) findViewById(R.id.iv_portrait_weixin_icon);
        this.h = (ImageView) findViewById(R.id.iv_portrait_qq);
        this.k = (ImageView) findViewById(R.id.iv_portrait_qq_icon);
        this.i = (ImageView) findViewById(R.id.iv_portrait_weibo);
        this.l = (ImageView) findViewById(R.id.iv_portrait_weibo_icon);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.title_layout);
        TitleBar titleBar = new TitleBar(this);
        titleBar.mLayout = viewGroup;
        titleBar.mLayout.setBackgroundColor(0);
        titleBar.mLayout.findViewById(R.id.xreader_common_divide).setVisibility(8);
        titleBar.mLayout.findViewById(R.id.white_button_line).setVisibility(8);
        titleBar.mLeft.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_left_arrow_selector, null));
        titleBar.mTitle.setText(getResources().getString(R.string.user_account_title_bar_portrait));
        titleBar.mTitle.setTextColor(-1);
        this.f.setOnClickListener(new ab(this));
        this.g.setOnClickListener(new ae(this));
        this.h.setOnClickListener(new af(this));
        this.i.setOnClickListener(new ag(this));
        a();
        this.e.a(this.q.e(), this.f, false);
        this.q.a(new ak(this, l.a().a(21), l.a().a(15), l.a().a(1)));
    }

    protected final int e() {
        return getResources().getColor(R.color.common_blue);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.e.getClass();
        if (i == 1001) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                m.b((Context) this);
            } else {
                this.e.b("account_center");
            }
        }
    }

    private void a() {
        this.q.a(this.r);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.e.a(i, i2, intent, "account_center");
        this.m = true;
        super.onActivityResult(i, i2, intent);
    }

    protected void onResume() {
        super.onResume();
        a();
        this.q.l = this.t;
        this.d = new HandlerUtil$StaticHandler(this.s);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.q.b(this.r);
    }

    static /* synthetic */ void a(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity, boolean z, int i, ImageView imageView, ImageView imageView2) {
        if (z) {
            z = userAccountPortraitSettingActivity.q;
            z.n = new ai(userAccountPortraitSettingActivity, imageView, imageView2, i);
            userAccountPortraitSettingActivity = z.g;
            XLOnUserListener xLOnUserListener = z.q;
            userAccountPortraitSettingActivity = "";
            if (i == true) {
                userAccountPortraitSettingActivity = "http://m.xunlei.com";
            } else if (i == true || i == true) {
                userAccountPortraitSettingActivity = "";
            }
            XLUserUtil.getInstance().userGetOtherAccountInfo(i, i.b(i), userAccountPortraitSettingActivity, xLOnUserListener, null);
            return;
        }
        userAccountPortraitSettingActivity.q.a(i, new ah(userAccountPortraitSettingActivity, imageView, imageView2, i));
    }

    static /* synthetic */ void a(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity, int i) {
        if (i == 1) {
            userAccountPortraitSettingActivity.p = 0;
        } else if (i == 15) {
            userAccountPortraitSettingActivity.o = 0;
        } else if (i == 21) {
            userAccountPortraitSettingActivity.n = 0;
        }
    }

    static /* synthetic */ void a(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity, XLThirdUserInfo xLThirdUserInfo, ImageView imageView, ImageView imageView2, int i) {
        int i2;
        if (!userAccountPortraitSettingActivity.isFinishing()) {
            if (VERSION.SDK_INT < 17 || !userAccountPortraitSettingActivity.isDestroyed()) {
                i2 = 0;
                if (i2 == 0 && userAccountPortraitSettingActivity.e != null) {
                    userAccountPortraitSettingActivity.m = true;
                    String stringValue = xLThirdUserInfo.getStringValue("headimgurl");
                    String stringValue2 = xLThirdUserInfo.getStringValue("nickname");
                    String stringValue3 = xLThirdUserInfo.getStringValue("gender");
                    userAccountPortraitSettingActivity.e.a(stringValue, imageView, true);
                    imageView2.setVisibility(0);
                    XLThreadPool.execute(new aj(userAccountPortraitSettingActivity, i, stringValue, stringValue2, stringValue3));
                    return;
                }
            }
        }
        i2 = true;
        if (i2 == 0) {
        }
    }

    static /* synthetic */ void a(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity, String str, int i, ImageView imageView, ImageView imageView2) {
        if (userAccountPortraitSettingActivity.e != null && str != null && b(i) != 0) {
            userAccountPortraitSettingActivity.e.a(str, imageView, false);
            imageView2.setVisibility(0);
        }
    }

    static /* synthetic */ void n(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity) {
        Intent xLIntent = new XLIntent();
        xLIntent.putExtra(a, true);
        userAccountPortraitSettingActivity.setResult(101, xLIntent);
    }
}
