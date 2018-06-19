package org.android.agoo.common;

import android.text.TextUtils;

/* compiled from: Taobao */
public final class c {
    public static final int a(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 >> 2;
        int i5 = i3 ^ i2;
        for (i3 = 0; i3 < i4; i3++) {
            int i6 = (i3 << 2) + i;
            i6 = ((bArr[i6 + 0] & 255) | (((((bArr[i6 + 3] << 8) | (bArr[i6 + 2] & 255)) << 8) | (bArr[i6 + 1] & 255)) << 8)) * 1540483477;
            i5 = (i5 * 1540483477) ^ ((i6 ^ (i6 >>> 24)) * 1540483477);
        }
        i4 = i2 - (i4 << 2);
        if (i4 != 0) {
            if (i4 >= 3) {
                i5 ^= bArr[(i + i2) - 3] << 16;
            }
            if (i4 >= 2) {
                i5 ^= bArr[(i + i2) - 2] << 8;
            }
            if (i4 > 0) {
                i5 ^= bArr[(i + i2) - 1];
            }
            i5 *= 1540483477;
        }
        bArr = ((i5 >>> 13) ^ i5) * 1540483477;
        return bArr ^ (bArr >>> 15);
    }

    public static final int a(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return (int) (Math.random() * ((double) j));
        }
        str = str.getBytes();
        return (int) (((long) Math.abs(a(str, 0, str.length, Integer.MAX_VALUE))) % j);
    }
}
