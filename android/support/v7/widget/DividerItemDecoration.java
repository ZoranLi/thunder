package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class DividerItemDecoration extends ItemDecoration {
    private static final int[] ATTRS = new int[]{16843284};
    public static final int HORIZONTAL = 0;
    private static final String TAG = "DividerItem";
    public static final int VERTICAL = 1;
    private final Rect mBounds = new Rect();
    private Drawable mDivider;
    private int mOrientation;

    public DividerItemDecoration(Context context, int i) {
        context = context.obtainStyledAttributes(ATTRS);
        this.mDivider = context.getDrawable(0);
        context.recycle();
        setOrientation(i);
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            this.mOrientation = i;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    public void setDrawable(@NonNull Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.mDivider = drawable;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        if (recyclerView.getLayoutManager() != null) {
            if (this.mDivider != null) {
                if (this.mOrientation == 1) {
                    drawVertical(canvas, recyclerView);
                } else {
                    drawHorizontal(canvas, recyclerView);
                }
            }
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft;
        int width;
        canvas.save();
        int i = 0;
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        int childCount = recyclerView.getChildCount();
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
            int round = this.mBounds.bottom + Math.round(childAt.getTranslationY());
            this.mDivider.setBounds(paddingLeft, round - this.mDivider.getIntrinsicHeight(), width, round);
            this.mDivider.draw(canvas);
            i++;
        }
        canvas.restore();
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop;
        int height;
        canvas.save();
        int i = 0;
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount = recyclerView.getChildCount();
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.mBounds);
            int round = this.mBounds.right + Math.round(childAt.getTranslationX());
            this.mDivider.setBounds(round - this.mDivider.getIntrinsicWidth(), paddingTop, round, height);
            this.mDivider.draw(canvas);
            i++;
        }
        canvas.restore();
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        if (this.mDivider == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.mOrientation == 1) {
            rect.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.mDivider.getIntrinsicWidth(), 0);
        }
    }
}
