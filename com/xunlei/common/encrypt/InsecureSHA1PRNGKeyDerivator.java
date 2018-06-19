package com.xunlei.common.encrypt;

import android.support.v4.view.ViewCompat;

class InsecureSHA1PRNGKeyDerivator {
    private static final int BYTES_OFFSET = 81;
    private static final int COUNTER_BASE = 0;
    private static final int DIGEST_LENGTH = 20;
    private static final int[] END_FLAGS = new int[]{Integer.MIN_VALUE, 8388608, 32768, 128};
    private static final int EXTRAFRAME_OFFSET = 5;
    private static final int FRAME_LENGTH = 16;
    private static final int FRAME_OFFSET = 21;
    private static final int H0 = 1732584193;
    private static final int H1 = -271733879;
    private static final int H2 = -1732584194;
    private static final int H3 = 271733878;
    private static final int H4 = -1009589776;
    private static final int HASHBYTES_TO_USE = 20;
    private static final int HASHCOPY_OFFSET = 0;
    private static final int HASH_OFFSET = 82;
    private static final int[] LEFT = new int[]{0, 24, 16, 8};
    private static final int[] MASK = new int[]{-1, ViewCompat.MEASURED_SIZE_MASK, 65535, 255};
    private static final int MAX_BYTES = 48;
    private static final int NEXT_BYTES = 2;
    private static final int[] RIGHT1 = new int[]{0, 40, 48, 56};
    private static final int[] RIGHT2 = new int[]{0, 8, 16, 24};
    private static final int SET_SEED = 1;
    private static final int UNDEFINED = 0;
    private transient int[] copies;
    private transient long counter;
    private transient int nextBIndex;
    private transient byte[] nextBytes;
    private transient int[] seed = new int[87];
    private transient long seedLength;
    private transient int state;

    public static byte[] deriveInsecureKey(byte[] bArr, int i) {
        InsecureSHA1PRNGKeyDerivator insecureSHA1PRNGKeyDerivator = new InsecureSHA1PRNGKeyDerivator();
        insecureSHA1PRNGKeyDerivator.setSeed(bArr);
        bArr = new byte[i];
        insecureSHA1PRNGKeyDerivator.nextBytes(bArr);
        return bArr;
    }

    private InsecureSHA1PRNGKeyDerivator() {
        this.seed[82] = H0;
        this.seed[83] = H1;
        this.seed[84] = H2;
        this.seed[85] = H3;
        this.seed[86] = H4;
        this.seedLength = 0;
        this.copies = new int[37];
        this.nextBytes = new byte[20];
        this.nextBIndex = 20;
        this.counter = 0;
        this.state = 0;
    }

    private void updateSeed(byte[] bArr) {
        updateHash(this.seed, bArr, 0, bArr.length - 1);
        this.seedLength += (long) bArr.length;
    }

