package com.xunlei.downloadprovider.download.engine.task.constants;

import java.io.Serializable;

public abstract class TaskResultCode implements Serializable {
    public static final int TASK_ALREADY_EXIST = -2;
    public static final int TASK_CREATE_FAILED = -1;
}
