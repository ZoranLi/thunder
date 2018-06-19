package com.xunlei.downloadprovider.player.xmp;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.aplayer.aplayerandroid.APlayerAndroid;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.ViewUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.concurrent.XLThreadPool$ForDatabase;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.broadcast.b;
import com.xunlei.downloadprovider.homepage.recommend.a.i;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.downloadprovider.personal.playrecord.w;
import com.xunlei.downloadprovider.player.xmp.XmpMediaPlayer.BufferingState;
import com.xunlei.downloadprovider.player.xmp.b.g;
import com.xunlei.downloadprovider.player.xmp.b.h;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer.ContainerType;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.ControlType;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.a;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.c;
import com.xunlei.downloadprovider.player.xmp.ui.ad;
import com.xunlei.downloadprovider.player.xmp.ui.m;
import com.xunlei.downloadprovider.player.xmp.ui.q;
import com.xunlei.downloadprovider.player.xmp.ui.u;
import com.xunlei.downloadprovider.player.xmp.ui.widget.DoubleClickAnimationView;
import com.xunlei.downloadprovider.player.xmp.ui.widget.PlayCompleteLikeGuideView;
import com.xunlei.downloadprovider.player.xmp.ui.z;
import com.xunlei.downloadprovider.plugin.videoplayervod.VodPlayerParams;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper.Entrance;
import java.io.File;
import java.util.HashMap;
import org.android.agoo.message.MessageService;

public final class ThunderXmpPlayer {
    private static boolean H = true;
    private TextureView A;
    private int B;
    private int C;
    private ControlType D;
    private boolean E;
    private boolean F;
    private long G;
    private HashMap<ContainerType, PlayerContainer> I = new HashMap();
    private aj J;
    private boolean K;
    private c L;
    private j M;
    private BroadcastReceiver N = new t(this);
    private b O = new u(this);
    private OnLayoutChangeListener P = new w(this);
    ak a = ak.a();
    public int b = com.xunlei.downloadprovider.player.xmp.b.b.a();
    PlayerTag c;
    Context d = BrothersApplication.getApplicationInstance();
    public BaseActivity e;
    public XmpMediaPlayer f;
    public FrameLayout g;
    public g h;
    public e i;
    public int j;
    public int k;
    public PlayerControl l;
    public OnVideoSizeChangedListener m;
    public int n;
    public String o;
    public boolean p;
    public VideoViewType q = VideoViewType.ADAPTIVE_VIEW_TYPE;
    PlayerContainer r;
    public a s;
    public a t;
    public PlayerControl.b u;
    public boolean v = true;
    public PlayCompleteLikeGuideView w;
    public PlayCompleteLikeGuideView.a x;
    public boolean y = true;
    private long z = -1;

    public enum VideoViewType {
        ADAPTIVE_VIEW_TYPE,
        ZOOM_AND_TAILOR,
        FILL_PARENT
    }

    public final void a(boolean z) {
        g gVar = this.h;
        StringBuilder stringBuilder = new StringBuilder("setOrientationListenerEnabled--enabled=");
        stringBuilder.append(z);
        stringBuilder.append("|prevEnabled=");
        stringBuilder.append(gVar.g);
        gVar.g = z;
        if (gVar.a != null) {
            if (!z) {
                gVar.a(false);
            } else if (gVar.a.l() || gVar.a.m()) {
                gVar.a(true);
            }
        }
    }

    public ThunderXmpPlayer(PlayerTag playerTag, ControlType controlType) {
        this.c = playerTag;
        this.f = new XmpMediaPlayer();
        playerTag = this.f;
        playerTag.a(8, "1");
        playerTag.a(209, "1");
        playerTag.a(504, "0");
        playerTag.a(1002, MessageService.MSG_DB_COMPLETE);
        playerTag.a(1005, "300");
        playerTag.a(new q(this, playerTag));
        this.g = (FrameLayout) LayoutInflater.from(this.d).inflate(R.layout.xmp_media_player_layout, null);
        this.g.addOnLayoutChangeListener(this.P);
        TextureView textureView = (TextureView) this.g.findViewById(R.id.texture_view);
        XmpMediaPlayer xmpMediaPlayer = this.f;
        new StringBuilder("setView----textureView=").append(textureView);
        xmpMediaPlayer.a.setView(textureView);
        this.A = textureView;
        this.h = new g(this);
        this.q = VideoViewType.ADAPTIVE_VIEW_TYPE;
        a(controlType);
        this.M = new j(this.d, this.g);
    }

