package com.xunlei.downloadprovider.download.player.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.animation.AnimationUtils;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.player.PlayProgressRanges;
import com.xunlei.downloadprovider.download.player.b;
import com.xunlei.downloadprovider.download.player.views.backgroundlayer.PlayerBackgroundLayerViewGroup;
import com.xunlei.downloadprovider.download.player.views.backgroundlayer.PlayerGestureView.a;
import com.xunlei.downloadprovider.download.player.views.bottom.PlayerBottomViewGroup;
import com.xunlei.downloadprovider.download.player.views.center.PlayerCenterViewGroup;
import com.xunlei.downloadprovider.download.player.views.left.PlayerLeftViewGroup;
import com.xunlei.downloadprovider.download.player.views.right.PlayerRightViewGroup;
import com.xunlei.downloadprovider.download.player.views.top.PlayerTopViewGroup;
import com.xunlei.downloadprovider.h.c;
import java.util.HashMap;
import java.util.Map;

public class DownloadVodPlayerView extends PlayerViewGroupBase {
    private static final String h = "DownloadVodPlayerView";
    public c a = new c();
    public PlayerCenterViewGroup b;
    public PlayerBackgroundLayerViewGroup c;
    public PlayerLeftViewGroup d;
    public boolean e;
    private int i = null;
    private SurfaceView j;
    private Map<Class, PlayerViewGroupBase> k = new HashMap();
    private PlayerTopViewGroup l;
    private PlayerBottomViewGroup m;
    private PlayerRightViewGroup n;
    private b o;
    private Runnable p = new a(this);
    private BroadcastReceiver q = new b(this);

    public DownloadVodPlayerView(Context context) {
        super(context);
    }

    public DownloadVodPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DownloadVodPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getViewState() {
        return this.i;
    }

    public void setViewState(int i) {
        this.i = i;
        if (!q()) {
            switch (i) {
                case 0:
                    this.c.a();
                    n();
                    b();
                    return;
                case 1:
                    if (l() == 0) {
                        this.b.a();
                        b();
                        m();
                    }
                    setPlayPauseButtonType(1);
                    return;
                case 2:
                    if (this.a.e != 0) {
                        this.c.a();
                    } else {
                        o();
                    }
                    this.m.setProgressBarEnabled(true);
                    setPlayPauseButtonType(1);
                    this.b.a();
                    n();
                    b();
                    return;
                case 3:
                    setPlayPauseButtonType(0);
                    a();
                    n();
                    b();
                    return;
                case 4:
                    setPlayPauseButtonType(0);
                    this.b.a();
                    n();
                    this.c.a();
                    k();
                    i = this.b;
                    i.b.a(0);
                    i.b.a(true);
                    break;
                default:
                    break;
            }
        }
    }

    private boolean q() {
        return this.c.b.getVisibility() == 0;
    }

