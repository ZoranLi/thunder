package com.facebook.rebound;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class Spring {
    private static int ID = 0;
    private static final double MAX_DELTA_TIME_SEC = 0.064d;
    private static final double SOLVER_TIMESTEP_SEC = 0.001d;
    private final PhysicsState mCurrentState = new PhysicsState();
    private double mDisplacementFromRestThreshold = 0.005d;
    private double mEndValue;
    private final String mId;
    private CopyOnWriteArraySet<SpringListener> mListeners = new CopyOnWriteArraySet();
    private boolean mOvershootClampingEnabled;
    private final PhysicsState mPreviousState = new PhysicsState();
    private double mRestSpeedThreshold = 0.005d;
    private SpringConfig mSpringConfig;
    private final BaseSpringSystem mSpringSystem;
    private double mStartValue;
    private final PhysicsState mTempState = new PhysicsState();
    private double mTimeAccumulator = 0.0d;
    private boolean mWasAtRest = true;

    private static class PhysicsState {
        double position;
        double velocity;

        private PhysicsState() {
        }
    }

    Spring(BaseSpringSystem baseSpringSystem) {
        if (baseSpringSystem == null) {
            throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
        }
        this.mSpringSystem = baseSpringSystem;
        baseSpringSystem = new StringBuilder("spring:");
        int i = ID;
        ID = i + 1;
        baseSpringSystem.append(i);
        this.mId = baseSpringSystem.toString();
        setSpringConfig(SpringConfig.defaultConfig);
    }

    public void destroy() {
        this.mListeners.clear();
        this.mSpringSystem.deregisterSpring(this);
    }

    public String getId() {
        return this.mId;
    }

    public Spring setSpringConfig(SpringConfig springConfig) {
        if (springConfig == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        this.mSpringConfig = springConfig;
        return this;
    }

    public SpringConfig getSpringConfig() {
        return this.mSpringConfig;
    }

    public Spring setCurrentValue(double d) {
        return setCurrentValue(d, true);
    }

    public Spring setCurrentValue(double d, boolean z) {
        this.mStartValue = d;
        this.mCurrentState.position = d;
        this.mSpringSystem.activateSpring(getId());
        d = this.mListeners.iterator();
        while (d.hasNext()) {
            ((SpringListener) d.next()).onSpringUpdate(this);
        }
        if (z) {
            setAtRest();
        }
        return this;
    }

    public double getStartValue() {
        return this.mStartValue;
    }

    public double getCurrentValue() {
        return this.mCurrentState.position;
    }

    public double getCurrentDisplacementDistance() {
        return getDisplacementDistanceForState(this.mCurrentState);
    }

    private double getDisplacementDistanceForState(PhysicsState physicsState) {
        return Math.abs(this.mEndValue - physicsState.position);
    }

    public Spring setEndValue(double d) {
        if (this.mEndValue == d && isAtRest()) {
            return this;
        }
        this.mStartValue = getCurrentValue();
        this.mEndValue = d;
        this.mSpringSystem.activateSpring(getId());
        d = this.mListeners.iterator();
        while (d.hasNext()) {
            ((SpringListener) d.next()).onSpringEndStateChange(this);
        }
        return this;
    }

    public double getEndValue() {
        return this.mEndValue;
    }

    public Spring setVelocity(double d) {
        if (d == this.mCurrentState.velocity) {
            return this;
        }
        this.mCurrentState.velocity = d;
        this.mSpringSystem.activateSpring(getId());
        return this;
    }

    public double getVelocity() {
        return this.mCurrentState.velocity;
    }

    public Spring setRestSpeedThreshold(double d) {
        this.mRestSpeedThreshold = d;
        return this;
    }

    public double getRestSpeedThreshold() {
        return this.mRestSpeedThreshold;
    }

    public Spring setRestDisplacementThreshold(double d) {
        this.mDisplacementFromRestThreshold = d;
        return this;
    }

    public double getRestDisplacementThreshold() {
        return this.mDisplacementFromRestThreshold;
    }

    public Spring setOvershootClampingEnabled(boolean z) {
        this.mOvershootClampingEnabled = z;
        return this;
    }

    public boolean isOvershootClampingEnabled() {
        return this.mOvershootClampingEnabled;
    }

    public boolean isOvershooting() {
        return this.mSpringConfig.tension > 0.0d && ((this.mStartValue < this.mEndValue && getCurrentValue() > this.mEndValue) || (this.mStartValue > this.mEndValue && getCurrentValue() < this.mEndValue));
    }

    void advance(double d) {
        Spring spring = this;
        boolean isAtRest = isAtRest();
        if (!isAtRest || !spring.mWasAtRest) {
            boolean z;
            double d2 = MAX_DELTA_TIME_SEC;
            if (d <= MAX_DELTA_TIME_SEC) {
                d2 = d;
            }
            spring.mTimeAccumulator += d2;
            d2 = spring.mSpringConfig.tension;
            double d3 = spring.mSpringConfig.friction;
            double d4 = spring.mCurrentState.position;
            double d5 = spring.mCurrentState.velocity;
            double d6 = spring.mTempState.position;
            double d7 = spring.mTempState.velocity;
            while (spring.mTimeAccumulator >= SOLVER_TIMESTEP_SEC) {
                spring.mTimeAccumulator -= SOLVER_TIMESTEP_SEC;
                if (spring.mTimeAccumulator < SOLVER_TIMESTEP_SEC) {
                    spring.mPreviousState.position = d4;
                    spring.mPreviousState.velocity = d5;
                }
                d7 = ((spring.mEndValue - d6) * d2) - (d3 * d5);
                double d8 = d5 + ((d7 * SOLVER_TIMESTEP_SEC) * 0.5d);
                double d9 = ((spring.mEndValue - (((d5 * SOLVER_TIMESTEP_SEC) * 0.5d) + d4)) * d2) - (d3 * d8);
                double d10 = d5 + ((d9 * SOLVER_TIMESTEP_SEC) * 0.5d);
                double d11 = d7;
                d7 = ((spring.mEndValue - (((d8 * SOLVER_TIMESTEP_SEC) * 0.5d) + d4)) * d2) - (d3 * d10);
                d6 = (d10 * SOLVER_TIMESTEP_SEC) + d4;
                double d12 = d5 + (d7 * SOLVER_TIMESTEP_SEC);
                d4 += (((d5 + ((d8 + d10) * 2.0d)) + d12) * 0.16666666666666666d) * SOLVER_TIMESTEP_SEC;
                d5 += (0.16666666666666666d * ((d11 + (2.0d * (d9 + d7))) + (((spring.mEndValue - d6) * d2) - (d3 * d12)))) * SOLVER_TIMESTEP_SEC;
                d7 = d12;
            }
            double d13 = d4;
            spring.mTempState.position = d6;
            spring.mTempState.velocity = d7;
            spring.mCurrentState.position = d4;
            spring.mCurrentState.velocity = d5;
            if (spring.mTimeAccumulator > 0.0d) {
                interpolate(spring.mTimeAccumulator / SOLVER_TIMESTEP_SEC);
            }
            if (isAtRest() || (spring.mOvershootClampingEnabled && isOvershooting())) {
                if (d2 > 0.0d) {
                    spring.mStartValue = spring.mEndValue;
                    spring.mCurrentState.position = spring.mEndValue;
                } else {
                    spring.mEndValue = spring.mCurrentState.position;
                    spring.mStartValue = spring.mEndValue;
                }
                setVelocity(0.0d);
                isAtRest = true;
            }
            boolean z2 = false;
            if (spring.mWasAtRest) {
                spring.mWasAtRest = false;
                z = true;
            } else {
                z = false;
            }
            if (isAtRest) {
                spring.mWasAtRest = true;
                z2 = true;
            }
            Iterator it = spring.mListeners.iterator();
            while (it.hasNext()) {
                SpringListener springListener = (SpringListener) it.next();
                if (z) {
                    springListener.onSpringActivate(spring);
                }
                springListener.onSpringUpdate(spring);
                if (z2) {
                    springListener.onSpringAtRest(spring);
                }
            }
        }
    }

    public boolean systemShouldAdvance() {
        if (isAtRest()) {
            if (wasAtRest()) {
                return false;
            }
        }
        return true;
    }

    public boolean wasAtRest() {
        return this.mWasAtRest;
    }

    public boolean isAtRest() {
        return Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold && (getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold || this.mSpringConfig.tension == 0.0d);
    }

    public Spring setAtRest() {
        this.mEndValue = this.mCurrentState.position;
        this.mTempState.position = this.mCurrentState.position;
        this.mCurrentState.velocity = 0.0d;
        return this;
    }

    private void interpolate(double d) {
        double d2 = 1.0d - d;
        this.mCurrentState.position = (this.mCurrentState.position * d) + (this.mPreviousState.position * d2);
        this.mCurrentState.velocity = (this.mCurrentState.velocity * d) + (this.mPreviousState.velocity * d2);
    }

    public Spring addListener(SpringListener springListener) {
        if (springListener == null) {
            throw new IllegalArgumentException("newListener is required");
        }
        this.mListeners.add(springListener);
        return this;
    }

    public Spring removeListener(SpringListener springListener) {
        if (springListener == null) {
            throw new IllegalArgumentException("listenerToRemove is required");
        }
        this.mListeners.remove(springListener);
        return this;
    }

    public Spring removeAllListeners() {
        this.mListeners.clear();
        return this;
    }

    public boolean currentValueIsApproximately(double d) {
        return Math.abs(getCurrentValue() - d) <= getRestDisplacementThreshold() ? Double.MIN_VALUE : 0.0d;
    }
}
