package com.xunlei.downloadprovider.ad.feedvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class FeedVideoItemADBottomView extends RelativeLayout {
    private ImageView a;
    private TextView b;
    private TextView c;
    private TextView d;

    public FeedVideoItemADBottomView(Context context) {
        super(context);
        setBottomBarLayout(context);
    }

    public FeedVideoItemADBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBottomBarLayout(context);
    }

    public FeedVideoItemADBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setBottomBarLayout(context);
    }

    public ImageView getSubjectIconImageView() {
        return this.a;
    }

    public TextView getSubjectNameTextView() {
        return this.b;
    }

    public TextView getTvOpen() {
        return this.c;
    }

    public TextView getTvTag() {
        return this.d;
    }

    private void setBottomBarLayout(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.feed_item_ad_bottom_view, this);
        this.c = (TextView) context.findViewById(R.id.btn_open);
        this.a = (ImageView) context.findViewById(R.id.iv_subject_icon);
        this.b = (TextView) context.findViewById(R.id.tv_subject_name);
        this.d = (TextView) context.findViewById(R.id.tv_tag);
    }
}
