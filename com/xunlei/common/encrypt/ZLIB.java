package com.xunlei.common.encrypt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class ZLIB {
    public static byte[] encrypt(byte[] bArr) {
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        byte[] bArr2;
        try {
            bArr2 = new byte[1024];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            bArr = bArr2;
        } catch (Exception e) {
            bArr2 = e;
            bArr2.printStackTrace();
            deflater.end();
            return bArr;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        deflater.end();
        return bArr;
    }

    public static void encrypt(byte[] bArr, OutputStream outputStream) {
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream);
        try {
            deflaterOutputStream.write(bArr, null, bArr.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
        }
    }

    public static byte[] decrypt(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        byte[] bArr2;
        try {
            bArr2 = new byte[1024];
            while (!inflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            bArr = bArr2;
        } catch (Exception e) {
            bArr2 = e;
            bArr2.printStackTrace();
            inflater.end();
            return bArr;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        inflater.end();
        return bArr;
    }

    public static byte[] decrypt(InputStream inputStream) {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
        int i = 1024;
        inputStream = new ByteArrayOutputStream(1024);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                i = inflaterInputStream.read(bArr, 0, i);
                if (i <= 0) {
                    break;
                }
                inputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream.toByteArray();
    }
}
