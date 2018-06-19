package com.xunlei.downloadprovider.download.engine.task.info;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class TaskRangeInfo implements Serializable {
    private long mLength;
    private long mStartPosition;

    public long getStartPosition() {
        return this.mStartPosition;
    }

    public long getEndPosition() {
        return this.mStartPosition + this.mLength;
    }

    public void setStartPosition(long j) {
        this.mStartPosition = j;
    }

    public long getLength() {
        return this.mLength;
    }

    public void setLength(long j) {
        this.mLength = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                TaskRangeInfo taskRangeInfo = (TaskRangeInfo) obj;
                return this.mStartPosition == taskRangeInfo.mStartPosition && this.mLength == taskRangeInfo.mLength;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((int) (this.mStartPosition ^ (this.mStartPosition >>> 32)))) + ((int) (this.mLength ^ (this.mLength >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TaskRangeInfo[");
        stringBuilder.append(this.mStartPosition);
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(this.mLength);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
