package com.xunlei.common.concurrent;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;

public abstract class XLCommand<T> implements Callable<XLCommandResult> {
    private static final String TAG = "XLCommand";
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private XLCommandListener mResponse;
    private XLCommandResult<T> mResult;

    public abstract T execute() throws Exception;

    public com.xunlei.common.concurrent.XLCommandResult call() throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.lang.StringBuilder;
        r1 = "Looper.getMainLooper()==Looper.myLooper() ";
        r0.<init>(r1);
        r1 = android.os.Looper.getMainLooper();
        r2 = android.os.Looper.myLooper();
        if (r1 != r2) goto L_0x0014;
    L_0x0011:
        r1 = "true";
        goto L_0x0016;
    L_0x0014:
        r1 = "false";
    L_0x0016:
        r0.append(r1);
        r0 = new com.xunlei.common.concurrent.XLCommandResult;
        r0.<init>();
        r3.mResult = r0;
        r0 = r3.mResult;	 Catch:{ Exception -> 0x0039 }
        r1 = r3.execute();	 Catch:{ Exception -> 0x0039 }
        r0.data = r1;	 Catch:{ Exception -> 0x0039 }
        r0 = r3.mHandler;
        if (r0 == 0) goto L_0x004b;
    L_0x002c:
        r0 = r3.mHandler;
        r1 = new com.xunlei.common.concurrent.XLCommand$1;
        r1.<init>(r3);
    L_0x0033:
        r0.post(r1);
        goto L_0x004b;
    L_0x0037:
        r0 = move-exception;
        goto L_0x004e;
    L_0x0039:
        r0 = r3.mResult;	 Catch:{ all -> 0x0037 }
        r1 = com.xunlei.common.concurrent.XLCommandResult.ResultCode.FAILED;	 Catch:{ all -> 0x0037 }
        r0.resultCode = r1;	 Catch:{ all -> 0x0037 }
        r0 = r3.mHandler;
        if (r0 == 0) goto L_0x004b;
    L_0x0043:
        r0 = r3.mHandler;
        r1 = new com.xunlei.common.concurrent.XLCommand$1;
        r1.<init>(r3);
        goto L_0x0033;
    L_0x004b:
        r0 = r3.mResult;
        return r0;
    L_0x004e:
        r1 = r3.mHandler;
        if (r1 == 0) goto L_0x005c;
    L_0x0052:
        r1 = r3.mHandler;
        r2 = new com.xunlei.common.concurrent.XLCommand$1;
        r2.<init>(r3);
        r1.post(r2);
    L_0x005c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.concurrent.XLCommand.call():com.xunlei.common.concurrent.XLCommandResult");
    }

    public void onResponse() {
        if (this.mResponse != null) {
            this.mResponse.onResponse(this.mResult);
        }
    }

    public void setResponse(XLCommandListener xLCommandListener) {
        this.mResponse = xLCommandListener;
    }
}
