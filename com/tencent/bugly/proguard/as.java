package com.tencent.bugly.proguard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: BUGLY */
public class as implements ar {
    public byte[] a(byte[] bArr) throws Exception {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.finish();
        gZIPOutputStream.close();
        bArr = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return bArr;
    }

    public byte[] b(byte[] bArr) throws Exception {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        bArr = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = bArr.read(bArr2, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                bArr.close();
                byteArrayInputStream.close();
                return toByteArray;
            }
        }
    }
}
