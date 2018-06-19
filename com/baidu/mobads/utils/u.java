package com.baidu.mobads.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class u {
    public static List<File> a(String str, String str2) {
        return a(str, str2, null);
    }

    public static List<File> a(String str, String str2, String str3) {
        return a(a(str), a(str2), str3);
    }

    public static List<File> a(File file, File file2, String str) {
        if (file != null) {
            if (file2 != null) {
                List<File> arrayList = new ArrayList();
                ZipFile zipFile = new ZipFile(file);
                file = zipFile.entries();
                if (b(str)) {
                    while (file.hasMoreElements() != null) {
                        ZipEntry zipEntry = (ZipEntry) file.nextElement();
                        if (a(file2, arrayList, zipFile, zipEntry, zipEntry.getName()) == null) {
                            return arrayList;
                        }
                    }
                }
                while (file.hasMoreElements()) {
                    ZipEntry zipEntry2 = (ZipEntry) file.nextElement();
                    String name = zipEntry2.getName();
                    if (name.contains(str) && !a(file2, arrayList, zipFile, zipEntry2, name)) {
                        return arrayList;
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    private static boolean a(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file);
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        File file2 = new File(stringBuilder.toString());
        list.add(file2);
        if (zipEntry.isDirectory() != null) {
            if (a(file2) == null) {
                return false;
            }
        } else if (b(file2) == null) {
            return false;
        } else {
            file = null;
            InputStream bufferedInputStream;
            try {
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    zipFile = new BufferedOutputStream(new FileOutputStream(file2));
                } catch (Throwable th) {
                    list = th;
                    bufferedInputStream.close();
                    file.close();
                    throw list;
                }
                try {
                    file = new byte[8192];
                    while (true) {
                        zipEntry = bufferedInputStream.read(file);
                        if (zipEntry == -1) {
                            break;
                        }
                        zipFile.write(file, 0, zipEntry);
                    }
                    bufferedInputStream.close();
                    zipFile.close();
                } catch (File file3) {
                    list = file3;
                    file3 = zipFile;
                    bufferedInputStream.close();
                    file3.close();
                    throw list;
                }
            } catch (Throwable th2) {
                list = th2;
                bufferedInputStream = null;
                bufferedInputStream.close();
                file3.close();
                throw list;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.io.File r1) {
        /*
        if (r1 == 0) goto L_0x0017;
    L_0x0002:
        r0 = r1.exists();
        if (r0 == 0) goto L_0x000f;
    L_0x0008:
        r1 = r1.isDirectory();
        if (r1 == 0) goto L_0x0017;
    L_0x000e:
        goto L_0x0015;
    L_0x000f:
        r1 = r1.mkdirs();
        if (r1 == 0) goto L_0x0017;
    L_0x0015:
        r1 = 1;
        return r1;
    L_0x0017:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.u.a(java.io.File):boolean");
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (File file2) {
            file2.printStackTrace();
            return false;
        }
    }

    private static File a(String str) {
        return b(str) ? null : new File(str);
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
