package com.aplayer.hardwareencode;

import android.annotation.SuppressLint;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import com.aplayer.aplayerandroid.Log;
import com.aplayer.hardwareencode.EncoderBase.EncodeFrame;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Muxer extends Thread {
    private int mAngle;
    private Map<EncoderBase, Integer> mEncoderToInnerTrackIDMap = new HashMap();
    private HardwareEncoder mHardwareEncoder = null;
    private Queue<MuxerData> mMuxQueue = new LinkedList();
    private volatile boolean mMuxStart = false;
    private MediaMuxer mMuxer = null;
    private MUXER_FORMAT mMuxerFmt = null;
    private String mOutputPath = null;
    private volatile boolean mRunning = true;

    public enum MUXER_FORMAT {
        MUXER_MP4(0);
        
        private final int value;

        private MUXER_FORMAT(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public class MuxerData {
        public EncodeFrame encodeFrame;
        public int trackID;

        public MuxerData(EncodeFrame encodeFrame, int i) {
            this.encodeFrame = encodeFrame;
            this.trackID = i;
        }
    }

    public Muxer(HardwareEncoder hardwareEncoder, String str, MUXER_FORMAT muxer_format) {
        this.mHardwareEncoder = hardwareEncoder;
        this.mOutputPath = str;
        this.mMuxerFmt = muxer_format;
    }

    public void setAngle(int i) {
        this.mAngle = i;
    }

    @SuppressLint({"NewApi"})
    public boolean init() {
        if (this.mMuxer != null) {
            Log.e("ContentValues", "Muter is already init, before call this, must call stop()!");
        }
        boolean z = false;
        if (!isSupportMuxter()) {
            Log.e("ContentValues", "System Version not support!");
            return false;
        } else if (!checkParam()) {
            return false;
        } else {
            try {
                this.mMuxer = new MediaMuxer(this.mOutputPath, this.mMuxerFmt.getValue());
                this.mMuxer.setOrientationHint(this.mAngle);
                if (this.mMuxer != null) {
                    z = true;
                }
                this.mRunning = z;
                return z;
            } catch (IOException e) {
                e.printStackTrace();
                this.mMuxer = null;
                Log.e("ContentValues", "Create MediaMuxer Failed!");
                return false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void stopMux() {
        this.mRunning = false;
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.mMuxer != null) {
            synchronized (this.mMuxer) {
                if (this.mMuxStart) {
                    try {
                        this.mMuxer.stop();
                        this.mMuxer.release();
                    } catch (Exception e2) {
                        Log.e("ContentValues", "Mutex stop error!");
                        e2.printStackTrace();
                    }
                    this.mMuxStart = false;
                }
                this.mMuxer = null;
            }
        }
        this.mMuxQueue.clear();
        this.mEncoderToInnerTrackIDMap.clear();
    }

    @SuppressLint({"NewApi"})
    public void putMuxData(EncoderBase encoderBase, List<EncodeFrame> list) {
        if (list == null) {
            Log.e("ContentValues", "encode return a null list");
            return;
        }
        for (EncodeFrame encodeFrame : list) {
            if (encodeFrame.newFormat != null) {
                Log.i("ContentValues", "Muxer has new newFormat");
                int addTrack = addTrack(encodeFrame.newFormat);
                if (-1 == addTrack) {
                    break;
                }
                updateInnerTrackIdMap(encoderBase, addTrack);
                if (this.mEncoderToInnerTrackIDMap.size() == this.mHardwareEncoder.getTrackNum()) {
                    Log.i("ContentValues", "Muxer isAllEncodeGetNewFormat");
                    synchronized (this.mMuxer) {
                        this.mMuxStart = true;
                        this.mMuxer.start();
                    }
                }
            }
            Integer num = (Integer) this.mEncoderToInnerTrackIDMap.get(encoderBase);
            if (num == null) {
                Log.e("ContentValues", "invalidate encoder");
                return;
            }
            synchronized (this.mMuxQueue) {
                do {
                } while (!this.mMuxQueue.offer(new MuxerData(encodeFrame, num.intValue())));
            }
        }
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
    L_0x0000:
        r0 = r2.mRunning;
        if (r0 == 0) goto L_0x0020;
    L_0x0004:
        r0 = r2.mMuxQueue;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0015;
    L_0x000c:
        r0 = r2.mMuxStart;
        if (r0 != 0) goto L_0x0011;
    L_0x0010:
        goto L_0x0015;
    L_0x0011:
        r2.mux();
        goto L_0x0000;
    L_0x0015:
        r0 = 10;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x001b }
        goto L_0x0000;
    L_0x001b:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0000 }
        goto L_0x0000;
    L_0x0020:
        r0 = "ContentValues";
        r1 = "mRunning is false while is over";
        com.aplayer.aplayerandroid.Log.i(r0, r1);
    L_0x0027:
        r0 = r2.mMuxQueue;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x003e;
    L_0x002f:
        r0 = r2.mMuxStart;
        if (r0 == 0) goto L_0x003e;
    L_0x0033:
        r0 = "ContentValues";
        r1 = "MuxThread mMuxQueue not empepty";
        com.aplayer.aplayerandroid.Log.e(r0, r1);
        r2.mux();
        goto L_0x0027;
    L_0x003e:
        r0 = "ContentValues";
        r1 = "Muxer mux thread leave";
        com.aplayer.aplayerandroid.Log.i(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.hardwareencode.Muxer.run():void");
    }

    private int addTrack(MediaFormat mediaFormat) {
        if (this.mMuxer == null) {
            Log.e("ContentValues", "before call this function, please confirm init is success!");
            return -1;
        } else if (mediaFormat == null) {
            Log.e("ContentValues", "mediaFormat is null");
            return -1;
        } else if (this.mMuxStart) {
            Log.e("ContentValues", "muxer is start, can't call this function, after mutxer start!");
            return -1;
        } else {
            synchronized (this.mMuxer) {
                mediaFormat = this.mMuxer.addTrack(mediaFormat);
            }
            return mediaFormat;
        }
    }

    @SuppressLint({"NewApi"})
    private void mux() {
        synchronized (this.mMuxQueue) {
            MuxerData muxerData = (MuxerData) this.mMuxQueue.poll();
        }
        if (!(muxerData == null || muxerData.encodeFrame == null || muxerData.encodeFrame.buffInfo == null || muxerData.encodeFrame.buff == null)) {
            if (muxerData.encodeFrame.buff.length > 0) {
                StringBuilder stringBuilder;
                BufferInfo bufferInfo = muxerData.encodeFrame.buffInfo;
                ByteBuffer wrap = ByteBuffer.wrap(muxerData.encodeFrame.buff);
                if (bufferInfo.size >= 0 && bufferInfo.offset >= 0 && bufferInfo.offset + bufferInfo.size <= wrap.capacity()) {
                    if (bufferInfo.presentationTimeUs >= 0) {
                        stringBuilder = new StringBuilder("Muxer trackID = ");
                        stringBuilder.append(muxerData.trackID);
                        stringBuilder.append(" bufferInfo size = ");
                        stringBuilder.append(bufferInfo.size);
                        stringBuilder.append(" offset = ");
                        stringBuilder.append(bufferInfo.offset);
                        stringBuilder.append(" capacity = ");
                        stringBuilder.append(wrap.capacity());
                        stringBuilder.append(" presentationTimeUs = ");
                        stringBuilder.append(bufferInfo.presentationTimeUs / 1000);
                        Log.i("ContentValues", stringBuilder.toString());
                        if (this.mHardwareEncoder.mRecordTimeMs <= 0) {
                            synchronized (this.mMuxer) {
                                this.mMuxer.writeSampleData(muxerData.trackID, wrap, bufferInfo);
                            }
                        } else if (bufferInfo.presentationTimeUs <= ((long) (this.mHardwareEncoder.mRecordTimeMs * 1000))) {
                            synchronized (this.mMuxer) {
                                this.mMuxer.writeSampleData(muxerData.trackID, wrap, bufferInfo);
                            }
                        } else {
                            this.mHardwareEncoder.delTrack(muxerData.trackID);
                        }
                        Log.i("ContentValues", "Muxer writeSampleData leave");
                        return;
                    }
                }
                stringBuilder = new StringBuilder("Muxer trackID = ");
                stringBuilder.append(muxerData.trackID);
                stringBuilder.append(" bufferInfo size = ");
                stringBuilder.append(bufferInfo.size);
                stringBuilder.append(" offset = ");
                stringBuilder.append(bufferInfo.offset);
                stringBuilder.append(" capacity = ");
                stringBuilder.append(wrap.capacity());
                stringBuilder.append(" presentationTimeUs = ");
                stringBuilder.append(bufferInfo.presentationTimeUs);
                Log.e("ContentValues", stringBuilder.toString());
                return;
            }
        }
        Log.e("ContentValues", "invalidate muxer data !");
    }

    private static boolean isSupportMuxter() {
        return VERSION.SDK_INT >= 18;
    }

    private boolean checkParam() {
        if (this.mOutputPath != null) {
            if (!this.mOutputPath.isEmpty()) {
                if (this.mMuxerFmt != null) {
                    return true;
                }
                Log.e("ContentValues", "muxfmt is null");
                return false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("invalidate path, outpath is ");
        stringBuilder.append(this.mOutputPath);
        Log.e("ContentValues", stringBuilder.toString());
        return false;
    }

    private boolean updateInnerTrackIdMap(EncoderBase encoderBase, int i) {
        if (encoderBase == null) {
            Log.e("ContentValues", "invalidate encoder!");
            return null;
        }
        synchronized (this.mEncoderToInnerTrackIDMap) {
            if (this.mEncoderToInnerTrackIDMap.get(encoderBase) != null) {
                Log.e("ContentValues", "format change more than once");
            }
            this.mEncoderToInnerTrackIDMap.put(encoderBase, Integer.valueOf(i));
        }
        return true;
    }
}
