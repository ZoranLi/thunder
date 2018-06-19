package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.taobao.accs.AccsClientConfig;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.d.b.n;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.homepage.redpacket.j;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.publiser.common.PublisherInfo;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.StateSyncManager;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.StateSyncManager.CommentSateInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.StateSyncManager.SourceFrom;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.c;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.e;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.k;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ShortMovieDetailFragment extends BaseFragment implements OnClickListener, com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a, com.xunlei.downloadprovider.shortvideo.videodetail.model.g.a {
    public static final String a = "ShortMovieDetailFragment";
    public static final int b = d.a().b.y();
    private static final int g = d.a().b.z();
    private static final int h = (b * 2);
    private a A;
    private i B;
    private boolean C;
    private boolean D;
    private UnifiedLoadingView E;
    private int F = 0;
    private int G = 0;
    private ap H;
    private aw I;
    private ImageView J;
    private aw K;
    private aw L;
    private aw M;
    private aw N;
    private aw O;
    private aw P;
    private List<e> Q;
    private LinearLayoutManager R;
    private LinkedHashMap<String, Object> S = new LinkedHashMap();
    private List<com.xunlei.downloadprovider.shortvideo.videodetail.bv.a> T = new ArrayList(h);
    private List<com.xunlei.downloadprovider.shortvideo.videodetail.bv.a> U = new ArrayList(4);
    private List<com.xunlei.downloadprovider.shortvideo.videodetail.bv.a> V = new ArrayList(4);
    private int W = 0;
    private String X;
    private String Y;
    private String Z;
    private View aA;
    private boolean aB;
    private ImageView aC;
    private ImageView aD;
    private int aE = 0;
    private LottieAnimationView aF;
    private LottieAnimationView aG;
    private boolean aH = false;
    private boolean aI = true;
    private k aJ = new bi(this);
    private aw aa;
    private int ab = 0;
    private aw ac;
    private boolean ad = false;
    private BroadcastReceiver ae;
    private b af;
    private LocalBroadcastManager ag;
    private BroadcastReceiver ah;
    private com.xunlei.downloadprovider.e.a.e ai;
    private f aj;
    private aa ak;
    private List<v> al;
    private ImageView am;
    private TextView an;
    private com.xunlei.downloadprovider.shortvideo.videodetail.widget.b ao;
    private p[] ap;
    private LoginHelper aq = LoginHelper.a();
    private com.xunlei.downloadprovider.ad.d.f ar = null;
    private Object[] as = new Object[]{Boolean.valueOf(true), Boolean.valueOf(true)};
    private boolean at = false;
    private boolean au = false;
    private boolean av;
    private String aw;
    private p ax;
    private p ay;
    private boolean az = false;
    g c;
    com.xunlei.downloadprovider.shortvideo.videodetail.model.b d;
    String e;
    List<com.xunlei.downloadprovider.shortvideo.videodetail.model.b> f;
    private RecyclerView i;
    private int j = 0;
    private int k = 0;
    private List<aw> l;
    private List<aw> m;
    private List<aw> n;
    private TextView o;
    private c p;
    private Handler q;
    private ErrorBlankView r;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x = 0;
    private int y = 2;
    private TextView z;

    public interface a {
        void a();

        void a(com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar, boolean z);

        void a(c cVar);

        void a(String str);

        void a(String str, com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar);

        void a(List<e> list);

        void b();

        void b(boolean z);

        int c();

        void c(boolean z);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mPageRoot = (ViewGroup) layoutInflater.inflate(R.layout.fragment_detail_layout, null);
        this.i = (RecyclerView) findViewById(R.id.rcv_contents);
        this.R = new LinearLayoutManager(this.mActivity);
        this.i.setLayoutManager(this.R);
        this.H = new ap(this.mActivity, this);
        this.i.setAdapter(this.H);
        layoutInflater = new k();
        layoutInflater.a = true;
        this.i.setItemAnimator(layoutInflater);
        this.aA = this.mActivity.findViewById(R.id.lyt_write_comment);
        this.aA.findViewById(R.id.flt_comment).setOnClickListener(this);
        this.z = (TextView) this.mActivity.findViewById(R.id.tv_comment_count);
        this.J = (ImageView) this.mActivity.findViewById(R.id.btn_share);
        this.mActivity.findViewById(R.id.fl_click_nice_bottom).setOnClickListener(this);
        this.am = (ImageView) this.mActivity.findViewById(R.id.iv_good_icon_bottom);
        this.an = (TextView) this.mActivity.findViewById(R.id.tv_plus_one_bottom);
        this.o = (TextView) this.mActivity.findViewById(R.id.tv_write_comment);
        this.aC = (ImageView) this.mActivity.findViewById(R.id.btn_comment);
        f(this.aB);
        int i = 0;
        if (j() != null) {
            this.J.setVisibility(8);
            this.mActivity.findViewById(R.id.fl_click_nice_bottom).setVisibility(8);
            layoutInflater = this.o.getLayoutParams();
            if (layoutInflater != null) {
                layoutInflater.width = DipPixelUtil.dip2px(300.0f);
            }
            this.o.setLayoutParams(layoutInflater);
        } else {
            this.J.setVisibility(0);
        }
        this.aD = (ImageView) this.mActivity.findViewById(R.id.iv_red_packet);
        a(4);
        if (!j() && d.a().l.d()) {
            int b = com.xunlei.downloadprovider.h.f.b(getApplicationContext(), "key_enter_detail_count", 0);
            if (b == 0) {
                this.aD.setVisibility(4);
                this.aG = (LottieAnimationView) this.mActivity.findViewById(R.id.lottie_detail_share1);
                this.aF = (LottieAnimationView) this.mActivity.findViewById(R.id.lottie_detail_share2);
                this.aG.setVisibility(0);
                this.aG.post(new am(this));
            } else {
                a(0);
            }
            b++;
            if (b == 5) {
                b = 0;
            }
            com.xunlei.downloadprovider.h.f.a(getApplicationContext(), "key_enter_detail_count", b);
        }
        this.r = (ErrorBlankView) findViewById(R.id.ev_try);
        this.r.setErrorType(2);
        this.r.setVisibility(8);
        this.r.a("刷新", new bq(this));
        this.E = (UnifiedLoadingView) findViewById(R.id.ulv_loading);
        this.E.setBackgroundColor(Color.parseColor("#ffffff"));
        this.E.hidePageLoadingViewBack();
        this.E.setOnTouchListener(new br(this));
        this.ao = new com.xunlei.downloadprovider.shortvideo.videodetail.widget.b(getContext());
        this.ao.a = new bt(this);
        this.B = new i(this.mActivity);
        this.i.addOnScrollListener(new ap(this));
        this.J.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.A = new a(this.mActivity);
        this.A.a(new aq(this));
        this.A.d = new ar(this);
        this.A.setOnDismissListener(new as(this));
        this.A.setOnShowListener(new at(this));
        this.B.a(new au(this));
        this.B.b(new av(this));
        this.B.c(new aw(this));
        this.B.d(new ax(this));
        this.ai = new az(this);
        this.aj = f.a();
        this.aj.a(1, this.ai);
        this.ak = new ba(this);
        ab.a().a(this.ak);
        this.ax = new bb(this);
        this.ay = new bc(this);
        this.I = new aw();
        this.I.b = this.d;
        this.I.c = this.p;
        if (j() == null) {
            this.I.a = 0;
        } else {
            this.I.a = 12;
        }
        g();
        this.l = new ArrayList(b);
        while (i < b) {
            bundle = new aw();
            bundle.a = 184;
            bundle.b = null;
            this.l.add(bundle);
            i++;
        }
        this.L = new aw();
        this.L.a = 183;
        this.L.b = "全部";
        this.aa = new aw();
        this.aa.a = 10;
        this.aa.b = "热门评论";
        this.aa.c = "hot";
        this.n = new ArrayList();
        this.M = new aw();
        this.M.a = 10;
        this.M.b = "最新评论";
        this.M.c = "new";
        this.m = new ArrayList();
        this.N = new aw();
        this.N.a = 11;
        this.N.b = null;
        this.O = new aw();
        this.O.a = 4;
        this.O.b = this.ap;
        this.O.c = this.as;
        this.P = new aw();
        this.P.a = 5;
        this.P.b = null;
        this.ac = new aw();
        this.ac.a = 9;
        this.ac.b = null;
        n();
        m();
        if (!(this.e == null || j() == null)) {
            this.H.c(this.K);
            this.H.c(this.l);
        }
        return this.mPageRoot;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.q = new al(this);
        this.d = new com.xunlei.downloadprovider.shortvideo.videodetail.model.b();
        bundle = getArguments();
        this.d.e = (BaseVideoInfo) bundle.getParcelable("video_nfo");
        this.d.f = (VideoUserInfo) bundle.getParcelable(VideoUserInfo.JSON_KEY);
        if (TextUtils.equals("null", this.d.a().getGcid())) {
            this.d.a().setGcid(null);
        }
        this.e = bundle.getString("from");
        this.af = b.a();
        a();
        this.C = bundle.getBoolean("movie_seek_to_comment", false);
        this.D = bundle.getBoolean("auto_show_comment_dialog", false);
        this.c = new g(this.mActivity);
        this.c.a = this;
        this.c.a(this.d, j());
        this.c.a();
        this.ae = new ay(this);
        bundle = new IntentFilter();
        bundle.addAction("action_comment_zan_state_changed");
        this.mActivity.registerReceiver(this.ae, bundle);
        this.ah = new bo(this);
        this.ag = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
        bundle = new IntentFilter();
        bundle.addAction("new_follow");
        bundle.addAction("cancel_follow");
        bundle.addAction("new_user_login_success");
        bundle.addAction("user_logout");
        this.ag.registerReceiver(this.ah, bundle);
        this.ar = new com.xunlei.downloadprovider.ad.d.f();
        this.ar.b = j();
        this.ar.c = new bj(this);
    }

    final void a() {
        if (this.p == null) {
            this.p = new c();
            if (this.I != null) {
                this.I.c = this.p;
            }
        }
        if (this.e == null || !j()) {
            long parseLong = Long.parseLong(this.d.b().getUid());
            this.p.a = this.af.b(parseLong) ^ 1;
            this.p.c = this.af.b(parseLong) ^ 1;
        } else {
            this.p.a = false;
        }
        ((a) this.mActivity).a(this.p);
    }

    public void onResume() {
        super.onResume();
        g();
        h();
        b();
    }

    private void g() {
        Object obj;
        if (this.K == null) {
            this.K = new aw();
            this.K.a = 180;
        }
        com.xunlei.downloadprovider.shortvideo.videodetail.model.d dVar = new com.xunlei.downloadprovider.shortvideo.videodetail.model.d();
        dVar.a = "相关推荐";
        com.xunlei.downloadprovider.ad.d.f fVar = this.ar;
        StringBuilder stringBuilder = new StringBuilder("getBrandAdInfo: ");
        if (fVar.a.a == null) {
            obj = "null";
        } else {
            obj = fVar.a.a;
        }
        stringBuilder.append(obj);
        dVar.b = fVar.a.a;
        this.K.b = dVar;
    }

    private void h() {
        if (this.H != null) {
            int d = this.H.d();
            if (d >= 0) {
                this.H.b(d, this.K);
            }
        }
    }

    public void onDestroy() {
        this.c.e();
        this.c.f();
        this.c.a = null;
        this.aj.b(1, this.ai);
        ab.a().b(this.ak);
        this.mActivity.unregisterReceiver(this.ae);
        this.ag.unregisterReceiver(this.ah);
        a(this.R.findFirstVisibleItemPosition(), this.R.findLastVisibleItemPosition());
        if (this.T.size() > 0) {
            new StringBuilder("onDestroy report size =>").append(this.T.size());
            bv.a(this.T, this.e, new String[]{this.X, this.Y, this.Z, AndroidConfig.getPhoneModel(), com.xunlei.xllib.android.b.c(this.mActivity)});
            this.T.clear();
        }
        com.xunlei.downloadprovider.ad.d.a.a.b();
        B();
        if (this.S != null) {
            this.S.clear();
        }
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.C != null) {
            c((int) null);
        }
        if (this.D != null) {
            r();
        }
        i();
    }

    final void b() {
        if (this.r.isShown()) {
            this.r.setVisibility(8);
            ((a) this.mActivity).b(false);
            this.E.show();
        }
        if (this.s == 1) {
            this.s = 0;
            this.c.a(this.d.a().getVideoId(), j());
        }
        if (this.x == 1 && !TextUtils.isEmpty(this.d.a().getGcid())) {
            this.x = 0;
            this.c.d();
        }
        if (this.w == 1 && !TextUtils.isEmpty(this.d.a().getGcid())) {
            this.w = 0;
            this.c.b();
        }
        if (this.u == 1) {
            this.u = 0;
            this.c.b(this.d.a().getVideoId(), g);
        }
    }

    private void i() {
        this.u = 0;
        this.E.show();
        this.s = 0;
        this.t = 0;
        this.c.a(this.d.a().getVideoId(), j());
        this.c.a(this.d.a().getVideoId(), j() ? 7 : 1);
        if (!j()) {
            this.c.b(this.d.a().getVideoId(), g);
            this.v = 0;
            com.xunlei.downloadprovider.ad.d.a.a.a().a.clear();
            g();
            h();
        }
        if (TextUtils.isEmpty(this.d.a().getGcid())) {
            this.w = 1;
            this.x = 1;
            return;
        }
        this.w = 0;
        this.x = 0;
        this.c.d();
        this.c.b();
    }

    private boolean j() {
        return this.e.equals(From.HOME_PAGE_AD.getText());
    }

    private void e(boolean z) {
        boolean z2 = false;
        this.j = 0;
        this.C = false;
        this.D = false;
        this.ad = true;
        this.au = false;
        this.av = false;
        this.y = 2;
        this.az = false;
        this.H.e();
        if (this.c != null) {
            this.c.e();
        }
        if (z) {
            this.d = new com.xunlei.downloadprovider.shortvideo.videodetail.model.b();
            this.p = new c();
            this.al = null;
            this.ap = null;
            this.I.b = this.d;
            this.I.c = this.p;
            this.am.setSelected(false);
            this.X = null;
            this.Y = null;
            this.Z = null;
            if (this.B && this.B.isShowing()) {
                this.B.dismiss();
            }
            if (this.A) {
                if (this.A.isShowing()) {
                    this.A.dismiss();
                }
                z = this.A;
                if (z.c != null) {
                    z.c.clear();
                }
                z.b = null;
                z.a.setText("");
                z.a.setHint("写评论...");
            }
            this.q.post(new bp(this));
        }
        if (this.Q) {
            this.Q.clear();
        }
        if (this.f) {
            this.f.clear();
        }
        if (this.l) {
            this.l.clear();
        } else {
            this.l = new ArrayList(b);
        }
        while (z2 < b) {
            z = new aw();
            z.a = 184;
            z.b = null;
            this.l.add(z);
            z2++;
        }
        if (this.m) {
            this.m.clear();
        }
        this.M.a = 10;
        if (this.n) {
            this.n.clear();
        }
        n();
    }

    private boolean k() {
        return this.H.a(this.R.findFirstVisibleItemPosition(), this.R.findLastVisibleItemPosition());
    }

    public final void a(boolean z) {
        if (this.aA != null) {
            if (this.aA.getVisibility() != 0) {
                this.aA.setVisibility(0);
            }
            this.aA.setAlpha(1.0f);
            this.aA.setTranslationY(0.0f);
            if (this.aB != z) {
                this.aB = z;
                f(z);
            }
        }
    }

    public final void a(boolean z, boolean z2) {
        if (this.aA != null) {
            if (this.aB) {
                float f = 1.0f;
                if (z2) {
                    float f2;
                    z2 = this.aA.animate();
                    if (z) {
                        f2 = 0.0f;
                    } else {
                        f2 = (float) this.aA.getMeasuredHeight();
                    }
                    z2 = z2.translationY(f2);
                    if (!z) {
                        f = 0.0f;
                    }
                    z2 = z2.alpha(f);
                    long j = 200;
                    z2 = z2.setDuration(200).setListener(new bs(this, z));
                    if (!z) {
                        j = 0;
                    }
                    z2.setStartDelay(j);
                    l();
                    return;
                }
                this.aA.setVisibility(z ? false : true);
                this.aA.setTranslationY(0.0f);
                this.aA.setAlpha(1.0f);
            }
        }
    }

    private void l() {
        if (!j() && d.a().l.d()) {
            if (this.aG != null && this.aG.b()) {
                this.aG.c();
                this.aG.setVisibility(8);
                this.aD.setVisibility(0);
            }
            if (this.aF != null && this.aF.b()) {
                this.aF.c();
                this.aF.setVisibility(8);
                this.aD.setVisibility(0);
            }
        }
    }

    private void f(boolean z) {
        if (z) {
            this.aA.setBackgroundResource(R.drawable.bg_comment_bottom_bar);
            this.o.setBackgroundResource(R.drawable.comment_input_light_layout_selector);
            this.o.setTextColor(-1);
            this.o.setHintTextColor(-1);
            this.J.setImageResource(R.drawable.short_detail_share_selector);
            this.aC.setImageResource(R.drawable.short_detail_comment_selector);
            this.am.setImageResource(R.drawable.ic_detail_like_white_selector);
            return;
        }
        this.aA.setBackgroundColor(-1);
        this.o.setBackgroundResource(R.drawable.comment_input_layout_selector);
        this.o.setTextColor(Color.parseColor("#5a6473"));
        this.o.setHintTextColor(Color.parseColor("#5a6473"));
        this.J.setImageResource(R.drawable.short_detail_share_black_selector);
        this.aC.setImageResource(R.drawable.short_detail_comment_black_selector);
        this.am.setImageResource(R.drawable.ic_shortdetail_like_selector);
    }

    private void a(int i) {
        if (!j()) {
            this.aD.setVisibility(i);
        }
    }

    private void m() {
        boolean z = false;
        if (this.aI) {
            this.aI = false;
            z = k();
        } else if (k() == this.aH) {
            return;
        } else {
            if (!this.aH) {
                z = true;
            }
        }
        this.aH = z;
        if (getActivity() instanceof ShortMovieDetailActivity) {
            ShortMovieDetailActivity shortMovieDetailActivity = (ShortMovieDetailActivity) getActivity();
            shortMovieDetailActivity.d = this.aH;
            shortMovieDetailActivity.a(shortMovieDetailActivity.d, shortMovieDetailActivity.c);
        }
    }

    private int b(int i) {
        int d = i - this.H.d();
        if (d > this.k) {
            d--;
        }
        StringBuilder stringBuilder = new StringBuilder("recyclerViewPosition: ");
        stringBuilder.append(i);
        stringBuilder.append(" getRecommendPosition: ");
        stringBuilder.append(d);
        return d;
    }

    private void a(int i, int i2) {
        this.V.clear();
        this.V.addAll(this.U);
        this.U.clear();
        while (i <= i2) {
            aw a = this.H.a(i);
            if (a != null && a.a == 182) {
                this.U.add(new com.xunlei.downloadprovider.shortvideo.videodetail.bv.a(((com.xunlei.downloadprovider.shortvideo.videodetail.model.b) a.b).a().getVideoId(), b(i), this.W));
            }
            i++;
        }
        for (com.xunlei.downloadprovider.shortvideo.videodetail.bv.a aVar : this.U) {
            if (!this.V.contains(aVar)) {
                new StringBuilder("collectVideoInfo. addReportVideo: ").append(aVar.toString());
                this.T.add(aVar);
            }
        }
        if (this.T.size() >= h) {
            new StringBuilder("report size =>").append(this.T.size());
            bv.a(this.T, this.e, new String[]{this.X, this.Y, this.Z, AndroidConfig.getPhoneModel(), com.xunlei.xllib.android.b.c(this.mActivity)});
            this.T.clear();
        }
    }

    private void a(String str, CommentInfo commentInfo) {
        if (TextUtils.isEmpty(str)) {
            XLToast.showToast(this.mActivity, "请填写评论内容");
        } else if (com.xunlei.xllib.android.b.a(this.mActivity)) {
            String phoneBrand = AndroidConfig.getPhoneBrand();
            this.q.sendEmptyMessageDelayed(203, 500);
            if (this.A.isShowing()) {
                this.A.dismiss();
            }
            this.c.a(str, phoneBrand, commentInfo);
        } else {
            XLToast.showToast(this.mActivity, "无网络连接");
        }
    }

    private void n() {
        this.H.a(this.I);
        this.H.a(this.K);
        this.H.a(this.M);
        this.H.a(this.N);
        this.H.a(2, this.l);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == R.id.fl_click_nice_bottom) {
            b("detail_shortvideo_foot");
        } else if (view == R.id.flt_comment) {
            view = this.H.c();
            if (view == -1) {
                view = this.H.b();
            }
            int findFirstVisibleItemPosition = this.R.findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition < view - 1 && (((a) this.mActivity).c() <= 0 || findFirstVisibleItemPosition < view - 2)) {
                if (this.R.findLastCompletelyVisibleItemPosition() != this.H.getItemCount() - 1) {
                    view = 1;
                    if (view != null) {
                        ((a) this.mActivity).c(true);
                        this.R.scrollToPositionWithOffset(0, 0);
                        bv.a("top");
                    }
                    ((a) this.mActivity).c(false);
                    c(((a) this.mActivity).c());
                    bv.a("discuss_area");
                    return;
                }
            }
            view = null;
            if (view != null) {
                ((a) this.mActivity).c(false);
                c(((a) this.mActivity).c());
                bv.a("discuss_area");
                return;
            }
            ((a) this.mActivity).c(true);
            this.R.scrollToPositionWithOffset(0, 0);
            bv.a("top");
        } else if (view == R.id.btn_share) {
            if (this.d != null) {
                a("detail_shortvideo_foot", "detail_shortvideo_foot");
            }
        } else if (view == R.id.tv_write_comment && this.d != null) {
            a(true, null);
            this.A.a(null);
            view = o();
            String p = p();
            this.aw = "discuss_bar";
            bv.c(this.d.a().getVideoId(), this.aw, view, p);
        }
    }

    public final boolean b(String str) {
        if (this.d == null || this.d.a().hasLike()) {
            return false;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.scale_in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.scale_out);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(getContext(), R.anim.scale_out2);
        loadAnimation.setAnimationListener(new bf(this, loadAnimation2));
        loadAnimation3.setAnimationListener(new bg(this));
        this.an.setVisibility(0);
        this.am.startAnimation(loadAnimation);
        this.an.startAnimation(loadAnimation3);
        f.a().a(getActivity(), new com.xunlei.downloadprovider.e.a.d(this.d.a().getVideoId(), this.d.a().getGcid(), this.d.a().getLikeCount()), null);
        x();
        long parseLong = Long.parseLong(this.d.b().getUid());
        if (parseLong > 0) {
            this.af.e(parseLong);
            if (this.af.d(parseLong)) {
                c(true);
            }
        }
        if (l.c()) {
            z();
        }
        bv.a(this.d.a().getVideoId(), str, this.az);
        return true;
    }

    @NonNull
    private String o() {
        String kind = this.d.b().getKind();
        if ("pub".equals(kind)) {
            return "channel";
        }
        if ("rad".equals(kind)) {
            return "per_host";
        }
        if ("yl_daren".equals(kind)) {
            return "youliao_talent";
        }
        if ("yl_nanshen".equals(kind)) {
            return "yl_nanshen";
        }
        return "yl_nvshen".equals(kind) ? "yl_nvshen" : "personal";
    }

    private String p() {
        if (this.ap == null) {
            return "";
        }
        int length = this.ap.length;
        if (length == 0) {
            return "";
        }
        int i = 1;
        if (length == 1) {
            return this.ap[0].a;
        }
        String str = this.ap[0].a;
        while (i < length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_");
            stringBuilder.append(this.ap[i].a);
            str = stringBuilder.toString();
            i++;
        }
        return str;
    }

    private String q() {
        String str = "";
        if (!From.HOME_PAGE.getText().contentEquals(this.e)) {
            if (!From.HOME_VIDEO_AUTO.getText().contentEquals(this.e)) {
                if (!(From.FEED_FLOW.getText().contentEquals(this.e) || From.FEEDFLOW_AUTOPLAY_NOSOUND.getText().contentEquals(this.e))) {
                    if (!From.FEEDFLOW_AUTOPLAY_SOUND.getText().contentEquals(this.e)) {
                        if (!From.FOLLOW_TAB_AUTO_LIST.getText().contentEquals(this.e)) {
                            if (!From.FOLLOW_TAB_VIDEO_LIST.getText().contentEquals(this.e)) {
                                if (!(From.PERSONAL_SPACE.getText().contentEquals(this.e) || From.PERSONAL_SPACE_AUTOPLAY_NOSOUND.getText().contentEquals(this.e))) {
                                    if (!From.PERSONAL_SPACE_AUTOPLAY_SOUND.getText().contentEquals(this.e)) {
                                        return (From.VIDEO_CHANNEL.getText().contentEquals(this.e) || From.CHANNEL_VIDEO_AUTO.getText().contentEquals(this.e) || From.CHANNEL_VIDEO_AUTO_SOUND.getText().contentEquals(this.e) || From.CHANNEL_FLOW.getText().contentEquals(this.e)) ? "personal" : str;
                                    }
                                }
                                return "personal";
                            }
                        }
                        return "follow";
                    }
                }
                return "feed";
            }
        }
        return "home";
    }

    private void a(boolean z, String str) {
        if (this.A == null) {
            this.A = new a(this.mActivity);
        }
        this.A.k = true;
        if (TextUtils.isEmpty(str)) {
            this.A.c();
        } else {
            this.A.b(str);
        }
        if (this.A.isShowing() == null) {
            if (z) {
                this.A.a(this.ap);
                str = o();
                String p = p();
                LoginHelper.a();
                bv.a("discuss_alert", str, p, l.c());
            } else {
                this.A.a(null);
            }
            this.A.show();
        } else if (z) {
            this.A.a(this.ap);
        } else {
            this.A.a(null);
        }
    }

    public final void a(String str, com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar) {
        String str2;
        if (this.ap == null) {
            String str3;
            if (bVar == null) {
                str3 = AccsClientConfig.DEFAULT_CONFIGTAG;
            } else {
                str3 = bVar.b().getKind();
                str2 = AccsClientConfig.DEFAULT_CONFIGTAG;
                if ("yl_nvshen".equals(str3)) {
                    str3 = "yl_female";
                } else if ("yl_nanshen".equals(str3)) {
                    str3 = "yl_male";
                } else if ("rad".equals(str3)) {
                    str3 = "live_male";
                    if (IChatUser.GENDER_FEMALE.equals(bVar.b().getSex())) {
                        str3 = "live_female";
                    }
                } else {
                    str3 = str2;
                }
            }
            this.ap = com.xunlei.downloadprovider.d.b.a().d(str3);
            this.O.b = this.ap;
            this.H.b(this.O);
            if (this.A != null && this.A.isShowing()) {
                this.A.a(this.ap);
                if (!this.at) {
                    str3 = p();
                    this.aw = q();
                    bv.c(this.d.a().getVideoId(), this.aw, o(), str3);
                    this.at = true;
                }
            }
        }
        str2 = null;
        if (!ITagManager.SUCCESS.contentEquals(str)) {
            if (this.mActivity != null) {
                ((a) this.mActivity).a(str, bVar);
            }
            if (this.d != null) {
                this.I.b = this.d;
                this.H.b(this.I);
            }
            if ("reject".contentEquals(str) != null) {
                this.d = null;
            }
            this.s = 1;
            this.E.hide();
            if (this.D != null) {
                r();
            }
            if (this.w == 1) {
                this.H.c(this.N);
                this.P.b = Boolean.valueOf(true);
                this.H.a(this.P);
                this.ad = false;
            }
        } else if (bVar != null) {
            this.s = 2;
            boolean hasLike = this.d != null ? this.d.a().hasLike() : false;
            int likeCount = this.d != null ? this.d.a().getLikeCount() : 0;
            if (this.d != null) {
                str2 = this.d.a().getTitle();
            }
            if (j()) {
                String gcid = this.d.a().getGcid();
                VideoUserInfo b = this.d.b();
                this.d = bVar;
                if (!(this.d == null || this.d.a() == null)) {
                    this.d.a().setGcid(gcid);
                    this.d.f = b;
                }
            } else {
                this.d = bVar;
            }
            this.d.a(this.al);
            if (hasLike) {
                this.d.a().setHasLike(true);
            }
            if (likeCount > bVar.a().getLikeCount()) {
                this.d.a().setLikeCount(likeCount);
            }
            com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
            if (com.xunlei.downloadprovider.homepage.recommend.feed.k.c(1, this.d.a().getVideoId())) {
                this.d.a().setHasLike(true);
            }
            if (this.d.a().hasLike()) {
                this.am.setSelected(true);
            }
            if (!(str2 == null || str2.trim().isEmpty())) {
                this.d.a().setTitle(str2);
            }
            this.c.a(this.d, j());
            this.c.a();
            if (this.w != 0) {
                int size = this.m == null ? 0 : this.m.size();
                for (int i = 0; i < size; i++) {
                    aw awVar = (aw) this.m.get(i);
                    if (awVar != null) {
                        CommentInfo commentInfo = (CommentInfo) awVar.b;
                        if (commentInfo != null) {
                            if (commentInfo.getRelatedUserInfo() == null) {
                                commentInfo.setRelatedUserInfo(new VideoUserInfo());
                            }
                            commentInfo.setPublisher(Long.parseLong(this.d.b().getUid()));
                            this.H.b(awVar);
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(this.d.a().getGcid()) && this.w == 1) {
                this.w = 0;
                this.c.b();
            }
            if (!TextUtils.isEmpty(this.d.a().getGcid()) && this.x == 1) {
                this.x = 0;
                this.c.d();
            }
            if (this.mActivity != null) {
                ((a) this.mActivity).a(str, bVar);
            }
            a();
            this.I.b = this.d;
            if (this.t != null) {
                this.H.b(this.I);
            }
            this.E.hide();
            if (this.D != null) {
                r();
            }
        }
    }

    public final void a(int i, List<v> list) {
        this.t = 2;
        this.al = list;
        if (this.d == null) {
            this.d = new com.xunlei.downloadprovider.shortvideo.videodetail.model.b();
            this.I.b = this.d;
        }
        this.d.a((List) list);
        if (this.d.a().hasLike() != null) {
            this.am.setSelected(true);
        }
        if (i > 0) {
            this.d.a().setLikeCount(i);
        }
        if (this.s != 0) {
            this.H.b(this.I);
        }
    }

    public final void a(List<e> list) {
        if (this.l == null) {
            this.l = new ArrayList(b);
        }
        if (this.Q == null) {
            this.Q = new ArrayList(b);
        }
        this.Q.clear();
        if (list != null && list.size() > 0) {
            this.Q.addAll(list);
        }
        if (list != null && list.size() > 0) {
            int min = Math.min(b, list.size());
            int i = 0;
            this.l = this.l.subList(0, min);
            while (i < min) {
                e eVar = (e) list.get(i);
                aw awVar;
                if (TextUtils.equals(eVar.a, "video")) {
                    awVar = (aw) this.l.get(i);
                    awVar.a = 182;
                    awVar.b = eVar.b;
                    if (TextUtils.isEmpty(this.X)) {
                        this.X = ((com.xunlei.downloadprovider.shortvideo.videodetail.model.b) eVar.b).a;
                        this.Y = ((com.xunlei.downloadprovider.shortvideo.videodetail.model.b) eVar.b).b;
                        this.Z = ((com.xunlei.downloadprovider.shortvideo.videodetail.model.b) eVar.b).c;
                        new StringBuilder("sparams=>").append(this.Z);
                    }
                } else if (TextUtils.equals(eVar.a, "ads")) {
                    awVar = (aw) this.l.get(i);
                    awVar.a = Opcodes.SHR_INT_2ADDR;
                    awVar.b = eVar.b;
                    this.k = i + 1;
                } else if ("site".equals(eVar.a)) {
                    awVar = (aw) this.l.get(i);
                    awVar.a = Opcodes.USHR_INT_2ADDR;
                    awVar.b = eVar.b;
                }
                i++;
            }
        }
        this.j = this.Q.size();
        if (this.Q.size() > null) {
            com.xunlei.downloadprovider.ad.d.f.a("brand");
            com.xunlei.downloadprovider.ad.d.f.a("effect");
            g();
            this.u = 2;
            if (this.H.d() == -1) {
                this.H.a(1, this.K);
                this.H.a(2, this.l);
            } else {
                h();
                this.H.a(this.l);
                this.H.a();
            }
            if (this.Q.size() > b) {
                this.H.a(this.l.size() + 2, this.L);
            } else {
                this.H.c(this.L);
            }
        } else {
            this.u = 1;
            this.H.c(this.L);
            this.H.c(this.K);
            this.H.c(this.l);
        }
        if (this.mActivity != null) {
            ((a) this.mActivity).a(this.Q);
        }
        u();
    }

    public final void a(String str) {
        if (this.mActivity != null) {
            ((a) this.mActivity).a(str);
        }
    }

    public final void a(int i, com.xunlei.downloadprovider.comment.entity.f fVar) {
        if (this.m == null) {
            this.m = new ArrayList(5);
        }
        List list = null;
        this.ab = 0;
        if (fVar != null) {
            list = fVar.e;
            this.ab = fVar.c + fVar.d;
        }
        s();
        t();
        if (this.m.isEmpty() != null || list != null) {
            b(list);
            this.H.c(this.m);
            this.m.clear();
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    CommentInfo commentInfo = (CommentInfo) it.next();
                    aw awVar = new aw();
                    awVar.a = 2;
                    awVar.b = commentInfo;
                    this.m.add(awVar);
                }
            }
            this.w = 2;
            if (i > 0) {
                this.H.c(this.N);
                this.H.c(this.O);
                this.H.c(this.P);
                this.H.b(this.m);
                this.ad = i < this.ab ? 1 : 0;
                if (this.ad == 0 && this.ab < 4) {
                    this.as[0] = Boolean.valueOf(false);
                    this.as[1] = Boolean.valueOf(true);
                    this.H.a(this.O);
                    this.av = true;
                }
            } else if (i == 0) {
                this.H.c(this.N);
                this.H.c(this.O);
                this.H.c(this.P);
                this.as[0] = Boolean.valueOf(true);
                this.as[1] = Boolean.valueOf(true);
                this.H.a(this.O);
                this.ad = false;
                this.av = true;
            } else {
                this.w = 1;
                this.H.c(this.N);
                this.H.c(this.O);
                this.H.c(this.P);
                this.H.a(this.P);
                this.ad = false;
            }
            u();
        }
    }

    private void c(int i) {
        if (i == 0) {
            i = 1;
        }
        int c = this.H.c();
        if (c == -1) {
            c = this.H.b();
        }
        StringBuilder stringBuilder = new StringBuilder("scrollToCommentArea--mSeekToComment=");
        stringBuilder.append(this.C);
        stringBuilder.append("|commentAreaPos=");
        stringBuilder.append(c);
        stringBuilder.append("|offset=");
        stringBuilder.append(i);
        stringBuilder.append("|count=");
        stringBuilder.append(this.i.getAdapter().getItemCount());
        this.R.scrollToPositionWithOffset(c, i);
        if (this.au == 0) {
            bv.a();
            this.au = true;
        }
        if (this.av != 0) {
            String o = o();
            String p = p();
            LoginHelper.a();
            bv.a("discuss_area", o, p, l.c());
            this.av = false;
        }
    }

    private void s() {
        if (this.ab > 0) {
            this.z.setText(ConvertUtil.decimal2String((long) this.ab, 10000, 10000, "万"));
            this.z.setVisibility(0);
            return;
        }
        this.z.setVisibility(4);
    }

    private void t() {
        if (this.d != null) {
            this.d.a().setCommentCount(this.ab);
        }
    }

    public final void a(com.xunlei.downloadprovider.comment.entity.f fVar) {
        if (this.m != null) {
            if (this.m.size() != 0) {
                List arrayList = new ArrayList();
                List list = null;
                if (fVar != null) {
                    list = fVar.e;
                }
                b(list);
                if (list == null || list.size() <= 0) {
                    XLToast.showToast(this.mActivity, "没有更多评论了");
                    this.ad = false;
                } else {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        CommentInfo commentInfo = (CommentInfo) it.next();
                        aw awVar = new aw();
                        awVar.a = 2;
                        awVar.b = commentInfo;
                        this.m.add(awVar);
                        arrayList.add(awVar);
                    }
                    if (this.m.size() >= this.ab) {
                        this.ad = false;
                    }
                }
                this.y = 2;
                this.H.c(this.ac);
                this.H.a(this.H.getItemCount(), arrayList);
            }
        }
    }

    public final void b(com.xunlei.downloadprovider.comment.entity.f fVar) {
        if (this.n == null) {
            this.n = new ArrayList(5);
        }
        List list = null;
        if (fVar != null) {
            list = fVar.e;
        }
        if (this.n.isEmpty() != null || list != null) {
            b(list);
            this.H.c(this.n);
            this.n.clear();
            int i = 0;
            if (list != null && list.size() > 0) {
                int size = list.size();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    CommentInfo commentInfo = (CommentInfo) it.next();
                    commentInfo.setHot(true);
                    aw awVar = new aw();
                    awVar.a = 2;
                    awVar.b = commentInfo;
                    this.n.add(awVar);
                }
                list.get(0);
                i = size;
            }
            this.x = 2;
            if (i > 0) {
                int b = this.H.b();
                if (b >= null) {
                    this.H.a(b, this.aa);
                    this.H.a(b + 1, this.n);
                } else {
                    this.H.a(this.aa);
                    this.H.b(this.n);
                }
                if (this.M.a != 1) {
                    this.M.a = 1;
                    this.H.b(this.M);
                }
            } else {
                this.H.c(this.aa);
                this.H.c(this.n);
                if (this.M.a != 10) {
                    this.M.a = 10;
                    this.H.b(this.M);
                }
            }
            u();
        }
    }

    private void u() {
        StringBuilder stringBuilder = new StringBuilder("trySeekToComment--mSeekToComment=");
        stringBuilder.append(this.C);
        stringBuilder.append("|mLoadCommentStatus=");
        stringBuilder.append(this.w);
        stringBuilder.append("|mLoadHotCommentStatus=");
        stringBuilder.append(this.x);
        if (this.C) {
            this.q.postDelayed(new bh(this), 200);
        }
    }

    public final void a(CommentInfo commentInfo) {
        long j;
        String str;
        aw awVar;
        VideoUserInfo b;
        boolean z = false;
        this.A.a(false);
        this.A.dismiss();
        this.A.a("");
        TargetCommentInfo targetCommentInfo = commentInfo.getTargetCommentList() != null ? (TargetCommentInfo) commentInfo.getTargetCommentList().get(0) : null;
        if (targetCommentInfo == null) {
            j = -1;
        } else {
            j = targetCommentInfo.getId();
        }
        long j2 = j;
        p pVar = r0.A.e;
        r0.A.a(j2);
        r0.A.e = null;
        String videoId = r0.d.a().getVideoId();
        String str2 = ITagManager.SUCCESS;
        long id = commentInfo.getId();
        boolean v = v();
        String o = o();
        boolean z2 = pVar != null;
        if (pVar != null) {
            str = pVar.a;
        } else {
            str = "";
        }
        bv.a(videoId, true, str2, j2, id, v, o, z2, str);
        r0.H.c(r0.N);
        r0.H.c(r0.P);
        if (pVar == null) {
            if (r0.ab < 3) {
                r0.as[0] = Boolean.valueOf(false);
                r0.H.b(r0.O);
                awVar = new aw();
                awVar.a = 2;
                awVar.b = commentInfo;
                r0.m.add(0, awVar);
                r0.H.a(r0.H.b() + 1, awVar);
                r0.ab++;
                s();
                t();
                r0.q.removeMessages(203);
                if (v()) {
                    XLToast.showToast(r0.mActivity, "发送评论成功");
                    return;
                }
                b = r0.d.b();
                if (Long.parseLong(b.getUid()) != r0.aq.g.c()) {
                    PublisherInfo publisherInfo = new PublisherInfo();
                    publisherInfo.a = b;
                    r0.ao.a(publisherInfo);
                    z = true;
                }
                if (z) {
                    r0.ao.show();
                }
                r0.af.g(Long.parseLong(r0.d.b().getUid()));
            }
        }
        r0.H.c(r0.O);
        awVar = new aw();
        awVar.a = 2;
        awVar.b = commentInfo;
        r0.m.add(0, awVar);
        r0.H.a(r0.H.b() + 1, awVar);
        r0.ab++;
        s();
        t();
        r0.q.removeMessages(203);
        if (v()) {
            XLToast.showToast(r0.mActivity, "发送评论成功");
            return;
        }
        b = r0.d.b();
        if (Long.parseLong(b.getUid()) != r0.aq.g.c()) {
            PublisherInfo publisherInfo2 = new PublisherInfo();
            publisherInfo2.a = b;
            r0.ao.a(publisherInfo2);
            z = true;
        }
        if (z) {
            r0.ao.show();
        }
        r0.af.g(Long.parseLong(r0.d.b().getUid()));
    }

    private boolean v() {
        if (this.d == null) {
            return false;
        }
        long parseLong = Long.parseLong(this.d.b().getUid());
        if (parseLong <= 0 || !this.af.f(parseLong)) {
            return false;
        }
        return true;
    }

    private void b(List<CommentInfo> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                List<com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a> list2 = this.c.b;
                if (list2 != null && list2.size() > 0) {
                    for (com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a aVar : list2) {
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

    public final void a(int i, String str) {
        ShortMovieDetailFragment shortMovieDetailFragment = this;
        int i2 = i;
        String str2 = str;
        if (i2 == 1) {
            if (shortMovieDetailFragment.d != null) {
                com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                if (com.xunlei.downloadprovider.homepage.recommend.feed.k.c(1, shortMovieDetailFragment.d.a().getVideoId())) {
                    shortMovieDetailFragment.d.a().setHasLike(true);
                }
                if (shortMovieDetailFragment.d.a().hasLike()) {
                    shortMovieDetailFragment.am.setSelected(true);
                }
                shortMovieDetailFragment.I.b = shortMovieDetailFragment.d;
                shortMovieDetailFragment.H.b(shortMovieDetailFragment.I);
                if (shortMovieDetailFragment.mActivity != null) {
                    ((a) shortMovieDetailFragment.mActivity).a(ITagManager.SUCCESS, shortMovieDetailFragment.d);
                }
            }
            if (shortMovieDetailFragment.w == 1) {
                shortMovieDetailFragment.H.c(shortMovieDetailFragment.N);
                shortMovieDetailFragment.H.a(shortMovieDetailFragment.P);
                shortMovieDetailFragment.ad = false;
            }
            if (shortMovieDetailFragment.ap == null) {
                shortMovieDetailFragment.ap = com.xunlei.downloadprovider.d.b.a().d(AccsClientConfig.DEFAULT_CONFIGTAG);
                shortMovieDetailFragment.O.b = shortMovieDetailFragment.ap;
                shortMovieDetailFragment.H.b(shortMovieDetailFragment.O);
                if (shortMovieDetailFragment.A != null && shortMovieDetailFragment.A.isShowing()) {
                    shortMovieDetailFragment.A.a(shortMovieDetailFragment.ap);
                }
            }
            shortMovieDetailFragment.s = 1;
            if (w()) {
                shortMovieDetailFragment.r.setVisibility(0);
                ((a) shortMovieDetailFragment.mActivity).b(true);
            } else if (shortMovieDetailFragment.D) {
                r();
            }
            shortMovieDetailFragment.E.hide();
        } else if (i2 == 13) {
            shortMovieDetailFragment.t = 1;
            if (!(shortMovieDetailFragment.d == null || shortMovieDetailFragment.d.d == null)) {
                shortMovieDetailFragment.d.a(null);
                if (shortMovieDetailFragment.s != 0) {
                    shortMovieDetailFragment.H.b(shortMovieDetailFragment.I);
                }
            }
        }
        if (i2 == 2) {
            if (shortMovieDetailFragment.j > 0) {
                XLToast.showToast(shortMovieDetailFragment.mActivity, "无法获取更多推荐");
            } else {
                shortMovieDetailFragment.u = 1;
                if (w()) {
                    shortMovieDetailFragment.E.hide();
                    shortMovieDetailFragment.r.setVisibility(0);
                    ((a) shortMovieDetailFragment.mActivity).b(true);
                }
            }
            a(null);
        } else if (i2 == 4) {
            String str3;
            if (TextUtils.isEmpty(shortMovieDetailFragment.A.a())) {
                shortMovieDetailFragment.A.a(false);
            } else {
                shortMovieDetailFragment.A.a(true);
            }
            p pVar = shortMovieDetailFragment.A.e;
            shortMovieDetailFragment.A.e = null;
            CommentInfo commentInfo = shortMovieDetailFragment.A.b;
            long id = commentInfo == null ? -1 : commentInfo.getId();
            String videoId = shortMovieDetailFragment.d.a().getVideoId();
            boolean v = v();
            String o = o();
            boolean z = pVar != null;
            if (pVar != null) {
                str3 = pVar.a;
            } else {
                str3 = "";
            }
            bv.a(videoId, false, str2, id, -1, v, o, z, str3);
            if (pVar != null) {
                shortMovieDetailFragment.q.removeMessages(203);
                shortMovieDetailFragment.as[1] = Boolean.valueOf(true);
                shortMovieDetailFragment.H.b(shortMovieDetailFragment.O);
            }
        } else if (i2 == 9) {
            XLToast.showToast(shortMovieDetailFragment.mActivity, "删除评论失败");
        } else if (i2 == 10) {
            if (shortMovieDetailFragment.G <= 0) {
                shortMovieDetailFragment.G++;
                new StringBuilder("retry load hot comment time=>").append(shortMovieDetailFragment.G);
                shortMovieDetailFragment.x = 0;
                shortMovieDetailFragment.c.d();
                return;
            }
            shortMovieDetailFragment.G = 0;
            shortMovieDetailFragment.x = 1;
            u();
            bv.a("hot", str2);
        } else if (i2 == 12) {
            shortMovieDetailFragment.H.c(shortMovieDetailFragment.ac);
            shortMovieDetailFragment.y = 1;
            XLToast.showToast(shortMovieDetailFragment.mActivity, "加载更多评论失败");
            bv.a("morenew", str2);
        } else if (i2 == 3) {
            if (shortMovieDetailFragment.F <= 0) {
                shortMovieDetailFragment.F++;
                new StringBuilder("retry load comment time=>").append(shortMovieDetailFragment.F);
                shortMovieDetailFragment.w = 0;
                shortMovieDetailFragment.c.b();
                return;
            }
            shortMovieDetailFragment.F = 0;
            shortMovieDetailFragment.w = 1;
            if (w()) {
                shortMovieDetailFragment.E.hide();
                shortMovieDetailFragment.r.setVisibility(0);
                ((a) shortMovieDetailFragment.mActivity).b(true);
            }
            bv.a("new", str2);
            a(-1, null);
        } else {
            if (!(i2 == 5 || i2 == 8 || i2 != 7)) {
                shortMovieDetailFragment.z.setVisibility(4);
            }
        }
    }

    private boolean w() {
        return this.r.getVisibility() != 0 && TextUtils.isEmpty(this.d.a().getTitle()) && this.s == 1 && this.u == 1 && this.w == 1;
    }

    public final void b(CommentInfo commentInfo) {
        commentInfo.setLiked(true);
    }

    public final void c(String str) {
        if (this.d != null) {
            String str2 = str;
            j.a().a(getActivity(), str2, this.d.a(), this.aJ, new com.xunlei.downloadprovidershare.b.c().a(com.xunlei.downloadprovidershare.b.a.c()).a(com.xunlei.downloadprovidershare.b.a.d()).a(new com.xunlei.downloadprovidershare.b.b("下载", com.xunlei.downloadprovidershare.R.drawable.share_download_selector, ShareOperationType.DOWNLOAD)).a(com.xunlei.downloadprovidershare.b.a.e()));
        }
    }

    public final void a(ShareOperationType shareOperationType) {
        j a = j.a();
        Activity activity = getActivity();
        String str = "detail_shortvideo_playend";
        BaseVideoInfo a2 = this.d.a();
        k kVar = this.aJ;
        int b = d.a().l.b();
        if (b == n.b) {
            q.a().a(activity, "com.xunlei.plugin.qrcode", new com.xunlei.downloadprovider.homepage.redpacket.n(a, activity, str, a2, b, shareOperationType, kVar));
        } else if (b == n.c) {
            r0 = com.xunlei.downloadprovider.f.c.a(activity, str, a2, b);
            com.xunlei.downloadprovider.f.a.a();
            com.xunlei.downloadprovider.f.a.a(activity, shareOperationType, r0, kVar);
        } else {
            r0 = com.xunlei.downloadprovider.f.c.a(str, a2);
            com.xunlei.downloadprovider.f.a.a();
            com.xunlei.downloadprovider.f.a.a(activity, shareOperationType, r0, kVar);
        }
    }

    public final void c() {
        if (this.d != null && !TextUtils.isEmpty(this.d.a().getPlayUrl())) {
            Context context = this.mActivity;
            BaseVideoInfo a = this.d.a();
            String playUrl = a.getPlayUrl();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(com.xunlei.xllib.b.k.b(a.getTitle(), "UTF-8"));
            stringBuilder.append(".mp4");
            g.a(context, playUrl, stringBuilder.toString());
        } else if (com.xunlei.xllib.android.b.a(this.mActivity)) {
            XLToast.showToast(this.mActivity, this.mActivity.getResources().getString(R.string.empty_download_url));
        } else {
            XLToast.showToast(this.mActivity, this.mActivity.getResources().getString(R.string.no_net_work_4_toast));
        }
    }

    public final void d(String str) {
        if (!com.xunlei.xllib.android.b.a(this.mActivity)) {
            XLToast.showToast(this.mActivity, this.mActivity.getResources().getString(R.string.no_net_work_4_toast));
        } else if (TextUtils.isEmpty(str)) {
            XLToast.showToast(this.mActivity, this.mActivity.getResources().getString(R.string.empty_download_url));
        } else {
            g.a(this.mActivity, str, str.substring(str.lastIndexOf(47) + 1));
        }
    }

    public final void d() {
        this.p.b = false;
        this.p.a = false;
        long parseLong = Long.parseLong(this.d.b().getUid());
        this.p.c = this.af.b(parseLong) ^ 1;
        ((a) this.mActivity).a(this.p);
    }

    public final void b(boolean z) {
        if (this.p.c != z) {
            this.p.c = z;
            ((a) this.mActivity).a(this.p);
        }
    }

    public final void c(boolean z) {
        if (this.p.b != z) {
            this.q.postDelayed(new bk(this, z), 300);
        }
    }

    public final boolean e() {
        return this.i.canScrollVertically(-1);
    }

    public final void a(View view, int i, Object obj) {
        ShortMovieDetailFragment shortMovieDetailFragment = this;
        View view2 = view;
        Object obj2 = obj;
        boolean z = true;
        boolean a;
        CommentInfo commentInfo;
        String kind;
        String str;
        switch (i) {
            case 0:
                a = com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance());
                if (!(shortMovieDetailFragment.d == null || TextUtils.isEmpty(shortMovieDetailFragment.d.a().getGcid()))) {
                    if (a) {
                        if (shortMovieDetailFragment.m != null) {
                            shortMovieDetailFragment.m.clear();
                        }
                        shortMovieDetailFragment.w = 0;
                        shortMovieDetailFragment.c.b();
                        if (shortMovieDetailFragment.x == 1) {
                            shortMovieDetailFragment.x = 0;
                            shortMovieDetailFragment.c.d();
                        }
                        return;
                    }
                }
                return;
            case 1:
                if (!(shortMovieDetailFragment.d == null || shortMovieDetailFragment.d.a().hasLike())) {
                    if (j()) {
                        com.xunlei.downloadprovider.e.a.d dVar = new com.xunlei.downloadprovider.e.a.d(shortMovieDetailFragment.d.a().getVideoId(), shortMovieDetailFragment.d.a().getGcid(), shortMovieDetailFragment.d.a().getLikeCount());
                        dVar.a = 7;
                        dVar.e = false;
                        f.a().a(getActivity(), dVar, null);
                    } else {
                        f.a().a(getActivity(), new com.xunlei.downloadprovider.e.a.d(shortMovieDetailFragment.d.a().getVideoId(), shortMovieDetailFragment.d.a().getGcid(), shortMovieDetailFragment.d.a().getLikeCount()), null);
                        x();
                    }
                    long parseLong = Long.parseLong(shortMovieDetailFragment.d.b().getUid());
                    if (parseLong > 0) {
                        shortMovieDetailFragment.af.e(parseLong);
                        if (shortMovieDetailFragment.af.d(parseLong)) {
                            c(true);
                        }
                    }
                    if (l.c()) {
                        z();
                    }
                    bv.a(shortMovieDetailFragment.d.a().getVideoId(), "video", shortMovieDetailFragment.az);
                }
                return;
            case 6:
                if (shortMovieDetailFragment.d != null) {
                    long parseLong2 = Long.parseLong(shortMovieDetailFragment.d.b().getUid());
                    if (parseLong2 != -1) {
                        m.a(getContext(), parseLong2, shortMovieDetailFragment.d.b().getKind(), shortMovieDetailFragment.d.b().getNickname(), shortMovieDetailFragment.d.b().getPortraitUrl(), PublisherActivity.From.VIDEO_DETAIL, shortMovieDetailFragment.d.a().getGcid(), shortMovieDetailFragment.d.a().getVideoId());
                    }
                    return;
                }
                return;
            case 7:
                aw awVar = (aw) obj2;
                com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar = (com.xunlei.downloadprovider.shortvideo.videodetail.model.b) awVar.b;
                bv.a(b(shortMovieDetailFragment.H.d(awVar)), shortMovieDetailFragment.d.a().getVideoId(), bVar.a().getVideoId(), new String[]{bVar.a, bVar.b, bVar.c, AndroidConfig.getPhoneModel(), com.xunlei.xllib.android.b.c(shortMovieDetailFragment.mActivity)});
                a(bVar, true);
                a = shortMovieDetailFragment.d.a().isFromYouLiaoShot();
                if (!a || !d.a().r.j()) {
                    z = false;
                }
                bv.a(shortMovieDetailFragment.d.a().getVideoId(), From.VIDEO_REC.getText(), a, z);
                return;
            case 8:
                ((TextView) view2).setText("正在加载...");
                y();
                bv.b(shortMovieDetailFragment.d.a().getVideoId());
                return;
            case 9:
                shortMovieDetailFragment.B.a((CommentInfo) obj2);
                shortMovieDetailFragment.B.show();
                return;
            case 11:
                commentInfo = (CommentInfo) obj2;
                if (shortMovieDetailFragment.d != null) {
                    shortMovieDetailFragment.c.a(commentInfo);
                    CommentSateInfo commentSateInfo = new CommentSateInfo();
                    commentSateInfo.a = commentInfo.getId();
                    commentSateInfo.d = commentInfo.getRelateGcid();
                    commentSateInfo.b = commentInfo.isLiked();
                    commentSateInfo.e = commentInfo.getUserId();
                    commentSateInfo.c = commentInfo.getLikeCount();
                    StateSyncManager.a(shortMovieDetailFragment.mActivity, SourceFrom.PAGE_SHORMOVIE_DETAIL, commentSateInfo);
                    c(commentInfo);
                    if (commentInfo != null) {
                        com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                        com.xunlei.downloadprovider.homepage.recommend.feed.k.a(String.valueOf(commentInfo.getId()), commentInfo.getLikeCount());
                    }
                    bv.a(shortMovieDetailFragment.d.a().getVideoId(), commentInfo.getId(), commentInfo.isHot(), l.c());
                }
                return;
            case 12:
                if (shortMovieDetailFragment.d != null) {
                    commentInfo = (CommentInfo) obj2;
                    if (commentInfo.isPreview()) {
                        XLToast.showToast(shortMovieDetailFragment.mActivity, "此评论暂时无法回复");
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder("回复 ");
                    stringBuilder.append(commentInfo.getUserName());
                    a(false, stringBuilder.toString());
                    shortMovieDetailFragment.A.a(commentInfo);
                    shortMovieDetailFragment.A.e = null;
                    shortMovieDetailFragment.aw = commentInfo.isHot() ? "discuss_hot" : "discuss_common";
                    bv.c(shortMovieDetailFragment.d.a().getVideoId(), shortMovieDetailFragment.aw, o(), p());
                    return;
                }
                return;
            case 14:
            case 15:
                commentInfo = (CommentInfo) obj2;
                if (commentInfo != null) {
                    shortMovieDetailFragment.c.e();
                    shortMovieDetailFragment.c.f();
                    commentInfo.setGcid(shortMovieDetailFragment.d.a().getGcid());
                    commentInfo.setSourceId(shortMovieDetailFragment.d.a().getVideoId());
                    m.a(shortMovieDetailFragment.mActivity, commentInfo.getUserId(), "per", commentInfo.getUserName(), commentInfo.getUserAvatar(), PublisherActivity.From.VIDEO_DETAIL, commentInfo);
                }
                return;
            case 16:
                TargetCommentInfo targetCommentInfo = (TargetCommentInfo) obj2;
                if (targetCommentInfo != null) {
                    shortMovieDetailFragment.c.e();
                    shortMovieDetailFragment.c.f();
                    m.b(shortMovieDetailFragment.mActivity, targetCommentInfo.getUserId(), "per", targetCommentInfo.getUserName(), targetCommentInfo.getUserAvatar(), PublisherActivity.From.VIDEO_DETAIL);
                }
                return;
            case 18:
                if (shortMovieDetailFragment.d != null) {
                    kind = shortMovieDetailFragment.d.b().getKind();
                    String videoId = shortMovieDetailFragment.d.a().getVideoId();
                    String uid = shortMovieDetailFragment.d.b().getUid();
                    String str2 = (kind == null || !kind.contentEquals("per")) ? "channel" : "personal";
                    String str3 = str2;
                    String str4 = "follow_button";
                    boolean c = l.c();
                    boolean z2 = shortMovieDetailFragment.p != null && shortMovieDetailFragment.p.b;
                    bv.a(videoId, uid, str3, str4, c, z2);
                    c(false);
                    if (l.c()) {
                        b(false);
                        a("follow_button", view2, true);
                    } else {
                        String videoId2 = shortMovieDetailFragment.d.a().getVideoId();
                        str2 = shortMovieDetailFragment.d.b().getUid();
                        kind = (kind == null || !kind.contentEquals("per")) ? "channel" : "personal";
                        bv.a(videoId2, str2, kind, "follow_button", l.c(), "skip_login", "", C());
                        shortMovieDetailFragment.aq.a(shortMovieDetailFragment.mActivity, new bm(shortMovieDetailFragment, view2), LoginFrom.VIDEO_DETAIL_FOLLOW, null);
                        return;
                    }
                }
                return;
            case 19:
                if (shortMovieDetailFragment.d != null) {
                    a("detail_shortvideo_top", "detail_shortvideo_top");
                    return;
                }
                return;
            case 20:
                return;
            case 21:
                v vVar = (v) obj2;
                if (vVar != null) {
                    m.a(shortMovieDetailFragment.mActivity, vVar.a, "per", vVar.b, vVar.c, PublisherActivity.From.VIDEO_DETAIL);
                    kind = shortMovieDetailFragment.d.a().getVideoId();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(vVar.a);
                    bv.c(kind, stringBuilder2.toString());
                }
                return;
            case 22:
                p pVar = (p) obj2;
                if (!(shortMovieDetailFragment.d == null || pVar == null)) {
                    shortMovieDetailFragment.A.e = pVar;
                    shortMovieDetailFragment.A.a(null);
                    bv.a(pVar.a, l.c(), o(), "discuss_area");
                    if (!r.a().a(getContext(), LoginFrom.VIDEO_DETAIL_USER_DISCUSS_DEFAULT, shortMovieDetailFragment.ay)) {
                        a(pVar.b, null);
                    }
                }
                return;
            case 23:
                com.xunlei.downloadprovider.ad.d.f.a(getActivity(), view2, obj2);
                return;
            case 24:
                com.xunlei.downloadprovider.ad.d.f.a(getActivity(), view2, obj2);
                return;
            case 26:
                if (!shortMovieDetailFragment.az && shortMovieDetailFragment.R.findFirstVisibleItemPosition() == 0) {
                    shortMovieDetailFragment.az = true;
                    if (shortMovieDetailFragment.d == null) {
                        str = "";
                    } else {
                        str = shortMovieDetailFragment.d.a().getVideoId();
                    }
                    bv.d(str);
                    return;
                }
            case 27:
                if (d.a().r.i()) {
                    str = "shortvideo_detail_shot";
                    if (ApkHelper.isApkPackageInstalled(getContext(), "cn.kuaipan.android")) {
                        ApkHelper.launchAppByPackageName(getContext(), "cn.kuaipan.android");
                        kind = "open";
                    } else {
                        Context context = getContext();
                        if (context != null) {
                            new com.xunlei.downloadprovider.publiser.campaign.d(context, str, new bl(shortMovieDetailFragment, str)).show();
                        }
                        kind = "download";
                    }
                    com.xunlei.downloadprovider.cooperation.a.a.b(str, kind, "youliao");
                    break;
                }
                return;
            default:
                break;
        }
    }

    private void a(String str, String str2) {
        c(str);
        bv.c(str2);
    }

    private void x() {
        com.xunlei.downloadprovider.e.a.a.a(getContext(), this.d != null ? this.d.a().getVideoId() : "", "video", "detail");
    }

    private void y() {
        this.W = 1;
        for (int i = b; i < this.Q.size(); i++) {
            aw awVar = new aw();
            e eVar = (e) this.Q.get(i);
            if (TextUtils.equals(eVar.a, "video")) {
                awVar.a = 182;
                awVar.b = eVar.b;
            } else if (TextUtils.equals(eVar.a, "ads")) {
                awVar.a = Opcodes.SHR_INT_2ADDR;
                awVar.b = eVar.b;
                this.k = i + 1;
            }
            this.l.add(awVar);
            this.H.a(this.l.size() + 2, awVar);
        }
        this.H.c(this.L);
    }

    private void z() {
        v vVar = new v();
        vVar.a = this.aq.g.c();
        vVar.c = this.aq.e();
        vVar.e = true;
        vVar.b = this.aq.g.d();
        vVar.d = this.aq.h();
        List list = this.d.d;
        if (list == null) {
            list = new ArrayList();
            this.d.a(list);
        }
        list.add(0, vVar);
        this.H.b(this.I);
    }

    private void c(CommentInfo commentInfo) {
        CommentInfo commentInfo2;
        if (commentInfo.isHot()) {
            for (aw awVar : this.m) {
                commentInfo2 = (CommentInfo) awVar.b;
                if (commentInfo2.getId() == commentInfo.getId()) {
                    commentInfo2.setLiked(commentInfo.isLiked());
                    commentInfo2.setLikeCount(commentInfo.getLikeCount());
                    this.H.b(awVar);
                    return;
                }
            }
            return;
        }
        if (this.n != null) {
            if (this.n.size() > 0) {
                for (aw awVar2 : this.n) {
                    commentInfo2 = (CommentInfo) awVar2.b;
                    if (commentInfo2.getId() == commentInfo.getId()) {
                        commentInfo2.setLiked(commentInfo.isLiked());
                        commentInfo2.setLikeCount(commentInfo.getLikeCount());
                        this.H.b(awVar2);
                        return;
                    }
                }
            }
        }
    }

    final void a(com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar, boolean z) {
        A();
        if (this.mActivity instanceof a) {
            this.i.scrollToPosition(0);
            ((a) this.mActivity).a(bVar, z);
            e(true);
            this.d = bVar;
            a();
            this.e = From.VIDEO_REC.getText();
            this.c.a(bVar, j());
            this.c.a();
            i();
        }
    }

    private void A() {
        a(this.R.findFirstVisibleItemPosition(), this.R.findLastVisibleItemPosition());
        if (this.T.size() > 0) {
            new StringBuilder("onItemClick report size =>").append(this.T.size());
            bv.a(this.T, this.e, new String[]{this.X, this.Y, this.Z, AndroidConfig.getPhoneModel(), com.xunlei.xllib.android.b.c(this.mActivity)});
            this.T.clear();
        }
        this.V.clear();
        this.U.clear();
    }

    public final void e(String str) {
        a(str, null, false);
    }

    public final void a(String str, View view) {
        a(str, view, true);
    }

    private void a(String str, View view, boolean z) {
        if (this.ao != null && this.ao.isShowing()) {
            this.ao.dismiss();
        }
        long parseLong = Long.parseLong(this.d.b().getUid());
        if (this.af.b(parseLong)) {
            XLToast.showToast(this.mActivity, "您已关注");
            d();
        } else if (com.xunlei.xllib.android.b.a(this.mActivity)) {
            this.af.a(parseLong, z, true, new bn(this, parseLong, str, view));
        } else {
            XLToast.showToast(this.mActivity, "无网络连接");
        }
    }

    public final void d(boolean z) {
        this.aA.setVisibility(z ? 0 : 8);
        if (!j() && d.a().l.d()) {
            if (z) {
                this.aD.setVisibility(0);
            } else {
                if (this.aF) {
                    this.aF.setVisibility(8);
                }
                this.aD.setVisibility(4);
            }
            l();
        }
    }

    private void B() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.S);
        for (String str : linkedHashMap.keySet()) {
            linkedHashMap.get(str);
        }
    }

    public final List<com.xunlei.downloadprovider.shortvideo.videodetail.model.b> f() {
        if (this.Q != null) {
            if (!this.Q.isEmpty()) {
                if (this.f == null) {
                    this.f = new ArrayList(b);
                }
                if (this.f.isEmpty()) {
                    for (e eVar : this.Q) {
                        if (TextUtils.equals(eVar.a, "video")) {
                            this.f.add((com.xunlei.downloadprovider.shortvideo.videodetail.model.b) eVar.b);
                        }
                    }
                }
                return this.f;
            }
        }
        return null;
    }

    private void r() {
        a(true, null);
        Object p = p();
        if (!this.at && !TextUtils.isEmpty(p)) {
            this.aw = q();
            bv.c(this.d.a().getVideoId(), this.aw, o(), p);
            this.at = true;
        }
    }

    public final void a(long j) {
        Iterator it;
        ArrayList arrayList = new ArrayList(1);
        for (aw awVar : this.m) {
            aw awVar2;
            CommentInfo commentInfo = (CommentInfo) awVar2.b;
            if (commentInfo.getId() == j) {
                arrayList.add(awVar2);
            } else {
                List targetCommentList = commentInfo.getTargetCommentList();
                if (targetCommentList != null && targetCommentList.size() > 0) {
                    TargetCommentInfo targetCommentInfo = (TargetCommentInfo) targetCommentList.get(0);
                    if (targetCommentInfo.getId() == j) {
                        targetCommentInfo.setId(-1);
                        this.H.b(awVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            this.ab -= arrayList.size();
            s();
            t();
            it = arrayList.iterator();
            while (it.hasNext()) {
                awVar2 = (aw) it.next();
                this.m.remove(awVar2);
                this.H.c(awVar2);
            }
            arrayList.clear();
            if (this.m.isEmpty()) {
                this.as[0] = Boolean.valueOf(true);
                this.as[1] = Boolean.valueOf(true);
                this.H.c(this.O);
                this.H.a(this.H.b() + 1, this.O);
                String o = o();
                String p = p();
                LoginHelper.a();
                bv.a("discuss_area", o, p, l.c());
            }
        }
        if (this.n != null) {
            if (!this.n.isEmpty()) {
                for (aw awVar3 : this.n) {
                    CommentInfo commentInfo2 = (CommentInfo) awVar3.b;
                    if (commentInfo2.getId() == j) {
                        arrayList.add(awVar3);
                    } else {
                        List targetCommentList2 = commentInfo2.getTargetCommentList();
                        if (targetCommentList2 != null && targetCommentList2.size() > 0) {
                            TargetCommentInfo targetCommentInfo2 = (TargetCommentInfo) targetCommentList2.get(0);
                            if (targetCommentInfo2.getId() == j) {
                                targetCommentInfo2.setId(-1);
                                this.H.b(awVar3);
                            }
                        }
                    }
                }
                j = arrayList.iterator();
                while (j.hasNext()) {
                    aw awVar4 = (aw) j.next();
                    this.n.remove(awVar4);
                    this.H.c(awVar4);
                }
                if (!(this.n == null || this.n.isEmpty() == null)) {
                    this.H.c(this.aa);
                }
            }
        }
        XLToast.showToast(this.mActivity, "删除评论成功");
    }

    public final void a(com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar) {
        if (bVar != null) {
            A();
            boolean z = true;
            if (this.mActivity instanceof a) {
                this.i.scrollToPosition(0);
                e(true);
                this.d = bVar;
                a();
                this.e = From.VIDEO_REC.getText();
                this.c.a(bVar, j());
                this.c.a();
                i();
                this.o.setText("");
            }
            this.e = From.VIDEO_SCREEN.getText();
            boolean isFromYouLiaoShot = this.d.a().isFromYouLiaoShot();
            if (isFromYouLiaoShot == null || !d.a().r.j()) {
                z = false;
            }
            bv.a(this.d.a().getVideoId(), this.e, isFromYouLiaoShot, z);
        }
    }

    private int C() {
        ShortMovieDetailActivity shortMovieDetailActivity = (ShortMovieDetailActivity) getActivity();
        if (shortMovieDetailActivity == null) {
            return 0;
        }
        ThunderXmpPlayer thunderXmpPlayer = shortMovieDetailActivity.a;
        if (thunderXmpPlayer != null) {
            if (thunderXmpPlayer.i != null) {
                return thunderXmpPlayer.i.b();
            }
        }
        return 0;
    }

    static /* synthetic */ void a(ShortMovieDetailFragment shortMovieDetailFragment, Intent intent) {
        if (((SourceFrom) SourceFrom.valueOf(SourceFrom.class, intent.getStringExtra("source_from"))) != SourceFrom.PAGE_SHORMOVIE_DETAIL) {
            CommentSateInfo commentSateInfo = (CommentSateInfo) intent.getParcelableExtra("comment_info");
            if (shortMovieDetailFragment.d != null) {
                if (TextUtils.equals(commentSateInfo.d, shortMovieDetailFragment.d.a().getGcid())) {
                    CommentInfo commentInfo;
                    for (aw awVar : shortMovieDetailFragment.m) {
                        commentInfo = (CommentInfo) awVar.b;
                        if (commentInfo.getId() == commentSateInfo.a) {
                            commentInfo.setLiked(commentSateInfo.b);
                            commentInfo.setLikeCount(commentSateInfo.c);
                            shortMovieDetailFragment.H.b(awVar);
                            break;
                        }
                    }
                    if (shortMovieDetailFragment.n != null) {
                        if (shortMovieDetailFragment.n.size() > 0) {
                            for (aw awVar2 : shortMovieDetailFragment.n) {
                                commentInfo = (CommentInfo) awVar2.b;
                                if (commentInfo.getId() == commentSateInfo.a) {
                                    commentInfo.setLiked(commentSateInfo.b);
                                    commentInfo.setLikeCount(commentSateInfo.c);
                                    shortMovieDetailFragment.H.b(awVar2);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ boolean d(ShortMovieDetailFragment shortMovieDetailFragment) {
        return shortMovieDetailFragment.u == 2 ? true : null;
    }

    static /* synthetic */ void a(ShortMovieDetailFragment shortMovieDetailFragment, int i) {
        if (i == 0 || i == 1) {
            int findFirstVisibleItemPosition = shortMovieDetailFragment.R.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = shortMovieDetailFragment.R.findLastVisibleItemPosition();
            shortMovieDetailFragment.a(findFirstVisibleItemPosition, findLastVisibleItemPosition);
            shortMovieDetailFragment.C = false;
            shortMovieDetailFragment.D = false;
            if (!shortMovieDetailFragment.au) {
                findFirstVisibleItemPosition = shortMovieDetailFragment.H.b();
                if (findFirstVisibleItemPosition > 0 && findLastVisibleItemPosition > findFirstVisibleItemPosition) {
                    bv.a();
                    shortMovieDetailFragment.au = true;
                    if (shortMovieDetailFragment.av) {
                        String o = shortMovieDetailFragment.o();
                        String p = shortMovieDetailFragment.p();
                        LoginHelper.a();
                        bv.a("discuss_area", o, p, l.c());
                    }
                }
            }
        }
        if (!(shortMovieDetailFragment.y == 0 || shortMovieDetailFragment.w == 0)) {
            if (shortMovieDetailFragment.ad) {
                if (i == 0 && shortMovieDetailFragment.R.findLastVisibleItemPosition() >= shortMovieDetailFragment.H.getItemCount() - 2) {
                    shortMovieDetailFragment.y = 0;
                    shortMovieDetailFragment.H.a(shortMovieDetailFragment.ac);
                    shortMovieDetailFragment.c.c();
                }
            }
        }
    }

    static /* synthetic */ void E(ShortMovieDetailFragment shortMovieDetailFragment) {
        String trim = shortMovieDetailFragment.A.a().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            XLToast.showToast(shortMovieDetailFragment.mActivity, "请填写评论内容");
        } else if (com.xunlei.xllib.android.b.a(shortMovieDetailFragment.mActivity)) {
            shortMovieDetailFragment.A.a(false);
            shortMovieDetailFragment.c.a(trim, AndroidConfig.getPhoneBrand(), shortMovieDetailFragment.A.b);
        } else {
            XLToast.showToast(shortMovieDetailFragment.mActivity, "无网络连接");
        }
    }

    static /* synthetic */ void ac(ShortMovieDetailFragment shortMovieDetailFragment) {
        long parseLong = Long.parseLong(shortMovieDetailFragment.d.b().getUid());
        if (parseLong > 0) {
            if (!shortMovieDetailFragment.af.b(parseLong)) {
                shortMovieDetailFragment.c(true);
            }
        }
    }
}
