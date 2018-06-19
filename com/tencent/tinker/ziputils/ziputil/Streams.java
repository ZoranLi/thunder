package com.tencent.tinker.ziputils.ziputil;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BUGLY */
public final class Streams {
    private static AtomicReference<byte[]> skipBuffer = new AtomicReference();

    private Streams() {
    }

    public static int readSingleByte(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1];
        if (inputStream.read(bArr, 0, 1) != -1) {
            return bArr[0] & 255;
        }
        return -1;
    }

    public static void writeSingleByte(OutputStream outputStream, int i) throws IOException {
        outputStream.write(new byte[]{(byte) (i & 255)});
    }

    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 != 0) {
            if (inputStream == null) {
                throw new NullPointerException("in == null");
            } else if (bArr == null) {
                throw new NullPointerException("dst == null");
            } else {
                Arrays.checkOffsetAndCount(bArr.length, i, i2);
                while (i2 > 0) {
                    int read = inputStream.read(bArr, i, i2);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    i += read;
                    i2 -= read;
                }
            }
        }
    }

    public static byte[] readFully(InputStream inputStream) throws IOException {
        try {
            byte[] readFullyNoClose = readFullyNoClose(inputStream);
            return readFullyNoClose;
        } finally {
            inputStream.close();
        }
    }

    public static byte[] readFullyNoClose(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String readFully(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            return stringWriter2;
        } finally {
            reader.close();
        }
    }

    public static void skipAll(InputStream inputStream) throws IOException {
        do {
            inputStream.skip(Long.MAX_VALUE);
        } while (inputStream.read() != -1);
    }

    public static long skipByReading(InputStream inputStream, long j) throws IOException {
        Object obj = (byte[]) skipBuffer.getAndSet(null);
        if (obj == null) {
            obj = new byte[4096];
        }
        long j2 = 0;
        while (j2 < j) {
            int min = (int) Math.min(j - j2, (long) obj.length);
            int read = inputStream.read(obj, 0, min);
            if (read == -1) {
                break;
            }
            long j3 = j2 + ((long) read);
            if (read < min) {
                j2 = j3;
                break;
            }
            j2 = j3;
        }
        skipBuffer.set(obj);
        return j2;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
    }

    public static String readAsciiLine(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read != -1) {
                if (read == 10) {
                    break;
                }
                stringBuilder.append((char) read);
            } else {
                throw new EOFException();
            }
        }
        inputStream = stringBuilder.length();
        if (inputStream > null) {
            inputStream--;
            if (stringBuilder.charAt(inputStream) == '\r') {
                stringBuilder.setLength(inputStream);
            }
        }
        return stringBuilder.toString();
    }
}
