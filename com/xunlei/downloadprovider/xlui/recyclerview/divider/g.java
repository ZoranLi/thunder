package com.xunlei.downloadprovider.xlui.recyclerview.divider;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.xunlei.downloadprovider.R;

/* compiled from: HorizontalDividerItemDecoration */
public final class g extends FlexibleDividerDecoration {
    private b i;

    /* compiled from: HorizontalDividerItemDecoration */
    public interface b {
        int a();

        int b();
    }

    /* compiled from: HorizontalDividerItemDecoration */
    public static class a extends com.xunlei.downloadprovider.xlui.recyclerview.divider.FlexibleDividerDecoration.a<a> {
        b j = new h(this);

        public a(Context context) {
            super(context);
        }

        public final a c() {
            this.j = new i(this, this.b.getDimensionPixelSize(R.dimen.lx_space_task_item_margin), this.b.getDimensionPixelSize(R.dimen.lx_space_task_item_margin));
            return this;
        }

        public final g d() {
            b();
            return new g(this);
        }
    }

    protected g(a aVar) {
        super(aVar);
        this.i = aVar.j;
    }

    protected final Rect a(RecyclerView recyclerView, View view) {
        Rect rect = new Rect(0, 0, 0, 0);
        int translationX = (int) ViewCompat.getTranslationX(view);
        int translationY = (int) ViewCompat.getTranslationY(view);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        rect.left = (recyclerView.getPaddingLeft() + this.i.a()) + translationX;
        rect.right = ((recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.i.b()) + translationX;
        translationX = a();
        recyclerView = FlexibleDividerDecoration.a(recyclerView);
        if (this.a != DividerType.DRAWABLE) {
            int i = translationX / 2;
            if (recyclerView != null) {
                rect.top = ((view.getTop() - layoutParams.topMargin) - i) + translationY;
            } else {
                rect.top = ((view.getBottom() + layoutParams.bottomMargin) + i) + translationY;
            }
            rect.bottom = rect.top;
        } else if (recyclerView != null) {
            rect.bottom = (view.getTop() - layoutParams.topMargin) + translationY;
            rect.top = rect.bottom - translationX;
        } else {
            rect.top = (view.getBottom() + layoutParams.bottomMargin) + translationY;
            rect.bottom = rect.top + translationX;
        }
        if (this.h != null) {
            if (recyclerView != null) {
                rect.top += translationX;
                rect.bottom += translationX;
            } else {
                rect.top -= translationX;
                rect.bottom -= translationX;
            }
        }
        return rect;
    }

    protected final void a(Rect rect, RecyclerView recyclerView) {
        if (this.h) {
            rect.set(0, 0, 0, 0);
        } else if (FlexibleDividerDecoration.a(recyclerView) != null) {
            rect.set(0, a(), 0, 0);
        } else {
            rect.set(0, 0, 0, a());
        }
    }

    private int a() {
        if (this.c != null) {
            return (int) this.c.a().getStrokeWidth();
        }
        if (this.f != null) {
            return this.f.a();
        }
        if (this.e != null) {
            return this.e.a().getIntrinsicHeight();
        }
        throw new RuntimeException("failed to get size");
    }
}