    final void a(ContainerType containerType, PlayerContainer playerContainer) {
        if (playerContainer != null) {
            if (this.r == playerContainer) {
                playerContainer.a(this);
                return;
            }
            new StringBuilder("attach--").append(this);
            u();
            this.r = playerContainer;
            this.I.put(containerType, playerContainer);
            this.l.e();
            containerType = this.a;
            new StringBuilder("onPlayerAttach--xmpPlayer=").append(this);
            if (this != null) {
                containerType.a(this.c, this);
            }
            containerType = playerContainer.getContainerLayout();
            x();
            StringBuilder stringBuilder = new StringBuilder("addContainerTo--parent=");
            stringBuilder.append(containerType);
            stringBuilder.append("|");
            stringBuilder.append(this);
            containerType.addView(this.g, new LayoutParams(-1, -1));
            playerContainer.a(this);
        }
    }

    private void u() {
        if (this.r != null) {
            new StringBuilder("detach---").append(this);
            ak akVar = this.a;
            ThunderXmpPlayer thunderXmpPlayer = (ThunderXmpPlayer) akVar.b.get(this.b);
            if (thunderXmpPlayer != null) {
                new StringBuilder("onPlayerDetach--player=").append(thunderXmpPlayer);
                PlayerTag playerTag = thunderXmpPlayer.c;
                if (playerTag != null) {
                    h hVar = (h) akVar.c.get(playerTag);
                    if (hVar != null) {
                        if (!hVar.a.isEmpty()) {
                            hVar.a(thunderXmpPlayer);
                            if (hVar.a.isEmpty()) {
                                akVar.c.remove(playerTag);
                            }
                        }
                    }
                }
            }
            x();
            this.r.b(this);
            this.M.a();
            b(false);
            this.r = null;
        }
    }

    public final void a(BaseActivity baseActivity, PlayerContainer playerContainer) {
        StringBuilder stringBuilder = new StringBuilder("attachActivity--activity=");
        stringBuilder.append(baseActivity);
        stringBuilder.append("|");
        stringBuilder.append(this);
        if (baseActivity != null) {
            if (playerContainer != null) {
                this.e = baseActivity;
                a(ContainerType.NORMAL, playerContainer);
                LocalBroadcastManager.getInstance(baseActivity).registerReceiver(this.N, new IntentFilter("com.xunlei.action.ACTION_VOLUME_UP_KEY_DOWN"));
                com.xunlei.downloadprovider.broadcast.a.a().a(this.O);
            }
        }
    }

    public final void a() {
        new StringBuilder("detachActivity--").append(this);
        if (this.e != null) {
            if (this.e != null) {
                LocalBroadcastManager.getInstance(this.e).unregisterReceiver(this.N);
            }
            this.N = null;
            com.xunlei.downloadprovider.broadcast.a.a().b(this.O);
            this.O = null;
            u();
            this.e = null;
        }
    }

    final PlayerContainer a(ContainerType containerType) {
        return (PlayerContainer) this.I.get(containerType);
    }

    public final void a(ControlType controlType) {
        if (this.D == null || this.D != controlType) {
            if (!(this.D == null || this.l == null)) {
                this.l.d();
            }
            this.D = controlType;
            switch (x.a[controlType.ordinal()]) {
                case 1:
                    controlType = new u(this.d);
                    break;
                case 2:
                    controlType = new m(this.d);
                    break;
                case 3:
                    controlType = new ad(this.d);
                    break;
                case 4:
                    controlType = new z(this.d);
                    break;
                default:
                    controlType = new q(this.d);
                    break;
            }
            controlType.a(this);
            controlType.a(n());
            this.l = controlType;
            if (this.L != null) {
                controlType.c = this.L;
            }
            controlType.e = this.u;
            controlType.d = new p(this);
        }
    }