    public final void a() {
        PlayerCenterViewGroup playerCenterViewGroup = this.b;
        playerCenterViewGroup.a();
        if (playerCenterViewGroup.i) {
            if (playerCenterViewGroup.d != null) {
                playerCenterViewGroup.d.setVisibility(0);
            }
            playerCenterViewGroup.h.setVisibility(0);
            return;
        }
        playerCenterViewGroup.e.setVisibility(0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.j = (SurfaceView) findViewById(R.id.player_render_view);
        this.l = (PlayerTopViewGroup) findViewById(R.id.player_top_view_layout);
        this.m = (PlayerBottomViewGroup) findViewById(R.id.player_bottom_view_layout);
        this.b = (PlayerCenterViewGroup) findViewById(R.id.center_view_layout);
        this.c = (PlayerBackgroundLayerViewGroup) findViewById(R.id.fullscreen_background_layer_layout);
        this.d = (PlayerLeftViewGroup) findViewById(R.id.player_left_view_layout);
        this.n = (PlayerRightViewGroup) findViewById(R.id.player_right_view_layout);
        this.k.put(PlayerTopViewGroup.class, this.l);
        this.k.put(PlayerBottomViewGroup.class, this.m);
        this.k.put(PlayerCenterViewGroup.class, this.b);
        this.k.put(PlayerBackgroundLayerViewGroup.class, this.c);
        this.k.put(PlayerLeftViewGroup.class, this.d);
        this.k.put(PlayerRightViewGroup.class, this.n);
        for (PlayerViewGroupBase a : this.k.values()) {
            a.a(this);
        }
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        c.a(applicationInstance, "ACTION_PLAYERVIEW_PROGRESS_BAR_StartTrackingTouch", this.q);
        c.a(applicationInstance, "ACTION_PLAYERVIEW_PROGRESS_BAR_StopTrackingTouch", this.q);
    }

    public SurfaceView getSurfaceView() {
        return this.j;
    }

    public PlayerTopViewGroup getPlayerTopViewGroup() {
        return this.l;
    }

    public PlayerBottomViewGroup getPlayerBottomViewGroup() {
        return this.m;
    }

    public PlayerCenterViewGroup getPlayerCenterViewGroup() {
        return this.b;
    }

    public PlayerBackgroundLayerViewGroup getPlayerBackgroundLayerViewGroup() {
        return this.c;
    }

    public PlayerLeftViewGroup getPlayerLeftViewGroup() {
        return this.d;
    }

    public PlayerRightViewGroup getPlayerRightViewGroup() {
        return this.n;
    }

    public void setPlayerController(b bVar) {
        super.setPlayerController(bVar);
        for (PlayerViewGroupBase playerController : this.k.values()) {
            playerController.setPlayerController(bVar);
        }
    }

    public void setViewEventListener(d dVar) {
        super.setViewEventListener(dVar);
        for (PlayerViewGroupBase viewEventListener : this.k.values()) {
            viewEventListener.setViewEventListener(dVar);
        }
    }

    public void setOnGestureListener(a aVar) {
        this.b.setOnGestureListener(aVar);
    }

    public final void a(boolean z) {
        super.a(z);
        for (PlayerViewGroupBase a : this.k.values()) {
            a.a(z);
        }
    }

    public void setTitle(String str) {
        this.l.setTitle(str);
    }

    public void setTitleVisible(boolean z) {
        this.l.setTitleVisible(z);
    }

    public final void b() {
        PlayerCenterViewGroup playerCenterViewGroup = this.b;
        playerCenterViewGroup.b.a(8);
        playerCenterViewGroup.b.a(false);
    }

    public void setErrorText(String str) {
        this.b.setErrorText(str);
    }

    public final void a(int i, int i2, int i3) {
        this.a.a = i;
        this.a.b = i2;
        this.a.c = i3;
        if (this.m != null) {
            this.m.a(i, i2, i3);
        }
    }

    public void setCacheProgress(PlayProgressRanges playProgressRanges) {
        this.a.d = playProgressRanges;
        if (this.m != null) {
            this.m.setCacheProgress(this.a.d);
        }
    }

    private void setPlayPauseButtonType(int i) {
        if (this.m != null) {
            this.m.setPlayPauseButtonType(i);
        }
    }

    public void setOnUiChangeListener(b bVar) {
        this.o = bVar;
    }

    public void setADFinish(boolean z) {
        this.e = z;
    }

    public final void c() {
        PlayerBottomViewGroup playerBottomViewGroup = this.m;
        if (!(playerBottomViewGroup.a.getVisibility() == 0 || playerBottomViewGroup.getContext() == null)) {
            playerBottomViewGroup.a.startAnimation(AnimationUtils.loadAnimation(playerBottomViewGroup.getContext(), R.anim.vod_control_bar_bottom_in));
            playerBottomViewGroup.a.setVisibility(0);
        }
        PlayerTopViewGroup playerTopViewGroup = this.l;
        if (!(playerTopViewGroup.a.getVisibility() == 0 || playerTopViewGroup.getContext() == null)) {
            playerTopViewGroup.a.startAnimation(AnimationUtils.loadAnimation(playerTopViewGroup.getContext(), R.anim.vod_control_bar_top_in));
            playerTopViewGroup.a.setVisibility(0);
        }
        if (this.i == 3) {
            a();
        }
        if (this.o != null) {
            this.o.a(true);
        }
    }

    public final void d() {
        PlayerBottomViewGroup playerBottomViewGroup = this.m;
        if (playerBottomViewGroup.a.getVisibility() == 0 && playerBottomViewGroup.getContext() != null) {
            playerBottomViewGroup.a.startAnimation(AnimationUtils.loadAnimation(playerBottomViewGroup.getContext(), R.anim.vod_control_bar_bottom_out));
            playerBottomViewGroup.a.setVisibility(8);
        }
        PlayerTopViewGroup playerTopViewGroup = this.l;
        if (playerTopViewGroup.a.getVisibility() == 0 && playerTopViewGroup.getContext() != null) {
            playerTopViewGroup.a.startAnimation(AnimationUtils.loadAnimation(playerTopViewGroup.getContext(), R.anim.vod_control_bar_top_out));
            playerTopViewGroup.a.setVisibility(8);
        }
        this.b.a();
        removeCallbacks(this.p);
        if (this.o != null) {
            this.o.a(false);
        }
    }

    public final void e() {
        d();
        this.d.a();
        this.n.b();
    }

    public final void f() {
        if (!(q() || h())) {
            if (!i()) {
                c();
                if (this.g) {
                    this.d.b();
                    this.n.a();
                }
            }
        }
    }

    public final boolean g() {
        return this.m.a.getVisibility() == 0;
    }

    public final boolean h() {
        return getPlayerController() != null ? getPlayerController().m_() : false;
    }

    public final boolean i() {
        return getPlayerLeftViewGroup() != null ? getPlayerLeftViewGroup().a : false;
    }

    public final void j() {
        removeCallbacks(this.p);
        postDelayed(this.p, 5000);
    }

    public final void k() {
        removeCallbacks(this.p);
    }

    public void setPlayAudioOnly(boolean z) {
        this.a.e = z;
        if (z) {
            this.c.a.setImageResource(R.drawable.downloadvod_player_music_bg);
            this.c.a();
        } else {
            this.c.a.setImageResource(R.drawable.downloadvod_player_default_bg);
        }
        this.m.setFullScreenButtonEnabled(z ^ 1);
    }

    public final boolean l() {
        return this.b.c.a.getVisibility() == 0;
    }

    public final void m() {
        this.b.c.a(0);
    }

    public final void n() {
        PlayerCenterViewGroup playerCenterViewGroup = this.b;
        playerCenterViewGroup.c.a(8);
        playerCenterViewGroup.c.b.setText(R.string.vod_player_default_loading_text);
    }

    public final void o() {
        if (this.c != null) {
            this.c.a.setVisibility(8);
        }
    }

    public void setLoadingText(CharSequence charSequence) {
        this.b.setLoadingText(charSequence);
    }
}
