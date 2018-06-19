package com.xunlei.downloadprovider.download.player.views.right;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.xunlei.downloadprovider.R;

public class PlayerRecordButtonView extends RelativeLayout {
    private static final String d = "PlayerRecordButtonView";
    public DecelerateInterpolator a;
    public View b;
    public ImageButton c;

    public PlayerRecordButtonView(Context context) {
        super(context);
    }

    public PlayerRecordButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerRecordButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PlayerRecordButtonView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = new DecelerateInterpolator();
        this.b = findViewById(R.id.v_record_btn_bg);
        this.c = (ImageButton) findViewById(R.id.btn_record);
    }

    public void setRecordBtnEnabled(boolean z) {
        this.c.setEnabled(z);
        this.b.setEnabled(z);
    }

    public void setRecordBtnSelected(boolean z) {
        this.c.setSelected(z);
        this.b.setSelected(z);
    }

    public void setRecordButtonOnClickListener(OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }
}
