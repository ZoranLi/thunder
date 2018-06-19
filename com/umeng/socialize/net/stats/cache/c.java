package com.umeng.socialize.net.stats.cache;

import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.tinker.android.dex.DexFormat;
import com.umeng.socialize.net.utils.AesHelper;
import com.umeng.socialize.utils.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: StatsLogCache */
public class c {
    private static final String a = "c";
    private static final String b = ".log";
    private final int c = 32;
    private final int d = 512;
    private final int e = 50;
    private final int f = 8;
    private String g = null;

    /* compiled from: StatsLogCache */
    public static class a {
        private String a;
        private List<String> b = new ArrayList();

        public String a() {
            return this.a;
        }

        public void a(String str) {
            this.a = str;
        }

        public List<String> b() {
            return this.b;
        }

        public void a(List<String> list) {
            this.b = list;
        }
    }

    public static double a(long j) {
        return (((double) j) / 1024.0d) / 1024.0d;
    }

    private double b(long j) {
        return j <= 0 ? 0.0d : ((double) j) / 1024.0d;
    }

    public c(String str) {
        this.g = str;
        str = a;
        StringBuilder stringBuilder = new StringBuilder("dir path");
        stringBuilder.append(this.g);
        Log.d(str, stringBuilder.toString());
    }

    public boolean a(String str) {
        File e = e();
        File a = a(e);
        boolean z = false;
        if (a == null) {
            return false;
        }
        double b = b();
        if (b < 50.0d) {
            str = a;
            StringBuilder stringBuilder = new StringBuilder("InternalMemory beyond the min limit, current size is:");
            stringBuilder.append(b);
            Log.e(str, stringBuilder.toString());
            return false;
        } else if (g(e)) {
            Log.e(a, "dir size beyond the max limit");
            return false;
        } else {
            Closeable a2;
            a aVar = new a(a);
            Closeable closeable = null;
            try {
                a2 = aVar.a(true);
            } catch (IOException e2) {
                e2.printStackTrace();
                b(a.getName());
                a2 = null;
            }
            if (a2 == null) {
                return false;
            }
            Closeable closeable2;
            try {
                StringBuilder stringBuilder2 = new StringBuilder("stats url = ");
                stringBuilder2.append(str);
                Log.net(stringBuilder2.toString());
                str = AesHelper.encryptNoPadding(str, "UTF-8");
            } catch (String str2) {
                try {
                    str2.printStackTrace();
                    Log.e(a, "save log encrypt error");
                    str2 = null;
                } catch (IOException e3) {
                    str2 = e3;
                    closeable2 = null;
                    try {
                        aVar.b(a2);
                        str2.printStackTrace();
                        a(closeable);
                        a(closeable2);
                        a(a2);
                        return z;
                    } catch (Throwable th) {
                        str2 = th;
                        a(closeable);
                        a(closeable2);
                        a(a2);
                        throw str2;
                    }
                } catch (Throwable th2) {
                    str2 = th2;
                    closeable2 = null;
                    a(closeable);
                    a(closeable2);
                    a(a2);
                    throw str2;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                closeable2 = null;
            } else {
                closeable2 = new OutputStreamWriter(a2);
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(closeable2);
                    try {
                        bufferedWriter.write(str2);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        aVar.a((FileOutputStream) a2);
                        z = true;
                        closeable = bufferedWriter;
                    } catch (IOException e4) {
                        str2 = e4;
                        closeable = bufferedWriter;
                        aVar.b(a2);
                        str2.printStackTrace();
                        a(closeable);
                        a(closeable2);
                        a(a2);
                        return z;
                    } catch (Throwable th3) {
                        str2 = th3;
                        closeable = bufferedWriter;
                        a(closeable);
                        a(closeable2);
                        a(a2);
                        throw str2;
                    }
                } catch (IOException e5) {
                    str2 = e5;
                    aVar.b(a2);
                    str2.printStackTrace();
                    a(closeable);
                    a(closeable2);
                    a(a2);
                    return z;
                }
            }
            a(closeable);
            a(closeable2);
            a(a2);
            return z;
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                closeable2.printStackTrace();
            }
        }
    }

    private File a(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                File b;
                String[] list = file.list();
                if (list != null) {
                    if (list.length > 0) {
                        b = b(file);
                        if (b == null) {
                            b = c(file);
                        }
                        return b;
                    }
                }
                b = c(file);
                return b;
            }
        }
        return null;
    }

    private File b(File file) {
        file = d(file);
        if (file != null) {
            if (file.length > 0) {
                int i = 0;
                while (i < file.length) {
                    File file2 = file[i];
                    if (!file2.getName().endsWith(".log")) {
                        b(file2.getName());
                        i++;
                    } else if (b(file2.length()) > 32.0d) {
                        return null;
                    } else {
                        return file2;
                    }
                }
                return null;
            }
        }
        return null;
    }

    private File c(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                return new File(file, c());
            }
        }
        return null;
    }

    private String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(System.currentTimeMillis()));
        stringBuilder.append(".log");
        return stringBuilder.toString();
    }

    private File[] d(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                file = file.listFiles();
                Arrays.sort(file, d());
                return file;
            }
        }
        return null;
    }

    private Comparator<File> d() {
        return new Comparator<File>(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return a((File) obj, (File) obj2);
            }

            public int a(File file, File file2) {
                return Long.valueOf(file.length()).compareTo(Long.valueOf(file2.length()));
            }
        };
    }

    private File e() {
        if (TextUtils.isEmpty(this.g)) {
            Log.d(a, "Couldn't create directory mDirPath is null");
            return null;
        }
        File file = new File(this.g);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("Couldn't create directory");
        stringBuilder.append(this.g);
        Log.d(str, stringBuilder.toString());
        return null;
    }

    public boolean b(String str) {
        File e = e();
        if (e == null) {
            return false;
        }
        boolean delete = new File(e, str).delete();
        String str2 = a;
        StringBuilder stringBuilder = new StringBuilder("deleteFile:");
        stringBuilder.append(str);
        stringBuilder.append(";result:");
        stringBuilder.append(delete);
        Log.d(str2, stringBuilder.toString());
        return delete;
    }

    public a a() {
        IOException e;
        Throwable th;
        File e2 = e(e());
        if (e2 == null) {
            return null;
        }
        Closeable c;
        try {
            c = new a(e2).c();
        } catch (IOException e3) {
            e3.printStackTrace();
            b(e2.getName());
            c = null;
        }
        if (c == null) {
            return null;
        }
        Closeable inputStreamReader;
        Closeable bufferedReader;
        try {
            a aVar = new a();
            aVar.a(e2.getName());
            inputStreamReader = new InputStreamReader(c);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    List arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        Object readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        i++;
                        String str = a;
                        StringBuilder stringBuilder = new StringBuilder("read file:");
                        stringBuilder.append(i);
                        stringBuilder.append(readLine);
                        Log.d(str, stringBuilder.toString());
                        if (!TextUtils.isEmpty(readLine)) {
                            try {
                                readLine = AesHelper.decryptNoPadding(readLine, "UTF-8").replaceAll(DexFormat.MAGIC_SUFFIX, "");
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                Log.e(a, "read log decrypt error");
                                readLine = null;
                            }
                            if (TextUtils.isEmpty(readLine) || !readLine.contains("sdkv")) {
                                Log.e(a, "read log content error");
                            } else {
                                arrayList.add(readLine);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        b(aVar.a());
                        a(c);
                        a(inputStreamReader);
                        a(bufferedReader);
                        return null;
                    }
                    aVar.a(arrayList);
                    a(c);
                    a(inputStreamReader);
                    a(bufferedReader);
                    return aVar;
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
                try {
                    e.printStackTrace();
                    a(c);
                    a(inputStreamReader);
                    a(bufferedReader);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    a(c);
                    a(inputStreamReader);
                    a(bufferedReader);
                    throw th;
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                a(c);
                a(inputStreamReader);
                a(bufferedReader);
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            inputStreamReader = null;
            bufferedReader = inputStreamReader;
            e.printStackTrace();
            a(c);
            a(inputStreamReader);
            a(bufferedReader);
            return null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            inputStreamReader = bufferedReader;
            a(c);
            a(inputStreamReader);
            a(bufferedReader);
            throw th;
        }
    }

    private File e(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    if (list.length > 0) {
                        return f(file);
                    }
                }
                return null;
            }
        }
        return null;
    }

    private File f(File file) {
        file = d(file);
        if (file != null) {
            if (file.length > 0) {
                for (File file2 : file) {
                    if (b(file2.length()) <= 40.0d && file2.getName().endsWith(".log")) {
                        return file2;
                    }
                    String str = a;
                    StringBuilder stringBuilder = new StringBuilder("getReadableFileFromFiles:file length don't legal");
                    stringBuilder.append(file2.length());
                    Log.e(str, stringBuilder.toString());
                    b(file2.getName());
                }
                return null;
            }
        }
        return null;
    }

    private boolean g(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            if (listFiles.length > 0) {
                long j = 0;
                for (File file2 : listFiles) {
                    long length;
                    if (file2.getName().endsWith(".log")) {
                        length = j + file2.length();
                    } else if (b(file2.getName())) {
                    } else {
                        length = j + file2.length();
                    }
                    j = length;
                }
                double d = ((double) j) / 1024.0d;
                String str = a;
                StringBuilder stringBuilder = new StringBuilder("dir size is:");
                stringBuilder.append(d);
                stringBuilder.append(";length:");
                stringBuilder.append(file.length());
                Log.e(str, stringBuilder.toString());
                if (d > 512.0d) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static double b() {
        long blockSizeLong;
        long availableBlocksLong;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (VERSION.SDK_INT >= 18) {
            blockSizeLong = statFs.getBlockSizeLong();
            availableBlocksLong = statFs.getAvailableBlocksLong();
        } else {
            blockSizeLong = (long) statFs.getBlockSize();
            availableBlocksLong = (long) statFs.getAvailableBlocks();
        }
        return a(availableBlocksLong * blockSizeLong);
    }
}
