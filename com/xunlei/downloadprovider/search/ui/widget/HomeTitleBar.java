package com.xunlei.downloadprovider.search.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xunlei.common.commonview.DownloadEntranceView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.center.widget.v;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.search.ui.search.bq;

public class HomeTitleBar extends FrameLayout {
    public v a;
    private HintAnimEditText b;
    private DownloadEntranceView c;
    private FrameLayout d;
    private DLCenterEntry e = DLCenterEntry.search;

    public HomeTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public HomeTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public HomeTitleBar(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.home_title_bar, this, true);
        this.b = (HintAnimEditText) findViewById(R.id.search_title_bar_title);
        this.d = (FrameLayout) findViewById(R.id.search_titlebar_download_entrance_layout);
        this.c = (DownloadEntranceView) findViewById(R.id.search_titlebar_download_entrance);
        this.c.setOnClickListener(new c(this));
        a();
    }

    public void setDlCenterEntry(DLCenterEntry dLCenterEntry) {
        this.e = dLCenterEntry;
    }

    public void setHint(String str) {
        if (bq.b) {
            HintAnimEditText hintAnimEditText = this.b;
            hintAnimEditText.a = (float) (hintAnimEditText.getCompoundPaddingTop() - hintAnimEditText.getLineBounds(0, null));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 2.0f * hintAnimEditText.a});
            ofFloat.addUpdateListener(new a(hintAnimEditText, str));
            ofFloat.setDuration(600);
            ofFloat.setStartDelay(10);
            ofFloat.addListener(new b(hintAnimEditText, str));
            ofFloat.start();
            return;
        }
        this.b.setHintString(str);
    }

    public final void a() {
        if (this.a == null) {
            this.a = new v(this.c);
        }
        this.a.a();
    }

    public void setOnTitleClickListener(OnClickListener onClickListener) {
        if (this.b != null) {
            this.b.setOnClickListener(onClickListener);
        }
    }

    public void setSearchDownloadEntranceState(boolean z) {
        if (this.d != null) {
            if (z) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
        if (this.b != null) {
            LayoutParams layoutParams = (LayoutParams) this.b.getLayoutParams();
            if (z) {
                layoutParams.rightMargin = 0;
                return;
            }
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.common_padding_left_normal);
        }
    }
}
