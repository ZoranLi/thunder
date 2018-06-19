package com.aplayer.hardwareencode;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.util.Range;
import com.aplayer.aplayerandroid.Log;
import com.aplayer.hardwareencode.utils.EncodeUtils;
import com.aplayer.hardwareencode.utils.EncodeUtils.EncodeVideoCapability;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class VideoEncoder extends EncoderBase {
    private static final String ERROR_TAGE;
    private static final String INFO_TAGE;
    private static final String TAG = "APlayerAndroid";
    private static final int TIMEOUT_USEC = 12000;
    private static final int TIME_BASE_MICROSECOND = 1000000;
    private int mBitRate;
    private int mColorFormat;
    private int[] mColors = new int[]{COLOR_FORMAT.YUV420Flexible, 19, 21};
    private ENCODE_FORMAT mEncodeFormat;
    private long mFirstPts = -1;
    private double mFrameRate;
    protected int mHeight;
    private int mIFrameInterval;
    private long mPrevEncodeFrameTimeUS = 0;
    private int mRawFrameNum = null;
    protected int mWidth;
    protected MediaCodec mediaCodec;

    public static class COLOR_FORMAT {
        public static final int COLOR_FormatSurface = 2130708361;
        public static final int NV12 = 21;
        public static final int YUV420Flexible = 2135033992;
        public static final int YUV420P = 19;
    }

    public enum ENCODE_FORMAT {
        VIDEO_ACV("video/avc");
        
        private final String value;

        private ENCODE_FORMAT(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    private static class VideoEncodeParam {
        CodecProfileLevel codecProfileLevel = null;
        Range<Integer> heightRanger = null;
        Range<Integer> widthRange = null;

        public VideoEncodeParam(CodecProfileLevel codecProfileLevel, Range<Integer> range, Range<Integer> range2) {
            this.codecProfileLevel = codecProfileLevel;
            this.widthRange = range;
            this.heightRanger = range2;
        }
    }

    protected void beforeMediaCodecStart(MediaCodec mediaCodec) {
    }

    static {
        StringBuilder stringBuilder = new StringBuilder("Aplayer_ERROR");
        stringBuilder.append(VideoEncoder.class.getSimpleName());
        ERROR_TAGE = stringBuilder.toString();
        stringBuilder = new StringBuilder("Aplayer_INFO");
        stringBuilder.append(VideoEncoder.class.getSimpleName());
        INFO_TAGE = stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VideoEncoder(com.aplayer.hardwareencode.HardwareEncoder r3, com.aplayer.hardwareencode.VideoEncoder.ENCODE_FORMAT r4, int r5, int r6, int r7, double r8, int r10, int r11) {
        /*
        r2 = this;
        r2.<init>(r3);
        r3 = 0;
        r2.mRawFrameNum = r3;
        r0 = 0;
        r2.mPrevEncodeFrameTimeUS = r0;
        r0 = -1;
        r2.mFirstPts = r0;
        r3 = 3;
        r3 = new int[r3];
        r3 = {2135033992, 19, 21};
        r2.mColors = r3;
        r2.mWidth = r6;
        r2.mHeight = r7;
        r2.mFrameRate = r8;
        r2.mBitRate = r10;
        r2.mColorFormat = r5;
        r2.mEncodeFormat = r4;
        r2.mIFrameInterval = r11;
        r2.mFirstPts = r0;
        r3 = 40;
        r2.mMaxInputQueueSize = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.hardwareencode.VideoEncoder.<init>(com.aplayer.hardwareencode.HardwareEncoder, com.aplayer.hardwareencode.VideoEncoder$ENCODE_FORMAT, int, int, int, double, int, int):void");
    }

    public EncodeVideoCapability getEncodeCapability() {
        if (this.mEncodeFormat == null && this.mediaCodec == null) {
            if (VERSION.SDK_INT >= 18) {
                return EncodeUtils.getEncodVieoeCapability(this.mediaCodec, this.mEncodeFormat.getValue());
            }
        }
        return null;
    }

    private boolean checkParam() {
        if (this.mWidth > 0 && this.mHeight > 0 && 0.0d < this.mFrameRate) {
            if (this.mBitRate > 0) {
                if (COLOR_FORMAT.COLOR_FormatSurface == this.mColorFormat || 19 == this.mColorFormat || 21 == this.mColorFormat || COLOR_FORMAT.YUV420Flexible == this.mColorFormat) {
                    return true;
                }
                String str = ERROR_TAGE;
                StringBuilder stringBuilder = new StringBuilder("Error not support format: ");
                stringBuilder.append(this.mColorFormat);
                Log.e(str, stringBuilder.toString());
                return false;
            }
        }
        Log.e(ERROR_TAGE, String.format("param is not invalidate, Width = %d, Height = %d, FrameRate = %d, BitRate = %d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Double.valueOf(this.mFrameRate), Integer.valueOf(this.mBitRate)}));
        return false;
    }

    private static boolean isSupportEncoder() {
        return VERSION.SDK_INT >= 16;
    }

    private MediaFormat createMediaCodecFormat(int i, int i2, int i3, Integer num, Integer num2) {
        i2 = MediaFormat.createVideoFormat(this.mEncodeFormat.getValue(), i2, i3);
        i2.setInteger("color-format", i);
        i2.setInteger("bitrate", this.mBitRate);
        i2.setFloat("frame-rate", ((float) this.mFrameRate) * 1065353216);
        i2.setInteger("i-frame-interval", this.mIFrameInterval);
        if (num != null) {
            i2.setInteger("profile", num.intValue());
        }
        if (num2 != null) {
            i2.setInteger("level", num2.intValue());
        }
        return i2;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public boolean init() {
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
        r12 = this;
        r0 = -1;
        r12.mFirstPts = r0;
        r0 = isSupportEncoder();
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0015;
    L_0x000c:
        r0 = ERROR_TAGE;
        r1 = "Not Support HardWareEncoder";
        com.aplayer.aplayerandroid.Log.e(r0, r1);
        goto L_0x010b;
    L_0x0015:
        r0 = r12.checkParam();
        if (r0 == 0) goto L_0x010b;
    L_0x001b:
        r0 = r12.mEncodeFormat;
        r0 = r0.getValue();
        r3 = com.aplayer.hardwareencode.utils.EncodeUtils.createMediaCodecEncoder(r0);	 Catch:{ Exception -> 0x0100 }
        r12.mediaCodec = r3;	 Catch:{ Exception -> 0x0100 }
        r3 = r12.mediaCodec;
        r0 = findBestMatchProfileLeve(r3, r0);
        r3 = r12.mWidth;
        r4 = r12.mHeight;
        r5 = 0;
        if (r0 == 0) goto L_0x00b7;
    L_0x0034:
        r6 = r0.codecProfileLevel;
        if (r6 == 0) goto L_0x0049;
    L_0x0038:
        r6 = r0.codecProfileLevel;
        r6 = r6.profile;
        r6 = java.lang.Integer.valueOf(r6);
        r7 = r0.codecProfileLevel;
        r7 = r7.level;
        r7 = java.lang.Integer.valueOf(r7);
        goto L_0x004b;
    L_0x0049:
        r6 = r5;
        r7 = r6;
    L_0x004b:
        r8 = r0.widthRange;
        if (r8 == 0) goto L_0x007f;
    L_0x004f:
        r8 = r0.widthRange;
        r9 = java.lang.Integer.valueOf(r3);
        r8 = r8.contains(r9);
        if (r8 != 0) goto L_0x007f;
    L_0x005b:
        r8 = r0.widthRange;
        r8 = r8.getUpper();
        r8 = (java.lang.Integer) r8;
        r9 = r0.widthRange;
        r9 = r9.getLower();
        r9 = (java.lang.Integer) r9;
        r10 = r8.intValue();
        if (r3 <= r10) goto L_0x0075;
    L_0x0071:
        r3 = r8.intValue();
    L_0x0075:
        r8 = r9.intValue();
        if (r3 >= r8) goto L_0x007f;
    L_0x007b:
        r3 = r9.intValue();
    L_0x007f:
        r8 = r0.heightRanger;
        if (r8 == 0) goto L_0x00b4;
    L_0x0083:
        r8 = r0.heightRanger;
        r9 = java.lang.Integer.valueOf(r4);
        r8 = r8.contains(r9);
        if (r8 != 0) goto L_0x00b4;
    L_0x008f:
        r8 = r0.heightRanger;
        r8 = r8.getUpper();
        r8 = (java.lang.Integer) r8;
        r0 = r0.heightRanger;
        r0 = r0.getLower();
        r0 = (java.lang.Integer) r0;
        r9 = r8.intValue();
        if (r4 <= r9) goto L_0x00a9;
    L_0x00a5:
        r4 = r8.intValue();
    L_0x00a9:
        r8 = r0.intValue();
        if (r4 >= r8) goto L_0x00b4;
    L_0x00af:
        r0 = r0.intValue();
        r4 = r0;
    L_0x00b4:
        r10 = r6;
        r11 = r7;
        goto L_0x00b9;
    L_0x00b7:
        r10 = r5;
        r11 = r10;
    L_0x00b9:
        r3 = r3 / 16;
        r3 = r3 * 16;
        r12.mWidth = r3;
        r4 = r4 / 2;
        r4 = r4 * 2;
        r12.mHeight = r4;
        r0 = "meeeee";
        r3 = new java.lang.StringBuilder;
        r4 = "createMediaCodecFormat :";
        r3.<init>(r4);
        r4 = r12.mWidth;
        r3.append(r4);
        r4 = "/";
        r3.append(r4);
        r4 = r12.mHeight;
        r3.append(r4);
        r3 = r3.toString();
        com.aplayer.aplayerandroid.Log.e(r0, r3);
        r7 = r12.mColorFormat;
        r8 = r12.mWidth;
        r9 = r12.mHeight;
        r6 = r12;
        r0 = r6.createMediaCodecFormat(r7, r8, r9, r10, r11);
        r3 = r12.mediaCodec;	 Catch:{ Exception -> 0x00ff }
        r3.configure(r0, r5, r5, r1);	 Catch:{ Exception -> 0x00ff }
        r0 = r12.mediaCodec;
        r12.beforeMediaCodecStart(r0);
        r0 = r12.mediaCodec;
        r0.start();
        goto L_0x010c;
    L_0x00ff:
        return r2;
    L_0x0100:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = ERROR_TAGE;
        r1 = "createEncoderByType() failed!";
        com.aplayer.aplayerandroid.Log.e(r0, r1);
    L_0x010b:
        r1 = r2;
    L_0x010c:
        r12.mRunning = r1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.hardwareencode.VideoEncoder.init():boolean");
    }

    public void release() {
        Log.i(TAG, "VideoEncoder release");
        try {
            this.mediaCodec.stop();
            this.mediaCodec.release();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(ERROR_TAGE, "mediaCodec.release() failed!");
        }
        this.mPrevEncodeFrameTimeUS = 0;
    }

    public boolean feedRawData(byte[] bArr, long j, long j2) {
        ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
        int dequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(j2);
        if (dequeueInputBuffer < 0) {
            return null;
        }
        if (j <= 0) {
            j = computePresentationTime((long) this.mRawFrameNum);
        }
        long j3 = j;
        j = inputBuffers[dequeueInputBuffer];
        j.clear();
        j.put(bArr);
        this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j3, 0);
        this.mRawFrameNum += 1;
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.aplayer.hardwareencode.EncoderBase.EncodeFrame> fetchEncodeData() {
        /*
        r14 = this;
        r0 = r14.mediaCodec;
        r0 = r0.getOutputBuffers();
        r1 = new android.media.MediaCodec$BufferInfo;
        r1.<init>();
        r2 = new java.util.ArrayList;
        r2.<init>();
    L_0x0010:
        r3 = r14.mediaCodec;
        r4 = 12000; // 0x2ee0 float:1.6816E-41 double:5.929E-320;
        r3 = r3.dequeueOutputBuffer(r1, r4);
        r4 = -1;
        if (r4 == r3) goto L_0x00db;
    L_0x001b:
        r4 = -3;
        if (r3 != r4) goto L_0x0025;
    L_0x001e:
        r0 = r14.mediaCodec;
        r0 = r0.getOutputBuffers();
        goto L_0x0010;
    L_0x0025:
        r4 = -2;
        r5 = 0;
        if (r3 != r4) goto L_0x0038;
    L_0x0029:
        r3 = r14.mediaCodec;
        r3 = r3.getOutputFormat();
        r4 = new com.aplayer.hardwareencode.EncoderBase$EncodeFrame;
        r4.<init>(r5, r5, r3);
        r2.add(r4);
        goto L_0x0010;
    L_0x0038:
        if (r3 >= 0) goto L_0x004e;
    L_0x003a:
        r4 = ERROR_TAGE;
        r5 = new java.lang.StringBuilder;
        r6 = "unexpected result from encoder.dequeueOutputBuffer: ";
        r5.<init>(r6);
        r5.append(r3);
        r3 = r5.toString();
        com.aplayer.aplayerandroid.Log.e(r4, r3);
        goto L_0x0010;
    L_0x004e:
        r4 = r0[r3];
        if (r4 != 0) goto L_0x006b;
    L_0x0052:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r2 = "encoderOutputBuffer ";
        r1.<init>(r2);
        r1.append(r3);
        r2 = " was null";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x006b:
        r6 = r1.flags;
        r6 = r6 & 2;
        r7 = 0;
        if (r6 == 0) goto L_0x0074;
    L_0x0072:
        r1.size = r7;
    L_0x0074:
        r6 = r1.size;
        if (r6 == 0) goto L_0x00c9;
    L_0x0078:
        r6 = r1.offset;
        r4.position(r6);
        r6 = r1.offset;
        r8 = r1.size;
        r6 = r6 + r8;
        r4.limit(r6);
        r6 = com.aplayer.hardwareencode.utils.EncodeUtils.bufferInfoDup(r1);
        r8 = "APlayerAndroid";
        r9 = new java.lang.StringBuilder;
        r10 = "setPresentationTime encode presentationTime = ";
        r9.<init>(r10);
        r10 = r6.presentationTimeUs;
        r9.append(r10);
        r9 = r9.toString();
        com.aplayer.aplayerandroid.Log.i(r8, r9);
        r8 = r14.mFirstPts;
        r10 = -1;
        r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r12 != 0) goto L_0x00aa;
    L_0x00a6:
        r8 = r6.presentationTimeUs;
        r14.mFirstPts = r8;
    L_0x00aa:
        r8 = r1.presentationTimeUs;
        r8 = r14.correctionBuffInfoTime(r8);
        r6.presentationTimeUs = r8;
        r8 = r6.presentationTimeUs;
        r10 = r14.mFirstPts;
        r12 = r8 - r10;
        r6.presentationTimeUs = r12;
        r8 = r1.size;
        r8 = new byte[r8];
        r4.get(r8);
        r4 = new com.aplayer.hardwareencode.EncoderBase$EncodeFrame;
        r4.<init>(r8, r6, r5);
        r2.add(r4);
    L_0x00c9:
        r4 = r14.mediaCodec;
        r4.releaseOutputBuffer(r3, r7);
        r3 = r1.flags;
        r3 = r3 & 4;
        if (r3 == 0) goto L_0x0010;
    L_0x00d4:
        r0 = INFO_TAGE;
        r1 = "reached end of stream unexpectedly";
        com.aplayer.aplayerandroid.Log.e(r0, r1);
    L_0x00db:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.hardwareencode.VideoEncoder.fetchEncodeData():java.util.List<com.aplayer.hardwareencode.EncoderBase$EncodeFrame>");
    }

    public MediaFormat getMediaFormat() {
        return this.mediaCodec != null ? this.mediaCodec.getOutputFormat() : null;
    }

    @SuppressLint({"NewApi"})
    private static VideoEncodeParam findBestMatchProfileLeve(MediaCodec mediaCodec, String str) {
        Range range = null;
        if (VERSION.SDK_INT >= 16 && mediaCodec != null) {
            if (str != null) {
                mediaCodec = EncodeUtils.getMediaCodecInfo(mediaCodec);
                mediaCodec = mediaCodec != null ? mediaCodec.getCapabilitiesForType(str) : null;
                if (mediaCodec != null) {
                    if (mediaCodec.profileLevels != null) {
                        int i;
                        int i2;
                        CodecProfileLevel codecProfileLevel;
                        VideoEncodeParam videoEncodeParam;
                        str = new ArrayList();
                        for (CodecProfileLevel codecProfileLevel2 : mediaCodec.profileLevels) {
                            if (8 == codecProfileLevel2.profile || 2 == codecProfileLevel2.profile || 4 == codecProfileLevel2.profile || 1 == codecProfileLevel2.profile) {
                                str.add(codecProfileLevel2);
                            }
                        }
                        int i3 = 0;
                        while (i3 < str.size() - 1) {
                            i2 = i3 + 1;
                            for (i = i2; i < str.size(); i++) {
                                codecProfileLevel2 = (CodecProfileLevel) str.get(i3);
                                CodecProfileLevel codecProfileLevel3 = (CodecProfileLevel) str.get(i);
                                if (codecProfileLevel2.profile < codecProfileLevel3.profile || (codecProfileLevel2.profile == codecProfileLevel3.profile && codecProfileLevel2.level < codecProfileLevel3.level)) {
                                    str.set(i3, codecProfileLevel3);
                                    str.set(i, codecProfileLevel2);
                                }
                            }
                            i3 = i2;
                        }
                        if (str.isEmpty()) {
                            videoEncodeParam = null;
                        } else {
                            CodecProfileLevel codecProfileLevel4 = (CodecProfileLevel) str.get(0);
                            if (VERSION.SDK_INT >= 21) {
                                mediaCodec = mediaCodec.getVideoCapabilities();
                                range = mediaCodec.getSupportedHeights();
                                mediaCodec = mediaCodec.getSupportedWidths();
                            } else {
                                mediaCodec = null;
                            }
                            videoEncodeParam = new VideoEncodeParam(codecProfileLevel4, mediaCodec, range);
                        }
                        return videoEncodeParam;
                    }
                }
                return null;
            }
        }
        return null;
    }

    private long computePresentationTime(long j) {
        return (long) (((double) j) * (1000000.0d / this.mFrameRate));
    }

    private long correctionBuffInfoTime(long j) {
        if (j <= this.mPrevEncodeFrameTimeUS) {
            j = this.mPrevEncodeFrameTimeUS + 16000;
        }
        this.mPrevEncodeFrameTimeUS = j;
        return j;
    }
}
