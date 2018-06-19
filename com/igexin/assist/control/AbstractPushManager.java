package com.igexin.assist.control;

import android.content.Context;

public interface AbstractPushManager {
    String getToken(Context context);

    void register(Context context);

    void setSilentTime(Context context, int i, int i2);

    void turnOffPush(Context context);

    void turnOnPush(Context context);

    void unregister(Context context);
}
