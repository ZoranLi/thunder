package com.xunlei.tdlive.control;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.util.HashSet;
import java.util.Iterator;

public class RecycleableViewPager extends ViewPager {
    private boolean a = true;
    private PagerAdapter b;
    private HashSet<OnPageChangeListener> c = new HashSet();
    private OnPageChangeListener d = new OnPageChangeListener(this) {
        final /* synthetic */ RecycleableViewPager a;

        {
            this.a = r1;
        }

        public void onPageScrolled(int i, float f, int i2) {
            Iterator it = this.a.c.iterator();
            while (it.hasNext()) {
                ((OnPageChangeListener) it.next()).onPageScrolled(RecycleableViewPager.a(i, this.a.b.getCount()), f, i2);
            }
        }

        public void onPageSelected(int i) {
            Iterator it = this.a.c.iterator();
            while (it.hasNext()) {
                ((OnPageChangeListener) it.next()).onPageSelected(RecycleableViewPager.a(i, this.a.b.getCount()));
            }
        }

        public void onPageScrollStateChanged(int i) {
            Iterator it = this.a.c.iterator();
            while (it.hasNext()) {
                ((OnPageChangeListener) it.next()).onPageScrollStateChanged(i);
            }
        }
    };

    static class a extends PagerAdapter {
        private PagerAdapter a;
        private DataSetObserver b = new DataSetObserver(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onChanged() {
                this.a.notifyDataSetChanged();
            }

            public void onInvalidated() {
                this.a.notifyDataSetChanged();
            }
        };

        public a(PagerAdapter pagerAdapter) {
            this.a = pagerAdapter;
            this.a.registerDataSetObserver(this.b);
        }

        public int getCount() {
            int count = this.a.getCount();
            return count < 2 ? count : count * ReaderCallback.GET_BAR_ANIMATING;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return this.a.isViewFromObject(view, obj);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return this.a.instantiateItem(viewGroup, RecycleableViewPager.a(i, this.a.getCount()));
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            this.a.destroyItem(viewGroup, RecycleableViewPager.a(i, this.a.getCount()), obj);
        }

        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            this.a.setPrimaryItem(viewGroup, RecycleableViewPager.a(i, this.a.getCount()), obj);
        }

        public int getItemPosition(Object obj) {
            return this.a.getItemPosition(obj);
        }

        public CharSequence getPageTitle(int i) {
            return this.a.getPageTitle(RecycleableViewPager.a(i, this.a.getCount()));
        }

        public float getPageWidth(int i) {
            return this.a.getPageWidth(RecycleableViewPager.a(i, this.a.getCount()));
        }
    }

    public RecycleableViewPager(Context context) {
        super(context);
    }

    public RecycleableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setRecycle(boolean z) {
        this.a = z;
        setAdapter(this.b);
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.a) {
            this.b = pagerAdapter;
            super.setAdapter(new a(pagerAdapter));
            return;
        }
        this.b = pagerAdapter;
        super.setAdapter(pagerAdapter);
    }

    public PagerAdapter getAdapter() {
        return this.b;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        super.removeOnPageChangeListener(this.d);
        super.addOnPageChangeListener(this.d);
        addOnPageChangeListener(onPageChangeListener);
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        super.removeOnPageChangeListener(this.d);
        super.addOnPageChangeListener(this.d);
        this.c.add(onPageChangeListener);
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.c.remove(onPageChangeListener);
        if (this.c.isEmpty() != null) {
            super.removeOnPageChangeListener(this.d);
        }
    }

    public void step(boolean z) {
        int currentItem = super.getCurrentItem() + 1;
        if (this.a) {
            currentItem %= ReaderCallback.GET_BAR_ANIMATING;
        }
        super.setCurrentItem(currentItem, z);
    }

    public int getCurrentItem() {
        if (this.a) {
            if (this.b != null) {
                return a(super.getCurrentItem(), this.b.getCount());
            }
        }
        return super.getCurrentItem();
    }

    static int a(int i, int i2) {
        return i2 == 0 ? 0 : i % i2;
    }
}
