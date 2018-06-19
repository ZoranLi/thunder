package com.qq.e.comm.net.rr;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    private static final byte[] a = new byte[]{(byte) 91, (byte) -62};
    private static Cipher b;
    private static Cipher c;
    private static byte[] d = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    static class a extends Exception {
        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    @SuppressLint({"TrulyRandom"})
    private static synchronized Cipher a() throws a {
        synchronized (a.class) {
            if (b != null) {
                Cipher cipher = b;
                return cipher;
            }
            try {
                cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
                cipher.init(1, new SecretKeySpec(d, "AES"));
                b = cipher;
                cipher = b;
                return cipher;
            } catch (Throwable e) {
                throw new a("Fail To Init Cipher", e);
            }
        }
    }

    public static byte[] a(byte[] bArr) throws b {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(c(com.qq.e.comm.a.a(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new b("Exception while packaging byte array", e);
        }
    }

    private static synchronized Cipher b() throws a {
        synchronized (a.class) {
            if (c != null) {
                Cipher cipher = c;
                return cipher;
            }
            try {
                cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
                cipher.init(2, new SecretKeySpec(d, "AES"));
                c = cipher;
                cipher = c;
                return cipher;
            } catch (Throwable e) {
                throw new a("Fail To Init Cipher", e);
            }
        }
    }

    @TargetApi(9)
    public static byte[] b(byte[] bArr) throws b {
        if (bArr != null) {
            if (bArr.length >= 4) {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                    byte[] bArr2 = new byte[4];
                    dataInputStream.read(bArr2);
                    if (a[0] == bArr2[0] && a[1] == bArr2[1] && (byte) 1 == bArr2[2]) {
                        if ((byte) 2 == bArr2[3]) {
                            return com.qq.e.comm.a.b(d(Arrays.copyOfRange(bArr, 4, bArr.length)));
                        }
                    }
                    throw new b("S2SS Package Magic/Version FormatError", null);
                } catch (Throwable e) {
                    throw new b("Exception while packaging byte array", e);
                }
            }
        }
        throw new b("S2SS Package FormatError", null);
    }

    private static byte[] c(byte[] bArr) throws a {
        try {
            return a().doFinal(bArr);
        } catch (Throwable e) {
            throw new a("Exception While encrypt byte array", e);
        }
    }

    private static byte[] d(byte[] bArr) throws a {
        try {
            return b().doFinal(bArr);
        } catch (Throwable e) {
            throw new a("Exception While dencrypt byte array", e);
        }
    }
}
