package com.tencent.bugly.beta.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: BUGLY */
class a$3 implements AnimationListener {
    final /* synthetic */ a a;

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    a$3(a aVar) {
        this.a = aVar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a.b != null) {
            this.a.b.setVisibility(8);
        }
        a.a(this.a);
    }
}
