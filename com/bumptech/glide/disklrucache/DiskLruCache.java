package com.bumptech.glide.disklrucache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable = new Callable<Void>() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
            r4 = this;
            r0 = com.bumptech.glide.disklrucache.DiskLruCache.this;
            monitor-enter(r0);
            r1 = com.bumptech.glide.disklrucache.DiskLruCache.this;	 Catch:{ all -> 0x0028 }
            r1 = r1.journalWriter;	 Catch:{ all -> 0x0028 }
            r2 = 0;
            if (r1 != 0) goto L_0x000e;
        L_0x000c:
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            return r2;
        L_0x000e:
            r1 = com.bumptech.glide.disklrucache.DiskLruCache.this;	 Catch:{ all -> 0x0028 }
            r1.trimToSize();	 Catch:{ all -> 0x0028 }
            r1 = com.bumptech.glide.disklrucache.DiskLruCache.this;	 Catch:{ all -> 0x0028 }
            r1 = r1.journalRebuildRequired();	 Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0026;
        L_0x001b:
            r1 = com.bumptech.glide.disklrucache.DiskLruCache.this;	 Catch:{ all -> 0x0028 }
            r1.rebuildJournal();	 Catch:{ all -> 0x0028 }
            r1 = com.bumptech.glide.disklrucache.DiskLruCache.this;	 Catch:{ all -> 0x0028 }
            r3 = 0;
            r1.redundantOpCount = r3;	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            return r2;
        L_0x0028:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.1.call():java.lang.Void");
        }
    };
    private final File directory;
    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75f, true);
    private long maxSize;
    private long nextSequenceNumber = 0;
    private int redundantOpCount;
    private long size = 0;
    private final int valueCount;

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private final boolean[] written;

        private Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable != null ? null : new boolean[DiskLruCache.this.valueCount];
        }

        private java.io.InputStream newInputStream(int r5) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r4 = this;
            r0 = com.bumptech.glide.disklrucache.DiskLruCache.this;
            monitor-enter(r0);
            r1 = r4.entry;	 Catch:{ all -> 0x002b }
            r1 = r1.currentEditor;	 Catch:{ all -> 0x002b }
            if (r1 == r4) goto L_0x0011;	 Catch:{ all -> 0x002b }
        L_0x000b:
            r5 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x002b }
            r5.<init>();	 Catch:{ all -> 0x002b }
            throw r5;	 Catch:{ all -> 0x002b }
        L_0x0011:
            r1 = r4.entry;	 Catch:{ all -> 0x002b }
            r1 = r1.readable;	 Catch:{ all -> 0x002b }
            r2 = 0;	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x001c;	 Catch:{ all -> 0x002b }
        L_0x001a:
            monitor-exit(r0);	 Catch:{ all -> 0x002b }
            return r2;
        L_0x001c:
            r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0029 }
            r3 = r4.entry;	 Catch:{ FileNotFoundException -> 0x0029 }
            r5 = r3.getCleanFile(r5);	 Catch:{ FileNotFoundException -> 0x0029 }
            r1.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0029 }
            monitor-exit(r0);	 Catch:{ all -> 0x002b }
            return r1;	 Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0);	 Catch:{ all -> 0x002b }
            return r2;	 Catch:{ all -> 0x002b }
        L_0x002b:
            r5 = move-exception;	 Catch:{ all -> 0x002b }
            monitor-exit(r0);	 Catch:{ all -> 0x002b }
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.Editor.newInputStream(int):java.io.InputStream");
        }

        public final String getString(int i) throws IOException {
            i = newInputStream(i);
            return i != 0 ? DiskLruCache.inputStreamToString(i) : 0;
        }

        public final File getFile(int i) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    this.written[i] = true;
                }
                i = this.entry.getDirtyFile(i);
                if (!DiskLruCache.this.directory.exists()) {
                    DiskLruCache.this.directory.mkdirs();
                }
            }
            return i;
        }

        public final void set(int i, String str) throws IOException {
            Closeable closeable = null;
            try {
                i = new OutputStreamWriter(new FileOutputStream(getFile(i)), Util.UTF_8);
                try {
                    i.write(str);
                    Util.closeQuietly(i);
                } catch (Throwable th) {
                    str = th;
                    closeable = i;
                    Util.closeQuietly(closeable);
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                Util.closeQuietly(closeable);
                throw str;
            }
        }

        public final void commit() throws IOException {
            DiskLruCache.this.completeEdit(this, true);
            this.committed = true;
        }

        public final void abort() throws IOException {
            DiskLruCache.this.completeEdit(this, false);
        }

        public final void abortUnlessCommitted() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r1 = this;
            r0 = r1.committed;
            if (r0 != 0) goto L_0x0008;
        L_0x0004:
            r1.abort();	 Catch:{ IOException -> 0x0008 }
            return;
        L_0x0008:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.Editor.abortUnlessCommitted():void");
        }
    }

    private final class Entry {
        File[] cleanFiles;
        private Editor currentEditor;
        File[] dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append('.');
            str = stringBuilder.length();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                stringBuilder.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.directory, stringBuilder.toString());
                stringBuilder.append(".tmp");
                this.dirtyFiles[i] = new File(DiskLruCache.this.directory, stringBuilder.toString());
                stringBuilder.setLength(str);
            }
        }

        public final String getLengths() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long j : this.lengths) {
                stringBuilder.append(' ');
                stringBuilder.append(j);
            }
            return stringBuilder.toString();
        }

        private void setLengths(java.lang.String[] r5) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r4 = this;
            r0 = r5.length;
            r1 = com.bumptech.glide.disklrucache.DiskLruCache.this;
            r1 = r1.valueCount;
            if (r0 == r1) goto L_0x000e;
        L_0x0009:
            r5 = r4.invalidLengths(r5);
            throw r5;
        L_0x000e:
            r0 = 0;
        L_0x000f:
            r1 = r5.length;	 Catch:{ NumberFormatException -> 0x0020 }
            if (r0 >= r1) goto L_0x001f;	 Catch:{ NumberFormatException -> 0x0020 }
        L_0x0012:
            r1 = r4.lengths;	 Catch:{ NumberFormatException -> 0x0020 }
            r2 = r5[r0];	 Catch:{ NumberFormatException -> 0x0020 }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0020 }
            r1[r0] = r2;	 Catch:{ NumberFormatException -> 0x0020 }
            r0 = r0 + 1;
            goto L_0x000f;
        L_0x001f:
            return;
        L_0x0020:
            r5 = r4.invalidLengths(r5);
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.Entry.setLengths(java.lang.String[]):void");
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            StringBuilder stringBuilder = new StringBuilder("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(strArr));
            throw new IOException(stringBuilder.toString());
        }

        public final File getCleanFile(int i) {
            return this.cleanFiles[i];
        }

        public final File getDirtyFile(int i) {
            return this.dirtyFiles[i];
        }
    }

    public final class Value {
        private final File[] files;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        private Value(String str, long j, File[] fileArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.files = fileArr;
            this.lengths = jArr;
        }

        public final Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public final File getFile(int i) {
            return this.files[i];
        }

        public final String getString(int i) throws IOException {
            return DiskLruCache.inputStreamToString(new FileInputStream(this.files[i]));
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        File file2 = file;
        this.directory = file2;
        this.appVersion = i;
        this.journalFile = new File(file2, JOURNAL_FILE);
        this.journalFileTmp = new File(file2, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file2, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
    }

    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    renameTo(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
            if (diskLruCache.journalFile.exists()) {
                try {
                    diskLruCache.readJournal();
                    diskLruCache.processJournal();
                    return diskLruCache;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    StringBuilder stringBuilder = new StringBuilder("DiskLruCache ");
                    stringBuilder.append(file);
                    stringBuilder.append(" is corrupt: ");
                    stringBuilder.append(e.getMessage());
                    stringBuilder.append(", removing");
                    printStream.println(stringBuilder.toString());
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            diskLruCache = new DiskLruCache(file, i, i2, j);
            diskLruCache.rebuildJournal();
            return diskLruCache;
        }
    }

    private void readJournal() throws java.io.IOException {
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
        r8 = this;
        r0 = new com.bumptech.glide.disklrucache.StrictLineReader;
        r1 = new java.io.FileInputStream;
        r2 = r8.journalFile;
        r1.<init>(r2);
        r2 = com.bumptech.glide.disklrucache.Util.US_ASCII;
        r0.<init>(r1, r2);
        r1 = r0.readLine();	 Catch:{ all -> 0x00bc }
        r2 = r0.readLine();	 Catch:{ all -> 0x00bc }
        r3 = r0.readLine();	 Catch:{ all -> 0x00bc }
        r4 = r0.readLine();	 Catch:{ all -> 0x00bc }
        r5 = r0.readLine();	 Catch:{ all -> 0x00bc }
        r6 = "libcore.io.DiskLruCache";	 Catch:{ all -> 0x00bc }
        r6 = r6.equals(r1);	 Catch:{ all -> 0x00bc }
        if (r6 == 0) goto L_0x008b;	 Catch:{ all -> 0x00bc }
    L_0x002a:
        r6 = "1";	 Catch:{ all -> 0x00bc }
        r6 = r6.equals(r2);	 Catch:{ all -> 0x00bc }
        if (r6 == 0) goto L_0x008b;	 Catch:{ all -> 0x00bc }
    L_0x0032:
        r6 = r8.appVersion;	 Catch:{ all -> 0x00bc }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ all -> 0x00bc }
        r3 = r6.equals(r3);	 Catch:{ all -> 0x00bc }
        if (r3 == 0) goto L_0x008b;	 Catch:{ all -> 0x00bc }
    L_0x003e:
        r3 = r8.valueCount;	 Catch:{ all -> 0x00bc }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ all -> 0x00bc }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x00bc }
        if (r3 == 0) goto L_0x008b;	 Catch:{ all -> 0x00bc }
    L_0x004a:
        r3 = "";	 Catch:{ all -> 0x00bc }
        r3 = r3.equals(r5);	 Catch:{ all -> 0x00bc }
        if (r3 != 0) goto L_0x0053;
    L_0x0052:
        goto L_0x008b;
    L_0x0053:
        r1 = 0;
    L_0x0054:
        r2 = r0.readLine();	 Catch:{ EOFException -> 0x005e }
        r8.readJournalLine(r2);	 Catch:{ EOFException -> 0x005e }
        r1 = r1 + 1;
        goto L_0x0054;
    L_0x005e:
        r2 = r8.lruEntries;	 Catch:{ all -> 0x00bc }
        r2 = r2.size();	 Catch:{ all -> 0x00bc }
        r1 = r1 - r2;	 Catch:{ all -> 0x00bc }
        r8.redundantOpCount = r1;	 Catch:{ all -> 0x00bc }
        r1 = r0.hasUnterminatedLine();	 Catch:{ all -> 0x00bc }
        if (r1 == 0) goto L_0x0071;	 Catch:{ all -> 0x00bc }
    L_0x006d:
        r8.rebuildJournal();	 Catch:{ all -> 0x00bc }
        goto L_0x0087;	 Catch:{ all -> 0x00bc }
    L_0x0071:
        r1 = new java.io.BufferedWriter;	 Catch:{ all -> 0x00bc }
        r2 = new java.io.OutputStreamWriter;	 Catch:{ all -> 0x00bc }
        r3 = new java.io.FileOutputStream;	 Catch:{ all -> 0x00bc }
        r4 = r8.journalFile;	 Catch:{ all -> 0x00bc }
        r5 = 1;	 Catch:{ all -> 0x00bc }
        r3.<init>(r4, r5);	 Catch:{ all -> 0x00bc }
        r4 = com.bumptech.glide.disklrucache.Util.US_ASCII;	 Catch:{ all -> 0x00bc }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x00bc }
        r1.<init>(r2);	 Catch:{ all -> 0x00bc }
        r8.journalWriter = r1;	 Catch:{ all -> 0x00bc }
    L_0x0087:
        com.bumptech.glide.disklrucache.Util.closeQuietly(r0);
        return;
    L_0x008b:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x00bc }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bc }
        r7 = "unexpected journal header: [";	 Catch:{ all -> 0x00bc }
        r6.<init>(r7);	 Catch:{ all -> 0x00bc }
        r6.append(r1);	 Catch:{ all -> 0x00bc }
        r1 = ", ";	 Catch:{ all -> 0x00bc }
        r6.append(r1);	 Catch:{ all -> 0x00bc }
        r6.append(r2);	 Catch:{ all -> 0x00bc }
        r1 = ", ";	 Catch:{ all -> 0x00bc }
        r6.append(r1);	 Catch:{ all -> 0x00bc }
        r6.append(r4);	 Catch:{ all -> 0x00bc }
        r1 = ", ";	 Catch:{ all -> 0x00bc }
        r6.append(r1);	 Catch:{ all -> 0x00bc }
        r6.append(r5);	 Catch:{ all -> 0x00bc }
        r1 = "]";	 Catch:{ all -> 0x00bc }
        r6.append(r1);	 Catch:{ all -> 0x00bc }
        r1 = r6.toString();	 Catch:{ all -> 0x00bc }
        r3.<init>(r1);	 Catch:{ all -> 0x00bc }
        throw r3;	 Catch:{ all -> 0x00bc }
    L_0x00bc:
        r1 = move-exception;
        com.bumptech.glide.disklrucache.Util.closeQuietly(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.readJournal():void");
    }

    private void readJournalLine(String str) throws IOException {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            StringBuilder stringBuilder = new StringBuilder("unexpected journal line: ");
            stringBuilder.append(str);
            throw new IOException(stringBuilder.toString());
        }
        String substring;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith(REMOVE)) {
                this.lruEntries.remove(substring);
                return;
            }
        }
        substring = str.substring(i, indexOf2);
        Entry entry = (Entry) this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
            str = str.substring(indexOf2 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(str);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
            entry.currentEditor = new Editor(entry);
        } else {
            if (indexOf2 == -1 && indexOf == 4) {
                if (str.startsWith(READ)) {
                    return;
                }
            }
            stringBuilder = new StringBuilder("unexpected journal line: ");
            stringBuilder.append(str);
            throw new IOException(stringBuilder.toString());
        }
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i = 0;
            if (entry.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += entry.lengths[i];
                    i++;
                }
            } else {
                entry.currentEditor = null;
                while (i < this.valueCount) {
                    deleteIfExists(entry.getCleanFile(i));
                    deleteIfExists(entry.getDirtyFile(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        try {
            bufferedWriter.write(MAGIC);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.appVersion));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.valueCount));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry entry : this.lruEntries.values()) {
                StringBuilder stringBuilder;
                if (entry.currentEditor != null) {
                    stringBuilder = new StringBuilder("DIRTY ");
                    stringBuilder.append(entry.key);
                    stringBuilder.append('\n');
                    bufferedWriter.write(stringBuilder.toString());
                } else {
                    stringBuilder = new StringBuilder("CLEAN ");
                    stringBuilder.append(entry.key);
                    stringBuilder.append(entry.getLengths());
                    stringBuilder.append('\n');
                    bufferedWriter.write(stringBuilder.toString());
                }
            }
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        } finally {
            bufferedWriter.close();
        }
    }

    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && file.delete() == null) {
            throw new IOException();
        }
    }

    private static void renameTo(File file, File file2, boolean z) throws IOException {
        if (z) {
            deleteIfExists(file2);
        }
        if (file.renameTo(file2) == null) {
            throw new IOException();
        }
    }

    public final synchronized Value get(String str) throws IOException {
        checkNotClosed();
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.readable) {
            return null;
        }
        for (File exists : entry.cleanFiles) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append(READ);
        this.journalWriter.append(' ');
        this.journalWriter.append(str);
        this.journalWriter.append('\n');
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        return new Value(str, entry.sequenceNumber, entry.cleanFiles, entry.lengths);
    }

    public final Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.bumptech.glide.disklrucache.DiskLruCache.Editor edit(java.lang.String r6, long r7) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5);
        r5.checkNotClosed();	 Catch:{ all -> 0x005d }
        r0 = r5.lruEntries;	 Catch:{ all -> 0x005d }
        r0 = r0.get(r6);	 Catch:{ all -> 0x005d }
        r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x005d }
        r1 = -1;
        r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1));
        r1 = 0;
        if (r3 == 0) goto L_0x001f;
    L_0x0013:
        if (r0 == 0) goto L_0x001d;
    L_0x0015:
        r2 = r0.sequenceNumber;	 Catch:{ all -> 0x005d }
        r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r4 == 0) goto L_0x001f;
    L_0x001d:
        monitor-exit(r5);
        return r1;
    L_0x001f:
        if (r0 != 0) goto L_0x002c;
    L_0x0021:
        r0 = new com.bumptech.glide.disklrucache.DiskLruCache$Entry;	 Catch:{ all -> 0x005d }
        r0.<init>(r6);	 Catch:{ all -> 0x005d }
        r7 = r5.lruEntries;	 Catch:{ all -> 0x005d }
        r7.put(r6, r0);	 Catch:{ all -> 0x005d }
        goto L_0x0034;
    L_0x002c:
        r7 = r0.currentEditor;	 Catch:{ all -> 0x005d }
        if (r7 == 0) goto L_0x0034;
    L_0x0032:
        monitor-exit(r5);
        return r1;
    L_0x0034:
        r7 = new com.bumptech.glide.disklrucache.DiskLruCache$Editor;	 Catch:{ all -> 0x005d }
        r7.<init>(r0);	 Catch:{ all -> 0x005d }
        r0.currentEditor = r7;	 Catch:{ all -> 0x005d }
        r8 = r5.journalWriter;	 Catch:{ all -> 0x005d }
        r0 = "DIRTY";
        r8.append(r0);	 Catch:{ all -> 0x005d }
        r8 = r5.journalWriter;	 Catch:{ all -> 0x005d }
        r0 = 32;
        r8.append(r0);	 Catch:{ all -> 0x005d }
        r8 = r5.journalWriter;	 Catch:{ all -> 0x005d }
        r8.append(r6);	 Catch:{ all -> 0x005d }
        r6 = r5.journalWriter;	 Catch:{ all -> 0x005d }
        r8 = 10;
        r6.append(r8);	 Catch:{ all -> 0x005d }
        r6 = r5.journalWriter;	 Catch:{ all -> 0x005d }
        r6.flush();	 Catch:{ all -> 0x005d }
        monitor-exit(r5);
        return r7;
    L_0x005d:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.edit(java.lang.String, long):com.bumptech.glide.disklrucache.DiskLruCache$Editor");
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        this.executorService.submit(this.cleanupCallable);
    }

    public final synchronized long size() {
        return this.size;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void completeEdit(com.bumptech.glide.disklrucache.DiskLruCache.Editor r12, boolean r13) throws java.io.IOException {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = r12.entry;	 Catch:{ all -> 0x010e }
        r1 = r0.currentEditor;	 Catch:{ all -> 0x010e }
        if (r1 == r12) goto L_0x0011;
    L_0x000b:
        r12 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x010e }
        r12.<init>();	 Catch:{ all -> 0x010e }
        throw r12;	 Catch:{ all -> 0x010e }
    L_0x0011:
        r1 = 0;
        if (r13 == 0) goto L_0x0050;
    L_0x0014:
        r2 = r0.readable;	 Catch:{ all -> 0x010e }
        if (r2 != 0) goto L_0x0050;
    L_0x001a:
        r2 = r1;
    L_0x001b:
        r3 = r11.valueCount;	 Catch:{ all -> 0x010e }
        if (r2 >= r3) goto L_0x0050;
    L_0x001f:
        r3 = r12.written;	 Catch:{ all -> 0x010e }
        r3 = r3[r2];	 Catch:{ all -> 0x010e }
        if (r3 != 0) goto L_0x003e;
    L_0x0027:
        r12.abort();	 Catch:{ all -> 0x010e }
        r12 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x010e }
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010e }
        r0 = "Newly created entry didn't create value for index ";
        r13.<init>(r0);	 Catch:{ all -> 0x010e }
        r13.append(r2);	 Catch:{ all -> 0x010e }
        r13 = r13.toString();	 Catch:{ all -> 0x010e }
        r12.<init>(r13);	 Catch:{ all -> 0x010e }
        throw r12;	 Catch:{ all -> 0x010e }
    L_0x003e:
        r3 = r0.getDirtyFile(r2);	 Catch:{ all -> 0x010e }
        r3 = r3.exists();	 Catch:{ all -> 0x010e }
        if (r3 != 0) goto L_0x004d;
    L_0x0048:
        r12.abort();	 Catch:{ all -> 0x010e }
        monitor-exit(r11);
        return;
    L_0x004d:
        r2 = r2 + 1;
        goto L_0x001b;
    L_0x0050:
        r12 = r11.valueCount;	 Catch:{ all -> 0x010e }
        if (r1 >= r12) goto L_0x0086;
    L_0x0054:
        r12 = r0.getDirtyFile(r1);	 Catch:{ all -> 0x010e }
        if (r13 == 0) goto L_0x0080;
    L_0x005a:
        r2 = r12.exists();	 Catch:{ all -> 0x010e }
        if (r2 == 0) goto L_0x0083;
    L_0x0060:
        r2 = r0.getCleanFile(r1);	 Catch:{ all -> 0x010e }
        r12.renameTo(r2);	 Catch:{ all -> 0x010e }
        r12 = r0.lengths;	 Catch:{ all -> 0x010e }
        r3 = r12[r1];	 Catch:{ all -> 0x010e }
        r5 = r2.length();	 Catch:{ all -> 0x010e }
        r12 = r0.lengths;	 Catch:{ all -> 0x010e }
        r12[r1] = r5;	 Catch:{ all -> 0x010e }
        r7 = r11.size;	 Catch:{ all -> 0x010e }
        r9 = r7 - r3;
        r2 = r9 + r5;
        r11.size = r2;	 Catch:{ all -> 0x010e }
        goto L_0x0083;
    L_0x0080:
        deleteIfExists(r12);	 Catch:{ all -> 0x010e }
    L_0x0083:
        r1 = r1 + 1;
        goto L_0x0050;
    L_0x0086:
        r12 = r11.redundantOpCount;	 Catch:{ all -> 0x010e }
        r1 = 1;
        r12 = r12 + r1;
        r11.redundantOpCount = r12;	 Catch:{ all -> 0x010e }
        r12 = 0;
        r0.currentEditor = r12;	 Catch:{ all -> 0x010e }
        r12 = r0.readable;	 Catch:{ all -> 0x010e }
        r12 = r12 | r13;
        r2 = 10;
        r3 = 32;
        if (r12 == 0) goto L_0x00cf;
    L_0x009b:
        r0.readable = r1;	 Catch:{ all -> 0x010e }
        r12 = r11.journalWriter;	 Catch:{ all -> 0x010e }
        r1 = "CLEAN";
        r12.append(r1);	 Catch:{ all -> 0x010e }
        r12 = r11.journalWriter;	 Catch:{ all -> 0x010e }
        r12.append(r3);	 Catch:{ all -> 0x010e }
        r12 = r11.journalWriter;	 Catch:{ all -> 0x010e }
        r1 = r0.key;	 Catch:{ all -> 0x010e }
        r12.append(r1);	 Catch:{ all -> 0x010e }
        r12 = r11.journalWriter;	 Catch:{ all -> 0x010e }
        r1 = r0.getLengths();	 Catch:{ all -> 0x010e }
        r12.append(r1);	 Catch:{ all -> 0x010e }
        r12 = r11.journalWriter;	 Catch:{ all -> 0x010e }
        r12.append(r2);	 Catch:{ all -> 0x010e }
        if (r13 == 0) goto L_0x00f2;
    L_0x00c3:
        r12 = r11.nextSequenceNumber;	 Catch:{ all -> 0x010e }
        r1 = 1;
        r3 = r12 + r1;
        r11.nextSequenceNumber = r3;	 Catch:{ all -> 0x010e }
        r0.sequenceNumber = r12;	 Catch:{ all -> 0x010e }
        goto L_0x00f2;
    L_0x00cf:
        r12 = r11.lruEntries;	 Catch:{ all -> 0x010e }
        r13 = r0.key;	 Catch:{ all -> 0x010e }
        r12.remove(r13);	 Catch:{ all -> 0x010e }
        r12 = r11.journalWriter;	 Catch:{ all -> 0x010e }
        r13 = "REMOVE";
        r12.append(r13);	 Catch:{ all -> 0x010e }
        r12 = r11.journalWriter;	 Catch:{ all -> 0x010e }
        r12.append(r3);	 Catch:{ all -> 0x010e }
        r12 = r11.journalWriter;	 Catch:{ all -> 0x010e }
        r13 = r0.key;	 Catch:{ all -> 0x010e }
        r12.append(r13);	 Catch:{ all -> 0x010e }
        r12 = r11.journalWriter;	 Catch:{ all -> 0x010e }
        r12.append(r2);	 Catch:{ all -> 0x010e }
    L_0x00f2:
        r12 = r11.journalWriter;	 Catch:{ all -> 0x010e }
        r12.flush();	 Catch:{ all -> 0x010e }
        r12 = r11.size;	 Catch:{ all -> 0x010e }
        r0 = r11.maxSize;	 Catch:{ all -> 0x010e }
        r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x0105;
    L_0x00ff:
        r12 = r11.journalRebuildRequired();	 Catch:{ all -> 0x010e }
        if (r12 == 0) goto L_0x010c;
    L_0x0105:
        r12 = r11.executorService;	 Catch:{ all -> 0x010e }
        r13 = r11.cleanupCallable;	 Catch:{ all -> 0x010e }
        r12.submit(r13);	 Catch:{ all -> 0x010e }
    L_0x010c:
        monitor-exit(r11);
        return;
    L_0x010e:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.completeEdit(com.bumptech.glide.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    private boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean remove(java.lang.String r10) throws java.io.IOException {
        /*
        r9 = this;
        monitor-enter(r9);
        r9.checkNotClosed();	 Catch:{ all -> 0x008b }
        r0 = r9.lruEntries;	 Catch:{ all -> 0x008b }
        r0 = r0.get(r10);	 Catch:{ all -> 0x008b }
        r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x008b }
        r1 = 0;
        if (r0 == 0) goto L_0x0089;
    L_0x000f:
        r2 = r0.currentEditor;	 Catch:{ all -> 0x008b }
        if (r2 == 0) goto L_0x0016;
    L_0x0015:
        goto L_0x0089;
    L_0x0016:
        r2 = r9.valueCount;	 Catch:{ all -> 0x008b }
        if (r1 >= r2) goto L_0x0055;
    L_0x001a:
        r2 = r0.getCleanFile(r1);	 Catch:{ all -> 0x008b }
        r3 = r2.exists();	 Catch:{ all -> 0x008b }
        if (r3 == 0) goto L_0x003e;
    L_0x0024:
        r3 = r2.delete();	 Catch:{ all -> 0x008b }
        if (r3 != 0) goto L_0x003e;
    L_0x002a:
        r10 = new java.io.IOException;	 Catch:{ all -> 0x008b }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008b }
        r1 = "failed to delete ";
        r0.<init>(r1);	 Catch:{ all -> 0x008b }
        r0.append(r2);	 Catch:{ all -> 0x008b }
        r0 = r0.toString();	 Catch:{ all -> 0x008b }
        r10.<init>(r0);	 Catch:{ all -> 0x008b }
        throw r10;	 Catch:{ all -> 0x008b }
    L_0x003e:
        r2 = r9.size;	 Catch:{ all -> 0x008b }
        r4 = r0.lengths;	 Catch:{ all -> 0x008b }
        r5 = r4[r1];	 Catch:{ all -> 0x008b }
        r7 = r2 - r5;
        r9.size = r7;	 Catch:{ all -> 0x008b }
        r2 = r0.lengths;	 Catch:{ all -> 0x008b }
        r3 = 0;
        r2[r1] = r3;	 Catch:{ all -> 0x008b }
        r1 = r1 + 1;
        goto L_0x0016;
    L_0x0055:
        r0 = r9.redundantOpCount;	 Catch:{ all -> 0x008b }
        r1 = 1;
        r0 = r0 + r1;
        r9.redundantOpCount = r0;	 Catch:{ all -> 0x008b }
        r0 = r9.journalWriter;	 Catch:{ all -> 0x008b }
        r2 = "REMOVE";
        r0.append(r2);	 Catch:{ all -> 0x008b }
        r0 = r9.journalWriter;	 Catch:{ all -> 0x008b }
        r2 = 32;
        r0.append(r2);	 Catch:{ all -> 0x008b }
        r0 = r9.journalWriter;	 Catch:{ all -> 0x008b }
        r0.append(r10);	 Catch:{ all -> 0x008b }
        r0 = r9.journalWriter;	 Catch:{ all -> 0x008b }
        r2 = 10;
        r0.append(r2);	 Catch:{ all -> 0x008b }
        r0 = r9.lruEntries;	 Catch:{ all -> 0x008b }
        r0.remove(r10);	 Catch:{ all -> 0x008b }
        r10 = r9.journalRebuildRequired();	 Catch:{ all -> 0x008b }
        if (r10 == 0) goto L_0x0087;
    L_0x0080:
        r10 = r9.executorService;	 Catch:{ all -> 0x008b }
        r0 = r9.cleanupCallable;	 Catch:{ all -> 0x008b }
        r10.submit(r0);	 Catch:{ all -> 0x008b }
    L_0x0087:
        monitor-exit(r9);
        return r1;
    L_0x0089:
        monitor-exit(r9);
        return r1;
    L_0x008b:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.remove(java.lang.String):boolean");
    }

    public final synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        this.journalWriter.flush();
    }

    public final synchronized void close() throws IOException {
        if (this.journalWriter != null) {
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }

    private void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            remove((String) ((java.util.Map.Entry) this.lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    public final void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
    }

    private static String inputStreamToString(InputStream inputStream) throws IOException {
        return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
    }
}
