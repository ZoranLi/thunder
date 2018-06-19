package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.xunlei.downloadprovider.R;

/* compiled from: TaskListFeedItemDecoration */
public final class m extends ItemDecoration {
    private Context a = null;
    private Paint b = null;

    public m(Context context) {
        this.a = context;
        this.b = new Paint();
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        super.onDraw(canvas, recyclerView, state);
        state = recyclerView.getChildCount();
        for (int i = 0; i < state; i++) {
            Rect a;
            View childAt = recyclerView.getChildAt(i);
            ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
            Object obj = 1;
            if ((a(childViewHolder) == 1 ? 1 : null) != null) {
                a = a(recyclerView, childAt);
            } else {
                if (a(childViewHolder) != 2) {
                    obj = null;
                }
                if (obj != null) {
                    a = a(recyclerView, childAt);
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.task_list_feed_padding_side);
                    int i2 = a.right - dimensionPixelSize;
                    a.left += dimensionPixelSize;
                    a.right = i2;
                    this.b.setColor(this.a.getResources().getColor(R.color.white));
                    canvas.drawRect(0.0f, (float) a.top, (float) recyclerView.getMeasuredWidth(), (float) a.bottom, this.b);
                } else {
                }
            }
            this.b.setColor(this.a.getResources().getColor(R.color.task_list_feed_divider));
            canvas.drawRect(a, this.b);
        }
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if ((a(recyclerView.getChildViewHolder(view)) != null ? true : null) != null) {
            rect.bottom = a();
        }
    }

    @NonNull
    private Rect a(RecyclerView recyclerView, View view) {
        Rect rect = new Rect();
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        recyclerView = view.getBottom();
        if (view.getLayoutParams() instanceof MarginLayoutParams) {
            recyclerView -= ((MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        }
        rect.set(paddingLeft, recyclerView, measuredWidth, a() + recyclerView);
        return rect;
    }

    private int a() {
        return this.a.getResources().getDimensionPixelSize(R.dimen.task_list_feed_divider_height);
    }

    private static int a(ViewHolder viewHolder) {
        return viewHolder instanceof c ? ((c) viewHolder).a() : null;
    }
}
