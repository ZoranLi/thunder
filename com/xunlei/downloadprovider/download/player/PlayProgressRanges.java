package com.xunlei.downloadprovider.download.player;

import com.xunlei.downloadprovider.download.engine.task.info.TaskRangeInfo;
import java.io.Serializable;
import java.util.List;

public class PlayProgressRanges implements Serializable {
    private static final long serialVersionUID = 1;
    public long mLength;
    public List<TaskRangeInfo> mRanges;
}
