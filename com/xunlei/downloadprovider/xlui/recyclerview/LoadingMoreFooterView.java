package com.xunlei.downloadprovider.xlui.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.GifView;
import com.xunlei.downloadprovider.R;

public class LoadingMoreFooterView extends LinearLayout {
    private ViewGroup a;
    private TextView b;
    private GifView c;

    public LoadingMoreFooterView(Context context) {
        this(context, null);
    }

    public LoadingMoreFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingMoreFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutParams(new LayoutParams(-1, -2));
        this.a = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.common_pull_up_refresh_item, null);
        this.b = (TextView) this.a.findViewById(R.id.loading_content);
        this.c = (GifView) this.a.findViewById(R.id.loading_gif);
        addView(this.a);
        this.a.setBackgroundColor(0);
        this.a.setLayoutParams(new LayoutParams(-1, -2));
        setPadding(0, 0, 0, DipPixelUtil.dip2px(4.0f));
    }

    public void setState(int i) {
        if (i == 0) {
            setVisibility(0);
            if (this.a != 0) {
                this.a.setVisibility(0);
                this.b.setText("正在加载中...");
                this.c.setVisibility(0);
            }
        } else if (i != 2) {
            setVisibility(0);
            if (this.a != 0) {
                this.a.setVisibility(8);
            }
        } else {
            setVisibility(0);
            if (this.a != 0) {
                this.a.setVisibility(0);
                this.b.setText("已经到底了");
                this.c.setVisibility(8);
            }
        }
    }

    public void setLoadingBackgroundColor(int i) {
        this.a.setBackgroundColor(i);
    }
}