    public final void b(boolean z) {
        if (!z) {
            this.x = null;
        }
        if (this.w) {
            this.w.a(true);
            ViewUtil.removeViewFromParent(this.w);
            this.w = null;
        }
    }

    public final void b() {
        new StringBuilder("reset--").append(this);
        XmpMediaPlayer xmpMediaPlayer = this.f;
        xmpMediaPlayer.a.close();
        xmpMediaPlayer.b();
    }

    private void a(String str, String str2) {
        y yVar;
        StringBuilder stringBuilder = new StringBuilder("onPlayEnd--endType=");
        stringBuilder.append(str);
        stringBuilder.append("|errorCode=");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(this);
        this.M.a();
        o();
        if (this.i != null) {
            yVar = this.i.b;
            if (yVar != null && str == "0") {
                long j = yVar.r;
                if (j > 0 && j != LoginHelper.a().g.c()) {
                    VisitorNetworkHelper a = VisitorNetworkHelper.a();
                    String str3 = yVar.f;
                    String str4 = yVar.d;
                    a.a(j, Entrance.VIDEO_PLAY, str3, str4, str4, "");
                }
            }
            this.i.a(BufferingState.END);
        }
        if (this.i != null) {
            yVar = this.i.b;
            if (yVar != null && !f.a(yVar)) {
                StringBuilder stringBuilder2 = new StringBuilder("playReport--reportPlayEnd--endType=");
                stringBuilder2.append(str);
                stringBuilder2.append("|errorCode=");
                stringBuilder2.append(str2);
                stringBuilder2.append("|");
                stringBuilder2.append(this);
                o.a aVar = new o.a();
                aVar.g = yVar.k;
                aVar.h = this.o;
                aVar.i = yVar.d;
                aVar.j = String.valueOf(this.z);
                aVar.k = yVar.l;
                aVar.l = yVar.m;
                aVar.m = yVar.n;
                int position = this.f.a.getPosition();
                if (!"2".equals(str) || position > 0) {
                    aVar.a = str;
                } else {
                    aVar.a = "3";
                }
                aVar.b = position / 1000;
                aVar.c = str2;
                aVar.d = this.i.c;
                aVar.e = this.i.d;
                aVar.f = SystemClock.elapsedRealtime() - this.G;
                aVar.o = yVar.s;
                aVar.p = yVar.b();
                aVar.n = yVar.q;
                str = HubbleEventBuilder.build("android_play_shortvideo", "play_shortvideo_end");
                str.add("from", aVar.g);
                str.add("position", aVar.h);
                str.add("movieid", aVar.i);
                str.add("play_sessionid", aVar.j);
                str.add("s_ab", aVar.k);
                str.add("sversion", aVar.l);
                str.add("params", aVar.m);
                str.add("end_type", aVar.a);
                str.add("play_duration", aVar.b);
                str.add("errorcode", aVar.c);
                str.add("card_num", aVar.d);
                str.add("card_duration", aVar.e);
                str.add("load_time", aVar.f);
                str.add("is_replay", aVar.n);
                str.add("pre_load", aVar.o ? "pre_load" : "normal");
                str.add("url", Uri.encode(aVar.p));
                ThunderReport.reportEvent(str);
            }
        }
    }

