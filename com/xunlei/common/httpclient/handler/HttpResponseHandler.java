package com.xunlei.common.httpclient.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class HttpResponseHandler {
    private static final int FAILURE_MESSAGE = 1;
    private static final int FINISH_MESSAGE = 3;
    private static final int PROGRESS_MESSAGE = 4;
    private static final int START_MESSAGE = 2;
    private static final int SUCCESS_MESSAGE = 0;
    private Handler handler;
    protected Object mFlag;

    public void onFailure(Throwable th, byte[] bArr) {
    }

    public void onFinish() {
    }

    public void onProgressChanged(long j, long j2) {
    }

    public void onStart() {
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
    }

    public HttpResponseHandler() {
        if (Looper.myLooper() != null) {
            this.handler = new Handler() {
                public void handleMessage(Message message) {
                    HttpResponseHandler.this.handleMessage(message);
                }
            };
        }
    }

    public void sendSuccessMessage(int i, Header[] headerArr, byte[] bArr) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), headerArr, bArr}));
    }

    public void sendFailureMessage(Throwable th, byte[] bArr) {
        sendMessage(obtainMessage(1, new Object[]{th, bArr}));
    }

    public void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    public void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    public void sendProgressChangeMessage(long j, long j2) {
        sendMessage(obtainMessage(4, new long[]{j, j2}));
    }

    protected void handleSuccessMessage(int i, Header[] headerArr, byte[] bArr) {
        onSuccess(i, headerArr, bArr);
    }

    protected void handleFailureMessage(Throwable th, byte[] bArr) {
        onFailure(th, bArr);
    }

    protected void handleMessage(Message message) {
        Object[] objArr;
        switch (message.what) {
            case 0:
                objArr = (Object[]) message.obj;
                handleSuccessMessage(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
                return;
            case 1:
                objArr = (Object[]) message.obj;
                handleFailureMessage((Throwable) objArr[0], (byte[]) objArr[1]);
                return;
            case 2:
                onStart();
                return;
            case 3:
                onFinish();
                return;
            case 4:
                long[] jArr = (long[]) message.obj;
                onProgressChanged(jArr[0], jArr[1]);
                break;
            default:
                break;
        }
    }

    protected void sendMessage(Message message) {
        if (this.handler != null) {
            this.handler.sendMessage(message);
        } else {
            handleMessage(message);
        }
    }

    protected Message obtainMessage(int i, Object obj) {
        if (this.handler != null) {
            return this.handler.obtainMessage(i, obj);
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }

    public void sendResponseMessage(HttpResponse httpResponse) {
        StatusLine statusLine = httpResponse.getStatusLine();
        if (200 != statusLine.getStatusCode()) {
            int statusCode = statusLine.getStatusCode();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(statusLine.getStatusCode());
            stringBuilder.append(" ");
            stringBuilder.append(statusLine.getReasonPhrase());
            sendFailureMessage(new HttpResponseException(statusCode, stringBuilder.toString()), null);
            return;
        }
        byte[] toByteArray;
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            try {
                toByteArray = EntityUtils.toByteArray(new BufferedHttpEntity(entity));
            } catch (HttpResponse httpResponse2) {
                httpResponse2.printStackTrace();
                sendFailureMessage(httpResponse2, null);
                return;
            }
        }
        toByteArray = null;
        sendSuccessMessage(statusLine.getStatusCode(), httpResponse2.getAllHeaders(), toByteArray);
    }

    public void setFlag(Object obj) {
        this.mFlag = obj;
    }

    public Object getFlag() {
        return this.mFlag;
    }
}
