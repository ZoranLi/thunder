package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class MultiDexExtractor {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    private static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";

    final class AnonymousClass1 implements FileFilter {
        final /* synthetic */ String val$extractedFilePrefix;

        AnonymousClass1(String str) {
            this.val$extractedFilePrefix = str;
        }

        public final boolean accept(File file) {
            file = file.getName();
            return (file.startsWith(this.val$extractedFilePrefix) || file.equals(MultiDexExtractor.LOCK_FILENAME) != null) ? null : true;
        }
    }

    private static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    MultiDexExtractor() {
    }

    static java.util.List<? extends java.io.File> load(android.content.Context r14, java.io.File r15, java.io.File r16, java.lang.String r17, boolean r18) throws java.io.IOException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = r17;
        r1 = r18;
        r3 = new java.lang.StringBuilder;
        r4 = "MultiDexExtractor.load(";
        r3.<init>(r4);
        r4 = r15.getPath();
        r3.append(r4);
        r4 = ", ";
        r3.append(r4);
        r3.append(r1);
        r4 = ", ";
        r3.append(r4);
        r3.append(r2);
        r4 = ")";
        r3.append(r4);
        r5 = getZipCrc(r15);
        r8 = new java.io.File;
        r3 = "MultiDex.lock";
        r4 = r16;
        r8.<init>(r4, r3);
        r9 = new java.io.RandomAccessFile;
        r3 = "rw";
        r9.<init>(r8, r3);
        r10 = 0;
        r11 = r9.getChannel();	 Catch:{ all -> 0x00ca }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c6 }
        r7 = "Blocking on lock ";	 Catch:{ all -> 0x00c6 }
        r3.<init>(r7);	 Catch:{ all -> 0x00c6 }
        r7 = r8.getPath();	 Catch:{ all -> 0x00c6 }
        r3.append(r7);	 Catch:{ all -> 0x00c6 }
        r12 = r11.lock();	 Catch:{ all -> 0x00c6 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c3 }
        r3.<init>();	 Catch:{ all -> 0x00c3 }
        r7 = r8.getPath();	 Catch:{ all -> 0x00c3 }
        r3.append(r7);	 Catch:{ all -> 0x00c3 }
        r7 = " locked";	 Catch:{ all -> 0x00c3 }
        r3.append(r7);	 Catch:{ all -> 0x00c3 }
        if (r1 != 0) goto L_0x0080;	 Catch:{ all -> 0x00c3 }
    L_0x0065:
        r1 = r14;	 Catch:{ all -> 0x00c3 }
        r3 = r15;	 Catch:{ all -> 0x00c3 }
        r7 = isModified(r1, r3, r5, r2);	 Catch:{ all -> 0x00c3 }
        if (r7 != 0) goto L_0x0082;
    L_0x006d:
        r7 = loadExistingExtractions(r14, r15, r16, r17);	 Catch:{ IOException -> 0x0073 }
        r13 = r7;
        goto L_0x008e;
    L_0x0073:
        r13 = performExtractions(r15, r16);	 Catch:{ all -> 0x00c3 }
        r3 = getTimeStamp(r3);	 Catch:{ all -> 0x00c3 }
        r7 = r13;	 Catch:{ all -> 0x00c3 }
        putStoredApkInfo(r1, r2, r3, r5, r7);	 Catch:{ all -> 0x00c3 }
        goto L_0x008e;	 Catch:{ all -> 0x00c3 }
    L_0x0080:
        r1 = r14;	 Catch:{ all -> 0x00c3 }
        r3 = r15;	 Catch:{ all -> 0x00c3 }
    L_0x0082:
        r13 = performExtractions(r15, r16);	 Catch:{ all -> 0x00c3 }
        r3 = getTimeStamp(r3);	 Catch:{ all -> 0x00c3 }
        r7 = r13;	 Catch:{ all -> 0x00c3 }
        putStoredApkInfo(r1, r2, r3, r5, r7);	 Catch:{ all -> 0x00c3 }
    L_0x008e:
        if (r12 == 0) goto L_0x00a4;
    L_0x0090:
        r12.release();	 Catch:{ IOException -> 0x0094 }
        goto L_0x00a4;
    L_0x0094:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r2 = "Failed to release lock on ";
        r1.<init>(r2);
        r2 = r8.getPath();
        r1.append(r2);
        r10 = r0;
    L_0x00a4:
        if (r11 == 0) goto L_0x00a9;
    L_0x00a6:
        closeQuietly(r11);
    L_0x00a9:
        closeQuietly(r9);
        if (r10 == 0) goto L_0x00af;
    L_0x00ae:
        throw r10;
    L_0x00af:
        r1 = new java.lang.StringBuilder;
        r2 = "load found ";
        r1.<init>(r2);
        r2 = r13.size();
        r1.append(r2);
        r2 = " secondary dex files";
        r1.append(r2);
        return r13;
    L_0x00c3:
        r0 = move-exception;
        r1 = r0;
        goto L_0x00ce;
    L_0x00c6:
        r0 = move-exception;
        r1 = r0;
        r12 = r10;
        goto L_0x00ce;
    L_0x00ca:
        r0 = move-exception;
        r1 = r0;
        r11 = r10;
        r12 = r11;
    L_0x00ce:
        if (r12 == 0) goto L_0x00e2;
    L_0x00d0:
        r12.release();	 Catch:{ IOException -> 0x00d4 }
        goto L_0x00e2;
    L_0x00d4:
        r2 = new java.lang.StringBuilder;
        r3 = "Failed to release lock on ";
        r2.<init>(r3);
        r3 = r8.getPath();
        r2.append(r3);
    L_0x00e2:
        if (r11 == 0) goto L_0x00e7;
    L_0x00e4:
        closeQuietly(r11);
    L_0x00e7:
        closeQuietly(r9);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDexExtractor.load(android.content.Context, java.io.File, java.io.File, java.lang.String, boolean):java.util.List<? extends java.io.File>");
    }

    private static List<ExtractedDex> loadExistingExtractions(Context context, File file, File file2, String str) throws IOException {
        String str2 = str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getName());
        stringBuilder.append(EXTRACTED_NAME_EXT);
        String stringBuilder2 = stringBuilder.toString();
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str2);
        stringBuilder3.append(KEY_DEX_NUMBER);
        int i = multiDexPreferences.getInt(stringBuilder3.toString(), 1);
        List<ExtractedDex> arrayList = new ArrayList(i - 1);
        int i2 = 2;
        while (i2 <= i) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(i2);
            stringBuilder4.append(EXTRACTED_SUFFIX);
            File extractedDex = new ExtractedDex(file2, stringBuilder4.toString());
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str2);
                stringBuilder4.append(KEY_DEX_CRC);
                stringBuilder4.append(i2);
                long j = multiDexPreferences.getLong(stringBuilder4.toString(), -1);
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str2);
                stringBuilder4.append(KEY_DEX_TIME);
                stringBuilder4.append(i2);
                long j2 = multiDexPreferences.getLong(stringBuilder4.toString(), -1);
                long lastModified = extractedDex.lastModified();
                if (j2 == lastModified) {
                    String str3 = stringBuilder2;
                    SharedPreferences sharedPreferences = multiDexPreferences;
                    if (j == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i2++;
                        stringBuilder2 = str3;
                        multiDexPreferences = sharedPreferences;
                    }
                }
                StringBuilder stringBuilder5 = new StringBuilder("Invalid extracted dex: ");
                stringBuilder5.append(extractedDex);
                stringBuilder5.append(" (key \"");
                stringBuilder5.append(str2);
                stringBuilder5.append("\"), expected modification time: ");
                stringBuilder5.append(j2);
                stringBuilder5.append(", modification time: ");
                stringBuilder5.append(lastModified);
                stringBuilder5.append(", expected crc: ");
                stringBuilder5.append(j);
                stringBuilder5.append(", file crc: ");
                stringBuilder5.append(extractedDex.crc);
                throw new IOException(stringBuilder5.toString());
            }
            stringBuilder = new StringBuilder("Missing extracted secondary dex file '");
            stringBuilder.append(extractedDex.getPath());
            stringBuilder.append("'");
            throw new IOException(stringBuilder.toString());
        }
        return arrayList;
    }

    private static boolean isModified(Context context, File file, long j, String str) {
        context = getMultiDexPreferences(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(KEY_TIME_STAMP);
        if (context.getLong(stringBuilder.toString(), -1) == getTimeStamp(file)) {
            file = new StringBuilder();
            file.append(str);
            file.append(KEY_CRC);
            if (context.getLong(file.toString(), -1) == j) {
                return null;
            }
        }
        return true;
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    private static java.util.List<android.support.multidex.MultiDexExtractor.ExtractedDex> performExtractions(java.io.File r11, java.io.File r12) throws java.io.IOException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r11.getName();
        r0.append(r1);
        r1 = ".classes";
        r0.append(r1);
        r0 = r0.toString();
        prepareDexDir(r12, r0);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = new java.util.zip.ZipFile;
        r2.<init>(r11);
        r11 = 2;
        r3 = "classes2.dex";	 Catch:{ all -> 0x010d }
        r3 = r2.getEntry(r3);	 Catch:{ all -> 0x010d }
    L_0x0029:
        if (r3 == 0) goto L_0x0109;	 Catch:{ all -> 0x010d }
    L_0x002b:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010d }
        r4.<init>();	 Catch:{ all -> 0x010d }
        r4.append(r0);	 Catch:{ all -> 0x010d }
        r4.append(r11);	 Catch:{ all -> 0x010d }
        r5 = ".zip";	 Catch:{ all -> 0x010d }
        r4.append(r5);	 Catch:{ all -> 0x010d }
        r4 = r4.toString();	 Catch:{ all -> 0x010d }
        r5 = new android.support.multidex.MultiDexExtractor$ExtractedDex;	 Catch:{ all -> 0x010d }
        r5.<init>(r12, r4);	 Catch:{ all -> 0x010d }
        r1.add(r5);	 Catch:{ all -> 0x010d }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010d }
        r6 = "Extraction is needed for file ";	 Catch:{ all -> 0x010d }
        r4.<init>(r6);	 Catch:{ all -> 0x010d }
        r4.append(r5);	 Catch:{ all -> 0x010d }
        r4 = 0;	 Catch:{ all -> 0x010d }
        r6 = r4;	 Catch:{ all -> 0x010d }
        r7 = r6;	 Catch:{ all -> 0x010d }
    L_0x0054:
        r8 = 3;	 Catch:{ all -> 0x010d }
        if (r6 >= r8) goto L_0x00c7;	 Catch:{ all -> 0x010d }
    L_0x0057:
        if (r7 != 0) goto L_0x00c7;	 Catch:{ all -> 0x010d }
    L_0x0059:
        r6 = r6 + 1;	 Catch:{ all -> 0x010d }
        extract(r2, r3, r5, r0);	 Catch:{ all -> 0x010d }
        r7 = getZipCrc(r5);	 Catch:{ IOException -> 0x0066 }
        r5.crc = r7;	 Catch:{ IOException -> 0x0066 }
        r7 = 1;
        goto L_0x0075;
    L_0x0066:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010d }
        r8 = "Failed to read crc from ";	 Catch:{ all -> 0x010d }
        r7.<init>(r8);	 Catch:{ all -> 0x010d }
        r8 = r5.getAbsolutePath();	 Catch:{ all -> 0x010d }
        r7.append(r8);	 Catch:{ all -> 0x010d }
        r7 = r4;	 Catch:{ all -> 0x010d }
    L_0x0075:
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010d }
        r9 = "Extraction ";	 Catch:{ all -> 0x010d }
        r8.<init>(r9);	 Catch:{ all -> 0x010d }
        if (r7 == 0) goto L_0x0081;	 Catch:{ all -> 0x010d }
    L_0x007e:
        r9 = "succeeded";	 Catch:{ all -> 0x010d }
        goto L_0x0083;	 Catch:{ all -> 0x010d }
    L_0x0081:
        r9 = "failed";	 Catch:{ all -> 0x010d }
    L_0x0083:
        r8.append(r9);	 Catch:{ all -> 0x010d }
        r9 = " - length ";	 Catch:{ all -> 0x010d }
        r8.append(r9);	 Catch:{ all -> 0x010d }
        r9 = r5.getAbsolutePath();	 Catch:{ all -> 0x010d }
        r8.append(r9);	 Catch:{ all -> 0x010d }
        r9 = ": ";	 Catch:{ all -> 0x010d }
        r8.append(r9);	 Catch:{ all -> 0x010d }
        r9 = r5.length();	 Catch:{ all -> 0x010d }
        r8.append(r9);	 Catch:{ all -> 0x010d }
        r9 = " - crc: ";	 Catch:{ all -> 0x010d }
        r8.append(r9);	 Catch:{ all -> 0x010d }
        r9 = r5.crc;	 Catch:{ all -> 0x010d }
        r8.append(r9);	 Catch:{ all -> 0x010d }
        if (r7 != 0) goto L_0x0054;	 Catch:{ all -> 0x010d }
    L_0x00aa:
        r5.delete();	 Catch:{ all -> 0x010d }
        r8 = r5.exists();	 Catch:{ all -> 0x010d }
        if (r8 == 0) goto L_0x0054;	 Catch:{ all -> 0x010d }
    L_0x00b3:
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010d }
        r9 = "Failed to delete corrupted secondary dex '";	 Catch:{ all -> 0x010d }
        r8.<init>(r9);	 Catch:{ all -> 0x010d }
        r9 = r5.getPath();	 Catch:{ all -> 0x010d }
        r8.append(r9);	 Catch:{ all -> 0x010d }
        r9 = "'";	 Catch:{ all -> 0x010d }
        r8.append(r9);	 Catch:{ all -> 0x010d }
        goto L_0x0054;	 Catch:{ all -> 0x010d }
    L_0x00c7:
        if (r7 != 0) goto L_0x00ee;	 Catch:{ all -> 0x010d }
    L_0x00c9:
        r12 = new java.io.IOException;	 Catch:{ all -> 0x010d }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010d }
        r1 = "Could not create zip file ";	 Catch:{ all -> 0x010d }
        r0.<init>(r1);	 Catch:{ all -> 0x010d }
        r1 = r5.getAbsolutePath();	 Catch:{ all -> 0x010d }
        r0.append(r1);	 Catch:{ all -> 0x010d }
        r1 = " for secondary dex (";	 Catch:{ all -> 0x010d }
        r0.append(r1);	 Catch:{ all -> 0x010d }
        r0.append(r11);	 Catch:{ all -> 0x010d }
        r11 = ")";	 Catch:{ all -> 0x010d }
        r0.append(r11);	 Catch:{ all -> 0x010d }
        r11 = r0.toString();	 Catch:{ all -> 0x010d }
        r12.<init>(r11);	 Catch:{ all -> 0x010d }
        throw r12;	 Catch:{ all -> 0x010d }
    L_0x00ee:
        r11 = r11 + 1;	 Catch:{ all -> 0x010d }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010d }
        r4 = "classes";	 Catch:{ all -> 0x010d }
        r3.<init>(r4);	 Catch:{ all -> 0x010d }
        r3.append(r11);	 Catch:{ all -> 0x010d }
        r4 = ".dex";	 Catch:{ all -> 0x010d }
        r3.append(r4);	 Catch:{ all -> 0x010d }
        r3 = r3.toString();	 Catch:{ all -> 0x010d }
        r3 = r2.getEntry(r3);	 Catch:{ all -> 0x010d }
        goto L_0x0029;
    L_0x0109:
        r2.close();	 Catch:{ IOException -> 0x010c }
    L_0x010c:
        return r1;
    L_0x010d:
        r11 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x0111 }
    L_0x0111:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDexExtractor.performExtractions(java.io.File, java.io.File):java.util.List<android.support.multidex.MultiDexExtractor$ExtractedDex>");
    }

    private static void putStoredApkInfo(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        context = getMultiDexPreferences(context).edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(KEY_TIME_STAMP);
        context.putLong(stringBuilder.toString(), j);
        j = new StringBuilder();
        j.append(str);
        j.append(KEY_CRC);
        context.putLong(j.toString(), j2);
        j = new StringBuilder();
        j.append(str);
        j.append(KEY_DEX_NUMBER);
        context.putInt(j.toString(), list.size() + 1);
        int i = 2;
        for (ExtractedDex extractedDex : list) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(KEY_DEX_CRC);
            stringBuilder2.append(i);
            context.putLong(stringBuilder2.toString(), extractedDex.crc);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(KEY_DEX_TIME);
            stringBuilder2.append(i);
            context.putLong(stringBuilder2.toString(), extractedDex.lastModified());
            i++;
        }
        context.commit();
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static void prepareDexDir(File file, String str) {
        str = file.listFiles(new AnonymousClass1(str));
        if (str == null) {
            str = new StringBuilder("Failed to list secondary dex dir content (");
            str.append(file.getPath());
            str.append(").");
            return;
        }
        for (File file2 : str) {
            StringBuilder stringBuilder = new StringBuilder("Trying to delete old file ");
            stringBuilder.append(file2.getPath());
            stringBuilder.append(" of size ");
            stringBuilder.append(file2.length());
            if (file2.delete()) {
                new StringBuilder("Deleted old file ").append(file2.getPath());
            } else {
                new StringBuilder("Failed to delete old file ").append(file2.getPath());
            }
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        zipFile = zipFile.getInputStream(zipEntry);
        StringBuilder stringBuilder = new StringBuilder("tmp-");
        stringBuilder.append(str);
        str = File.createTempFile(stringBuilder.toString(), EXTRACTED_SUFFIX, file.getParentFile());
        new StringBuilder("Extracting ").append(str.getPath());
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            zipEntry = new byte[16384];
            for (int read = zipFile.read(zipEntry); read != -1; read = zipFile.read(zipEntry)) {
                zipOutputStream.write(zipEntry, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (str.setReadOnly() == null) {
                stringBuilder = new StringBuilder("Failed to mark readonly \"");
                stringBuilder.append(str.getAbsolutePath());
                stringBuilder.append("\" (tmp of \"");
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append("\")");
                throw new IOException(stringBuilder.toString());
            }
            new StringBuilder("Renaming to ").append(file.getPath());
            if (str.renameTo(file) == null) {
                stringBuilder = new StringBuilder("Failed to rename \"");
                stringBuilder.append(str.getAbsolutePath());
                stringBuilder.append("\" to \"");
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append("\"");
                throw new IOException(stringBuilder.toString());
            }
            closeQuietly(zipFile);
            str.delete();
        } catch (Throwable th) {
            closeQuietly(zipFile);
            str.delete();
        }
    }

    private static void closeQuietly(java.io.Closeable r0) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0.close();	 Catch:{ IOException -> 0x0004 }
        return;
    L_0x0004:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDexExtractor.closeQuietly(java.io.Closeable):void");
    }
}
