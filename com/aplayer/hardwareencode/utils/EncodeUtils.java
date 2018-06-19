package com.aplayer.hardwareencode.utils;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.util.Range;
import java.io.IOException;

public class EncodeUtils {
    private static final String ERROR_TAGE;
    private static final String TAG = "APlayerAndroid";
    private static final String TAGE;

    public static class EncodeVideoCapability {
        public int[] colorFormat = null;
        public int heightAlignment = 0;
        public int heightLower = 0;
        public int heightUpper = 0;
        public ProfileLevel[] profileLevel = null;
        public int widthAlignment = 0;
        public int widthLower = 0;
        public int widthUpper = 0;

        public static class ProfileLevel {
            int level;
            int profile;

            public ProfileLevel(int i, int i2) {
                this.profile = i;
                this.level = i2;
            }
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder("AplayerAndroid_");
        stringBuilder.append(EncodeUtils.class.getSimpleName());
        ERROR_TAGE = stringBuilder.toString();
        stringBuilder = new StringBuilder("AplayerAndroid_");
        stringBuilder.append(EncodeUtils.class.getSimpleName());
        TAGE = stringBuilder.toString();
    }

    public static BufferInfo bufferInfoDup(BufferInfo bufferInfo) {
        BufferInfo bufferInfo2 = new BufferInfo();
        bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
        return bufferInfo2;
    }

    public static void showCodecInfo() {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                new StringBuilder("CodecName:").append(codecInfoAt.getName());
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                String str = "";
                for (String str2 : supportedTypes) {
                    StringBuilder stringBuilder;
                    if (!str2.isEmpty()) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str2);
                        stringBuilder.append(",  ");
                        str2 = stringBuilder.toString();
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(str2);
                    str2 = stringBuilder.toString();
                }
            }
        }
    }

    private static String FindHardWareEncoder16(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    String equalsIgnoreCase2;
                    if (equalsIgnoreCase2.equalsIgnoreCase(str)) {
                        equalsIgnoreCase2 = codecInfoAt.getName();
                        if ((equalsIgnoreCase2.indexOf("google") == -1 ? 1 : null) != null) {
                            return equalsIgnoreCase2;
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    private static String FindHardWareEncoder21(String str) {
        MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
        for (MediaCodecInfo mediaCodecInfo : codecInfos) {
            if (mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    String equalsIgnoreCase2;
                    if (equalsIgnoreCase2.equalsIgnoreCase(str)) {
                        equalsIgnoreCase2 = mediaCodecInfo.getName();
                        if ((equalsIgnoreCase2.indexOf("google") == -1 ? 1 : 0) != 0) {
                            return equalsIgnoreCase2;
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static String findHardwareEncodeeName(String str) {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        if (VERSION.SDK_INT < 21) {
            return FindHardWareEncoder16(str);
        }
        return FindHardWareEncoder21(str);
    }

    public static MediaCodec createMediaCodecEncoder(String str) throws IOException {
        return MediaCodec.createEncoderByType(str);
    }

    public static MediaCodecInfo getMediaCodecInfo(MediaCodec mediaCodec) {
        return (VERSION.SDK_INT < 18 || mediaCodec == null) ? null : mediaCodec.getCodecInfo();
    }

    public static EncodeVideoCapability getEncodVieoeCapability(MediaCodec mediaCodec, String str) {
        Range range = null;
        if (mediaCodec != null) {
            if (VERSION.SDK_INT >= 18) {
                EncodeVideoCapability encodeVideoCapability = new EncodeVideoCapability();
                mediaCodec = mediaCodec.getCodecInfo().getCapabilitiesForType(str);
                encodeVideoCapability.colorFormat = mediaCodec.colorFormats;
                str = mediaCodec.profileLevels;
                if (str != null) {
                    encodeVideoCapability.profileLevel = new ProfileLevel[str.length];
                    for (int i = 0; i < str.length; i++) {
                        encodeVideoCapability.profileLevel[i] = new ProfileLevel(str[i].profile, str[i].level);
                    }
                }
                if (VERSION.SDK_INT >= 21) {
                    mediaCodec = mediaCodec.getVideoCapabilities();
                    range = mediaCodec.getSupportedHeights();
                    str = mediaCodec.getSupportedWidths();
                    encodeVideoCapability.heightAlignment = mediaCodec.getHeightAlignment();
                    encodeVideoCapability.widthAlignment = mediaCodec.getWidthAlignment();
                } else {
                    encodeVideoCapability.heightAlignment = 2;
                    encodeVideoCapability.widthAlignment = 2;
                    str = null;
                }
                if (str != null) {
                    encodeVideoCapability.widthUpper = ((Integer) str.getUpper()).intValue();
                    encodeVideoCapability.widthLower = ((Integer) str.getLower()).intValue();
                }
                if (range != null) {
                    encodeVideoCapability.heightUpper = ((Integer) range.getUpper()).intValue();
                    encodeVideoCapability.heightLower = ((Integer) range.getLower()).intValue();
                }
                return encodeVideoCapability;
            }
        }
        return null;
    }
}
