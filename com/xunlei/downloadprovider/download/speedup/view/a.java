package com.xunlei.downloadprovider.download.speedup.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.xunlei.common.androidutil.DipPixelUtil;

/* compiled from: ABProgressManager */
public final class a {
    public d a;
    public View b;

    public a(Context context) {
        View flickerSingleProgressView = new FlickerSingleProgressView(context);
        flickerSingleProgressView.setLayoutParams(new LayoutParams(-1, DipPixelUtil.dip2px(2.0f)));
        this.a = flickerSingleProgressView.getProgressControl();
        this.b = flickerSingleProgressView;
    }
}
