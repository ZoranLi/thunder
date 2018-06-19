package com.aplayer.hardwareencode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.aplayer.aplayerandroid.Log;
import com.aplayer.hardwareencode.utils.EncodeUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.nio.ByteBuffer;

public class AudioEncoder extends EncoderBase {
    public static final int AACCodecProfileLevel = 1;
    public static final int[] AAC_STANDARD_SAMPLE_RATE = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final String ERROR_TAGE = "APlayerAndroid";
    private static final String INFO_TAGE = "APlayerAndroid";
    private final int MERGE_FRAME_LIMETE_MS = 100;
    private int TIMEOUT_USEC = 12000;
    private int mBitRate;
    private int mChannelCount;
    private ENCODE_FORMAT mEncodeFormat;
    private long mFirstPts = -1;
    private byte[] mInputMerge = null;
    private long mInputMergePts = 0;
    private long mLastpts = -1;
    private int mMaxMergeFrameLimete = 26460;
    private int mMergeFrameLimete = 8820;
    private long mPts = 0;
    private int mSampleRate;
    private MediaCodec mediaCodec;

    public enum ENCODE_FORMAT {
        AUDIO_AAC("audio/mp4a-latm"),
        AUDIO_MPEG("audio/mpeg");
        
        private final String value;

        private ENCODE_FORMAT(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public AudioEncoder(HardwareEncoder hardwareEncoder, ENCODE_FORMAT encode_format, int i, int i2, int i3) {
        super(hardwareEncoder);
        this.mEncodeFormat = encode_format;
        this.mChannelCount = i;
        this.mSampleRate = i2;
        this.mBitRate = i3;
        this.mMaxInputQueueSize = 400;
        this.mMergeFrameLimete = (int) (((0 * ((double) this.mSampleRate)) * ((double) this.mChannelCount)) / 0);
    }

    private boolean checkParam() {
        if (this.mChannelCount > 0 && this.mSampleRate > 0) {
            if (this.mBitRate > 0) {
                if (getSupportSampleRate(this.mEncodeFormat) == null || indexOfArray(AAC_STANDARD_SAMPLE_RATE, this.mSampleRate) >= 0) {
                    return true;
                }
                StringBuilder stringBuilder = new StringBuilder("Not Support Sample Rate = ");
                stringBuilder.append(this.mSampleRate);
                Log.e("APlayerAndroid", stringBuilder.toString());
                return false;
            }
        }
        String str = "APlayerAndroid";
        Log.e(str, String.format("param is not invalidate, ChannelCount = %d, SampleRate = %d, BitRate = %d", new Object[]{Integer.valueOf(this.mChannelCount), Integer.valueOf(this.mSampleRate), Integer.valueOf(this.mBitRate)}));
        return false;
    }

    private static boolean isSupportEncoder() {
        return VERSION.SDK_INT >= 16;
    }

    public boolean init() {
        this.mFirstPts = -1;
        boolean z = true;
        if (!isSupportEncoder()) {
            Log.e("APlayerAndroid", "Not Support HardWareEncoder");
        } else if (checkParam()) {
            String value = this.mEncodeFormat.getValue();
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", value);
            mediaFormat.setInteger("channel-count", this.mChannelCount);
            mediaFormat.setInteger("sample-rate", this.mSampleRate);
            mediaFormat.setInteger("bitrate", this.mBitRate);
            mediaFormat.setInteger("aac-profile", 1);
            mediaFormat.setInteger("max-input-size", ShareConstants.MD5_FILE_BUF_LENGTH);
            try {
                this.mediaCodec = EncodeUtils.createMediaCodecEncoder(value);
                this.mediaCodec.configure(mediaFormat, null, null, 1);
                this.mediaCodec.start();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("APlayerAndroid", "createEncoderByType() failed!");
            }
            this.mRunning = z;
            return z;
        }
        z = false;
        this.mRunning = z;
        return z;
    }

    public void release() {
        try {
            this.mediaCodec.stop();
            this.mediaCodec.release();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("APlayerAndroid", "mediaCodec.release() failed!");
        }
    }

    public boolean feedRawData(byte[] bArr, long j, long j2) {
        AudioEncoder audioEncoder = this;
        Object obj = bArr;
        if (obj == null) {
            return false;
        }
        int length = obj.length;
        if (audioEncoder.mInputMerge != null) {
            length += audioEncoder.mInputMerge.length;
        }
        boolean z = false;
        int i = z;
        while (length > 0) {
            ByteBuffer[] inputBuffers;
            int dequeueInputBuffer;
            long j3;
            boolean z2;
            int i2 = length > audioEncoder.mMaxMergeFrameLimete ? audioEncoder.mMaxMergeFrameLimete : length;
            Object obj2;
            if (audioEncoder.mInputMerge != null) {
                obj2 = new byte[i2];
                System.arraycopy(audioEncoder.mInputMerge, 0, obj2, 0, audioEncoder.mInputMerge.length);
                System.arraycopy(obj, i, obj2, audioEncoder.mInputMerge.length, i2 - audioEncoder.mInputMerge.length);
                i += i2 - audioEncoder.mInputMerge.length;
                audioEncoder.mInputMerge = obj2;
            } else if (i2 < obj.length - i) {
                obj2 = new byte[i2];
                System.arraycopy(obj, i, obj2, 0, i2);
                i += i2;
                audioEncoder.mInputMerge = obj2;
                audioEncoder.mInputMergePts = 0;
            } else {
                audioEncoder.mInputMerge = obj;
                audioEncoder.mInputMergePts = j;
                if (audioEncoder.mInputMerge.length < audioEncoder.mMergeFrameLimete) {
                    return true;
                }
                inputBuffers = audioEncoder.mediaCodec.getInputBuffers();
                audioEncoder.mediaCodec.getOutputBuffers();
                dequeueInputBuffer = audioEncoder.mediaCodec.dequeueInputBuffer(j2);
                if (dequeueInputBuffer < 0) {
                    if (audioEncoder.mInputMergePts > 0) {
                        j3 = audioEncoder.mPts;
                        computePresentationTime(audioEncoder.mInputMerge.length);
                    } else {
                        audioEncoder.mPts = audioEncoder.mInputMergePts;
                        j3 = audioEncoder.mInputMergePts;
                    }
                    long j4 = j3;
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.put(audioEncoder.mInputMerge);
                    audioEncoder.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, audioEncoder.mInputMerge.length, j4, 0);
                    z2 = true;
                } else {
                    z2 = false;
                }
                audioEncoder.mInputMerge = null;
                audioEncoder.mInputMergePts = 0;
                length -= i2;
                z = z2;
            }
            long j5 = j;
            if (audioEncoder.mInputMerge.length < audioEncoder.mMergeFrameLimete) {
                return true;
            }
            inputBuffers = audioEncoder.mediaCodec.getInputBuffers();
            audioEncoder.mediaCodec.getOutputBuffers();
            dequeueInputBuffer = audioEncoder.mediaCodec.dequeueInputBuffer(j2);
            if (dequeueInputBuffer < 0) {
                z2 = false;
            } else {
                if (audioEncoder.mInputMergePts > 0) {
                    audioEncoder.mPts = audioEncoder.mInputMergePts;
                    j3 = audioEncoder.mInputMergePts;
                } else {
                    j3 = audioEncoder.mPts;
                    computePresentationTime(audioEncoder.mInputMerge.length);
                }
                long j42 = j3;
                ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                byteBuffer2.clear();
                byteBuffer2.put(audioEncoder.mInputMerge);
                audioEncoder.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, audioEncoder.mInputMerge.length, j42, 0);
                z2 = true;
            }
            audioEncoder.mInputMerge = null;
            audioEncoder.mInputMergePts = 0;
            length -= i2;
            z = z2;
        }
        return z;
    }

