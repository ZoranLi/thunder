package org.android.spdy;

import java.util.List;
import java.util.Map;

final class SpdySessionCallBack implements Intenalcb {
    SpdySessionCallBack() {
    }

    public final void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, int i) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdyDataChunkRecvCB] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        long begin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i);
        if (spdyStream == null || spdyStream.callBack == null) {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyDataChunkRecvCB] - no sessionCallBack.");
        } else {
            spdyStream.callBack.spdyDataChunkRecvCB(spdySession, z, j, spdyByteArray, spdyStream.streamContext);
        }
        NetTimeGaurd.end("spdyDataChunkRecvCB", 3, begin);
    }

    public final void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdyDataRecvCallback] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        long begin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i2);
        if (spdyStream == null || spdyStream.callBack == null) {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyDataRecvCallback] - no sessionCallBack.");
        } else {
            spdyStream.callBack.spdyDataRecvCallback(spdySession, z, j, i, spdyStream.streamContext);
        }
        NetTimeGaurd.end("spdyDataRecvCallback", 3, begin);
    }

    public final void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i, int i2) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyDataSendCallback] - ");
        i2 = spdySession.getSpdyStream(i2);
        if (i2 == 0 || i2.callBack == null) {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyDataSendCallback] - no sessionCallBack.");
            return;
        }
        i2.callBack.spdyDataSendCallback(spdySession, z, j, i, i2.streamContext);
    }

    public final void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, int i2, SuperviseData superviseData) {
        SpdySession spdySession2 = spdySession;
        int i3 = i2;
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdyStreamCloseCallback] - ");
        stringBuilder.append(spdySession2);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        long begin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession2.getSpdyStream(i3);
        if (spdyStream == null || spdyStream.callBack == null) {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyStreamCloseCallback] - no sessionCallBack.");
        } else {
            StringBuilder stringBuilder2 = new StringBuilder("index=");
            stringBuilder2.append(i3);
            stringBuilder2.append("    endtime=");
            stringBuilder2.append(System.currentTimeMillis());
            spduLog.Logi("tnet-jni", stringBuilder2.toString());
            spdyStream.callBack.spdyStreamCloseCallback(spdySession2, j, i, spdyStream.streamContext, superviseData);
            spdySession2.removeSpdyStream(i3);
        }
        NetTimeGaurd.end("spdyStreamCloseCallback", 3, begin);
        NetTimeGaurd.finish(3);
    }

    public final void spdyRequestRecvCallback(SpdySession spdySession, long j, int i) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdyOnStreamResponse] - ");
        stringBuilder.append(spdySession);
        spduLog.Logd("tnet-jni", stringBuilder.toString());
        long begin = NetTimeGaurd.begin();
        i = spdySession.getSpdyStream(i);
        if (i == 0 || i.callBack == null) {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyRequestRecvCallback] - no sessionCallBack.");
        } else {
            i.callBack.spdyRequestRecvCallback(spdySession, j, i.streamContext);
        }
        NetTimeGaurd.end("spdyPingRecvCallback", 3, begin);
    }

    public final void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, int i) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdyOnStreamResponse] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        NetTimeGaurd.start(3);
        long begin = NetTimeGaurd.begin();
        i = spdySession.getSpdyStream(i);
        if (i == 0 || i.callBack == null) {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyOnStreamResponse] - no sessionCallBack.");
        } else {
            i.callBack.spdyOnStreamResponse(spdySession, j, map, i.streamContext);
        }
        NetTimeGaurd.end("spdyOnStreamResponse", 3, begin);
    }

    public final void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdySessionConnectCB] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        NetTimeGaurd.start(0);
        if (spdySession.sessionCallBack != null) {
            long begin = NetTimeGaurd.begin();
            spdySession.sessionCallBack.spdySessionConnectCB(spdySession, superviseConnectInfo);
            NetTimeGaurd.end("spdySessionConnectCB", 0, begin);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionConnectCB] - no sessionCallBack.");
        }
        NetTimeGaurd.finish(0);
    }

    public final void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdyPingRecvCallback] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        NetTimeGaurd.start(1);
        if (spdySession.sessionCallBack != null) {
            long begin = NetTimeGaurd.begin();
            spdySession.sessionCallBack.spdyPingRecvCallback(spdySession, j, obj);
            NetTimeGaurd.end("spdyPingRecvCallback", 1, begin);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyPingRecvCallback] - no sessionCallBack.");
        }
        NetTimeGaurd.finish(1);
    }

    public final void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdyCustomControlFrameRecvCallback] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        if (spdySession.sessionCallBack != null) {
            spdySession.sessionCallBack.spdyCustomControlFrameRecvCallback(spdySession, obj, i, i2, i3, i4, bArr);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyCustomControlFrameRecvCallback] - no sessionCallBack.");
        }
    }

    public final void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdyCustomControlFrameFailCallback] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        if (spdySession.sessionCallBack != null) {
            spdySession.sessionCallBack.spdyCustomControlFrameFailCallback(spdySession, obj, i, i2);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyCustomControlFrameFailCallback] - no sessionCallBack.");
        }
    }

    public final void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdySessionFailedError] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        NetTimeGaurd.start(2);
        if (spdySession.sessionCallBack != null) {
            long begin = NetTimeGaurd.begin();
            spdySession.sessionCallBack.spdySessionFailedError(spdySession, i, obj);
            spdySession.clearAllStreamCb();
            NetTimeGaurd.end("spdySessionFailedError", 2, begin);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionFailedError] - no sessionCallBack.");
        }
        NetTimeGaurd.finish(2);
    }

    public final void spdySessionOnWritable(SpdySession spdySession, Object obj, int i) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdySessionOnWritable] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        NetTimeGaurd.start(2);
        if (spdySession.sessionCallBack == null || !(spdySession.sessionCallBack instanceof SessionExtraCb)) {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionOnWritable] - no sessionCallBack.");
        } else {
            long begin = NetTimeGaurd.begin();
            ((SessionExtraCb) spdySession.sessionCallBack).spdySessionOnWritable(spdySession, obj, i);
            NetTimeGaurd.end("spdySessionOnWritable", 2, begin);
        }
        NetTimeGaurd.finish(2);
    }

    public final void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.spdySessionCloseCallback] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        if (spdySession.sessionCallBack != null) {
            spdySession.sessionCallBack.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionCloseCallback] - no sessionCallBack.");
        }
    }

    public final void bioPingRecvCallback(SpdySession spdySession, int i) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.bioPingRecvCallback] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        if (spdySession.sessionCallBack != null) {
            spdySession.sessionCallBack.bioPingRecvCallback(spdySession, i);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.bioPingRecvCallback] - no sessionCallBack.");
        }
    }

    public final byte[] getSSLMeta(SpdySession spdySession) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.getSSLMeta] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        if (spdySession.sessionCallBack != null) {
            return spdySession.sessionCallBack.getSSLMeta(spdySession);
        }
        spduLog.Loge("tnet-jni", "[SpdySessionCallBack.getSSLMeta] - no sessionCallBack.");
        return null;
    }

    public final int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("[SpdySessionCallBack.putSSLMeta] - ");
        stringBuilder.append(spdySession);
        spduLog.Logi("tnet-jni", stringBuilder.toString());
        if (spdySession.sessionCallBack != null) {
            return spdySession.sessionCallBack.putSSLMeta(spdySession, bArr);
        }
        spduLog.Loge("tnet-jni", "[SpdySessionCallBack.putSSLMeta] - no sessionCallBack.");
        return -1;
    }
}
