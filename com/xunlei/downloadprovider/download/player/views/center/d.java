package com.xunlei.downloadprovider.download.player.views.center;

import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.xunlei.downloadprovider.R;

/* compiled from: PlayerLoadingViewHolder */
public final class d {
    public View a;
    public TextView b;
    private LottieAnimationView c;

    public d(View view) {
        this.a = view;
        this.c = (LottieAnimationView) view.findViewById(R.id.lav_loading_indicator);
        this.b = (TextView) view.findViewById(R.id.player_loading_text);
    }

    public final void a(int i) {
        if (i == 0) {
            this.c.c();
            this.c.a(true);
            this.c.a();
        } else {
            this.c.c();
        }
        this.a.setVisibility(i);
    }
}
