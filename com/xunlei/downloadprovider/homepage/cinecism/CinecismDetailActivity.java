package com.xunlei.downloadprovider.homepage.cinecism;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.e.a.d;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.f.c;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.LikeView;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.i;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import com.xunlei.downloadprovider.web.base.core.ag;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.k;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.b;
import java.util.Random;
import org.android.agoo.common.AgooConstants;

public class CinecismDetailActivity extends BaseActivity {
    private static final String a = "CinecismDetailActivity";
    private static int[] w = new int[]{R.string.comment_hint_1, R.string.comment_hint_2, R.string.comment_hint_3};
    private e A = new k(this);
    private k B = new l(this);
    private ag C = new n(this);
    private aa D = new q(this);
    private boolean c;
    private String d;
    private String e;
    private CinecismInfo f;
    private VideoUserInfo g;
    private g h;
    private i i;
    private a j;
    private TextView k;
    private int l = 0;
    private LikeView m;
    private ErrorBlankView n;
    private UnifiedLoadingView o;
    private CustomWebView p;
    private String q;
    private boolean r = false;
    private int s = 0;
    private int t = 0;
    private long u;
    private int v = 0;
    private int x = w[new Random().nextInt(w.length)];
    private p y = new d(this);
    private g.a z = new i(this);

    static /* synthetic */ int t(CinecismDetailActivity cinecismDetailActivity) {
        int i = cinecismDetailActivity.l - 1;
        cinecismDetailActivity.l = i;
        return i;
    }

    static /* synthetic */ int u(CinecismDetailActivity cinecismDetailActivity) {
        int i = cinecismDetailActivity.l + 1;
        cinecismDetailActivity.l = i;
        return i;
    }