    private void b(y yVar) {
        XmpMediaPlayer xmpMediaPlayer;
        new StringBuilder("doPlay--").append(this);
        c(yVar.g);
        this.G = SystemClock.elapsedRealtime();
        this.z = System.currentTimeMillis();
        if (!yVar.s) {
            xmpMediaPlayer = this.f;
            File externalCacheDir = this.d.getExternalCacheDir();
            if (externalCacheDir != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(externalCacheDir.toString());
                stringBuilder.append("/xmp/");
                String stringBuilder2 = stringBuilder.toString();
                xmpMediaPlayer.a(CONFIGID.HTTP_USER_AHTTP, "1");
                xmpMediaPlayer.a(CONFIGID.HTTP_AHTTP_CACHE_DIR, stringBuilder2);
            }
        }
        xmpMediaPlayer = this.f;
        yVar = yVar.b;
        xmpMediaPlayer.b();
        com.xunlei.downloadprovider.player.xmp.b.a.a();
        xmpMediaPlayer.a.open(yVar);
        xmpMediaPlayer.b(false);
        xmpMediaPlayer.d = yVar;
    }

    public final void a(y yVar) {
        if (yVar != null) {
            new StringBuilder("play--").append(this);
            if (!(this.f == null || TextUtils.isEmpty(yVar.b))) {
                if (!TextUtils.isEmpty(yVar.d)) {
                    boolean a;
                    this.i = new e(yVar);
                    this.l.c(yVar);
                    if (com.xunlei.xllib.android.b.d(this.d)) {
                        a = this.a.a(yVar.d, this.e, new r(this, yVar));
                    } else {
                        a = true;
                    }
                    if (a) {
                        this.l.b(yVar);
                        int state = this.f.a.getState();
                        if (state == 0) {
                            b(yVar);
                        } else if (state == 6) {
                            this.F = true;
                        } else {
                            this.F = true;
                            b();
                        }
                    }
                }
            }
        }
    }

    public final void c(boolean z) {
        if (H && z) {
            v();
        } else {
            w();
        }
    }

    private void v() {
        new StringBuilder("mute--").append(this);
        this.f.c(true);
        this.p = true;
        this.l.a(true);
    }

    private void w() {
        new StringBuilder("resetToSystemVolume--").append(this);
        this.f.c(false);
        this.p = false;
        this.l.a(false);
    }

    public final void d(boolean z) {
        H = z;
        if (z) {
            v();
        } else {
            w();
        }
    }

    public static boolean c() {
        return H;
    }

    public static void d() {
        H = false;
    }

    public final void e() {
        new StringBuilder("start--").append(this);
        this.E = false;
        XmpMediaPlayer xmpMediaPlayer = this.f;
        com.xunlei.downloadprovider.player.xmp.b.a.a();
        xmpMediaPlayer.a.stopRead(false);
        xmpMediaPlayer.a.play();
    }

    public final void a(int i) {
        this.f.a.setPosition(i);
    }

    public final void a(boolean z, boolean z2) {
        StringBuilder stringBuilder = new StringBuilder("pause(");
        stringBuilder.append(z);
        stringBuilder.append(")--");
        stringBuilder.append(this);
        if (!(m() && this.E)) {
            this.E = z;
        }
        this.f.a(z2);
        o();
    }

    public final void f() {
        new StringBuilder("rePlay--").append(this);
        if (com.xunlei.xllib.android.b.a(this.d)) {
            y n = n();
            if (n != null) {
                n.g = this.p;
                n.q = true;
                a(n);
                return;
            }
            return;
        }
        XLToast.showToast(this.d, "无网络连接");
    }

    public final int g() {
        return this.f.a.getState();
    }

    public final int h() {
        return this.f.a.getPosition();
    }

    public final boolean i() {
        return SystemClock.elapsedRealtime() - this.h.e < 1800;
    }

    private void x() {
        if (this.g != null && this.g.getParent() != null) {
            StringBuilder stringBuilder = new StringBuilder("removeSelfContainer--parent=");
            stringBuilder.append(this.g.getParent());
            stringBuilder.append("|");
            stringBuilder.append(this);
            ((ViewGroup) this.g.getParent()).removeView(this.g);
        }
    }

    public final boolean j() {
        return this.j >= this.k;
    }

    public final void a(b bVar) {
        this.h.d = bVar;
    }

