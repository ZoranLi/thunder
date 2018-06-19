package com.xunlei.downloadprovider.xlui.widget.extendviewpager.autoscrollviewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import com.xunlei.download.proguard.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class AutoScrollViewPager extends ViewPager {
    int a;
    boolean b;
    boolean c;
    private long d;
    private boolean e;
    private int f;
    private double g;
    private double h;
    private Handler i;
    private boolean j;
    private boolean k;
    private float l;
    private float m;
    private a n;

    private static class a extends Handler {
        private final WeakReference<AutoScrollViewPager> a;

        public a(AutoScrollViewPager autoScrollViewPager) {
            this.a = new WeakReference(autoScrollViewPager);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == null) {
                AutoScrollViewPager autoScrollViewPager = (AutoScrollViewPager) this.a.get();
                if (autoScrollViewPager != null) {
                    autoScrollViewPager.n.a = autoScrollViewPager.g;
                    PagerAdapter adapter = autoScrollViewPager.getAdapter();
                    int currentItem = autoScrollViewPager.getCurrentItem();
                    if (adapter != null) {
                        int count = adapter.getCount();
                        if (count > 1) {
                            currentItem = autoScrollViewPager.a == 0 ? currentItem - 1 : currentItem + 1;
                            if (currentItem < 0) {
                                if (autoScrollViewPager.b) {
                                    autoScrollViewPager.setCurrentItem(count - 1, autoScrollViewPager.c);
                                }
                            } else if (currentItem != count) {
                                autoScrollViewPager.setCurrentItem(currentItem, true);
                            } else if (autoScrollViewPager.b) {
                                autoScrollViewPager.setCurrentItem(0, autoScrollViewPager.c);
                            }
                        }
                    }
                    autoScrollViewPager.n.a = autoScrollViewPager.h;
                    autoScrollViewPager.a(autoScrollViewPager.d + ((long) autoScrollViewPager.n.getDuration()));
                }
            }
        }
    }

    public AutoScrollViewPager(Context context) {
        super(context);
        this.d = c.x;
        this.a = 1;
        this.b = true;
        this.e = true;
        this.f = 0;
        this.c = true;
        this.g = 1.0d;
        this.h = 1.0d;
        this.j = false;
        this.k = false;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        c();
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1500;
        this.a = 1;
        this.b = true;
        this.e = true;
        this.f = 0;
        this.c = true;
        this.g = 1.0d;
        this.h = 1.0d;
        this.j = false;
        this.k = false;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        c();
    }

    private void c() {
        this.i = new a(this);
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            this.n = new a(getContext(), (Interpolator) declaredField2.get(null));
            declaredField.set(this, this.n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a() {
        this.j = true;
        a((long) (((double) this.d) + ((((double) this.n.getDuration()) / this.g) * this.h)));
    }

    public final void b() {
        this.j = false;
        this.i.removeMessages(0);
    }

    public void setSwipeScrollDurationFactor(double d) {
        this.h = d;
    }

    public void setAutoScrollDurationFactor(double d) {
        this.g = d;
    }

    private void a(long j) {
        this.i.removeMessages(0);
        this.i.sendEmptyMessageDelayed(0, j);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.e) {
            if (actionMasked == 0 && this.j) {
                this.k = true;
                b();
            } else if (motionEvent.getAction() == 1 && this.k) {
                a();
            }
        }
        if (this.f == 2 || this.f == 1) {
            int i;
            this.l = motionEvent.getX();
            if (motionEvent.getAction() == 0) {
                this.m = this.l;
            }
            actionMasked = getCurrentItem();
            PagerAdapter adapter = getAdapter();
            if (adapter == null) {
                i = 0;
            } else {
                i = adapter.getCount();
            }
            if ((actionMasked == 0 && this.m <= this.l) || (actionMasked == i - 1 && this.m >= this.l)) {
                if (this.f == 2) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    if (i > 1) {
                        setCurrentItem((i - actionMasked) - 1, this.c);
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public long getInterval() {
        return this.d;
    }

    public void setInterval(long j) {
        this.d = j;
    }

    public int getDirection() {
        return this.a == 0 ? 0 : 1;
    }

    public void setDirection(int i) {
        this.a = i;
    }

    public void setCycle(boolean z) {
        this.b = z;
    }

    public void setStopScrollWhenTouch(boolean z) {
        this.e = z;
    }

    public int getSlideBorderMode() {
        return this.f;
    }

    public void setSlideBorderMode(int i) {
        this.f = i;
    }

    public void setBorderAnimation(boolean z) {
        this.c = z;
    }
}
