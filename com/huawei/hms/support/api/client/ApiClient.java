package com.huawei.hms.support.api.client;

import android.content.Context;

public interface ApiClient {
    String getAppID();

    Context getContext();

    String getPackageName();

    String getSessionId();

    SubAppInfo getSubAppInfo();

    String getTransportName();

    boolean isConnected();
}
