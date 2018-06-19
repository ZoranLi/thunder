package com.ta.utdid2.android.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class SystemUtils {
    public static String getCpuInfo() {
        String readLine;
        IOException iOException;
        FileNotFoundException fileNotFoundException;
        String str = null;
        try {
            Reader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                readLine = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e) {
                    iOException = e;
                    str = readLine;
                    iOException.toString();
                    readLine = str;
                    return readLine != null ? "" : readLine.substring(readLine.indexOf(58) + 1).trim();
                } catch (FileNotFoundException e2) {
                    fileNotFoundException = e2;
                    fileNotFoundException.toString();
                    if (readLine != null) {
                    }
                }
            } catch (IOException e3) {
                iOException = e3;
                iOException.toString();
                readLine = str;
                if (readLine != null) {
                }
            }
        } catch (FileNotFoundException e4) {
            fileNotFoundException = e4;
            readLine = str;
            fileNotFoundException.toString();
            if (readLine != null) {
            }
        }
        if (readLine != null) {
        }
    }

    public static int getSystemVersion() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = android.os.Build.VERSION.class;	 Catch:{ Exception -> 0x000e }
        r2 = "SDK_INT";	 Catch:{ Exception -> 0x000e }
        r1 = r1.getField(r2);	 Catch:{ Exception -> 0x000e }
        r1 = r1.getInt(r0);	 Catch:{ Exception -> 0x000e }
        goto L_0x0026;
    L_0x000e:
        r1 = android.os.Build.VERSION.class;	 Catch:{ Exception -> 0x0021 }
        r2 = "SDK";	 Catch:{ Exception -> 0x0021 }
        r1 = r1.getField(r2);	 Catch:{ Exception -> 0x0021 }
        r0 = r1.get(r0);	 Catch:{ Exception -> 0x0021 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0021 }
        r1 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0021 }
        goto L_0x0026;
    L_0x0021:
        r0 = move-exception;
        r1 = 2;
        r0.printStackTrace();
    L_0x0026:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.android.utils.SystemUtils.getSystemVersion():int");
    }

    public static File getRootFolder(String str) {
        if (Environment.getExternalStorageDirectory() == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), File.separator, str}));
        if (file.exists() == null) {
            file.mkdirs();
        }
        return file;
    }

    public static String getAppLabel(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            context = context.getPackageName();
            if (!(packageManager == null || context == null)) {
                return packageManager.getApplicationLabel(packageManager.getPackageInfo(context, 1).applicationInfo).toString();
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return null;
    }
}
