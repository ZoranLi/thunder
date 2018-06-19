package com.facebook.rebound;

public class SteppingLooper extends SpringLooper {
    private long mLastTime;
    private boolean mStarted;

    public void start() {
        this.mStarted = true;
        this.mLastTime = 0;
    }

    public boolean step(long j) {
        if (this.mSpringSystem != null) {
            if (this.mStarted) {
                long j2 = this.mLastTime + j;
                this.mSpringSystem.loop((double) j2);
                this.mLastTime = j2;
                return this.mSpringSystem.getIsIdle();
            }
        }
        return 0;
    }

    public void stop() {
        this.mStarted = false;
    }
}
