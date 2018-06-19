package com.umeng.socialize.a.b;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: CacheUtil */
public class a {

    /* compiled from: CacheUtil */
    private static class a implements Comparator<File> {
        private a() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((File) obj, (File) obj2);
        }

        public int a(File file, File file2) {
            if (file.lastModified() > file2.lastModified()) {
                return 1;
            }
            return file.lastModified() == file2.lastModified() ? null : -1;
        }
    }

    public static void a() {
        Object obj = (Environment.getExternalStorageDirectory() == null || TextUtils.isEmpty(Environment.getExternalStorageDirectory().getPath())) ? null : 1;
        StringBuilder stringBuilder;
        if (obj != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder.append(File.separator);
            stringBuilder.append(c.e);
            stringBuilder.append(File.separator);
            c.d = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getDataDirectory().getPath());
            stringBuilder.append(File.separator);
            stringBuilder.append(c.e);
            stringBuilder.append(File.separator);
            c.d = stringBuilder.toString();
        }
        File file = new File(c.d);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            a(c.d);
        } catch (Exception e) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(UmengText.CLEAN_CACHE_ERROR);
            stringBuilder2.append(e.toString());
            Log.um(stringBuilder2.toString());
        }
    }

    private static void a(String str) {
        str = new File(str).listFiles();
        if (str != null) {
            if (str.length != 0) {
                int i = 0;
                int i2 = 0;
                int i3 = i2;
                while (i2 < str.length) {
                    i3 = (int) (((long) i3) + str[i2].length());
                    i2++;
                }
                if (i3 > 0 || 40 > c()) {
                    i2 = str.length;
                    Arrays.sort(str, new a());
                    while (i < i2) {
                        str[i].delete();
                        i++;
                    }
                }
            }
        }
    }

    private static int c() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (int) ((((double) statFs.getAvailableBlocks()) * ((double) statFs.getBlockSize())) / 1048576.0d);
    }

    public static void b() {
        a();
    }
}
