package com.bumptech.glide.request.target;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import com.bumptech.glide.request.Request;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    private static final String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce = false;
    private static Integer tagId;
    private final SizeDeterminer sizeDeterminer;
    protected final T view;

    private static class SizeDeterminer {
        private static final int PENDING_SIZE = 0;
        private final List<SizeReadyCallback> cbs = new ArrayList();
        private Point displayDimens;
        private SizeDeterminerLayoutListener layoutListener;
        private final View view;

        private static class SizeDeterminerLayoutListener implements OnPreDrawListener {
            private final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.sizeDeterminerRef = new WeakReference(sizeDeterminer);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    new StringBuilder("OnGlobalLayoutListener called listener=").append(this);
                }
                SizeDeterminer sizeDeterminer = (SizeDeterminer) this.sizeDeterminerRef.get();
                if (sizeDeterminer != null) {
                    sizeDeterminer.checkCurrentDimens();
                }
                return true;
            }
        }

        private boolean isSizeValid(int i) {
            if (i <= 0) {
                if (i != -2) {
                    return false;
                }
            }
            return true;
        }

        public SizeDeterminer(View view) {
            this.view = view;
        }

        private void notifyCbs(int i, int i2) {
            for (SizeReadyCallback onSizeReady : this.cbs) {
                onSizeReady.onSizeReady(i, i2);
            }
            this.cbs.clear();
        }

        private void checkCurrentDimens() {
            if (!this.cbs.isEmpty()) {
                int viewWidthOrParam = getViewWidthOrParam();
                int viewHeightOrParam = getViewHeightOrParam();
                if (isSizeValid(viewWidthOrParam)) {
                    if (isSizeValid(viewHeightOrParam)) {
                        notifyCbs(viewWidthOrParam, viewHeightOrParam);
                        ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
                        }
                        this.layoutListener = null;
                    }
                }
            }
        }

        public void getSize(SizeReadyCallback sizeReadyCallback) {
            int viewWidthOrParam = getViewWidthOrParam();
            int viewHeightOrParam = getViewHeightOrParam();
            if (isSizeValid(viewWidthOrParam) && isSizeValid(viewHeightOrParam)) {
                sizeReadyCallback.onSizeReady(viewWidthOrParam, viewHeightOrParam);
                return;
            }
            if (!this.cbs.contains(sizeReadyCallback)) {
                this.cbs.add(sizeReadyCallback);
            }
            if (this.layoutListener == null) {
                sizeReadyCallback = this.view.getViewTreeObserver();
                this.layoutListener = new SizeDeterminerLayoutListener(this);
                sizeReadyCallback.addOnPreDrawListener(this.layoutListener);
            }
        }

        private int getViewHeightOrParam() {
            LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getHeight())) {
                return this.view.getHeight();
            }
            return layoutParams != null ? getSizeForParam(layoutParams.height, true) : 0;
        }

        private int getViewWidthOrParam() {
            LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getWidth())) {
                return this.view.getWidth();
            }
            if (layoutParams != null) {
                return getSizeForParam(layoutParams.width, false);
            }
            return 0;
        }

        private int getSizeForParam(int i, boolean z) {
            if (i != -2) {
                return i;
            }
            i = getDisplayDimens();
            return z ? i.y : i.x;
        }

        @TargetApi(13)
        private Point getDisplayDimens() {
            if (this.displayDimens != null) {
                return this.displayDimens;
            }
            Display defaultDisplay = ((WindowManager) this.view.getContext().getSystemService("window")).getDefaultDisplay();
            if (VERSION.SDK_INT >= 13) {
                this.displayDimens = new Point();
                defaultDisplay.getSize(this.displayDimens);
            } else {
                this.displayDimens = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            }
            return this.displayDimens;
        }
    }

    public static void setTagId(int i) {
        if (tagId == null) {
            if (!isTagUsedAtLeastOnce) {
                tagId = Integer.valueOf(i);
                return;
            }
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    public ViewTarget(T t) {
        if (t == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.view = t;
        this.sizeDeterminer = new SizeDeterminer(t);
    }

    public T getView() {
        return this.view;
    }

    public void getSize(SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }

    public void setRequest(Request request) {
        setTag(request);
    }

    public Request getRequest() {
        Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof Request) {
            return (Request) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    private void setTag(Object obj) {
        if (tagId == null) {
            isTagUsedAtLeastOnce = true;
            this.view.setTag(obj);
            return;
        }
        this.view.setTag(tagId.intValue(), obj);
    }

    private Object getTag() {
        if (tagId == null) {
            return this.view.getTag();
        }
        return this.view.getTag(tagId.intValue());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Target for: ");
        stringBuilder.append(this.view);
        return stringBuilder.toString();
    }
}
