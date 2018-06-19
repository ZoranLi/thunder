package com.xunlei.downloadprovider.homepage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Scroller;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.h.j;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailFragment;
import com.xunlei.xllib.android.d;

/* compiled from: FixOnTopScrollingHelper */
public class b {
    private static final String o = "b";
    public final View a;
    public final ShortMovieDetailFragment b;
    public final VelocityTracker c;
    public final Scroller d;
    public final a e;
    public final int f;
    public int g;
    public int h;
    public float i;
    public float j;
    public int k = ViewConfiguration.get(this.p).getScaledTouchSlop();
    public boolean l;
    public boolean m;
    public int n;
    private final Context p;
    private final int q = ViewConfiguration.get(this.p).getScaledMinimumFlingVelocity();
    private final int r = AndroidConfig.getScreenHeight();

    /* compiled from: FixOnTopScrollingHelper */
    private class a extends Handler {
        final /* synthetic */ b a;

        private a(b bVar) {
            this.a = bVar;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1001 && this.a.d.computeScrollOffset() != null) {
                message = this.a.d.getCurrY();
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.a.a.getLayoutParams();
                if (message > this.a.h) {
                    message = this.a.h;
                } else if (message < this.a.g) {
                    message = this.a.g;
                }
                marginLayoutParams.height = message;
                this.a.a.requestLayout();
                if (marginLayoutParams.topMargin + this.a.a.getMeasuredHeight() > this.a.f - b.a()) {
                    this.a.b.a(true);
                } else {
                    this.a.b.a(false);
                }
                sendEmptyMessage(1001);
            }
        }
    }

    public b(Context context, View view, ShortMovieDetailFragment shortMovieDetailFragment, int i, int i2) {
        this.p = context;
        this.a = view;
        this.b = shortMovieDetailFragment;
        this.g = i;
        this.h = i2;
        this.f = d.b(this.p) - (j.b(this.p) != null ? j.a(this.p) : null);
        this.c = VelocityTracker.obtain();
        this.d = new Scroller(this.p);
        this.e = new a();
    }

    public final void a(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    public static int a() {
        return DipPixelUtil.dip2px(43.0f);
    }
}
