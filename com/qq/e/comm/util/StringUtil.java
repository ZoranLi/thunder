package com.qq.e.comm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StringUtil {
    public static boolean isEmpty(String str) {
        if (str != null) {
            if (str.trim().length() != 0) {
                return false;
            }
        }
        return true;
    }

    public static String join(String str, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            int i = 0;
            while (i < strArr.length) {
                if (!(str == null || i == 0)) {
                    stringBuffer.append(str);
                }
                stringBuffer.append(strArr[i]);
                i++;
            }
        }
        return stringBuffer.toString();
    }

    public static int parseInteger(java.lang.String r0, int r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Throwable -> 0x0005 }
        return r0;
    L_0x0005:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.StringUtil.parseInteger(java.lang.String, int):int");
    }

    public static String readAll(File file) throws IOException {
        IOException e;
        Throwable th;
        if (file == null || !file.exists()) {
            return null;
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuilder.append(readLine);
                    } else {
                        String stringBuilder2 = stringBuilder.toString();
                        try {
                            bufferedReader.close();
                            return stringBuilder2;
                        } catch (Throwable e2) {
                            GDTLogger.e("Exception while close bufferreader", e2);
                            return stringBuilder2;
                        }
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            throw e;
        } catch (Throwable e22) {
            th = e22;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable e222) {
                    GDTLogger.e("Exception while close bufferreader", e222);
                }
            }
            throw th;
        }
    }

    public static void writeTo(String str, File file) throws IOException {
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(str);
        fileWriter.close();
    }
}
