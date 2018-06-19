package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Set;

public class HttpManager {
    private static final String BOUNDARY = getBoundry();
    private static final String END_MP_BOUNDARY;
    private static final String MP_BOUNDARY;
    private static final String TAG = "HttpManager";

    private static native String calcOauthSignNative(Context context, String str, String str2);

    static {
        System.loadLibrary("weibosdkcore");
        StringBuilder stringBuilder = new StringBuilder("--");
        stringBuilder.append(BOUNDARY);
        MP_BOUNDARY = stringBuilder.toString();
        stringBuilder = new StringBuilder("--");
        stringBuilder.append(BOUNDARY);
        stringBuilder.append("--");
        END_MP_BOUNDARY = stringBuilder.toString();
    }

    public static String openUrl(Context context, String str, String str2, WeiboParameters weiboParameters) throws WeiboException {
        context = requestHttpExecute(context, str, str2, weiboParameters);
        str = TAG;
        str2 = new StringBuilder("Response : ");
        str2.append(context);
        LogUtil.d(str, str2.toString());
        return context;
    }

    private static String requestHttpExecute(Context context, String str, String str2, WeiboParameters weiboParameters) {
        Throwable e;
        HttpURLConnection httpURLConnection = null;
        try {
            setHttpCommonParam(context, weiboParameters);
            if ("GET".equals(str2) != null) {
                str2 = new StringBuilder();
                str2.append(str);
                str2.append("?");
                str2.append(weiboParameters.encodeUrl());
                context = ConnectionFactory.createConnect(str2.toString(), context);
                try {
                    context.setRequestMethod("GET");
                    context.setInstanceFollowRedirects(true);
                    context.connect();
                } catch (IOException e2) {
                    e = e2;
                    httpURLConnection = context;
                    try {
                        e.printStackTrace();
                        throw new WeiboException(e);
                    } catch (Throwable th) {
                        str = th;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw str;
                    }
                } catch (Throwable th2) {
                    str = th2;
                    httpURLConnection = context;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw str;
                }
            }
            context = ConnectionFactory.createConnect(str, context);
            context.setInstanceFollowRedirects(true);
            context.connect();
            if (weiboParameters.hasBinaryData() != null) {
                str = new DataOutputStream(context.getOutputStream());
                buildParams(str, weiboParameters);
                str.flush();
                str.close();
            } else {
                str = new DataOutputStream(context.getOutputStream());
                str.write(weiboParameters.encodeUrl().getBytes("UTF-8"));
                str.flush();
                str.close();
            }
            httpURLConnection = context;
            context = httpURLConnection.getResponseCode();
            if (context != 200) {
                throw new WeiboHttpException(readConnectResponse(httpURLConnection), context);
            }
            context = readConnectResponse(httpURLConnection);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return context;
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            throw new WeiboException(e);
        }
    }

