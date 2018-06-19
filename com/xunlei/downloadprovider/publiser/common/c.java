package com.xunlei.downloadprovider.publiser.common;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.LayoutParams;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

/* compiled from: AvatarActivity */
final class c implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ LayoutParams c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;
    final /* synthetic */ AvatarActivity h;

    c(AvatarActivity avatarActivity, float f, float f2, LayoutParams layoutParams, int i, int i2, int i3, int i4) {
        this.h = avatarActivity;
        this.a = f;
        this.b = f2;
        this.c = layoutParams;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        valueAnimator = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.h.b.setTranslationX(this.a + ((this.b - this.a) * valueAnimator));
        this.c.width = (int) ((((float) this.d) + (((float) (this.e - this.d)) * valueAnimator)) + PayBaseConstants.HALF_OF_FLOAT);
        this.c.height = (int) ((((float) this.f) + (((float) (this.g - this.f)) * valueAnimator)) + PayBaseConstants.HALF_OF_FLOAT);
        this.h.b.requestLayout();
    }
}
