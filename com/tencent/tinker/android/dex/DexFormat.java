package com.tencent.tinker.android.dex;

/* compiled from: BUGLY */
public final class DexFormat {
    public static final int API_CURRENT = 14;
    public static final int API_NO_EXTENDED_OPCODES = 13;
    public static final String DEX_IN_JAR_NAME = "classes.dex";
    public static final int ENDIAN_TAG = 305419896;
    public static final String MAGIC_PREFIX = "dex\n";
    public static final String MAGIC_SUFFIX = "\u0000";
    public static final int MAX_MEMBER_IDX = 65535;
    public static final int MAX_TYPE_IDX = 65535;
    public static final String VERSION_CURRENT = "036";
    public static final String VERSION_FOR_API_13 = "035";

    private DexFormat() {
    }

    public static int magicToApi(byte[] bArr) {
        if (bArr.length == 8 && bArr[0] == (byte) 100 && bArr[1] == (byte) 101 && bArr[2] == (byte) 120 && bArr[3] == (byte) 10) {
            if (bArr[7] == (byte) 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((char) bArr[4]);
                stringBuilder.append((char) bArr[5]);
                stringBuilder.append((char) bArr[6]);
                bArr = stringBuilder.toString();
                if (bArr.equals(VERSION_CURRENT)) {
                    return 14;
                }
                if (bArr.equals(VERSION_FOR_API_13) != null) {
                    return 13;
                }
                return -1;
            }
        }
        return -1;
    }

    public static String apiToMagic(int i) {
        i = i >= 14 ? VERSION_CURRENT : VERSION_FOR_API_13;
        StringBuilder stringBuilder = new StringBuilder(MAGIC_PREFIX);
        stringBuilder.append(i);
        stringBuilder.append(MAGIC_SUFFIX);
        return stringBuilder.toString();
    }
}
