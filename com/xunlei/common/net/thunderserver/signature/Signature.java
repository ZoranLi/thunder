package com.xunlei.common.net.thunderserver.signature;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.xllib.b.b;
import com.xunlei.xllib.b.k;
import java.security.Key;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Signature {
    private static final Random RAND = new Random();
    private final String mSecret;

    public Signature(String str) {
        if (str == null) {
            throw new NullPointerException("The secret for signature can not be null.");
        }
        this.mSecret = str;
    }

    static long generateTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    static String generateNonce() {
        return String.valueOf(RAND.nextInt());
    }

    static String urlSafeBase64Encode(byte[] bArr) {
        return b.a(bArr);
    }

    static String urlEncode(String str) {
        return k.c(str, "UTF-8");
    }

    private String encodeParams(List<Parameter> list, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(list == null || list.isEmpty())) {
            Collections.sort(list);
            int i = 0;
            for (Parameter parameter : list) {
                if (i > 0) {
                    stringBuilder.append("%26");
                }
                stringBuilder.append(urlEncode(parameter.name));
                stringBuilder.append("%3D");
                stringBuilder.append(parameter.getEncodedValue());
                i++;
            }
        }
        if (TextUtils.isEmpty(str) == null) {
            stringBuilder.append("%26");
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public String baseString(String str, String str2, List<Parameter> list, String str3) {
        return String.format("%s&%s&%s", new Object[]{str, urlEncode(str2), encodeParams(list, str3)});
    }

    public String sign(String str, String str2, List<Parameter> list, String str3) {
        return signBaseString(baseString(str, str2, list, str3));
    }

    @NonNull
    private String signBaseString(String str) {
        try {
            Key secretKeySpec = new SecretKeySpec(this.mSecret.getBytes("UTF-8"), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            return urlSafeBase64Encode(instance.doFinal(str.getBytes("UTF-8")));
        } catch (String str2) {
            throw new IllegalArgumentException("Signature args err", str2);
        }
    }
}
