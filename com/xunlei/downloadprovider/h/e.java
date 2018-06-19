package com.xunlei.downloadprovider.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: FileUtil */
public final class e {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return null;
        }
        str = str.substring(lastIndexOf);
        if (str != null) {
            str = str.toLowerCase();
        }
        return str;
    }

    public static long a(File file) {
        long j = 0;
        if (!file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        file = file.listFiles();
        int i = 0;
        while (i < file.length) {
            i++;
            j += a(file[i]);
        }
        return j;
    }

    public static StringBuilder a(String str, String str2) {
        Closeable bufferedReader;
        File file = new File(str);
        str = new StringBuilder("");
        if (!file.isFile()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), str2));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (!str.toString().equals("")) {
                            str.append("\r\n");
                        }
                        str.append(readLine);
                    } else {
                        a(bufferedReader);
                        return str;
                    }
                } catch (IOException e) {
                    str = e;
                }
            }
        } catch (IOException e2) {
            str = e2;
            bufferedReader = null;
            try {
                str.printStackTrace();
                a(bufferedReader);
                return null;
            } catch (Throwable th) {
                str = th;
                a(bufferedReader);
                throw str;
            }
        } catch (Throwable th2) {
            str = th2;
            bufferedReader = null;
            a(bufferedReader);
            throw str;
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        if (file.exists() == null) {
            return true;
        }
        if (file.isFile() != null) {
            return file.delete();
        }
        int i = 0;
        if (file.isDirectory() == null) {
            return false;
        }
        str = file.listFiles();
        if (str == null) {
            return false;
        }
        int length = str.length;
        while (i < length) {
            File file2 = str[i];
            if (file2.isFile()) {
                file2.delete();
            } else if (file2.isDirectory()) {
                d(file2.getAbsolutePath());
            }
            i++;
        }
        return file.delete();
    }

    public static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        Closeable closeable = null;
        try {
            b(str);
            Closeable fileWriter = new FileWriter(str, false);
            try {
                fileWriter.write(str2);
                a(fileWriter);
                return true;
            } catch (IOException e) {
                str = e;
                closeable = fileWriter;
                try {
                    str.printStackTrace();
                    a(closeable);
                    return false;
                } catch (Throwable th) {
                    str = th;
                    a(closeable);
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                closeable = fileWriter;
                a(closeable);
                throw str;
            }
        } catch (IOException e2) {
            str = e2;
            str.printStackTrace();
            a(closeable);
            return false;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                closeable2.printStackTrace();
            }
        }
    }

    public static boolean e(String str) {
        if (str != null) {
            return str.endsWith(ShareConstants.PATCH_SUFFIX) || str.endsWith(".APK") != null;
        } else {
            return false;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean f(String str) {
        return str != null ? str.toLowerCase().endsWith(".torrent") : null;
    }

    public static boolean g(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() != null) {
            if (file.isDirectory() != null) {
                z = true;
                return z;
            }
        }
        try {
            z = file.mkdirs();
        } catch (String str2) {
            str2.printStackTrace();
        }
        return z;
    }

    public static boolean c(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder stringBuilder;
                if (!str2.endsWith(File.separator)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(File.separator);
                    str2 = stringBuilder.toString();
                }
                if (!str.endsWith(File.separator)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(File.separator);
                    str = stringBuilder.toString();
                }
                return str.equalsIgnoreCase(str2);
            }
        }
        return null;
    }

    public static void d(String str, String str2) {
        try {
            str = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
            while (true) {
                ZipEntry nextEntry = str.getNextEntry();
                if (nextEntry != null) {
                    try {
                        byte[] bArr = new byte[4096];
                        String name = nextEntry.getName();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str2);
                        stringBuilder.append(name);
                        File file = new File(stringBuilder.toString());
                        File file2 = new File(file.getParent());
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 4096);
                        while (true) {
                            int read = str.read(bArr, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    str.close();
                    return;
                }
            }
        } catch (String str3) {
            str3.printStackTrace();
        }
    }

    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf == -1) {
                str = "";
            } else {
                str = str.substring(0, lastIndexOf);
            }
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if ((file.exists() == null || file.isDirectory() == null) && file.mkdirs() == null) {
            return false;
        }
        return true;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() == null || file.isFile() == null) {
            return false;
        }
        return true;
    }
}
