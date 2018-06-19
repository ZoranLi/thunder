package com.xunlei.downloadprovider.publiser.per;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteEditActivity;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.recommend.fans.FansActivity;
import com.xunlei.downloadprovider.homepage.recommend.fans.FollowActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.f;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.publiser.common.AvatarActivity;
import com.xunlei.downloadprovider.publiser.common.GenderInfo;
import com.xunlei.downloadprovider.publiser.common.PublisherInfo;
import com.xunlei.downloadprovider.publiser.common.h;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.downloadprovider.publiser.common.view.PublisherBottomFollowBtn;
import com.xunlei.downloadprovider.publiser.common.view.PublisherFollowBtn;
import com.xunlei.downloadprovider.publiser.common.view.PublisherUserInfoTagView;
import com.xunlei.downloadprovider.publiser.visitors.model.Gender;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.g;
import com.xunlei.downloadprovidershare.k;
import com.xunlei.xllib.android.XLIntent;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.TnetStatusCode;

public class PublisherActivity extends BaseActivity implements OnOffsetChangedListener, OnClickListener, com.xunlei.downloadprovider.publiser.per.HistoryDynamicItemFragment.a, com.xunlei.downloadprovider.publiser.per.HistoryPublishItemFragment.a {
    private View A;
    private PublisherBottomFollowBtn B;
    private View C;
    private PagerSlidingTabStrip D;
    private TextView E;
    private TextView F;
    private a G;
    private HistoryDynamicItemFragment H;
    private HistoryPublishItemFragment I;
    private String J;
    private String K;
    private String L;
    private LoginHelper M = LoginHelper.a();
    private LocalBroadcastManager N;
    private BroadcastReceiver O;
    private b P;
    private aa Q;
    private long R = 0;
    private boolean S = false;
    private h T;
    private boolean U = false;
    private boolean V = false;
    private int W;
    private long X = 0;
    private k Y = new cg(this);
    private p Z = new ch(this);
    int a;
    int c;
    PublisherInfo d;
    UnifiedLoadingView e;
    ImageView f;
    PublisherUserInfoTagView g;
    TextView h;
    TextView i;
    ViewPager j;
    long k;
    String l;
    int m;
    boolean n = false;
    private AppBarLayout o;
    private ImageView p;
    private TextView q;
    private ImageView r;
    private ImageView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private View w;
    private View x;
    private PublisherFollowBtn y;
    private View z;

    private class a extends FragmentPagerAdapter {
        final /* synthetic */ PublisherActivity a;

        public final int getCount() {
            return 2;
        }

        private a(PublisherActivity publisherActivity, FragmentManager fragmentManager) {
            this.a = publisherActivity;
            super(fragmentManager);
        }

        public final Fragment getItem(int i) {
            switch (i) {
                case 0:
                    if (this.a.I == 0) {
                        this.a.I = HistoryPublishItemFragment.a(this.a.k, this.a.J, this.a.K, this.a.l, this.a.L);
                    }
                    return this.a.I;
                case 1:
                    if (this.a.H == 0) {
                        this.a.H = HistoryDynamicItemFragment.a(this.a.k, this.a.l);
                    }
                    return this.a.H;
                default:
                    return 0;
            }
        }
    }