    public static void a(Context context, String str, CinecismInfo cinecismInfo, VideoUserInfo videoUserInfo, boolean z) {
        Intent intent = new Intent(context, CinecismDetailActivity.class);
        intent.putExtra("from", str);
        intent.putExtra("cinecism_info", cinecismInfo);
        intent.putExtra(VideoUserInfo.JSON_KEY, videoUserInfo);
        intent.putExtra("seek_to_comment", z);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_detail_cinecism);
        this.o = (UnifiedLoadingView) findViewById(R.id.cinecism_loading_view);
        this.o.setPageLoadingViewBgColor(-1);
        this.o.setOnClickListener(null);
        this.p = (CustomWebView) findViewById(R.id.cinecism_webview);
        this.p.setShowLoading(false);
        if (this.p.getWebView() != null) {
            this.p.getWebView().setOverScrollMode(2);
        }
        this.p.setErrorViewVisibilityListener(new b(this));
        this.p.a(this.C);
        this.p.setWebViewClient(new m(this));
        this.n = (ErrorBlankView) findViewById(R.id.cinecism_error_view);
        this.n.setOnClickListener(null);
        this.n.setActionButtonListener(new s(this));
        ((ImageView) findViewById(R.id.iv_menu)).setOnClickListener(new t(this));
        ((ImageView) findViewById(R.id.iv_back)).setOnClickListener(new u(this));
        findViewById(R.id.flt_comment).setOnClickListener(new v(this));
        ((ImageView) findViewById(R.id.btn_comment)).setImageResource(R.drawable.ic_detail_comment_black);
        TextView textView = (TextView) findViewById(R.id.tv_write_comment);
        textView.setHint(this.x);
        textView.setOnClickListener(new w(this));
        this.k = (TextView) findViewById(R.id.tv_comment_count);
        b(0);
        f.a().a(8, this.A);
        this.m = (LikeView) findViewById(R.id.detail_like_view);
        this.m.setLikeIcon(R.drawable.ic_shortdetail_like_selector);
        this.m.setEmptyText("");
        this.m.setOnClickListener(new x(this));
        findViewById(R.id.btn_share).setOnClickListener(new y(this));
        ab.a().a(this.D);
        a(getIntent());
        b();
    }

    public final void a(int i) {
        this.s = 1;
        if (!b.a(this)) {
            this.n.setErrorType(2);
        } else if (i == 404) {
            this.n.setErrorType(1);
        }
        h();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    private void a(Intent intent) {
        if (intent != null) {
            String stringExtra;
            StringBuilder stringBuilder;
            this.d = intent.getStringExtra("from");
            if ("cinecism_detail".equals(this.d)) {
                this.v = 0;
                this.c = false;
                this.f = null;
                this.g = null;
                b(0);
                this.m.a(false, 0);
            }
            if ("share_page".equals(this.d)) {
                stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_ID);
                if (TextUtils.isEmpty(stringExtra)) {
                    onBackPressed();
                    return;
                } else {
                    this.e = stringExtra;
                    b(stringExtra);
                }
            } else if (("personal_space".equals(this.d) && intent.getParcelableExtra(VideoUserInfo.JSON_KEY) == null) || "cinecism_detail".equals(this.d)) {
                CinecismInfo cinecismInfo = (CinecismInfo) intent.getParcelableExtra("cinecism_info");
                this.e = cinecismInfo.a;
                b(cinecismInfo.a);
            } else {
                this.t = 2;
                this.g = (VideoUserInfo) intent.getParcelableExtra(VideoUserInfo.JSON_KEY);
                this.f = (CinecismInfo) intent.getParcelableExtra("cinecism_info");
                this.c = intent.getBooleanExtra("seek_to_comment", false);
                this.e = this.f.a;
            }
            this.o.show();
            intent = new StringBuilder("http://m.sjzhushou.com/h5/movie/detail/index60.html?id=");
            intent.append(this.e);
            intent.append("&peerid=");
            intent.append(AndroidConfig.getHubbleDeviceGUID());
            intent = intent.toString();
            LoginHelper.a();
            if (l.c()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(intent);
                stringBuilder.append("&portrait=");
                stringBuilder.append(com.xunlei.xllib.b.k.a(LoginHelper.a().e(), "UTF-8"));
                intent = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(intent);
            stringBuilder.append("&seekcomment=");
            stringBuilder.append(this.c);
            stringExtra = stringBuilder.toString();
            if (!stringExtra.equals(this.q)) {
                this.p.a(stringExtra);
                this.s = 0;
                this.q = stringExtra;
                this.r = false;
            }
        }
    }

    private void b() {
        if (!g()) {
            com.xunlei.downloadprovider.comment.a aVar = new com.xunlei.downloadprovider.comment.a();
            com.xunlei.downloadprovider.comment.entity.e eVar = new com.xunlei.downloadprovider.comment.entity.e(8, this.f.a, this.e);
            aVar.a(eVar);
            this.h = new g(this, eVar);
            this.h.a = this.z;
            this.h.c = Long.parseLong(this.g.getUid());
            this.h.a();
            d();
            this.l = this.f.h;
            b(this.f.h);
            z.a(this.d, this.e, c());
            this.u = System.currentTimeMillis();
        }
    }

    private String c() {
        return String.valueOf(this.f.e);
    }

    private void d() {
        this.m.a(this.f.f, 0);
    }

    private void a(String str) {
        if (this.j == null) {
            this.j = new a(this);
            this.j.a(new c(this));
        }
        this.j.b(str);
        if (this.j.isShowing() == null) {
            this.j.show();
        }
    }

    private void b(int i) {
        if (i == 0) {
            this.k.setVisibility(8);
            return;
        }
        this.k.setVisibility(0);
        this.k.setText(String.valueOf(i));
    }

    private void b(String str) {
        this.t = 0;
        this.o.show();
        com.xunlei.downloadprovider.homepage.cinecism.a.a.a(str, new j(this));
    }

    private boolean g() {
        if (this.g != null) {
            if (this.f != null) {
                return false;
            }
        }
        return true;
    }

    private void h() {
        this.o.hide();
        this.p.setVisibility(8);
        this.n.setVisibility(0);
    }

    public void onBackPressed() {
        finish();
        if ("share_page".equals(this.d)) {
            MainTabActivity.b(this, "thunder", null);
            return;
        }
        ActivityManager activityManager = (ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity");
        if (activityManager != null) {
            RunningTaskInfo runningTaskInfo = (RunningTaskInfo) activityManager.getRunningTasks(1).get(0);
            if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
                MainTabActivity.b(this, "thunder", null);
            }
        }
    }

    private void a(boolean z) {
        if (this.p != null) {
            CustomWebView customWebView = this.p;
            StringBuilder stringBuilder = new StringBuilder("javascript:window.change_follow_state(");
            stringBuilder.append(z);
            stringBuilder.append(com.umeng.message.proguard.k.t);
            customWebView.a(stringBuilder.toString());
        }
    }

    protected void onResume() {
        super.onResume();
        this.u = System.currentTimeMillis();
    }

    protected void onPause() {
        super.onPause();
        if (!g() && this.s == 2) {
            z.a(this.e, c(), System.currentTimeMillis() - this.u, this.v);
        }
    }

    public void onDestroy() {
        ab.a().b(this.D);
        f.a().b(8, this.A);
        if (this.h != null) {
            this.h.f();
        }
        super.onDestroy();
    }

    static /* synthetic */ void c(CinecismDetailActivity cinecismDetailActivity) {
        if (cinecismDetailActivity.s == 2 && !cinecismDetailActivity.g()) {
            cinecismDetailActivity.p.setVisibility(0);
            cinecismDetailActivity.n.setVisibility(8);
        }
    }

    static /* synthetic */ void d(CinecismDetailActivity cinecismDetailActivity) {
        if (cinecismDetailActivity.s != 0 && cinecismDetailActivity.t != 0) {
            cinecismDetailActivity.o.hide();
        }
    }

    static /* synthetic */ void b(CinecismDetailActivity cinecismDetailActivity, String str) {
        if (!cinecismDetailActivity.g()) {
            com.xunlei.downloadprovidershare.a.f a = c.a(str, cinecismDetailActivity.f);
            com.xunlei.downloadprovidershare.b.c b = com.xunlei.downloadprovidershare.b.a.b();
            long c = LoginHelper.a().g.c();
            if (c > 0 && cinecismDetailActivity.g.getUid().equals(String.valueOf(c))) {
                b.a(ShareOperationType.REPORT);
            }
            com.xunlei.downloadprovider.f.a.a();
            com.xunlei.downloadprovider.f.a.b(cinecismDetailActivity, a, cinecismDetailActivity.B, b);
            z.c(str, cinecismDetailActivity.e, cinecismDetailActivity.c());
        }
    }

    static /* synthetic */ void a(CinecismDetailActivity cinecismDetailActivity, CinecismInfo cinecismInfo) {
        if (!cinecismInfo.f) {
            cinecismDetailActivity.m.a();
            d dVar = new d(cinecismInfo.a, cinecismInfo.a, cinecismInfo.g);
            dVar.a = 8;
            dVar.e = null;
            f.a().a(cinecismDetailActivity, dVar, null);
            if (cinecismDetailActivity.p != null) {
                cinecismDetailActivity.p.a("javascript:window.fav_client()");
            }
        }
    }

    static /* synthetic */ void q(CinecismDetailActivity cinecismDetailActivity) {
        String trim = cinecismDetailActivity.j.a().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            XLToast.showToast(cinecismDetailActivity, "请填写评论内容");
        } else if (b.a(cinecismDetailActivity)) {
            cinecismDetailActivity.j.a(false);
            cinecismDetailActivity.h.a(trim, AndroidConfig.getPhoneBrand(), cinecismDetailActivity.j.b);
        } else {
            XLToast.showNoNetworkToast(cinecismDetailActivity);
        }
    }

    static /* synthetic */ void y(CinecismDetailActivity cinecismDetailActivity) {
        if (!cinecismDetailActivity.g()) {
            Context context = cinecismDetailActivity;
            m.a(context, cinecismDetailActivity.f.e, cinecismDetailActivity.g.getKind(), cinecismDetailActivity.g.getNickname(), cinecismDetailActivity.g.getPortraitUrl(), From.CINECISM_DETAIL);
            z.b(cinecismDetailActivity.f.a, String.valueOf(cinecismDetailActivity.f.e), "header");
        }
    }

    static /* synthetic */ void a(CinecismDetailActivity cinecismDetailActivity, int i, CommentInfo commentInfo) {
        StringBuilder stringBuilder = new StringBuilder("onCommentClick=clickId ");
        stringBuilder.append(i);
        stringBuilder.append("|CommentInfo=");
        stringBuilder.append(commentInfo);
        if (commentInfo != null) {
            String str;
            String c;
            long id;
            String c2;
            switch (i) {
                case 1:
                    str = cinecismDetailActivity.e;
                    c = cinecismDetailActivity.c();
                    id = commentInfo.getId();
                    LoginHelper.a();
                    z.a(str, c, id, l.b(), "comment");
                    if (commentInfo.isPreview() != 0) {
                        XLToast.showToast(cinecismDetailActivity, "此评论暂时无法回复");
                        return;
                    }
                    i = new StringBuilder("回复 ");
                    i.append(commentInfo.getUserName());
                    cinecismDetailActivity.a(i.toString());
                    cinecismDetailActivity.j.a(commentInfo);
                    return;
                case 2:
                    String str2 = cinecismDetailActivity.e;
                    c2 = cinecismDetailActivity.c();
                    long id2 = commentInfo.getId();
                    LoginHelper.a();
                    z.a(str2, c2, id2, l.b(), "long_click");
                    if (cinecismDetailActivity.i == 0) {
                        cinecismDetailActivity.i = new i(cinecismDetailActivity);
                        cinecismDetailActivity.i.a(new e(cinecismDetailActivity));
                        cinecismDetailActivity.i.c(new f(cinecismDetailActivity));
                        cinecismDetailActivity.i.b(new g(cinecismDetailActivity));
                        cinecismDetailActivity.i.d(new h(cinecismDetailActivity));
                    }
                    cinecismDetailActivity.i.a(commentInfo);
                    if (cinecismDetailActivity.i.isShowing() == 0) {
                        cinecismDetailActivity.i.show();
                    }
                    return;
                case 3:
                    cinecismDetailActivity.h.a(commentInfo);
                    str = cinecismDetailActivity.e;
                    c = cinecismDetailActivity.c();
                    id = commentInfo.getId();
                    LoginHelper.a();
                    z.a(str, c, id, l.b(), "like");
                    return;
                case 4:
                    cinecismDetailActivity.h.e();
                    cinecismDetailActivity.h.f();
                    m.a(cinecismDetailActivity, commentInfo.getUserId(), "per", commentInfo.getUserName(), commentInfo.getUserAvatar(), From.CINECISM_DETAIL);
                    c2 = cinecismDetailActivity.e;
                    String c3 = cinecismDetailActivity.c();
                    long id3 = commentInfo.getId();
                    LoginHelper.a();
                    z.a(c2, c3, id3, l.b(), "head");
                    break;
                default:
                    break;
            }
        }
    }

    static /* synthetic */ void b(CinecismDetailActivity cinecismDetailActivity, VideoUserInfo videoUserInfo) {
        z.b(cinecismDetailActivity.f.a, String.valueOf(cinecismDetailActivity.f.e), "follow");
        cinecismDetailActivity.a(true);
        com.xunlei.downloadprovider.homepage.follow.b.a().a(Long.parseLong(videoUserInfo.getUid()), true, new o(cinecismDetailActivity));
    }
}
