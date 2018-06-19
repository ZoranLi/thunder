package com.tencent.smtt.utils;

import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class p {
    protected static final char[] a = "0123456789abcdef".toCharArray();
    private static String b = "";
    private static byte[] c;
    private static p f;
    private static String g;
    private Cipher d = null;
    private Cipher e = null;

    private p() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(new Random().nextInt(89999999) + 10000000));
        stringBuilder.append(String.valueOf(new Random().nextInt(89999999) + 10000000));
        stringBuilder.append(String.valueOf(new Random().nextInt(89999999) + 10000000));
        g = stringBuilder.toString();
        String str = "00000000";
        for (int i = 0; i < 12; i++) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(String.valueOf(new Random().nextInt(89999999) + 10000000));
            str = stringBuilder2.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(g);
        c = stringBuilder.toString().getBytes();
        this.d = Cipher.getInstance("RSA/ECB/NoPadding");
        this.d.init(1, KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0))));
        b = b(this.d.doFinal(c));
        Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(g.getBytes()));
        this.e = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.e.init(1, generateSecret);
    }

    public static p a() {
        try {
            if (f == null) {
                f = new p();
            }
            return f;
        } catch (Exception e) {
            f = null;
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        instance.init(1, generateSecret);
        return instance.doFinal(bArr);
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = a[i2 >>> 4];
            cArr[i3 + 1] = a[i2 & 15];
        }
        return new String(cArr);
    }

    public static String c() {
        return g;
    }

    public byte[] a(byte[] bArr) {
        return this.e.doFinal(bArr);
    }

    public String b() {
        return b;
    }

    public byte[] c(byte[] bArr) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(g.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
