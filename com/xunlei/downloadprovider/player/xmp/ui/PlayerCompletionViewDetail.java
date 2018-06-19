package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.downloadprovider.player.xmp.d;

public class PlayerCompletionViewDetail extends FrameLayout {
    private ThunderXmpPlayer a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private d e;
    private View f;
    private View g;
    private View h;
    private View i;
    private TextView j;
    private boolean k = false;
    private a l = null;
    private aj m = new l(this);

    public interface a {
        void a(boolean z);
    }

    public PlayerCompletionViewDetail(Context context) {
        super(context);
        a(context);
    }

    public PlayerCompletionViewDetail(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayerCompletionViewDetail(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void setMediaPlayer(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrevPlayBtnVisiable(boolean z) {
        this.c.setVisibility(8);
    }

    public void setNextPlayBtnVisiable(boolean z) {
        this.d.setVisibility(8);
    }

    public void setOnControllerClickListener(d dVar) {
        this.e = dVar;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.k != (i == 0)) {
            this.k ^= 1;
            if (this.l != 0) {
                this.l.a(this.k);
            }
        }
    }

    public aj getXmpPlayerListener() {
        return this.m;
    }

    public void setOnPlayerCompletionVisibleChangedListener(a aVar) {
        this.l = aVar;
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.media_player_completion_view, this, true);
        this.b = (ImageView) context.findViewById(R.id.replay);
        this.c = (ImageView) context.findViewById(R.id.prev_play_btn);
        this.d = (ImageView) context.findViewById(R.id.next_play_btn);
        this.f = context.findViewById(R.id.ll_we_chat_share);
        this.g = context.findViewById(R.id.ll_we_circle_share);
        this.h = context.findViewById(R.id.ll_qq_share);
        this.i = context.findViewById(R.id.ll_qzone_share);
        this.j = (TextView) context.findViewById(R.id.tv_replay_btn);
        setVisibility(8);
        this.b.setOnClickListener(new d(this));
        this.c.setOnClickListener(new e(this));
        this.d.setOnClickListener(new f(this));
        this.j.setOnClickListener(new g(this));
        this.f.setOnClickListener(new h(this));
        this.g.setOnClickListener(new i(this));
        this.h.setOnClickListener(new j(this));
        this.i.setOnClickListener(new k(this));
    }
}
