package com.xunlei.downloadprovider.homepage.photoarticle;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.e.a.d;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.LikeView;
import com.xunlei.downloadprovider.homepage.photoarticle.b.b;
import com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.widget.DetailCardUserInfoTagView;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap;
import com.xunlei.downloadprovider.shortvideo.videodetail.i;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g.a;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.downloadprovider.xlui.recyclerview.h;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.k;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.XLIntent;
import java.util.List;
import java.util.Random;
import org.android.agoo.common.AgooConstants;

public class PhotoArticleDetailActivity extends BaseActivity {
    private static int[] x = new int[]{R.string.comment_hint_1, R.string.comment_hint_2, R.string.comment_hint_3};
    private ImageView A;
    private DetailCardUserInfoTagView B;
    private FollowBtnView C;
    private a D = new i(this);
    private b.a E = new k(this);
    private ap.a F = new m(this);
    private e G = new n(this);
    private k H = new o(this);
    private Runnable I = new p(this);
    private p J = new q(this);
    private int a = 2;
    private int c = 2;
    private boolean d;
    private String e;
    private String f;
    private PhotoArticleInfo g;
    private VideoUserInfo h;
    private XRecyclerView i;
    private a j;
    private LinearLayoutManager k;
    private com.xunlei.downloadprovider.comment.a l;
    private g m;
    private i n;
    private com.xunlei.downloadprovider.shortvideo.videodetail.a o;
    private TextView p;
    private TextView q;
    private int r = 0;
    private LikeView s;
    private ImageView t;
    private ErrorBlankView u;
    private UnifiedLoadingView v;
    private Handler w = new Handler();
    private int y = x[new Random().nextInt(x.length)];
    private TextView z;

    static /* synthetic */ int x(PhotoArticleDetailActivity photoArticleDetailActivity) {
        int i = photoArticleDetailActivity.r - 1;
        photoArticleDetailActivity.r = i;
        return i;
    }

    static /* synthetic */ int y(PhotoArticleDetailActivity photoArticleDetailActivity) {
        int i = photoArticleDetailActivity.r + 1;
        photoArticleDetailActivity.r = i;
        return i;
    }

    public static void a(Context context, String str, PhotoArticleInfo photoArticleInfo, VideoUserInfo videoUserInfo, boolean z) {
        Intent xLIntent = new XLIntent(context, PhotoArticleDetailActivity.class);
        xLIntent.putExtra("from", str);
        xLIntent.putExtra("article_info", photoArticleInfo);
        xLIntent.putExtra(VideoUserInfo.JSON_KEY, videoUserInfo);
        xLIntent.putExtra("seek_to_comment", z);
        context.startActivity(xLIntent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.article_detail_activity);
        this.v = (UnifiedLoadingView) findViewById(R.id.article_loading_view);
        this.v.setPageLoadingViewBgColor(-1);
        this.v.show();
        this.u = (ErrorBlankView) findViewById(R.id.error_layout);
        this.u.setActionButtonListener(new j(this));
        this.t = (ImageView) findViewById(R.id.iv_menu);
        this.t.setImageResource(R.drawable.ic_menu_gray);
        this.t.setOnClickListener(new s(this));
        bundle = findViewById(R.id.fl_title_container);
        bundle.setVisibility(0);
        bundle.setBackgroundColor(-1);
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        imageView.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        imageView.setOnClickListener(new t(this));
        findViewById(R.id.lyt_channel).setOnClickListener(new b(this));
        this.A = (ImageView) findViewById(R.id.iv_channel_icon);
        this.z = (TextView) findViewById(R.id.tv_channel_title);
        this.z.setTextColor(Color.parseColor("#3b424c"));
        this.z.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.z.setMaxWidth(DipPixelUtil.dip2px(90.0f));
        this.B = (DetailCardUserInfoTagView) findViewById(R.id.tv_from_youliao_shot);
        this.C = (FollowBtnView) findViewById(R.id.btn_follow);
        this.C.setDrawableId(R.drawable.follow_btn_solid_animation_drawable);
        this.C.setFollowListener(new r(this));
        findViewById(R.id.flt_comment).setOnClickListener(new v(this));
        ((ImageView) findViewById(R.id.btn_comment)).setImageResource(R.drawable.ic_detail_comment_black);
        this.p = (TextView) findViewById(R.id.tv_write_comment);
        this.p.setHint(this.y);
        this.p.setOnClickListener(new w(this));
        this.q = (TextView) findViewById(R.id.tv_comment_count);
        b(0);
        f.a().a(9, this.G);
        this.s = (LikeView) findViewById(R.id.detail_like_view);
        this.s.setLikeIcon(R.drawable.ic_shortdetail_like_selector);
        this.s.setEmptyText("");
        this.s.setOnClickListener(new x(this));
        findViewById(R.id.btn_share).setOnClickListener(new c(this));
        i();
        b();
    }

