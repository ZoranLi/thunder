package com.huawei.hms.support.api.push.a.a.b;

import android.text.TextUtils;
import com.huawei.hms.support.api.push.a.a.a.b;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES128_CBC */
public abstract class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return a(str, a());
    }

    public static String a(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (bArr != null) {
            if (bArr.length > 0) {
                try {
                    Key secretKeySpec = new SecretKeySpec(bArr, "AES");
                    bArr = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    byte[] bArr2 = new byte[16];
                    new SecureRandom().nextBytes(bArr2);
                    bArr.init(1, secretKeySpec, new IvParameterSpec(bArr2));
                    return a(com.huawei.hms.support.api.push.a.a.a.a.a(bArr2), com.huawei.hms.support.api.push.a.a.a.a.a(bArr.doFinal(str.getBytes("UTF-8"))));
                } catch (Exception e) {
                    b("IllegalArgumentException aes cbc encrypter data error", e);
                    return null;
                } catch (Exception e2) {
                    b("InvalidKeyException aes cbc encrypter data error", e2);
                    return null;
                } catch (Exception e22) {
                    b("InvalidAlgorithmParameterException aes cbc encrypter data error", e22);
                    return null;
                } catch (Exception e222) {
                    b("IllegalBlockSizeException aes cbc encrypter data error", e222);
                    return null;
                } catch (Exception e2222) {
                    b("UnsupportedEncodingException aes cbc encrypter data error", e2222);
                    return null;
                } catch (Exception e22222) {
                    b("aes cbc encrypter data error", e22222);
                    return null;
                }
            }
        }
        return "";
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return b(str, a());
    }

    public static String b(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (bArr != null) {
            if (bArr.length > 0) {
                try {
                    Key secretKeySpec = new SecretKeySpec(bArr, "AES");
                    bArr = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    Object c = c(str);
                    str = d(str);
                    if (!TextUtils.isEmpty(c)) {
                        if (!TextUtils.isEmpty(str)) {
                            bArr.init(2, secretKeySpec, new IvParameterSpec(com.huawei.hms.support.api.push.a.a.a.a.b(c)));
                            return new String(bArr.doFinal(com.huawei.hms.support.api.push.a.a.a.a.b(str)), "UTF-8");
                        }
                    }
                    if (com.huawei.hms.support.log.a.b() != null) {
                        com.huawei.hms.support.log.a.b("AES128_CBC", "ivParameter or encrypedWord is null");
                    }
                    return "";
                } catch (Exception e) {
                    a("aes cbc decrypter data error", e);
                    return "";
                } catch (Exception e2) {
                    a("aes cbc decrypter data error", e2);
                    return "";
                } catch (Exception e22) {
                    a("aes cbc decrypter data error", e22);
                    return "";
                } catch (Exception e222) {
                    a("aes cbc decrypter data error", e222);
                    return "";
                } catch (Exception e2222) {
                    a("aes cbc decrypter data error", e2222);
                    return "";
                } catch (Exception e22222) {
                    a("aes cbc encrypter data error", e22222);
                    return "";
                }
            }
        }
        return "";
    }

    private static byte[] a() {
        byte[] b = com.huawei.hms.support.api.push.a.a.a.a.b(b.a());
        byte[] b2 = com.huawei.hms.support.api.push.a.a.a.a.b(b.a());
        return a(a(a(b, b2), com.huawei.hms.support.api.push.a.a.a.a.b("2A57086C86EF54970C1E6EB37BFC72B1")));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        if (!(bArr == null || bArr2 == null || bArr.length == 0)) {
            if (bArr2.length != 0) {
                int length = bArr.length;
                if (length != bArr2.length) {
                    return new byte[0];
                }
                byte[] bArr3 = new byte[length];
                while (i < length) {
                    bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
                    i++;
                }
                return bArr3;
            }
        }
        return new byte[0];
    }

    private static byte[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            if (bArr.length != 0) {
                while (i < bArr.length) {
                    bArr[i] = (byte) (bArr[i] >> 2);
                    i++;
                }
                return bArr;
            }
        }
        return new byte[0];
    }

    private static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str2.substring(0, 6));
                    stringBuffer.append(str.substring(0, 6));
                    stringBuffer.append(str2.substring(6, 10));
                    stringBuffer.append(str.substring(6, 16));
                    stringBuffer.append(str2.substring(10, 16));
                    stringBuffer.append(str.substring(16));
                    stringBuffer.append(str2.substring(16));
                    return stringBuffer.toString();
                } catch (String str3) {
                    if (com.huawei.hms.support.log.a.d() != null) {
                        com.huawei.hms.support.log.a.d("AES128_CBC", str3.getMessage());
                    }
                    return "";
                }
            }
        }
        return "";
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(6, 12));
            stringBuffer.append(str.substring(16, 26));
            stringBuffer.append(str.substring(32, 48));
            return stringBuffer.toString();
        } catch (String str2) {
            if (com.huawei.hms.support.log.a.d()) {
                StringBuilder stringBuilder = new StringBuilder("get iv error:");
                stringBuilder.append(str2.getMessage());
                com.huawei.hms.support.log.a.d("AES128_CBC", stringBuilder.toString());
            }
            return "";
        }
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 6));
            stringBuffer.append(str.substring(12, 16));
            stringBuffer.append(str.substring(26, 32));
            stringBuffer.append(str.substring(48));
            return stringBuffer.toString();
        } catch (String str2) {
            if (com.huawei.hms.support.log.a.d()) {
                StringBuilder stringBuilder = new StringBuilder("get encrypt word error:");
                stringBuilder.append(str2.getMessage());
                com.huawei.hms.support.log.a.d("AES128_CBC", stringBuilder.toString());
            }
            return "";
        }
    }

    private static void a(String str, Exception exception) {
        if (com.huawei.hms.support.log.a.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(exception.getMessage());
            com.huawei.hms.support.log.a.d("AES128_CBC", stringBuilder.toString());
        }
    }

    private static void b(String str, Exception exception) {
        if (com.huawei.hms.support.log.a.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(exception.getMessage());
            com.huawei.hms.support.log.a.d("AES128_CBC", stringBuilder.toString());
        }
    }
}
