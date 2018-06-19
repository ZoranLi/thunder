package com.umeng.socialize.weixin.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class WXAuthUtils {
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
            StringBuilder stringBuilder = new StringBuilder("##");
            stringBuilder.append(str3.getMessage());
            return stringBuilder.toString();
        }
    }

    private static String convertStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(readLine);
                str = stringBuilder.toString();
            } else {
                inputStream.close();
                return str;
            }
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
