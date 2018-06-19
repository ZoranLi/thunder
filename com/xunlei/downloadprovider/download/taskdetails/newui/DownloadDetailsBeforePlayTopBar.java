package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.xunlei.downloadprovider.R;

public class DownloadDetailsBeforePlayTopBar extends RelativeLayout {
    private View a = null;

    public DownloadDetailsBeforePlayTopBar(Context context) {
        super(context);
        a();
    }

    public DownloadDetailsBeforePlayTopBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DownloadDetailsBeforePlayTopBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.download_detail_before_play_top_bar, this);
        this.a = findViewById(R.id.btn_back);
    }

    public void setOnBackClickListener(OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }
}
