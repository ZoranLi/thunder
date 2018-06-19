package com.xunlei.common.androidutil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class HandlerUtil$StaticHandler extends Handler {
    WeakReference<HandlerUtil$MessageListener> mListener;

    public HandlerUtil$StaticHandler(HandlerUtil$MessageListener handlerUtil$MessageListener) {
        this.mListener = new WeakReference(handlerUtil$MessageListener);
    }

    public HandlerUtil$StaticHandler(Looper looper, HandlerUtil$MessageListener handlerUtil$MessageListener) {
        super(looper);
        this.mListener = new WeakReference(handlerUtil$MessageListener);
    }

    public void handleMessage(Message message) {
        if (this.mListener != null) {
            HandlerUtil$MessageListener handlerUtil$MessageListener = (HandlerUtil$MessageListener) this.mListener.get();
            if (handlerUtil$MessageListener != null) {
                handlerUtil$MessageListener.handleMessage(message);
            }
        }
    }

    public void removeListener() {
        this.mListener = null;
    }
}