    private void computePresentationTime(int i) {
        this.mPts += (((((long) i) * 1000000) / ((long) this.mSampleRate)) / ((long) this.mChannelCount)) / 2;
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
        r4 = r14.TIMEOUT_USEC;
        r4 = (long) r4;
        r3 = r3.dequeueOutputBuffer(r1, r4);
        r4 = -1;
        if (r4 == r3) goto L_0x0120;
    L_0x001c:
        r4 = -3;
        if (r3 != r4) goto L_0x0026;
    L_0x001f:
        r0 = r14.mediaCodec;
        r0 = r0.getOutputBuffers();
        goto L_0x0010;
    L_0x0026:
        r4 = -2;
        r5 = 0;
        if (r3 != r4) goto L_0x0040;
    L_0x002a:
        r3 = r14.mediaCodec;
        r3 = r3.getOutputFormat();
        r4 = new com.aplayer.hardwareencode.EncoderBase$EncodeFrame;
        r4.<init>(r5, r5, r3);
        r3 = "ContentValues";
        r5 = "AudioEncoder has a new Format";
        com.aplayer.aplayerandroid.Log.i(r3, r5);
        r2.add(r4);
        goto L_0x0010;
    L_0x0040:
        if (r3 >= 0) goto L_0x0056;
    L_0x0042:
        r4 = "APlayerAndroid";
        r5 = new java.lang.StringBuilder;
        r6 = "unexpected result from encoder.dequeueOutputBuffer: ";
        r5.<init>(r6);
        r5.append(r3);
        r3 = r5.toString();
        com.aplayer.aplayerandroid.Log.e(r4, r3);
        goto L_0x0010;
    L_0x0056:
        r4 = r0[r3];
        if (r4 != 0) goto L_0x0073;
    L_0x005a:
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
    L_0x0073:
        r6 = r1.flags;
        r6 = r6 & 2;
        r7 = 0;
        if (r6 == 0) goto L_0x007c;
    L_0x007a:
        r1.size = r7;
    L_0x007c:
        r6 = r1.size;
        if (r6 == 0) goto L_0x010e;
    L_0x0080:
        r6 = "APlayerAndroid";
        r8 = new java.lang.StringBuilder;
        r9 = "Get Buffer Success! flag = ";
        r8.<init>(r9);
        r9 = r1.flags;
        r8.append(r9);
        r9 = ",pts = ";
        r8.append(r9);
        r9 = r1.presentationTimeUs;
        r8.append(r9);
        r8 = r8.toString();
        com.aplayer.aplayerandroid.Log.i(r6, r8);
        r6 = r1.offset;
        r4.position(r6);
        r6 = r1.offset;
        r8 = r1.size;
        r6 = r6 + r8;
        r4.limit(r6);
        r6 = r1.size;
        r6 = new byte[r6];
        r4.get(r6);
        r4 = com.aplayer.hardwareencode.utils.EncodeUtils.bufferInfoDup(r1);
        r8 = r6.length;
        r4.size = r8;
        r4.offset = r7;
        r8 = r14.mFirstPts;
        r10 = -1;
        r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r12 != 0) goto L_0x00dd;
    L_0x00c4:
        r8 = r4.presentationTimeUs;
        r14.mFirstPts = r8;
        r8 = "APlayerAndroid";
        r9 = new java.lang.StringBuilder;
        r10 = "firstPts = ";
        r9.<init>(r10);
        r10 = r14.mFirstPts;
        r9.append(r10);
        r9 = r9.toString();
        com.aplayer.aplayerandroid.Log.i(r8, r9);
    L_0x00dd:
        r8 = r4.presentationTimeUs;
        r10 = r14.mFirstPts;
        r12 = r8 - r10;
        r4.presentationTimeUs = r12;
        r8 = "APlayerAndroid";
        r9 = new java.lang.StringBuilder;
        r10 = "audio presentationTimeUs = ";
        r9.<init>(r10);
        r10 = r4.presentationTimeUs;
        r9.append(r10);
        r9 = r9.toString();
        com.aplayer.aplayerandroid.Log.i(r8, r9);
        r8 = new com.aplayer.hardwareencode.EncoderBase$EncodeFrame;
        r8.<init>(r6, r4, r5);
        r5 = r4.presentationTimeUs;
        r9 = r14.mLastpts;
        r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
        if (r11 <= 0) goto L_0x010e;
    L_0x0107:
        r2.add(r8);
        r4 = r4.presentationTimeUs;
        r14.mLastpts = r4;
    L_0x010e:
        r4 = r14.mediaCodec;
        r4.releaseOutputBuffer(r3, r7);
        r3 = r1.flags;
        r3 = r3 & 4;
        if (r3 == 0) goto L_0x0010;
    L_0x0119:
        r0 = "APlayerAndroid";
        r1 = "reached end of stream unexpectedly";
        com.aplayer.aplayerandroid.Log.e(r0, r1);
    L_0x0120:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.hardwareencode.AudioEncoder.fetchEncodeData():java.util.List<com.aplayer.hardwareencode.EncoderBase$EncodeFrame>");
    }

    public MediaFormat getMediaFormat() {
        return this.mediaCodec != null ? this.mediaCodec.getOutputFormat() : null;
    }

    public static int indexOfArray(int[] iArr, int i) {
        int i2 = 0;
        while (iArr != null && i2 < iArr.length) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final int[] getSupportSampleRate(ENCODE_FORMAT encode_format) {
        return encode_format == ENCODE_FORMAT.AUDIO_AAC ? AAC_STANDARD_SAMPLE_RATE : null;
    }
}
