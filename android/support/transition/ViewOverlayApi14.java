package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

@RequiresApi(14)
class ViewOverlayApi14 implements ViewOverlayImpl {
    protected OverlayViewGroup mOverlayViewGroup;

    static class OverlayViewGroup extends ViewGroup {
        static Method sInvalidateChildInParentFastMethod;
        ArrayList<Drawable> mDrawables = null;
        ViewGroup mHostView;
        View mRequestingView;
        ViewOverlayApi14 mViewOverlay;

        static class TouchInterceptor extends View {
            TouchInterceptor(Context context) {
                super(context);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = android.view.ViewGroup.class;	 Catch:{ NoSuchMethodException -> 0x001d }
            r1 = "invalidateChildInParentFast";	 Catch:{ NoSuchMethodException -> 0x001d }
            r2 = 3;	 Catch:{ NoSuchMethodException -> 0x001d }
            r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001d }
            r3 = 0;	 Catch:{ NoSuchMethodException -> 0x001d }
            r4 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x001d }
            r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x001d }
            r3 = 1;	 Catch:{ NoSuchMethodException -> 0x001d }
            r4 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x001d }
            r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x001d }
            r3 = 2;	 Catch:{ NoSuchMethodException -> 0x001d }
            r4 = android.graphics.Rect.class;	 Catch:{ NoSuchMethodException -> 0x001d }
            r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x001d }
            r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x001d }
            sInvalidateChildInParentFastMethod = r0;	 Catch:{ NoSuchMethodException -> 0x001d }
            return;
        L_0x001d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewOverlayApi14.OverlayViewGroup.<clinit>():void");
        }

        OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.mHostView = viewGroup;
            this.mRequestingView = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.mViewOverlay = viewOverlayApi14;
        }

        public void add(Drawable drawable) {
            if (this.mDrawables == null) {
                this.mDrawables = new ArrayList();
            }
            if (!this.mDrawables.contains(drawable)) {
                this.mDrawables.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void remove(Drawable drawable) {
            if (this.mDrawables != null) {
                this.mDrawables.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        protected boolean verifyDrawable(@NonNull Drawable drawable) {
            if (!super.verifyDrawable(drawable)) {
                if (this.mDrawables == null || this.mDrawables.contains(drawable) == null) {
                    return null;
                }
            }
            return true;
        }

        public void add(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.mHostView || viewGroup.getParent() == null || !ViewCompat.isAttachedToWindow(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.mHostView.getLocationOnScreen(iArr2);
                    ViewCompat.offsetLeftAndRight(view, iArr[0] - iArr2[0]);
                    ViewCompat.offsetTopAndBottom(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        public void remove(View view) {
            super.removeView(view);
            if (isEmpty() != null) {
                this.mHostView.removeView(this);
            }
        }

        public void clear() {
            removeAllViews();
            if (this.mDrawables != null) {
                this.mDrawables.clear();
            }
        }

        boolean isEmpty() {
            return getChildCount() == 0 && (this.mDrawables == null || this.mDrawables.size() == 0);
        }

        public void invalidateDrawable(@NonNull Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.mHostView.getLocationOnScreen(iArr);
            this.mRequestingView.getLocationOnScreen(iArr2);
            int i = 0;
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.mRequestingView.getWidth(), this.mRequestingView.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.mDrawables == null ? 0 : this.mDrawables.size();
            while (i < size) {
                ((Drawable) this.mDrawables.get(i)).draw(canvas);
                i++;
            }
        }

        private void getOffset(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.mHostView.getLocationOnScreen(iArr2);
            this.mRequestingView.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void invalidateChildFast(View view, Rect rect) {
            if (this.mHostView != null) {
                int left = view.getLeft();
                view = view.getTop();
                int[] iArr = new int[2];
                getOffset(iArr);
                rect.offset(left + iArr[0], view + iArr[1]);
                this.mHostView.invalidate(rect);
            }
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        protected ViewParent invalidateChildInParentFast(int i, int i2, Rect rect) {
            if ((this.mHostView instanceof ViewGroup) && sInvalidateChildInParentFastMethod != null) {
                try {
                    getOffset(new int[2]);
                    sInvalidateChildInParentFastMethod.invoke(this.mHostView, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), rect});
                } catch (int i3) {
                    i3.printStackTrace();
                } catch (int i32) {
                    i32.printStackTrace();
                }
            }
            return 0;
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.mHostView != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.mHostView instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    getOffset(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }
    }

    ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.mOverlayViewGroup = new OverlayViewGroup(context, viewGroup, view, this);
    }

    static ViewGroup getContentView(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    static ViewOverlayApi14 createFrom(View view) {
        ViewGroup contentView = getContentView(view);
        if (contentView == null) {
            return null;
        }
        int childCount = contentView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = contentView.getChildAt(i);
            if (childAt instanceof OverlayViewGroup) {
                return ((OverlayViewGroup) childAt).mViewOverlay;
            }
        }
        return new ViewGroupOverlayApi14(contentView.getContext(), contentView, view);
    }

    ViewGroup getOverlayView() {
        return this.mOverlayViewGroup;
    }

    public void add(@NonNull Drawable drawable) {
        this.mOverlayViewGroup.add(drawable);
    }

    public void clear() {
        this.mOverlayViewGroup.clear();
    }

    public void remove(@NonNull Drawable drawable) {
        this.mOverlayViewGroup.remove(drawable);
    }

    boolean isEmpty() {
        return this.mOverlayViewGroup.isEmpty();
    }
}
