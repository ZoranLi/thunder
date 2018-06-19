package com.tencent.bugly.proguard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* compiled from: BUGLY */
public class at implements ar {
    public byte[] a(byte[] bArr) throws Exception {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        ZipEntry zipEntry = new ZipEntry("zip");
        zipEntry.setSize((long) bArr.length);
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write(bArr);
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        bArr = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return bArr;
    }

    public byte[] b(byte[] bArr) throws Exception {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        bArr = new ZipInputStream(byteArrayInputStream);
        byte[] bArr2 = null;
        while (bArr.getNextEntry() != null) {
            byte[] bArr3 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = bArr.read(bArr3, 0, 1024);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        }
        bArr.close();
        byteArrayInputStream.close();
        return bArr2;
    }
}
