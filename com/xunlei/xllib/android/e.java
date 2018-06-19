package com.xunlei.xllib.android;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: StorageUtil */
public abstract class e {

    /* compiled from: StorageUtil */
    public static class a {
        private static String a = "";
        private static String b = "e$a";
        private static boolean c = false;
        private static String[] d;

        public static void a(Context context) {
            d = e.a(context);
        }

        private static String c() {
            if (d()) {
                return a;
            }
            if (!TextUtils.isEmpty(a)) {
                return (e.b(a) == 0 || !new File(a).exists()) ? "" : a;
            } else if (c) {
                return a;
            } else {
                c = true;
                String a = a();
                long b = e.b(a);
                try {
                    Process exec = Runtime.getRuntime().exec("df");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split(" ");
                        if (split != null) {
                            for (String trim : split) {
                                String trim2 = trim2.trim();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(File.separator);
                                stringBuilder.append("mnt");
                                if (!trim2.startsWith(stringBuilder.toString())) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(File.separator);
                                    stringBuilder.append("storage");
                                    if (!trim2.startsWith(stringBuilder.toString())) {
                                    }
                                }
                                while (trim2.endsWith(Constants.COLON_SEPARATOR)) {
                                    trim2 = trim2.substring(0, trim2.length() - 1);
                                }
                                if (!(e.a(a, trim2) || "/mnt/secure/asec".equals(trim2))) {
                                    long b2 = e.b(trim2);
                                    if (!(b2 == 0 || b2 == b || b2 <= 0)) {
                                        File file = new File(trim2);
                                        if (!e.a(file) && file.exists() && file.canRead() && file.canWrite()) {
                                            a = trim2;
                                            if (!trim2.endsWith(File.separator)) {
                                                StringBuilder stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append(a);
                                                stringBuilder2.append(File.separator);
                                                a = stringBuilder2.toString();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    exec.destroy();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return a;
            }
        }

        public static String a() {
            String path = Environment.getExternalStorageDirectory().getPath();
            if (path != null && !path.endsWith("/")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(path);
                stringBuilder.append("/");
                path = stringBuilder.toString();
                if (d()) {
                    return "";
                }
                if (e.b(path) == 0) {
                    return "";
                }
            } else if (path != null) {
                path = "";
            }
            if (TextUtils.isEmpty(path) && d != null && d.length > 0) {
                for (String str : d) {
                    String str2;
                    if (!str2.endsWith("/")) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str2);
                        stringBuilder2.append("/");
                        str2 = stringBuilder2.toString();
                    }
                    if (TextUtils.isEmpty(path) && str2.contains("emulated") && e.b(str2) != 0) {
                        path = str2;
                    }
                }
            }
            return path;
        }

        public static String b() {
            String c = c();
            if (d != null && d.length > 0) {
                for (String str : d) {
                    String str2;
                    if (!str2.endsWith("/")) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str2);
                        stringBuilder.append("/");
                        str2 = stringBuilder.toString();
                    }
                    if (!(!TextUtils.isEmpty(c) || str2.contains("emulated") || str2.contains("sdcard0"))) {
                        File file = new File(str2);
                        if (e.b(str2) != 0 && file.exists()) {
                            c = str2;
                        }
                    }
                }
            }
            return c;
        }

        private static boolean d() {
            try {
                return "checking".equalsIgnoreCase(Environment.getExternalStorageState());
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public static long a(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        File file = new File(str);
        boolean z = false;
        try {
            z = a(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.exists() && file.isDirectory()) {
            if (!z) {
                long blockSizeLong;
                try {
                    StatFs statFs = new StatFs(str);
                    if (VERSION.SDK_INT >= 18) {
                        blockSizeLong = statFs.getBlockSizeLong();
                        try {
                            j = statFs.getAvailableBlocksLong();
                        } catch (Exception e2) {
                            str = e2;
                            str.printStackTrace();
                            return j * blockSizeLong;
                        }
                        return j * blockSizeLong;
                    }
                    blockSizeLong = (long) statFs.getBlockSize();
                    j = (long) statFs.getAvailableBlocks();
                    return j * blockSizeLong;
                } catch (Exception e3) {
                    str = e3;
                    blockSizeLong = 0;
                    str.printStackTrace();
                    return j * blockSizeLong;
                }
            }
        }
        return 0;
    }

    public static long b(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        File file = new File(str);
        boolean z = false;
        try {
            z = a(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.exists() && file.isDirectory()) {
            if (!z) {
                long blockSizeLong;
                try {
                    StatFs statFs = new StatFs(str);
                    if (VERSION.SDK_INT >= 18) {
                        blockSizeLong = statFs.getBlockSizeLong();
                        try {
                            j = statFs.getBlockCountLong();
                        } catch (Exception e2) {
                            str = e2;
                            str.printStackTrace();
                            return j * blockSizeLong;
                        }
                        return j * blockSizeLong;
                    }
                    blockSizeLong = (long) statFs.getBlockSize();
                    j = (long) statFs.getBlockCount();
                    return j * blockSizeLong;
                } catch (Exception e3) {
                    str = e3;
                    blockSizeLong = 0;
                    str.printStackTrace();
                    return j * blockSizeLong;
                }
            }
        }
        return 0;
    }

    public static String[] a(Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            context = (String[]) storageManager.getClass().getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]);
        } catch (Context context2) {
            context2.printStackTrace();
            context2 = null;
        }
        return context2 == null ? new String[0] : context2;
    }

    public static boolean a(File file) throws IOException {
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return file.getCanonicalFile().equals(file.getAbsoluteFile()) == null ? true : null;
    }

    public static boolean a(String str, String str2) {
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
                return str.equals(str2);
            }
        }
        return null;
    }

    public static String a() {
        String path = Environment.getExternalStorageDirectory().getPath();
        if (path.endsWith(File.separator)) {
            return path;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(path);
        stringBuilder.append(File.separator);
        return stringBuilder.toString();
    }

    public static boolean b() {
        try {
            return "mounted".equalsIgnoreCase(Environment.getExternalStorageState());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
