package com.aplayer.hardwareencode;

import android.media.MediaCodec;
import android.os.Build.VERSION;
import com.aplayer.aplayerandroid.APlayerAndroid;
import com.aplayer.aplayerandroid.Log;
import com.aplayer.hardwareencode.EncoderBase.EncodeFrame;
import com.aplayer.hardwareencode.Muxer.MUXER_FORMAT;
import com.aplayer.hardwareencode.VideoEncoder.COLOR_FORMAT;
import com.aplayer.hardwareencode.VideoEncoder.ENCODE_FORMAT;
import com.aplayer.hardwareencode.module.RawFrame;
import com.aplayer.hardwareencode.utils.EncodeUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HardwareEncoder {
    public static final int BUFFER_MODE = 1;
    public static final int SURFACE_MODE = 0;
    private static final String TAG = "APlayerAndroid";
    private APlayerAndroid mAPlayer = null;
    private int mAngle;
    private int mEcoderMode = -1;
    private String mEncodeOutpath;
    private boolean mEncoding = false;
    private Map<Integer, EncoderBase> mExternalIDToEncoderMap = new HashMap();
    private int mIFrameInterval = 5;
    private Object mLock = new Object();
    private Muxer mMuxer = null;
    private MUXER_FORMAT mMuxerFmt = MUXER_FORMAT.MUXER_MP4;
    protected int mRecordTimeMs = -1;
    private int mTrackAllocID = 0;
    private int mVideoBitRate = 2000000;
    private double mVideoFrameRate = 25.0d;
    private int mVideoHeight = 0;
    private int mVideoWidth = 0;

    public int addSubTrack() {
        return 0;
    }

    public HardwareEncoder(APlayerAndroid aPlayerAndroid) {
        this.mAPlayer = aPlayerAndroid;
    }

    public int start() {
        Log.i(TAG, "encoder start");
        if (this.mMuxer != null) {
            Log.e(TAG, "encode is running...");
            return -1;
        } else if (initMuxer()) {
            for (Entry value : this.mExternalIDToEncoderMap.entrySet()) {
                EncoderBase encoderBase = (EncoderBase) value.getValue();
                if (encoderBase != null) {
                    encoderBase.start();
                }
            }
            this.mEncoding = true;
            return 1;
        } else {
            Log.e(TAG, "muxer init failed");
            return -1;
        }
    }

    public int close() {
        Log.i(TAG, "encoder stop");
        synchronized (this.mLock) {
            this.mEncoding = false;
            for (Entry value : this.mExternalIDToEncoderMap.entrySet()) {
                EncoderBase encoderBase = (EncoderBase) value.getValue();
                if (encoderBase != null) {
                    encoderBase.stopEncode();
                }
            }
            this.mExternalIDToEncoderMap.clear();
            Log.i(TAG, "encoder releaseMuxer s");
            releaseMuxer();
            Log.i(TAG, "encoder stop leave");
        }
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mVideoBitRate = 1048576;
        return 1;
    }

    public int setRecordTime(int i) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("HardwareEncoder setRecordTime = ");
        stringBuilder.append(i);
        Log.i(str, stringBuilder.toString());
        this.mRecordTimeMs = i;
        return 1;
    }

    public int setOutFileName(String str) {
        this.mEncodeOutpath = str;
        return 1;
    }

    public int setOutFileAngle(int i) {
        this.mAngle = i;
        return 1;
    }

    public int addVideoTrack(int i, int i2, int i3, double d) {
        int i4;
        int i5;
        if (COLOR_FORMAT.COLOR_FormatSurface == i3) {
            int i6 = ((this.mVideoWidth != 0 ? this.mVideoWidth : i) / 16) * 16;
            i4 = (i2 * i6) / i;
            i5 = i6;
        } else {
            i5 = i;
            i4 = i2;
        }
        this.mVideoFrameRate = d;
        return _addVideoTrack(ENCODE_FORMAT.VIDEO_ACV, i3, i5, i4, this.mVideoFrameRate, this.mVideoBitRate, this.mIFrameInterval);
    }

    public int addVideoTrack(int i, int i2, int i3, double d, int i4) {
        this.mVideoFrameRate = d;
        this.mVideoBitRate = i4;
        return _addVideoTrack(ENCODE_FORMAT.VIDEO_ACV, i3, i, i2, d, i4, this.mIFrameInterval);
    }

    public int addAudioTrack(int i, int i2, int i3) {
        return _addAudioTrack(AudioEncoder.ENCODE_FORMAT.AUDIO_AAC, i, i2, 48000);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int putRawData(int r4, long r5) {
        /*
        r3 = this;
        r0 = "APlayerAndroid";
        r1 = new java.lang.StringBuilder;
        r2 = "putRawData enter trackIndex  presentationTime ";
        r1.<init>(r2);
        r1.append(r5);
        r1 = r1.toString();
        com.aplayer.aplayerandroid.Log.i(r0, r1);
        r0 = r3.mLock;
        monitor-enter(r0);
        r1 = r3.mEncoding;	 Catch:{ all -> 0x002f }
        if (r1 != 0) goto L_0x001d;
    L_0x001a:
        r4 = -6;
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return r4;
    L_0x001d:
        r1 = r3.getVideoSurfaceEncoder();	 Catch:{ all -> 0x002f }
        r2 = -1;
        if (r1 != 0) goto L_0x0026;
    L_0x0024:
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return r2;
    L_0x0026:
        r4 = r1.renderTexture(r4, r5);	 Catch:{ all -> 0x002f }
        if (r4 == 0) goto L_0x002d;
    L_0x002c:
        r2 = 0;
    L_0x002d:
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return r2;
    L_0x002f:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.hardwareencode.HardwareEncoder.putRawData(int, long):int");
    }

    public int putRawData(int i, ByteBuffer byteBuffer, int i2) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("putRawData enter trackIndex ");
        stringBuilder.append(i);
        stringBuilder.append(" rawData size ");
        stringBuilder.append(byteBuffer.limit());
        stringBuilder.append(" pts ");
        stringBuilder.append(i2);
        Log.i(str, stringBuilder.toString());
        if (!this.mEncoding) {
            return -6;
        }
        synchronized (this.mExternalIDToEncoderMap) {
            EncoderBase encoderBase = (EncoderBase) this.mExternalIDToEncoderMap.get(Integer.valueOf(i));
            if (encoderBase == null) {
                return -2;
            }
            byte[] bArr = null;
            if (byteBuffer != null && byteBuffer.limit() > 0) {
                bArr = new byte[byteBuffer.limit()];
                byteBuffer.get(bArr);
            }
            i = encoderBase.feedRewData(new RawFrame(bArr, ((long) i2) * 1000, i));
            return i;
        }
    }

    public int setVideoWidth(int i) {
        if (this.mEncoding) {
            return 0;
        }
        this.mVideoWidth = i;
        return 1;
    }

    public int setVideoHeight(int i) {
        if (this.mEncoding) {
            return 0;
        }
        this.mVideoHeight = i;
        return 1;
    }

    public int setVideoBitRate(int i) {
        if (this.mEncoding) {
            return 0;
        }
        this.mVideoBitRate = i * 1024;
        return 1;
    }

    public boolean isEncoding() {
        return this.mEncoding;
    }

    public Object getVideoEncodeCapability() {
        if (VERSION.SDK_INT < 18) {
            return null;
        }
        MediaCodec createMediaCodecEncoder;
        String value = ENCODE_FORMAT.VIDEO_ACV.getValue();
        try {
            createMediaCodecEncoder = EncodeUtils.createMediaCodecEncoder(value);
        } catch (IOException e) {
            e.printStackTrace();
            createMediaCodecEncoder = null;
        }
        if (createMediaCodecEncoder == null) {
            return null;
        }
        return EncodeUtils.getEncodVieoeCapability(createMediaCodecEncoder, value);
    }

    protected void delTrack(int i) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("HardwareEncoder delTrack trackIndex = ");
        stringBuilder.append(i);
        stringBuilder.append(" size = ");
        stringBuilder.append(this.mExternalIDToEncoderMap.size());
        Log.i(str, stringBuilder.toString());
        if (this.mExternalIDToEncoderMap.isEmpty()) {
            new Thread() {
                public void run() {
                    HardwareEncoder.this.mAPlayer.endRecord();
                }
            }.start();
            return;
        }
        synchronized (this.mExternalIDToEncoderMap) {
            if (this.mExternalIDToEncoderMap.containsKey(Integer.valueOf(i))) {
                ((EncoderBase) this.mExternalIDToEncoderMap.remove(Integer.valueOf(i))).stopEncode();
            }
            Log.i(TAG, "HardwareEncoder delTrack remove");
        }
    }

    protected void putEncoderData(EncoderBase encoderBase, List<EncodeFrame> list) {
        if (this.mMuxer != null) {
            this.mMuxer.putMuxData(encoderBase, list);
        }
    }

    protected int getTrackNum() {
        int size;
        synchronized (this.mExternalIDToEncoderMap) {
            size = this.mExternalIDToEncoderMap.size();
        }
        return size;
    }

    private int _addVideoTrack(ENCODE_FORMAT encode_format, int i, int i2, int i3, double d, int i4, int i5) {
        EncoderBase encoderBase;
        HardwareEncoder hardwareEncoder = this;
        int i6 = i;
        EncoderBase videoEncoderSurfaceInput;
        if (i6 == COLOR_FORMAT.COLOR_FormatSurface) {
            int i7;
            if (hardwareEncoder.mAngle % 180 != 0) {
                i7 = i2;
                i6 = i3;
            } else {
                i6 = i2;
                i7 = i3;
            }
            videoEncoderSurfaceInput = new VideoEncoderSurfaceInput(hardwareEncoder, encode_format, i6, i7, d, i4, i5);
            hardwareEncoder.mEcoderMode = 0;
        } else {
            videoEncoderSurfaceInput = new VideoEncoder(hardwareEncoder, encode_format, i6, i2, i3, d, i4, i5);
            hardwareEncoder.mEcoderMode = 1;
            encoderBase = videoEncoderSurfaceInput;
        }
        return encoderBase.init() ? addTrack(encoderBase) : -1;
    }

    private int _addAudioTrack(AudioEncoder.ENCODE_FORMAT encode_format, int i, int i2, int i3) {
        EncoderBase audioEncoder = new AudioEncoder(this, encode_format, i, i2, i3);
        return audioEncoder.init() != null ? addTrack(audioEncoder) : -1;
    }

    private int addTrack(EncoderBase encoderBase) {
        int i;
        synchronized (this.mExternalIDToEncoderMap) {
            if (encoderBase != null) {
                if (!this.mExternalIDToEncoderMap.containsValue(encoderBase)) {
                    i = this.mTrackAllocID;
                    this.mExternalIDToEncoderMap.put(Integer.valueOf(i), encoderBase);
                    this.mTrackAllocID++;
                }
            }
            i = -1;
        }
        return i;
    }

    public VideoEncoderSurfaceInput getVideoSurfaceEncoder() {
        for (Entry value : this.mExternalIDToEncoderMap.entrySet()) {
            EncoderBase encoderBase = (EncoderBase) value.getValue();
            if (encoderBase != null && (encoderBase instanceof VideoEncoderSurfaceInput)) {
                return (VideoEncoderSurfaceInput) encoderBase;
            }
        }
        return null;
    }

    private boolean initMuxer() {
        if (this.mEncodeOutpath == null) {
            Log.e(TAG, "initMuxer: outpath is null");
            return false;
        }
        this.mMuxer = new Muxer(this, this.mEncodeOutpath, this.mMuxerFmt);
        if (this.mEcoderMode == 1) {
            this.mMuxer.setAngle(this.mAngle);
        } else if (this.mEcoderMode == 0) {
            this.mMuxer.setAngle(0);
        }
        if (!this.mMuxer.init()) {
            return false;
        }
        this.mMuxer.start();
        return true;
    }

    private void releaseMuxer() {
        if (this.mMuxer != null) {
            this.mMuxer.stopMux();
            this.mMuxer = null;
        }
    }
}
