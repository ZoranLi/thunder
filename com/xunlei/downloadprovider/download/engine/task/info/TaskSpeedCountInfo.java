package com.xunlei.downloadprovider.download.engine.task.info;

import java.io.Serializable;

public class TaskSpeedCountInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public long mHighestSpeed = 0;
    public long mTaskId = 0;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return this.mTaskId == ((TaskSpeedCountInfo) obj).mTaskId;
            }
        }
        return false;
    }

    public int hashCode() {
        return (int) (this.mTaskId ^ (this.mTaskId >>> 32));
    }
}
