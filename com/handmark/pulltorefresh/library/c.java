package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;

@TargetApi(9)
/* compiled from: OverscrollHelper */
public final class c {
    public static void a(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, boolean z) {
        a(pullToRefreshBase, i, i2, i3, i4, 0, z);
    }

    public static void a(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, boolean z) {
        a(pullToRefreshBase, i, i2, i3, i4, i5, 0, 1.0f, z);
    }

    public static void a(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z) {
        if (d.a[pullToRefreshBase.getPullToRefreshScrollDirection().ordinal()] != 1) {
            i2 = i4;
            int i7 = i3;
            i3 = pullToRefreshBase.getScrollY();
            i = i7;
        } else {
            i3 = pullToRefreshBase.getScrollX();
        }
        if (pullToRefreshBase.isPullToRefreshOverScrollEnabled() != 0 && pullToRefreshBase.isRefreshing() == 0) {
            i4 = pullToRefreshBase.getMode();
            if (i4.permitsPullToRefresh() && !z && i != 0) {
                i += i2;
                if (i < 0 - i6) {
                    if (i4.showHeaderLoadingLayout() != 0) {
                        if (i3 == 0) {
                            pullToRefreshBase.setState(State.OVERSCROLLING, new boolean[0]);
                        }
                        pullToRefreshBase.setScrollValue((int) (f * ((float) (i3 + i))));
                    }
                } else if (i > i5 + i6) {
                    if (i4.showFooterLoadingLayout() != 0) {
                        if (i3 == 0) {
                            pullToRefreshBase.setState(State.OVERSCROLLING, new boolean[0]);
                        }
                        pullToRefreshBase.setScrollValue((int) (f * ((float) ((i3 + i) - i5))));
                    }
                } else if (Math.abs(i) <= i6 || Math.abs(i - i5) <= i6) {
                    pullToRefreshBase.setState(State.RESET, new boolean[0]);
                }
            } else if (z && State.OVERSCROLLING == pullToRefreshBase.getState()) {
                pullToRefreshBase.setState(State.RESET, new boolean[0]);
            }
        }
    }
}
