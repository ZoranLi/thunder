package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@SuppressLint({"NewApi"})
public class k {
    public static String a = null;
    public static final a b = new m();
    private static final int c = 4;

    public interface a {
        boolean a(File file, File file2);
    }

    public interface b {
        boolean a(InputStream inputStream, ZipEntry zipEntry, String str);
    }

    public static long a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null) {
            return -1;
        }
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static ByteArrayOutputStream a(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    public static File a() {
        try {
            return Environment.getExternalStorageDirectory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File a(Context context, boolean z, String str) {
        String d = z ? d(context) : c(context);
        if (d == null) {
            return null;
        }
        File file = new File(d);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            return null;
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            return file2;
        }
        try {
            file2.createNewFile();
            return file2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(Context context, int i) {
        return a(context, context.getApplicationInfo().packageName, i, true);
    }

    private static String a(Context context, String str) {
        String str2 = "";
        if (context == null) {
            return str2;
        }
        context = context.getApplicationContext();
        try {
            return context.getExternalFilesDir(str).getAbsolutePath();
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Environment.getExternalStorageDirectory());
                stringBuilder.append(File.separator);
                stringBuilder.append("Android");
                stringBuilder.append(File.separator);
                stringBuilder.append("data");
                stringBuilder.append(File.separator);
                stringBuilder.append(context.getApplicationInfo().packageName);
                stringBuilder.append(File.separator);
                stringBuilder.append("files");
                stringBuilder.append(File.separator);
                stringBuilder.append(str);
                return stringBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static String a(Context context, String str, int i, boolean z) {
        if (context == null) {
            return "";
        }
        String str2 = "";
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory());
            stringBuilder.append(File.separator);
            str2 = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder2;
        switch (i) {
            case 1:
                if (str2.equals("")) {
                    return str2;
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT);
                stringBuilder2.append(File.separator);
                stringBuilder2.append("tbs");
                stringBuilder2.append(File.separator);
                stringBuilder2.append(str);
                return stringBuilder2.toString();
            case 2:
                if (str2.equals("")) {
                    return str2;
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append("tbs");
                stringBuilder2.append(File.separator);
                stringBuilder2.append("backup");
                stringBuilder2.append(File.separator);
                stringBuilder2.append(str);
                return stringBuilder2.toString();
            case 3:
                if (str2.equals("")) {
                    return str2;
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT);
                stringBuilder2.append(File.separator);
                stringBuilder2.append("tbs");
                stringBuilder2.append(File.separator);
                stringBuilder2.append("backup");
                stringBuilder2.append(File.separator);
                stringBuilder2.append(str);
                return stringBuilder2.toString();
            case 4:
                if (str2.equals("")) {
                    return a(context, "backup");
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str2);
                stringBuilder3.append(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT);
                stringBuilder3.append(File.separator);
                stringBuilder3.append("tbs");
                stringBuilder3.append(File.separator);
                stringBuilder3.append("backup");
                stringBuilder3.append(File.separator);
                stringBuilder3.append(str);
                str = stringBuilder3.toString();
                if (z) {
                    File file = new File(str);
                    if (!(file.exists() && file.canWrite())) {
                        if (file.exists()) {
                            str = a(context, "backup");
                        } else {
                            file.mkdirs();
                            if (!file.canWrite()) {
                                return a(context, "backup");
                            }
                        }
                    }
                }
                return str;
            case 5:
                if (str2.equals("")) {
                    return str2;
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT);
                stringBuilder2.append(File.separator);
                stringBuilder2.append("tbs");
                stringBuilder2.append(File.separator);
                stringBuilder2.append(str);
                return stringBuilder2.toString();
            case 6:
                if (a != null) {
                    return a;
                }
                String a = a(context, "tbslog");
                a = a;
                return a;
            default:
                return "";
        }
    }

    public static FileLock a(Context context, FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            return tryLock.isValid() ? tryLock : null;
        } catch (OverlappingFileLockException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(File file, boolean z) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File a : listFiles) {
                    a(a, z);
                }
                if (!z) {
                    file.delete();
                }
            }
        }
    }

    public static void a(File file, boolean z, String str) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!file2.getName().equals(str)) {
                        a(file2, z);
                    }
                }
                if (!z) {
                    file.delete();
                }
            }
        }
    }

    public static void a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                FileChannel channel = fileLock.channel();
                if (channel != null && channel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean a(Context context) {
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        boolean z = false;
        if (context != null && context.getApplicationContext().checkSelfPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) == 0) {
            z = true;
        }
        return z;
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        b(file);
        return file.mkdirs();
    }

    public static boolean a(File file, File file2) {
        return a(file.getPath(), file2.getPath());
    }

    public static boolean a(File file, File file2, FileFilter fileFilter) {
        return a(file, file2, fileFilter, b);
    }

    public static boolean a(File file, File file2, FileFilter fileFilter, a aVar) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return b(file, file2, fileFilter, aVar);
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file3 : listFiles) {
            if (!a(file3, new File(file2, file3.getName()), fileFilter)) {
                z = false;
            }
        }
        return z;
    }

    private static boolean a(String str, long j, long j2, long j3) {
        Throwable th;
        File file = new File(str);
        if (file.length() != j) {
            StringBuilder stringBuilder = new StringBuilder("file size doesn't match: ");
            stringBuilder.append(file.length());
            stringBuilder.append(" vs ");
            stringBuilder.append(j);
            TbsLog.e("FileHelper", stringBuilder.toString());
            return true;
        }
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                long value = crc32.getValue();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(file.getName());
                stringBuilder2.append(": crc = ");
                stringBuilder2.append(value);
                stringBuilder2.append(", zipCrc = ");
                stringBuilder2.append(j3);
                TbsLog.i("FileHelper", stringBuilder2.toString());
                if (value != j3) {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return true;
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = null;
            th = th4;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static boolean a(String str, String str2) {
        return a(str, str2, Build.CPU_ABI, VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, r.a("ro.product.cpu.upgradeabi", "armeabi"));
    }

    private static boolean a(String str, String str2, String str3, String str4, b bVar) {
        ZipFile zipFile;
        Throwable th;
        try {
            zipFile = new ZipFile(str);
            Enumeration entries = zipFile.entries();
            boolean z = false;
            boolean z2 = z;
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                String name = zipEntry.getName();
                if (name != null && (name.startsWith("lib/") || name.startsWith("assets/"))) {
                    String substring = name.substring(name.lastIndexOf(47));
                    if (substring.endsWith(".so")) {
                        if (name.regionMatches(c, str2, 0, str2.length()) && name.charAt(c + str2.length()) == '/') {
                            z = true;
                        } else if (str3 != null && name.regionMatches(c, str3, 0, str3.length()) && name.charAt(c + str3.length()) == '/') {
                            z2 = z ? true : true;
                        } else if (str4 == null) {
                            continue;
                        } else if (!name.regionMatches(c, str4, 0, str4.length())) {
                            continue;
                        } else if (name.charAt(c + str4.length()) != '/') {
                            continue;
                        } else if (z) {
                            continue;
                        } else if (z2) {
                            continue;
                        }
                    }
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    try {
                        if (!bVar.a(inputStream, zipEntry, substring.substring(1))) {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (zipFile != null) {
                                zipFile.close();
                            }
                            return false;
                        } else if (inputStream != null) {
                            inputStream.close();
                        } else {
                            continue;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            if (zipFile != null) {
                zipFile.close();
            }
            return true;
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4, String str5) {
        return a(str, str3, str4, str5, new l(str2));
    }

    public static int b(InputStream inputStream, OutputStream outputStream) {
        long a = a(inputStream, outputStream);
        return a > 2147483647L ? -1 : (int) a;
    }

    public static FileOutputStream b(Context context, boolean z, String str) {
        File a = a(context, z, str);
        if (a != null) {
            try {
                return new FileOutputStream(a);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void b(File file) {
        a(file, false);
    }

    public static boolean b() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(Context context) {
        long a = aa.a();
        boolean z = a >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z) {
            String str = TbsDownloader.LOGTAG;
            StringBuilder stringBuilder = new StringBuilder("[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = ");
            stringBuilder.append(a);
            TbsLog.e(str, stringBuilder.toString());
        }
        return z;
    }

    public static boolean b(File file, File file2) {
        return a(file, file2, null);
    }

    private static boolean b(File file, File file2, FileFilter fileFilter, a aVar) {
        Throwable th;
        Throwable th2;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return false;
        }
        FileChannel fileChannel = null;
        FileChannel channel;
        try {
            if (!file.exists() || !file.isFile()) {
                return false;
            }
            if (file2.exists()) {
                if (aVar != null && aVar.a(file, file2)) {
                    return true;
                }
                b(file2);
            }
            File parentFile = file2.getParentFile();
            if (parentFile.isFile()) {
                b(parentFile);
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                return false;
            }
            FileChannel channel2 = new FileInputStream(file).getChannel();
            try {
                channel = new FileOutputStream(file2).getChannel();
            } catch (Throwable th3) {
                th = th3;
                channel = null;
                fileChannel = channel2;
                th2 = th;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (channel != null) {
                    channel.close();
                }
                throw th2;
            }
            try {
                long size = channel2.size();
                if (channel.transferFrom(channel2, 0, size) != size) {
                    b(file2);
                    if (channel2 != null) {
                        channel2.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return false;
                }
                if (channel2 != null) {
                    channel2.close();
                }
                if (channel != null) {
                    channel.close();
                }
                return true;
            } catch (Throwable th4) {
                th = th4;
                fileChannel = channel2;
                th2 = th;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (channel != null) {
                    channel.close();
                }
                throw th2;
            }
        } catch (Throwable th5) {
            th2 = th5;
            channel = null;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (channel != null) {
                channel.close();
            }
            throw th2;
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) {
        Throwable e;
        StringBuilder stringBuilder;
        a(new File(str));
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(File.separator);
        stringBuilder2.append(str2);
        str = stringBuilder2.toString();
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                StringBuilder stringBuilder3;
                if (a(str, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                    stringBuilder3 = new StringBuilder("file is different: ");
                    stringBuilder3.append(str);
                    TbsLog.e("FileHelper", stringBuilder3.toString());
                    return false;
                }
                if (!file.setLastModified(zipEntry.getTime())) {
                    stringBuilder3 = new StringBuilder("Couldn't set time for dst file ");
                    stringBuilder3.append(file);
                    TbsLog.e("FileHelper", stringBuilder3.toString());
                }
                return true;
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    b(file);
                    stringBuilder = new StringBuilder("Couldn't write dst file ");
                    stringBuilder.append(file);
                    throw new IOException(stringBuilder.toString(), e);
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            b(file);
            stringBuilder = new StringBuilder("Couldn't write dst file ");
            stringBuilder.append(file);
            throw new IOException(stringBuilder.toString(), e);
        }
    }

    public static byte[] b(InputStream inputStream) {
        return a(inputStream).toByteArray();
    }

    public static File c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a().getAbsolutePath());
        stringBuilder.append("/.tbs");
        File file = new File(stringBuilder.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String c(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory());
        stringBuilder.append(File.separator);
        stringBuilder.append("tbs");
        stringBuilder.append(File.separator);
        stringBuilder.append("file_locks");
        return stringBuilder.toString();
    }

    public static boolean c(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static FileOutputStream d(File file) {
        StringBuilder stringBuilder;
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.exists() || parentFile.mkdirs())) {
                stringBuilder = new StringBuilder("File '");
                stringBuilder.append(file);
                stringBuilder.append("' could not be created");
                throw new IOException(stringBuilder.toString());
            }
        } else if (file.isDirectory()) {
            stringBuilder = new StringBuilder("File '");
            stringBuilder.append(file);
            stringBuilder.append("' exists but is a directory");
            throw new IOException(stringBuilder.toString());
        } else if (!file.canWrite()) {
            stringBuilder = new StringBuilder("File '");
            stringBuilder.append(file);
            stringBuilder.append("' cannot be written to");
            throw new IOException(stringBuilder.toString());
        }
        return new FileOutputStream(file);
    }

    static String d(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_private");
        return (file.isDirectory() || file.mkdir()) ? file.getAbsolutePath() : null;
    }
}