    private static java.lang.String readConnectResponse(java.net.HttpURLConnection r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r1 = 0;
        r0 = new byte[r0];	 Catch:{ IOException -> 0x003d, all -> 0x0039 }
        r4 = r4.getInputStream();	 Catch:{ IOException -> 0x003d, all -> 0x0039 }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0035, all -> 0x0032 }
        r2.<init>();	 Catch:{ IOException -> 0x0035, all -> 0x0032 }
    L_0x000e:
        r1 = r4.read(r0);	 Catch:{ IOException -> 0x0030, all -> 0x002e }
        r3 = -1;	 Catch:{ IOException -> 0x0030, all -> 0x002e }
        if (r1 == r3) goto L_0x001a;	 Catch:{ IOException -> 0x0030, all -> 0x002e }
    L_0x0015:
        r3 = 0;	 Catch:{ IOException -> 0x0030, all -> 0x002e }
        r2.write(r0, r3, r1);	 Catch:{ IOException -> 0x0030, all -> 0x002e }
        goto L_0x000e;	 Catch:{ IOException -> 0x0030, all -> 0x002e }
    L_0x001a:
        r0 = new java.lang.String;	 Catch:{ IOException -> 0x0030, all -> 0x002e }
        r1 = r2.toByteArray();	 Catch:{ IOException -> 0x0030, all -> 0x002e }
        r3 = "UTF-8";	 Catch:{ IOException -> 0x0030, all -> 0x002e }
        r0.<init>(r1, r3);	 Catch:{ IOException -> 0x0030, all -> 0x002e }
        if (r4 == 0) goto L_0x002a;
    L_0x0027:
        r4.close();	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        r2.close();	 Catch:{ Exception -> 0x002d }
    L_0x002d:
        return r0;
    L_0x002e:
        r0 = move-exception;
        goto L_0x0047;
    L_0x0030:
        r0 = move-exception;
        goto L_0x0037;
    L_0x0032:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0047;
    L_0x0035:
        r0 = move-exception;
        r2 = r1;
    L_0x0037:
        r1 = r4;
        goto L_0x003f;
    L_0x0039:
        r0 = move-exception;
        r4 = r1;
        r2 = r4;
        goto L_0x0047;
    L_0x003d:
        r0 = move-exception;
        r2 = r1;
    L_0x003f:
        r4 = new com.sina.weibo.sdk.exception.WeiboException;	 Catch:{ all -> 0x0045 }
        r4.<init>(r0);	 Catch:{ all -> 0x0045 }
        throw r4;	 Catch:{ all -> 0x0045 }
    L_0x0045:
        r0 = move-exception;
        r4 = r1;
    L_0x0047:
        if (r4 == 0) goto L_0x004c;
    L_0x0049:
        r4.close();	 Catch:{ Exception -> 0x004c }
    L_0x004c:
        if (r2 == 0) goto L_0x0051;
    L_0x004e:
        r2.close();	 Catch:{ Exception -> 0x0051 }
    L_0x0051:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.HttpManager.readConnectResponse(java.net.HttpURLConnection):java.lang.String");
    }

    private static void setHttpCommonParam(Context context, WeiboParameters weiboParameters) {
        String str = "";
        if (!TextUtils.isEmpty(weiboParameters.getAppKey())) {
            str = Utility.getAid(context, weiboParameters.getAppKey());
            if (!TextUtils.isEmpty(str)) {
                weiboParameters.put("aid", str);
            }
        }
        String timestamp = getTimestamp();
        weiboParameters.put("oauth_timestamp", timestamp);
        String str2 = "";
        Object obj = weiboParameters.get("access_token");
        Object obj2 = weiboParameters.get(Oauth2AccessToken.KEY_REFRESH_TOKEN);
        Object obj3 = weiboParameters.get("phone");
        if (obj != null && (obj instanceof String)) {
            str2 = (String) obj;
        } else if (obj2 != null && (obj2 instanceof String)) {
            str2 = (String) obj2;
        } else if (obj3 != null && (obj3 instanceof String)) {
            str2 = (String) obj3;
        }
        weiboParameters.put("oauth_sign", getOauthSign(context, str, str2, weiboParameters.getAppKey(), timestamp));
    }

    public static java.lang.String openRedirectUrl4LocationUri(android.content.Context r1, java.lang.String r2, java.lang.String r3, com.sina.weibo.sdk.net.WeiboParameters r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "GET";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0041;
    L_0x0008:
        r3 = "?";
        r3 = r2.endsWith(r3);
        if (r3 == 0) goto L_0x0024;
    L_0x0010:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r2);
        r2 = r4.encodeUrl();
        r3.append(r2);
        r2 = r3.toString();
        goto L_0x003c;
    L_0x0024:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r2);
        r2 = "?";
        r3.append(r2);
        r2 = r4.encodeUrl();
        r3.append(r2);
        r2 = r3.toString();
    L_0x003c:
        r1 = com.sina.weibo.sdk.net.ConnectionFactory.createConnect(r2, r1);
        goto L_0x0045;
    L_0x0041:
        r1 = com.sina.weibo.sdk.net.ConnectionFactory.createConnect(r2, r1);
    L_0x0045:
        r3 = "";
        r4 = 0;
        r1.setInstanceFollowRedirects(r4);	 Catch:{ Exception -> 0x0068 }
        r1.connect();	 Catch:{ Exception -> 0x0068 }
        r4 = r1.getResponseCode();	 Catch:{ Exception -> 0x0068 }
        r0 = 302; // 0x12e float:4.23E-43 double:1.49E-321;	 Catch:{ Exception -> 0x0068 }
        if (r4 == r0) goto L_0x0061;	 Catch:{ Exception -> 0x0068 }
    L_0x0056:
        r0 = 301; // 0x12d float:4.22E-43 double:1.487E-321;	 Catch:{ Exception -> 0x0068 }
        if (r4 != r0) goto L_0x005b;	 Catch:{ Exception -> 0x0068 }
    L_0x005a:
        goto L_0x0061;	 Catch:{ Exception -> 0x0068 }
    L_0x005b:
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0068 }
        if (r4 != r1) goto L_0x0068;	 Catch:{ Exception -> 0x0068 }
    L_0x005f:
        r3 = r2;	 Catch:{ Exception -> 0x0068 }
        goto L_0x0068;	 Catch:{ Exception -> 0x0068 }
    L_0x0061:
        r2 = "Location";	 Catch:{ Exception -> 0x0068 }
        r1 = r1.getHeaderField(r2);	 Catch:{ Exception -> 0x0068 }
        r3 = r1;
    L_0x0068:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.HttpManager.openRedirectUrl4LocationUri(android.content.Context, java.lang.String, java.lang.String, com.sina.weibo.sdk.net.WeiboParameters):java.lang.String");
    }

    public static synchronized java.lang.String downloadFile(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) throws com.sina.weibo.sdk.exception.WeiboException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.sina.weibo.sdk.net.HttpManager.class;
        monitor-enter(r0);
        r1 = new java.io.File;	 Catch:{ all -> 0x00d6 }
        r1.<init>(r10);	 Catch:{ all -> 0x00d6 }
        r2 = r1.exists();	 Catch:{ all -> 0x00d6 }
        if (r2 != 0) goto L_0x0011;	 Catch:{ all -> 0x00d6 }
    L_0x000e:
        r1.mkdirs();	 Catch:{ all -> 0x00d6 }
    L_0x0011:
        r2 = new java.io.File;	 Catch:{ all -> 0x00d6 }
        r2.<init>(r1, r11);	 Catch:{ all -> 0x00d6 }
        r1 = r2.exists();	 Catch:{ all -> 0x00d6 }
        if (r1 == 0) goto L_0x0022;	 Catch:{ all -> 0x00d6 }
    L_0x001c:
        r8 = r2.getPath();	 Catch:{ all -> 0x00d6 }
        monitor-exit(r0);
        return r8;
    L_0x0022:
        r1 = android.webkit.URLUtil.isValidUrl(r9);	 Catch:{ all -> 0x00d6 }
        if (r1 != 0) goto L_0x002c;	 Catch:{ all -> 0x00d6 }
    L_0x0028:
        r8 = "";	 Catch:{ all -> 0x00d6 }
        monitor-exit(r0);
        return r8;
    L_0x002c:
        r1 = new java.io.File;	 Catch:{ all -> 0x00d6 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d6 }
        r3.<init>();	 Catch:{ all -> 0x00d6 }
        r3.append(r11);	 Catch:{ all -> 0x00d6 }
        r11 = "_temp";	 Catch:{ all -> 0x00d6 }
        r3.append(r11);	 Catch:{ all -> 0x00d6 }
        r11 = r3.toString();	 Catch:{ all -> 0x00d6 }
        r1.<init>(r10, r11);	 Catch:{ all -> 0x00d6 }
        r8 = com.sina.weibo.sdk.net.ConnectionFactory.createConnect(r9, r8);	 Catch:{ all -> 0x00d6 }
        r9 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;	 Catch:{ all -> 0x00d6 }
        r8.setConnectTimeout(r9);	 Catch:{ all -> 0x00d6 }
        r8.setReadTimeout(r9);	 Catch:{ all -> 0x00d6 }
        r9 = "GET";	 Catch:{ Exception -> 0x0054 }
        r8.setRequestMethod(r9);	 Catch:{ Exception -> 0x0054 }
    L_0x0054:
        r9 = r1.exists();	 Catch:{ Exception -> 0x00d2 }
        r10 = 0;	 Catch:{ Exception -> 0x00d2 }
        if (r9 == 0) goto L_0x0061;	 Catch:{ Exception -> 0x00d2 }
    L_0x005c:
        r3 = r1.length();	 Catch:{ Exception -> 0x00d2 }
        goto L_0x0065;	 Catch:{ Exception -> 0x00d2 }
    L_0x0061:
        r1.createNewFile();	 Catch:{ Exception -> 0x00d2 }
        r3 = r10;	 Catch:{ Exception -> 0x00d2 }
    L_0x0065:
        r9 = "RANGE";	 Catch:{ Exception -> 0x00d2 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d2 }
        r6 = "bytes=";	 Catch:{ Exception -> 0x00d2 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x00d2 }
        r5.append(r3);	 Catch:{ Exception -> 0x00d2 }
        r3 = r5.toString();	 Catch:{ Exception -> 0x00d2 }
        r8.setRequestProperty(r9, r3);	 Catch:{ Exception -> 0x00d2 }
        r9 = r8.getResponseCode();	 Catch:{ Exception -> 0x00d2 }
        r3 = 206; // 0xce float:2.89E-43 double:1.02E-321;	 Catch:{ Exception -> 0x00d2 }
        if (r9 == r3) goto L_0x0094;	 Catch:{ Exception -> 0x00d2 }
    L_0x0080:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x00d2 }
        if (r9 != r3) goto L_0x008a;	 Catch:{ Exception -> 0x00d2 }
    L_0x0084:
        r9 = r8.getContentLength();	 Catch:{ Exception -> 0x00d2 }
        r3 = (long) r9;	 Catch:{ Exception -> 0x00d2 }
        goto L_0x0095;	 Catch:{ Exception -> 0x00d2 }
    L_0x008a:
        r8 = readConnectResponse(r8);	 Catch:{ Exception -> 0x00d2 }
        r10 = new com.sina.weibo.sdk.exception.WeiboHttpException;	 Catch:{ Exception -> 0x00d2 }
        r10.<init>(r8, r9);	 Catch:{ Exception -> 0x00d2 }
        throw r10;	 Catch:{ Exception -> 0x00d2 }
    L_0x0094:
        r3 = r10;	 Catch:{ Exception -> 0x00d2 }
    L_0x0095:
        r8 = r8.getInputStream();	 Catch:{ Exception -> 0x00d2 }
        r9 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x00d2 }
        r5 = "rw";	 Catch:{ Exception -> 0x00d2 }
        r9.<init>(r1, r5);	 Catch:{ Exception -> 0x00d2 }
        r9.seek(r10);	 Catch:{ Exception -> 0x00d2 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Exception -> 0x00d2 }
        r5 = new byte[r5];	 Catch:{ Exception -> 0x00d2 }
    L_0x00a7:
        r6 = r8.read(r5);	 Catch:{ Exception -> 0x00d2 }
        r7 = -1;	 Catch:{ Exception -> 0x00d2 }
        if (r6 == r7) goto L_0x00b3;	 Catch:{ Exception -> 0x00d2 }
    L_0x00ae:
        r7 = 0;	 Catch:{ Exception -> 0x00d2 }
        r9.write(r5, r7, r6);	 Catch:{ Exception -> 0x00d2 }
        goto L_0x00a7;	 Catch:{ Exception -> 0x00d2 }
    L_0x00b3:
        r9.close();	 Catch:{ Exception -> 0x00d2 }
        r8.close();	 Catch:{ Exception -> 0x00d2 }
        r8 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));	 Catch:{ Exception -> 0x00d2 }
        if (r8 == 0) goto L_0x00cf;	 Catch:{ Exception -> 0x00d2 }
    L_0x00bd:
        r8 = r1.length();	 Catch:{ Exception -> 0x00d2 }
        r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1));	 Catch:{ Exception -> 0x00d2 }
        if (r10 >= 0) goto L_0x00c6;	 Catch:{ Exception -> 0x00d2 }
    L_0x00c5:
        goto L_0x00cf;	 Catch:{ Exception -> 0x00d2 }
    L_0x00c6:
        r1.renameTo(r2);	 Catch:{ Exception -> 0x00d2 }
        r8 = r2.getPath();	 Catch:{ Exception -> 0x00d2 }
        monitor-exit(r0);
        return r8;
    L_0x00cf:
        r1.delete();	 Catch:{ Exception -> 0x00d2 }
    L_0x00d2:
        r8 = "";	 Catch:{ all -> 0x00d6 }
        monitor-exit(r0);
        return r8;
    L_0x00d6:
        r8 = move-exception;
        monitor-exit(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.HttpManager.downloadFile(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void buildParams(OutputStream outputStream, WeiboParameters weiboParameters) throws WeiboException {
        try {
            StringBuilder stringBuilder;
            Set<String> keySet = weiboParameters.keySet();
            for (String str : keySet) {
                if (weiboParameters.get(str) instanceof String) {
                    stringBuilder = new StringBuilder(100);
                    stringBuilder.setLength(0);
                    stringBuilder.append(MP_BOUNDARY);
                    stringBuilder.append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"");
                    stringBuilder.append(str);
                    stringBuilder.append("\"\r\n\r\n");
                    stringBuilder.append(weiboParameters.get(str));
                    stringBuilder.append("\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                }
            }
            for (String str2 : keySet) {
                Object obj = weiboParameters.get(str2);
                if (obj instanceof Bitmap) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(MP_BOUNDARY);
                    stringBuilder.append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"");
                    stringBuilder.append(str2);
                    stringBuilder.append("\"; filename=\"file\"\r\n");
                    stringBuilder.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                    Bitmap bitmap = (Bitmap) obj;
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.write("\r\n".getBytes());
                } else if (obj instanceof ByteArrayOutputStream) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(MP_BOUNDARY);
                    stringBuilder.append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"");
                    stringBuilder.append(str2);
                    stringBuilder.append("\"; filename=\"file\"\r\n");
                    stringBuilder.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                    ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) obj;
                    outputStream.write(byteArrayOutputStream2.toByteArray());
                    outputStream.write("\r\n".getBytes());
                    byteArrayOutputStream2.close();
                }
            }
            weiboParameters = new StringBuilder("\r\n");
            weiboParameters.append(END_MP_BOUNDARY);
            outputStream.write(weiboParameters.toString().getBytes());
        } catch (Throwable e) {
            throw new WeiboException(e);
        }
    }

    public static String getBoundry() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < 12; i++) {
            long currentTimeMillis = System.currentTimeMillis() + ((long) i);
            long j = currentTimeMillis % 3;
            if (j == 0) {
                stringBuffer.append(((char) ((int) currentTimeMillis)) % 9);
            } else if (j == 1) {
                stringBuffer.append((char) ((int) (65 + (currentTimeMillis % 26))));
            } else {
                stringBuffer.append((char) ((int) (97 + (currentTimeMillis % 26))));
            }
        }
        return stringBuffer.toString();
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    private static String getOauthSign(Context context, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        if (TextUtils.isEmpty(str2) == null) {
            stringBuilder.append(str2);
        }
        if (TextUtils.isEmpty(str3) == null) {
            stringBuilder.append(str3);
        }
        return calcOauthSignNative(context, stringBuilder.toString(), str4);
    }
}
