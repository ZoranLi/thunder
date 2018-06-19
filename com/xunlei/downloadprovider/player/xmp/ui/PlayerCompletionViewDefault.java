package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;

public class PlayerCompletionViewDefault extends FrameLayout {
    private ThunderXmpPlayer a;
    private ImageView b;
    private TextView c;
    private OnClickListener d;
    private aj e = new c(this);

    public PlayerCompletionViewDefault(Context context) {
        super(context);
        a(context);
    }

    public PlayerCompletionViewDefault(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayerCompletionViewDefault(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.media_player_completion_view, this, true);
        this.b = (ImageView) context.findViewById(R.id.replay);
        this.b.setOnClickListener(new b(this));
        this.c = (TextView) context.findViewById(R.id.tv_replay);
        setVisibility(8);
    }

    public void setMediaPlayer(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setReplayClickListener(OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public aj getXmpPlayerListener() {
        return this.e;
    }
}
