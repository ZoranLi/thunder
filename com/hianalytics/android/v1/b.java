package com.hianalytics.android.v1;

import com.hianalytics.android.b.a.a;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class b {
    public static boolean a(String str, byte[] bArr) {
        IOException e;
        Throwable th;
        boolean z = false;
        OutputStream outputStream = null;
        HttpURLConnection httpURLConnection;
        try {
            OutputStream outputStream2;
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                a.h();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(ReaderCallback.GET_BAR_ANIMATING);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                outputStream2 = httpURLConnection.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                try {
                    new StringBuilder("IOException:").append(e.getMessage());
                    a.h();
                    e.printStackTrace();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        a.h();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        a.h();
                    }
                    throw th;
                }
            }
            try {
                outputStream2.write(bArr);
                outputStream2.flush();
                int responseCode = httpURLConnection.getResponseCode();
                a.h();
                if (responseCode == 200) {
                    z = true;
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    a.h();
                }
                return z;
            } catch (IOException e5) {
                e32 = e5;
                outputStream = outputStream2;
                new StringBuilder("IOException:").append(e32.getMessage());
                a.h();
                e32.printStackTrace();
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    a.h();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                outputStream = outputStream2;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    a.h();
                }
                throw th;
            }
        } catch (IOException e6) {
            e32 = e6;
            httpURLConnection = null;
            new StringBuilder("IOException:").append(e32.getMessage());
            a.h();
            e32.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                a.h();
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                a.h();
            }
            throw th;
        }
    }
}
