package com.xunlei.downloadprovider.personal.a.c;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout.LayoutParams;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.download.speedup.a;

/* compiled from: UserInfoViewHolder */
final class ak implements Runnable {
    final /* synthetic */ s a;

    ak(s sVar) {
        this.a = sVar;
    }

    public final void run() {
        LayoutParams layoutParams = (LayoutParams) this.a.G.getLayoutParams();
        layoutParams.height = this.a.H.getHeight() + DipPixelUtil.dip2px(13.0f);
        layoutParams.width = this.a.H.getWidth() + DipPixelUtil.dip2px(5.0f);
        this.a.G.setLayoutParams(layoutParams);
        this.a.G.setVisibility(0);
        Drawable background = this.a.G.getBackground();
        if (this.a.I == null && (background instanceof AnimationDrawable)) {
            this.a.I = new a((AnimationDrawable) background, Integer.MAX_VALUE, 3000);
        }
        if (this.a.I != null) {
            this.a.I.a();
        }
    }
}
