package com.xunlei.downloadprovider.contentpublish.website;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build.VERSION;
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
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.AccsClientConfig;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.contentpublish.website.a.h;
import com.xunlei.downloadprovider.e.a.d;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.common.PublisherInfo;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap;
import com.xunlei.downloadprovider.shortvideo.videodetail.i;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.StateSyncManager;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.StateSyncManager.CommentSateInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.StateSyncManager.SourceFrom;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.c;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.k;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WebsiteDetailFragment extends BaseFragment implements OnClickListener, com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a, com.xunlei.downloadprovider.shortvideo.videodetail.model.g.a, k {
    public static final String a = "WebsiteDetailFragment";
    private aw A;
    private ImageView B;
    private aw C;
    private aw D;
    private aw E;
    private aw F;
    private LinearLayoutManager G;
    private String H;
    private aw I;
    private int J = 0;
    private aw K;
    private boolean L = false;
    private BroadcastReceiver M;
    private b N;
    private LocalBroadcastManager O;
    private BroadcastReceiver P;
    private e Q;
    private f R;
    private aa S;
    private List<v> T;
    private ImageView U;
    private TextView V;
    private com.xunlei.downloadprovider.shortvideo.videodetail.widget.b W;
    private boolean X;
    private p[] Y;
    private LoginHelper Z = LoginHelper.a();
    private Object[] aa = new Object[]{Boolean.valueOf(true), Boolean.valueOf(true)};
    private boolean ab = false;
    private boolean ac = false;
    private boolean ad;
    private String ae;
    private List<com.xunlei.downloadprovider.shortvideo.videodetail.model.b> af;
    private com.xunlei.downloadprovider.member.login.authphone.p ag;
    private com.xunlei.downloadprovider.member.login.authphone.p ah;
    private boolean ai = false;
    private View aj;
    private ImageView ak;
    private VideoUserInfo al;
    private com.xunlei.downloadprovider.contentpublish.website.a.b am;
    private RecyclerView b;
    private g c;
    private int d = 0;
    private List<aw> e;
    private List<aw> f;
    private List<aw> g;
    private TextView h;
    private WebsiteInfo i;
    private c j = new c();
    private Handler k;
    private ErrorBlankView l;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 2;
    private TextView r;
    private com.xunlei.downloadprovider.shortvideo.videodetail.a s;
    private i t;
    private boolean u;
    private UnifiedLoadingView v;
    private int w = 0;
    private int x = 0;
    private ap y;
    private ArrayList<aw> z;

    public interface a {
        void a(VideoUserInfo videoUserInfo);

        void a(c cVar);

        void a(boolean z);
    }

    public final void a(String str) {
    }

    public final void a(String str, com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar) {
    }

    public final void a(List<com.xunlei.downloadprovider.shortvideo.videodetail.model.e> list) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mPageRoot = (ViewGroup) layoutInflater.inflate(R.layout.fragment_website_detail_layout, null);
        this.b = (RecyclerView) findViewById(R.id.rcv_contents);
        this.G = new LinearLayoutManager(this.mActivity);
        this.b.setLayoutManager(this.G);
        this.y = new ap(this.mActivity, this);
        this.b.setAdapter(this.y);
        this.b.setItemAnimator(new com.xunlei.downloadprovider.shortvideo.videodetail.k());
        this.aj = this.mActivity.findViewById(R.id.lyt_write_comment);
        this.aj.findViewById(R.id.flt_comment).setOnClickListener(this);
        this.r = (TextView) this.mActivity.findViewById(R.id.tv_comment_count);
        this.B = (ImageView) this.mActivity.findViewById(R.id.btn_share);
        this.B.setVisibility(0);
        this.mActivity.findViewById(R.id.fl_click_nice_bottom).setOnClickListener(this);
        this.U = (ImageView) this.mActivity.findViewById(R.id.iv_good_icon_bottom);
        this.V = (TextView) this.mActivity.findViewById(R.id.tv_plus_one_bottom);
        this.h = (TextView) this.mActivity.findViewById(R.id.tv_write_comment);
        this.ak = (ImageView) this.mActivity.findViewById(R.id.btn_comment);
        this.aj.setBackgroundColor(-1);
        this.h.setBackgroundResource(R.drawable.ic_input_bg_round);
        this.h.setTextColor(Color.parseColor("#5a6473"));
        this.h.setHintTextColor(Color.parseColor("#5a6473"));
        this.B.setImageResource(R.drawable.ic_detail_share_black);
        this.ak.setImageResource(R.drawable.ic_detail_comment_black);
        this.U.setImageResource(R.drawable.ic_shortdetail_like_selector);
        this.l = (ErrorBlankView) findViewById(R.id.ev_try);
        b(false);
        this.v = (UnifiedLoadingView) findViewById(R.id.ulv_loading);
        this.v.setBackgroundColor(Color.parseColor("#ffffff"));
        this.v.hidePageLoadingViewBack();
        this.v.setOnTouchListener(new ah(this));
        this.W = new com.xunlei.downloadprovider.shortvideo.videodetail.widget.b(getContext());
        this.W.a = new aj(this);
        this.t = new i(this.mActivity);
        this.b.addOnScrollListener(new al(this));
        this.B.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.s = new com.xunlei.downloadprovider.shortvideo.videodetail.a(this.mActivity);
        this.s.a(new h(this));
        this.s.d = new i(this);
        this.s.setOnDismissListener(new j(this));
        this.t.a(new k(this));
        this.t.b(new l(this));
        this.t.c(new m(this));
        this.t.d(new n(this));
        this.Q = new o(this);
        this.R = f.a();
        this.R.a(5, this.Q);
        this.S = new p(this);
        ab.a().a(this.S);
        this.ag = new q(this);
        this.ah = new s(this);
        this.z = new ArrayList();
        this.A = new aw();
        this.A.b = this.i;
        this.A.c = this.T;
        this.A.a = 18;
        this.I = new aw();
        this.I.a = 10;
        this.I.b = "热门评论";
        this.I.c = "hot";
        this.g = new ArrayList();
        this.C = new aw();
        this.C.a = 10;
        this.C.b = "最新评论";
        this.C.c = "new";
        this.f = new ArrayList();
        this.D = new aw();
        this.D.a = 11;
        this.D.b = null;
        this.E = new aw();
        this.E.a = 4;
        this.E.b = this.Y;
        this.E.c = this.aa;
        this.F = new aw();
        this.F.a = 5;
        this.F.b = null;
        this.K = new aw();
        this.K.a = 9;
        this.K.b = null;
        e();
        return this.mPageRoot;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k = new g(this);
        bundle = getArguments();
        this.i = (WebsiteInfo) bundle.getParcelable("video_nfo");
        this.al = (VideoUserInfo) bundle.getParcelable(VideoUserInfo.JSON_KEY);
        if (this.al == null) {
            this.al = new VideoUserInfo();
        }
        this.H = bundle.getString("from");
        this.u = bundle.getBoolean("seek_to_comment", false);
        this.X = false;
        this.N = b.a();
        a();
        this.c = new g(this.mActivity);
        this.am = new com.xunlei.downloadprovider.contentpublish.website.a.b();
        this.c.a = this;
        this.c.a(new com.xunlei.downloadprovider.comment.entity.e(5, this.i.a, this.i.a));
        this.c.c = this.i.b;
        this.c.a();
        this.M = new r(this);
        bundle = new IntentFilter();
        bundle.addAction("action_comment_zan_state_changed");
        this.mActivity.registerReceiver(this.M, bundle);
        this.P = new ac(this);
        this.O = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
        bundle = new IntentFilter();
        bundle.addAction("new_follow");
        bundle.addAction("cancel_follow");
        bundle.addAction("new_user_login_success");
        bundle.addAction("user_logout");
        this.O.registerReceiver(this.P, bundle);
    }

    final void a() {
        long parseLong = Long.parseLong(this.al.getUid());
        this.j.a = this.N.b(parseLong) ^ 1;
        this.j.c = this.N.b(parseLong) ^ 1;
        ((a) this.mActivity).a(this.j);
    }

    public void onResume() {
        super.onResume();
        if (!this.l.isShown() || this.l.getErrorType() != 1) {
            StringBuilder stringBuilder;
            if (this.l.isShown()) {
                this.l.setVisibility(8);
                ((a) this.mActivity).a(false);
                this.v.show();
            }
            if (this.m == 1) {
                this.m = 0;
                d();
            }
            if (this.p == 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.i.a);
                if (!TextUtils.isEmpty(stringBuilder.toString())) {
                    this.p = 0;
                    this.c.d();
                }
            }
            if (this.o == 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.i.a);
                if (!TextUtils.isEmpty(stringBuilder.toString())) {
                    this.o = 0;
                    this.c.b();
                }
            }
        }
    }

    public void onDestroy() {
        this.c.e();
        this.c.f();
        this.R.b(1, this.Q);
        ab.a().b(this.S);
        this.mActivity.unregisterReceiver(this.M);
        this.O.unregisterReceiver(this.P);
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.u != null) {
            k();
        }
        c();
    }

    private void c() {
        this.v.show();
        this.m = 0;
        this.n = 0;
        d();
        this.c.a(this.i.a, 5);
        if (TextUtils.isEmpty(this.i.a)) {
            this.o = 1;
            this.p = 1;
            return;
        }
        this.o = 0;
        this.p = 0;
        this.c.d();
        this.c.b();
    }

    private void d() {
        com.xunlei.downloadprovider.contentpublish.website.a.b bVar = this.am;
        String str = this.i.a;
        com.xunlei.downloadprovider.member.payment.a.e.c afVar = new af(this);
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/fav_site/api/pub/");
        stringBuilder.append(str);
        bVar.a(new ar(0, stringBuilder.toString(), new com.xunlei.downloadprovider.contentpublish.website.a.g(bVar, afVar), new h(bVar, afVar)));
    }

    private void b(boolean z) {
        this.l.setErrorType(2);
        this.l.setVisibility(z ? false : true);
        this.l.a("刷新", new ai(this));
    }

    private void a(String str, CommentInfo commentInfo) {
        if (TextUtils.isEmpty(str)) {
            XLToast.showToast(this.mActivity, "请填写评论内容");
        } else if (com.xunlei.xllib.android.b.a(this.mActivity)) {
            String phoneBrand = AndroidConfig.getPhoneBrand();
            this.k.sendEmptyMessageDelayed(203, 500);
            if (this.s.isShowing()) {
                this.s.dismiss();
            }
            this.c.a(str, phoneBrand, commentInfo);
        } else {
            XLToast.showToast(this.mActivity, "无网络连接");
        }
    }

    private void e() {
        this.y.a(this.A);
        this.y.a(this.C);
        this.y.a(this.D);
    }

    public void onClick(View view) {
        if (f()) {
            view = view.getId();
            if (view == R.id.fl_click_nice_bottom) {
                if (this.i != null && this.i.j == null) {
                    view = AnimationUtils.loadAnimation(getContext(), R.anim.scale_in);
                    Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.scale_out);
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.scale_out2);
                    view.setAnimationListener(new v(this, loadAnimation));
                    loadAnimation2.setAnimationListener(new w(this));
                    this.V.setVisibility(0);
                    this.U.startAnimation(view);
                    this.V.startAnimation(loadAnimation2);
                    g();
                }
                return;
            }
            boolean z = true;
            if (view == R.id.flt_comment) {
                view = this.y.c();
                if (view == -1) {
                    view = this.y.b();
                }
                if (this.G.findFirstVisibleItemPosition() >= view || this.G.findLastCompletelyVisibleItemPosition() == this.y.getItemCount() - 1) {
                    z = false;
                }
                if (z) {
                    k();
                    com.xunlei.downloadprovider.contentpublish.website.a.a.a("discuss_area");
                    return;
                }
                this.G.scrollToPositionWithOffset(0, 0);
                com.xunlei.downloadprovider.contentpublish.website.a.a.a("top");
            } else if (view == R.id.btn_share) {
                if (this.i != null) {
                    d("detail_news_foot");
                }
            } else if (view == R.id.tv_write_comment && this.i != null) {
                c(true);
                this.s.a(null);
                this.ae = "discuss_bar";
                String str = this.i.a;
                String str2 = this.ae;
                String a = com.xunlei.xllib.b.k.a(this.i.f, "UTF-8");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.i.b);
                com.xunlei.downloadprovider.contentpublish.website.a.a.a(str, str2, a, stringBuilder.toString());
            }
        }
    }

    private boolean f() {
        if (this.i != null) {
            if (!TextUtils.isEmpty(this.i.a)) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        if (!(this.i == null || this.i.j)) {
            d dVar = new d(this.i.a, this.i.a, this.i.k);
            dVar.a = 5;
            dVar.e = false;
            f.a().a(getActivity(), dVar, null);
            long parseLong = Long.parseLong(this.al.getUid());
            if (parseLong > 0) {
                this.N.e(parseLong);
                if (this.N.d(parseLong)) {
                    d(true);
                }
            }
            com.xunlei.downloadprovider.contentpublish.website.a.a.a(this.i.a, com.xunlei.xllib.b.k.a(this.i.f, "UTF-8"), this.al.getUid());
            this.i.j = true;
            this.U.setSelected(true);
            if (l.c()) {
                v vVar = new v();
                vVar.a = this.Z.g.c();
                vVar.c = this.Z.e();
                vVar.e = true;
                vVar.b = this.Z.g.d();
                vVar.d = this.Z.h();
                List list = this.T;
                if (list == null) {
                    list = new ArrayList();
                    this.T = list;
                }
                list.add(0, vVar);
                this.y.b(this.A);
                return;
            }
            this.y.b(this.A);
        }
    }

    @NonNull
    private String h() {
        String kind = this.al.getKind();
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

    private String i() {
        if (this.Y == null) {
            return "";
        }
        int length = this.Y.length;
        if (length == 0) {
            return "";
        }
        int i = 1;
        if (length == 1) {
            return this.Y[0].a;
        }
        String str = this.Y[0].a;
        while (i < length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_");
            stringBuilder.append(this.Y[i].a);
            str = stringBuilder.toString();
            i++;
        }
        return str;
    }

    private void c(boolean z) {
        if (this.s == null) {
            this.s = new com.xunlei.downloadprovider.shortvideo.videodetail.a(this.mActivity);
        }
        this.s.c();
        this.s.k = true;
        if (!this.s.isShowing()) {
            if (this.X && z) {
                this.s.a(this.Y);
                String h = h();
                String i = i();
                LoginHelper.a();
                com.xunlei.downloadprovider.contentpublish.website.a.a.a("discuss_alert", h, i, l.c());
            } else {
                this.s.a(null);
            }
            this.s.show();
        } else if (this.X && z) {
            this.s.a(this.Y);
        } else {
            this.s.a(null);
        }
    }

    final void a(String str, WebsiteInfo websiteInfo, VideoUserInfo videoUserInfo) {
        String str2;
        String kind;
        String str3;
        StringBuilder stringBuilder;
        if (!this.X) {
            this.Y = null;
        } else if (this.Y == null) {
            VideoUserInfo videoUserInfo2 = this.al;
            if (videoUserInfo2 == null) {
                str2 = AccsClientConfig.DEFAULT_CONFIGTAG;
            } else {
                kind = videoUserInfo2.getKind();
                str3 = AccsClientConfig.DEFAULT_CONFIGTAG;
                if ("yl_nvshen".equals(kind)) {
                    str2 = "yl_female";
                } else if ("yl_nanshen".equals(kind)) {
                    str2 = "yl_male";
                } else if ("rad".equals(kind)) {
                    str2 = IChatUser.GENDER_FEMALE.equals(videoUserInfo2.getSex()) ? "live_female" : "live_male";
                } else {
                    str2 = str3;
                }
            }
            this.Y = com.xunlei.downloadprovider.d.b.a().d(str2);
            this.E.b = this.Y;
            this.y.b(this.E);
            if (this.s != null && this.s.isShowing()) {
                this.s.a(this.Y);
                if (!this.ab) {
                    this.ae = this.H;
                    str2 = this.i.a;
                    kind = this.ae;
                    str3 = com.xunlei.xllib.b.k.a(this.i.f, "UTF-8");
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(this.i.b);
                    com.xunlei.downloadprovider.contentpublish.website.a.a.a(str2, kind, str3, stringBuilder.toString());
                    this.ab = true;
                }
            }
        }
        str2 = websiteInfo.a;
        kind = this.H;
        str3 = com.xunlei.xllib.b.k.a(websiteInfo.f, "UTF-8");
        stringBuilder = new StringBuilder();
        stringBuilder.append(websiteInfo.b);
        com.xunlei.downloadprovider.contentpublish.website.a.a.a(str2, kind, str3, stringBuilder.toString(), TextUtils.equals("not exist", str) ^ true);
        if (!TextUtils.equals(ITagManager.SUCCESS, str)) {
            if (this.i != null) {
                this.A.b = this.i;
                this.y.b(this.A);
            }
            if (TextUtils.equals("not exist", str) != null) {
                this.i = null;
                this.l.setErrorType(1);
                this.l.setVisibility(0);
                this.l.a(null, null);
                this.l.a((int) R.drawable.commonui_bg_page_gone, (int) R.string.commonui_page_file_gone);
                this.l.setOnTouchListener(new x(this));
                this.aj.setVisibility(8);
                ((a) this.mActivity).a(true);
            }
            this.m = 1;
            this.v.hide();
            if (this.o == 1) {
                this.y.c(this.D);
                this.y.a(this.F);
                this.L = false;
            }
            if (this.o == 1) {
                this.y.c(this.D);
                this.y.a(this.F);
                this.L = false;
            }
        } else if (websiteInfo != null) {
            int i;
            this.m = 2;
            if (this.i != null) {
                str = this.i.j;
            } else {
                str = null;
            }
            if (this.i != null) {
                i = this.i.k;
            } else {
                i = 0;
            }
            if (this.i != null) {
                String str4 = this.i.e;
            }
            this.i = websiteInfo;
            this.al = videoUserInfo;
            if (str != null) {
                this.i.j = true;
            }
            if (i > websiteInfo.k) {
                this.i.k = i;
            }
            com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
            if (com.xunlei.downloadprovider.homepage.recommend.feed.k.c(1, this.i.a) != null) {
                this.i.j = true;
            }
            if (this.i.j != null) {
                this.U.setSelected(true);
            }
            if (this.o != null) {
                j();
            }
            if (TextUtils.isEmpty(this.i.a) == null && this.o == 1) {
                this.o = 0;
                this.c.b();
            }
            if (TextUtils.isEmpty(this.i.a) == null && this.p == 1) {
                this.p = 0;
                this.c.d();
            }
            this.A.b = this.i;
            this.y.b(this.A);
            ((a) this.mActivity).a(this.al);
            a();
            this.v.hide();
        }
    }

    private void j() {
        int i = 0;
        int size = this.f == null ? 0 : this.f.size();
        while (i < size) {
            aw awVar = (aw) this.f.get(i);
            if (awVar != null) {
                CommentInfo commentInfo = (CommentInfo) awVar.b;
                if (commentInfo != null) {
                    if (commentInfo.getRelatedUserInfo() == null) {
                        commentInfo.setRelatedUserInfo(new VideoUserInfo());
                    }
                    commentInfo.setPublisher(Long.parseLong(this.al.getUid()));
                    this.y.b(awVar);
                }
            }
            i++;
        }
    }

    public final void a(int i, List<v> list) {
        this.n = 2;
        this.T = list;
        this.A.c = this.T;
        if (this.i == null) {
            this.i = new WebsiteInfo();
            this.A.b = this.i;
        }
        if (!(list == null || this.i.j)) {
            long c = LoginHelper.a().g.c();
            for (v vVar : list) {
                if (vVar.a == c) {
                    this.i.j = true;
                }
            }
        }
        if (i > 0) {
            this.i.k = i;
        }
        this.y.b(this.A);
    }

    public final void a(int i, com.xunlei.downloadprovider.comment.entity.f fVar) {
        if (this.f == null) {
            this.f = new ArrayList(5);
        }
        List list = null;
        this.J = 0;
        if (fVar != null) {
            list = fVar.e;
            this.J = fVar.c + fVar.d;
        }
        l();
        if (this.f.isEmpty() != null || list != null) {
            b(list);
            this.y.c(this.f);
            this.f.clear();
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    CommentInfo commentInfo = (CommentInfo) it.next();
                    aw awVar = new aw();
                    awVar.a = 2;
                    awVar.b = commentInfo;
                    this.f.add(awVar);
                }
            }
            this.o = 2;
            if (i > 0) {
                this.y.c(this.D);
                this.y.c(this.E);
                this.y.c(this.F);
                this.y.b(this.f);
                this.L = i < this.J ? 1 : 0;
                if (this.X != 0 && this.L == 0 && this.J < 4) {
                    this.aa[0] = Boolean.valueOf(false);
                    this.aa[1] = Boolean.valueOf(true);
                    this.y.a(this.E);
                    this.ad = true;
                }
            } else if (i == 0) {
                this.y.c(this.D);
                this.y.c(this.E);
                this.y.c(this.F);
                this.aa[0] = Boolean.valueOf(true);
                this.aa[1] = Boolean.valueOf(true);
                this.y.a(this.E);
                this.L = false;
                if (this.X != 0) {
                    this.ad = true;
                }
            } else {
                this.o = 1;
                this.y.c(this.D);
                this.y.c(this.E);
                this.y.c(this.F);
                this.y.a(this.F);
                this.L = false;
            }
            if (this.u != 0) {
                this.k.postDelayed(new y(this), 200);
            }
        }
    }

    private void k() {
        int c = this.y.c();
        if (c == -1) {
            c = this.y.b();
        }
        this.G.scrollToPositionWithOffset(c, 0);
        if (!this.ac) {
            com.xunlei.downloadprovider.contentpublish.website.a.a.a();
            this.ac = true;
        }
        if (this.ad) {
            String h = h();
            String i = i();
            LoginHelper.a();
            com.xunlei.downloadprovider.contentpublish.website.a.a.a("discuss_area", h, i, l.c());
            this.ad = false;
        }
    }

    private void l() {
        if (this.J > 0) {
            this.r.setText(ConvertUtil.decimal2String((long) this.J, 10000, 10000, "万"));
            this.r.setVisibility(0);
            return;
        }
        this.r.setVisibility(4);
    }

    public final void a(com.xunlei.downloadprovider.comment.entity.f fVar) {
        if (this.f != null) {
            if (this.f.size() != 0) {
                List arrayList = new ArrayList();
                List list = null;
                if (fVar != null) {
                    list = fVar.e;
                }
                b(list);
                if (list == null || list.size() <= 0) {
                    XLToast.showToast(this.mActivity, "没有更多评论了");
                    this.L = false;
                } else {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        CommentInfo commentInfo = (CommentInfo) it.next();
                        aw awVar = new aw();
                        awVar.a = 2;
                        awVar.b = commentInfo;
                        this.f.add(awVar);
                        arrayList.add(awVar);
                    }
                    if (this.f.size() >= this.J) {
                        this.L = false;
                    }
                }
                this.q = 2;
                this.y.c(this.K);
                this.y.a(this.y.getItemCount(), arrayList);
            }
        }
    }

    public final void b(com.xunlei.downloadprovider.comment.entity.f fVar) {
        if (this.g == null) {
            this.g = new ArrayList(5);
        }
        List list = null;
        int i = 0;
        if (fVar != null) {
            list = fVar.e;
        }
        if (this.g.isEmpty() != null || list != null) {
            b(list);
            this.y.c(this.g);
            this.g.clear();
            if (list != null && list.size() > 0) {
                i = list.size();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    CommentInfo commentInfo = (CommentInfo) it.next();
                    commentInfo.setHot(true);
                    aw awVar = new aw();
                    awVar.a = 2;
                    awVar.b = commentInfo;
                    this.g.add(awVar);
                }
            }
            this.p = 2;
            if (i > 0) {
                int b = this.y.b();
                if (b >= null) {
                    this.y.a(b, this.I);
                    this.y.a(b + 1, this.g);
                } else {
                    this.y.a(this.I);
                    this.y.b(this.g);
                }
                if (this.C.a != 1) {
                    this.C.a = 1;
                    this.y.b(this.C);
                }
            } else {
                this.y.c(this.I);
                this.y.c(this.g);
                if (this.C.a != 10) {
                    this.C.a = 10;
                    this.y.b(this.C);
                }
            }
            if (this.u != null) {
                this.k.postDelayed(new z(this), 200);
            }
        }
    }

    public final void a(CommentInfo commentInfo) {
        long j;
        aw awVar;
        PublisherInfo publisherInfo;
        boolean z = false;
        this.s.a(false);
        this.s.dismiss();
        this.s.a("");
        TargetCommentInfo targetCommentInfo = commentInfo.getTargetCommentList() != null ? (TargetCommentInfo) commentInfo.getTargetCommentList().get(0) : null;
        if (targetCommentInfo == null) {
            j = -1;
        } else {
            j = targetCommentInfo.getId();
        }
        long j2 = j;
        p pVar = this.s.e;
        this.s.a(j2);
        this.s.e = null;
        com.xunlei.downloadprovider.contentpublish.website.a.a.a(this.i.a, true, ITagManager.SUCCESS, j2, commentInfo.getId(), com.xunlei.xllib.b.k.a(this.i.f, "UTF-8"), this.al.getUid());
        this.y.c(this.D);
        this.y.c(this.F);
        if (this.X && pVar == null) {
            if (this.J < 3) {
                this.aa[0] = Boolean.valueOf(false);
                this.y.b(this.E);
                awVar = new aw();
                awVar.a = 2;
                awVar.b = commentInfo;
                this.f.add(0, awVar);
                this.y.a(this.y.b() + 1, awVar);
                this.J += 1;
                l();
                this.k.removeMessages(203);
                if (this.i != null) {
                    long parseLong = Long.parseLong(this.al.getUid());
                    if (parseLong > 0 && this.N.f(parseLong) != null) {
                        commentInfo = 1;
                        if (commentInfo == null) {
                            commentInfo = this.al;
                            if (Long.parseLong(commentInfo.getUid()) != this.Z.g.c()) {
                                publisherInfo = new PublisherInfo();
                                publisherInfo.a = commentInfo;
                                this.W.a(publisherInfo);
                                z = true;
                            }
                            if (z) {
                                this.W.show();
                            }
                            this.N.g(Long.parseLong(this.al.getUid()));
                        }
                        XLToast.showToast(this.mActivity, "发送评论成功");
                        return;
                    }
                }
                commentInfo = null;
                if (commentInfo == null) {
                    XLToast.showToast(this.mActivity, "发送评论成功");
                    return;
                }
                commentInfo = this.al;
                if (Long.parseLong(commentInfo.getUid()) != this.Z.g.c()) {
                    publisherInfo = new PublisherInfo();
                    publisherInfo.a = commentInfo;
                    this.W.a(publisherInfo);
                    z = true;
                }
                if (z) {
                    this.W.show();
                }
                this.N.g(Long.parseLong(this.al.getUid()));
            }
        }
        this.y.c(this.E);
        awVar = new aw();
        awVar.a = 2;
        awVar.b = commentInfo;
        this.f.add(0, awVar);
        this.y.a(this.y.b() + 1, awVar);
        this.J += 1;
        l();
        this.k.removeMessages(203);
        if (this.i != null) {
            long parseLong2 = Long.parseLong(this.al.getUid());
            commentInfo = 1;
            if (commentInfo == null) {
                commentInfo = this.al;
                if (Long.parseLong(commentInfo.getUid()) != this.Z.g.c()) {
                    publisherInfo = new PublisherInfo();
                    publisherInfo.a = commentInfo;
                    this.W.a(publisherInfo);
                    z = true;
                }
                if (z) {
                    this.W.show();
                }
                this.N.g(Long.parseLong(this.al.getUid()));
            }
            XLToast.showToast(this.mActivity, "发送评论成功");
            return;
        }
        commentInfo = null;
        if (commentInfo == null) {
            XLToast.showToast(this.mActivity, "发送评论成功");
            return;
        }
        commentInfo = this.al;
        if (Long.parseLong(commentInfo.getUid()) != this.Z.g.c()) {
            publisherInfo = new PublisherInfo();
            publisherInfo.a = commentInfo;
            this.W.a(publisherInfo);
            z = true;
        }
        if (z) {
            this.W.show();
        }
        this.N.g(Long.parseLong(this.al.getUid()));
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
        if (i == 1) {
            if (this.i != null) {
                com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                if (com.xunlei.downloadprovider.homepage.recommend.feed.k.c(1, this.i.a)) {
                    this.i.j = true;
                }
                if (this.i.j) {
                    this.U.setSelected(true);
                }
                this.A.b = this.i;
                this.y.b(this.A);
            }
            if (this.o == 1) {
                this.y.c(this.D);
                this.y.a(this.F);
                this.L = false;
            }
            if (this.X && this.Y == null) {
                this.Y = com.xunlei.downloadprovider.d.b.a().d(AccsClientConfig.DEFAULT_CONFIGTAG);
                this.E.b = this.Y;
                this.y.b(this.E);
                if (this.s != null && this.s.isShowing()) {
                    this.s.a(this.Y);
                }
            }
            this.m = 1;
            if (m()) {
                b(true);
                ((a) this.mActivity).a(true);
            }
            this.v.hide();
        } else if (i == 13) {
            this.n = 1;
            if (this.T != null) {
                this.T = null;
                this.A.c = this.T;
                if (this.m != 0) {
                    this.y.b(this.A);
                }
            }
        }
        if (i == 4) {
            if (TextUtils.isEmpty(this.s.a()) == 0) {
                this.s.a(true);
            } else {
                this.s.a(false);
            }
            i = this.s.e;
            this.s.e = null;
            CommentInfo commentInfo = this.s.b;
            com.xunlei.downloadprovider.contentpublish.website.a.a.a(this.i.a, false, str, commentInfo == null ? -1 : commentInfo.getId(), -1, com.xunlei.xllib.b.k.a(this.i.f, "UTF-8"), this.al.getUid());
            if (i != 0) {
                this.k.removeMessages(203);
                this.aa[1] = Boolean.valueOf(true);
                this.y.b(this.E);
            }
        } else if (i == 9) {
            XLToast.showToast(this.mActivity, "删除评论失败");
        } else if (i == 10) {
            if ((this.x <= 0 ? 1 : 0) != 0) {
                this.x++;
                new StringBuilder("retry load hot comment time=>").append(this.x);
                this.p = 0;
                this.c.d();
                return;
            }
            this.x = 0;
            this.p = 1;
            if (this.u != 0) {
                this.k.postDelayed(new aa(this), 200);
            }
            com.xunlei.downloadprovider.contentpublish.website.a.a.b("hot", str);
        } else if (i == 12) {
            this.y.c(this.K);
            this.q = 1;
            XLToast.showToast(this.mActivity, "加载更多评论失败");
            com.xunlei.downloadprovider.contentpublish.website.a.a.b("morenew", str);
        } else if (i == 3) {
            if ((this.w <= 0 ? 1 : 0) != 0) {
                this.w++;
                new StringBuilder("retry load comment time=>").append(this.w);
                this.o = 0;
                this.c.b();
                return;
            }
            this.w = 0;
            this.o = 1;
            if (m() != 0) {
                this.v.hide();
                b(true);
                ((a) this.mActivity).a(true);
            }
            com.xunlei.downloadprovider.contentpublish.website.a.a.b("new", str);
            a(-1, null);
        } else {
            if (!(i == 5 || i == 8 || i != 7)) {
                this.r.setVisibility(4);
            }
        }
    }

    private boolean m() {
        return this.l.getVisibility() != 0 && TextUtils.isEmpty(this.i.e) && this.m == 1 && this.o == 1;
    }

    public final void b(CommentInfo commentInfo) {
        commentInfo.setLiked(true);
    }

    public final void b(String str) {
        if (f()) {
            str = com.xunlei.downloadprovider.f.c.a(str, this.i, this.al);
            com.xunlei.downloadprovidershare.b.c b = com.xunlei.downloadprovidershare.b.a.b();
            long c = LoginHelper.a().g.c();
            if (c > 0 && this.al.getUid().equals(String.valueOf(c))) {
                b.a(ShareOperationType.REPORT);
            }
            com.xunlei.downloadprovider.f.a.a();
            com.xunlei.downloadprovider.f.a.b(this.mActivity, str, this, b);
        }
    }

    public final void b() {
        this.j.b = false;
        this.j.a = false;
        long parseLong = Long.parseLong(this.al.getUid());
        this.j.c = this.N.b(parseLong) ^ 1;
        ((a) this.mActivity).a(this.j);
    }

    public final void a(boolean z) {
        if (this.j.c != z) {
            this.j.c = z;
            ((a) this.mActivity).a(this.j);
        }
    }

    private void d(boolean z) {
        if (this.j.b != z) {
            this.k.postDelayed(new ab(this, z), 300);
        }
    }

    public final void a(View view, int i, Object obj) {
        CommentInfo commentInfo;
        String a;
        switch (i) {
            case 0:
                if (f() != null) {
                    if (this.f != null) {
                        this.f.clear();
                    }
                    this.o = 0;
                    this.c.b();
                    if (this.p == 1) {
                        this.p = 0;
                        this.c.d();
                    }
                    return;
                }
                return;
            case 1:
                if (f() != null) {
                    g();
                    return;
                }
                return;
            case 6:
                if (f() != null) {
                    long parseLong = Long.parseLong(this.al.getUid());
                    if (parseLong != -1) {
                        m.a(getContext(), parseLong, this.al.getKind(), this.al.getNickname(), this.al.getPortraitUrl(), From.LINK_DETAIL_HOST, this.i.a, this.i.a);
                    }
                    return;
                }
                return;
            case 9:
                if (f() != null) {
                    this.t.a((CommentInfo) obj);
                    this.t.show();
                    return;
                }
                return;
            case 11:
                if (f() != null) {
                    commentInfo = (CommentInfo) obj;
                    if (this.i != null) {
                        this.c.a(commentInfo);
                        view = new CommentSateInfo();
                        view.a = commentInfo.getId();
                        view.d = commentInfo.getRelateGcid();
                        view.b = commentInfo.isLiked();
                        view.e = commentInfo.getUserId();
                        view.c = commentInfo.getLikeCount();
                        StateSyncManager.a(this.mActivity, SourceFrom.PAGE_SHORMOVIE_DETAIL, view);
                        c(commentInfo);
                        if (commentInfo != null) {
                            com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                            com.xunlei.downloadprovider.homepage.recommend.feed.k.a(String.valueOf(commentInfo.getId()), commentInfo.getLikeCount());
                        }
                        com.xunlei.downloadprovider.contentpublish.website.a.a.a(this.i.a, com.xunlei.xllib.b.k.a(this.i.f, "UTF-8"), this.al.getUid(), commentInfo.getId(), l.c());
                    }
                    return;
                }
                return;
            case 12:
                if (f() != null) {
                    commentInfo = (CommentInfo) obj;
                    if (commentInfo.isPreview() != null) {
                        XLToast.showToast(this.mActivity, "此评论暂时无法回复");
                        return;
                    }
                    new StringBuilder("回复 ").append(commentInfo.getUserName());
                    c(false);
                    this.s.a(commentInfo);
                    this.s.e = null;
                    this.ae = commentInfo.isHot() != null ? "discuss_hot" : "discuss_common";
                    String str = this.i.a;
                    String str2 = this.ae;
                    a = com.xunlei.xllib.b.k.a(this.i.f, "UTF-8");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.i.b);
                    com.xunlei.downloadprovider.contentpublish.website.a.a.a(str, str2, a, stringBuilder.toString());
                    return;
                }
                return;
            case 14:
            case 15:
                if (f() != null) {
                    CommentInfo commentInfo2 = (CommentInfo) obj;
                    if (commentInfo2 != null) {
                        this.c.e();
                        this.c.f();
                        commentInfo2.setGcid(this.i.a);
                        commentInfo2.setSourceId(this.i.a);
                        m.a(this.mActivity, commentInfo2.getUserId(), "per", commentInfo2.getUserName(), commentInfo2.getUserAvatar(), From.LINK_DETAIL_DISCUSS, commentInfo2);
                    }
                    return;
                }
                return;
            case 16:
                if (f() != null) {
                    TargetCommentInfo targetCommentInfo = (TargetCommentInfo) obj;
                    if (targetCommentInfo != null) {
                        this.c.e();
                        this.c.f();
                        m.b(this.mActivity, targetCommentInfo.getUserId(), "per", targetCommentInfo.getUserName(), targetCommentInfo.getUserAvatar(), From.LINK_DETAIL_DISCUSS);
                    }
                    return;
                }
                return;
            case 18:
                if (!(f() == 0 || this.i == 0)) {
                    i = this.al.getKind();
                    String str3 = this.i.a;
                    String uid = this.al.getUid();
                    a = (i == 0 || i.contentEquals("per") == null) ? "channel" : "personal";
                    String str4 = a;
                    String str5 = "follow_button";
                    boolean c = l.c();
                    boolean z = (this.j == null || this.j.b == null) ? false : true;
                    com.xunlei.downloadprovider.contentpublish.website.a.a.a(str3, uid, str4, str5, c, z);
                    d(false);
                    if (l.c() == null) {
                        String str6 = this.i.a;
                        String uid2 = this.al.getUid();
                        i = (i == 0 || i.contentEquals("per") == 0) ? "channel" : "personal";
                        com.xunlei.downloadprovider.contentpublish.website.a.a.a(str6, uid2, (String) i, "follow_button", l.c(), "skip_login", "");
                        this.Z.a(this.mActivity, new ad(this, view), LoginFrom.VIDEO_DETAIL_FOLLOW, null);
                        return;
                    }
                    a(false);
                    a("follow_button", view, true);
                }
                return;
            case 19:
                if (f() != null) {
                    d("detail_news");
                    return;
                }
                return;
            case 21:
                if (f() != null) {
                    v vVar = (v) obj;
                    if (vVar != null) {
                        m.a(this.mActivity, vVar.a, "per", vVar.b, vVar.c, From.LINK_DETAIL_LIKE);
                        view = this.i.a;
                        i = new StringBuilder();
                        i.append(vVar.a);
                        com.xunlei.downloadprovider.contentpublish.website.a.a.c(view, i.toString());
                    }
                    return;
                }
                return;
            case 22:
                if (f() != null) {
                    p pVar = (p) obj;
                    if (!(this.i == null || pVar == null)) {
                        this.s.e = pVar;
                        this.s.a(null);
                        com.xunlei.downloadprovider.contentpublish.website.a.a.a(pVar.a, l.c(), h(), "discuss_area");
                        if (r.a().a(getContext(), LoginFrom.VIDEO_DETAIL_USER_DISCUSS_DEFAULT, this.ah) == null) {
                            a(pVar.b, null);
                        }
                    }
                    return;
                }
                return;
            case 26:
                if (this.ai == null && this.G.findFirstVisibleItemPosition() == null) {
                    this.ai = true;
                    com.xunlei.downloadprovider.contentpublish.website.a.a.c(this.i == null ? "" : this.i.a);
                    break;
                }
            case 28:
                if (f() != null) {
                    com.xunlei.downloadprovider.contentpublish.website.a.a.a(com.xunlei.xllib.b.k.a(this.i.f, "UTF-8"), this.H);
                    com.xunlei.downloadprovider.web.a.a();
                    com.xunlei.downloadprovider.web.a.a(getContext(), this.i.f, true, BrowserFrom.LINK_DETAIL_URL);
                    return;
                }
                return;
            default:
                break;
        }
    }

    private void d(String str) {
        b(str);
        com.xunlei.downloadprovider.contentpublish.website.a.a.b(str, this.i.a, com.xunlei.xllib.b.k.a(this.i.f, "UTF-8"), this.al.getUid());
    }

    private void c(CommentInfo commentInfo) {
        CommentInfo commentInfo2;
        if (commentInfo.isHot()) {
            for (aw awVar : this.f) {
                commentInfo2 = (CommentInfo) awVar.b;
                if (commentInfo2.getId() == commentInfo.getId()) {
                    commentInfo2.setLiked(commentInfo.isLiked());
                    commentInfo2.setLikeCount(commentInfo.getLikeCount());
                    this.y.b(awVar);
                    return;
                }
            }
            return;
        }
        if (this.g != null) {
            if (this.g.size() > 0) {
                for (aw awVar2 : this.g) {
                    commentInfo2 = (CommentInfo) awVar2.b;
                    if (commentInfo2.getId() == commentInfo.getId()) {
                        commentInfo2.setLiked(commentInfo.isLiked());
                        commentInfo2.setLikeCount(commentInfo.getLikeCount());
                        this.y.b(awVar2);
                        return;
                    }
                }
            }
        }
    }

    public final void c(String str) {
        a(str, null, false);
    }

    public final void a(String str, View view) {
        a(str, view, true);
    }

    private void a(String str, View view, boolean z) {
        if (this.W != null && this.W.isShowing()) {
            this.W.dismiss();
        }
        long parseLong = Long.parseLong(this.al.getUid());
        if (this.N.b(parseLong)) {
            XLToast.showToast(this.mActivity, "您已关注");
            b();
        } else if (com.xunlei.xllib.android.b.a(this.mActivity)) {
            this.N.a(parseLong, z, true, new ae(this, parseLong, str, view));
        } else {
            XLToast.showToast(this.mActivity, "无网络连接");
        }
    }

    public void onShareTargetClicked(ShareOperationType shareOperationType, com.xunlei.downloadprovidershare.a.f fVar) {
        String reportShareTo = shareOperationType.getReportShareTo();
        if (shareOperationType == ShareOperationType.REPORT) {
            if (this.i != null) {
                ReportActivity.a(getContext(), 5, this.i.a, this.i.a, DispatchConstants.OTHER);
            }
            com.xunlei.downloadprovider.contentpublish.website.a.a.b("jubao");
            return;
        }
        com.xunlei.downloadprovider.contentpublish.website.a.a.a(this.i.a, com.xunlei.xllib.b.k.a(this.i.f, "UTF-8"), this.al.getUid(), reportShareTo, fVar.j);
    }

    public final void a(long j) {
        Iterator it;
        ArrayList arrayList = new ArrayList(1);
        for (aw awVar : this.f) {
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
                        this.y.b(awVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            this.J -= arrayList.size();
            l();
            it = arrayList.iterator();
            while (it.hasNext()) {
                awVar2 = (aw) it.next();
                this.f.remove(awVar2);
                this.y.c(awVar2);
            }
            arrayList.clear();
            if (this.f.isEmpty()) {
                this.aa[0] = Boolean.valueOf(true);
                this.aa[1] = Boolean.valueOf(true);
                this.y.c(this.E);
                this.y.a(this.y.b() + 1, this.E);
                if (this.X) {
                    String h = h();
                    String i = i();
                    LoginHelper.a();
                    com.xunlei.downloadprovider.contentpublish.website.a.a.a("discuss_area", h, i, l.c());
                }
            }
        }
        if (this.g != null) {
            if (!this.g.isEmpty()) {
                for (aw awVar3 : this.g) {
                    CommentInfo commentInfo2 = (CommentInfo) awVar3.b;
                    if (commentInfo2.getId() == j) {
                        arrayList.add(awVar3);
                    } else {
                        List targetCommentList2 = commentInfo2.getTargetCommentList();
                        if (targetCommentList2 != null && targetCommentList2.size() > 0) {
                            TargetCommentInfo targetCommentInfo2 = (TargetCommentInfo) targetCommentList2.get(0);
                            if (targetCommentInfo2.getId() == j) {
                                targetCommentInfo2.setId(-1);
                                this.y.b(awVar3);
                            }
                        }
                    }
                }
                j = arrayList.iterator();
                while (j.hasNext()) {
                    aw awVar4 = (aw) j.next();
                    this.g.remove(awVar4);
                    this.y.c(awVar4);
                }
                if (!(this.g == null || this.g.isEmpty() == null)) {
                    this.y.c(this.I);
                }
            }
        }
        XLToast.showToast(this.mActivity, "删除评论成功");
    }

    public void onShareComplete(int i, ShareOperationType shareOperationType, com.xunlei.downloadprovidershare.a.f fVar) {
        long parseLong = Long.parseLong(this.al.getUid());
        if (parseLong > 0) {
            if (!this.N.b(parseLong)) {
                d(true);
            }
        }
        String a = com.xunlei.downloadprovider.f.a.a(i);
        com.xunlei.downloadprovider.contentpublish.website.a.a.a(this.i.a, com.xunlei.xllib.b.k.a(this.i.f, "UTF-8"), this.al.getUid(), shareOperationType.getReportShareTo(), a, i, fVar.j);
        if (i == 0) {
            i = com.xunlei.downloadprovider.homepage.recommend.a.a.a();
            shareOperationType = this.i.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.i.a);
            i.a(shareOperationType, 5, stringBuilder.toString(), "share_success");
            com.xunlei.downloadprovider.e.b.b.a();
            com.xunlei.downloadprovider.e.b.b.a(this.i.a);
        }
    }

    static /* synthetic */ void a(WebsiteDetailFragment websiteDetailFragment, Intent intent) {
        if (((SourceFrom) SourceFrom.valueOf(SourceFrom.class, intent.getStringExtra("source_from"))) != SourceFrom.PAGE_SHORMOVIE_DETAIL) {
            CommentSateInfo commentSateInfo = (CommentSateInfo) intent.getParcelableExtra("comment_info");
            if (websiteDetailFragment.i != null) {
                if (TextUtils.equals(commentSateInfo.d, websiteDetailFragment.i.a)) {
                    CommentInfo commentInfo;
                    for (aw awVar : websiteDetailFragment.f) {
                        commentInfo = (CommentInfo) awVar.b;
                        if (commentInfo.getId() == commentSateInfo.a) {
                            commentInfo.setLiked(commentSateInfo.b);
                            commentInfo.setLikeCount(commentSateInfo.c);
                            websiteDetailFragment.y.b(awVar);
                            break;
                        }
                    }
                    if (websiteDetailFragment.g != null) {
                        if (websiteDetailFragment.g.size() > 0) {
                            for (aw awVar2 : websiteDetailFragment.g) {
                                commentInfo = (CommentInfo) awVar2.b;
                                if (commentInfo.getId() == commentSateInfo.a) {
                                    commentInfo.setLiked(commentSateInfo.b);
                                    commentInfo.setLikeCount(commentSateInfo.c);
                                    websiteDetailFragment.y.b(awVar2);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ boolean d(WebsiteDetailFragment websiteDetailFragment) {
        if (!(websiteDetailFragment.getActivity() == null || websiteDetailFragment.getActivity().isFinishing())) {
            if (VERSION.SDK_INT < 17 || websiteDetailFragment.getActivity().isDestroyed() == null) {
                return null;
            }
        }
        return true;
    }

    static /* synthetic */ void l(WebsiteDetailFragment websiteDetailFragment) {
        websiteDetailFragment.d = 0;
        websiteDetailFragment.u = false;
        websiteDetailFragment.L = true;
        websiteDetailFragment.ac = false;
        websiteDetailFragment.ad = false;
        websiteDetailFragment.q = 2;
        websiteDetailFragment.ai = false;
        websiteDetailFragment.y.e();
        if (websiteDetailFragment.c != null) {
            websiteDetailFragment.c.e();
        }
        if (websiteDetailFragment.af != null) {
            websiteDetailFragment.af.clear();
        }
        if (websiteDetailFragment.e != null) {
            websiteDetailFragment.e.clear();
        } else {
            websiteDetailFragment.e = new ArrayList(8);
        }
        if (websiteDetailFragment.f != null) {
            websiteDetailFragment.f.clear();
        }
        websiteDetailFragment.C.a = 10;
        if (websiteDetailFragment.g != null) {
            websiteDetailFragment.g.clear();
        }
        websiteDetailFragment.e();
    }

    static /* synthetic */ void a(WebsiteDetailFragment websiteDetailFragment, int i) {
        if (i == 0 || i == 1) {
            int findLastVisibleItemPosition = websiteDetailFragment.G.findLastVisibleItemPosition();
            websiteDetailFragment.u = false;
            if (!websiteDetailFragment.ac) {
                int b = websiteDetailFragment.y.b();
                if (b > 0 && findLastVisibleItemPosition > b) {
                    com.xunlei.downloadprovider.contentpublish.website.a.a.a();
                    websiteDetailFragment.ac = true;
                    if (websiteDetailFragment.ad) {
                        String h = websiteDetailFragment.h();
                        String i2 = websiteDetailFragment.i();
                        LoginHelper.a();
                        com.xunlei.downloadprovider.contentpublish.website.a.a.a("discuss_area", h, i2, l.c());
                    }
                }
            }
        }
        if (!(websiteDetailFragment.q == 0 || websiteDetailFragment.o == 0)) {
            if (websiteDetailFragment.L) {
                if (i == 0 && websiteDetailFragment.G.findLastVisibleItemPosition() >= websiteDetailFragment.y.getItemCount() - 2) {
                    websiteDetailFragment.q = 0;
                    websiteDetailFragment.y.a(websiteDetailFragment.K);
                    websiteDetailFragment.c.c();
                }
            }
        }
    }

    static /* synthetic */ void w(WebsiteDetailFragment websiteDetailFragment) {
        String trim = websiteDetailFragment.s.a().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            XLToast.showToast(websiteDetailFragment.mActivity, "请填写评论内容");
        } else if (com.xunlei.xllib.android.b.a(websiteDetailFragment.mActivity)) {
            websiteDetailFragment.s.a(false);
            websiteDetailFragment.c.a(trim, AndroidConfig.getPhoneBrand(), websiteDetailFragment.s.b);
        } else {
            XLToast.showToast(websiteDetailFragment.mActivity, "无网络连接");
        }
    }
}
