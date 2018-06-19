package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.downloadprovider.player.xmp.y;

public abstract class PlayerControl extends aj {
    public ThunderXmpPlayer a;
    View b;
    public c c;
    public a d;
    public b e;
    private Context f;
    private y g;

    public enum ControlType {
        DEFAULT,
        AUTO_PLAY,
        VIDEO_DETAIL,
        SPLASH_AD,
        SLIDE_CARD_PLAY
    }

    public interface a {
        boolean a();
    }

    public interface b {
        void a();
    }

    public interface c {
        boolean onClick();
    }

    public abstract View a(Context context);

    public void a(boolean z) {
    }

    public void b(y yVar) {
    }

    public void b(boolean z) {
    }

    public void c(y yVar) {
    }

    public void e() {
    }

    PlayerControl(Context context) {
        this.f = context;
        this.b = a(context);
    }

    public void a(y yVar) {
        this.g = yVar;
    }

    public void a(ThunderXmpPlayer thunderXmpPlayer) {
        new StringBuilder("bindPlayer--player=").append(thunderXmpPlayer);
        this.a = thunderXmpPlayer;
        View view = this.b;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        thunderXmpPlayer.g.addView(view, layoutParams);
        thunderXmpPlayer.a((aj) this);
        this.b = view;
    }

    public void d() {
        new StringBuilder("unbindPlayer--player=").append(this.a);
        if (this.a != null) {
            this.a.g.removeView(this.b);
            this.a.b((aj) this);
        }
    }
}
