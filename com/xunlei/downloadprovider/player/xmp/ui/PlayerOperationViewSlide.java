package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;

public class PlayerOperationViewSlide extends FrameLayout {
    PlayerPosterView a;
    TextView b;
    MediaPlayerLoadingView c;
    private ImageView d;
    private ThunderXmpPlayer e;
    private aj f = new bf(this);

    public PlayerOperationViewSlide(Context context) {
        super(context);
        a(context);
    }

    public PlayerOperationViewSlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayerOperationViewSlide(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.player_operation_view_auto, this, true);
        this.d = (ImageView) context.findViewById(R.id.iv_voice_animation);
        this.c = (MediaPlayerLoadingView) context.findViewById(R.id.loading_progress);
        this.a = (PlayerPosterView) context.findViewById(R.id.player_poster);
        this.b = (TextView) context.findViewById(R.id.count_down);
        this.b.setVisibility(8);
    }

    public void setMediaPlayer(ThunderXmpPlayer thunderXmpPlayer) {
        this.e = thunderXmpPlayer;
    }

    public aj getXmpPlayerListener() {
        return this.f;
    }

    static /* synthetic */ void f(PlayerOperationViewSlide playerOperationViewSlide) {
        playerOperationViewSlide.d.setVisibility(4);
        ((AnimationDrawable) playerOperationViewSlide.d.getDrawable()).stop();
    }
}
