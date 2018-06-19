package com.tencent.smtt.sdk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class a {
    public static int a = 600;
    private static int b;

    public static int a() {
        BufferedReader bufferedReader;
        IOException e;
        Throwable th;
        if (b > 0) {
            return b;
        }
        int i = 0;
        try {
            int indexOf;
            String readLine;
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        indexOf = readLine.indexOf("MemTotal:");
                    }
                    break;
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (-1 == indexOf);
            readLine = readLine.substring(indexOf + 9).trim();
            if (readLine != null && readLine.length() != 0 && readLine.contains("k")) {
                i = Integer.parseInt(readLine.substring(0, readLine.indexOf("k")).trim()) / 1024;
            }
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (IOException e32) {
            e = e32;
            bufferedReader = null;
            e.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            b = i;
            return i;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        b = i;
        return i;
    }
}
