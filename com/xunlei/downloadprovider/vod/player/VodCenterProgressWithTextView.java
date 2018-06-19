package com.xunlei.downloadprovider.vod.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class VodCenterProgressWithTextView extends LinearLayout {
    private ImageView a = null;
    private TextView b = null;
    private TextView c = null;
    private ProgressBar d = null;
    private int e = null;

    public VodCenterProgressWithTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VodCenterProgressWithTextView(Context context) {
        super(context);
    }

    @SuppressLint({"NewApi"})
    public VodCenterProgressWithTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (ImageView) findViewById(R.id.iv_center_progress_icon);
        this.b = (TextView) findViewById(R.id.tv_center_progress_text);
        this.c = (TextView) findViewById(R.id.tv_center_progress_text_suffix);
        this.d = (ProgressBar) findViewById(R.id.pbr_center_progress);
    }

    public void setProgress(int i) {
        this.d.setProgress(i);
        if (i < this.e) {
            this.a.setBackgroundResource(R.drawable.vod_player_center_seek_rewind);
        } else {
            this.a.setBackgroundResource(R.drawable.vod_player_center_seek_forward);
        }
    }

    public void setText(String str) {
        this.b.setText(str);
    }

    public void setSuffixText(String str) {
        this.c.setText(str);
    }
}
