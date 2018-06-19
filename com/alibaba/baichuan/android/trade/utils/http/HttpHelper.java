package com.alibaba.baichuan.android.trade.utils.http;

import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class HttpHelper {

    public static class HttpHelpterException extends Exception {
        public int statusCode;

        HttpHelpterException(Throwable th) {
            super(th);
        }
    }

    public static String a(String str) {
        try {
            return a.a(b(str));
        } catch (Throwable e) {
            if (e instanceof HttpHelpterException) {
                throw e;
            }
            throw new HttpHelpterException(e);
        }
    }

    private static InputStream b(String str) {
        HttpHelpterException httpHelpterException;
        int responseCode;
        try {
            str = c(str);
            responseCode = str.getResponseCode();
            if (responseCode == 200) {
                return str.getInputStream();
            }
            try {
                StringBuilder stringBuilder = new StringBuilder("http request exception, response code: ");
                stringBuilder.append(responseCode);
                throw new RuntimeException(stringBuilder.toString());
            } catch (Exception e) {
                str = e;
                httpHelpterException = new HttpHelpterException(str);
                httpHelpterException.statusCode = responseCode;
                throw httpHelpterException;
            }
        } catch (Exception e2) {
            str = e2;
            responseCode = -999;
            httpHelpterException = new HttpHelpterException(str);
            httpHelpterException.statusCode = responseCode;
            throw httpHelpterException;
        }
    }

    private static HttpURLConnection c(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(ReaderCallback.GET_BAR_ANIMATING);
            httpURLConnection.setReadTimeout(ReaderCallback.GET_BAR_ANIMATING);
            return httpURLConnection;
        } catch (String str2) {
            throw new RuntimeException(str2);
        }
    }
}
