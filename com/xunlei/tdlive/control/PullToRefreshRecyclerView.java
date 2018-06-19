package com.xunlei.tdlive.control;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.xunlei.tdlive.sdk.R;

public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {
    protected /* synthetic */ View createRefreshableView(Context context, AttributeSet attributeSet) {
        return a(context, attributeSet);
    }

    public PullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    protected RecyclerView a(Context context, AttributeSet attributeSet) {
        return (RecyclerView) LayoutInflater.from(context).inflate(R.layout.xllive_view_vetical_scrollbar_recyclerview, null);
    }

    protected boolean isReadyForPullStart() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.getRefreshableView();
        r0 = (android.support.v7.widget.RecyclerView) r0;
        r0 = r0.getChildCount();
        r1 = 1;
        if (r0 > 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = 0;
        r2 = r4.getRefreshableView();	 Catch:{ Throwable -> 0x0041 }
        r2 = (android.support.v7.widget.RecyclerView) r2;	 Catch:{ Throwable -> 0x0041 }
        r3 = r4.getRefreshableView();	 Catch:{ Throwable -> 0x0041 }
        r3 = (android.support.v7.widget.RecyclerView) r3;	 Catch:{ Throwable -> 0x0041 }
        r3 = r3.getChildAt(r0);	 Catch:{ Throwable -> 0x0041 }
        r2 = r2.getChildAdapterPosition(r3);	 Catch:{ Throwable -> 0x0041 }
        if (r2 != 0) goto L_0x0041;	 Catch:{ Throwable -> 0x0041 }
    L_0x0025:
        r2 = r4.getRefreshableView();	 Catch:{ Throwable -> 0x0041 }
        r2 = (android.support.v7.widget.RecyclerView) r2;	 Catch:{ Throwable -> 0x0041 }
        r2 = r2.getChildAt(r0);	 Catch:{ Throwable -> 0x0041 }
        r2 = r2.getTop();	 Catch:{ Throwable -> 0x0041 }
        r3 = r4.getRefreshableView();	 Catch:{ Throwable -> 0x0041 }
        r3 = (android.support.v7.widget.RecyclerView) r3;	 Catch:{ Throwable -> 0x0041 }
        r3 = r3.getPaddingTop();	 Catch:{ Throwable -> 0x0041 }
        if (r2 != r3) goto L_0x0040;
    L_0x003f:
        return r1;
    L_0x0040:
        return r0;
    L_0x0041:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.control.PullToRefreshRecyclerView.isReadyForPullStart():boolean");
    }

    protected boolean isReadyForPullEnd() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.getRefreshableView();	 Catch:{ Throwable -> 0x0059 }
        r1 = (android.support.v7.widget.RecyclerView) r1;	 Catch:{ Throwable -> 0x0059 }
        r2 = r5.getRefreshableView();	 Catch:{ Throwable -> 0x0059 }
        r2 = (android.support.v7.widget.RecyclerView) r2;	 Catch:{ Throwable -> 0x0059 }
        r3 = r5.getRefreshableView();	 Catch:{ Throwable -> 0x0059 }
        r3 = (android.support.v7.widget.RecyclerView) r3;	 Catch:{ Throwable -> 0x0059 }
        r3 = r3.getChildCount();	 Catch:{ Throwable -> 0x0059 }
        r4 = 1;	 Catch:{ Throwable -> 0x0059 }
        r3 = r3 - r4;	 Catch:{ Throwable -> 0x0059 }
        r2 = r2.getChildAt(r3);	 Catch:{ Throwable -> 0x0059 }
        r1 = r1.getChildAdapterPosition(r2);	 Catch:{ Throwable -> 0x0059 }
        r2 = r5.getRefreshableView();	 Catch:{ Throwable -> 0x0059 }
        r2 = (android.support.v7.widget.RecyclerView) r2;	 Catch:{ Throwable -> 0x0059 }
        r2 = r2.getAdapter();	 Catch:{ Throwable -> 0x0059 }
        r2 = r2.getItemCount();	 Catch:{ Throwable -> 0x0059 }
        r2 = r2 - r4;	 Catch:{ Throwable -> 0x0059 }
        if (r1 < r2) goto L_0x0059;	 Catch:{ Throwable -> 0x0059 }
    L_0x0032:
        r1 = r5.getRefreshableView();	 Catch:{ Throwable -> 0x0059 }
        r1 = (android.support.v7.widget.RecyclerView) r1;	 Catch:{ Throwable -> 0x0059 }
        r2 = r5.getRefreshableView();	 Catch:{ Throwable -> 0x0059 }
        r2 = (android.support.v7.widget.RecyclerView) r2;	 Catch:{ Throwable -> 0x0059 }
        r2 = r2.getChildCount();	 Catch:{ Throwable -> 0x0059 }
        r2 = r2 - r4;	 Catch:{ Throwable -> 0x0059 }
        r1 = r1.getChildAt(r2);	 Catch:{ Throwable -> 0x0059 }
        r1 = r1.getBottom();	 Catch:{ Throwable -> 0x0059 }
        r2 = r5.getRefreshableView();	 Catch:{ Throwable -> 0x0059 }
        r2 = (android.support.v7.widget.RecyclerView) r2;	 Catch:{ Throwable -> 0x0059 }
        r2 = r2.getBottom();	 Catch:{ Throwable -> 0x0059 }
        if (r1 > r2) goto L_0x0058;
    L_0x0057:
        return r4;
    L_0x0058:
        return r0;
    L_0x0059:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.control.PullToRefreshRecyclerView.isReadyForPullEnd():boolean");
    }
}
