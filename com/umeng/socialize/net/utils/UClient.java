package com.umeng.socialize.net.utils;

import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.utils.URequest.FilePair;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class UClient {
    private static final String END = "\r\n";
    private static final String TAG = "UClient";

    protected static class ResponseObj {
        public int httpResponseCode;
        public JSONObject jsonObject;

        protected ResponseObj() {
        }
    }

    public <T extends UResponse> T execute(URequest uRequest, Class<T> cls) {
        uRequest.onPrepareRequest();
        String trim = uRequest.getHttpMethod().trim();
        verifyMethod(trim);
        uRequest = URequest.GET.equals(trim) ? httpGetRequest(uRequest) : URequest.POST.equals(trim) ? httpPostRequest(uRequest) : null;
        return createResponse(uRequest, cls);
    }

    protected <T extends UResponse> T createResponse(ResponseObj responseObj, Class<T> cls) {
        if (responseObj == null) {
            return null;
        }
        try {
            return (UResponse) cls.getConstructor(new Class[]{Integer.class, JSONObject.class}).newInstance(new Object[]{Integer.valueOf(responseObj.httpResponseCode), responseObj.jsonObject});
        } catch (ResponseObj responseObj2) {
            Log.e(TAG, "SecurityException", responseObj2);
            return null;
        } catch (ResponseObj responseObj22) {
            Log.e(TAG, "NoSuchMethodException", responseObj22);
            return null;
        } catch (ResponseObj responseObj222) {
            Log.e(TAG, "IllegalArgumentException", responseObj222);
            return null;
        } catch (ResponseObj responseObj2222) {
            Log.e(TAG, "InstantiationException", responseObj2222);
            return null;
        } catch (ResponseObj responseObj22222) {
            Log.e(TAG, "IllegalAccessException", responseObj22222);
            return null;
        } catch (ResponseObj responseObj222222) {
            Log.e(TAG, "InvocationTargetException", responseObj222222);
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.umeng.socialize.net.utils.UClient.ResponseObj httpPostRequest(com.umeng.socialize.net.utils.URequest r8) {
        /*
        r7 = this;
        r0 = r8.toJson();
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r0 = "";
        goto L_0x0011;
    L_0x0009:
        r0 = r8.toJson();
        r0 = r0.toString();
    L_0x0011:
        r1 = new java.lang.StringBuilder;
        r2 = "URequest  = ";
        r1.<init>(r2);
        r2 = r8.getClass();
        r2 = r2.getName();
        r1.append(r2);
        r1 = r1.toString();
        com.umeng.socialize.utils.Log.net(r1);
        r1 = java.util.UUID.randomUUID();
        r1 = r1.toString();
        r2 = 0;
        r3 = r7.openUrlConnection(r8);	 Catch:{ IOException -> 0x01bb, all -> 0x01b7 }
        if (r3 != 0) goto L_0x0045;
    L_0x0039:
        r7.closeQuietly(r2);
        r7.closeQuietly(r2);
        if (r3 == 0) goto L_0x0044;
    L_0x0041:
        r3.disconnect();
    L_0x0044:
        return r2;
    L_0x0045:
        r4 = r8.getBodyPair();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r5 = r8.mMimeType;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        if (r5 == 0) goto L_0x0074;
    L_0x004d:
        r0 = "data";
        r0 = r4.get(r0);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0 = (java.lang.String) r0;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = "Content-Type";
        r4 = r8.mMimeType;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r3.setRequestProperty(r1, r4);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = r3.getOutputStream();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0 = r0.getBytes();	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r1.write(r0);	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        goto L_0x0161;
    L_0x006d:
        r8 = move-exception;
        goto L_0x01d4;
    L_0x0070:
        r8 = move-exception;
    L_0x0071:
        r0 = r2;
        goto L_0x01bf;
    L_0x0074:
        r5 = r8.postStyle;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r6 = com.umeng.socialize.net.utils.URequest.PostStyle.APPLICATION;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        if (r5 != r6) goto L_0x00f5;
    L_0x007a:
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r5 = "message:";
        r1.<init>(r5);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1.append(r0);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0 = r1.toString();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        com.umeng.socialize.utils.Log.net(r0);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0 = "Content-Type";
        r1 = "application/x-www-form-urlencoded";
        r3.setRequestProperty(r0, r1);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0 = new android.net.Uri$Builder;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0.<init>();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = r4.keySet();	 Catch:{ Throwable -> 0x00b7 }
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x00b7 }
    L_0x009f:
        r5 = r1.hasNext();	 Catch:{ Throwable -> 0x00b7 }
        if (r5 == 0) goto L_0x00da;
    L_0x00a5:
        r5 = r1.next();	 Catch:{ Throwable -> 0x00b7 }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x00b7 }
        r6 = r4.get(r5);	 Catch:{ Throwable -> 0x00b7 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x00b7 }
        r0.appendQueryParameter(r5, r6);	 Catch:{ Throwable -> 0x00b7 }
        goto L_0x009f;
    L_0x00b7:
        r1 = move-exception;
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r4.<init>();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r5 = com.umeng.socialize.utils.UmengText.UPLOADFAIL;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r4.append(r5);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r5 = "[";
        r4.append(r5);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = r1.getMessage();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r4.append(r1);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = "]";
        r4.append(r1);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = r4.toString();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        com.umeng.socialize.utils.Log.um(r1);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
    L_0x00da:
        r0 = r0.build();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0 = r0.getEncodedQuery();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r4 = r3.getOutputStream();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1.<init>(r4);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        if (r0 == 0) goto L_0x0161;
    L_0x00ed:
        r0 = r0.getBytes();	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r1.write(r0);	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        goto L_0x0161;
    L_0x00f5:
        if (r4 == 0) goto L_0x00fd;
    L_0x00f7:
        r4 = r4.size();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        if (r4 > 0) goto L_0x0103;
    L_0x00fd:
        r4 = r8.postStyle;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r5 = com.umeng.socialize.net.utils.URequest.PostStyle.MULTIPART;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        if (r4 != r5) goto L_0x0127;
    L_0x0103:
        r0 = "Content-Type";
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r5 = "multipart/form-data; boundary=";
        r4.<init>(r5);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r4.append(r1);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r3.setRequestProperty(r0, r4);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0 = r3.getOutputStream();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r7.addBodyParams(r8, r0, r1);	 Catch:{ IOException -> 0x0123, all -> 0x011f }
        r1 = r0;
        goto L_0x0161;
    L_0x011f:
        r8 = move-exception;
        r1 = r0;
        goto L_0x01d4;
    L_0x0123:
        r8 = move-exception;
        r1 = r0;
        goto L_0x0071;
    L_0x0127:
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r4 = "message:";
        r1.<init>(r4);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1.append(r0);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        com.umeng.socialize.utils.Log.net(r1);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = "Content-Type";
        r4 = "application/x-www-form-urlencoded";
        r3.setRequestProperty(r1, r4);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = new android.net.Uri$Builder;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1.<init>();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r4 = "content";
        r1.appendQueryParameter(r4, r0);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0 = r1.build();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0 = r0.getEncodedQuery();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r4 = r3.getOutputStream();	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r1.<init>(r4);	 Catch:{ IOException -> 0x01b3, all -> 0x01b0 }
        r0 = r0.getBytes();	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r1.write(r0);	 Catch:{ IOException -> 0x0070, all -> 0x006d }
    L_0x0161:
        r1.flush();	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r0 = r3.getResponseCode();	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r4 = new com.umeng.socialize.net.utils.UClient$ResponseObj;	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r4.<init>();	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r4.httpResponseCode = r0;	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r5) goto L_0x01a4;
    L_0x0173:
        r0 = r3.getInputStream();	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r5 = r3.getContentEncoding();	 Catch:{ IOException -> 0x01a2 }
        r6 = r3.getRequestMethod();	 Catch:{ IOException -> 0x01a2 }
        r8 = r7.parseResult(r8, r6, r5, r0);	 Catch:{ IOException -> 0x01a2 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01a2 }
        r6 = "requestMethod:POST;json data:";
        r5.<init>(r6);	 Catch:{ IOException -> 0x01a2 }
        r5.append(r8);	 Catch:{ IOException -> 0x01a2 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x01a2 }
        com.umeng.socialize.utils.Log.net(r5);	 Catch:{ IOException -> 0x01a2 }
        r4.jsonObject = r8;	 Catch:{ IOException -> 0x01a2 }
        r7.closeQuietly(r0);
        r7.closeQuietly(r1);
        if (r3 == 0) goto L_0x01a1;
    L_0x019e:
        r3.disconnect();
    L_0x01a1:
        return r4;
    L_0x01a2:
        r8 = move-exception;
        goto L_0x01bf;
    L_0x01a4:
        r7.closeQuietly(r2);
        r7.closeQuietly(r1);
        if (r3 == 0) goto L_0x01af;
    L_0x01ac:
        r3.disconnect();
    L_0x01af:
        return r2;
    L_0x01b0:
        r8 = move-exception;
        r1 = r2;
        goto L_0x01d4;
    L_0x01b3:
        r8 = move-exception;
        r0 = r2;
        r1 = r0;
        goto L_0x01bf;
    L_0x01b7:
        r8 = move-exception;
        r1 = r2;
        r3 = r1;
        goto L_0x01d4;
    L_0x01bb:
        r8 = move-exception;
        r0 = r2;
        r1 = r0;
        r3 = r1;
    L_0x01bf:
        r4 = "UClient";
        r5 = "Caught Exception in httpPostRequest()";
        com.umeng.socialize.utils.Log.e(r4, r5, r8);	 Catch:{ all -> 0x01d2 }
        r7.closeQuietly(r0);
        r7.closeQuietly(r1);
        if (r3 == 0) goto L_0x01d1;
    L_0x01ce:
        r3.disconnect();
    L_0x01d1:
        return r2;
    L_0x01d2:
        r8 = move-exception;
        r2 = r0;
    L_0x01d4:
        r7.closeQuietly(r2);
        r7.closeQuietly(r1);
        if (r3 == 0) goto L_0x01df;
    L_0x01dc:
        r3.disconnect();
    L_0x01df:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.utils.UClient.httpPostRequest(com.umeng.socialize.net.utils.URequest):com.umeng.socialize.net.utils.UClient$ResponseObj");
    }

    private ResponseObj httpGetRequest(URequest uRequest) {
        StringBuilder stringBuilder = new StringBuilder("URequest  = ");
        stringBuilder.append(uRequest.getClass().getName());
        Log.net(stringBuilder.toString());
        HttpURLConnection openUrlConnection;
        Closeable inputStream;
        try {
            openUrlConnection = openUrlConnection(uRequest);
            if (openUrlConnection == null) {
                closeQuietly(null);
                if (openUrlConnection != null) {
                    openUrlConnection.disconnect();
                }
                return null;
            }
            try {
                int responseCode = openUrlConnection.getResponseCode();
                ResponseObj responseObj = new ResponseObj();
                responseObj.httpResponseCode = responseCode;
                if (responseCode == 200) {
                    inputStream = openUrlConnection.getInputStream();
                    try {
                        uRequest = parseResult(uRequest, openUrlConnection.getRequestMethod(), openUrlConnection.getContentEncoding(), inputStream);
                        responseObj.jsonObject = uRequest;
                        StringBuilder stringBuilder2 = new StringBuilder("result  = ");
                        stringBuilder2.append(uRequest);
                        Log.net(stringBuilder2.toString());
                        closeQuietly(inputStream);
                        if (openUrlConnection != null) {
                            openUrlConnection.disconnect();
                        }
                        return responseObj;
                    } catch (Exception e) {
                        uRequest = e;
                        try {
                            Log.e(TAG, "Caught Exception in httpGetRequest()", uRequest);
                            closeQuietly(inputStream);
                            if (openUrlConnection != null) {
                                openUrlConnection.disconnect();
                            }
                            return null;
                        } catch (Throwable th) {
                            uRequest = th;
                            closeQuietly(inputStream);
                            if (openUrlConnection != null) {
                                openUrlConnection.disconnect();
                            }
                            throw uRequest;
                        }
                    }
                }
                closeQuietly(null);
                if (openUrlConnection != null) {
                    openUrlConnection.disconnect();
                }
                return null;
            } catch (Exception e2) {
                uRequest = e2;
                inputStream = null;
                Log.e(TAG, "Caught Exception in httpGetRequest()", uRequest);
                closeQuietly(inputStream);
                if (openUrlConnection != null) {
                    openUrlConnection.disconnect();
                }
                return null;
            } catch (Throwable th2) {
                uRequest = th2;
                inputStream = null;
                closeQuietly(inputStream);
                if (openUrlConnection != null) {
                    openUrlConnection.disconnect();
                }
                throw uRequest;
            }
        } catch (Exception e3) {
            uRequest = e3;
            openUrlConnection = null;
            inputStream = openUrlConnection;
            Log.e(TAG, "Caught Exception in httpGetRequest()", uRequest);
            closeQuietly(inputStream);
            if (openUrlConnection != null) {
                openUrlConnection.disconnect();
            }
            return null;
        } catch (Throwable th3) {
            uRequest = th3;
            openUrlConnection = null;
            inputStream = openUrlConnection;
            closeQuietly(inputStream);
            if (openUrlConnection != null) {
                openUrlConnection.disconnect();
            }
            throw uRequest;
        }
    }

    private HttpURLConnection openUrlConnection(URequest uRequest) throws IOException {
        String trim = uRequest.getHttpMethod().trim();
        Object toGetUrl = URequest.GET.equals(trim) ? uRequest.toGetUrl() : URequest.POST.equals(trim) ? uRequest.mBaseUrl : null;
        if (TextUtils.isEmpty(toGetUrl)) {
            return null;
        }
        HttpURLConnection httpURLConnection;
        URL url = new URL(toGetUrl);
        if ("https".equals(url.getProtocol())) {
            httpURLConnection = (HttpsURLConnection) url.openConnection();
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(Config.connectionTimeOut);
        httpURLConnection.setReadTimeout(Config.readSocketTimeOut);
        httpURLConnection.setRequestMethod(trim);
        if (URequest.GET.equals(trim)) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (uRequest.mHeaders != null && uRequest.mHeaders.size() > 0) {
                for (String str : uRequest.mHeaders.keySet()) {
                    httpURLConnection.setRequestProperty(str, (String) uRequest.mHeaders.get(str));
                }
            }
        } else if (URequest.POST.equals(trim) != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    private void verifyMethod(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ((URequest.GET.equals(str.trim()) ^ URequest.POST.equals(str.trim())) != 0) {
                return;
            }
        }
        throw new RuntimeException(UmengText.netMethodError(str));
    }

    private void addBodyParams(URequest uRequest, OutputStream outputStream, String str) throws IOException {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder();
        Map bodyPair = uRequest.getBodyPair();
        for (String str2 : bodyPair.keySet()) {
            if (bodyPair.get(str2) != null) {
                addFormField(stringBuilder, str2, bodyPair.get(str2).toString(), str);
            }
        }
        if (stringBuilder.length() > 0) {
            OutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(stringBuilder.toString().getBytes());
            outputStream = dataOutputStream;
            obj = 1;
        } else {
            obj = null;
        }
        uRequest = uRequest.getFilePair();
        if (uRequest != null && uRequest.size() > 0) {
            for (String str22 : uRequest.keySet()) {
                FilePair filePair = (FilePair) uRequest.get(str22);
                byte[] bArr = filePair.mBinaryData;
                if (bArr != null && bArr.length > 0) {
                    addFilePart(filePair.mFileName, bArr, str, outputStream);
                    obj = 1;
                }
            }
        }
        if (obj != null) {
            finishWrite(outputStream, str);
        }
    }

    private void addFormField(StringBuilder stringBuilder, String str, String str2, String str3) {
        stringBuilder.append("--");
        stringBuilder.append(str3);
        stringBuilder.append("\r\nContent-Disposition: form-data; name=\"");
        stringBuilder.append(str);
        stringBuilder.append("\"\r\nContent-Type: text/plain; charset=UTF-8\r\n\r\n");
        stringBuilder.append(str2);
        stringBuilder.append(END);
    }

    private void addFilePart(String str, byte[] bArr, String str2, OutputStream outputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(str2);
        stringBuilder.append("\r\nContent-Disposition: form-data; name=\"pic\"; filename=\"");
        stringBuilder.append(str);
        stringBuilder.append("\"\r\nContent-Type: application/octet-stream\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        outputStream.write(stringBuilder.toString().getBytes());
        outputStream.write(bArr);
        outputStream.write(END.getBytes());
    }

    private void finishWrite(OutputStream outputStream, String str) throws IOException {
        outputStream.write(END.getBytes());
        StringBuilder stringBuilder = new StringBuilder("--");
        stringBuilder.append(str);
        stringBuilder.append("--");
        outputStream.write(stringBuilder.toString().getBytes());
        outputStream.write(END.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    protected org.json.JSONObject parseResult(com.umeng.socialize.net.utils.URequest r4, java.lang.String r5, java.lang.String r6, java.io.InputStream r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r6 = r3.wrapStream(r6, r7);	 Catch:{ IOException -> 0x005c, all -> 0x0059 }
        r7 = r3.convertStreamToString(r6);	 Catch:{ IOException -> 0x0057 }
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0057 }
        r2 = "requestMethod:";	 Catch:{ IOException -> 0x0057 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0057 }
        r1.append(r5);	 Catch:{ IOException -> 0x0057 }
        r2 = ";origin data:";	 Catch:{ IOException -> 0x0057 }
        r1.append(r2);	 Catch:{ IOException -> 0x0057 }
        r1.append(r7);	 Catch:{ IOException -> 0x0057 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x0057 }
        com.umeng.socialize.utils.Log.net(r1);	 Catch:{ IOException -> 0x0057 }
        r1 = "POST";	 Catch:{ IOException -> 0x0057 }
        r1 = r1.equals(r5);	 Catch:{ IOException -> 0x0057 }
        if (r1 == 0) goto L_0x003b;
    L_0x002a:
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0033 }
        r5.<init>(r7);	 Catch:{ Exception -> 0x0033 }
        r3.closeQuietly(r6);
        return r5;
    L_0x0033:
        r4 = r3.decryptData(r4, r7);	 Catch:{ IOException -> 0x0057 }
        r3.closeQuietly(r6);
        return r4;
    L_0x003b:
        r1 = "GET";	 Catch:{ IOException -> 0x0057 }
        r5 = r1.equals(r5);	 Catch:{ IOException -> 0x0057 }
        if (r5 == 0) goto L_0x0065;	 Catch:{ IOException -> 0x0057 }
    L_0x0043:
        r5 = android.text.TextUtils.isEmpty(r7);	 Catch:{ IOException -> 0x0057 }
        if (r5 == 0) goto L_0x004d;
    L_0x0049:
        r3.closeQuietly(r6);
        return r0;
    L_0x004d:
        r4 = r3.decryptData(r4, r7);	 Catch:{ IOException -> 0x0057 }
        r3.closeQuietly(r6);
        return r4;
    L_0x0055:
        r4 = move-exception;
        goto L_0x0069;
    L_0x0057:
        r4 = move-exception;
        goto L_0x005e;
    L_0x0059:
        r4 = move-exception;
        r6 = r0;
        goto L_0x0069;
    L_0x005c:
        r4 = move-exception;
        r6 = r0;
    L_0x005e:
        r5 = "UClient";	 Catch:{ all -> 0x0055 }
        r7 = "Caught IOException in parseResult()";	 Catch:{ all -> 0x0055 }
        com.umeng.socialize.utils.Log.e(r5, r7, r4);	 Catch:{ all -> 0x0055 }
    L_0x0065:
        r3.closeQuietly(r6);
        return r0;
    L_0x0069:
        r3.closeQuietly(r6);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.utils.UClient.parseResult(com.umeng.socialize.net.utils.URequest, java.lang.String, java.lang.String, java.io.InputStream):org.json.JSONObject");
    }

    protected InputStream wrapStream(String str, InputStream inputStream) throws IOException {
        if (str != null) {
            if (!"identity".equalsIgnoreCase(str)) {
                if ("gzip".equalsIgnoreCase(str)) {
                    return new GZIPInputStream(inputStream);
                }
                if ("deflate".equalsIgnoreCase(str)) {
                    return new InflaterInputStream(inputStream, new Inflater(false), 512);
                }
                StringBuilder stringBuilder = new StringBuilder("unsupported content-encoding: ");
                stringBuilder.append(str);
                throw new RuntimeException(stringBuilder.toString());
            }
        }
        return inputStream;
    }

    protected String convertStreamToString(InputStream inputStream) {
        Closeable inputStreamReader = new InputStreamReader(inputStream);
        inputStream = new BufferedReader(inputStreamReader, 512);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = inputStream.readLine();
                if (readLine == null) {
                    break;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(readLine);
                stringBuilder2.append("\n");
                stringBuilder.append(stringBuilder2.toString());
            } catch (IOException e) {
                stringBuilder = e;
                Log.e(TAG, "Caught IOException in convertStreamToString()", stringBuilder);
                return null;
            } finally {
                closeQuietly(inputStreamReader);
                closeQuietly(inputStream);
            }
        }
        return stringBuilder.toString();
    }

    private org.json.JSONObject decryptData(com.umeng.socialize.net.utils.URequest r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = r1.getDecryptString(r2);	 Catch:{ Throwable -> 0x000a }
        r2 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x000a }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x000a }
        return r2;
    L_0x000a:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.utils.UClient.decryptData(com.umeng.socialize.net.utils.URequest, java.lang.String):org.json.JSONObject");
    }

    protected void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                Log.e(TAG, "Caught IOException in closeQuietly()", closeable2);
            }
        }
    }
}
