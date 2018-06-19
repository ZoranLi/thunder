package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.h.j;
import com.xunlei.downloadprovider.homepage.c;
import com.xunlei.downloadprovider.homepage.r;
import com.xunlei.downloadprovider.homepage.r.b;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.ControlType;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerOperationViewDetail;
import com.xunlei.downloadprovider.player.xmp.ui.u;
import com.xunlei.downloadprovider.player.xmp.y;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.HistoryRecordList;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.e;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.t;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.ShortMovieFlowBaseInfoView;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.ShortMoviePublisherInfoView;
import com.xunlei.downloadprovidershare.view.SharePopView;
import com.xunlei.xllib.android.XLIntent;
import java.util.List;

public class ShortMovieDetailActivity extends BaseActivity implements b, com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailFragment.a {
    private boolean A = true;
    private boolean B = true;
    private int C;
    private r D;
    private com.xunlei.downloadprovider.homepage.b E;
    private SharePopView F;
    private ShortMoviePublisherInfoView G;
    private int H;
    private boolean I = false;
    private boolean J = false;
    private BaseVideoInfo K;
    private VideoUserInfo L;
    private boolean M;
    private boolean N = true;
    private Button O;
    private String P;
    private boolean Q = true;
    private int R = Color.parseColor("#00000000");
    private int S = Color.parseColor("#3b424c");
    private View T;
    private boolean U = true;
    private boolean V = false;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = false;
    private PlayerContainer Z = new w(this);
    ThunderXmpPlayer a;
    private Runnable aa = new ab(this);
    private Runnable ab = new ad(this);
    boolean c = false;
    boolean d = false;
    private String e;
    private ShortMovieDetailFragment f;
    private ViewGroup g;
    private View h;
    private ViewGroup i;
    private TextView j;
    private ShortMovieFlowBaseInfoView k;
    private boolean l;
    private u m;
    private int n = 0;
    private int o = 0;
    private ImageView p;
    private ImageView q;
    private View r;
    private c s;
    private HistoryRecordList<com.xunlei.downloadprovider.shortvideo.videodetail.model.b> t;
    private boolean u;
    private boolean v;
    private boolean w = false;
    private Handler x;
    private ValueAnimator y;
    private com.xunlei.downloadprovider.broadcast.b z = new q(this);

    public enum From {
        VIDEO_CHANNEL("videoChannel"),
        HOT_VIDEO("hotvideo"),
        HOME_COLLECT_DISCUSS("home_collect_discuss"),
        VIDEO_REC("video_rec"),
        HOME_HOT_SRC("home_hotSrc"),
        PLAY_LIST("play_list"),
        SHARE_PAGE("from_share_page"),
        FEED_FLOW("feedflow"),
        FEEDFLOW_AUTOPLAY_NOSOUND("feedflow_autoplay_nosound"),
        FEEDFLOW_AUTOPLAY_SOUND("feedflow_autoplay_sound"),
        HOME_PAGE("homepage"),
        HOME_VIDEO_AUTO("home_video_auto"),
        CHANNEL_VIDEO_AUTO("channel_video_auto"),
        CHANNEL_VIDEO_AUTO_SOUND("channel_video_auto_sound"),
        PERSONAL_SPACE_AUTOPLAY_NOSOUND("personal_space_autoplay_nosound"),
        PERSONAL_SPACE_AUTOPLAY_SOUND("personal_space_autoplay_sound"),
        PUSH("push"),
        KANDAN("kandan"),
        YOULIAO_TAB("youliao_tab"),
        CARD_SLIDE_PAGE("shortvideo_hotornot_video"),
        CINECISM_MORE_RECOMMEND("cinecism_more_recommend"),
        VIDEOTAG_COLLECT("videotag_collect"),
        VIDEO_SCREEN("video_screen"),
        VIDEO_SCREEN_AUTO("video_screen_auto"),
        VIDEO_HOT_DISCUSS("video_hot_discuss"),
        PERSONAL_SPACE("personal_space"),
        HOME_PAGE_AD("homepage_ad"),
        WEB("web"),
        WITHDRAW("withdraw"),
        CHANNEL_FLOW("channelflow"),
        SEARCH_RESULT_PAGE("search_result"),
        SEARCH_NOW_SHORTVIDEO("search_now_shortvideo"),
        PER_ZAN_LIST("per_zanlist"),
        MESSAGE_CENTER("message_center"),
        VIDEO_COLLECT("videoCollect"),
        MUSIC_COLLECT("musicCollect"),
        LBS_COLLECT("LBSCollect"),
        HOME_USER_CENTER_VISIT_VIDEO("home_usercenter_visitvideo"),
        HOME_USER_CENTER_VISIT_COMMENT("home_usercenter_visitcomment"),
        FOLLOW_TAB_VIDEO_LIST("followtab_video_list"),
        FOLLOW_TAB_AUTO_LIST("followtab_auto_list"),
        PROMOTE_CHANNEL_LAUNCH("promote_channel_launch"),
        DOWNLOAD_CENTER_HOME("dl_home"),
        DOWNLOAD_CENTER_ALL("dl_all"),
        DOWNLOAD_CENTER_DOWNLOADING("dl_dloading"),
        DOWNLOAD_CENTER_COMPLETE("dl_complete"),
        PERSONAL_CHAT_COMMENT_REPLY_MESSAGE_RESOURCE("personal_chat_video"),
        PERSONAL_CHAT_COMMENT_REPLY_MESSAGE_REPLY("personal_chat_reply");
        
