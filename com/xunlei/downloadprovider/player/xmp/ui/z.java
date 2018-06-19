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
import com.xunlei.downloadprovider.player.xmp.y;
import com.xunlei.xllib.b.j;

/* compiled from: PlayerControlSlide */
public final class z extends PlayerControl {
    View f;
    private PlayerOperationViewSlide g;
    private PlayerGestureViewDefault h;
    private aj i = new ab(this);

    public z(Context context) {
        super(context);
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
        super.a(thunderXmpPlayer);
        this.g.setMediaPlayer(thunderXmpPlayer);
        thunderXmpPlayer.a(this.g.getXmpPlayerListener());
        thunderXmpPlayer.a(this.i);
        this.h.setMediaPlayer(thunderXmpPlayer);
        thunderXmpPlayer.a(this.h.getXmpPlayerListener());
        this.h.setOnGestureListener(new aa(this));
    }

    public final void b(y yVar) {
        super.b(yVar);
        this.g.c.a();
    }

    public final void c(y yVar) {
        super.c(yVar);
        PlayerOperationViewSlide playerOperationViewSlide = this.g;
        playerOperationViewSlide.b.setText(j.a((long) (yVar.e * 1000)));
        playerOperationViewSlide.a.setScaleType(yVar.p);
        Drawable a = yVar.a();
        if (a == null) {
            Object obj = yVar.o;
            if (TextUtils.isEmpty(obj)) {
                playerOperationViewSlide.a.setVisibility(8);
            } else {
                playerOperationViewSlide.a.setImageDrawable(null);
                b.a().a(obj, playerOperationViewSlide.a, null);
            }
        } else {
            playerOperationViewSlide.a.setImageDrawable(a);
        }
        if (yVar.q != null) {
            playerOperationViewSlide.a.setVisibility(8);
        } else {
            playerOperationViewSlide.a.setVisibility(0);
        }
    }

    public final View a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.player_slide_control_layout, null);
        this.g = (PlayerOperationViewSlide) context.findViewById(R.id.operation_view);
        this.h = (PlayerGestureViewDefault) context.findViewById(R.id.gesture_view);
        return context;
    }

    public final void d() {
        ThunderXmpPlayer thunderXmpPlayer = this.a;
        if (thunderXmpPlayer != null) {
            thunderXmpPlayer.b(this.g.getXmpPlayerListener());
            this.g.setMediaPlayer(null);
            thunderXmpPlayer.b(this.i);
            super.d();
        }
    }
}
