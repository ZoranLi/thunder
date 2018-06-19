package com.tencent.tinker.loader.hotplug.interceptor;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.reflect.Field;

/* compiled from: BUGLY */
public class HandlerMessageInterceptor extends Interceptor<Callback> {
    private static Field sMCallbackField;
    private final MessageHandler mMessageHandler;
    private final Handler mTarget;

    /* compiled from: BUGLY */
    public interface MessageHandler {
        boolean handleMessage(Message message);
    }

    /* compiled from: BUGLY */
    private static class CallbackWrapper implements Callback, ITinkerHotplugProxy {
        private volatile boolean mIsInHandleMethod = null;
        private final MessageHandler mMessageHandler;
        private final Callback mOrigCallback;

        CallbackWrapper(MessageHandler messageHandler, Callback callback) {
            this.mMessageHandler = messageHandler;
            this.mOrigCallback = callback;
        }

        public boolean handleMessage(Message message) {
            if (this.mIsInHandleMethod) {
                return false;
            }
            this.mIsInHandleMethod = true;
            message = this.mMessageHandler.handleMessage(message) ? 1 : this.mOrigCallback != null ? this.mOrigCallback.handleMessage(message) : null;
            this.mIsInHandleMethod = false;
            return message;
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor.class;
        monitor-enter(r0);
        r1 = sMCallbackField;	 Catch:{ all -> 0x0013 }
        if (r1 != 0) goto L_0x0011;
    L_0x0007:
        r1 = android.os.Handler.class;	 Catch:{ Throwable -> 0x0011 }
        r2 = "mCallback";	 Catch:{ Throwable -> 0x0011 }
        r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r1, r2);	 Catch:{ Throwable -> 0x0011 }
        sMCallbackField = r1;	 Catch:{ Throwable -> 0x0011 }
    L_0x0011:
        monitor-exit(r0);	 Catch:{ all -> 0x0013 }
        return;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r1 = move-exception;	 Catch:{ all -> 0x0013 }
        monitor-exit(r0);	 Catch:{ all -> 0x0013 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor.<clinit>():void");
    }

    public HandlerMessageInterceptor(Handler handler, MessageHandler messageHandler) {
        this.mTarget = handler;
        this.mMessageHandler = messageHandler;
    }

    @Nullable
    protected Callback fetchTarget() throws Throwable {
        return (Callback) sMCallbackField.get(this.mTarget);
    }

    @NonNull
    protected Callback decorate(@Nullable Callback callback) throws Throwable {
        if (callback == null || !ITinkerHotplugProxy.class.isAssignableFrom(callback.getClass())) {
            return new CallbackWrapper(this.mMessageHandler, callback);
        }
        return callback;
    }

    protected void inject(@Nullable Callback callback) throws Throwable {
        sMCallbackField.set(this.mTarget, callback);
    }
}
