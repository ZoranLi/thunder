package com.xunlei.downloadprovider.vod.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.xunlei.downloadprovider.R;

public class VodCenterProgressView extends LinearLayout {
    private ImageView a = null;
    private ProgressBar b = null;
    private CenterProgressType c;

    public enum CenterProgressType {
        CenterProgress_Volume,
        CenterProgress_Brightness
    }

    public VodCenterProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VodCenterProgressView(Context context) {
        super(context);
    }

    @SuppressLint({"NewApi"})
    public VodCenterProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (ImageView) findViewById(R.id.iv_center_progress_icon);
        this.b = (ProgressBar) findViewById(R.id.pbr_center_progress);
    }

    public void setProgress(int i) {
        switch (c.a[this.c.ordinal()]) {
            case 1:
                if (i <= 0) {
                    this.a.setBackgroundResource(R.drawable.vod_player_center_vol_silence);
                    break;
                } else {
                    this.a.setBackgroundResource(R.drawable.vod_player_center_vol);
                    break;
                }
            case 2:
                this.a.setBackgroundResource(R.drawable.vod_player_center_brightness);
                break;
            default:
                break;
        }
        this.b.setProgress(i);
    }

    public CenterProgressType getType() {
        return this.c;
    }
}
