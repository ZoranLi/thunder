package com.xunlei.tdlive.control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

public class PagerIndicator extends LinearLayout implements OnClickListener {
    private boolean a = null;
    private int b;
    private int c;
    private int d = -1;
    private BaseAdapter e;
    private a f = new a();
    private boolean g;
    private b h;

    private class a extends DataSetObserver {
        final /* synthetic */ PagerIndicator a;

        private a(PagerIndicator pagerIndicator) {
            this.a = pagerIndicator;
        }

        public void onChanged() {
            int i;
            this.a.removeAllViews();
            int i2 = 0;
            for (i = 0; i < this.a.e.getCount(); i++) {
                View childAt = this.a.getChildAt(i);
                View view = this.a.e.getView(i, childAt, this.a);
                if (!(view == null || view == childAt)) {
                    if (childAt != null) {
                        this.a.removeViewAt(i);
                    }
                    view.setOnClickListener(this.a);
                    this.a.addView(view, i);
                }
            }
            if (this.a.c >= 0 && this.a.c < this.a.getChildCount()) {
                if (this.a.d == -1) {
                    if (this.a.b >= 0 && this.a.b < this.a.getChildCount()) {
                        this.a.getChildAt(this.a.b).setSelected(false);
                    }
                    this.a.getChildAt(this.a.b = this.a.c).setSelected(true);
                } else if (this.a.d == this.a.c) {
                    for (i = 0; i < this.a.getChildCount(); i++) {
                        if (i == this.a.c) {
                            this.a.getChildAt(this.a.b = this.a.c).setSelected(true);
                        } else {
                            this.a.getChildAt(i).setActivated(true);
                        }
                    }
                } else {
                    for (i = 0; i < this.a.getChildCount(); i++) {
                        this.a.getChildAt(i).setPressed(false);
                    }
                    this.a.getChildAt(this.a.b = this.a.c).setSelected(true);
                }
                if (this.a.g && this.a.h != null) {
                    this.a.h.a(this.a, this.a.b);
                }
            }
            if (this.a.a) {
                PagerIndicator pagerIndicator = this.a;
                if (this.a.e.getCount() <= 1) {
                    i2 = 8;
                }
                pagerIndicator.setVisibility(i2);
                return;
            }
            this.a.setVisibility(0);
        }

        public void onInvalidated() {
            this.a.removeAllViews();
            onChanged();
        }
    }

    public interface b {
        void a(PagerIndicator pagerIndicator, int i);
    }

    @SuppressLint({"NewApi"})
    public PagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PagerIndicator(Context context) {
        super(context);
    }

    public void setOnPagerIndicatorListener(b bVar) {
        this.h = bVar;
    }

    public void setSingleVisible(boolean z) {
        this.a = z ^ true;
        int i = 0;
        if (this.e && this.a) {
            if (this.e.getCount() <= true) {
                i = 8;
            }
            setVisibility(i);
            return;
        }
        setVisibility(0);
    }

    public void select(int i) {
        select(i, true);
    }

    public void select(int i, boolean z) {
        if (this.e != null && i >= 0 && i < this.e.getCount()) {
            this.g = z;
            this.c = i;
            this.e.notifyDataSetChanged();
            this.g = false;
        }
    }

    public void setThirdStatePosition(int i) {
        this.d = i;
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        if (this.e != null) {
            this.e.unregisterDataSetObserver(this.f);
        }
        this.b = -1;
        this.c = 0;
        this.e = baseAdapter;
        this.e.registerDataSetObserver(this.f);
        this.e.notifyDataSetChanged();
    }

    public BaseAdapter getAdapter() {
        return this.e;
    }

    public void onClick(View view) {
        if (this.h != null) {
            for (int i = 0; i < getChildCount(); i++) {
                if (view == getChildAt(i)) {
                    select(i);
                    return;
                }
            }
        }
    }
}
