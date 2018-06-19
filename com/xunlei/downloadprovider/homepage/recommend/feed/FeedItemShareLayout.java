package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.b.n;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.f.c;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

public class FeedItemShareLayout extends FrameLayout {
    RelativeLayout a;
    Animation b;
    k c = new n(this);
    private y d;
    private OnClickListener e;
    private OnClickListener f;
    private AnimationSet g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private TextView l;
    private TextView m;
    private OnClickListener n = new m(this);

    public FeedItemShareLayout(Context context) {
        super(context);
        a(context);
        a();
    }

    public FeedItemShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        a();
    }

    public FeedItemShareLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
        a();
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.media_share_layout, this, true);
        findViewById(R.id.replay_btn).setOnClickListener(this.n);
        this.h = (ImageView) findViewById(R.id.iv_weixin);
        this.h.setOnClickListener(this.n);
        this.i = (ImageView) findViewById(R.id.iv_wxfriend);
        this.i.setOnClickListener(this.n);
        this.j = (ImageView) findViewById(R.id.iv_qq);
        this.j.setOnClickListener(this.n);
        this.k = (ImageView) findViewById(R.id.iv_qzone);
        this.k.setOnClickListener(this.n);
        this.a = (RelativeLayout) findViewById(R.id.rl_follow_contain);
        this.a.setOnClickListener(this.n);
        this.l = (TextView) findViewById(R.id.tv_feed_follow_btn);
        this.m = (TextView) findViewById(R.id.tv_feed_follow_title);
    }

    public void setFollowContainVisible(boolean z) {
        if (z) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
    }

    public void setFeedFollowTitleText(String str) {
        this.m.setText(str);
    }

    public void setFollowBtnClickable(boolean z) {
        if (z) {
            this.l.setEnabled(true);
        } else {
            this.l.setEnabled(false);
        }
    }

    public final void a(boolean z) {
        if (z) {
            setFollowContainVisible(false);
            setFollowBtnClickable(false);
            return;
        }
        setFollowContainVisible(true);
        setFollowBtnClickable(true);
    }

    private void a() {
        this.g = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) DipPixelUtil.dip2px(-4.0f));
        translateAnimation.setRepeatCount(1);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setDuration(200);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 1.25f, 1.0f, 1.25f, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
        scaleAnimation.setDuration(200);
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(2);
        this.g.addAnimation(translateAnimation);
        this.g.addAnimation(scaleAnimation);
    }

    public void setClickReplayListener(OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public void setClickFollowListener(OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    Activity getActivity() {
        return (Activity) getContext();
    }

    public void setFeedVideoItemModel(y yVar) {
        this.d = yVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    static /* synthetic */ void a(FeedItemShareLayout feedItemShareLayout) {
        if (feedItemShareLayout.b != null) {
            feedItemShareLayout.b.cancel();
        }
    }

    static /* synthetic */ void a(FeedItemShareLayout feedItemShareLayout, ShareOperationType shareOperationType) {
        f a;
        n nVar = d.a().l;
        if (nVar.d()) {
            a = c.a(feedItemShareLayout.getActivity(), "short_video", feedItemShareLayout.d.a, nVar.b());
        } else {
            a = c.a("short_video", feedItemShareLayout.d.a);
        }
        a.a();
        a.a(feedItemShareLayout.getActivity(), shareOperationType, a, feedItemShareLayout.c);
    }
}
