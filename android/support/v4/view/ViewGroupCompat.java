package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public final class ViewGroupCompat {
    static final ViewGroupCompatBaseImpl IMPL;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    static class ViewGroupCompatBaseImpl {
        public int getLayoutMode(ViewGroup viewGroup) {
            return 0;
        }

        public boolean isTransitionGroup(ViewGroup viewGroup) {
            return false;
        }

        public void setLayoutMode(ViewGroup viewGroup, int i) {
        }

        public void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        }

        ViewGroupCompatBaseImpl() {
        }

        public int getNestedScrollAxes(ViewGroup viewGroup) {
            return viewGroup instanceof NestedScrollingParent ? ((NestedScrollingParent) viewGroup).getNestedScrollAxes() : null;
        }
    }

    @RequiresApi(18)
    static class ViewGroupCompatApi18Impl extends ViewGroupCompatBaseImpl {
        ViewGroupCompatApi18Impl() {
        }

        public int getLayoutMode(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }

        public void setLayoutMode(ViewGroup viewGroup, int i) {
            viewGroup.setLayoutMode(i);
        }
    }

    @RequiresApi(21)
    static class ViewGroupCompatApi21Impl extends ViewGroupCompatApi18Impl {
        ViewGroupCompatApi21Impl() {
        }

        public void setTransitionGroup(ViewGroup viewGroup, boolean z) {
            viewGroup.setTransitionGroup(z);
        }

        public boolean isTransitionGroup(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        public int getNestedScrollAxes(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            IMPL = new ViewGroupCompatApi21Impl();
        } else if (VERSION.SDK_INT >= 18) {
            IMPL = new ViewGroupCompatApi18Impl();
        } else {
            IMPL = new ViewGroupCompatBaseImpl();
        }
    }

    private ViewGroupCompat() {
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        viewGroup.setMotionEventSplittingEnabled(z);
    }

    public static int getLayoutMode(ViewGroup viewGroup) {
        return IMPL.getLayoutMode(viewGroup);
    }

    public static void setLayoutMode(ViewGroup viewGroup, int i) {
        IMPL.setLayoutMode(viewGroup, i);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        IMPL.setTransitionGroup(viewGroup, z);
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return IMPL.isTransitionGroup(viewGroup);
    }

    public static int getNestedScrollAxes(@NonNull ViewGroup viewGroup) {
        return IMPL.getNestedScrollAxes(viewGroup);
    }
}
