package com.umeng.message.proguard;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* compiled from: DeflaterHelper */
public class g {
    public static int a;

    public static byte[] a(String str, String str2) throws IOException {
        if (h.d(str)) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(str.getBytes(str2));
        deflater.finish();
        str = new byte[8192];
        a = 0;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(str);
                    a += deflate;
                    byteArrayOutputStream.write(str, 0, deflate);
                } catch (Throwable th) {
                    str = th;
                }
            }
            deflater.end();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            str = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw str;
        }
    }

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException, DataFormatException {
        if (bArr != null) {
            if (bArr.length != 0) {
                Inflater inflater = new Inflater();
                byte[] bArr2 = new byte[100];
                inflater.setInput(bArr, 0, bArr.length);
                bArr = new StringBuilder();
                while (!inflater.needsInput()) {
                    bArr.append(new String(bArr2, 0, inflater.inflate(bArr2), str));
                }
                inflater.end();
                return bArr.toString();
            }
        }
        return null;
    }
}
