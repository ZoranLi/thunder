package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket = new Bucket();
    final Callback mCallback;
    final List<View> mHiddenViews = new ArrayList();

    static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        Bucket() {
        }

        void set(int i) {
            if (i >= 64) {
                ensureNext();
                this.mNext.set(i - 64);
                return;
            }
            this.mData |= 1 << i;
        }

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        void clear(int i) {
            if (i < 64) {
                this.mData &= (1 << i) ^ -1;
            } else if (this.mNext != null) {
                this.mNext.clear(i - 64);
            }
        }

        boolean get(int i) {
            if (i < 64) {
                return (this.mData & (1 << i)) != 0;
            } else {
                ensureNext();
                return this.mNext.get(i - 64);
            }
        }

        void reset() {
            this.mData = 0;
            if (this.mNext != null) {
                this.mNext.reset();
            }
        }

        void insert(int i, boolean z) {
            if (i >= 64) {
                ensureNext();
                this.mNext.insert(i - 64, z);
                return;
            }
            boolean z2 = (this.mData & LAST_BIT) != 0;
            long j = (1 << i) - 1;
            this.mData = (this.mData & j) | ((this.mData & (j ^ -1)) << 1);
            if (z) {
                set(i);
            } else {
                clear(i);
            }
            if (z2 || this.mNext != 0) {
                ensureNext();
                this.mNext.insert(0, z2);
            }
        }

        boolean remove(int i) {
            if (i >= 64) {
                ensureNext();
                return this.mNext.remove(i - 64);
            }
            long j = 1 << i;
            i = (this.mData & j) != 0 ? 1 : 0;
            this.mData &= j ^ -1;
            long j2 = j - 1;
            this.mData = (this.mData & j2) | Long.rotateRight(this.mData & (j2 ^ -1), 1);
            if (this.mNext != null) {
                if (this.mNext.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return i;
        }

        int countOnesBefore(int i) {
            if (this.mNext == null) {
                if (i >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.mData & ((1 << i) - 1));
            } else {
                return this.mNext.countOnesBefore(i - 64) + Long.bitCount(this.mData);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mNext.toString());
            stringBuilder.append("xx");
            stringBuilder.append(Long.toBinaryString(this.mData));
            return stringBuilder.toString();
        }
    }

    interface Callback {
        void addView(View view, int i);

        void attachViewToParent(View view, int i, LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return null;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    void addView(View view, boolean z) {
        addView(view, -1, z);
    }

    void addView(View view, int i, boolean z) {
        if (i < 0) {
            i = this.mCallback.getChildCount();
        } else {
            i = getOffset(i);
        }
        this.mBucket.insert(i, z);
        if (z) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, i);
    }

    private int getOffset(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int countOnesBefore = i - (i2 - this.mBucket.countOnesBefore(i2));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i2) != 0) {
                    i2++;
                }
                return i2;
            }
            i2 += countOnesBefore;
        }
        return -1;
    }

    void removeView(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.mBucket.remove(indexOfChild)) {
                unhideViewInternal(view);
            }
            this.mCallback.removeViewAt(indexOfChild);
        }
    }

    void removeViewAt(int i) {
        i = getOffset(i);
        View childAt = this.mCallback.getChildAt(i);
        if (childAt != null) {
            if (this.mBucket.remove(i)) {
                unhideViewInternal(childAt);
            }
            this.mCallback.removeViewAt(i);
        }
    }

    View getChildAt(int i) {
        return this.mCallback.getChildAt(getOffset(i));
    }

    void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState((View) this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    View findHiddenNonRemovedView(int i) {
        int size = this.mHiddenViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.mHiddenViews.get(i2);
            ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return 0;
    }

    void attachViewToParent(View view, int i, LayoutParams layoutParams, boolean z) {
        if (i < 0) {
            i = this.mCallback.getChildCount();
        } else {
            i = getOffset(i);
        }
        this.mBucket.insert(i, z);
        if (z) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, i, layoutParams);
    }

    int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    View getUnfilteredChildAt(int i) {
        return this.mCallback.getChildAt(i);
    }

    void detachViewFromParent(int i) {
        i = getOffset(i);
        this.mBucket.remove(i);
        this.mCallback.detachViewFromParent(i);
    }

    int indexOfChild(View view) {
        view = this.mCallback.indexOfChild(view);
        if (view == -1 || this.mBucket.get(view)) {
            return -1;
        }
        return view - this.mBucket.countOnesBefore(view);
    }

    boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    void hide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            StringBuilder stringBuilder = new StringBuilder("view is not a child, cannot hide ");
            stringBuilder.append(view);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.mBucket.set(indexOfChild);
        hideViewInternal(view);
    }

    void unhide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        StringBuilder stringBuilder;
        if (indexOfChild < 0) {
            stringBuilder = new StringBuilder("view is not a child, cannot hide ");
            stringBuilder.append(view);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.mBucket.get(indexOfChild)) {
            this.mBucket.clear(indexOfChild);
            unhideViewInternal(view);
        } else {
            stringBuilder = new StringBuilder("trying to unhide a view that was not hidden");
            stringBuilder.append(view);
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mBucket.toString());
        stringBuilder.append(", hidden list:");
        stringBuilder.append(this.mHiddenViews.size());
        return stringBuilder.toString();
    }

    boolean removeViewIfHidden(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        } else if (!this.mBucket.get(indexOfChild)) {
            return null;
        } else {
            this.mBucket.remove(indexOfChild);
            unhideViewInternal(view);
            this.mCallback.removeViewAt(indexOfChild);
            return true;
        }
    }
}