    private void setSeed(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("seed == null");
        }
        if (this.state == 2) {
            System.arraycopy(this.copies, 0, this.seed, 82, 5);
        }
        this.state = 1;
        if (bArr.length != 0) {
            updateSeed(bArr);
        }
    }

    protected synchronized void nextBytes(byte[] bArr) {
        InsecureSHA1PRNGKeyDerivator insecureSHA1PRNGKeyDerivator = this;
        Object obj = bArr;
        synchronized (this) {
            if (obj == null) {
                try {
                    throw new NullPointerException("bytes == null");
                } catch (Throwable th) {
                    Throwable th2 = th;
                }
            } else {
                int i = insecureSHA1PRNGKeyDerivator.seed[81] == 0 ? 0 : (insecureSHA1PRNGKeyDerivator.seed[81] + 7) >> 2;
                if (insecureSHA1PRNGKeyDerivator.state == 0) {
                    throw new IllegalStateException("No seed supplied!");
                }
                int i2;
                long j = 32;
                if (insecureSHA1PRNGKeyDerivator.state == 1) {
                    System.arraycopy(insecureSHA1PRNGKeyDerivator.seed, 82, insecureSHA1PRNGKeyDerivator.copies, 0, 5);
                    for (i2 = i + 3; i2 < 18; i2++) {
                        insecureSHA1PRNGKeyDerivator.seed[i2] = 0;
                    }
                    long j2 = (insecureSHA1PRNGKeyDerivator.seedLength << 3) + 64;
                    if (insecureSHA1PRNGKeyDerivator.seed[81] < 48) {
                        insecureSHA1PRNGKeyDerivator.seed[14] = (int) (j2 >>> 32);
                        insecureSHA1PRNGKeyDerivator.seed[15] = (int) j2;
                    } else {
                        insecureSHA1PRNGKeyDerivator.copies[19] = (int) (j2 >>> 32);
                        insecureSHA1PRNGKeyDerivator.copies[20] = (int) j2;
                    }
                    insecureSHA1PRNGKeyDerivator.nextBIndex = 20;
                }
                insecureSHA1PRNGKeyDerivator.state = 2;
                if (obj.length == 0) {
                    return;
                }
                int length = 20 - insecureSHA1PRNGKeyDerivator.nextBIndex < obj.length ? 20 - insecureSHA1PRNGKeyDerivator.nextBIndex : obj.length;
                if (length > 0) {
                    System.arraycopy(insecureSHA1PRNGKeyDerivator.nextBytes, insecureSHA1PRNGKeyDerivator.nextBIndex, obj, 0, length);
                    insecureSHA1PRNGKeyDerivator.nextBIndex += length;
                    length += 0;
                } else {
                    length = 0;
                }
                if (length >= obj.length) {
                    return;
                }
                i2 = insecureSHA1PRNGKeyDerivator.seed[81] & 3;
                while (true) {
                    int i3;
                    int i4;
                    if (i2 == 0) {
                        insecureSHA1PRNGKeyDerivator.seed[i] = (int) (insecureSHA1PRNGKeyDerivator.counter >>> j);
                        insecureSHA1PRNGKeyDerivator.seed[i + 1] = (int) insecureSHA1PRNGKeyDerivator.counter;
                        insecureSHA1PRNGKeyDerivator.seed[i + 2] = END_FLAGS[0];
                        i3 = length;
                    } else {
                        int[] iArr = insecureSHA1PRNGKeyDerivator.seed;
                        i3 = length;
                        iArr[i] = ((int) ((insecureSHA1PRNGKeyDerivator.counter >>> RIGHT1[i2]) & ((long) MASK[i2]))) | iArr[i];
                        insecureSHA1PRNGKeyDerivator.seed[i + 1] = (int) (insecureSHA1PRNGKeyDerivator.counter >>> RIGHT2[i2]);
                        insecureSHA1PRNGKeyDerivator.seed[i + 2] = (int) ((insecureSHA1PRNGKeyDerivator.counter << LEFT[i2]) | ((long) END_FLAGS[i2]));
                    }
                    if (insecureSHA1PRNGKeyDerivator.seed[81] > 48) {
                        insecureSHA1PRNGKeyDerivator.copies[5] = insecureSHA1PRNGKeyDerivator.seed[16];
                        insecureSHA1PRNGKeyDerivator.copies[6] = insecureSHA1PRNGKeyDerivator.seed[17];
                    }
                    computeHash(insecureSHA1PRNGKeyDerivator.seed);
                    if (insecureSHA1PRNGKeyDerivator.seed[81] > 48) {
                        System.arraycopy(insecureSHA1PRNGKeyDerivator.seed, 0, insecureSHA1PRNGKeyDerivator.copies, 21, 16);
                        System.arraycopy(insecureSHA1PRNGKeyDerivator.copies, 5, insecureSHA1PRNGKeyDerivator.seed, 0, 16);
                        computeHash(insecureSHA1PRNGKeyDerivator.seed);
                        System.arraycopy(insecureSHA1PRNGKeyDerivator.copies, 21, insecureSHA1PRNGKeyDerivator.seed, 0, 16);
                    }
                    insecureSHA1PRNGKeyDerivator.counter++;
                    int i5 = 0;
                    length = i5;
                    while (i5 < 5) {
                        i4 = insecureSHA1PRNGKeyDerivator.seed[i5 + 82];
                        insecureSHA1PRNGKeyDerivator.nextBytes[length] = i4 >> 24;
                        insecureSHA1PRNGKeyDerivator.nextBytes[length + 1] = (byte) (i4 >>> 16);
                        insecureSHA1PRNGKeyDerivator.nextBytes[length + 2] = (byte) (i4 >>> 8);
                        insecureSHA1PRNGKeyDerivator.nextBytes[length + 3] = (byte) i4;
                        length += 4;
                        i5++;
                    }
                    insecureSHA1PRNGKeyDerivator.nextBIndex = 0;
                    i5 = 20 < obj.length - i3 ? 20 : obj.length - i3;
                    if (i5 > 0) {
                        i4 = i3;
                        System.arraycopy(insecureSHA1PRNGKeyDerivator.nextBytes, 0, obj, i4, i5);
                        length = i4 + i5;
                        insecureSHA1PRNGKeyDerivator.nextBIndex += i5;
                    } else {
                        length = i3;
                    }
                    if (length >= obj.length) {
                        return;
                    } else {
                        i5 = 81;
                        j = 32;
                    }
                }
            }
        }
    }

    private static void computeHash(int[] iArr) {
        int i;
        int i2 = iArr[82];
        int i3 = iArr[83];
        int i4 = iArr[84];
        int i5 = iArr[85];
        int i6 = iArr[86];
        for (i = 16; i < 80; i++) {
            int i7 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i7 >>> 31) | (i7 << 1);
        }
        i = 0;
        int i8 = i3;
        i3 = i2;
        i2 = i8;
        int i9 = i5;
        i5 = i4;
        i4 = i6;
        i6 = i9;
        while (true) {
            int i10 = 20;
            if (i >= 20) {
                break;
            }
            i4 = ((i4 + iArr[i]) + 1518500249) + (((i3 << 5) | (i3 >>> 27)) + ((i2 & i5) | ((i2 ^ -1) & i6)));
            i++;
            i8 = i5;
            i5 = (i2 >>> 2) | (i2 << 30);
            i2 = i3;
            i3 = i4;
            i4 = i6;
            i6 = i8;
        }
        i8 = i3;
        i3 = i2;
        i2 = i8;
        i9 = i5;
        i5 = i4;
        i4 = i6;
        i6 = i9;
        while (true) {
            i = 40;
            if (i10 >= 40) {
                break;
            }
            i5 = ((i5 + iArr[i10]) + 1859775393) + (((i2 << 5) | (i2 >>> 27)) + ((i3 ^ i6) ^ i4));
            i10++;
            i8 = (i3 >>> 2) | (i3 << 30);
            i3 = i2;
            i2 = i5;
            i5 = i4;
            i4 = i6;
            i6 = i8;
        }
        i8 = i3;
        i3 = i2;
        i2 = i8;
        i9 = i5;
        i5 = i4;
        i4 = i6;
        i6 = i9;
        while (true) {
            i10 = 60;
            if (i >= 60) {
                break;
            }
            i6 = ((i6 + iArr[i]) - 1894007588) + (((i3 << 5) | (i3 >>> 27)) + (((i2 & i4) | (i2 & i5)) | (i4 & i5)));
            i++;
            i8 = i4;
            i4 = (i2 >>> 2) | (i2 << 30);
            i2 = i3;
            i3 = i6;
            i6 = i5;
            i5 = i8;
        }
        i8 = i3;
        i3 = i2;
        i2 = i8;
        i9 = i5;
        i5 = i4;
        i4 = i6;
        i6 = i9;
        while (i10 < 80) {
            i4 = ((i4 + iArr[i10]) - 899497514) + (((i2 << 5) | (i2 >>> 27)) + ((i3 ^ i5) ^ i6));
            i10++;
            i8 = (i3 >>> 2) | (i3 << 30);
            i3 = i2;
            i2 = i4;
            i4 = i6;
            i6 = i5;
            i5 = i8;
        }
        iArr[82] = iArr[82] + i2;
        iArr[83] = iArr[83] + i3;
        iArr[84] = iArr[84] + i5;
        iArr[85] = iArr[85] + i6;
        iArr[86] = iArr[86] + i4;
    }

    private static void updateHash(int[] iArr, byte[] bArr, int i, int i2) {
        int i3 = iArr[81];
        int i4 = i3 >> 2;
        int i5 = i3 & 3;
        iArr[81] = (((i3 + i2) - i) + 1) & 63;
        if (i5 != 0) {
            while (i <= i2 && i5 < 4) {
                iArr[i4] = iArr[i4] | ((bArr[i] & 255) << ((3 - i5) << 3));
                i5++;
                i++;
            }
            if (i5 == 4) {
                i4++;
                if (i4 == 16) {
                    computeHash(iArr);
                    i4 = 0;
                }
            }
            if (i > i2) {
                return;
            }
        }
        i5 = ((i2 - i) + 1) >> 2;
        int i6 = i;
        for (i = 0; i < i5; i++) {
            iArr[i4] = ((((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16)) | ((bArr[i6 + 2] & 255) << 8)) | (bArr[i6 + 3] & 255);
            i6 += 4;
            i4++;
            if (i4 >= 16) {
                computeHash(iArr);
                i4 = 0;
            }
        }
        i2 = (i2 - i6) + 1;
        if (i2 != 0) {
            i = (bArr[i6] & 255) << 24;
            if (i2 != 1) {
                i |= (bArr[i6 + 1] & 255) << 16;
                if (i2 != 2) {
                    i |= (bArr[i6 + 2] & 255) << 8;
                }
            }
            iArr[i4] = i;
        }
    }
}
