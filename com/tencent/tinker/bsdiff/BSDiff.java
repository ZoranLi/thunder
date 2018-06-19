package com.tencent.tinker.bsdiff;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: BUGLY */
public class BSDiff {
    private static final byte[] MAGIC_BYTES = new byte[]{(byte) 77, (byte) 105, (byte) 99, (byte) 114, (byte) 111, (byte) 77, (byte) 115, (byte) 103};

    /* compiled from: BUGLY */
    private static class IntByRef {
        private int value;

        private IntByRef() {
        }
    }

    private static void split(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i5 = i3;
        int i6 = i;
        int i7 = i2;
        while (true) {
            int i8 = 0;
            if (i7 < 16) {
                break;
            }
            i4 = iArr4[iArr3[(i7 / 2) + i6] + i5];
            int i9 = i6;
            int i10 = 0;
            int i11 = i10;
            while (true) {
                int i12 = i6 + i7;
                if (i9 >= i12) {
                    break;
                }
                if (iArr4[iArr3[i9] + i5] < i4) {
                    i10++;
                }
                if (iArr4[iArr3[i9] + i5] == i4) {
                    i11++;
                }
                i9++;
            }
            i10 += i6;
            i7 = i11 + i10;
            i9 = i6;
            i11 = 0;
            int i13 = i11;
            while (i9 < i10) {
                int i14;
                int i15;
                if (iArr4[iArr3[i9] + i5] < i4) {
                    i9++;
                } else if (iArr4[iArr3[i9] + i5] == i4) {
                    i14 = iArr3[i9];
                    i15 = i10 + i11;
                    iArr3[i9] = iArr3[i15];
                    iArr3[i15] = i14;
                    i11++;
                } else {
                    i14 = iArr3[i9];
                    i15 = i7 + i13;
                    iArr3[i9] = iArr3[i15];
                    iArr3[i15] = i14;
                    i13++;
                }
            }
            while (true) {
                i9 = i10 + i11;
                if (i9 >= i7) {
                    break;
                } else if (iArr4[iArr3[i9] + i5] == i4) {
                    i11++;
                } else {
                    i14 = iArr3[i9];
                    i15 = i7 + i13;
                    iArr3[i9] = iArr3[i15];
                    iArr3[i15] = i14;
                    i13++;
                }
            }
            if (i10 > i6) {
                split(iArr3, iArr4, i6, i10 - i6, i5);
            }
            while (i8 < i7 - i10) {
                iArr4[iArr3[i10 + i8]] = i7 - 1;
                i8++;
            }
            if (i10 == i7 - 1) {
                iArr3[i10] = -1;
            }
            if (i12 > i7) {
                i6 = i7;
                i7 = i12 - i7;
            } else {
                return;
            }
        }
        i4 = i6;
        while (true) {
            i9 = i6 + i7;
            if (i4 < i9) {
                i12 = iArr4[iArr3[i4] + i5];
                i10 = 1;
                i13 = i10;
                while (true) {
                    i14 = i4 + i10;
                    if (i14 >= i9) {
                        break;
                    }
                    if (iArr4[iArr3[i14] + i5] < i12) {
                        i12 = iArr4[iArr3[i14] + i5];
                        i13 = 0;
                    }
                    if (iArr4[iArr3[i14] + i5] == i12) {
                        i15 = i4 + i13;
                        int i16 = iArr3[i15];
                        iArr3[i15] = iArr3[i14];
                        iArr3[i14] = i16;
                        i13++;
                    }
                    i10++;
                }
                for (i9 = 0; i9 < i13; i9++) {
                    iArr4[iArr3[i4 + i9]] = (i4 + i13) - 1;
                }
                if (i13 == 1) {
                    iArr3[i4] = -1;
                }
                i4 += i13;
            } else {
                return;
            }
        }
    }

