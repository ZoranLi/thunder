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

/* compiled from: ScrollingHelper */
public class r {
    private static final String r = "r";
    public final View a;
    public final ShortMovieDetailFragment b;
    public final VelocityTracker c;
    public final int d = ViewConfiguration.get(this.s).getScaledMinimumFlingVelocity();
    public final Scroller e;
    public final a f;
    public final int g = AndroidConfig.getScreenHeight();
    public final int h;
    public int i;
    public final b j;
    public float k;
    public float l;
    public int m = ViewConfiguration.get(this.s).getScaledTouchSlop();
    public boolean n;
    public boolean o;
    public int p;
    public float q;
    private final Context s;

    /* compiled from: ScrollingHelper */
    private class a extends Handler {
        final /* synthetic */ r a;

        private a(r rVar) {
            this.a = rVar;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1001 && this.a.e.computeScrollOffset() != null) {
                message = this.a.e.getCurrY();
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.a.a.getLayoutParams();
                if (message > this.a.i) {
                    message = this.a.i;
                } else if (message <= this.a.i - this.a.a.getMeasuredHeight()) {
                    message = this.a.i - this.a.a.getMeasuredHeight();
                    if (this.a.j != null) {
                        this.a.j.a(false);
                    }
                } else if (this.a.j != null) {
                    this.a.j.a(true);
                }
                marginLayoutParams.topMargin = message;
                this.a.a.requestLayout();
                if (marginLayoutParams.topMargin + this.a.a.getMeasuredHeight() > this.a.h - DipPixelUtil.dip2px(43.0f)) {
                    this.a.b.a(true);
                } else {
                    this.a.b.a(false);
                }
                sendEmptyMessage(1001);
            }
        }
    }

    /* compiled from: ScrollingHelper */
    public interface b {
        void a(boolean z);
    }

    public r(Context context, View view, ShortMovieDetailFragment shortMovieDetailFragment, int i, b bVar) {
        this.s = context;
        this.a = view;
        this.b = shortMovieDetailFragment;
        this.h = d.b(this.s) - (j.b(this.s) != null ? j.a(this.s) : null);
        this.i = i;
        this.c = VelocityTracker.obtain();
        this.e = new Scroller(this.s);
        this.f = new a();
        this.j = bVar;
    }
}
