package com.aplayer.hardwareencode;

import android.media.MediaFormat;

public class AACAdtsPacket {
    public int getProfile(MediaFormat mediaFormat) {
        return mediaFormat.getInteger("aac-profile");
    }

    public static byte[] PacketToAdtsFrame(byte[] bArr, int i, int i2, int i3) {
        int length = bArr.length + 7;
        Object obj = new byte[length];
        System.arraycopy(bArr, 0, obj, 7, bArr.length);
        addADTStoPacket(obj, length, i, i2, i3);
        return obj;
    }

    private static void addADTStoPacket(byte[] bArr, int i, int i2, int i3, int i4) {
        i2 = AudioEncoder.indexOfArray(AudioEncoder.AAC_STANDARD_SAMPLE_RATE, i2);
        bArr[0] = (byte) -1;
        bArr[1] = (byte) -7;
        bArr[2] = (byte) ((((i4 - 1) << 6) + (i2 << 2)) + (i3 >> 2));
        bArr[3] = (byte) (((i3 & 3) << 6) + (i >> 11));
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }
}
