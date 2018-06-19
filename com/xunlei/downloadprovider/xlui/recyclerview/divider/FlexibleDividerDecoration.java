package com.xunlei.downloadprovider.xlui.recyclerview.divider;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.xunlei.downloadprovider.R;

public abstract class FlexibleDividerDecoration extends ItemDecoration {
    private static final int[] i = new int[]{16843284};
    protected DividerType a = DividerType.DRAWABLE;
    protected f b;
    protected d c;
    protected b d;
    protected c e;
    protected e f;
    protected boolean g;
    protected boolean h;
    private Paint j;

    protected enum DividerType {
        DRAWABLE,
        PAINT,
        COLOR
    }

    public static class a<T extends a> {
        Context a;
        protected Resources b;
        d c;
        b d;
        c e;
        e f;
        f g = new d(this);
        boolean h = false;
        boolean i = false;

        public a(Context context) {
            this.a = context;
            this.b = context.getResources();
        }

        public final T a(@ColorRes int i) {
            this.d = new e(this, ContextCompat.getColor(this.a, i));
            return this;
        }

        public final T b(int i) {
            this.f = new f(this, i);
            return this;
        }

        public final T a() {
            return b(this.b.getDimensionPixelSize(R.dimen.lx_space_task_divider));
        }

        protected final void b() {
            if (this.c == null) {
                return;
            }
            if (this.d != null) {
                throw new IllegalArgumentException("Use setColor method of Paint class to specify line color. Do not provider ColorProvider if you set PaintProvider.");
            } else if (this.f != null) {
                throw new IllegalArgumentException("Use setStrokeWidth method of Paint class to specify line size. Do not provider SizeProvider if you set PaintProvider.");
            }
        }
    }

    public interface b {
        int a();
    }

    public interface c {
        Drawable a();
    }

    public interface d {
        Paint a();
    }

    public interface e {
        int a();
    }

    public interface f {
    }

    protected abstract Rect a(RecyclerView recyclerView, View view);

    protected abstract void a(Rect rect, RecyclerView recyclerView);

    protected FlexibleDividerDecoration(a aVar) {
        if (aVar.c != null) {
            this.a = DividerType.PAINT;
            this.c = aVar.c;
        } else if (aVar.d != null) {
            this.a = DividerType.COLOR;
            this.d = aVar.d;
            this.j = new Paint();
            this.f = aVar.f;
            if (this.f == null) {
                this.f = new b(this);
            }
        } else {
            this.a = DividerType.DRAWABLE;
            if (aVar.e == null) {
                TypedArray obtainStyledAttributes = aVar.a.obtainStyledAttributes(i);
                Drawable drawable = obtainStyledAttributes.getDrawable(0);
                obtainStyledAttributes.recycle();
                this.e = new a(this, drawable);
            } else {
                this.e = aVar.e;
            }
            this.f = aVar.f;
        }
        this.b = aVar.g;
        this.g = aVar.h;
        this.h = aVar.i;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        FlexibleDividerDecoration flexibleDividerDecoration = this;
        RecyclerView recyclerView2 = recyclerView;
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            int b = b(recyclerView);
            int childCount = recyclerView.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView2.getChildAt(i2);
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(childAt);
                Canvas canvas2;
                if (childAdapterPosition >= i) {
                    Object obj;
                    Rect a;
                    Drawable a2;
                    if (!flexibleDividerDecoration.g) {
                        if (childAdapterPosition < itemCount - b) {
                        }
                        canvas2 = canvas;
                        i = childAdapterPosition;
                    }
                    if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                        if (gridLayoutManager.getSpanSizeLookup().getSpanIndex(childAdapterPosition, gridLayoutManager.getSpanCount()) > 0) {
                            obj = 1;
                            if (obj == null) {
                                a(childAdapterPosition, recyclerView2);
                                a = a(recyclerView2, childAt);
                                switch (c.a[flexibleDividerDecoration.a.ordinal()]) {
                                    case 1:
                                        a2 = flexibleDividerDecoration.e.a();
                                        a2.setBounds(a);
                                        a2.draw(canvas);
                                        break;
                                    case 2:
                                        flexibleDividerDecoration.j = flexibleDividerDecoration.c.a();
                                        canvas.drawLine((float) a.left, (float) a.top, (float) a.right, (float) a.bottom, flexibleDividerDecoration.j);
                                        break;
                                    case 3:
                                        flexibleDividerDecoration.j.setColor(flexibleDividerDecoration.d.a());
                                        flexibleDividerDecoration.j.setStrokeWidth((float) flexibleDividerDecoration.f.a());
                                        canvas.drawLine((float) a.left, (float) a.top, (float) a.right, (float) a.bottom, flexibleDividerDecoration.j);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            canvas2 = canvas;
                            i = childAdapterPosition;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        a(childAdapterPosition, recyclerView2);
                        a = a(recyclerView2, childAt);
                        switch (c.a[flexibleDividerDecoration.a.ordinal()]) {
                            case 1:
                                a2 = flexibleDividerDecoration.e.a();
                                a2.setBounds(a);
                                a2.draw(canvas);
                                break;
                            case 2:
                                flexibleDividerDecoration.j = flexibleDividerDecoration.c.a();
                                canvas.drawLine((float) a.left, (float) a.top, (float) a.right, (float) a.bottom, flexibleDividerDecoration.j);
                                break;
                            case 3:
                                flexibleDividerDecoration.j.setColor(flexibleDividerDecoration.d.a());
                                flexibleDividerDecoration.j.setStrokeWidth((float) flexibleDividerDecoration.f.a());
                                canvas.drawLine((float) a.left, (float) a.top, (float) a.right, (float) a.bottom, flexibleDividerDecoration.j);
                                break;
                            default:
                                break;
                        }
                    }
                    canvas2 = canvas;
                    i = childAdapterPosition;
                } else {
                    canvas2 = canvas;
                }
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        state = recyclerView.getAdapter().getItemCount();
        int b = b(recyclerView);
        if (this.g || childAdapterPosition < state - b) {
            a(childAdapterPosition, recyclerView);
            a(rect, recyclerView);
        }
    }

    protected static boolean a(RecyclerView recyclerView) {
        recyclerView = recyclerView.getLayoutManager();
        return recyclerView instanceof LinearLayoutManager ? ((LinearLayoutManager) recyclerView).getReverseLayout() : null;
    }

    private static int b(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            int spanCount = gridLayoutManager.getSpanCount();
            recyclerView = recyclerView.getAdapter().getItemCount();
            for (int i = recyclerView - 1; i >= 0; i--) {
                if (spanSizeLookup.getSpanIndex(i, spanCount) == 0) {
                    return recyclerView - i;
                }
            }
        }
        return 1;
    }

    private static int a(int i, RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return i;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        return gridLayoutManager.getSpanSizeLookup().getSpanGroupIndex(i, gridLayoutManager.getSpanCount());
    }
}
