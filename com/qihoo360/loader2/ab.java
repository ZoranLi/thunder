package com.qihoo360.loader2;

import android.text.TextUtils;
import com.qihoo360.mobilesafe.a.a;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.utils.b;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: PluginNativeLibsHelper */
public final class ab {
    public static boolean a(String str, File file) {
        if (a.a) {
            StringBuilder stringBuilder = new StringBuilder("install(): Start. apkp=");
            stringBuilder.append(str);
            stringBuilder.append("; nd=");
            stringBuilder.append(file.getAbsolutePath());
        }
        a(file);
        ZipFile zipFile = null;
        ZipFile zipFile2;
        try {
            zipFile2 = new ZipFile(str);
            try {
                Closeable inputStream;
                Map hashMap = new HashMap();
                Map hashMap2 = new HashMap();
                a(zipFile2, hashMap, hashMap2);
                for (String str2 : hashMap2.keySet()) {
                    String a;
                    StringBuilder stringBuilder2;
                    File file2;
                    Set set = (Set) hashMap2.get(str2);
                    if (set != null) {
                        if (set.size() > 0) {
                            String[] strArr;
                            boolean a2 = at.a();
                            if (a2) {
                                strArr = b.c;
                            } else {
                                strArr = b.b;
                            }
                            a = a(set, str2, strArr);
                            if (c.a) {
                                StringBuilder stringBuilder3 = new StringBuilder("findSoPathForAbis: Find so path. name=");
                                stringBuilder3.append(str2);
                                stringBuilder3.append("; list=");
                                stringBuilder3.append(a);
                                stringBuilder3.append("; Host-is-64bit?=");
                                stringBuilder3.append(a2);
                                stringBuilder3.append("; abis=");
                                stringBuilder3.append(Arrays.toString(strArr));
                                c.a("PluginNativeLibsHelper", stringBuilder3.toString());
                            }
                            if (a.a) {
                                stringBuilder2 = new StringBuilder("install(): Ready to extract. so=");
                                stringBuilder2.append(str2);
                                stringBuilder2.append("; sop=");
                                stringBuilder2.append(a);
                            }
                            if (a != null) {
                                file2 = new File(file, str2);
                                try {
                                    inputStream = zipFile2.getInputStream((ZipEntry) hashMap.get(a));
                                    try {
                                        com.qihoo360.replugin.utils.c.a((InputStream) inputStream, file2);
                                        if (a.a) {
                                            new StringBuilder("extractFile(): Success! fn=").append(file2.getName());
                                        }
                                        b.a(inputStream);
                                    } catch (Throwable th) {
                                        str = th;
                                    }
                                } catch (Throwable th2) {
                                    str = th2;
                                    inputStream = null;
                                }
                            }
                        }
                    }
                    a = null;
                    if (a.a) {
                        stringBuilder2 = new StringBuilder("install(): Ready to extract. so=");
                        stringBuilder2.append(str2);
                        stringBuilder2.append("; sop=");
                        stringBuilder2.append(a);
                    }
                    if (a != null) {
                        file2 = new File(file, str2);
                        inputStream = zipFile2.getInputStream((ZipEntry) hashMap.get(a));
                        com.qihoo360.replugin.utils.c.a((InputStream) inputStream, file2);
                        if (a.a) {
                            new StringBuilder("extractFile(): Success! fn=").append(file2.getName());
                        }
                        b.a(inputStream);
                    }
                }
                b.a(zipFile2);
                return true;
                b.a(inputStream);
                throw str;
            } catch (Throwable th3) {
                str = th3;
            }
        } catch (Throwable th4) {
            str = th4;
            try {
                if (a.a) {
                    str.printStackTrace();
                }
                a(file);
                b.a(zipFile);
                return null;
            } catch (Throwable th5) {
                str = th5;
                zipFile2 = zipFile;
                b.a(zipFile2);
                throw str;
            }
        }
    }

    public static void a(File file) {
        if (file.exists()) {
            try {
                com.qihoo360.replugin.utils.c.c(file);
            } catch (File file2) {
                file2.printStackTrace();
            }
        }
    }

    private static void a(ZipFile zipFile, Map<String, ZipEntry> map, Map<String, Set<String>> map2) {
        zipFile = zipFile.entries();
        while (zipFile.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) zipFile.nextElement();
            String name = zipEntry.getName();
            if (!(name.contains("../") || !name.startsWith("lib/") || zipEntry.isDirectory())) {
                map.put(name, zipEntry);
                String name2 = new File(name).getName();
                Set set = (Set) map2.get(name2);
                if (set == null) {
                    set = new TreeSet();
                    map2.put(name2, set);
                }
                set.add(name);
            }
        }
    }

    private static String a(Set<String> set, String str, String[] strArr) {
        Arrays.sort(strArr);
        for (String str2 : set) {
            String replaceFirst = str2.replaceFirst("lib/", "");
            StringBuilder stringBuilder = new StringBuilder("/");
            stringBuilder.append(str);
            CharSequence replace = replaceFirst.replace(stringBuilder.toString(), "");
            if (!TextUtils.isEmpty(replace) && Arrays.binarySearch(strArr, replace) >= 0) {
                return str2;
            }
        }
        return null;
    }
}
