package com.tencent.tinker.bsdiff;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

/* compiled from: BUGLY */
public class BSPatch {
    public static final int RETURN_DIFF_FILE_ERR = 2;
    public static final int RETURN_NEW_FILE_ERR = 4;
    public static final int RETURN_OLD_FILE_ERR = 3;
    public static final int RETURN_SUCCESS = 1;

    public static int patchLessMemory(RandomAccessFile randomAccessFile, File file, File file2, int i) throws IOException {
        if (randomAccessFile != null) {
            if (randomAccessFile.length() > 0) {
                if (file == null) {
                    return 4;
                }
                if (file2 != null) {
                    if (file2.length() > 0) {
                        byte[] bArr = new byte[((int) file2.length())];
                        InputStream fileInputStream = new FileInputStream(file2);
                        try {
                            BSUtil.readFromStream(fileInputStream, bArr, null, bArr.length);
                            return patchLessMemory(randomAccessFile, (int) randomAccessFile.length(), bArr, bArr.length, file, i);
                        } finally {
                            fileInputStream.close();
                        }
                    }
                }
                return 2;
            }
        }
        return 3;
    }

    public static int patchLessMemory(RandomAccessFile randomAccessFile, int i, byte[] bArr, int i2, File file, int i3) throws IOException {
        OutputStream fileOutputStream;
        Throwable th;
        int i4 = i;
        byte[] bArr2 = bArr;
        int i5 = i2;
        File file2 = file;
        if (randomAccessFile != null) {
            if (i4 > 0) {
                if (file2 == null) {
                    return 4;
                }
                if (bArr2 != null) {
                    if (i5 > 0) {
                        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr2, 0, i5));
                        dataInputStream.skip(8);
                        long readLong = dataInputStream.readLong();
                        long readLong2 = dataInputStream.readLong();
                        int readLong3 = (int) dataInputStream.readLong();
                        dataInputStream.close();
                        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, i5);
                        byteArrayInputStream.skip(32);
                        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
                        byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, i5);
                        byteArrayInputStream.skip(readLong + 32);
                        InputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        InputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr2, 0, i5);
                        byteArrayInputStream2.skip((readLong2 + readLong) + 32);
                        InputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream2);
                        fileOutputStream = new FileOutputStream(file2);
                        RandomAccessFile randomAccessFile2;
                        try {
                            int[] iArr = new int[3];
                            int i6 = 0;
                            int i7 = i6;
                            while (i6 < readLong3) {
                                int i8 = 0;
                                while (i8 <= 2) {
                                    try {
                                        iArr[i8] = dataInputStream2.readInt();
                                        i8++;
                                    } catch (Throwable th2) {
                                        Throwable th3 = th2;
                                        randomAccessFile2 = randomAccessFile;
                                    }
                                }
                                if (iArr[0] + i6 > readLong3) {
                                    fileOutputStream.close();
                                    randomAccessFile2 = randomAccessFile;
                                    randomAccessFile.close();
                                    fileOutputStream.close();
                                    return 2;
                                }
                                randomAccessFile2 = randomAccessFile;
                                byte[] bArr3 = new byte[iArr[0]];
                                if (BSUtil.readFromStream(gZIPInputStream, bArr3, 0, iArr[0])) {
                                    byte[] bArr4 = new byte[iArr[0]];
                                    if (randomAccessFile2.read(bArr4, 0, iArr[0]) < iArr[0]) {
                                        fileOutputStream.close();
                                        randomAccessFile.close();
                                        fileOutputStream.close();
                                        return 2;
                                    }
                                    int i9;
                                    for (int i10 = 0; i10 < iArr[0]; i10++) {
                                        int i11 = i7 + i10;
                                        if (i11 < 0) {
                                            i9 = i;
                                        } else if (i11 < i) {
                                            bArr3[i10] = (byte) (bArr3[i10] + bArr4[i10]);
                                        }
                                    }
                                    i9 = i;
                                    fileOutputStream.write(bArr3);
                                    i6 += iArr[0];
                                    i7 += iArr[0];
                                    if (iArr[1] + i6 > readLong3) {
                                        fileOutputStream.close();
                                        randomAccessFile.close();
                                        fileOutputStream.close();
                                        return 2;
                                    }
                                    bArr4 = new byte[iArr[1]];
                                    if (BSUtil.readFromStream(gZIPInputStream2, bArr4, 0, iArr[1])) {
                                        try {
                                            fileOutputStream.write(bArr4);
                                            fileOutputStream.flush();
                                            i6 += iArr[1];
                                            i7 += iArr[2];
                                            randomAccessFile2.seek((long) i7);
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                        }
                                    } else {
                                        fileOutputStream.close();
                                        randomAccessFile.close();
                                        fileOutputStream.close();
                                        return 2;
                                    }
                                }
                                fileOutputStream.close();
                                randomAccessFile.close();
                                fileOutputStream.close();
                                return 2;
                            }
                            randomAccessFile2 = randomAccessFile;
                            dataInputStream2.close();
                            gZIPInputStream.close();
                            gZIPInputStream2.close();
                            randomAccessFile.close();
                            fileOutputStream.close();
                            return 1;
                        } catch (Throwable th5) {
                            th2 = th5;
                            randomAccessFile2 = randomAccessFile;
                        }
                    }
                }
                return 2;
            }
        }
        return 3;
        th3 = th2;
        randomAccessFile.close();
        fileOutputStream.close();
        throw th3;
        randomAccessFile.close();
        fileOutputStream.close();
        throw th3;
    }

    public static int patchFast(File file, File file2, File file3, int i) throws IOException {
        if (file != null) {
            if (file.length() > 0) {
                if (file2 == null) {
                    return 4;
                }
                if (file3 != null) {
                    if (file3.length() > 0) {
                        InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        byte[] bArr = new byte[((int) file3.length())];
                        InputStream fileInputStream = new FileInputStream(file3);
                        try {
                            BSUtil.readFromStream(fileInputStream, bArr, null, bArr.length);
                            file = patchFast(bufferedInputStream, (int) file.length(), bArr, i);
                            file3 = new FileOutputStream(file2);
                            try {
                                file3.write(file);
                                return 1;
                            } finally {
                                file3.close();
                            }
                        } finally {
                            fileInputStream.close();
                        }
                    }
                }
                return 2;
            }
        }
        return 3;
    }

    public static int patchFast(InputStream inputStream, InputStream inputStream2, File file) throws IOException {
        if (inputStream == null) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (inputStream2 == null) {
            return 2;
        }
        inputStream = BSUtil.inputStreamToByte(inputStream);
        inputStream2 = BSUtil.inputStreamToByte(inputStream2);
        inputStream = patchFast(inputStream, inputStream.length, inputStream2, inputStream2.length, 0);
        inputStream2 = new FileOutputStream(file);
        try {
            inputStream2.write(inputStream);
            return 1;
        } finally {
            inputStream2.close();
        }
    }

    public static byte[] patchFast(InputStream inputStream, InputStream inputStream2) throws IOException {
        if (inputStream == null || inputStream2 == null) {
            return null;
        }
        inputStream = BSUtil.inputStreamToByte(inputStream);
        inputStream2 = BSUtil.inputStreamToByte(inputStream2);
        return patchFast(inputStream, inputStream.length, inputStream2, inputStream2.length, 0);
    }

    public static byte[] patchFast(InputStream inputStream, int i, byte[] bArr, int i2) throws IOException {
        byte[] bArr2 = new byte[i];
        BSUtil.readFromStream(inputStream, bArr2, 0, i);
        inputStream.close();
        return patchFast(bArr2, i, bArr, bArr.length, i2);
    }

    public static byte[] patchFast(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws IOException {
        i3 = new DataInputStream(new ByteArrayInputStream(bArr2, 0, i2));
        i3.skip(8);
        long readLong = i3.readLong();
        long readLong2 = i3.readLong();
        int readLong3 = (int) i3.readLong();
        i3.close();
        i3 = new ByteArrayInputStream(bArr2, 0, i2);
        i3.skip(32);
        DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(i3));
        i3 = new ByteArrayInputStream(bArr2, 0, i2);
        i3.skip(readLong + 32);
        InputStream gZIPInputStream = new GZIPInputStream(i3);
        i3 = new ByteArrayInputStream(bArr2, 0, i2);
        i3.skip((readLong2 + readLong) + 32);
        bArr2 = new GZIPInputStream(i3);
        i2 = new byte[readLong3];
        i3 = new int[3];
        int i4 = 0;
        int i5 = i4;
        while (i4 < readLong3) {
            int i6;
            for (i6 = 0; i6 <= 2; i6++) {
                i3[i6] = dataInputStream.readInt();
            }
            if (i3[0] + i4 > readLong3) {
                throw new IOException("Corrupt by wrong patch file.");
            } else if (BSUtil.readFromStream(gZIPInputStream, i2, i4, i3[0])) {
                for (i6 = 0; i6 < i3[0]; i6++) {
                    int i7 = i5 + i6;
                    if (i7 >= 0 && i7 < i) {
                        int i8 = i4 + i6;
                        i2[i8] = (byte) (i2[i8] + bArr[i7]);
                    }
                }
                i4 += i3[0];
                i5 += i3[0];
                if (i3[1] + i4 > readLong3) {
                    throw new IOException("Corrupt by wrong patch file.");
                } else if (BSUtil.readFromStream(bArr2, i2, i4, i3[1])) {
                    i4 += i3[1];
                    i5 += i3[2];
                } else {
                    throw new IOException("Corrupt by wrong patch file.");
                }
            } else {
                throw new IOException("Corrupt by wrong patch file.");
            }
        }
        dataInputStream.close();
        gZIPInputStream.close();
        bArr2.close();
        return i2;
    }
}
