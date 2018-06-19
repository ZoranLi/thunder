package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class FeedVideoItemBottomView extends RelativeLayout {
    private ImageView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private a g;
    private LinearLayout h;
    private LinearLayout i;
    private RelativeLayout j;
    private RelativeLayout k;
    private RelativeLayout l;
    private ImageView m;
    private ImageView n;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public void setOnBottomActionBarClickListener(a aVar) {
        this.g = aVar;
    }

    public FeedVideoItemBottomView(Context context) {
        super(context);
        setBottomBarLayout(context);
    }

    public FeedVideoItemBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBottomBarLayout(context);
    }

    public FeedVideoItemBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setBottomBarLayout(context);
    }

    public ImageView getSubjectIconImageView() {
        return this.a;
    }

    public TextView getLikeTextView() {
        return this.e;
    }

    public TextView getCommentNumTextView() {
        return this.c;
    }

    public ImageView getLikeImageView() {
        return this.f;
    }

    public TextView getSubjectNameTextView() {
        return this.b;
    }

    public ImageView getHotCommentArrowImage() {
        return this.m;
    }

    public ImageView getImgVthumb() {
        return this.n;
    }

    public TextView getShareCountTextView() {
        return this.d;
    }

    public void setFollowFlVisibility(int i) {
        this.l.setVisibility(i);
    }

    public LinearLayout getClickLinearLayout() {
        return this.i;
    }

    private void setBottomBarLayout(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.feed_item_bottom_view, this);
        this.h = (LinearLayout) context.findViewById(R.id.ll_subject_icon_name);
        this.a = (ImageView) context.findViewById(R.id.iv_subject_icon);
        this.b = (TextView) context.findViewById(R.id.tv_subject_name);
        this.i = (LinearLayout) context.findViewById(R.id.ll_click_nice);
        this.f = (ImageView) context.findViewById(R.id.iv_click_nice_icon);
        this.e = (TextView) context.findViewById(R.id.tv_click_nice_num);
        this.j = (RelativeLayout) context.findViewById(R.id.rl_comment);
        this.c = (TextView) context.findViewById(R.id.tv_comment_num);
        this.m = (ImageView) findViewById(R.id.iv_hot_comment_arrow);
        this.k = (RelativeLayout) context.findViewById(R.id.rl_feed_share);
        this.d = (TextView) context.findViewById(R.id.tv_share_count);
        this.l = (RelativeLayout) context.findViewById(R.id.rl_feed_follow);
        this.n = (ImageView) context.findViewById(R.id.small_img_v);
        this.h.setOnClickListener(new t(this));
        this.i.setOnClickListener(new u(this));
        this.j.setOnClickListener(new v(this));
        this.k.setOnClickListener(new w(this));
        this.l.setOnClickListener(new x(this));
    }
}