    public final boolean k() {
        g gVar = this.h;
        if (gVar.a == null || !gVar.b) {
            return false;
        }
        gVar.c();
        return true;
    }

    public final void a(PlayerTag playerTag) {
        if (playerTag != null) {
            if (this.c != playerTag) {
                ak akVar = this.a;
                PlayerTag playerTag2 = this.c;
                StringBuilder stringBuilder = new StringBuilder("onPlayerTagChanged--oldTag=");
                stringBuilder.append(playerTag2);
                stringBuilder.append("|newTag=");
                stringBuilder.append(playerTag);
                stringBuilder.append("|player=");
                stringBuilder.append(this);
                if (akVar.b(this)) {
                    StringBuilder stringBuilder2 = new StringBuilder("addCachePlayer--tag=");
                    stringBuilder2.append(playerTag);
                    stringBuilder2.append("|xmpPlayer=");
                    stringBuilder2.append(this);
                    if (this != null) {
                        if (playerTag.getCacheSize() <= 0) {
                            q();
                        } else {
                            g gVar = (g) akVar.a.get(playerTag);
                            if (gVar == null) {
                                gVar = new g(playerTag.getCacheSize());
                                gVar.a = akVar.d;
                                akVar.a.put(playerTag, gVar);
                            }
                            gVar.put(Integer.valueOf(this.b), this);
                        }
                    }
                }
                if (akVar.a(this)) {
                    akVar.a(playerTag, this);
                }
                this.c = playerTag;
            }
        }
    }

    public final boolean l() {
        return g() == 4;
    }

    public final boolean m() {
        return g() == 3;
    }

    public final y n() {
        if (this.i == null) {
            return null;
        }
        return this.i.b;
    }

    public final void o() {
        if (this.i != null && this.i.b.h) {
            if (h() >= 3000) {
                y yVar = this.i.b;
                int h = h();
                int c = this.f.c();
                String str = yVar.d;
                String str2 = yVar.f;
                String str3 = yVar.c;
                String b = yVar.b();
                String str4 = yVar.o;
                VodPlayerParams vodPlayerParams = new VodPlayerParams();
                vodPlayerParams.mMovieId = str;
                vodPlayerParams.mGCID = str2;
                vodPlayerParams.mTitle = str3;
                vodPlayerParams.mUrl = b;
                vodPlayerParams.mCoverUrl = str4;
                vodPlayerParams.mCurPlayPos = h;
                vodPlayerParams.mDuration = c;
                v a = v.a();
                if (!TextUtils.isEmpty(vodPlayerParams.mMovieId)) {
                    XLThreadPool$ForDatabase.executeRead(new w(a, vodPlayerParams));
                }
                this.i.a = true;
            }
        }
    }

    public final void a(aj ajVar) {
        this.f.a(ajVar);
    }

    public final void b(aj ajVar) {
        this.f.c.remove(ajVar);
    }

    public final void c(aj ajVar) {
        if (this.J != null) {
            b(this.J);
        }
        this.J = ajVar;
        if (ajVar != null) {
            a(ajVar);
        }
    }

