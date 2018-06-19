package com.umeng.socialize.net.utils;

import android.os.Bundle;
import com.umeng.socialize.utils.ContextUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class SocializeNetUtils {
    private static final String TAG = "SocializeNetUtils";

    public static boolean isConSpeCharacters(String str) {
        return str.replaceAll("[一-龥]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == null ? null : true;
    }

    public static boolean isSelfAppkey(String str) {
        return (str.equals("5126ff896c738f2bfa000438") == null || ContextUtil.getPackageName().equals("com.umeng.soexample") != null) ? null : true;
    }

    public static byte[] getNetData(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r6);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0089, all -> 0x0086 }
        r0.<init>();	 Catch:{ Exception -> 0x0089, all -> 0x0086 }
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r2.<init>(r6);	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r2 = r2.openConnection();	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r3 = 1;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r2.setInstanceFollowRedirects(r3);	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r3 = com.umeng.socialize.Config.connectionTimeOut;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r2.setConnectTimeout(r3);	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r3 = com.umeng.socialize.Config.readSocketTimeOut;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r2.setReadTimeout(r3);	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r4 = 301; // 0x12d float:4.22E-43 double:1.487E-321;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        if (r3 != r4) goto L_0x0045;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
    L_0x002e:
        r3 = "Location";	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r2 = r2.getHeaderField(r3);	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r6 = r2.equals(r6);	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        if (r6 == 0) goto L_0x0040;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
    L_0x003a:
        r6 = com.umeng.socialize.utils.UmengText.NET_AGAIN_ERROR;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        com.umeng.socialize.utils.Log.um(r6);	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        return r1;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
    L_0x0040:
        r6 = getNetData(r2);	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        return r6;	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
    L_0x0045:
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x0083, all -> 0x0081 }
        r3 = "image";	 Catch:{ Exception -> 0x007f }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x007f }
        r5 = "getting image from url";	 Catch:{ Exception -> 0x007f }
        r4.<init>(r5);	 Catch:{ Exception -> 0x007f }
        r4.append(r6);	 Catch:{ Exception -> 0x007f }
        r6 = r4.toString();	 Catch:{ Exception -> 0x007f }
        com.umeng.socialize.utils.Log.d(r3, r6);	 Catch:{ Exception -> 0x007f }
        r6 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ Exception -> 0x007f }
        r6 = new byte[r6];	 Catch:{ Exception -> 0x007f }
    L_0x0060:
        r3 = r2.read(r6);	 Catch:{ Exception -> 0x007f }
        r4 = -1;	 Catch:{ Exception -> 0x007f }
        if (r3 == r4) goto L_0x006c;	 Catch:{ Exception -> 0x007f }
    L_0x0067:
        r4 = 0;	 Catch:{ Exception -> 0x007f }
        r0.write(r6, r4, r3);	 Catch:{ Exception -> 0x007f }
        goto L_0x0060;	 Catch:{ Exception -> 0x007f }
    L_0x006c:
        r6 = r0.toByteArray();	 Catch:{ Exception -> 0x007f }
        if (r2 == 0) goto L_0x007e;
    L_0x0072:
        r2.close();	 Catch:{ IOException -> 0x0075, all -> 0x0079 }
    L_0x0075:
        r0.close();	 Catch:{ IOException -> 0x007e }
        goto L_0x007e;
    L_0x0079:
        r6 = move-exception;
        r0.close();	 Catch:{ IOException -> 0x007d }
    L_0x007d:
        throw r6;
    L_0x007e:
        return r6;
    L_0x007f:
        r6 = move-exception;
        goto L_0x008c;
    L_0x0081:
        r6 = move-exception;
        goto L_0x00bc;
    L_0x0083:
        r6 = move-exception;
        r2 = r1;
        goto L_0x008c;
    L_0x0086:
        r6 = move-exception;
        r0 = r1;
        goto L_0x00bc;
    L_0x0089:
        r6 = move-exception;
        r0 = r1;
        r2 = r0;
    L_0x008c:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ba }
        r3.<init>();	 Catch:{ all -> 0x00ba }
        r4 = com.umeng.socialize.utils.UmengText.IMAGE_DOWNLOAD_ERROR;	 Catch:{ all -> 0x00ba }
        r3.append(r4);	 Catch:{ all -> 0x00ba }
        r6 = r6.getMessage();	 Catch:{ all -> 0x00ba }
        r3.append(r6);	 Catch:{ all -> 0x00ba }
        r6 = r3.toString();	 Catch:{ all -> 0x00ba }
        com.umeng.socialize.utils.Log.um(r6);	 Catch:{ all -> 0x00ba }
        if (r2 == 0) goto L_0x00b9;
    L_0x00a6:
        r2.close();	 Catch:{ IOException -> 0x00b6, all -> 0x00af }
        if (r0 == 0) goto L_0x00b9;
    L_0x00ab:
        r0.close();	 Catch:{ IOException -> 0x00b9 }
        goto L_0x00b9;
    L_0x00af:
        r6 = move-exception;
        if (r0 == 0) goto L_0x00b5;
    L_0x00b2:
        r0.close();	 Catch:{ IOException -> 0x00b5 }
    L_0x00b5:
        throw r6;
    L_0x00b6:
        if (r0 == 0) goto L_0x00b9;
    L_0x00b8:
        goto L_0x00ab;
    L_0x00b9:
        return r1;
    L_0x00ba:
        r6 = move-exception;
        r1 = r2;
    L_0x00bc:
        if (r1 == 0) goto L_0x00d1;
    L_0x00be:
        r1.close();	 Catch:{ IOException -> 0x00ce, all -> 0x00c7 }
        if (r0 == 0) goto L_0x00d1;
    L_0x00c3:
        r0.close();	 Catch:{ IOException -> 0x00d1 }
        goto L_0x00d1;
    L_0x00c7:
        r6 = move-exception;
        if (r0 == 0) goto L_0x00cd;
    L_0x00ca:
        r0.close();	 Catch:{ IOException -> 0x00cd }
    L_0x00cd:
        throw r6;
    L_0x00ce:
        if (r0 == 0) goto L_0x00d1;
    L_0x00d0:
        goto L_0x00c3;
    L_0x00d1:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.utils.SocializeNetUtils.getNetData(java.lang.String):byte[]");
    }

    public static boolean startWithHttp(String str) {
        if (!str.startsWith("http://")) {
            if (str.startsWith("https://") == null) {
                return null;
            }
        }
        return true;
    }

    public static android.os.Bundle parseUrl(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0019 }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x0019 }
        r1 = r0.getQuery();	 Catch:{ MalformedURLException -> 0x0019 }
        r1 = decodeUrl(r1);	 Catch:{ MalformedURLException -> 0x0019 }
        r0 = r0.getRef();	 Catch:{ MalformedURLException -> 0x0019 }
        r0 = decodeUrl(r0);	 Catch:{ MalformedURLException -> 0x0019 }
        r1.putAll(r0);	 Catch:{ MalformedURLException -> 0x0019 }
        return r1;
    L_0x0019:
        r1 = new android.os.Bundle;
        r1.<init>();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.utils.SocializeNetUtils.parseUrl(java.lang.String):android.os.Bundle");
    }

    public static android.os.Bundle parseUri(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.net.URI;	 Catch:{ Exception -> 0x000e }
        r0.<init>(r1);	 Catch:{ Exception -> 0x000e }
        r1 = r0.getQuery();	 Catch:{ Exception -> 0x000e }
        r1 = decodeUrl(r1);	 Catch:{ Exception -> 0x000e }
        return r1;
    L_0x000e:
        r1 = new android.os.Bundle;
        r1.<init>();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.utils.SocializeNetUtils.parseUri(java.lang.String):android.os.Bundle");
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static String request(String str) {
        String str2 = "";
        try {
            str = new URL(str).openConnection();
            if (str == null) {
                return str2;
            }
            str.connect();
            str = str.getInputStream();
            if (str == null) {
                return str2;
            }
            return convertStreamToString(str);
        } catch (String str3) {
            str3.printStackTrace();
            return str2;
        }
    }

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(readLine);
                stringBuilder2.append("/n");
                stringBuilder.append(stringBuilder2.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (InputStream inputStream2) {
                    inputStream2.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }
}
