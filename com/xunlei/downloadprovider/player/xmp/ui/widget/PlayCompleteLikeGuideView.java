package com.xunlei.downloadprovider.player.xmp.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.ViewUtil;
import com.xunlei.common.commonview.RoundProgressBar;
import com.xunlei.downloadprovider.R;
import java.util.ArrayList;
import java.util.List;

public class PlayCompleteLikeGuideView extends FrameLayout {
    public ImageView a;
    public int b = 5;
    public a c;
    private View d;
    private TextView e;
    private View f;
    private RoundProgressBar g;

    public interface a {
        void a(boolean z);

        void onClick(int i);
    }

    public PlayCompleteLikeGuideView(Context context) {
        super(context);
        a(context);
    }

    public PlayCompleteLikeGuideView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayCompleteLikeGuideView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_complete_like_guide_view, this, true);
        this.a = (ImageView) findViewById(R.id.like_guide_animation_view);
        setOnClickListener(new d(this));
        this.d = findViewById(R.id.animation_layout);
        this.e = (TextView) findViewById(R.id.count_down_view);
        this.e.setText("5");
        this.f = findViewById(R.id.count_down_layout);
        this.g = (RoundProgressBar) findViewById(R.id.progress_bar);
    }

    public final void a(int i) {
        List arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.g, View.ALPHA, new float[]{0.6f}).setDuration(500));
        int i2 = 0;
        while (i2 < this.b) {
            AnimatorSet animatorSet = new AnimatorSet();
            int[] iArr = new int[2];
            iArr[0] = i2 * 72;
            i2++;
            iArr[1] = i2 * 72;
            Animator duration = ValueAnimator.ofInt(iArr).setDuration(650);
            duration.addUpdateListener(new f(this));
            animatorSet.play(duration).before(ValueAnimator.ofInt(new int[]{0, 0}).setDuration(250));
            arrayList.add(animatorSet);
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(arrayList);
        animatorSet2.setStartDelay((long) i);
        animatorSet2.start();
    }

    public final void a(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
        getAnimationDrawable().stop();
        this.a.clearAnimation();
        this.a.setVisibility(8);
        ViewUtil.removeViewFromParent(this);
        this.b = true;
        this.c = false;
    }

    public AnimationDrawable getAnimationDrawable() {
        return (AnimationDrawable) this.a.getDrawable();
    }

    static /* synthetic */ void f(PlayCompleteLikeGuideView playCompleteLikeGuideView) {
        AnimatorSet animatorSet = new AnimatorSet();
        Animator duration = ObjectAnimator.ofFloat(playCompleteLikeGuideView.d, View.TRANSLATION_Y, new float[]{(float) DipPixelUtil.dip2px(13.0f)}).setDuration(150);
        Animator duration2 = ObjectAnimator.ofFloat(playCompleteLikeGuideView.d, View.TRANSLATION_Y, new float[]{(float) (-DipPixelUtil.dip2px(40.0f))}).setDuration(200);
        animatorSet.play(duration2).with(ObjectAnimator.ofFloat(playCompleteLikeGuideView, View.ALPHA, new float[]{0.0f}).setDuration(200)).after(duration);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ObjectAnimator.ofFloat(playCompleteLikeGuideView.f, View.TRANSLATION_Y, new float[]{(float) DipPixelUtil.dip2px(40.0f)}).setDuration(200)).after(ObjectAnimator.ofFloat(playCompleteLikeGuideView.f, View.TRANSLATION_Y, new float[]{(float) (-DipPixelUtil.dip2px(13.0f))}).setDuration(150));
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(new Animator[]{animatorSet, animatorSet2});
        animatorSet3.addListener(new g(playCompleteLikeGuideView));
        animatorSet3.start();
    }
}
