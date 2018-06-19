package com.xunlei.downloadprovider.download.player.views.left;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.player.views.PlayerViewGroupBase;
import com.xunlei.downloadprovider.player.xmp.b.a;

public class PlayerLeftViewGroup extends PlayerViewGroupBase implements OnClickListener {
    public boolean a = null;
    private ImageButton b = null;

    public PlayerLeftViewGroup(Context context) {
        super(context);
    }

    public PlayerLeftViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerLeftViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PlayerLeftViewGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.b = (ImageButton) findViewById(R.id.btn_lock);
        this.b.setOnClickListener(this);
        if (a.b()) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.b.getLayoutParams();
            marginLayoutParams.leftMargin += 80;
            this.b.setLayoutParams(marginLayoutParams);
        }
    }

    private void setScreenLock(boolean z) {
        if (z) {
            this.a = true;
            this.b.setImageResource(R.drawable.vod_player_btn_lock);
            return;
        }
        this.a = false;
        this.b.setImageResource(R.drawable.vod_player_btn_lock_open);
    }

    public final void a() {
        if (getVisibility() == 0 && getContext() != null) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.vod_control_bar_left_out));
            setVisibility(8);
        }
    }

    public final void b() {
        if (getVisibility() != 0 && getContext() != null) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.vod_control_bar_left_in));
            setVisibility(0);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_lock) {
            if (this.a == null) {
                setScreenLock(true);
                if (getPlayerRootView() != null) {
                    getPlayerRootView().d();
                    if (getPlayerRootView().getPlayerRightViewGroup() != null) {
                        getPlayerRootView().getPlayerRightViewGroup().b();
                    }
                }
                XLToast.showToastWithDuration(getContext(), getResources().getString(R.string.vod_toast_play_lock), 1);
                if (getPlayerRootView() != null) {
                    getPlayerRootView().j();
                }
                return;
            }
            setScreenLock(null);
            if (getPlayerRootView() != null) {
                getPlayerRootView().c();
                if (getPlayerRootView().getPlayerRightViewGroup() != null) {
                    getPlayerRootView().getPlayerRightViewGroup().a();
                }
            }
            XLToast.showToastWithDuration(getContext(), getResources().getString(R.string.vod_toast_play_unlock), 1);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        if (!z) {
            a();
        }
    }
}
