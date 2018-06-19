package com.qihoo360.replugin.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* compiled from: FileUtils */
public final class c {
    public static FileInputStream a(File file) throws IOException {
        StringBuilder stringBuilder;
        if (!file.exists()) {
            stringBuilder = new StringBuilder("File '");
            stringBuilder.append(file);
            stringBuilder.append("' does not exist");
            throw new FileNotFoundException(stringBuilder.toString());
        } else if (file.isDirectory()) {
            stringBuilder = new StringBuilder("File '");
            stringBuilder.append(file);
            stringBuilder.append("' exists but is a directory");
            throw new IOException(stringBuilder.toString());
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            stringBuilder = new StringBuilder("File '");
            stringBuilder.append(file);
            stringBuilder.append("' cannot be read");
            throw new IOException(stringBuilder.toString());
        }
    }

    public static InputStream a(Context context, String str) {
        context = context.getAssets();
        if (context == null) {
            return null;
        }
        try {
            return context.open(str);
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    public static FileOutputStream b(File file) throws IOException {
        StringBuilder stringBuilder;
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.mkdirs() || parentFile.isDirectory())) {
                stringBuilder = new StringBuilder("Directory '");
                stringBuilder.append(parentFile);
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
        return new FileOutputStream(file, false);
    }

    public static void c(File file) throws IOException {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            if (file.exists()) {
                f(file);
                if (!file.delete()) {
                    StringBuilder stringBuilder = new StringBuilder("Unable to delete directory ");
                    stringBuilder.append(file);
                    stringBuilder.append(".");
                    throw new IOException(stringBuilder.toString());
                }
            }
            return;
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (exists) {
                stringBuilder = new StringBuilder("Unable to delete file: ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
            StringBuilder stringBuilder2 = new StringBuilder("File does not exist: ");
            stringBuilder2.append(file);
            throw new FileNotFoundException(stringBuilder2.toString());
        }
    }

    public static String a(File file, Charset charset) throws IOException {
        Closeable a;
        try {
            a = a(file);
            try {
                charset = d.a((InputStream) a, a.a(charset));
                b.a(a);
                return charset;
            } catch (Throwable th) {
                charset = th;
                b.a(a);
                throw charset;
            }
        } catch (Throwable th2) {
            charset = th2;
            a = null;
            b.a(a);
            throw charset;
        }
    }

    public static boolean d(java.io.File r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        if (r2 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r2.isDirectory();	 Catch:{ Exception -> 0x000d }
        if (r1 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x000d }
    L_0x000a:
        f(r2);	 Catch:{ Exception -> 0x000d }
    L_0x000d:
        r2 = r2.delete();	 Catch:{ Exception -> 0x0012 }
        return r2;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.c.d(java.io.File):boolean");
    }

    public static void b(File file, File file2) throws IOException {
        e(file, file2);
        StringBuilder stringBuilder;
        if (file.isDirectory()) {
            stringBuilder = new StringBuilder("Source '");
            stringBuilder.append(file);
            stringBuilder.append("' exists but is a directory");
            throw new IOException(stringBuilder.toString());
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            StringBuilder stringBuilder2 = new StringBuilder("Source '");
            stringBuilder2.append(file);
            stringBuilder2.append("' and destination '");
            stringBuilder2.append(file2);
            stringBuilder2.append("' are the same");
            throw new IOException(stringBuilder2.toString());
        } else {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                file2 = new StringBuilder("Destination '");
                file2.append(parentFile);
                file2.append("' directory cannot be created");
                throw new IOException(file2.toString());
            } else if (!file2.exists() || file2.canWrite()) {
                d(file, file2);
            } else {
                stringBuilder = new StringBuilder("Destination '");
                stringBuilder.append(file2);
                stringBuilder.append("' exists but is read-only");
                throw new IOException(stringBuilder.toString());
            }
        }
    }

    private static void d(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        Throwable th2;
        Closeable closeable;
        FileChannel channel;
        File file3 = file;
        File file4 = file2;
        if (file2.exists() && file2.isDirectory()) {
            StringBuilder stringBuilder = new StringBuilder("Destination '");
            stringBuilder.append(file4);
            stringBuilder.append("' exists but is a directory");
            throw new IOException(stringBuilder.toString());
        }
        Closeable closeable2 = null;
        try {
            FileChannel channel2;
            fileInputStream = new FileInputStream(file3);
            try {
                fileOutputStream = new FileOutputStream(file4);
            } catch (Throwable th22) {
                th = th22;
                fileOutputStream = null;
                closeable = fileOutputStream;
                b.a(closeable2, fileOutputStream, closeable, fileInputStream);
                throw th;
            }
            try {
                channel = fileInputStream.getChannel();
                try {
                    channel2 = fileOutputStream.getChannel();
                } catch (Throwable th222) {
                    closeable = channel;
                    th = th222;
                    b.a(closeable2, fileOutputStream, closeable, fileInputStream);
                    throw th;
                }
            } catch (Throwable th2222) {
                th = th2222;
                closeable = null;
                b.a(closeable2, fileOutputStream, closeable, fileInputStream);
                throw th;
            }
            try {
                long size = channel.size();
                long j = 0;
                while (j < size) {
                    long j2 = size - j;
                    closeable = channel;
                    try {
                        j2 = channel2.transferFrom(channel, j, j2 > 31457280 ? 31457280 : j2);
                        if (j2 == 0) {
                            break;
                        }
                        j += j2;
                        channel = closeable;
                    } catch (Throwable th3) {
                        th2222 = th3;
                    }
                }
                closeable = channel;
                b.a(channel2, fileOutputStream, closeable, fileInputStream);
                long length = file.length();
                long length2 = file2.length();
                if (length != length2) {
                    StringBuilder stringBuilder2 = new StringBuilder("Failed to copy full contents from '");
                    stringBuilder2.append(file3);
                    stringBuilder2.append("' to '");
                    stringBuilder2.append(file4);
                    stringBuilder2.append("' Expected length: ");
                    stringBuilder2.append(length);
                    stringBuilder2.append(" Actual: ");
                    stringBuilder2.append(length2);
                    throw new IOException(stringBuilder2.toString());
                }
                file4.setLastModified(file.lastModified());
            } catch (Throwable th4) {
                th2222 = th4;
                closeable = channel;
                th = th2222;
                closeable2 = channel2;
                b.a(closeable2, fileOutputStream, closeable, fileInputStream);
                throw th;
            }
        } catch (Throwable th22222) {
            th = th22222;
            fileInputStream = null;
            fileOutputStream = fileInputStream;
            closeable = fileOutputStream;
            b.a(closeable2, fileOutputStream, closeable, fileInputStream);
            throw th;
        }
    }

    private static void e(File file, File file2) throws FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (file.exists() == null) {
            StringBuilder stringBuilder = new StringBuilder("Source '");
            stringBuilder.append(file);
            stringBuilder.append("' does not exist");
            throw new FileNotFoundException(stringBuilder.toString());
        }
    }

    public static void c(File file, File file2) throws IOException {
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            r0 = new StringBuilder("Source '");
            r0.append(file);
            r0.append("' does not exist");
            throw new FileNotFoundException(r0.toString());
        } else if (file.isDirectory()) {
            r0 = new StringBuilder("Source '");
            r0.append(file);
            r0.append("' is a directory");
            throw new IOException(r0.toString());
        } else if (file2.exists()) {
            r0 = new StringBuilder("Destination '");
            r0.append(file2);
            r0.append("' already exists");
            throw new IOException(r0.toString());
        } else if (file2.isDirectory()) {
            r0 = new StringBuilder("Destination '");
            r0.append(file2);
            r0.append("' is a directory");
            throw new IOException(r0.toString());
        } else if (!file.renameTo(file2)) {
            b(file, file2);
            if (!file.delete()) {
                d(file2);
                StringBuilder stringBuilder = new StringBuilder("Failed to delete original file '");
                stringBuilder.append(file);
                stringBuilder.append("' after copy to '");
                stringBuilder.append(file2);
                stringBuilder.append("'");
                throw new IOException(stringBuilder.toString());
            }
        }
    }

