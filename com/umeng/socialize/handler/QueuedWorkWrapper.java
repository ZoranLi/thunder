package com.umeng.socialize.handler;

import com.umeng.socialize.common.QueuedWork;

public class QueuedWorkWrapper {
    public void onError(Runnable runnable) {
        QueuedWork.runInMain(runnable);
    }
}
