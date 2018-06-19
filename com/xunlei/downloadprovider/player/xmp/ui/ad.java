package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.downloadprovider.player.xmp.y;

/* compiled from: PlayerControlSplashAd */
public final class ad extends PlayerControl {
    PlayerPosterView f;
    private aj g = new ae(this);

    public ad(Context context) {
        super(context);
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
        super.a(thunderXmpPlayer);
        thunderXmpPlayer.a(this.g);
    }

    public final void b(y yVar) {
        super.b(yVar);
    }

    public final void c(y yVar) {
        super.c(yVar);
        ImageView imageView = this.f;
        imageView.setScaleType(yVar.p);
        Drawable a = yVar.a();
        if (a != null) {
            imageView.setImageDrawable(a);
        } else if (TextUtils.isEmpty(yVar.o)) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            b.a().a(yVar.o, imageView, null);
        }
    }

    public final View a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.player_splash_ad_control_layout, null);
        this.f = (PlayerPosterView) context.findViewById(R.id.player_poster);
        return context;
    }

    public final void d() {
        ThunderXmpPlayer thunderXmpPlayer = this.a;
        if (thunderXmpPlayer != null) {
            thunderXmpPlayer.b(this.g);
            super.d();
        }
    }
}
