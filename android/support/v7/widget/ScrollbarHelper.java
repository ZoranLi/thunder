package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class ScrollbarHelper {
    ScrollbarHelper() {
    }

    static int computeScrollOffset(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z, boolean z2) {
        if (!(layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null)) {
            if (view2 != null) {
                int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
                int max = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
                if (z2) {
                    state = Math.max(0, (state.getItemCount() - max) - 1);
                } else {
                    state = Math.max(0, min);
                }
                if (!z) {
                    return state;
                }
                return Math.round((((float) state) * (((float) Math.abs(orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)))) + ((float) (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view))));
            }
        }
        return 0;
    }

    static int computeScrollExtent(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (!(layoutManager.getChildCount() == 0 || state.getItemCount() == null || view == null)) {
            if (view2 != null) {
                if (!z) {
                    return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
                }
                return Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view));
            }
        }
        return null;
    }

    static int computeScrollRange(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (!(layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null)) {
            if (view2 != null) {
                if (!z) {
                    return state.getItemCount();
                }
                return (int) ((((float) (orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) * ((float) state.getItemCount()));
            }
        }
        return null;
    }
}
