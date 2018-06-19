package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.xlui.recyclerview.LoadingMoreFooterView;

/* compiled from: MessageCenterItemDecoration */
public final class n extends ItemDecoration {
    private Paint a;

    public n() {
        this.a = null;
        this.a = new Paint(1);
        this.a.setColor(BrothersApplication.getApplicationInstance().getResources().getColor(R.color.search_line_color));
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        super.onDraw(canvas, recyclerView, state);
        state = recyclerView.getChildCount();
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        for (int i = 0; i < state; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (!(childAt.getVisibility() == 8 || (childAt instanceof LoadingMoreFooterView))) {
                int bottom = childAt.getBottom() - ((MarginLayoutParams) childAt.getLayoutParams()).bottomMargin;
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) (bottom + 1), this.a);
            }
        }
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, 1);
    }
}
