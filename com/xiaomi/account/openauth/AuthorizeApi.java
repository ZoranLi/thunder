package com.xiaomi.account.openauth;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class AuthorizeApi {
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final String HOST = "open.account.xiaomi.com";
    private static final String METHOD_GET = "GET";
    private static final String OAUTH_URL_BASE = "https://open.account.xiaomi.com";
    private static final int READ_TIMEOUT = 15000;
    private static final String UTF8 = "UTF-8";

    @Deprecated
    public static String doHttpGet(Context context, String str, long j, String str2) throws XMAuthericationException {
        return doHttpGet(str, j, str2, null, null);
    }

    public static String doHttpGet(String str, long j, String str2) throws XMAuthericationException {
        return doHttpGet(str, j, str2, null, null);
    }

    @Deprecated
    public static String doHttpGet(Context context, String str, long j, String str2, String str3, String str4) throws XMAuthericationException {
        return doHttpGet(str, j, str2, str3, str4);
    }

    public static java.lang.String doHttpGet(java.lang.String r3, long r4, java.lang.String r6, java.lang.String r7, java.lang.String r8) throws com.xiaomi.account.openauth.XMAuthericationException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "clientId";
        r4 = java.lang.String.valueOf(r4);
        r1.<init>(r2, r4);
        r0.add(r1);
        r4 = new org.apache.http.message.BasicNameValuePair;
        r5 = "token";
        r4.<init>(r5, r6);
        r0.add(r4);
        r4 = 0;
        r5 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r1 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r2 = "https://open.account.xiaomi.com";	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r1.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r1.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r1 = r1.toString();	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r1 = com.xiaomi.account.openauth.AuthorizeHelper.generateUrl(r1, r0);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5.<init>(r1);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r1 = 1;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        java.net.HttpURLConnection.setFollowRedirects(r1);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5 = r5.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5 = (java.net.HttpURLConnection) r5;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5.setDoInput(r1);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r1 = "GET";	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5.setRequestMethod(r1);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5.setConnectTimeout(r1);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r1 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5.setReadTimeout(r1);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r3 = makeHeaders(r3, r6, r7, r8, r0);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        if (r3 == 0) goto L_0x0075;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
    L_0x0057:
        r6 = r3.keySet();	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r6 = r6.iterator();	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
    L_0x005f:
        r7 = r6.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        if (r7 == 0) goto L_0x0075;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
    L_0x0065:
        r7 = r6.next();	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r7 = (java.lang.String) r7;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r8 = r3.get(r7);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r8 = (java.lang.String) r8;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5.setRequestProperty(r7, r8);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        goto L_0x005f;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
    L_0x0075:
        r5.connect();	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r3 = r5.getInputStream();	 Catch:{ IOException -> 0x007d, UnsupportedEncodingException -> 0x00d7, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        goto L_0x0081;
    L_0x007d:
        r3 = r5.getErrorStream();	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
    L_0x0081:
        if (r3 != 0) goto L_0x008e;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
    L_0x0083:
        r3 = new com.xiaomi.account.openauth.XMAuthericationException;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5 = new java.io.IOException;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r3.<init>(r5);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        throw r3;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
    L_0x008e:
        r5 = new java.io.BufferedReader;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r6 = new java.io.InputStreamReader;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r6.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r5.<init>(r6, r3);	 Catch:{ UnsupportedEncodingException -> 0x00d7, IOException -> 0x00d0, NoSuchAlgorithmException -> 0x00c9, InvalidKeyException -> 0x00c2 }
        r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x00bd, IOException -> 0x00ba, NoSuchAlgorithmException -> 0x00b7, InvalidKeyException -> 0x00b4, all -> 0x00b1 }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x00bd, IOException -> 0x00ba, NoSuchAlgorithmException -> 0x00b7, InvalidKeyException -> 0x00b4, all -> 0x00b1 }
    L_0x009f:
        r4 = r5.readLine();	 Catch:{ UnsupportedEncodingException -> 0x00bd, IOException -> 0x00ba, NoSuchAlgorithmException -> 0x00b7, InvalidKeyException -> 0x00b4, all -> 0x00b1 }
        if (r4 == 0) goto L_0x00a9;	 Catch:{ UnsupportedEncodingException -> 0x00bd, IOException -> 0x00ba, NoSuchAlgorithmException -> 0x00b7, InvalidKeyException -> 0x00b4, all -> 0x00b1 }
    L_0x00a5:
        r3.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x00bd, IOException -> 0x00ba, NoSuchAlgorithmException -> 0x00b7, InvalidKeyException -> 0x00b4, all -> 0x00b1 }
        goto L_0x009f;	 Catch:{ UnsupportedEncodingException -> 0x00bd, IOException -> 0x00ba, NoSuchAlgorithmException -> 0x00b7, InvalidKeyException -> 0x00b4, all -> 0x00b1 }
    L_0x00a9:
        r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x00bd, IOException -> 0x00ba, NoSuchAlgorithmException -> 0x00b7, InvalidKeyException -> 0x00b4, all -> 0x00b1 }
        closeQuietly(r5);
        return r3;
    L_0x00b1:
        r3 = move-exception;
        r4 = r5;
        goto L_0x00de;
    L_0x00b4:
        r3 = move-exception;
        r4 = r5;
        goto L_0x00c3;
    L_0x00b7:
        r3 = move-exception;
        r4 = r5;
        goto L_0x00ca;
    L_0x00ba:
        r3 = move-exception;
        r4 = r5;
        goto L_0x00d1;
    L_0x00bd:
        r3 = move-exception;
        r4 = r5;
        goto L_0x00d8;
    L_0x00c0:
        r3 = move-exception;
        goto L_0x00de;
    L_0x00c2:
        r3 = move-exception;
    L_0x00c3:
        r5 = new com.xiaomi.account.openauth.XMAuthericationException;	 Catch:{ all -> 0x00c0 }
        r5.<init>(r3);	 Catch:{ all -> 0x00c0 }
        throw r5;	 Catch:{ all -> 0x00c0 }
    L_0x00c9:
        r3 = move-exception;	 Catch:{ all -> 0x00c0 }
    L_0x00ca:
        r5 = new com.xiaomi.account.openauth.XMAuthericationException;	 Catch:{ all -> 0x00c0 }
        r5.<init>(r3);	 Catch:{ all -> 0x00c0 }
        throw r5;	 Catch:{ all -> 0x00c0 }
    L_0x00d0:
        r3 = move-exception;	 Catch:{ all -> 0x00c0 }
    L_0x00d1:
        r5 = new com.xiaomi.account.openauth.XMAuthericationException;	 Catch:{ all -> 0x00c0 }
        r5.<init>(r3);	 Catch:{ all -> 0x00c0 }
        throw r5;	 Catch:{ all -> 0x00c0 }
    L_0x00d7:
        r3 = move-exception;	 Catch:{ all -> 0x00c0 }
    L_0x00d8:
        r5 = new com.xiaomi.account.openauth.XMAuthericationException;	 Catch:{ all -> 0x00c0 }
        r5.<init>(r3);	 Catch:{ all -> 0x00c0 }
        throw r5;	 Catch:{ all -> 0x00c0 }
    L_0x00de:
        closeQuietly(r4);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.openauth.AuthorizeApi.doHttpGet(java.lang.String, long, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private static void closeQuietly(java.io.BufferedReader r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0006;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.openauth.AuthorizeApi.closeQuietly(java.io.BufferedReader):void");
    }

    private static HashMap<String, String> makeHeaders(String str, String str2, String str3, String str4, List<NameValuePair> list) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str3 == null && str4 == null) {
            return null;
        }
        String generateNonce = AuthorizeHelper.generateNonce();
        return AuthorizeHelper.buildMacRequestHead(str2, generateNonce, AuthorizeHelper.getMacAccessTokenSignatureString(generateNonce, "GET", HOST, str, URLEncodedUtils.format(list, "UTF-8"), str3, str4));
    }
}