    public final String toString() {
        String str;
        String str2 = null;
        if (n() != null) {
            str2 = n().d;
            str = n().c;
        } else {
            str = null;
        }
        StringBuilder stringBuilder = new StringBuilder("|id=");
        stringBuilder.append(this.b);
        stringBuilder.append("|tag=");
        stringBuilder.append(this.c);
        stringBuilder.append("|state=");
        stringBuilder.append(g());
        stringBuilder.append("|movieId=");
        stringBuilder.append(str2);
        stringBuilder.append("|title=");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public final void p() {
        g gVar = this.h;
        gVar.a(false);
        gVar.l = true;
        a(null);
        this.m = null;
        this.s = null;
        this.t = null;
        a(null);
        b(false);
        this.x = null;
        c(null);
    }

    public final void q() {
        new StringBuilder("destroy--").append(this);
        if (this.f.e) {
            a("1", "");
        }
        if (this.h.b) {
            this.h.c();
        }
        a();
        p();
        ak a = ak.a();
        new StringBuilder("removePlayer--xmpPlayer=").append(this);
        if (this != null) {
            a.b.remove(this.b);
            a.b(this);
            a.a(this);
        }
        if (this.g != null) {
            this.g.removeOnLayoutChangeListener(this.P);
        }
        this.P = null;
        g gVar = this.h;
        if (gVar.a != null) {
            gVar.a.b(gVar.m);
            gVar.a = null;
        }
        if (gVar.f != null) {
            gVar.f.disable();
            gVar.f = null;
        }
        gVar.m = null;
        gVar.d = null;
        this.i = null;
        if (this.l != null) {
            PlayerControl playerControl = this.l;
            playerControl.d();
            playerControl.a = null;
            this.l = null;
        }
        this.I.clear();
        this.r = null;
        this.g = null;
        if (this.f != null) {
            XmpMediaPlayer xmpMediaPlayer = this.f;
            xmpMediaPlayer.a();
            xmpMediaPlayer.c.clear();
            if (xmpMediaPlayer.b != null) {
                m mVar = xmpMediaPlayer.b;
                mVar.s_();
                mVar.e();
                mVar.b = null;
                mVar.a = null;
                xmpMediaPlayer.b = null;
            }
            xmpMediaPlayer.b();
            APlayerAndroid aPlayerAndroid = xmpMediaPlayer.a;
            if (aPlayerAndroid != null) {
                aPlayerAndroid.setOnOpenSuccessListener(null);
                aPlayerAndroid.setOnPlayCompleteListener(null);
                aPlayerAndroid.setOnPlayStateChangeListener(null);
                aPlayerAndroid.setOnSeekCompleteListener(null);
                aPlayerAndroid.setOnBufferListener(null);
                aPlayerAndroid.setOnShowSubtitleListener(null);
                aPlayerAndroid.setOnReCreateHwDecoderListener(null);
                aPlayerAndroid.setOnFirstFrameRenderListener(null);
                aPlayerAndroid.destroy();
            }
        }
    }

    public final void r() {
        new StringBuilder("recycle--").append(this);
        q();
    }

    public final boolean s() {
        return this.r != null;
    }

    public final void a(PlayerContainer playerContainer) {
        this.I.put(ContainerType.FULL_SCREEN, playerContainer);
    }

    public final boolean t() {
        return this.f.b.c;
    }

    public final void a(c cVar) {
        this.L = cVar;
        if (this.l != null) {
            this.l.c = cVar;
        }
    }

    static /* synthetic */ void c(ThunderXmpPlayer thunderXmpPlayer) {
        View doubleClickAnimationView = new DoubleClickAnimationView(thunderXmpPlayer.d);
        thunderXmpPlayer.g.addView(doubleClickAnimationView);
        if (doubleClickAnimationView.c == null) {
            doubleClickAnimationView.c = true;
            ImageView imageView = doubleClickAnimationView.a;
            imageView.setImageResource(R.drawable.double_click_like);
            doubleClickAnimationView.b.setVisibility(8);
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
            animationDrawable.start();
            int i = 0;
            int i2 = i;
            while (i < animationDrawable.getNumberOfFrames()) {
                i2 += animationDrawable.getDuration(i);
                i++;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            Animator duration = ObjectAnimator.ofFloat(imageView, View.TRANSLATION_Y, new float[]{(float) DipPixelUtil.dip2px(13.0f)}).setDuration(150);
            Animator duration2 = ObjectAnimator.ofFloat(imageView, View.TRANSLATION_Y, new float[]{(float) (-DipPixelUtil.dip2px(40.0f))}).setDuration(200);
            thunderXmpPlayer = ObjectAnimator.ofFloat(doubleClickAnimationView, View.ALPHA, new float[]{null}).setDuration(200);
            animatorSet.setStartDelay((long) i2);
            animatorSet.addListener(new com.xunlei.downloadprovider.player.xmp.ui.widget.c(doubleClickAnimationView));
            animatorSet.play(duration2).with(thunderXmpPlayer).after(duration);
            animatorSet.start();
        }
    }

    static /* synthetic */ void a(ThunderXmpPlayer thunderXmpPlayer, int i, int i2, int i3, int i4) {
        if (i3 != 0) {
            if (i4 != 0) {
                LayoutParams layoutParams = thunderXmpPlayer.A.getLayoutParams();
                if (layoutParams != null) {
                    switch (x.b[thunderXmpPlayer.q.ordinal()]) {
                        case 1:
                            layoutParams.width = i;
                            layoutParams.height = (i * i4) / i3;
                            thunderXmpPlayer.A.setLayoutParams(layoutParams);
                            break;
                        case 2:
                            layoutParams.width = i;
                            layoutParams.height = i2;
                            thunderXmpPlayer.A.setLayoutParams(layoutParams);
                            break;
                        default:
                            float f = ((float) i3) / ((float) i4);
                            float f2 = ((float) i) / ((float) i2);
                            if (((double) Math.abs(f - f2)) >= 0.02d) {
                                if (f > f2) {
                                    i2 = (i4 * i) / i3;
                                } else {
                                    i = (i3 * i2) / i4;
                                }
                            }
                            layoutParams.width = i;
                            layoutParams.height = i2;
                            thunderXmpPlayer.A.setLayoutParams(layoutParams);
                            break;
                    }
                    thunderXmpPlayer = new StringBuilder("adjustScreen--width=");
                    thunderXmpPlayer.append(layoutParams.width);
                    thunderXmpPlayer.append("|height=");
                    thunderXmpPlayer.append(layoutParams.height);
                }
            }
        }
    }

    static /* synthetic */ void o(ThunderXmpPlayer thunderXmpPlayer) {
        if (thunderXmpPlayer.i != null) {
            y yVar = thunderXmpPlayer.i.b;
            if (yVar != null && !f.a(yVar)) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - thunderXmpPlayer.G;
                StringBuilder stringBuilder = new StringBuilder("playReport--reportPlayAllStart--loadTime=");
                stringBuilder.append(elapsedRealtime);
                stringBuilder.append("|");
                stringBuilder.append(thunderXmpPlayer);
                o.c cVar = new o.c();
                cVar.g = yVar.k;
                cVar.h = thunderXmpPlayer.o;
                cVar.i = yVar.d;
                cVar.j = String.valueOf(thunderXmpPlayer.z);
                cVar.k = yVar.l;
                cVar.l = yVar.m;
                cVar.m = yVar.n;
                cVar.a = elapsedRealtime;
                cVar.n = yVar.q;
                cVar.o = yVar.s;
                cVar.p = yVar.b();
                StatEvent build = HubbleEventBuilder.build("android_play_shortvideo", "play_shortvideo_start");
                build.add("from", cVar.g);
                build.add("position", cVar.h);
                build.add("movieid", cVar.i);
                build.add("play_sessionid", cVar.j);
                build.add("load_time", cVar.a);
                build.add("s_ab", cVar.k);
                build.add("sversion", cVar.l);
                build.add("params", cVar.m);
                build.add("is_replay", cVar.n);
                build.add("pre_load", cVar.o ? "pre_load" : "normal");
                build.add("url", Uri.encode(cVar.p));
                ThunderReport.reportEvent(build);
                com.xunlei.downloadprovider.homepage.recommend.a.a a = com.xunlei.downloadprovider.homepage.recommend.a.a.a();
                String str = yVar.d;
                String str2 = yVar.f;
                String peerid = AndroidConfig.getPeerid();
                int c = thunderXmpPlayer.f.c();
                String str3 = "start";
                String str4 = yVar.j;
                if (com.xunlei.xllib.android.b.a(a.a) != null) {
                    XLThreadPool.execute(new i(a.b, c, str3, str, str2, peerid, str4));
                }
            }
        }
    }
}
