package com.xunlei.downloadprovider.player.xmp.ui.item;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer.VideoViewType;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.ControlType;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.b;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a;

public abstract class BasePlayerView extends FrameLayout implements e {
    private ThunderXmpPlayer a;

    public static void l() {
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public int getListPosition() {
        return -1;
    }

    public PlayerContainer getPlayerFullScreenContainer() {
        return null;
    }

    public String getPlayerPage() {
        return "";
    }

    public void k() {
    }

    public BasePlayerView(Context context) {
        super(context);
    }

    public BasePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BasePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
    }

    public void b(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = null;
    }

    protected final void a(a aVar) {
        ThunderXmpPlayer player = getPlayer();
        ThunderXmpPlayer b = ak.a().b(getPlayerTag());
        if (!(b == null || b == player)) {
            b.r();
        }
        int i = -1;
        if (player != null) {
            i = player.b;
        }
        aVar.p = i;
        ShortMovieDetailActivity.a(getContext(), aVar);
    }

    public void c(ThunderXmpPlayer thunderXmpPlayer) {
        thunderXmpPlayer.o = getPlayerPage();
        thunderXmpPlayer.n = getListPosition();
        thunderXmpPlayer.a(getPlayerTag());
        thunderXmpPlayer.q = getVideoViewType();
        thunderXmpPlayer.a(getPlayerControllerType());
        thunderXmpPlayer.a(getPlayerFullScreenContainer());
        thunderXmpPlayer.s = new a(this, thunderXmpPlayer);
        thunderXmpPlayer.t = new b(this);
        thunderXmpPlayer.a(new c(this));
        b dVar = new d(this);
        thunderXmpPlayer.u = dVar;
        if (thunderXmpPlayer.l != null) {
            thunderXmpPlayer.l.e = dVar;
        }
    }

    public VideoViewType getVideoViewType() {
        return VideoViewType.ZOOM_AND_TAILOR;
    }

    public ControlType getPlayerControllerType() {
        return ControlType.DEFAULT;
    }

    public ThunderXmpPlayer getPlayer() {
        return this.a;
    }

    public static void e(ThunderXmpPlayer thunderXmpPlayer) {
        thunderXmpPlayer.q();
    }

    protected final ThunderXmpPlayer j() {
        ak a = ak.a();
        ThunderXmpPlayer a2 = a.a(getPlayerTag(), null);
        if (a2 == null) {
            a2 = a.a(getPlayerTag(), getPlayerControllerType());
        }
        c(a2);
        a2.a((BaseActivity) getContext(), (PlayerContainer) this);
        return a2;
    }
}
