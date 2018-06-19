package com.aplayer.aplayerandroid;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.aplayer.aplayerandroid.SurfaceRenderer.TextureArea;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class HardwareDecoder {
    private static String TAG = "APlayerAndroid_HD";
    private static HashMap<Integer, String> mAVCodeIDToMime = new HashMap();
    private Object lock = new Object();
    private APlayerAndroid mAPlayerAndroid;
    private ByteBuffer mBbcsd;
    private int mCodeId = 0;
    private boolean mCodecStopFlage = false;
    private MediaCodec mDecoder = null;
    private int mFFmpegLevel = -1;
    private int mFFmpegProfile = -1;
    private String mHWDecoderName = null;
    private boolean mIsFormatOutputed = false;
    private OnDecoderOneFrameListener mOnDecoderOneFrameListener;
    private long mRealTimeUs = 0;
    private SurfaceRenderer mSurfaceRenderer = null;
    private int mSurfaceType = 0;

    private class AV_CODEC_ID {
        private static final int AV_CODEC_ID_H264 = 28;
        private static final int AV_CODEC_ID_H265 = 174;
        private static final int AV_CODEC_ID_MPEG4 = 13;

        private AV_CODEC_ID() {
        }
    }

    public interface OnDecoderOneFrameListener {
        void onDecoderOneFrame();
    }

    HardwareDecoder(APlayerAndroid aPlayerAndroid) {
        mAVCodeIDToMime.put(Integer.valueOf(28), "video/avc");
        mAVCodeIDToMime.put(Integer.valueOf(13), "video/mp4v-es");
        mAVCodeIDToMime.put(Integer.valueOf(Opcodes.DIV_DOUBLE), "video/hevc");
        this.mAPlayerAndroid = aPlayerAndroid;
    }

    public int FindHardWareDecoder(int i) {
        this.mCodeId = i;
        i = TAG;
        StringBuilder stringBuilder = new StringBuilder("sdk version ");
        stringBuilder.append(VERSION.SDK_INT);
        Log.e(i, stringBuilder.toString());
        if (VERSION.SDK_INT < 16) {
            return 0;
        }
        if (VERSION.SDK_INT < 21) {
            return FindHardWareDecoder16();
        }
        return FindHardWareDecoder21();
    }

    public int FindHardWareDecoder16() {
        String str = (String) mAVCodeIDToMime.get(Integer.valueOf(this.mCodeId));
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("mimeType = ");
        stringBuilder.append(str);
        stringBuilder.append("codeid = ");
        stringBuilder.append(this.mCodeId);
        Log.e(str2, stringBuilder.toString());
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    String equalsIgnoreCase2;
                    if (equalsIgnoreCase2.equalsIgnoreCase(str)) {
                        equalsIgnoreCase2 = codecInfoAt.getName();
                        String str3 = TAG;
                        StringBuilder stringBuilder2 = new StringBuilder("hwDecoderName = ");
                        stringBuilder2.append(equalsIgnoreCase2);
                        Log.e(str3, stringBuilder2.toString());
                        if (equalsIgnoreCase2.indexOf("google") == -1) {
                            this.mHWDecoderName = equalsIgnoreCase2;
                            return 1;
                        }
                    }
                }
                continue;
            }
        }
        return 0;
    }

    public int FindHardWareDecoder21() {
        String str = (String) mAVCodeIDToMime.get(Integer.valueOf(this.mCodeId));
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("mimeType = ");
        stringBuilder.append(str);
        stringBuilder.append("codeid = ");
        stringBuilder.append(this.mCodeId);
        Log.e(str2, stringBuilder.toString());
        MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
        for (MediaCodecInfo mediaCodecInfo : codecInfos) {
            if (!mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    String equalsIgnoreCase2;
                    if (equalsIgnoreCase2.equalsIgnoreCase(str)) {
                        equalsIgnoreCase2 = mediaCodecInfo.getName();
                        String str3 = TAG;
                        StringBuilder stringBuilder2 = new StringBuilder("hwDecoderName = ");
                        stringBuilder2.append(equalsIgnoreCase2);
                        Log.e(str3, stringBuilder2.toString());
                        if (equalsIgnoreCase2.indexOf("google") == -1) {
                            this.mHWDecoderName = equalsIgnoreCase2;
                            return 1;
                        }
                    }
                }
                continue;
            }
        }
        return 0;
    }

    public Bitmap getCurrentScreenshot() {
        return this.mSurfaceRenderer != null ? this.mSurfaceRenderer.getScreenshot() : null;
    }

    public int CreateCodec(ByteBuffer byteBuffer, int i, int i2) {
        HardwareDecoder hardwareDecoder = this;
        ByteBuffer byteBuffer2 = byteBuffer;
        Log.i(TAG, "HardwareDecoder:CreateCodec");
        if (byteBuffer2 == null) {
            Log.e(TAG, "HardwareDecoder:CreateCodec bbcsd == null");
            return -1;
        }
        int videoHeight = hardwareDecoder.mAPlayerAndroid.getVideoHeight();
        int videoWidth = hardwareDecoder.mAPlayerAndroid.getVideoWidth();
        long duration = ((long) hardwareDecoder.mAPlayerAndroid.getDuration()) * 1000;
        Surface surface = null;
        if (hardwareDecoder.mSurfaceType == 0) {
            surface = hardwareDecoder.mAPlayerAndroid.getInnerSurface();
        } else if (hardwareDecoder.mSurfaceType == 2) {
            hardwareDecoder.mSurfaceRenderer = new SurfaceRenderer(hardwareDecoder.mAPlayerAndroid, hardwareDecoder.mAPlayerAndroid.getInnerSurface(), hardwareDecoder.mAPlayerAndroid.getViewSurfaceWidth(), hardwareDecoder.mAPlayerAndroid.getViewSurfaceHeight(), videoWidth, videoHeight);
            surface = hardwareDecoder.mSurfaceRenderer.GetSurface();
        }
        if (surface == null) {
            Log.e(TAG, "HardWareDecoder CreateCodec surface == null");
            return -1;
        }
        hardwareDecoder.mBbcsd = byteBuffer2;
        if (hardwareDecoder.mCodeId == 28) {
            hardwareDecoder.mFFmpegProfile = i;
            hardwareDecoder.mFFmpegLevel = i2;
        }
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger(SocializeProtocolConstants.HEIGHT, videoHeight);
        mediaFormat.setInteger(SocializeProtocolConstants.WIDTH, videoWidth);
        mediaFormat.setString("mime", (String) mAVCodeIDToMime.get(Integer.valueOf(hardwareDecoder.mCodeId)));
        mediaFormat.setLong("durationUs", duration);
        mediaFormat.setByteBuffer("csd-0", hardwareDecoder.mBbcsd);
        hardwareDecoder.mBbcsd.position(0);
        if (CreateCodec(mediaFormat, surface)) {
            return 1;
        }
        return 0;
    }

    public int stopCodec() {
        String str;
        StringBuilder stringBuilder;
        Log.i(TAG, "HardwareDecoder stopCodec");
        this.mCodecStopFlage = true;
        if (this.mDecoder != null) {
            synchronized (this) {
                if (this.mSurfaceType == 2 && this.mSurfaceRenderer != null) {
                    this.mSurfaceRenderer.release();
                    this.mSurfaceRenderer = null;
                }
                try {
                    this.mDecoder.stop();
                } catch (Exception e) {
                    str = TAG;
                    stringBuilder = new StringBuilder("HardwareDecoder stopCodec stop is fail");
                    stringBuilder.append(e.toString());
                    Log.e(str, stringBuilder.toString());
                }
                try {
                    this.mDecoder.release();
                } catch (Exception e2) {
                    str = TAG;
                    stringBuilder = new StringBuilder("HardwareDecoder stopCodec release is fail");
                    stringBuilder.append(e2.toString());
                    Log.e(str, stringBuilder.toString());
                }
                this.mDecoder = null;
                this.mIsFormatOutputed = false;
            }
        }
        return 1;
    }

    public boolean IsCodecPrepare() {
        return this.mDecoder != null;
    }

    public int ReCreateCodec() {
        if (this.mHWDecoderName != null && this.mDecoder == null) {
            CreateCodec(this.mBbcsd, this.mFFmpegProfile, this.mFFmpegLevel);
        }
        return 1;
    }

    public void setRenderType(int i) {
        this.mSurfaceType = i;
    }

    private boolean CreateCodec(MediaFormat mediaFormat, Surface surface) {
        Log.i(TAG, "HardwareDecoder CreateCodec enter");
        if (!(this.mHWDecoderName == null || this.mHWDecoderName.length() == 0)) {
            if (this.mDecoder == null) {
                synchronized (this) {
                    try {
                        this.mDecoder = MediaCodec.createByCodecName(this.mHWDecoderName);
                        if (VERSION.SDK_INT < 18 || this.mCodeId != 28 || isSupports(this.mDecoder.getCodecInfo(), (String) mAVCodeIDToMime.get(Integer.valueOf(this.mCodeId)), FF2AndroidMapper.convert2AndroidProfile(this.mFFmpegProfile), FF2AndroidMapper.convert2AndroidLevel(this.mFFmpegLevel))) {
                            try {
                                this.mDecoder.configure(mediaFormat, surface, null, 0);
                                this.mDecoder.start();
                                this.mIsFormatOutputed = false;
                                this.mCodecStopFlage = false;
                                Log.i(TAG, "HardwareDecoder CreateCodec leave");
                                return true;
                            } catch (MediaFormat mediaFormat2) {
                                mediaFormat2.printStackTrace();
                                Log.e(TAG, "configure fail");
                                stopCodec();
                                return false;
                            }
                        }
                        stopCodec();
                        mediaFormat2 = TAG;
                        surface = new StringBuilder("h264 profile not support ");
                        surface.append(FF2AndroidMapper.getAVCProfileName(FF2AndroidMapper.convert2AndroidProfile(this.mFFmpegProfile)));
                        surface.append("/");
                        surface.append(FF2AndroidMapper.getAndroidAVCLevelName(FF2AndroidMapper.convert2AndroidLevel(this.mFFmpegLevel)));
                        Log.e(mediaFormat2, surface.toString());
                        return false;
                    } catch (MediaFormat mediaFormat22) {
                        mediaFormat22.printStackTrace();
                        mediaFormat22 = TAG;
                        surface = new StringBuilder("createByCodecName fail mHWDecoderName = ");
                        surface.append(this.mHWDecoderName);
                        Log.e(mediaFormat22, surface.toString());
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private boolean isSupports(android.media.MediaCodecInfo r3, java.lang.String r4, int r5, int r6) {
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
        r6 = 0;
        r3 = r3.getCapabilitiesForType(r4);	 Catch:{ IllegalArgumentException -> 0x0016 }
        r3 = r3.profileLevels;	 Catch:{ IllegalArgumentException -> 0x0016 }
        r4 = r3.length;	 Catch:{ IllegalArgumentException -> 0x0016 }
        r0 = r6;	 Catch:{ IllegalArgumentException -> 0x0016 }
    L_0x0009:
        if (r0 >= r4) goto L_0x0016;	 Catch:{ IllegalArgumentException -> 0x0016 }
    L_0x000b:
        r1 = r3[r0];	 Catch:{ IllegalArgumentException -> 0x0016 }
        r1 = r1.profile;	 Catch:{ IllegalArgumentException -> 0x0016 }
        if (r1 != r5) goto L_0x0013;
    L_0x0011:
        r3 = 1;
        return r3;
    L_0x0013:
        r0 = r0 + 1;
        goto L_0x0009;
    L_0x0016:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.aplayerandroid.HardwareDecoder.isSupports(android.media.MediaCodecInfo, java.lang.String, int, int):boolean");
    }

    public int FlushCodec() {
        Log.i(TAG, "HardwareDecoder FlushCodec");
        synchronized (this) {
            if (this.mDecoder != null && this.mIsFormatOutputed) {
                try {
                    this.mDecoder.flush();
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                }
            }
        }
        return 1;
    }

    public int Decode(ByteBuffer byteBuffer, int i, boolean z) {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (VERSION.SDK_INT < 21) {
                byteBuffer = Decode16(byteBuffer, i, z);
                return byteBuffer;
            }
            byteBuffer = Decode21(byteBuffer, i, z);
            return byteBuffer;
        }
    }

    public int Decode16(java.nio.ByteBuffer r25, int r26, boolean r27) {
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
        r24 = this;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r5 = TAG;
        r6 = new java.lang.StringBuilder;
        r7 = "Decode enter timestamp = ";
        r6.<init>(r7);
        r6.append(r3);
        r6 = r6.toString();
        com.aplayer.aplayerandroid.Log.i(r5, r6);
        r5 = r1.mDecoder;
        r6 = 0;
        if (r5 != 0) goto L_0x0021;
    L_0x0020:
        return r6;
    L_0x0021:
        r7 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r7 = r7.getInputBuffers();	 Catch:{ Exception -> 0x013a }
        r8 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r8.getOutputBuffers();	 Catch:{ Exception -> 0x013a }
        r8 = new android.media.MediaCodec$BufferInfo;	 Catch:{ Exception -> 0x013a }
        r8.<init>();	 Catch:{ Exception -> 0x013a }
        r9 = 1;	 Catch:{ Exception -> 0x013a }
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x013a }
        r12 = 0;	 Catch:{ Exception -> 0x013a }
        if (r2 == 0) goto L_0x00c8;	 Catch:{ Exception -> 0x013a }
    L_0x0038:
        r14 = r7;	 Catch:{ Exception -> 0x013a }
        r15 = r12;	 Catch:{ Exception -> 0x013a }
        r7 = -1;	 Catch:{ Exception -> 0x013a }
    L_0x003b:
        r5 = r1.mCodecStopFlage;	 Catch:{ Exception -> 0x013a }
        if (r5 != 0) goto L_0x00ab;	 Catch:{ Exception -> 0x013a }
    L_0x003f:
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r7 = r5.dequeueInputBuffer(r10);	 Catch:{ Exception -> 0x013a }
        if (r7 >= 0) goto L_0x00ab;	 Catch:{ Exception -> 0x013a }
    L_0x0047:
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r5 = r5.dequeueOutputBuffer(r8, r10);	 Catch:{ Exception -> 0x013a }
        switch(r5) {
            case -3: goto L_0x007c;
            case -2: goto L_0x0053;
            case -1: goto L_0x0077;
            default: goto L_0x0050;
        };	 Catch:{ Exception -> 0x013a }
    L_0x0050:
        r9 = r8.presentationTimeUs;	 Catch:{ Exception -> 0x013a }
        goto L_0x0083;	 Catch:{ Exception -> 0x013a }
    L_0x0053:
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r5 = r5.getOutputFormat();	 Catch:{ Exception -> 0x013a }
        r1.updateTextureArea(r5);	 Catch:{ Exception -> 0x013a }
        r1.mIsFormatOutputed = r9;	 Catch:{ Exception -> 0x013a }
        r6 = TAG;	 Catch:{ Exception -> 0x013a }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013a }
        r10 = "KEY_COLOR_FORMAT =  ";	 Catch:{ Exception -> 0x013a }
        r9.<init>(r10);	 Catch:{ Exception -> 0x013a }
        r10 = "color-format";	 Catch:{ Exception -> 0x013a }
        r5 = r5.getInteger(r10);	 Catch:{ Exception -> 0x013a }
        r9.append(r5);	 Catch:{ Exception -> 0x013a }
        r5 = r9.toString();	 Catch:{ Exception -> 0x013a }
        com.aplayer.aplayerandroid.Log.e(r6, r5);	 Catch:{ Exception -> 0x013a }
    L_0x0077:
        r6 = 0;	 Catch:{ Exception -> 0x013a }
        r9 = 1;	 Catch:{ Exception -> 0x013a }
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x013a }
        goto L_0x003b;	 Catch:{ Exception -> 0x013a }
    L_0x007c:
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r14 = r5.getInputBuffers();	 Catch:{ Exception -> 0x013a }
        goto L_0x0077;	 Catch:{ Exception -> 0x013a }
    L_0x0083:
        r6 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1));	 Catch:{ Exception -> 0x013a }
        if (r6 >= 0) goto L_0x0088;	 Catch:{ Exception -> 0x013a }
    L_0x0087:
        r9 = r12;	 Catch:{ Exception -> 0x013a }
    L_0x0088:
        r6 = TAG;	 Catch:{ Exception -> 0x013a }
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013a }
        r15 = "realTimeUs = ";	 Catch:{ Exception -> 0x013a }
        r11.<init>(r15);	 Catch:{ Exception -> 0x013a }
        r11.append(r9);	 Catch:{ Exception -> 0x013a }
        r11 = r11.toString();	 Catch:{ Exception -> 0x013a }
        com.aplayer.aplayerandroid.Log.e(r6, r11);	 Catch:{ Exception -> 0x013a }
        r6 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r6.releaseOutputBuffer(r5, r4);	 Catch:{ Exception -> 0x013a }
        r5 = r1.mOnDecoderOneFrameListener;	 Catch:{ Exception -> 0x013a }
        if (r5 == 0) goto L_0x00a9;	 Catch:{ Exception -> 0x013a }
    L_0x00a4:
        r5 = r1.mOnDecoderOneFrameListener;	 Catch:{ Exception -> 0x013a }
        r5.onDecoderOneFrame();	 Catch:{ Exception -> 0x013a }
    L_0x00a9:
        r15 = r9;	 Catch:{ Exception -> 0x013a }
        goto L_0x0077;	 Catch:{ Exception -> 0x013a }
    L_0x00ab:
        r18 = r7;	 Catch:{ Exception -> 0x013a }
        if (r18 < 0) goto L_0x00c6;	 Catch:{ Exception -> 0x013a }
    L_0x00af:
        r5 = r14[r18];	 Catch:{ Exception -> 0x013a }
        r5.put(r2);	 Catch:{ Exception -> 0x013a }
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r19 = 0;	 Catch:{ Exception -> 0x013a }
        r20 = r25.limit();	 Catch:{ Exception -> 0x013a }
        r2 = (long) r3;	 Catch:{ Exception -> 0x013a }
        r23 = 0;	 Catch:{ Exception -> 0x013a }
        r17 = r5;	 Catch:{ Exception -> 0x013a }
        r21 = r2;	 Catch:{ Exception -> 0x013a }
        r17.queueInputBuffer(r18, r19, r20, r21, r23);	 Catch:{ Exception -> 0x013a }
    L_0x00c6:
        r2 = r15;	 Catch:{ Exception -> 0x013a }
        goto L_0x00c9;	 Catch:{ Exception -> 0x013a }
    L_0x00c8:
        r2 = r12;	 Catch:{ Exception -> 0x013a }
    L_0x00c9:
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x013a }
        r5 = r5.dequeueOutputBuffer(r8, r6);	 Catch:{ Exception -> 0x013a }
        switch(r5) {
            case -3: goto L_0x0100;
            case -2: goto L_0x00d9;
            case -1: goto L_0x00d7;
            default: goto L_0x00d4;
        };	 Catch:{ Exception -> 0x013a }
    L_0x00d4:
        r2 = r8.presentationTimeUs;	 Catch:{ Exception -> 0x013a }
        goto L_0x0107;	 Catch:{ Exception -> 0x013a }
    L_0x00d7:
        r2 = (int) r2;	 Catch:{ Exception -> 0x013a }
        return r2;	 Catch:{ Exception -> 0x013a }
    L_0x00d9:
        r2 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r2 = r2.getOutputFormat();	 Catch:{ Exception -> 0x013a }
        r1.updateTextureArea(r2);	 Catch:{ Exception -> 0x013a }
        r3 = 1;	 Catch:{ Exception -> 0x013a }
        r1.mIsFormatOutputed = r3;	 Catch:{ Exception -> 0x013a }
        r3 = TAG;	 Catch:{ Exception -> 0x013a }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013a }
        r5 = "KEY_COLOR_FORMAT =  ";	 Catch:{ Exception -> 0x013a }
        r4.<init>(r5);	 Catch:{ Exception -> 0x013a }
        r5 = "color-format";	 Catch:{ Exception -> 0x013a }
        r2 = r2.getInteger(r5);	 Catch:{ Exception -> 0x013a }
        r4.append(r2);	 Catch:{ Exception -> 0x013a }
        r2 = r4.toString();	 Catch:{ Exception -> 0x013a }
        com.aplayer.aplayerandroid.Log.e(r3, r2);	 Catch:{ Exception -> 0x013a }
        r2 = 0;	 Catch:{ Exception -> 0x013a }
        return r2;	 Catch:{ Exception -> 0x013a }
    L_0x0100:
        r2 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r2.getOutputBuffers();	 Catch:{ Exception -> 0x013a }
        r2 = 0;	 Catch:{ Exception -> 0x013a }
        return r2;	 Catch:{ Exception -> 0x013a }
    L_0x0107:
        r6 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));	 Catch:{ Exception -> 0x013a }
        if (r6 >= 0) goto L_0x010c;	 Catch:{ Exception -> 0x013a }
    L_0x010b:
        goto L_0x010d;	 Catch:{ Exception -> 0x013a }
    L_0x010c:
        r12 = r2;	 Catch:{ Exception -> 0x013a }
    L_0x010d:
        r2 = TAG;	 Catch:{ Exception -> 0x013a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013a }
        r6 = "realTimeUs = ";	 Catch:{ Exception -> 0x013a }
        r3.<init>(r6);	 Catch:{ Exception -> 0x013a }
        r3.append(r12);	 Catch:{ Exception -> 0x013a }
        r3 = r3.toString();	 Catch:{ Exception -> 0x013a }
        com.aplayer.aplayerandroid.Log.i(r2, r3);	 Catch:{ Exception -> 0x013a }
        r2 = r1.mDecoder;	 Catch:{ Exception -> 0x013a }
        r2.releaseOutputBuffer(r5, r4);	 Catch:{ Exception -> 0x013a }
        r2 = r1.mOnDecoderOneFrameListener;	 Catch:{ Exception -> 0x013a }
        if (r2 == 0) goto L_0x012e;	 Catch:{ Exception -> 0x013a }
    L_0x0129:
        r2 = r1.mOnDecoderOneFrameListener;	 Catch:{ Exception -> 0x013a }
        r2.onDecoderOneFrame();	 Catch:{ Exception -> 0x013a }
    L_0x012e:
        r2 = r1.lock;	 Catch:{ Exception -> 0x013a }
        monitor-enter(r2);	 Catch:{ Exception -> 0x013a }
        r1.mRealTimeUs = r12;	 Catch:{ all -> 0x0136 }
        monitor-exit(r2);	 Catch:{ all -> 0x0136 }
        r2 = (int) r12;	 Catch:{ all -> 0x0136 }
        return r2;	 Catch:{ all -> 0x0136 }
    L_0x0136:
        r0 = move-exception;	 Catch:{ all -> 0x0136 }
        r3 = r0;	 Catch:{ all -> 0x0136 }
        monitor-exit(r2);	 Catch:{ all -> 0x0136 }
        throw r3;	 Catch:{ Exception -> 0x013a }
    L_0x013a:
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.aplayerandroid.HardwareDecoder.Decode16(java.nio.ByteBuffer, int, boolean):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int Decode21(java.nio.ByteBuffer r24, int r25, boolean r26) {
        /*
        r23 = this;
        r1 = r23;
        r2 = r24;
        r3 = r25;
        r4 = r26;
        r5 = "HardwareDecoder";
        r6 = new java.lang.StringBuilder;
        r7 = "HardwareDecoder21 Decode java enter timestamp = ";
        r6.<init>(r7);
        r6.append(r3);
        r7 = " size = ";
        r6.append(r7);
        r7 = r24.remaining();
        r6.append(r7);
        r6 = r6.toString();
        com.aplayer.aplayerandroid.Log.i(r5, r6);
        r5 = r1.mDecoder;
        r6 = 0;
        if (r5 != 0) goto L_0x002d;
    L_0x002c:
        return r6;
    L_0x002d:
        r7 = new android.media.MediaCodec$BufferInfo;	 Catch:{ Exception -> 0x014b }
        r7.<init>();	 Catch:{ Exception -> 0x014b }
        r8 = 1;
        r9 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        if (r2 == 0) goto L_0x00d3;
    L_0x0037:
        r13 = -1;
        r14 = 0;
    L_0x003a:
        r5 = r1.mCodecStopFlage;	 Catch:{ Exception -> 0x014b }
        if (r5 != 0) goto L_0x00b3;
    L_0x003e:
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        r11 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r13 = r5.dequeueInputBuffer(r11);	 Catch:{ Exception -> 0x014b }
        if (r13 >= 0) goto L_0x00b3;
    L_0x0048:
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        r5 = r5.dequeueOutputBuffer(r7, r9);	 Catch:{ Exception -> 0x014b }
        switch(r5) {
            case -3: goto L_0x0080;
            case -2: goto L_0x005c;
            case -1: goto L_0x0054;
            default: goto L_0x0051;
        };	 Catch:{ Exception -> 0x014b }
    L_0x0051:
        r6 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        goto L_0x0082;
    L_0x0054:
        r5 = TAG;	 Catch:{ Exception -> 0x014b }
        r11 = "HardwareDecoder21 Decode java INFO_TRY_AGAIN_LATER ";
        com.aplayer.aplayerandroid.Log.i(r5, r11);	 Catch:{ Exception -> 0x014b }
        goto L_0x0080;
    L_0x005c:
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        r5 = r5.getOutputFormat();	 Catch:{ Exception -> 0x014b }
        r1.mIsFormatOutputed = r8;	 Catch:{ Exception -> 0x014b }
        r1.updateTextureArea(r5);	 Catch:{ Exception -> 0x014b }
        r11 = TAG;	 Catch:{ Exception -> 0x014b }
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014b }
        r6 = "HardwareDecoder21 Decode java KEY_COLOR_FORMAT =  ";
        r12.<init>(r6);	 Catch:{ Exception -> 0x014b }
        r6 = "color-format";
        r5 = r5.getInteger(r6);	 Catch:{ Exception -> 0x014b }
        r12.append(r5);	 Catch:{ Exception -> 0x014b }
        r5 = r12.toString();	 Catch:{ Exception -> 0x014b }
        com.aplayer.aplayerandroid.Log.e(r11, r5);	 Catch:{ Exception -> 0x014b }
    L_0x0080:
        r6 = 0;
        goto L_0x003a;
    L_0x0082:
        r6.getOutputBuffer(r5);	 Catch:{ Exception -> 0x014b }
        r6 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        r6.releaseOutputBuffer(r5, r4);	 Catch:{ Exception -> 0x014b }
        r5 = r1.mOnDecoderOneFrameListener;	 Catch:{ Exception -> 0x014b }
        if (r5 == 0) goto L_0x0093;
    L_0x008e:
        r5 = r1.mOnDecoderOneFrameListener;	 Catch:{ Exception -> 0x014b }
        r5.onDecoderOneFrame();	 Catch:{ Exception -> 0x014b }
    L_0x0093:
        r11 = r7.presentationTimeUs;	 Catch:{ Exception -> 0x014b }
        r5 = 0;
        r14 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r14 >= 0) goto L_0x009e;
    L_0x009b:
        r14 = 0;
        goto L_0x009f;
    L_0x009e:
        r14 = r11;
    L_0x009f:
        r5 = TAG;	 Catch:{ Exception -> 0x014b }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014b }
        r11 = "HardwareDecoder21 Decode java releaseOutputBuffer realTimeUs = ";
        r6.<init>(r11);	 Catch:{ Exception -> 0x014b }
        r6.append(r14);	 Catch:{ Exception -> 0x014b }
        r6 = r6.toString();	 Catch:{ Exception -> 0x014b }
        com.aplayer.aplayerandroid.Log.i(r5, r6);	 Catch:{ Exception -> 0x014b }
        goto L_0x0080;
    L_0x00b3:
        if (r13 < 0) goto L_0x00d5;
    L_0x00b5:
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        r5 = r5.getInputBuffer(r13);	 Catch:{ Exception -> 0x014b }
        r5.put(r2);	 Catch:{ Exception -> 0x014b }
        r5 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        r18 = 0;
        r19 = r24.limit();	 Catch:{ Exception -> 0x014b }
        r2 = (long) r3;	 Catch:{ Exception -> 0x014b }
        r22 = 0;
        r16 = r5;
        r17 = r13;
        r20 = r2;
        r16.queueInputBuffer(r17, r18, r19, r20, r22);	 Catch:{ Exception -> 0x014b }
        goto L_0x00d5;
    L_0x00d3:
        r14 = 0;
    L_0x00d5:
        r2 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        r2 = r2.dequeueOutputBuffer(r7, r9);	 Catch:{ Exception -> 0x014b }
        switch(r2) {
            case -3: goto L_0x0110;
            case -2: goto L_0x00ea;
            case -1: goto L_0x00e1;
            default: goto L_0x00de;
        };	 Catch:{ Exception -> 0x014b }
    L_0x00de:
        r3 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        goto L_0x0112;
    L_0x00e1:
        r2 = TAG;	 Catch:{ Exception -> 0x014b }
        r3 = "HardwareDecoder21 Decode java INFO_TRY_AGAIN_LATER ";
        com.aplayer.aplayerandroid.Log.i(r2, r3);	 Catch:{ Exception -> 0x014b }
        r2 = (int) r14;	 Catch:{ Exception -> 0x014b }
        return r2;
    L_0x00ea:
        r2 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        r2 = r2.getOutputFormat();	 Catch:{ Exception -> 0x014b }
        r3 = TAG;	 Catch:{ Exception -> 0x014b }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014b }
        r5 = "HardwareDecoder21 Decode java KEY_COLOR_FORMAT =  ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x014b }
        r5 = "color-format";
        r5 = r2.getInteger(r5);	 Catch:{ Exception -> 0x014b }
        r4.append(r5);	 Catch:{ Exception -> 0x014b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x014b }
        com.aplayer.aplayerandroid.Log.i(r3, r4);	 Catch:{ Exception -> 0x014b }
        r1.mIsFormatOutputed = r8;	 Catch:{ Exception -> 0x014b }
        r1.updateTextureArea(r2);	 Catch:{ Exception -> 0x014b }
        r2 = 0;
        return r2;
    L_0x0110:
        r2 = 0;
        return r2;
    L_0x0112:
        r3.getOutputBuffer(r2);	 Catch:{ Exception -> 0x014b }
        r3 = r1.mDecoder;	 Catch:{ Exception -> 0x014b }
        r3.releaseOutputBuffer(r2, r4);	 Catch:{ Exception -> 0x014b }
        r2 = r1.mOnDecoderOneFrameListener;	 Catch:{ Exception -> 0x014b }
        if (r2 == 0) goto L_0x0123;
    L_0x011e:
        r2 = r1.mOnDecoderOneFrameListener;	 Catch:{ Exception -> 0x014b }
        r2.onDecoderOneFrame();	 Catch:{ Exception -> 0x014b }
    L_0x0123:
        r11 = r7.presentationTimeUs;	 Catch:{ Exception -> 0x014b }
        r5 = 0;
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x012c;
    L_0x012b:
        r11 = r5;
    L_0x012c:
        r2 = TAG;	 Catch:{ Exception -> 0x014b }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014b }
        r4 = "HardwareDecoder21 Decode java realTimeUs = ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x014b }
        r3.append(r11);	 Catch:{ Exception -> 0x014b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x014b }
        com.aplayer.aplayerandroid.Log.i(r2, r3);	 Catch:{ Exception -> 0x014b }
        r2 = r1.lock;	 Catch:{ Exception -> 0x014b }
        monitor-enter(r2);	 Catch:{ Exception -> 0x014b }
        r1.mRealTimeUs = r11;	 Catch:{ all -> 0x0147 }
        monitor-exit(r2);	 Catch:{ all -> 0x0147 }
        r2 = (int) r11;	 Catch:{ all -> 0x0147 }
        return r2;
    L_0x0147:
        r0 = move-exception;
        r3 = r0;
        monitor-exit(r2);	 Catch:{ all -> 0x0147 }
        throw r3;	 Catch:{ Exception -> 0x014b }
    L_0x014b:
        r0 = move-exception;
        r2 = r0;
        r3 = TAG;
        r4 = new java.lang.StringBuilder;
        r5 = "decode failed:";
        r4.<init>(r5);
        r2 = r2.getMessage();
        r4.append(r2);
        r2 = r4.toString();
        com.aplayer.aplayerandroid.Log.e(r3, r2);
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.aplayerandroid.HardwareDecoder.Decode21(java.nio.ByteBuffer, int, boolean):int");
    }

    protected long getRealTimeUs() {
        long j;
        synchronized (this.lock) {
            j = this.mRealTimeUs;
        }
        return j;
    }

    @TargetApi(16)
    private void updateTextureArea(MediaFormat mediaFormat) {
        TextureArea textureArea = new TextureArea();
        textureArea.mTextureWidth = (float) mediaFormat.getInteger(SocializeProtocolConstants.WIDTH);
        textureArea.mTextureHeight = (float) mediaFormat.getInteger(SocializeProtocolConstants.HEIGHT);
        if (mediaFormat.containsKey("crop-left")) {
            textureArea.m_crop_left = (float) mediaFormat.getInteger("crop-left");
        }
        if (mediaFormat.containsKey("crop-right")) {
            textureArea.m_crop_right = (float) mediaFormat.getInteger("crop-right");
        }
        if (mediaFormat.containsKey("crop-top")) {
            textureArea.m_crop_top = (float) mediaFormat.getInteger("crop-top");
        }
        if (mediaFormat.containsKey("crop-bottom")) {
            textureArea.m_crop_bottom = (float) mediaFormat.getInteger("crop-bottom");
        }
        if (this.mSurfaceRenderer != null) {
            this.mSurfaceRenderer.setTextureArea(textureArea);
        }
    }

    public void setOnDecoderOneFrameListener(OnDecoderOneFrameListener onDecoderOneFrameListener) {
        this.mOnDecoderOneFrameListener = onDecoderOneFrameListener;
    }
}
