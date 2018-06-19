package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

final class StateListAnimator {
    private final AnimatorListener mAnimationListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            if (StateListAnimator.this.mRunningAnimator == animator) {
                StateListAnimator.this.mRunningAnimator = null;
            }
        }
    };
    private Tuple mLastMatch = null;
    ValueAnimator mRunningAnimator = null;
    private final ArrayList<Tuple> mTuples = new ArrayList();

    static class Tuple {
        final ValueAnimator mAnimator;
        final int[] mSpecs;

        Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.mSpecs = iArr;
            this.mAnimator = valueAnimator;
        }
    }

    StateListAnimator() {
    }

    public final void addState(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.mAnimationListener);
        this.mTuples.add(tuple);
    }

    final void setState(int[] iArr) {
        Tuple tuple;
        int size = this.mTuples.size();
        for (int i = 0; i < size; i++) {
            tuple = (Tuple) this.mTuples.get(i);
            if (StateSet.stateSetMatches(tuple.mSpecs, iArr)) {
                break;
            }
        }
        tuple = null;
        if (tuple != this.mLastMatch) {
            if (this.mLastMatch != null) {
                cancel();
            }
            this.mLastMatch = tuple;
            if (tuple != null) {
                start(tuple);
            }
        }
    }

    private void start(Tuple tuple) {
        this.mRunningAnimator = tuple.mAnimator;
        this.mRunningAnimator.start();
    }

    private void cancel() {
        if (this.mRunningAnimator != null) {
            this.mRunningAnimator.cancel();
            this.mRunningAnimator = null;
        }
    }

    public final void jumpToCurrentState() {
        if (this.mRunningAnimator != null) {
            this.mRunningAnimator.end();
            this.mRunningAnimator = null;
        }
    }
}
