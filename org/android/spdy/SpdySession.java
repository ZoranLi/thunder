package org.android.spdy;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SpdySession {
    private static volatile int count;
    private SpdyAgent agent;
    private String authority;
    private AtomicBoolean closed = new AtomicBoolean();
    private String domain;
    private Handler handler;
    Intenalcb intenalcb;
    private Object lock = new Object();
    private int mode;
    private int pubkey_seqnum = 0;
    volatile int refcount = 1;
    SessionCb sessionCallBack = null;
    private boolean sessionClearedFromSessionMgr = false;
    private volatile long sessionNativePtr;
    private NetSparseArray<SpdyStreamContext> spdyStream = null;
    private int streamcount = 1;
    private HandlerThread thread;
    private Object userData = null;

    private native int sendCustomControlFrameN(long j, int i, int i2, int i3, int i4, byte[] bArr);

    private native int sendHeadersN(long j, int i, String[] strArr, boolean z);

    private native int setOptionN(long j, int i, int i2);

    private native int streamCloseN(long j, int i, int i2);

    private native int streamSendDataN(long j, int i, byte[] bArr, int i2, int i3, boolean z);

    private native int submitBioPingN(long j);

    private native int submitPingN(long j);

    private native int submitRequestN(long j, String str, byte b, String[] strArr, byte[] bArr, boolean z, int i, int i2);

    SpdySession(long j, SpdyAgent spdyAgent, String str, String str2, SessionCb sessionCb, int i, int i2, Object obj) {
        this.sessionNativePtr = j;
        this.agent = spdyAgent;
        this.authority = str;
        this.intenalcb = new SpdySessionCallBack();
        this.domain = str2;
        this.spdyStream = new NetSparseArray(5);
        this.sessionCallBack = sessionCb;
        this.pubkey_seqnum = i2;
        this.mode = i;
        this.userData = obj;
        this.closed.set(false);
    }

    public final int getRefCount() {
        return this.refcount;
    }

    final void increRefCount() {
        this.refcount++;
    }

    private String getAuthority() {
        return this.authority;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final Object getUserData() {
        return this.userData;
    }

    final int putSpdyStreamCtx(SpdyStreamContext spdyStreamContext) {
        int i;
        synchronized (this.lock) {
            i = this.streamcount;
            this.streamcount = i + 1;
            this.spdyStream.put(i, spdyStreamContext);
        }
        return i;
    }

    final SpdyStreamContext getSpdyStream(int i) {
        if (i <= 0) {
            return 0;
        }
        SpdyStreamContext spdyStreamContext;
        synchronized (this.lock) {
            spdyStreamContext = (SpdyStreamContext) this.spdyStream.get(i);
        }
        return spdyStreamContext;
    }

    final void removeSpdyStream(int i) {
        if (i > 0) {
            synchronized (this.lock) {
                this.spdyStream.remove(i);
            }
        }
    }

    public final SpdyStreamContext[] getAllStreamCb() {
        SpdyStreamContext[] spdyStreamContextArr;
        synchronized (this.lock) {
            int size = this.spdyStream.size();
            if (size > 0) {
                spdyStreamContextArr = new SpdyStreamContext[size];
                this.spdyStream.toArray(spdyStreamContextArr);
            } else {
                spdyStreamContextArr = null;
            }
        }
        return spdyStreamContextArr;
    }

    public final void clearAllStreamCb() {
        spduLog.Logd("tnet-jni", "[SpdySession.clearAllStreamCb] - ");
        synchronized (this.lock) {
            this.spdyStream.clear();
        }
    }

    final SpdyAgent getSpdyAgent() {
        return this.agent;
    }

    final Handler getMsgHandler() {
        return this.handler;
    }

    final long getSessionNativePtr() {
        return this.sessionNativePtr;
    }

    final void setSessionNativePtr(long j) {
        this.sessionNativePtr = j;
    }

    public final int setOption(int i, int i2) throws SpdyErrorException {
        sessionIsOpen();
        i = setOptionN(this.sessionNativePtr, i, i2);
        if (i == 0) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder("setOption error: ");
        stringBuilder.append(i);
        throw new SpdyErrorException(stringBuilder.toString(), i);
    }

    public final int submitPing() throws SpdyErrorException {
        sessionIsOpen();
        int submitPingN = submitPingN(this.sessionNativePtr);
        if (submitPingN == 0) {
            return submitPingN;
        }
        StringBuilder stringBuilder = new StringBuilder("submitPing error: ");
        stringBuilder.append(submitPingN);
        throw new SpdyErrorException(stringBuilder.toString(), submitPingN);
    }

    @Deprecated
    public final int submitBioPing() throws SpdyErrorException {
        sessionIsOpen();
        int submitBioPingN = submitBioPingN(this.sessionNativePtr);
        if (submitBioPingN == 0) {
            return submitBioPingN;
        }
        StringBuilder stringBuilder = new StringBuilder("submitBioPing error: ");
        stringBuilder.append(submitBioPingN);
        throw new SpdyErrorException(stringBuilder.toString(), submitBioPingN);
    }

    public final int streamReset(long j, int i) throws SpdyErrorException {
        sessionIsOpen();
        spduLog.Logd("tnet-jni", "[SpdySession.streamReset] - ");
        int streamCloseN = streamCloseN(this.sessionNativePtr, (int) j, i);
        if (streamCloseN == 0) {
            return streamCloseN;
        }
        i = new StringBuilder("streamReset error: ");
        i.append(streamCloseN);
        throw new SpdyErrorException(i.toString(), streamCloseN);
    }

    public final int sendCustomControlFrame(int i, int i2, int i3, int i4, byte[] bArr) throws SpdyErrorException {
        sessionIsOpen();
        if (bArr != null && bArr.length <= 0) {
            bArr = null;
        }
        byte[] bArr2 = bArr;
        StringBuilder stringBuilder = new StringBuilder("[sendCustomControlFrame] - type: ");
        stringBuilder.append(i2);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        i = sendCustomControlFrameN(this.sessionNativePtr, i, i2, i3, i4, bArr2);
        if (i == 0) {
            return i;
        }
        i3 = new StringBuilder("sendCustomControlFrame error: ");
        i3.append(i);
        throw new SpdyErrorException(i3.toString(), i);
    }

    public final int submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Spdycb spdycb) throws SpdyErrorException {
        if (!(spdyRequest == null || obj == null)) {
            if (spdyRequest.getAuthority() != null) {
                sessionIsOpen();
                byte[] dataproviderToByteArray = SpdyAgent.dataproviderToByteArray(spdyRequest, spdyDataProvider);
                if (dataproviderToByteArray != null && dataproviderToByteArray.length <= 0) {
                    dataproviderToByteArray = null;
                }
                byte[] bArr = dataproviderToByteArray;
                boolean z = spdyDataProvider != null ? spdyDataProvider.finished : true;
                spdyDataProvider = new SpdyStreamContext(obj, spdycb);
                obj = putSpdyStreamCtx(spdyDataProvider);
                String[] mapToByteArray = SpdyAgent.mapToByteArray(spdyRequest.getHeaders());
                StringBuilder stringBuilder = new StringBuilder("index=");
                stringBuilder.append(obj);
                stringBuilder.append("  starttime=");
                stringBuilder.append(System.currentTimeMillis());
                spduLog.Logi("tnet-jni", stringBuilder.toString());
                int submitRequestN = submitRequestN(this.sessionNativePtr, spdyRequest.getUrlPath(), (byte) spdyRequest.getPriority(), mapToByteArray, bArr, z, obj, spdyRequest.getRequestTimeoutMs());
                stringBuilder = new StringBuilder("index=");
                stringBuilder.append(obj);
                stringBuilder.append("   calltime=");
                stringBuilder.append(System.currentTimeMillis());
                spduLog.Logi("tnet-jni", stringBuilder.toString());
                if (submitRequestN < null) {
                    removeSpdyStream(obj);
                    obj = new StringBuilder("submitRequest error: ");
                    obj.append(submitRequestN);
                    throw new SpdyErrorException(obj.toString(), submitRequestN);
                }
                spdyDataProvider.streamId = submitRequestN;
                return submitRequestN;
            }
        }
        throw new SpdyErrorException("submitRequest error: -1102", (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    final void sessionIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("session is already closed: -1104", (int) TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
    }

    public final int cleanUp() {
        spduLog.Logd("tnet-jni", "[SpdySession.cleanUp] - ");
        if (this.closed.getAndSet(true)) {
            return 0;
        }
        this.agent.removeSession(this);
        return closeprivate();
    }

    final int closeInternal() {
        return !this.closed.getAndSet(true) ? closeprivate() : 0;
    }

    public final int closeSession() {
        int closeSession;
        spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - ");
        synchronized (this.lock) {
            if (!this.sessionClearedFromSessionMgr) {
                StringBuilder stringBuilder = new StringBuilder("[SpdySession.closeSession] - ");
                stringBuilder.append(this.authority);
                spduLog.Logd("tnet-jni", stringBuilder.toString());
                this.agent.clearSpdySession(this.authority, this.domain, this.mode);
                this.sessionClearedFromSessionMgr = true;
                try {
                    closeSession = this.agent.closeSession(this.sessionNativePtr);
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                }
            }
            closeSession = 0;
        }
        return closeSession;
    }

    private int closeprivate() {
        synchronized (this.lock) {
            if (!this.sessionClearedFromSessionMgr) {
                this.agent.clearSpdySession(this.authority, this.domain, this.mode);
                this.sessionClearedFromSessionMgr = true;
            }
        }
        this.sessionNativePtr = 0;
        synchronized (this.lock) {
            SpdyStreamContext[] allStreamCb = getAllStreamCb();
            if (allStreamCb != null) {
                for (SpdyStreamContext spdyStreamContext : allStreamCb) {
                    StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdyStreamCloseCallback] unfinished stm=");
                    stringBuilder.append(spdyStreamContext.streamId);
                    spduLog.Logi("tnet-jni", stringBuilder.toString());
                    spdyStreamContext.callBack.spdyStreamCloseCallback(this, (long) spdyStreamContext.streamId, TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS, spdyStreamContext.streamContext, null);
                }
            }
            this.spdyStream.clear();
        }
        return 0;
    }
}