        private final String mText;

        private From(String str) {
            this.mText = str;
        }

        public final String getText() {
            return this.mText;
        }
    }

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f = -1;
        public boolean g = false;
        public int h = 0;
        public int i;
        public long j = -1;
        public String k;
        public String l;
        public String m;
        public int n = 0;
        public String o = "per";
        public int p = -1;
        public String q;
        public boolean r;
        public boolean s;
        public boolean t;
        public From u;
        public BaseVideoInfo v;
        public VideoUserInfo w;
    }

    static /* synthetic */ void d() {
    }

    protected final boolean q_() {
        return false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 256);
        setContentView(R.layout.short_movie_detail_layout_new);
        this.t = new HistoryRecordList();
        this.x = new Handler();
        bundle = getIntent();
        Uri data = bundle.getData();
        boolean z = true;
        if (data != null) {
            if ("/resourceDetail".equals(data.getPath())) {
                BaseVideoInfo baseVideoInfo = new BaseVideoInfo();
                baseVideoInfo.setTitle(data.getQueryParameter("title"));
                baseVideoInfo.setVideoId(data.getQueryParameter("movieKey"));
                baseVideoInfo.setGcid(data.getQueryParameter("gcid"));
                this.K = baseVideoInfo;
                this.L = new VideoUserInfo();
                this.e = bundle.getStringExtra("from");
            }
        } else {
            this.K = (BaseVideoInfo) bundle.getParcelableExtra(BaseVideoInfo.JSON_KEY);
            this.L = (VideoUserInfo) bundle.getParcelableExtra(VideoUserInfo.JSON_KEY);
            if (this.L == null) {
                this.L = new VideoUserInfo();
            }
            this.e = bundle.getStringExtra("from");
            this.l = bundle.getBooleanExtra("seek_to_comment", false);
            this.M = bundle.getBooleanExtra("show_comment_dialog", false);
            this.N = this.M ^ 1;
        }
        bundle = new com.xunlei.downloadprovider.shortvideo.videodetail.model.b();
        bundle.f = this.L;
        bundle.e = this.K;
        this.t.putHead(bundle);
        this.A = true;
        this.B = d.a().b.h();
        if (k() != null) {
            this.A = false;
            this.B = false;
        }
        this.C = com.xunlei.xllib.android.d.a(this);
        this.k = (ShortMovieFlowBaseInfoView) findViewById(R.id.flow_base_info);
        this.k.getPublisherInfoView().setPublisherNameTextColor(getResources().getColor(R.color.white));
        if (this.K != null) {
            TextView textView = (TextView) findViewById(R.id.tv_comment_count);
            int commentCount = this.K.getCommentCount();
            if (commentCount > 0) {
                textView.setText(ConvertUtil.decimal2String((long) commentCount, 10000, 10000, "万"));
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
        }
        this.I = true;
        this.J = true;
        o();
        this.r = findViewById(R.id.lyt_titlebar_wrapper);
        this.r.setVisibility(0);
        this.T = findViewById(R.id.lyt_line);
        this.p = (ImageView) findViewById(R.id.iv_menu);
        if (From.HOME_PAGE_AD.getText().contentEquals(this.e) != null) {
            this.p.setVisibility(4);
        } else {
            this.p.setVisibility(0);
        }
        this.q = (ImageView) findViewById(R.id.iv_back);
        this.q.setOnClickListener(new t(this));
        this.p.setOnClickListener(new u(this));
        this.G = (ShortMoviePublisherInfoView) findViewById(R.id.short_movie_publisher_info_view_top);
        n();
        this.k.a(this.L);
        this.G.a(this.L);
        bundle = a((Activity) this, this.r);
        ShortMovieFlowBaseInfoView shortMovieFlowBaseInfoView = this.k;
        shortMovieFlowBaseInfoView.a = com.xunlei.xllib.android.d.b(BrothersApplication.getApplicationInstance()) - com.xunlei.downloadprovider.homepage.b.a();
        shortMovieFlowBaseInfoView.b = com.xunlei.xllib.android.d.b(BrothersApplication.getApplicationInstance());
        if (bundle == null) {
            bundle = j.a(BrothersApplication.getApplicationInstance());
            shortMovieFlowBaseInfoView.a -= bundle;
            shortMovieFlowBaseInfoView.b -= bundle;
        }
        this.i = (ViewGroup) findViewById(R.id.ryt_top_area);
        this.g = (ViewGroup) findViewById(R.id.vod_layout);
        bundle = i();
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.i.getLayoutParams();
        marginLayoutParams.width = -1;
        marginLayoutParams.height = bundle;
        marginLayoutParams.topMargin = this.H;
        this.i.setLayoutParams(marginLayoutParams);
        if (this.H != null) {
            z = false;
        }
        d(z);
        this.j = (TextView) findViewById(R.id.tv_video_tips);
        this.j.setVisibility(4);
        this.j.setOnClickListener(new ag(this));
        this.h = findViewById(R.id.detail_layout);
        this.h.setVisibility(0);
        this.f = new ShortMovieDetailFragment();
        Bundle bundle2 = new Bundle(9);
        Parcelable parcelable = this.K;
        Parcelable parcelable2 = this.L;
        bundle2.putParcelable("video_nfo", parcelable);
        bundle2.putParcelable(VideoUserInfo.JSON_KEY, parcelable2);
        bundle2.putBoolean("movie_seek_to_comment", this.l);
        bundle2.putBoolean("auto_show_comment_dialog", this.M);
        bundle2.putString("from", this.e);
        this.f.setArguments(bundle2);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.detail_layout, this.f);
        beginTransaction.commit();
        this.O = (Button) findViewById(R.id.btn_extra);
        this.O.setVisibility(8);
        bundle = (ThunderXmpPlayer) ak.a().b.get(getIntent().getIntExtra("player_id", -1));
        if (bundle == null) {
            bundle = ak.a().a(PlayerTag.VIDEO_DETAIL, ControlType.VIDEO_DETAIL);
        }
        bundle.p();
        bundle.h.l = false;
        bundle.a(PlayerTag.VIDEO_DETAIL);
        bundle.o = "videoDetail";
        bundle.a(ControlType.VIDEO_DETAIL);
        bundle.a(this.Z);
        bundle.t = new ah(this);
        bundle.a((BaseActivity) this, this.Z);
        this.a = bundle;
        this.m = (u) bundle.l;
        u uVar = this.m;
        com.xunlei.downloadprovider.player.xmp.d aiVar = new ai(this);
        uVar.f.setOnControllerClickListener(aiVar);
        uVar.g.setOnControllerClickListener(aiVar);
        bundle.c(new aj(this));
        uVar = this.m;
        uVar.f.setVisiableListener(new ak(this));
        bundle.a(new r(this));
        if (bundle.f.e) {
            bundle.c(false);
            bundle.e();
        } else if (TextUtils.isEmpty(this.K.getVideoId()) == null && TextUtils.isEmpty(this.K.getPlayUrl()) == null) {
            a(this.K, this.L, this.e);
        }
        bundle = this.m;
        bundle.g.setOnPlayerCompletionVisibleChangedListener(new s(this));
        h();
        this.s = new c(this);
        this.s.a = new af(this);
        this.D = new r(this, this.i, this.f, this.H, this);
        this.E = new com.xunlei.downloadprovider.homepage.b(this, this.i, this.f, j(), i());
        this.i.postDelayed(new ac(this), 0);
        this.k.setTopAreaView(this.i);
        this.Q = d.a().b.o();
        this.k.setListener(this.f);
        this.G.setListener(this.f);
        this.m.b(8);
        this.k.setOnVisibleChangedListener(new ae(this));
    }

    private void g() {
        ShortMovieFlowBaseInfoView shortMovieFlowBaseInfoView = this.k;
        boolean z = (this.W || this.X || this.Y) ? false : true;
        shortMovieFlowBaseInfoView.setShow(z);
    }

    private void h() {
        int dimensionPixelOffset;
        if (this.H == 0) {
            dimensionPixelOffset = (getResources().getDimensionPixelOffset(R.dimen.short_movie_detail_living_bar_spacing_bottom) + com.xunlei.downloadprovider.homepage.b.a()) + (!this.V ? j.a(this) : 0);
            new StringBuilder("updateLiveGuideMargin. mIsInDimMode: ").append(this.V);
            int b = com.xunlei.xllib.android.d.b(this) - this.i.getMeasuredHeight();
            if (b < 0) {
                dimensionPixelOffset -= b;
            }
        } else {
            dimensionPixelOffset = DipPixelUtil.dip2px(-15.0f);
        }
        this.m.f.setLiveGuideMarginBottom(dimensionPixelOffset);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        if (this.a == null || !r0.a.h.b) {
            boolean z = false;
            int action;
            MarginLayoutParams marginLayoutParams;
            float rawY;
            float rawY2;
            if (r0.B) {
                com.xunlei.downloadprovider.homepage.b bVar = r0.E;
                action = motionEvent.getAction();
                bVar.c.addMovement(motionEvent2);
                marginLayoutParams = (MarginLayoutParams) bVar.a.getLayoutParams();
                if (action == 0) {
                    rawY = motionEvent.getRawY();
                    bVar.i = rawY;
                    bVar.j = rawY;
                    bVar.n = marginLayoutParams.height;
                    bVar.l = false;
                    bVar.m = false;
                    bVar.c.clear();
                    bVar.d.abortAnimation();
                    bVar.e.removeMessages(1001);
                } else if (action == 2) {
                    rawY = motionEvent.getRawY() - bVar.i;
                    rawY2 = motionEvent.getRawY() - bVar.j;
                    bVar.j = motionEvent.getRawY();
                    if (!bVar.m) {
                        if (Math.abs(rawY) < ((float) bVar.k)) {
                            z = bVar.m;
                        }
                    }
                    if ((rawY2 <= 0.0f || marginLayoutParams.height >= bVar.h || bVar.b.e()) && (rawY2 >= 0.0f || marginLayoutParams.height <= bVar.g)) {
                        if (bVar.m && rawY2 < 0.0f) {
                            motionEvent2.setAction(0);
                            bVar.m = false;
                        }
                        rawY = motionEvent.getRawY();
                        bVar.i = rawY;
                        bVar.j = rawY;
                        bVar.n = marginLayoutParams.height;
                    } else {
                        marginLayoutParams.height = (int) (((float) bVar.n) + rawY);
                        if (marginLayoutParams.height > bVar.h) {
                            marginLayoutParams.height = bVar.h;
                        } else if (marginLayoutParams.height < bVar.g) {
                            marginLayoutParams.height = bVar.g;
                        }
                        bVar.a.requestLayout();
                        if (marginLayoutParams.topMargin + bVar.a.getMeasuredHeight() > bVar.f - com.xunlei.downloadprovider.homepage.b.a()) {
                            bVar.b.a(true);
                        } else {
                            bVar.b.a(false);
                        }
                        if (bVar.l) {
                            z = true;
                        } else {
                            bVar.l = true;
                            bVar.m = true;
                            motionEvent2.setAction(3);
                        }
                    }
                } else if (action == 1) {
                    rawY = motionEvent.getRawY() - bVar.i;
                    if (bVar.m && marginLayoutParams.height < bVar.h && marginLayoutParams.height > bVar.g) {
                        bVar.d.startScroll(0, marginLayoutParams.height, 0, (rawY > 0.0f ? bVar.h : bVar.g) - marginLayoutParams.height);
                        bVar.e.sendEmptyMessage(1001);
                    }
                    if (bVar.l && Math.abs(rawY) <= ((float) bVar.k)) {
                        motionEvent2.setAction(3);
                    }
                }
                if (z) {
                    return true;
                }
            } else if (r0.A) {
                r rVar = r0.D;
                action = motionEvent.getAction();
                rVar.c.addMovement(motionEvent2);
                marginLayoutParams = (MarginLayoutParams) rVar.a.getLayoutParams();
                if (action == 0) {
                    rawY = motionEvent.getRawY();
                    rVar.k = rawY;
                    rVar.l = rawY;
                    rVar.q = motionEvent.getRawX();
                    rVar.p = marginLayoutParams.topMargin;
                    rVar.n = false;
                    rVar.o = false;
                    rVar.c.clear();
                    rVar.e.abortAnimation();
                    rVar.f.removeMessages(1001);
                } else if (action == 2) {
                    rawY = motionEvent.getRawY() - rVar.k;
                    rawY2 = motionEvent.getRawY() - rVar.l;
                    float rawX = motionEvent.getRawX() - rVar.q;
                    rVar.l = motionEvent.getRawY();
                    rVar.q = motionEvent.getRawX();
                    if (!rVar.o) {
                        if (Math.abs(rawY) < ((float) rVar.m) || Math.abs(rawY2) <= Math.abs(rawX)) {
                            z = rVar.o;
                        }
                    }
                    if ((rawY2 <= 0.0f || marginLayoutParams.topMargin >= rVar.i || marginLayoutParams.topMargin <= rVar.i - rVar.a.getMeasuredHeight()) && ((rawY2 <= 0.0f || marginLayoutParams.topMargin != rVar.i - rVar.a.getMeasuredHeight() || rVar.b.e()) && (rawY2 >= 0.0f || marginLayoutParams.topMargin <= rVar.i - rVar.a.getMeasuredHeight()))) {
                        if (rVar.o && rawY2 < 0.0f) {
                            motionEvent2.setAction(0);
                            rVar.o = false;
                        }
                        rawY = motionEvent.getRawY();
                        rVar.k = rawY;
                        rVar.l = rawY;
                        rVar.p = marginLayoutParams.topMargin;
                    } else {
                        marginLayoutParams.topMargin = (int) (((float) rVar.p) + rawY);
                        if (marginLayoutParams.topMargin > rVar.i) {
                            marginLayoutParams.topMargin = rVar.i;
                        } else if (marginLayoutParams.topMargin <= rVar.i - rVar.a.getMeasuredHeight()) {
                            marginLayoutParams.topMargin = rVar.i - rVar.a.getMeasuredHeight();
                            if (rVar.j != null) {
                                rVar.j.a(false);
                            }
                        } else if (rVar.j != null) {
                            rVar.j.a(true);
                        }
                        if (marginLayoutParams.topMargin + rVar.a.getMeasuredHeight() > rVar.h - DipPixelUtil.dip2px(43.0f)) {
                            rVar.b.a(true);
                        } else {
                            rVar.b.a(false);
                        }
                        rVar.a.requestLayout();
                        if (rVar.n) {
                            z = true;
                        } else {
                            rVar.n = true;
                            rVar.o = true;
                            motionEvent2.setAction(3);
                        }
                    }
                } else if (action == 1) {
                    rawY = motionEvent.getRawY() - rVar.k;
                    if (rVar.o && marginLayoutParams.topMargin < rVar.i && marginLayoutParams.topMargin > rVar.i - rVar.a.getMeasuredHeight()) {
                        rVar.c.computeCurrentVelocity(1000);
                        float yVelocity = rVar.c.getYVelocity();
                        if (yVelocity >= ((float) rVar.d) || yVelocity <= ((float) (-rVar.d))) {
                            rVar.e.fling(0, marginLayoutParams.topMargin, 0, (int) yVelocity, 0, 0, -rVar.g, rVar.g);
                            rVar.f.sendEmptyMessage(1001);
                        }
                    }
                    if (rVar.n && Math.abs(rawY) <= ((float) rVar.m)) {
                        motionEvent2.setAction(3);
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        float rawY3 = motionEvent.getRawY();
        int[] iArr = new int[2];
        r0.i.getLocationOnScreen(iArr);
        if (rawY3 > ((float) (iArr[1] + r0.i.getMeasuredHeight())) && r0.s.a(motionEvent2)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private int i() {
        int i;
        r rVar;
        int i2;
        if (!(!this.A || this.n == 0 || this.o == 0)) {
            if ((((float) this.o) * 1.0f) / ((float) this.n) < 1.7777778f) {
                if ((((double) this.n) * 1.0d) / ((double) this.o) <= 1.6699999570846558d) {
                    i = (int) ((((float) (this.C * this.n)) * 1.0f) / ((float) this.o));
                    if (this.I) {
                        this.H = 0;
                    } else {
                        this.H = this.r.getMeasuredHeight();
                        if (this.H <= 0) {
                            this.H = getResources().getDimensionPixelSize(R.dimen.common_title_height) + com.xunlei.xllib.android.d.c(this);
                        }
                    }
                } else {
                    i = (int) ((((float) (this.C * this.n)) * 1.0f) / ((float) this.o));
                    this.H = 0;
                }
                if (this.D != null) {
                    rVar = this.D;
                    i2 = this.H;
                    if (rVar.i != i2) {
                        rVar.i = i2;
                    }
                }
                return i;
            }
        }
        i = (int) ((((float) (this.C * 9)) * 1.0f) / 16.0f);
        if (this.I) {
            this.H = 0;
        } else {
            this.H = this.r.getMeasuredHeight();
            if (this.H <= 0) {
                this.H = getResources().getDimensionPixelSize(R.dimen.common_title_height) + com.xunlei.xllib.android.d.c(this);
            }
        }
        if (this.D != null) {
            rVar = this.D;
            i2 = this.H;
            if (rVar.i != i2) {
                rVar.i = i2;
            }
        }
        return i;
    }

    private int j() {
        return (int) ((((float) (this.C * 9)) * 1.0f) / 16.0f);
    }

    private boolean k() {
        return From.HOME_PAGE_AD.getText().equals(this.e);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(BaseVideoInfo.JSON_KEY, this.K);
        super.onSaveInstanceState(bundle);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.K = (BaseVideoInfo) bundle.getParcelable(BaseVideoInfo.JSON_KEY);
    }

    protected void onStart() {
        super.onStart();
        this.u = false;
        com.xunlei.downloadprovider.broadcast.a.a().a(this.z);
        if (this.v) {
            this.v = false;
            a(this.K, this.L, this.e);
        }
    }

    protected void onStop() {
        this.u = true;
        com.xunlei.downloadprovider.broadcast.a.a().b(this.z);
        this.x.removeCallbacks(this.aa);
        if (this.a != null) {
            if (this.a.f.e) {
                this.a.a(false, false);
            } else {
                this.a.b();
            }
        }
        super.onStop();
    }

    public void onBackPressed() {
        if (!this.a.k()) {
            finish();
            if (From.SHARE_PAGE.equals(this.e)) {
                MainTabActivity.b(this, "thunder", null);
                return;
            }
            RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
            if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
                MainTabActivity.b(this, "thunder", null);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.a((Activity) this, i, i2, intent);
    }

    public static void a(Context context, From from, String str, String str2, String str3, int i, int i2, String str4, String str5) {
        Intent xLIntent = new XLIntent(context, ShortMovieDetailActivity.class);
        Parcelable baseVideoInfo = new BaseVideoInfo();
        baseVideoInfo.setVideoId(str);
        baseVideoInfo.setGcid(str2);
        baseVideoInfo.setTitle(str3);
        baseVideoInfo.setPlayUrl(str4);
        baseVideoInfo.setCoverUrl(str5);
        xLIntent.putExtra(BaseVideoInfo.JSON_KEY, baseVideoInfo);
        xLIntent.putExtra("from", from.mText);
        xLIntent.putExtra("played_position", i);
        xLIntent.putExtra("total_time", i2);
        context.startActivity(xLIntent);
    }

    public final void a(com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar, boolean z) {
        l();
        if (this.a != null) {
            String access$3100;
            if (z) {
                access$3100 = From.VIDEO_REC.mText;
            } else {
                access$3100 = From.VIDEO_SCREEN.mText;
            }
            a(bVar);
            a(bVar.a(), bVar.b(), access$3100);
            m();
            bVar.b();
            n();
            this.k.a(bVar);
            this.G.a(bVar.b());
            this.t.putHead(bVar);
            this.m.c(this.t.isBackEnd() ^ 1);
        }
    }

    private void l() {
        this.o = 0;
        this.n = 0;
    }

    private void a(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, String str) {
        this.x.removeCallbacks(this.aa);
        if (baseVideoInfo != null && this.a != null) {
            y yVar = new y(baseVideoInfo.getVideoId(), baseVideoInfo.getPlayUrl(), baseVideoInfo.getTitle(), str);
            yVar.o = baseVideoInfo.getCoverUrl();
            yVar.f = baseVideoInfo.getGcid();
            yVar.n = baseVideoInfo.getServerExtData();
            yVar.t = videoUserInfo.getLiveExtra();
            yVar.r = baseVideoInfo.getPublisherId();
            if (k() != null) {
                yVar.h = null;
            }
            this.a.a(yVar);
        }
    }

    public final void a(String str, com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar) {
        if (bVar != null) {
            this.K = bVar.a();
        }
        if (this.U) {
            this.U = false;
            boolean z = this.K != null && this.K.isFromYouLiaoShot();
            boolean z2 = z && d.a().r.j();
            bv.a(this.K.getVideoId(), this.e, z, z2);
        }
        if (this.a != null) {
            if (!ITagManager.SUCCESS.contentEquals(str)) {
                if (!("reject".contentEquals(str) == null && "not exist".contentEquals(str) == null)) {
                    this.j.setText(getResources().getString(R.string.video_tip_offline));
                    this.j.setVisibility(0);
                    this.a.b();
                }
            } else if (bVar != null) {
                a(bVar);
                bVar.b();
                n();
                y n = this.a.n();
                new StringBuilder("mFlowBaseInfoView. setMarginBottom: ").append(System.currentTimeMillis());
                this.k.setMarginBottom(PlayerOperationViewDetail.a(n) ? PlayerOperationViewDetail.getLivingBarSpaceY() : 0);
                this.k.a(bVar);
                this.G.a(bVar.b());
                if (this.Q && a(this.L)) {
                    BaseVideoInfo a = bVar.a();
                    if (a != null) {
                        String videoId = a.getVideoId();
                        g gVar = this.f.c;
                        if (gVar.a != null) {
                            XLThreadPool.execute(new t(gVar, videoId));
                        }
                    }
                    this.O.setOnClickListener(new v(this));
                }
                this.j.setVisibility(4);
                d(this.H == 0);
                if (n == null || !TextUtils.equals(n.d, bVar.a().getVideoId())) {
                    this.v = true;
                    if (this.u == null) {
                        this.v = false;
                        a(this.K, this.L, this.e);
                    }
                    return;
                }
                if (TextUtils.isEmpty(n.o)) {
                    n.o = bVar.a().getCoverUrl();
                }
            }
        }
    }

    private static boolean a(VideoUserInfo videoUserInfo) {
        return videoUserInfo == null ? null : TextUtils.equals(videoUserInfo.getKind(), "gamegzh");
    }

    private void a(com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar) {
        this.K = bVar.a();
        this.L = bVar.b();
        this.P = null;
    }

    private void m() {
        if (!this.a.h.b) {
            ((MarginLayoutParams) this.i.getLayoutParams()).topMargin = this.H;
            this.i.requestLayout();
        }
    }

    private void n() {
        this.G.setVisibility(this.J ? 8 : 0);
    }

    public final void a(List<e> list) {
        if (this.a != null) {
            boolean z = true;
            if (list == null || list.isEmpty() != null) {
                list = this.m;
                if (this.t.isForwardEnd()) {
                    z = false;
                }
            } else {
                list = this.m;
            }
            list.d(z);
        }
    }

    public final void a(String str) {
        this.P = str;
    }

    public final void b(boolean z) {
        int i = 0;
        this.i.setVisibility(z ? 8 : 0);
        ImageView imageView = this.p;
        if (z || From.HOME_PAGE_AD.getText().contentEquals(this.e)) {
            i = 4;
        }
        imageView.setVisibility(i);
    }

    public final void a(com.xunlei.downloadprovider.shortvideo.videodetail.model.c cVar) {
        if (cVar != null) {
            if (this.k != null) {
                this.k.c.a(cVar);
            }
            if (this.G != null) {
                this.G.a(cVar);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.N = z;
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public final void c(boolean z) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.i.getLayoutParams();
        if (this.B) {
            z = j();
            if (marginLayoutParams.height > z) {
                marginLayoutParams.height = z;
            }
            this.i.requestLayout();
            a(marginLayoutParams);
        } else if (this.A) {
            if (z) {
                marginLayoutParams.topMargin = this.H;
            } else {
                marginLayoutParams.topMargin = this.H - this.i.getMeasuredHeight();
            }
            z = z && !this.H;
            d(z);
            this.i.requestLayout();
            this.k.b();
            a(marginLayoutParams);
        }
    }

    public final int c() {
        if (this.H != 0) {
            return 0;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.titlebar_height);
        return !j.b(this) ? dimensionPixelSize + com.xunlei.xllib.android.d.c(this) : dimensionPixelSize;
    }

    protected void onDestroy() {
        if (this.a != null) {
            this.a.q();
        }
        this.k.e = null;
        this.a = null;
        this.m = null;
        this.x.removeCallbacks(this.ab);
        super.onDestroy();
    }

    private void o() {
        if (this.I) {
            this.H = 0;
        } else {
            this.H = getResources().getDimensionPixelSize(R.dimen.common_title_height);
        }
    }

    private void a(MarginLayoutParams marginLayoutParams) {
        this.x.post(new y(this, marginLayoutParams));
    }

    public final void a(boolean z) {
        z = z && !this.H;
        d(z);
    }

    private void d(boolean z) {
        this.c = z;
        a(this.d, this.c);
    }

    final void a(boolean z, boolean z2) {
        if (z || z2) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
        }
        if (!z) {
            if (!z2) {
                this.r.setBackgroundColor(true);
                this.T.setVisibility(0);
                this.q.setImageResource(true);
                this.p.setImageResource(true);
                e(false);
                return;
            }
        }
        this.r.setBackgroundResource(true);
        this.T.setVisibility(8);
        this.q.setImageResource(true);
        this.p.setImageResource(true);
        e(true);
    }

    private void e(boolean z) {
        int i = 0;
        if (VERSION.SDK_INT >= 23) {
            if (z) {
                j.b(this);
                z = getWindow();
                if (j.b(this)) {
                    i = getResources().getColor(R.color.status_bar_color_dark);
                }
                z.setStatusBarColor(i);
                return;
            }
            j.a(this);
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        } else if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            if (!z) {
                i = -16777216;
            }
            window.setStatusBarColor(i);
        } else {
            if (VERSION.SDK_INT >= 19) {
                if (!z) {
                    i = -16777216;
                }
                com.xunlei.downloadprovider.xlui.a.a(this, i);
            }
        }
    }

    public final boolean a(Activity activity, View view) {
        boolean z = false;
        if (!j.b(activity)) {
            if (VERSION.SDK_INT >= 19) {
                if (VERSION.SDK_INT >= 21) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | 1024);
                    activity.getWindow().addFlags(Integer.MIN_VALUE);
                    activity.getWindow().clearFlags(67108864);
                    activity.getWindow().setStatusBarColor(0);
                    if (view != null) {
                        view.setFitsSystemWindows(true);
                    }
                } else if (VERSION.SDK_INT >= 19) {
                    activity.getWindow().addFlags(67108864);
                    if (view != null) {
                        view.setFitsSystemWindows(true);
                    }
                    com.xunlei.downloadprovider.xlui.a.a(activity, 0);
                }
                z = true;
            }
        }
        this.V = z;
        return this.V;
    }

    protected final int e() {
        return getResources().getColor(R.color.status_bar_color_dark);
    }

    public static void a(Context context, a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("BundleInfo object is NULL!");
        } else if (TextUtils.isEmpty(aVar.a)) {
            throw new IllegalArgumentException("BundleInfo#movieId is Requested!");
        } else if (aVar.u == null) {
            throw new IllegalArgumentException("BundleInfo#extraFrom is Requested!");
        } else {
            Intent xLIntent = new XLIntent(context, ShortMovieDetailActivity.class);
            new StringBuilder("set movie id =>").append(aVar.a);
            xLIntent.putExtra("from", aVar.u.mText);
            xLIntent.putExtra("played_position", aVar.h);
            xLIntent.putExtra("total_time", aVar.i);
            xLIntent.putExtra("seek_to_comment", aVar.s);
            xLIntent.putExtra("show_comment_dialog", false);
            xLIntent.putExtra("player_id", aVar.p);
            xLIntent.putExtra("s_params", aVar.q);
            xLIntent.putExtra("should_continue_play_after_finish", aVar.r);
            Parcelable parcelable = aVar.v;
            if (parcelable == null) {
                parcelable = new BaseVideoInfo();
                parcelable.setVideoId(aVar.a);
                parcelable.setGcid(aVar.b);
                parcelable.setTitle(aVar.c);
                parcelable.setPlayUrl(aVar.d);
                parcelable.setCoverUrl(aVar.e);
                parcelable.setLikeCount(aVar.f);
                parcelable.setHasLike(aVar.g);
            }
            xLIntent.putExtra(BaseVideoInfo.JSON_KEY, parcelable);
            parcelable = aVar.w;
            if (parcelable == null) {
                parcelable = new VideoUserInfo();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(aVar.j);
                parcelable.setUid(stringBuilder.toString());
                parcelable.setPortraitUrl(aVar.k);
                parcelable.setNickname(aVar.l);
                parcelable.setKind(aVar.o);
                parcelable.getPubExtra().a = aVar.n;
                parcelable.getPubExtra().b = aVar.m;
            }
            xLIntent.putExtra(VideoUserInfo.JSON_KEY, parcelable);
            Activity activity;
            if ((context instanceof MainTabActivity) != null) {
                activity = (Activity) context;
                activity.startActivityForResult(xLIntent, 1000);
                activity.overridePendingTransition(0, 0);
            } else if ((context instanceof PublisherActivity) != null) {
                activity = (Activity) context;
                activity.startActivityForResult(xLIntent, 1000);
                activity.overridePendingTransition(0, 0);
            } else {
                if ((context instanceof Activity) != null) {
                    context.startActivity(xLIntent);
                    ((Activity) context).overridePendingTransition(0, 0);
                }
            }
        }
    }

    public final void a() {
        if (this.f != null) {
            this.f.c();
        }
    }

    public final void b() {
        if (this.K != null) {
            ReportActivity.a(this, 1, this.K.getVideoId(), this.K.getGcid(), DispatchConstants.OTHER);
        }
    }

    static /* synthetic */ boolean m(ShortMovieDetailActivity shortMovieDetailActivity) {
        return (!shortMovieDetailActivity.Q || shortMovieDetailActivity.w || TextUtils.isEmpty(shortMovieDetailActivity.P) || a(shortMovieDetailActivity.L) == null) ? null : true;
    }

    static /* synthetic */ void n(ShortMovieDetailActivity shortMovieDetailActivity) {
        shortMovieDetailActivity.O.setVisibility(0);
        bv.e(shortMovieDetailActivity.K.getVideoId());
    }

    static /* synthetic */ void y(ShortMovieDetailActivity shortMovieDetailActivity) {
        shortMovieDetailActivity.Y = true;
        shortMovieDetailActivity.g();
        if (shortMovieDetailActivity.y != null && shortMovieDetailActivity.y.isStarted()) {
            shortMovieDetailActivity.y.cancel();
        }
        if (shortMovieDetailActivity.D != null) {
            shortMovieDetailActivity.D.f.removeMessages(1001);
        }
        shortMovieDetailActivity.h.setVisibility(8);
        shortMovieDetailActivity.f.d(false);
        shortMovieDetailActivity.r.setVisibility(8);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) shortMovieDetailActivity.i.getLayoutParams();
        marginLayoutParams.height = -1;
        marginLayoutParams.topMargin = 0;
        shortMovieDetailActivity.i.requestLayout();
        if (VERSION.SDK_INT < 21 && VERSION.SDK_INT >= 19) {
            com.xunlei.downloadprovider.xlui.a.a(shortMovieDetailActivity, 0);
        }
        com.xunlei.downloadprovider.cooperation.ui.b.a().c = false;
    }

    static /* synthetic */ void z(ShortMovieDetailActivity shortMovieDetailActivity) {
        boolean z = false;
        shortMovieDetailActivity.Y = false;
        shortMovieDetailActivity.g();
        shortMovieDetailActivity.h.setVisibility(0);
        shortMovieDetailActivity.r.setVisibility(0);
        shortMovieDetailActivity.f.d(true);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) shortMovieDetailActivity.i.getLayoutParams();
        marginLayoutParams.height = shortMovieDetailActivity.i();
        marginLayoutParams.topMargin = shortMovieDetailActivity.H;
        shortMovieDetailActivity.i.requestLayout();
        if (shortMovieDetailActivity.H == 0) {
            z = true;
        }
        shortMovieDetailActivity.d(z);
        shortMovieDetailActivity.a(marginLayoutParams);
        shortMovieDetailActivity.f.a();
        com.xunlei.downloadprovider.cooperation.ui.b.a().c = true;
    }

    static /* synthetic */ void A(ShortMovieDetailActivity shortMovieDetailActivity) {
        shortMovieDetailActivity.f.d(shortMovieDetailActivity.P);
        bv.b("play", shortMovieDetailActivity.K.getVideoId());
    }

    static /* synthetic */ void P(ShortMovieDetailActivity shortMovieDetailActivity) {
        int color;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) shortMovieDetailActivity.i.getLayoutParams();
        int i = marginLayoutParams.height;
        int i2 = shortMovieDetailActivity.i();
        int i3 = marginLayoutParams.topMargin;
        int i4 = shortMovieDetailActivity.H;
        if (shortMovieDetailActivity.r.getBackground() instanceof ColorDrawable) {
            color = ((ColorDrawable) shortMovieDetailActivity.r.getBackground()).getColor();
        } else {
            color = shortMovieDetailActivity.R;
        }
        int i5 = color;
        int i6 = shortMovieDetailActivity.H == 0 ? shortMovieDetailActivity.R : -1;
        shortMovieDetailActivity.y = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        shortMovieDetailActivity.y.addUpdateListener(new z(shortMovieDetailActivity, i, i2, i3, i4, marginLayoutParams, i5, i6));
        shortMovieDetailActivity.y.addListener(new aa(shortMovieDetailActivity, i4, marginLayoutParams));
        shortMovieDetailActivity.k.d = true;
        shortMovieDetailActivity.y.start();
    }

    static /* synthetic */ int a(int i, int i2, float f) {
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int green = Color.green(i);
        i = Color.blue(i);
        return Color.argb((int) (((float) alpha) + (((float) (Color.alpha(i2) - alpha)) * f)), (int) (((float) red) + (((float) (Color.red(i2) - red)) * f)), (int) (((float) green) + (((float) (Color.green(i2) - green)) * f)), (int) (((float) i) + (((float) (Color.blue(i2) - i)) * f)));
    }
}
