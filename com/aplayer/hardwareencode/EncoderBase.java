package com.aplayer.hardwareencode;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.aplayer.aplayerandroid.Log;
import com.aplayer.hardwareencode.module.RawFrame;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class EncoderBase extends Thread {
    protected HardwareEncoder mHardwareEncoder = null;
    protected int mMaxInputQueueSize = 5;
    private Queue<RawFrame> mRawFrameQueue = new LinkedList();
    protected boolean mRunning = false;

    public class EncodeFrame {
        public byte[] buff;
        public BufferInfo buffInfo;
        public MediaFormat newFormat;

        public EncodeFrame(byte[] bArr, BufferInfo bufferInfo, MediaFormat mediaFormat) {
            this.buff = bArr;
            this.buffInfo = bufferInfo;
            this.newFormat = mediaFormat;
        }
    }

    abstract boolean feedRawData(byte[] bArr, long j, long j2);

    abstract List<EncodeFrame> fetchEncodeData();

    abstract MediaFormat getMediaFormat();

    abstract boolean init();

    abstract void release();

    public EncoderBase(HardwareEncoder hardwareEncoder) {
        this.mHardwareEncoder = hardwareEncoder;
    }

    public int feedRewData(RawFrame rawFrame) {
        synchronized (this.mRawFrameQueue) {
            Log.i("ContentValues", "putRawData feedRewData");
            if (this.mRawFrameQueue.size() >= this.mMaxInputQueueSize) {
                return -3;
            }
            this.mRawFrameQueue.add(rawFrame);
            return null;
        }
    }

    public void stopEncode() {
        this.mRunning = false;
        synchronized (this.mRawFrameQueue) {
            this.mRawFrameQueue.clear();
            try {
                join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        release();
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
    L_0x0000:
        r0 = r8.mRunning;
        if (r0 == 0) goto L_0x004a;
    L_0x0004:
        r0 = r8.mRawFrameQueue;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0017;
    L_0x000c:
        r0 = 5;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0012 }
        goto L_0x0000;
    L_0x0012:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0000 }
        goto L_0x0000;
    L_0x0017:
        r0 = r8.mRawFrameQueue;
        monitor-enter(r0);
        r1 = r8.mRawFrameQueue;	 Catch:{ all -> 0x0047 }
        r1 = r1.remove();	 Catch:{ all -> 0x0047 }
        r1 = (com.aplayer.hardwareencode.module.RawFrame) r1;	 Catch:{ all -> 0x0047 }
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        if (r1 == 0) goto L_0x003d;
    L_0x0025:
        r0 = r1.rawData;
        if (r0 == 0) goto L_0x003d;
    L_0x0029:
        r3 = r1.rawData;
        r4 = r1.pts;
        r6 = -1;
        r2 = r8;
        r0 = r2.feedRawData(r3, r4, r6);
        if (r0 != 0) goto L_0x003d;
    L_0x0036:
        r0 = "ContentValues";
        r1 = "feed raw data failed!";
        com.aplayer.aplayerandroid.Log.e(r0, r1);
    L_0x003d:
        r0 = r8.fetchEncodeData();
        r1 = r8.mHardwareEncoder;
        r1.putEncoderData(r8, r0);
        goto L_0x0000;
    L_0x0047:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        throw r1;
    L_0x004a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.hardwareencode.EncoderBase.run():void");
    }
}
