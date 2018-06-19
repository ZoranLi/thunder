package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.downloadprovider.player.xmp.y;

/* compiled from: PlayerControlDefault */
public final class q extends PlayerControl {
    public PlayerOperationViewDefault f;
    View g;
    private PlayerCompletionViewDefault h;
    private PlayerGestureViewDefault i;
    private aj j = new s(this);

    public q(Context context) {
        super(context);
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
        super.a(thunderXmpPlayer);
        thunderXmpPlayer.a(this.j);
        this.f.setMediaPlayer(thunderXmpPlayer);
        thunderXmpPlayer.a(this.f.getXmpPlayerListener());
        this.h.setMediaPlayer(thunderXmpPlayer);
        thunderXmpPlayer.a(this.h.getXmpPlayerListener());
        this.i.setMediaPlayer(thunderXmpPlayer);
        thunderXmpPlayer.a(this.i.getXmpPlayerListener());
        this.i.setOnGestureListener(new r(this));
    }

    public final void b(boolean z) {
        super.b(z);
        if (z) {
            this.i.setShouldDetectorGestureMove(true);
            z = this.f;
            z.e.setVisibility(0);
            z.d.setVisibility(0);
            z.h.setImageResource(R.drawable.ic_suitscreen_selector);
            return;
        }
        this.i.a();
        this.i.setShouldDetectorGestureMove(false);
        z = this.f;
        z.d();
        z.d.setVisibility(8);
        z.h.setImageResource(R.drawable.ic_fullscreen_selector);
    }

    public final void b(y yVar) {
        super.b(yVar);
        PlayerOperationViewDefault.e();
    }

    public final void c(y yVar) {
        super.c(yVar);
        PlayerOperationViewDefault playerOperationViewDefault = this.f;
        playerOperationViewDefault.e.setText(yVar.c);
        playerOperationViewDefault.k.setScaleType(yVar.p);
        Drawable a = yVar.a();
        if (a == null) {
            yVar = yVar.o;
            if (TextUtils.isEmpty(yVar)) {
                playerOperationViewDefault.k.setVisibility(8);
            } else {
                playerOperationViewDefault.k.setImageDrawable(null);
                b.a().a(yVar, playerOperationViewDefault.k, null);
            }
        } else {
            playerOperationViewDefault.k.setImageDrawable(a);
        }
        playerOperationViewDefault.k.setVisibility(0);
    }

    public final void e() {
        super.e();
        PlayerOperationViewDefault playerOperationViewDefault = this.f;
        if (playerOperationViewDefault.a.t()) {
            int c = playerOperationViewDefault.a.f.c();
            playerOperationViewDefault.m.setSecondaryProgress(c);
            playerOperationViewDefault.g.setSecondaryProgress(c);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        PlayerOperationViewDefault playerOperationViewDefault = this.f;
        int streamVolume = ((AudioManager) playerOperationViewDefault.getContext().getSystemService("audio")).getStreamVolume(3);
        if (!z) {
            if (streamVolume != 0) {
                playerOperationViewDefault.j.setImageResource(R.drawable.media_player_auto_play_voice);
                return;
            }
        }
        playerOperationViewDefault.j.setImageResource(R.drawable.media_player_auto_play_mute);
    }

    public final void d() {
        ThunderXmpPlayer thunderXmpPlayer = this.a;
        if (thunderXmpPlayer != null) {
            thunderXmpPlayer.b(this.j);
            thunderXmpPlayer.b(this.f.getXmpPlayerListener());
            this.f.setMediaPlayer(null);
            thunderXmpPlayer.b(this.h.getXmpPlayerListener());
            this.h.setMediaPlayer(null);
            thunderXmpPlayer.b(this.i.getXmpPlayerListener());
            this.i.setMediaPlayer(null);
            super.d();
        }
    }

    public final View a(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.player_default_control_layout, null);
        this.f = (PlayerOperationViewDefault) viewGroup.findViewById(R.id.operation_view);
        this.h = (PlayerCompletionViewDefault) viewGroup.findViewById(R.id.completion_view);
        this.i = (PlayerGestureViewDefault) viewGroup.findViewById(R.id.gesture_view);
        return viewGroup;
    }
}
