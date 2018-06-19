package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.downloadprovider.player.xmp.b.a;
import com.xunlei.downloadprovider.player.xmp.y;

/* compiled from: PlayerControlDetail */
public final class u extends PlayerControl {
    public PlayerOperationViewDetail f;
    public PlayerCompletionViewDetail g;
    View h;
    private ThunderXmpPlayer i;
    private PlayerGestureViewDefault j;
    private boolean k = true;
    private aj l = new w(this);

    public u(Context context) {
        super(context);
    }

    public final View a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.player_detail_control_layout, null);
        this.f = (PlayerOperationViewDetail) context.findViewById(R.id.operation_view);
        this.g = (PlayerCompletionViewDetail) context.findViewById(R.id.completion_view);
        this.j = (PlayerGestureViewDefault) context.findViewById(R.id.gesture_view);
        return context;
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
        super.a(thunderXmpPlayer);
        this.i = thunderXmpPlayer;
        this.i.a(this.l);
        this.f.setMediaPlayer(this.i);
        this.i.a(this.f.getXmpPlayerListener());
        this.g.setMediaPlayer(this.i);
        if (this.k != null) {
            this.i.a(this.g.getXmpPlayerListener());
        }
        this.j.setMediaPlayer(this.i);
        this.i.a(this.j.getXmpPlayerListener());
        this.j.setOnGestureListener(new v(this));
    }

    public final void c(boolean z) {
        this.f.setPrevPlayBtnVisible(z);
        this.g.setPrevPlayBtnVisiable(z);
    }

    public final void d(boolean z) {
        this.f.setNextPlayBtnVisiable(z);
        this.g.setNextPlayBtnVisiable(z);
    }

    public final void b(int i) {
        this.f.setGrayBgVisibility(i);
    }

    public final void b(boolean z) {
        super.b(z);
        if (z) {
            this.j.setShouldDetectorGestureMove(true);
            z = this.f;
            z.d.setVisibility(0);
            z.c.setVisibility(0);
            z.f.setImageResource(R.drawable.ic_suitscreen_selector);
            if (!this.i.j() && a.b()) {
                this.f.setTitleBarTopMargin(80);
            }
            return;
        }
        this.j.a();
        this.j.setShouldDetectorGestureMove(false);
        z = this.f;
        z.d.setVisibility(8);
        z.c.setVisibility(8);
        z.f.setImageResource(R.drawable.ic_fullscreen_selector);
    }

    public final void c(y yVar) {
        super.c(yVar);
        PlayerOperationViewDetail playerOperationViewDetail = this.f;
        playerOperationViewDetail.setVideoInfo(yVar);
        playerOperationViewDetail.a(0);
        playerOperationViewDetail.a(0, false);
        if (playerOperationViewDetail.h != null) {
            playerOperationViewDetail.h.setScaleType(yVar.p);
            Drawable a = yVar.a();
            if (a == null) {
                yVar = yVar.o;
                if (playerOperationViewDetail.h != null) {
                    if (TextUtils.isEmpty(yVar)) {
                        playerOperationViewDetail.h.setVisibility(8);
                        return;
                    } else {
                        playerOperationViewDetail.h.setVisibility(0);
                        b.a().a(yVar, playerOperationViewDetail.h, null);
                    }
                }
                return;
            }
            playerOperationViewDetail.h.setImageDrawable(a);
        }
    }

    public final void e() {
        super.e();
        PlayerOperationViewDetail playerOperationViewDetail = this.f;
        if (playerOperationViewDetail.a.t()) {
            int c = playerOperationViewDetail.a.f.c();
            playerOperationViewDetail.g.setSecondaryProgress(c);
            playerOperationViewDetail.e.setSecondaryProgress(c);
        }
    }

    public final void a(y yVar) {
        super.a(yVar);
        this.f.setVideoInfo(yVar);
    }

    public final void e(boolean z) {
        this.k = z;
        if (z) {
            this.g.setVisibility(0);
            this.i.a(this.g.getXmpPlayerListener());
            return;
        }
        this.g.setVisibility(8);
        this.i.b(this.g.getXmpPlayerListener());
    }

    public final void d() {
        ThunderXmpPlayer thunderXmpPlayer = this.a;
        if (thunderXmpPlayer != null) {
            thunderXmpPlayer.b(this.l);
            thunderXmpPlayer.b(this.f.getXmpPlayerListener());
            this.f.setMediaPlayer(null);
            thunderXmpPlayer.b(this.g.getXmpPlayerListener());
            this.g.setMediaPlayer(null);
            thunderXmpPlayer.b(this.j.getXmpPlayerListener());
            this.j.setMediaPlayer(null);
            super.d();
        }
    }
}
