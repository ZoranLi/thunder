package com.xunlei.downloadprovider.download.player.views.backgroundlayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.player.views.PlayerViewGroupBase;

public class PlayerBackgroundLayerViewGroup extends PlayerViewGroupBase {
    public ImageView a;
    public ImageView b;
    public TextView c;
    public ImageView d;

    public PlayerBackgroundLayerViewGroup(Context context) {
        super(context);
    }

    public PlayerBackgroundLayerViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerBackgroundLayerViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PlayerBackgroundLayerViewGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (ImageView) findViewById(R.id.player_poster_image);
        this.b = (ImageView) findViewById(R.id.player_float_tip_icon);
        this.c = (TextView) findViewById(R.id.player_float_tip_tv);
        this.d = (ImageView) findViewById(R.id.player_float_tip_close_btn);
    }

    public void setFloatCloseListener(OnClickListener onClickListener) {
        this.d.setOnClickListener(onClickListener);
    }

    public final void a() {
        this.a.setVisibility(0);
    }
}
