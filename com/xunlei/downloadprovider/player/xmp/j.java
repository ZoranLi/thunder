package com.xunlei.downloadprovider.player.xmp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.xunlei.common.androidutil.ViewUtil;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.player.xmp.ui.widget.DoubleClickAnimationView;
import com.xunlei.downloadprovider.player.xmp.ui.widget.DoubleClickAnimationView.a;

/* compiled from: PlayerLikeGuideHelper */
public final class j {
    static long e;
    Context a;
    int b = 1;
    DoubleClickAnimationView c;
    Handler d = new k(this, Looper.getMainLooper());
    private ViewGroup f;

    public j(Context context, ViewGroup viewGroup) {
        this.a = context;
        this.f = viewGroup;
        e = f.b(this.a, "short_video_play_count", 0);
        this.b = d.a().i.d();
    }

    final void a(String str, int i) {
        if (this.c == null) {
            this.c = new DoubleClickAnimationView(this.a);
            DoubleClickAnimationView doubleClickAnimationView = this.c;
            a lVar = new l(this);
            if (!doubleClickAnimationView.c) {
                doubleClickAnimationView.c = true;
                doubleClickAnimationView.setBackgroundColor(Color.parseColor("#99000000"));
                doubleClickAnimationView.a.setImageResource(R.drawable.double_click_guide);
                doubleClickAnimationView.b.setImageResource(R.drawable.double_click_guide_text);
                int i2 = 0;
                doubleClickAnimationView.b.setVisibility(0);
                AnimationDrawable animationDrawable = (AnimationDrawable) doubleClickAnimationView.a.getDrawable();
                animationDrawable.start();
                int i3 = 0;
                while (i2 < animationDrawable.getNumberOfFrames()) {
                    i3 += animationDrawable.getDuration(i2);
                    i2++;
                }
                doubleClickAnimationView.postDelayed(new com.xunlei.downloadprovider.player.xmp.ui.widget.a(doubleClickAnimationView, lVar), (long) i3);
            }
        }
        ViewUtil.removeViewFromParent(this.c);
        this.f.addView(this.c);
        StatEvent build = HubbleEventBuilder.build("android_play_shortvideo", "zan_double_click_guide");
        build.add("tabid", str);
        build.add("num", i);
        ThunderReport.reportEvent(build);
    }

    public final void a() {
        ViewUtil.removeViewFromParent(this.c);
        this.d.removeMessages(1);
    }
}