    @Deprecated
    public static void a(Context context, From from, long j, String str, String str2, @NonNull String str3, boolean z) {
        Intent xLIntent = new XLIntent(context, PublisherActivity.class);
        xLIntent.putExtra(AgooConstants.MESSAGE_ID, j);
        xLIntent.putExtra("user_name", str);
        xLIntent.putExtra("user_kind", str2);
        xLIntent.putExtra("user_icon", str3);
        xLIntent.putExtra("user_from", from.getText());
        xLIntent.putExtra("dong_tai", z);
        context.startActivity(xLIntent);
    }

    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_personal_space);
        bundle = getIntent();
        this.k = bundle.getLongExtra(AgooConstants.MESSAGE_ID, -1);
        this.J = bundle.getStringExtra("user_name");
        this.l = bundle.getStringExtra("user_kind");
        this.K = bundle.getStringExtra("user_icon");
        this.L = bundle.getStringExtra("user_from");
        this.n = bundle.getBooleanExtra("dong_tai", false);
        this.P = b.a();
        this.T = new h();
        this.I = HistoryPublishItemFragment.a(this.k, this.J, this.K, this.l, this.L);
        this.H = HistoryDynamicItemFragment.a(this.k, this.l);
        this.O = new bx(this);
        this.N = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
        bundle = new IntentFilter();
        bundle.addAction("new_follow");
        bundle.addAction("cancel_follow");
        bundle.addAction("new_user_login_success");
        bundle.addAction("user_logout");
        bundle.addAction("following_id_list_loaded");
        bundle.addAction("action_start_follow_guide_animation");
        this.N.registerReceiver(this.O, bundle);
        if (this.Q == null) {
            this.Q = new by(this);
        }
        ab.a().a(this.Q);
        this.d = new PublisherInfo();
        this.p = (ImageView) findViewById(R.id.iv_back);
        this.p.setOnClickListener(new bt(this));
        this.q = (TextView) findViewById(R.id.tv_title);
        this.q.setVisibility(0);
        this.s = (ImageView) findViewById(R.id.iv_avatar);
        ViewCompat.setTransitionName(this.s, "avatar");
        this.s.setOnClickListener(new cf(this));
        if (TextUtils.isEmpty(this.K) == null) {
            a((Context) this, this.K, this.s);
        }
        this.f = (ImageView) findViewById(R.id.img_v);
        this.f.setOnClickListener(new cl(this));
        this.f.setVisibility(8);
        this.h = (TextView) findViewById(R.id.tv_living_id);
        this.g = (PublisherUserInfoTagView) findViewById(R.id.view_user_info_tag);
        this.t = (TextView) findViewById(R.id.tv_description);
        bundle = findViewById(R.id.layout_follow_count);
        View findViewById = findViewById(R.id.layout_fans_count);
        View findViewById2 = findViewById(R.id.layout_visit_count);
        this.v = (TextView) findViewById(R.id.tv_fans_count);
        this.u = (TextView) findViewById(R.id.tv_follow_count);
        this.i = (TextView) findViewById(R.id.tv_visitor_count);
        bundle.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        findViewById2.setOnClickListener(new cm(this));
        this.w = findViewById(R.id.tv_edit_personal_info);
        this.x = findViewById(R.id.layout_chat_follow_top);
        this.z = findViewById(R.id.layout_chat_top);
        this.y = (PublisherFollowBtn) findViewById(R.id.btn_follow_top);
        this.A = findViewById(R.id.layout_publisher_bottom_chat_follow);
        this.C = findViewById(R.id.layout_chat_bottom);
        this.B = (PublisherBottomFollowBtn) findViewById(R.id.btn_follow_bottom);
        this.z.setOnClickListener(new cn(this));
        this.y.setOnClickListener(new co(this));
        this.C.setOnClickListener(new cp(this));
        this.B.setOnClickListener(new cq(this));
        this.w.setOnClickListener(new cr(this));
        if (g() != null) {
            this.w.setVisibility(0);
            this.x.setVisibility(8);
            this.A.setVisibility(8);
        } else {
            this.w.setVisibility(8);
            this.x.setVisibility(0);
            this.A.setVisibility(8);
        }
        this.e = (UnifiedLoadingView) findViewById(R.id.lv_loading);
        this.e.setVisibility(0);
        this.e.setType(2);
        this.r = (ImageView) findViewById(R.id.iv_menu_more);
        this.r.setVisibility(0);
        this.r.setOnClickListener(new bu(this));
        this.o = (AppBarLayout) findViewById(R.id.lyt_appbar);
        this.t.setOnClickListener(this);
        a(this.J);
        b(this.K);
        if (LoginHelper.a().g.c() == this.k) {
            i();
        } else {
            d((String) null);
            this.y.setVisibility(0);
        }
        a(this.P.b(this.k));
        this.E = new TextView(this);
        this.E.setText("发布");
        this.E.setGravity(17);
        this.F = new TextView(this);
        this.F.setText("动态");
        this.F.setGravity(17);
        if (VERSION.SDK_INT >= 23) {
            this.E.setTextAppearance(R.style.TabTextStyle);
            this.F.setTextAppearance(R.style.TabTextStyle);
        } else {
            this.E.setTextAppearance(this, R.style.TabTextStyle);
            this.F.setTextAppearance(this, R.style.TabTextStyle);
        }
        this.D = (PagerSlidingTabStrip) findViewById(R.id.tb_fragment);
        this.D.a(this.E);
        this.D.a(this.F);
        this.j = (ViewPager) findViewById(R.id.vp_fragment);
        this.G = new a(getSupportFragmentManager());
        this.j.setAdapter(this.G);
        this.D.setViewPager(this.j);
        this.o.addOnOffsetChangedListener(this);
        this.j.addOnPageChangeListener(new bv(this));
        this.T.a(this.k, new bw(this));
    }

    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.n != null) {
            this.j.setCurrentItem(1, false);
            this.E.setSelected(false);
            this.F.setSelected(true);
            return;
        }
        this.j.setCurrentItem(0, false);
        this.E.setSelected(true);
        this.F.setSelected(false);
    }

    protected void onResume() {
        super.onResume();
        com.xunlei.downloadprovider.homepage.recommend.a.a(this.L, o.a(this.l), this.k);
        if (this.M.g.c() == this.k) {
            i();
        }
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        i = (Math.abs(i) * 100) / appBarLayout.getTotalScrollRange();
        if (LoginHelper.a().g.c() != this.k) {
            if (i <= 55 || this.A.getVisibility() == 0) {
                if (i < 55 && this.A.getVisibility() == null) {
                    this.A.setVisibility(8);
                }
                return;
            }
            this.A.setVisibility(0);
        }
    }

    final void a(boolean z) {
        this.y.setFollowStatus(z);
        this.B.setFollowStatus(z);
        b(true);
        d(z);
        this.d.b().a = z;
    }

    final void a(long j) {
        if (j >= 0) {
            this.R = j;
            this.u.setText(ConvertUtil.decimal2String(j, 10000, 10000, "万"));
        }
    }

    final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = TextUtils.isEmpty(this.J) == null ? this.J : "迅雷用户";
        }
        this.q.setText(str);
    }

    final void b(String str) {
        if (!(str == null || TextUtils.equals(str, this.K))) {
            if (!isFinishing()) {
                if (VERSION.SDK_INT < 17 || !isDestroyed()) {
                    this.K = str;
                    if (TextUtils.isEmpty(str) == null) {
                        a((Context) this, this.K, this.s);
                    }
                }
            }
        }
    }

    private static void a(Context context, String str, ImageView imageView) {
        Glide.with(context).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).fallback(R.drawable.ic_default_avatar).error(R.drawable.ic_default_avatar).placeholder(R.drawable.ic_default_avatar).dontAnimate().into(imageView);
    }

    private boolean d() {
        return this.d.b().a;
    }

    private void b(boolean z) {
        this.y.setEnabled(z);
        this.B.setEnabled(z);
    }

    private void c(boolean z) {
        this.z.setEnabled(z);
        this.C.setEnabled(z);
    }

    public final void c(String str) {
        b(false);
        if (this.P.b(this.k)) {
            this.P.a(this.k, new cd(this));
            return;
        }
        PublisherFollowBtn publisherFollowBtn = this.y;
        publisherFollowBtn.a.setVisibility(8);
        publisherFollowBtn.b.setVisibility(0);
        this.P.a(this.k, true, true, new ce(this, str));
    }

    private boolean g() {
        return this.k > 0 && this.k == this.M.g.c();
    }

    private String h() {
        if (this.d == null) {
            return "";
        }
        return this.d.a().getNewno();
    }

    private void i() {
        LoginHelper a = LoginHelper.a();
        b(a.e());
        a(a.g.d());
        this.g.a(a.j(), a.k(), Gender.parse(a.g()), a.f());
        d(a.h());
        if (g()) {
            this.w.setVisibility(0);
            this.x.setVisibility(8);
            this.A.setVisibility(8);
            return;
        }
        this.w.setVisibility(8);
        this.x.setVisibility(0);
    }

    final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "这个家伙太懒，什么都没留下。。。";
        }
        this.t.setText(str);
        this.t.setVisibility(0);
    }

    public void onClick(View view) {
        view = view.getId();
        if (R.id.layout_fans_count == view) {
            FansActivity.a(this, this.k, GenderInfo.castStringToGenderInfo(this.d.a().getSex()), "per_host_funnum");
            com.xunlei.downloadprovider.homepage.recommend.a.b("fans_num", o.a(this.l));
            return;
        }
        if (R.id.layout_follow_count == view) {
            FollowActivity.a(this, this.k, GenderInfo.castStringToGenderInfo(this.d.a().getSex()), "per_host_funnum");
            com.xunlei.downloadprovider.homepage.recommend.a.b("follow_num", o.a(this.l));
        }
    }

    public final void c(int i) {
        this.e.setVisibility(8);
        this.U = true;
        d(i);
        if (this.j.getCurrentItem() == 0) {
            com.xunlei.downloadprovider.homepage.recommend.a.a("public", this.c <= 0, this.c <= 0 ? 0 : (long) this.c);
        }
        if (this.S == 0 && this.V != 0 && this.c == 0 && this.e.getVisibility() == 8 && this.a > 0) {
            this.j.setCurrentItem(1, false);
        }
    }

    public final void d(int i) {
        this.c = i;
        if (i > 0) {
            this.E.setText(String.format("%s(%s)", new Object[]{"发布", ConvertUtil.decimal2String((long) i, 10000, 10000, "万")}));
            return;
        }
        this.E.setText("发布");
    }

    public final void b() {
        this.e.setVisibility(8);
        boolean z = false;
        this.U = false;
        String str = "public";
        if (this.c <= 0) {
            z = true;
        }
        com.xunlei.downloadprovider.homepage.recommend.a.a(str, z, this.c <= 0 ? 0 : (long) this.c);
    }

    public final void a(int i) {
        this.e.setVisibility(8);
        this.V = true;
        b(i);
        if (!this.S) {
            if (this.n) {
                this.j.setCurrentItem(1, false);
            } else if (this.U && this.c <= 0 && this.e.getVisibility() == 8 && i > 0) {
                this.j.setCurrentItem(1, false);
            }
        }
    }

    public final void b(int i) {
        this.a = i;
        if (i > 0) {
            this.F.setText(String.format("%s(%s)", new Object[]{"动态", ConvertUtil.decimal2String((long) i, 10000, 10000, "万")}));
            return;
        }
        this.F.setText("动态");
    }

    public final void a() {
        this.e.setVisibility(8);
        this.V = false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.a((Activity) this, i, i2, intent);
    }

    public void onBackPressed() {
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
        if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
            MainTabActivity.b(this, "thunder", null);
        } else {
            super.onBackPressed();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.a().c(PlayerTag.PERSONAL);
        this.N.unregisterReceiver(this.O);
        if (this.Q != null) {
            ab.a().b(this.Q);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            Intent xLIntent = new XLIntent();
            xLIntent.setAction("com.xunlei.action.ACTION_VOLUME_UP_KEY_DOWN");
            this.N.sendBroadcast(xLIntent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void e(String str) {
        c(false);
        com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b b = com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b();
        long j = this.k;
        c ckVar = new ck(this);
        if (!com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c()) {
            ckVar.a(com.xunlei.downloadprovider.personal.message.chat.b.a(TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS, "私信功能关闭"));
        } else if (com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.d()) {
            ((com.xunlei.downloadprovider.personal.message.chat.chatengine.b.aa) com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p.a(com.xunlei.downloadprovider.personal.message.chat.chatengine.b.aa.class)).a(j, new f(b, this, str, ckVar));
        } else {
            XLToast.showToast(this, getString(R.string.personal_chat_disabled));
            ckVar.a(com.xunlei.downloadprovider.personal.message.chat.b.a(-2000, "私信功能不可用"));
        }
    }

    private void d(boolean z) {
        PublisherFollowBtn publisherFollowBtn = this.y;
        publisherFollowBtn.b.setVisibility(8);
        publisherFollowBtn.setFollowStatus(z);
    }

    final void b(long j) {
        this.v.setText(j.a(j));
        this.v.setVisibility(0);
    }

    final void c() {
        int i;
        if (com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c() && this.d != null) {
            String uid = this.d.a().getUid();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LoginHelper.a().g.c());
            if (!uid.equals(stringBuilder.toString())) {
                i = 1;
                if (i == 0) {
                    this.z.setVisibility(0);
                    this.C.setVisibility(0);
                }
                this.z.setVisibility(8);
                this.C.setVisibility(8);
                return;
            }
        }
        i = 0;
        if (i == 0) {
            this.z.setVisibility(8);
            this.C.setVisibility(8);
            return;
        }
        this.z.setVisibility(0);
        this.C.setVisibility(0);
    }

    static /* synthetic */ void b(PublisherActivity publisherActivity) {
        if (!TextUtils.isEmpty(publisherActivity.K)) {
            Intent a = AvatarActivity.a(publisherActivity, publisherActivity.K.replace("/300x300", "/1000x1000"), publisherActivity.K);
            a.setFlags(67108864);
            ActivityCompat.startActivity(publisherActivity, a, ActivityOptionsCompat.makeSceneTransitionAnimation(publisherActivity, publisherActivity.s, "avatar").toBundle());
        }
    }

    static /* synthetic */ void a(PublisherActivity publisherActivity, String str) {
        if (!com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c() || l.c()) {
            publisherActivity.e(str);
        } else {
            publisherActivity.M.a(publisherActivity, new ci(publisherActivity, str), LoginFrom.PERSONAL_CHAT, null);
        }
    }

    static /* synthetic */ void b(PublisherActivity publisherActivity, String str) {
        String str2 = publisherActivity.l;
        if (publisherActivity.d()) {
            com.xunlei.downloadprovider.homepage.recommend.a.a(str, publisherActivity.k, o.a(str2), "");
        } else {
            com.xunlei.downloadprovider.homepage.recommend.a.a(str, publisherActivity.k, "", l.c(), o.a(str2), "");
        }
        if (!l.c()) {
            com.xunlei.downloadprovider.homepage.recommend.a.a(str, publisherActivity.k, 0, "skip_login", "", o.a(str2), "", publisherActivity.W);
            publisherActivity.M.a(publisherActivity, new bz(publisherActivity, str), LoginFrom.PERSONAL_FOLLOW, null);
        } else if (publisherActivity.d()) {
            XLAlertDialog xLAlertDialog = new XLAlertDialog(publisherActivity);
            xLAlertDialog.setMessage((CharSequence) "确定取消关注吗?");
            xLAlertDialog.setOnClickConfirmButtonListener(new cb(publisherActivity, str, str2));
            xLAlertDialog.setOnClickCancelButtonListener(new cc(publisherActivity, str, str2));
            xLAlertDialog.show();
        } else {
            publisherActivity.c(str);
        }
    }

    static /* synthetic */ void g(PublisherActivity publisherActivity) {
        String str = "personal_space_share";
        PublisherInfo publisherInfo = publisherActivity.d;
        String str2 = publisherActivity.K;
        String str3 = publisherActivity.J;
        String d = d.a().n.d("publisher_share_url");
        VideoUserInfo a = publisherInfo.a();
        String uid = a.getUid();
        String description = a.getDescription();
        if (TextUtils.isEmpty(description)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j.a((long) publisherInfo.b().b));
            stringBuilder.append("个粉丝");
            description = stringBuilder.toString();
        }
        String portraitUrl = a.getPortraitUrl();
        if (TextUtils.isEmpty(portraitUrl)) {
            portraitUrl = str2;
        }
        str2 = a.getNickname();
        if (TextUtils.isEmpty(str2)) {
            str2 = str3;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append("的迅雷个人主页");
        com.xunlei.downloadprovidershare.a.f gVar = new g(uid, str, d, stringBuilder2.toString());
        gVar.h = portraitUrl;
        gVar.d = description;
        gVar.k = publisherActivity.h();
        com.xunlei.downloadprovidershare.b.c b = com.xunlei.downloadprovidershare.b.a.b();
        if (publisherActivity.g()) {
            b.a(ShareOperationType.REPORT);
            b.a(new com.xunlei.downloadprovidershare.b.b("发布链接", com.xunlei.downloadprovidershare.R.drawable.share_link_publish_selector, ShareOperationType.LINK_PUBLISH));
        }
        b.a(new com.xunlei.downloadprovidershare.b.b("迅雷ID", com.xunlei.downloadprovidershare.R.drawable.share_id_icon_selector, ShareOperationType.XL_ID));
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.b(publisherActivity, gVar, publisherActivity.Y, b);
        com.xunlei.downloadprovider.homepage.recommend.a.a("right_top_id", publisherActivity.h());
    }

    static /* synthetic */ void b(PublisherActivity publisherActivity, boolean z) {
        z = z ? publisherActivity.d.b().b + 1 : publisherActivity.d.b().b <= false ? publisherActivity.d.b().b - 1 : false;
        publisherActivity.d.b().b = z;
        publisherActivity.b((long) z);
    }

    static /* synthetic */ void a(PublisherActivity publisherActivity, String str, List list) {
        if ("icon_below".equals(str) != null) {
            com.xunlei.downloadprovider.publiser.common.recommendfollow.d.a(publisherActivity, list, publisherActivity.y, "icon_blow");
        } else {
            com.xunlei.downloadprovider.publiser.common.recommendfollow.d.a(publisherActivity, list, publisherActivity.B, "page_bottom");
        }
    }

    static /* synthetic */ void A(PublisherActivity publisherActivity) {
        if (!r.a().a(publisherActivity, LoginFrom.SELF_LOGIN_VIDEO, publisherActivity.Z)) {
            WebsiteEditActivity.a(publisherActivity, "shortvideo_usercenter_pulink");
        }
    }
}