    private void a(String str) {
        com.xunlei.downloadprovider.homepage.photoarticle.a.a a = com.xunlei.downloadprovider.homepage.photoarticle.a.a.a();
        c lVar = new l(this);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("photo article resId and listener can not null!");
        }
        XLThreadPool.execute(new com.xunlei.downloadprovider.homepage.photoarticle.a.b(a, str, lVar));
    }

    private void b() {
        if (!c()) {
            VideoUserInfo videoUserInfo = this.h;
            PhotoArticleInfo photoArticleInfo = this.g;
            this.l = new com.xunlei.downloadprovider.comment.a();
            com.xunlei.downloadprovider.comment.entity.e eVar = new com.xunlei.downloadprovider.comment.entity.e(9, this.g.a, this.f);
            this.l.a(eVar);
            this.m = new g(this, eVar);
            this.m.c = Long.parseLong(this.h.getUid());
            this.m.a = this.D;
            this.m.a();
            this.i = (XRecyclerView) findViewById(R.id.article_recycle_view);
            this.i.setPullRefreshEnabled(false);
            this.i.setLoadingListener(new u(this));
            this.i.setLoadingBackgroundColor(Color.parseColor("#ffffff"));
            this.k = new LinearLayoutManager(this);
            this.i.setLayoutManager(this.k);
            this.j = new a(this, this.F, this.E);
            this.i.setAdapter(this.j);
            a aVar = this.j;
            PhotoArticleInfo photoArticleInfo2 = this.g;
            int i = this.a;
            int i2 = 1;
            if (photoArticleInfo2 != null) {
                aVar.h = photoArticleInfo2;
                if (aVar.c == null) {
                    aVar.c = new aw(8, photoArticleInfo2.c);
                } else {
                    aVar.c.b = photoArticleInfo2.c;
                }
                if (aVar.d == null) {
                    aVar.d = new aw(7, photoArticleInfo2.b);
                } else {
                    aVar.d.b = photoArticleInfo2.b;
                }
                if (aVar.f == null) {
                    aVar.f = new aw(9, photoArticleInfo2);
                    aVar.f.c = aVar.i;
                } else {
                    aVar.f.b = photoArticleInfo2;
                    aVar.f.c = aVar.i;
                }
                aVar.a(i == 0);
            }
            d();
            this.z.setText(videoUserInfo.getNickname());
            if (!TextUtils.isEmpty(videoUserInfo.getPortraitUrl())) {
                com.xunlei.downloadprovider.homepage.choiceness.b.a();
                com.xunlei.downloadprovider.homepage.choiceness.b.a(videoUserInfo.getPortraitUrl(), this.A, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new);
            }
            this.B.setUserInfo(videoUserInfo);
            this.C.setUserInfo(videoUserInfo);
            long parseLong = Long.parseLong(videoUserInfo.getUid());
            int i3 = parseLong > 0 ? 1 : 0;
            if (parseLong != LoginHelper.a().g.c()) {
                i2 = 0;
            }
            if ((i3 & i2) != 0) {
                this.C.setVisibility(8);
            } else {
                this.C.setVisibility(0);
            }
            b(photoArticleInfo.i);
            String str = this.e;
            String str2 = this.f;
            String h = h();
            StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_show");
            build.add("from", str);
            build.add("news_id", str2);
            build.add("author_id", h);
            y.a(build);
            if (this.g != null) {
                this.m.a(this.g.a, 9);
            }
        }
    }

    private boolean c() {
        if (this.h != null) {
            if (this.g != null) {
                return false;
            }
        }
        return true;
    }

    private void d() {
        this.s.a(this.g.g, 0);
    }

    private void g() {
        this.a = 0;
        this.m.b();
    }

    private String h() {
        return String.valueOf(this.g.f);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        i();
    }

    public void onDestroy() {
        f.a().b(9, this.G);
        if (this.m != null) {
            this.m.f();
        }
        this.w.removeCallbacks(this.I);
        super.onDestroy();
    }

    private void i() {
        Intent intent = getIntent();
        if (intent != null) {
            this.e = intent.getStringExtra("from");
            if ("forground_h5".equals(this.e)) {
                String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_ID);
                if (TextUtils.isEmpty(stringExtra)) {
                    onBackPressed();
                    return;
                }
                this.f = stringExtra;
                a(stringExtra);
                return;
            }
            this.h = (VideoUserInfo) intent.getParcelableExtra(VideoUserInfo.JSON_KEY);
            this.g = (PhotoArticleInfo) intent.getParcelableExtra("article_info");
            this.d = intent.getBooleanExtra("seek_to_comment", false);
            this.f = this.g.a;
        }
    }

    public final void a() {
        int a = this.j.a();
        int headerViewsCount = this.i.getHeaderViewsCount();
        a(a < 0 ? headerViewsCount + this.j.getItemCount() : headerViewsCount + a);
    }

    private void a(int i) {
        h hVar = new h(this.i, (LinearLayoutManager) this.i.getLayoutManager());
        hVar.d = i;
        int findFirstVisibleItemPosition = hVar.b.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = hVar.b.findLastVisibleItemPosition();
        if (i <= findFirstVisibleItemPosition) {
            hVar.a.scrollToPosition(i);
        } else if (i <= findLastVisibleItemPosition) {
            hVar.a.scrollBy(0, hVar.a.getChildAt(i - findFirstVisibleItemPosition).getTop());
        } else {
            hVar.a.scrollToPosition(i);
            hVar.c = true;
        }
    }

    private void b(int i) {
        if (i == 0) {
            this.q.setVisibility(8);
            return;
        }
        this.q.setVisibility(0);
        this.q.setText(String.valueOf(i));
    }

    public void onBackPressed() {
        finish();
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
        if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
            MainTabActivity.b(this, "thunder", null);
        }
    }

    static /* synthetic */ void a(PhotoArticleDetailActivity photoArticleDetailActivity) {
        if (!photoArticleDetailActivity.c()) {
            PhotoArticleInfo photoArticleInfo = photoArticleDetailActivity.g;
            VideoUserInfo videoUserInfo = photoArticleDetailActivity.h;
            Context context = photoArticleDetailActivity;
            m.a(context, photoArticleInfo.f, videoUserInfo.getKind(), videoUserInfo.getNickname(), videoUserInfo.getPortraitUrl(), From.NEWS_DETAIL_HEAD);
        }
    }

    static /* synthetic */ void b(PhotoArticleDetailActivity photoArticleDetailActivity) {
        photoArticleDetailActivity.v.hide();
        photoArticleDetailActivity.u.setVisibility(0);
    }

    static /* synthetic */ void a(PhotoArticleDetailActivity photoArticleDetailActivity, String str) {
        if (!photoArticleDetailActivity.c()) {
            com.xunlei.downloadprovidershare.a.f a = com.xunlei.downloadprovider.f.c.a(str, photoArticleDetailActivity.g);
            com.xunlei.downloadprovidershare.b.c b = com.xunlei.downloadprovidershare.b.a.b();
            long c = LoginHelper.a().g.c();
            if (c > 0 && photoArticleDetailActivity.h.getUid().equals(String.valueOf(c))) {
                b.a(ShareOperationType.REPORT);
            }
            com.xunlei.downloadprovider.f.a.a();
            com.xunlei.downloadprovider.f.a.b(photoArticleDetailActivity, a, photoArticleDetailActivity.H, b);
            String str2 = photoArticleDetailActivity.f;
            photoArticleDetailActivity = photoArticleDetailActivity.h();
            StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_share_click");
            build.add("news_id", str2);
            build.add("author_id", photoArticleDetailActivity);
            build.add("from", str);
            y.a(build);
        }
    }

    static /* synthetic */ void h(PhotoArticleDetailActivity photoArticleDetailActivity) {
        photoArticleDetailActivity.a = 0;
        photoArticleDetailActivity.m.c();
    }

    static /* synthetic */ void b(PhotoArticleDetailActivity photoArticleDetailActivity, String str) {
        if (photoArticleDetailActivity.o == null) {
            photoArticleDetailActivity.o = new com.xunlei.downloadprovider.shortvideo.videodetail.a(photoArticleDetailActivity);
            photoArticleDetailActivity.o.a(new d(photoArticleDetailActivity));
        }
        photoArticleDetailActivity.o.b(str);
        if (photoArticleDetailActivity.o.isShowing() == null) {
            photoArticleDetailActivity.o.show();
        }
    }

    static /* synthetic */ void b(PhotoArticleDetailActivity photoArticleDetailActivity, PhotoArticleInfo photoArticleInfo) {
        if (!photoArticleInfo.g) {
            photoArticleDetailActivity.s.a();
            d dVar = new d(photoArticleInfo.a, photoArticleInfo.a, photoArticleInfo.h);
            dVar.a = 9;
            dVar.e = null;
            f.a().a(photoArticleDetailActivity, dVar, null);
            y.a(photoArticleDetailActivity.f, photoArticleDetailActivity.h(), "bottom");
        }
    }

    static /* synthetic */ void a(PhotoArticleDetailActivity photoArticleDetailActivity, List list) {
        if (list != null) {
            if (!list.isEmpty()) {
                PhotoArticleDetailActivity<com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a> photoArticleDetailActivity2 = photoArticleDetailActivity.m.b;
                if (photoArticleDetailActivity2 != null && photoArticleDetailActivity2.size() > 0) {
                    for (com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a aVar : photoArticleDetailActivity2) {
                        for (CommentInfo commentInfo : list) {
                            if (commentInfo.getId() == aVar.a) {
                                commentInfo.setLiked(true);
                                if (!aVar.d) {
                                    commentInfo.setLikeCount(commentInfo.getLikeCount() + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void p(PhotoArticleDetailActivity photoArticleDetailActivity) {
        String trim = photoArticleDetailActivity.o.a().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            XLToast.showToast(photoArticleDetailActivity, "请填写评论内容");
        } else if (com.xunlei.xllib.android.b.a(photoArticleDetailActivity)) {
            photoArticleDetailActivity.o.a(false);
            photoArticleDetailActivity.m.a(trim, AndroidConfig.getPhoneBrand(), photoArticleDetailActivity.o.b);
        } else {
            XLToast.showNoNetworkToast(photoArticleDetailActivity);
        }
    }

    static /* synthetic */ void a(PhotoArticleDetailActivity photoArticleDetailActivity, CommentInfo commentInfo) {
        if (photoArticleDetailActivity.n == null) {
            photoArticleDetailActivity.n = new i(photoArticleDetailActivity);
            photoArticleDetailActivity.n.a(new e(photoArticleDetailActivity));
            photoArticleDetailActivity.n.b(new f(photoArticleDetailActivity));
            photoArticleDetailActivity.n.c(new g(photoArticleDetailActivity));
            photoArticleDetailActivity.n.d(new h(photoArticleDetailActivity));
        }
        photoArticleDetailActivity.n.a(commentInfo);
        if (photoArticleDetailActivity.n.isShowing() == null) {
            photoArticleDetailActivity.n.show();
        }
    }
}
