package com.xunlei.downloadprovider.download.util.a.a;

import android.content.Context;
import android.os.Environment;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.io.File;

/* compiled from: IconsCacheUtil */
final class c {
    private static File a;

    static File a() {
        if (a != null) {
            return a;
        }
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            file = applicationInstance.getExternalCacheDir();
        }
        if (file == null) {
            file = applicationInstance.getCacheDir();
        }
        File file2 = new File(file, "TaskSnapshots");
        a = file2;
        return file2;
    }
}
