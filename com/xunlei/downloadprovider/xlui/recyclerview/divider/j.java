package com.xunlei.downloadprovider.xlui.recyclerview.divider;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: VerticalDividerItemDecoration */
public final class j extends FlexibleDividerDecoration {
    private b i;

    /* compiled from: VerticalDividerItemDecoration */
    public interface b {
    }

    /* compiled from: VerticalDividerItemDecoration */
    public static class a extends com.xunlei.downloadprovider.xlui.recyclerview.divider.FlexibleDividerDecoration.a<a> {
        b j = new k(this);

        public a(Context context) {
            super(context);
        }

        public final j c() {
            b();
            return new j(this);
        }
    }

    protected j(a aVar) {
        super(aVar);
        this.i = aVar.j;
    }

    protected final Rect a(RecyclerView recyclerView, View view) {
        Rect rect = new Rect(0, 0, 0, 0);
        int translationX = (int) ViewCompat.getTranslationX(view);
        int translationY = (int) ViewCompat.getTranslationY(view);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        rect.top = (recyclerView.getPaddingTop() + 0) + translationY;
        rect.bottom = ((recyclerView.getHeight() - recyclerView.getPaddingBottom()) - 0) + translationY;
        int a = a();
        recyclerView = FlexibleDividerDecoration.a(recyclerView);
        if (this.a != DividerType.DRAWABLE) {
            translationY = a / 2;
            if (recyclerView != null) {
                rect.left = ((view.getLeft() - layoutParams.leftMargin) - translationY) + translationX;
            } else {
                rect.left = ((view.getRight() + layoutParams.rightMargin) + translationY) + translationX;
            }
            rect.right = rect.left;
        } else if (recyclerView != null) {
            rect.right = (view.getLeft() - layoutParams.leftMargin) + translationX;
            rect.left = rect.right - a;
        } else {
            rect.left = (view.getRight() + layoutParams.rightMargin) + translationX;
            rect.right = rect.left + a;
        }
        if (this.h != null) {
            if (recyclerView != null) {
                rect.left += a;
                rect.right += a;
            } else {
                rect.left -= a;
                rect.right -= a;
            }
        }
        return rect;
    }

    protected final void a(Rect rect, RecyclerView recyclerView) {
        if (this.h) {
            rect.set(0, 0, 0, 0);
        } else if (FlexibleDividerDecoration.a(recyclerView) != null) {
            rect.set(a(), 0, 0, 0);
        } else {
            rect.set(0, 0, a(), 0);
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
            return this.e.a().getIntrinsicWidth();
        }
        throw new RuntimeException("failed to get size");
    }
}
