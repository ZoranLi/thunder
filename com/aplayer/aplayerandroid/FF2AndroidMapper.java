package com.aplayer.aplayerandroid;

public class FF2AndroidMapper {
    public static final int AVCLevel1 = 1;
    public static final int AVCLevel11 = 4;
    public static final int AVCLevel12 = 8;
    public static final int AVCLevel13 = 16;
    public static final int AVCLevel1b = 2;
    public static final int AVCLevel2 = 32;
    public static final int AVCLevel21 = 64;
    public static final int AVCLevel22 = 128;
    public static final int AVCLevel3 = 256;
    public static final int AVCLevel31 = 512;
    public static final int AVCLevel32 = 1024;
    public static final int AVCLevel4 = 2048;
    public static final int AVCLevel41 = 4096;
    public static final int AVCLevel42 = 8192;
    public static final int AVCLevel5 = 16384;
    public static final int AVCLevel51 = 32768;
    public static final int AVCLevel52 = 65536;
    public static final int AVCProfileBaseline = 1;
    public static final int AVCProfileExtended = 4;
    public static final int AVCProfileHigh = 8;
    public static final int AVCProfileHigh10 = 16;
    public static final int AVCProfileHigh422 = 32;
    public static final int AVCProfileHigh444 = 64;
    public static final int AVCProfileMain = 2;
    public static final int FF_H264_LEVEL_1 = 10;
    public static final int FF_H264_LEVEL_11 = 11;
    public static final int FF_H264_LEVEL_12 = 12;
    public static final int FF_H264_LEVEL_13 = 13;
    public static final int FF_H264_LEVEL_1b = 9;
    public static final int FF_H264_LEVEL_2 = 20;
    public static final int FF_H264_LEVEL_21 = 21;
    public static final int FF_H264_LEVEL_22 = 22;
    public static final int FF_H264_LEVEL_3 = 30;
    public static final int FF_H264_LEVEL_31 = 31;
    public static final int FF_H264_LEVEL_32 = 32;
    public static final int FF_H264_LEVEL_4 = 40;
    public static final int FF_H264_LEVEL_41 = 41;
    public static final int FF_H264_LEVEL_42 = 42;
    public static final int FF_H264_LEVEL_5 = 50;
    public static final int FF_H264_LEVEL_51 = 51;
    public static final int FF_H264_LEVEL_52 = 52;
    public static final int FF_PROFILE_H264_BASELINE = 66;
    public static final int FF_PROFILE_H264_CAVLC_444 = 44;
    public static final int FF_PROFILE_H264_CONSTRAINED = 512;
    public static final int FF_PROFILE_H264_CONSTRAINED_BASELINE = 578;
    public static final int FF_PROFILE_H264_EXTENDED = 88;
    public static final int FF_PROFILE_H264_HIGH = 100;
    public static final int FF_PROFILE_H264_HIGH_10 = 110;
    public static final int FF_PROFILE_H264_HIGH_10_INTRA = 2158;
    public static final int FF_PROFILE_H264_HIGH_422 = 122;
    public static final int FF_PROFILE_H264_HIGH_422_INTRA = 2170;
    public static final int FF_PROFILE_H264_HIGH_444 = 144;
    public static final int FF_PROFILE_H264_HIGH_444_INTRA = 2292;
    public static final int FF_PROFILE_H264_HIGH_444_PREDICTIVE = 244;
    public static final int FF_PROFILE_H264_INTRA = 2048;
    public static final int FF_PROFILE_H264_MAIN = 77;
    public static final int FF_PROFILE_H264_MULTIVIEW_HIGH = 118;
    public static final int FF_PROFILE_H264_STEREO_HIGH = 128;

    public static int convert2AndroidLevel(int i) {
        switch (i) {
            case 9:
                return 2;
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    public static int convert2AndroidProfile(int i) {
        switch (i) {
            case 44:
            case 144:
            case FF_PROFILE_H264_HIGH_444_PREDICTIVE /*244*/:
            case FF_PROFILE_H264_HIGH_444_INTRA /*2292*/:
                return 64;
            case 66:
            case FF_PROFILE_H264_CONSTRAINED_BASELINE /*578*/:
                return 1;
            case 77:
                return 2;
            case 88:
                return 4;
            case 100:
                return 8;
            case 110:
                return 16;
            case 118:
            case 128:
                return -1;
            case 122:
            case FF_PROFILE_H264_HIGH_422_INTRA /*2170*/:
                return 32;
            default:
                return -1;
        }
    }

    public static String getAVCProfileName(int i) {
        if (i == 4) {
            return "AVCProfileExtended";
        }
        if (i == 8) {
            return "AVCProfileHigh";
        }
        if (i == 16) {
            return "AVCProfileHigh10";
        }
        if (i == 32) {
            return "AVCProfileHigh422";
        }
        if (i == 64) {
            return "AVCProfileHigh444";
        }
        switch (i) {
            case 1:
                return "AVCProfileBaseline";
            case 2:
                return "AVCProfileMain";
            default:
                return null;
        }
    }

    public static String getAndroidAVCLevelName(int i) {
        switch (i) {
            case 1:
                return "AVCLevel1";
            case 2:
                return "AVCLevel1b";
            case 4:
                return "AVCLevel11";
            case 8:
                return "AVCLevel12";
            case 16:
                return "AVCLevel13";
            case 32:
                return "AVCLevel2";
            case 64:
                return "AVCLevel21";
            case 128:
                return "AVCLevel22";
            case 256:
                return "AVCLevel3";
            case 512:
                return "AVCLevel31";
            case 1024:
                return "AVCLevel32";
            case 2048:
                return "AVCLevel4";
            case 4096:
                return "AVCLevel41";
            case 8192:
                return "AVCLevel42";
            case 16384:
                return "AVCLevel5";
            case 32768:
                return "AVCLevel51";
            case 65536:
                return "AVCLevel52";
            default:
                return null;
        }
    }
}
