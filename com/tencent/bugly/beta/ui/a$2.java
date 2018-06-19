package com.tencent.bugly.beta.ui;

import android.view.animation.Animation;

/* compiled from: BUGLY */
class a$2 implements Runnable {
    final /* synthetic */ Animation a;
    final /* synthetic */ a b;

    a$2(a aVar, Animation animation) {
        this.b = aVar;
        this.a = animation;
    }

    public void run() {
        if (this.b.b != null) {
            this.b.b.startAnimation(this.a);
        }
    }
}
