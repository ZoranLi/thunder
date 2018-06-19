package com.xunlei.common.commonview.anim;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public class MovingViewAnimator {
    public static final int AUTO_MOVE = 0;
    public static final int DIAGONAL_MOVE = 3;
    public static final int HORIZONTAL_MOVE = 1;
    public static final int NONE_MOVE = -1;
    public static final int VERTICAL_MOVE = 2;
    private AnimatorListener animatorListener;
    private int currentLoop;
    private boolean infiniteRepetition;
    private boolean isRunning;
    private int loopCount;
    private AnimatorSet mAnimatorSet;
    private long mDelay;
    private Interpolator mInterpolator;
    private int mSpeed;
    private View mView;
    private int movementType;
    private float offsetHeight;
    private float offsetWidth;
    private ArrayList<Float> pathDistances;
    private AnimatorListener repeatAnimatorListener;

    public class Builder {
        private ArrayList<Animator> mList;

        private Builder() {
            this.mList = new ArrayList();
            MovingViewAnimator.this.pathDistances.clear();
        }

        public Builder addHorizontalMoveToRight() {
            this.mList.add(MovingViewAnimator.this.createHorizontalAnimator(0.0f, MovingViewAnimator.this.offsetWidth));
            return this;
        }

        public Builder addHorizontalMoveToLeft() {
            this.mList.add(MovingViewAnimator.this.createHorizontalAnimator(MovingViewAnimator.this.offsetWidth, 0.0f));
            return this;
        }

        public Builder addVerticalMoveToDown() {
            this.mList.add(MovingViewAnimator.this.createVerticalAnimator(0.0f, MovingViewAnimator.this.offsetHeight));
            return this;
        }

        public Builder addVerticalMoveToUp() {
            this.mList.add(MovingViewAnimator.this.createVerticalAnimator(MovingViewAnimator.this.offsetHeight, 0.0f));
            return this;
        }

        public Builder addDiagonalMoveToDownRight() {
            this.mList.add(MovingViewAnimator.this.createDiagonalAnimator(0.0f, MovingViewAnimator.this.offsetWidth, 0.0f, MovingViewAnimator.this.offsetHeight));
            return this;
        }

        public Builder addDiagonalMoveToDownLeft() {
            this.mList.add(MovingViewAnimator.this.createDiagonalAnimator(MovingViewAnimator.this.offsetWidth, 0.0f, 0.0f, MovingViewAnimator.this.offsetHeight));
            return this;
        }

        public Builder addDiagonalMoveToUpRight() {
            this.mList.add(MovingViewAnimator.this.createDiagonalAnimator(0.0f, MovingViewAnimator.this.offsetWidth, MovingViewAnimator.this.offsetHeight, 0.0f));
            return this;
        }

        public Builder addDiagonalMoveToUpLeft() {
            this.mList.add(MovingViewAnimator.this.createDiagonalAnimator(MovingViewAnimator.this.offsetWidth, 0.0f, MovingViewAnimator.this.offsetHeight, 0.0f));
            return this;
        }

        public void start() {
            MovingViewAnimator.this.mAnimatorSet.removeAllListeners();
            MovingViewAnimator.this.stop();
            MovingViewAnimator.this.mAnimatorSet = new AnimatorSet();
            MovingViewAnimator.this.mAnimatorSet.playSequentially(this.mList);
            MovingViewAnimator.this.updateListener();
            MovingViewAnimator.this.setUpValues();
            MovingViewAnimator.this.start();
        }
    }

    public MovingViewAnimator(View view) {
        this.infiniteRepetition = true;
        this.loopCount = -1;
        this.mSpeed = 50;
        this.mDelay = 0;
        this.repeatAnimatorListener = new AnimatorListenerAdapter() {
            public void onAnimationEnd(final Animator animator) {
                MovingViewAnimator.this.mView.post(new Runnable() {
                    public void run() {
                        if (MovingViewAnimator.this.isRunning) {
                            if (MovingViewAnimator.this.infiniteRepetition) {
                                MovingViewAnimator.this.mAnimatorSet.start();
                                if (MovingViewAnimator.this.animatorListener != null) {
                                    MovingViewAnimator.this.animatorListener.onAnimationRepeat(animator);
                                    return;
                                }
                            }
                            MovingViewAnimator.this.currentLoop = MovingViewAnimator.this.currentLoop - 1;
                            if (MovingViewAnimator.this.currentLoop > 0) {
                                MovingViewAnimator.this.mAnimatorSet.start();
                                if (MovingViewAnimator.this.animatorListener != null) {
                                    MovingViewAnimator.this.animatorListener.onAnimationRepeat(animator);
                                }
                            }
                        }
                    }
                });
            }
        };
        this.mView = view;
        this.isRunning = null;
        this.mAnimatorSet = new AnimatorSet();
        this.pathDistances = new ArrayList();
        this.mInterpolator = new AccelerateDecelerateInterpolator();
    }

    public MovingViewAnimator(View view, int i, float f, float f2) {
        this(view);
        updateValues(i, f, f2);
    }

    private void init() {
        setUpAnimator();
        updateListener();
        setUpValues();
    }

    private void setUpAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.pathDistances.clear();
        switch (this.movementType) {
            case 0:
                animatorSet.playSequentially(new Animator[]{createVerticalAnimator(0.0f, this.offsetHeight), createDiagonalAnimator(0.0f, this.offsetWidth, this.offsetHeight, 0.0f), createHorizontalAnimator(this.offsetWidth, 0.0f), createDiagonalAnimator(0.0f, this.offsetWidth, 0.0f, this.offsetHeight), createHorizontalAnimator(this.offsetWidth, 0.0f), createVerticalAnimator(this.offsetHeight, 0.0f)});
                break;
            case 1:
                animatorSet.playSequentially(new Animator[]{createHorizontalAnimator(0.0f, this.offsetWidth), createHorizontalAnimator(this.offsetWidth, 0.0f)});
                break;
            case 2:
                animatorSet.playSequentially(new Animator[]{createVerticalAnimator(0.0f, this.offsetHeight), createVerticalAnimator(this.offsetHeight, 0.0f)});
                break;
            case 3:
                animatorSet.playSequentially(new Animator[]{createDiagonalAnimator(0.0f, this.offsetWidth, 0.0f, this.offsetHeight), createDiagonalAnimator(this.offsetWidth, 0.0f, this.offsetHeight, 0.0f)});
                break;
            default:
                break;
        }
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            stop();
        }
        this.mAnimatorSet = animatorSet;
    }

    private void setUpValues() {
        addListener(this.animatorListener);
        setSpeed(this.mSpeed);
        setStartDelay(this.mDelay);
        setRepetition(this.loopCount);
        setInterpolator(this.mInterpolator);
    }

    private void updateListener() {
        this.mAnimatorSet.addListener(this.repeatAnimatorListener);
    }

    public void updateValues(int i, float f, float f2) {
        this.movementType = i;
        this.offsetWidth = f;
        this.offsetHeight = f2;
        init();
    }

    public void setMovementType(int i) {
        updateValues(i, this.offsetWidth, this.offsetHeight);
    }

    public void setOffsets(float f, float f2) {
        updateValues(this.movementType, f, f2);
    }

    public void start() {
        if (this.movementType != -1) {
            this.isRunning = true;
            if (!this.infiniteRepetition) {
                this.currentLoop = this.loopCount;
            }
            this.mAnimatorSet.start();
        }
    }

    public void cancel() {
        if (this.isRunning) {
            this.mAnimatorSet.removeListener(this.repeatAnimatorListener);
            this.mAnimatorSet.cancel();
        }
    }

    @TargetApi(19)
    public void pause() {
        if (VERSION.SDK_INT >= 19 && this.mAnimatorSet.isStarted()) {
            this.mAnimatorSet.pause();
        }
    }

    @TargetApi(19)
    public void resume() {
        if (VERSION.SDK_INT >= 19 && this.mAnimatorSet.isPaused()) {
            this.mAnimatorSet.resume();
        }
    }

    public void stop() {
        this.isRunning = false;
        this.mAnimatorSet.removeListener(this.repeatAnimatorListener);
        this.mAnimatorSet.end();
        this.mView.clearAnimation();
    }

    public void setRepetition(int i) {
        if (i < 0) {
            this.infiniteRepetition = true;
            return;
        }
        this.loopCount = i;
        this.currentLoop = this.loopCount;
        this.infiniteRepetition = false;
    }

    public Builder addCustomMovement() {
        return new Builder();
    }

    public void clearCustomMovement() {
        init();
        start();
    }

    public int getMovementType() {
        return this.movementType;
    }

    public int getRemainingRepetitions() {
        return this.infiniteRepetition ? -1 : this.currentLoop;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
        this.mAnimatorSet.setInterpolator(interpolator);
    }

    public void setStartDelay(long j) {
        this.mDelay = j;
        this.mAnimatorSet.setStartDelay(j);
    }

    public void setSpeed(int i) {
        this.mSpeed = i;
        i = this.mAnimatorSet.getChildAnimations();
        for (int i2 = 0; i2 < i.size(); i2++) {
            ((Animator) i.get(i2)).setDuration(parseSpeed(((Float) this.pathDistances.get(i2)).floatValue()));
        }
    }

    public void addListener(AnimatorListener animatorListener) {
        clearListener();
        if (animatorListener != null) {
            this.animatorListener = animatorListener;
            this.mAnimatorSet.addListener(this.animatorListener);
        }
    }

    public void clearListener() {
        if (this.animatorListener != null) {
            this.mAnimatorSet.removeListener(this.animatorListener);
            this.animatorListener = null;
        }
    }

    private long parseSpeed(float f) {
        return (long) ((f / ((float) this.mSpeed)) * 1000.0f);
    }

    private ObjectAnimator createHorizontalAnimator(float f, float f2) {
        this.pathDistances.add(Float.valueOf(Math.abs(f - f2)));
        return createObjectAnimation("scrollX", f, f2);
    }

    private ObjectAnimator createVerticalAnimator(float f, float f2) {
        this.pathDistances.add(Float.valueOf(Math.abs(f - f2)));
        return createObjectAnimation("scrollY", f, f2);
    }

    private ObjectAnimator createDiagonalAnimator(float f, float f2, float f3, float f4) {
        this.pathDistances.add(Float.valueOf(Pythagoras(Math.abs(f - f2), Math.abs(f3 - f4))));
        f = createPropertyValuesHolder("scrollX", f, f2);
        f2 = createPropertyValuesHolder("scrollY", f3, f4);
        return ObjectAnimator.ofPropertyValuesHolder(this.mView, new PropertyValuesHolder[]{f, f2});
    }

    private ObjectAnimator createObjectAnimation(String str, float f, float f2) {
        return ObjectAnimator.ofInt(this.mView, str, new int[]{(int) f, (int) f2});
    }

    private PropertyValuesHolder createPropertyValuesHolder(String str, float f, float f2) {
        return PropertyValuesHolder.ofInt(str, new int[]{(int) f, (int) f2});
    }

    private static float Pythagoras(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }
}
