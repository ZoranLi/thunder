package com.xunlei.tdlive.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import com.xunlei.tdlive.a.f;
import com.xunlei.tdlive.control.PagerIndicator;
import com.xunlei.tdlive.control.RecycleableViewPager;
import com.xunlei.tdlive.sdk.R;
import com.xunlei.tdlive.util.j;

public class LiveListBannerView extends RelativeLayout implements OnPageChangeListener, Runnable {
    private j a;
    private AdapterView<?> b;
    private PagerIndicator c;
    private RecycleableViewPager d;
    private OnItemClickListener e;
    private GestureDetector f;
    private DataSetObserver g = new DataSetObserver(this) {
        final /* synthetic */ LiveListBannerView a;

        {
            this.a = r1;
        }

        public void onChanged() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.a;	 Catch:{ Throwable -> 0x001e }
            r0 = r0.c;	 Catch:{ Throwable -> 0x001e }
            r0 = r0.getAdapter();	 Catch:{ Throwable -> 0x001e }
            r0 = (com.xunlei.tdlive.a.f) r0;	 Catch:{ Throwable -> 0x001e }
            r1 = r2.a;	 Catch:{ Throwable -> 0x001e }
            r1 = r1.d;	 Catch:{ Throwable -> 0x001e }
            r1 = r1.getAdapter();	 Catch:{ Throwable -> 0x001e }
            r1 = r1.getCount();	 Catch:{ Throwable -> 0x001e }
            r0.a(r1);	 Catch:{ Throwable -> 0x001e }
            return;
        L_0x001e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.view.LiveListBannerView.1.onChanged():void");
        }

        public void onInvalidated() {
            onChanged();
        }
    };

    private class a extends SimpleOnGestureListener {
        final /* synthetic */ LiveListBannerView a;

        private a(LiveListBannerView liveListBannerView) {
            this.a = liveListBannerView;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (this.a.e != null) {
                if (this.a.b == null) {
                    this.a.b = new AdapterView<Adapter>(this, this.a.getContext()) {
                        final /* synthetic */ a a;

                        public Adapter getAdapter() {
                            return null;
                        }

                        public View getSelectedView() {
                            return null;
                        }

                        public void setAdapter(Adapter adapter) {
                        }

                        public void setSelection(int i) {
                        }
                    };
                    this.a.b.setId(this.a.getId());
                }
                this.a.e.onItemClick(this.a.b, this.a, this.a.d.getCurrentItem(), (long) this.a.getId());
            }
            return true;
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public LiveListBannerView(Context context) {
        super(context);
    }

    public LiveListBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LiveListBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public LiveListBannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setAdapter(android.support.v4.view.PagerAdapter r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.d;	 Catch:{ Throwable -> 0x000b }
        r0 = r0.getAdapter();	 Catch:{ Throwable -> 0x000b }
        r1 = r2.g;	 Catch:{ Throwable -> 0x000b }
        r0.unregisterDataSetObserver(r1);	 Catch:{ Throwable -> 0x000b }
    L_0x000b:
        r0 = r2.d;
        r0.setAdapter(r3);
        r3 = r2.d;
        r3 = r3.getAdapter();
        r0 = r2.g;
        r3.registerDataSetObserver(r0);
        r3 = r2.d;
        r3 = r3.getAdapter();
        r3.notifyDataSetChanged();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.view.LiveListBannerView.setAdapter(android.support.v4.view.PagerAdapter):void");
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        if (this.f == null) {
            this.f = new GestureDetector(getContext(), new a());
        }
        this.e = onItemClickListener;
    }

    public void autoStep(int i) {
        if (this.a == null) {
            this.a = new j(i, this);
        }
        this.a.a(i);
        this.a.c();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.d = (RecycleableViewPager) findViewById(R.id.banner);
        this.d.setOnPageChangeListener(this);
        this.c = (PagerIndicator) findViewById(R.id.banner_indicator);
        this.c.setSingleVisible(false);
        this.c.setAdapter(new f());
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (f == 0 && this.a != 0) {
            this.a.c();
        }
    }

    public void onPageSelected(int i) {
        this.c.select(i % this.c.getAdapter().getCount());
    }

    public void run() {
        if (this.d != null) {
            this.d.step(true);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f != null) {
            this.f.onTouchEvent(motionEvent);
        }
        return null;
    }
}
