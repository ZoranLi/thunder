package com.xunlei.downloadprovider.download.engine.task.info;

import java.io.Serializable;

public class TaskCountsStatistics implements Serializable {
    private static final long serialVersionUID = 1;
    public int mFailedCount = 0;
    public int mPausedCount = 0;
    public int mRunningCount = 0;
    public int mSuccessCount = 0;
    public int mTotalCount = 0;
    public int mUnfinishedNoCopyRightProblemCount = 0;
    public int mUnfinishedUnIllegalCount = 0;

    public TaskCountsStatistics(TaskCountsStatistics taskCountsStatistics) {
        copyFrom(taskCountsStatistics);
    }

    public void copyFrom(TaskCountsStatistics taskCountsStatistics) {
        this.mTotalCount = taskCountsStatistics.mTotalCount;
        this.mSuccessCount = taskCountsStatistics.mSuccessCount;
        this.mRunningCount = taskCountsStatistics.mRunningCount;
        this.mPausedCount = taskCountsStatistics.mPausedCount;
        this.mFailedCount = taskCountsStatistics.mFailedCount;
        this.mUnfinishedUnIllegalCount = taskCountsStatistics.mUnfinishedUnIllegalCount;
        this.mUnfinishedNoCopyRightProblemCount = taskCountsStatistics.mUnfinishedNoCopyRightProblemCount;
    }

    public TaskCountsStatistics() {
        reset();
    }

    public void reset() {
        this.mTotalCount = 0;
        this.mSuccessCount = 0;
        this.mRunningCount = 0;
        this.mPausedCount = 0;
        this.mFailedCount = 0;
        this.mUnfinishedUnIllegalCount = 0;
        this.mUnfinishedNoCopyRightProblemCount = 0;
    }

    public int getFinishedTaskCount() {
        return this.mSuccessCount;
    }

    public int getRunningCount() {
        return this.mRunningCount;
    }

    public int getFailedCount() {
        return this.mFailedCount;
    }

    public int getPausedCount() {
        return this.mPausedCount;
    }

    public int getUnfinishedTaskCount() {
        return (this.mRunningCount + this.mPausedCount) + this.mFailedCount;
    }

    public int getUnfinishedUnIllegalCount() {
        return this.mUnfinishedUnIllegalCount;
    }

    public int getUnfinishedNoCopyRightProblemCount() {
        return this.mUnfinishedNoCopyRightProblemCount;
    }

    public TaskCountsStatistics minus(TaskCountsStatistics taskCountsStatistics) {
        this.mTotalCount -= taskCountsStatistics.mTotalCount;
        this.mSuccessCount -= taskCountsStatistics.mSuccessCount;
        this.mRunningCount -= taskCountsStatistics.mRunningCount;
        this.mPausedCount -= taskCountsStatistics.mPausedCount;
        this.mFailedCount -= taskCountsStatistics.mFailedCount;
        this.mUnfinishedUnIllegalCount -= taskCountsStatistics.mUnfinishedUnIllegalCount;
        this.mUnfinishedNoCopyRightProblemCount -= taskCountsStatistics.mUnfinishedNoCopyRightProblemCount;
        return this;
    }

    public TaskCountsStatistics plus(TaskCountsStatistics taskCountsStatistics) {
        this.mTotalCount += taskCountsStatistics.mTotalCount;
        this.mSuccessCount += taskCountsStatistics.mSuccessCount;
        this.mRunningCount += taskCountsStatistics.mRunningCount;
        this.mPausedCount += taskCountsStatistics.mPausedCount;
        this.mFailedCount += taskCountsStatistics.mFailedCount;
        this.mUnfinishedUnIllegalCount += taskCountsStatistics.mUnfinishedUnIllegalCount;
        this.mUnfinishedNoCopyRightProblemCount += taskCountsStatistics.mUnfinishedNoCopyRightProblemCount;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TaskCountsStatistics{Total=");
        stringBuilder.append(this.mTotalCount);
        stringBuilder.append(", Success=");
        stringBuilder.append(this.mSuccessCount);
        stringBuilder.append(", Running=");
        stringBuilder.append(this.mRunningCount);
        stringBuilder.append(", Paused=");
        stringBuilder.append(this.mPausedCount);
        stringBuilder.append(", Failed=");
        stringBuilder.append(this.mFailedCount);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