    public static long e(File file) {
        file = file.listFiles();
        if (file == null) {
            return 0;
        }
        int length = file.length;
        int i = 0;
        long j = 0;
        while (i < length) {
            long e;
            File file2 = file[i];
            if (file2.isDirectory()) {
                e = e(file2);
            } else {
                e = file2.length();
            }
            long j2 = j + e;
            if (j2 < 0) {
                j = j2;
                break;
            }
            i++;
            j = j2;
        }
        return j;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".");
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        if (lastIndexOf2 == -1) {
            if (lastIndexOf == -1) {
                return str;
            }
            return str.substring(0, lastIndexOf);
        } else if (lastIndexOf == -1) {
            return str.substring(lastIndexOf2 + 1);
        } else {
            return lastIndexOf2 < lastIndexOf ? str.substring(lastIndexOf2 + 1, lastIndexOf) : str.substring(lastIndexOf2 + 1);
        }
    }

    private static void f(File file) throws IOException {
        StringBuilder stringBuilder;
        if (!file.exists()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(file);
            stringBuilder.append(" does not exist");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder stringBuilder2 = new StringBuilder("Failed to list contents of ");
                stringBuilder2.append(file);
                throw new IOException(stringBuilder2.toString());
            }
            file = null;
            for (File c : listFiles) {
                try {
                    c(c);
                } catch (IOException e) {
                    file = e;
                }
            }
            if (file != null) {
                throw file;
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(file);
            stringBuilder.append(" is not a directory");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static void a(File file, File file2) throws IOException {
        e(file, file2);
        StringBuilder stringBuilder;
        if (!file.isDirectory()) {
            stringBuilder = new StringBuilder("Source '");
            stringBuilder.append(file);
            stringBuilder.append("' exists but is not a directory");
            throw new IOException(stringBuilder.toString());
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            StringBuilder stringBuilder2 = new StringBuilder("Source '");
            stringBuilder2.append(file);
            stringBuilder2.append("' and destination '");
            stringBuilder2.append(file2);
            stringBuilder2.append("' are the same");
            throw new IOException(stringBuilder2.toString());
        } else if (!file2.exists() || file2.canWrite()) {
            for (File file3 : file.listFiles()) {
                b(file3, new File(file2, file3.getName()));
            }
        } else {
            stringBuilder = new StringBuilder("Destination '");
            stringBuilder.append(file2);
            stringBuilder.append("' exists but is read-only");
            throw new IOException(stringBuilder.toString());
        }
    }

    public static void a(java.io.InputStream r1, java.io.File r2) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Unexpected register number in merge insn: ?: MERGE  (r1_3 java.io.Closeable) = (r1_2 java.io.Closeable), (r1_5 java.io.Closeable)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMerge(EliminatePhiNodes.java:84)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMergeInstructions(EliminatePhiNodes.java:68)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.visit(EliminatePhiNodes.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = b(r2);	 Catch:{ all -> 0x0016 }
        com.qihoo360.replugin.utils.d.a(r1, r2);	 Catch:{ all -> 0x0011 }
        r2.close();	 Catch:{ all -> 0x0011 }
        com.qihoo360.replugin.utils.b.a(r2);	 Catch:{ all -> 0x0016 }
        com.qihoo360.replugin.utils.b.a(r1);
        return;
    L_0x0011:
        r0 = move-exception;
        com.qihoo360.replugin.utils.b.a(r2);	 Catch:{ all -> 0x0016 }
        throw r0;	 Catch:{ all -> 0x0016 }
    L_0x0016:
        r2 = move-exception;
        com.qihoo360.replugin.utils.b.a(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.c.a(java.io.InputStream, java.io.File):void");
    }
}
