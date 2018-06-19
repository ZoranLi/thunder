package com.xunlei.downloadprovider.cardslide.slide;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;

@SuppressLint({"NewApi"})
public class CardItemView extends FrameLayout {
    ViewGroup a;
    ImageView b;
    ImageView c;
    Spring d;
    Spring e;
    ObjectAnimator f;
    private CardSlidePanel g;

    public CardItemView(Context context) {
        this(context, null);
    }

    public CardItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context = SpringConfig.fromBouncinessAndSpeed(0, 20.0d);
        attributeSet = SpringSystem.create();
        this.d = attributeSet.createSpring().setSpringConfig(context);
        this.e = attributeSet.createSpring().setSpringConfig(context);
        this.d.addListener(new b(this));
        this.e.addListener(new c(this));
    }

    public void setScreenX(int i) {
        offsetLeftAndRight(i - getLeft());
    }

    public void setScreenY(int i) {
        offsetTopAndBottom(i - getTop());
    }

    public void setParentView(CardSlidePanel cardSlidePanel) {
        this.g = cardSlidePanel;
    }

    public ImageView getIvLove() {
        return this.b;
    }

    public ImageView getIvDel() {
        return this.c;
    }

    public ViewGroup getCardVodLayout() {
        return this.a;
    }
}
