package com.xiaomi.account.openauth;

import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.account.openauth.utils.Base64Coder;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class AuthorizeHelper {
    private static final String HMAC_SHA1 = "HmacSHA1";
    public static final String OAUTH2_HOST;
    public static final boolean USE_PREVIEW;
    private static final String UTF8 = "UTF-8";
    private static Random random = new Random();

    static {
        boolean exists = new File("/data/system/oauth_staging_preview").exists();
        USE_PREVIEW = exists;
        OAUTH2_HOST = exists ? "http://account.preview.n.xiaomi.net" : "https://account.xiaomi.com";
    }

    protected static String getMacAccessTokenSignatureString(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if (HMAC_SHA1.equalsIgnoreCase(str7)) {
            str7 = new StringBuilder("");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\n");
            str7.append(stringBuilder.toString());
            str = new StringBuilder();
            str.append(str2.toUpperCase());
            str.append("\n");
            str7.append(str.toString());
            str = new StringBuilder();
            str.append(str3);
            str.append("\n");
            str7.append(str.toString());
            str = new StringBuilder();
            str.append(str4);
            str.append("\n");
            str7.append(str.toString());
            if (TextUtils.isEmpty(str5) == null) {
                str = new StringBuffer();
                str2 = new ArrayList();
                URLEncodedUtils.parse(str2, new Scanner(str5), "UTF-8");
                Collections.sort(str2, new Comparator<NameValuePair>() {
                    public final int compare(NameValuePair nameValuePair, NameValuePair nameValuePair2) {
                        return nameValuePair.getName().compareTo(nameValuePair2.getName());
                    }
                });
                str.append(URLEncodedUtils.format(str2, "UTF-8"));
                str2 = new StringBuilder();
                str2.append(str.toString());
                str2.append("\n");
                str7.append(str2.toString());
            }
            return encodeSign(encryptHMACSha1(str7.toString().getBytes("UTF-8"), str6.getBytes("UTF-8")));
        }
        str2 = new StringBuilder("error mac algorithm : ");
        str2.append(str7);
        throw new NoSuchAlgorithmException(str2.toString());
    }

    protected static HashMap<String, String> buildMacRequestHead(String str, String str2, String str3) throws UnsupportedEncodingException {
        str = String.format("MAC access_token=\"%s\", nonce=\"%s\",mac=\"%s\"", new Object[]{URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"), URLEncoder.encode(str3, "UTF-8")});
        str2 = new HashMap();
        str2.put("Authorization", str);
        return str2;
    }

    protected static String generateNonce() {
        long nextLong = random.nextLong();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 60000);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nextLong);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(currentTimeMillis);
        return stringBuilder.toString();
    }

    protected static String encodeSign(byte[] bArr) {
        return new String(Base64Coder.encode(bArr));
    }

    protected static byte[] encryptHMACSha1(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException {
        Key secretKeySpec = new SecretKeySpec(bArr2, HMAC_SHA1);
        bArr2 = Mac.getInstance(HMAC_SHA1);
        bArr2.init(secretKeySpec);
        bArr2.update(bArr);
        return bArr2.doFinal();
    }

    protected static String generateUrl(String str, List<NameValuePair> list) {
        if (list == null || list.size() <= 0) {
            return str;
        }
        str = Uri.parse(str).buildUpon();
        for (NameValuePair nameValuePair : list) {
            str.appendQueryParameter(nameValuePair.getName(), nameValuePair.getValue());
        }
        return str.build().toString();
    }
}
