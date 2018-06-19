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

public class PlayerOperationViewAuto extends FrameLayout {
    PlayerPosterView a;
    TextView b;
    MediaPlayerLoadingView c;
    private ImageView d;
    private ThunderXmpPlayer e;
    private aj f = new ak(this);

    public PlayerOperationViewAuto(Context context) {
        super(context);
        a(context);
    }

    public PlayerOperationViewAuto(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayerOperationViewAuto(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.player_operation_view_auto, this, true);
        this.d = (ImageView) context.findViewById(R.id.iv_voice_animation);
        this.c = (MediaPlayerLoadingView) context.findViewById(R.id.loading_progress);
        this.a = (PlayerPosterView) context.findViewById(R.id.player_poster);
        this.b = (TextView) context.findViewById(R.id.count_down);
    }

    public void setMediaPlayer(ThunderXmpPlayer thunderXmpPlayer) {
        this.e = thunderXmpPlayer;
    }

    public aj getXmpPlayerListener() {
        return this.f;
    }

    static /* synthetic */ void f(PlayerOperationViewAuto playerOperationViewAuto) {
        playerOperationViewAuto.d.setVisibility(0);
        ((AnimationDrawable) playerOperationViewAuto.d.getDrawable()).start();
    }

    static /* synthetic */ void g(PlayerOperationViewAuto playerOperationViewAuto) {
        playerOperationViewAuto.d.setVisibility(4);
        ((AnimationDrawable) playerOperationViewAuto.d.getDrawable()).stop();
    }
}
