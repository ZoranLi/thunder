package com.xunlei.tdlive.sdk;

import android.os.Handler.Callback;
import android.os.Message;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.protocol.XLLiveRequest.JsonCallBack;

class BasePlugin$2 implements JsonCallBack {
    final /* synthetic */ Callback a;
    final /* synthetic */ BasePlugin b;

    BasePlugin$2(BasePlugin basePlugin, Callback callback) {
        this.b = basePlugin;
        this.a = callback;
    }

    public void onResponse(int i, String str, JsonWrapper jsonWrapper) {
        if (this.a != null) {
            str = new Message();
            str.what = i;
            str.obj = jsonWrapper.toString();
            this.a.handleMessage(str);
        }
    }
}
