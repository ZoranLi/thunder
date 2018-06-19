package com.xunlei.downloadprovider.cardslide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.constant.WBConstants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cardslide.c.a;
import com.xunlei.downloadprovider.cardslide.c.b;
import com.xunlei.downloadprovider.cardslide.d.c;
import com.xunlei.downloadprovider.cardslide.slide.CardItemView;
import com.xunlei.downloadprovider.cardslide.slide.CardSlidePanel;
import com.xunlei.downloadprovider.comment.entity.e;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer.VideoViewType;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.ControlType;
import com.xunlei.downloadprovider.player.xmp.y;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.android.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardSlideActivity extends BaseActivity {
    private static final String c = "CardSlideActivity";
    private PlayerContainer A = new h(this);
    private MessageListener B = new l(this);
    public List<a> a = new ArrayList();
    private String[] d = new String[]{"视频很棒哦，加油！", "超赞，我会持续关注你！", "喜欢，期待你更多的作品！", "好喜欢你的视频", "视频超赞，忍不住多看几遍！", "我会一直支持你呦。", "永远支持你，很棒哦。", "支持你！加油！", "必须关注呀！", "看了好几遍，停不下来了！很棒哦~"};
    private RelativeLayout e;
    private CardSlidePanel f;
    private TextView g;
    private ViewGroup h;
    private TitleBar i;
    private RelativeLayout j;
    private RelativeLayout k;
    private RelativeLayout l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ErrorBlankView p;
    private UnifiedLoadingView q;
    private Button r;
    private LoginHelper s = LoginHelper.a();
    private CountDownTimer t;
    private com.xunlei.downloadprovider.comment.a u;
    private StaticHandler v;
    private a w;
    private ThunderXmpPlayer x;
    private boolean y = false;
    private int z = -1;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_card_slide);
        this.v = new StaticHandler(this.B);
        c.a("init", b.a);
        if (b.a.size() > null) {
            this.a = new ArrayList(b.a);
        }
        this.u = new com.xunlei.downloadprovider.comment.a();
        this.i = new TitleBar((Activity) this);
        this.i.mTitle.setText(getResources().getString(R.string.card_slide_page_title));
        this.f = (CardSlidePanel) findViewById(R.id.image_slide_panel);
        this.e = (RelativeLayout) findViewById(R.id.rl_end_contain);
        this.g = (TextView) findViewById(R.id.tv_remaining_time);
        this.j = (RelativeLayout) findViewById(R.id.fl_bottom_btn_contain);
        this.k = (RelativeLayout) findViewById(R.id.fl_btn_left);
        this.l = (RelativeLayout) findViewById(R.id.fl_btn_right);
        this.m = (ImageView) findViewById(R.id.iv_btn_left);
        this.n = (ImageView) findViewById(R.id.iv_btn_right);
        this.o = (ImageView) findViewById(R.id.iv_btn_right_ani);
        this.p = (ErrorBlankView) findViewById(R.id.card_slide_ev_show);
        this.q = (UnifiedLoadingView) findViewById(R.id.card_slide_loading_view);
        this.r = (Button) findViewById(R.id.btn_card_slide);
        if (d.b(BrothersApplication.getApplicationInstance()) < WBConstants.SDK_NEW_PAY_VERSION) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, DipPixelUtil.dip2px(105.0f));
            layoutParams.addRule(12);
            this.j.setLayoutParams(layoutParams);
        } else if (c.c()) {
            findViewById(R.id.view_temp).setLayoutParams(new RelativeLayout.LayoutParams(-1, DipPixelUtil.dip2px(530.0f)));
        }
        this.f.setCardSwitchListener(new m(this));
        this.f.setAdapter(new n(this));
        if (b.c) {
            this.p.setVisibility(8);
            a(c.b());
        } else if (b.a.size() == 0) {
            h();
        }
        findViewById(R.id.iv_btn_left).setOnClickListener(new o(this));
        this.m.setOnClickListener(new p(this));
        findViewById(R.id.iv_btn_right).setOnClickListener(new q(this));
        this.i.mTitle.setOnClickListener(new r(this));
        this.r.setOnClickListener(new s(this));
        u.a(getIntent().getStringExtra("from"), this.a.size() > 0);
    }

    protected void onResumeFragments() {
        super.onResumeFragments();
        c();
    }

    private void c() {
        if (this.p.getVisibility() == 0 || this.e.getVisibility() == 0 || this.f.getVisibility() == 0) {
            if (System.currentTimeMillis() / 1000 > com.xunlei.downloadprovider.cardslide.d.a.a().c()) {
                this.q.setVisibility(0);
                this.p.setVisibility(8);
                this.e.setVisibility(8);
                this.j.setVisibility(8);
                b.d = true;
                b.a().a(new a(this));
            }
        }
    }

    private void d() {
        this.n.setScaleX(1.0f);
        this.n.setScaleY(1.0f);
        this.l.setScaleX(1.0f);
        this.l.setScaleY(1.0f);
    }

    private void g() {
        this.m.setBackgroundResource(R.drawable.ic_card_btn_del_gray);
        this.m.setRotation(0.0f);
        this.m.setScaleX(1.0f);
        this.m.setScaleY(1.0f);
        this.k.setScaleX(1.0f);
        this.k.setScaleY(1.0f);
    }

    public static void a() {
        u.a(u.a);
        u.a.clear();
    }

    private void a(a aVar) {
        if (aVar != null && !b.b.contains(aVar.c) && !aVar.b.hasLike()) {
            f a = f.a();
            BaseVideoInfo baseVideoInfo = aVar.b;
            aVar = aVar.a;
            com.xunlei.downloadprovider.e.a.d dVar = new com.xunlei.downloadprovider.e.a.d(baseVideoInfo.getVideoId(), baseVideoInfo.getGcid(), baseVideoInfo.getLikeCount());
            dVar.e = false;
            a.a(this, dVar, new b(this, baseVideoInfo, aVar));
        }
    }

    private void a(int i, a aVar) {
        if (aVar != null) {
            this.x = ak.a().a(PlayerTag.CARD_SLIDE, ControlType.SLIDE_CARD_PLAY);
            this.x.y = false;
            this.x.o = "hot_or_not";
            this.x.q = VideoViewType.ZOOM_AND_TAILOR;
            this.x.a((BaseActivity) this, this.A);
            BaseVideoInfo baseVideoInfo = aVar.b;
            y yVar = new y(baseVideoInfo.getVideoId(), baseVideoInfo.getPlayUrl(), baseVideoInfo.getTitle());
            yVar.o = baseVideoInfo.getCoverUrl();
            yVar.g = true;
            yVar.k = "hot_or_not_auto_play";
            yVar.o = aVar.b.getCoverUrl();
            yVar.p = ScaleType.CENTER_CROP;
            yVar.r = baseVideoInfo.getPublisherId();
            this.x.a(yVar);
            this.x.a(new e(this, i));
            this.x.c(new f(this));
            this.x.t = new g(this);
        }
    }

    protected void onResume() {
        super.onResume();
        this.v.sendEmptyMessageDelayed(1000, 500);
    }

    protected void onPause() {
        this.v.removeMessages(1000);
        if (this.x != null) {
            this.x.a(false, false);
        }
        super.onPause();
    }

    private void a(long j) {
        this.e.setVisibility(0);
        this.t = new j(this, j * 1000);
        this.t.start();
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, CardSlideActivity.class);
        intent.putExtra("from", str);
        context.startActivity(intent);
    }

    private void h() {
        this.p.setErrorType(0);
        this.p.setVisibility(0);
        this.p.a("", null);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            Intent xLIntent = new XLIntent();
            xLIntent.setAction("com.xunlei.action.ACTION_VOLUME_UP_KEY_DOWN");
            LocalBroadcastManager.getInstance(this).sendBroadcast(xLIntent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.t != null) {
            this.t.cancel();
        }
        this.v.removeMessages(1000);
        ak.a().c(PlayerTag.CARD_SLIDE);
        this.s.k = null;
        if (this.v != null) {
            this.v.removeCallbacksAndMessages(null);
        }
        a();
    }

    private void b(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.a.getUid()) && !com.xunlei.downloadprovider.homepage.follow.b.a().b(Long.valueOf(aVar.a.getUid()).longValue())) {
            VideoUserInfo videoUserInfo = aVar.a;
            Object uid = aVar.a.getUid();
            if (!TextUtils.isEmpty(uid)) {
                com.xunlei.downloadprovider.homepage.follow.b.a().a(Long.valueOf(uid).longValue(), false, new c(this, aVar, videoUserInfo));
            }
        }
    }

    private void c(a aVar) {
        BaseVideoInfo baseVideoInfo = aVar.b;
        aVar = aVar.a;
        this.u.a(new e(1, baseVideoInfo.getGcid(), baseVideoInfo.getVideoId()));
        String str = this.d[new Random().nextInt(10)];
        this.u.a(str, AndroidConfig.getPhoneBrand(), new d(this, baseVideoInfo, aVar, str));
    }

    static /* synthetic */ void b(CardSlideActivity cardSlideActivity) {
        cardSlideActivity.g();
        cardSlideActivity.d();
    }

    static /* synthetic */ void a(CardSlideActivity cardSlideActivity, int i, CardItemView cardItemView) {
        cardSlideActivity.z = i;
        cardSlideActivity.w = (a) cardSlideActivity.a.get(i);
        cardSlideActivity.h = cardItemView.getCardVodLayout();
        cardSlideActivity.a(i, (a) cardSlideActivity.a.get(i));
        cardSlideActivity = cardSlideActivity.w.c;
        if (u.a != 0 && u.a.contains(cardSlideActivity) == 0) {
            u.a.add(cardSlideActivity);
        }
    }

    static /* synthetic */ void d(CardSlideActivity cardSlideActivity) {
        cardSlideActivity.o.setAlpha(1.0f);
        cardSlideActivity.n.setAlpha(0.0f);
        cardSlideActivity.o.setBackgroundResource(R.drawable.card_slide_love_btn_ani);
        AnimationDrawable animationDrawable = (AnimationDrawable) cardSlideActivity.o.getBackground();
        animationDrawable.start();
        int i = 0;
        int i2 = 0;
        while (i < animationDrawable.getNumberOfFrames()) {
            i2 += animationDrawable.getDuration(i);
            i++;
        }
        new Handler().postDelayed(new i(cardSlideActivity, animationDrawable), (long) i2);
    }

    static /* synthetic */ void a(CardSlideActivity cardSlideActivity, boolean z, int i, int i2) {
        boolean z2 = true;
        cardSlideActivity.f.a(1);
        a aVar = (a) cardSlideActivity.a.get(i);
        if (i2 == 1) {
            if (l.c()) {
                cardSlideActivity.a(aVar);
                cardSlideActivity.b(aVar);
                cardSlideActivity.c(aVar);
            } else {
                cardSlideActivity.s.a(cardSlideActivity, new t(cardSlideActivity, aVar), LoginFrom.CARD_SLIDE_PAGE, null);
            }
        }
        new StringBuilder("handleCardVanish resId = ").append(((a) cardSlideActivity.a.get(i)).c);
        b.a.remove(aVar);
        c.a("handleCardVanish", b.a);
        if (b.a.size() == 0) {
            b.c = true;
        }
        XLThreadPool.execute(new com.xunlei.downloadprovider.cardslide.a.c(com.xunlei.downloadprovider.cardslide.a.a.a(), aVar.c));
        com.xunlei.downloadprovider.cardslide.d.a.a().b();
        if (b.a.size() == 0) {
            cardSlideActivity.a(c.b());
        }
        i = aVar.c;
        if (i2 != 1) {
            z2 = false;
        }
        u.a(i, z, z2);
        if (u.a.size() >= true) {
            a();
        }
        if (cardSlideActivity.x) {
            cardSlideActivity.x.q();
        }
    }

    static /* synthetic */ void a(String str) {
        if (b.b != null && !b.b.contains(str)) {
            b.b.add(str);
        }
    }

    static /* synthetic */ void t(CardSlideActivity cardSlideActivity) {
        cardSlideActivity.q.setVisibility(8);
        cardSlideActivity.j.setVisibility(0);
        cardSlideActivity.f.getAdapter().b.notifyChanged();
    }
}
