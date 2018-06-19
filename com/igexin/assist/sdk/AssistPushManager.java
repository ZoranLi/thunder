package com.igexin.assist.sdk;

import android.content.Context;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.push.core.g;

public class AssistPushManager {
    private AbstractPushManager a;

    private AssistPushManager() {
    }

    public static AssistPushManager getInstance() {
        return c.a;
    }

    public static String getToken() {
        return g.z;
    }

    public void initialize(Context context) {
        this.a = a.a(context);
    }

    public void register(Context context) {
        if (this.a != null) {
            this.a.register(context);
        }
    }

    public void setSilentTime(Context context, int i, int i2) {
        if (this.a != null) {
            this.a.setSilentTime(context, i, i2);
        }
    }

    public void turnOffPush(Context context) {
        if (this.a != null) {
            this.a.turnOffPush(context);
        }
    }

    public void turnOnPush(Context context) {
        if (this.a != null) {
            this.a.turnOnPush(context);
        }
    }

    public void unregister(Context context) {
        if (this.a != null) {
            this.a.unregister(context);
        }
    }
}
