package com.tencent.smtt.export.external;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;
import java.util.ArrayList;

public class LibraryLoader {
    private static String[] sLibrarySearchPaths;

    public static String[] getLibrarySearchPaths(Context context) {
        if (sLibrarySearchPaths != null) {
            return sLibrarySearchPaths;
        }
        if (context == null) {
            return new String[]{"/system/lib"};
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getNativeLibraryDir(context));
        arrayList.add("/system/lib");
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        sLibrarySearchPaths = strArr;
        return strArr;
    }

    public static String getNativeLibraryDir(Context context) {
        int i = VERSION.SDK_INT;
        if (i >= 9) {
            return context.getApplicationInfo().nativeLibraryDir;
        }
        if (i >= 4) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getApplicationInfo().dataDir);
            stringBuilder.append("/lib");
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder("/data/data/");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("/lib");
        return stringBuilder.toString();
    }

    public static void loadLibrary(Context context, String str) {
        String[] librarySearchPaths = getLibrarySearchPaths(context);
        String mapLibraryName = System.mapLibraryName(str);
        for (String str2 : librarySearchPaths) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append("/");
            stringBuilder.append(mapLibraryName);
            String str22 = stringBuilder.toString();
            if (new File(str22).exists()) {
                try {
                    System.load(str22);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        try {
            System.loadLibrary(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
