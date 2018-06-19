package com.xunlei.downloadprovider.download.player.views.right;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.player.views.PlayerViewGroupBase;

public class PlayerRightViewGroup extends PlayerViewGroupBase {
    private PlayerRecordButtonView a;

    public PlayerRightViewGroup(Context context) {
        super(context);
    }

    public PlayerRightViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerRightViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PlayerRightViewGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (PlayerRecordButtonView) findViewById(R.id.player_record_button);
    }

    public final void a() {
        if (getVisibility() != 0 && getContext() != null) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.vod_control_bar_right_in));
            setVisibility(0);
        }
    }

    public final void b() {
        if (getVisibility() == 0 && getContext() != null) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.vod_control_bar_right_out));
            setVisibility(8);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        if (!z) {
            b();
        }
    }
}