    private static void qsufsort(int[] iArr, int[] iArr2, byte[] bArr, int i) {
        int i2;
        int[] iArr3 = new int[256];
        int i3 = 0;
        for (i2 = 0; i2 < i; i2++) {
            int i4 = 255 & bArr[i2];
            iArr3[i4] = iArr3[i4] + 1;
        }
        for (i2 = 1; i2 < 256; i2++) {
            iArr3[i2] = iArr3[i2] + iArr3[i2 - 1];
        }
        for (i2 = 255; i2 > 0; i2--) {
            iArr3[i2] = iArr3[i2 - 1];
        }
        iArr3[0] = 0;
        for (i2 = 0; i2 < i; i2++) {
            int i5 = bArr[i2] & 255;
            int i6 = iArr3[i5] + 1;
            iArr3[i5] = i6;
            iArr[i6] = i2;
        }
        iArr[0] = i;
        for (i2 = 0; i2 < i; i2++) {
            iArr2[i2] = iArr3[bArr[i2] & 255];
        }
        iArr2[i] = 0;
        for (bArr = 1; bArr < 256; bArr++) {
            if (iArr3[bArr] == iArr3[bArr - 1] + 1) {
                iArr[iArr3[bArr]] = -1;
            }
        }
        iArr[0] = -1;
        bArr = 1;
        while (true) {
            int i7 = i + 1;
            if (iArr[0] == (-i7)) {
                break;
            }
            int i8 = 0;
            i2 = i8;
            while (i8 < i7) {
                if (iArr[i8] < 0) {
                    i2 -= iArr[i8];
                    i8 -= iArr[i8];
                } else {
                    if (i2 != 0) {
                        iArr[i8 - i2] = -i2;
                    }
                    i2 = (iArr2[iArr[i8]] + 1) - i8;
                    split(iArr, iArr2, i8, i2, bArr);
                    i8 += i2;
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                iArr[i8 - i2] = -i2;
            }
            bArr += bArr;
        }
        while (i3 < i7) {
            iArr[iArr2[i3]] = i3;
            i3++;
        }
    }

    private static int search(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, IntByRef intByRef) {
        int i6;
        IntByRef intByRef2 = intByRef;
        int i7 = i4;
        int i8 = i5;
        while (true) {
            i6 = i8 - i7;
            if (i6 < 2) {
                break;
            }
            i6 = (i6 / 2) + i7;
            if (memcmp(bArr, i, iArr[i6], bArr2, i2, i3) < 0) {
                i7 = i6;
            } else {
                i8 = i6;
            }
        }
        i6 = matchlen(bArr, i, iArr[i7], bArr2, i2, i3);
        int matchlen = matchlen(bArr, i, iArr[i8], bArr2, i2, i3);
        if (i6 > matchlen) {
            intByRef2.value = iArr[i7];
            return i6;
        }
        intByRef2.value = iArr[i8];
        return matchlen;
    }

    private static int matchlen(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        i = Math.min(i - i2, i3 - i4);
        for (i3 = 0; i3 < i; i3++) {
            if (bArr[i2 + i3] != bArr2[i4 + i3]) {
                return i3;
            }
        }
        return i;
    }

    private static int memcmp(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        i -= i2;
        i3 -= i4;
        if (i > i3) {
            i = i3;
        }
        int i5 = 0;
        while (i5 < i) {
            int i6 = i5 + i2;
            int i7 = i5 + i4;
            if (bArr[i6] != bArr2[i7]) {
                return bArr[i6] < bArr2[i7] ? -1 : 1;
            } else {
                i5++;
            }
        }
        return 0;
    }

    public static void bsdiff(File file, File file2, File file3) throws IOException {
        InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        InputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
        OutputStream fileOutputStream = new FileOutputStream(file3);
        try {
            fileOutputStream.write(bsdiff(bufferedInputStream, (int) file.length(), bufferedInputStream2, (int) file2.length()));
        } finally {
            fileOutputStream.close();
        }
    }

    public static byte[] bsdiff(InputStream inputStream, int i, InputStream inputStream2, int i2) throws IOException {
        byte[] bArr = new byte[i];
        BSUtil.readFromStream(inputStream, bArr, 0, i);
        inputStream.close();
        byte[] bArr2 = new byte[i2];
        BSUtil.readFromStream(inputStream2, bArr2, 0, i2);
        inputStream2.close();
        return bsdiff(bArr, i, bArr2, i2);
    }

    public static byte[] bsdiff(byte[] bArr, int i, byte[] bArr2, int i2) throws IOException {
        OutputStream outputStream;
        long j;
        OutputStream outputStream2;
        OutputStream outputStream3;
        int i3;
        byte[] bArr3 = bArr;
        int i4 = i;
        int i5 = i2;
        int i6 = i4 + 1;
        int[] iArr = new int[i6];
        qsufsort(iArr, new int[i6], bArr3, i4);
        byte[] bArr4 = new byte[i5];
        byte[] bArr5 = new byte[i5];
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.write(MAGIC_BYTES);
        dataOutputStream.writeLong(-1);
        dataOutputStream.writeLong(-1);
        long j2 = (long) i5;
        dataOutputStream.writeLong(j2);
        dataOutputStream.flush();
        OutputStream gZIPOutputStream = new GZIPOutputStream(dataOutputStream);
        DataOutputStream dataOutputStream2 = new DataOutputStream(gZIPOutputStream);
        IntByRef intByRef = new IntByRef();
        int i7 = 0;
        i6 = 0;
        int i8 = i6;
        int i9 = i8;
        int i10 = i9;
        int i11 = i10;
        int i12 = i11;
        int i13 = i12;
        while (i6 < i5) {
            IntByRef intByRef2;
            DataOutputStream dataOutputStream3;
            int[] iArr2;
            int i14;
            int i15;
            IntByRef intByRef3;
            int i16;
            int i17;
            i6 += i8;
            int i18 = i6;
            int i19 = i8;
            i8 = i7;
            while (i6 < i5) {
                int i20 = i6;
                intByRef2 = intByRef;
                dataOutputStream3 = dataOutputStream2;
                outputStream = gZIPOutputStream;
                j = j2;
                outputStream2 = dataOutputStream;
                iArr2 = iArr;
                outputStream3 = byteArrayOutputStream;
                i6 = search(iArr, bArr3, i4, bArr2, i5, i20, 0, i4, intByRef2);
                i14 = i8;
                i3 = i18;
                i7 = i20;
                while (i3 < i7 + i6) {
                    i15 = i3 + i11;
                    if (i15 < i4 && bArr3[i15] == bArr2[i3]) {
                        i14++;
                    }
                    i3++;
                }
                if ((i6 == i14 && i6 != 0) || i6 > i14 + 8) {
                    break;
                }
                i15 = i7 + i11;
                if (i15 < i4 && bArr3[i15] == bArr2[i7]) {
                    i14--;
                }
                i8 = i14;
                i19 = i6;
                i6 = i7 + 1;
                i18 = i3;
                byteArrayOutputStream = outputStream3;
                intByRef = intByRef2;
                dataOutputStream2 = dataOutputStream3;
                gZIPOutputStream = outputStream;
                j2 = j;
                dataOutputStream = outputStream2;
                iArr = iArr2;
            }
            i7 = i6;
            intByRef2 = intByRef;
            dataOutputStream3 = dataOutputStream2;
            outputStream = gZIPOutputStream;
            j = j2;
            outputStream2 = dataOutputStream;
            iArr2 = iArr;
            outputStream3 = byteArrayOutputStream;
            i14 = i8;
            i6 = i19;
            if (i6 == i14) {
                if (i7 != i5) {
                    i8 = i6;
                    i6 = i7;
                    byteArrayOutputStream = outputStream3;
                    intByRef = intByRef2;
                    dataOutputStream2 = dataOutputStream3;
                    gZIPOutputStream = outputStream;
                    j2 = j;
                    dataOutputStream = outputStream2;
                    iArr = iArr2;
                    i7 = 0;
                }
            }
            i3 = 0;
            i14 = 0;
            i15 = 0;
            int i21 = 0;
            while (true) {
                int i22 = i12 + i3;
                if (i22 >= i7) {
                    break;
                }
                int i23 = i13 + i3;
                if (i23 >= i4) {
                    break;
                }
                if (bArr3[i23] == bArr2[i22]) {
                    i14++;
                }
                i3++;
                if ((i14 * 2) - i3 > (i15 * 2) - i21) {
                    i21 = i3;
                    i15 = i14;
                }
            }
            if (i7 < i5) {
                i3 = 1;
                i14 = 0;
                i15 = 0;
                i22 = 0;
                while (i7 >= i12 + i3) {
                    intByRef3 = intByRef2;
                    if (intByRef3.value < i3) {
                        i16 = i6;
                        break;
                    }
                    i16 = i6;
                    if (bArr3[intByRef3.value - i3] == bArr2[i7 - i3]) {
                        i15++;
                    }
                    if ((i15 * 2) - i3 > (i22 * 2) - i14) {
                        i14 = i3;
                        i22 = i15;
                    }
                    i3++;
                    intByRef2 = intByRef3;
                    i6 = i16;
                }
                i16 = i6;
                intByRef3 = intByRef2;
            } else {
                i16 = i6;
                intByRef3 = intByRef2;
                i14 = 0;
            }
            i6 = i12 + i21;
            i3 = i7 - i14;
            if (i6 > i3) {
                i15 = i6 - i3;
                i22 = 0;
                i17 = 0;
                i4 = 0;
                i8 = 0;
                while (i22 < i15) {
                    int i24 = i6;
                    if (bArr2[(i6 - i15) + i22] == bArr3[((i13 + i21) - i15) + i22]) {
                        i8++;
                    }
                    if (bArr2[i3 + i22] == bArr3[(intByRef3.value - i14) + i22]) {
                        i8--;
                    }
                    i6 = i8;
                    if (i6 > i4) {
                        i17 = i22 + 1;
                        i4 = i6;
                    }
                    i22++;
                    i8 = i6;
                    i6 = i24;
                    i5 = i2;
                }
                i21 += i17 - i15;
                i14 -= i17;
            }
            i6 = 0;
            while (i6 < i21) {
                i3 = i9;
                bArr4[i3 + i6] = (byte) (bArr2[i12 + i6] - bArr3[i13 + i6]);
                i6++;
                i9 = i3;
            }
            i3 = i9;
            i6 = 0;
            while (true) {
                i15 = i7 - i14;
                i22 = i12 + i21;
                i17 = i15 - i22;
                if (i6 >= i17) {
                    break;
                }
                i4 = i10;
                bArr5[i4 + i6] = bArr2[i22 + i6];
                i6++;
                i10 = i4;
            }
            i9 = i3 + i21;
            i10 += i17;
            DataOutputStream dataOutputStream4 = dataOutputStream3;
            dataOutputStream4.writeInt(i21);
            dataOutputStream4.writeInt(i17);
            dataOutputStream4.writeInt((intByRef3.value - i14) - (i13 + i21));
            i13 = intByRef3.value - i14;
            i11 = intByRef3.value - i7;
            dataOutputStream2 = dataOutputStream4;
            i6 = i7;
            i12 = i15;
            intByRef = intByRef3;
            byteArrayOutputStream = outputStream3;
            gZIPOutputStream = outputStream;
            j2 = j;
            dataOutputStream = outputStream2;
            iArr = iArr2;
            i8 = i16;
            i7 = 0;
            i4 = i;
            i5 = i2;
        }
        outputStream = gZIPOutputStream;
        j = j2;
        outputStream2 = dataOutputStream;
        outputStream3 = byteArrayOutputStream;
        i3 = i9;
        i4 = i10;
        dataOutputStream2.flush();
        outputStream.finish();
        OutputStream outputStream4 = outputStream2;
        i7 = outputStream4.size() - 32;
        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream4);
        gZIPOutputStream2.write(bArr4, 0, i3);
        gZIPOutputStream2.finish();
        gZIPOutputStream2.flush();
        i3 = (outputStream4.size() - i7) - 32;
        gZIPOutputStream2 = new GZIPOutputStream(outputStream4);
        gZIPOutputStream2.write(bArr5, 0, i4);
        gZIPOutputStream2.finish();
        gZIPOutputStream2.flush();
        outputStream4.close();
        outputStream4 = new ByteArrayOutputStream(32);
        dataOutputStream2 = new DataOutputStream(outputStream4);
        dataOutputStream2.write(MAGIC_BYTES);
        dataOutputStream2.writeLong((long) i7);
        dataOutputStream2.writeLong((long) i3);
        dataOutputStream2.writeLong(j);
        dataOutputStream2.close();
        Object toByteArray = outputStream3.toByteArray();
        Object toByteArray2 = outputStream4.toByteArray();
        System.arraycopy(toByteArray2, 0, toByteArray, 0, toByteArray2.length);
        return toByteArray;
    }
}
